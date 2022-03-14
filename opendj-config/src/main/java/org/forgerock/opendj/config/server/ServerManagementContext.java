/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2009 Sun Microsystems, Inc.
 * Portions copyright 2014-2016 ForgeRock AS.
 */

package org.forgerock.opendj.config.server;

import static com.forgerock.opendj.ldap.config.ConfigMessages.*;
import static com.forgerock.opendj.util.StaticUtils.*;
import static org.forgerock.opendj.config.PropertyException.defaultBehaviorException;
import static org.forgerock.opendj.config.PropertyException.illegalPropertyValueException;
import static org.forgerock.opendj.config.PropertyException.propertyIsSingleValuedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.forgerock.i18n.LocalizableMessage;
import org.forgerock.opendj.server.config.meta.RootCfgDefn;
import org.forgerock.opendj.server.config.server.RootCfg;
import org.forgerock.opendj.config.AbsoluteInheritedDefaultBehaviorProvider;
import org.forgerock.opendj.config.AbstractManagedObjectDefinition;
import org.forgerock.opendj.config.AggregationPropertyDefinition;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.Configuration;
import org.forgerock.opendj.config.ConfigurationClient;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.config.DefaultBehaviorProviderVisitor;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.DefinitionDecodingException.Reason;
import org.forgerock.opendj.config.DefinitionResolver;
import org.forgerock.opendj.config.LDAPProfile;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectPath;
import org.forgerock.opendj.config.PropertyDefinition;
import org.forgerock.opendj.config.PropertyDefinitionVisitor;
import org.forgerock.opendj.config.PropertyNotFoundException;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.Reference;
import org.forgerock.opendj.config.RelationDefinition;
import org.forgerock.opendj.config.RelativeInheritedDefaultBehaviorProvider;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.server.spi.ConfigurationRepository;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Server management connection context. */
public final class ServerManagementContext {

    /**
     * A default behavior visitor used for retrieving the default values of a
     * property.
     *
     * @param <T>
     *            The type of the property.
     */
    private final class DefaultValueFinder<T> implements DefaultBehaviorProviderVisitor<T, Collection<T>, Void> {

        /** Any exception that occurred whilst retrieving inherited default values. */
        private PropertyException exception;

        /** Optional new configuration entry which does not yet exist in the configuration back-end. */
        private final Entry newConfigEntry;

        /** The path of the managed object containing the next property. */
        private ManagedObjectPath<?, ?> nextPath;

        /** The next property whose default values were required. */
        private PropertyDefinition<T> nextProperty;

        /** Private constructor. */
        private DefaultValueFinder(Entry newConfigEntry) {
            this.newConfigEntry = newConfigEntry;
        }

        @Override
        public Collection<T> visitAbsoluteInherited(AbsoluteInheritedDefaultBehaviorProvider<T> d, Void p) {
            try {
                return getInheritedProperty(d.getManagedObjectPath(), d.getManagedObjectDefinition(),
                        d.getPropertyName());
            } catch (PropertyException e) {
                exception = e;
                return Collections.emptySet();
            }
        }

        @Override
        public Collection<T> visitAlias(AliasDefaultBehaviorProvider<T> d, Void p) {
            return Collections.emptySet();
        }

        @Override
        public Collection<T> visitDefined(DefinedDefaultBehaviorProvider<T> d, Void p) {
            Collection<String> stringValues = d.getDefaultValues();
            List<T> values = new ArrayList<>(stringValues.size());

            for (String stringValue : stringValues) {
                try {
                    values.add(nextProperty.decodeValue(stringValue));
                } catch (PropertyException e) {
                    exception = PropertyException.defaultBehaviorException(nextProperty, e);
                    break;
                }
            }

            return values;
        }

        @Override
        public Collection<T> visitRelativeInherited(RelativeInheritedDefaultBehaviorProvider<T> d, Void p) {
            try {
                return getInheritedProperty(d.getManagedObjectPath(nextPath), d.getManagedObjectDefinition(),
                        d.getPropertyName());
            } catch (PropertyException e) {
                exception = e;
                return Collections.emptySet();
            }
        }

        @Override
        public Collection<T> visitUndefined(UndefinedDefaultBehaviorProvider<T> d, Void p) {
            return Collections.emptySet();
        }

