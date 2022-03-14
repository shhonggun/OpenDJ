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
 * Copyright 2008 Sun Microsystems, Inc.
 */
package org.forgerock.opendj.server.config.meta;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.AttributeTypePropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.DNPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.SubjectDNToUserAttributeCertificateMapperCfgClient;
import org.forgerock.opendj.server.config.server.CertificateMapperCfg;
import org.forgerock.opendj.server.config.server.SubjectDNToUserAttributeCertificateMapperCfg;



/**
 * An interface for querying the Subject DN To User Attribute
 * Certificate Mapper managed object definition meta information.
 * <p>
 * The Subject DN To User Attribute Certificate Mapper maps client
 * certificates to user entries by looking for the certificate subject
 * DN in a specified attribute of user entries.
 */
public final class SubjectDNToUserAttributeCertificateMapperCfgDefn extends ManagedObjectDefinition<SubjectDNToUserAttributeCertificateMapperCfgClient, SubjectDNToUserAttributeCertificateMapperCfg> {

  /** The singleton configuration definition instance. */
  private static final SubjectDNToUserAttributeCertificateMapperCfgDefn INSTANCE = new SubjectDNToUserAttributeCertificateMapperCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "subject-attribute" property definition. */
  private static final AttributeTypePropertyDefinition PD_SUBJECT_ATTRIBUTE;



  /** The "user-base-dn" property definition. */
  private static final DNPropertyDefinition PD_USER_BASE_DN;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SubjectDNToUserAttributeCertificateMapper");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.CertificateMapper");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "subject-attribute" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "subject-attribute");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "subject-attribute"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<AttributeType>());
      PD_SUBJECT_ATTRIBUTE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SUBJECT_ATTRIBUTE);
  }



  /** Build the "user-base-dn" property definition. */
  static {
      DNPropertyDefinition.Builder builder = DNPropertyDefinition.createBuilder(INSTANCE, "user-base-dn");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "user-base-dn"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<DN>(INSTANCE, "user-base-dn"));
      PD_USER_BASE_DN = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_USER_BASE_DN);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("security"));
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Subject DN To User Attribute Certificate Mapper
   * configuration definition singleton.
   *
   * @return Returns the Subject DN To User Attribute Certificate
   *         Mapper configuration definition singleton.
   */
  public static SubjectDNToUserAttributeCertificateMapperCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SubjectDNToUserAttributeCertificateMapperCfgDefn() {
    super("subject-dn-to-user-attribute-certificate-mapper", CertificateMapperCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SubjectDNToUserAttributeCertificateMapperCfgClient createClientConfiguration(
      ManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfgClient> impl) {
    return new SubjectDNToUserAttributeCertificateMapperCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SubjectDNToUserAttributeCertificateMapperCfg createServerConfiguration(
      ServerManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfg> impl) {
    return new SubjectDNToUserAttributeCertificateMapperCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SubjectDNToUserAttributeCertificateMapperCfg> getServerConfigurationClass() {
    return SubjectDNToUserAttributeCertificateMapperCfg.class;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Subject DN To User Attribute Certificate
   * Mapper is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return CertificateMapperCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Subject DN To User Attribute Certificate Mapper
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "subject-attribute" property definition.
   * <p>
   * Specifies the name or OID of the attribute whose value should
   * exactly match the certificate subject DN.
   *
   * @return Returns the "subject-attribute" property definition.
   */
  public AttributeTypePropertyDefinition getSubjectAttributePropertyDefinition() {
    return PD_SUBJECT_ATTRIBUTE;
  }



  /**
   * Get the "user-base-dn" property definition.
   * <p>
   * Specifies the base DNs that should be used when performing
   * searches to map the client certificate to a user entry.
   *
   * @return Returns the "user-base-dn" property definition.
   */
  public DNPropertyDefinition getUserBaseDNPropertyDefinition() {
    return PD_USER_BASE_DN;
  }



  /**
   * Managed object client implementation.
   */
  private static class SubjectDNToUserAttributeCertificateMapperCfgClientImpl implements
    SubjectDNToUserAttributeCertificateMapperCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfgClient> impl;



    /** Private constructor. */
    private SubjectDNToUserAttributeCertificateMapperCfgClientImpl(
        ManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public Boolean isEnabled() {
      return impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public AttributeType getSubjectAttribute() {
      return impl.getPropertyValue(INSTANCE.getSubjectAttributePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSubjectAttribute(AttributeType value) {
      impl.setPropertyValue(INSTANCE.getSubjectAttributePropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserBaseDN() {
      return impl.getPropertyValues(INSTANCE.getUserBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setUserBaseDN(Collection<DN> values) {
      impl.setPropertyValues(INSTANCE.getUserBaseDNPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SubjectDNToUserAttributeCertificateMapperCfgClient, ? extends SubjectDNToUserAttributeCertificateMapperCfg> definition() {
      return INSTANCE;
    }



    /** {@inheritDoc} */
    public PropertyProvider properties() {
      return impl;
    }



    /** {@inheritDoc} */
    public void commit() throws ManagedObjectAlreadyExistsException,
        MissingMandatoryPropertiesException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.commit();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }



  /**
   * Managed object server implementation.
   */
  private static class SubjectDNToUserAttributeCertificateMapperCfgServerImpl implements
    SubjectDNToUserAttributeCertificateMapperCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfg> impl;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "subject-attribute" property. */
    private final AttributeType pSubjectAttribute;

    /** The value of the "user-base-dn" property. */
    private final SortedSet<DN> pUserBaseDN;



    /** Private constructor. */
    private SubjectDNToUserAttributeCertificateMapperCfgServerImpl(ServerManagedObject<? extends SubjectDNToUserAttributeCertificateMapperCfg> impl) {
      this.impl = impl;
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pSubjectAttribute = impl.getPropertyValue(INSTANCE.getSubjectAttributePropertyDefinition());
      this.pUserBaseDN = impl.getPropertyValues(INSTANCE.getUserBaseDNPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSubjectDNToUserAttributeChangeListener(
        ConfigurationChangeListener<SubjectDNToUserAttributeCertificateMapperCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSubjectDNToUserAttributeChangeListener(
        ConfigurationChangeListener<SubjectDNToUserAttributeCertificateMapperCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<CertificateMapperCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<CertificateMapperCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public AttributeType getSubjectAttribute() {
      return pSubjectAttribute;
    }



    /** {@inheritDoc} */
    public SortedSet<DN> getUserBaseDN() {
      return pUserBaseDN;
    }



    /** {@inheritDoc} */
    public Class<? extends SubjectDNToUserAttributeCertificateMapperCfg> configurationClass() {
      return SubjectDNToUserAttributeCertificateMapperCfg.class;
    }



    /** {@inheritDoc} */
    public DN dn() {
      return impl.getDN();
    }



    /** {@inheritDoc} */
    public String name() {
      return impl.getName();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }
}
