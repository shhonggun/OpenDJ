package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.plugin}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/plugin.properties} and it should not be manually edited.
 */
public final class PluginMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.plugin";

    // Prevent instantiation.
    private PluginMessages() {
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
     * The LDAP attribute description list plugin instance defined in configuration entry %s does not list any plugin types. This plugin must be configured to operate as a pre-parse search plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_ADLIST_NO_PLUGIN_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ADLIST_NO_PLUGIN_TYPES_3", 3);

    /**
     * The LDAP attribute description list plugin instance defined in configuration entry %s lists an invalid plugin type %s. This plugin can only be used as a pre-parse search plugin
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_ADLIST_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ADLIST_INVALID_PLUGIN_TYPE_4", 4);

    /**
     * The Directory Server profiler plugin instance defined in configuration entry %s does not list any plugin types. This plugin must be configured to operate as a startup plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PROFILER_NO_PLUGIN_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PROFILER_NO_PLUGIN_TYPES_5", 5);

    /**
     * The Directory Server profiler plugin instance defined in configuration entry %s lists an invalid plugin type %s. This plugin can only be used as a startup plugin
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_PROFILER_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PROFILER_INVALID_PLUGIN_TYPE_6", 6);

    /**
     * An unexpected error occurred when the profiler plugin defined in configuration entry %s attempted to write the information captured to output file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_PROFILER_CANNOT_WRITE_PROFILE_DATA =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PROFILER_CANNOT_WRITE_PROFILE_DATA_9", 9);

    /**
     * The profile directory %s specified in attribute ds-cfg-profile-directory of configuration entry %s is invalid because the specified path does not exist or is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_PLUGIN_PROFILER_INVALID_PROFILE_DIR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "WARN_PLUGIN_PROFILER_INVALID_PROFILE_DIR_16", 16);

    /**
     * The profiler plugin defined in configuration entry %s has been activated and has started capturing data
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_PROFILER_STARTED_PROFILING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_PROFILER_STARTED_PROFILING_22", 22);

    /**
     * The profiler plugin defined in configuration entry %s is already active, and therefore the request to start profiling has been ignored
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_PROFILER_ALREADY_PROFILING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_PROFILER_ALREADY_PROFILING_23", 23);

    /**
     * The profiler plugin defined in configuration entry %s received a request to stop capturing data but it was not active so no action has been taken
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_PROFILER_NOT_RUNNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_PROFILER_NOT_RUNNING_24", 24);

    /**
     * The profiler plugin defined in configuration entry %s has been stopped and is no longer capturing data
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_PROFILER_STOPPED_PROFILING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_PROFILER_STOPPED_PROFILING_25", 25);

    /**
     * The data collected by the profiler plugin defined in configuration entry %s has been written to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PLUGIN_PROFILER_WROTE_PROFILE_DATA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_PROFILER_WROTE_PROFILE_DATA_26", 26);

    /**
     * The startup plugin defined in configuration entry %s threw an exception when it was invoked during the Directory Server startup process: %s. The server startup process has been aborted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_STARTUP_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_STARTUP_PLUGIN_EXCEPTION_30", 30);

    /**
     * The startup plugin defined in configuration entry %s returned a null value when it was invoked during the Directory Server startup process. This is an illegal return value, and the server startup process has been aborted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_STARTUP_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_STARTUP_PLUGIN_RETURNED_NULL_31", 31);

    /**
     * The startup plugin defined in configuration entry %s encountered an error when it was invoked during the Directory Server startup process: %s (error ID %d). The server startup process has been aborted
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_PLUGIN_STARTUP_PLUGIN_FAIL_ABORT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_STARTUP_PLUGIN_FAIL_ABORT_33", 33);

    /**
     * The shutdown plugin defined in configuration entry %s threw an exception when it was invoked during the Directory Server shutdown process: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_SHUTDOWN_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SHUTDOWN_PLUGIN_EXCEPTION_34", 34);

    /**
     * The post-connect plugin defined in configuration entry %s threw an exception when it was invoked for connection %d from %s: %s. The connection will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_PLUGIN_POST_CONNECT_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_CONNECT_PLUGIN_EXCEPTION_35", 35);

    /**
     * The post-connect plugin defined in configuration entry %s returned null when invoked for connection %d from %s. This is an illegal response, and the connection will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_PLUGIN_POST_CONNECT_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_CONNECT_PLUGIN_RETURNED_NULL_36", 36);

    /**
     * The post-disconnect plugin defined in configuration entry %s threw an exception when it was invoked for connection %d from %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_PLUGIN_POST_DISCONNECT_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_DISCONNECT_PLUGIN_EXCEPTION_37", 37);

    /**
     * The post-disconnect plugin defined in configuration entry %s returned null when invoked for connection %d from %s. This is an illegal response
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_PLUGIN_POST_DISCONNECT_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_DISCONNECT_PLUGIN_RETURNED_NULL_38", 38);

    /**
     * The pre-parse %s plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object> ERR_PLUGIN_PRE_PARSE_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PRE_PARSE_PLUGIN_EXCEPTION_39", 39);

    /**
     * The pre-parse %s plugin defined in configuration entry %s returned null when invoked for connection %d operation %d. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> ERR_PLUGIN_PRE_PARSE_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PRE_PARSE_PLUGIN_RETURNED_NULL_40", 40);

    /**
     * The pre-operation %s plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object> ERR_PLUGIN_PRE_OPERATION_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PRE_OPERATION_PLUGIN_EXCEPTION_41", 41);

    /**
     * The pre-operation %s plugin defined in configuration entry %s returned null when invoked for connection %d operation %d. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> ERR_PLUGIN_PRE_OPERATION_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PRE_OPERATION_PLUGIN_RETURNED_NULL_42", 42);

    /**
     * The post-operation %s plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object> ERR_PLUGIN_POST_OPERATION_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_OPERATION_PLUGIN_EXCEPTION_43", 43);

    /**
     * The post-operation %s plugin defined in configuration entry %s returned null when invoked for connection %d operation %d. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> ERR_PLUGIN_POST_OPERATION_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_OPERATION_PLUGIN_RETURNED_NULL_44", 44);

    /**
     * The post-response %s plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object> ERR_PLUGIN_POST_RESPONSE_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_RESPONSE_PLUGIN_EXCEPTION_45", 45);

    /**
     * The post-response %s plugin defined in configuration entry %s returned null when invoked for connection %d operation %d. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> ERR_PLUGIN_POST_RESPONSE_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_RESPONSE_PLUGIN_RETURNED_NULL_46", 46);

    /**
     * The search result entry plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d with entry %s: %s. Processing on this search operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Number, Object, Object> ERR_PLUGIN_SEARCH_ENTRY_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Number, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SEARCH_ENTRY_PLUGIN_EXCEPTION_47", 47);

    /**
     * The search result entry plugin defined in configuration entry %s returned null when invoked for connection %d operation %d with entry %s. This is an illegal response, and processing on this search operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_PLUGIN_SEARCH_ENTRY_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SEARCH_ENTRY_PLUGIN_RETURNED_NULL_48", 48);

    /**
     * The search result reference plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d with referral URL(s) %s: %s. Processing on this search operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Number, Object, Object> ERR_PLUGIN_SEARCH_REFERENCE_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Number, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SEARCH_REFERENCE_PLUGIN_EXCEPTION_49", 49);

    /**
     * The search result reference plugin defined in configuration entry %s returned null when invoked for connection %d operation %d with referral URL(s) %s. This is an illegal response, and processing on this search operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_PLUGIN_SEARCH_REFERENCE_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SEARCH_REFERENCE_PLUGIN_RETURNED_NULL_50", 50);

    /**
     * An attempt was made to register the LastMod plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_LASTMOD_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_LASTMOD_INVALID_PLUGIN_TYPE_51", 51);

    /**
     * Path to a profile data file. This argument can be provided more than once to analyze data from multiple data files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROFILEVIEWER_DESCRIPTION_FILENAMES =
                    new LocalizableMessageDescriptor.Arg0(PluginMessages.class, RESOURCE, "INFO_PROFILEVIEWER_DESCRIPTION_FILENAMES_52", 52);

    /**
     * Indicates whether to view the profile information in GUI mode or to write the resulting data to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROFILEVIEWER_DESCRIPTION_USE_GUI =
                    new LocalizableMessageDescriptor.Arg0(PluginMessages.class, RESOURCE, "INFO_PROFILEVIEWER_DESCRIPTION_USE_GUI_53", 53);

    /**
     * An unexpected error occurred while attempting to initialize the command-line arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROFILEVIEWER_CANNOT_INITIALIZE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PROFILEVIEWER_CANNOT_INITIALIZE_ARGS_55", 55);

    /**
     * An error occurred while parsing the command-line arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROFILEVIEWER_ERROR_PARSING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PROFILEVIEWER_ERROR_PARSING_ARGS_56", 56);

    /**
     * An error occurred while trying to process the profile data in file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PROFILEVIEWER_CANNOT_PROCESS_DATA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PROFILEVIEWER_CANNOT_PROCESS_DATA_FILE_57", 57);

    /**
     * The LDIF import plugin defined in configuration entry %s threw an exception when it was invoked on entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_LDIF_IMPORT_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_LDIF_IMPORT_PLUGIN_EXCEPTION_58", 58);

    /**
     * The LDIF import plugin defined in configuration entry %s returned null when invoked on entry %s. This is an illegal response
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_LDIF_IMPORT_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_LDIF_IMPORT_PLUGIN_RETURNED_NULL_59", 59);

    /**
     * The LDIF export plugin defined in configuration entry %s threw an exception when it was invoked on entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_LDIF_EXPORT_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_LDIF_EXPORT_PLUGIN_EXCEPTION_60", 60);

    /**
     * The LDIF export plugin defined in configuration entry %s returned null when invoked on entry %s. This is an illegal response
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_LDIF_EXPORT_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_LDIF_EXPORT_PLUGIN_RETURNED_NULL_61", 61);

    /**
     * An attempt was made to register the EntryUUID plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_ENTRYUUID_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ENTRYUUID_INVALID_PLUGIN_TYPE_62", 62);

    /**
     * The intermediate response plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_PLUGIN_INTERMEDIATE_RESPONSE_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_INTERMEDIATE_RESPONSE_PLUGIN_EXCEPTION_63", 63);

    /**
     * The intermediate response plugin defined in configuration entry %s returned null when invoked for connection %d operation %d. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_PLUGIN_INTERMEDIATE_RESPONSE_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_INTERMEDIATE_RESPONSE_PLUGIN_RETURNED_NULL_64", 64);

    /**
     * An attempt was made to register the password policy import plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWPIMPORT_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWPIMPORT_INVALID_PLUGIN_TYPE_65", 65);

    /**
     * An error occurred while attempting to encode a password value stored in attribute %s of user entry %s: %s. Password values for this user will not be encoded
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_PWPIMPORT_ERROR_ENCODING_PASSWORD =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWPIMPORT_ERROR_ENCODING_PASSWORD_66", 66);

    /**
     * The plugin defined in configuration entry %s does not support the %s plugin type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_TYPE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_TYPE_NOT_SUPPORTED_67", 67);

    /**
     * This utility can be used to view information in data files captured by the Directory Server profiler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROFILEVIEWER_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(PluginMessages.class, RESOURCE, "INFO_PROFILEVIEWER_TOOL_DESCRIPTION_68", 68);

    /**
     * The password policy import plugin is not configured any default auth password schemes, and the server does not support the %s auth password scheme
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWIMPORT_NO_DEFAULT_AUTH_SCHEMES =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWIMPORT_NO_DEFAULT_AUTH_SCHEMES_69", 69);

    /**
     * Auth password storage scheme %s referenced by the password policy import plugin is not configured for use in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWIMPORT_INVALID_DEFAULT_AUTH_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWIMPORT_INVALID_DEFAULT_AUTH_SCHEME_70", 70);

    /**
     * The password policy import plugin is not configured any default user password schemes, and the server does not support the %s auth password scheme
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWIMPORT_NO_DEFAULT_USER_SCHEMES =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWIMPORT_NO_DEFAULT_USER_SCHEMES_71", 71);

    /**
     * User password storage scheme %s referenced by the password policy import plugin is not configured for use in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWIMPORT_INVALID_DEFAULT_USER_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWIMPORT_INVALID_DEFAULT_USER_SCHEME_72", 72);

    /**
     * Entry '%s' indicates that it uses custom password policy '%s', but no such policy is defined in the server. Any passwords contained in the entry will be encoded using the default storage schemes, but authentication as this user might not be possible
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_PLUGIN_PWIMPORT_NO_SUCH_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "WARN_PLUGIN_PWIMPORT_NO_SUCH_POLICY_73", 73);

    /**
     * An error occurred while attempting to decode the value of the custom password policy attribute in entry '%s': %s. Any passwords contained in the entry will be encoded using the default storage schemes, but authentication as this user might not be possible
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_PLUGIN_PWIMPORT_CANNOT_DECODE_POLICY_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "WARN_PLUGIN_PWIMPORT_CANNOT_DECODE_POLICY_DN_74", 74);

    /**
     * The subordinate modify DN plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_PLUGIN_SUBORDINATE_MODIFY_DN_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SUBORDINATE_MODIFY_DN_PLUGIN_EXCEPTION_75", 75);

    /**
     * The subordinate modify DN plugin defined in configuration entry %s returned null when invoked for connection %d operation %s. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_PLUGIN_SUBORDINATE_MODIFY_DN_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SUBORDINATE_MODIFY_DN_PLUGIN_RETURNED_NULL_76", 76);

    /**
     * An attempt was made to register the Unique Attribute plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_UNIQUEATTR_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_INVALID_PLUGIN_TYPE_77", 77);

    /**
     * An attempt was made to register the Referential Integrity plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_INVALID_PLUGIN_TYPE_81", 81);

    /**
     * An error occurred during Referential Integity plugin initialization because log file creation failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_CREATE_LOGFILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_CREATE_LOGFILE_82", 82);

    /**
     * An error occurred closing the Referential Integrity plugin update log file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_CLOSE_LOGFILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_CLOSE_LOGFILE_83", 83);

    /**
     * An error occurred replacing the Referential Integrity plugin update log file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_REPLACE_LOGFILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_REPLACE_LOGFILE_84", 84);

    /**
     * The file name that the Referential Integrity plugin logs changes to during background processing has been changed from %s to %s, but this change will not take effect until the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PLUGIN_REFERENT_LOGFILE_CHANGE_REQUIRES_RESTART =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_REFERENT_LOGFILE_CHANGE_REQUIRES_RESTART_85", 85);

    /**
     * The Referential Integrity plugin background processing update interval has been changed from %s to %s, the new value will now be during background processing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_UPDATE_INTERVAL_CHANGED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_UPDATE_INTERVAL_CHANGED_86", 86);

    /**
     * The Referential Integrity plugin background processing has been stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_STOPPING =
                    new LocalizableMessageDescriptor.Arg0(PluginMessages.class, RESOURCE, "INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_STOPPING_87", 87);

    /**
     * The Referential Integrity plugin has started background processing using the update interval %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_STARTING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_REFERENT_BACKGROUND_PROCESSING_STARTING_88", 88);

    /**
     * The Referential Integrity plugin failed when performaing an internal search: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_SEARCH_FAILED_89", 89);

    /**
     * The Referential Integrity plugin failed when performing an internal modify on entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_REFERENT_MODIFY_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_MODIFY_FAILED_90", 90);

    /**
     * The Referential Integrity plugin failed to decode a entry DN from the update log: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_CANNOT_DECODE_STRING_AS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_CANNOT_DECODE_STRING_AS_DN_91", 91);

    /**
     * The Referential Integrity plugin failed when performing a search because the base DN %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PLUGIN_REFERENT_SEARCH_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "INFO_PLUGIN_REFERENT_SEARCH_NO_SUCH_OBJECT_92", 92);

    /**
     * An error occurred in the Referential Integrity plugin while attempting to configure the attribute type %s which has a syntax OID of %s. A Referential Integrity attribute type must have a syntax OID of either 1.3.6.1.4.1.1466.115.121.1.12 (for the distinguished name syntax) or 1.3.6.1.4.1.1466.115.121.1.34 (for the name and optional uid syntax)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_REFERENT_INVALID_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_INVALID_ATTRIBUTE_SYNTAX_93", 93);

    /**
     * The 7-bit clean plugin is configured with invalid plugin type %s. Only the ldifImport, preOperationAdd, preOperationModify, and preOperationModifyDN plugin types are allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_7BIT_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_INVALID_PLUGIN_TYPE_96", 96);

    /**
     * An error occurred while trying to decode the DN of the target entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_7BIT_CANNOT_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_CANNOT_DECODE_DN_97", 97);

    /**
     * An error occurred while trying to decode attribute %s in the target entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_7BIT_CANNOT_DECODE_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_CANNOT_DECODE_ATTR_98", 98);

    /**
     * An error occurred while trying to decode the new RDN: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_7BIT_CANNOT_DECODE_NEW_RDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_CANNOT_DECODE_NEW_RDN_99", 99);

    /**
     * The modify DN operation would have resulted in a value for attribute %s that was not 7-bit clean
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_7BIT_MODIFYDN_ATTR_NOT_CLEAN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_MODIFYDN_ATTR_NOT_CLEAN_102", 102);

    /**
     * The entry included a value for attribute %s that was not 7-bit clean
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_7BIT_IMPORT_ATTR_NOT_CLEAN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_7BIT_IMPORT_ATTR_NOT_CLEAN_103", 103);

    /**
     * The password policy import plugin references default auth password storage scheme %s which is not available for use in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_PWIMPORT_NO_SUCH_DEFAULT_AUTH_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_PWIMPORT_NO_SUCH_DEFAULT_AUTH_SCHEME_104", 104);

    /**
     * The post-synchronization %s plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object> ERR_PLUGIN_POST_SYNCHRONIZATION_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_POST_SYNCHRONIZATION_PLUGIN_EXCEPTION_105", 105);

    /**
     * A unique attribute conflict was detected for attribute %s: value %s already exists in entry %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_UNIQUEATTR_ATTR_NOT_UNIQUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_ATTR_NOT_UNIQUE_106", 106);

    /**
     * A unique attribute conflict was detected for attribute %s during synchronization (connID=%d, opID=%d): value %s in entry %s conflicts with an existing value in entry %s. Manual interaction is required to eliminate the conflict
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Number, Number, Object, Object, Object> ERR_PLUGIN_UNIQUEATTR_SYNC_NOT_UNIQUE =
                    new LocalizableMessageDescriptor.Arg6<Object, Number, Number, Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_SYNC_NOT_UNIQUE_107", 107);

    /**
     * An internal error occurred while attempting to determine whether the operation would have resulted in a unique attribute conflict (result %s, message %s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_UNIQUEATTR_INTERNAL_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_INTERNAL_ERROR_108", 108);

    /**
     * An internal error occurred while attempting to determine whether the synchronization operation (connID=%d, opID=%d) for entry %s would have resulted in a unique attribute conflict (result %s, message %s)
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Object> ERR_PLUGIN_UNIQUEATTR_INTERNAL_ERROR_SYNC =
                    new LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_INTERNAL_ERROR_SYNC_109", 109);

    /**
     * The referential integrity plugin defined in configuration entry %s is configured to operate on attribute %s but there is no equality index defined for this attribute in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_REFERENT_ATTR_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_ATTR_UNINDEXED_110", 110);

    /**
     * The unique attribute plugin defined in configuration entry %s is configured to operate on attribute %s but there is no equality index defined for this attribute in backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_UNIQUEATTR_ATTR_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_UNIQUEATTR_ATTR_UNINDEXED_111", 111);

    /**
     * An attempt was made to register the Change Number Control plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_CHANGE_NUMBER_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_CHANGE_NUMBER_INVALID_PLUGIN_TYPE_113", 113);

    /**
     * An attempt was made to register the Change Number Control plugin with the following plugin types : %s. However this plugin must be configured with all of the following plugin types : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_CHANGE_NUMBER_INVALID_PLUGIN_TYPE_LIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_CHANGE_NUMBER_INVALID_PLUGIN_TYPE_LIST_114", 114);

    /**
     * The subordinate delete plugin defined in configuration entry %s threw an exception when it was invoked for connection %d operation %d: %s. Processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_PLUGIN_SUBORDINATE_DELETE_PLUGIN_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SUBORDINATE_DELETE_PLUGIN_EXCEPTION_115", 115);

    /**
     * The subordinate delete plugin defined in configuration entry %s returned null when invoked for connection %d operation %s. This is an illegal response, and processing on this operation will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_PLUGIN_SUBORDINATE_DELETE_PLUGIN_RETURNED_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SUBORDINATE_DELETE_PLUGIN_RETURNED_NULL_116", 116);

    /**
     * An attempt was made to register the Samba password synchronization plugin to be invoked as a %s plugin. This plugin type is not allowed for this plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_SAMBA_SYNC_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SAMBA_SYNC_INVALID_PLUGIN_TYPE_117", 117);

    /**
     * The Samba password synchronization plugin could not encode a password for the following reasons: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_SAMBA_SYNC_ENCODING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SAMBA_SYNC_ENCODING_118", 118);

    /**
     * The Samba password synchronization plugin could not process a modification for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_SAMBA_SYNC_MODIFICATION_PROCESSING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_SAMBA_SYNC_MODIFICATION_PROCESSING_119", 119);

    /**
     * Invalid plugin type '%s' for the Attribute Cleanup plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_ATTR_CLEANUP_INITIALIZE_PLUGIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ATTR_CLEANUP_INITIALIZE_PLUGIN_120", 120);

    /**
     * Attribute '%s' is not defined in the directory schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_ATTR_CLEANUP_ATTRIBUTE_MISSING =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ATTR_CLEANUP_ATTRIBUTE_MISSING_121", 121);

    /**
     * The attribute '%s' has already been defined in the configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_ATTR_CLEANUP_DUPLICATE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ATTR_CLEANUP_DUPLICATE_VALUE_122", 122);

    /**
     * The mapping '%s:%s' maps the attribute to itself
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_ATTR_CLEANUP_EQUAL_VALUES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_ATTR_CLEANUP_EQUAL_VALUES_123", 123);

    /**
     * The property 'check-references-filter-criteria' specifies filtering criteria for attribute '%s', but this attribute is not listed in the 'attribute-type' property
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_ATTR_NOT_LISTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_ATTR_NOT_LISTED_124", 124);

    /**
     * The filtering criteria '%s' specified in property 'check-references-filter-criteria' is invalid because the filter could not be decoded: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PLUGIN_REFERENT_BAD_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_BAD_FILTER_125", 125);

    /**
     * The entry referenced by the value '%s' of the attribute '%s' in the entry '%s' does not exist in any of the configured naming contexts
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_REFERENT_ENTRY_MISSING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_ENTRY_MISSING_126", 126);

    /**
     * The entry referenced by the value '%s' of the attribute '%s' in the entry '%s' does not match the filter '%s'
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_PLUGIN_REFERENT_FILTER_MISMATCH =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_FILTER_MISMATCH_127", 127);

    /**
     * The entry referenced by the value '%s' of the attribute '%s' in the entry '%s' does not belong to any of the configured naming contexts
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PLUGIN_REFERENT_NAMINGCONTEXT_MISMATCH =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_NAMINGCONTEXT_MISMATCH_128", 128);

    /**
     * The opration could not be processed due to an unexpected exception: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_REFERENT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(PluginMessages.class, RESOURCE, "ERR_PLUGIN_REFERENT_EXCEPTION_129", 129);

}