        /** Find the default values for the next path/property. */
        private Collection<T> find(ManagedObjectPath<?, ?> path, PropertyDefinition<T> propertyDef) {
            nextPath = path;
            nextProperty = propertyDef;

            Collection<T> values = nextProperty.getDefaultBehaviorProvider().accept(this, null);

            if (exception != null) {
                throw exception;
            }

            if (values.size() > 1 && !propertyDef.hasOption(PropertyOption.MULTI_VALUED)) {
                throw defaultBehaviorException(propertyDef, propertyIsSingleValuedException(propertyDef));
            }

            return values;
        }

        /** Get an inherited property value. */
        @SuppressWarnings("unchecked")
        private Collection<T> getInheritedProperty(ManagedObjectPath<?, ?> target,
            AbstractManagedObjectDefinition<?, ?> definition, String propertyName) {
            // First check that the requested type of managed object corresponds to the path.
            AbstractManagedObjectDefinition<?, ?> actual = target.getManagedObjectDefinition();
            if (!definition.isParentOf(actual)) {
                throw PropertyException.defaultBehaviorException(nextProperty, new DefinitionDecodingException(actual,
                        Reason.WRONG_TYPE_INFORMATION));
            }

            // Save the current property in case of recursion.
            PropertyDefinition<T> propDef1 = nextProperty;

            try {
                // Get the actual managed object definition.
                DN dn = DNBuilder.create(target);
                Entry configEntry;
                if (newConfigEntry != null && newConfigEntry.getName().equals(dn)) {
                    configEntry = newConfigEntry;
                } else {
                    configEntry = getManagedObjectConfigEntry(dn);
                }

                DefinitionResolver resolver = new MyDefinitionResolver(configEntry);
                ManagedObjectDefinition<?, ?> mod = definition.resolveManagedObjectDefinition(resolver);

                PropertyDefinition<T> propDef2;
                try {
                    PropertyDefinition<?> propDefTmp = mod.getPropertyDefinition(propertyName);
                    propDef2 = propDef1.getClass().cast(propDefTmp);
                } catch (IllegalArgumentException | ClassCastException e) {
                    throw new PropertyNotFoundException(propertyName);
                }

                Set<String> attributeValues = getAttributeValues(mod, propDef2, configEntry);
                if (attributeValues.size() > 0) {
                    Collection<T> pvalues = new ArrayList<>();
                    for (String value : attributeValues) {
                        pvalues.add(ValueDecoder.decode(propDef1, value));
                    }
                    return pvalues;
                } else {
                    // Recursively retrieve this property's default values.
                    Collection<T> tmp = find(target, propDef2);
                    Collection<T> pvalues = new ArrayList<>(tmp.size());
                    for (T value : tmp) {
                        propDef1.validateValue(value);
                        pvalues.add(value);
                    }
                    return pvalues;
                }
            } catch (Exception e) {
                throw PropertyException.defaultBehaviorException(propDef1, e);
            }
        }
    }

    /**
     * A definition resolver that determines the managed object definition from
     * the object classes of a ConfigEntry.
     */
    private static final class MyDefinitionResolver implements DefinitionResolver {

        /** The config entry. */
        private final Entry entry;

        /** Private constructor. */
        private MyDefinitionResolver(Entry entry) {
            this.entry = entry;
        }

        @Override
        public boolean matches(AbstractManagedObjectDefinition<?, ?> d) {
            String oc = LDAPProfile.getInstance().getObjectClass(d);
         // TODO : use the schema to get object class and check it in the entry
         // Commented because reject any config entry without proper schema loading
         // Previous code was
//            ObjectClass oc = DirectoryServer.getObjectClass(name.toLowerCase());
//            if (oc == null) {
//              oc = DirectoryServer.getDefaultObjectClass(name);
//            }
//            return Entries.containsObjectClass(entry, oc);
            return entry.containsAttribute("objectClass", oc);
        }
    }

    /** A visitor which is used to decode property LDAP values. */
    private static final class ValueDecoder extends PropertyDefinitionVisitor<Object, String> {

        /**
         * Decodes the provided property LDAP value.
         *
         * @param <P>
         *            The type of the property.
         * @param propertyDef
         *            The property definition.
         * @param value
         *            The LDAP string representation.
         * @return Returns the decoded LDAP value.
         * @throws PropertyException
         *             If the property value could not be decoded because it was
         *             invalid.
         */
        public static <P> P decode(PropertyDefinition<P> propertyDef, String value) {
            return propertyDef.castValue(propertyDef.accept(new ValueDecoder(), value));
        }

