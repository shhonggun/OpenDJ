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



import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.EnumPropertyDefinition;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.client.CryptPasswordStorageSchemeCfgClient;
import org.forgerock.opendj.server.config.server.CryptPasswordStorageSchemeCfg;
import org.forgerock.opendj.server.config.server.PasswordStorageSchemeCfg;



/**
 * An interface for querying the Crypt Password Storage Scheme managed
 * object definition meta information.
 * <p>
 * The Crypt Password Storage Scheme provides a mechanism for encoding
 * user passwords like Unix crypt does. Like on most Unix systems, the
 * password may be encrypted using different algorithms, either Unix
 * crypt, md5, sha256 or sha512.
 */
public final class CryptPasswordStorageSchemeCfgDefn extends ManagedObjectDefinition<CryptPasswordStorageSchemeCfgClient, CryptPasswordStorageSchemeCfg> {

  /** The singleton configuration definition instance. */
  private static final CryptPasswordStorageSchemeCfgDefn INSTANCE = new CryptPasswordStorageSchemeCfgDefn();



  /**
   * Defines the set of permissable values for the "crypt-password-storage-encryption-algorithm" property.
   * <p>
   * Specifies the algorithm to use to encrypt new passwords.
   * <p>
   * Select the crypt algorithm to use to encrypt new passwords. The
   * value can either be "unix", which means the password is encrypted
   * with the weak Unix crypt algorithm, or "md5" which means the
   * password is encrypted with the BSD MD5 algorithm and has a $1$
   * prefix, or "sha256" which means the password is encrypted with the
   * SHA256 algorithm and has a $5$ prefix, or "sha512" which means the
   * password is encrypted with the SHA512 algorithm and has a $6$
   * prefix.
   */
  public static enum CryptPasswordStorageEncryptionAlgorithm {

    /**
     * New passwords are encrypted with the BSD MD5 algorithm.
     */
    MD5("md5"),



    /**
     * New passwords are encrypted with the Unix crypt SHA256
     * algorithm.
     */
    SHA256("sha256"),



    /**
     * New passwords are encrypted with the Unix crypt SHA512
     * algorithm.
     */
    SHA512("sha512"),



    /**
     * New passwords are encrypted with the Unix crypt algorithm.
     * Passwords are truncated at 8 characters and the top bit of each
     * character is ignored.
     */
    UNIX("unix");



    /** String representation of the value. */
    private final String name;



    /** Private constructor. */
    private CryptPasswordStorageEncryptionAlgorithm(String name) { this.name = name; }



    /** {@inheritDoc} */
    public String toString() { return name; }

  }



