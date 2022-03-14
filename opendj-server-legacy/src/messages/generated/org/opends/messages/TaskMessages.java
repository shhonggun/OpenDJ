package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.task}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/task.properties} and it should not be manually edited.
 */
public final class TaskMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.task";

    // Prevent instantiation.
    private TaskMessages() {
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
     * The task could not enable a backend: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CANNOT_ENABLE_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_CANNOT_ENABLE_BACKEND_1", 1);

    /**
     * The task could not disable a backend: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_CANNOT_DISABLE_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_CANNOT_DISABLE_BACKEND_2", 2);

    /**
     * The Directory Server shutdown process has been initiated by task %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASK_SHUTDOWN_DEFAULT_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "INFO_TASK_SHUTDOWN_DEFAULT_MESSAGE_3", 3);

    /**
     * The Directory Server shutdown process has been initiated by task %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TASK_SHUTDOWN_CUSTOM_MESSAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "INFO_TASK_SHUTDOWN_CUSTOM_MESSAGE_4", 4);

    /**
     * Unable to add one or more files to the server schema because no schema file names were provided in attribute %s of task entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_ADDSCHEMAFILE_NO_FILENAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_NO_FILENAME_5", 5);

    /**
     * Unable to add one or more files to the server schema because the specified schema file %s does not exist in schema directory %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_ADDSCHEMAFILE_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_NO_SUCH_FILE_6", 6);

    /**
     * Unable to add one or more files to the server schema because an error occurred while attempting to determine whether file %s exists in schema directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TASK_ADDSCHEMAFILE_ERROR_CHECKING_FOR_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_ERROR_CHECKING_FOR_FILE_7", 7);

    /**
     * An error occurred while attempting to load the contents of schema file %s into the server schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_ADDSCHEMAFILE_ERROR_LOADING_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_ERROR_LOADING_SCHEMA_FILE_8", 8);

    /**
     * Unable to add one or more files to the server schema because the server was unable to obtain a write lock on the schema entry %s after multiple attempts
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_ADDSCHEMAFILE_CANNOT_LOCK_SCHEMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_CANNOT_LOCK_SCHEMA_9", 9);

    /**
     * You do not have sufficient privileges to modify the server schema
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_ADDSCHEMAFILE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_INSUFFICIENT_PRIVILEGES_10", 10);

    /**
     * You do not have sufficient privileges to initiate a Directory Server backup
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_BACKUP_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_BACKUP_INSUFFICIENT_PRIVILEGES_11", 11);

    /**
     * You do not have sufficient privileges to initiate a Directory Server restore
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_RESTORE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_RESTORE_INSUFFICIENT_PRIVILEGES_12", 12);

    /**
     * You do not have sufficient privileges to initiate an LDIF import
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_LDIFIMPORT_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_LDIFIMPORT_INSUFFICIENT_PRIVILEGES_13", 13);

    /**
     * You do not have sufficient privileges to initiate an LDIF export
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_LDIFEXPORT_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_LDIFEXPORT_INSUFFICIENT_PRIVILEGES_14", 14);

    /**
     * You do not have sufficient privileges to initiate a Directory Server restart
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_SHUTDOWN_INSUFFICIENT_RESTART_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_SHUTDOWN_INSUFFICIENT_RESTART_PRIVILEGES_15", 15);

    /**
     * You do not have sufficient privileges to initiate a Directory Server shutdown
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_SHUTDOWN_INSUFFICIENT_SHUTDOWN_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_SHUTDOWN_INSUFFICIENT_SHUTDOWN_PRIVILEGES_16", 16);

    /**
     * An error occurred while attempting to notify a synchronization provider of type %s about the schema changes made by the add schema file task: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_ADDSCHEMAFILE_CANNOT_NOTIFY_SYNC_PROVIDER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_CANNOT_NOTIFY_SYNC_PROVIDER_17", 17);

    /**
     * You do not have sufficient privileges to initiate an index rebuild
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_INDEXREBUILD_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_INDEXREBUILD_INSUFFICIENT_PRIVILEGES_18", 18);

    /**
     * Invalid DN provided with the Initialize task
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_INITIALIZE_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_INITIALIZE_INVALID_DN_20", 20);

    /**
     * Only users with the SERVER_LOCKDOWN privilege may place the server in lockdown mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_ENTERLOCKDOWN_NOT_ROOT =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_ENTERLOCKDOWN_NOT_ROOT_21", 21);

    /**
     * Only users with the SERVER_LOCKDOWN privilege connected from a loopback address may place the server in lockdown mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_ENTERLOCKDOWN_NOT_LOOPBACK =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_ENTERLOCKDOWN_NOT_LOOPBACK_22", 22);

    /**
     * Only users with the SERVER_LOCKDOWN privilege may cause the server to leave lockdown mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_LEAVELOCKDOWN_NOT_ROOT =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_LEAVELOCKDOWN_NOT_ROOT_23", 23);

    /**
     * Only users with the SERVER_LOCKDOWN privilege connected from a loopback address may cause the server to leave lockdown mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_LEAVELOCKDOWN_NOT_LOOPBACK =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_LEAVELOCKDOWN_NOT_LOOPBACK_24", 24);

    /**
     * You do not have sufficient privileges to terminate client connections
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_DISCONNECT_NO_PRIVILEGE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_DISCONNECT_NO_PRIVILEGE_25", 25);

    /**
     * Unable to decode value %s as an integer connection ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_DISCONNECT_INVALID_CONN_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_DISCONNECT_INVALID_CONN_ID_26", 26);

    /**
     * Attribute %s must be provided to specify the connection ID for the client to disconnect
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_DISCONNECT_NO_CONN_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_DISCONNECT_NO_CONN_ID_27", 27);

    /**
     * Unable to decode value %s as an indication of whether to notify the client before disconnecting it. The provided value should be either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_DISCONNECT_INVALID_NOTIFY_CLIENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_DISCONNECT_INVALID_NOTIFY_CLIENT_28", 28);

    /**
     * An administrator has terminated this client connection
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_DISCONNECT_GENERIC_MESSAGE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_DISCONNECT_GENERIC_MESSAGE_29", 29);

    /**
     * There is no client connection with connection ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_DISCONNECT_NO_SUCH_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_DISCONNECT_NO_SUCH_CONNECTION_30", 30);

    /**
     * Add Schema File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_ADD_SCHEMA_FILE_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_ADD_SCHEMA_FILE_NAME_32", 32);

    /**
     * Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_BACKUP_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_BACKUP_NAME_33", 33);

    /**
     * Disconnect Client
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_DISCONNECT_CLIENT_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_DISCONNECT_CLIENT_NAME_34", 34);

    /**
     * Lockdown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_ENTER_LOCKDOWN_MODE_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_ENTER_LOCKDOWN_MODE_NAME_35", 35);

    /**
     * Export
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_EXPORT_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_EXPORT_NAME_36", 36);

    /**
     * Import
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_IMPORT_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_IMPORT_NAME_37", 37);

    /**
     * Initialize Backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_INITIALIZE_TARGET_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_INITIALIZE_TARGET_NAME_38", 38);

    /**
     * Initialize From Replica
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_INITIALIZE_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_INITIALIZE_NAME_39", 39);

    /**
     * Leave Lockdown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_LEAVE_LOCKDOWN_MODE_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_LEAVE_LOCKDOWN_MODE_NAME_40", 40);

    /**
     * Rebuild Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_REBUILD_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_REBUILD_NAME_41", 41);

    /**
     * Restore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_RESTORE_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_RESTORE_NAME_42", 42);

    /**
     * Set Generation ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_SET_GENERATION_ID_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_SET_GENERATION_ID_NAME_43", 43);

    /**
     * Shutdown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_SHUTDOWN_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_SHUTDOWN_NAME_44", 44);

    /**
     * Unscheduled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_UNSCHEDULED =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_UNSCHEDULED_45", 45);

    /**
     * Disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_DISABLED_46", 46);

    /**
     * Waiting on start time
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_WAITING_ON_START_TIME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_WAITING_ON_START_TIME_47", 47);

    /**
     * Waiting on dependency
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_WAITING_ON_DEPENDENCY =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_WAITING_ON_DEPENDENCY_48", 48);

    /**
     * Running
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_RUNNING_49", 49);

    /**
     * Completed successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_COMPLETED_SUCCESSFULLY =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_COMPLETED_SUCCESSFULLY_50", 50);

    /**
     * Completed with errors
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_COMPLETED_WITH_ERRORS =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_COMPLETED_WITH_ERRORS_51", 51);

    /**
     * Stopped by shutdown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_STOPPED_BY_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_STOPPED_BY_SHUTDOWN_52", 52);

    /**
     * Stopped by error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_STOPPED_BY_ERROR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_STOPPED_BY_ERROR_53", 53);

    /**
     * Stopped by administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_STOPPED_BY_ADMINISTRATOR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_STOPPED_BY_ADMINISTRATOR_54", 54);

    /**
     * Canceled before starting
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_CANCELED_BEFORE_STARTING =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_CANCELED_BEFORE_STARTING_55", 55);

    /**
     * Backup All
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_BACKUPALL =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_BACKUPALL_56", 56);

    /**
     * Compress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_COMPRESS =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_COMPRESS_57", 57);

    /**
     * Encrypt
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_ENCRYPT =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_ENCRYPT_58", 58);

    /**
     * Hash
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_HASH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_HASH_59", 59);

    /**
     * Incremental
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_INCREMENTAL =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_INCREMENTAL_60", 60);

    /**
     * Sign Hash
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_SIGN_HASH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_SIGN_HASH_61", 61);

    /**
     * Backend ID(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_BACKEND_IDS =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_BACKEND_IDS_62", 62);

    /**
     * Backup Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_BACKUP_DIR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_BACKUP_DIR_63", 63);

    /**
     * Backup ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_BACKUP_ID_64", 64);

    /**
     * Incremental Base ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKUP_ARG_INC_BASE_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_BACKUP_ARG_INC_BASE_ID_65", 65);

    /**
     * LDIF File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_LDIF_FILE_66", 66);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_BACKEND_ID_67", 67);

    /**
     * Append To LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_APPEND_TO_LDIF =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_APPEND_TO_LDIF_68", 68);

    /**
     * Compress LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_COMPRESS_LDIF =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_COMPRESS_LDIF_69", 69);

    /**
     * Encrypt LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_ENCRYPT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_ENCRYPT_LDIF_70", 70);

    /**
     * Sign Hash
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_SIGN_HASH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_SIGN_HASH_71", 71);

    /**
     * Include Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_INCL_ATTR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_INCL_ATTR_72", 72);

    /**
     * Exclude Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_EXCL_ATTR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_EXCL_ATTR_73", 73);

    /**
     * Include Filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_INCL_FILTER =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_INCL_FILTER_74", 74);

    /**
     * Exclude Filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_EXCL_FILTER =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_EXCL_FILTER_75", 75);

    /**
     * Include Branch
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_INCL_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_INCL_BRANCH_76", 76);

    /**
     * Exclude Branch
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_EXCL_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_EXCL_BRANCH_77", 77);

    /**
     * Wrap Column
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EXPORT_ARG_WRAP_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_EXPORT_ARG_WRAP_COLUMN_78", 78);

    /**
     * Backup Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTORE_ARG_BACKUP_DIR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_RESTORE_ARG_BACKUP_DIR_79", 79);

    /**
     * Backup ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTORE_ARG_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_RESTORE_ARG_BACKUP_ID_80", 80);

    /**
     * Verify Only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTORE_ARG_VERIFY_ONLY =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_RESTORE_ARG_VERIFY_ONLY_81", 81);

    /**
     * LDIF File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_LDIF_FILE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_LDIF_FILE_82", 82);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_BACKEND_ID_85", 85);

    /**
     * Include Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_INCL_ATTR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_INCL_ATTR_86", 86);

    /**
     * Exclude Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_EXCL_ATTR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_EXCL_ATTR_87", 87);

    /**
     * Include Filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_INCL_FILTER =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_INCL_FILTER_88", 88);

    /**
     * Exclude Filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_EXCL_FILTER =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_EXCL_FILTER_89", 89);

    /**
     * Include Branch
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_INCL_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_INCL_BRANCH_90", 90);

    /**
     * Exclude Branch
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_EXCL_BRANCH =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_EXCL_BRANCH_91", 91);

    /**
     * Reject File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_REJECT_FILE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_REJECT_FILE_92", 92);

    /**
     * Skip File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_SKIP_FILE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_SKIP_FILE_93", 93);

    /**
     * Overwrite
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_OVERWRITE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_OVERWRITE_94", 94);

    /**
     * Skip Schema Validation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_SKIP_SCHEMA_VALIDATION =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_SKIP_SCHEMA_VALIDATION_95", 95);

    /**
     * Is Compressed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_IS_COMPRESSED =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_IS_COMPRESSED_96", 96);

    /**
     * Is Encrypted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_IS_ENCRYPTED =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_IS_ENCRYPTED_97", 97);

    /**
     * Clear Backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_CLEAR_BACKEND =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_CLEAR_BACKEND_98", 98);

    /**
     * Process
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FAILED_DEPENDENCY_ACTION_PROCESS =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_FAILED_DEPENDENCY_ACTION_PROCESS_99", 99);

    /**
     * Cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FAILED_DEPENDENCY_ACTION_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_FAILED_DEPENDENCY_ACTION_CANCEL_100", 100);

    /**
     * Disable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FAILED_DEPENDENCY_ACTION_DISABLE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_FAILED_DEPENDENCY_ACTION_DISABLE_101", 101);

    /**
     * Task was stopped by an administrator: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASK_STOPPED_BY_ADMIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "INFO_TASK_STOPPED_BY_ADMIN_102", 102);

    /**
     * Invalid generation ID provided with the task
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_INITIALIZE_INVALID_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_INITIALIZE_INVALID_GENERATION_ID_103", 103);

    /**
     * Template File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_TEMPLATE_FILE =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_TEMPLATE_FILE_104", 104);

    /**
     * Random Seed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IMPORT_ARG_RANDOM_SEED =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_IMPORT_ARG_RANDOM_SEED_105", 105);

    /**
     * Unable to connect to the server at %s on port %s. Check this port is an administration port
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_LDAP_FAILED_TO_CONNECT_WRONG_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_LDAP_FAILED_TO_CONNECT_WRONG_PORT_106", 106);

    /**
     * Recurring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_STATE_RECURRING =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_STATE_RECURRING_107", 107);

    /**
     * Index option cannot be specified when the rebuildAll or rebuildDegraded option is used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_INDEXREBUILD_ALL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_INDEXREBUILD_ALL_ERROR_108", 108);

    /**
     * Purge conflicts historical
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_PURGE_CONFLICTS_HIST_NAME =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_PURGE_CONFLICTS_HIST_NAME_109", 109);

    /**
     * Attribute %s has an invalid value. Reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TASK_INVALID_ATTRIBUTE_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(TaskMessages.class, RESOURCE, "ERR_TASK_INVALID_ATTRIBUTE_VALUE_110", 110);

    /**
     * Reset change number index to begin with a given number and change.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_RESET_CHANGE_NUMBER =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "INFO_TASK_RESET_CHANGE_NUMBER_111", 111);

    /**
     * No changelog database was found for baseDN '%s'. Either the baseDN is not replicated or its changelog has not been enabled in this server.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_RESET_CHANGE_NUMBER_CHANGELOG_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_RESET_CHANGE_NUMBER_CHANGELOG_NOT_FOUND_112", 112);

    /**
     * The change number index cannot be reset because this OpenDJ instance does not appear to be a replication server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TASK_RESET_CHANGE_NUMBER_NO_RSES =
                    new LocalizableMessageDescriptor.Arg0(TaskMessages.class, RESOURCE, "ERR_TASK_RESET_CHANGE_NUMBER_NO_RSES_113", 113);

    /**
     * Invalid change number (%d) specified, it must be greater than zero
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_TASK_RESET_CHANGE_NUMBER_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Number>(TaskMessages.class, RESOURCE, "ERR_TASK_RESET_CHANGE_NUMBER_INVALID_114", 114);

    /**
     * Unable to reset the change number index: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_RESET_CHANGE_NUMBER_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_RESET_CHANGE_NUMBER_FAILED_115", 115);

    /**
     * The changes made by the add schema file task failed schema validation: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TASK_ADDSCHEMAFILE_SCHEMA_VALIDATION_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(TaskMessages.class, RESOURCE, "ERR_TASK_ADDSCHEMAFILE_SCHEMA_VALIDATION_ERROR_116", 116);

}