        /** Prevent instantiation. */
        private ValueDecoder() {
            // Do nothing.
        }

        @Override
        public <C extends ConfigurationClient, S extends Configuration> Object visitAggregation(
                AggregationPropertyDefinition<C, S> d, String p) {
            // Aggregations values are stored as full DNs in LDAP, but
            // just their common name is exposed in the admin framework.
            try {
                Reference<C, S> reference = Reference.parseDN(d.getParentPath(), d.getRelationDefinition(), p);
                return reference.getName();
            } catch (IllegalArgumentException e) {
                throw illegalPropertyValueException(d, p);
            }
        }

        @Override
        public <T> Object visitUnknown(PropertyDefinition<T> d, String p) {
            // By default the property definition's decoder will do.
            return d.decodeValue(p);
        }
    }

    private static final Logger debugLogger = LoggerFactory.getLogger(ServerManagementContext.class);

    /** The root server managed object, lazily initialized. */
    private volatile ServerManagedObject<RootCfg> root;

    /** Repository of configuration entries. */
    private final ConfigurationRepository configRepository;

    /**
     * Creates a context from the provided configuration repository.
     *
     * @param repository
     *          The repository of configuration entries.
     */
    public ServerManagementContext(ConfigurationRepository repository) {
        configRepository = repository;
    }

    /**
     * Gets the named managed object.
     *
     * @param <C>
     *            The type of client managed object configuration that the path
     *            definition refers to.
     * @param <S>
     *            The type of server managed object configuration that the path
     *            definition refers to.
     * @param path
     *            The path of the managed object.
     * @return Returns the named managed object.
     * @throws ConfigException
     *             If the named managed object could not be found or if it could
     *             not be decoded.
     */
    @SuppressWarnings("unchecked")
    public <C extends ConfigurationClient, S extends Configuration> ServerManagedObject<? extends S> getManagedObject(
            ManagedObjectPath<C, S> path) throws ConfigException {
        // Be careful to handle the root configuration.
        if (path.isEmpty()) {
            return (ServerManagedObject<S>) getRootConfigurationManagedObject();
        }

        // Get the configuration entry.
        DN targetDN = DNBuilder.create(path);
        Entry configEntry = getManagedObjectConfigEntry(targetDN);
        try {
            ServerManagedObject<? extends S> managedObject;
            managedObject = decode(path, configEntry);

            // Enforce any constraints.
            managedObject.ensureIsUsable();

            return managedObject;
        } catch (DefinitionDecodingException e) {
            throw ConfigExceptionFactory.getInstance().createDecodingExceptionAdaptor(targetDN, e);
        } catch (ServerManagedObjectDecodingException e) {
            throw ConfigExceptionFactory.getInstance().createDecodingExceptionAdaptor(e);
        } catch (ConstraintViolationException e) {
            throw ConfigExceptionFactory.getInstance().createDecodingExceptionAdaptor(e);
        }
    }

    /**
     * Get the root configuration manager associated with this management
     * context.
     *
     * @return the root configuration manager associated with this
     *         management context.
     */
    public RootCfg getRootConfiguration() {
        return getRootConfigurationManagedObject().getConfiguration();
    }

    /**
     * Get the root configuration server managed object associated with this
     * management context.
     *
     * @return the root configuration server managed object
     */
    public ServerManagedObject<RootCfg> getRootConfigurationManagedObject() {
        // Use lazy initialisation
        // because it needs a reference to this server context.
        ServerManagedObject<RootCfg> rootObject = root;
        if (rootObject == null) {
            synchronized (this) {
                rootObject = root;
                if (rootObject == null) {
                    root = rootObject =
                        new ServerManagedObject<>(ManagedObjectPath.emptyPath(),
                                RootCfgDefn.getInstance(), Collections.<PropertyDefinition<?>,
                                SortedSet<?>> emptyMap(), null, this);
                }
            }
        }
        return rootObject;
    }

