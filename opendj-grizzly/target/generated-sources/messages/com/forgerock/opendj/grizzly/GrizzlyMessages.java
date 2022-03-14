package com.forgerock.opendj.grizzly;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.grizzly.grizzly}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/grizzly/grizzly.properties} and it should not be manually edited.
 */
public final class GrizzlyMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.grizzly.grizzly";

    // Prevent instantiation.
    private GrizzlyMessages() {
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
     * The LDAP connection has failed because no bind or StartTLS response was received from the server within the %d ms timeout
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> LDAP_CONNECTION_BIND_OR_START_TLS_CONNECTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Number>(GrizzlyMessages.class, RESOURCE, "LDAP_CONNECTION_BIND_OR_START_TLS_CONNECTION_TIMEOUT", -1);

    /**
     * The bind or StartTLS request has failed because no response was received from the server within the %d ms timeout. The LDAP connection is now in an invalid state and can no longer be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> LDAP_CONNECTION_BIND_OR_START_TLS_REQUEST_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Number>(GrizzlyMessages.class, RESOURCE, "LDAP_CONNECTION_BIND_OR_START_TLS_REQUEST_TIMEOUT", -1);

    /**
     * The connection attempt to server %s has failed because the connection timeout period of %d ms was exceeded
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> LDAP_CONNECTION_CONNECT_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(GrizzlyMessages.class, RESOURCE, "LDAP_CONNECTION_CONNECT_TIMEOUT", -1);

    /**
     * The request has failed because no response was received from the server within the %d ms timeout
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> LDAP_CONNECTION_REQUEST_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Number>(GrizzlyMessages.class, RESOURCE, "LDAP_CONNECTION_REQUEST_TIMEOUT", -1);

}
