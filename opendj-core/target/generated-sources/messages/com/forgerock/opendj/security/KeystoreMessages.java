package com.forgerock.opendj.security;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.security.keystore}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/security/keystore.properties} and it should not be manually edited.
 */
public final class KeystoreMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.security.keystore";

    // Prevent instantiation.
    private KeystoreMessages() {
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
     * The key cannot be decoded because it contained invalid padding after being decrypted
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_DECODE_BAD_PADDING =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_BAD_PADDING", -1);

    /**
     * The key cannot be decrypted using the provided global key store password and/or key password. The password(s) are probably incorrect
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_DECODE_KEYSTORE_DECRYPT_FAILURE =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_KEYSTORE_DECRYPT_FAILURE", -1);

    /**
     * The key cannot be decoded because it has been protected with an external global key store protection mechanism, but no mechanism has been configured
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_DECODE_KEY_MISSING_KEYSTORE_EXT =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_KEY_MISSING_KEYSTORE_EXT", -1);

    /**
     * The key cannot be decoded because it has been protected with a global key store password and/or key password, but neither have been provided
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_DECODE_KEY_MISSING_PWD =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_KEY_MISSING_PWD", -1);

    /**
     * The key cannot be decoded because it is malformed
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_DECODE_MALFORMED =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_MALFORMED", -1);

    /**
     * The key cannot be decoded because its encoding version %d is not supported
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> KEYSTORE_DECODE_UNSUPPORTED_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(KeystoreMessages.class, RESOURCE, "KEYSTORE_DECODE_UNSUPPORTED_VERSION", -1);

    /**
     * An unexpected error occurred while attempting to remove the key store entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_DELETE_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_DELETE_FAILURE", -1);

    /**
     * The key store entry '%s' could not be parsed because it contains missing or malformed attributes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_ENTRY_MALFORMED =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_ENTRY_MALFORMED", -1);

    /**
     * The trusted certificate '%s' could not be added to the key store because there is already a private or secret key entry with the same alias
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_KEY_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_KEY_ENTRY_ALREADY_EXISTS", -1);

    /**
     * An unexpected error occurred while attempting to read the key store entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_READ_ALIAS_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_READ_ALIAS_FAILURE", -1);

    /**
     * An unexpected error occurred while accessing the key store
     */
    public static final LocalizableMessageDescriptor.Arg0 KEYSTORE_READ_FAILURE =
                    new LocalizableMessageDescriptor.Arg0(KeystoreMessages.class, RESOURCE, "KEYSTORE_READ_FAILURE", -1);

    /**
     * The key store entry '%s' could not be parsed because it does not contain a recognized object class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_UNRECOGNIZED_OBJECT_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_UNRECOGNIZED_OBJECT_CLASS", -1);

    /**
     * The key could not be encrypted or decrypted because the JVM does not support the '%s' cipher
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_UNSUPPORTED_CIPHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_UNSUPPORTED_CIPHER", -1);

    /**
     * The key could not be encrypted or decrypted because the JVM does not support the '%s' algorithm
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_UNSUPPORTED_KF =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_UNSUPPORTED_KF", -1);

    /**
     * The key could not be encrypted or decrypted because the JVM does not support '%s' with %d iterations and %d bits
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> KEYSTORE_UNSUPPORTED_KF_ARGS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(KeystoreMessages.class, RESOURCE, "KEYSTORE_UNSUPPORTED_KF_ARGS", -1);

    /**
     * An unexpected error occurred while attempting to update the key store entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> KEYSTORE_UPDATE_ALIAS_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(KeystoreMessages.class, RESOURCE, "KEYSTORE_UPDATE_ALIAS_FAILURE", -1);

}