    /**
     * Lists the child managed objects of the named parent managed object.
     *
     * @param <C>
     *            The type of client managed object configuration that the
     *            relation definition refers to.
     * @param <S>
     *            The type of server managed object configuration that the
     *            relation definition refers to.
     * @param parent
     *            The path of the parent managed object.
     * @param relationDef
     *            The relation definition.
     * @return Returns the names of the child managed objects.
     * @throws IllegalArgumentException
     *             If the relation definition is not associated with the parent
     *             managed object's definition.
     */
    public <C extends ConfigurationClient, S extends Configuration> String[] listManagedObjects(
            ManagedObjectPath<?, ?> parent, RelationDefinition<C, S> relationDef) {
        validateRelationDefinition(parent, relationDef);

        // Get the target entry.
        DN targetDN = DNBuilder.create(parent, relationDef);
        Set<DN> children;
        try {
            children = configRepository.getChildren(targetDN);
        } catch (ConfigException e) {
            return new String[0];
        }
        List<String> names = new ArrayList<>(children.size());
        for (DN child : children) {
            // Assume that RDNs are single-valued and can be trimmed.
            String name = child.rdn().getFirstAVA().getAttributeValue().toString().trim();
            names.add(name);
        }

        return names.toArray(new String[names.size()]);
    }

    /**
     * Determines whether the named managed object exists.
     *
     * @param path
     *            The path of the named managed object.
     * @return Returns <code>true</code> if the named managed object exists,
     *         <code>false</code> otherwise.
     */
    public boolean managedObjectExists(ManagedObjectPath<?, ?> path) {
        // Get the configuration entry.
        DN targetDN = DNBuilder.create(path);
        try {
            return configRepository.hasEntry(targetDN);
        } catch (ConfigException e) {
            // Assume it doesn't exist.
            return false;
        }
    }

    /**
     * Decodes a configuration entry into the required type of server managed
     * object.
     *
     * @param <C>
     *            The type of client managed object configuration that the path
     *            definition refers to.
     * @param <S>
     *            The type of server managed object configuration that the path
     *            definition refers to.
     * @param path
     *            The location of the server managed object.
     * @param configEntry
     *            The configuration entry that should be decoded.
     * @return Returns the new server-side managed object from the provided
     *         definition and configuration entry.
     * @throws DefinitionDecodingException
     *             If the managed object's type could not be determined.
     * @throws ServerManagedObjectDecodingException
     *             If one or more of the managed object's properties could not
     *             be decoded.
     */
    <C extends ConfigurationClient, S extends Configuration> ServerManagedObject<? extends S> decode(
            ManagedObjectPath<C, S> path, Entry configEntry) throws DefinitionDecodingException,
            ServerManagedObjectDecodingException {
        return decode(path, configEntry, null);
    }

    /**
     * Decodes a configuration entry into the required type of server managed
     * object.
     *
     * @param <C>
     *            The type of client managed object configuration that the path
     *            definition refers to.
     * @param <S>
     *            The type of server managed object configuration that the path
     *            definition refers to.
     * @param path
     *            The location of the server managed object.
     * @param configEntry
     *            The configuration entry that should be decoded.
     * @param newConfigEntry
     *            Optional new configuration that does not exist yet in the
     *            configuration back-end. This will be used for resolving
     *            inherited default values.
     * @return Returns the new server-side managed object from the provided
     *         definition and configuration entry.
     * @throws DefinitionDecodingException
     *             If the managed object's type could not be determined.
     * @throws ServerManagedObjectDecodingException
     *             If one or more of the managed object's properties could not
     *             be decoded.
     */
    <C extends ConfigurationClient, S extends Configuration> ServerManagedObject<? extends S> decode(
            ManagedObjectPath<C, S> path, Entry configEntry, Entry newConfigEntry)
            throws DefinitionDecodingException, ServerManagedObjectDecodingException {
        // First determine the correct definition to use for the entry.
        // This could either be the provided definition, or one of its
        // sub-definitions.
        DefinitionResolver resolver = new MyDefinitionResolver(configEntry);
        AbstractManagedObjectDefinition<C, S> d = path.getManagedObjectDefinition();
        ManagedObjectDefinition<? extends C, ? extends S> mod = d.resolveManagedObjectDefinition(resolver);

        // Build the managed object's properties.
        List<PropertyException> exceptions = new LinkedList<>();
        Map<PropertyDefinition<?>, SortedSet<?>> properties = new HashMap<>();
        for (PropertyDefinition<?> propertyDef : mod.getAllPropertyDefinitions()) {
            try {
                Set<String> attributeValues = getAttributeValues(mod, propertyDef, configEntry);
                SortedSet<?> pvalues = decodeProperty(path, propertyDef, attributeValues, newConfigEntry);
                properties.put(propertyDef, pvalues);
            } catch (PropertyException e) {
                exceptions.add(e);
            }
        }

        // If there were no decoding problems then return the managed
        // object, otherwise throw an operations exception.
        ServerManagedObject<? extends S> managedObject = decodeAux(path, mod, properties, configEntry.getName());
        if (exceptions.isEmpty()) {
            return managedObject;
        } else {
            throw new ServerManagedObjectDecodingException(managedObject, exceptions);
        }
    }

