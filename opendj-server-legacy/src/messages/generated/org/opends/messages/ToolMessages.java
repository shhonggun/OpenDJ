package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.tool}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/tool.properties} and it should not be manually edited.
 */
public final class ToolMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.tool";

    // Prevent instantiation.
    private ToolMessages() {
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
     * Null auth type for this certificate exception
     */
    public static final LocalizableMessageDescriptor.Arg0 ERROR_CERTIFICATE_NULL_AUTH_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERROR_CERTIFICATE_NULL_AUTH_TYPE", -1);

    /**
     * Null chain for this certificate exception
     */
    public static final LocalizableMessageDescriptor.Arg0 ERROR_CERTIFICATE_NULL_CHAIN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERROR_CERTIFICATE_NULL_CHAIN", -1);

    /**
     * Null host name for this certificate exception
     */
    public static final LocalizableMessageDescriptor.Arg0 ERROR_CERTIFICATE_NULL_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERROR_CERTIFICATE_NULL_HOST_NAME", -1);

    /**
     * Error parsing ldap url %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERROR_CERTIFICATE_PARSING_URL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERROR_CERTIFICATE_PARSING_URL", -1);

    /**
     * The provided passwords do not match.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADMINISTRATOR_PWD_DO_NOT_MATCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_ADMINISTRATOR_PWD_DO_NOT_MATCH", -1);

    /**
     * Invalid integer number "%s". Please enter a valid integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BAD_INTEGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BAD_INTEGER", -1);

    /**
     * ERROR:  Unable to bind to port %d.  This port may already be in use, or you may not have permission to bind to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CANNOT_BIND_TO_PORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_CANNOT_BIND_TO_PORT", -1);

    /**
     * ERROR:  Unable to bind to port %d.  This port may already be in use, or you may not have permission to bind to it.  On UNIX-based operating systems, non-root users may not be allowed to bind to ports 1 through 1024
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CANNOT_BIND_TO_PRIVILEGED_PORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_CANNOT_BIND_TO_PRIVILEGED_PORT", -1);

    /**
     * Confirmation tries limit reached (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CONFIRMATION_TRIES_LIMIT_REACHED =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_CONFIRMATION_TRIES_LIMIT_REACHED", -1);

    /**
     * The LDAP bind password was not specified and cannot be read interactively
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_BIND_PASSWORD_NONINTERACTIVE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_ERROR_BIND_PASSWORD_NONINTERACTIVE", -1);

    /**
     * The connection parameters could not be read due to the following error: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_CANNOT_READ_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ERROR_CANNOT_READ_CONNECTION_PARAMETERS", -1);

    /**
     * The property modification "%s" is incompatible with another modification to the same property
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_INCOMPATIBLE_PROPERTY_MOD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ERROR_INCOMPATIBLE_PROPERTY_MOD", -1);

    /**
     * No password was specified for administrator "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_NO_ADMIN_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ERROR_NO_ADMIN_PASSWORD", -1);

    /**
     * Unable to connect to the server at "%s" on port %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FAILED_TO_CONNECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_FAILED_TO_CONNECT", -1);

    /**
     * Unable to connect to the server at %s on port %s. In non-interactive mode, if the trustStore related parameters are not used, you must use the '--trustAll' option for remote connections
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FAILED_TO_CONNECT_NOT_TRUSTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_FAILED_TO_CONNECT_NOT_TRUSTED", -1);

    /**
     * Unable to connect to the server at %s on port %s. Check this port is an administration port
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FAILED_TO_CONNECT_WRONG_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_FAILED_TO_CONNECT_WRONG_PORT", -1);

    /**
     * The hostname "%s" could not be resolved. Please check you have provided the correct address
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_BAD_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_BAD_HOST_NAME", -1);

    /**
     * The provided path is not valid
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_CONN_PROMPT_SECURITY_INVALID_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_PROMPT_SECURITY_INVALID_FILE_PATH", -1);

    /**
     * Unable to resolve keystore aliases: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RESOLVE_KEYSTORE_ALIASES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_RESOLVE_KEYSTORE_ALIASES", -1);

    /**
     * Unable to authenticate using simple authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SIMPLE_BIND_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_SIMPLE_BIND_NOT_SUPPORTED", -1);

    /**
     * Unable to trust the certificate because: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTING_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TRUSTING_CERTIFICATE", -1);

    /**
     * Unable to trust the certificate permanently, certificate will be trusted only for this session. Error details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTING_CERTIFICATE_PERMANENTLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TRUSTING_CERTIFICATE_PERMANENTLY", -1);

    /**
     * An error occurred while reading configuration file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_READING_CONF_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_READING_CONF_FILE", -1);

    /**
     * Confirm Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINISTRATOR_PWD_CONFIRM_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ADMINISTRATOR_PWD_CONFIRM_PROMPT", -1);

    /**
     * Global Administrator Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINISTRATOR_PWD_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ADMINISTRATOR_PWD_PROMPT", -1);

    /**
     * Global Administrator User ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINISTRATOR_UID_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ADMINISTRATOR_UID_PROMPT", -1);

    /**
     * Directory server administration port number [%d]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_ADMIN_CONN_PROMPT_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_ADMIN_CONN_PROMPT_PORT_NUMBER", -1);

    /**
     * Certificate exception cause: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CERTIFICATE_EXCEPTION_CAUSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_CERTIFICATE_EXCEPTION_CAUSE", -1);

    /**
     * The Certificate presented by the server %s:%s could not be trusted.
There is a name mismatch between the name of the server (%s) and the subject DN of the certificate.  This could be caused because you are connected to a server pretending to be %s:%s.
Before accepting this certificate, you should examine the server's certificate carefully.
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> INFO_CERTIFICATE_NAME_MISMATCH_TEXT_CLI =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_CERTIFICATE_NAME_MISMATCH_TEXT_CLI", -1);

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
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_CERTIFICATE_NOT_TRUSTED_TEXT_CLI", -1);

    /**
     * An error occurred connecting to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_CONNECTING_TO_LOCAL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ERROR_CONNECTING_TO_LOCAL", -1);

    /**
     * Global Administrator User ID, or bind DN if no Global Administrator is defined [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_GLOBAL_ADMINISTRATOR_OR_BINDDN_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_GLOBAL_ADMINISTRATOR_OR_BINDDN_PROMPT", -1);

    /**
     * >>>> Specify OpenDJ LDAP connection parameters
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS", -1);

    /**
     * Global Administrator User ID [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_ADMINISTRATOR_UID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_ADMINISTRATOR_UID", -1);

    /**
     * Administrator user bind DN [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_BIND_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_BIND_DN", -1);

    /**
     * Directory server hostname or IP address [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_HOST_NAME", -1);

    /**
     * Directory server port number [%d]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAP_CONN_PROMPT_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_PORT_NUMBER", -1);

    /**
     * %s (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIAS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIAS", -1);

    /**
     * Which certificate do you want to use?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIASES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIASES", -1);

    /**
     * View certificate details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS", -1);

    /**
     * Password for keystore '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PASSWORD", -1);

    /**
     * Keystore path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PATH", -1);

    /**
     * LDAP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_LDAP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_LDAP", -1);

    /**
     * Manually validate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_MANUAL_CHECK =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_MANUAL_CHECK", -1);

    /**
     * %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAP_CONN_PROMPT_SECURITY_PROTOCOL_DEFAULT_CHOICE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_PROTOCOL_DEFAULT_CHOICE", -1);

    /**
     * Server Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE", -1);

    /**
     * Use a truststore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE", -1);

    /**
     * Password for truststore '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PASSWORD", -1);

    /**
     * Truststore path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PATH", -1);

    /**
     * How do you want to trust the server certificate?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_METHOD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_METHOD", -1);

    /**
     * Do you trust this server certificate?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION", -1);

    /**
     * Yes, also add it to a truststore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS", -1);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO", -1);

    /**
     * Yes, for this session only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION", -1);

    /**
     * How do you want to connect?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_SECURE_CTX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_SECURE_CTX", -1);

    /**
     * LDAP with SSL
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_SSL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_SSL", -1);

    /**
     * LDAP with StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_START_TLS", -1);

    /**
     * Automatically trust
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_TRUST_ALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_TRUST_ALL", -1);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE", -1);

    /**
     * Issuer   : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER", -1);

    /**
     * User DN  : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN", -1);

    /**
     * Validity : From '%s'%n             To '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY", -1);

    /**
     * <not available>
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_LABEL", -1);

    /**
     * %s [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROMPT_SINGLE_DEFAULT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_PROMPT_SINGLE_DEFAULT", -1);

    /**
     * No indexes to rebuild for backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_NO_INDEX_TO_REBUILD_FOR_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_NO_INDEX_TO_REBUILD_FOR_BACKEND", -1);

    /**
     * Adding local backend object class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_ADD_LOCAL_BACKEND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_ADD_LOCAL_BACKEND", -1);

    /**
     * Adding subordinate-base-dn attribute to Global configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_ADD_SUBORDINATE_BASE_DN_TO_GLOBAL_CONFIG =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_ADD_SUBORDINATE_BASE_DN_TO_GLOBAL_CONFIG", -1);

    /**
     * Removing subordinate-base-dn attribute from Root DSE configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_DELETE_SUBORDINATE_BASE_DN_FROM_ROOT_DSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_DELETE_SUBORDINATE_BASE_DN_FROM_ROOT_DSE", -1);

    /**
     * remove OpenDJ directory server software
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_UNINSTALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_UNINSTALL", -1);

    /**
     * Unable to create an SSL connection to the server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOLS_CANNOT_CREATE_SSL_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOLS_CANNOT_CREATE_SSL_CONNECTION_1", 1);

    /**
     * Unable to create an SSL connection to the server because the connection factory has not been initialized
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TOOLS_SSL_CONNECTION_NOT_INITIALIZED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_TOOLS_SSL_CONNECTION_NOT_INITIALIZED_2", 2);

    /**
     * Cannot load the key store file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOLS_CANNOT_LOAD_KEYSTORE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOLS_CANNOT_LOAD_KEYSTORE_FILE_3", 3);

    /**
     * Cannot initialize the key manager for the key store:%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOLS_CANNOT_INIT_KEYMANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOLS_CANNOT_INIT_KEYMANAGER_4", 4);

    /**
     * Cannot load the key store file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOLS_CANNOT_LOAD_TRUSTSTORE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOLS_CANNOT_LOAD_TRUSTSTORE_FILE_5", 5);

    /**
     * Cannot initialize the key manager for the key store:%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOLS_CANNOT_INIT_TRUSTMANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOLS_CANNOT_INIT_TRUSTMANAGER_6", 6);

    /**
     * List available password storage schemes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_LISTSCHEMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_LISTSCHEMES_7", 7);

    /**
     * Clear-text password to encode or to compare against an encoded password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_CLEAR_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_CLEAR_PW_8", 8);

    /**
     * Clear-text password file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_CLEAR_PW_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_CLEAR_PW_FILE_9", 9);

    /**
     * Encoded password to compare against the clear-text password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_ENCODED_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_ENCODED_PW_10", 10);

    /**
     * Encoded password file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_ENCODED_PW_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_ENCODED_PW_FILE_11", 11);

    /**
     * Path to the Directory Server configuration file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CONFIG_FILE_13", 13);

    /**
     * Scheme to use for the encoded password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_SCHEME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_SCHEME_14", 14);

    /**
     * An unexpected error occurred while attempting to initialize the command-line arguments:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_ARGS_16", 16);

    /**
     * An error occurred while parsing the command-line arguments:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_PARSING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ERROR_PARSING_ARGS_17", 17);

    /**
     * No clear-text password was specified.  Use --%s, --%s or --%s to specify the password to encode
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENCPW_NO_CLEAR_PW =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_NO_CLEAR_PW_18", 18);

    /**
     * No password storage scheme was specified.  Use the --%s argument to specify the storage scheme
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_NO_SCHEME_19", 19);

    /**
     * An unexpected error occurred while attempting to bootstrap the Directory Server client-side code:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SERVER_BOOTSTRAP_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_SERVER_BOOTSTRAP_ERROR_20", 20);

    /**
     * An error occurred while trying to load the Directory Server configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_LOAD_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_LOAD_CONFIG_21", 21);

    /**
     * An error occurred while trying to load the Directory Server schema:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_LOAD_SCHEMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_LOAD_SCHEMA_22", 22);

    /**
     * An error occurred while trying to initialize the core Directory Server configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_CORE_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_CORE_CONFIG_23", 23);

    /**
     * An error occurred while trying to initialize the Directory Server password storage schemes:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_STORAGE_SCHEMES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_STORAGE_SCHEMES_24", 24);

    /**
     * No password storage schemes have been configured for use in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENCPW_NO_STORAGE_SCHEMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_ENCPW_NO_STORAGE_SCHEMES_25", 25);

    /**
     * Password storage scheme "%s" is not configured for use in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_NO_SUCH_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_NO_SUCH_SCHEME_26", 26);

    /**
     * The provided clear-text and encoded passwords match
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_PASSWORDS_MATCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_PASSWORDS_MATCH_27", 27);

    /**
     * The provided clear-text and encoded passwords do not match
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_PASSWORDS_DO_NOT_MATCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_PASSWORDS_DO_NOT_MATCH_28", 28);

    /**
     * Encoded Password:  "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_ENCODED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_ENCODED_PASSWORD_29", 29);

    /**
     * An error occurred while attempting to encode the clear-text password:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_CANNOT_ENCODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_CANNOT_ENCODE_30", 30);

    /**
     * Path to the LDIF file to be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_LDIF_FILE_33", 33);

    /**
     * Append an existing LDIF file rather than overwriting it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_APPEND_TO_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_APPEND_TO_LDIF_34", 34);

    /**
     * Backend ID for the backend to export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_BACKEND_ID_35", 35);

    /**
     * Base DN of a branch to exclude from the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_BRANCH_36", 36);

    /**
     * Attribute to include in the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_ATTRIBUTE_37", 37);

    /**
     * Attribute to exclude from the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_ATTRIBUTE_38", 38);

    /**
     * Filter to identify entries to include in the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_FILTER_39", 39);

    /**
     * Filter to identify entries to exclude from the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_FILTER_40", 40);

    /**
     * Column at which to wrap long lines (0 for no wrapping)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_WRAP_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_WRAP_COLUMN_41", 41);

    /**
     * Compress the LDIF data as it is exported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_COMPRESS_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_COMPRESS_LDIF_42", 42);

    /**
     * Encrypt the LDIF data as it is exported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_ENCRYPT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_ENCRYPT_LDIF_43", 43);

    /**
     * Generate a signed hash of the export data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_SIGN_HASH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_SIGN_HASH_44", 44);

    /**
     * Unable to decode exclude filter string "%s" as a valid search filter:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFEXPORT_CANNOT_PARSE_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_PARSE_EXCLUDE_FILTER_52", 52);

    /**
     * Unable to decode include filter string "%s" as a valid search filter:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFEXPORT_CANNOT_PARSE_INCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_PARSE_INCLUDE_FILTER_53", 53);

    /**
     * Unable to decode base DN string "%s" as a valid distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DECODE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_DECODE_BASE_DN_54", 54);

    /**
     * Multiple Directory Server backends are configured with the requested backend ID "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFEXPORT_MULTIPLE_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_MULTIPLE_BACKENDS_FOR_ID_55", 55);

    /**
     * None of the Directory Server backends are configured with the requested backend ID "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFEXPORT_NO_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_NO_BACKENDS_FOR_ID_56", 56);

    /**
     * Unable to decode exclude branch string "%s" as a valid distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFEXPORT_CANNOT_DECODE_EXCLUDE_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_DECODE_EXCLUDE_BASE_57", 57);

    /**
     * Unable to decode wrap column value "%s" as an integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFEXPORT_CANNOT_DECODE_WRAP_COLUMN_AS_INTEGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_DECODE_WRAP_COLUMN_AS_INTEGER_58", 58);

    /**
     * An error occurred while attempting to process the LDIF export:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFEXPORT_ERROR_DURING_EXPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_ERROR_DURING_EXPORT_59", 59);

    /**
     * Unable to decode the backend configuration base DN string "%s" as a valid DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DECODE_BACKEND_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_DECODE_BACKEND_BASE_DN_60", 60);

    /**
     * Unable to retrieve the backend configuration base entry "%s" from the server configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_RETRIEVE_BACKEND_BASE_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_RETRIEVE_BACKEND_BASE_ENTRY_61", 61);

    /**
     * Cannot determine the name of the Java class providing the logic for the backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DETERMINE_BACKEND_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_DETERMINE_BACKEND_CLASS_62", 62);

    /**
     * Unable to load class %s referenced in configuration entry %s for use as a Directory Server backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CANNOT_LOAD_BACKEND_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_LOAD_BACKEND_CLASS_63", 63);

    /**
     * Unable to create an instance of class %s referenced in configuration entry %s as a Directory Server backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CANNOT_INSTANTIATE_BACKEND_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INSTANTIATE_BACKEND_CLASS_64", 64);

    /**
     * No base DNs have been defined in backend configuration entry %s.  This backend will not be evaluated
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_BASES_FOR_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_NO_BASES_FOR_BACKEND_65", 65);

    /**
     * Unable to determine the set of base DNs defined in backend configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DETERMINE_BASES_FOR_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_DETERMINE_BASES_FOR_BACKEND_66", 66);

    /**
     * Path to the LDIF file to be imported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_LDIF_FILE_69", 69);

    /**
     * Backend ID for the backend to import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_BACKEND_ID_72", 72);

    /**
     * Base DN of a branch to exclude from the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_BRANCH_73", 73);

    /**
     * Attribute to include in the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_ATTRIBUTE_74", 74);

    /**
     * Attribute to exclude from the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_ATTRIBUTE_75", 75);

    /**
     * Filter to identify entries to include in the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_FILTER_76", 76);

    /**
     * Filter to identify entries to exclude from the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_EXCLUDE_FILTER_77", 77);

    /**
     * Write rejected entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_REJECT_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_REJECT_FILE_78", 78);

    /**
     * Overwrite an existing rejects and/or skip file rather than appending to it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_OVERWRITE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_OVERWRITE_79", 79);

    /**
     * LDIF file is compressed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_IS_COMPRESSED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_IS_COMPRESSED_80", 80);

    /**
     * LDIF file is encrypted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_IS_ENCRYPTED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_IS_ENCRYPTED_81", 81);

    /**
     * Unable to decode exclude filter string "%s" as a valid search filter:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_PARSE_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_PARSE_EXCLUDE_FILTER_89", 89);

    /**
     * Unable to decode include filter string "%s" as a valid search filter:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_PARSE_INCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_PARSE_INCLUDE_FILTER_90", 90);

    /**
     * Imported branches or backend IDs can not span across multiple Directory Server backends
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIFIMPORT_MULTIPLE_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_MULTIPLE_BACKENDS_FOR_ID_92", 92);

    /**
     * None of the Directory Server backends are configured with the requested backend ID or base DNs that include the specified branches
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIFIMPORT_NO_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_NO_BACKENDS_FOR_ID_93", 93);

    /**
     * Unable to decode exclude branch string "%s" as a valid distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_DECODE_EXCLUDE_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_DECODE_EXCLUDE_BASE_94", 94);

    /**
     * An error occurred while trying to open the rejects file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_OPEN_REJECTS_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_OPEN_REJECTS_FILE_95", 95);

    /**
     * An error occurred while attempting to process the LDIF import:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFIMPORT_ERROR_DURING_IMPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_ERROR_DURING_IMPORT_96", 96);

    /**
     * Processing %s request for %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROCESSING_OPERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_PROCESSING_OPERATION_104", 104);

    /**
     * %s operation failed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_OPERATION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_OPERATION_FAILED_105", 105);

    /**
     * %s operation successful for DN %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_OPERATION_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_OPERATION_SUCCESSFUL_106", 106);

    /**
     * Comparing type %s with value %s in entry %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_PROCESSING_COMPARE_OPERATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_PROCESSING_COMPARE_OPERATION_107", 107);

    /**
     * Compare operation returned false for entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_OPERATION_RESULT_FALSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_COMPARE_OPERATION_RESULT_FALSE_108", 108);

    /**
     * Compare operation returned true for entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_OPERATION_RESULT_TRUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_COMPARE_OPERATION_RESULT_TRUE_109", 109);

    /**
     * Invalid operation type returned in search result %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SEARCH_OPERATION_INVALID_PROTOCOL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_SEARCH_OPERATION_INVALID_PROTOCOL_110", 110);

    /**
     * DN to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDDN_112", 112);

    /**
     * Password to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDPASSWORD_113", 113);

    /**
     * Bind password file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDPASSWORDFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDPASSWORDFILE_114", 114);

    /**
     * Use the specified character set for command-line input
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENCODING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENCODING_115", 115);

    /**
     * Use verbose mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_VERBOSE_116", 116);

    /**
     * Certificate key store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_KEYSTOREPATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_KEYSTOREPATH_117", 117);

    /**
     * Certificate trust store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPATH_118", 118);

    /**
     * Certificate key store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_KEYSTOREPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_KEYSTOREPASSWORD_119", 119);

    /**
     * Directory server hostname or IP address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_HOST =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_HOST_120", 120);

    /**
     * Directory server port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PORT_121", 121);

    /**
     * Use a request control with the provided information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONTROLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CONTROLS_123", 123);

    /**
     * Continue processing even if there are errors
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONTINUE_ON_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CONTINUE_ON_ERROR_124", 124);

    /**
     * Use SSL for secure communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_USE_SSL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_USE_SSL_125", 125);

    /**
     * Use StartTLS to secure communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_START_TLS_126", 126);

    /**
     * Use the SASL EXTERNAL authentication mechanism
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_USE_SASL_EXTERNAL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_USE_SASL_EXTERNAL_127", 127);

    /**
     * File containing the DNs of the entries to delete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DELETE_DESCRIPTION_FILENAME_128", 128);

    /**
     * Delete the specified entry and all entries below it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_DESCRIPTION_DELETE_SUBTREE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DELETE_DESCRIPTION_DELETE_SUBTREE_129", 129);

    /**
     * Treat records with no changetype as add operations
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_DESCRIPTION_DEFAULT_ADD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MODIFY_DESCRIPTION_DEFAULT_ADD_130", 130);

    /**
     * Search base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_BASEDN_131", 131);

    /**
     * Maximum number of entries to return from the search
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_SIZE_LIMIT_132", 132);

    /**
     * Maximum length of time in seconds to allow for the search
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_TIME_LIMIT_133", 133);

    /**
     * Search scope ('base', 'one', 'sub', or 'subordinate'). Note: 'subordinate' is an LDAP extension that might not work with all LDAP servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_SEARCH_SCOPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_SEARCH_SCOPE_134", 134);

    /**
     * Alias dereference policy ('never', 'always', 'search', or 'find')
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_DEREFERENCE_POLICY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_DEREFERENCE_POLICY_135", 135);

    /**
     * Cannot send the simple bind request:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_CANNOT_SEND_SIMPLE_BIND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_SEND_SIMPLE_BIND_136", 136);

    /**
     * Cannot read the bind response from the server. The port you are using may require a secured communication (--useSSL). %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_CANNOT_READ_BIND_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_READ_BIND_RESPONSE_137", 137);

    /**
     * The Directory Server indicated that it was closing the connection to the client (result code %d, message "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAPAUTH_SERVER_DISCONNECT =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_SERVER_DISCONNECT_138", 138);

    /**
     * The Directory Server sent an unexpected extended response message to the client:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_UNEXPECTED_EXTENDED_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_EXTENDED_RESPONSE_139", 139);

    /**
     * The Directory Server sent an unexpected response message to the client:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_UNEXPECTED_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_RESPONSE_140", 140);

    /**
     * The simple bind attempt failed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_SIMPLE_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_SIMPLE_BIND_FAILED_141", 141);

    /**
     * A SASL bind was requested but no SASL mechanism was specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_NO_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NO_SASL_MECHANISM_142", 142);

    /**
     * The requested SASL mechanism "%s" is not supported by this client
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_UNSUPPORTED_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNSUPPORTED_SASL_MECHANISM_143", 143);

    /**
     * The trace SASL property may only be given a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_TRACE_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_TRACE_SINGLE_VALUED_144", 144);

    /**
     * Property "%s" is not allowed for the %s SASL mechanism
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_INVALID_SASL_PROPERTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_INVALID_SASL_PROPERTY_145", 145);

    /**
     * Cannot send the SASL %S bind request:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_CANNOT_SEND_SASL_BIND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_SEND_SASL_BIND_146", 146);

    /**
     * The SASL %s bind attempt failed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_SASL_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_SASL_BIND_FAILED_147", 147);

    /**
     * No SASL properties were provided for use with the %s mechanism
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_NO_SASL_PROPERTIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NO_SASL_PROPERTIES_148", 148);

    /**
     * The "authid" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_AUTHID_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_AUTHID_SINGLE_VALUED_149", 149);

    /**
     * The "authid" SASL property is required for use with the %s mechanism
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_SASL_AUTHID_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_SASL_AUTHID_REQUIRED_150", 150);

    /**
     * Cannot send the initial bind request in the multi-stage %s bind to the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_CANNOT_SEND_INITIAL_SASL_BIND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_SEND_INITIAL_SASL_BIND_151", 151);

    /**
     * Cannot read the initial %s bind response from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_CANNOT_READ_INITIAL_BIND_RESPONSE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_READ_INITIAL_BIND_RESPONSE_152", 152);

    /**
     * The client received an unexpected intermediate bind response.  The "SASL bind in progress" result was expected for the first response in the multi-stage %s bind process, but the bind response had a result code of %d (%s) and an error message of "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDAPAUTH_UNEXPECTED_INITIAL_BIND_RESPONSE =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_INITIAL_BIND_RESPONSE_153", 153);

    /**
     * The initial bind response from the server did not include any server SASL credentials containing the challenge information needed to complete the CRAM-MD5 authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_NO_CRAMMD5_SERVER_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NO_CRAMMD5_SERVER_CREDENTIALS_154", 154);

    /**
     * An unexpected error occurred while trying to initialize the MD5 digest generator:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_CANNOT_INITIALIZE_MD5_DIGEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_INITIALIZE_MD5_DIGEST_155", 155);

    /**
     * Cannot send the second bind request in the multi-stage %s bind to the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_CANNOT_SEND_SECOND_SASL_BIND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_SEND_SECOND_SASL_BIND_156", 156);

    /**
     * Cannot read the second %s bind response from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_CANNOT_READ_SECOND_BIND_RESPONSE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_READ_SECOND_BIND_RESPONSE_157", 157);

    /**
     * One or more SASL properties were provided, but the %s mechanism does not take any SASL properties
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_NO_ALLOWED_SASL_PROPERTIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NO_ALLOWED_SASL_PROPERTIES_158", 158);

    /**
     * The "authzid" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_AUTHZID_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_AUTHZID_SINGLE_VALUED_159", 159);

    /**
     * The "realm" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_REALM_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_REALM_SINGLE_VALUED_160", 160);

    /**
     * The "qop" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_QOP_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_QOP_SINGLE_VALUED_161", 161);

    /**
     * The "%s" QoP mode is not supported by this client.  Only the "auth" mode is currently available for use
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_QOP_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_QOP_NOT_SUPPORTED_162", 162);

    /**
     * The specified DIGEST-MD5 quality of protection mode "%s" is not valid.  The only QoP mode currently supported is "auth"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_INVALID_QOP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_INVALID_QOP_163", 163);

    /**
     * The "digest-uri" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_DIGEST_URI_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGEST_URI_SINGLE_VALUED_164", 164);

    /**
     * The initial bind response from the server did not include any server SASL credentials containing the challenge information needed to complete the DIGEST-MD5 authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_NO_DIGESTMD5_SERVER_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NO_DIGESTMD5_SERVER_CREDENTIALS_165", 165);

    /**
     * The DIGEST-MD5 credentials provided by the server contained an invalid token of "%s" starting at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPAUTH_DIGESTMD5_INVALID_TOKEN_IN_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_INVALID_TOKEN_IN_CREDENTIALS_166", 166);

    /**
     * The DIGEST-MD5 credentials provided by the server specified the use of the "%s" character set.  The character set that may be specified in the DIGEST-MD5 credentials is "utf-8"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_INVALID_CHARSET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_INVALID_CHARSET_167", 167);

    /**
     * The requested QoP mode of "%s" is not listed as supported by the Directory Server.  The Directory Server's list of supported QoP modes is:  "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_REQUESTED_QOP_NOT_SUPPORTED_BY_SERVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_REQUESTED_QOP_NOT_SUPPORTED_BY_SERVER_168", 168);

    /**
     * The server SASL credentials provided in response to the initial DIGEST-MD5 bind request did not include the nonce to use to generate the authentication digests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_DIGESTMD5_NO_NONCE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_NO_NONCE_169", 169);

    /**
     * An error occurred while attempting to generate the response digest for the DIGEST-MD5 bind request:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_CANNOT_CREATE_RESPONSE_DIGEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_CANNOT_CREATE_RESPONSE_DIGEST_170", 170);

    /**
     * The DIGEST-MD5 bind response from the server did not include the "rspauth" element to provide a digest of the response authentication information
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_DIGESTMD5_NO_RSPAUTH_CREDS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_NO_RSPAUTH_CREDS_171", 171);

    /**
     * An error occurred while trying to decode the rspauth element of the DIGEST-MD5 bind response from the server as a hexadecimal string:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_COULD_NOT_DECODE_RSPAUTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_COULD_NOT_DECODE_RSPAUTH_172", 172);

    /**
     * An error occurred while trying to calculate the expected rspauth element to compare against the value included in the DIGEST-MD5 response from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_DIGESTMD5_COULD_NOT_CALCULATE_RSPAUTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_COULD_NOT_CALCULATE_RSPAUTH_173", 173);

    /**
     * The rpsauth element included in the DIGEST-MD5 bind response from the Directory Server was different from the expected value calculated by the client
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_DIGESTMD5_RSPAUTH_MISMATCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_RSPAUTH_MISMATCH_174", 174);

    /**
     * The DIGEST-MD5 response challenge could not be parsed because it had an invalid quotation mark at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAPAUTH_DIGESTMD5_INVALID_CLOSING_QUOTE_POS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_DIGESTMD5_INVALID_CLOSING_QUOTE_POS_175", 175);

    /**
     * Text string that may be written to the Directory Server error log as trace information for the bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_TRACE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_TRACE_176", 176);

    /**
     * Authentication ID for the bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_AUTHID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_AUTHID_177", 177);

    /**
     * Realm into which the authentication is to be performed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_REALM =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_REALM_178", 178);

    /**
     * Quality of protection to use for the bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_QOP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_QOP_179", 179);

    /**
     * Digest URI to use for the bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_DIGEST_URI =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_DIGEST_URI_180", 180);

    /**
     * Authorization ID to use for the bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_AUTHZID_181", 181);

    /**
     * SASL bind options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SASL_PROPERTIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SASL_PROPERTIES_182", 182);

    /**
     * KDC to use for the Kerberos authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_PROPERTY_DESCRIPTION_KDC =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PROPERTY_DESCRIPTION_KDC_183", 183);

    /**
     * The "kdc" SASL property only accepts a single value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_KDC_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_KDC_SINGLE_VALUED_184", 184);

    /**
     * The specified GSSAPI quality of protection mode "%s" is not valid.  The only QoP mode currently supported is "auth"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_INVALID_QOP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_INVALID_QOP_185", 185);

    /**
     * An error occurred while trying to create the temporary JAAS configuration for GSSAPI authentication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_JAAS_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_JAAS_CONFIG_186", 186);

    /**
     * An error occurred while attempting to perform local authentication to the Kerberos realm:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_LOCAL_AUTHENTICATION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_LOCAL_AUTHENTICATION_FAILED_187", 187);

    /**
     * An error occurred while attempting to perform GSSAPI authentication to the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_REMOTE_AUTHENTICATION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_REMOTE_AUTHENTICATION_FAILED_188", 188);

    /**
     * The LDAPAuthenticationHandler.run() method was called for a non-SASL bind.  The backtrace for this call is %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_NONSASL_RUN_INVOCATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NONSASL_RUN_INVOCATION_189", 189);

    /**
     * The LDAPAuthenticationHandler.run() method was called for a SASL bind with an unexpected mechanism of "%s".  The backtrace for this call is %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_UNEXPECTED_RUN_INVOCATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_RUN_INVOCATION_190", 190);

    /**
     * An error occurred while attempting to create a SASL client to process the GSSAPI authentication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_SASL_CLIENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_SASL_CLIENT_191", 191);

    /**
     * An error occurred while attempting to create the initial challenge for GSSAPI authentication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_INITIAL_CHALLENGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_CANNOT_CREATE_INITIAL_CHALLENGE_192", 192);

    /**
     * An error occurred while trying to validate the SASL credentials provided by the Directory Server in the GSSAPI bind response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_CANNOT_VALIDATE_SERVER_CREDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_CANNOT_VALIDATE_SERVER_CREDS_193", 193);

    /**
     * The Directory Server unexpectedly returned a success response to the client even though the client does not believe that the GSSAPI negotiation is complete
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_GSSAPI_UNEXPECTED_SUCCESS_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_UNEXPECTED_SUCCESS_RESPONSE_194", 194);

    /**
     * The GSSAPI bind attempt failed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_GSSAPI_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_BIND_FAILED_195", 195);

    /**
     * The LDAPAuthenticationHandler.handle() method was called for a non-SASL bind. The backtrace for this call is %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_NONSASL_CALLBACK_INVOCATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_NONSASL_CALLBACK_INVOCATION_196", 196);

    /**
     * The LDAPAuthenticationHandler.handle() method was called during a GSSAPI bind attempt with an unexpected callback type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_UNEXPECTED_GSSAPI_CALLBACK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_GSSAPI_CALLBACK_197", 197);

    /**
     * The LDAPAuthenticationHandler.handle() method was called for an unexpected SASL mechanism of %s.  The backtrace for this call is %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPAUTH_UNEXPECTED_CALLBACK_INVOCATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_UNEXPECTED_CALLBACK_INVOCATION_198", 198);

    /**
     * Password for user '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPAUTH_PASSWORD_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_PASSWORD_PROMPT_199", 199);

    /**
     * LDAP protocol version number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_VERSION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_VERSION_200", 200);

    /**
     * Invalid LDAP version number '%s'. Allowed values are 2 and 3
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DESCRIPTION_INVALID_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_DESCRIPTION_INVALID_VERSION_201", 201);

    /**
     * Cannot send the 'Who Am I?' request to the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_CANNOT_SEND_WHOAMI_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_SEND_WHOAMI_REQUEST_202", 202);

    /**
     * Cannot read the 'Who Am I?' response from the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_CANNOT_READ_WHOAMI_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CANNOT_READ_WHOAMI_RESPONSE_203", 203);

    /**
     * The 'Who Am I?' request was rejected by the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_WHOAMI_FAILED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_WHOAMI_FAILED_204", 204);

    /**
     * Invalid scope '%s' specified for the search request
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_INVALID_SEARCH_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_SEARCH_INVALID_SEARCH_SCOPE_205", 205);

    /**
     * No filters specified for the search request
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_NO_FILTERS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_SEARCH_NO_FILTERS_206", 206);

    /**
     * Base DN of a backend supporting indexing. Verification is performed on indexes within the scope of the given base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFYINDEX_DESCRIPTION_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VERIFYINDEX_DESCRIPTION_BASE_DN_207", 207);

    /**
     * Name of an index to be verified. For an attribute index this is simply an attribute name. Multiple indexes may be verified for completeness, or all indexes if no indexes are specified.  An index is complete if each index value references all entries containing that value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFYINDEX_DESCRIPTION_INDEX_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VERIFYINDEX_DESCRIPTION_INDEX_NAME_208", 208);

    /**
     * Specifies that a single index should be verified to ensure it is clean.  An index is clean if each index value references only entries containing that value.  Only one index at a time may be verified in this way
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFYINDEX_DESCRIPTION_VERIFY_CLEAN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VERIFYINDEX_DESCRIPTION_VERIFY_CLEAN_209", 209);

    /**
     * An error occurred while attempting to perform index verification:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VERIFYINDEX_ERROR_DURING_VERIFY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_VERIFYINDEX_ERROR_DURING_VERIFY_210", 210);

    /**
     * Only one index at a time may be verified for cleanliness
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_VERIFYINDEX_VERIFY_CLEAN_REQUIRES_SINGLE_INDEX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_VERIFYINDEX_VERIFY_CLEAN_REQUIRES_SINGLE_INDEX_211", 211);

    /**
     * The backend does not support indexing
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BACKEND_NO_INDEXING_SUPPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_BACKEND_NO_INDEXING_SUPPORT_212", 212);

    /**
     * The Directory Server backend with backend ID "%s" does not provide a mechanism for performing LDIF exports
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFEXPORT_CANNOT_EXPORT_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_EXPORT_BACKEND_213", 213);

    /**
     * The Directory Server backend with backend ID %s does not provide a mechanism for performing LDIF imports
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFIMPORT_CANNOT_IMPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_IMPORT_214", 214);

    /**
     * Do not wrap long lines
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DONT_WRAP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_DONT_WRAP_215", 215);

    /**
     * Base DN of a branch to include in the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_INCLUDE_BRANCH_216", 216);

    /**
     * Cannot determine the backend ID for the backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DETERMINE_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_DETERMINE_BACKEND_ID_217", 217);

    /**
     * Unable to decode include branch string "%s" as a valid distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_DECODE_INCLUDE_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_DECODE_INCLUDE_BASE_218", 218);

    /**
     * Provided include base DN "%s" is not handled by the backend with backend ID %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_INVALID_INCLUDE_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_INVALID_INCLUDE_BASE_219", 219);

    /**
     * Multiple Directory Server backends are configured to support base DN "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MULTIPLE_BACKENDS_FOR_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_MULTIPLE_BACKENDS_FOR_BASE_230", 230);

    /**
     * None of the Directory Server backends are configured to support the requested base DN "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_BACKENDS_FOR_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_NO_BACKENDS_FOR_BASE_231", 231);

    /**
     * Base DN of a branch to include in the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_INCLUDE_BRANCH_240", 240);

    /**
     * Provided include base DN "%s" is not handled by the backend with backend ID %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFEXPORT_INVALID_INCLUDE_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_INVALID_INCLUDE_BASE_242", 242);

    /**
     * Backend ID for the backend to archive
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_BACKEND_ID_245", 245);

    /**
     * Use the provided identifier for the backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_BACKUP_ID_246", 246);

    /**
     * Path to the target directory for the backup file(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_BACKUP_DIR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_BACKUP_DIR_247", 247);

    /**
     * Perform an incremental backup rather than a full backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_INCREMENTAL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_INCREMENTAL_248", 248);

    /**
     * Compress the backup contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_COMPRESS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_COMPRESS_249", 249);

    /**
     * Encrypt the backup contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_ENCRYPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_ENCRYPT_250", 250);

    /**
     * Generate a hash of the backup contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_HASH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_HASH_251", 251);

    /**
     * Sign the hash of the backup contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_SIGN_HASH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_SIGN_HASH_252", 252);

    /**
     * None of the Directory Server backends are configured with the requested backend ID "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDB_NO_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_NO_BACKENDS_FOR_ID_261", 261);

    /**
     * The target backend %s cannot be backed up using the requested configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDB_CANNOT_BACKUP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_BACKUP_264", 264);

    /**
     * An error occurred while attempting to back up backend %s with the requested configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_ERROR_DURING_BACKUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_ERROR_DURING_BACKUP_265", 265);

    /**
     * Back up all backends in the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_BACKUP_ALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_BACKUP_ALL_274", 274);

    /**
     * The %s and %s arguments may not be used together.  Exactly one of them must be provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_CANNOT_MIX_BACKUP_ALL_AND_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_MIX_BACKUP_ALL_AND_BACKEND_ID_275", 275);

    /**
     * Neither the %s argument nor the %s argument was provided.  Exactly one of them is required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_NEED_BACKUP_ALL_OR_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_NEED_BACKUP_ALL_OR_BACKEND_ID_276", 276);

    /**
     * An error occurred while attempting to create the backup directory %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_CANNOT_CREATE_BACKUP_DIR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_CREATE_BACKUP_DIR_277", 277);

    /**
     * Backend ID %s was included in the set of backends to archive, but this backend does not provide support for a backup mechanism.  It will be skipped
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BACKUPDB_BACKUP_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_BACKUPDB_BACKUP_NOT_SUPPORTED_278", 278);

    /**
     * None of the target backends provide a backup mechanism.  The backup operation has been aborted
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_BACKUPDB_NO_BACKENDS_TO_ARCHIVE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "WARN_BACKUPDB_NO_BACKENDS_TO_ARCHIVE_279", 279);

    /**
     * Starting backup for backend %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BACKUPDB_STARTING_BACKUP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "NOTE_BACKUPDB_STARTING_BACKUP_280", 280);

    /**
     * An error occurred while attempting to parse the backup descriptor file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_CANNOT_PARSE_BACKUP_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_PARSE_BACKUP_DESCRIPTOR_281", 281);

    /**
     * The backup process completed with one or more errors
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_BACKUPDB_COMPLETED_WITH_ERRORS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "NOTE_BACKUPDB_COMPLETED_WITH_ERRORS_282", 282);

    /**
     * The backup process completed successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_BACKUPDB_COMPLETED_SUCCESSFULLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "NOTE_BACKUPDB_COMPLETED_SUCCESSFULLY_283", 283);

    /**
     * An error occurred while attempting to initialize the crypto manager:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_CRYPTO_MANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_CRYPTO_MANAGER_284", 284);

    /**
     * An error occurred while attempting to initialize the subentry manager:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_SUBENTRY_MANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_SUBENTRY_MANAGER_285", 285);

    /**
     * An error occurred while attempting to initialize the root DN manager:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_ROOTDN_MANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_ROOTDN_MANAGER_286", 286);

    /**
     * Backup ID of the source archive for an incremental backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_DESCRIPTION_INCREMENTAL_BASE_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_DESCRIPTION_INCREMENTAL_BASE_ID_287", 287);

    /**
     * The use of the %s argument requires that the %s argument is also provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_INCREMENTAL_BASE_REQUIRES_INCREMENTAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_INCREMENTAL_BASE_REQUIRES_INCREMENTAL_288", 288);

    /**
     * Backup ID of the backup to restore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTOREDB_DESCRIPTION_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_DESCRIPTION_BACKUP_ID_292", 292);

    /**
     * Path to the directory containing the backup file(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTOREDB_DESCRIPTION_BACKUP_DIR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_DESCRIPTION_BACKUP_DIR_293", 293);

    /**
     * List available backups in the backup directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTOREDB_DESCRIPTION_LIST_BACKUPS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_DESCRIPTION_LIST_BACKUPS_294", 294);

    /**
     * Verify the contents of the backup but do not restore it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTOREDB_DESCRIPTION_VERIFY_ONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_DESCRIPTION_VERIFY_ONLY_295", 295);

    /**
     * An error occurred while attempting to examine the set of backups contained in backup directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESTOREDB_CANNOT_READ_BACKUP_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_CANNOT_READ_BACKUP_DIRECTORY_304", 304);

    /**
     * Backup ID:          %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_BACKUP_ID_305", 305);

    /**
     * Backup Date:        %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_BACKUP_DATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_BACKUP_DATE_306", 306);

    /**
     * Is Incremental:     %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_INCREMENTAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_INCREMENTAL_307", 307);

    /**
     * Is Compressed:      %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_COMPRESSED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_COMPRESSED_308", 308);

    /**
     * Is Encrypted:       %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_ENCRYPTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_ENCRYPTED_309", 309);

    /**
     * Has Unsigned Hash:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_HASHED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_HASHED_310", 310);

    /**
     * Has Signed Hash:    %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_SIGNED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_SIGNED_311", 311);

    /**
     * Dependent Upon:     %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESTOREDB_LIST_DEPENDENCIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_LIST_DEPENDENCIES_312", 312);

    /**
     * The requested backup ID %s does not exist in %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESTOREDB_INVALID_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_INVALID_BACKUP_ID_313", 313);

    /**
     * There are no Directory Server backups contained in %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RESTOREDB_NO_BACKUPS_IN_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_NO_BACKUPS_IN_DIRECTORY_314", 314);

    /**
     * The backups contained in directory %s were taken from a Directory Server backend defined in configuration entry %s but no such backend is available
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESTOREDB_NO_BACKENDS_FOR_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_NO_BACKENDS_FOR_DN_315", 315);

    /**
     * The Directory Server backend configured with backend ID %s does not provide a mechanism for restoring backups
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RESTOREDB_CANNOT_RESTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_CANNOT_RESTORE_316", 316);

    /**
     * An unexpected error occurred while attempting to restore backup %s from %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RESTOREDB_ERROR_DURING_BACKUP =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_ERROR_DURING_BACKUP_317", 317);

    /**
     * Restoring an encrypted or signed backup requires a connection to an online server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RESTOREDB_ENCRYPT_OR_SIGN_REQUIRES_ONLINE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_ENCRYPT_OR_SIGN_REQUIRES_ONLINE_318", 318);

    /**
     * The use of the %s argument or the %s argument requires a connection to an online server instance
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_ENCRYPT_OR_SIGN_REQUIRES_ONLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_ENCRYPT_OR_SIGN_REQUIRES_ONLINE_325", 325);

    /**
     * The use of the %s argument requires that the %s argument is also provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_SIGN_REQUIRES_HASH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_SIGN_REQUIRES_HASH_326", 326);

    /**
     * Show what would be done but do not perform any operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_NOOP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_NOOP_327", 327);

    /**
     * An error occurred while attempting to acquire a shared lock for backend %s:  %s.  This generally means that some other process has exclusive access to this backend (e.g., a restore or an LDIF import).  This backend will not be archived
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDB_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_LOCK_BACKEND_328", 328);

    /**
     * An error occurred while attempting to release the shared lock for backend %s:  %s.  This lock should automatically be cleared when the backup process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BACKUPDB_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_BACKUPDB_CANNOT_UNLOCK_BACKEND_329", 329);

    /**
     * An error occurred while attempting to acquire an exclusive lock for backend %s:  %s.  This generally means some other process is still using this backend (e.g., it is in use by the Directory Server or a backup or LDIF export is in progress).  The restore cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESTOREDB_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_RESTOREDB_CANNOT_LOCK_BACKEND_330", 330);

    /**
     * An error occurred while attempting to release the exclusive lock for backend %s:  %s.  This lock should automatically be cleared when the restore process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_RESTOREDB_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_RESTOREDB_CANNOT_UNLOCK_BACKEND_331", 331);

    /**
     * An error occurred while attempting to acquire an exclusive lock for backend %s:  %s.  This generally means some other process is still using this backend (e.g., it is in use by the Directory Server or a backup or LDIF export is in progress).  The LDIF import cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_LOCK_BACKEND_332", 332);

    /**
     * An error occurred while attempting to release the exclusive lock for backend %s:  %s.  This lock should automatically be cleared when the import process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LDIFIMPORT_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_LDIFIMPORT_CANNOT_UNLOCK_BACKEND_333", 333);

    /**
     * An error occurred while attempting to acquire a shared lock for backend %s:  %s.  This generally means that some other process has an exclusive lock on this backend (e.g., an LDIF import or a restore).  The LDIF export cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFEXPORT_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFEXPORT_CANNOT_LOCK_BACKEND_334", 334);

    /**
     * An error occurred while attempting to release the shared lock for backend %s:  %s.  This lock should automatically be cleared when the export process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LDIFEXPORT_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_LDIFEXPORT_CANNOT_UNLOCK_BACKEND_335", 335);

    /**
     * An error occurred while attempting to acquire a shared lock for backend %s:  %s.  This generally means that some other process has an exclusive lock on this backend (e.g., an LDIF import or a restore).  The index verification cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFYINDEX_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_VERIFYINDEX_CANNOT_LOCK_BACKEND_336", 336);

    /**
     * An error occurred while attempting to release the shared lock for backend %s:  %s.  This lock should automatically be cleared when the verification process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_VERIFYINDEX_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_VERIFYINDEX_CANNOT_UNLOCK_BACKEND_337", 337);

    /**
     * Only retrieve attribute names but not their values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TYPES_ONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TYPES_ONLY_338", 338);

    /**
     * Skip schema validation during the LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_SKIP_SCHEMA_VALIDATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_SKIP_SCHEMA_VALIDATION_339", 339);

    /**
     * Use the LDAP assertion control with the provided filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ASSERTION_FILTER_342", 342);

    /**
     * The search filter provided for the LDAP assertion control was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ASSERTION_INVALID_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_ASSERTION_INVALID_FILTER_343", 343);

    /**
     * Use the LDAP ReadEntry pre-read control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PREREAD_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PREREAD_ATTRS_346", 346);

    /**
     * Use the LDAP ReadEntry post-read control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_POSTREAD_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_POSTREAD_ATTRS_347", 347);

    /**
     * An error occurred while trying to decode the entry contained in the value of the pre-read response control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPMODIFY_PREREAD_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPMODIFY_PREREAD_CANNOT_DECODE_VALUE_349", 349);

    /**
     * Target entry before the operation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_PREREAD_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPMODIFY_PREREAD_ENTRY_350", 350);

    /**
     * An error occurred while trying to decode the entry contained in the value of the post-read response control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPMODIFY_POSTREAD_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPMODIFY_POSTREAD_CANNOT_DECODE_VALUE_352", 352);

    /**
     * Target entry after the operation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_POSTREAD_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPMODIFY_POSTREAD_ENTRY_353", 353);

    /**
     * Use the proxied authorization control with the given authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PROXY_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PROXY_AUTHZID_354", 354);

    /**
     * Use the persistent search control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PSEARCH_INFO =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PSEARCH_INFO_355", 355);

    /**
     * The request to use the persistent search control did not include a descriptor that indicates the options to use with that control
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PSEARCH_MISSING_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PSEARCH_MISSING_DESCRIPTOR_356", 356);

    /**
     * The persistent search descriptor %s did not start with the required 'ps' string
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_DOESNT_START_WITH_PS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PSEARCH_DOESNT_START_WITH_PS_357", 357);

    /**
     * The provided change type value %s is invalid.  The recognized change types are add, delete, modify, modifydn, and any
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_CHANGE_TYPE_358", 358);

    /**
     * The provided changesOnly value %s is invalid.  Allowed values are 1 to only return matching entries that have changed since the beginning of the search, or 0 to also include existing entries that match the search criteria
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_CHANGESONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_CHANGESONLY_359", 359);

    /**
     * The provided returnECs value %s is invalid.  Allowed values are 1 to request that the entry change notification control be included in updated entries, or 0 to exclude the control from matching entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_RETURN_ECS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_RETURN_ECS_360", 360);

    /**
     * Use the authorization identity control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REPORT_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REPORT_AUTHZID_361", 361);

    /**
     * # Bound with authorization ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_BIND_AUTHZID_RETURNED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_BIND_AUTHZID_RETURNED_362", 362);

    /**
     * File containing a list of search filter strings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_FILENAME_363", 363);

    /**
     * Use the LDAP matched values control with the provided filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_MATCHED_VALUES_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_MATCHED_VALUES_FILTER_364", 364);

    /**
     * The provided matched values filter was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MATCHEDVALUES_INVALID_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_MATCHEDVALUES_INVALID_FILTER_365", 365);

    /**
     * An error occurred while attempting to open the LDIF file %s for reading:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_FILE_CANNOT_OPEN_FOR_READ =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIF_FILE_CANNOT_OPEN_FOR_READ_366", 366);

    /**
     * An error occurred while attempting to read the contents of LDIF file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_FILE_READ_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIF_FILE_READ_ERROR_367", 367);

    /**
     * Error at or near line %d in LDIF file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_FILE_INVALID_LDIF_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIF_FILE_INVALID_LDIF_ENTRY_368", 368);

    /**
     * Use the authentication password syntax rather than the user password syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_AUTHPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_AUTHPW_369", 369);

    /**
     * Authentication password storage scheme "%s" is not configured for use in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_NO_SUCH_AUTH_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_NO_SUCH_AUTH_SCHEME_371", 371);

    /**
     * The provided password is not a valid encoded authentication password value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_INVALID_ENCODED_AUTHPW =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_INVALID_ENCODED_AUTHPW_372", 372);

    /**
     * An error occurred while attempting to initialize the password policy components:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_PWPOLICY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_PWPOLICY_373", 373);

    /**
     * Directory server hostname or IP address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_HOST =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_HOST_374", 374);

    /**
     * Directory server administration port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_PORT_375", 375);

    /**
     * DN to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_BINDDN_378", 378);

    /**
     * Password to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_BINDPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_BINDPW_379", 379);

    /**
     * Bind password file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_BINDPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_BINDPWFILE_380", 380);

    /**
     * SASL bind options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_SASLOPTIONS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_SASLOPTIONS_381", 381);

    /**
     * Use the proxied authorization control with the given authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_PROXYAUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_PROXYAUTHZID_382", 382);

    /**
     * Reason the server is being stopped or restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_STOP_REASON =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_STOP_REASON_383", 383);

    /**
     * Indicates the date/time at which the shutdown operation will begin as a server task expressed in format YYYYMMDDhhmmssZ for UTC time or YYYYMMDDhhmmss for local time.  A value of '0' will cause the shutdown to be scheduled for immediate execution.  When this option is specified the operation will be scheduled to start at the specified time after which this utility will exit immediately
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_STOP_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_STOP_TIME_384", 384);

    /**
     * Certificate key store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_KSFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_KSFILE_386", 386);

    /**
     * Certificate key store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_KSPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_KSPW_387", 387);

    /**
     * Certificate key store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_KSPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_KSPWFILE_388", 388);

    /**
     * Certificate trust store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_TSFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_TSFILE_389", 389);

    /**
     * Certificate trust store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_TSPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_TSPW_390", 390);

    /**
     * Certificate trust store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_TSPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_TSPWFILE_391", 391);

    /**
     * ERROR:  You may not provide both the %s and the %s arguments
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STOPDS_MUTUALLY_EXCLUSIVE_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_MUTUALLY_EXCLUSIVE_ARGUMENTS_395", 395);

    /**
     * ERROR:  Unable to decode the provided stop time.  It should be in the form YYYYMMDDhhmmssZ for UTC time or YYYYMMDDhhmmss for local time
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STOPDS_CANNOT_DECODE_STOP_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_DECODE_STOP_TIME_396", 396);

    /**
     * ERROR:  Unable to perform SSL initialization:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_CANNOT_INITIALIZE_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_INITIALIZE_SSL_397", 397);

    /**
     * ERROR:  The provided SASL option string "%s" could not be parsed in the form "name=value"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_CANNOT_PARSE_SASL_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_PARSE_SASL_OPTION_398", 398);

    /**
     * ERROR:  One or more SASL options were provided, but none of them were the "mech" option to specify which SASL mechanism should be used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STOPDS_NO_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_STOPDS_NO_SASL_MECHANISM_399", 399);

    /**
     * ERROR:  Cannot parse the value of the %s argument as an integer value between 1 and 65535:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STOPDS_CANNOT_DETERMINE_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_DETERMINE_PORT_400", 400);

    /**
     * ERROR:  Cannot establish a connection to the Directory Server %s.  Verify that the server is running and that the provided credentials are valid.  Details:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STOPDS_CANNOT_CONNECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_CONNECT_401", 401);

    /**
     * NOTICE:  The connection to the Directory Server was closed while waiting for a response to the shutdown request.  This likely means that the server has started the shutdown process
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STOPDS_UNEXPECTED_CONNECTION_CLOSURE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_STOPDS_UNEXPECTED_CONNECTION_CLOSURE_402", 402);

    /**
     * ERROR:  An I/O error occurred while attempting to communicate with the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_IO_ERROR_403", 403);

    /**
     * ERROR:  An error occurred while trying to decode the response from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_DECODE_ERROR_404", 404);

    /**
     * ERROR:  Expected an add response message but got a %s message instead
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_INVALID_RESPONSE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_INVALID_RESPONSE_TYPE_405", 405);

    /**
     * # Your password has expired
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_PASSWORD_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BIND_PASSWORD_EXPIRED_406", 406);

    /**
     * # Your password will expire in %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_BIND_PASSWORD_EXPIRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_BIND_PASSWORD_EXPIRING_407", 407);

    /**
     * # Your account has been locked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_ACCOUNT_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BIND_ACCOUNT_LOCKED_408", 408);

    /**
     * # You must change your password before any other operations will be allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_MUST_CHANGE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BIND_MUST_CHANGE_PASSWORD_409", 409);

    /**
     * # You have %d grace logins remaining
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_BIND_GRACE_LOGINS_REMAINING =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_BIND_GRACE_LOGINS_REMAINING_410", 410);

    /**
     * Use the password policy request control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_USE_PWP_CONTROL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_USE_PWP_CONTROL_411", 411);

    /**
     * File containing the DNs of the entries to compare
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COMPARE_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_COMPARE_DESCRIPTION_FILENAME_413", 413);

    /**
     * LDIF file containing the data to search.  Multiple files may be specified by providing the option multiple times.  If no files are provided, the data will be read from standard input
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_LDIF_FILE_414", 414);

    /**
     * The base DN for the search.  Multiple base DNs may be specified by providing the option multiple times.  If no base DN is provided, then the root DSE will be used
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_BASEDN_415", 415);

    /**
     * The scope for the search.  It must be one of 'base', 'one', 'sub', or 'subordinate'.  If it is not provided, then 'sub' will be used
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_SCOPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_SCOPE_416", 416);

    /**
     * The path to the file containing the search filter(s) to use.  If this is not provided, then the filter must be provided on the command line after all configuration options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_FILTER_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_FILTER_FILE_419", 419);

    /**
     * The path to the output file to which the matching entries should be written.  If this is not provided, then the data will be written to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_OUTPUT_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_OUTPUT_FILE_420", 420);

    /**
     * Any existing output file should be overwritten rather than appending to it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_OVERWRITE_EXISTING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_OVERWRITE_EXISTING_421", 421);

    /**
     * Long lines should not be wrapped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_DONT_WRAP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_DONT_WRAP_422", 422);

    /**
     * Maximum number of matching entries to return
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_SIZE_LIMIT_423", 423);

    /**
     * Maximum length of time (in seconds) to spend processing
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_TIME_LIMIT_424", 424);

    /**
     * No search filter was specified.  Either a filter file or an individual search filter must be provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIFSEARCH_NO_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_NO_FILTER_428", 428);

    /**
     * An error occurred while attempting to process the Directory Server configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFSEARCH_CANNOT_INITIALIZE_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_INITIALIZE_CONFIG_429", 429);

    /**
     * An error occurred while attempting to initialize the Directory Server schema based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFSEARCH_CANNOT_INITIALIZE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_INITIALIZE_SCHEMA_430", 430);

    /**
     * An error occurred while attempting to parse search filter '%s':  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFSEARCH_CANNOT_PARSE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_PARSE_FILTER_431", 431);

    /**
     * An error occurred while attempting to parse base DN '%s':  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFSEARCH_CANNOT_PARSE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_PARSE_BASE_DN_432", 432);

    /**
     * An error occurred while attempting to parse the time limit as an integer:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_PARSE_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_PARSE_TIME_LIMIT_433", 433);

    /**
     * An error occurred while attempting to parse the size limit as an integer:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_PARSE_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_PARSE_SIZE_LIMIT_434", 434);

    /**
     * An error occurred while attempting to create the LDIF reader:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_CREATE_READER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_CREATE_READER_435", 435);

    /**
     * An error occurred while attempting to create the LDIF writer used to return matching entries:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_CREATE_WRITER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_CREATE_WRITER_436", 436);

    /**
     * The specified time limit has been exceeded during search processing
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_LDIFSEARCH_TIME_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "WARN_LDIFSEARCH_TIME_LIMIT_EXCEEDED_437", 437);

    /**
     * The specified size limit has been exceeded during search processing
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_LDIFSEARCH_SIZE_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "WARN_LDIFSEARCH_SIZE_LIMIT_EXCEEDED_438", 438);

    /**
     * An error occurred while attempting to read an entry from the LDIF content:  %s.  Skipping this entry and continuing processing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_READ_ENTRY_RECOVERABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_READ_ENTRY_RECOVERABLE_439", 439);

    /**
     * An error occurred while attempting to read an entry from the LDIF content:  %s.  Unable to continue processing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_CANNOT_READ_ENTRY_FATAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_READ_ENTRY_FATAL_440", 440);

    /**
     * An unexpected error occurred during search processing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_ERROR_DURING_PROCESSING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_ERROR_DURING_PROCESSING_441", 441);

    /**
     * An error occurred while attempting to initialize the Directory Server JMX subsystem based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFSEARCH_CANNOT_INITIALIZE_JMX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFSEARCH_CANNOT_INITIALIZE_JMX_442", 442);

    /**
     * LDIF file to use as the source data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_SOURCE_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_SOURCE_LDIF_443", 443);

    /**
     * LDIF file to use as the target data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_TARGET_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_TARGET_LDIF_444", 444);

    /**
     * File to which the output should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_OUTPUT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_OUTPUT_LDIF_445", 445);

    /**
     * Any existing output file should be overwritten rather than appending to it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_OVERWRITE_EXISTING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_OVERWRITE_EXISTING_446", 446);

    /**
     * An error occurred while attempting to initialize the Directory Server JMX subsystem based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_INITIALIZE_JMX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_INITIALIZE_JMX_452", 452);

    /**
     * An error occurred while attempting to process the Directory Server configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_INITIALIZE_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_INITIALIZE_CONFIG_453", 453);

    /**
     * An error occurred while attempting to initialize the Directory Server schema based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_INITIALIZE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_INITIALIZE_SCHEMA_454", 454);

    /**
     * An error occurred while attempting to open source LDIF %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_OPEN_SOURCE_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_OPEN_SOURCE_LDIF_455", 455);

    /**
     * An error occurred while reading the contents of source LDIF %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_ERROR_READING_SOURCE_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_ERROR_READING_SOURCE_LDIF_456", 456);

    /**
     * An error occurred while attempting to open target LDIF %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_OPEN_TARGET_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_OPEN_TARGET_LDIF_457", 457);

    /**
     * An error occurred while reading the contents of target LDIF %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_ERROR_READING_TARGET_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_ERROR_READING_TARGET_LDIF_458", 458);

    /**
     * An error occurred while attempting to open the LDIF writer for the diff output:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFDIFF_CANNOT_OPEN_OUTPUT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_OPEN_OUTPUT_459", 459);

    /**
     * No differences were detected between the source and target LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_NO_DIFFERENCES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_NO_DIFFERENCES_460", 460);

    /**
     * An error occurred while attempting to write the diff output:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFDIFF_ERROR_WRITING_OUTPUT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_ERROR_WRITING_OUTPUT_461", 461);

    /**
     * Port on which the Directory Server should listen for LDAP communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_LDAP_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_LDAP_PORT_464", 464);

    /**
     * Base DN for user information in the Directory Server.  Multiple base DNs may be provided by using this option multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_BASE_DN_465", 465);

    /**
     * DN for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_ROOT_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_ROOT_DN_466", 466);

    /**
     * Password for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_ROOT_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_ROOT_PW_467", 467);

    /**
     * Path to a file containing the password for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_ROOT_PW_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_ROOT_PW_FILE_468", 468);

    /**
     * An error occurred while attempting to acquire the server-wide lock file %s:  %s.  This generally means that the Directory Server is running, or another tool that requires exclusive access to the server is in use
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_ACQUIRE_SERVER_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_ACQUIRE_SERVER_LOCK_472", 472);

    /**
     * An error occurred while attempting to initialize the Directory Server JMX subsystem based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_INITIALIZE_JMX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_INITIALIZE_JMX_473", 473);

    /**
     * An error occurred while attempting to process the Directory Server configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_INITIALIZE_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_INITIALIZE_CONFIG_474", 474);

    /**
     * An error occurred while attempting to initialize the Directory Server schema based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_INITIALIZE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_INITIALIZE_SCHEMA_475", 475);

    /**
     * An error occurred while attempting to parse base DN value "%s" as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_PARSE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_PARSE_BASE_DN_476", 476);

    /**
     * An error occurred while attempting to parse root DN value "%s" as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_PARSE_ROOT_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_PARSE_ROOT_DN_477", 477);

    /**
     * The DN for the initial root user was provided, but no corresponding password was given.  If the root DN is specified then the password must also be provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIGDS_NO_ROOT_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_NO_ROOT_PW_478", 478);

    /**
     * An error occurred while attempting to update the port on which to listen for LDAP communication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_LDAP_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_LDAP_PORT_480", 480);

    /**
     * An error occurred while attempting to update the entry for the initial Directory Server root user: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_ROOT_USER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_ROOT_USER_481", 481);

    /**
     * An error occurred while writing the updated Directory Server configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_WRITE_UPDATED_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_WRITE_UPDATED_CONFIG_482", 482);

    /**
     * ERROR:  No configuration changes were specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIGDS_NO_CONFIG_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_NO_CONFIG_CHANGES_483", 483);

    /**
     * Successfully wrote the updated Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_WROTE_UPDATED_CONFIG =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_WROTE_UPDATED_CONFIG_484", 484);

    /**
     * The setup command used to invoke this program
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_PROGNAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_PROGNAME_486", 486);

    /**
     * Base DN for user information in the Directory Server.  Multiple base DNs may be provided by using this option multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_BASEDN_490", 490);

    /**
     * Indicates whether to create the base entry in the Directory Server database
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ADDBASE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ADDBASE_491", 491);

    /**
     * Path to an LDIF file containing data that should be added to the Directory Server database. Multiple LDIF files may be provided by using this option multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_IMPORTLDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_IMPORTLDIF_492", 492);

    /**
     * Port on which the Directory Server should listen for LDAP communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_LDAPPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_LDAPPORT_493", 493);

    /**
     * Skip the check to determine whether the specified ports are usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_SKIPPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_SKIPPORT_494", 494);

    /**
     * DN for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ROOTDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ROOTDN_495", 495);

    /**
     * Password for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ROOTPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ROOTPW_496", 496);

    /**
     * Path to a file containing the password for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ROOTPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ROOTPWFILE_497", 497);

    /**
     * An error occurred while attempting to parse the string "%s" as a valid DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INSTALLDS_CANNOT_PARSE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CANNOT_PARSE_DN_503", 503);

    /**
     * Provide the base DN for the directory data:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_BASEDN_504", 504);

    /**
     * Please specify the path to the LDIF file containing the data to import:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_IMPORT_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_IMPORT_FILE_506", 506);

    /**
     * On which port would you like the Directory Server to accept connections from LDAP clients?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_LDAPPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_LDAPPORT_509", 509);

    /**
     * ERROR:  Unable to bind to port %d.  This port may already be in use, or you may not have permission to bind to it.  On UNIX-based operating systems, non-root users may not be allowed to bind to ports 1 through 1024
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_INSTALLDS_CANNOT_BIND_TO_PRIVILEGED_PORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CANNOT_BIND_TO_PRIVILEGED_PORT_510", 510);

    /**
     * ERROR:  Unable to bind to port %d.  This port may already be in use, or you may not have permission to bind to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_INSTALLDS_CANNOT_BIND_TO_PORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CANNOT_BIND_TO_PORT_511", 511);

    /**
     * What would you like to use as the initial root user DN for the Directory Server?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_ROOT_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_ROOT_DN_512", 512);

    /**
     * ERROR:  No password was provided for the initial root user.  When performing a non-interactive installation, this must be provided using either the %s or the %s argument
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INSTALLDS_NO_ROOT_PASSWORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_NO_ROOT_PASSWORD_513", 513);

    /**
     * Please provide the password to use for the initial root user:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_ROOT_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_ROOT_PASSWORD_514", 514);

    /**
     * Please re-enter the password for confirmation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_CONFIRM_ROOT_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_CONFIRM_ROOT_PASSWORD_515", 515);

    /**
     * ERROR:  The provided response could not be interpreted as an integer.  Please provide the response as an integer value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_INVALID_INTEGER_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_INVALID_INTEGER_RESPONSE_524", 524);

    /**
     * ERROR:  The provided value is less than the lowest allowed value of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_INSTALLDS_INTEGER_BELOW_LOWER_BOUND =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_INTEGER_BELOW_LOWER_BOUND_525", 525);

    /**
     * ERROR:  The provided value is greater than the largest allowed value of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_INSTALLDS_INTEGER_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_INTEGER_ABOVE_UPPER_BOUND_526", 526);

    /**
     * ERROR:  The provided response could not be interpreted as an LDAP DN
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_INVALID_DN_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_INVALID_DN_RESPONSE_527", 527);

    /**
     * ERROR:  The provided password values do not match
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_PASSWORDS_DONT_MATCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_PASSWORDS_DONT_MATCH_530", 530);

    /**
     * Use quiet mode (no output)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_QUIET =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_QUIET_532", 532);

    /**
     * Invalid number of arguments provided for tag %s on line number %d of the template file:  expected %d, got %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number> ERR_MAKELDIF_TAG_INVALID_ARGUMENT_COUNT =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INVALID_ARGUMENT_COUNT_535", 535);

    /**
     * Invalid number of arguments provided for tag %s on line number %d of the template file: expected between %d and %d, got %d
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number> ERR_MAKELDIF_TAG_INVALID_ARGUMENT_RANGE_COUNT =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INVALID_ARGUMENT_RANGE_COUNT_536", 536);

    /**
     * Undefined attribute %s referenced on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_TAG_UNDEFINED_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_UNDEFINED_ATTRIBUTE_537", 537);

    /**
     * Value %d is below the lowest allowed value of %d for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number> ERR_MAKELDIF_TAG_INTEGER_BELOW_LOWER_BOUND =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INTEGER_BELOW_LOWER_BOUND_538", 538);

    /**
     * Cannot parse value "%s" as an integer for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_MAKELDIF_TAG_CANNOT_PARSE_AS_INTEGER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_CANNOT_PARSE_AS_INTEGER_539", 539);

    /**
     * Value %d is above the largest allowed value of %d for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number> ERR_MAKELDIF_TAG_INTEGER_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INTEGER_ABOVE_UPPER_BOUND_540", 540);

    /**
     * Cannot parse value "%s" as a Boolean value for tag %s on line %d of the template file.  The value must be either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_MAKELDIF_TAG_CANNOT_PARSE_AS_BOOLEAN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_CANNOT_PARSE_AS_BOOLEAN_542", 542);

    /**
     * The branch with entry DN '%s' references a subordinate template named '%s' which is not defined in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_UNDEFINED_BRANCH_SUBORDINATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_UNDEFINED_BRANCH_SUBORDINATE_543", 543);

    /**
     * Unable to load class %s for use as a MakeLDIF tag
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MAKELDIF_CANNOT_LOAD_TAG_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CANNOT_LOAD_TAG_CLASS_544", 544);

    /**
     * Cannot instantiate class %s as a MakeLDIF tag
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MAKELDIF_CANNOT_INSTANTIATE_TAG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CANNOT_INSTANTIATE_TAG_545", 545);

    /**
     * Cannot register the tag defined in class %s because the tag name %s conflicts with the name of another tag that has already been registered
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_CONFLICTING_TAG_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CONFLICTING_TAG_NAME_546", 546);

    /**
     * Possible reference to an undefined constant %s on line %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_MAKELDIF_WARNING_UNDEFINED_CONSTANT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_WARNING_UNDEFINED_CONSTANT_547", 547);

    /**
     * The constant definition on line %d is missing an equal sign to delimit the constant name from the value
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_MAKELDIF_DEFINE_MISSING_EQUALS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_DEFINE_MISSING_EQUALS_548", 548);

    /**
     * The constant definition on line %d does not include a name for the constant
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_MAKELDIF_DEFINE_NAME_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_DEFINE_NAME_EMPTY_549", 549);

    /**
     * The definition for constant %s on line %d conflicts with an earlier constant definition included in the template
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_CONFLICTING_CONSTANT_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CONFLICTING_CONSTANT_NAME_550", 550);

    /**
     * Constant %s defined on line %d has not been assigned a value
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_WARNING_DEFINE_VALUE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_WARNING_DEFINE_VALUE_EMPTY_551", 551);

    /**
     * The branch definition %s starting on line %d conflicts with an earlier branch definition contained in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_CONFLICTING_BRANCH_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CONFLICTING_BRANCH_DN_552", 552);

    /**
     * The template definition %s starting on line %d conflicts with an earlier template definition contained in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_CONFLICTING_TEMPLATE_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CONFLICTING_TEMPLATE_NAME_553", 553);

    /**
     * Unexpected template line "%s" encountered on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_UNEXPECTED_TEMPLATE_FILE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_UNEXPECTED_TEMPLATE_FILE_LINE_554", 554);

    /**
     * The template named %s references a subordinate template named %s which is not defined in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_UNDEFINED_TEMPLATE_SUBORDINATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_UNDEFINED_TEMPLATE_SUBORDINATE_555", 555);

    /**
     * Unable to decode branch DN "%s" on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_CANNOT_DECODE_BRANCH_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CANNOT_DECODE_BRANCH_DN_556", 556);

    /**
     * Subordinate template definition on line %d for branch %s is missing a colon to separate the template name from the number of entries
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_BRANCH_SUBORDINATE_TEMPLATE_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_BRANCH_SUBORDINATE_TEMPLATE_NO_COLON_557", 557);

    /**
     * Subordinate template definition on line %d for branch %s specified invalid number of entries %d for template %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> ERR_MAKELDIF_BRANCH_SUBORDINATE_INVALID_NUM_ENTRIES =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_BRANCH_SUBORDINATE_INVALID_NUM_ENTRIES_558", 558);

    /**
     * Subordinate template definition on line %d for branch %s specifies that zero entries of type %s should be generated
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_MAKELDIF_BRANCH_SUBORDINATE_ZERO_ENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_BRANCH_SUBORDINATE_ZERO_ENTRIES_559", 559);

    /**
     * Unable to parse the number of entries for template %s as an integer for the subordinate template definition on line %d for branch %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_MAKELDIF_BRANCH_SUBORDINATE_CANT_PARSE_NUMENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_BRANCH_SUBORDINATE_CANT_PARSE_NUMENTRIES_560", 560);

    /**
     * Subordinate template definition on line %d for template %s is missing a colon to separate the template name from the number of entries
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_TEMPLATE_SUBORDINATE_TEMPLATE_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TEMPLATE_SUBORDINATE_TEMPLATE_NO_COLON_561", 561);

    /**
     * Subordinate template definition on line %d for template %s specified invalid number of entries %d for subordinate template %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> ERR_MAKELDIF_TEMPLATE_SUBORDINATE_INVALID_NUM_ENTRIES =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TEMPLATE_SUBORDINATE_INVALID_NUM_ENTRIES_562", 562);

    /**
     * Subordinate template definition on line %d for template %s specifies that zero entries of type %s should be generated
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_MAKELDIF_TEMPLATE_SUBORDINATE_ZERO_ENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_TEMPLATE_SUBORDINATE_ZERO_ENTRIES_563", 563);

    /**
     * Unable to parse the number of entries for template %s as an integer for the subordinate template definition on line %d for template %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_MAKELDIF_TEMPLATE_SUBORDINATE_CANT_PARSE_NUMENTRIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TEMPLATE_SUBORDINATE_CANT_PARSE_NUMENTRIES_564", 564);

    /**
     * The template named %s includes RDN attribute %s that is not assigned a value in that template
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_TEMPLATE_MISSING_RDN_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TEMPLATE_MISSING_RDN_ATTR_565", 565);

    /**
     * There is no colon to separate the attribute name from the value pattern on line %d of the template file in the definition for branch %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_NO_COLON_IN_BRANCH_EXTRA_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_NO_COLON_IN_BRANCH_EXTRA_LINE_566", 566);

    /**
     * There is no attribute name before the colon on line %d of the template file in the definition for branch %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_NO_ATTR_IN_BRANCH_EXTRA_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_NO_ATTR_IN_BRANCH_EXTRA_LINE_567", 567);

    /**
     * The value pattern for line %d of the template file in the definition for branch %s is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> WARN_MAKELDIF_NO_VALUE_IN_BRANCH_EXTRA_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_NO_VALUE_IN_BRANCH_EXTRA_LINE_568", 568);

    /**
     * There is no colon to separate the attribute name from the value pattern on line %d of the template file in the definition for template %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_NO_COLON_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_NO_COLON_IN_TEMPLATE_LINE_569", 569);

    /**
     * There is no attribute name before the colon on line %d of the template file in the definition for template %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_NO_ATTR_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_NO_ATTR_IN_TEMPLATE_LINE_570", 570);

    /**
     * The value pattern for line %d of the template file in the definition for template %s is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> WARN_MAKELDIF_NO_VALUE_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_NO_VALUE_IN_TEMPLATE_LINE_571", 571);

    /**
     * An undefined tag %s is referenced on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_NO_SUCH_TAG =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_NO_SUCH_TAG_572", 572);

    /**
     * An unexpected error occurred while trying to create a new instance of tag %s referenced on line %d of the template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_MAKELDIF_CANNOT_INSTANTIATE_NEW_TAG =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CANNOT_INSTANTIATE_NEW_TAG_573", 573);

    /**
     * Cannot parse value "%s" as an valid format string for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_MAKELDIF_TAG_INVALID_FORMAT_STRING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INVALID_FORMAT_STRING_587", 587);

    /**
     * The random tag on line %d of the template file does not include an argument to specify the type of random value that should be generated
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_MAKELDIF_TAG_NO_RANDOM_TYPE_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_NO_RANDOM_TYPE_ARGUMENT_588", 588);

    /**
     * The value generated from the random tag on line %d of the template file will always be an empty string
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_MAKELDIF_TAG_WARNING_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_TAG_WARNING_EMPTY_VALUE_589", 589);

    /**
     * The random tag on line %d of the template file references an unknown random type of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_MAKELDIF_TAG_UNKNOWN_RANDOM_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_UNKNOWN_RANDOM_TYPE_590", 590);

    /**
     * Could not find template file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MAKELDIF_COULD_NOT_FIND_TEMPLATE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_COULD_NOT_FIND_TEMPLATE_FILE_592", 592);

    /**
     * Cannot find file %s referenced by tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_MAKELDIF_TAG_CANNOT_FIND_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_CANNOT_FIND_FILE_595", 595);

    /**
     * Invalid file access mode %s for tag %s on line %d of the template file.  It must be either "sequential" or "random"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_MAKELDIF_TAG_INVALID_FILE_ACCESS_MODE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_INVALID_FILE_ACCESS_MODE_596", 596);

    /**
     * An error occurred while trying to read file %s referenced by tag %s on line %d of the template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object> ERR_MAKELDIF_TAG_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_CANNOT_READ_FILE_597", 597);

    /**
     * An error occurred while attempting to write entry %s to LDIF:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_CANNOT_WRITE_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_CANNOT_WRITE_ENTRY_601", 601);

    /**
     * Path to a MakeLDIF template to use to generate the import data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_TEMPLATE_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_TEMPLATE_FILE_603", 603);

    /**
     * Neither the %s or the %s argument was provided.  One of these arguments must be given to specify the source for the LDIF data to be imported
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_MISSING_REQUIRED_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_MISSING_REQUIRED_ARGUMENT_605", 605);

    /**
     * Unable to parse the specified file %s as a MakeLDIF template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_PARSE_TEMPLATE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_PARSE_TEMPLATE_FILE_606", 606);

    /**
     * Line %d of the template file contains an incomplete tag that starts with either '<' or '{' but does get closed
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_MAKELDIF_INCOMPLETE_TAG =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_INCOMPLETE_TAG_607", 607);

    /**
     * Tag %s referenced on line %d of the template file is not allowed for use in branch definitions
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MAKELDIF_TAG_NOT_ALLOWED_IN_BRANCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_NOT_ALLOWED_IN_BRANCH_608", 608);

    /**
     * Seed for the MakeLDIF random number generator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_RANDOM_SEED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_RANDOM_SEED_609", 609);

    /**
     * Entry %s is added twice in the set of changes to apply, which is not supported by the LDIF modify tool
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_CANNOT_ADD_ENTRY_TWICE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_ADD_ENTRY_TWICE_610", 610);

    /**
     * Entry %s cannot be deleted because it was previously added in the set of changes.  This is not supported by the LDIF modify tool
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_CANNOT_DELETE_AFTER_ADD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_DELETE_AFTER_ADD_611", 611);

    /**
     * Cannot modify entry %s because it was previously added or deleted in the set of changes.  This is not supported by the LDIF modify tool
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_CANNOT_MODIFY_ADDED_OR_DELETED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_MODIFY_ADDED_OR_DELETED_612", 612);

    /**
     * The modify DN operation targeted at entry %s cannot be processed because modify DN operations are not supported by the LDIF modify tool
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_MODDN_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_MODDN_NOT_SUPPORTED_613", 613);

    /**
     * Entry %s has an unknown changetype of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_UNKNOWN_CHANGETYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_UNKNOWN_CHANGETYPE_614", 614);

    /**
     * Unable to add entry %s because it already exists in the data set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_ADD_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_ADD_ALREADY_EXISTS_615", 615);

    /**
     * Unable to delete entry %s because it does not exist in the data set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_DELETE_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_DELETE_NO_SUCH_ENTRY_616", 616);

    /**
     * Unable to modify entry %s because it does not exist in the data set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_MODIFY_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_MODIFY_NO_SUCH_ENTRY_617", 617);

    /**
     * LDIF file containing the data to be updated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFMODIFY_DESCRIPTION_SOURCE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFMODIFY_DESCRIPTION_SOURCE_620", 620);

    /**
     * LDIF file containing the changes to apply
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFMODIFY_DESCRIPTION_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFMODIFY_DESCRIPTION_CHANGES_621", 621);

    /**
     * File to which the updated data should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFMODIFY_DESCRIPTION_TARGET =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFMODIFY_DESCRIPTION_TARGET_622", 622);

    /**
     * An error occurred while attempting to initialize the Directory Server JMX subsystem based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_INITIALIZE_JMX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_INITIALIZE_JMX_626", 626);

    /**
     * An error occurred while attempting to process the Directory Server configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_INITIALIZE_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_INITIALIZE_CONFIG_627", 627);

    /**
     * An error occurred while attempting to initialize the Directory Server schema based on the information in configuration file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_INITIALIZE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_INITIALIZE_SCHEMA_628", 628);

    /**
     * The source LDIF file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_SOURCE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_SOURCE_DOES_NOT_EXIST_629", 629);

    /**
     * Unable to open the source LDIF file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_OPEN_SOURCE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_OPEN_SOURCE_630", 630);

    /**
     * The changes LDIF file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_CHANGES_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CHANGES_DOES_NOT_EXIST_631", 631);

    /**
     * Unable to open the changes LDIF file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_OPEN_CHANGES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_OPEN_CHANGES_632", 632);

    /**
     * Unable to open the target LDIF file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFMODIFY_CANNOT_OPEN_TARGET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_CANNOT_OPEN_TARGET_633", 633);

    /**
     * An error occurred while processing the requested changes:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_ERROR_PROCESSING_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFMODIFY_ERROR_PROCESSING_LDIF_634", 634);

    /**
     * Address of the Directory Server system
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_HOST =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_HOST_635", 635);

    /**
     * Port on which the Directory Server listens for LDAP client connections
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_PORT_636", 636);

    /**
     * DN to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_BIND_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_BIND_DN_637", 637);

    /**
     * Password to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_BIND_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_BIND_PW_638", 638);

    /**
     * Path to a file containing the password to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_BIND_PW_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_BIND_PW_FILE_639", 639);

    /**
     * Authorization ID for the user entry whose password should be changed. The authorization ID is a string having either the prefix "dn:" followed by the user's distinguished name, or the prefix "u:" followed by a user identifier that depends on the identity mapping used to match the user identifier to an entry in the directory. Examples include "dn:uid=bjensen,ou=People,dc=example,dc=com", and, if we assume that "bjensen" is mapped to Barbara Jensen's entry, "u:bjensen"
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_AUTHZID_640", 640);

    /**
     * Use the bind DN as the authorization ID for the password modify operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_PROVIDE_DN_FOR_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_PROVIDE_DN_FOR_AUTHZID_641", 641);

    /**
     * New password to provide for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_NEWPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_NEWPW_642", 642);

    /**
     * Path to a file containing the new password to provide for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_NEWPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_NEWPWFILE_643", 643);

    /**
     * Current password for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_CURRENTPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_CURRENTPW_644", 644);

    /**
     * Path to a file containing the current password for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_CURRENTPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_CURRENTPWFILE_645", 645);

    /**
     * Use SSL to secure the communication with the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_USE_SSL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_USE_SSL_646", 646);

    /**
     * Use StartTLS to secure the communication with the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_USE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_USE_STARTTLS_647", 647);

    /**
     * Path to the key store to use when establishing SSL/TLS communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE_649", 649);

    /**
     * Path to a file containing the PIN needed to access the contents of the key store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE_PINFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE_PINFILE_650", 650);

    /**
     * Path to the trust store to use when establishing SSL/TLS communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE_651", 651);

    /**
     * Path to a file containing the PIN needed to access the contents of the trust store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE_PINFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE_PINFILE_652", 652);

    /**
     * If either a bind DN or bind password is provided, then the other must be given as well
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPPWMOD_BIND_DN_AND_PW_MUST_BE_TOGETHER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_BIND_DN_AND_PW_MUST_BE_TOGETHER_657", 657);

    /**
     * If a bind DN and password are not provided, then an authorization ID and current password must be given
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPPWMOD_ANON_REQUIRES_AUTHZID_AND_CURRENTPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_ANON_REQUIRES_AUTHZID_AND_CURRENTPW_658", 658);

    /**
     * If the %s argument is provided, then the  %s argument must also be given
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPPWMOD_DEPENDENT_ARGS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_DEPENDENT_ARGS_659", 659);

    /**
     * Unable to initialize SSL/TLS support:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_ERROR_INITIALIZING_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_ERROR_INITIALIZING_SSL_660", 660);

    /**
     * An error occurred while attempting to connect to the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_CANNOT_CONNECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_CANNOT_CONNECT_661", 661);

    /**
     * Unable to send the LDAP password modify request:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_CANNOT_SEND_PWMOD_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_CANNOT_SEND_PWMOD_REQUEST_662", 662);

    /**
     * Unable to read the LDAP password modify response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_CANNOT_READ_PWMOD_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_CANNOT_READ_PWMOD_RESPONSE_663", 663);

    /**
     * The LDAP password modify operation failed with result code %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAPPWMOD_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_FAILED_664", 664);

    /**
     * Error Message:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_FAILURE_ERROR_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_FAILURE_ERROR_MESSAGE_665", 665);

    /**
     * Matched DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_FAILURE_MATCHED_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_FAILURE_MATCHED_DN_666", 666);

    /**
     * The LDAP password modify operation was successful
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_SUCCESSFUL_667", 667);

    /**
     * Additional Info:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPPWMOD_ADDITIONAL_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_ADDITIONAL_INFO_668", 668);

    /**
     * Generated Password:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPPWMOD_GENERATED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_GENERATED_PASSWORD_669", 669);

    /**
     * Unable to decode the password modify response value because it contained an invalid element type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_UNRECOGNIZED_VALUE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_UNRECOGNIZED_VALUE_TYPE_670", 670);

    /**
     * Unable to decode the password modify response value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_COULD_NOT_DECODE_RESPONSE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_COULD_NOT_DECODE_RESPONSE_VALUE_671", 671);

    /**
     * The assertion value was indicated to be base64-encoded, but an error occurred while trying to decode the value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COMPARE_CANNOT_BASE64_DECODE_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_COMPARE_CANNOT_BASE64_DECODE_ASSERTION_VALUE_673", 673);

    /**
     * Unable to read the assertion value from the specified file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_CANNOT_READ_ASSERTION_VALUE_FROM_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_COMPARE_CANNOT_READ_ASSERTION_VALUE_FROM_FILE_674", 674);

    /**
     * Path to the file to watch for deletion
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT4DEL_DESCRIPTION_TARGET_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WAIT4DEL_DESCRIPTION_TARGET_FILE_675", 675);

    /**
     * Path to a file containing log output to monitor
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT4DEL_DESCRIPTION_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WAIT4DEL_DESCRIPTION_LOG_FILE_676", 676);

    /**
     * Maximum length of time in seconds to wait for the target file to be deleted before exiting
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT4DEL_DESCRIPTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WAIT4DEL_DESCRIPTION_TIMEOUT_677", 677);

    /**
     * WARNING:  Unable to open log file %s for reading:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_WAIT4DEL_CANNOT_OPEN_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_WAIT4DEL_CANNOT_OPEN_LOG_FILE_681", 681);

    /**
     * No entry DNs provided for the compare operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPCOMPARE_NO_DNS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPCOMPARE_NO_DNS_682", 682);

    /**
     * This utility can be used to back up one or more Directory Server backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDB_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDB_TOOL_DESCRIPTION_683", 683);

    /**
     * This utility can be used to define a base configuration for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_TOOL_DESCRIPTION_684", 684);

    /**
     * This utility can be used to encode user passwords with a specified storage scheme, or to determine whether a given clear-text value matches a provided encoded password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_TOOL_DESCRIPTION_685", 685);

    /**
     * This utility can be used to export data from a Directory Server backend in LDIF form
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_TOOL_DESCRIPTION_686", 686);

    /**
     * This utility can be used to import LDIF data into a Directory Server backend, overwriting existing data. It cannot be used to append data to the backend database
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_TOOL_DESCRIPTION_687", 687);

    /**
     * This utility can be used to setup the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_TOOL_DESCRIPTION_688", 688);

    /**
     * This utility can be used to perform LDAP compare operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPCOMPARE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPCOMPARE_TOOL_DESCRIPTION_689", 689);

    /**
     * This utility can be used to perform LDAP delete operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPDELETE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPDELETE_TOOL_DESCRIPTION_690", 690);

    /**
     * This utility can be used to perform LDAP modify, add, delete, and modify DN operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPMODIFY_TOOL_DESCRIPTION_691", 691);

    /**
     * This utility can be used to perform LDAP password modify operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_TOOL_DESCRIPTION_692", 692);

    /**
     * This utility can be used to perform LDAP search operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_TOOL_DESCRIPTION_693", 693);

    /**
     * This utility can be used to compare two LDIF files and report the differences in LDIF format
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_TOOL_DESCRIPTION_694", 694);

    /**
     * This utility can be used to apply a set of modify, add, and delete operations against data in an LDIF file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFMODIFY_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFMODIFY_TOOL_DESCRIPTION_695", 695);

    /**
     * This utility can be used to perform search operations against data in an LDIF file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFSEARCH_TOOL_DESCRIPTION_696", 696);

    /**
     * This utility can be used to restore a backup of a Directory Server backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTOREDB_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RESTOREDB_TOOL_DESCRIPTION_698", 698);

    /**
     * This utility can be used to request that the Directory Server stop running or perform a restart. When run without connection options, this utility sends a signal to the OpenDJ process to stop the server. When run with connection options, this utility connects to the OpenDJ administration port and creates a shutdown task to stop the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_TOOL_DESCRIPTION_699", 699);

    /**
     * This utility can be used to ensure that index data is consistent within an indexed backend database
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFYINDEX_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VERIFYINDEX_TOOL_DESCRIPTION_700", 700);

    /**
     * This utility can be used to wait for a file to be removed from the filesystem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT4DEL_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WAIT4DEL_TOOL_DESCRIPTION_701", 701);

    /**
     * No attribute was specified to use as the target for the comparison
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPCOMPARE_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPCOMPARE_NO_ATTR_703", 703);

    /**
     * Invalid attribute string '%s'. The attribute string must be in one of the following forms: 'attribute:value', 'attribute::base64value', or 'attribute:<valueFilePath'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPCOMPARE_INVALID_ATTR_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPCOMPARE_INVALID_ATTR_STRING_704", 704);

    /**
     * Invalid control specification '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_INVALID_CONTROL_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOL_INVALID_CONTROL_STRING_705", 705);

    /**
     * SASL EXTERNAL authentication may only be requested if SSL or StartTLS is used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TOOL_SASLEXTERNAL_NEEDS_SSL_OR_TLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_TOOL_SASLEXTERNAL_NEEDS_SSL_OR_TLS_706", 706);

    /**
     * SASL EXTERNAL authentication may only be used if a client certificate key store is specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TOOL_SASLEXTERNAL_NEEDS_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_TOOL_SASLEXTERNAL_NEEDS_KEYSTORE_707", 707);

    /**
     * # Persistent search change type:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_PSEARCH_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_PSEARCH_CHANGE_TYPE_708", 708);

    /**
     * # Persistent search previous entry DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_PSEARCH_PREVIOUS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_PSEARCH_PREVIOUS_DN_709", 709);

    /**
     * # Account Usability Response Control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_HEADER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_HEADER_710", 710);

    /**
     * #   The account is usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_IS_USABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_IS_USABLE_711", 711);

    /**
     * #   Time until password expiration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_EXPIRATION_712", 712);

    /**
     * #   The account is not usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_NOT_USABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_NOT_USABLE_713", 713);

    /**
     * #   The account has been deactivated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_ACCT_INACTIVE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_ACCT_INACTIVE_714", 714);

    /**
     * #   The password has been reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_PW_RESET =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_PW_RESET_715", 715);

    /**
     * #   The password has expired
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_PW_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_PW_EXPIRED_716", 716);

    /**
     * #   Number of grace logins remaining:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_ACCTUSABLE_REMAINING_GRACE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_REMAINING_GRACE_717", 717);

    /**
     * #   The account is locked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_LOCKED_718", 718);

    /**
     * #   Time until the account is unlocked:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_UNLOCK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_UNLOCK_719", 719);

    /**
     * Certificate key store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_KEYSTOREPASSWORD_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_KEYSTOREPASSWORD_FILE_720", 720);

    /**
     * Certificate trust store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPASSWORD_721", 721);

    /**
     * Certificate trust store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPASSWORD_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPASSWORD_FILE_722", 722);

    /**
     * This utility can be used to list the backends and base DNs configured in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTBACKENDS_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_TOOL_DESCRIPTION_723", 723);

    /**
     * Backend ID of the backend for which to list the base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTBACKENDS_DESCRIPTION_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_DESCRIPTION_BACKEND_ID_726", 726);

    /**
     * Base DN for which to list the backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTBACKENDS_DESCRIPTION_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_DESCRIPTION_BASE_DN_727", 727);

    /**
     * An error occurred while trying to read backend information from the server configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LISTBACKENDS_CANNOT_GET_BACKENDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LISTBACKENDS_CANNOT_GET_BACKENDS_734", 734);

    /**
     * The provided base DN value '%s' could not be parsed as a valid DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LISTBACKENDS_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LISTBACKENDS_INVALID_DN_735", 735);

    /**
     * The provided DN '%s' is not a base DN for any backend configured in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LISTBACKENDS_NOT_BASE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_NOT_BASE_DN_736", 736);

    /**
     * The provided DN '%s' is not below any base DN for any of the backends configured in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LISTBACKENDS_NO_BACKEND_FOR_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_NO_BACKEND_FOR_DN_737", 737);

    /**
     * The provided DN '%s' is below '%s' which is configured as a base DN for backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_LISTBACKENDS_DN_BELOW_BASE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_DN_BELOW_BASE_738", 738);

    /**
     * The provided DN '%s' is a base DN for backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LISTBACKENDS_BASE_FOR_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_BASE_FOR_ID_739", 739);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTBACKENDS_LABEL_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_LABEL_BACKEND_ID_740", 740);

    /**
     * Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTBACKENDS_LABEL_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LISTBACKENDS_LABEL_BASE_DN_741", 741);

    /**
     * There is no backend with ID '%s' in the server configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LISTBACKENDS_NO_SUCH_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LISTBACKENDS_NO_SUCH_BACKEND_742", 742);

    /**
     * None of the provided backend IDs exist in the server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LISTBACKENDS_NO_VALID_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LISTBACKENDS_NO_VALID_BACKENDS_743", 743);

    /**
     * The provided password is not a valid encoded user password value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_INVALID_ENCODED_USERPW =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_INVALID_ENCODED_USERPW_748", 748);

    /**
     * Use the LDAP compare result as an exit code for the password comparison
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_USE_COMPARE_RESULT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_USE_COMPARE_RESULT_749", 749);

    /**
     * Count the number of entries returned by the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_COUNT_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_COUNT_ENTRIES_750", 750);

    /**
     * # Total number of matching entries: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT_751", 751);

    /**
     * Specifies that the database should be populated with the specified number of sample entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_SAMPLE_DATA =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_SAMPLE_DATA_753", 753);

    /**
     * Options for populating the database:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_HEADER_POPULATE_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_HEADER_POPULATE_TYPE_754", 754);

    /**
     * Only create the base entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_POPULATE_OPTION_BASE_ONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_POPULATE_OPTION_BASE_ONLY_755", 755);

    /**
     * Leave the database empty
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_POPULATE_OPTION_LEAVE_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_POPULATE_OPTION_LEAVE_EMPTY_756", 756);

    /**
     * Import data from an LDIF file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_POPULATE_OPTION_IMPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_POPULATE_OPTION_IMPORT_LDIF_757", 757);

    /**
     * Load automatically-generated sample data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_POPULATE_OPTION_GENERATE_SAMPLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_POPULATE_OPTION_GENERATE_SAMPLE_758", 758);

    /**
     * ERROR:  The specified LDIF file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_NO_SUCH_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_NO_SUCH_LDIF_FILE_780", 780);

    /**
     * Please specify the number of user entries to generate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_NUM_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_NUM_ENTRIES_781", 781);

    /**
     * The PIN needed to access the contents of the key store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE_PIN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_KEYSTORE_PIN_783", 783);

    /**
     * The PIN needed to access the contents of the trust store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE_PIN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_TRUSTSTORE_PIN_784", 784);

    /**
     * Exclude operational attributes from the LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_OPERATIONAL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_DESCRIPTION_EXCLUDE_OPERATIONAL_785", 785);

    /**
     * Password Policy Warning:  %s = %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_LDAPPWMOD_PWPOLICY_WARNING =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_PWPOLICY_WARNING_786", 786);

    /**
     * Password Policy Error:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPPWMOD_PWPOLICY_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDAPPWMOD_PWPOLICY_ERROR_787", 787);

    /**
     * Unable to decode the password policy response control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPPWMOD_CANNOT_DECODE_PWPOLICY_CONTROL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAPPWMOD_CANNOT_DECODE_PWPOLICY_CONTROL_788", 788);

    /**
     * The connection to the Directory Server was closed before the bind response could be read
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPAUTH_CONNECTION_CLOSED_WITHOUT_BIND_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPAUTH_CONNECTION_CLOSED_WITHOUT_BIND_RESPONSE_789", 789);

    /**
     * Use the simple paged results control with the given page size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SIMPLE_PAGE_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SIMPLE_PAGE_SIZE_790", 790);

    /**
     * The simple paged results control may only be used with a single search filter
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PAGED_RESULTS_REQUIRES_SINGLE_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PAGED_RESULTS_REQUIRES_SINGLE_FILTER_791", 791);

    /**
     * Unable to decode the simple paged results control from the search response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PAGED_RESULTS_CANNOT_DECODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PAGED_RESULTS_CANNOT_DECODE_792", 792);

    /**
     * The simple paged results response control was not found in the search result done message from the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PAGED_RESULTS_RESPONSE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PAGED_RESULTS_RESPONSE_NOT_FOUND_793", 793);

    /**
     * Each attribute-level change should be written as a separate modification per attribute value rather than one modification per entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_SINGLE_VALUE_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_SINGLE_VALUE_CHANGES_794", 794);

    /**
     * Rejecting client certificate chain because the prompt trust manager may only be used to trust server certificates
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROMPTTM_REJECTING_CLIENT_CERT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PROMPTTM_REJECTING_CLIENT_CERT_795", 795);

    /**
     * WARNING:  The server did not present a certificate chain.  Do you still wish to attempt connecting to the target server?
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_PROMPTTM_NO_SERVER_CERT_CHAIN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "WARN_PROMPTTM_NO_SERVER_CERT_CHAIN_796", 796);

    /**
     * WARNING:  The server certificate is expired (expiration time:  %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_PROMPTTM_CERT_EXPIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_PROMPTTM_CERT_EXPIRED_797", 797);

    /**
     * WARNING:  The server certificate will not be valid until %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_PROMPTTM_CERT_NOT_YET_VALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_PROMPTTM_CERT_NOT_YET_VALID_798", 798);

    /**
     * The server is using the following certificate: 
    Subject DN:  %s
    Issuer DN:  %s
    Validity:  %s through %s
Do you wish to trust this certificate and continue connecting to the server?
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_PROMPTTM_SERVER_CERT =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_PROMPTTM_SERVER_CERT_799", 799);

    /**
     * Please enter "yes" or "no":
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROMPTTM_YESNO_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROMPTTM_YESNO_PROMPT_800", 800);

    /**
     * The server certificate has been rejected by the user
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROMPTTM_USER_REJECTED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PROMPTTM_USER_REJECTED_801", 801);

    /**
     * Server already stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_SERVER_ALREADY_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_SERVER_ALREADY_STOPPED_802", 802);

    /**
     * Stopping Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_GOING_TO_STOP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_GOING_TO_STOP_803", 803);

    /**
     * Used to determine whether the server can be stopped or not and the mode to be used to stop it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_CHECK_STOPPABILITY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_CHECK_STOPPABILITY_804", 804);

    /**
     * Nickname of certificate for SSL client authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CERT_NICKNAME_805", 805);

    /**
     * Port on which the Directory Server should listen for JMX communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_JMX_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_JMX_PORT_806", 806);

    /**
     * An error occurred while attempting to update the port on which to listen for JMX communication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_JMX_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_JMX_PORT_807", 807);

    /**
     * Port on which the Directory Server should listen for JMX communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_JMXPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_JMXPORT_808", 808);

    /**
     * On which port would you like the Directory Server to accept connections from JMX clients?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_JMXPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_JMXPORT_809", 809);

    /**
     * Result Code:  %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_TOOL_RESULT_CODE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_TOOL_RESULT_CODE_810", 810);

    /**
     * Additional Information:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_ERROR_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOL_ERROR_MESSAGE_811", 811);

    /**
     * Matched DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_MATCHED_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TOOL_MATCHED_DN_812", 812);

    /**
     * Could not find the service name for the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_NOT_FOUND_813", 813);

    /**
     * An unexpected error occurred starting the server as a windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_START_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_START_ERROR_814", 814);

    /**
     * An unexpected error occurred stopping the server windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_STOP_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_STOP_ERROR_815", 815);

    /**
     * This utility can be used to configure the server as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGURE_WINDOWS_SERVICE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGURE_WINDOWS_SERVICE_TOOL_DESCRIPTION_816", 816);

    /**
     * Enables the server as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_ENABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_ENABLE_818", 818);

    /**
     * Disables the server as a Windows service and stops the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_DISABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_DISABLE_819", 819);

    /**
     * Provides information about the state of the server as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_STATE_820", 820);

    /**
     * You can only provide one of the following arguments:
enableService, disableService, serviceState or cleanupService
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIGURE_WINDOWS_SERVICE_TOO_MANY_ARGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_CONFIGURE_WINDOWS_SERVICE_TOO_MANY_ARGS_823", 823);

    /**
     * You must provide at least one of the following arguments:
enableService, disableService or serviceState or cleanupService
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIGURE_WINDOWS_SERVICE_TOO_FEW_ARGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_CONFIGURE_WINDOWS_SERVICE_TOO_FEW_ARGS_824", 824);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_WINDOWS_SERVICE_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_NAME_825", 825);

    /**
     * Next Generation Directory Server.  Installation path: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_WINDOWS_SERVICE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_DESCRIPTION_826", 826);

    /**
     * The server was successfully enabled to run as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WINDOWS_SERVICE_SUCCESSULLY_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_SUCCESSULLY_ENABLED_827", 827);

    /**
     * The server was already enabled to run as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WINDOWS_SERVICE_ALREADY_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_ALREADY_ENABLED_828", 828);

    /**
     * The server could not be enabled to run as a Windows service.  The service name is already in use
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_NAME_ALREADY_IN_USE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_NAME_ALREADY_IN_USE_829", 829);

    /**
     * An unexpected error occurred trying to enable the server as a Windows service.%nCheck that you have administrator rights (only Administrators can enable the server to run as a Windows Service)
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_ENABLE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_ENABLE_ERROR_830", 830);

    /**
     * The server was successfully disabled as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WINDOWS_SERVICE_SUCCESSULLY_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_SUCCESSULLY_DISABLED_831", 831);

    /**
     * The server was already disabled as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WINDOWS_SERVICE_ALREADY_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_ALREADY_DISABLED_832", 832);

    /**
     * The server has been marked for deletion as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_WINDOWS_SERVICE_MARKED_FOR_DELETION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "WARN_WINDOWS_SERVICE_MARKED_FOR_DELETION_833", 833);

    /**
     * An unexpected error occurred trying to disable the server as a Windows service%nCheck that you have administrator rights (only Administrators can disable the server as a Windows Service)
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_DISABLE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_DISABLE_ERROR_834", 834);

    /**
     * The server is enabled as a Windows service.  The service name for the server is: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_WINDOWS_SERVICE_ENABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_ENABLED_835", 835);

    /**
     * The server is disabled as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WINDOWS_SERVICE_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_DISABLED_836", 836);

    /**
     * An unexpected error occurred trying to retrieve the state of the server as a Windows service
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_WINDOWS_SERVICE_STATE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_STATE_ERROR_837", 837);

    /**
     * Used by the window service code to inform that stop-ds is being called from the window services after a call to net stop
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOPDS_DESCRIPTION_WINDOWS_NET_STOP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOPDS_DESCRIPTION_WINDOWS_NET_STOP_838", 838);

    /**
     * Path to a file to which the command will write the output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WAIT4DEL_DESCRIPTION_OUTPUT_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WAIT4DEL_DESCRIPTION_OUTPUT_FILE_839", 839);

    /**
     * WARNING:  Unable to open output file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_WAIT4DEL_CANNOT_OPEN_OUTPUT_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_WAIT4DEL_CANNOT_OPEN_OUTPUT_FILE_840", 840);

    /**
     * Enable the server to run as a Windows Service?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_ENABLE_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_ENABLE_SERVICE_842", 842);

    /**
     * Enable the server to run as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ENABLE_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ENABLE_WINDOWS_SERVICE_843", 843);

    /**
     * Allows to disable the server service and to clean up the windows registry information associated with the provided service name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_CLEANUP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGURE_WINDOWS_SERVICE_DESCRIPTION_CLEANUP_844", 844);

    /**
     * Clean up of service %s was successful
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_WINDOWS_SERVICE_CLEANUP_SUCCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_WINDOWS_SERVICE_CLEANUP_SUCCESS_845", 845);

    /**
     * Could not find the service with name %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_WINDOWS_SERVICE_CLEANUP_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_CLEANUP_NOT_FOUND_846", 846);

    /**
     * Service %s has been marked for deletion
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_WINDOWS_SERVICE_CLEANUP_MARKED_FOR_DELETION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_WINDOWS_SERVICE_CLEANUP_MARKED_FOR_DELETION_847", 847);

    /**
     * An unexpected error occurred cleaning up the service %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_WINDOWS_SERVICE_CLEANUP_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_CLEANUP_ERROR_848", 848);

    /**
     * This utility can be used to rebuild index data within an indexed backend database
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_TOOL_DESCRIPTION_849", 849);

    /**
     * Base DN of a backend supporting indexing. Rebuild is performed on indexes within the scope of the given base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_BASE_DN_850", 850);

    /**
     * Names of index(es) to rebuild. For an attribute index this is simply an attribute name.  At least one index must be specified for rebuild. Cannot be used with the "--rebuildAll" option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_INDEX_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_INDEX_NAME_851", 851);

    /**
     * An error occurred while attempting to perform index rebuild:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REBUILDINDEX_ERROR_DURING_REBUILD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_ERROR_DURING_REBUILD_852", 852);

    /**
     * The backend does not support rebuilding of indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REBUILDINDEX_WRONG_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_WRONG_BACKEND_TYPE_853", 853);

    /**
     * At least one index must be specified for the rebuild process
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REBUILDINDEX_REQUIRES_AT_LEAST_ONE_INDEX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_REQUIRES_AT_LEAST_ONE_INDEX_854", 854);

    /**
     * An error occurred while attempting to acquire a exclusive lock for backend %s:  %s.  This generally means that some other process has an lock on this backend or the server is running with this backend online. The rebuild process cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REBUILDINDEX_CANNOT_EXCLUSIVE_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_CANNOT_EXCLUSIVE_LOCK_BACKEND_855", 855);

    /**
     * An error occurred while attempting to release the shared lock for backend %s:  %s.  This lock should automatically be cleared when the rebuild process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_REBUILDINDEX_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_REBUILDINDEX_CANNOT_UNLOCK_BACKEND_856", 856);

    /**
     * An error occurred while attempting to acquire a shared lock for backend %s:  %s.  This generally means that some other process has an exclusive lock on this backend (e.g., an LDIF import or a restore). The rebuild process cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REBUILDINDEX_CANNOT_SHARED_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_CANNOT_SHARED_LOCK_BACKEND_857", 857);

    /**
     * Port on which the Directory Server should listen for LDAPS communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_LDAPS_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_LDAPS_PORT_858", 858);

    /**
     * An error occurred while attempting to update the port on which to listen for LDAPS communication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_LDAPS_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_LDAPS_PORT_859", 859);

    /**
     * Specifies whether to enable or not StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_ENABLE_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_ENABLE_START_TLS_860", 860);

    /**
     * DN of the key manager provider to use for SSL and/or StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_KEYMANAGER_PROVIDER_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_KEYMANAGER_PROVIDER_DN_861", 861);

    /**
     * DN of the trust manager provider to use for SSL and/or StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_TRUSTMANAGER_PROVIDER_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_TRUSTMANAGER_PROVIDER_DN_862", 862);

    /**
     * An error occurred while attempting to parse key manager provider DN value "%s" as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_PARSE_KEYMANAGER_PROVIDER_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_PARSE_KEYMANAGER_PROVIDER_DN_863", 863);

    /**
     * An error occurred while attempting to parse trust manager provider DN value "%s" as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_CANNOT_PARSE_TRUSTMANAGER_PROVIDER_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_PARSE_TRUSTMANAGER_PROVIDER_DN_864", 864);

    /**
     * An error occurred while attempting to enable StartTLS: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_ENABLE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_ENABLE_STARTTLS_865", 865);

    /**
     * An error occurred while attempting to enable key manager provider entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_ENABLE_KEYMANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_ENABLE_KEYMANAGER_866", 866);

    /**
     * An error occurred while attempting to enable trust manager provider entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_ENABLE_TRUSTMANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_ENABLE_TRUSTMANAGER_867", 867);

    /**
     * An error occurred while attempting to update the key manager provider DN used for LDAPS communication: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_KEYMANAGER_REFERENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_KEYMANAGER_REFERENCE_868", 868);

    /**
     * An error occurred while attempting to update the trust manager provider DN used for LDAPS communication: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_TRUSTMANAGER_REFERENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_TRUSTMANAGER_REFERENCE_869", 869);

    /**
     * Path of the key store to be used by the key manager provider
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_KEYMANAGER_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_KEYMANAGER_PATH_870", 870);

    /**
     * Nickname of the certificate that the connection handler should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGDS_DESCRIPTION_CERTNICKNAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGDS_DESCRIPTION_CERTNICKNAME_871", 871);

    /**
     * ERROR:  You must provide the %s argument when providing the %s argument
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_KEYMANAGER_PROVIDER_DN_REQUIRED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_KEYMANAGER_PROVIDER_DN_REQUIRED_872", 872);

    /**
     * An error occurred while attempting to update the nickname of the certificate that the connection handler should use when accepting SSL-based connections or performing StartTLS negotiation: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_CERT_NICKNAME_873", 873);

    /**
     * LDIF file containing the changes to apply
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPMODIFY_DESCRIPTION_FILENAME_874", 874);

    /**
     * The parent template %s referenced on line %d for template %s is invalid because the referenced parent template is not defined before the template that extends it
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_MAKELDIF_TEMPLATE_INVALID_PARENT_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TEMPLATE_INVALID_PARENT_TEMPLATE_875", 875);

    /**
     * Sort the results using the provided sort order
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SORT_ORDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SORT_ORDER_876", 876);

    /**
     * The provided sort order was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SORTCONTROL_INVALID_ORDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_SORTCONTROL_INVALID_ORDER_877", 877);

    /**
     * Use the virtual list view control to retrieve the specified results page
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_VLV =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_VLV_878", 878);

    /**
     * If the --%s argument is provided, then the --%s argument must also be given
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPSEARCH_VLV_REQUIRES_SORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPSEARCH_VLV_REQUIRES_SORT_879", 879);

    /**
     * The provided virtual list view descriptor was invalid.  It must be a value in the form 'beforeCount:afterCount:offset:contentCount' (where offset specifies the index of the target entry and contentCount specifies the estimated total number of results or zero if it is not known), or 'beforeCount:afterCount:assertionValue' (where the entry should be the first entry whose primary sort value is greater than or equal to the provided assertionValue).  In either case, beforeCount is the number of entries to return before the target value and afterCount is the number of entries to return after the target value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPSEARCH_VLV_INVALID_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPSEARCH_VLV_INVALID_DESCRIPTOR_880", 880);

    /**
     * # Server-side sort failed:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_SORT_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_LDAPSEARCH_SORT_ERROR_881", 881);

    /**
     * # Unable to decode the server-side sort response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_CANNOT_DECODE_SORT_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_LDAPSEARCH_CANNOT_DECODE_SORT_RESPONSE_882", 882);

    /**
     * # VLV Target Offset:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_VLV_TARGET_OFFSET =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_VLV_TARGET_OFFSET_883", 883);

    /**
     * # VLV Content Count:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_VLV_CONTENT_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_VLV_CONTENT_COUNT_884", 884);

    /**
     * # Virtual list view processing failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_VLV_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_LDAPSEARCH_VLV_ERROR_885", 885);

    /**
     * # Unable to decode the virtual list view response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_CANNOT_DECODE_VLV_RESPONSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_LDAPSEARCH_CANNOT_DECODE_VLV_RESPONSE_886", 886);

    /**
     * The specified LDIF file %s cannot be read
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFIMPORT_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_READ_FILE_887", 887);

    /**
     * Use geteffectiverights control with the provided authzid
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_EFFECTIVERIGHTS_USER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_EFFECTIVERIGHTS_USER_888", 888);

    /**
     * Specifies geteffectiverights control specific attribute list
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_EFFECTIVERIGHTS_ATTR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_EFFECTIVERIGHTS_ATTR_889", 889);

    /**
     * The authorization ID "%s" contained in the geteffectiverights control is invalid because it does not start with "dn:" to indicate a user DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EFFECTIVERIGHTS_INVALID_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_EFFECTIVERIGHTS_INVALID_AUTHZID_890", 890);

    /**
     * Use script-friendly mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SCRIPT_FRIENDLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SCRIPT_FRIENDLY_1076", 1076);

    /**
     * This utility can be used to retrieve and manipulate the values of password policy state variables
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_TOOL_DESCRIPTION_1094", 1094);

    /**
     * Directory server hostname or IP address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_HOST =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_HOST_1095", 1095);

    /**
     * Directory server administration port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_PORT_1096", 1096);

    /**
     * The DN to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_BINDDN_1099", 1099);

    /**
     * The password to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_BINDPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_BINDPW_1100", 1100);

    /**
     * The path to the file containing the bind password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_BINDPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_BINDPWFILE_1101", 1101);

    /**
     * The DN of the user entry for which to get and set password policy state information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_TARGETDN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_TARGETDN_1102", 1102);

    /**
     * SASL bind options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_SASLOPTIONS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_SASLOPTIONS_1103", 1103);

    /**
     * Certificate key store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_KSFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_KSFILE_1105", 1105);

    /**
     * Certificate key store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_KSPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_KSPW_1106", 1106);

    /**
     * Certificate key store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_KSPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_KSPWFILE_1107", 1107);

    /**
     * Certificate trust store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_TSFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_TSFILE_1108", 1108);

    /**
     * Certificate trust store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_TSPW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_TSPW_1109", 1109);

    /**
     * Certificate trust store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_DESCRIPTION_TSPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_DESCRIPTION_TSPWFILE_1110", 1110);

    /**
     * Display all password policy state information for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_ALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_ALL_1112", 1112);

    /**
     * Display the DN of the password policy for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_POLICY_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_POLICY_DN_1113", 1113);

    /**
     * Display information about whether the user account has been administratively disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_ACCOUNT_DISABLED_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_ACCOUNT_DISABLED_STATE_1114", 1114);

    /**
     * Specify whether the user account has been administratively disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_ACCOUNT_DISABLED_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_ACCOUNT_DISABLED_STATE_1115", 1115);

    /**
     * 'true' to indicate that the account is disabled, or 'false' to indicate that it is not disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_OPERATION_BOOLEAN_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_OPERATION_BOOLEAN_VALUE_1116", 1116);

    /**
     * Clear account disabled state information from the user account
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_ACCOUNT_DISABLED_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_ACCOUNT_DISABLED_STATE_1117", 1117);

    /**
     * Display when the user account will expire
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_ACCOUNT_EXPIRATION_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_ACCOUNT_EXPIRATION_TIME_1118", 1118);

    /**
     * Specify when the user account will expire
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_ACCOUNT_EXPIRATION_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_ACCOUNT_EXPIRATION_TIME_1119", 1119);

    /**
     * A timestamp value using the generalized time syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_OPERATION_TIME_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_OPERATION_TIME_VALUE_1120", 1120);

    /**
     * Clear account expiration time information from the user account
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_ACCOUNT_EXPIRATION_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_ACCOUNT_EXPIRATION_TIME_1121", 1121);

    /**
     * Display the length of time in seconds until the user account expires
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_ACCOUNT_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_ACCOUNT_EXPIRATION_1122", 1122);

    /**
     * Display the time that the user's password was last changed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_CHANGED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_CHANGED_TIME_1123", 1123);

    /**
     * Specify the time that the user's password was last changed.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_CHANGED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_CHANGED_TIME_1124", 1124);

    /**
     * Clear information about the time that the user's password was last changed.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_CHANGED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_CHANGED_TIME_1125", 1125);

    /**
     * Display the time that the user first received an expiration warning notice
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_EXPIRATION_WARNED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_EXPIRATION_WARNED_TIME_1126", 1126);

    /**
     * Specify the time that the user first received an expiration warning notice.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_EXPIRATION_WARNED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_EXPIRATION_WARNED_TIME_1127", 1127);

    /**
     * Clear information about the time that the user first received an expiration warning notice.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_EXPIRATION_WARNED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_EXPIRATION_WARNED_TIME_1128", 1128);

    /**
     * Display length of time in seconds until the user's password expires
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_PASSWORD_EXP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_PASSWORD_EXP_1129", 1129);

    /**
     * Display the length of time in seconds until the user should start receiving password expiration warning notices
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_PASSWORD_EXP_WARNING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_PASSWORD_EXP_WARNING_1130", 1130);

    /**
     * Display the authentication failure times for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_AUTH_FAILURE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_AUTH_FAILURE_TIMES_1131", 1131);

    /**
     * Add an authentication failure time to the user account.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_ADD_AUTH_FAILURE_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_ADD_AUTH_FAILURE_TIME_1132", 1132);

    /**
     * Specify the authentication failure times for the user.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_AUTH_FAILURE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_AUTH_FAILURE_TIMES_1133", 1133);

    /**
     * A timestamp value using the generalized time syntax.  Multiple timestamp values may be given by providing this argument multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_OPERATION_TIME_VALUES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_OPERATION_TIME_VALUES_1134", 1134);

    /**
     * Clear authentication failure time information from the user's account.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_AUTH_FAILURE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_AUTH_FAILURE_TIMES_1135", 1135);

    /**
     * Display the length of time in seconds until the authentication failure lockout expires
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_AUTH_FAILURE_UNLOCK =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_AUTH_FAILURE_UNLOCK_1136", 1136);

    /**
     * Display the number of remaining authentication failures until the user's account is locked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_REMAINING_AUTH_FAILURE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_REMAINING_AUTH_FAILURE_COUNT_1137", 1137);

    /**
     * Display the time that the user last authenticated to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_LAST_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_LAST_LOGIN_TIME_1138", 1138);

    /**
     * Specify the time that the user last authenticated to the server.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_LAST_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_LAST_LOGIN_TIME_1139", 1139);

    /**
     * Clear the time that the user last authenticated to the server.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_LAST_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_LAST_LOGIN_TIME_1140", 1140);

    /**
     * Display the length of time in seconds until user's account is locked because it has remained idle for too long
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_IDLE_LOCKOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_IDLE_LOCKOUT_1141", 1141);

    /**
     * Display information about whether the user will be required to change his or her password on the next successful authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_RESET_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_RESET_STATE_1142", 1142);

    /**
     * Specify whether the user will be required to change his or her password on the next successful authentication.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_RESET_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_PASSWORD_RESET_STATE_1143", 1143);

    /**
     * Clear information about whether the user will be required to change his or her password on the next successful authentication.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_RESET_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_RESET_STATE_1144", 1144);

    /**
     * Display the length of time in seconds until user's account is locked because the user failed to change the password in a timely manner after an administrative reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_RESET_LOCKOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_RESET_LOCKOUT_1145", 1145);

    /**
     * Display the grace login use times for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_GRACE_LOGIN_USE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_GRACE_LOGIN_USE_TIMES_1146", 1146);

    /**
     * Add a grace login use time to the user account.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_ADD_GRACE_LOGIN_USE_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_ADD_GRACE_LOGIN_USE_TIME_1147", 1147);

    /**
     * Specify the grace login use times for the user.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_GRACE_LOGIN_USE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_GRACE_LOGIN_USE_TIMES_1148", 1148);

    /**
     * Clear the set of grace login use times for the user.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_GRACE_LOGIN_USE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_GRACE_LOGIN_USE_TIMES_1149", 1149);

    /**
     * Display the number of grace logins remaining for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_REMAINING_GRACE_LOGIN_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_REMAINING_GRACE_LOGIN_COUNT_1150", 1150);

    /**
     * Display the required password change time with which the user last complied
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PW_CHANGED_BY_REQUIRED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PW_CHANGED_BY_REQUIRED_TIME_1151", 1151);

    /**
     * Specify the required password change time with which the user last complied.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_SET_PW_CHANGED_BY_REQUIRED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_SET_PW_CHANGED_BY_REQUIRED_TIME_1152", 1152);

    /**
     * Clear information about the required password change time with which the user last complied.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_PW_CHANGED_BY_REQUIRED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_PW_CHANGED_BY_REQUIRED_TIME_1153", 1153);

    /**
     * Display the length of time in seconds that the user has remaining to change his or her password before the account becomes locked due to the required change time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_REQUIRED_CHANGE_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_SECONDS_UNTIL_REQUIRED_CHANGE_TIME_1154", 1154);

    /**
     * No subcommand was provided to indicate which password policy state operation should be performed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_NO_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_NO_SUBCOMMAND_1155", 1155);

    /**
     * The provided value '%s' was invalid for the requested operation.  A Boolean value of either 'true' or 'false' was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_INVALID_BOOLEAN_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_INVALID_BOOLEAN_VALUE_1156", 1156);

    /**
     * No value was specified, but the requested operation requires a Boolean value of either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_NO_BOOLEAN_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_NO_BOOLEAN_VALUE_1157", 1157);

    /**
     * Unrecognized subcommand '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_INVALID_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_INVALID_SUBCOMMAND_1158", 1158);

    /**
     * An error occurred while attempting to send the request to the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_CANNOT_SEND_REQUEST_EXTOP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_SEND_REQUEST_EXTOP_1159", 1159);

    /**
     * The Directory Server closed the connection before the response could be read
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_CONNECTION_CLOSED_READING_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CONNECTION_CLOSED_READING_RESPONSE_1160", 1160);

    /**
     * The server was unable to process the request:  result code %d (%s), error message '%s'
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_PWPSTATE_REQUEST_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_REQUEST_FAILED_1161", 1161);

    /**
     * Unable to decode the response message from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_CANNOT_DECODE_RESPONSE_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DECODE_RESPONSE_MESSAGE_1162", 1162);

    /**
     * Unable to decode information about an operation contained in the response:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_CANNOT_DECODE_RESPONSE_OP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DECODE_RESPONSE_OP_1163", 1163);

    /**
     * Password Policy DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_POLICY_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_POLICY_DN_1164", 1164);

    /**
     * Account Is Disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_ACCOUNT_DISABLED_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_ACCOUNT_DISABLED_STATE_1165", 1165);

    /**
     * Account Expiration Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_ACCOUNT_EXPIRATION_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_ACCOUNT_EXPIRATION_TIME_1166", 1166);

    /**
     * Seconds Until Account Expiration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_ACCOUNT_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_ACCOUNT_EXPIRATION_1167", 1167);

    /**
     * Password Changed Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_CHANGED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_CHANGED_TIME_1168", 1168);

    /**
     * Password Expiration Warned Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_EXPIRATION_WARNED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_EXPIRATION_WARNED_TIME_1169", 1169);

    /**
     * Seconds Until Password Expiration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_EXPIRATION_1170", 1170);

    /**
     * Seconds Until Password Expiration Warning
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_EXPIRATION_WARNING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_EXPIRATION_WARNING_1171", 1171);

    /**
     * Authentication Failure Times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_AUTH_FAILURE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_AUTH_FAILURE_TIMES_1172", 1172);

    /**
     * Seconds Until Authentication Failure Unlock
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_AUTH_FAILURE_UNLOCK =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_AUTH_FAILURE_UNLOCK_1173", 1173);

    /**
     * Remaining Authentication Failure Count
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_REMAINING_AUTH_FAILURE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_REMAINING_AUTH_FAILURE_COUNT_1174", 1174);

    /**
     * Last Login Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_LAST_LOGIN_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_LAST_LOGIN_TIME_1175", 1175);

    /**
     * Seconds Until Idle Account Lockout
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_IDLE_LOCKOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_IDLE_LOCKOUT_1176", 1176);

    /**
     * Password Is Reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_RESET_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_RESET_STATE_1177", 1177);

    /**
     * Seconds Until Password Reset Lockout
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_RESET_LOCKOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_PASSWORD_RESET_LOCKOUT_1178", 1178);

    /**
     * Grace Login Use Times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_GRACE_LOGIN_USE_TIMES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_GRACE_LOGIN_USE_TIMES_1179", 1179);

    /**
     * Remaining Grace Login Count
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_REMAINING_GRACE_LOGIN_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_REMAINING_GRACE_LOGIN_COUNT_1180", 1180);

    /**
     * Password Changed by Required Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_CHANGED_BY_REQUIRED_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_CHANGED_BY_REQUIRED_TIME_1181", 1181);

    /**
     * Seconds Until Required Change Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_SECONDS_UNTIL_REQUIRED_CHANGE_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_SECONDS_UNTIL_REQUIRED_CHANGE_TIME_1182", 1182);

    /**
     * Unrecognized or invalid operation type:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_INVALID_RESPONSE_OP_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_INVALID_RESPONSE_OP_TYPE_1183", 1183);

    /**
     * ERROR:  You may not provide both the %s and the %s arguments
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_MUTUALLY_EXCLUSIVE_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_MUTUALLY_EXCLUSIVE_ARGUMENTS_1184", 1184);

    /**
     * ERROR:  Unable to perform SSL initialization:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_CANNOT_INITIALIZE_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_INITIALIZE_SSL_1185", 1185);

    /**
     * ERROR:  The provided SASL option string "%s" could not be parsed in the form "name=value"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_CANNOT_PARSE_SASL_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_PARSE_SASL_OPTION_1186", 1186);

    /**
     * ERROR:  One or more SASL options were provided, but none of them were the "mech" option to specify which SASL mechanism should be used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_NO_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_NO_SASL_MECHANISM_1187", 1187);

    /**
     * ERROR:  Cannot parse the value of the %s argument as an integer value between 1 and 65535:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_CANNOT_DETERMINE_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DETERMINE_PORT_1188", 1188);

    /**
     * ERROR:  Cannot establish a connection to the Directory Server %s.  Verify that the server is running and that the provided credentials are valid.  Details:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_CANNOT_CONNECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_CONNECT_1189", 1189);

    /**
     * Count the number of entries rejected by the server and return that value as the exit code (values > 255 will be reduced to 255 due to exit code restrictions)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_COUNT_REJECTS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_COUNT_REJECTS_1195", 1195);

    /**
     * Write skipped entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_SKIP_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_SKIP_FILE_1197", 1197);

    /**
     * An error occurred while trying to open the skip file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_OPEN_SKIP_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_OPEN_SKIP_FILE_1198", 1198);

    /**
     * Count the number of errors found during the verification and return that value as the exit code (values > 255 will be reduced to 255 due to exit code restrictions)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFYINDEX_DESCRIPTION_COUNT_ERRORS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VERIFYINDEX_DESCRIPTION_COUNT_ERRORS_1199", 1199);

    /**
     * Password History
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPSTATE_LABEL_PASSWORD_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PWPSTATE_LABEL_PASSWORD_HISTORY_1201", 1201);

    /**
     * Display password history state values for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_GET_PASSWORD_HISTORY_1202", 1202);

    /**
     * Clear password history state values for the user.  This should be used only for testing purposes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PWPSTATE_CLEAR_PASSWORD_HISTORY_1203", 1203);

    /**
     * ERROR:  You have specified the value %s for different ports
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_PORT_ALREADY_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_PORT_ALREADY_SPECIFIED_1211", 1211);

    /**
     * Remove all entries for all base DNs in the backend before importing
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_CLEAR_BACKEND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_CLEAR_BACKEND_1251", 1251);

    /**
     * Neither the %s or the %s argument was provided.  One of these arguments must be given to specify the backend for the LDIF data to be imported to
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_MISSING_BACKEND_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_MISSING_BACKEND_ARGUMENT_1252", 1252);

    /**
     * The list tag on line %d of the template file does not contain any arguments to specify the list values.  At least one list value must be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_MAKELDIF_TAG_LIST_NO_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_MAKELDIF_TAG_LIST_NO_ARGUMENTS_1291", 1291);

    /**
     * The list tag on line %d of the template file contains item '%s' that includes a semicolon but that semicolon is not followed by an integer.  The semicolon will be assumed to be part of the value and not a delimiter to separate the value from its relative weight
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> WARN_MAKELDIF_TAG_LIST_INVALID_WEIGHT =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "WARN_MAKELDIF_TAG_LIST_INVALID_WEIGHT_1292", 1292);

    /**
     * An unexpected error occurred attempting to set the server's root directory to %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INITIALIZE_SERVER_ROOT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INITIALIZE_SERVER_ROOT_1293", 1293);

    /**
     * ERROR:  Unable to perform SSL initialization:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_CANNOT_INITIALIZE_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_CANNOT_INITIALIZE_SSL_1295", 1295);

    /**
     * ERROR:  The provided SASL option string "%s" could not be parsed in the form "name=value"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_CANNOT_PARSE_SASL_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_CANNOT_PARSE_SASL_OPTION_1296", 1296);

    /**
     * ERROR:  One or more SASL options were provided, but none of them were the "mech" option to specify which SASL mechanism should be used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_CONN_NO_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_NO_SASL_MECHANISM_1297", 1297);

    /**
     * NOTICE:  The connection to the Directory Server was closed while waiting for a response to the shutdown request.  This likely means that the server has started the shutdown process
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_CLIENT_UNEXPECTED_CONNECTION_CLOSURE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_TASK_CLIENT_UNEXPECTED_CONNECTION_CLOSURE_1315", 1315);

    /**
     * ERROR:  An I/O error occurred while attempting to communicate with the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_TOOL_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_TOOL_IO_ERROR_1316", 1316);

    /**
     * ERROR:  An error occurred while trying to decode the response from the server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_TOOL_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_TOOL_DECODE_ERROR_1317", 1317);

    /**
     * ERROR:  Expected an add response message but got a %s message instead
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CLIENT_INVALID_RESPONSE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_CLIENT_INVALID_RESPONSE_TYPE_1318", 1318);

    /**
     * %s task %s scheduled to start immediately
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TASK_TOOL_TASK_SCHEDULED_NOW =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_TASK_TOOL_TASK_SCHEDULED_NOW_1319", 1319);

    /**
     * ERROR:  argument %s is incompatible with use of this tool to interact with the directory as a client
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_INCOMPATIBLE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDAP_CONN_INCOMPATIBLE_ARGS_1320", 1320);

    /**
     * This tool may only be used on UNIX-based systems
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CREATERC_ONLY_RUNS_ON_UNIX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_CREATERC_ONLY_RUNS_ON_UNIX_1321", 1321);

    /**
     * Create an RC script that may be used to start, stop, and restart the Directory Server on UNIX-based systems
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATERC_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CREATERC_TOOL_DESCRIPTION_1322", 1322);

    /**
     * The path to the output file to create
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATERC_OUTFILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CREATERC_OUTFILE_DESCRIPTION_1323", 1323);

    /**
     * Unable to determine the path to the server root directory.  Please ensure that the %s system property or the %s environment variable is set to the path of the server root directory
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CREATERC_UNABLE_TO_DETERMINE_SERVER_ROOT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CREATERC_UNABLE_TO_DETERMINE_SERVER_ROOT_1324", 1324);

    /**
     * An error occurred while attempting to generate the RC script:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATERC_CANNOT_WRITE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CREATERC_CANNOT_WRITE_1325", 1325);

    /**
     * List the base DNs in a backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_SUBCMD_LIST_ENTRY_CONTAINERS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_SUBCMD_LIST_ENTRY_CONTAINERS_1329", 1329);

    /**
     * The backend ID of the backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_BACKEND_ID_1331", 1331);

    /**
     * The base DN within the backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_BASE_DN_1332", 1332);

    /**
     * The name of the index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_INDEX_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_INDEX_NAME_1333", 1333);

    /**
     * Do not try to decode backend data to their appropriate types
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_SKIP_DECODE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_SKIP_DECODE_1334", 1334);

    /**
     * Shows the status of indexes for a backend base DN. This subcommand can take a long time to complete, as it reads all indexes for all backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_SUBCMD_LIST_INDEX_STATUS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_SUBCMD_LIST_INDEX_STATUS_1336", 1336);

    /**
     * Only show records with keys that should be ordered before the provided value using the comparator for the database container
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_MAX_KEY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_MAX_KEY_VALUE_1337", 1337);

    /**
     * Only show records with keys that should be ordered after the provided value using the comparator for the database container
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_MIN_KEY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_MIN_KEY_VALUE_1338", 1338);

    /**
     * Only show records whose data is no larger than the provided value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_MAX_DATA_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_MAX_DATA_SIZE_1339", 1339);

    /**
     * Only show records whose data is no smaller than the provided value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_MIN_DATA_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_MIN_DATA_SIZE_1340", 1340);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_BACKEND_ID_1342", 1342);

    /**
     * Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_BASE_DN_1344", 1344);

    /**
     * None of the Directory Server backends are configured with the requested backend ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_DEBUG_NO_BACKENDS_FOR_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_DEBUG_NO_BACKENDS_FOR_ID_1347", 1347);

    /**
     * None of the entry containers are configured with the requested base DN %s in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_DEBUG_NO_ENTRY_CONTAINERS_FOR_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_DEBUG_NO_ENTRY_CONTAINERS_FOR_BASE_DN_1348", 1348);

    /**
     * Unable to decode base DN string "%s" as a valid distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_DEBUG_DECODE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_DEBUG_DECODE_BASE_DN_1352", 1352);

    /**
     * Record Count
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_RECORD_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_RECORD_COUNT_1356", 1356);

    /**
     * Index Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_INDEX_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_INDEX_NAME_1357", 1357);

    /**
     * Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_INDEX_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_INDEX_TYPE_1358", 1358);

    /**
     * Valid
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_INDEX_STATUS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_INDEX_STATUS_1359", 1359);

    /**
     * Confidential
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_DEBUG_INDEX_CONFIDENTIAL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_DEBUG_INDEX_CONFIDENTIAL_1360", 1360);

    /**
     * An error occurred while attempting to release the shared lock for backend %s:  %s.  This lock should automatically be cleared when the process exits, so no further action should be required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BACKEND_DEBUG_CANNOT_UNLOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "WARN_BACKEND_DEBUG_CANNOT_UNLOCK_BACKEND_1362", 1362);

    /**
     * An error occurred while attempting to acquire a shared lock for backend %s:  %s.  This generally means that some other process has exclusive access to this backend (e.g., a restore or an LDIF import)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_DEBUG_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_DEBUG_CANNOT_LOCK_BACKEND_1363", 1363);

    /**
     * A sub-command must be specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BACKEND_DEBUG_MISSING_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_BACKEND_DEBUG_MISSING_SUBCOMMAND_1374", 1374);

    /**
     * The name of the user account under which the server should run
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATERC_USER_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CREATERC_USER_DESCRIPTION_1375", 1375);

    /**
     * The path to the Java installation that should be used to run the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATERC_JAVA_HOME_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CREATERC_JAVA_HOME_DESCRIPTION_1376", 1376);

    /**
     * A set of arguments that should be passed to the JVM when running the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CREATERC_JAVA_ARGS_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CREATERC_JAVA_ARGS_DESCRIPTION_1377", 1377);

    /**
     * The directory %s specified as the OPENDJ_JAVA_HOME path does not exist or is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATERC_JAVA_HOME_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CREATERC_JAVA_HOME_DOESNT_EXIST_1378", 1378);

    /**
     * To see basic server configuration status and configuration, you can launch %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INSTALLDS_STATUS_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_STATUS_COMMAND_LINE_1379", 1379);

    /**
     * Do you want to enable SSL?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_ENABLE_SSL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_ENABLE_SSL_1380", 1380);

    /**
     * On which port would you like the Directory Server to accept connections from LDAPS clients?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_LDAPSPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_LDAPSPORT_1381", 1381);

    /**
     * Do you want to enable Start TLS?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_ENABLE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_ENABLE_STARTTLS_1382", 1382);

    /**
     * Java Key Store (JKS) path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_JKS_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_JKS_PATH_1383", 1383);

    /**
     * PKCS#12 key Store path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_PKCS12_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_PKCS12_PATH_1384", 1384);

    /**
     * Key store PIN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_KEYSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_KEYSTORE_PASSWORD_1385", 1385);

    /**
     * Use nickname %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INSTALLDS_PROMPT_CERTNICKNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_CERTNICKNAME_1386", 1386);

    /**
     * Certificate server options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_HEADER_CERT_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_HEADER_CERT_TYPE_1387", 1387);

    /**
     * Generate self-signed certificate (recommended for testing purposes only)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CERT_OPTION_SELF_SIGNED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CERT_OPTION_SELF_SIGNED_1388", 1388);

    /**
     * Use an existing certificate located on a Java Key Store (JKS)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CERT_OPTION_JKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CERT_OPTION_JKS_1389", 1389);

    /**
     * Use an existing certificate located on a PKCS#12 key store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CERT_OPTION_PKCS12 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CERT_OPTION_PKCS12_1390", 1390);

    /**
     * Use an existing certificate on a PKCS#11 token
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CERT_OPTION_PKCS11 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CERT_OPTION_PKCS11_1391", 1391);

    /**
     * Do you want to start the server when the configuration is completed?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_START_SERVER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_START_SERVER_1393", 1393);

    /**
     * The provided certificate nickname could not be found.  The key store contains the following certificate nicknames: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_CERTNICKNAME_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CERTNICKNAME_NOT_FOUND_1394", 1394);

    /**
     * The key store contains the following certificate nicknames: %s.%nYou have to provide the nickname of the certificate you want to use
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_MUST_PROVIDE_CERTNICKNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_MUST_PROVIDE_CERTNICKNAME_1395", 1395);

    /**
     * Do not start the server when the configuration is completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_DO_NOT_START =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_DO_NOT_START_1396", 1396);

    /**
     * Enable StartTLS to allow secure communication with the server using the LDAP port
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ENABLE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ENABLE_STARTTLS_1397", 1397);

    /**
     * Port on which the Directory Server should listen for LDAPS communication.  The LDAPS port will be configured and SSL will be enabled only if this argument is explicitly specified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_LDAPSPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_LDAPSPORT_1398", 1398);

    /**
     * Generate a self-signed certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_USE_SELF_SIGNED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_USE_SELF_SIGNED_1399", 1399);

    /**
     * Use a certificate in a PKCS#11 token that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_USE_PKCS11 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_USE_PKCS11_1400", 1400);

    /**
     * Path of a Java Key Store (JKS) containing a certificate to be used as the server certificate. This does not apply to the administration connector, which uses its own key store and certificate (default: config/admin-keystore and admin-cert)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_USE_JAVAKEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_USE_JAVAKEYSTORE_1401", 1401);

    /**
     * Path of a PKCS#12 key store containing the certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_USE_PKCS12 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_USE_PKCS12_1402", 1402);

    /**
     * Certificate key store PIN.  A PIN is required when you specify to use an existing certificate (JKS, JCEKS, PKCS#12 or PKCS#11) as server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_KEYSTOREPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_KEYSTOREPASSWORD_1403", 1403);

    /**
     * Certificate key store PIN file.  A PIN is required when you specify to use an existing certificate (JKS, JCEKS, PKCS#12 or PKCS#11) as server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_KEYSTOREPASSWORD_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_KEYSTOREPASSWORD_FILE_1404", 1404);

    /**
     * Nickname of the certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_CERT_NICKNAME_1405", 1405);

    /**
     * You have specified several certificate types to be used.  Only one certificate type (self-signed, JKS, JCEKS, PKCS#12 or PCKS#11) is allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_SEVERAL_CERTIFICATE_TYPE_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_SEVERAL_CERTIFICATE_TYPE_SPECIFIED_1406", 1406);

    /**
     * You have chosen to enable SSL or StartTLS.  You must specify which type of certificate you want the server to use
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_CERTIFICATE_REQUIRED_FOR_SSL_OR_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CERTIFICATE_REQUIRED_FOR_SSL_OR_STARTTLS_1407", 1407);

    /**
     * You must provide the PIN of the keystore to retrieve the certificate to be used by the server.  You can use {%s} or {%s}
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INSTALLDS_NO_KEYSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_NO_KEYSTORE_PASSWORD_1408", 1408);

    /**
     * You have specified to use a certificate as server certificate.  You must enable SSL (using option {%s}) or Start TLS (using option %s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INSTALLDS_SSL_OR_STARTTLS_REQUIRED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_SSL_OR_STARTTLS_REQUIRED_1410", 1410);

    /**
     * The argument '%s' is incompatible with '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_INCOMPATIBLE_ARGS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_INCOMPATIBLE_ARGS_1411", 1411);

    /**
     * This utility can be used to obtain a list of tasks scheduled to run within the Directory Server as well as information about individual tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_TOOL_DESCRIPTION_1412", 1412);

    /**
     * Print a summary of tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_SUMMARY_ARG_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_SUMMARY_ARG_DESCRIPTION_1413", 1413);

    /**
     * ID of a particular task about which this tool will display information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_TASK_ARG_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_TASK_ARG_DESCRIPTION_1414", 1414);

    /**
     * refresh
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_REFRESH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_REFRESH_1415", 1415);

    /**
     * cancel task
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_CANCEL_1416", 1416);

    /**
     * view logs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_VIEW_LOGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_VIEW_LOGS_1417", 1417);

    /**
     * Enter the number of a task to cancel [%d]
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_TASKINFO_CMD_CANCEL_NUMBER_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_CANCEL_NUMBER_PROMPT_1419", 1419);

    /**
     * Invalid menu item or task number '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKINFO_INVALID_MENU_KEY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_INVALID_MENU_KEY_1422", 1422);

    /**
     * ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_ID_1423", 1423);

    /**
     * Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_TYPE_1424", 1424);

    /**
     * Status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_STATUS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_STATUS_1425", 1425);

    /**
     * Scheduled Start Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_SCHEDULED_START =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_SCHEDULED_START_1426", 1426);

    /**
     * Actual Start Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_ACTUAL_START =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_ACTUAL_START_1427", 1427);

    /**
     * Completion Time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_COMPLETION_TIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_COMPLETION_TIME_1428", 1428);

    /**
     * Dependencies
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_DEPENDENCY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_DEPENDENCY_1429", 1429);

    /**
     * Failed Dependency Action
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_FAILED_DEPENDENCY_ACTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_FAILED_DEPENDENCY_ACTION_1430", 1430);

    /**
     * Log Message(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_LOG =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_LOG_1431", 1431);

    /**
     * Last Log Message
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_LAST_LOG =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_LAST_LOG_1432", 1432);

    /**
     * Email Upon Completion
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_NOTIFY_ON_COMPLETION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_NOTIFY_ON_COMPLETION_1433", 1433);

    /**
     * Email Upon Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_FIELD_NOTIFY_ON_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_FIELD_NOTIFY_ON_ERROR_1434", 1434);

    /**
     * Task %s canceled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASKINFO_CMD_CANCEL_SUCCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_CANCEL_SUCCESS_1435", 1435);

    /**
     * Error retrieving task entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKINFO_RETRIEVING_TASK_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_RETRIEVING_TASK_ENTRY_1437", 1437);

    /**
     * There are no tasks with ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKINFO_UNKNOWN_TASK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_UNKNOWN_TASK_ENTRY_1438", 1438);

    /**
     * Task Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_DETAILS_1439", 1439);

    /**
     * %s Options
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASKINFO_OPTIONS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_TASKINFO_OPTIONS_1440", 1440);

    /**
     * No tasks exist
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_NO_TASKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_NO_TASKS_1441", 1441);

    /**
     * None
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_NONE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_NONE_1442", 1442);

    /**
     * None Specified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_NONE_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_NONE_SPECIFIED_1443", 1443);

    /**
     * Immediate execution
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_IMMEDIATE_EXECUTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_IMMEDIATE_EXECUTION_1444", 1444);

    /**
     * Error connecting to the directory server: '%s'. Verify that the connection options are correct and that the server is running
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASKINFO_LDAP_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_TASKINFO_LDAP_EXCEPTION_1445", 1445);

    /**
     * Options '%s' and '%s' are incompatible with each other and cannot be used together
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INCOMPATIBLE_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INCOMPATIBLE_ARGUMENTS_1446", 1446);

    /**
     * ID of a particular task to cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_TASK_ARG_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_TASK_ARG_CANCEL_1447", 1447);

    /**
     * Error canceling task '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKINFO_CANCELING_TASK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_CANCELING_TASK_1448", 1448);

    /**
     * Error accessing logs for task '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKINFO_ACCESSING_LOGS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_ACCESSING_LOGS_1449", 1449);

    /**
     * Task at index %d is not cancelable
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_TASKINFO_NOT_CANCELABLE_TASK_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_NOT_CANCELABLE_TASK_INDEX_1450", 1450);

    /**
     * There are currently no cancelable tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_NO_CANCELABLE_TASKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_NO_CANCELABLE_TASKS_1452", 1452);

    /**
     * There are no tasks defined with ID '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CLIENT_UNKNOWN_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_CLIENT_UNKNOWN_TASK_1453", 1453);

    /**
     * Task '%s' has finished and cannot be canceled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CLIENT_UNCANCELABLE_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_CLIENT_UNCANCELABLE_TASK_1454", 1454);

    /**
     * State for task '%s' cannot be determined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CLIENT_TASK_STATE_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_CLIENT_TASK_STATE_UNKNOWN_1455", 1455);

    /**
     * Indicates the date/time at which this operation will start when scheduled as a server task expressed in YYYYMMDDhhmmssZ format for UTC time or YYYYMMDDhhmmss for local time.  A value of '0' will cause the task to be scheduled for immediate execution.  When this option is specified the operation will be scheduled to start at the specified time after which this utility will exit immediately
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_START_DATETIME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_START_DATETIME_1456", 1456);

    /**
     * The start date/time must in YYYYMMDDhhmmssZ format for UTC time or YYYYMMDDhhmmss for local time
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_START_DATETIME_FORMAT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_START_DATETIME_FORMAT_1457", 1457);

    /**
     * %s task %s scheduled to start %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_TASK_TOOL_TASK_SCHEDULED_FUTURE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_TASK_TOOL_TASK_SCHEDULED_FUTURE_1458", 1458);

    /**
     * You have provided options for scheduling this operation as a task but options provided for connecting to the server's tasks backend resulted in the following error: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_TOOL_START_TIME_NO_LDAP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_TOOL_START_TIME_NO_LDAP_1459", 1459);

    /**
     * Path to the file containing default property values used for command line arguments
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PROP_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PROP_FILE_PATH_1461", 1461);

    /**
     * No properties file will be used to get default command line argument values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_NO_PROP_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_NO_PROP_FILE_1462", 1462);

    /**
     * Task Scheduling Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TASK_TASK_ARGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_TASK_ARGS_1463", 1463);

    /**
     * Task Backend Connection Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TASK_LDAP_ARGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_LDAP_ARGS_1464", 1464);

    /**
     * Configuration Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONFIG_OPTIONS_ARGS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CONFIG_OPTIONS_ARGS_1468", 1468);

    /**
     * Email address of a recipient to be notified when the task completes.  This option may be specified more than once
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TASK_COMPLETION_NOTIFICATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_COMPLETION_NOTIFICATION_1469", 1469);

    /**
     * Email address of a recipient to be notified if an error occurs when this task executes.  This option may be specified more than once
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TASK_ERROR_NOTIFICATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_ERROR_NOTIFICATION_1470", 1470);

    /**
     * ID of a task upon which this task depends.  A task will not start execution until all its dependencies have completed execution
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TASK_DEPENDENCY_ID =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_DEPENDENCY_ID_1471", 1471);

    /**
     * Action this task will take should one if its dependent tasks fail.  The value must be one of %s.  If not specified defaults to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DESCRIPTION_TASK_FAILED_DEPENDENCY_ACTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_TASK_FAILED_DEPENDENCY_ACTION_1472", 1472);

    /**
     * The option %s is only applicable when scheduling this operation as a task
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKTOOL_OPTIONS_FOR_TASK_ONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASKTOOL_OPTIONS_FOR_TASK_ONLY_1473", 1473);

    /**
     * The value %s for option %s is not a valid email address
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKTOOL_INVALID_EMAIL_ADDRESS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKTOOL_INVALID_EMAIL_ADDRESS_1474", 1474);

    /**
     * The failed dependency action value %s is invalid.  The value must be one of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKTOOL_INVALID_FDA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKTOOL_INVALID_FDA_1475", 1475);

    /**
     * The failed dependency action option is to be used in conjunction with one or more dependencies
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASKTOOL_FDA_WITH_NO_DEPENDENCY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_TASKTOOL_FDA_WITH_NO_DEPENDENCY_1476", 1476);

    /**
     * Error:  task %s is not in a cancelable state
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKINFO_TASK_NOT_CANCELABLE_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_TASK_NOT_CANCELABLE_TASK_1477", 1477);

    /**
     * The backup process was cancelled
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_BACKUPDB_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "NOTE_BACKUPDB_CANCELLED_1478", 1478);

    /**
     * Write rejected entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_REJECTED_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_REJECTED_FILE_1479", 1479);

    /**
     * Cannot write to rejected entries file %s.  Verify that you have enough write rights on the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_CANNOT_WRITE_REJECTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CANNOT_WRITE_REJECTED_1480", 1480);

    /**
     * Write rejected entries to file:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_REJECTED_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_REJECTED_FILE_1481", 1481);

    /**
     * Write skipped entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_SKIPPED_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_SKIPPED_FILE_1482", 1482);

    /**
     * Cannot write to skipped entries file %s.  Verify that you have enough write rights on the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_CANNOT_WRITE_SKIPPED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_CANNOT_WRITE_SKIPPED_1483", 1483);

    /**
     * Write skipped entries to file:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_SKIPPED_FILE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_SKIPPED_FILE_1484", 1484);

    /**
     * The maximum number of tries to provide the certificate key store PIN is %s.  Install canceled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_TOO_MANY_KEYSTORE_PASSWORD_TRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_TOO_MANY_KEYSTORE_PASSWORD_TRIES_1485", 1485);

    /**
     * This utility can be used to change the java arguments and java home that are used by the different server commands.%n%nBefore launching the command, edit the properties file located in %s to specify the java arguments and java home. When you have edited the properties file, run this command for the changes to be taken into account.%n%nNote that the changes will only apply to this server installation. No modifications will be made to your environment variables
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_JAVAPROPERTIES_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_JAVAPROPERTIES_TOOL_DESCRIPTION_1486", 1486);

    /**
     * The properties file to be used to generate the scripts.  If this attribute is not specified %s will be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_JAVAPROPERTIES_DESCRIPTION_PROPERTIES_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_JAVAPROPERTIES_DESCRIPTION_PROPERTIES_FILE_1488", 1488);

    /**
     * The script file that will be written.  If not specified %s will be written
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_JAVAPROPERTIES_DESCRIPTION_DESTINATION_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_JAVAPROPERTIES_DESCRIPTION_DESTINATION_FILE_1489", 1489);

    /**
     * The file properties "%s" cannot be read.  Check that it exists and that you have read rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JAVAPROPERTIES_WITH_PROPERTIES_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_JAVAPROPERTIES_WITH_PROPERTIES_FILE_1491", 1491);

    /**
     * The destination file "%s" cannot be written.  Check that you have write rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JAVAPROPERTIES_WITH_DESTINATION_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_JAVAPROPERTIES_WITH_DESTINATION_FILE_1492", 1492);

    /**
     * The destination file "%s" cannot be written.  Check that you have right reads to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JAVAPROPERTIES_WRITING_DESTINATION_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_JAVAPROPERTIES_WRITING_DESTINATION_FILE_1493", 1493);

    /**
     * The script file %s was successfully created.  For the command-lines to use the java properties specified on %s you must copy the created script file to %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_JAVAPROPERTIES_SUCCESSFUL_NON_DEFAULT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "INFO_JAVAPROPERTIES_SUCCESSFUL_NON_DEFAULT_1494", 1494);

    /**
     * The operation was successful.  The server commands will use the java arguments and java home specified in the properties file located in %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_JAVAPROPERTIES_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_JAVAPROPERTIES_SUCCESSFUL_1495", 1495);

    /**
     * Indicates that the command must be run in offline mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_RUN_OFFLINE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_RUN_OFFLINE_1496", 1496);

    /**
     * The backend ID '%s' has been specified several times
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDB_REPEATED_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_REPEATED_BACKEND_ID_1497", 1497);

    /**
     * ERROR:  The empty LDAP DN is not a valid value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTALLDS_EMPTY_DN_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_EMPTY_DN_RESPONSE_1498", 1498);

    /**
     * {file}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_FILE_PLACEHOLDER_1499", 1499);

    /**
     * {configFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGFILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CONFIGFILE_PLACEHOLDER_1501", 1501);

    /**
     * {ldifFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFFILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFFILE_PLACEHOLDER_1502", 1502);

    /**
     * {seed}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEED_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEED_PLACEHOLDER_1503", 1503);

    /**
     * {keyStorePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTOREPATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_KEYSTOREPATH_PLACEHOLDER_1504", 1504);

    /**
     * {trustStorePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTOREPATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TRUSTSTOREPATH_PLACEHOLDER_1505", 1505);

    /**
     * {bindPasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDPWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BINDPWD_FILE_PLACEHOLDER_1506", 1506);

    /**
     * {host}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HOST_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_HOST_PLACEHOLDER_1508", 1508);

    /**
     * {port}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PORT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PORT_PLACEHOLDER_1509", 1509);

    /**
     * {baseDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BASEDN_PLACEHOLDER_1510", 1510);

    /**
     * {rootUserDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_DN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ROOT_USER_DN_PLACEHOLDER_1511", 1511);

    /**
     * {bindDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BINDDN_PLACEHOLDER_1512", 1512);

    /**
     * {bindPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDPWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BINDPWD_PLACEHOLDER_1513", 1513);

    /**
     * {keyStorePassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_PLACEHOLDER_1514", 1514);

    /**
     * {path}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PATH_PLACEHOLDER_1515", 1515);

    /**
     * {path}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTORE_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TRUSTSTORE_PWD_FILE_PLACEHOLDER_1516", 1516);

    /**
     * {trustStorePassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTORE_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TRUSTSTORE_PWD_PLACEHOLDER_1517", 1517);

    /**
     * {nickname}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NICKNAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_NICKNAME_PLACEHOLDER_1518", 1518);

    /**
     * {filter}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ASSERTION_FILTER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ASSERTION_FILTER_PLACEHOLDER_1519", 1519);

    /**
     * {filter}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILTER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_FILTER_PLACEHOLDER_1520", 1520);

    /**
     * {authzID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROXYAUTHID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROXYAUTHID_PLACEHOLDER_1521", 1521);

    /**
     * {name=value}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SASL_OPTION_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SASL_OPTION_PLACEHOLDER_1522", 1522);

    /**
     * {version}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROTOCOL_VERSION_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROTOCOL_VERSION_PLACEHOLDER_1523", 1523);

    /**
     * {backendName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKENDNAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKENDNAME_PLACEHOLDER_1527", 1527);

    /**
     * {startTime}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_START_DATETIME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_START_DATETIME_PLACEHOLDER_1531", 1531);

    /**
     * {propertiesFilePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROP_FILE_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROP_FILE_PATH_PLACEHOLDER_1532", 1532);

    /**
     * {emailAddress}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_ADDRESS_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_EMAIL_ADDRESS_PLACEHOLDER_1533", 1533);

    /**
     * {taskID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_ID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASK_ID_PLACEHOLDER_1534", 1534);

    /**
     * {action}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ACTION_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ACTION_PLACEHOLDER_1535", 1535);

    /**
     * {backupID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPID_PLACEHOLDER_1541", 1541);

    /**
     * {backupDir}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUPDIR_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BACKUPDIR_PLACEHOLDER_1542", 1542);

    /**
     * {ldapPort}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPORT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPPORT_PLACEHOLDER_1543", 1543);

    /**
     * {jmxPort}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JMXPORT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_JMXPORT_PLACEHOLDER_1544", 1544);

    /**
     * {keyManagerProviderDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEY_MANAGER_PROVIDER_DN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_KEY_MANAGER_PROVIDER_DN_PLACEHOLDER_1545", 1545);

    /**
     * {trustManagerProviderDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUST_MANAGER_PROVIDER_DN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TRUST_MANAGER_PROVIDER_DN_PLACEHOLDER_1546", 1546);

    /**
     * {keyManagerPath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEY_MANAGER_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_KEY_MANAGER_PATH_PLACEHOLDER_1547", 1547);

    /**
     * {rootUserPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ROOT_USER_PWD_PLACEHOLDER_1548", 1548);

    /**
     * {serverRootDir}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_ROOT_DIR_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SERVER_ROOT_DIR_PLACEHOLDER_1549", 1549);

    /**
     * {serviceName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVICE_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SERVICE_NAME_PLACEHOLDER_1550", 1550);

    /**
     * {userName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_USER_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_USER_NAME_PLACEHOLDER_1551", 1551);

    /**
     * {args}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGS_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ARGS_PLACEHOLDER_1552", 1552);

    /**
     * {databaseName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATABASE_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DATABASE_NAME_PLACEHOLDER_1553", 1553);

    /**
     * {maxKeyValue}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAX_KEY_VALUE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MAX_KEY_VALUE_PLACEHOLDER_1554", 1554);

    /**
     * {minKeyValue}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MIN_KEY_VALUE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MIN_KEY_VALUE_PLACEHOLDER_1555", 1555);

    /**
     * {maxDataSize}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAX_DATA_SIZE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MAX_DATA_SIZE_PLACEHOLDER_1556", 1556);

    /**
     * {minDataSize}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MIN_DATA_SIZE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MIN_DATA_SIZE_PLACEHOLDER_1557", 1557);

    /**
     * {clearPW}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLEAR_PWD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CLEAR_PWD_1558", 1558);

    /**
     * {encodedPW}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCODED_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCODED_PWD_PLACEHOLDER_1559", 1559);

    /**
     * {scheme}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STORAGE_SCHEME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STORAGE_SCHEME_PLACEHOLDER_1560", 1560);

    /**
     * {branchDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BRANCH_DN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_BRANCH_DN_PLACEHOLDER_1561", 1561);

    /**
     * {attribute}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ATTRIBUTE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ATTRIBUTE_PLACEHOLDER_1562", 1562);

    /**
     * {wrapColumn}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WRAP_COLUMN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_WRAP_COLUMN_PLACEHOLDER_1563", 1563);

    /**
     * {templateFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TEMPLATE_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TEMPLATE_FILE_PLACEHOLDER_1564", 1564);

    /**
     * {rejectFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REJECT_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REJECT_FILE_PLACEHOLDER_1565", 1565);

    /**
     * {skipFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SKIP_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SKIP_FILE_PLACEHOLDER_1566", 1566);

    /**
     * {programName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRAM_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROGRAM_NAME_PLACEHOLDER_1567", 1567);

    /**
     * {numEntries}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUM_ENTRIES_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_NUM_ENTRIES_PLACEHOLDER_1568", 1568);

    /**
     * {rootUserPasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ROOT_USER_PWD_FILE_PLACEHOLDER_1569", 1569);

    /**
     * {controloid[:criticality[:value|::b64value|:<filePath]]}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONTROL_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAP_CONTROL_PLACEHOLDER_1570", 1570);

    /**
     * {encoding}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCODING_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCODING_PLACEHOLDER_1571", 1571);

    /**
     * {attrList}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ATTRIBUTE_LIST_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ATTRIBUTE_LIST_PLACEHOLDER_1572", 1572);

    /**
     * {newPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NEW_PASSWORD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_NEW_PASSWORD_PLACEHOLDER_1573", 1573);

    /**
     * {currentPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_PASSWORD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CURRENT_PASSWORD_PLACEHOLDER_1574", 1574);

    /**
     * {searchScope}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_SCOPE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SEARCH_SCOPE_PLACEHOLDER_1575", 1575);

    /**
     * {sortOrder}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORT_ORDER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SORT_ORDER_PLACEHOLDER_1576", 1576);

    /**
     * {before:after:index:count | before:after:value}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLV_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_VLV_PLACEHOLDER_1577", 1577);

    /**
     * {dereferencePolicy}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DEREFERENCE_POLICE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DEREFERENCE_POLICE_PLACEHOLDER_1578", 1578);

    /**
     * {sizeLimit}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SIZE_LIMIT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SIZE_LIMIT_PLACEHOLDER_1579", 1579);

    /**
     * {timeLimit}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TIME_LIMIT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TIME_LIMIT_PLACEHOLDER_1580", 1580);

    /**
     * {scope}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SCOPE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SCOPE_PLACEHOLDER_1581", 1581);

    /**
     * {filterFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILTER_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_FILTER_FILE_PLACEHOLDER_1582", 1582);

    /**
     * {outputFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OUTPUT_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_OUTPUT_FILE_PLACEHOLDER_1583", 1583);

    /**
     * {targetDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TARGETDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TARGETDN_PLACEHOLDER_1584", 1584);

    /**
     * {time}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TIME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TIME_PLACEHOLDER_1585", 1585);

    /**
     * {true|false}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUE_FALSE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TRUE_FALSE_PLACEHOLDER_1586", 1586);

    /**
     * {index}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INDEX_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INDEX_PLACEHOLDER_1587", 1587);

    /**
     * {stopReason}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOP_REASON_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOP_REASON_PLACEHOLDER_1588", 1588);

    /**
     * {stopTime}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOP_TIME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_STOP_TIME_PLACEHOLDER_1589", 1589);

    /**
     * {seconds}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SECONDS_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SECONDS_PLACEHOLDER_1590", 1590);

    /**
     * {data}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DATA_PLACEHOLDER_1591", 1591);

    /**
     * {address}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRESS_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ADDRESS_PLACEHOLDER_1592", 1592);

    /**
     * {subject}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBJECT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_SUBJECT_PLACEHOLDER_1593", 1593);

    /**
     * {keyStorePasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_FILE_PLACEHOLDER_1595", 1595);

    /**
     * ps[:changetype[:changesonly[:entrychgcontrols]]]
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PSEARCH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PSEARCH_PLACEHOLDER_1596", 1596);

    /**
     * true
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MULTICHOICE_TRUE_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MULTICHOICE_TRUE_VALUE_1597", 1597);

    /**
     * false
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MULTICHOICE_FALSE_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MULTICHOICE_FALSE_VALUE_1598", 1598);

    /**
     * JMX Listener Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_SERVER_JMXPORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_SERVER_JMXPORT_LABEL_1599", 1599);

    /**
     * Start Server when the configuration is completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_START_SERVER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_START_SERVER_1600", 1600);

    /**
     * Do not start Server when the configuration is completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DO_NOT_START_SERVER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DO_NOT_START_SERVER_1601", 1601);

    /**
     * Setup Summary%n=============
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_SUMMARY_1602", 1602);

    /**
     * What would you like to do?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CONFIRM_INSTALL_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CONFIRM_INSTALL_PROMPT_1603", 1603);

    /**
     * Set up the server with the parameters above
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CONFIRM_INSTALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CONFIRM_INSTALL_1604", 1604);

    /**
     * Provide the setup parameters again
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROVIDE_DATA_AGAIN =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROVIDE_DATA_AGAIN_1605", 1605);

    /**
     * Cancel and exit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CANCEL_1606", 1606);

    /**
     * An error occurred while attempting to update the crypto manager in the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_CRYPTO_MANAGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_CRYPTO_MANAGER_1607", 1607);

    /**
     * %s task %s has been successfully completed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TASK_TOOL_TASK_SUCESSFULL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_TASK_TOOL_TASK_SUCESSFULL_1608", 1608);

    /**
     * %s task %s did not complete successfully
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TASK_TOOL_TASK_NOT_SUCESSFULL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_TASK_TOOL_TASK_NOT_SUCESSFULL_1609", 1609);

    /**
     * Cannot access trust store '%s'.  Verify that the provided trust store exists and that you have read access rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_READ_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_READ_TRUSTSTORE_1610", 1610);

    /**
     * Cannot access key store '%s'.  Verify that the provided key store exists and that you have read access rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_READ_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_READ_KEYSTORE_1611", 1611);

    /**
     * File containing a list of attributes to ignore when computing the difference
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_IGNORE_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_IGNORE_ATTRS_1612", 1612);

    /**
     * File containing a list of entries (DN) to ignore when computing the difference
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_IGNORE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_IGNORE_ENTRIES_1613", 1613);

    /**
     * An error occurred while attempting to read the file '%s' containing the list of ignored entries: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_READ_FILE_IGNORE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_READ_FILE_IGNORE_ENTRIES_1614", 1614);

    /**
     * An error occurred while attempting to read the file '%s' containing the list of ignored attributes: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFDIFF_CANNOT_READ_FILE_IGNORE_ATTRIBS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFDIFF_CANNOT_READ_FILE_IGNORE_ATTRIBS_1615", 1615);

    /**
     * The string '%s' from file '%s' could not be parsed as a dn
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDIFDIFF_CANNOT_PARSE_STRING_AS_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_CANNOT_PARSE_STRING_AS_DN_1616", 1616);

    /**
     * The %s operation change number is %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CHANGE_NUMBER_CONTROL_RESULT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_CHANGE_NUMBER_CONTROL_RESULT_1617", 1617);

    /**
     * On which port would you like the Administration Connector to accept connections?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_ADMINCONNECTORPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_ADMINCONNECTORPORT_1618", 1618);

    /**
     * Port on which the Administration Connector should listen for communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_ADMINCONNECTORPORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_ADMINCONNECTORPORT_1619", 1619);

    /**
     * An error occurred while attempting to update the administration connector port:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_ADMIN_CONNECTOR_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_ADMIN_CONNECTOR_PORT_1620", 1620);

    /**
     * Error connecting to the directory server at %s on %s. Check this port is an administration port
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKINFO_LDAP_EXCEPTION_SSL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_TASKINFO_LDAP_EXCEPTION_SSL_1621", 1621);

    /**
     * Directory server administration port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ADMIN_PORT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ADMIN_PORT_1622", 1622);

    /**
     * Path of a JCEKS containing a certificate to be used as the server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_USE_JCEKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_USE_JCEKS_1623", 1623);

    /**
     * Use an existing certificate located on a JCEKS key store
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_CERT_OPTION_JCEKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_CERT_OPTION_JCEKS_1624", 1624);

    /**
     * JCEKS Key Store path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_JCEKS_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_JCEKS_PATH_1625", 1625);

    /**
     * Error creating JCEKS Key Provider configuration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_KEYMANAGER_CANNOT_CREATE_JCEKS_PROVIDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIG_KEYMANAGER_CANNOT_CREATE_JCEKS_PROVIDER_1626", 1626);

    /**
     * ERROR:  Cannot establish a connection to the Directory Server at %s on port %s. Check this port is an administration port
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STOPDS_CANNOT_CONNECT_SSL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_CANNOT_CONNECT_SSL_1628", 1628);

    /**
     * ERROR:  Cannot establish a connection to the Directory Server at %s on port %s. Check this port is an administration port
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_CANNOT_CONNECT_SSL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_CONNECT_SSL_1629", 1629);

    /**
     * The target backend %s cannot be backed up to the backup directory %s: this directory is already a backup location for backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPDB_CANNOT_BACKUP_IN_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKUPDB_CANNOT_BACKUP_IN_DIRECTORY_1650", 1650);

    /**
     * {schedulePattern}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RECURRING_TASK_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_RECURRING_TASK_PLACEHOLDER_1651", 1651);

    /**
     * An error occurred while attempting to initialize server components to run the tool: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_SERVER_COMPONENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_SERVER_COMPONENTS_1652", 1652);

    /**
     * The %s argument is not supported for online imports
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFIMPORT_COUNT_REJECTS_REQUIRES_OFFLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_COUNT_REJECTS_REQUIRES_OFFLINE_1653", 1653);

    /**
     * Indicates the task is recurring and will be scheduled according to the value argument expressed in crontab(5) compatible time/date pattern
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_RECURRING_TASK =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_RECURRING_TASK_1654", 1654);

    /**
     * Recurring %s task %s scheduled successfully
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TASK_TOOL_RECURRING_TASK_SCHEDULED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_TASK_TOOL_RECURRING_TASK_SCHEDULED_1655", 1655);

    /**
     * Exporting to %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIFEXPORT_PATH_TO_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LDIFEXPORT_PATH_TO_LDIF_FILE_1662", 1662);

    /**
     * yes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROMPT_YES_COMPLETE_ANSWER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROMPT_YES_COMPLETE_ANSWER_1663", 1663);

    /**
     * y
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROMPT_YES_FIRST_LETTER_ANSWER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROMPT_YES_FIRST_LETTER_ANSWER_1664", 1664);

    /**
     * no
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROMPT_NO_COMPLETE_ANSWER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROMPT_NO_COMPLETE_ANSWER_1665", 1665);

    /**
     * n
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROMPT_NO_FIRST_LETTER_ANSWER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PROMPT_NO_FIRST_LETTER_ANSWER_1666", 1666);

    /**
     * The specified start time '%s' has already passed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_START_DATETIME_ALREADY_PASSED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_START_DATETIME_ALREADY_PASSED_1667", 1667);

    /**
     * An error occurred reading file '%s'.  Check that the file exists and that you have read access rights to it.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPCOMPARE_ERROR_READING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDAPCOMPARE_ERROR_READING_FILE_1668", 1668);

    /**
     * The specified stop time '%s' has already passed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_STOPDS_DATETIME_ALREADY_PASSED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_STOPDS_DATETIME_ALREADY_PASSED_1669", 1669);

    /**
     * Both entry DNs and a file name were provided for the compare operation.  These arguments are not compatible
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPCOMPARE_FILENAME_AND_DNS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_LDAPCOMPARE_FILENAME_AND_DNS_1670", 1670);

    /**
     * r
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_REFRESH_CHAR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_REFRESH_CHAR_1671", 1671);

    /**
     * c
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_CANCEL_CHAR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_CANCEL_CHAR_1672", 1672);

    /**
     * l
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKINFO_CMD_VIEW_LOGS_CHAR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TASKINFO_CMD_VIEW_LOGS_CHAR_1673", 1673);

    /**
     * Takes into account the syntax of the attributes as defined in the schema to make the value comparison.  The provided LDIF files must be conform to the server schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_CHECK_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_CHECK_SCHEMA_1674", 1674);

    /**
     * WARNING:  no configuration file was provided as argument.  No schema check will be performed.  If this is being called through the '%s' command-line, verify that the script has not been modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDIFDIFF_NO_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "WARN_LDIFDIFF_NO_CONFIG_FILE_1675", 1675);

    /**
     * You must provide a non-empty password to continue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPAUTH_NON_EMPTY_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPAUTH_NON_EMPTY_PASSWORD_1676", 1676);

    /**
     * The timeout of '%d' seconds to start the server has been reached.  You can use the argument '--%s' to increase this timeout
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_TIMEOUT_DURING_STARTUP =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_TIMEOUT_DURING_STARTUP_1680", 1680);

    /**
     * Enable the server to run as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_ENABLE_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_ENABLE_WINDOWS_SERVICE_1681", 1681);

    /**
     * Do not enable the server to run as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DO_NOT_ENABLE_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DO_NOT_ENABLE_WINDOWS_SERVICE_1682", 1682);

    /**
     * Path to temporary directory for index scratch files during LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_TEMP_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_TEMP_DIRECTORY_1683", 1683);

    /**
     * {directory}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_TEMP_DIR_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_TEMP_DIR_PLACEHOLDER_1684", 1684);

    /**
     * Number of threads used to read LDIF file during import. Default value (0) equals: 2 x (number of CPUs)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_DESCRIPTION_THREAD_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_DESCRIPTION_THREAD_COUNT_1686", 1686);

    /**
     * {count}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFIMPORT_THREAD_COUNT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFIMPORT_THREAD_COUNT_PLACEHOLDER_1687", 1687);

    /**
     * The value %s for threadCount cannot be parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIFIMPORT_CANNOT_PARSE_THREAD_COUNT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_CANNOT_PARSE_THREAD_COUNT_1688", 1688);

    /**
     * # Public changelog exchange control(%s): %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAPSEARCH_PUBLIC_CHANGELOG_COOKIE_EXC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_LDAPSEARCH_PUBLIC_CHANGELOG_COOKIE_EXC_1689", 1689);

    /**
     * The password to encode or to compare against an encoded password is interactively asked to the user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_DESCRIPTION_INPUT_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_DESCRIPTION_INPUT_PW_1690", 1690);

    /**
     * Please enter the password :
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_INPUT_PWD_1 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_INPUT_PWD_1_1691", 1691);

    /**
     * Please renter the password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENCPW_INPUT_PWD_2 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ENCPW_INPUT_PWD_2_1692", 1692);

    /**
     * Provided passwords don't matched
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENCPW_NOT_SAME_PW =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_ENCPW_NOT_SAME_PW_1693", 1693);

    /**
     * Cannot read password from the input: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENCPW_CANNOT_READ_PW =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_ENCPW_CANNOT_READ_PW_1694", 1694);

    /**
     * Rebuild all indexes, including any DN2ID, DN2URI, VLV and extensible indexes. Cannot be used with the "-i" option or the "--rebuildDegraded" option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_REBUILD_ALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_REBUILD_ALL_1695", 1695);

    /**
     * {directory}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_TEMP_DIR_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_TEMP_DIR_PLACEHOLDER_1697", 1697);

    /**
     * Path to temporary directory for index scratch files during index rebuilding
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_TEMP_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_TEMP_DIRECTORY_1698", 1698);

    /**
     * Index "-i" option cannot be specified with the "--rebuildAll" option
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REBUILDINDEX_REBUILD_ALL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_REBUILD_ALL_ERROR_1699", 1699);

    /**
     * Do you want to create base DNs in the server?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROVIDE_BASE_DN_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROVIDE_BASE_DN_PROMPT_1700", 1700);

    /**
     * You have specified not to create a base DN.  If no base DN is to be created you cannot specify argument '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INSTALLDS_NO_BASE_DN_AND_CONFLICTING_ARG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_NO_BASE_DN_AND_CONFLICTING_ARG_1701", 1701);

    /**
     * Use subentries control to specify that subentries are visible and normal entries are not
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBENTRIES_1702", 1702);

    /**
     * The fully-qualified directory server host name that will be used when generating self-signed certificates for LDAP SSL/StartTLS, the administration connector, and replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_HOST_NAME_1703", 1703);

    /**
     * Provide the fully-qualified directory server host name that will be used when generating self-signed certificates for LDAP SSL/StartTLS, the administration connector, and replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_HOST_NAME_1704", 1704);

    /**
     * {period}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PERIOD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_PERIOD_PLACEHOLDER_1705", 1705);

    /**
     * When this argument is specified, the status command will display its contents periodically.  Used to specify the period (in seconds) between two displays of the status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REFRESH_PERIOD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REFRESH_PERIOD_1706", 1706);

    /**
     * Print equivalent non-interactive command-line
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PRINT_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PRINT_EQUIVALENT_COMMAND_LINE_1708", 1708);

    /**
     * The Windows Service was successfully configured but there was an error starting it.  Error code starting Windows Service: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_WINDOWS_SERVICE_ENABLING_ERROR_STARTING_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_WINDOWS_SERVICE_ENABLING_ERROR_STARTING_SERVER_1709", 1709);

    /**
     * Do not display backend data, just statistics
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_STATS_ONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_STATS_ONLY_1710", 1710);

    /**
     * {timeout}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TIMEOUT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_TIMEOUT_PLACEHOLDER_1711", 1711);

    /**
     * Maximum length of time (in milliseconds) that can be taken to establish a connection.  Use '0' to specify no time out
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONNECTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_CONNECTION_TIMEOUT_1712", 1712);

    /**
     * A client side timeout occurred.%nAdditional Information:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CLIENT_SIDE_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CLIENT_SIDE_TIMEOUT_1714", 1714);

    /**
     * {maximum duration}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAXIMUM_DURATION_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_MAXIMUM_DURATION_PLACEHOLDER_1716", 1716);

    /**
     * This argument specifies the maximum duration the purge processing must last expressed in seconds
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PURGE_HISTORICAL_MAXIMUM_DURATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_PURGE_HISTORICAL_MAXIMUM_DURATION_1717", 1717);

    /**
     * The provided schedule value has an invalid format.  The schedule must be expressed using a crontab(5) format.  Error details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRING_SCHEDULE_FORMAT_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_RECURRING_SCHEDULE_FORMAT_ERROR_1718", 1718);

    /**
     * Rebuild all degraded indexes, including any DN2ID, DN2URI, VLV and extensible indexes. Cannot be used with the "-i" option or the "--rebuildAll" option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_REBUILD_DEGRADED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_REBUILD_DEGRADED_1720", 1720);

    /**
     * Option "--rebuildDegraded" cannot be specified with the "--%s" option
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REBUILDINDEX_REBUILD_DEGRADED_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_REBUILD_DEGRADED_ERROR_1721", 1721);

    /**
     * Option "--rebuildAll" cannot be specified with the "--%s" option
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REBUILDINDEX_REBUILD_ALL_DEGRADED_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_REBUILDINDEX_REBUILD_ALL_DEGRADED_ERROR_1722", 1722);

    /**
     * An error occurred while attempting to update the FQDN for the DIGEST-MD5 SASL mechanism:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIGDS_CANNOT_UPDATE_DIGEST_MD5_FQDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_CANNOT_UPDATE_DIGEST_MD5_FQDN_1733", 1733);

    /**
     * Indicates that indexes do not need rebuilding because they are known to be empty and forcefully marks them as valid. This is an advanced option which must only be used in cases where a degraded index is known to be empty and does not therefore need rebuilding. This situation typically arises when an index is created for an attribute which has just been added to the schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REBUILDINDEX_DESCRIPTION_CLEAR_DEGRADED_STATE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_REBUILDINDEX_DESCRIPTION_CLEAR_DEGRADED_STATE_1734", 1734);

    /**
     * Use the LDAP compare result as an exit code for reporting differences between the two LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_USE_COMPARE_RESULT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_USE_COMPARE_RESULT_1735", 1735);

    /**
     * Use the LDAP compare result as an exit code for the LDAP compare operations
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPCOMPARE_DESCRIPTION_USE_COMPARE_RESULT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LDAPCOMPARE_DESCRIPTION_USE_COMPARE_RESULT_1736", 1736);

    /**
     * The version of the installed OpenDJ could not be determined because the version file '%s' could not be found. Restore it from backup before continuing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BUILDVERSION_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BUILDVERSION_NOT_FOUND_1737", 1737);

    /**
     * The version of the installed OpenDJ could not be determined because the version file '%s' exists but contains invalid data. Restore it from backup before continuing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BUILDVERSION_MALFORMED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BUILDVERSION_MALFORMED_1738", 1738);

    /**
     * The OpenDJ binary version '%s' does not match the installed version '%s'. Please run upgrade before continuing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BUILDVERSION_MISMATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BUILDVERSION_MISMATCH_1739", 1739);

    /**
     * Ignores any errors which occur during the upgrade. This option should be used with caution and may be useful in automated deployments where potential errors are known in advance and resolved after the upgrade has completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_OPTION_IGNORE_ERRORS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_OPTION_IGNORE_ERRORS_1740", 1740);

    /**
     * Forces a non-interactive upgrade to continue even if it requires user interaction. In particular, long running or critical upgrade tasks, such as re-indexing, which require user confirmation will be skipped. This option may only be used with the '%s' option
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_OPTION_FORCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_OPTION_FORCE_1741", 1741);

    /**
     * Upgrades OpenDJ configuration and application data so that it is compatible with the installed binaries.%n%nThis tool should be run immediately after upgrading the OpenDJ binaries and before restarting the server.%n%nNOTE: this tool does not provide backup or restore capabilities. Therefore, it is the responsibility of the OpenDJ administrator to take necessary precautions before performing the upgrade
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_DESCRIPTION_CLI =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_DESCRIPTION_CLI_1743", 1743);

    /**
     * The upgrade failed to complete for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_MAIN_UPGRADE_PROCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_MAIN_UPGRADE_PROCESS_1800", 1800);

    /**
     * OpenDJ was successfully upgraded from version %s to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_SUCCESSFUL_1801", 1801);

    /**
     * Performing upgrade
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_PERFORMING_TASKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_PERFORMING_TASKS_1802", 1802);

    /**
     * OpenDJ Upgrade Utility
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TITLE_1803", 1803);

    /**
     * OpenDJ will be upgraded from version %s to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_SUMMARY_1804", 1804);

    /**
     * OpenDJ cannot be upgraded because the server is currently running. Please stop the server and try again
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UPGRADE_REQUIRES_SERVER_OFFLINE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_UPGRADE_REQUIRES_SERVER_OFFLINE_1805", 1805);

    /**
     * OpenDJ has already been upgraded to version %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_VERSION_UP_TO_DATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_VERSION_UP_TO_DATE_1806", 1806);

    /**
     * An unexpected error occurred while attempting to display a notification: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_DISPLAY_NOTIFICATION_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_DISPLAY_NOTIFICATION_ERROR_1807", 1807);

    /**
     * An unexpected error occurred while attempting to display a confirmation : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_DISPLAY_CONFIRM_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_DISPLAY_CONFIRM_ERROR_1808", 1808);

    /**
     * ...Change(s) done in %s (x%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_CHANGE_DONE_IN_SPECIFIC_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_CHANGE_DONE_IN_SPECIFIC_FILE_1810", 1810);

    /**
     * ...No change applied in %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_NO_CHANGE_DONE_IN_SPECIFIC_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_NO_CHANGE_DONE_IN_SPECIFIC_FILE_1811", 1811);

    /**
     * 
An error occurred while performing an upgrade task: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_TASKS_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_TASKS_FAIL_1812", 1812);

    /**
     * %s.%nDo you want to make this configuration change?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_NEEDS_USER_CONFIRM =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_NEEDS_USER_CONFIRM_1813", 1813);

    /**
     * The upgrade is ready to proceed. Do you wish to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_DISPLAY_CONFIRM_START =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_DISPLAY_CONFIRM_START_1814", 1814);

    /**
     * The upgrade has been canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_ABORTED_BY_USER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_ABORTED_BY_USER_1815", 1815);

    /**
     * No %s with OID %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_UNKNOWN_OC_ATT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_UNKNOWN_OC_ATT_1816", 1816);

    /**
     * An error occurred when trying to upgrade the config/upgrade folder: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_CONFIG_ERROR_UPGRADE_FOLDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_CONFIG_ERROR_UPGRADE_FOLDER_1817", 1817);

    /**
     * Preparing to upgrade
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_REQUIREMENTS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REQUIREMENTS_1818", 1818);

    /**
     * This tool cannot be used for upgrading versions of OpenDJ which are older than '%s'. Please upgrade to '%s' first before attempting further upgrades
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_VERSION_IS_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_VERSION_IS_NOT_SUPPORTED_1819", 1819);

    /**
     * Invalid response
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_CLI_ACCEPT_INVALID_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LICENSE_CLI_ACCEPT_INVALID_RESPONSE_1820", 1820);

    /**
     * Please read the License Agreement above.%nYou must accept the terms of the agreement before continuing with the installation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_DETAILS_CLI_LABEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LICENSE_DETAILS_CLI_LABEL_1821", 1821);

    /**
     * Do you accept the License Agreement?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LICENSE_ACCEPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LICENSE_ACCEPT_1822", 1822);

    /**
     * An error occurred while copying the file '%s' to '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_COPYING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_ERROR_COPYING_FILE_1823", 1823);

    /**
     * An error occurred while deleting directory '%s'. Check that you have the rights to delete this directory and that there is no other application using it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_DELETING_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_ERROR_DELETING_DIRECTORY_1824", 1824);

    /**
     * An error occurred while deleting file '%s'. Check that you have the rights to delete this file and that there is no other application using it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ERROR_DELETING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_ERROR_DELETING_FILE_1825", 1825);

    /**
     * An error occurred while renaming file '%s' to '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_RENAMING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_ERROR_RENAMING_FILE_1826", 1826);

    /**
     * The upgrade failed because %d errors were encountered. Please check log for further details
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_UPGRADE_FAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_FAILS_1827", 1827);

    /**
     * An error occurred while copying the schema file '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_COPYSCHEMA_FAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_COPYSCHEMA_FAILS_1828", 1828);

    /**
     * An error occurred while adding one or more attributes to the schema file '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_ADDATTRIBUTE_FAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_ADDATTRIBUTE_FAILS_1829", 1829);

    /**
     * An error occurred while adding one or more object classes to the schema file '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_ADDOBJECTCLASS_FAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_ADDOBJECTCLASS_FAILS_1830", 1830);

    /**
     * See '%s' for a detailed log of this operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_GENERAL_SEE_FOR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_GENERAL_SEE_FOR_DETAILS_1831", 1831);

    /**
     * Replacing schema file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_REPLACE_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REPLACE_SCHEMA_FILE_1832", 1832);

    /**
     * Archiving concatenated schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_REFRESH_UPGRADE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REFRESH_UPGRADE_DIRECTORY_1833", 1833);

    /**
     * Adding '%s' configuration file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_ADD_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_ADD_CONFIG_FILE_1834", 1834);

    /**
     * An error occurred while adding configuration file '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPGRADE_ADD_CONFIG_FILE_FAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_ADD_CONFIG_FILE_FAILS_1835", 1835);

    /**
     * An error occurred when trying to rename the SNMP security config file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_RENAME_SNMP_SECURITY_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_RENAME_SNMP_SECURITY_CONFIG_FILE_1838", 1838);

    /**
     * Rebuilding index(es) '%s' for base dn(s) '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_REBUILD_INDEX_STARTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_INDEX_STARTS_1839", 1839);

    /**
     * Rebuild index task ends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_REBUILD_INDEX_ENDS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_INDEX_ENDS_1840", 1840);

    /**
     * Performing post upgrade tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_PERFORMING_POST_TASKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_PERFORMING_POST_TASKS_1841", 1841);

    /**
     * Post upgrade tasks complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_POST_TASKS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_POST_TASKS_COMPLETE_1842", 1842);

    /**
     * An error occurred during post upgrade task. Process aborted. Please check log for further details
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UPGRADE_PERFORMING_POST_TASKS_FAIL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_UPGRADE_PERFORMING_POST_TASKS_FAIL_1843", 1843);

    /**
     * You have to rebuild the '%s' index(es) manually to get a fully functional server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_REBUILD_INDEXES_DECLINED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_INDEXES_DECLINED_1844", 1844);

    /**
     * You have to rebuild all indexes manually to get a fully functional server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_ALL_REBUILD_INDEX_DECLINED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_ALL_REBUILD_INDEX_DECLINED_1845", 1845);

    /**
     * Invalid log file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_INVALID_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_INVALID_LOG_FILE_1846", 1846);

    /**
     * The rebuild index tool arguments are %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_REBUILD_INDEX_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_INDEX_ARGUMENTS_1847", 1847);

    /**
     * Rebuilding all indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_REBUILD_ALL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_ALL_1848", 1848);

    /**
     * End of the upgrade process
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_PROCESS_END =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_PROCESS_END_1849", 1849);

    /**
     * '%s' is missing or empty, it is probably corrupted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UPGRADE_CORRUPTED_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_UPGRADE_CORRUPTED_TEMPLATE_1850", 1850);

    /**
     * The classes folder has been renamed to '%s' to avoid compatibility issues
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_CLASSES_FOLDER_RENAMED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_CLASSES_FOLDER_RENAMED_1852", 1852);

    /**
     * The dsjavaproperties tool failed to run. Please rerun dsjavaproperties manually
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UPGRADE_DSJAVAPROPERTIES_FAILED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_UPGRADE_DSJAVAPROPERTIES_FAILED_1853", 1853);

    /**
     * List the pluggable backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_BACKENDS_1854", 1854);

    /**
     * List the low-level databases within a pluggable backend's storage engine. This subcommand may take a long time to complete depending on the size of the backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_RAW_DBS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_RAW_DBS_1855", 1855);

    /**
     * Dump records from an index, decoding keys and values. Depending on index size, this subcommand can generate lots of output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_DUMP_INDEX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_DUMP_INDEX_1857", 1857);

    /**
     * Dump the raw records in hexadecimal format for a low-level database within the pluggable backend's storage engine. Depending on index size, this subcommand can generate lots of output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_DUMP_RAW_DB =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_DUMP_RAW_DB_1858", 1858);

    /**
     * Raw DB Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_RAW_DB_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_RAW_DB_NAME_1861", 1861);

    /**
     * An error occurred while listing the base DNs: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_TOOL_ERROR_LISTING_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ERROR_LISTING_BASE_DNS_1863", 1863);

    /**
     * An error occurred while listing indexes: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_TOOL_ERROR_LISTING_TREES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ERROR_LISTING_TREES_1864", 1864);

    /**
     * An unexpected error occurred while attempting to initialize the backend '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_TOOL_ERROR_INITIALIZING_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ERROR_INITIALIZING_BACKEND_1865", 1865);

    /**
     * An unexpected error occurred while attempting to read and/or decode records from an index: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_TOOL_ERROR_READING_TREE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ERROR_READING_TREE_1866", 1866);

    /**
     * List the indexes associated with a pluggable backend. This subcommand may take a long time to complete depending on the size of the backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_INDEXES_1866", 1866);

    /**
     * Over Entry Limit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_INDEX_UNDEFINED_RECORD_COUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_INDEX_UNDEFINED_RECORD_COUNT_1867", 1867);

    /**
     * No index exists with the requested name '%s' in base DN '%s' and backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKEND_TOOL_NO_TREE_FOR_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_NO_TREE_FOR_NAME_1868", 1868);

    /**
     * Cannot specify a minimum key both as a string and as an hexadecimal string
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BACKEND_TOOL_ONLY_ONE_MIN_KEY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ONLY_ONE_MIN_KEY_1869", 1869);

    /**
     * Cannot specify a maximum key both as a string and as an hexadecimal string
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BACKEND_TOOL_ONLY_ONE_MAX_KEY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_ONLY_ONE_MAX_KEY_1870", 1870);

    /**
     * An error occurred while processing arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_TOOL_PROCESSING_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_PROCESSING_ARGUMENT_1871", 1871);

    /**
     * An error occurred while trying to execute %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_TOOL_EXECUTING_COMMAND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_EXECUTING_COMMAND_1872", 1872);

    /**
     * Total Keys
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_TOTAL_KEYS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_KEYS_1873", 1873);

    /**
     * Keys Size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_KEYS_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_KEYS_SIZE_1874", 1874);

    /**
     * Values Size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_VALUES_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_VALUES_SIZE_1875", 1875);

    /**
     * Total Size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_TOTAL_SIZES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_SIZES_1876", 1876);

    /**
     * Uses SI Units for printing sizes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_USE_SI_UNITS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_USE_SI_UNITS_1877", 1877);

    /**
     * Write hexadecimal data on a single line instead of pretty format
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_SINGLE_LINE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_SUBCMD_SINGLE_LINE_1878", 1878);

    /**
     * Storage
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LABEL_BACKEND_TOOL_STORAGE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_STORAGE_1879", 1879);

    /**
     * %nTotal: %d%n
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LABEL_BACKEND_TOOL_TOTAL =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_1880", 1880);

    /**
     * Cannot configure backend %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_TOOL_CANNOT_CONFIGURE_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_CANNOT_CONFIGURE_BACKEND_1881", 1881);

    /**
     * %nIndex: %s%n
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LABEL_BACKEND_TOOL_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_INDEX_1882", 1882);

    /**
     * Over index-entry-limit keys: %s%n
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LABEL_BACKEND_TOOL_OVER_INDEX_LIMIT_KEYS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_OVER_INDEX_LIMIT_KEYS_1883", 1883);

    /**
     * %nTotal Records: %d%n
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LABEL_BACKEND_TOOL_TOTAL_RECORDS =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_RECORDS_1884", 1884);

    /**
     * Total / Average Key Size: %d bytes / %d bytes%n
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_LABEL_BACKEND_TOOL_TOTAL_KEY_SIZE_AND_AVG =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_KEY_SIZE_AND_AVG_1885", 1885);

    /**
     * Total / Average Data Size: %d bytes / %d bytes%n
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_LABEL_BACKEND_TOOL_TOTAL_DATA_SIZE_AND_AVG =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_TOTAL_DATA_SIZE_AND_AVG_1886", 1886);

    /**
     * At key number %d, %s:
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_BACKEND_TOOL_CURSOR_AT_KEY_NUMBER =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_CURSOR_AT_KEY_NUMBER_1887", 1887);

    /**
     * Key (len %d):
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LABEL_BACKEND_TOOL_KEY_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_KEY_FORMAT_1888", 1888);

    /**
     * Value (len %d):
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LABEL_BACKEND_TOOL_VALUE_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolMessages.class, RESOURCE, "INFO_LABEL_BACKEND_TOOL_VALUE_FORMAT_1889", 1889);

    /**
     * Data decoder for printing is not available, should use hex dump
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BACKEND_TOOL_DECODER_NOT_AVAILABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_DECODER_NOT_AVAILABLE_1890", 1890);

    /**
     * No storage index exists with the requested name %s in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_TOOL_NO_TREE_FOR_NAME_IN_STORAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_BACKEND_TOOL_NO_TREE_FOR_NAME_IN_STORAGE_1891", 1891);

    /**
     * This utility can be used to debug a backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_TOOL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_TOOL_1893", 1893);

    /**
     * {indexName}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INDEX_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INDEX_NAME_PLACEHOLDER_1894", 1894);

    /**
     * The raw database name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BACKEND_DEBUG_RAW_DB_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_BACKEND_DEBUG_RAW_DB_NAME_1895", 1895);

    /**
     * {change number}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CHANGE_NUMBER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_CHANGE_NUMBER_PLACEHOLDER_1896", 1896);

    /**
     * An error occurred while initializing server backends: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_BACKENDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_BACKENDS_1897", 1897);

    /**
     * An error occurred while initializing plugins: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_SERVER_PLUGINS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_SERVER_PLUGINS_1898", 1898);

    /**
     * Subsystem %s should be initialized first
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_SUBSYSTEM_NOT_INITIALIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_CANNOT_SUBSYSTEM_NOT_INITIALIZED_1899", 1899);

    /**
     * Backend Type: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INSTALLDS_BACKEND_TYPE_USED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_BACKEND_TYPE_USED_1900", 1900);

    /**
     * StartTLS failed: the connection has been closed without receiving a response. This may indicate you tried to connect to an LDAPS port instead of the LDAP port, or that the network is down
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_STARTTLS_FAILED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_STARTTLS_FAILED_1901", 1901);

    /**
     * Fixing de-DE collation matching rule OID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_6869_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_6869_SUMMARY_10000", 10000);

    /**
     * Updating password policy configurations
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7192_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7192_SUMMARY_10001", 10001);

    /**
     * Updating audit log publisher configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7364_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7364_SUMMARY_10002", 10002);

    /**
     * Adding 'etag' virtual attribute schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7748_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7748_1_SUMMARY_10003", 10003);

    /**
     * Configuring 'etag' virtual attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7748_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7748_2_SUMMARY_10004", 10004);

    /**
     * Configuring 'ds-pwp-password-expiration-time' virtual attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7834_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7834_SUMMARY_10005", 10005);

    /**
     * Updating certificate syntax configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7979_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7979_SUMMARY_10006", 10006);

    /**
     * Updating JPEG syntax configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8124_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8124_SUMMARY_10007", 10007);

    /**
     * Updating country string syntax configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8133_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8133_SUMMARY_10008", 10008);

    /**
     * Modifying filter in 'isMemberOf' virtual attribute configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8214_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8214_SUMMARY_10009", 10009);

    /**
     * OpenDJ 2.5.0 modified the default configuration of the 'isMemberOf' virtual attribute so that it is included with group entries. This was done in order to make it easier for users to determine which groups a 'nested' group belongs to
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8214_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8214_DESCRIPTION_10010", 10010);

    /**
     * Updating dictionary password validator configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8387_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8387_SUMMARY_10011", 10011);

    /**
     * Updating attribute value password validator configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8389_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8389_SUMMARY_10012", 10012);

    /**
     * Adding PBKDF2 password storage scheme configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8487_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8487_SUMMARY_10013", 10013);

    /**
     * Adding HTTP connection handler configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8613_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8613_SUMMARY_10014", 10014);

    /**
     * Adding file-based HTTP access logger
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8832_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8832_SUMMARY_10015", 10015);

    /**
     * Rename SNMP security config file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_7466_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_7466_SUMMARY_10016", 10016);

    /**
     * Adding 'emailAddress' attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8985_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8985_1_SUMMARY_10017", 10017);

    /**
     * Updating subject attribute to user attribute configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_8985_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_8985_2_SUMMARY_10018", 10018);

    /**
     * OpenDJ 2.5.0-Xpress1 introduced a regression in the ds-sync-hist ordering index. This index has to be rebuilt and this could take a long time to proceed. Do you want to launch this process automatically at the end of the upgrade?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_9013_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_9013_DESCRIPTION_10019", 10019);

    /**
     * ERROR:  The server rejected the task for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_TOOL_LDAP_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_TASK_TOOL_LDAP_ERROR_10020", 10020);

    /**
     * Changing matching rule for 'userCertificate' and 'caCertificate' to CertificateExactMatch
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10133_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10133_1_SUMMARY_10021", 10021);

    /**
     * Configuring 'CertificateExactMatch' matching rule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10133_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10133_2_SUMMARY_10022", 10022);

    /**
     * Updating ds-cfg-java-class attribute in File-Based Debug Logger
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10214_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10214_SUMMARY_10023", 10023);

    /**
     * Deleting ds-cfg-default-debug-level attribute in File-Based Debug Logger
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10232_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10232_SUMMARY_10024", 10024);

    /**
     * Updating ds-cfg-default-severity attribute in File-Based Error Logger
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10329_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10329_SUMMARY_10025", 10025);

    /**
     * Updating ds-cfg-override-severity attribute in Replication Repair Logger
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10339_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10339_SUMMARY_10026", 10026);

    /**
     * Removing 'dc=replicationchanges' backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10733_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10733_1_SUMMARY_10027", 10027);

    /**
     * Removing ACI for 'dc=replicationchanges'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10733_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10733_2_SUMMARY_10028", 10028);

    /**
     * Adding default privilege 'changelog-read' to all root DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10820_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10820_SUMMARY_10029", 10029);

    /**
     * Adding PKCS5S2 password storage scheme configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_10908_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_10908_SUMMARY_10030", 10030);

    /**
     * Removing config for 'Network Groups'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11237_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11237_1_SUMMARY_10031", 10031);

    /**
     * Removing config for 'Workflows'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11237_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11237_2_SUMMARY_10032", 10032);

    /**
     * Removing config for 'Workflow Elements'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11237_3_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11237_3_SUMMARY_10033", 10033);

    /**
     * Removing config for 'Network Group Plugin'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11239_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11239_SUMMARY_10034", 10034);

    /**
     * OpenDJ 3.0.0 changed the matching rule implementations. All indexes have to be rebuilt. This could take a long time to proceed. Do you want to launch this process automatically at the end of the upgrade?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11260_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11260_SUMMARY_10035", 10035);

    /**
     * Removing config for 'Extensions'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11339_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11339_SUMMARY_10036", 10036);

    /**
     * Removing config for 'File System Entry Cache'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_11476_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_11476_SUMMARY_10037", 10037);

    /**
     * Removing config for 'Entry Cache Preload'
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_12226_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_12226_SUMMARY_10038", 10038);

    /**
     * Rerunning dsjavaproperties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_9206_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_9206_SUMMARY_10039", 10039);

    /**
     * The upgrade will not be performed because the current instance contains one or more JE based backends which cannot be migrated because the JE library is not present in the class-path. The upgrade should be restarted once the JE backends have been exported and disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_NO_JE_LIB =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_NO_JE_LIB_10040", 10040);

    /**
     * The upgrade will not be performed because the JE backend '%s' contains a base DN '%s' that cannot be migrated. The upgrade should be restarted once the JE backend has been exported and disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_TASK_MIGRATE_JE_UGLY_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_UGLY_DN_10041", 10041);

    /**
     * The upgrade will not be performed because the configuration file config.ldif could not be parsed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_CONFIG_READ_FAIL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_CONFIG_READ_FAIL_10042", 10042);

    /**
     * The upgrade cannot continue because the JE backend with environment directory '%s' could not be accessed for migration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_MIGRATE_JE_ENV_UNREADABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_ENV_UNREADABLE_10043", 10043);

    /**
     * Migrating JE backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_1_10044", 10044);

    /**
     * Convert local DB backends to JE backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_2 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_2_10045", 10045);

    /**
     * Convert local DB indexes to backend indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_3 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_3_10046", 10046);

    /**
     * Convert local DB VLV indexes to backend VLV indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_4 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_4_10047", 10047);

    /**
     * Skipping migration of disabled JE backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_5 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_SUMMARY_5_10048", 10048);

    /**
     * OpenDJ 3.0.0 introduced changes to the JE backend configuration and database format. The upgrade will update all JE backend configurations, but will only migrate JE backend databases which are associated with *enabled* JE backends. It is very strongly recommended that any existing data has been backed up and that you have read the upgrade documentation before proceeding. Do you want to proceed with the upgrade?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_DESCRIPTION_10049", 10049);

    /**
     * The upgrade will not be performed because some JE backends need to be migrated.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_JE_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_JE_CANCELLED_10050", 10050);

    /**
     * OpenDJ 3.0.0 improved the replication changelog storage format. As a consequence, the old changelog content of the current replication server will be erased by the upgrade. The new changelog content will be automatically reconstructed from the changelog of other replication servers in the topology. After the upgrade, dsreplication reset-change-number can be used to reset the changelog change-number of the current replication server to match another replication server. Do you want to proceed with the upgrade?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_MIGRATE_CHANGELOG_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_MIGRATE_CHANGELOG_DESCRIPTION_10051", 10051);

    /**
     * Removing content of changelog in '%s' directory.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_DELETE_CHANGELOG_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_DELETE_CHANGELOG_SUMMARY_10052", 10052);

    /**
     * Removing file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_DELETE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_DELETE_FILE_10054", 10054);

    /**
     * Unable to access the LDIF file %s to import. Please check that the file is local to the server and the path correct.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFIMPORT_LDIF_FILE_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_LDIFIMPORT_LDIF_FILE_DOESNT_EXIST_10055", 10055);

    /**
     * Adding Bcrypt password storage scheme configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_BCRYPT_SCHEME_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_BCRYPT_SCHEME_SUMMARY_10056", 10056);

    /**
     * Removing configuration entry for the configuration backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_CONFIGURATION_BACKEND_NOT_CONFIGURABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_CONFIGURATION_BACKEND_NOT_CONFIGURABLE_10057", 10057);

    /**
     * WARNING: OpenDJ %s OEM Edition removes support for the Berkeley JE backend.

The upgrade tool will reconfigure all JE backends as PDB backends.

After the upgrade the new PDB backend(s) will be empty. It is therefore very strongly recommended that any data that was in the JE backends be exported to LDIF so that it can be re-imported once the upgrade completes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_1_SUMMARY_10058", 10058);

    /**
     * Reconfiguring local-db backends to PDB backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_2_SUMMARY_10059", 10059);

    /**
     * Reconfiguring local-db backend indexes to PDB backend indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_3_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_3_SUMMARY_10060", 10060);

    /**
     * Reconfiguring local-db backend VLV indexes to PDB backend VLV indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_4_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_LOCAL_DB_TO_PDB_4_SUMMARY_10061", 10061);

    /**
     * Renaming local-db backend directory '%s' to '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_TASK_RENAME_JE_DB_DIR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_RENAME_JE_DB_DIR_10062", 10062);

    /**
     * You must reimport all your data into the PDB backends in order to have a fully functional server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_RENAME_JE_DB_DIR_WARNING =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_RENAME_JE_DB_DIR_WARNING_10063", 10063);

    /**
     * Removing configuration for matching rules
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_REMOVE_MATCHING_RULES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REMOVE_MATCHING_RULES_10064", 10064);

    /**
     * Adding 'includedAttributes' attribute type to changelog schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_2716_1_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_2716_1_SUMMARY_10065", 10065);

    /**
     * Updating 'changeLogEntry' object class in changelog schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_2716_2_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_2716_2_SUMMARY_10066", 10066);

    /**
     * Removing old OpenDJ library files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_REMOVE_OLD_JARS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REMOVE_OLD_JARS_10067", 10067);

    /**
     * OpenDJ 3.5.0 introduced a new format for all equality indexes based on "distinguishedName" attribute type, like "member", "owner", "roleOccupant" and "seeAlso". They all have to be rebuilt if they exist on your server and this could take a long time to proceed. Do you want to launch this process automatically at the end of the upgrade?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_REBUILD_INDEXES_DISTINGUISHED_NAME =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_REBUILD_INDEXES_DISTINGUISHED_NAME_10068", 10068);

    /**
     * Unable to determine whether the file system is case sensitive. If the file system is case sensitive, then remove OpenDJ.jar and all OpenDJ_*.jar before starting the upgraded server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_UNABLE_TO_REMOVE_OLD_JARS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_UNABLE_TO_REMOVE_OLD_JARS_10069", 10069);

    /**
     * Restoring 'ds-cfg-delimiter-char' attribute type in concatenated schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_SUMMARY_RESTORE_CSV_DELIMITER_CHAR =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_SUMMARY_RESTORE_CSV_DELIMITER_CHAR_10070", 10070);

    /**
     * An error occurred reading schema file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_TASK_CANNOT_READ_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_CANNOT_READ_SCHEMA_FILE_10071", 10071);

    /**
     * An error occurred appending 'ds-cfg-delimiter-char' attribute type to concatenated schema file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_UPGRADE_TASK_CANNOT_WRITE_TO_CONCATENATED_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_CANNOT_WRITE_TO_CONCATENATED_SCHEMA_FILE_10072", 10072);

    /**
     * OpenDJ 3.5.0 introduced a new configuration model for the HTTP connection handler and its associated endpoints. Any enabled HTTP connection handlers will be disabled during the upgrade due to the break in compatibility
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_CONFIRM_DISABLING_HTTP_CONNECTION_HANDLER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_CONFIRM_DISABLING_HTTP_CONNECTION_HANDLER_10073", 10073);

    /**
     * Disabling the HTTP connection handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_DISABLING_HTTP_CONNECTION_HANDLER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_DISABLING_HTTP_CONNECTION_HANDLER_10074", 10074);

    /**
     * Adding default HTTP endpoints and auth mechanisms to configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_ADDING_DEFAULT_HTTP_ENDPOINTS_AND_AUTH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_ADDING_DEFAULT_HTTP_ENDPOINTS_AND_AUTH_10075", 10075);

    /**
     * Removing top configuration entry for matching rules
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_REMOVE_MATCHING_RULES_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REMOVE_MATCHING_RULES_ENTRY_10076", 10076);

    /**
     * Removing configuration for syntaxes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_REMOVE_SYNTAXES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_REMOVE_SYNTAXES_10077", 10077);

    /**
     * Adding configuration for schema providers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UPGRADE_TASK_ADD_SCHEMA_PROVIDERS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_UPGRADE_TASK_ADD_SCHEMA_PROVIDERS_10078", 10078);

    /**
     * back up OpenDJ directory data
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_BACKUP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_BACKUP_15000", 15000);

    /**
     * encode and decode base64 strings
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_BASE64 =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_BASE64_15001", 15001);

    /**
     * start the OpenDJ graphical admin interface
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_CONTROL_PANEL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_CONTROL_PANEL_15002", 15002);

    /**
     * script to manage OpenDJ as a service on UNIX
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_CREATE_RC_SCRIPT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_CREATE_RC_SCRIPT_15003", 15003);

    /**
     * apply OpenDJ Java home and JVM settings
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_DSJAVAPROPERTIES =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_DSJAVAPROPERTIES_15005", 15005);

    /**
     * manage OpenDJ directory data replication
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_DSREPLICATION =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_DSREPLICATION_15006", 15006);

    /**
     * encode a password with an OpenDJ storage scheme
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_ENCODE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_ENCODE_PASSWORD_15007", 15007);

    /**
     * export OpenDJ directory data in LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_EXPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_EXPORT_LDIF_15008", 15008);

    /**
     * import OpenDJ directory data from LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_IMPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_IMPORT_LDIF_15009", 15009);

    /**
     * perform LDAP compare operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPCOMPARE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPCOMPARE_15010", 15010);

    /**
     * perform LDAP delete operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPDELETE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPDELETE_15011", 15011);

    /**
     * perform LDAP modify, add, delete, mod DN operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPMODIFY_15012", 15012);

    /**
     * perform LDAP password modifications
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPPASSWORDMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPPASSWORDMODIFY_15013", 15013);

    /**
     * perform LDAP search operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPSEARCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPSEARCH_15014", 15014);

    /**
     * compare small LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFDIFF =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFDIFF_15015", 15015);

    /**
     * apply LDIF changes to LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFMODIFY_15016", 15016);

    /**
     * search LDIF with LDAP filters
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFSEARCH =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFSEARCH_15017", 15017);

    /**
     * list OpenDJ backends and base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LIST_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_LIST_BACKENDS_15018", 15018);

    /**
     * manage state of OpenDJ server accounts
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_MANAGE_ACCOUNT =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_MANAGE_ACCOUNT_15020", 15020);

    /**
     * manage OpenDJ server administration tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_MANAGE_TASKS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_MANAGE_TASKS_15021", 15021);

    /**
     * rebuild index after configuration change
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_REBUILD_INDEX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_REBUILD_INDEX_15022", 15022);

    /**
     * restore OpenDJ directory data backups
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_RESTORE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_RESTORE_15023", 15023);

    /**
     * install OpenDJ directory server
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_SETUP =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_SETUP_15024", 15024);

    /**
     * start OpenDJ directory server
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_START_DS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_START_DS_15025", 15025);

    /**
     * display basic OpenDJ server information
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_STATUS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_STATUS_15026", 15026);

    /**
     * stop OpenDJ directory server
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_STOP_DS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_STOP_DS_15027", 15027);

    /**
     * upgrade OpenDJ configuration and application data
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_UPGRADE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_UPGRADE_15028", 15028);

    /**
     * check index for consistency or errors
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_VERIFY_INDEX =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_VERIFY_INDEX_15029", 15029);

    /**
     * register OpenDJ as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_WINDOWS_SERVICE_15030", 15030);

    /**
     * gather OpenDJ backend debugging information
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_BACKEND_TOOL =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "REF_SHORT_DESC_BACKEND_TOOL_15031", 15031);

    /**
     * <xinclude:include href="description-psearch-info.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_PSEARCH_INFO =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_PSEARCH_INFO_20002", 20002);

    /**
     * <xinclude:include href="variablelist-ldap-controls.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_CONTROLS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_CONTROLS_20003", 20003);

    /**
     * <xinclude:include href="description-upgrade.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_UPGRADE_CLI =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_UPGRADE_CLI_20004", 20004);

    /**
     * Just verify that the JVM can be started properly
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_TESTONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_TESTONLY_20005", 20005);

    /**
     * {backendType}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_BACKEND_TYPE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_BACKEND_TYPE_PLACEHOLDER_20006", 20006);

    /**
     * The type of the userRoot backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_DESCRIPTION_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_DESCRIPTION_BACKEND_TYPE_20007", 20007);

    /**
     * Provide the backend type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLDS_PROMPT_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_INSTALLDS_PROMPT_BACKEND_TYPE_20008", 20008);

    /**
     * The backend type '%s' is not recognized. The supported backend types are %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INSTALLDS_NO_SUCH_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_INSTALLDS_NO_SUCH_BACKEND_TYPE_20009", 20009);

    /**
     * The backend type '%s' is not recognized. The supported backend types are %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_BACKEND_TYPE_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_BACKEND_TYPE_UNKNOWN_20010", 20010);

    /**
     * An error occurred while trying to create userRoot backend type %s. Error message: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIGDS_SET_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolMessages.class, RESOURCE, "ERR_CONFIGDS_SET_BACKEND_TYPE_20011", 20011);

    /**
     * The local instance is not configured or you do not have permissions to access it.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INSTANCE_NOT_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "ERR_INSTANCE_NOT_CONFIGURED_20013", 20013);

    /**
     * Invalid deref alias specified: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_INVALID_DEREFERENCE_POLICY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_SEARCH_INVALID_DEREFERENCE_POLICY_20014", 20014);

    /**
     * Could not completely read file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILE_NOT_FULLY_READABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolMessages.class, RESOURCE, "ERR_FILE_NOT_FULLY_READABLE_20015", 20015);

    /**
     * <xinclude:include href="variablelist-backendstat-index-status.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_INDEX_STATUS =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_BACKEND_TOOL_SUBCMD_LIST_INDEX_STATUS_20016", 20016);

    /**
     * Legacy argument for ForgeRock OpenDJ compatibility.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DEFAULT_ADD =
                    new LocalizableMessageDescriptor.Arg0(ToolMessages.class, RESOURCE, "INFO_DESCRIPTION_DEFAULT_ADD_20017", 20017);

}
