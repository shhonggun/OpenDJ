package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.quickSetup}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/quickSetup.properties} and it should not be manually edited.
 */
public final class QuickSetupMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.quickSetup";

    // Prevent instantiation.
    private QuickSetupMessages() {
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
     * The following administrators are defined in server %s but not in server %s:%n%s%nThe merge can only be performed if these administrators are defined in server %s.
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ADS_ADMINISTRATOR_MERGE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "ERR_ADS_ADMINISTRATOR_MERGE", -1);

    /**
     * The registration information of server %s and server %s could not be merged. Reasons:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ADS_MERGE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "ERR_ADS_MERGE", -1);

    /**
     * The provided credentials are not valid. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CONNECT_TO_LOCAL_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_LOCAL_AUTHENTICATION", -1);

    /**
     * Could not connect to the server. Check that the server is running. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CONNECT_TO_LOCAL_COMMUNICATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_LOCAL_COMMUNICATION", -1);

    /**
     * Could not connect to the server. Check that the server is running and that the provided credentials are valid.%nError details:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CONNECT_TO_LOCAL_GENERIC =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_LOCAL_GENERIC", -1);

    /**
     * You do not have enough access rights to read the configuration in the server. %nProvide credentials with enough rights. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CONNECT_TO_LOCAL_PERMISSIONS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_LOCAL_PERMISSIONS", -1);

    /**
     * Could not find a remote peer to initialize the contents of local base DN: %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COULD_NOT_FIND_REPLICATIONID =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_COULD_NOT_FIND_REPLICATIONID", -1);

    /**
     * Error updating scripts with java properties. Error code: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ERROR_CREATING_JAVA_HOME_SCRIPTS =
                    new LocalizableMessageDescriptor.Arg1<Number>(QuickSetupMessages.class, RESOURCE, "ERR_ERROR_CREATING_JAVA_HOME_SCRIPTS", -1);

    /**
     * Could not use the arguments '%s' using the running Java virtual machine. Check that the Java virtual machine supports this argument.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GENERIC_JAVA_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_GENERIC_JAVA_ARGUMENT", -1);

    /**
     * The initial memory value must be a positive integer.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INITIAL_MEMORY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "ERR_INITIAL_MEMORY_VALUE", -1);

    /**
     * Could not use the provided initial memory value. Check that the running Java virtual machine supports the %s argument and that there is enough memory in the machine to use the provided value.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INITIAL_MEMORY_VALUE_EXTENDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_INITIAL_MEMORY_VALUE_EXTENDED", -1);

    /**
     * The maximum memory value must be higher than the initial memory value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MAX_MEMORY_BIGGER_THAN_INITIAL_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "ERR_MAX_MEMORY_BIGGER_THAN_INITIAL_MEMORY", -1);

    /**
     * The maximum memory value must be a positive integer.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MAX_MEMORY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "ERR_MAX_MEMORY_VALUE", -1);

    /**
     * Could not use the provided maximum memory value. Check that the running Java virtual machine supports the %s argument and that there is enough memory in the machine to use the provided value.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MAX_MEMORY_VALUE_EXTENDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "ERR_MAX_MEMORY_VALUE_EXTENDED", -1);

    /**
     * Note that 32-bit Java virtual machines do not support memory values higher than 2 gigabytes.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MEMORY_32_BIT_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "ERR_MEMORY_32_BIT_LIMIT", -1);

    /**
     * The provided memory arguments and the 'Other Java Arguments' were checked successfully separately. However there was an error running them simultaneously. Check that the provided arguments are compatible with the memory values.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MEMORY_AND_OTHER_ARGUMENTS_NOT_COMPATIBLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "ERR_MEMORY_AND_OTHER_ARGUMENTS_NOT_COMPATIBLE", -1);

    /**
     * Could not use the provided memory values. Check that the running Java virtual machine supports the %s and %s arguments and that there is enough memory in the machine to use the provided values.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MEMORY_VALUE_EXTENDED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "ERR_MEMORY_VALUE_EXTENDED", -1);

    /**
     * Java arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ADDITIONAL_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ADDITIONAL_ARGUMENTS", -1);

    /**
     * Administrator already registered.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINISTRATOR_ALREADY_REGISTERED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ADMINISTRATOR_ALREADY_REGISTERED", -1);

    /**
     * Administration Connector Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMIN_CONNECTOR_PORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ADMIN_CONNECTOR_PORT_LABEL", -1);

    /**
     * Enter the port number that the administration connector will use.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMIN_CONNECTOR_PORT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ADMIN_CONNECTOR_PORT_TOOLTIP", -1);

    /**
     * You must specify different ports for the Administration Connector Port and the other listeners.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMIN_CONNECTOR_VALUE_SEVERAL_TIMES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ADMIN_CONNECTOR_VALUE_SEVERAL_TIMES", -1);

    /**
     * Registration information error. Error type: '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ADS_CONTEXT_EXCEPTION_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ADS_CONTEXT_EXCEPTION_MSG", -1);

    /**
     * Registration information error. Error type: '%s'. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ADS_CONTEXT_EXCEPTION_WITH_DETAILS_MSG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ADS_CONTEXT_EXCEPTION_WITH_DETAILS_MSG", -1);

    /**
     * An unexpected error occurred managing the registration information.%nThe error is: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ADS_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ADS_EXCEPTION", -1);

    /**
     * Considering the number of entries that will be automatically generated and imported to the server, the default runtime settings might not be enough to be able to manage that volume of data. It is recommended to increase the maximum memory allowed for both the server runtime and the import.<br><br>Check the documentation for more information about how to tune the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_AUTOMATICALLY_GENERATED_DATA_WARNING_UPDATE_RUNTIME_ARGS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_AUTOMATICALLY_GENERATED_DATA_WARNING_UPDATE_RUNTIME_ARGS", -1);

    /**
     * Backend Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKEND_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BACKEND_TYPE_LABEL", -1);

    /**
     * images/opendjbackground.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKGROUND_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BACKGROUND_ICON", -1);

    /**
     * QuickSetup.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKGROUND_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BACKGROUND_ICON_DESCRIPTION", -1);

    /**
     * QuickSetup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKGROUND_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BACKGROUND_ICON_TOOLTIP", -1);

    /**
     * The provided Directory Base DN is used for storing the server configuration data. You must specify a different DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE_DN_IS_CONFIGURATION_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BASE_DN_IS_CONFIGURATION_DN", -1);

    /**
     * Directory Base DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BASE_DN_LABEL", -1);

    /**
     * Enter the DN of the top entry where your data will be stored
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE_DN_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BASE_DN_TOOLTIP", -1);

    /**
     * Browse...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BROWSE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BROWSE_BUTTON_LABEL", -1);

    /**
     * Click to display a file system browser
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BROWSE_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BROWSE_BUTTON_TOOLTIP", -1);

    /**
     * An unexpected error occurred.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BUG_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_BUG_MSG", -1);

    /**
     * Cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCEL_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANCEL_BUTTON_LABEL", -1);

    /**
     * Cancel the currently running operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCEL_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANCEL_BUTTON_TOOLTIP", -1);

    /**
     * Cannot bind to port %s.%n%nThe port could be already in use by another application or maybe you do not have the rights to access it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CANNOT_BIND_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_BIND_PORT", -1);

    /**
     * Cannot bind to privileged port %s.%n%nThe port could be already in use by another application or maybe you do not have the rights to access it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CANNOT_BIND_PRIVILEDGED_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_BIND_PRIVILEDGED_PORT", -1);

    /**
     * Could not connect to %s. Check that the server is running and that the provided credentials are valid.%nError details:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CANNOT_CONNECT_TO_REMOTE_GENERIC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_CONNECT_TO_REMOTE_GENERIC", -1);

    /**
     * Disabled. A valid keytool command could not be found.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANNOT_UPDATE_SECURITY_WARNING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_UPDATE_SECURITY_WARNING", -1);

    /**
     * Could not use 4444. Port in use or user not authorized.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANNOT_USE_DEFAULT_ADMIN_CONNECTOR_PORT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_USE_DEFAULT_ADMIN_CONNECTOR_PORT", -1);

    /**
     * Could not use 389. Port in use or user not authorized.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANNOT_USE_DEFAULT_PORT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_USE_DEFAULT_PORT", -1);

    /**
     * Could not use 636. Port in use or user not authorized.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANNOT_USE_DEFAULT_SECURE_PORT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CANNOT_USE_DEFAULT_SECURE_PORT", -1);

    /**
     * To view the details of a given certificate select it.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_CHAIN_COMBO_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_CHAIN_COMBO_TOOLTIP", -1);

    /**
     * Certificate Chain:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_CHAIN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_CHAIN_LABEL", -1);

    /**
     * Accept for this Session
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_ACCEPT_FOR_SESSION_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_ACCEPT_FOR_SESSION_BUTTON_LABEL", -1);

    /**
     * Close this dialog and accept the certificate only for this session.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_ACCEPT_FOR_SESSION_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_ACCEPT_FOR_SESSION_BUTTON_TOOLTIP", -1);

    /**
     * Accept permanently
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_ACCEPT_PERMANENTLY_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_ACCEPT_PERMANENTLY_BUTTON_LABEL", -1);

    /**
     * Close this dialog and accept the certificate permanently.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_ACCEPT_PERMANENTLY_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_ACCEPT_PERMANENTLY_BUTTON_TOOLTIP", -1);

    /**
     * Do not Accept
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_DO_NOT_ACCEPT_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_DO_NOT_ACCEPT_BUTTON_LABEL", -1);

    /**
     * Close this dialog and do not accept the certificate.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_DO_NOT_ACCEPT_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_DO_NOT_ACCEPT_BUTTON_TOOLTIP", -1);

    /**
     * Certificate Not Trusted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_DIALOG_TITLE", -1);

    /**
     * You must accept the certificate presented by %s:%s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CERTIFICATE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_EXCEPTION", -1);

    /**
     * %s - Expired
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CERTIFICATE_EXPIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_EXPIRED", -1);

    /**
     * Expires On:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_EXPIRES_ON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_EXPIRES_ON_LABEL", -1);

    /**
     * <br><br><a href="">Hide Certificate Details</a>
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_HIDE_DETAILS_TEXT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_HIDE_DETAILS_TEXT", -1);

    /**
     * Issued By:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_ISSUED_BY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_ISSUED_BY_LABEL", -1);

    /**
     * Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_LABEL", -1);

    /**
     * MD5 Fingerprint:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_MD5_FINGERPRINT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_MD5_FINGERPRINT_LABEL", -1);

    /**
     * The Certificate presented by the server %s:%s could not be trusted.<br><br>There is a name mismatch between the name of the server (%s) and the subject DN of the certificate.<br>This could be caused because you are connected to a server pretending to be %s:%s.<br><br>Before accepting this certificate, you should examine the server's certificate carefully.<br><br>Are you willing to accept this certificate for the purpose of identifying the server %s:%s?
     */
    public static final LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Object, Object, Object> INFO_CERTIFICATE_NAME_MISMATCH_TEXT =
                    new LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_NAME_MISMATCH_TEXT", -1);

    /**
     * The Certificate presented by the server %s:%s could not be trusted.
There is a name mismatch between the name of the server (%s) and the subject DN of the certificate. This could be caused because you are connected to a server pretending to be %s:%s.
Before accepting this certificate, you should examine the server's certificate carefully.
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> INFO_CERTIFICATE_NAME_MISMATCH_TEXT_CLI =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_NAME_MISMATCH_TEXT_CLI", -1);

    /**
     * The Certificate presented by the server %s:%s could not be trusted.<br><br>Possible reasons for this error:<br>&nbsp;&nbsp;&nbsp;&nbsp;-The Certificate Authority that issued the certificate is not recognized (this is the case of the self-signed certificates).<br>&nbsp;&nbsp;&nbsp;&nbsp;-The server's certificate is incomplete due to a misconfiguration.<br>&nbsp;&nbsp;&nbsp;&nbsp;-The server's certificate has expired.<br>&nbsp;&nbsp;&nbsp;&nbsp;-There is a time difference between the server machine clock and the local machine clock.<br>Before accepting this certificate, you should examine the server's certificate carefully.<br><br>Are you willing to accept this certificate for the purpose of identifying the server %s:%s?
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_CERTIFICATE_NOT_TRUSTED_TEXT =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_NOT_TRUSTED_TEXT", -1);

    /**
     * The Certificate presented by the server %s:%s could not be trusted.
Possible reasons for this error:
-The Certificate Authority that issued the certificate is not recognized (this is the case of the self-signed certificates).
-The server's certificate is incomplete due to a misconfiguration.
-The server's certificate has expired.
-There is a time difference between the server machine clock and the local machine clock.
Before accepting this certificate, you should examine the server's certificate carefully.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CERTIFICATE_NOT_TRUSTED_TEXT_CLI =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_NOT_TRUSTED_TEXT_CLI", -1);

    /**
     * %s - Not valid yet
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CERTIFICATE_NOT_VALID_YET =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_NOT_VALID_YET", -1);

    /**
     * Serial Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_SERIAL_NUMBER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_SERIAL_NUMBER_LABEL", -1);

    /**
     * SHA1 Fingerprint:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_SHA1_FINGERPRINT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_SHA1_FINGERPRINT_LABEL", -1);

    /**
     * <br><br><a href="">Show Certificate Details</a>
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_SHOW_DETAILS_TEXT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_SHOW_DETAILS_TEXT", -1);

    /**
     * Subject:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_SUBJECT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_SUBJECT_LABEL", -1);

    /**
     * Certificate Not Trusted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_TITLE", -1);

    /**
     * Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_TYPE_LABEL", -1);

    /**
     * Valid From:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CERTIFICATE_VALID_FROM_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CERTIFICATE_VALID_FROM_LABEL", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CHECKBOX_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CHECKBOX_COLOR", -1);

    /**
     * Close Setup Window
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLOSE_BUTTON_INSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CLOSE_BUTTON_INSTALL_TOOLTIP", -1);

    /**
     * Close
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLOSE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CLOSE_BUTTON_LABEL", -1);

    /**
     * Close Setup Window
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLOSE_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CLOSE_BUTTON_TOOLTIP", -1);

    /**
     * Close Progress Dialog
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLOSE_PROGRESS_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CLOSE_PROGRESS_BUTTON_TOOLTIP", -1);

    /**
     * 255,255,255
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COMBOBOX_BACKGROUND_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_COMBOBOX_BACKGROUND_COLOR", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRMATION_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRMATION_TITLE", -1);

    /**
     * Cancel the running operation?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CANCEL_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_CANCEL_PROMPT", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CANCEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_CANCEL_TITLE", -1);

    /**
     * QuickSetup has not yet completed.%nAre you sure you want to close the QuickSetup Window?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CLOSE_INSTALL_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_CLOSE_INSTALL_MSG", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CLOSE_INSTALL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_CLOSE_INSTALL_TITLE", -1);

    /**
     * Are you sure you want to quit QuickSetup?%nIf you click 'Yes' nothing will be installed on your system.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_QUIT_INSTALL_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_QUIT_INSTALL_MSG", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_QUIT_INSTALL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_QUIT_INSTALL_TITLE", -1);

    /**
     * Uninstall Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_STEP", -1);

    /**
     * Contacting server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONTACTING_SERVER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONTACTING_SERVER_LABEL", -1);

    /**
     * Continue with Setup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONTINUE_BUTTON_INSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONTINUE_BUTTON_INSTALL_TOOLTIP", -1);

    /**
     * Continue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONTINUE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CONTINUE_BUTTON_LABEL", -1);

    /**
     * An unexpected error occurred launching the Control Panel.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COULD_NOT_LAUNCH_CONTROL_PANEL_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_COULD_NOT_LAUNCH_CONTROL_PANEL_MSG", -1);

    /**
     * Only Create Base Entry (%s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CREATE_BASE_ENTRY_LABEL =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_CREATE_BASE_ENTRY_LABEL", -1);

    /**
     * Only create the top entry for the Directory Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATE_BASE_ENTRY_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CREATE_BASE_ENTRY_TOOLTIP", -1);

    /**
     * Global Administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATE_GLOBAL_ADMINISTRATOR_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CREATE_GLOBAL_ADMINISTRATOR_STEP", -1);

    /**
     * images/currentstep.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_STEP_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CURRENT_STEP_ICON", -1);

    /**
     * Current Step Indicator.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_STEP_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CURRENT_STEP_ICON_DESCRIPTION", -1);

    /**
     * Current Step Indicator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_STEP_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CURRENT_STEP_ICON_TOOLTIP", -1);

    /**
     * 255,255,255
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_STEP_PANEL_BACKGROUND_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_CURRENT_STEP_PANEL_BACKGROUND_COLOR", -1);

    /**
     * Choose options for the LDAP data to be hosted by the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_OPTIONS_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_OPTIONS_PANEL_INSTRUCTIONS", -1);

    /**
     * Directory Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_OPTIONS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_OPTIONS_PANEL_TITLE", -1);

    /**
     * Directory Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_OPTIONS_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_OPTIONS_STEP", -1);

    /**
     * Choose the Data Replication Options.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_REPLICATION_OPTIONS_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_REPLICATION_OPTIONS_PANEL_INSTRUCTIONS", -1);

    /**
     * Topology Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_REPLICATION_OPTIONS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_REPLICATION_OPTIONS_PANEL_TITLE", -1);

    /**
     * Topology Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_REPLICATION_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DATA_REPLICATION_STEP", -1);

    /**
     * 236,236,236
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DEFAULT_BACKGROUND_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DEFAULT_BACKGROUND_COLOR", -1);

    /**
     * Use Default
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DEFAULT_JAVA_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DEFAULT_JAVA_ARGUMENTS", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DEFAULT_LABEL_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DEFAULT_LABEL_COLOR", -1);

    /**
     * Directory Data:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIRECTORY_DATA_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIRECTORY_DATA_LABEL", -1);

    /**
     * The provided Root User DN is used for the configuration of the Directory Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIRECTORY_MANAGER_DN_IS_CONFIG_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIRECTORY_MANAGER_DN_IS_CONFIG_DN", -1);

    /**
     * 000000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_ERROR_BACKGROUND_1_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_ERROR_BACKGROUND_1_COLOR", -1);

    /**
     * FFFFCC
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_ERROR_BACKGROUND_2_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_ERROR_BACKGROUND_2_COLOR", -1);

    /**
     * E1E1A7
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_ERROR_BACKGROUND_3_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_ERROR_BACKGROUND_3_COLOR", -1);

    /**
     * 000000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_1_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_1_COLOR", -1);

    /**
     * FFFFCC
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_2_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_2_COLOR", -1);

    /**
     * E1E1A7
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_3_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_DIV_OPEN_SUCCESSFUL_BACKGROUND_3_COLOR", -1);

    /**
     * Before launching the command-lines described below, edit the file '%s' and add the following line:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDIT_JAVA_PROPERTIES_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_EDIT_JAVA_PROPERTIES_LINE", -1);

    /**
     * Before launching the command-lines described below, edit the file '%s' and add the following lines:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDIT_JAVA_PROPERTIES_LINES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_EDIT_JAVA_PROPERTIES_LINES", -1);

    /**
     * You must provide a Global Administrative User ID.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_ADMINISTRATOR_UID =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_ADMINISTRATOR_UID", -1);

    /**
     * You must provide an Root User DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_DIRECTORY_MANAGER_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_DIRECTORY_MANAGER_DN", -1);

    /**
     * You must provide the name of the host.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_HOST_NAME", -1);

    /**
     * You must provide the password of the Root User.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_PWD =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_PWD", -1);

    /**
     * You must provide a value for the Administrative User.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_REMOTE_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_REMOTE_DN", -1);

    /**
     * You must provide the fully qualified name of the host.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_REMOTE_HOST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_REMOTE_HOST", -1);

    /**
     * You must provide an Admin User password.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_REMOTE_PWD =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EMPTY_REMOTE_PWD", -1);

    /**
     * Enable SSL on LDAP Port %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ENABLE_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_SSL", -1);

    /**
     * Enable SSL on Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_SSL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_SSL_LABEL", -1);

    /**
     * Enables SSL on the specified port.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_SSL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_SSL_TOOLTIP", -1);

    /**
     * Enable StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_STARTTLS", -1);

    /**
     * Enable StartTLS for LDAP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_STARTTLS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_STARTTLS_LABEL", -1);

    /**
     * Allows encrypted communication over the standard LDAP port.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_STARTTLS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_STARTTLS_TOOLTIP", -1);

    /**
     * Run the server as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_WINDOWS_SERVICE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_WINDOWS_SERVICE_LABEL", -1);

    /**
     * Check this check box if you want the server to run as a Windows Service.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLE_WINDOWS_SERVICE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ENABLE_WINDOWS_SERVICE_TOOLTIP", -1);

    /**
     * You must specify different ports for LDAP and LDAPS communication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EQUAL_PORTS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EQUAL_PORTS", -1);

    /**
     * Could not access the JCEKS key store. Check that the running Java installation supports JCEKS, that the contents of the file correspond to a valid JCEKS key store, that you have access rights to it and that the provided PIN is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ACCESSING_JCEKS_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ACCESSING_JCEKS_KEYSTORE", -1);

    /**
     * Could not access the JKS key store. Check that the contents of the file correspond to a valid JKS key store, that you have access rights to it and that the provided PIN is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ACCESSING_JKS_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ACCESSING_JKS_KEYSTORE", -1);

    /**
     * Could not access the key store. This may be due to JDK issue JDK-6879539 which prevent use of empty password. This issue is fixed in JDK7/JDK8.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ACCESSING_KEYSTORE_JDK_BUG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ACCESSING_KEYSTORE_JDK_BUG", -1);

    /**
     * Could not access the PKCS#11 key store. Check that is installed and that the provided PIN is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ACCESSING_PKCS11_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ACCESSING_PKCS11_KEYSTORE", -1);

    /**
     * Could not access the PKCS#12 key store. Check that the contents of the file correspond to a valid PKCS#12 key store, that you have access rights to it and that the provided PIN is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ACCESSING_PKCS12_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ACCESSING_PKCS12_KEYSTORE", -1);

    /**
     * Close this window
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_BROWSER_CLOSE_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_BROWSER_CLOSE_BUTTON_TOOLTIP", -1);

    /**
     * Copy URL
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_BROWSER_COPY_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_BROWSER_COPY_BUTTON_LABEL", -1);

    /**
     * Copies the URL to the system clipboard
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_BROWSER_COPY_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_BROWSER_COPY_BUTTON_TOOLTIP", -1);

    /**
     * Could not launch the web browser.<br>You can copy and paste the following URL manually into your web browser:<br><span style="font-style:italic">%s</span>
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_BROWSER_DISPLAY_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_BROWSER_DISPLAY_MSG", -1);

    /**
     * Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_BROWSER_DISPLAY_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_BROWSER_DISPLAY_TITLE", -1);

    /**
     * Error Configuring Directory Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CONFIGURING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CONFIGURING", -1);

    /**
     * Error Configuring Certificates.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CONFIGURING_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CONFIGURING_CERTIFICATE", -1);

    /**
     * An unexpected error occurred configuring server %s.%nThe error is: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_CONFIGURING_REMOTE_GENERIC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CONFIGURING_REMOTE_GENERIC", -1);

    /**
     * The connection with the server timed out.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CONNECTING_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CONNECTING_TIMEOUT", -1);

    /**
     * An error occurred connecting to the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CONNECTING_TO_LOCAL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CONNECTING_TO_LOCAL", -1);

    /**
     * An unexpected error occurred extracting file %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_COPYING =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_COPYING", -1);

    /**
     * Error copying file %s to %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_COPYING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_COPYING_FILE", -1);

    /**
     * Error Creating Base Entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CREATING_BASE_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CREATING_BASE_ENTRY", -1);

    /**
     * Error determining the server build information.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CREATING_BUILD_INFO =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CREATING_BUILD_INFO", -1);

    /**
     * Error determining the server build information. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_CREATING_BUILD_INFO_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CREATING_BUILD_INFO_MSG", -1);

    /**
     * An error occurred creating the temporary file.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CREATING_TEMP_FILE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_CREATING_TEMP_FILE", -1);

    /**
     * Error deleting directory %s. Check that you have the rights to delete this directory and that there is no other application using it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_DELETING_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_DELETING_DIRECTORY", -1);

    /**
     * Error deleting file %s. Check that you have the rights to delete this file and that there is no other application using it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_DELETING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_DELETING_FILE", -1);

    /**
     * Error Disabling Windows service. Try to kill the process opendj_service.exe and then running the %s\bat\windows-service.bat -d command-line to disable the service manually.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_DISABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_DISABLING_WINDOWS_SERVICE", -1);

    /**
     * Error during the initialization with contents from server %s. Last log details: %s. Task state: %s. Check the error logs of %s for more information.
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_ERROR_DURING_INITIALIZATION_LOG =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_DURING_INITIALIZATION_LOG", -1);

    /**
     * Error during the initialization with contents from server %s. Task state: %s. Check the error logs of %s for more information.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_ERROR_DURING_INITIALIZATION_NO_LOG =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_DURING_INITIALIZATION_NO_LOG", -1);

    /**
     * Error Enabling Windows service.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ENABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ENABLING_WINDOWS_SERVICE", -1);

    /**
     * Failed to move file %s to %s. Make sure this file is not currently locked by another application.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_FAILED_MOVING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_FAILED_MOVING_FILE", -1);

    /**
     * images/error_small.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ICON", -1);

    /**
     * Error.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ICON_DESCRIPTION", -1);

    /**
     * Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ICON_TOOLTIP", -1);

    /**
     * Error Importing LDIF File.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_IMPORTING_LDIF =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_IMPORTING_LDIF", -1);

    /**
     * Error Importing Automatically-Generated Data when invoked with arguments %s: %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_IMPORT_AUTOMATICALLY_GENERATED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_IMPORT_AUTOMATICALLY_GENERATED", -1);

    /**
     * The import LDIF tool returned error code %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_IMPORT_LDIF_TOOL_RETURN_CODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_IMPORT_LDIF_TOOL_RETURN_CODE", -1);

    /**
     * Directory %s is either empty or you lack permissions to access its contents.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_INSTALL_ROOT_DIR_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_INSTALL_ROOT_DIR_EMPTY", -1);

    /**
     * File %s is not a server installation root.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_INSTALL_ROOT_DIR_NOT_DIR =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_INSTALL_ROOT_DIR_NOT_DIR", -1);

    /**
     * Directory %s does not contain directory %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_INSTALL_ROOT_DIR_NO_DIR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_INSTALL_ROOT_DIR_NO_DIR", -1);

    /**
     * Directory %s does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_INSTALL_ROOT_DIR_NO_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_INSTALL_ROOT_DIR_NO_EXIST", -1);

    /**
     * The root directory is null.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_INSTALL_ROOT_DIR_NULL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_INSTALL_ROOT_DIR_NULL", -1);

    /**
     * images/error_large.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_LARGE_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_LARGE_ICON", -1);

    /**
     * Error launching initialization with contents from server %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_LAUNCHING_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_LAUNCHING_INITIALIZATION", -1);

    /**
     * Error reading the progress of the initialization with contents from server %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_POOLING_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_POOLING_INITIALIZATION", -1);

    /**
     * The value of property %s could not be determined.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_PROP_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_PROP_VALUE", -1);

    /**
     * Error reading data from server. There is an error with the certificate presented by the server.
Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE", -1);

    /**
     * Error reading data from server %s. There is an error with the certificate presented by the server.
Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE_SERVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE_SERVER", -1);

    /**
     * Error Reading error output.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_READING_ERROROUTPUT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_ERROROUTPUT", -1);

    /**
     * Error Reading output.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_READING_OUTPUT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_OUTPUT", -1);

    /**
     * The following errors were encountered reading the configuration of the existing servers:%n%s%n%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_READING_REGISTERED_SERVERS_CONFIRM =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_REGISTERED_SERVERS_CONFIRM", -1);

    /**
     * Error reading configuration. Details:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_READING_SERVER_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_READING_SERVER_CONFIGURATION", -1);

    /**
     * Error renaming file %s to %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_RENAMING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_RENAMING_FILE", -1);

    /**
     * Error Starting Directory Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_STARTING_SERVER =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STARTING_SERVER", -1);

    /**
     * Error Starting Directory Server. Error code: %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_STARTING_SERVER_CODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STARTING_SERVER_CODE", -1);

    /**
     * Could not connect to the server after requesting start. Verify that the server has access rights to port %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_STARTING_SERVER_IN_UNIX =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STARTING_SERVER_IN_UNIX", -1);

    /**
     * Could not connect to the server after requesting start. If you have a firewall configured check that it allows connections to port %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_STARTING_SERVER_IN_WINDOWS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STARTING_SERVER_IN_WINDOWS", -1);

    /**
     * Error Stopping Directory Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_STOPPING_SERVER =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STOPPING_SERVER", -1);

    /**
     * Error Stopping Directory Server. Error code: %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_STOPPING_SERVER_CODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_STOPPING_SERVER_CODE", -1);

    /**
     * Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_TITLE", -1);

    /**
     * An unexpected error occurred reading the zip file %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_ZIP_STREAM =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_ERROR_ZIP_STREAM", -1);

    /**
     * Root Cause:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXCEPTION_ROOT_CAUSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_EXCEPTION_ROOT_CAUSE", -1);

    /**
     * 255,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FIELD_INVALID_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FIELD_INVALID_COLOR", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FIELD_VALID_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FIELD_VALID_COLOR", -1);

    /**
     * Path %s does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_FILE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_FILE_DOES_NOT_EXIST", -1);

    /**
     * Finished
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISHED_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FINISHED_PANEL_TITLE", -1);

    /**
     * Finished
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISHED_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FINISHED_STEP", -1);

    /**
     * Finish Installation and Setup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISH_BUTTON_INSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FINISH_BUTTON_INSTALL_TOOLTIP", -1);

    /**
     * Finish
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISH_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FINISH_BUTTON_LABEL", -1);

    /**
     * Finish Setup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISH_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_FINISH_BUTTON_TOOLTIP", -1);

    /**
     * %s QuickSetup
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_FRAME_INSTALL_TITLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_FRAME_INSTALL_TITLE", -1);

    /**
     * Build ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_BUILD_ID =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_BUILD_ID", -1);

    /**
     * Checking Data...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_CHECKING_DATA =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_CHECKING_DATA", -1);

    /**
     * Loading...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_LOADING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_LOADING", -1);

    /**
     * See %s for a detailed log of the failed operation.
Please report this error and provide the log file mentioned above.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GENERAL_PROVIDE_LOG_IN_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_PROVIDE_LOG_IN_ERROR", -1);

    /**
     * See %s for a detailed log of this operation.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GENERAL_SEE_FOR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_SEE_FOR_DETAILS", -1);

    /**
     * started
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_SERVER_STARTED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_SERVER_STARTED", -1);

    /**
     * stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_SERVER_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_SERVER_STOPPED", -1);

    /**
     * Warning
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_WARNING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GENERAL_WARNING", -1);

    /**
     * The Administrator that can manage all the server instances.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_DESCRIPTION", -1);

    /**
     * Provide the informaton to create a Global Administrator that will able to manage your whole replication topology.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PANEL_INSTRUCTIONS", -1);

    /**
     * Create Global Administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PANEL_TITLE", -1);

    /**
     * Global Administrator Password (confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PWD_CONFIRM_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PWD_CONFIRM_LABEL", -1);

    /**
     * Confirm the password of the Global Administrator.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PWD_CONFIRM_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PWD_CONFIRM_TOOLTIP", -1);

    /**
     * Global Administrator Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PWD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PWD_LABEL", -1);

    /**
     * The Global Administrator Password.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_PWD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_PWD_TOOLTIP", -1);

    /**
     * Global Administrator ID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_UID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_UID_LABEL", -1);

    /**
     * The Global Administrator ID.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_ADMINISTRATOR_UID_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_GLOBAL_ADMINISTRATOR_UID_TOOLTIP", -1);

    /**
     * images/help_medium.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HELP_MEDIUM_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HELP_MEDIUM_ICON", -1);

    /**
     * images/help_small.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HELP_SMALL_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HELP_SMALL_ICON", -1);

    /**
     * Help icon.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HELP_SMALL_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HELP_SMALL_ICON_DESCRIPTION", -1);

    /**
     * Busy, please wait.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HELP_WAIT_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HELP_WAIT_DESCRIPTION", -1);

    /**
     * Hide Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HIDE_EXCEPTION_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HIDE_EXCEPTION_DETAILS", -1);

    /**
     * Fully Qualified Host Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HOST_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HOST_NAME_LABEL", -1);

    /**
     * Enter the fully qualified name of the local host.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HOST_NAME_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HOST_NAME_TOOLTIP", -1);

    /**
     * 666666
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HTML_SEPARATOR_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_HTML_SEPARATOR_COLOR", -1);

    /**
     * Import Automatically-Generated Sample Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_AUTOMATICALLY_GENERATED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_AUTOMATICALLY_GENERATED_LABEL", -1);

    /**
     * Populate the base DN with automatically-generated LDAP data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_AUTOMATICALLY_GENERATED_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_AUTOMATICALLY_GENERATED_TOOLTIP", -1);

    /**
     * Import Data from LDIF File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_DATA_FROM_LDIF_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_DATA_FROM_LDIF_LABEL", -1);

    /**
     * Use the contents of an LDIF file to populate the base DN with data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_DATA_FROM_LDIF_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_DATA_FROM_LDIF_TOOLTIP", -1);

    /**
     * Considering the size of the provided LDIF file, the default runtime settings might not be enough to be able to manage that volume of data. It is recommended to increase the maximum memory allowed for both the server runtime and the import.<br><br>Check the documentation for more information about how to tune the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_FILE_WARNING_UPDATE_RUNTIME_ARGS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_FILE_WARNING_UPDATE_RUNTIME_ARGS", -1);

    /**
     * Specify the memory and java arguments that will be used when importing data to the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_JAVA_ARGUMENTS_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_JAVA_ARGUMENTS_MSG", -1);

    /**
     * Import Runtime Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_JAVA_ARGUMENTS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_JAVA_ARGUMENTS_TITLE", -1);

    /**
     * Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_PATH_LABEL", -1);

    /**
     * Enter the full path of the LDIF file containing the data to be imported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_PATH_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_PATH_TOOLTIP", -1);

    /**
     * Import Runtime Settings:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_RUNTIME_ARGS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_IMPORT_RUNTIME_ARGS_LABEL", -1);

    /**
     * images/info_small.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INFORMATION_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INFORMATION_ICON", -1);

    /**
     * Information.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INFORMATION_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INFORMATION_ICON_DESCRIPTION", -1);

    /**
     * Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INFORMATION_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INFORMATION_ICON_TOOLTIP", -1);

    /**
     * images/info_large.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INFORMATION_LARGE_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INFORMATION_LARGE_ICON", -1);

    /**
     * Ignoring %s since %s exists.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INFO_IGNORING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INFO_IGNORING_FILE", -1);

    /**
     * %s entries processed (%s %% complete).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INITIALIZE_PROGRESS_WITH_PERCENTAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INITIALIZE_PROGRESS_WITH_PERCENTAGE", -1);

    /**
     * %s entries processed.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INITIALIZE_PROGRESS_WITH_PROCESSED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_INITIALIZE_PROGRESS_WITH_PROCESSED", -1);

    /**
     * %s remaining to be processed.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INITIALIZE_PROGRESS_WITH_UNPROCESSED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_INITIALIZE_PROGRESS_WITH_UNPROCESSED", -1);

    /**
     * %d MB Initial Memory
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_INITIAL_MEMORY =
                    new LocalizableMessageDescriptor.Arg1<Number>(QuickSetupMessages.class, RESOURCE, "INFO_INITIAL_MEMORY", -1);

    /**
     * Initial Memory:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INITIAL_MEMORY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INITIAL_MEMORY_LABEL", -1);

    /**
     * Provide the initial memory in megabytes that the Java process will use.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INITIAL_MEMORY_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INITIAL_MEMORY_TOOLTIP", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INLINE_HELP_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INLINE_HELP_COLOR", -1);

    /**
     * The server contains some database files.<br>If you continue with the setup the contents of these database files will be deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLSTATUS_CANOVERWRITECURRENTINSTALL_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_CANOVERWRITECURRENTINSTALL_MSG", -1);

    /**
     * The server contains some database files.%nThe setup will delete the contents of these database files.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLSTATUS_CANOVERWRITECURRENTINSTALL_MSG_CLI =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_CANOVERWRITECURRENTINSTALL_MSG_CLI", -1);

    /**
     * Has already been configured
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLSTATUS_CONFIGFILEMODIFIED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_CONFIGFILEMODIFIED", -1);

    /**
     * Contains data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLSTATUS_DBFILEEXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_DBFILEEXIST", -1);

    /**
     * Server Already Configured<br> The setup can only be used with servers that have not yet been configured. The current server:%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INSTALLSTATUS_INSTALLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_INSTALLED", -1);

    /**
     * Server Already Configured%n %s command-line can only be used with servers that have not yet been configured. The current server:%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INSTALLSTATUS_INSTALLED_CLI =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_INSTALLED_CLI", -1);

    /**
     * The Directory Server is not installed.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLSTATUS_NOT_INSTALLED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_NOT_INSTALLED", -1);

    /**
     * Is currently running on port %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INSTALLSTATUS_SERVERRUNNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_INSTALLSTATUS_SERVERRUNNING", -1);

    /**
     * Setup canceled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_CANCELED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_CANCELED", -1);

    /**
     * Equivalent non-interactive command-line to enable replication:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_ENABLE_REPLICATION_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_ENABLE_REPLICATION_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * Equivalent non-interactive command-lines to enable replication:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_ENABLE_REPLICATION_EQUIVALENT_COMMAND_LINES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_ENABLE_REPLICATION_EQUIVALENT_COMMAND_LINES", -1);

    /**
     * Equivalent non-interactive command-line to initialize replication:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_INITIALIZE_REPLICATION_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_INITIALIZE_REPLICATION_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * Equivalent non-interactive command-lines to initialize replication:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_INITIALIZE_REPLICATION_EQUIVALENT_COMMAND_LINES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_INITIALIZE_REPLICATION_EQUIVALENT_COMMAND_LINES", -1);

    /**
     * The Server will be temporarily started.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_SERVER_MUST_BE_TEMPORARILY_STARTED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_SERVER_MUST_BE_TEMPORARILY_STARTED", -1);

    /**
     * Equivalent non-interactive command-line to setup server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_SETUP_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_SETUP_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * Equivalent command-line to stop the server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALL_STOP_SERVER_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTALL_STOP_SERVER_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTRUCTIONS_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INSTRUCTIONS_COLOR", -1);

    /**
     * The number of user entries to generate automatically must be an integer between %s and %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INVALID_NUMBER_ENTRIES_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_NUMBER_ENTRIES_RANGE", -1);

    /**
     * The LDAP Listener Port must be an integer between %s and %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INVALID_PORT_VALUE_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_PORT_VALUE_RANGE", -1);

    /**
     * The provided port is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INVALID_REMOTE_PORT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_REMOTE_PORT", -1);

    /**
     * The Replication Port on %s must be an integer between %s and %s.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_INVALID_REMOTE_REPLICATION_PORT_VALUE_RANGE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_REMOTE_REPLICATION_PORT_VALUE_RANGE", -1);

    /**
     * The Replication Port must be an integer between %s and %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INVALID_REPLICATION_PORT_VALUE_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_REPLICATION_PORT_VALUE_RANGE", -1);

    /**
     * The LDAPS Listener Port must be an integer between %s and %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INVALID_SECURE_PORT_VALUE_RANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_INVALID_SECURE_PORT_VALUE_RANGE", -1);

    /**
     * Close this dialog and discard the provide java arguments.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_ARGUMENTS_CANCEL_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_ARGUMENTS_CANCEL_BUTTON_TOOLTIP", -1);

    /**
     * Leave empty to use the default value of the Java virtual machine.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_ARGUMENTS_LEAVE_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_ARGUMENTS_LEAVE_EMPTY", -1);

    /**
     * Close this dialog and accept the provided java arguments.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_ARGUMENTS_OK_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_ARGUMENTS_OK_BUTTON_TOOLTIP", -1);

    /**
     * Click to configure the runtime options that will be used to run the import utility.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_CHANGE_IMPORT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_CHANGE_IMPORT_TOOLTIP", -1);

    /**
     * Change...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_CHANGE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_CHANGE_LABEL", -1);

    /**
     * Click to configure the runtime options that will be used to run the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_CHANGE_SERVER_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_CHANGE_SERVER_TOOLTIP", -1);

    /**
     * Specify the runtime options that the Java virtual machine will use to run the server and the import tool.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_OPTIONS_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_OPTIONS_PANEL_INSTRUCTIONS", -1);

    /**
     * Runtime Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_OPTIONS_PANEL_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_OPTIONS_PANEL_STEP", -1);

    /**
     * Runtime Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_OPTIONS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_OPTIONS_PANEL_TITLE", -1);

    /**
     * Java Runtime Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_RUNTIME_SETTINGS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JAVA_RUNTIME_SETTINGS_TITLE", -1);

    /**
     * Use existing JCEKS File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JCEKS_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JCEKS_CERTIFICATE", -1);

    /**
     * JCEKS File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JCEKS_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JCEKS_CERTIFICATE_LABEL", -1);

    /**
     * Select this option if you have a JCEKS certificate.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JCEKS_CERTIFICATE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JCEKS_CERTIFICATE_TOOLTIP", -1);

    /**
     * No certificates for the Java Key Store could be found. Check that the provided path is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JCEKS_KEYSTORE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JCEKS_KEYSTORE_DOES_NOT_EXIST", -1);

    /**
     * Use existing Java Key Store File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JKS_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JKS_CERTIFICATE", -1);

    /**
     * Java Key Store (JKS) File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JKS_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JKS_CERTIFICATE_LABEL", -1);

    /**
     * Select this option if you have a JKS certificate.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JKS_CERTIFICATE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JKS_CERTIFICATE_TOOLTIP", -1);

    /**
     * No certificates for the Java Key Store could be found. Check that the provided path is valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JKS_KEYSTORE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_JKS_KEYSTORE_DOES_NOT_EXIST", -1);

    /**
     * The provided key store path does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PATH_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PATH_DOES_NOT_EXIST", -1);

    /**
     * Key Store Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PATH_LABEL", -1);

    /**
     * The provided key store path is not a file.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PATH_NOT_A_FILE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PATH_NOT_A_FILE", -1);

    /**
     * You must provide the path of the key store.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PATH_NOT_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PATH_NOT_PROVIDED", -1);

    /**
     * Absolute path to the keystore.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PATH_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PATH_TOOLTIP", -1);

    /**
     * Key Store PIN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_LABEL", -1);

    /**
     * Provide the PIN (password) required to access the existing key store.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_TOOLTIP", -1);

    /**
     * Key Store Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_KEYSTORE_TYPE_LABEL", -1);

    /**
     * LDAP Data Interchange Format (*.ldif)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIF_FILES_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LDIF_FILES_DESCRIPTION", -1);

    /**
     * The provided LDIF file does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIF_FILE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LDIF_FILE_DOES_NOT_EXIST", -1);

    /**
     * Leave Database Empty
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LEAVE_DATABASE_EMPTY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LEAVE_DATABASE_EMPTY_LABEL", -1);

    /**
     * Do not create any entry for the Directory Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LEAVE_DATABASE_EMPTY_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LEAVE_DATABASE_EMPTY_TOOLTIP", -1);

    /**
     * Click to accept
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_CLICK_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_CLICK_LABEL", -1);

    /**
     * Invalid response
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_CLI_ACCEPT_INVALID_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_CLI_ACCEPT_INVALID_RESPONSE", -1);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_CLI_ACCEPT_NO =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_CLI_ACCEPT_NO", -1);

    /**
     * Accept the license (%s/%s) [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_LICENSE_CLI_ACCEPT_QUESTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_CLI_ACCEPT_QUESTION", -1);

    /**
     * Yes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_CLI_ACCEPT_YES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_CLI_ACCEPT_YES", -1);

    /**
     * Please read the License Agreement above.%nYou must accept the terms of the agreement before continuing with the installation.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_DETAILS_CLI_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_DETAILS_CLI_LABEL", -1);

    /**
     * <html>Please read the following License Agreement.<br>You must accept the terms of the agreement before continuing with the installation.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_DETAILS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_DETAILS_LABEL", -1);

    /**
     * License
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_PANEL_TITLE", -1);

    /**
     * License
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_LICENSE_STEP", -1);

    /**
     * %d MB Max Memory
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_MAXIMUM_MEMORY =
                    new LocalizableMessageDescriptor.Arg1<Number>(QuickSetupMessages.class, RESOURCE, "INFO_MAXIMUM_MEMORY", -1);

    /**
     * Maximum Memory:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAX_MEMORY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MAX_MEMORY_LABEL", -1);

    /**
     * Provide the maximum memory in megabytes that the Java process will be allowed to use.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAX_MEMORY_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MAX_MEMORY_TOOLTIP", -1);

    /**
     * Megabytes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MEGABYTE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MEGABYTE_LABEL", -1);

    /**
     * memorySizeInMB
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MEMORY_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MEMORY_PLACEHOLDER", -1);

    /**
     * images/opendjminimized.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MINIMIZED_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MINIMIZED_ICON", -1);

    /**
     * QuickSetup minimized.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MINIMIZED_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MINIMIZED_ICON_DESCRIPTION", -1);

    /**
     * QuickSetup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MINIMIZED_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MINIMIZED_ICON_TOOLTIP", -1);

    /**
     * images/opendjminimizedmac.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MINIMIZED_MAC_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_MINIMIZED_MAC_ICON", -1);

    /**
     * Next >
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NEXT_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NEXT_BUTTON_LABEL", -1);

    /**
     * Go to Next Step
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NEXT_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NEXT_BUTTON_TOOLTIP", -1);

    /**
     * <not available>
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_LABEL", -1);

    /**
     * The provided Directory Base DN is not a valid DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_A_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_A_BASE_DN", -1);

    /**
     * The provided Root User DN is not a valid DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_A_DIRECTORY_MANAGER_DN =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_A_DIRECTORY_MANAGER_DN", -1);

    /**
     * The provided DN is not one of the Root User DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_A_DIRECTORY_MANAGER_IN_CONFIG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_A_DIRECTORY_MANAGER_IN_CONFIG", -1);

    /**
     * The passwords you have provided do not match.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_EQUAL_PWD =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_EQUAL_PWD", -1);

    /**
     * You must provide the Global Administrator ID to be able to access the configuration of all the remote servers that have been previously installed.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_GLOBAL_ADMINISTRATOR_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NOT_GLOBAL_ADMINISTRATOR_PROVIDED", -1);

    /**
     * Leave empty if you do not want to create a base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_BASE_DN_INLINE_HELP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_BASE_DN_INLINE_HELP", -1);

    /**
     * No entries found to initialize.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_ENTRIES_TO_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_ENTRIES_TO_INITIALIZE", -1);

    /**
     * You must provide the path of the LDIF file to import.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_LDIF_PATH =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_LDIF_PATH", -1);

    /**
     * You must provide the number of user entries to generate automatically.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_NUMBER_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_NUMBER_ENTRIES", -1);

    /**
     * disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_SECURITY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_SECURITY", -1);

    /**
     * You must select at least one base DN to replicate contents with.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_SUFFIXES_CHOSEN_TO_REPLICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NO_SUFFIXES_CHOSEN_TO_REPLICATE", -1);

    /**
     * Number of User Entries:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUMBER_ENTRIES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NUMBER_ENTRIES_LABEL", -1);

    /**
     * Enter the number of user entries to be generated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUMBER_ENTRIES_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_NUMBER_ENTRIES_TOOLTIP", -1);

    /**
     * OK
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OK_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OK_BUTTON_LABEL", -1);

    /**
     * Choose a File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPEN_GENERIC_FILE_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OPEN_GENERIC_FILE_DIALOG_TITLE", -1);

    /**
     * Choose an LDIF File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPEN_LDIF_FILE_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OPEN_LDIF_FILE_DIALOG_TITLE", -1);

    /**
     * Choose Installation Path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPEN_SERVER_LOCATION_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OPEN_SERVER_LOCATION_DIALOG_TITLE", -1);

    /**
     * Choose a Server Installation Package (.zip)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPEN_ZIP_FILE_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OPEN_ZIP_FILE_DIALOG_TITLE", -1);

    /**
     * 255,255,255
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPTIONPANE_BACKGROUND_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OPTIONPANE_BACKGROUND_COLOR", -1);

    /**
     * Other Java Arguments:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OTHER_JAVA_ARGUMENTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OTHER_JAVA_ARGUMENTS_LABEL", -1);

    /**
     * Provide other java arguments that will be used by the Java process.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OTHER_JAVA_ARGUMENTS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_OTHER_JAVA_ARGUMENTS_TOOLTIP", -1);

    /**
     * 255,255,255
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PANEL_BACKGROUND_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PANEL_BACKGROUND_COLOR", -1);

    /**
     * 204,204,204
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PANEL_BORDER_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PANEL_BORDER_COLOR", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PASSWORDFIELD_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PASSWORDFIELD_COLOR", -1);

    /**
     * Use existing PKCS#11 Token
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS11_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS11_CERTIFICATE", -1);

    /**
     * PKCS#11 Token
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS11_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS11_CERTIFICATE_LABEL", -1);

    /**
     * Select this option if you have a PKCS#11 token.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS11_CERTIFICATE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS11_CERTIFICATE_TOOLTIP", -1);

    /**
     * No certificates for the PCKS#11 key store could be found. Check that is installed, that you have access rights to it and that the key store contains certificates.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS11_KEYSTORE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS11_KEYSTORE_DOES_NOT_EXIST", -1);

    /**
     * Use existing PKCS#12 File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS12_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS12_CERTIFICATE", -1);

    /**
     * PKCS#12 File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS12_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS12_CERTIFICATE_LABEL", -1);

    /**
     * Select this option if you have a PKCS#12 certificate.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS12_CERTIFICATE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS12_CERTIFICATE_TOOLTIP", -1);

    /**
     * No certificates for the PCKS#12 key store could be found. Check that the provided path and PIN are valid and that the key store contains certificates.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PKCS12_KEYSTORE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PKCS12_KEYSTORE_DOES_NOT_EXIST", -1);

    /**
     * < Previous
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PREVIOUS_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PREVIOUS_BUTTON_LABEL", -1);

    /**
     * Go to Previous Step
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PREVIOUS_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PREVIOUS_BUTTON_TOOLTIP", -1);

    /**
     * Starting...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESSBAR_INITIAL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESSBAR_INITIAL_LABEL", -1);

    /**
     * Progress Bar
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESSBAR_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESSBAR_TOOLTIP", -1);

    /**
     * Canceling
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CANCELING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CANCELING", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_COLOR", -1);

    /**
     * Configuring Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CONFIGURING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CONFIGURING", -1);

    /**
     * Configuring Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CONFIGURING_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CONFIGURING_REPLICATION", -1);

    /**
     * Configuring Replication on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_CONFIGURING_REPLICATION_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CONFIGURING_REPLICATION_REMOTE", -1);

    /**
     * Copying file %s to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROGRESS_COPYING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_COPYING_FILE", -1);

    /**
     * Creating Global Administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CREATING_ADMINISTRATOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_ADMINISTRATOR", -1);

    /**
     * Creating Registration Configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CREATING_ADS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_ADS", -1);

    /**
     * Creating Registration Configuration on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_CREATING_ADS_ON_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_ADS_ON_REMOTE", -1);

    /**
     * Creating Base Entry for the base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CREATING_BASE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_BASE_ENTRIES", -1);

    /**
     * Creating Base Entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_CREATING_BASE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_BASE_ENTRY", -1);

    /**
     * Creating Replicated Base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_CREATING_REPLICATED_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_CREATING_REPLICATED_BACKENDS", -1);

    /**
     * Deleting directory %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_DELETING_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_DIRECTORY", -1);

    /**
     * Deleting Database Files outside the Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_EXTERNAL_DB_FILES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_EXTERNAL_DB_FILES", -1);

    /**
     * Deleting Database Files outside the Installation Path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_EXTERNAL_DB_FILES_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_EXTERNAL_DB_FILES_NON_VERBOSE", -1);

    /**
     * Deleting Log Files outside the Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_EXTERNAL_LOG_FILES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_EXTERNAL_LOG_FILES", -1);

    /**
     * Deleting Log Files outside the Installation Path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_EXTERNAL_LOG_FILES_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_EXTERNAL_LOG_FILES_NON_VERBOSE", -1);

    /**
     * Deleting file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_DELETING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_FILE", -1);

    /**
     * Ignoring file %s since it does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_DELETING_FILE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_FILE_DOES_NOT_EXIST", -1);

    /**
     * Deleting Files under the Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_INSTALLATION_FILES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_INSTALLATION_FILES", -1);

    /**
     * Deleting Files under the Installation Path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DELETING_INSTALLATION_FILES_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DELETING_INSTALLATION_FILES_NON_VERBOSE", -1);

    /**
     * Details:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DETAILS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DETAILS_LABEL", -1);

    /**
     * Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DIALOG_TITLE", -1);

    /**
     * Disabling Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DISABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DISABLING_WINDOWS_SERVICE", -1);

    /**
     * Done.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_DONE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_DONE", -1);

    /**
     * Enabling Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_ENABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_ENABLING_WINDOWS_SERVICE", -1);

    /**
     * Error.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_ERROR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_ERROR", -1);

    /**
     * Extracting %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_EXTRACTING =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_EXTRACTING", -1);

    /**
     * Importing LDIF file %s:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORTING_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORTING_LDIF", -1);

    /**
     * Importing LDIF files %s:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORTING_LDIFS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORTING_LDIFS", -1);

    /**
     * Importing LDIF files %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORTING_LDIFS_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORTING_LDIFS_NON_VERBOSE", -1);

    /**
     * Importing LDIF file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORTING_LDIF_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORTING_LDIF_NON_VERBOSE", -1);

    /**
     * Importing Automatically-Generated Data (%s Entries):
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED", -1);

    /**
     * Importing Automatically-Generated Data (%s Entries)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED_NON_VERBOSE", -1);

    /**
     * Initializing Registration information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_INITIALIZING_ADS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_INITIALIZING_ADS", -1);

    /**
     * Initializing schema information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_INITIALIZING_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_INITIALIZING_SCHEMA", -1);

    /**
     * Initializing base DN %s with the contents from %s:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROGRESS_INITIALIZING_SUFFIX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_INITIALIZING_SUFFIX", -1);

    /**
     * Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_PANEL_TITLE", -1);

    /**
     * .....
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_POINTS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_POINTS", -1);

    /**
     * The Directory Server is already stopped.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_SERVER_ALREADY_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_SERVER_ALREADY_STOPPED", -1);

    /**
     * Server stopped.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_SERVER_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_SERVER_STOPPED", -1);

    /**
     * Waiting for Server to stop...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_SERVER_WAITING_TO_STOP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_SERVER_WAITING_TO_STOP", -1);

    /**
     * Starting Directory Server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_STARTING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_STARTING", -1);

    /**
     * Starting Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_STARTING_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_STARTING_NON_VERBOSE", -1);

    /**
     * Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_STEP", -1);

    /**
     * Stopping Directory Server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_STOPPING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_STOPPING", -1);

    /**
     * Stopping Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_STOPPING_NON_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_STOPPING_NON_VERBOSE", -1);

    /**
     * Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_TITLE", -1);

    /**
     * Reverting Registration Configuration on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_UNCONFIGURING_ADS_ON_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_UNCONFIGURING_ADS_ON_REMOTE", -1);

    /**
     * Unconfiguring Replication on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_UNCONFIGURING_REPLICATION_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_UNCONFIGURING_REPLICATION_REMOTE", -1);

    /**
     * Configuring Certificates
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_UPDATING_CERTIFICATES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_PROGRESS_UPDATING_CERTIFICATES", -1);

    /**
     * The minimum length required for the Root User password is %s characters.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PWD_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_PWD_TOO_SHORT", -1);

    /**
     * Quit Setup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_QUIT_BUTTON_INSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_QUIT_BUTTON_INSTALL_TOOLTIP", -1);

    /**
     * Quit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_QUIT_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_QUIT_BUTTON_LABEL", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_READ_ONLY_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_READ_ONLY_COLOR", -1);

    /**
     * An unexpected error occurred managing the registration information in %s.%nThe error is: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REMOTE_ADS_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_ADS_EXCEPTION", -1);

    /**
     * Replication Port
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_REPLICATION_PORTS_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_REPLICATION_PORTS_STEP", -1);

    /**
     * You must specify a different Replication port for existing server %s. The specified port has already been chosen to configure the new server.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REMOTE_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL", -1);

    /**
     * You must provide the ports that will be used to replicate data for the remote servers specified below.<br>The specified ports must be free on the remote hosts and the user that is being used to run the Directory Servers must have access rights to them.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_REPLICATION_PORT_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_REPLICATION_PORT_INSTRUCTIONS", -1);

    /**
     * Replication Port of Remote Servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_REPLICATION_PORT_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_REPLICATION_PORT_TITLE", -1);

    /**
     * Admin User:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_DN_LABEL", -1);

    /**
     * The DN or the UID of an administrator in the server you want to replicate data with.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_DN_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_DN_TOOLTIP", -1);

    /**
     * Fully Qualified Host Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_HOST_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_HOST_LABEL", -1);

    /**
     * The fully qualified name of the host where the server you want to replicate data with is located.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_HOST_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_HOST_TOOLTIP", -1);

    /**
     * Administration Connector Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_PORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_PORT_LABEL", -1);

    /**
     * The administration connector port of the server you want to replicate data with.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_PORT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_PORT_TOOLTIP", -1);

    /**
     * Admin Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_PWD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_PWD_LABEL", -1);

    /**
     * The password of an administrator in the server you want to replicate data with.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOTE_SERVER_PWD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_PWD_TOOLTIP", -1);

    /**
     * %s - To be configured on remote server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REMOTE_SERVER_REPLICATION_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_REMOTE_SERVER_REPLICATION_PORT", -1);

    /**
     * Considering the number of entries defined in the suffixes of the replicated remote servers, the default runtime settings might not be enough to be able to manage that volume of data. It is recommended to increase the maximum memory allowed for the server runtime.<br><br>Check the documentation for more information about how to tune the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_ENTRIES_WARNING_UPDATE_RUNTIME_ARGS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATED_ENTRIES_WARNING_UPDATE_RUNTIME_ARGS", -1);

    /**
     * This server will be part of a replication topology
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_SERVER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATED_SERVER_LABEL", -1);

    /**
     * Check this if you want to replicate the data on the server that you are creating with other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_SERVER_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATED_SERVER_TOOLTIP", -1);

    /**
     * The name of the backend that will be used for replicated data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_SUFFIXES_BACKEND_NAME_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATED_SUFFIXES_BACKEND_NAME_TOOLTIP", -1);

    /**
     * Select the type of backend that you want to use for replicated data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_SUFFIXES_BACKEND_TYPE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATED_SUFFIXES_BACKEND_TYPE_TOOLTIP", -1);

    /**
     * You must specify a different Replication port than those you chose for LDAP and LDAPS communication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATION_PORT_ALREADY_CHOSEN_FOR_OTHER_PROTOCOL", -1);

    /**
     * Replication Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATION_PORT_LABEL", -1);

    /**
     * The port that will be used to send and receive replication updates between this server and the other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PORT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REPLICATION_PORT_TOOLTIP", -1);

    /**
     * Only Create Base Entry (%s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REVIEW_CREATE_BASE_ENTRY_LABEL =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_CREATE_BASE_ENTRY_LABEL", -1);

    /**
     * Do not Create a Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_CREATE_NO_SUFFIX =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_CREATE_NO_SUFFIX", -1);

    /**
     * Backend Type: %s%nCreate New Base DN %s%nBase DN Data: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_REVIEW_CREATE_SUFFIX =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_CREATE_SUFFIX", -1);

    /**
     * Show Equivalent Command-Line
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_DISPLAY_EQUIVALENT_COMMAND =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_DISPLAY_EQUIVALENT_COMMAND", -1);

    /**
     * Show Summary
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_DISPLAY_TEXT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_DISPLAY_TEXT", -1);

    /**
     * Import Automatically-Generated Data (%s Entries)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REVIEW_IMPORT_AUTOMATICALLY_GENERATED =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_IMPORT_AUTOMATICALLY_GENERATED", -1);

    /**
     * Import Data from LDIF File (%s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REVIEW_IMPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_IMPORT_LDIF", -1);

    /**
     * Leave Database Empty
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_LEAVE_DATABASE_EMPTY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_LEAVE_DATABASE_EMPTY_LABEL", -1);

    /**
     * Review your settings and click Finish if they are correct.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_PANEL_INSTRUCTIONS", -1);

    /**
     * Review
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_PANEL_TITLE", -1);

    /**
     * Replicate contents with base DNs:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REVIEW_REPLICATE_SUFFIX =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_REPLICATE_SUFFIX", -1);

    /**
     * Review
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REVIEW_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_REVIEW_STEP", -1);

    /**
     * Runtime Options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RUNTIME_OPTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_RUNTIME_OPTIONS_LABEL", -1);

    /**
     * Configure as Secure
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURE_REPLICATION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURE_REPLICATION_LABEL", -1);

    /**
     * %s (Secure)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SECURE_REPLICATION_PORT_LABEL =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_SECURE_REPLICATION_PORT_LABEL", -1);

    /**
     * Check this if you want to encrypt the communication when other servers connect to this replication port.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURE_REPLICATION_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURE_REPLICATION_TOOLTIP", -1);

    /**
     * Close this dialog and discard configuration.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURITY_OPTIONS_CANCEL_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURITY_OPTIONS_CANCEL_BUTTON_TOOLTIP", -1);

    /**
     * Security Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURITY_OPTIONS_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURITY_OPTIONS_DIALOG_TITLE", -1);

    /**
     * Specify the options for enabling secure access to the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURITY_OPTIONS_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURITY_OPTIONS_INSTRUCTIONS", -1);

    /**
     * Close this dialog and accept configuration.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURITY_OPTIONS_OK_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURITY_OPTIONS_OK_BUTTON_TOOLTIP", -1);

    /**
     * Configure Secure Access
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECURITY_OPTIONS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SECURITY_OPTIONS_TITLE", -1);

    /**
     * Close this dialog and discard selected alias.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SELECT_ALIAS_CANCEL_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SELECT_ALIAS_CANCEL_BUTTON_TOOLTIP", -1);

    /**
     * The provided Key Store contains multiple certificates.<br>Select the alias of the certificate that you want to be used as Server Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SELECT_ALIAS_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SELECT_ALIAS_MSG", -1);

    /**
     * Close this dialog and accept selected alias.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SELECT_ALIAS_OK_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SELECT_ALIAS_OK_BUTTON_TOOLTIP", -1);

    /**
     * Select Alias
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SELECT_ALIAS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SELECT_ALIAS_TITLE", -1);

    /**
     * Create a new Self-Signed Certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SELF_SIGNED_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SELF_SIGNED_CERTIFICATE", -1);

    /**
     * Root User DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_DN_LABEL", -1);

    /**
     * Enter the distinguished name (DN) of the inital Root User account that will used for managing the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_DN_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_DN_TOOLTIP", -1);

    /**
     * Password (confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_PWD_CONFIRM_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_PWD_CONFIRM_LABEL", -1);

    /**
     * Re-enter the password for the server initial Root User account
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_PWD_CONFIRM_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_PWD_CONFIRM_TOOLTIP", -1);

    /**
     * Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_PWD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_PWD_LABEL", -1);

    /**
     * Enter a password for the server initial Root User account
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DIRECTORY_MANAGER_PWD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_DIRECTORY_MANAGER_PWD_TOOLTIP", -1);

    /**
     * Error on %s:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SERVER_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_ERROR", -1);

    /**
     * Specify the memory and java arguments that will be used to run the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_JAVA_ARGUMENTS_MSG =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_JAVA_ARGUMENTS_MSG", -1);

    /**
     * Server Runtime Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_JAVA_ARGUMENTS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_JAVA_ARGUMENTS_TITLE", -1);

    /**
     * Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_LOCATION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_LOCATION_LABEL", -1);

    /**
     * Enter the full path to the parent location where the server files will be stored
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_LOCATION_PARENT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_LOCATION_PARENT_TOOLTIP", -1);

    /**
     * Enter the relative path to the location where the server files will be stored
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_LOCATION_RELATIVE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_LOCATION_RELATIVE_TOOLTIP", -1);

    /**
     * LDAP Listener Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_PORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_PORT_LABEL", -1);

    /**
     * Enter the port number that the server will use to listen for LDAP requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_PORT_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_PORT_TOOLTIP", -1);

    /**
     * Server Runtime Settings:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_RUNTIME_ARGS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_RUNTIME_ARGS_LABEL", -1);

    /**
     * Configure...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SECURITY_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SECURITY_BUTTON_LABEL", -1);

    /**
     * Click to configure the LDAP Secure Access.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SECURITY_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SECURITY_BUTTON_TOOLTIP", -1);

    /**
     * LDAP Secure Access:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SECURITY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SECURITY_LABEL", -1);

    /**
     * The LDAP Secure Access Configuration for the new server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SECURITY_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SECURITY_TOOLTIP", -1);

    /**
     * Enter a port to listen for LDAP requests and enter a password for the server initial Root user.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SETTINGS_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SETTINGS_PANEL_INSTRUCTIONS", -1);

    /**
     * Server Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SETTINGS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SETTINGS_PANEL_TITLE", -1);

    /**
     * Server Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_SETTINGS_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SERVER_SETTINGS_STEP", -1);

    /**
     * %n%nThe graphical Setup launch failed.%n%nLaunching command line setup...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SETUP_LAUNCHER_GUI_LAUNCHED_FAILED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SETUP_LAUNCHER_GUI_LAUNCHED_FAILED", -1);

    /**
     * %n%nThe graphical Setup launch failed. Check file %s for more details.%n%nLaunching command line setup...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SETUP_LAUNCHER_GUI_LAUNCHED_FAILED_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_SETUP_LAUNCHER_GUI_LAUNCHED_FAILED_DETAILS", -1);

    /**
     * Launching graphical setup...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SETUP_LAUNCHER_LAUNCHING_GUI =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SETUP_LAUNCHER_LAUNCHING_GUI", -1);

    /**
     * Show Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SHOW_EXCEPTION_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SHOW_EXCEPTION_DETAILS", -1);

    /**
     * images/opendjsplash.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SPLASH_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SPLASH_ICON", -1);

    /**
     * QuickSetup Launching.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SPLASH_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SPLASH_ICON_DESCRIPTION", -1);

    /**
     * QuickSetup Launching
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SPLASH_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SPLASH_ICON_TOOLTIP", -1);

    /**
     * SSL Access:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SSL_ACCESS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SSL_ACCESS_LABEL", -1);

    /**
     * The LDAPS port.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SSL_PORT_TEXTFIELD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SSL_PORT_TEXTFIELD_TOOLTIP", -1);

    /**
     * This will be a stand alone server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STANDALONE_SERVER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_STANDALONE_SERVER_LABEL", -1);

    /**
     * Check this if you do not want to replicate the data on the server that you are creating with other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STANDALONE_SERVER_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_STANDALONE_SERVER_TOOLTIP", -1);

    /**
     * StartTLS Access:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STARTTLS_ACCESS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_STARTTLS_ACCESS_LABEL", -1);

    /**
     * Start Server when Configuration has Completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_START_SERVER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_START_SERVER_LABEL", -1);

    /**
     * Check this check box if you want to start the server once the installation and configuration has completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_START_SERVER_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_START_SERVER_TOOLTIP", -1);

    /**
     * images/divider-left.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBSECTION_LEFT_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUBSECTION_LEFT_ICON", -1);

    /**
     * Decoration icon.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBSECTION_LEFT_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUBSECTION_LEFT_ICON_DESCRIPTION", -1);

    /**
     * images/divider-right.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBSECTION_RIGHT_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUBSECTION_RIGHT_ICON", -1);

    /**
     * Decoration icon.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBSECTION_RIGHT_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUBSECTION_RIGHT_ICON_DESCRIPTION", -1);

    /**
     * Data Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIXES_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIXES_STEP", -1);

    /**
     * The Distinguished Name (DN) of the base DN to replicate.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIXES_TO_REPLICATE_DN_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIXES_TO_REPLICATE_DN_TOOLTIP", -1);

    /**
     * Choose the base DNs that you want to create and whose contents will be replicated with the remote servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIXES_TO_REPLICATE_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIXES_TO_REPLICATE_PANEL_INSTRUCTIONS", -1);

    /**
     * Data Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIXES_TO_REPLICATE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIXES_TO_REPLICATE_PANEL_TITLE", -1);

    /**
     * Base DN initialized successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIX_INITIALIZED_SUCCESSFULLY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIX_INITIALIZED_SUCCESSFULLY", -1);

    /**
     * -No Base DNs Found-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIX_LIST_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIX_LIST_EMPTY", -1);

    /**
     * %s entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SUFFIX_LIST_REPLICA_DISPLAY_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIX_LIST_REPLICA_DISPLAY_ENTRIES", -1);

    /**
     * number of entries not available
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIX_LIST_REPLICA_DISPLAY_ENTRIES_NOT_AVAILABLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIX_LIST_REPLICA_DISPLAY_ENTRIES_NOT_AVAILABLE", -1);

    /**
     * no entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUFFIX_LIST_REPLICA_DISPLAY_NO_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUFFIX_LIST_REPLICA_DISPLAY_NO_ENTRIES", -1);

    /**
     * Canceling...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_CANCELING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_CANCELING", -1);

    /**
     * Configuring Directory Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_CONFIGURING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_CONFIGURING", -1);

    /**
     * Creating Registration Configuration...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_CONFIGURING_ADS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_CONFIGURING_ADS", -1);

    /**
     * Configuring Replication...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_CONFIGURING_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_CONFIGURING_REPLICATION", -1);

    /**
     * Creating Base Entry...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_CREATING_BASE_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_CREATING_BASE_ENTRY", -1);

    /**
     * Enabling Windows Service...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_ENABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_ENABLING_WINDOWS_SERVICE", -1);

    /**
     * Importing Automatically-Generated Data...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_IMPORTING_AUTOMATICALLY_GENERATED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_IMPORTING_AUTOMATICALLY_GENERATED", -1);

    /**
     * Importing LDIF File...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_IMPORTING_LDIF =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_IMPORTING_LDIF", -1);

    /**
     * Initializing Contents of Replicated Base DNs...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_INITIALIZE_REPLICATED_SUFFIXES =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_INITIALIZE_REPLICATED_SUFFIXES", -1);

    /**
     * <b>QuickSetup Canceled.</b> <br>The setup was canceled and any files installed to your system during this operation have been removed.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_INSTALL_FINISHED_CANCELED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_INSTALL_FINISHED_CANCELED", -1);

    /**
     * <b>%s QuickSetup Completed Successfully.</b><br>%s is now installed in %s.<br>The server is %s.<br><br>Visit the <a href="%s"> %s Administration Guide</a> for an overview of server management and configuration.<br>To see server configuration status and to perform some basic administration tasks on the server, click Launch Control Panel. Note that you can launch this tool later using %s.<br><INPUT type="submit" value="Launch Control Panel"></INPUT>
     */
    public static final LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Object, Object, Object> INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY =
                    new LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_INSTALL_FINISHED_SUCCESSFULLY", -1);

    /**
     * <b>Error</b><br>An error occurred. Check 'Details' text area for more information.<br>The server is %s.<br>To see server configuration status and to perform basic administration tasks on the server, click Launch Control Panel. Note that you can launch this tool later using %s.<br><INPUT type="submit" value="Launch Control Panel"></INPUT>
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_SUMMARY_INSTALL_FINISHED_WITH_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_INSTALL_FINISHED_WITH_ERROR", -1);

    /**
     * Starting QuickSetup...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_INSTALL_NOT_STARTED =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_INSTALL_NOT_STARTED", -1);

    /**
     * Starting Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_STARTING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_STARTING", -1);

    /**
     * An error occurred Starting Server. Check 'Details' text area for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_START_ERROR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_START_ERROR", -1);

    /**
     * Server Started Successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_START_SUCCESS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_START_SUCCESS", -1);

    /**
     * Stopping Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_STOPPING =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_STOPPING", -1);

    /**
     * Waiting to Cancel...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_WAITING_TO_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_SUMMARY_WAITING_TO_CANCEL", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TEXTFIELD_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_TEXTFIELD_COLOR", -1);

    /**
     * 000,000,000
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TEXT_AREA_BORDER_COLOR =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_TEXT_AREA_BORDER_COLOR", -1);

    /**
     * There is already a server in the topology
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TOPOLOGY_EXISTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_TOPOLOGY_EXISTS_LABEL", -1);

    /**
     * Check this if you already created a server that you want to replicate data with.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TOPOLOGY_EXISTS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_TOPOLOGY_EXISTS_TOOLTIP", -1);

    /**
     * Use Custom Values for Import (%s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_USE_CUSTOM_IMPORT_RUNTIME =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_USE_CUSTOM_IMPORT_RUNTIME", -1);

    /**
     * Use Custom Values for Server Runtime (%s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_USE_CUSTOM_SERVER_RUNTIME =
                    new LocalizableMessageDescriptor.Arg1<Object>(QuickSetupMessages.class, RESOURCE, "INFO_USE_CUSTOM_SERVER_RUNTIME", -1);

    /**
     * Use an Existing Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USE_EXISTING_CERTIFICATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_USE_EXISTING_CERTIFICATE_LABEL", -1);

    /**
     * Select this if you have already a certificate you want the new server to use.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USE_EXISTING_CERTIFICATE_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_USE_EXISTING_CERTIFICATE_TOOLTIP", -1);

    /**
     * Use Default JVM Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USE_JVM_DEFAULT_SETTINGS =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_USE_JVM_DEFAULT_SETTINGS", -1);

    /**
     * Generate Self-Signed Certificate (recommended for testing only)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USE_SELF_SIGNED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_USE_SELF_SIGNED_LABEL", -1);

    /**
     * Create a new Self-Signed Certificate to encrypt communication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USE_SELF_SIGNED_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_USE_SELF_SIGNED_TOOLTIP", -1);

    /**
     * images/wait.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WAIT", -1);

    /**
     * images/wait_tiny.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT_TINY =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WAIT_TINY", -1);

    /**
     * images/warning_small.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WARNING_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WARNING_ICON", -1);

    /**
     * Warning.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WARNING_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WARNING_ICON_DESCRIPTION", -1);

    /**
     * Warning
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WARNING_ICON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WARNING_ICON_TOOLTIP", -1);

    /**
     * images/warning_large.gif
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WARNING_LARGE_ICON =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WARNING_LARGE_ICON", -1);

    /**
     * The clocks of servers %s and %s have a difference superior to %s minutes. Replication does not require clocks to be synchronized but monitoring of replication updates between servers can be difficult.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_WARNING_SERVERS_CLOCK_DIFFERENCE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_WARNING_SERVERS_CLOCK_DIFFERENCE", -1);

    /**
     * The %s QuickSetup tool will ask you for some basic server and data configuration settings and will get your server up and running quickly.<br><br> %s requires a Java SE %s or higher runtime.<br><br> Additional information on QuickSetup is available on the <a href="%s"> %s documentation site</a>.
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> INFO_WELCOME_PANEL_OFFLINE_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(QuickSetupMessages.class, RESOURCE, "INFO_WELCOME_PANEL_OFFLINE_INSTRUCTIONS", -1);

    /**
     * Welcome
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WELCOME_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WELCOME_PANEL_TITLE", -1);

    /**
     * Welcome
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WELCOME_STEP =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_WELCOME_STEP", -1);

    /**
     * Server Installation Package (.zip)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ZIP_FILES_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(QuickSetupMessages.class, RESOURCE, "INFO_ZIP_FILES_DESCRIPTION", -1);

}