  /** The "crypt-password-storage-encryption-algorithm" property definition. */
  private static final EnumPropertyDefinition<CryptPasswordStorageEncryptionAlgorithm> PD_CRYPT_PASSWORD_STORAGE_ENCRYPTION_ALGORITHM;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** Build the "crypt-password-storage-encryption-algorithm" property definition. */
  static {
      EnumPropertyDefinition.Builder<CryptPasswordStorageEncryptionAlgorithm> builder = EnumPropertyDefinition.createBuilder(INSTANCE, "crypt-password-storage-encryption-algorithm");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "crypt-password-storage-encryption-algorithm"));
      DefaultBehaviorProvider<CryptPasswordStorageEncryptionAlgorithm> provider = new DefinedDefaultBehaviorProvider<CryptPasswordStorageEncryptionAlgorithm>("unix");
      builder.setDefaultBehaviorProvider(provider);
      builder.setEnumClass(CryptPasswordStorageEncryptionAlgorithm.class);
      PD_CRYPT_PASSWORD_STORAGE_ENCRYPTION_ALGORITHM = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_CRYPT_PASSWORD_STORAGE_ENCRYPTION_ALGORITHM);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.CryptPasswordStorageScheme");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.PasswordStorageScheme");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the Crypt Password Storage Scheme configuration definition
   * singleton.
   *
   * @return Returns the Crypt Password Storage Scheme configuration
   *         definition singleton.
   */
  public static CryptPasswordStorageSchemeCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private CryptPasswordStorageSchemeCfgDefn() {
    super("crypt-password-storage-scheme", PasswordStorageSchemeCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public CryptPasswordStorageSchemeCfgClient createClientConfiguration(
      ManagedObject<? extends CryptPasswordStorageSchemeCfgClient> impl) {
    return new CryptPasswordStorageSchemeCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public CryptPasswordStorageSchemeCfg createServerConfiguration(
      ServerManagedObject<? extends CryptPasswordStorageSchemeCfg> impl) {
    return new CryptPasswordStorageSchemeCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<CryptPasswordStorageSchemeCfg> getServerConfigurationClass() {
    return CryptPasswordStorageSchemeCfg.class;
  }



  /**
   * Get the "crypt-password-storage-encryption-algorithm" property definition.
   * <p>
   * Specifies the algorithm to use to encrypt new passwords.
   * <p>
   * Select the crypt algorithm to use to encrypt new passwords. The
   * value can either be "unix", which means the password is encrypted
   * with the weak Unix crypt algorithm, or "md5" which means the
   * password is encrypted with the BSD MD5 algorithm and has a $1$
   * prefix, or "sha256" which means the password is encrypted with the
   * SHA256 algorithm and has a $5$ prefix, or "sha512" which means the
   * password is encrypted with the SHA512 algorithm and has a $6$
   * prefix.
   *
   * @return Returns the "crypt-password-storage-encryption-algorithm" property definition.
   */
  public EnumPropertyDefinition<CryptPasswordStorageEncryptionAlgorithm> getCryptPasswordStorageEncryptionAlgorithmPropertyDefinition() {
    return PD_CRYPT_PASSWORD_STORAGE_ENCRYPTION_ALGORITHM;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the Crypt Password Storage Scheme is enabled
   * for use.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return PasswordStorageSchemeCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Crypt Password Storage Scheme implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Managed object client implementation.
   */
  private static class CryptPasswordStorageSchemeCfgClientImpl implements
    CryptPasswordStorageSchemeCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends CryptPasswordStorageSchemeCfgClient> impl;



    /** Private constructor. */
    private CryptPasswordStorageSchemeCfgClientImpl(
        ManagedObject<? extends CryptPasswordStorageSchemeCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public CryptPasswordStorageEncryptionAlgorithm getCryptPasswordStorageEncryptionAlgorithm() {
      return impl.getPropertyValue(INSTANCE.getCryptPasswordStorageEncryptionAlgorithmPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setCryptPasswordStorageEncryptionAlgorithm(CryptPasswordStorageEncryptionAlgorithm value) {
      impl.setPropertyValue(INSTANCE.getCryptPasswordStorageEncryptionAlgorithmPropertyDefinition(), value);
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
    public ManagedObjectDefinition<? extends CryptPasswordStorageSchemeCfgClient, ? extends CryptPasswordStorageSchemeCfg> definition() {
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
  private static class CryptPasswordStorageSchemeCfgServerImpl implements
    CryptPasswordStorageSchemeCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends CryptPasswordStorageSchemeCfg> impl;

    /** The value of the "crypt-password-storage-encryption-algorithm" property. */
    private final CryptPasswordStorageEncryptionAlgorithm pCryptPasswordStorageEncryptionAlgorithm;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;



    /** Private constructor. */
    private CryptPasswordStorageSchemeCfgServerImpl(ServerManagedObject<? extends CryptPasswordStorageSchemeCfg> impl) {
      this.impl = impl;
      this.pCryptPasswordStorageEncryptionAlgorithm = impl.getPropertyValue(INSTANCE.getCryptPasswordStorageEncryptionAlgorithmPropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addCryptChangeListener(
        ConfigurationChangeListener<CryptPasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeCryptChangeListener(
        ConfigurationChangeListener<CryptPasswordStorageSchemeCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<PasswordStorageSchemeCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<PasswordStorageSchemeCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public CryptPasswordStorageEncryptionAlgorithm getCryptPasswordStorageEncryptionAlgorithm() {
      return pCryptPasswordStorageEncryptionAlgorithm;
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
    public Class<? extends CryptPasswordStorageSchemeCfg> configurationClass() {
      return CryptPasswordStorageSchemeCfg.class;
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
