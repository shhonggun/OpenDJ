package org.forgerock.openidm.accountchange;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.forgerock.openidm.accountchange.openidm-account-status-notification-handler}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/forgerock/openidm/accountchange/openidm-account-status-notification-handler.properties} and it should not be manually edited.
 */
public final class OpenidmAccountStatusNotificationHandlerMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.forgerock.openidm.accountchange.openidm-account-status-notification-handler";

    // Prevent instantiation.
    private OpenidmAccountStatusNotificationHandlerMessages() {
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
     * An error occurred during OpenIDM Password Sync plugin initialization because log file creation failed : could not create directory %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_LOGFILE_UNABLE_TO_CREATE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_LOGFILE_UNABLE_TO_CREATE_DIRECTORY_1", 1);

    /**
     * The file name that the OpenIDM Password Sync plugin logs changes has been changed from %s to %s, but this change will not take effect until the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_OPENIDM_PWSYNC_LOGFILE_CHANGE_REQUIRES_RESTART =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "INFO_OPENIDM_PWSYNC_LOGFILE_CHANGE_REQUIRES_RESTART_2", 2);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because the url '%s' is not a valid OpenIDM-URL: %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OPENIDM_PWSYNC_MALFORMEDURLEXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_MALFORMEDURLEXCEPTION_3", 3);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because the ssl-cert-nickname '%s' is not found in provided keystore.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_INVALID_CLIENT_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_INVALID_CLIENT_CERT_NICKNAME_4", 4);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because the certificate-subject-dn '%s' is not found in provided truststore.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_INVALID_SERVERKEYALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_INVALID_SERVERKEYALIAS_5", 5);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because a key manager is required for SSL client authentication, but no key manager was provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OPENIDM_PWSYNC_NO_KEYMANAGER_PROVIDER =
                    new LocalizableMessageDescriptor.Arg0(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_NO_KEYMANAGER_PROVIDER_6", 6);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because the trust-manager-provider: '%s' does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_INVALID_TRUSTMANAGERPROVIDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_INVALID_TRUSTMANAGERPROVIDER_7", 7);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization: %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_INITIALIZATIONEXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_INITIALIZATIONEXCEPTION_8", 8);

    /**
     * The update interval of the OpenIDM Password Sync plugin executes the background thread has been changed from %s to %s, but this change will not take effect until the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_OPENIDM_PWSYNC_UPDATE_INTERVAL_CHANGE_REQUIRES_RESTART =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "INFO_OPENIDM_PWSYNC_UPDATE_INTERVAL_CHANGE_REQUIRES_RESTART_9", 9);

    /**
     * Unable to send password update request because Client can not authorise.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OPENIDM_PWSYNC_UNAUTHORISED_REQUEST =
                    new LocalizableMessageDescriptor.Arg0(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_UNAUTHORISED_REQUEST_10", 10);

    /**
     * Unable to send password update request because unexpected error happend. Return status code: %s, Error message: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OPENIDM_PWSYNC_UNEXPECTED_RETURN_STATUS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_UNEXPECTED_RETURN_STATUS_11", 11);

    /**
     * Authentication to OpenIDM requires either ssl-cert-nickname to be set or openidm-user and openidm-password to be set but neither were set. For SSL client authentication, ssl-cert-nickname must be provided. For basic authentication, openidm-user and openidm-password must be provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OPENIDM_PWSYNC_INVALID_AUTHENTICATION_CONFIG =
                    new LocalizableMessageDescriptor.Arg0(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_INVALID_AUTHENTICATION_CONFIG_12", 12);

    /**
     * An error occurred during OpenIDM Password Sync plugin initialization because log file creation failed:  %s exists and is not a directory.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPENIDM_PWSYNC_LOGFILE_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(OpenidmAccountStatusNotificationHandlerMessages.class, RESOURCE, "ERR_OPENIDM_PWSYNC_LOGFILE_ALREADY_EXISTS_14", 14);

}
