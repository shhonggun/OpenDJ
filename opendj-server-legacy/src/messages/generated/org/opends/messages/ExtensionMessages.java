package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.extension}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/extension.properties} and it should not be manually edited.
 */
public final class ExtensionMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.extension";

    // Prevent instantiation.
    private ExtensionMessages() {
        // Do nothing.
    }

    /**
     * Returns the name of the resource associated with the messages contained
     * in this class. The resource name may be used for obtaining named loggers,
     * e.g. using SLF4J's {@code org.slf4j.LoggerFactory#getLogger(String name)}.
     *
     * @return The name of the resource associated with the messages contained
     *         in this class.
     */
    public static String resourceName() {
        return RESOURCE;
    }

    /**
     * An error occurred while attempting to initialize the message digest generator for the %s algorithm: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWSCHEME_CANNOT_INITIALIZE_MESSAGE_DIGEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_CANNOT_INITIALIZE_MESSAGE_DIGEST_1", 1);

    /**
     * An error occurred while attempting to base64-decode the password value %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWSCHEME_CANNOT_BASE64_DECODE_STORED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_CANNOT_BASE64_DECODE_STORED_PASSWORD_2", 2);

    /**
     * The %s password storage scheme is not reversible, so it is impossible to recover the plaintext version of an encoded password
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWSCHEME_NOT_REVERSIBLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_NOT_REVERSIBLE_3", 3);

    /**
     * An error occurred while trying to register the JMX alert handler with the MBean server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JMX_ALERT_HANDLER_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_JMX_ALERT_HANDLER_CANNOT_REGISTER_4", 4);

    /**
     * An unexpected error occurred while attempting to encode a password using the storage scheme defined in class %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWSCHEME_CANNOT_ENCODE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_CANNOT_ENCODE_PASSWORD_5", 5);

    /**
     * The ds-cfg-include-filter attribute of configuration entry %s, which specifies a set of search filters that may be used to control which entries are included in the cache, has an invalid value of "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CACHE_INVALID_INCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CACHE_INVALID_INCLUDE_FILTER_6", 6);

    /**
     * The ds-cfg-exclude-filter attribute of configuration entry %s, which specifies a set of search filters that may be used to control which entries are excluded from the cache, has an invalid value of "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CACHE_INVALID_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CACHE_INVALID_EXCLUDE_FILTER_7", 7);

    /**
     * A fatal error occurred while trying to initialize fifo entry cache: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FIFOCACHE_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_FIFOCACHE_CANNOT_INITIALIZE_8", 8);

    /**
     * A fatal error occurred while trying to initialize soft reference entry cache: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SOFTREFCACHE_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SOFTREFCACHE_CANNOT_INITIALIZE_9", 9);

    /**
     * An unexpected error occurred while attempting to decode the password modify extended request sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_DECODE_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_DECODE_REQUEST_33", 33);

    /**
     * The password modify extended request cannot be processed because it does not contain an authorization ID and the underlying connection is not authenticated
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_NO_AUTH_OR_USERID =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_NO_AUTH_OR_USERID_34", 34);

    /**
     * The password modify extended request cannot be processed because the server was unable to obtain a write lock on user entry %s after multiple attempts
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_LOCK_USER_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_LOCK_USER_ENTRY_35", 35);

    /**
     * The password modify extended request cannot be processed because the server cannot decode "%s" as a valid DN for use in the authorization ID for the operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_DECODE_AUTHZ_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_DECODE_AUTHZ_DN_36", 36);

    /**
     * The password modify extended request cannot be processed because it contained an invalid userIdentity field. The provided userIdentity string was "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_INVALID_AUTHZID_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_INVALID_AUTHZID_STRING_37", 37);

    /**
     * The password modify extended request cannot be processed because it was not possible to identify the user entry to update based on the authorization DN of "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_NO_USER_ENTRY_BY_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_NO_USER_ENTRY_BY_AUTHZID_38", 38);

    /**
     * The password modify extended operation cannot be processed because the current password provided for the user is invalid
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_INVALID_OLD_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_INVALID_OLD_PASSWORD_41", 41);

    /**
     * Path to the file containing the Directory Server keystore information. Changes to this configuration attribute will take effect the next time that the key manager is accessed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILE_KEYMANAGER_DESCRIPTION_FILE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "INFO_FILE_KEYMANAGER_DESCRIPTION_FILE_43", 43);

    /**
     * The keystore file %s specified in attribute ds-cfg-key-store-file of configuration entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_NO_SUCH_FILE_45", 45);

    /**
     * An unexpected error occurred while trying to determine the value of configuration attribute ds-cfg-key-store-file in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_CANNOT_DETERMINE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_CANNOT_DETERMINE_FILE_46", 46);

    /**
     * Java property %s which is specified in attribute ds-cfg-key-store-pin-property of configuration entry %s should contain the PIN needed to access the file-based key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_PIN_PROPERTY_NOT_SET_50", 50);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-key-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the file-based key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_PIN_ENVAR_NOT_SET_53", 53);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the file-based key manager, but this file does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_PIN_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_PIN_NO_SUCH_FILE_56", 56);

    /**
     * An error occurred while trying to read the keystore PIN from file %s specified in configuration attribute ds-cfg-key-store-pin-file of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILE_KEYMANAGER_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_PIN_FILE_CANNOT_READ_57", 57);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the file-based key manager, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_PIN_FILE_EMPTY_58", 58);

    /**
     * An error occurred while trying to load the keystore contents from file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_CANNOT_LOAD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_CANNOT_LOAD_62", 62);

    /**
     * The keystore type %s specified in attribute ds-cfg-key-store-type of configuration entry %s is not valid: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILE_KEYMANAGER_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_INVALID_TYPE_63", 63);

    /**
     * Java property %s which is specified in attribute ds-cfg-key-store-pin-property of configuration entry %s should contain the PIN needed to access the PKCS#11 key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PKCS11_KEYMANAGER_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_PIN_PROPERTY_NOT_SET_68", 68);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-key-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the PKCS#11 key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PKCS11_KEYMANAGER_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_PIN_ENVAR_NOT_SET_71", 71);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the PKCS#11 key manager, but this file does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PKCS11_KEYMANAGER_PIN_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_PIN_NO_SUCH_FILE_74", 74);

    /**
     * An error occurred while trying to read the keystore PIN from file %s specified in configuration attribute ds-cfg-key-store-pin-file of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PKCS11_KEYMANAGER_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_PIN_FILE_CANNOT_READ_75", 75);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the PKCS#11 key manager, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PKCS11_KEYMANAGER_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_PIN_FILE_EMPTY_76", 76);

    /**
     * An unexpected error occurred while trying to determine the value of configuration attribute ds-cfg-key-store-pin in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PKCS11_KEYMANAGER_CANNOT_DETERMINE_PIN_FROM_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_CANNOT_DETERMINE_PIN_FROM_ATTR_79", 79);

    /**
     * An error occurred while trying to access the PKCS#11 key manager: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PKCS11_KEYMANAGER_CANNOT_LOAD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_CANNOT_LOAD_81", 81);

    /**
     * An error occurred while trying to create a key manager factory to access the contents of keystore file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_KEYMANAGER_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_KEYMANAGER_CANNOT_CREATE_FACTORY_83", 83);

    /**
     * An error occurred while trying to create a key manager factory to access the contents of the PKCS#11 keystore: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PKCS11_KEYMANAGER_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PKCS11_KEYMANAGER_CANNOT_CREATE_FACTORY_84", 84);

    /**
     * The trust store file %s specified in attribute ds-cfg-trust-store-file of configuration entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_NO_SUCH_FILE_87", 87);

    /**
     * An unexpected error occurred while trying to determine the value of configuration attribute ds-cfg-trust-store-file in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_CANNOT_DETERMINE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_CANNOT_DETERMINE_FILE_88", 88);

    /**
     * Java property %s which is specified in attribute ds-cfg-trust-store-pin-property of configuration entry %s should contain the PIN needed to access the file-based trust manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_PIN_PROPERTY_NOT_SET_92", 92);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-trust-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the file-based trust manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_PIN_ENVAR_NOT_SET_95", 95);

    /**
     * File %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s should contain the PIN needed to access the file-based trust manager, but this file does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_PIN_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_PIN_NO_SUCH_FILE_98", 98);

    /**
     * An error occurred while trying to read the trust store PIN from file %s specified in configuration attribute ds-cfg-trust-store-pin-file of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILE_TRUSTMANAGER_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_PIN_FILE_CANNOT_READ_99", 99);

    /**
     * File %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s should contain the PIN needed to access the file-based trust manager, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_PIN_FILE_EMPTY_100", 100);

    /**
     * An error occurred while trying to load the trust store contents from file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_CANNOT_LOAD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_CANNOT_LOAD_104", 104);

    /**
     * An error occurred while trying to create a trust manager factory to access the contents of trust store file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILE_TRUSTMANAGER_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_CANNOT_CREATE_FACTORY_105", 105);

    /**
     * The trust store type %s specified in attribute ds-cfg-trust-store-type of configuration entry %s is not valid: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILE_TRUSTMANAGER_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FILE_TRUSTMANAGER_INVALID_TYPE_106", 106);

    /**
     * Could not map the provided certificate chain to a user entry because no peer certificate was available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEDCM_NO_PEER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SEDCM_NO_PEER_CERTIFICATE_118", 118);

    /**
     * Could not map the provided certificate chain to a user because the peer certificate was not an X.509 certificate (peer certificate format was %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEDCM_PEER_CERT_NOT_X509 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SEDCM_PEER_CERT_NOT_X509_119", 119);

    /**
     * Could not map the provided certificate chain to a user because the peer certificate subject "%s" could not be decoded as an LDAP DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEDCM_CANNOT_DECODE_SUBJECT_AS_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SEDCM_CANNOT_DECODE_SUBJECT_AS_DN_120", 120);

    /**
     * Could not map the provided certificate chain to a user because an error occurred while attempting to retrieve the user entry with DN "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEDCM_CANNOT_GET_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SEDCM_CANNOT_GET_ENTRY_121", 121);

    /**
     * Could not map the provided certificate chain to a user because no user entry exists with a DN of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEDCM_NO_USER_FOR_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SEDCM_NO_USER_FOR_DN_122", 122);

    /**
     * The SASL EXTERNAL bind request could not be processed because the associated bind request does not have a reference to the client connection
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLEXTERNAL_NO_CLIENT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_NO_CLIENT_CONNECTION_123", 123);

    /**
     * The SASL EXTERNAL bind request could not be processed because the associated client connection instance is not an instance of LDAPClientConnection
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLEXTERNAL_NOT_LDAP_CLIENT_INSTANCE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_NOT_LDAP_CLIENT_INSTANCE_124", 124);

    /**
     * The SASL EXTERNAL bind request could not be processed because the client did not present a certificate chain during SSL/TLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLEXTERNAL_NO_CLIENT_CERT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_NO_CLIENT_CERT_126", 126);

    /**
     * The SASL EXTERNAL bind request failed because the certificate chain presented by the client during SSL/TLS negotiation could not be mapped to a user entry in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLEXTERNAL_NO_MAPPING =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_NO_MAPPING_127", 127);

    /**
     * StartTLS cannot be used on this connection because the underlying client connection is not available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STARTTLS_NO_CLIENT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_STARTTLS_NO_CLIENT_CONNECTION_128", 128);

    /**
     * StartTLS cannot be used on this client connection because this connection type is not capable of using StartTLS to protect its communication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STARTTLS_NOT_TLS_CAPABLE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_STARTTLS_NOT_TLS_CAPABLE_129", 129);

    /**
     * Unable to authenticate via SASL EXTERNAL because the mapped user entry %s does not have any certificates with which to verify the presented peer certificate
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLEXTERNAL_NO_CERT_IN_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_NO_CERT_IN_ENTRY_137", 137);

    /**
     * Unable to authenticate via SASL EXTERNAL because the mapped user entry %s did not contain the peer certificate presented by the client
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLEXTERNAL_PEER_CERT_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_PEER_CERT_NOT_FOUND_138", 138);

    /**
     * An error occurred while attempting to validate the peer certificate presented by the client with a certificate from the user's entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLEXTERNAL_CANNOT_VALIDATE_CERT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLEXTERNAL_CANNOT_VALIDATE_CERT_139", 139);

    /**
     * SASL PLAIN authentication requires that SASL credentials be provided but none were included in the bind request
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_NO_SASL_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_NO_SASL_CREDENTIALS_147", 147);

    /**
     * The SASL PLAIN bind request did not include any NULL characters. NULL characters are required as delimiters between the authorization ID and authentication ID, and also between the authentication ID and the password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_NO_NULLS_IN_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_NO_NULLS_IN_CREDENTIALS_148", 148);

    /**
     * The SASL PLAIN bind request did not include a second NULL character in the credentials, which is required as a delimiter between the authentication ID and the password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_NO_SECOND_NULL =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_NO_SECOND_NULL_149", 149);

    /**
     * The authentication ID contained in the SASL PLAIN bind request had a length of zero characters, which is not allowed. SASL PLAIN authentication does not allow an empty string for use as the authentication ID
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_ZERO_LENGTH_AUTHCID =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_ZERO_LENGTH_AUTHCID_150", 150);

    /**
     * The password contained in the SASL PLAIN bind request had a length of zero characters, which is not allowed. SASL PLAIN authentication does not allow an empty string for use as the password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_ZERO_LENGTH_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_ZERO_LENGTH_PASSWORD_151", 151);

    /**
     * An error occurred while attempting to decode the SASL PLAIN authentication ID "%s" because it appeared to contain a DN but DN decoding failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_CANNOT_DECODE_AUTHCID_AS_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_CANNOT_DECODE_AUTHCID_AS_DN_152", 152);

    /**
     * The authentication ID in the SASL PLAIN bind request appears to be an empty DN. This is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_AUTHCID_IS_NULL_DN =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHCID_IS_NULL_DN_153", 153);

    /**
     * An error occurred while attempting to retrieve user entry %s as specified in the DN-based authentication ID of a SASL PLAIN bind request: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_CANNOT_GET_ENTRY_BY_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_CANNOT_GET_ENTRY_BY_DN_154", 154);

    /**
     * The server was not able to find any user entries for the provided authentication ID of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLPLAIN_NO_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_NO_MATCHING_ENTRIES_157", 157);

    /**
     * The provided password is invalid
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLPLAIN_INVALID_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_INVALID_PASSWORD_160", 160);

    /**
     * An unexpected error occurred while attempting to obtain an MD5 digest engine for use by the CRAM-MD5 SASL handler: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLCRAMMD5_CANNOT_GET_MESSAGE_DIGEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_CANNOT_GET_MESSAGE_DIGEST_166", 166);

    /**
     * The SASL CRAM-MD5 bind request contained SASL credentials but there is no stored challenge for this client connection. The first CRAM-MD5 bind request in the two-stage process must not contain client SASL credentials
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLCRAMMD5_NO_STORED_CHALLENGE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_NO_STORED_CHALLENGE_172", 172);

    /**
     * The SASL CRAM-MD5 bind request contained SASL credentials, but the stored SASL state information for this client connection is not in an appropriate form for the challenge
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLCRAMMD5_INVALID_STORED_CHALLENGE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_INVALID_STORED_CHALLENGE_173", 173);

    /**
     * The SASL CRAM-MD5 bind request from the client included SASL credentials but there was no space to separate the username from the authentication digest
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLCRAMMD5_NO_SPACE_IN_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_NO_SPACE_IN_CREDENTIALS_174", 174);

    /**
     * The SASL CRAM-MD5 bind request included SASL credentials, but the decoded digest string had an invalid length of %d bytes rather than the %d bytes expected for a hex representation of an MD5 digest
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_SASLCRAMMD5_INVALID_DIGEST_LENGTH =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_INVALID_DIGEST_LENGTH_175", 175);

    /**
     * The SASL CRAM-MD5 bind request included SASL credentials, but the decoded digest was not comprised of only hexadecimal digits: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLCRAMMD5_INVALID_DIGEST_CONTENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_INVALID_DIGEST_CONTENT_176", 176);

    /**
     * An error occurred while attempting to decode the SASL CRAM-MD5 username "%s" because it appeared to contain a DN but DN decoding failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLCRAMMD5_CANNOT_DECODE_USERNAME_AS_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_CANNOT_DECODE_USERNAME_AS_DN_177", 177);

    /**
     * The username in the SASL CRAM-MD5 bind request appears to be an empty DN. This is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLCRAMMD5_USERNAME_IS_NULL_DN =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_USERNAME_IS_NULL_DN_178", 178);

    /**
     * An error occurred while attempting to retrieve user entry %s as specified in the DN-based username of a SASL CRAM-MD5 bind request: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLCRAMMD5_CANNOT_GET_ENTRY_BY_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_CANNOT_GET_ENTRY_BY_DN_180", 180);

    /**
     * The server was not able to find any user entries for the provided username of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLCRAMMD5_NO_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_NO_MATCHING_ENTRIES_184", 184);

    /**
     * The provided password is invalid
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLCRAMMD5_INVALID_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_INVALID_PASSWORD_188", 188);

    /**
     * SASL CRAM-MD5 authentication is not possible for user %s because none of the passwords in the user entry are stored in a reversible form
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLCRAMMD5_NO_REVERSIBLE_PASSWORDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_NO_REVERSIBLE_PASSWORDS_189", 189);

    /**
     * An unsupported or unexpected callback was provided to the SASL server for use during %s authentication: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_SASL_UNSUPPORTED_CALLBACK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "INFO_SASL_UNSUPPORTED_CALLBACK_192", 192);

    /**
     * The client connection included %s state information, indicating that the client was in the process of performing a %s bind, but the bind request did not include any credentials
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_NO_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_NO_CREDENTIALS_193", 193);

    /**
     * An unexpected error occurred while attempting to determine the value of the ds-cfg-server-fqdn attribute in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_CANNOT_GET_SERVER_FQDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CANNOT_GET_SERVER_FQDN_194", 194);

    /**
     * An unexpected error occurred while trying to create an %s context: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_CONTEXT_CREATE_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CONTEXT_CREATE_ERROR_195", 195);

    /**
     * An error occurred while attempting to decode the SASL %s username "%s" because it appeared to contain a DN but DN decoding failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SASL_CANNOT_DECODE_USERNAME_AS_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CANNOT_DECODE_USERNAME_AS_DN_196", 196);

    /**
     * The username in the SASL %s bind request appears to be an empty DN. This is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_USERNAME_IS_NULL_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_USERNAME_IS_NULL_DN_197", 197);

    /**
     * An error occurred while attempting to retrieve user entry %s as specified in the DN-based username of a SASL %s bind request: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SASL_CANNOT_GET_ENTRY_BY_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CANNOT_GET_ENTRY_BY_DN_199", 199);

    /**
     * The username contained in the SASL %s bind request had a length of zero characters, which is not allowed. %s authentication does not allow an empty string for use as the username
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_ZERO_LENGTH_USERNAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_ZERO_LENGTH_USERNAME_200", 200);

    /**
     * The server was not able to find any user entries for the provided username of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_NO_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_NO_MATCHING_ENTRIES_201", 201);

    /**
     * The provided authorization ID %s contained an invalid DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_AUTHZID_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_INVALID_DN_202", 202);

    /**
     * The entry %s specified as the authorization identity does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_AUTHZID_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_NO_SUCH_ENTRY_203", 203);

    /**
     * The entry %s specified as the authorization identity could not be retrieved: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_AUTHZID_CANNOT_GET_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_CANNOT_GET_ENTRY_204", 204);

    /**
     * The server was unable to find any entry corresponding to authorization ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_AUTHZID_NO_MAPPED_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_NO_MAPPED_ENTRY_205", 205);

    /**
     * An error occurred while attempting to retrieve the clear-text password(s) for user %s in order to perform SASL %s authentication: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SASL_CANNOT_GET_REVERSIBLE_PASSWORDS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CANNOT_GET_REVERSIBLE_PASSWORDS_207", 207);

    /**
     * SASL %s authentication is not possible for user %s because none of the passwords in the user entry are stored in a reversible form
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_NO_REVERSIBLE_PASSWORDS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_NO_REVERSIBLE_PASSWORDS_208", 208);

    /**
     * SASL %s protocol error: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_PROTOCOL_ERROR_209", 209);

    /**
     * The authenticating user %s does not have sufficient privileges to assume a different authorization identity
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_AUTHZID_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_INSUFFICIENT_PRIVILEGES_210", 210);

    /**
     * The authenticating user %s does not have sufficient access to assume a different authorization identity
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_AUTHZID_INSUFFICIENT_ACCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHZID_INSUFFICIENT_ACCESS_211", 211);

    /**
     * The server was unable to find any entry corresponding to authentication ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_AUTHENTRY_NO_MAPPED_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_AUTHENTRY_NO_MAPPED_ENTRY_212", 212);

    /**
     * The server was unable to because both the ds-cfg-kdc-address and ds-cfg-realm attributes must be defined or neither defined
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLGSSAPI_KDC_REALM_NOT_DEFINED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLGSSAPI_KDC_REALM_NOT_DEFINED_213", 213);

    /**
     * An error occurred while attempting to map authorization ID %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_CANNOT_MAP_AUTHENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CANNOT_MAP_AUTHENTRY_214", 214);

    /**
     * An error occurred while attempting to write a temporary JAAS configuration file for use during GSSAPI processing: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLGSSAPI_CANNOT_CREATE_JAAS_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLGSSAPI_CANNOT_CREATE_JAAS_CONFIG_215", 215);

    /**
     * An error occurred while attempting to create the JAAS login context for GSSAPI authentication: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLGSSAPI_CANNOT_CREATE_LOGIN_CONTEXT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLGSSAPI_CANNOT_CREATE_LOGIN_CONTEXT_216", 216);

    /**
     * No client connection was available for use in processing the GSSAPI bind request
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLGSSAPI_NO_CLIENT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLGSSAPI_NO_CLIENT_CONNECTION_217", 217);

    /**
     * GSSAPI mechanism using a principal name of: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GSSAPI_PRINCIPAL_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "INFO_GSSAPI_PRINCIPAL_NAME_218", 218);

    /**
     * GSSAPI SASL mechanism using a server fully qualified domain name of: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GSSAPI_SERVER_FQDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "INFO_GSSAPI_SERVER_FQDN_219", 219);

    /**
     * DIGEST-MD5 SASL mechanism using a realm of: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DIGEST_MD5_REALM =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "INFO_DIGEST_MD5_REALM_220", 220);

    /**
     * DIGEST-MD5 SASL mechanism using a server fully qualified domain name of: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_DIGEST_MD5_SERVER_FQDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "NOTE_DIGEST_MD5_SERVER_FQDN_221", 221);

    /**
     * You do not have sufficient privileges to use the proxied authorization control
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_WHOAMI_PROXYAUTH_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_WHOAMI_PROXYAUTH_INSUFFICIENT_PRIVILEGES_277", 277);

    /**
     * ID string %s mapped to multiple users
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXACTMAP_MULTIPLE_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXACTMAP_MULTIPLE_MATCHING_ENTRIES_306", 306);

    /**
     * The internal search based on ID string %s could not be processed efficiently: %s. Check the server configuration to ensure that all associated backends are properly configured for these types of searches
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXACTMAP_INEFFICIENT_SEARCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXACTMAP_INEFFICIENT_SEARCH_307", 307);

    /**
     * An internal failure occurred while attempting to resolve ID string %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXACTMAP_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXACTMAP_SEARCH_FAILED_308", 308);

    /**
     * An error occurred while attempting to map username %s to a Directory Server entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLCRAMMD5_CANNOT_MAP_USERNAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_CANNOT_MAP_USERNAME_313", 313);

    /**
     * An error occurred while attempting to map username %s to a Directory Server entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLDIGESTMD5_CANNOT_MAP_USERNAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLDIGESTMD5_CANNOT_MAP_USERNAME_319", 319);

    /**
     * An error occurred while attempting to map username %s to a Directory Server entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_CANNOT_MAP_USERNAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_CANNOT_MAP_USERNAME_325", 325);

    /**
     * Unable to process the cancel request because the extended operation did not include a request value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_CANCEL_NO_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_CANCEL_NO_REQUEST_VALUE_327", 327);

    /**
     * An error occurred while attempting to decode the value of the cancel extended request: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_CANCEL_CANNOT_DECODE_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_CANCEL_CANNOT_DECODE_REQUEST_VALUE_328", 328);

    /**
     * Processing on this operation was terminated as a result of receiving a cancel request (message ID %d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_EXTOP_CANCEL_REASON =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "INFO_EXTOP_CANCEL_REASON_329", 329);

    /**
     * Password storage scheme %s does not support use with the authentication password attribute syntax
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWSCHEME_DOES_NOT_SUPPORT_AUTH_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_DOES_NOT_SUPPORT_AUTH_PASSWORD_330", 330);

    /**
     * The configured minimum password length of %d characters is greater than the configured maximum password length of %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_PWLENGTHVALIDATOR_MIN_GREATER_THAN_MAX =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ExtensionMessages.class, RESOURCE, "ERR_PWLENGTHVALIDATOR_MIN_GREATER_THAN_MAX_335", 335);

    /**
     * The provided password is shorter than the minimum required length of %d characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PWLENGTHVALIDATOR_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_PWLENGTHVALIDATOR_TOO_SHORT_336", 336);

    /**
     * The provided password is longer than the maximum allowed length of %d characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PWLENGTHVALIDATOR_TOO_LONG =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_PWLENGTHVALIDATOR_TOO_LONG_337", 337);

    /**
     * Configuration entry "%s" does not contain attribute ds-cfg-password-character-set which specifies the sets of characters that should be used when generating the password. This is a required attribute
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RANDOMPWGEN_NO_CHARSETS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_NO_CHARSETS_341", 341);

    /**
     * Configuration entry "%s" contains multiple definitions for the %s character set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RANDOMPWGEN_CHARSET_NAME_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_CHARSET_NAME_CONFLICT_342", 342);

    /**
     * An error occurred while attempting to decode the value(s) of the configuration attribute ds-cfg-password-character-set, which is used to hold the character set(s) for use in generating the password: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RANDOMPWGEN_CANNOT_DETERMINE_CHARSETS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_CANNOT_DETERMINE_CHARSETS_343", 343);

    /**
     * The password format string "%s" references an undefined character set "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RANDOMPWGEN_UNKNOWN_CHARSET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_UNKNOWN_CHARSET_346", 346);

    /**
     * The password format string "%s" contains an invalid syntax. This value should be a comma-delimited sequence of elements, where each element is the name of a character set followed by a colon and the number of characters to choose at random from that character set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RANDOMPWGEN_INVALID_PWFORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_INVALID_PWFORMAT_347", 347);

    /**
     * An error occurred while attempting to decode the value for configuration attribute ds-cfg-password-format, which is used to specify the format for the generated passwords: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RANDOMPWGEN_CANNOT_DETERMINE_PWFORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_RANDOMPWGEN_CANNOT_DETERMINE_PWFORMAT_348", 348);

    /**
     * An error occurred while attempting to get the password policy for user %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXTOP_PASSMOD_CANNOT_GET_PW_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_GET_PW_POLICY_354", 354);

    /**
     * The current password must be provided for self password changes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_REQUIRE_CURRENT_PW =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_REQUIRE_CURRENT_PW_355", 355);

    /**
     * Password modify operations that supply the user's current password must be performed over a secure communication channel
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_SECURE_AUTH_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_SECURE_AUTH_REQUIRED_356", 356);

    /**
     * End users are not allowed to change their passwords
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_USER_PW_CHANGES_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_USER_PW_CHANGES_NOT_ALLOWED_357", 357);

    /**
     * Password changes must be performed over a secure communication channel
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_SECURE_CHANGES_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_SECURE_CHANGES_REQUIRED_358", 358);

    /**
     * The password cannot be changed because the previous password change was too recent
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_IN_MIN_AGE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_IN_MIN_AGE_359", 359);

    /**
     * The password cannot be changed because it is expired
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_PASSWORD_IS_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_PASSWORD_IS_EXPIRED_360", 360);

    /**
     * No new password was provided, and no password generator has been defined that may be used to automatically create a new password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_NO_PW_GENERATOR =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_NO_PW_GENERATOR_361", 361);

    /**
     * An error occurred while attempting to create a new password using the password generator: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_GENERATE_PW =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_GENERATE_PW_362", 362);

    /**
     * The password policy does not allow users to supply pre-encoded passwords
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_PRE_ENCODED_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_PRE_ENCODED_NOT_ALLOWED_363", 363);

    /**
     * The provided new password failed the validation checks defined in the server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_UNACCEPTABLE_PW =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_UNACCEPTABLE_PW_364", 364);

    /**
     * Unable to encode the provided password using the default scheme(s): %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_ENCODE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_ENCODE_PASSWORD_365", 365);

    /**
     * The identity mapper with configuration entry DN %s as specified for use with the password modify extended operation defined in entry %s either does not exist or is not enabled. The identity mapper is a required component, and the password modify extended operation will not be enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXTOP_PASSMOD_NO_SUCH_ID_MAPPER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_NO_SUCH_ID_MAPPER_368", 368);

    /**
     * An error occurred while attempting to determine the identity mapper to use in conjunction with the password modify extended operation defined in configuration entry %s: %s. The password modify extended operation will not be enabled for use in the server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXTOP_PASSMOD_CANNOT_DETERMINE_ID_MAPPER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_DETERMINE_ID_MAPPER_369", 369);

    /**
     * The provided authorization ID string "%s" could not be mapped to any user in the directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_MAP_USER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_MAP_USER_370", 370);

    /**
     * An error occurred while attempting to map authorization ID string "%s" to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXTOP_PASSMOD_ERROR_MAPPING_USER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_ERROR_MAPPING_USER_371", 371);

    /**
     * Account-Status-Notification type='%s' userdn='%s' id=%d msg='%s'
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object> NOTE_ERRORLOG_ACCTNOTHANDLER_NOTIFICATION =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object>(ExtensionMessages.class, RESOURCE, "NOTE_ERRORLOG_ACCTNOTHANDLER_NOTIFICATION_375", 375);

    /**
     * An error occurred while attempting to retrieve the clear-text password(s) for user %s in order to perform SASL CRAM-MD5 authentication: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLCRAMMD5_CANNOT_GET_REVERSIBLE_PASSWORDS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLCRAMMD5_CANNOT_GET_REVERSIBLE_PASSWORDS_377", 377);

    /**
     * An error occurred while attempting to verify the password for user %s during SASL PLAIN authentication: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_CANNOT_CHECK_PASSWORD_VALIDITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_CANNOT_CHECK_PASSWORD_VALIDITY_378", 378);

    /**
     * The password modify operation was not actually performed in the Directory Server because the LDAP no-op control was present in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_EXTOP_PASSMOD_NOOP =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "WARN_EXTOP_PASSMOD_NOOP_380", 380);

    /**
     * The user account has been administratively disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_ACCOUNT_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_ACCOUNT_DISABLED_381", 381);

    /**
     * The user account is locked
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_ACCOUNT_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_ACCOUNT_LOCKED_382", 382);

    /**
     * Unable to examine entry %s as a potential member of static group %s because that entry does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STATICMEMBERS_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICMEMBERS_NO_SUCH_ENTRY_383", 383);

    /**
     * An error occurred while attempting to retrieve entry %s as a potential member of static group %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICMEMBERS_CANNOT_GET_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICMEMBERS_CANNOT_GET_ENTRY_384", 384);

    /**
     * Entry %s cannot be parsed as a valid static group because static groups are not allowed to have both the %s and %s object classes
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICGROUP_INVALID_OC_COMBINATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_INVALID_OC_COMBINATION_385", 385);

    /**
     * Entry %s cannot be parsed as a valid static group because it does not contain exactly one of the %s or the %s object classes
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICGROUP_NO_VALID_OC =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_NO_VALID_OC_386", 386);

    /**
     * Value %s for attribute %s in entry %s cannot be parsed as a valid DN: %s. It will be excluded from the set of group members
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_STATICGROUP_CANNOT_DECODE_MEMBER_VALUE_AS_DN =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_CANNOT_DECODE_MEMBER_VALUE_AS_DN_387", 387);

    /**
     * Cannot add user %s as a new member of static group %s because that user is already in the member list for the group
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STATICGROUP_ADD_MEMBER_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_ADD_MEMBER_ALREADY_EXISTS_388", 388);

    /**
     * Cannot remove user %s as a member of static group %s because that user is not included in the member list for the group
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STATICGROUP_REMOVE_MEMBER_NO_SUCH_MEMBER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_REMOVE_MEMBER_NO_SUCH_MEMBER_389", 389);

    /**
     * Cannot add user %s as a new member of static group %s because an error occurred while attempting to perform an internal modification to update the group: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICGROUP_ADD_MEMBER_UPDATE_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_ADD_MEMBER_UPDATE_FAILED_390", 390);

    /**
     * Cannot remove user %s as a member of static group %s because an error occurred while attempting to perform an internal modification to update the group: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICGROUP_REMOVE_MEMBER_UPDATE_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_REMOVE_MEMBER_UPDATE_FAILED_391", 391);

    /**
     * You do not have sufficient privileges to perform password reset operations
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_INSUFFICIENT_PRIVILEGES_392", 392);

    /**
     * The provided authorization ID was empty, which is not allowed for DIGEST-MD5 authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SASLDIGESTMD5_EMPTY_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SASLDIGESTMD5_EMPTY_AUTHZID_393", 393);

    /**
     * The provided authorization ID %s contained an invalid DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_AUTHZID_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_INVALID_DN_400", 400);

    /**
     * The authenticating user %s does not have sufficient privileges to specify an alternate authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLPLAIN_AUTHZID_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_INSUFFICIENT_PRIVILEGES_401", 401);

    /**
     * The entry corresponding to authorization DN %s does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLPLAIN_AUTHZID_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_NO_SUCH_ENTRY_402", 402);

    /**
     * An error occurred while attempting to retrieve entry %s specified as the authorization ID: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_AUTHZID_CANNOT_GET_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_CANNOT_GET_ENTRY_403", 403);

    /**
     * No entry corresponding to authorization ID %s was found in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASLPLAIN_AUTHZID_NO_MAPPED_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_NO_MAPPED_ENTRY_404", 404);

    /**
     * An error occurred while attempting to map authorization ID %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASLPLAIN_AUTHZID_CANNOT_MAP_AUTHZID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASLPLAIN_AUTHZID_CANNOT_MAP_AUTHZID_405", 405);

    /**
     * Could not map the provided certificate chain to a user entry because no peer certificate was available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SDTUACM_NO_PEER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_NO_PEER_CERTIFICATE_417", 417);

    /**
     * Could not map the provided certificate chain to a user because the peer certificate was not an X.509 certificate (peer certificate format was %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SDTUACM_PEER_CERT_NOT_X509 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_PEER_CERT_NOT_X509_418", 418);

    /**
     * The certificate with subject %s could not be mapped to exactly one user. It maps to both %s and %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SDTUACM_MULTIPLE_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_MULTIPLE_MATCHING_ENTRIES_419", 419);

    /**
     * Configuration entry %s has value '%s' which violates the format required for attribute mappings. The expected format is 'certattr:userattr'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_INVALID_MAP_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_INVALID_MAP_FORMAT_422", 422);

    /**
     * Configuration entry %s contains multiple mappings for certificate attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_DUPLICATE_CERT_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_DUPLICATE_CERT_ATTR_423", 423);

    /**
     * Mapping %s in configuration entry %s references attribute %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SATUACM_NO_SUCH_ATTR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_NO_SUCH_ATTR_424", 424);

    /**
     * Configuration entry %s contains multiple mappings for user attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_DUPLICATE_USER_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_DUPLICATE_USER_ATTR_425", 425);

    /**
     * Could not map the provided certificate chain to a user entry because no peer certificate was available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SATUACM_NO_PEER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_NO_PEER_CERTIFICATE_429", 429);

    /**
     * Could not map the provided certificate chain to a user because the peer certificate was not an X.509 certificate (peer certificate format was %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SATUACM_PEER_CERT_NOT_X509 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_PEER_CERT_NOT_X509_430", 430);

    /**
     * Unable to decode peer certificate subject %s as a DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_CANNOT_DECODE_SUBJECT_AS_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_CANNOT_DECODE_SUBJECT_AS_DN_431", 431);

    /**
     * Peer certificate subject %s does not contain any attributes for which a mapping has been established
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SATUACM_NO_MAPPABLE_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_NO_MAPPABLE_ATTRIBUTES_432", 432);

    /**
     * The certificate with subject %s could not be mapped to exactly one user. It maps to both %s and %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SATUACM_MULTIPLE_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_MULTIPLE_MATCHING_ENTRIES_433", 433);

    /**
     * Could not map the provided certificate chain to a user entry because no peer certificate was available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_FCM_NO_PEER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_FCM_NO_PEER_CERTIFICATE_443", 443);

    /**
     * Could not map the provided certificate chain to a user because the peer certificate was not an X.509 certificate (peer certificate format was %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FCM_PEER_CERT_NOT_X509 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_PEER_CERT_NOT_X509_444", 444);

    /**
     * An error occurred while attempting to calculate the fingerprint for the peer certificate with subject %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FCM_CANNOT_CALCULATE_FINGERPRINT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_CANNOT_CALCULATE_FINGERPRINT_445", 445);

    /**
     * The certificate with fingerprint %s could not be mapped to exactly one user. It maps to both %s and %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FCM_MULTIPLE_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_MULTIPLE_MATCHING_ENTRIES_446", 446);

    /**
     * Unable to decode value "%s" in entry "%s" as an LDAP URL: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DYNAMICGROUP_CANNOT_DECODE_MEMBERURL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_DYNAMICGROUP_CANNOT_DECODE_MEMBERURL_447", 447);

    /**
     * Dynamic groups do not support nested groups
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DYNAMICGROUP_NESTING_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_DYNAMICGROUP_NESTING_NOT_SUPPORTED_448", 448);

    /**
     * Dynamic groups do not support explicitly altering their membership
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DYNAMICGROUP_ALTERING_MEMBERS_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_DYNAMICGROUP_ALTERING_MEMBERS_NOT_SUPPORTED_449", 449);

    /**
     * Base DN %s specified in dynamic group %s does not exist in the server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DYNAMICGROUP_NONEXISTENT_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "WARN_DYNAMICGROUP_NONEXISTENT_BASE_DN_450", 450);

    /**
     * An error occurred while attempting perform an internal search with base DN %s and filter %s to resolve the member list for dynamic group %s: result code %s, error message %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> ERR_DYNAMICGROUP_INTERNAL_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_DYNAMICGROUP_INTERNAL_SEARCH_FAILED_451", 451);

    /**
     * The server encountered a timeout while attempting to add user %s to the member list for dynamic group %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DYNAMICGROUP_CANNOT_RETURN_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_DYNAMICGROUP_CANNOT_RETURN_ENTRY_452", 452);

    /**
     * The provided password differs less than the minimum required difference of %d characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PWDIFFERENCEVALIDATOR_TOO_SMALL =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_PWDIFFERENCEVALIDATOR_TOO_SMALL_456", 456);

    /**
     * The provided password contained too many instances of the same character appearing consecutively. The maximum number of times the same character may appear consecutively in a password is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_REPEATEDCHARS_VALIDATOR_TOO_MANY_CONSECUTIVE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_REPEATEDCHARS_VALIDATOR_TOO_MANY_CONSECUTIVE_457", 457);

    /**
     * The provided password does not contain enough unique characters. The minimum number of unique characters that may appear in a user password is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_UNIQUECHARS_VALIDATOR_NOT_ENOUGH_UNIQUE_CHARS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_UNIQUECHARS_VALIDATOR_NOT_ENOUGH_UNIQUE_CHARS_458", 458);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_VATTR_NOT_SEARCHABLE_459", 459);

    /**
     * The provided password contained a word from the server's dictionary
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DICTIONARY_VALIDATOR_PASSWORD_IN_DICTIONARY =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_DICTIONARY_VALIDATOR_PASSWORD_IN_DICTIONARY_460", 460);

    /**
     * The specified dictionary file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DICTIONARY_VALIDATOR_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_DICTIONARY_VALIDATOR_NO_SUCH_FILE_461", 461);

    /**
     * An error occurred while attempting to load the dictionary from file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DICTIONARY_VALIDATOR_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_DICTIONARY_VALIDATOR_CANNOT_READ_FILE_462", 462);

    /**
     * The provided password was found in another attribute in the user entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTRVALUE_VALIDATOR_PASSWORD_IN_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_ATTRVALUE_VALIDATOR_PASSWORD_IN_ENTRY_463", 463);

    /**
     * The provided password contained character '%s' which is not allowed for use in passwords
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_ILLEGAL_CHARACTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_ILLEGAL_CHARACTER_464", 464);

    /**
     * The provided password did not contain enough characters from the character set '%s'. The minimum number of characters from that set that must be present in user passwords is %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHARSET_VALIDATOR_TOO_FEW_CHARS_FROM_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_TOO_FEW_CHARS_FROM_SET_465", 465);

    /**
     * The provided character set definition '%s' is invalid because it does not contain a colon to separate the minimum count from the character set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_NO_SET_COLON =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_NO_SET_COLON_466", 466);

    /**
     * The provided character set definition '%s' is invalid because the provided character set is empty
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_NO_SET_CHARS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_NO_SET_CHARS_467", 467);

    /**
     * The provided character set definition '%s' is invalid because the value before the colon must be an integer greater or equal to zero
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_INVALID_SET_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_INVALID_SET_COUNT_468", 468);

    /**
     * The provided character set definition '%s' is invalid because it contains character '%s' which has already been used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHARSET_VALIDATOR_DUPLICATE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_DUPLICATE_CHAR_469", 469);

    /**
     * The virtual static group defined in entry %s contains multiple target group DNs, but only one is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VIRTUAL_STATIC_GROUP_MULTIPLE_TARGETS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_MULTIPLE_TARGETS_470", 470);

    /**
     * Unable to decode "%s" as the target DN for group %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_VIRTUAL_STATIC_GROUP_CANNOT_DECODE_TARGET =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_CANNOT_DECODE_TARGET_471", 471);

    /**
     * The virtual static group defined in entry %s does not contain a target group definition
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VIRTUAL_STATIC_GROUP_NO_TARGET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_NO_TARGET_472", 472);

    /**
     * Virtual static groups do not support nesting
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_VIRTUAL_STATIC_GROUP_NESTING_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_NESTING_NOT_SUPPORTED_473", 473);

    /**
     * Target group %s referenced by virtual static group %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VIRTUAL_STATIC_GROUP_NO_TARGET_GROUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_NO_TARGET_GROUP_474", 474);

    /**
     * Altering membership for virtual static group %s is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VIRTUAL_STATIC_GROUP_ALTERING_MEMBERS_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_ALTERING_MEMBERS_NOT_SUPPORTED_475", 475);

    /**
     * Virtual static group %s references target group %s which is itself a virtual static group. One virtual static group is not allowed to reference another as its target group
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VIRTUAL_STATIC_GROUP_TARGET_CANNOT_BE_VIRTUAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_VIRTUAL_STATIC_GROUP_TARGET_CANNOT_BE_VIRTUAL_476", 476);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRYUUID_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_ENTRYUUID_VATTR_NOT_SEARCHABLE_501", 501);

    /**
     * You do not have sufficient privileges to use the password policy state extended operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_NO_PRIVILEGE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_NO_PRIVILEGE_502", 502);

    /**
     * The provided password policy state extended request did not include a request value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_NO_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_NO_REQUEST_VALUE_503", 503);

    /**
     * An unexpected error occurred while attempting to decode password policy state extended request value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_DECODE_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_DECODE_FAILURE_504", 504);

    /**
     * Multiple entries were found with DN %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_MULTIPLE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_MULTIPLE_ENTRIES_505", 505);

    /**
     * An unexpected error occurred while attempting to decode an operation from the password policy state extended request: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_INVALID_OP_ENCODING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_INVALID_OP_ENCODING_506", 506);

    /**
     * No value was provided for the password policy state operation intended to set the disabled state for the user. Exactly one value (either 'true' or 'false') must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_NO_DISABLED_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_NO_DISABLED_VALUE_507", 507);

    /**
     * Multiple values were provided for the password policy state operation intended to set the disabled state for the user. Exactly one value (either 'true' or 'false') must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_DISABLED_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_DISABLED_VALUE_COUNT_508", 508);

    /**
     * The value provided for the password policy state operation intended to set the disabled state for the user was invalid. The value must be either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_DISABLED_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_DISABLED_VALUE_509", 509);

    /**
     * Multiple values were provided for the password policy state operation intended to set the account expiration time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_ACCT_EXP_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_ACCT_EXP_VALUE_COUNT_510", 510);

    /**
     * The value %s provided for the password policy state operation used to set the account expiration time was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_ACCT_EXP_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_ACCT_EXP_VALUE_511", 511);

    /**
     * Multiple values were provided for the password policy state operation intended to set the password changed time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_PWCHANGETIME_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_PWCHANGETIME_VALUE_COUNT_512", 512);

    /**
     * The value %s provided for the password policy state operation used to set the password changed time was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_PWCHANGETIME_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_PWCHANGETIME_VALUE_513", 513);

    /**
     * Multiple values were provided for the password policy state operation intended to set the password warned time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_PWWARNEDTIME_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_PWWARNEDTIME_VALUE_COUNT_514", 514);

    /**
     * The value %s provided for the password policy state operation used to set the password warned time was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_PWWARNEDTIME_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_PWWARNEDTIME_VALUE_515", 515);

    /**
     * Multiple values were provided for the password policy state operation intended to add an authentication failure time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_ADD_FAILURE_TIME_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_ADD_FAILURE_TIME_COUNT_516", 516);

    /**
     * The value %s provided for the password policy state operation used to update the authentication failure times was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_AUTH_FAILURE_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_AUTH_FAILURE_TIME_517", 517);

    /**
     * Multiple values were provided for the password policy state operation intended to set the last login time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_LAST_LOGIN_TIME_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_LAST_LOGIN_TIME_COUNT_518", 518);

    /**
     * The value %s provided for the password policy state operation used to set the last login time was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_LAST_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_LAST_LOGIN_TIME_519", 519);

    /**
     * No value was provided for the password policy state operation intended to set the reset state for the user. Exactly one value (either 'true' or 'false') must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_NO_RESET_STATE_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_NO_RESET_STATE_VALUE_520", 520);

    /**
     * Multiple values were provided for the password policy state operation intended to set the reset state for the user. Exactly one value (either 'true' or 'false') must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_RESET_STATE_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_RESET_STATE_VALUE_COUNT_521", 521);

    /**
     * The value provided for the password policy state operation intended to set the reset state for the user was invalid. The value must be either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_RESET_STATE_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_RESET_STATE_VALUE_522", 522);

    /**
     * Multiple values were provided for the password policy state operation intended to add a grace login use time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_ADD_GRACE_LOGIN_TIME_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_ADD_GRACE_LOGIN_TIME_COUNT_523", 523);

    /**
     * The value %s provided for the password policy state operation used to update the grace login use times was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_GRACE_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_GRACE_LOGIN_TIME_524", 524);

    /**
     * Multiple values were provided for the password policy state operation intended to set the required change time for the user. Exactly one value must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_BAD_REQUIRED_CHANGE_TIME_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_REQUIRED_CHANGE_TIME_COUNT_525", 525);

    /**
     * The value %s provided for the password policy state operation used to set the required change time was invalid: %s. The value should be specified using the generalized time format
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_EXTOP_BAD_REQUIRED_CHANGE_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_BAD_REQUIRED_CHANGE_TIME_526", 526);

    /**
     * The password policy state extended request included an operation with an invalid or unsupported operation type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_UNKNOWN_OP_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_UNKNOWN_OP_TYPE_527", 527);

    /**
     * An error occurred while attempting to update the password policy state information for user %s as part of a password modify extended operation (result code='%s', error message='%s')
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_EXTOP_PASSMOD_CANNOT_UPDATE_PWP_STATE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "WARN_EXTOP_PASSMOD_CANNOT_UPDATE_PWP_STATE_528", 528);

    /**
     * The provided new password was already contained in the password history
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_PASSMOD_PW_IN_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_PW_IN_HISTORY_530", 530);

    /**
     * The Directory Server is not configured with any SMTP servers. The SMTP alert handler cannot be used unless the Directory Server is configured with information about at least one SMTP server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SMTPALERTHANDLER_NO_SMTP_SERVERS =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_SMTPALERTHANDLER_NO_SMTP_SERVERS_531", 531);

    /**
     * An error occurred when trying to send an e-mail message for administrative alert with type %s and message %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_SMTPALERTHANDLER_ERROR_SENDING_MESSAGE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "WARN_SMTPALERTHANDLER_ERROR_SENDING_MESSAGE_532", 532);

    /**
     * The provided match pattern "%s" could not be parsed as a regular expression: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REGEXMAP_INVALID_MATCH_PATTERN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_REGEXMAP_INVALID_MATCH_PATTERN_533", 533);

    /**
     * The processed ID string %s mapped to multiple users
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REGEXMAP_MULTIPLE_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_REGEXMAP_MULTIPLE_MATCHING_ENTRIES_535", 535);

    /**
     * The internal search based on processed ID string %s could not be processed efficiently: %s. Check the server configuration to ensure that all associated backends are properly configured for these types of searches
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REGEXMAP_INEFFICIENT_SEARCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_REGEXMAP_INEFFICIENT_SEARCH_536", 536);

    /**
     * An internal failure occurred while attempting to resolve processed ID string %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REGEXMAP_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_REGEXMAP_SEARCH_FAILED_537", 537);

    /**
     * Cannot add group %s as a new nested group of static group %s because that group is already in the nested group list for the group
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STATICGROUP_ADD_NESTED_GROUP_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_ADD_NESTED_GROUP_ALREADY_EXISTS_538", 538);

    /**
     * Cannot remove group %s as a nested group of static group %s because that group is not included in the nested group list for the group
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STATICGROUP_REMOVE_NESTED_GROUP_NO_SUCH_GROUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_REMOVE_NESTED_GROUP_NO_SUCH_GROUP_539", 539);

    /**
     * Group instance with DN %s has been deleted and is no longer valid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STATICGROUP_GROUP_INSTANCE_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICGROUP_GROUP_INSTANCE_INVALID_540", 540);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NUMSUBORDINATES_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_NUMSUBORDINATES_VATTR_NOT_SEARCHABLE_541", 541);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_HASSUBORDINATES_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_HASSUBORDINATES_VATTR_NOT_SEARCHABLE_542", 542);

    /**
     * The SMTP account status notification handler defined in configuration entry %s cannot be enabled unless the Directory Server is with information about one or more SMTP servers
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SMTP_ASNH_NO_MAIL_SERVERS_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_NO_MAIL_SERVERS_CONFIGURED_543", 543);

    /**
     * SMTP account status notification handler configuration entry '%s' does not include any email address attribute types or recipient addresses. At least one of these must be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SMTP_ASNH_NO_RECIPIENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_NO_RECIPIENTS_544", 544);

    /**
     * Unable to parse message subject value '%s' from configuration entry '%s' because the value does not contain a colon to separate the notification type from the subject
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SMTP_ASNH_SUBJECT_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_SUBJECT_NO_COLON_545", 545);

    /**
     * Unable to parse message subject value '%s' from configuration entry '%s' because '%s' is not a valid account status notification type
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SMTP_ASNH_SUBJECT_INVALID_NOTIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_SUBJECT_INVALID_NOTIFICATION_TYPE_546", 546);

    /**
     * The message subject definitions contained in configuration entry '%s' have multiple subjects defined for notification type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SMTP_ASNH_SUBJECT_DUPLICATE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_SUBJECT_DUPLICATE_TYPE_547", 547);

    /**
     * Unable to parse message template file path value '%s' from configuration entry '%s' because the value does not contain a colon to separate the notification type from the template file path
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SMTP_ASNH_TEMPLATE_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_NO_COLON_548", 548);

    /**
     * Unable to parse message template file path value '%s' from configuration entry '%s' because '%s' is not a valid account status notification type
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SMTP_ASNH_TEMPLATE_INVALID_NOTIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_INVALID_NOTIFICATION_TYPE_549", 549);

    /**
     * The message template file path definitions contained in configuration entry '%s' have multiple template file paths defined for notification type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SMTP_ASNH_TEMPLATE_DUPLICATE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_DUPLICATE_TYPE_550", 550);

    /**
     * The message template file '%s' referenced in configuration entry '%s' does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SMTP_ASNH_TEMPLATE_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_NO_SUCH_FILE_551", 551);

    /**
     * An unclosed token was found starting at column %d of line %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_SMTP_ASNH_TEMPLATE_UNCLOSED_TOKEN =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_UNCLOSED_TOKEN_552", 552);

    /**
     * The notification-user-attr token starting at column %d of line %d references undefined attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_SMTP_ASNH_TEMPLATE_UNDEFINED_ATTR_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_UNDEFINED_ATTR_TYPE_553", 553);

    /**
     * The notification-property token starting at column %d of line %d references undefined notification property %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_SMTP_ASNH_TEMPLATE_UNDEFINED_PROPERTY =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_UNDEFINED_PROPERTY_554", 554);

    /**
     * An unrecognized token %s was found at column %d of line %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SMTP_ASNH_TEMPLATE_UNRECOGNIZED_TOKEN =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_UNRECOGNIZED_TOKEN_555", 555);

    /**
     * An error occurred while attempting to parse message template file '%s' referenced in configuration entry '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SMTP_ASNH_TEMPLATE_CANNOT_PARSE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_TEMPLATE_CANNOT_PARSE_556", 556);

    /**
     * Directory Account Status Notification
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SMTP_ASNH_DEFAULT_SUBJECT =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "INFO_SMTP_ASNH_DEFAULT_SUBJECT_557", 557);

    /**
     * An error occurred while attempting to send an account status notification message for notification type %s for user entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SMTP_ASNH_CANNOT_SEND_MESSAGE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SMTP_ASNH_CANNOT_SEND_MESSAGE_558", 558);

    /**
     * An error occurred while trying to encrypt a value using password storage scheme %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWSCHEME_CANNOT_ENCRYPT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_CANNOT_ENCRYPT_559", 559);

    /**
     * An error occurred while trying to decrypt a value using password storage scheme %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWSCHEME_CANNOT_DECRYPT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_CANNOT_DECRYPT_560", 560);

    /**
     * Cannot decode the provided symmetric key extended operation because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_GET_SYMMETRIC_KEY_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "ERR_GET_SYMMETRIC_KEY_NO_VALUE_561", 561);

    /**
     * Cannot decode the provided symmetric key extended request: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GET_SYMMETRIC_KEY_ASN1_DECODE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_GET_SYMMETRIC_KEY_ASN1_DECODE_EXCEPTION_563", 563);

    /**
     * An unexpected error occurred while attempting to decode the symmetric key extended request sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GET_SYMMETRIC_KEY_DECODE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_GET_SYMMETRIC_KEY_DECODE_EXCEPTION_564", 564);

    /**
     * The exact match identity mapper defined in configuration entry %s references attribute type %s which is does not have an equality index defined in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_EXACTMAP_ATTR_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_EXACTMAP_ATTR_UNINDEXED_565", 565);

    /**
     * The regular expression identity mapper defined in configuration entry %s references attribute type %s which is does not have an equality index defined in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REGEXMAP_ATTR_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_REGEXMAP_ATTR_UNINDEXED_566", 566);

    /**
     * The subject attribute to user attribute certificate mapper defined in configuration entry %s references attribute type %s which is does not have an equality index defined in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_SATUACM_ATTR_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "WARN_SATUACM_ATTR_UNINDEXED_568", 568);

    /**
     * Loaded extension from file '%s' (build %s, revision %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_LOG_EXTENSION_INFORMATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "NOTE_LOG_EXTENSION_INFORMATION_571", 571);

    /**
     * Failed to create a SASL server for SASL mechanism %s using a server FQDN of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_CREATE_SASL_SERVER_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_CREATE_SASL_SERVER_FAILED_572", 572);

    /**
     * GSSAPI SASL mechanism handler initalization failed because the keytab file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_GSSAPI_KEYTAB_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_GSSAPI_KEYTAB_INVALID_573", 573);

    /**
     * The GSSAPI SASL mechanism handler initialization was successful
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GSSAPI_STARTED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "INFO_GSSAPI_STARTED_574", 574);

    /**
     * The GSSAPI SASL mechanism handler has been stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GSSAPI_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(ExtensionMessages.class, RESOURCE, "INFO_GSSAPI_STOPPED_575", 575);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COLLECTIVEATTRIBUTESUBENTRIES_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_COLLECTIVEATTRIBUTESUBENTRIES_VATTR_NOT_SEARCHABLE_576", 576);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PASSWORDPOLICYSUBENTRY_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PASSWORDPOLICYSUBENTRY_VATTR_NOT_SEARCHABLE_577", 577);

    /**
     * The password value %s has been base64-decoded but is too short to be valid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWSCHEME_INVALID_BASE64_DECODED_STORED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_INVALID_BASE64_DECODED_STORED_PASSWORD_578", 578);

    /**
     * The provided minimum required number of character sets '%d' is invalid because it must at least include all mandatory character sets
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CHARSET_VALIDATOR_MIN_CHAR_SETS_TOO_SMALL =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_MIN_CHAR_SETS_TOO_SMALL_579", 579);

    /**
     * The provided minimum required number of character sets '%d' is invalid because it is greater than the total number of defined character sets
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CHARSET_VALIDATOR_MIN_CHAR_SETS_TOO_BIG =
                    new LocalizableMessageDescriptor.Arg1<Number>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_MIN_CHAR_SETS_TOO_BIG_580", 580);

    /**
     * The provided password did not contain characters from at least %d of the following character sets or ranges: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_CHARSET_VALIDATOR_TOO_FEW_OPTIONAL_CHAR_SETS =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_TOO_FEW_OPTIONAL_CHAR_SETS_581", 581);

    /**
     * An error occurred while attempting to decode member's DN %s of static group %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STATICMEMBERS_CANNOT_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_STATICMEMBERS_CANNOT_DECODE_DN_582", 582);

    /**
     * SASL %s authentication is not supported for user %s because the account is not managed locally
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_ACCOUNT_NOT_LOCAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SASL_ACCOUNT_NOT_LOCAL_583", 583);

    /**
     * Password modification is not supported for user %s because the account is not managed locally
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_ACCOUNT_NOT_LOCAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_ACCOUNT_NOT_LOCAL_584", 584);

    /**
     * The password policy state extended operation is not supported for user %s because the account is not managed locally
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PWPSTATE_ACCOUNT_NOT_LOCAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_EXTOP_PWPSTATE_ACCOUNT_NOT_LOCAL_585", 585);

    /**
     * The user "%s" could not be authenticated using LDAP PTA policy "%s" because the following mapping attributes were not found in the user's entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_PTA_MAPPING_ATTRIBUTE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_MAPPING_ATTRIBUTE_NOT_FOUND_586", 586);

    /**
     * The user "%s" could not be authenticated using LDAP PTA policy "%s" because the search of base DN "%s" returned more than one entry matching the filter "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_LDAP_PTA_MAPPED_SEARCH_TOO_MANY_CANDIDATES =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_MAPPED_SEARCH_TOO_MANY_CANDIDATES_587", 587);

    /**
     * The user "%s" could not be authenticated using LDAP PTA policy "%s" because the search did not return any entries matching the filter "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_PTA_MAPPED_SEARCH_NO_CANDIDATES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_MAPPED_SEARCH_NO_CANDIDATES_588", 588);

    /**
     * The user "%s" could not be authenticated using LDAP PTA policy "%s" because the search failed unexpectedly for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_PTA_MAPPED_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_MAPPED_SEARCH_FAILED_589", 589);

    /**
     * The user "%s" could not be authenticated using LDAP PTA policy "%s" because the bind failed unexpectedly for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_PTA_MAPPED_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_MAPPED_BIND_FAILED_590", 590);

    /**
     * A connection could not be established to the remote LDAP server at %s:%d for LDAP PTA policy "%s" because the host name "%s" could not be resolved to an IP address
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECT_UNKNOWN_HOST =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECT_UNKNOWN_HOST_591", 591);

    /**
     * A connection could not be established to the remote LDAP server at %s:%d for LDAP PTA policy "%s" because the connection was refused. This may indicate that the server is either offline or it is not listening on port %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Number> ERR_LDAP_PTA_CONNECT_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Number>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECT_ERROR_592", 592);

    /**
     * A connection could not be established to the remote LDAP server at %s:%d for LDAP PTA policy "%s" because the connection attempt timed out. This may indicate that the server is slow to respond, the network is slow, or that there is some other network problem
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDAP_PTA_CONNECT_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECT_TIMEOUT_593", 593);

    /**
     * A connection could not be established to the remote LDAP server at %s:%d for LDAP PTA policy "%s" because SSL negotiation failed for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECT_SSL_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECT_SSL_ERROR_594", 594);

    /**
     * A connection could not be established to the remote LDAP server at %s:%d for LDAP PTA policy "%s" because an unexpected error occurred: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECT_OTHER_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECT_OTHER_ERROR_595", 595);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has failed unexpectedly: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_OTHER_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_OTHER_ERROR_596", 596);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has been closed unexpectedly
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDAP_PTA_CONNECTION_CLOSED =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_CLOSED_597", 597);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has timed out and will be closed. This may indicate that the server is slow to respond, the network is slow, or that there is some other network problem
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDAP_PTA_CONNECTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_TIMEOUT_598", 598);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has encountered a protocol error while decoding a response from the server and will be closed. The decoding error was: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_DECODE_ERROR_599", 599);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has received an unexpected response from the server and will be closed. The unexpected response message was: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_WRONG_RESPONSE =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_WRONG_RESPONSE_600", 600);

    /**
     * The connection to the remote LDAP server at %s:%d for LDAP PTA policy "%s" has received a disconnect notification with response code %d (%s) and error message "%s"
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Number, Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_DISCONNECTING =
                    new LocalizableMessageDescriptor.Arg6<Object, Number, Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_DISCONNECTING_601", 601);

    /**
     * The remote LDAP server at %s:%d for LDAP PTA policy "%s" has failed to authenticate user "%s", returning the response code %d (%s) and error message "%s"
     */
    public static final LocalizableMessageDescriptor.Arg7<Object, Number, Object, Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg7<Object, Number, Object, Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_BIND_FAILED_602", 602);

    /**
     * The remote LDAP server at %s:%d for LDAP PTA policy "%s" returned multiple matching entries while searching "%s" using the filter "%s"
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object> ERR_LDAP_PTA_CONNECTION_SEARCH_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_SEARCH_SIZE_LIMIT_603", 603);

    /**
     * The remote LDAP server at %s:%d for LDAP PTA policy "%s" did not return any matching entries while searching "%s" using the filter "%s"
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object> ERR_LDAP_PTA_CONNECTION_SEARCH_NO_MATCHES =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_SEARCH_NO_MATCHES_604", 604);

    /**
     * The remote LDAP server at %s:%d for LDAP PTA policy "%s" returned an error while searching "%s" using the filter "%s": response code %d (%s) and error message "%s"
     */
    public static final LocalizableMessageDescriptor.Arg8<Object, Number, Object, Object, Object, Number, Object, Object> ERR_LDAP_PTA_CONNECTION_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg8<Object, Number, Object, Object, Object, Number, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_CONNECTION_SEARCH_FAILED_605", 605);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the remote LDAP server address "%s" specifies a port number which is invalid. Port numbers should be greater than 0 and less than 65536
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PTA_INVALID_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_INVALID_PORT_NUMBER_606", 606);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the Java property %s which should contain the mapped search bind password is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PTA_PWD_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_PWD_PROPERTY_NOT_SET_607", 607);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the environment variable %s which should contain the mapped search bind password is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PTA_PWD_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_PWD_ENVAR_NOT_SET_608", 608);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the file %s which should contain the mapped search bind password does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PTA_PWD_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_PWD_NO_SUCH_FILE_609", 609);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the file %s which should contain the mapped search bind password cannot be read for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_PTA_PWD_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_PWD_FILE_CANNOT_READ_610", 610);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because the file %s which should contain the mapped search bind password is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PTA_PWD_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_PWD_FILE_EMPTY_611", 611);

    /**
     * The configuration of LDAP PTA policy "%s" is invalid because it does not specify the a means for obtaining the mapped search bind password
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PTA_NO_PWD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_NO_PWD_613", 613);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ETAG_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_ETAG_VATTR_NOT_SEARCHABLE_614", 614);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWDEXPTIME_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWDEXPTIME_VATTR_NOT_SEARCHABLE_615", 615);

    /**
     * The certificate with subject %s mapped to multiple users
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SATUACM_MULTIPLE_SEARCH_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_MULTIPLE_SEARCH_MATCHING_ENTRIES_616", 616);

    /**
     * The internal search based on the certificate with subject %s could not be processed efficiently: %s. Check the server configuration to ensure that all associated backends are properly configured for these types of searches
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_INEFFICIENT_SEARCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_INEFFICIENT_SEARCH_617", 617);

    /**
     * An internal failure occurred while attempting to map the certificate with subject %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SATUACM_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SATUACM_SEARCH_FAILED_618", 618);

    /**
     * The certificate with subject %s mapped to multiple users
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SDTUACM_MULTIPLE_SEARCH_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_MULTIPLE_SEARCH_MATCHING_ENTRIES_619", 619);

    /**
     * The internal search based on the certificate with subject %s could not be processed efficiently: %s. Check the server configuration to ensure that all associated backends are properly configured for these types of searches
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SDTUACM_INEFFICIENT_SEARCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_INEFFICIENT_SEARCH_620", 620);

    /**
     * An internal failure occurred while attempting to map the certificate with subject %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SDTUACM_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_SDTUACM_SEARCH_FAILED_621", 621);

    /**
     * The certificate with fingerprint %s mapped to multiple users
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FCM_MULTIPLE_SEARCH_MATCHING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_MULTIPLE_SEARCH_MATCHING_ENTRIES_622", 622);

    /**
     * The internal search based on the certificate with fingerprint %s could not be processed efficiently: %s. Check the server configuration to ensure that all associated backends are properly configured for these types of searches
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FCM_INEFFICIENT_SEARCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_INEFFICIENT_SEARCH_623", 623);

    /**
     * An internal failure occurred while attempting to map the certificate with fingerprint %s to a user entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FCM_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_FCM_SEARCH_FAILED_624", 624);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FIRSTCHANGENUMBER_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_FIRSTCHANGENUMBER_VATTR_NOT_SEARCHABLE_625", 625);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LASTCHANGENUMBER_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_LASTCHANGENUMBER_VATTR_NOT_SEARCHABLE_626", 626);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LASTCOOKIE_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_LASTCOOKIE_VATTR_NOT_SEARCHABLE_627", 627);

    /**
     * The %s attribute is not searchable and should not be included in otherwise unindexed search filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOGBASEDN_VATTR_NOT_SEARCHABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHANGELOGBASEDN_VATTR_NOT_SEARCHABLE_628", 628);

    /**
     * The provided password did not contain enough characters from the character range '%s'. The minimum number of characters from that range that must be present in user passwords is %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHARSET_VALIDATOR_TOO_FEW_CHARS_FROM_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_TOO_FEW_CHARS_FROM_RANGE_629", 629);

    /**
     * The provided character range definition '%s' is invalid because it does not contain a colon to separate the minimum count from the character range
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_NO_RANGE_COLON =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_NO_RANGE_COLON_630", 630);

    /**
     * The provided character range definition '%s' is invalid because it does not contain a colon to separate the minimum count from the character range
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_NO_RANGE_CHARS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_NO_RANGE_CHARS_631", 631);

    /**
     * The provided character range definition '%s' is invalid because the value before the colon must be an integer greater or equal to zero
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_VALIDATOR_INVALID_RANGE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_INVALID_RANGE_COUNT_632", 632);

    /**
     * The provided character range definition '%s' is invalid because the range '%s' is reversed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHARSET_VALIDATOR_UNSORTED_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_UNSORTED_RANGE_633", 633);

    /**
     * The provided character range definition '%s' is invalid because the range '%s' is missing the minus
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHARSET_VALIDATOR_MALFORMED_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_MALFORMED_RANGE_634", 634);

    /**
     * The provided character range definition '%s' is invalid because the range '%s' is too short
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHARSET_VALIDATOR_SHORT_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_CHARSET_VALIDATOR_SHORT_RANGE_635", 635);

    /**
     * There is no private key entry in keystore %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_KEY_ENTRY_IN_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_NO_KEY_ENTRY_IN_KEYSTORE_636", 636);

    /**
     * Handshake for '%s': cipher requires the alias(es) '%s' to contain key(s) of type(s) '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_MISSING_KEY_TYPE_IN_ALIASES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "INFO_MISSING_KEY_TYPE_IN_ALIASES_637", 637);

    /**
     * An error occurred while attempting to match a bcrypt hashed password value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWSCHEME_INVALID_STORED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_PWSCHEME_INVALID_STORED_PASSWORD_638", 638);

    /**
     * The mapped search filter template "%s" could not be parsed as a valid LDAP filter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PTA_INVALID_FILTER_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_PTA_INVALID_FILTER_TEMPLATE_639", 639);

    /**
     * An error occurred while trying to create a key manager factory to access the contents of LDAP keystore with base DN '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_KEYMANAGER_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_CANNOT_CREATE_FACTORY_640", 640);

    /**
     * An error occurred while trying to create a trust manager factory to access the contents of LDAP keystore with base DN '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_TRUSTMANAGER_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_CANNOT_CREATE_FACTORY_641", 641);

    /**
     * Java property %s which is specified in attribute ds-cfg-key-store-pin-property of configuration entry %s should contain the PIN needed to access the LDAP key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_KEYMANAGER_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_PIN_PROPERTY_NOT_SET_642", 642);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-key-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the LDAP key manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_KEYMANAGER_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_PIN_ENVAR_NOT_SET_643", 643);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the LDAP key manager, but this file does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_KEYMANAGER_PIN_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_PIN_NO_SUCH_FILE_644", 644);

    /**
     * An error occurred while trying to read the keystore PIN from file %s specified in configuration attribute ds-cfg-key-store-pin-file of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_KEYMANAGER_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_PIN_FILE_CANNOT_READ_645", 645);

    /**
     * File %s specified in attribute ds-cfg-key-store-pin-file of configuration entry %s should contain the PIN needed to access the LDAP key manager, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_KEYMANAGER_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_KEYMANAGER_PIN_FILE_EMPTY_646", 646);

    /**
     * Java property %s which is specified in attribute ds-cfg-trust-store-pin-property of configuration entry %s should contain the PIN needed to access the LDAP trust manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_TRUSTMANAGER_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_PIN_PROPERTY_NOT_SET_647", 647);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-trust-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the LDAP trust manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_TRUSTMANAGER_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_PIN_ENVAR_NOT_SET_648", 648);

    /**
     * File %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s should contain the PIN needed to access the LDAP trust manager, but this file does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_TRUSTMANAGER_PIN_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_PIN_NO_SUCH_FILE_649", 649);

    /**
     * An error occurred while trying to read the trust store PIN from file %s specified in configuration attribute ds-cfg-trust-store-pin-file of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDAP_TRUSTMANAGER_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_PIN_FILE_CANNOT_READ_650", 650);

    /**
     * File %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s should contain the PIN needed to access the LDAP trust manager, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_TRUSTMANAGER_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExtensionMessages.class, RESOURCE, "ERR_LDAP_TRUSTMANAGER_PIN_FILE_EMPTY_651", 651);

}
