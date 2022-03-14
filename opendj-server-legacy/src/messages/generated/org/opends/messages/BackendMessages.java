package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.backend}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/backend.properties} and it should not be manually edited.
 */
public final class BackendMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.backend";

    // Prevent instantiation.
    private BackendMessages() {
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
     * An attempt was made to configure the root DSE backend without providing a configuration entry.  This is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ROOTDSE_CONFIG_ENTRY_NULL =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_CONFIG_ENTRY_NULL_2", 2);

    /**
     * Base DN "%s" is configured as one of the subordinate base DNs to use for searches below the root DSE.  However, this base DN is not handled by any suffix registered with the Directory Server and will therefore not be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ROOTDSE_NO_BACKEND_FOR_SUBORDINATE_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_ROOTDSE_NO_BACKEND_FOR_SUBORDINATE_BASE_4", 4);

    /**
     * An unexpected problem occurred while trying to determine the set of subordinate base DNs to use for searches below the root DSE:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ROOTDSE_SUBORDINATE_BASE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_ROOTDSE_SUBORDINATE_BASE_EXCEPTION_5", 5);

    /**
     * The root DSE backend was asked to retrieve entry with DN "%s".  This backend should only be asked to retrieve the root DSE itself.  However, it will check with the defined subordinate backends and see if it can find the requested entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ROOTDSE_GET_ENTRY_NONROOT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_ROOTDSE_GET_ENTRY_NONROOT_6", 6);

    /**
     * Unwilling to update entry "%s" because modify operations are not supported in the root DSE backend.  If you wish to alter the contents of the root DSE itself, then it may be possible to do so by modifying the "%s" entry in the configuration
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ROOTDSE_MODIFY_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_MODIFY_NOT_SUPPORTED_9", 9);

    /**
     * Unwilling to perform a search (connection ID %d, operation ID %d) with a base DN of "%s" in the root DSE backend.  The base DN for searches in this backend must be the DN of the root DSE itself
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ROOTDSE_INVALID_SEARCH_BASE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_INVALID_SEARCH_BASE_11", 11);

    /**
     * An unexpected failure occurred while trying to process a search operation (connection ID %d, operation ID %d) in the root DSE backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ROOTDSE_UNEXPECTED_SEARCH_FAILURE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_UNEXPECTED_SEARCH_FAILURE_12", 12);

    /**
     * Unable to process the search with connection ID %d and operation ID %d because it had an invalid scope of %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ROOTDSE_INVALID_SEARCH_SCOPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_INVALID_SEARCH_SCOPE_13", 13);

    /**
     * An unexpected error occurred while trying to open the LDIF writer for the root DSE backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ROOTDSE_UNABLE_TO_CREATE_LDIF_WRITER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_UNABLE_TO_CREATE_LDIF_WRITER_14", 14);

    /**
     * An unexpected error occurred while trying to export the root DSE entry to the specified LDIF target: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ROOTDSE_UNABLE_TO_EXPORT_DSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_UNABLE_TO_EXPORT_DSE_15", 15);

    /**
     * The root DSE backend does not provide a facility for backup and restore operations.  The contents of the root DSE should be backed up as part of the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ROOTDSE_BACKUP_AND_RESTORE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_BACKUP_AND_RESTORE_NOT_SUPPORTED_17", 17);

    /**
     * The root DSE configuration has been updated so that it will now use the defined set of Directory Server suffixes when performing searches below the root DSE
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOTDSE_USING_SUFFIXES_AS_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_ROOTDSE_USING_SUFFIXES_AS_BASE_DNS_18", 18);

    /**
     * The root DSE configuration has been updated so that it will now use the base DN set %s when performing below the root DSE
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ROOTDSE_USING_NEW_SUBORDINATE_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_ROOTDSE_USING_NEW_SUBORDINATE_BASE_DNS_19", 19);

    /**
     * The root DSE configuration has been updated so that it will now use a new set of user-defined attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOTDSE_USING_NEW_USER_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_ROOTDSE_USING_NEW_USER_ATTRS_20", 20);

    /**
     * An attempt was made to configure the monitor backend without providing a configuration entry.  This is not allowed, and no monitor information will be available over protocol
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MONITOR_CONFIG_ENTRY_NULL =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_MONITOR_CONFIG_ENTRY_NULL_21", 21);

    /**
     * An unexpected error occurred while attempting to decode cn=monitor as the base DN for the Directory Server monitor information:  %s.  No monitor information will be available over protocol
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MONITOR_CANNOT_DECODE_MONITOR_ROOT_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MONITOR_CANNOT_DECODE_MONITOR_ROOT_DN_22", 22);

    /**
     * Unwilling to add entry "%s" because add operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_ADD_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_ADD_NOT_SUPPORTED_23", 23);

    /**
     * Unwilling to remove entry "%s" because delete operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_DELETE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_DELETE_NOT_SUPPORTED_24", 24);

    /**
     * Unwilling to update entry "%s" because modify operations are not supported in the monitor backend.  If you wish to alter the contents of the base monitor entry itself, then it may be possible to do so by modifying the "%s" entry in the configuration
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MONITOR_MODIFY_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MONITOR_MODIFY_NOT_SUPPORTED_25", 25);

    /**
     * Unwilling to rename entry "%s" because modify DN operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_MODIFY_DN_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_MODIFY_DN_NOT_SUPPORTED_26", 26);

    /**
     * An error occurred while attempting to export the base monitor entry:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MONITOR_UNABLE_TO_EXPORT_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MONITOR_UNABLE_TO_EXPORT_BASE_27", 27);

    /**
     * An error occurred while attempting to export the monitor entry for monitor provider %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MONITOR_UNABLE_TO_EXPORT_PROVIDER_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MONITOR_UNABLE_TO_EXPORT_PROVIDER_ENTRY_28", 28);

    /**
     * The "%s" backend does not support LDIF import operations
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_IMPORT_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_IMPORT_NOT_SUPPORTED_29", 29);

    /**
     * The monitor configuration has been updated so that it will now use a new set of user-defined attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MONITOR_USING_NEW_USER_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_MONITOR_USING_NEW_USER_ATTRS_31", 31);

    /**
     * Unable to retrieve the requested entry from the "%s" backend because the provided DN was null
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_GET_ENTRY_NULL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_GET_ENTRY_NULL_32", 32);

    /**
     * Unable to initialize the "%s" backend because an error occurred while attempting to decode the base DN for this backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_CANNOT_DECODE_BACKEND_ROOT_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CANNOT_DECODE_BACKEND_ROOT_DN_33", 33);

    /**
     * Unable to retrieve the requested entry %s from the monitor backend because the DN is not below the monitor base of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MONITOR_INVALID_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MONITOR_INVALID_BASE_34", 34);

    /**
     * %d days %d hours %d minutes %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> INFO_MONITOR_UPTIME =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "INFO_MONITOR_UPTIME_37", 37);

    /**
     * An attempt was made to configure the schema backend without providing a configuration entry.  This is not allowed, and no schema information will be available over protocol
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SCHEMA_CONFIG_ENTRY_NULL =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CONFIG_ENTRY_NULL_38", 38);

    /**
     * An error occurred while trying to determine the base DNs to use when publishing the Directory Server schema information, as specified in the ds-cfg-schema-entry-dn attribute of configuration entry %s:  %s.  The default schema base DN of cn=schema will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_CANNOT_DETERMINE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CANNOT_DETERMINE_BASE_DN_40", 40);

    /**
     * An error occurred while attempting to export the base schema entry:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_UNABLE_TO_EXPORT_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_UNABLE_TO_EXPORT_BASE_45", 45);

    /**
     * Unable to retrieve the requested entry %s from the schema backend because the DN is equal to one of the schema entry DNs
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_INVALID_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_INVALID_BASE_48", 48);

    /**
     * An unexpected error occurred while trying to open the LDIF writer for the schema backend:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_UNABLE_TO_CREATE_LDIF_WRITER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_UNABLE_TO_CREATE_LDIF_WRITER_49", 49);

    /**
     * Successfully deregistered DN %s so that it will no longer be available as a schema entry DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SCHEMA_DEREGISTERED_BASE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_SCHEMA_DEREGISTERED_BASE_DN_50", 50);

    /**
     * An error occurred while trying to deregister %s as a schema entry DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_CANNOT_DEREGISTER_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CANNOT_DEREGISTER_BASE_DN_51", 51);

    /**
     * Successfully registered DN %s as a new schema entry DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SCHEMA_REGISTERED_BASE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_SCHEMA_REGISTERED_BASE_DN_52", 52);

    /**
     * An error occurred while trying to register %s as a schema entry DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_CANNOT_REGISTER_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CANNOT_REGISTER_BASE_DN_53", 53);

    /**
     * The schema configuration has been updated so that it will now use a new set of user-defined attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SCHEMA_USING_NEW_USER_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_SCHEMA_USING_NEW_USER_ATTRS_54", 54);

    /**
     * The Directory Server was unable to obtain a lock on entry %s after multiple attempts.  This could mean that the entry is already locked by a long-running operation or that the entry has previously been locked but was not properly unlocked
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_CANNOT_LOCK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CANNOT_LOCK_ENTRY_55", 55);

    /**
     * The task defined in entry %s is invalid because it has an invalid state %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_INVALID_STATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_INVALID_STATE_91", 91);

    /**
     * An error occurred while trying to parse the scheduled start time value %s from task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_CANNOT_PARSE_SCHEDULED_START_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_CANNOT_PARSE_SCHEDULED_START_TIME_92", 92);

    /**
     * An error occurred while trying to parse the actual start time value %s from task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_CANNOT_PARSE_ACTUAL_START_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_CANNOT_PARSE_ACTUAL_START_TIME_93", 93);

    /**
     * An error occurred while trying to parse the completion time value %s from task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_CANNOT_PARSE_COMPLETION_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_CANNOT_PARSE_COMPLETION_TIME_94", 94);

    /**
     * Task entry %s is missing required attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_MISSING_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_MISSING_ATTR_95", 95);

    /**
     * There are multiple instances of attribute %s in task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_MULTIPLE_ATTRS_FOR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_MULTIPLE_ATTRS_FOR_TYPE_96", 96);

    /**
     * There are no values for attribute %s in task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_NO_VALUES_FOR_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_NO_VALUES_FOR_ATTR_97", 97);

    /**
     * There are multiple values for attribute %s in task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_MULTIPLE_VALUES_FOR_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_MULTIPLE_VALUES_FOR_ATTR_98", 98);

    /**
     * An error occurred while executing the task defined in entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_EXECUTE_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASK_EXECUTE_FAILED_99", 99);

    /**
     * The provided recurring task entry does not contain attribute %s which is needed to hold the recurring task ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_NO_ID_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_NO_ID_ATTRIBUTE_100", 100);

    /**
     * The provided recurring task entry contains multiple attributes with type %s, which is used to hold the recurring task ID, but only a single instance is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_MULTIPLE_ID_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_MULTIPLE_ID_TYPES_101", 101);

    /**
     * The provided recurring task entry does not contain any values for the %s attribute, which is used to specify the recurring task ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_NO_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_NO_ID_102", 102);

    /**
     * The provided recurring task entry contains multiple values for the %s attribute, which is used to specify the recurring task ID, but only a single value is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_MULTIPLE_ID_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_MULTIPLE_ID_VALUES_103", 103);

    /**
     * The provided recurring task entry does not contain attribute %s which is needed to specify recurring task schedule
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_NO_SCHEDULE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_NO_SCHEDULE_ATTRIBUTE_104", 104);

    /**
     * The provided recurring task entry contains multiple attributes with type %s, which is used to hold recurring task schedule, but only a single instance is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_MULTIPLE_SCHEDULE_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_MULTIPLE_SCHEDULE_TYPES_105", 105);

    /**
     * The provided recurring task entry does not contain any values for the %s attribute, which is used to specify recurring task schedule
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_NO_SCHEDULE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_NO_SCHEDULE_VALUES_106", 106);

    /**
     * The provided recurring task entry contains multiple values for the %s attribute, which is used to specify recurring task schedule, but only a single value is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_MULTIPLE_SCHEDULE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_MULTIPLE_SCHEDULE_VALUES_107", 107);

    /**
     * An error occurred while attempting to load class %s specified in attribute %s of the provided recurring task entry:  %s.  Does this class exist in the Directory Server classpath?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RECURRINGTASK_CANNOT_LOAD_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_CANNOT_LOAD_CLASS_108", 108);

    /**
     * An error occurred while trying to create an instance of class %s as a Directory Server task.  Is this class a subclass of %s?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RECURRINGTASK_CANNOT_INSTANTIATE_CLASS_AS_TASK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_CANNOT_INSTANTIATE_CLASS_AS_TASK_109", 109);

    /**
     * An error occurred while attempting to perform internal initialization on an instance of class %s with the information contained in the provided entry:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RECURRINGTASK_CANNOT_INITIALIZE_INTERNAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_CANNOT_INITIALIZE_INTERNAL_110", 110);

    /**
     * The task backend configuration entry does not contain any base DNs.  There must be exactly one base DN for task information in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASKBE_NO_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_TASKBE_NO_BASE_DNS_112", 112);

    /**
     * The task backend configuration entry contains multiple base DNs.  There must be exactly one base DN for task information in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASKBE_MULTIPLE_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_TASKBE_MULTIPLE_BASE_DNS_113", 113);

    /**
     * An error occurred while attempting to decode recurring task base %s as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKBE_CANNOT_DECODE_RECURRING_TASK_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_CANNOT_DECODE_RECURRING_TASK_BASE_DN_114", 114);

    /**
     * An error occurred while attempting to decode scheduled task base %s as a DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKBE_CANNOT_DECODE_SCHEDULED_TASK_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_CANNOT_DECODE_SCHEDULED_TASK_BASE_DN_115", 115);

    /**
     * The specified task data backing file %s already exists and the Directory Server will not attempt to overwrite it.  Please delete or rename the existing file before attempting to use that path for the new backing file, or choose a new path
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_BACKING_FILE_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_BACKING_FILE_EXISTS_121", 121);

    /**
     * The specified path %s for the new task data backing file appears to be an invalid path.  Please choose a new path for the task data backing file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_INVALID_BACKING_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_INVALID_BACKING_FILE_PATH_122", 122);

    /**
     * The parent directory %s for the new task data backing file %s does not exist.  Please create this directory before attempting to use this path for the new backing file or choose a new path
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKBE_BACKING_FILE_MISSING_PARENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_BACKING_FILE_MISSING_PARENT_123", 123);

    /**
     * The parent directory %s for the new task data backing file %s exists but is not a directory. Please choose a new path for the task data backing file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKBE_BACKING_FILE_PARENT_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_BACKING_FILE_PARENT_NOT_DIRECTORY_124", 124);

    /**
     * An error occurred while attempting to determine the new path to the task data backing file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_ERROR_GETTING_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_ERROR_GETTING_BACKING_FILE_125", 125);

    /**
     * The completed task retention time has been updated to %d seconds.  This will take effect immediately
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_TASKBE_UPDATED_RETENTION_TIME =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "INFO_TASKBE_UPDATED_RETENTION_TIME_128", 128);

    /**
     * The path to the task data backing file has been changed to %s.  A snapshot of the current task configuration has been written to that file and it will continue to be used for future updates
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASKBE_UPDATED_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_TASKBE_UPDATED_BACKING_FILE_129", 129);

    /**
     * New entries in the task backend may only be added immediately below %s for scheduled tasks or immediately below %s for recurring tasks
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKBE_ADD_DISALLOWED_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_ADD_DISALLOWED_DN_130", 130);

    /**
     * This file contains the data used by the Directory Server task scheduler backend.  Do not edit this file directly, as there is a risk that those changes will be lost.  Scheduled and recurring task definitions should only be edited using the administration utilities provided with the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKBE_BACKING_FILE_HEADER =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_TASKBE_BACKING_FILE_HEADER_132", 132);

    /**
     * Unable to add recurring task %s to the task scheduler because another recurring task already exists with the same ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_DUPLICATE_RECURRING_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_DUPLICATE_RECURRING_ID_133", 133);

    /**
     * Unable to schedule task %s because another task already exists with the same ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_DUPLICATE_TASK_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_DUPLICATE_TASK_ID_134", 134);

    /**
     * Unable to add completed task %s to the task scheduler because another task already exists with the same ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_TASKSCHED_DUPLICATE_TASK_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_TASKSCHED_DUPLICATE_TASK_ID_135", 135);

    /**
     * An error occurred while attempting to schedule the next iteration of recurring task %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_ERROR_SCHEDULING_RECURRING_ITERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_ERROR_SCHEDULING_RECURRING_ITERATION_136", 136);

    /**
     * An error occurred while attempting to read an entry from the tasks backing file %s on or near line %d:  %s.  This is not a fatal error, so the task scheduler will attempt to continue parsing the file and schedule any additional tasks that it contains
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_TASKSCHED_CANNOT_PARSE_ENTRY_RECOVERABLE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_PARSE_ENTRY_RECOVERABLE_137", 137);

    /**
     * An error occurred while attempting to read an entry from the tasks backing file %s on or near line %d:  %s.  This is an unrecoverable error, and parsing cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_TASKSCHED_CANNOT_PARSE_ENTRY_FATAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_PARSE_ENTRY_FATAL_138", 138);

    /**
     * Entry %s read from the tasks backing file is invalid because it has no parent and does not match the task root DN of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_ENTRY_HAS_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_ENTRY_HAS_NO_PARENT_139", 139);

    /**
     * An error occurred while attempting to parse entry %s as a recurring task and add it to the scheduler:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_SCHEDULE_RECURRING_TASK_FROM_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_SCHEDULE_RECURRING_TASK_FROM_ENTRY_140", 140);

    /**
     * An error occurred while attempting to parse entry %s as a task and add it to the scheduler:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_SCHEDULE_TASK_FROM_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_SCHEDULE_TASK_FROM_ENTRY_141", 141);

    /**
     * Entry %s read from the tasks backing file %s has a DN which is not valid for a task or recurring task definition and will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_INVALID_TASK_ENTRY_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_INVALID_TASK_ENTRY_DN_142", 142);

    /**
     * An error occurred while attempting to read from the tasks data backing file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_ERROR_READING_TASK_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_ERROR_READING_TASK_BACKING_FILE_143", 143);

    /**
     * An error occurred while attempting to create a new tasks backing file %s for use with the task scheduler:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_CREATE_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_CREATE_BACKING_FILE_144", 144);

    /**
     * The provided task entry does not contain attribute %s which is needed to specify the fully-qualified name of the class providing the task logic
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_NO_CLASS_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_NO_CLASS_ATTRIBUTE_145", 145);

    /**
     * The provided task entry contains multiple attributes with type %s, which is used to hold the task class name, but only a single instance is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_MULTIPLE_CLASS_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_MULTIPLE_CLASS_TYPES_146", 146);

    /**
     * The provided task entry does not contain any values for the %s attribute, which is used to specify the fully-qualified name of the class providing the task logic
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_NO_CLASS_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_NO_CLASS_VALUES_147", 147);

    /**
     * The provided task entry contains multiple values for the %s attribute, which is used to specify the task class name, but only a single value is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_MULTIPLE_CLASS_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_MULTIPLE_CLASS_VALUES_148", 148);

    /**
     * An error occurred while attempting to load class %s specified in attribute %s of the provided task entry:  %s. Does this class exist in the Directory Server classpath?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TASKSCHED_CANNOT_LOAD_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_LOAD_CLASS_149", 149);

    /**
     * An error occurred while trying to create an instance of class %s as a Directory Server task. Is this class a subclass of %s?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_INSTANTIATE_CLASS_AS_TASK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_INSTANTIATE_CLASS_AS_TASK_150", 150);

    /**
     * An error occurred while attempting to perform internal initialization on an instance of class %s with the information contained in the provided entry:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_INITIALIZE_INTERNAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_INITIALIZE_INTERNAL_151", 151);

    /**
     * An error occurred while attempting to rename the current tasks backing file from %s to %s:  %s.  The previous task configuration (which does not reflect the latest update) may be lost
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_TASKSCHED_CANNOT_RENAME_CURRENT_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "WARN_TASKSCHED_CANNOT_RENAME_CURRENT_BACKING_FILE_152", 152);

    /**
     * An error occurred while attempting to rename the new tasks backing file from %s to %s:  %s. If the Directory Server is restarted, then the task scheduler may not work as expected
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TASKSCHED_CANNOT_RENAME_NEW_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_RENAME_NEW_BACKING_FILE_153", 153);

    /**
     * An error occurred while attempting to write the new tasks data backing file %s:  %s.  Configuration information reflecting the latest update may be lost
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_CANNOT_WRITE_BACKING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_CANNOT_WRITE_BACKING_FILE_154", 154);

    /**
     * The tasks backend is being shut down
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKBE_INTERRUPTED_BY_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_TASKBE_INTERRUPTED_BY_SHUTDOWN_156", 156);

    /**
     * The root DSE configuration has been updated so that configuration attribute %s will now use a value of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ROOTDSE_UPDATED_SHOW_ALL_ATTRS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "INFO_ROOTDSE_UPDATED_SHOW_ALL_ATTRS_159", 159);

    /**
     * Unable to remove pending task %s because no such task exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_REMOVE_PENDING_NO_SUCH_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_REMOVE_PENDING_NO_SUCH_TASK_161", 161);

    /**
     * Unable to remove pending task %s because the task is no longer pending
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_REMOVE_PENDING_NOT_PENDING =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_REMOVE_PENDING_NOT_PENDING_162", 162);

    /**
     * Unable to remove completed task %s because no such task exists in the list of completed tasks
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_REMOVE_COMPLETED_NO_SUCH_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_REMOVE_COMPLETED_NO_SUCH_TASK_163", 163);

    /**
     * Unable to remove entry %s from the task backend because its DN is either not appropriate for that backend or it is not below the scheduled or recurring tasks base entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_DELETE_INVALID_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_DELETE_INVALID_ENTRY_164", 164);

    /**
     * Unable to remove entry %s from the task backend because there is no scheduled task associated with that entry DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_DELETE_NO_SUCH_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_DELETE_NO_SUCH_TASK_165", 165);

    /**
     * Unable to delete entry %s from the task backend because the associated task is currently running
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_DELETE_RUNNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_DELETE_RUNNING_166", 166);

    /**
     * Unable to remove entry %s from the task backend because there is no recurring task associated with that entry DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_DELETE_NO_SUCH_RECURRING_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_DELETE_NO_SUCH_RECURRING_TASK_167", 167);

    /**
     * Unable to process the search operation in the task backend because the provided base DN %s is not valid for entries in the task backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_SEARCH_INVALID_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_SEARCH_INVALID_BASE_168", 168);

    /**
     * Unable to process the search operation in the task backend because there is no scheduled task associated with the provided search base entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_SEARCH_NO_SUCH_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_SEARCH_NO_SUCH_TASK_169", 169);

    /**
     * Unable to process the search operation in the task backend because there is no recurring task associated with the provided search base entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_SEARCH_NO_SUCH_RECURRING_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_SEARCH_NO_SUCH_RECURRING_TASK_170", 170);

    /**
     * Unable to initialize the "%s" backend because the provided configuration entry is null
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_CONFIG_ENTRY_NULL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CONFIG_ENTRY_NULL_171", 171);

    /**
     * Requested entry %s does not exist in the backup backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_INVALID_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_INVALID_BASE_176", 176);

    /**
     * Unable to retrieve entry %s from the backup backend because the requested DN is one level below the base DN but does not specify a backup directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_DN_DOES_NOT_SPECIFY_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_DN_DOES_NOT_SPECIFY_DIRECTORY_177", 177);

    /**
     * Unable to retrieve entry %s from the backup backend because the requested backup directory is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_INVALID_BACKUP_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_INVALID_BACKUP_DIRECTORY_178", 178);

    /**
     * An error occurred while attempting to examine the requested backup directory:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_ERROR_GETTING_BACKUP_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_ERROR_GETTING_BACKUP_DIRECTORY_179", 179);

    /**
     * Unable to retrieve entry %s from the backup backend because the requested DN is two levels below the base DN but does not specify a backup ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_NO_BACKUP_ID_IN_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_NO_BACKUP_ID_IN_DN_180", 180);

    /**
     * Unable to retrieve entry %s from the backup backend because it does not have a parent
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_NO_BACKUP_PARENT_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_NO_BACKUP_PARENT_DN_181", 181);

    /**
     * Unable to retrieve entry %s from the backup backend because the DN does not contain the backup directory in which the requested backup should reside
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_NO_BACKUP_DIR_IN_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_NO_BACKUP_DIR_IN_DN_182", 182);

    /**
     * Backup %s does not exist in backup directory %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_NO_SUCH_BACKUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_NO_SUCH_BACKUP_183", 183);

    /**
     * Unwilling to update entry "%s" because modify operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_MODIFY_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_MODIFY_NOT_SUPPORTED_186", 186);

    /**
     * The requested entry %s does not exist in the backup backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_NO_SUCH_ENTRY_188", 188);

    /**
     * Exactly one base DN must be provided for use with the memory-based backend
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MEMORYBACKEND_REQUIRE_EXACTLY_ONE_BASE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_REQUIRE_EXACTLY_ONE_BASE_192", 192);

    /**
     * Entry %s already exists in the memory-based backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_ENTRY_ALREADY_EXISTS_193", 193);

    /**
     * Entry %s does not belong in the memory-based backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_ENTRY_DOESNT_BELONG =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_ENTRY_DOESNT_BELONG_194", 194);

    /**
     * Unable to add entry %s because its parent entry %s does not exist in the memory-based backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MEMORYBACKEND_PARENT_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_PARENT_DOESNT_EXIST_195", 195);

    /**
     * Entry %s does not exist in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_ENTRY_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_ENTRY_DOESNT_EXIST_196", 196);

    /**
     * Cannot delete entry %s because it has one or more subordinate entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_CANNOT_DELETE_ENTRY_WITH_CHILDREN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_DELETE_ENTRY_WITH_CHILDREN_197", 197);

    /**
     * Unable to create an LDIF writer:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_CANNOT_CREATE_LDIF_WRITER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_CREATE_LDIF_WRITER_199", 199);

    /**
     * Cannot write entry %s to LDIF:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MEMORYBACKEND_CANNOT_WRITE_ENTRY_TO_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_WRITE_ENTRY_TO_LDIF_200", 200);

    /**
     * Unable to create an LDIF reader:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_CANNOT_CREATE_LDIF_READER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_CREATE_LDIF_READER_201", 201);

    /**
     * An unrecoverable error occurred while reading from LDIF:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_ERROR_READING_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_ERROR_READING_LDIF_202", 202);

    /**
     * An unexpected error occurred while processing the import:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_ERROR_DURING_IMPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_ERROR_DURING_IMPORT_203", 203);

    /**
     * The memory-based backend does not support backup or restore operations
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MEMORYBACKEND_BACKUP_RESTORE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_BACKUP_RESTORE_NOT_SUPPORTED_204", 204);

    /**
     * Cannot rename entry %s because it has one or more subordinate entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_CANNOT_RENAME_ENRY_WITH_CHILDREN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_RENAME_ENRY_WITH_CHILDREN_205", 205);

    /**
     * Cannot rename entry %s because the target entry is in a different backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MEMORYBACKEND_CANNOT_RENAME_TO_ANOTHER_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_CANNOT_RENAME_TO_ANOTHER_BACKEND_206", 206);

    /**
     * Cannot rename entry %s because the new parent entry %s doesn't exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MEMORYBACKEND_RENAME_PARENT_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MEMORYBACKEND_RENAME_PARENT_DOESNT_EXIST_207", 207);

    /**
     * An error occurred while attempting to register base DN %s in the Directory Server:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_CANNOT_REGISTER_BASEDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CANNOT_REGISTER_BASEDN_210", 210);

    /**
     * The schema backend does not support the %s modification type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_INVALID_MODIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_INVALID_MODIFICATION_TYPE_212", 212);

    /**
     * The schema backend does not support the modification of the %s attribute type.  Only attribute types, object classes, ldap syntaxes, name forms, DIT content rules, DIT structure rules, and matching rule uses may be modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_UNSUPPORTED_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_UNSUPPORTED_ATTRIBUTE_TYPE_213", 213);

    /**
     * An error occurred while attempting to decode the object class "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_OBJECTCLASS_216", 216);

    /**
     * Unable to add objectclass %s because its superior class of %s is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_UNDEFINED_SUPERIOR_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_UNDEFINED_SUPERIOR_OBJECTCLASS_217", 217);

    /**
     * Unable to add objectclass %s because it requires attribute %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OC_UNDEFINED_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OC_UNDEFINED_REQUIRED_ATTR_218", 218);

    /**
     * Unable to add objectclass %s because it allows attribute %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OC_UNDEFINED_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OC_UNDEFINED_OPTIONAL_ATTR_219", 219);

    /**
     * An error occurred while attempting to write the updated schema:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_SCHEMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_SCHEMA_222", 222);

    /**
     * An error occurred while attempting to decode the name form "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_NAME_FORM_223", 223);

    /**
     * An error occurred while attempting to decode the DIT content rule "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_DCR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_DCR_224", 224);

    /**
     * An error occurred while attempting to decode the DIT structure rule "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_DSR_225", 225);

    /**
     * An error occurred while attempting to decode the matching rule use "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_MR_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_MR_USE_226", 226);

    /**
     * The server will not allow removing all values for the %s attribute type in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_DELETE_NO_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DELETE_NO_VALUES_227", 227);

    /**
     * Unable to add attribute type %s because it conflicts with multiple existing attribute types (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_ATTRTYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_ATTRTYPE_228", 228);

    /**
     * Unable to add objectclass %s because it conflicts with multiple existing objectclasses (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_OBJECTCLASS_230", 230);

    /**
     * Unable to add name form %s because it conflicts with multiple existing name forms (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_NAME_FORM_231", 231);

    /**
     * Unable to add name form %s because it references structural objectclass %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_UNDEFINED_STRUCTURAL_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_UNDEFINED_STRUCTURAL_OC_232", 232);

    /**
     * Unable to add name form %s because it references required attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_UNDEFINED_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_UNDEFINED_REQUIRED_ATTR_233", 233);

    /**
     * Unable to add name form %s because it references optional attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_UNDEFINED_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_UNDEFINED_OPTIONAL_ATTR_234", 234);

    /**
     * Unable to add DIT content rule %s because it conflicts with multiple existing DIT content rules (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_DCR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_DCR_235", 235);

    /**
     * Unable to add DIT content rule %s because it references structural objectclass %s which is already associated with another DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_STRUCTURAL_OC_CONFLICT_FOR_ADD_DCR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_STRUCTURAL_OC_CONFLICT_FOR_ADD_DCR_236", 236);

    /**
     * Unable to add DIT content rule %s because it references structural objectclass %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_UNDEFINED_STRUCTURAL_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_UNDEFINED_STRUCTURAL_OC_237", 237);

    /**
     * Unable to add DIT content rule %s because it references auxiliary objectclass %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_UNDEFINED_AUXILIARY_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_UNDEFINED_AUXILIARY_OC_238", 238);

    /**
     * Unable to add DIT content rule %s because it references required attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_UNDEFINED_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_UNDEFINED_REQUIRED_ATTR_239", 239);

    /**
     * Unable to add DIT content rule %s because it references optional attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_UNDEFINED_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_UNDEFINED_OPTIONAL_ATTR_240", 240);

    /**
     * Unable to add DIT content rule %s because it references prohibited attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_UNDEFINED_PROHIBITED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_UNDEFINED_PROHIBITED_ATTR_241", 241);

    /**
     * Unable to add DIT structure rule %s because it conflicts with multiple existing DIT structure rules (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_DSR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_DSR_242", 242);

    /**
     * Unable to add DIT structure rule %s because it references name form %s which is already associated with another DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_NAME_FORM_CONFLICT_FOR_ADD_DSR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NAME_FORM_CONFLICT_FOR_ADD_DSR_243", 243);

    /**
     * Unable to add DIT structure rule %s because it references name form %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DSR_UNDEFINED_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DSR_UNDEFINED_NAME_FORM_244", 244);

    /**
     * Unable to add matching rule use %s because it conflicts with multiple existing matching rule uses (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_MR_USE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_MR_USE_245", 245);

    /**
     * Unable to add matching rule use %s because it references matching rule %s which is already associated with another matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_MODIFY_MR_CONFLICT_FOR_ADD_MR_USE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MR_CONFLICT_FOR_ADD_MR_USE_246", 246);

    /**
     * Unable to add matching rule use %s because it references attribute type %s which is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_MRU_UNDEFINED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MRU_UNDEFINED_ATTR_247", 247);

    /**
     * Circular reference detected for attribute type %s in which the superior type chain references the attribute type itself
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_AT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_AT_248", 248);

    /**
     * Circular reference detected for objectclass %s in which the superior class chain references the objectclass itself
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_OC =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_OC_249", 249);

    /**
     * Circular reference detected for DIT structure rule %s in which the superior rule chain references the DIT structure rule itself
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_DSR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CIRCULAR_REFERENCE_DSR_250", 250);

    /**
     * An error occurred while attempting to create copies of the existing schema files before applying the updates:  %s.  The server was able to restore the original schema configuration, so no additional cleanup should be required
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CANNOT_WRITE_ORIG_FILES_CLEANED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_WRITE_ORIG_FILES_CLEANED_251", 251);

    /**
     * An error occurred while attempting to create copies of the existing schema files before applying the updates:  %s.  A problem also occurred when attempting to restore the original schema configuration, so the server may be left in an inconsistent state and could require manual cleanup
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CANNOT_WRITE_ORIG_FILES_NOT_CLEANED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_WRITE_ORIG_FILES_NOT_CLEANED_252", 252);

    /**
     * An error occurred while attempting to write new versions of the server schema files:  %s.   The server was able to restore the original schema configuration, so no additional cleanup should be required
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_FILES_RESTORED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_FILES_RESTORED_253", 253);

    /**
     * An error occurred while attempting to write new versions of the server schema files: %s.  A problem also occurred when attempting to restore the original schema configuration, so the server may be left in an inconsistent state and could require manual cleanup
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_FILES_NOT_RESTORED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_WRITE_NEW_FILES_NOT_RESTORED_254", 254);

    /**
     * Unable to remove attribute type %s from the server schema because no such attribute type is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_ATTRIBUTE_TYPE_255", 255);

    /**
     * Unable to remove attribute type %s from the server schema because it is referenced as the superior type for attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_AT_SUPERIOR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_AT_SUPERIOR_TYPE_256", 256);

    /**
     * Unable to remove attribute type %s from the server schema because it is referenced as a required or optional attribute type in objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_AT_IN_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_AT_IN_OC_257", 257);

    /**
     * Unable to remove attribute type %s from the server schema because it is referenced as a required or optional attribute type in name form %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_AT_IN_NF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_AT_IN_NF_258", 258);

    /**
     * Unable to remove attribute type %s from the server schema because it is referenced as a required, optional, or prohibited attribute type in DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_AT_IN_DCR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_AT_IN_DCR_259", 259);

    /**
     * Unable to remove attribute type %s from the server schema because it is referenced by matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_AT_IN_MR_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_AT_IN_MR_USE_260", 260);

    /**
     * Unable to remove objectclass %s from the server schema because no such objectclass is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_OBJECTCLASS_261", 261);

    /**
     * Unable to remove objectclass %s from the server schema because it is referenced as the superior class for objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_OC_SUPERIOR_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_OC_SUPERIOR_CLASS_262", 262);

    /**
     * Unable to remove objectclass %s from the server schema because it is referenced as the structural class for name form %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_OC_IN_NF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_OC_IN_NF_263", 263);

    /**
     * Unable to remove objectclass %s from the server schema because it is referenced as a structural or auxiliary class for DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_OC_IN_DCR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_OC_IN_DCR_264", 264);

    /**
     * Unable to remove name form %s from the server schema because no such name form is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_NAME_FORM_265", 265);

    /**
     * Unable to remove name form %s from the server schema because it is referenced by DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_NF_IN_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NF_IN_DSR_266", 266);

    /**
     * Unable to remove DIT content rule %s from the server schema because no such DIT content rule is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_DCR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_DCR_267", 267);

    /**
     * Unable to remove DIT structure rule %s from the server schema because no such DIT structure rule is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_DSR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_DSR_268", 268);

    /**
     * Unable to remove DIT structure rule %s from the server schema because it is referenced as a superior rule for DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_REMOVE_DSR_SUPERIOR_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_DSR_SUPERIOR_RULE_269", 269);

    /**
     * Unable to remove matching rule use %s from the server schema because no such matching rule use is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_MR_USE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_MR_USE_270", 270);

    /**
     * Unable to add name form %s because it references objectclass %s which is defined in the server schema but is not a structural objectclass
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_OC_NOT_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_OC_NOT_STRUCTURAL_271", 271);

    /**
     * Unable to add DIT content rule %s because it references structural objectclass %s which is defined in the server schema but is not structural
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OC_NOT_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OC_NOT_STRUCTURAL_272", 272);

    /**
     * Unable to add attribute type %s because the superior type %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OBSOLETE_SUPERIOR_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OBSOLETE_SUPERIOR_ATTRIBUTE_TYPE_274", 274);

    /**
     * Unable to add attribute type %s because the associated matching rule %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_ATTRTYPE_OBSOLETE_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_ATTRTYPE_OBSOLETE_MR_275", 275);

    /**
     * Unable to add object class %s because the superior class %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OBSOLETE_SUPERIOR_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OBSOLETE_SUPERIOR_OBJECTCLASS_276", 276);

    /**
     * Unable to add object class %s because required attribute %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OC_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OC_OBSOLETE_REQUIRED_ATTR_277", 277);

    /**
     * Unable to add object class %s because optional attribute %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_OC_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_OC_OBSOLETE_OPTIONAL_ATTR_278", 278);

    /**
     * Unable to add name form %s because its structural object class %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_OC_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_OC_OBSOLETE_279", 279);

    /**
     * Unable to add name form %s because it requires attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_OBSOLETE_REQUIRED_ATTR_280", 280);

    /**
     * Unable to add name form %s because it allows attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_NF_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_NF_OBSOLETE_OPTIONAL_ATTR_281", 281);

    /**
     * Unable to add DIT content rule %s because its structural object class %s is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_STRUCTURAL_OC_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_STRUCTURAL_OC_OBSOLETE_282", 282);

    /**
     * Unable to add DIT content rule %s because it references auxiliary object class %s which is defined in the server schema but is not an auxiliary class
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OC_NOT_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OC_NOT_AUXILIARY_283", 283);

    /**
     * Unable to add DIT content rule %s because it requires attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OBSOLETE_REQUIRED_ATTR_285", 285);

    /**
     * Unable to add DIT content rule %s because it allows attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OBSOLETE_OPTIONAL_ATTR_286", 286);

    /**
     * Unable to add DIT content rule %s because it prohibits attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OBSOLETE_PROHIBITED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OBSOLETE_PROHIBITED_ATTR_287", 287);

    /**
     * Unable to add DIT structure rule %s because its name form %s is marked OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DSR_OBSOLETE_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DSR_OBSOLETE_NAME_FORM_288", 288);

    /**
     * Unable to add DIT structure rule %s because it references superior rule %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DSR_OBSOLETE_SUPERIOR_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DSR_OBSOLETE_SUPERIOR_RULE_289", 289);

    /**
     * Unable to add matching rule use %s because its matching rule %s is marked OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_MRU_OBSOLETE_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MRU_OBSOLETE_MR_290", 290);

    /**
     * Unable to add matching rule use %s because it references attribute type %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_MRU_OBSOLETE_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MRU_OBSOLETE_ATTR_291", 291);

    /**
     * Unable to add DIT content rule %s because it references auxiliary object class %s which is marked as OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_DCR_OBSOLETE_AUXILIARY_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_DCR_OBSOLETE_AUXILIARY_OC_292", 292);

    /**
     * You do not have sufficient privileges to modify the Directory Server schema
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SCHEMA_MODIFY_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_INSUFFICIENT_PRIVILEGES_293", 293);

    /**
     * Unable to find a file containing concatenated schema element definitions in order to determine if any schema changes were made with the server offline.  The file was expected in the %s directory and should have been named either %s or %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CANNOT_FIND_CONCAT_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CANNOT_FIND_CONCAT_FILE_294", 294);

    /**
     * An error occurred while attempting to determine whether any schema changes had been made by directly editing the schema files with the server offline:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_ERROR_DETERMINING_SCHEMA_CHANGES =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_ERROR_DETERMINING_SCHEMA_CHANGES_295", 295);

    /**
     * An error occurred while attempting to write file %s containing a concatenated list of all server schema elements:  %s.  The server may not be able to accurately identify any schema changes made with the server offline
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_CANNOT_WRITE_CONCAT_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_CANNOT_WRITE_CONCAT_SCHEMA_FILE_296", 296);

    /**
     * The Directory Server is not configured to allow task %s to be invoked
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKSCHED_NOT_ALLOWED_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_NOT_ALLOWED_TASK_298", 298);

    /**
     * Task ID:  %s
     * Task State:  %s
     * Scheduled Start Time:  %s
     * Actual Start Time:  %s
     * Completion Time:  %s
     * 
     * Log Messages:
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> INFO_TASK_COMPLETION_BODY =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(BackendMessages.class, RESOURCE, "INFO_TASK_COMPLETION_BODY_299", 299);

    /**
     * Requested entry %s does not exist in the trust store backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTSTORE_INVALID_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_INVALID_BASE_301", 301);

    /**
     * Unable to process entry %s in the trust store backend because the requested DN is one level below the base DN but does not specify a certificate name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTSTORE_DN_DOES_NOT_SPECIFY_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_DN_DOES_NOT_SPECIFY_CERTIFICATE_302", 302);

    /**
     * Error while trying to retrieve certificate %s from the trust store file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_CANNOT_RETRIEVE_CERT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_RETRIEVE_CERT_303", 303);

    /**
     * Indexes are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INDEXES_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_INDEXES_NOT_SUPPORTED_305", 305);

    /**
     * Unable to initialize the trust store backend from configuration entry %s because it does not contain exactly one base DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTSTORE_REQUIRES_ONE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_REQUIRES_ONE_BASE_DN_306", 306);

    /**
     * LDIF import and export operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_IMPORT_AND_EXPORT_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_IMPORT_AND_EXPORT_NOT_SUPPORTED_307", 307);

    /**
     * Backup and restore operations are not supported in the "%s" backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_BACKUP_AND_RESTORE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_BACKUP_AND_RESTORE_NOT_SUPPORTED_308", 308);

    /**
     * The trust store file %s specified in attribute ds-cfg-trust-store-file of configuration entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_NO_SUCH_FILE_309", 309);

    /**
     * The trust store type %s specified in attribute ds-cfg-trust-store-type of configuration entry %s is not valid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_INVALID_TYPE_310", 310);

    /**
     * An error occurred while trying to create the PIN file %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_PIN_FILE_CANNOT_CREATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_PIN_FILE_CANNOT_CREATE_311", 311);

    /**
     * An error occurred while trying to read the trust store PIN from file %s specified in configuration attribute ds-cfg-trust-store-pin-file of configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_PIN_FILE_CANNOT_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_PIN_FILE_CANNOT_READ_312", 312);

    /**
     * File %s specified in attribute ds-cfg-trust-store-pin-file of configuration entry %s should contain the PIN needed to access the trust store, but this file is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_PIN_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_PIN_FILE_EMPTY_313", 313);

    /**
     * Environment variable %s which is specified in attribute ds-cfg-trust-store-pin-environment-variable of configuration entry %s should contain the PIN needed to access the trust store, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_PIN_ENVAR_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_PIN_ENVAR_NOT_SET_314", 314);

    /**
     * Java property %s which is specified in attribute ds-cfg-trust-store-pin-property of configuration entry %s should contain the PIN needed to access the file-based trust manager, but this property is not set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_PIN_PROPERTY_NOT_SET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_PIN_PROPERTY_NOT_SET_315", 315);

    /**
     * An unexpected error occurred while trying to determine the value of configuration attribute ds-cfg-trust-store-file in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_CANNOT_DETERMINE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_DETERMINE_FILE_316", 316);

    /**
     * An error occurred while trying to load the trust store contents from file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_CANNOT_LOAD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_LOAD_317", 317);

    /**
     * An error occurred while trying to create a trust manager factory to access the contents of trust store file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_CANNOT_CREATE_FACTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_CREATE_FACTORY_318", 318);

    /**
     * The certificate entry %s already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTSTORE_ALIAS_IN_USE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ALIAS_IN_USE_319", 319);

    /**
     * Error while attempting to generate a self-signed certificate %s in the trust store file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_CANNOT_GENERATE_CERT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_GENERATE_CERT_320", 320);

    /**
     * Error while trying to add certificate %s to the trust store file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_CANNOT_ADD_CERT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_ADD_CERT_321", 321);

    /**
     * The entry %s could not be added because it does not contain a certificate attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_ENTRY_MISSING_CERT_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ENTRY_MISSING_CERT_ATTR_323", 323);

    /**
     * The entry %s could not be added because it contains multiple certificate attributes %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_ENTRY_HAS_MULTIPLE_CERT_ATTRS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ENTRY_HAS_MULTIPLE_CERT_ATTRS_324", 324);

    /**
     * The entry %s could not be added because it does not contain a value of certificate attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_ENTRY_MISSING_CERT_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ENTRY_MISSING_CERT_VALUE_325", 325);

    /**
     * The entry %s could not be added because it contains multiple values of certificate attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_ENTRY_HAS_MULTIPLE_CERT_VALUES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ENTRY_HAS_MULTIPLE_CERT_VALUES_326", 326);

    /**
     * Error while writing certificate %s to a file: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_CANNOT_WRITE_CERT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_WRITE_CERT_327", 327);

    /**
     * Failed to set permissions on trust store file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_TRUSTSTORE_SET_PERMISSIONS_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_TRUSTSTORE_SET_PERMISSIONS_FAILED_328", 328);

    /**
     * The root container for backend %s has not been initialized preventing this backend from processing the requested operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ROOT_CONTAINER_NOT_INITIALIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ROOT_CONTAINER_NOT_INITIALIZED_329", 329);

    /**
     * Unable to obtain a write lock on entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_CANNOT_LOCK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_CANNOT_LOCK_ENTRY_330", 330);

    /**
     * Entry %s cannot be modified because it does not represent a task entry.  Only task entries may be modified in the task backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_INVALID_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_INVALID_ENTRY_331", 331);

    /**
     * Entry %s cannot be modified because it does not represent a valid task in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_NO_SUCH_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_NO_SUCH_TASK_332", 332);

    /**
     * Entry %s cannot be modified because the assoicated task has completed running.  Completed tasks cannot be modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_COMPLETED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_COMPLETED_333", 333);

    /**
     * Entry %s cannot be modified because the server does not currently support modifying recurring task entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_RECURRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_RECURRING_334", 334);

    /**
     * The task associated with entry %s is currently running.  The only modification allowed for running tasks is to replace the value of the ds-task-state attribute with "cancel"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKBE_MODIFY_RUNNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKBE_MODIFY_RUNNING_335", 335);

    /**
     * Task processing was interrupted by a modify request to cancel the task
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASKBE_RUNNING_TASK_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_TASKBE_RUNNING_TASK_CANCELLED_336", 336);

    /**
     * Error while trying to delete certificate %s from the trust store file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_CANNOT_DELETE_CERT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CANNOT_DELETE_CERT_337", 337);

    /**
     * Unable to retrieve entry %s from the trust store backend because the certificate %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRUSTSTORE_CERTIFICATE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_CERTIFICATE_NOT_FOUND_338", 338);

    /**
     * The LDIF backend defined in configuration entry %s only supports a single base DN, but was configured for use with multiple base DNs
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_MULTIPLE_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MULTIPLE_BASE_DNS_339", 339);

    /**
     * LDIF file %s configured for use with the LDIF backend defined in configuration entry %s has multiple entries with a DN of %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_DUPLICATE_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_DUPLICATE_ENTRY_342", 342);

    /**
     * LDIF file %s configured for use with the LDIF backend defined in configuration entry %s includes entry %s which is not below the base DN defined for that backend
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_ENTRY_OUT_OF_SCOPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ENTRY_OUT_OF_SCOPE_343", 343);

    /**
     * LDIF file %s configured for use with the LDIF backend defined in configuration entry %s contains entry %s but its parent entry has not yet been read
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_MISSING_PARENT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MISSING_PARENT_344", 344);

    /**
     * An error occurred while trying to create file %s to write an updated version of the data for the LDIF backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_ERROR_CREATING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_CREATING_FILE_345", 345);

    /**
     * An error occurred while trying to write updated data to file %s for the LDIF backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_ERROR_WRITING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_WRITING_FILE_346", 346);

    /**
     * An error occurred while attempting to rename file %s to %s while writing updated data for the LDIF backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_LDIF_BACKEND_ERROR_RENAMING_FILE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_RENAMING_FILE_347", 347);

    /**
     * Entry %s already exists in the LDIF backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_ADD_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ADD_ALREADY_EXISTS_348", 348);

    /**
     * The parent for entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_ADD_MISSING_PARENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ADD_MISSING_PARENT_349", 349);

    /**
     * Entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_DELETE_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_DELETE_NO_SUCH_ENTRY_350", 350);

    /**
     * Entry %s has one or more subordinate entries and cannot be deleted until all of its subordinate entries are removed first
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_DELETE_NONLEAF =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_DELETE_NONLEAF_351", 351);

    /**
     * Entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_MODIFY_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MODIFY_NO_SUCH_ENTRY_352", 352);

    /**
     * Source entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_MODDN_NO_SUCH_SOURCE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MODDN_NO_SUCH_SOURCE_ENTRY_353", 353);

    /**
     * Target entry %s already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_MODDN_TARGET_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MODDN_TARGET_ENTRY_ALREADY_EXISTS_354", 354);

    /**
     * The new parent DN %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_MODDN_NEW_PARENT_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_MODDN_NEW_PARENT_DOESNT_EXIST_355", 355);

    /**
     * Entry %s specified as the search base DN does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_SEARCH_NO_SUCH_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_SEARCH_NO_SUCH_BASE_356", 356);

    /**
     * An error occurred while trying to create the writer for the LDIF export operation:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_WRITER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_WRITER_357", 357);

    /**
     * An error occurred while trying to write entry %s during the LDIF export:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_BACKEND_CANNOT_WRITE_ENTRY_TO_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_CANNOT_WRITE_ENTRY_TO_LDIF_358", 358);

    /**
     * An error occurred while trying to create the reader for the LDIF import operation:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_READER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_CANNOT_CREATE_LDIF_READER_359", 359);

    /**
     * An unrecoverable error occurred while attempting to read data from the import file:  %s.  The LDIF import cannot continue
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_ERROR_READING_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_READING_LDIF_360", 360);

    /**
     * The LDIF backend currently does not provide a backup or restore mechanism.  Use LDIF import and export operations instead
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIF_BACKEND_BACKUP_RESTORE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_BACKUP_RESTORE_NOT_SUPPORTED_361", 361);

    /**
     * The change to the LDIF file path will not take effect until the backend is disabled and re-enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIF_BACKEND_LDIF_FILE_CHANGED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_LDIF_BACKEND_LDIF_FILE_CHANGED_363", 363);

    /**
     * The change to the LDIF backend base DN will not take effect until the backend is disabled and re-enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIF_BACKEND_BASE_DN_CHANGED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_LDIF_BACKEND_BASE_DN_CHANGED_364", 364);

    /**
     * The target entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_HAS_SUBORDINATES_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_HAS_SUBORDINATES_NO_SUCH_ENTRY_365", 365);

    /**
     * The target entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_BACKEND_NUM_SUBORDINATES_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_NUM_SUBORDINATES_NO_SUCH_ENTRY_366", 366);

    /**
     * Error reading key %s from key store %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TRUSTSTORE_ERROR_READING_KEY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_TRUSTSTORE_ERROR_READING_KEY_367", 367);

    /**
     * This backend does not provide support for the hasSubordinates operational attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_HAS_SUBORDINATES_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_HAS_SUBORDINATES_NOT_SUPPORTED_368", 368);

    /**
     * This backend does not provide support for the numSubordinates operational attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NUM_SUBORDINATES_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_NUM_SUBORDINATES_NOT_SUPPORTED_369", 369);

    /**
     * The backend %s is now taken offline
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BACKEND_OFFLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_BACKEND_OFFLINE_370", 370);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid number of tokens
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_N_TOKENS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_N_TOKENS_371", 371);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid minute token
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_MINUTE_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_MINUTE_TOKEN_372", 372);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid hour token
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_HOUR_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_HOUR_TOKEN_373", 373);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid day of the month token
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_DAY_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_DAY_TOKEN_374", 374);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid month of the year token
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_MONTH_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_MONTH_TOKEN_375", 375);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid day of the week token
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_WEEKDAY_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_WEEKDAY_TOKEN_376", 376);

    /**
     * The provided recurring task entry attribute %s holding the recurring task schedule has invalid tokens combination yielding a nonexistent calendar date
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RECURRINGTASK_INVALID_TOKENS_COMBO =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_TOKENS_COMBO_377", 377);

    /**
     * An error occurred while attempting to export task backend data:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASKS_CANNOT_EXPORT_TO_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_TASKS_CANNOT_EXPORT_TO_FILE_378", 378);

    /**
     * The information for backup %s could not be found in the backup directory %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_MISSING_BACKUPID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKUP_MISSING_BACKUPID_407", 407);

    /**
     * Unable to add DIT structure rule %s because its rule identifier conflicts with existing DIT structure rule (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_RULEID_CONFLICTS_FOR_ADD_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_RULEID_CONFLICTS_FOR_ADD_DSR_409", 409);

    /**
     * JE backend '%s' does not specify the number of cleaner threads: defaulting to %d threads
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_ERGONOMIC_SIZING_OF_JE_CLEANER_THREADS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(BackendMessages.class, RESOURCE, "INFO_ERGONOMIC_SIZING_OF_JE_CLEANER_THREADS_410", 410);

    /**
     * JE backend '%s' does not specify the number of lock tables: defaulting to %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_ERGONOMIC_SIZING_OF_JE_LOCK_TABLES =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(BackendMessages.class, RESOURCE, "INFO_ERGONOMIC_SIZING_OF_JE_LOCK_TABLES_411", 411);

    /**
     * Unable to schedule task %s because its dependency task %s is missing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASKSCHED_DEPENDENCY_MISSING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_TASKSCHED_DEPENDENCY_MISSING_412", 412);

    /**
     * %s task %s started execution
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_TASK_STARTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "NOTE_TASK_STARTED_413", 413);

    /**
     * %s task %s finished execution in the state %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_TASK_FINISHED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "NOTE_TASK_FINISHED_414", 414);

    /**
     * Unable to add ldap syntax description with OID %s because it conflicts with an existing ldap syntax description
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_LDAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_MULTIPLE_CONFLICTS_FOR_ADD_LDAP_SYNTAX_415", 415);

    /**
     * Unable to remove ldap syntax description %s from the server schema because no such ldap syntax description  is defined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_LSD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_REMOVE_NO_SUCH_LSD_416", 416);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax because its OID %s corresponds to an attribute syntax that is already implemented
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_INVALID_LDAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_INVALID_LDAP_SYNTAX_417", 417);

    /**
     * An error occurred while attempting to decode the ldapsyntax description "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_MODIFY_CANNOT_DECODE_LDAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_MODIFY_CANNOT_DECODE_LDAP_SYNTAX_418", 418);

    /**
     * The provided recurring task schedule value has an invalid number of tokens
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_N_TOKENS_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_N_TOKENS_SIMPLE_419", 419);

    /**
     * The provided recurring task schedule value has an invalid minute token
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_MINUTE_TOKEN_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_MINUTE_TOKEN_SIMPLE_420", 420);

    /**
     * The provided recurring task schedule value has an invalid hour token
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_HOUR_TOKEN_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_HOUR_TOKEN_SIMPLE_421", 421);

    /**
     * The provided recurring task schedule value has an invalid day of the month token
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_DAY_TOKEN_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_DAY_TOKEN_SIMPLE_422", 422);

    /**
     * The provided recurring task schedule value has an invalid month of the year token
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_MONTH_TOKEN_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_MONTH_TOKEN_SIMPLE_423", 423);

    /**
     * The provided recurring task schedule value has an invalid day of the week token
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RECURRINGTASK_INVALID_WEEKDAY_TOKEN_SIMPLE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_RECURRINGTASK_INVALID_WEEKDAY_TOKEN_SIMPLE_424", 424);

    /**
     * The schema backend does not support the Replace modification type for the %s attribute type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_INVALID_REPLACE_MODIFICATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_INVALID_REPLACE_MODIFICATION_425", 425);

    /**
     * An error occurred while trying to close file %s for the LDIF backend defined in configuration entry %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_BACKEND_ERROR_CLOSING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_CLOSING_FILE_426", 426);

    /**
     * The file %s written for the LDIF backend defined in configuration entry %s is 0 bytes long and unusable.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_BACKEND_ERROR_EMPTY_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_LDIF_BACKEND_ERROR_EMPTY_FILE_427", 427);

    /**
     * Configuration attribute ds-cfg-db-cache-size has a value of %d but the JVM has only %d available. Consider using ds-cfg-db-cache-percent
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_BACKEND_CONFIG_CACHE_SIZE_GREATER_THAN_JVM_HEAP =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CONFIG_CACHE_SIZE_GREATER_THAN_JVM_HEAP_428", 428);

    /**
     * Configuration attribute ds-cfg-db-cache-percent has a value of %d%% but the JVM has only %d%% available
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_BACKEND_CONFIG_CACHE_PERCENT_GREATER_THAN_JVM_HEAP =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CONFIG_CACHE_PERCENT_GREATER_THAN_JVM_HEAP_429", 429);

    /**
     * Unable to process the virtual list view request because the target assertion could not be decoded as a valid value for the '%s' attribute type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VLV_BAD_ASSERTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_VLV_BAD_ASSERTION_430", 430);

    /**
     * Disk free space of %d bytes for directory %s is now below low threshold of %d bytes. Backend %s is now locked down and will no longer accept any operations from clients until sufficient disk space is restored
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> WARN_DISK_SPACE_LOW_THRESHOLD_CROSSED =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(BackendMessages.class, RESOURCE, "WARN_DISK_SPACE_LOW_THRESHOLD_CROSSED_431", 431);

    /**
     * Disk free space of %d bytes for directory %s is now below disk low threshold of %d bytes. Backend %s is now offline and will no longer accept any operations until sufficient disk space is restored
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> WARN_DISK_SPACE_FULL_THRESHOLD_CROSSED =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(BackendMessages.class, RESOURCE, "WARN_DISK_SPACE_FULL_THRESHOLD_CROSSED_432", 432);

    /**
     * An error occurred while trying to list the files to backup for backend '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_LIST_FILES_TO_BACKUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_LIST_FILES_TO_BACKUP_433", 433);

    /**
     * An error occurred while trying to switch to append mode for backend '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_SWITCH_TO_APPEND_MODE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_SWITCH_TO_APPEND_MODE_434", 434);

    /**
     * An error occurred while trying to end append mode for backend '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_END_APPEND_MODE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_END_APPEND_MODE_435", 435);

    /**
     * Insufficient free memory (%d bytes) to perform import. At least %d bytes of free memory is required
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_IMPORT_LDIF_LACK_MEM =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "ERR_IMPORT_LDIF_LACK_MEM_438", 438);

    /**
     * The attribute '%s' cannot have indexing of type '%s' because it does not have a corresponding matching rule
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_INDEX_TYPE_NEEDS_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_CONFIG_INDEX_TYPE_NEEDS_MATCHING_RULE_440", 440);

    /**
     * Unable to process the virtual list view request because the target start position was before the beginning of the result set
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENTRYIDSORTER_NEGATIVE_START_POS =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_ENTRYIDSORTER_NEGATIVE_START_POS_441", 441);

    /**
     * The entry database does not contain a record for ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MISSING_ID2ENTRY_RECORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MISSING_ID2ENTRY_RECORD_443", 443);

    /**
     * Unable to examine the entry with ID %s for sorting purposes: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRYIDSORTER_CANNOT_EXAMINE_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_ENTRYIDSORTER_CANNOT_EXAMINE_ENTRY_444", 444);

    /**
     * Execution error during backend operation: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXECUTION_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_EXECUTION_ERROR_445", 445);

    /**
     * Interrupted error during backend operation: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INTERRUPTED_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_INTERRUPTED_ERROR_446", 446);

    /**
     * The backend database directory could not be created: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATE_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_CREATE_FAIL_447", 447);

    /**
     * This platform does not support setting file permissions %s to the database directory %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_UNABLE_SET_PERMISSIONS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "WARN_UNABLE_SET_PERMISSIONS_448", 448);

    /**
     * An error occurred while setting file permissions for the backend database directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_SET_PERMISSIONS_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "WARN_SET_PERMISSIONS_FAILED_449", 449);

    /**
     * The change to the DB directory will not take effect until the backend is restarted. The DB files from the previous directory %s must be moved to the new directory %s after shutting down the backend to retain the existing data
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_CONFIG_DB_DIR_REQUIRES_RESTART =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "NOTE_CONFIG_DB_DIR_REQUIRES_RESTART_450", 450);

    /**
     * The backend database directory '%s' is not a valid directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRECTORY_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_DIRECTORY_INVALID_451", 451);

    /**
     * PDB backend '%s' initialized to use %d buffers of %d bytes (total %dkb)
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number> NOTE_PDB_MEMORY_CFG =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_PDB_MEMORY_CFG_452", 452);

    /**
     * The entry '%s' cannot be added because an entry with that name already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ADD_ENTRY_ALREADY_EXISTS_453", 453);

    /**
     * The entry '%s' cannot be added because its parent entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ADD_NO_SUCH_OBJECT_454", 454);

    /**
     * There is no index configured for attribute type '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_INDEX_NOT_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ATTRIBUTE_INDEX_NOT_CONFIGURED_455", 455);

    /**
     * An error occurred while preloading the database cache for backend %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CACHE_PRELOAD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_CACHE_PRELOAD_456", 456);

    /**
     * An error occurred while attempting to decode an attribute description token from the compressed schema definitions: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPSCHEMA_CANNOT_DECODE_AD_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_COMPSCHEMA_CANNOT_DECODE_AD_TOKEN_457", 457);

    /**
     * An error occurred while attempting to decode an object class set token from the compressed schema definitions: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPSCHEMA_CANNOT_DECODE_OC_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_COMPSCHEMA_CANNOT_DECODE_OC_TOKEN_458", 458);

    /**
     * An error occurred while attempting to store compressed schema information in the database: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPSCHEMA_CANNOT_STORE_EX =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_COMPSCHEMA_CANNOT_STORE_EX_459", 459);

    /**
     * An error occurred while parsing the search filter %s defined for VLV index %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_VLV_INDEX_BAD_FILTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_CONFIG_VLV_INDEX_BAD_FILTER_460", 460);

    /**
     * Sort attribute %s for VLV index %s is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_VLV_INDEX_UNDEFINED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_CONFIG_VLV_INDEX_UNDEFINED_ATTR_461", 461);

    /**
     * Database exception: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DATABASE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_DATABASE_EXCEPTION_462", 462);

    /**
     * A plugin caused the delete operation to be aborted while deleting a subordinate entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_ABORTED_BY_SUBORDINATE_PLUGIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_DELETE_ABORTED_BY_SUBORDINATE_PLUGIN_463", 463);

    /**
     * The entry '%s' cannot be removed because it has subordinate entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_NOT_ALLOWED_ON_NONLEAF =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_DELETE_NOT_ALLOWED_ON_NONLEAF_464", 464);

    /**
     * The entry '%s' cannot be removed because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_DELETE_NO_SUCH_OBJECT_465", 465);

    /**
     * An entry container named '%s' is alreadly registered for base DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_CONTAINER_ALREADY_REGISTERED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_ENTRY_CONTAINER_ALREADY_REGISTERED_466", 466);

    /**
     * The entry database does not contain a valid record for ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_DATABASE_CORRUPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_ENTRY_DATABASE_CORRUPT_467", 467);

    /**
     * I/O error occurred while exporting entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXPORT_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_EXPORT_IO_ERROR_468", 468);

    /**
     * The backend must be disabled before the import process can start
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_IMPORT_BACKEND_ONLINE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_IMPORT_BACKEND_ONLINE_469", 469);

    /**
     * Unable to create the temporary directory %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_IMPORT_CREATE_TMPDIR_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_IMPORT_CREATE_TMPDIR_ERROR_471", 471);

    /**
     * The import has been aborted because the entry '%s' does not have a parent entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_IMPORT_PARENT_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_IMPORT_PARENT_NOT_FOUND_481", 481);

    /**
     * Entry record is not compatible with this version of the backend database. Entry version: %x
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_INCOMPATIBLE_ENTRY_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "ERR_INCOMPATIBLE_ENTRY_VERSION_482", 482);

    /**
     * An error occurred while reading from index %s. The index seems to be corrupt and is now operating in a degraded state. The index must be rebuilt before it can return to normal operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INDEX_CORRUPT_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_INDEX_CORRUPT_REQUIRES_REBUILD_483", 483);

    /**
     * The following paged results control cookie value was not recognized: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_PAGED_RESULTS_COOKIE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_INVALID_PAGED_RESULTS_COOKIE_484", 484);

    /**
     * A plugin caused the modify DN operation to be aborted while moving and/or renaming an entry from %s to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFYDN_ABORTED_BY_SUBORDINATE_PLUGIN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_MODIFYDN_ABORTED_BY_SUBORDINATE_PLUGIN_487", 487);

    /**
     * A plugin caused the modify DN operation to be aborted while moving and/or renaming an entry from %s to %s because the change to that entry violated the server schema configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFYDN_ABORTED_BY_SUBORDINATE_SCHEMA_ERROR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "ERR_MODIFYDN_ABORTED_BY_SUBORDINATE_SCHEMA_ERROR_488", 488);

    /**
     * The entry cannot be renamed to '%s' because an entry with that name already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFYDN_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MODIFYDN_ALREADY_EXISTS_489", 489);

    /**
     * The entry '%s' cannot be renamed because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFYDN_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MODIFYDN_NO_SUCH_OBJECT_490", 490);

    /**
     * The entry '%s' cannot be modified because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_MODIFY_NO_SUCH_OBJECT_491", 491);

    /**
     * The entry cannot be moved because the new parent entry '%s' does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NEW_SUPERIOR_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_NEW_SUPERIOR_NO_SUCH_OBJECT_492", 492);

    /**
     * The database environment could not be opened: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPEN_ENV_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_OPEN_ENV_FAIL_493", 493);

    /**
     * Rebuilding system index(es) must be done with the backend containing the base DN disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REBUILD_BACKEND_ONLINE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_REBUILD_BACKEND_ONLINE_494", 494);

    /**
     * The backend database files could not be removed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REMOVE_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_REMOVE_FAIL_495", 495);

    /**
     * The requested search operation included both the simple paged results control and the virtual list view control. These controls are mutually exclusive and cannot be used together
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_CANNOT_MIX_PAGEDRESULTS_AND_VLV =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SEARCH_CANNOT_MIX_PAGEDRESULTS_AND_VLV_496", 496);

    /**
     * The search results cannot be sorted because the given search request is not indexed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_CANNOT_SORT_UNINDEXED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SEARCH_CANNOT_SORT_UNINDEXED_497", 497);

    /**
     * The search base entry '%s' does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SEARCH_NO_SUCH_OBJECT_498", 498);

    /**
     * You do not have sufficient privileges to perform an unindexed search
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_UNINDEXED_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SEARCH_UNINDEXED_INSUFFICIENT_PRIVILEGES_499", 499);

    /**
     * Unchecked exception during database transaction: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNCHECKED_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_UNCHECKED_EXCEPTION_500", 500);

    /**
     * There is no VLV index configured with name '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VLV_INDEX_NOT_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_VLV_INDEX_NOT_CONFIGURED_501", 501);

    /**
     * The filter value exceeded the index entry limit for the %s index
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INDEX_FILTER_INDEX_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_INDEX_FILTER_INDEX_LIMIT_EXCEEDED_502", 502);

    /**
     * %s index is invalid and needs to be rebuilt
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_INDEX_FILTER_INDEX_NOT_TRUSTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "INFO_INDEX_FILTER_INDEX_NOT_TRUSTED_503", 503);

    /**
     * %s index type is disabled for the %s attribute
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INDEX_FILTER_INDEX_TYPE_DISABLED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "INFO_INDEX_FILTER_INDEX_TYPE_DISABLED_504", 504);

    /**
     * Matching rule %s is disabled for the extensible index of the %s attribute
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_INDEX_FILTER_MATCHING_RULE_NOT_INDEXED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "INFO_INDEX_FILTER_MATCHING_RULE_NOT_INDEXED_505", 505);

    /**
     * Average number of entries referenced is %.2f/record
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_VERIFY_AVERAGE_REFERENCE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "INFO_VERIFY_AVERAGE_REFERENCE_COUNT_506", 506);

    /**
     * Free memory = %d MB, Cache miss rate = %.1f/record
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_CACHE_AND_MEMORY_REPORT =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "INFO_CACHE_AND_MEMORY_REPORT_507", 507);

    /**
     * Number of records that exceed the entry limit: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_VERIFY_ENTRY_LIMIT_EXCEEDED_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "INFO_VERIFY_ENTRY_LIMIT_EXCEEDED_COUNT_508", 508);

    /**
     * Statistics for records that have exceeded the entry limit:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VERIFY_ENTRY_LIMIT_STATS_HEADER =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "INFO_VERIFY_ENTRY_LIMIT_STATS_HEADER_509", 509);

    /**
     * File %s has %d such record(s) min=%d max=%d median=%d
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number> INFO_VERIFY_ENTRY_LIMIT_STATS_ROW =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "INFO_VERIFY_ENTRY_LIMIT_STATS_ROW_510", 510);

    /**
     * Maximum number of entries referenced by any record is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_VERIFY_MAX_REFERENCE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "INFO_VERIFY_MAX_REFERENCE_COUNT_511", 511);

    /**
     * Number of records referencing more than one entry: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_VERIFY_MULTIPLE_REFERENCE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "INFO_VERIFY_MULTIPLE_REFERENCE_COUNT_512", 512);

    /**
     * The database backend %s containing %d entries has started
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> NOTE_BACKEND_STARTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(BackendMessages.class, RESOURCE, "NOTE_BACKEND_STARTED_513", 513);

    /**
     * Some index keys have already exceeded the previous index entry limit in index %s. This index must be rebuilt before it can use the new limit
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONFIG_INDEX_ENTRY_LIMIT_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_CONFIG_INDEX_ENTRY_LIMIT_REQUIRES_REBUILD_514", 514);

    /**
     * Exported %d entries and skipped %d in %d seconds (average rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_EXPORT_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_EXPORT_FINAL_STATUS_515", 515);

    /**
     * Exported %d records and skipped %d (recent rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> NOTE_EXPORT_PROGRESS_REPORT =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_EXPORT_PROGRESS_REPORT_516", 516);

    /**
     * Flushing data to disk
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_IMPORT_CLOSING_DATABASE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "NOTE_IMPORT_CLOSING_DATABASE_518", 518);

    /**
     * Processed %d entries, imported %d, skipped %d, rejected %d and migrated %d in %d seconds (average rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Number, Number, Number, Number, Number, Number> NOTE_IMPORT_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg7<Number, Number, Number, Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_FINAL_STATUS_519", 519);

    /**
     * Setting DB cache size to %d bytes and phase one buffer size to %d bytes
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_IMPORT_LDIF_DB_MEM_BUF_INFO =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_DB_MEM_BUF_INFO_520", 520);

    /**
     * Index %s phase two processing completed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_IMPORT_LDIF_INDEX_CLOSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_INDEX_CLOSE_522", 522);

    /**
     * Index %s phase two started processing %d buffers in %d batches
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> NOTE_IMPORT_LDIF_INDEX_STARTED =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_INDEX_STARTED_523", 523);

    /**
     * Index %s %d%% complete: remaining = %d KB, rate = %d KB/s; batch %d/%d
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Number, Number, Number, Number, Number> NOTE_IMPORT_LDIF_PHASE_TWO_REPORT =
                    new LocalizableMessageDescriptor.Arg6<Object, Number, Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_PHASE_TWO_REPORT_525", 525);

    /**
     * Import LDIF environment close took %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_IMPORT_LDIF_ROOTCONTAINER_CLOSE =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_ROOTCONTAINER_CLOSE_526", 526);

    /**
     * The amount of free memory available to the import task is %d bytes. The number of phase one buffers required is %d buffers
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_IMPORT_LDIF_TOT_MEM_BUF =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_TOT_MEM_BUF_528", 528);

    /**
     * Total import time was %d seconds. Phase one processing completed in %d seconds, phase two processing completed in %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> NOTE_IMPORT_PHASE_STATS =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_PHASE_STATS_531", 531);

    /**
     * Processed %d entries, skipped %d and rejected %d (recent rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_IMPORT_PROGRESS_REPORT =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_PROGRESS_REPORT_532", 532);

    /**
     * %s starting import (build %s, R%s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_IMPORT_STARTING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_STARTING_533", 533);

    /**
     * Import Thread Count: %d threads
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_IMPORT_THREAD_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_THREAD_COUNT_534", 534);

    /**
     * Due to changes in the configuration, index %s is currently operating in a degraded state and must be rebuilt before it can be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_INDEX_ADD_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_INDEX_ADD_REQUIRES_REBUILD_535", 535);

    /**
     * This search operation has checked the maximum of %d entries for matches
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_LOOKTHROUGH_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "NOTE_LOOKTHROUGH_LIMIT_EXCEEDED_536", 536);

    /**
     * Rebuild of all indexes started with %d total entries to process
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_REBUILD_ALL_START =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_ALL_START_537", 537);

    /**
     * Degraded state of index(es) %s has been cleared
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_REBUILD_CLEARDEGRADEDSTATE_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_CLEARDEGRADEDSTATE_FINAL_STATUS_538", 538);

    /**
     * Rebuild of all degraded indexes started with %d total entries to process
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_REBUILD_DEGRADED_START =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_DEGRADED_START_539", 539);

    /**
     * Rebuild complete. Processed %d entries in %d seconds (average rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> NOTE_REBUILD_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_FINAL_STATUS_540", 540);

    /**
     * %.1f%% Completed. Processed %d/%d entries. (recent rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_REBUILD_PROGRESS_REPORT =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_PROGRESS_REPORT_541", 541);

    /**
     * Rebuild of index(es) %s started with %d total entries to process
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> NOTE_REBUILD_START =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(BackendMessages.class, RESOURCE, "NOTE_REBUILD_START_542", 542);

    /**
     * A referral entry %s indicates that the operation must be processed at a different server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_REFERRAL_RESULT_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_REFERRAL_RESULT_MESSAGE_543", 543);

    /**
     * Checked %d records and found %d error(s) in %d seconds (average rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_VERIFY_CLEAN_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_VERIFY_CLEAN_FINAL_STATUS_544", 544);

    /**
     * Checked %d entries and found %d error(s) in %d seconds (average rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_VERIFY_FINAL_STATUS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_VERIFY_FINAL_STATUS_545", 545);

    /**
     * Processed %d out of %d records and found %d error(s) (recent rate %.1f/sec)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_VERIFY_PROGRESS_REPORT =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_VERIFY_PROGRESS_REPORT_546", 546);

    /**
     * The requested operation is not supported by this backend
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_FUNCTION_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "WARN_FUNCTION_NOT_SUPPORTED_547", 547);

    /**
     * Unable to determine the total number of entries in the container: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GET_ENTRY_COUNT_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_GET_ENTRY_COUNT_FAILED_548", 548);

    /**
     * Including %s additional log file(s) due to cleaner activity
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JEB_BACKUP_CLEANER_ACTIVITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_JEB_BACKUP_CLEANER_ACTIVITY_557", 557);

    /**
     * The database logging level string '%s' provided for configuration entry '%s' is invalid. The value must be one of OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, or ALL. Note that these values are case sensitive
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_JEB_INVALID_LOGGING_LEVEL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_JEB_INVALID_LOGGING_LEVEL_561", 561);

    /**
     * Configuration attribute ds-cfg-db-cache-size has a value of %d which is less than the minimum: %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_CONFIG_JEB_CACHE_SIZE_TOO_SMALL =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "ERR_CONFIG_JEB_CACHE_SIZE_TOO_SMALL_569", 569);

    /**
     * Configuration attributes ds-cfg-db-txn-no-sync and ds-cfg-db-txn-write-no-sync are mutually exclusive and cannot be both set at the same time
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_JEB_DURABILITY_CONFLICT =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_CONFIG_JEB_DURABILITY_CONFLICT_570", 570);

    /**
     * Could not find any backup in '%s'. A full backup will be executed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BACKUPDB_INCREMENTAL_NOT_FOUND_DOING_NORMAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "WARN_BACKUPDB_INCREMENTAL_NOT_FOUND_DOING_NORMAL_578", 578);

    /**
     * The backend must be disabled before verification process can start
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_VERIFY_BACKEND_ONLINE =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_VERIFY_BACKEND_ONLINE_579", 579);

    /**
     * Missing ID %d%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_VERIFY_MISSING_ID =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_MISSING_ID_583", 583);

    /**
     * Missing entry %s in VLV index %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFY_MISSING_ENTRY_VLV =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_MISSING_ENTRY_VLV_584", 584);

    /**
     * Reference to unknown entry ID %s%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFY_UNKNOWN_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_UNKNOWN_ID_585", 585);

    /**
     * Reference to entry ID %s has a key which does not match the expected key%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFY_ENTRY_NON_MATCHING_KEY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_ENTRY_NON_MATCHING_KEY_586", 586);

    /**
     * Empty ID set: %n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VERIFY_EMPTY_IDSET =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_EMPTY_IDSET_587", 587);

    /**
     * Duplicate reference to ID %d%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_VERIFY_DUPLICATE_REFERENCE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_DUPLICATE_REFERENCE_588", 588);

    /**
     * Reference to unknown ID %d%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_VERIFY_UNKNOWN_REFERENCE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_UNKNOWN_REFERENCE_589", 589);

    /**
     * Reference to entry <%s> which does not match the value%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFY_UNEXPECTED_REFERENCE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_UNEXPECTED_REFERENCE_590", 590);

    /**
     * File dn2id is missing key %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_VERIFY_DN2ID_MISSING_KEY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_DN2ID_MISSING_KEY_591", 591);

    /**
     * File dn2id has ID %d instead of %d for key %s.
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_VERIFY_DN2ID_WRONG_ID =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_DN2ID_WRONG_ID_592", 592);

    /**
     * File dn2id has DN <%s> referencing unknown ID %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_VERIFY_DN2ID_UNKNOWN_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(BackendMessages.class, RESOURCE, "ERR_VERIFY_DN2ID_UNKNOWN_ID_593", 593);

    /**
     * File dn2id has DN <%s> referencing entry with wrong DN <%s>.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VERIFY_DN2ID_WRONG_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_VERIFY_DN2ID_WRONG_ENTRY_594", 594);

    /**
     * The stored entry count in id2entry (%d) does not agree with the actual number of entry records found (%d).
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_VERIFY_WRONG_ENTRY_COUNT =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(BackendMessages.class, RESOURCE, "ERR_VERIFY_WRONG_ENTRY_COUNT_595", 595);

    /**
     * File id2childrenCount has wrong number of children for DN <%s> (got %d, expecting %d)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_VERIFY_ID2COUNT_WRONG_COUNT =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(BackendMessages.class, RESOURCE, "ERR_VERIFY_ID2COUNT_WRONG_COUNT_596", 596);

    /**
     * File id2ChildrenCount references non-existing EntryID <%d>.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_VERIFY_ID2COUNT_WRONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Number>(BackendMessages.class, RESOURCE, "ERR_VERIFY_ID2COUNT_WRONG_ID_597", 597);

    /**
     * Rebuilding index finished: no indexes to rebuild.
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_REBUILD_NOTHING_TO_REBUILD =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "NOTE_REBUILD_NOTHING_TO_REBUILD_598", 598);

    /**
     * Setting DB cache size to %d MB. Using %d mb off-heap memory through %d phase one buffers of %d KB.
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_IMPORT_LDIF_OFFHEAP_MEM_BUF_INFO =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(BackendMessages.class, RESOURCE, "NOTE_IMPORT_LDIF_OFFHEAP_MEM_BUF_INFO_599", 599);

    /**
     * Ignoring schema definition '%s' because the following error occurred while it was being parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SCHEMA_PARSE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SCHEMA_PARSE_LINE_600", 600);

    /**
     * Schema definition could not be parsed as valid attribute value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SCHEMA_COULD_NOT_PARSE_DEFINITION =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_SCHEMA_COULD_NOT_PARSE_DEFINITION_601", 601);

    /**
     * Attribute %s is set as confidential on a backend whose entries are still cleartext. Enable confidentiality on the backend first
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CLEARTEXT_BACKEND_FOR_INDEX_CONFIDENTIALITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_CLEARTEXT_BACKEND_FOR_INDEX_CONFIDENTIALITY_602", 602);

    /**
     * The attribute '%s' cannot enable confidentiality for keys and values at the same time
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_INDEX_CANNOT_PROTECT_BOTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_CONFIG_INDEX_CANNOT_PROTECT_BOTH_603", 603);

    /**
     * Cannot encode entry for writing on storage: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_ENCODE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_CANNOT_ENCODE_ENTRY_604", 604);

    /**
     * Input stream ended unexpectedly while decoding entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_DECODE_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(BackendMessages.class, RESOURCE, "ERR_CANNOT_DECODE_ENTRY_605", 605);

    /**
     * Confidentiality cannot be disabled on suffix '%s' because the following indexes have confidentiality still enabled: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_CANNOT_CHANGE_CONFIDENTIALITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_CANNOT_CHANGE_CONFIDENTIALITY_606", 606);

    /**
     * Changing confidentiality for index '%s' requires the index to be rebuilt before it can be used again
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONFIG_INDEX_CONFIDENTIALITY_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "NOTE_CONFIG_INDEX_CONFIDENTIALITY_REQUIRES_REBUILD_607", 607);

    /**
     * Error while enabling confidentiality with cipher %s, %d bits: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_BACKEND_FAULTY_CRYPTO_TRANSFORMATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(BackendMessages.class, RESOURCE, "ERR_BACKEND_FAULTY_CRYPTO_TRANSFORMATION_608", 608);

    /**
     * The import has been aborted because the data to be imported contains duplicate copies of entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_IMPORT_DUPLICATE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_IMPORT_DUPLICATE_ENTRY_609", 609);

    /**
     * Unwilling to perform a search (connection ID %d, operation ID %d) with a scope of "%s" in the root DSE backend. Only the BASE scope is supported for the root DSE backend.
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ROOTDSE_NOT_SUPPORTED_SCOPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(BackendMessages.class, RESOURCE, "ERR_ROOTDSE_NOT_SUPPORTED_SCOPE_610", 610);

    /**
     * An error occurred while adding Service Discovery Mechanism '%s' : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_ADD_MECHANISM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_ADD_MECHANISM_611", 611);

    /**
     * Service Discovery Mechanism '%s' initialization failed : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_INIT_MECHANISM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(BackendMessages.class, RESOURCE, "ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_INIT_MECHANISM_614", 614);

    /**
     * Registering Service Discovery Manager's listener failed : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_LISTENER =
                    new LocalizableMessageDescriptor.Arg1<Object>(BackendMessages.class, RESOURCE, "ERR_SERVICE_DISCOVERY_CONFIG_MANAGER_LISTENER_615", 615);

}