    /** Decode helper method required to avoid generics warning. */
    private <C extends ConfigurationClient, S extends Configuration> ServerManagedObject<S> decodeAux(
            ManagedObjectPath<? super C, ? super S> path, ManagedObjectDefinition<C, S> d,
            Map<PropertyDefinition<?>, SortedSet<?>> properties, DN configDN) {
        ManagedObjectPath<C, S> newPath = path.asSubType(d);
        return new ServerManagedObject<>(newPath, d, properties, configDN, this);
    }

    /** Decode a property using the provided attribute values. */
    private <T> SortedSet<T> decodeProperty(ManagedObjectPath<?, ?> path, PropertyDefinition<T> propertyDef,
            Set<String> attributeValues, Entry newConfigEntry) {
        PropertyException exception = null;
        SortedSet<T> pvalues = new TreeSet<>(propertyDef);

        if (attributeValues.size() > 0) {
            // The property has values defined for it.
            for (String value : attributeValues) {
                try {
                    pvalues.add(ValueDecoder.decode(propertyDef, value));
                } catch (PropertyException e) {
                    exception = e;
                }
            }
        } else {
            // No values defined so get the defaults.
            try {
                pvalues.addAll(getDefaultValues(path, propertyDef, newConfigEntry));
            } catch (PropertyException e) {
                exception = e;
            }
        }

        if (pvalues.size() > 1 && !propertyDef.hasOption(PropertyOption.MULTI_VALUED)) {
            // This exception takes precedence over previous exceptions.
            exception = PropertyException.propertyIsSingleValuedException(propertyDef);
            T value = pvalues.first();
            pvalues.clear();
            pvalues.add(value);
        }

        if (pvalues.isEmpty() && propertyDef.hasOption(PropertyOption.MANDATORY) && exception == null) {
            exception = PropertyException.propertyIsMandatoryException(propertyDef);
        }

        if (exception != null) {
            throw exception;
        }
        return pvalues;
    }

    /** Gets the attribute values associated with a property from a ConfigEntry. */
    private Set<String> getAttributeValues(ManagedObjectDefinition<?, ?> d, PropertyDefinition<?> pd,
            Entry configEntry) {
        final String attrID = LDAPProfile.getInstance().getAttributeName(d, pd);
        return configEntry.parseAttribute(attrID).asSetOfString();
    }

    /** Get the default values for the specified property. */
    private <T> Collection<T> getDefaultValues(ManagedObjectPath<?, ?> p, PropertyDefinition<T> pd,
            Entry newConfigEntry) {
        DefaultValueFinder<T> v = new DefaultValueFinder<>(newConfigEntry);
        return v.find(p, pd);
    }

    /**
     * Returns the repository containing all configuration entries.
     *
     * @return the repository
     */
    public ConfigurationRepository getConfigRepository() {
        return configRepository;
    }

    /** Gets a config entry required for a managed object and throws a config exception on failure. */
    private Entry getManagedObjectConfigEntry(DN dn) throws ConfigException {
        Entry configEntry;
        try {
            configEntry = configRepository.getEntry(dn);
        } catch (ConfigException e) {
            debugLogger.trace("Unable to perform post add", e);

            LocalizableMessage message = ERR_ADMIN_CANNOT_GET_MANAGED_OBJECT.get(
                    dn, stackTraceToSingleLineString(e, true));
            throw new ConfigException(message, e);
        }

        // The configuration handler is free to return null indicating
        // that the entry does not exist.
        if (configEntry == null) {
            throw new ConfigException(ERR_ADMIN_MANAGED_OBJECT_DOES_NOT_EXIST.get(dn));
        }

        return configEntry;
    }

    /** Validate that a relation definition belongs to the path. */
    private void validateRelationDefinition(ManagedObjectPath<?, ?> path, RelationDefinition<?, ?> rd) {
        AbstractManagedObjectDefinition<?, ?> d = path.getManagedObjectDefinition();
        RelationDefinition<?, ?> tmp = d.getRelationDefinition(rd.getName());
        if (tmp != rd) {
            throw new IllegalArgumentException("The relation " + rd.getName() + " is not associated with a "
                    + d.getName());
        }
    }
}
