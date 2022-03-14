package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.core}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/core.properties} and it should not be manually edited.
 */
public final class CoreMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.core";

    // Prevent instantiation.
    private CoreMessages() {
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
     * Abandon requests cannot be canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CANCEL_ABANDON =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_CANCEL_ABANDON_1", 1);

    /**
     * Bind requests cannot be canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CANCEL_BIND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_CANCEL_BIND_2", 2);

    /**
     * Unbind requests cannot be canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CANCEL_UNBIND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_CANCEL_UNBIND_3", 3);

    /**
     * Client Unbind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_UNBIND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_UNBIND_4", 4);

    /**
     * Client Disconnect
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_CLIENT_CLOSURE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_CLIENT_CLOSURE_5", 5);

    /**
     * Client Connection Rejected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_REJECTED_CLIENT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_REJECTED_CLIENT_6", 6);

    /**
     * I/O Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_IO_ERROR_7", 7);

    /**
     * Protocol Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_PROTOCOL_ERROR_8", 8);

    /**
     * Server Shutdown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_SERVER_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_SERVER_SHUTDOWN_9", 9);

    /**
     * Administrative Termination
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_BY_ADMINISTRATOR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_BY_ADMINISTRATOR_10", 10);

    /**
     * Security Problem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_SECURITY_PROBLEM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_SECURITY_PROBLEM_11", 11);

    /**
     * Maximum Request Size Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_MAX_REQUEST_SIZE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_MAX_REQUEST_SIZE_12", 12);

    /**
     * Administrative Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_ADMIN_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_ADMIN_LIMIT_13", 13);

    /**
     * Idle Time Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_IDLE_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_IDLE_TIME_LIMIT_14", 14);

    /**
     * I/O Timeout
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_IO_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_IO_TIMEOUT_15", 15);

    /**
     * Connection Closed by Plugin
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_BY_PLUGIN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_BY_PLUGIN_16", 16);

    /**
     * Unknown Closure Reason
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_OTHER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_OTHER_17", 17);

    /**
     * Success
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SUCCESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SUCCESS_63", 63);

    /**
     * Operations Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OPERATIONS_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OPERATIONS_ERROR_64", 64);

    /**
     * Protocol Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_PROTOCOL_ERROR_65", 65);

    /**
     * Time Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_TIME_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_TIME_LIMIT_EXCEEDED_66", 66);

    /**
     * Size Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SIZE_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SIZE_LIMIT_EXCEEDED_67", 67);

    /**
     * Compare False
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_COMPARE_FALSE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_COMPARE_FALSE_68", 68);

    /**
     * Compare True
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_COMPARE_TRUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_COMPARE_TRUE_69", 69);

    /**
     * Authentication Method Not Supported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AUTH_METHOD_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AUTH_METHOD_NOT_SUPPORTED_70", 70);

    /**
     * Strong Authentication Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_STRONG_AUTH_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_STRONG_AUTH_REQUIRED_71", 71);

    /**
     * Referral
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_REFERRAL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_REFERRAL_72", 72);

    /**
     * Administrative Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ADMIN_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ADMIN_LIMIT_EXCEEDED_73", 73);

    /**
     * Unavailable Critical Extension
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNAVAILABLE_CRITICAL_EXTENSION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNAVAILABLE_CRITICAL_EXTENSION_74", 74);

    /**
     * Confidentiality Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CONFIDENTIALITY_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CONFIDENTIALITY_REQUIRED_75", 75);

    /**
     * SASL Bind in Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SASL_BIND_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SASL_BIND_IN_PROGRESS_76", 76);

    /**
     * No Such Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_ATTRIBUTE_77", 77);

    /**
     * Undefined Attribute Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNDEFINED_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNDEFINED_ATTRIBUTE_TYPE_78", 78);

    /**
     * Inappropriate Matching
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INAPPROPRIATE_MATCHING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INAPPROPRIATE_MATCHING_79", 79);

    /**
     * Constraint Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CONSTRAINT_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CONSTRAINT_VIOLATION_80", 80);

    /**
     * Attribute or Value Exists
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ATTRIBUTE_OR_VALUE_EXISTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ATTRIBUTE_OR_VALUE_EXISTS_81", 81);

    /**
     * Invalid Attribute Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_ATTRIBUTE_SYNTAX_82", 82);

    /**
     * No Such Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_OBJECT_83", 83);

    /**
     * Alias Problem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ALIAS_PROBLEM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ALIAS_PROBLEM_84", 84);

    /**
     * Invalid DN Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_DN_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_DN_SYNTAX_85", 85);

    /**
     * Alias Dereferencing Problem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ALIAS_DEREFERENCING_PROBLEM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ALIAS_DEREFERENCING_PROBLEM_86", 86);

    /**
     * Inappropriate Authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INAPPROPRIATE_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INAPPROPRIATE_AUTHENTICATION_87", 87);

    /**
     * Invalid Credentials
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_CREDENTIALS_88", 88);

    /**
     * Insufficient Access Rights
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INSUFFICIENT_ACCESS_RIGHTS_89", 89);

    /**
     * Busy
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_BUSY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_BUSY_90", 90);

    /**
     * Unavailable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNAVAILABLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNAVAILABLE_91", 91);

    /**
     * Unwilling to Perform
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNWILLING_TO_PERFORM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNWILLING_TO_PERFORM_92", 92);

    /**
     * Loop Detected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_LOOP_DETECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_LOOP_DETECT_93", 93);

    /**
     * Naming Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NAMING_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NAMING_VIOLATION_94", 94);

    /**
     * Object Class Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OBJECTCLASS_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OBJECTCLASS_VIOLATION_95", 95);

    /**
     * Not Allowed on Non-Leaf
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NOT_ALLOWED_ON_NONLEAF =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NOT_ALLOWED_ON_NONLEAF_96", 96);

    /**
     * Not Allowed on RDN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NOT_ALLOWED_ON_RDN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NOT_ALLOWED_ON_RDN_97", 97);

    /**
     * Entry Already Exists
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ENTRY_ALREADY_EXISTS_98", 98);

    /**
     * Object Class Modifications Prohibited
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OBJECTCLASS_MODS_PROHIBITED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OBJECTCLASS_MODS_PROHIBITED_99", 99);

    /**
     * Affects Multiple DSAs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AFFECTS_MULTIPLE_DSAS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AFFECTS_MULTIPLE_DSAS_100", 100);

    /**
     * Canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CANCELED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CANCELED_101", 101);

    /**
     * No Such Operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_OPERATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_OPERATION_102", 102);

    /**
     * Too Late
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_TOO_LATE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_TOO_LATE_103", 103);

    /**
     * Cannot Cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CANNOT_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CANNOT_CANCEL_104", 104);

    /**
     * Other
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OTHER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OTHER_105", 105);

    /**
     * Processing on this operation has been canceled because the Directory Server is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCELED_BY_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_SHUTDOWN_107", 107);

    /**
     * %s encountered an uncaught exception while processing operation %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_UNCAUGHT_WORKER_THREAD_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_UNCAUGHT_WORKER_THREAD_EXCEPTION_108", 108);

    /**
     * %s is unexpectedly exiting when the Directory Server is not in the process of shutting down. This likely indicates that the thread encountered an unexpected error
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_UNEXPECTED_WORKER_THREAD_EXIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_UNEXPECTED_WORKER_THREAD_EXIT_109", 109);

    /**
     * The request to process this operation has been rejected because the Directory Server has already started its shutdown process
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_OP_REJECTED_BY_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_OP_REJECTED_BY_SHUTDOWN_111", 111);

    /**
     * The request to process this operation has been rejected because the work queue has already reached its maximum capacity of %d pending operations
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_OP_REJECTED_BY_QUEUE_FULL =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "WARN_OP_REJECTED_BY_QUEUE_FULL_112", 112);

    /**
     * %s was interrupted while waiting for new work: %s. This should not happen, but the thread will resume waiting for new work so there should be no adverse effects
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_WORKER_INTERRUPTED_WITHOUT_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_WORKER_INTERRUPTED_WITHOUT_SHUTDOWN_113", 113);

    /**
     * An unexpected exception was caught while %s was waiting for new work: %s. This should not happen, but the thread will resume waiting for new work so there should be no adverse effects
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_WORKER_WAITING_UNCAUGHT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_WORKER_WAITING_UNCAUGHT_EXCEPTION_114", 114);

    /**
     * The work queue caught an exception while trying to cancel pending operation %s when the Directory Server was shutting down: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_QUEUE_UNABLE_TO_CANCEL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_QUEUE_UNABLE_TO_CANCEL_115", 115);

    /**
     * The work queue caught an exception while trying to notify %s that the Directory Server was shutting down: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_QUEUE_UNABLE_TO_NOTIFY_THREAD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_QUEUE_UNABLE_TO_NOTIFY_THREAD_116", 116);

    /**
     * Server Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_SERVER_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_SERVER_ERROR_117", 117);

    /**
     * The Directory Server is currently running. The configuration may not be bootstrapped while the server is online
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_BOOTSTRAP_WHILE_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_BOOTSTRAP_WHILE_RUNNING_118", 118);

    /**
     * Unable to create an instance of class %s to serve as the Directory Server configuration handler: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_INSTANTIATE_CONFIG_HANDLER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_INSTANTIATE_CONFIG_HANDLER_120", 120);

    /**
     * An error occurred while trying to initialize the configuration handler %s using configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CANNOT_INITIALIZE_CONFIG_HANDLER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_CONFIG_HANDLER_121", 121);

    /**
     * The Directory Server may not be started before the configuration has been bootstrapped
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_START_BEFORE_BOOTSTRAP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_START_BEFORE_BOOTSTRAP_122", 122);

    /**
     * The Directory Server may not be started while it is already running.  Please stop the running instance before attempting to start it again
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_START_WHILE_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_START_WHILE_RUNNING_123", 123);

    /**
     * Entry %s violates the Directory Server schema configuration because it is missing attribute %s which is required by objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_MISSING_REQUIRED_ATTR_FOR_OC =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_MISSING_REQUIRED_ATTR_FOR_OC_126", 126);

    /**
     * Entry %s violates the Directory Server schema configuration because it includes attribute %s which is not allowed by any of the objectclasses defined in that entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_DISALLOWED_USER_ATTR_FOR_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DISALLOWED_USER_ATTR_FOR_OC_127", 127);

    /**
     * An error occurred while attempting to bootstrap the attribute syntax defined in class %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_BOOTSTRAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_BOOTSTRAP_SYNTAX_130", 130);

    /**
     * The Directory Server is beginning the configuration bootstrapping process
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DIRECTORY_BOOTSTRAPPING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DIRECTORY_BOOTSTRAPPING_132", 132);

    /**
     * %s (build %s, revision number %s) starting up
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_DIRECTORY_SERVER_STARTING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "NOTE_DIRECTORY_SERVER_STARTING_134", 134);

    /**
     * The Directory Server has started successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_DIRECTORY_SERVER_STARTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "NOTE_DIRECTORY_SERVER_STARTED_135", 135);

    /**
     * An error occurred while attempting to create the JMX MBean server that will be used for monitoring, notification, and configuration interaction within the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CREATE_MBEAN_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_CREATE_MBEAN_SERVER_138", 138);

    /**
     * The Directory Server has sent an alert notification generated by class %s (alert type %s, alert ID %s): %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> NOTE_SENT_ALERT_NOTIFICATION =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "NOTE_SENT_ALERT_NOTIFICATION_139", 139);

    /**
     * An uncaught exception during processing for thread %s has caused it to terminate abnormally. The stack trace for that exception is: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNCAUGHT_THREAD_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_UNCAUGHT_THREAD_EXCEPTION_140", 140);

    /**
     * The Directory Server has started the shutdown process. The shutdown was initiated by an instance of class %s and the reason provided for the shutdown was %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_SERVER_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "NOTE_SERVER_SHUTDOWN_141", 141);

    /**
     * The Directory Server shutdown hook detected that the JVM is shutting down. This generally indicates that JVM received an external request to stop (e.g., through a kill signal)
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SHUTDOWN_DUE_TO_SHUTDOWN_HOOK =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SHUTDOWN_DUE_TO_SHUTDOWN_HOOK_142", 142);

    /**
     * Unable to decode the provided filter string as a search filter because the provided string was empty or null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_FILTER_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NULL_143", 143);

    /**
     * An unexpected error occurred while attempting to decode the string "%s" as a search filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_UNCAUGHT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_UNCAUGHT_EXCEPTION_144", 144);

    /**
     * The provided search filter "%s" had mismatched parentheses around the portion between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SEARCH_FILTER_MISMATCHED_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_MISMATCHED_PARENTHESES_145", 145);

    /**
     * The provided search filter "%s" was missing an equal sign in the suspected simple filter component between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SEARCH_FILTER_NO_EQUAL_SIGN =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NO_EQUAL_SIGN_146", 146);

    /**
     * The provided search filter "%s" had an invalid escaped byte value at position %d. A backslash in a value must be followed by two hexadecimal characters that define the byte that has been encoded
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SEARCH_FILTER_INVALID_ESCAPED_BYTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_INVALID_ESCAPED_BYTE_147", 147);

    /**
     * The provided search filter "%s" could not be decoded because the compound filter between positions %d and %d did not start with an open parenthesis and end with a close parenthesis (they may be parentheses for different filter components)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SEARCH_FILTER_COMPOUND_MISSING_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_COMPOUND_MISSING_PARENTHESES_148", 148);

    /**
     * The provided search filter "%s" could not be decoded because the closing parenthesis at position %d did not have a corresponding open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SEARCH_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS_149", 149);

    /**
     * The provided search filter "%s" could not be decoded because the opening parenthesis at position %d did not have a corresponding close parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SEARCH_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS_150", 150);

    /**
     * The provided search filter "%s" could not be decoded because the assumed substring filter value between positions %d and %d did not have any asterisk wildcard characters
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SEARCH_FILTER_SUBSTRING_NO_ASTERISKS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_SUBSTRING_NO_ASTERISKS_151", 151);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not have a colon to denote the end of the attribute type name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_COLON_152", 152);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because it contained an unknown filter type %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_INVALID_FILTER_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_INVALID_FILTER_TYPE_153", 153);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because the internal check returned an unknown result type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_INVALID_RESULT_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_INVALID_RESULT_TYPE_154", 154);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because the set of filter components for an %s component was NULL
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_COMPOUND_COMPONENTS_NULL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_COMPOUND_COMPONENTS_NULL_155", 155);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because the filter was nested beyond the maximum allowed depth of 100 levels
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_NESTED_TOO_DEEP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NESTED_TOO_DEEP_156", 156);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because the NOT filter component did not include a subcomponent
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_NOT_COMPONENT_NULL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NOT_COMPONENT_NULL_157", 157);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because an equality component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_EQUALITY_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EQUALITY_NO_ATTRIBUTE_TYPE_158", 158);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because an equality component for attribute %s had a NULL assertion value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_EQUALITY_NO_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EQUALITY_NO_ASSERTION_VALUE_159", 159);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a substring component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_SUBSTRING_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_SUBSTRING_NO_ATTRIBUTE_TYPE_160", 160);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a substring component for attribute %s did not have any subInitial, subAny, or subFinal elements
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_SUBSTRING_NO_SUBSTRING_COMPONENTS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_SUBSTRING_NO_SUBSTRING_COMPONENTS_161", 161);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a greater-or-equal component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_GREATER_OR_EQUAL_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_GREATER_OR_EQUAL_NO_ATTRIBUTE_TYPE_162", 162);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a greater-or-equal component for attribute %s had a NULL assertion value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_GREATER_OR_EQUAL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_GREATER_OR_EQUAL_NO_VALUE_163", 163);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a less-or-equal component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_LESS_OR_EQUAL_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_LESS_OR_EQUAL_NO_ATTRIBUTE_TYPE_164", 164);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a less-or-equal component for attribute %s had a NULL assertion value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_LESS_OR_EQUAL_NO_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_LESS_OR_EQUAL_NO_ASSERTION_VALUE_165", 165);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a presence component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_PRESENCE_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_PRESENCE_NO_ATTRIBUTE_TYPE_166", 166);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because an approximate component had a NULL attribute type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_APPROXIMATE_NO_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_APPROXIMATE_NO_ATTRIBUTE_TYPE_167", 167);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because an approximate component for attribute %s had a NULL assertion value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SEARCH_FILTER_APPROXIMATE_NO_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_APPROXIMATE_NO_ASSERTION_VALUE_168", 168);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a contained extensible match filter did not have an assertion value
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_ASSERTION_VALUE_169", 169);

    /**
     * Unable to determine whether entry "%s" matches filter "%s" because a contained extensible match filter did not have either an attribute type or a matching rule ID
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_RULE_OR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_RULE_OR_TYPE_170", 170);

    /**
     * Unable to decode the provided string as a relative distinguished name because the provided string was empty or null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RDN_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_RDN_DECODE_NULL_171", 171);

    /**
     * Unable to decode the provided string "%s" as a relative distinguished name because the string ended with an attribute type name (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RDN_END_WITH_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_RDN_END_WITH_ATTR_NAME_172", 172);

    /**
     * Unable to decode the provided string "%s" as a relative distinguished name because the first non-blank character after the attribute type %s was not an equal sign (character read was %c)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Character> ERR_RDN_NO_EQUAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Character>(CoreMessages.class, RESOURCE, "ERR_RDN_NO_EQUAL_173", 173);

    /**
     * Unable to decode the provided string "%s" as a relative distinguished name because it contained an unexpected plus, comma, or semicolon at position %d, which is not allowed in an RDN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_RDN_UNEXPECTED_COMMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_RDN_UNEXPECTED_COMMA_174", 174);

    /**
     * Unable to decode the provided string "%s" as a relative distinguished name because an illegal character %c was found at position %d, where either the end of the string or a '+' sign were expected
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_RDN_ILLEGAL_CHARACTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(CoreMessages.class, RESOURCE, "ERR_RDN_ILLEGAL_CHARACTER_175", 175);

    /**
     * An error occurred while trying to retrieve the root DSE configuration entry (cn=Root DSE,cn=config) from the Directory Server configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_GET_ROOT_DSE_CONFIG_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_GET_ROOT_DSE_CONFIG_ENTRY_183", 183);

    /**
     * Unable to register objectclass %s with the server schema because its OID %s conflicts with the OID of an existing objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_OBJECTCLASS_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_OBJECTCLASS_OID_186", 186);

    /**
     * Unable to register objectclass %s with the server schema because its name %s conflicts with the name of an existing objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_OBJECTCLASS_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_OBJECTCLASS_NAME_187", 187);

    /**
     * Unable to register matching rule %s with the server schema because its name %s conflicts with the name of an existing matching rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_MR_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_MR_NAME_190", 190);

    /**
     * Unable to register matching rule use %s with the server schema because its matching rule %s conflicts with the matching rule for an existing matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_MATCHING_RULE_USE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_MATCHING_RULE_USE_191", 191);

    /**
     * Unable to register DIT content rule %s with the server schema because its structural objectclass %s conflicts with the structural objectclass for an existing DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_DIT_CONTENT_RULE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_DIT_CONTENT_RULE_192", 192);

    /**
     * Unable to register DIT structure rule %s with the server schema because its name form %s conflicts with the name form for an existing DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_NAME_FORM_193", 193);

    /**
     * Unable to register DIT structure rule %s with the server schema because its rule ID %d conflicts with the rule ID for an existing DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_ID_194", 194);

    /**
     * Unable to register name form %s with the server schema because its structural objectclass %s conflicts with the structural objectclass for an existing name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_NAME_FORM_OC =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_NAME_FORM_OC_195", 195);

    /**
     * Unable to register name form %s with the server schema because its OID %s conflicts with the OID for an existing name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_NAME_FORM_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_NAME_FORM_OID_196", 196);

    /**
     * Unable to register name form %s with the server schema because its name %s conflicts with the name for an existing name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_NAME_FORM_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_NAME_FORM_NAME_197", 197);

    /**
     * Entry %s violates the Directory Server schema configuration because it includes multiple conflicting structural objectclasses %s and %s. Only a single structural objectclass is allowed in an entry
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_MULTIPLE_STRUCTURAL_CLASSES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_MULTIPLE_STRUCTURAL_CLASSES_198", 198);

    /**
     * Entry %s violates the Directory Server schema configuration because it does not include a structural objectclass. All entries must contain a structural objectclass
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_SCHEMA_NO_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_NO_STRUCTURAL_CLASS_199", 199);

    /**
     * Entry "%s" contains a value "%s" for attribute %s that is invalid according to the syntax for that attribute: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_ADD_OP_INVALID_SYNTAX =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ADD_OP_INVALID_SYNTAX_200", 200);

    /**
     * Entry "%s" does not contain any values for attribute "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_COMPARE_OP_NO_SUCH_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_COMPARE_OP_NO_SUCH_ATTR_201", 201);

    /**
     * Entry "%s" does not contain any values for attribute "%s" with the specified set of options
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_COMPARE_OP_NO_SUCH_ATTR_WITH_OPTIONS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_COMPARE_OP_NO_SUCH_ATTR_WITH_OPTIONS_202", 202);

    /**
     * The Directory Server is now stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_SERVER_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "NOTE_SERVER_STOPPED_203", 203);

    /**
     * %s has been stopped because the total number of worker threads in the Directory Server was reduced
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_WORKER_STOPPED_BY_REDUCED_THREADNUMBER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_WORKER_STOPPED_BY_REDUCED_THREADNUMBER_204", 204);

    /**
     * Entry %s violates the Directory Server schema configuration because it includes multiple values for attribute %s, which is defined as a single-valued attribute
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_ATTR_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_ATTR_SINGLE_VALUED_205", 205);

    /**
     * Entry %s violates the Directory Server schema configuration because its RDN does not contain attribute %s that is required by name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_RDN_MISSING_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_RDN_MISSING_REQUIRED_ATTR_206", 206);

    /**
     * Entry %s violates the Directory Server schema configuration because its RDN contains attribute %s that is not allowed by name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_RDN_DISALLOWED_ATTR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_RDN_DISALLOWED_ATTR_207", 207);

    /**
     * Entry %s violates the Directory Server schema configuration because it is missing attribute %s which is required by DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_MISSING_REQUIRED_ATTR_FOR_DCR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_MISSING_REQUIRED_ATTR_FOR_DCR_208", 208);

    /**
     * Entry %s violates the Directory Server schema configuration because it contains attribute %s which is prohibited by DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_PROHIBITED_ATTR_FOR_DCR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_PROHIBITED_ATTR_FOR_DCR_209", 209);

    /**
     * Entry %s violates the Directory Server schema configuration because it includes auxiliary objectClass %s that is not allowed by DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_DISALLOWED_AUXILIARY_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DISALLOWED_AUXILIARY_CLASS_211", 211);

    /**
     * The Directory Server was unable to evaluate entry %s to determine whether it was compliant with the DIT structure rule configuration because parent entry %s either does not exist or could not be retrieved
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_DSR_NO_PARENT_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_NO_PARENT_ENTRY_213", 213);

    /**
     * The Directory Server was unable to evaluate entry %s to determine whether it was compliant with the DIT rule configuration because the parent entry %s does not appear to contain a valid structural objectclass
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_DSR_NO_PARENT_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_NO_PARENT_OC_214", 214);

    /**
     * Entry %s violates the Directory Server schema configuration because DIT structure rule %s does not allow entries of type %s to be placed immediately below entries of type %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ENTRY_SCHEMA_DSR_DISALLOWED_SUPERIOR_OC =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_DISALLOWED_SUPERIOR_OC_215", 215);

    /**
     * An unexpected error occurred while attempting to check entry %s against DIT structure rule %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_COULD_NOT_CHECK_DSR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_COULD_NOT_CHECK_DSR_216", 216);

    /**
     * Processing on this operation has been canceled because the Directory Server received a bind request on this connection, which requires that all operations in progress to be abandoned
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCELED_BY_BIND_REQUEST =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_BIND_REQUEST_217", 217);

    /**
     * Unable to bind to the Directory Server because no such user exists in the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_UNKNOWN_USER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_UNKNOWN_USER_218", 218);

    /**
     * A fatal error occurred when executing one of the Directory Server startup plugins: %s (error ID %d). The Directory Server startup process has been aborted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_STARTUP_PLUGIN_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_STARTUP_PLUGIN_ERROR_220", 220);

    /**
     * Unable to bind to the Directory Server using simple authentication because that user does not have a password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_NO_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_NO_PASSWORD_221", 221);

    /**
     * Unable to process the bind request because it attempted to use an unknown SASL mechanism %s that is not available in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BIND_OPERATION_UNKNOWN_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_UNKNOWN_SASL_MECHANISM_222", 222);

    /**
     * The specified entry %s does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPARE_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPARE_NO_SUCH_ENTRY_228", 228);

    /**
     * The operation was canceled because the client issued an abandon request (message ID %d) for this operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CANCELED_BY_ABANDON_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_ABANDON_REQUEST_229", 229);

    /**
     * The provided entry cannot be added because it contains a null DN. This DN is reserved for the root DSE, and that entry may not be added over protocol
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADD_CANNOT_ADD_ROOT_DSE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ADD_CANNOT_ADD_ROOT_DSE_230", 230);

    /**
     * The provided entry %s cannot be added because it does not have a parent and is not defined as one of the suffixes within the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_ENTRY_NOT_SUFFIX =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ENTRY_NOT_SUFFIX_231", 231);

    /**
     * Entry %s cannot be added because its parent entry %s does not exist in the server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_NO_PARENT_233", 233);

    /**
     * Entry %s cannot be added because the server failed to obtain a write lock for this entry after multiple attempts
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_CANNOT_LOCK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_CANNOT_LOCK_ENTRY_234", 234);

    /**
     * Entry %s cannot be removed because the server failed to obtain a write lock for this entry after multiple attempts
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_CANNOT_LOCK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_CANNOT_LOCK_ENTRY_235", 235);

    /**
     * The maximum time limit of %d seconds for processing this search operation has expired
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_SEARCH_TIME_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_TIME_LIMIT_EXCEEDED_238", 238);

    /**
     * This search operation has sent the maximum of %d entries to the client
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_SEARCH_SIZE_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_SIZE_LIMIT_EXCEEDED_239", 239);

    /**
     * The entry %s specified as the search base does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_BASE_DOESNT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_BASE_DOESNT_EXIST_240", 240);

    /**
     * Entry %s does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_NO_SUCH_ENTRY_241", 241);

    /**
     * Entry %s cannot be removed because the backend that should contain that entry has a subordinate backend with a base DN of %s that is below the target DN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DELETE_HAS_SUB_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_HAS_SUB_BACKEND_242", 242);

    /**
     * A modify DN operation cannot be performed on entry %s because the new RDN would not have a parent DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NO_PARENT_243", 243);

    /**
     * The modify DN operation for entry %s cannot be performed because no backend is registered to handle that DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_NO_BACKEND_FOR_CURRENT_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NO_BACKEND_FOR_CURRENT_ENTRY_244", 244);

    /**
     * The modify DN operation for entry %s cannot be performed because no backend is registered to handle the new DN %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_NO_BACKEND_FOR_NEW_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NO_BACKEND_FOR_NEW_ENTRY_245", 245);

    /**
     * The modify DN operation for entry %s cannot be performed because the backend holding the current entry is different from the backend used to handle the new DN %s. Modify DN operations may not span multiple backends
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_DIFFERENT_BACKENDS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_DIFFERENT_BACKENDS_246", 246);

    /**
     * The modify DN operation for entry %s cannot be performed because the server was unable to obtain a write lock for that DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_CANNOT_LOCK_CURRENT_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_CANNOT_LOCK_CURRENT_DN_247", 247);

    /**
     * The modify DN operation for entry %s cannot be performed because the server was unable to obtain a write lock for the new DN %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_CANNOT_LOCK_NEW_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_CANNOT_LOCK_NEW_DN_249", 249);

    /**
     * The modify DN operation for entry %s cannot be performed because that entry does not exist in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_NO_CURRENT_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NO_CURRENT_ENTRY_250", 250);

    /**
     * Entry %s cannot be modified because the server failed to obtain a write lock for this entry after multiple attempts
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_CANNOT_LOCK_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_CANNOT_LOCK_ENTRY_251", 251);

    /**
     * Entry %s cannot be modified because no such entry exists in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_SUCH_ENTRY_252", 252);

    /**
     * Entry %s cannot be modified because the modification contained an add component for attribute %s but no values were provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_ADD_NO_VALUES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ADD_NO_VALUES_253", 253);

    /**
     * When attempting to modify entry %s to add one or more values for attribute %s, value "%s" was found to be invalid according to the associated syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_MODIFY_ADD_INVALID_SYNTAX =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ADD_INVALID_SYNTAX_254", 254);

    /**
     * Entry %s cannot be modified because it would have resulted in one or more duplicate values for attribute %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_ADD_DUPLICATE_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ADD_DUPLICATE_VALUE_255", 255);

    /**
     * Entry %s cannot be modified because the change to attribute %s would have removed a value used in the RDN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_DELETE_RDN_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_DELETE_RDN_ATTR_256", 256);

    /**
     * Entry %s cannot be modified because the attempt to update attribute %s would have removed one or more values from the attribute that were not present: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_DELETE_MISSING_VALUES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_DELETE_MISSING_VALUES_257", 257);

    /**
     * Entry %s cannot be modified because an attempt was made to remove one or more values from attribute %s but this attribute is not present in the entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_DELETE_NO_SUCH_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_DELETE_NO_SUCH_ATTR_258", 258);

    /**
     * When attempting to modify entry %s to replace the set of values for attribute %s, value "%s" was found to be invalid according to the associated syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_MODIFY_REPLACE_INVALID_SYNTAX =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_REPLACE_INVALID_SYNTAX_259", 259);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s which is used as an RDN attribute for the entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_INCREMENT_RDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_RDN_260", 260);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s but the request did not include a value for that attribute specifying the amount by which to increment the value
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_INCREMENT_REQUIRES_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_REQUIRES_VALUE_261", 261);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s but the request contained multiple values, where only a single integer value is allowed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_INCREMENT_REQUIRES_SINGLE_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_REQUIRES_SINGLE_VALUE_262", 262);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s but the value "%s" contained in the request could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_INCREMENT_PROVIDED_VALUE_NOT_INTEGER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_PROVIDED_VALUE_NOT_INTEGER_263", 263);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s but that attribute did not have any values in the target entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_INCREMENT_REQUIRES_EXISTING_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_REQUIRES_EXISTING_VALUE_264", 264);

    /**
     * Entry %s cannot be modified because an attempt was made to increment the value of attribute %s but the value "%s" could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_INCREMENT_REQUIRES_INTEGER_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INCREMENT_REQUIRES_INTEGER_VALUE_265", 265);

    /**
     * Entry %s cannot be modified because the resulting entry would have violated the server schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_VIOLATES_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_VIOLATES_SCHEMA_266", 266);

    /**
     * Entry %s cannot be modified because there is no backend registered to handle operations for that entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_NO_BACKEND_FOR_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_BACKEND_FOR_ENTRY_267", 267);

    /**
     * There is no extended operation handler registered with the Directory Server for handling extended operations with a request OID of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTENDED_NO_HANDLER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_EXTENDED_NO_HANDLER_268", 268);

    /**
     * Entry %s violates the Directory Server schema configuration because it contains an unknown objectclass %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_UNKNOWN_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_UNKNOWN_OC_269", 269);

    /**
     * An unexpected error was encountered while processing a search in one of the Directory Server backends: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_BACKEND_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_BACKEND_EXCEPTION_270", 270);

    /**
     * The modify DN operation for entry %s cannot be performed because the change would have violated the server schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_VIOLATES_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_VIOLATES_SCHEMA_271", 271);

    /**
     * The Directory Server is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONNHANDLER_CLOSED_BY_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CONNHANDLER_CLOSED_BY_SHUTDOWN_272", 272);

    /**
     * The connection handler that accepted this connection has been disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONNHANDLER_CLOSED_BY_DISABLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CONNHANDLER_CLOSED_BY_DISABLE_273", 273);

    /**
     * The connection handler that accepted this connection has been removed from the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONNHANDLER_CLOSED_BY_DELETE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CONNHANDLER_CLOSED_BY_DELETE_274", 274);

    /**
     * Object class %s cannot be added to entry %s because that class is not defined in the Directory Server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_ADD_UNKNOWN_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_ADD_UNKNOWN_OC_276", 276);

    /**
     * Object class %s is already present in entry %s and cannot be added a second time
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_ADD_DUPLICATE_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_ADD_DUPLICATE_OC_277", 277);

    /**
     * The password provided by the user did not match any password(s) stored in the user's entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_WRONG_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_WRONG_PASSWORD_279", 279);

    /**
     * Fully-qualified name of the Java class to use as the Directory Server configuration handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_CONFIG_CLASS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_CONFIG_CLASS_281", 281);

    /**
     * Path to the file containing the information needed by the configuration handler to obtain the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_CONFIG_FILE_282", 282);

    /**
     * Display extended Directory Server version information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_FULLVERSION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_FULLVERSION_284", 284);

    /**
     * Display general system information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_SYSINFO =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_SYSINFO_285", 285);

    /**
     * An error occurred while attempting to initialize the command-line arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCORE_CANNOT_INITIALIZE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DSCORE_CANNOT_INITIALIZE_ARGS_288", 288);

    /**
     * An error occurred while attempting to parse the provided set of command line arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCORE_ERROR_PARSING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DSCORE_ERROR_PARSING_ARGS_289", 289);

    /**
     * An error occurred while attempting to bootstrap the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCORE_CANNOT_BOOTSTRAP =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DSCORE_CANNOT_BOOTSTRAP_290", 290);

    /**
     * An error occurred while trying to start the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCORE_CANNOT_START =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DSCORE_CANNOT_START_291", 291);

    /**
     * The line "%s" associated with the backup information in directory %s could not be parsed because it did not contain an equal sign to delimit the property name from the value
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPINFO_NO_DELIMITER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_NO_DELIMITER_292", 292);

    /**
     * The line "%s" associated with the backup information in directory %s could not be parsed because it did not include a property name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPINFO_NO_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_NO_NAME_293", 293);

    /**
     * The backup information structure in directory %s could not be parsed because it contained multiple backup IDs (%s and %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPINFO_MULTIPLE_BACKUP_IDS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_MULTIPLE_BACKUP_IDS_294", 294);

    /**
     * The backup information structure in directory %s could not be parsed because it contained an unknown property %s with value %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPINFO_UNKNOWN_PROPERTY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_UNKNOWN_PROPERTY_295", 295);

    /**
     * An unexpected error occurred while trying to decode a backup information structure in directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPINFO_CANNOT_DECODE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_CANNOT_DECODE_296", 296);

    /**
     * Unable to decode a backup information structure in directory %s because the structure did not include a backup ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPINFO_NO_BACKUP_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_NO_BACKUP_ID_297", 297);

    /**
     * The backup information structure with backup ID %s in directory %s was not valid because it did not contain the backup date
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPINFO_NO_BACKUP_DATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPINFO_NO_BACKUP_DATE_298", 298);

    /**
     * Cannot add a backup with ID %s to backup directory %s because another backup already exists with that ID
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDIRECTORY_ADD_DUPLICATE_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_ADD_DUPLICATE_ID_299", 299);

    /**
     * Cannot remove backup %s from backup directory %s because no backup with that ID exists in that directory
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDIRECTORY_NO_SUCH_BACKUP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_NO_SUCH_BACKUP_300", 300);

    /**
     * Cannot remove backup %s from backup directory %s because it is listed as a dependency for backup %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPDIRECTORY_UNRESOLVED_DEPENDENCY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_UNRESOLVED_DEPENDENCY_301", 301);

    /**
     * Backup directory %s does not exist and an error occurred while attempting to create it: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDIRECTORY_CANNOT_CREATE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_CREATE_DIRECTORY_302", 302);

    /**
     * The backup directory path %s exists but does not reference a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDIRECTORY_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_NOT_DIRECTORY_303", 303);

    /**
     * An error occurred while trying to remove saved backup descriptor file %s: %s. The new backup descriptor has been written to %s but will not be used until it is manually renamed to %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_BACKUPDIRECTORY_CANNOT_DELETE_SAVED_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_DELETE_SAVED_DESCRIPTOR_304", 304);

    /**
     * An error occurred while trying to rename the current backup descriptor file %s to %s: %s. The new backup descriptor has been written to %s but will not be used until it is manually renamed to %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> ERR_BACKUPDIRECTORY_CANNOT_RENAME_CURRENT_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_RENAME_CURRENT_DESCRIPTOR_305", 305);

    /**
     * An error occurred while trying to rename the new backup descriptor file %s to %s: %s. The new backup descriptor will not be used until it is manually renamed
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPDIRECTORY_CANNOT_RENAME_NEW_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_RENAME_NEW_DESCRIPTOR_306", 306);

    /**
     * No backup directory descriptor file was found at %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDIRECTORY_NO_DESCRIPTOR_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_NO_DESCRIPTOR_FILE_307", 307);

    /**
     * The backup descriptor file %s is invalid because the first line should have contained the DN of the backend configuration entry but was blank
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUPDIRECTORY_CANNOT_READ_CONFIG_ENTRY_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_READ_CONFIG_ENTRY_DN_308", 308);

    /**
     * The backup descriptor file %s is invalid because the first line of the file was "%s", but the DN of the backend configuration entry was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUPDIRECTORY_FIRST_LINE_NOT_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_FIRST_LINE_NOT_DN_309", 309);

    /**
     * An error occurred while trying to decode the value "%s" read from the first line of %s as the DN of the backend configuration entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUPDIRECTORY_CANNOT_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_BACKUPDIRECTORY_CANNOT_DECODE_DN_310", 310);

    /**
     * The attempt to obtain a shared lock on file %s was rejected because an exclusive lock was already held on that file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_LOCK_SHARED_REJECTED_BY_EXCLUSIVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_SHARED_REJECTED_BY_EXCLUSIVE_311", 311);

    /**
     * The attempt to obtain a shared lock on file %s was rejected because the attempt to create the lock file failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_SHARED_FAILED_CREATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_SHARED_FAILED_CREATE_312", 312);

    /**
     * The attempt to obtain a shared lock on file %s was rejected because the attempt to open the lock file failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_SHARED_FAILED_OPEN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_SHARED_FAILED_OPEN_313", 313);

    /**
     * The attempt to obtain a shared lock on file %s was rejected because an error occurred while attempting to acquire the lock: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_SHARED_FAILED_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_SHARED_FAILED_LOCK_314", 314);

    /**
     * The shared lock requested for file %s was not granted, which indicates that another process already holds an exclusive lock on that file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_LOCK_SHARED_NOT_GRANTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_SHARED_NOT_GRANTED_315", 315);

    /**
     * The attempt to obtain an exclusive lock on file %s was rejected because an exclusive lock was already held on that file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_REJECTED_BY_EXCLUSIVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_REJECTED_BY_EXCLUSIVE_316", 316);

    /**
     * The attempt to obtain an exclusive lock on file %s was rejected because a shared lock was already held on that file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_REJECTED_BY_SHARED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_REJECTED_BY_SHARED_317", 317);

    /**
     * The attempt to obtain an exclusive lock on file %s was rejected because the attempt to create the lock file failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_CREATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_CREATE_318", 318);

    /**
     * The attempt to obtain an exclusive lock on file %s was rejected because the attempt to open the lock file failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_OPEN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_OPEN_319", 319);

    /**
     * The attempt to obtain an exclusive lock on file %s was rejected because an error occurred while attempting to acquire the lock: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_FAILED_LOCK_320", 320);

    /**
     * The exclusive lock requested for file %s was not granted, which indicates that another process already holds a shared or exclusive lock on that file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_LOCK_EXCLUSIVE_NOT_GRANTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_LOCK_EXCLUSIVE_NOT_GRANTED_321", 321);

    /**
     * The attempt to release the exclusive lock held on %s failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_UNLOCK_EXCLUSIVE_FAILED_RELEASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_UNLOCK_EXCLUSIVE_FAILED_RELEASE_322", 322);

    /**
     * The attempt to release the shared lock held on %s failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILELOCKER_UNLOCK_SHARED_FAILED_RELEASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_UNLOCK_SHARED_FAILED_RELEASE_323", 323);

    /**
     * The attempt to release the lock held on %s failed because no record of a lock on that file was found
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILELOCKER_UNLOCK_UNKNOWN_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_FILELOCKER_UNLOCK_UNKNOWN_FILE_324", 324);

    /**
     * Server Connection Closed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_SERVER_DOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_SERVER_DOWN_325", 325);

    /**
     * Local Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_LOCAL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_LOCAL_ERROR_326", 326);

    /**
     * Encoding Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_ENCODING_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_ENCODING_ERROR_327", 327);

    /**
     * Decoding Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_DECODING_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_DECODING_ERROR_328", 328);

    /**
     * Client-Side Timeout
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_TIMEOUT_329", 329);

    /**
     * Unknown Authentication Mechanism
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_AUTH_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_AUTH_UNKNOWN_330", 330);

    /**
     * Filter Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_FILTER_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_FILTER_ERROR_331", 331);

    /**
     * Cancelled by User
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_USER_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_USER_CANCELLED_332", 332);

    /**
     * Parameter Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_PARAM_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_PARAM_ERROR_333", 333);

    /**
     * Out of Memory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NO_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NO_MEMORY_334", 334);

    /**
     * Connect Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CONNECT_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CONNECT_ERROR_335", 335);

    /**
     * Operation Not Supported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NOT_SUPPORTED_336", 336);

    /**
     * Control Not Found
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CONTROL_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CONTROL_NOT_FOUND_337", 337);

    /**
     * No Results Returned
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NO_RESULTS_RETURNED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NO_RESULTS_RETURNED_338", 338);

    /**
     * More Results to Return
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_MORE_RESULTS_TO_RETURN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_MORE_RESULTS_TO_RETURN_339", 339);

    /**
     * Referral Loop Detected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CLIENT_LOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CLIENT_LOOP_340", 340);

    /**
     * Referral Hop Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_REFERRAL_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_REFERRAL_LIMIT_EXCEEDED_341", 341);

    /**
     * An error occurred while attempting to release a shared lock for backend %s: %s. This lock should be automatically cleaned when the Directory Server process exits, so no additional action should be necessary
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_SHUTDOWN_CANNOT_RELEASE_SHARED_BACKEND_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_SHUTDOWN_CANNOT_RELEASE_SHARED_BACKEND_LOCK_342", 342);

    /**
     * The Directory Server could not acquire an exclusive lock on file %s: %s. This generally means that another instance of this server is already running
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_ACQUIRE_EXCLUSIVE_SERVER_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_ACQUIRE_EXCLUSIVE_SERVER_LOCK_343", 343);

    /**
     * Entry %s cannot be modified because the modification attempted to update attribute %s which is defined as NO-USER-MODIFICATION in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_ATTR_IS_NO_USER_MOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ATTR_IS_NO_USER_MOD_346", 346);

    /**
     * Entry %s cannot be added because it includes attribute %s which is defined as NO-USER-MODIFICATION in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_ATTR_IS_NO_USER_MOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ATTR_IS_NO_USER_MOD_347", 347);

    /**
     * Entry %s cannot be renamed because the current DN includes attribute %s which is defined as NO-USER-MODIFICATION in the server schema and the deleteOldRDN flag was set in the modify DN request
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_OLD_RDN_ATTR_IS_NO_USER_MOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_OLD_RDN_ATTR_IS_NO_USER_MOD_348", 348);

    /**
     * Entry %s cannot be renamed because the new RDN includes attribute %s which is defined as NO-USER-MODIFICATION in the server schema, and the target value for that attribute is not already included in the entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_NEW_RDN_ATTR_IS_NO_USER_MOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NEW_RDN_ATTR_IS_NO_USER_MOD_349", 349);

    /**
     * The modify DN operation for entry %s cannot be performed because a pre-operation plugin modified the entry in a way that caused it to violate the server schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_PREOP_VIOLATES_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_PREOP_VIOLATES_SCHEMA_356", 356);

    /**
     * Entry %s cannot be modified because the request contained an LDAP assertion control and the associated filter did not match the contents of the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ASSERTION_FAILED_357", 357);

    /**
     * Entry %s cannot be modified because the request contained an LDAP assertion control, but an error occurred while attempting to compare the target entry against the filter contained in the control: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_CANNOT_PROCESS_ASSERTION_FILTER_358", 358);

    /**
     * Entry %s cannot be modified because the request contained a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_UNSUPPORTED_CRITICAL_CONTROL_359", 359);

    /**
     * Entry %s cannot be removed because the request contained an LDAP assertion control and the associated filter did not match the contents of the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_ASSERTION_FAILED_362", 362);

    /**
     * Entry %s cannot be removed because the request contained an LDAP assertion control, but an error occurred while attempting to compare the target entry against the filter contained in the control: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DELETE_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_CANNOT_PROCESS_ASSERTION_FILTER_363", 363);

    /**
     * Entry %s cannot be removed because the request contained a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DELETE_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_UNSUPPORTED_CRITICAL_CONTROL_364", 364);

    /**
     * Entry %s cannot be renamed because the request contained an LDAP assertion control and the associated filter did not match the contents of the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_ASSERTION_FAILED_365", 365);

    /**
     * Entry %s cannot be renamed because the request contained an LDAP assertion control, but an error occurred while attempting to compare the target entry against the filter contained in the control: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_CANNOT_PROCESS_ASSERTION_FILTER_366", 366);

    /**
     * Entry %s cannot be renamed because the request contained a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_UNSUPPORTED_CRITICAL_CONTROL_367", 367);

    /**
     * Entry %s cannot be added because the request contained an LDAP assertion control and the associated filter did not match the contents of the provided entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ASSERTION_FAILED_368", 368);

    /**
     * Entry %s cannot be added because the request contained an LDAP assertion control, but an error occurred while attempting to compare the provided entry against the filter contained in the control: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_CANNOT_PROCESS_ASSERTION_FILTER_369", 369);

    /**
     * Entry %s cannot be added because the request contained a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_UNSUPPORTED_CRITICAL_CONTROL_370", 370);

    /**
     * The search request cannot be processed because it contains an LDAP assertion control and an error occurred while trying to retrieve the base entry to compare it against the assertion filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_CANNOT_GET_ENTRY_FOR_ASSERTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_CANNOT_GET_ENTRY_FOR_ASSERTION_371", 371);

    /**
     * The search request cannot be processed because it contains an LDAP assertion control but the search base entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_NO_SUCH_ENTRY_FOR_ASSERTION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SEARCH_NO_SUCH_ENTRY_FOR_ASSERTION_372", 372);

    /**
     * The search request cannot be processed because it contains an LDAP assertion control and the assertion filter did not match the contents of the base entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SEARCH_ASSERTION_FAILED_373", 373);

    /**
     * The search request cannot be processed because it contains an LDAP assertion control, but an error occurred while attempting to compare the base entry against the assertion filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_CANNOT_PROCESS_ASSERTION_FILTER_374", 374);

    /**
     * The search request cannot be processed because it contains a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_UNSUPPORTED_CRITICAL_CONTROL_375", 375);

    /**
     * Cannot perform the compare operation on entry %s because the request contained an LDAP assertion control and the associated filter did not match the contents of the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPARE_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPARE_ASSERTION_FAILED_376", 376);

    /**
     * Cannot perform the compare operation on entry %s because the request contained an LDAP assertion control, but an error occurred while attempting to compare the target entry against the filter contained in that control: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMPARE_CANNOT_PROCESS_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_COMPARE_CANNOT_PROCESS_ASSERTION_FILTER_377", 377);

    /**
     * Cannot perform the compare operation on entry %s because the request contained a critical control with OID %s that is not supported by the Directory Server for this type of operation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMPARE_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_COMPARE_UNSUPPORTED_CRITICAL_CONTROL_378", 378);

    /**
     * The add operation was not actually performed in the Directory Server backend because the LDAP no-op control was present in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADD_NOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_ADD_NOOP_379", 379);

    /**
     * The delete operation was not actually performed in the Directory Server backend because the LDAP no-op control was present in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_NOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DELETE_NOOP_380", 380);

    /**
     * The modify operation was not actually performed in the Directory Server backend because the LDAP no-op control was present in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_NOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_NOOP_381", 381);

    /**
     * The modify DN operation was not actually performed in the Directory Server backend because the LDAP no-op control was present in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODDN_NOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODDN_NOOP_382", 382);

    /**
     * Authorization Denied
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AUTHORIZATION_DENIED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AUTHORIZATION_DENIED_384", 384);

    /**
     * Entry %s cannot be added because it is missing attribute %s that is contained in the entry's RDN. All attributes used in the RDN must also be provided in the attribute list for the entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_MISSING_RDN_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_MISSING_RDN_ATTRIBUTE_385", 385);

    /**
     * Unable to process the bind request because it contained a control with OID %s that was marked critical but this control is not supported for the bind operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BIND_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BIND_UNSUPPORTED_CRITICAL_CONTROL_394", 394);

    /**
     * There are multiple user-specific size limit values contained in user entry %s. The default server size limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BIND_MULTIPLE_USER_SIZE_LIMITS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_BIND_MULTIPLE_USER_SIZE_LIMITS_395", 395);

    /**
     * The user-specific size limit value %s contained in user entry %s could not be parsed as an integer. The default server size limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BIND_CANNOT_PROCESS_USER_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_BIND_CANNOT_PROCESS_USER_SIZE_LIMIT_396", 396);

    /**
     * There are multiple user-specific time limit values contained in user entry %s. The default server time limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BIND_MULTIPLE_USER_TIME_LIMITS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_BIND_MULTIPLE_USER_TIME_LIMITS_397", 397);

    /**
     * The user-specific time limit value %s contained in user entry %s could not be parsed as an integer. The default server time limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BIND_CANNOT_PROCESS_USER_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_BIND_CANNOT_PROCESS_USER_TIME_LIMIT_398", 398);

    /**
     * Assertion Failed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ASSERTION_FAILED_399", 399);

    /**
     * The entry %s cannot be added because an entry with that name already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ENTRY_ALREADY_EXISTS_400", 400);

    /**
     * An error occurred during preoperation synchronization processing for the add operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ADD_SYNCH_PREOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_SYNCH_PREOP_FAILED_401", 401);

    /**
     * An error occurred during postoperation synchronization processing for the add operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ADD_SYNCH_POSTOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_SYNCH_POSTOP_FAILED_402", 402);

    /**
     * An error occurred during preoperation synchronization processing for the delete operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_DELETE_SYNCH_PREOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_SYNCH_PREOP_FAILED_403", 403);

    /**
     * An error occurred during postoperation synchronization processing for the delete operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_DELETE_SYNCH_POSTOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_SYNCH_POSTOP_FAILED_404", 404);

    /**
     * An error occurred during preoperation synchronization processing for the modify operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODIFY_SYNCH_PREOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_SYNCH_PREOP_FAILED_405", 405);

    /**
     * An error occurred during postoperation synchronization processing for the modify operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODIFY_SYNCH_POSTOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_SYNCH_POSTOP_FAILED_406", 406);

    /**
     * An error occurred during preoperation synchronization processing for the modify DN operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODDN_SYNCH_PREOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_SYNCH_PREOP_FAILED_407", 407);

    /**
     * An error occurred during postoperation synchronization processing for the modify DN operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODDN_SYNCH_POSTOP_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_SYNCH_POSTOP_FAILED_408", 408);

    /**
     * An error occurred during conflict resolution synchronization processing for the add operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_ADD_SYNCH_CONFLICT_RESOLUTION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_SYNCH_CONFLICT_RESOLUTION_FAILED_409", 409);

    /**
     * An error occurred during conflict resolution synchronization processing for the delete operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_DELETE_SYNCH_CONFLICT_RESOLUTION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_SYNCH_CONFLICT_RESOLUTION_FAILED_410", 410);

    /**
     * An error occurred during conflict resolution synchronization processing for the modify operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODIFY_SYNCH_CONFLICT_RESOLUTION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_SYNCH_CONFLICT_RESOLUTION_FAILED_411", 411);

    /**
     * An error occurred during conflict resolution synchronization processing for the modify DN operation with connection ID %d and operation ID %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_MODDN_SYNCH_CONFLICT_RESOLUTION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_SYNCH_CONFLICT_RESOLUTION_FAILED_412", 412);

    /**
     * Unable to add entry %s because the Directory Server is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_SERVER_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_SERVER_READONLY_413", 413);

    /**
     * Unable to add entry %s because the backend that should hold that entry is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_BACKEND_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_BACKEND_READONLY_414", 414);

    /**
     * Unable to delete entry %s because the Directory Server is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_SERVER_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_SERVER_READONLY_415", 415);

    /**
     * Unable to delete entry %s because the backend that holds that entry is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_BACKEND_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_BACKEND_READONLY_416", 416);

    /**
     * Unable to modify entry %s because the Directory Server is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_SERVER_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_SERVER_READONLY_417", 417);

    /**
     * Unable to modify entry %s because the backend that holds that entry is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_BACKEND_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_BACKEND_READONLY_418", 418);

    /**
     * Unable to rename entry %s because the Directory Server is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_SERVER_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_SERVER_READONLY_419", 419);

    /**
     * Unable to rename entry %s because the backend that holds that entry is configured in read-only mode
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_BACKEND_READONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_BACKEND_READONLY_420", 420);

    /**
     * Unable to process the simple bind request because it contained a bind DN but no password, which is forbidden by the server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_DN_BUT_NO_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_DN_BUT_NO_PASSWORD_421", 421);

    /**
     * The password policy definition contained in configuration entry "%s" is invalid because the specified password attribute "%s" is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_UNDEFINED_PASSWORD_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_UNDEFINED_PASSWORD_ATTRIBUTE_425", 425);

    /**
     * The password policy definition contained in configuration entry "%s" is invalid because the specified password attribute "%s" has a syntax OID of %s. The password attribute must have a syntax OID of either 1.3.6.1.4.1.26027.1.3.1 (for the user password syntax) or 1.3.6.1.4.1.4203.1.1.2 (for the authentication password syntax)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PWPOLICY_INVALID_PASSWORD_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_INVALID_PASSWORD_ATTRIBUTE_SYNTAX_426", 426);

    /**
     * An error occurred while attempting to determine the value for attribute ds-cfg-require-change-by-time in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_CANNOT_DETERMINE_REQUIRE_CHANGE_BY_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_CANNOT_DETERMINE_REQUIRE_CHANGE_BY_TIME_477", 477);

    /**
     * The password policy definition contained in configuration entry "%s" is invalid because the specified last login time format "%s" is not a valid format string The last login time format string should conform to the syntax described in the API documentation for the <CODE>java.text.SimpleDateFormat</CODE> class
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_INVALID_LAST_LOGIN_TIME_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_INVALID_LAST_LOGIN_TIME_FORMAT_482", 482);

    /**
     * The password policy definition contained in configuration entry "%s" is invalid because the specified previous last login time format "%s" is not a valid format string The previous last login time format strings should conform to the syntax described in the API documentation for the <CODE>java.text.SimpleDateFormat</CODE> class
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_INVALID_PREVIOUS_LAST_LOGIN_TIME_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_INVALID_PREVIOUS_LAST_LOGIN_TIME_FORMAT_485", 485);

    /**
     * Attribute options are not allowed for the password attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_ATTRIBUTE_OPTIONS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_ATTRIBUTE_OPTIONS_NOT_ALLOWED_496", 496);

    /**
     * Only a single value may be provided for the password attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_MULTIPLE_PW_VALUES_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_MULTIPLE_PW_VALUES_NOT_ALLOWED_497", 497);

    /**
     * Pre-encoded passwords are not allowed for the password attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_PREENCODED_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_PREENCODED_NOT_ALLOWED_498", 498);

    /**
     * The password value for attribute %s was found to be unacceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_VALIDATION_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_VALIDATION_FAILED_499", 499);

    /**
     * The password policy defined in configuration entry %s is configured to always send at least one warning notification before the password is expired, but no warning interval has been set. If configuration attribute ds-cfg-expire-passwords-without-warning is set to "false", then configuration attribute ds-cfg-password-expiration-warning-interval must have a positive value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_MUST_HAVE_WARNING_IF_NOT_EXPIRE_WITHOUT_WARNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_MUST_HAVE_WARNING_IF_NOT_EXPIRE_WITHOUT_WARNING_500", 500);

    /**
     * A bind operation is currently in progress on the associated client connection. No other requests may be made on this client connection until the bind processing has completed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENQUEUE_BIND_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ENQUEUE_BIND_IN_PROGRESS_501", 501);

    /**
     * %s must change their password before it will be allowed to request any other operations
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENQUEUE_MUST_CHANGE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENQUEUE_MUST_CHANGE_PASSWORD_502", 502);

    /**
     * An error occurred while attempting to decode the ds-pwp-password-policy-dn value "%s" in user entry "%s" as a DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PWPSTATE_CANNOT_DECODE_SUBENTRY_VALUE_AS_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DECODE_SUBENTRY_VALUE_AS_DN_504", 504);

    /**
     * User entry %s is configured to use a password policy subentry of %s but no such password policy has been defined in the server configuration
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_NO_SUCH_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_NO_SUCH_POLICY_505", 505);

    /**
     * An error occurred while attempting to decode value "%s" for attribute %s in user entry %s in accordance with the generalized time format: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_PWPSTATE_CANNOT_DECODE_GENERALIZED_TIME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DECODE_GENERALIZED_TIME_506", 506);

    /**
     * Unable to decode value "%s" for attribute %s in user entry %s as a Boolean value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PWPSTATE_CANNOT_DECODE_BOOLEAN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_DECODE_BOOLEAN_507", 507);

    /**
     * The entry %s cannot be added due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_508", 508);

    /**
     * The user cannot bind due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_509", 509);

    /**
     * The entry %s cannot be compared due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPARE_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPARE_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_510", 510);

    /**
     * The entry %s cannot be deleted due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DELETE_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DELETE_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_511", 511);

    /**
     * The extended operation %s cannot be performed due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTENDED_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_EXTENDED_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_512", 512);

    /**
     * The entry %s cannot be renamed due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODDN_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_513", 513);

    /**
     * The entry %s cannot be modified due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_514", 514);

    /**
     * The entry %s cannot be searched due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCH_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_AUTHZ_INSUFFICIENT_ACCESS_RIGHTS_515", 515);

    /**
     * Rejecting a simple bind request because the password policy requires secure authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_INSECURE_SIMPLE_BIND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_INSECURE_SIMPLE_BIND_516", 516);

    /**
     * Rejecting a bind request because the account has been administratively disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_ACCOUNT_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_ACCOUNT_DISABLED_517", 517);

    /**
     * Rejecting a bind request because the account has been locked due to too many failed authentication attempts
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_ACCOUNT_FAILURE_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_ACCOUNT_FAILURE_LOCKED_518", 518);

    /**
     * Rejecting a bind request because the account has been locked after the user's password was not changed in a timely manner after an administrative reset
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_ACCOUNT_RESET_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_ACCOUNT_RESET_LOCKED_519", 519);

    /**
     * Rejecting a bind request because the account has been locked after remaining idle for too long
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_ACCOUNT_IDLE_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_ACCOUNT_IDLE_LOCKED_520", 520);

    /**
     * Rejecting a bind request because that user's password is expired
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_PASSWORD_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_PASSWORD_EXPIRED_521", 521);

    /**
     * An error occurred while attempting to update password policy state information for user %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPSTATE_CANNOT_UPDATE_USER_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_CANNOT_UPDATE_USER_ENTRY_522", 522);

    /**
     * Rejecting a SASL %s bind request for user %s because the password policy requires secure authentication
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BIND_OPERATION_INSECURE_SASL_BIND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_INSECURE_SASL_BIND_523", 523);

    /**
     * The alternate root bind DN "%s" is already registered with the Directory Server for actual root entry DN "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_REGISTER_DUPLICATE_ALTERNATE_ROOT_BIND_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CANNOT_REGISTER_DUPLICATE_ALTERNATE_ROOT_BIND_DN_530", 530);

    /**
     * Rejecting a bind request because the account has expired
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_OPERATION_ACCOUNT_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_ACCOUNT_EXPIRED_531", 531);

    /**
     * Attributes used to hold user passwords are not allowed to have any attribute options
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_PASSWORDS_CANNOT_HAVE_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_PASSWORDS_CANNOT_HAVE_OPTIONS_532", 532);

    /**
     * Users are not allowed to change their own passwords
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_NO_USER_PW_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_USER_PW_CHANGES_533", 533);

    /**
     * Password changes must be performed over a secure authentication channel
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_REQUIRE_SECURE_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_REQUIRE_SECURE_CHANGES_534", 534);

    /**
     * The password cannot be changed because it has not been long enough since the last password change
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_WITHIN_MINIMUM_AGE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_WITHIN_MINIMUM_AGE_535", 535);

    /**
     * Multiple password values are not allowed in user entries
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_MULTIPLE_VALUES_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_MULTIPLE_VALUES_NOT_ALLOWED_536", 536);

    /**
     * User passwords may not be provided in pre-encoded form
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_NO_PREENCODED_PASSWORDS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_PREENCODED_PASSWORDS_537", 537);

    /**
     * Invalid modification type %s attempted on password attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_INVALID_MOD_TYPE_FOR_PASSWORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_INVALID_MOD_TYPE_FOR_PASSWORD_538", 538);

    /**
     * The user entry does not have any existing passwords to remove
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_NO_EXISTING_VALUES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_EXISTING_VALUES_539", 539);

    /**
     * The provided user password does not match any password in the user's entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_INVALID_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_INVALID_PASSWORD_541", 541);

    /**
     * The password policy requires that user password changes include the current password in the request
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_PW_CHANGE_REQUIRES_CURRENT_PW =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_PW_CHANGE_REQUIRES_CURRENT_PW_542", 542);

    /**
     * The password change would result in multiple password values in the user entry, which is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_MULTIPLE_PASSWORDS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_MULTIPLE_PASSWORDS_NOT_ALLOWED_543", 543);

    /**
     * The provided password value was rejected by a password validator: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_PW_VALIDATION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_PW_VALIDATION_FAILED_544", 544);

    /**
     * %s must change their password before it will be allowed to perform any other operations
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_MUST_CHANGE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_MUST_CHANGE_PASSWORD_545", 545);

    /**
     * The user password is about to expire (time to expiration: %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BIND_PASSWORD_EXPIRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_BIND_PASSWORD_EXPIRING_547", 547);

    /**
     * The account has been locked as a result of too many failed authentication attempts (time to unlock: %s)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BIND_ACCOUNT_TEMPORARILY_LOCKED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BIND_ACCOUNT_TEMPORARILY_LOCKED_548", 548);

    /**
     * The account has been locked as a result of too many failed authentication attempts. It may only be unlocked by an administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_ACCOUNT_PERMANENTLY_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_ACCOUNT_PERMANENTLY_LOCKED_549", 549);

    /**
     * The user password has been changed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_PASSWORD_CHANGED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_PASSWORD_CHANGED_551", 551);

    /**
     * The user password has been administratively reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_PASSWORD_RESET =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_PASSWORD_RESET_552", 552);

    /**
     * The user account has been administratively enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_ACCOUNT_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_ACCOUNT_ENABLED_553", 553);

    /**
     * The user account has been administratively disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_ACCOUNT_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_ACCOUNT_DISABLED_554", 554);

    /**
     * The user account has been administratively unlocked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODIFY_ACCOUNT_UNLOCKED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_MODIFY_ACCOUNT_UNLOCKED_555", 555);

    /**
     * The specified password value already exists in the user entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_PASSWORD_EXISTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_PASSWORD_EXISTS_556", 556);

    /**
     * There are multiple user-specific lookthrough limit values contained in user entry %s. The default server lookthrough limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BIND_MULTIPLE_USER_LOOKTHROUGH_LIMITS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_BIND_MULTIPLE_USER_LOOKTHROUGH_LIMITS_557", 557);

    /**
     * The user-specific lookthrough limit value %s contained in user entry %s could not be parsed as an integer. The default server lookthrough limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BIND_CANNOT_PROCESS_USER_LOOKTHROUGH_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_BIND_CANNOT_PROCESS_USER_LOOKTHROUGH_LIMIT_558", 558);

    /**
     * Unable to add one or more values to attribute %s because at least one of the values already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_DUPLICATE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_DUPLICATE_VALUES_559", 559);

    /**
     * Unable to remove one or more values from attribute %s because at least one of the attributes does not exist in the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_NO_SUCH_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_NO_SUCH_VALUE_560", 560);

    /**
     * The increment operation is not supported for the objectClass attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENTRY_OC_INCREMENT_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ENTRY_OC_INCREMENT_NOT_SUPPORTED_561", 561);

    /**
     * Unknown modification type %s requested
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_UNKNOWN_MODIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_UNKNOWN_MODIFICATION_TYPE_562", 562);

    /**
     * Unable to increment the value of attribute %s because the provided modification did not have exactly one value to use as the increment
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_INVALID_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_INVALID_VALUE_COUNT_564", 564);

    /**
     * Unable to increment the value of attribute %s because either the current value or the increment could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_CANNOT_PARSE_AS_INT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_CANNOT_PARSE_AS_INT_565", 565);

    /**
     * Entry %s cannot be updated because the request did not contain any modifications
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_NO_MODIFICATIONS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_NO_MODIFICATIONS_566", 566);

    /**
     * Do not detach from the terminal and continue running in the foreground. This option cannot be used with the -t, --timeout option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_NODETACH =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_NODETACH_567", 567);

    /**
     * Unable to increment the value of attribute %s because that attribute does not exist in the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_NO_SUCH_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_NO_SUCH_ATTRIBUTE_568", 568);

    /**
     * This utility can be used to start the Directory Server, as well as to obtain the server version and other forms of general server information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_TOOL_DESCRIPTION_569", 569);

    /**
     * Unable to process the request for extended operation %s because it contained an unsupported critical control with OID %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXTENDED_UNSUPPORTED_CRITICAL_CONTROL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_EXTENDED_UNSUPPORTED_CRITICAL_CONTROL_570", 570);

    /**
     * Unable to register backend %s with the Directory Server because another backend with the same backend ID is already registered
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REGISTER_BACKEND_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_BACKEND_ALREADY_EXISTS_571", 571);

    /**
     * Unable to register base DN %s with the Directory Server for backend %s because that base DN is already registered for backend %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REGISTER_BASEDN_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_BASEDN_ALREADY_EXISTS_572", 572);

    /**
     * Unable to register base DN %s with the Directory Server for backend %s because that backend already contains another base DN %s that is within the same hierarchical path
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REGISTER_BASEDN_HIERARCHY_CONFLICT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_BASEDN_HIERARCHY_CONFLICT_573", 573);

    /**
     * Unable to register base DN %s with the Directory Server for backend %s because that backend already contains another base DN %s that is not subordinate to the same base DN in the parent backend
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REGISTER_BASEDN_DIFFERENT_PARENT_BASES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_BASEDN_DIFFERENT_PARENT_BASES_574", 574);

    /**
     * Unable to register base DN %s with the Directory Server for backend %s because that backend already contains one or more other base DNs that are subordinate to backend %s but the new base DN is not
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REGISTER_BASEDN_NEW_BASE_NOT_SUBORDINATE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_BASEDN_NEW_BASE_NOT_SUBORDINATE_575", 575);

    /**
     * Backend %s already contains entry %s which has just been registered as the base DN for backend %s. These conflicting entries can cause unexpected or errant search results, and both backends should be reinitialized to ensure that each has the correct content
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_REGISTER_BASEDN_ENTRIES_IN_MULTIPLE_BACKENDS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_REGISTER_BASEDN_ENTRIES_IN_MULTIPLE_BACKENDS_576", 576);

    /**
     * Unable to de-register base DN %s with the Directory Server because that base DN is not registered for any active backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DEREGISTER_BASEDN_NOT_REGISTERED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DEREGISTER_BASEDN_NOT_REGISTERED_577", 577);

    /**
     * Base DN %s has been deregistered from the Directory Server for backend %s. This base DN had both superior and subordinate entries in other backends, and there might be inconsistent or unexpected behavior when accessing entries in this portion of the hierarchy because of the missing entries that had been held in the de-registered backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DEREGISTER_BASEDN_MISSING_HIERARCHY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DEREGISTER_BASEDN_MISSING_HIERARCHY_578", 578);

    /**
     * Unable to update the schema element with definition "%s" because a circular reference was identified when attempting to rebuild other schema elements dependent upon it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SCHEMA_CIRCULAR_DEPENDENCY_REFERENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CIRCULAR_DEPENDENCY_REFERENCE_579", 579);

    /**
     * Rejecting the requested operation because the connection has not been authenticated
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REJECT_UNAUTHENTICATED_OPERATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_REJECT_UNAUTHENTICATED_OPERATION_580", 580);

    /**
     * Entry "%s" cannot be added because it contains attribute type %s which is declared OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ADD_ATTR_IS_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ADD_ATTR_IS_OBSOLETE_581", 581);

    /**
     * Entry "%s" cannot be added because it contains objectclass %s which is declared OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ADD_OC_IS_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ADD_OC_IS_OBSOLETE_582", 582);

    /**
     * Entry %s cannot be modified because the modification attempted to set one or more new values for attribute %s which is marked OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_ATTR_IS_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ATTR_IS_OBSOLETE_583", 583);

    /**
     * Object class %s added to entry %s is marked OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_ADD_OBSOLETE_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_ADD_OBSOLETE_OC_584", 584);

    /**
     * The modify DN operation for entry %s cannot be performed because the new RDN includes attribute type %s which is declared OBSOLETE in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_NEWRDN_ATTR_IS_OBSOLETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NEWRDN_ATTR_IS_OBSOLETE_585", 585);

    /**
     * Entry %s is invalid according to the server schema because there is no DIT structure rule that applies to that entry, but there is a DIT structure rule for the parent entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_VIOLATES_PARENT_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_VIOLATES_PARENT_DSR_586", 586);

    /**
     * An unexpected error occurred while attempting to perform DIT structure rule processing for the parent of entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_COULD_NOT_CHECK_PARENT_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_COULD_NOT_CHECK_PARENT_DSR_587", 587);

    /**
     * Terminating the client connection because its associated authentication or authorization entry %s has been deleted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CLIENTCONNECTION_DISCONNECT_DUE_TO_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_CLIENTCONNECTION_DISCONNECT_DUE_TO_DELETE_588", 588);

    /**
     * You do not have sufficient privileges to reset user passwords
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_PWRESET_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_PWRESET_INSUFFICIENT_PRIVILEGES_589", 589);

    /**
     * You do not have sufficient privileges to access the server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_COMPARE_CONFIG_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_COMPARE_CONFIG_INSUFFICIENT_PRIVILEGES_590", 590);

    /**
     * You do not have sufficient privileges to add entries that include privileges
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADD_CHANGE_PRIVILEGE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ADD_CHANGE_PRIVILEGE_INSUFFICIENT_PRIVILEGES_591", 591);

    /**
     * You do not have sufficient privileges to modify the set of privileges contained in an entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_CHANGE_PRIVILEGE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_CHANGE_PRIVILEGE_INSUFFICIENT_PRIVILEGES_592", 592);

    /**
     * hasPrivilege determination for connID=%d opID=%d requesterDN="%s" privilege="%s" result=%b
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Boolean> INFO_CLIENTCONNECTION_AUDIT_HASPRIVILEGE =
                    new LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Boolean>(CoreMessages.class, RESOURCE, "INFO_CLIENTCONNECTION_AUDIT_HASPRIVILEGE_593", 593);

    /**
     * hasPrivilege determination for connID=%d opID=%d requesterDN="%s" privilegeSet="%s" result=%b
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Boolean> INFO_CLIENTCONNECTION_AUDIT_HASPRIVILEGES =
                    new LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Boolean>(CoreMessages.class, RESOURCE, "INFO_CLIENTCONNECTION_AUDIT_HASPRIVILEGES_594", 594);

    /**
     * You do not have sufficient privileges to use the proxied authorization control
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH_INSUFFICIENT_PRIVILEGES_595", 595);

    /**
     * Used to determine whether a server can be started or not and the mode to be used to start it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_CHECK_STARTABILITY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_CHECK_STARTABILITY_596", 596);

    /**
     * Entry %s violates the Directory Server schema configuration because it includes attribute %s without any values
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_ATTR_NO_VALUES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_ATTR_NO_VALUES_597", 597);

    /**
     * OpenDJ is configured to run as a Windows service and it cannot run in no-detach mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DSCORE_ERROR_NODETACH_AND_WINDOW_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_DSCORE_ERROR_NODETACH_AND_WINDOW_SERVICE_598", 598);

    /**
     * Used by the Windows service code to inform that start-ds is being called from the Windows services after a call to net start
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_WINDOWS_NET_START =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_WINDOWS_NET_START_599", 599);

    /**
     * Unable to decode an entry because it had an unsupported entry version byte value of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_DECODE_UNRECOGNIZED_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_DECODE_UNRECOGNIZED_VERSION_600", 600);

    /**
     * Unable to decode an entry because an unexpected exception was caught during processing: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_DECODE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_DECODE_EXCEPTION_601", 601);

    /**
     * The provided search filter "%s" could not be decoded because the NOT filter between positions %d and %d did not contain exactly one filter component
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_SEARCH_FILTER_NOT_EXACTLY_ONE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_NOT_EXACTLY_ONE_602", 602);

    /**
     * Sort Control Missing
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SORT_CONTROL_MISSING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SORT_CONTROL_MISSING_608", 608);

    /**
     * Offset Range Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OFFSET_RANGE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OFFSET_RANGE_ERROR_609", 609);

    /**
     * Virtual List View Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_VIRTUAL_LIST_VIEW_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_VIRTUAL_LIST_VIEW_ERROR_610", 610);

    /**
     * The request control with Object Identifier (OID) "%s" cannot be used due to insufficient access rights
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONTROL_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CONTROL_INSUFFICIENT_ACCESS_RIGHTS_611", 611);

    /**
     * The connection handler %s is trying to use the listener %s which is already in use by another connection handler
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_HOST_PORT_ALREADY_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_HOST_PORT_ALREADY_SPECIFIED_612", 612);

    /**
     * No enabled connection handler available
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NOT_AVAILABLE_CONNECTION_HANDLERS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_NOT_AVAILABLE_CONNECTION_HANDLERS_614", 614);

    /**
     * Could not start connection handlers
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_STARTING_CONNECTION_HANDLERS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ERROR_STARTING_CONNECTION_HANDLERS_615", 615);

    /**
     * Unable to process the non-root bind because the server is in lockdown mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BIND_REJECTED_LOCKDOWN_MODE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_BIND_REJECTED_LOCKDOWN_MODE_616", 616);

    /**
     * The Directory Server is entering lockdown mode, in which clients will only be allowed to connect via a loopback address, and only root users will be allowed to process operations
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_DIRECTORY_SERVER_ENTERING_LOCKDOWN_MODE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_DIRECTORY_SERVER_ENTERING_LOCKDOWN_MODE_617", 617);

    /**
     * The Directory Server is leaving lockdown mode and will resume normal operation
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_DIRECTORY_SERVER_LEAVING_LOCKDOWN_MODE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "NOTE_DIRECTORY_SERVER_LEAVING_LOCKDOWN_MODE_618", 618);

    /**
     * Rejecting the requested operation because the server is in lockdown mode and will only accept requests from root users over loopback connections
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_REJECT_OPERATION_IN_LOCKDOWN_MODE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "NOTE_REJECT_OPERATION_IN_LOCKDOWN_MODE_619", 619);

    /**
     * Unable to decode the provided attribute because it used an undefined attribute description token %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPRESSEDSCHEMA_UNRECOGNIZED_AD_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPRESSEDSCHEMA_UNRECOGNIZED_AD_TOKEN_620", 620);

    /**
     * Unable to decode the provided object class set because it used an undefined token %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPRESSEDSCHEMA_UNKNOWN_OC_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPRESSEDSCHEMA_UNKNOWN_OC_TOKEN_621", 621);

    /**
     * Unable to write the updated compressed schema token data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMPRESSEDSCHEMA_CANNOT_WRITE_UPDATED_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_COMPRESSEDSCHEMA_CANNOT_WRITE_UPDATED_DATA_622", 622);

    /**
     * Unable to decode the provided entry encode configuration element because it has an invalid length
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENTRYENCODECFG_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ENTRYENCODECFG_INVALID_LENGTH_623", 623);

    /**
     * No Operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_OPERATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_OPERATION_624", 624);

    /**
     * Unable to create an extensible match search filter using the provided information because it did not contain either an attribute type or a matching rule ID. At least one of these must be provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SEARCH_FILTER_CREATE_EXTENSIBLE_MATCH_NO_AT_OR_MR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_CREATE_EXTENSIBLE_MATCH_NO_AT_OR_MR_625", 625);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not contain either an attribute description or a matching rule ID. At least one of these must be provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR_626", 626);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d referenced an unknown matching rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_SUCH_MR =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_SEARCH_FILTER_EXTENSIBLE_MATCH_NO_SUCH_MR_627", 627);

    /**
     * Rejecting a bind request for user %s because either the entire server or the user's backend has a writability mode of 'disabled' and password policy state updates would not be allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BIND_OPERATION_WRITABILITY_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BIND_OPERATION_WRITABILITY_DISABLED_628", 628);

    /**
     * The provided new password was found in the password history for the user
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MODIFY_PW_IN_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MODIFY_PW_IN_HISTORY_629", 629);

    /**
     * There are multiple user-specific idle time limit values contained in user entry %s. The default server idle time limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_BIND_MULTIPLE_USER_IDLE_TIME_LIMITS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_BIND_MULTIPLE_USER_IDLE_TIME_LIMITS_630", 630);

    /**
     * The user-specific idle time limit value %s contained in user entry %s could not be parsed as an integer. The default server idle time limit will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_BIND_CANNOT_PROCESS_USER_IDLE_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_BIND_CANNOT_PROCESS_USER_IDLE_TIME_LIMIT_631", 631);

    /**
     * This connection has been terminated because it has remained idle for too long
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_IDLETIME_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_IDLETIME_LIMIT_EXCEEDED_632", 632);

    /**
     * The password policy configuration entry "%s" is invalid because if a maximum password age is configured, then the password expiration warning interval must be shorter than the maximum password age
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_WARNING_INTERVAL_LARGER_THAN_MAX_AGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_WARNING_INTERVAL_LARGER_THAN_MAX_AGE_633", 633);

    /**
     * The password policy configuration entry "%s" is invalid because if both a minimum password age and a maximum password age are configured, then the sum of the minimum password age and the password expiration warning interval must be shorter than the maximum password age
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_MIN_AGE_PLUS_WARNING_GREATER_THAN_MAX_AGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_MIN_AGE_PLUS_WARNING_GREATER_THAN_MAX_AGE_634", 634);

    /**
     * An error occurred while attempting to disconnect client connection %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_IDLETIME_DISCONNECT_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_IDLETIME_DISCONNECT_ERROR_638", 638);

    /**
     * An unexpected error occurred in the idle time limit thread: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_IDLETIME_UNEXPECTED_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_IDLETIME_UNEXPECTED_ERROR_639", 639);

    /**
     * The Directory Server is currently running. Environment configuration changes are not allowed with the server running
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DIRCFG_SERVER_ALREADY_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_DIRCFG_SERVER_ALREADY_RUNNING_640", 640);

    /**
     * The specified server root directory '%s' is invalid. The specified path must exist and must be a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRCFG_INVALID_SERVER_ROOT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DIRCFG_INVALID_SERVER_ROOT_641", 641);

    /**
     * The specified config file path '%s' is invalid. The specified path must exist and must be a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRCFG_INVALID_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DIRCFG_INVALID_CONFIG_FILE_642", 642);

    /**
     * The specified config handler class '%s' is invalid. The specified class must be a subclass of the org.opends.server.api.ConfigHandler superclass
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRCFG_INVALID_CONFIG_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DIRCFG_INVALID_CONFIG_CLASS_643", 643);

    /**
     * The specified schema configuration directory '%s' is invalid. The specified path must exist and must be a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRCFG_INVALID_SCHEMA_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DIRCFG_INVALID_SCHEMA_DIRECTORY_644", 644);

    /**
     * The specified lock directory '%s' is invalid. The specified path must exist and must be a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIRCFG_INVALID_LOCK_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_DIRCFG_INVALID_LOCK_DIRECTORY_645", 645);

    /**
     * The Directory Server is currently running. The environment configuration can not be altered while the server is online
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_SET_ENVIRONMENT_CONFIG_WHILE_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_SET_ENVIRONMENT_CONFIG_WHILE_RUNNING_648", 648);

    /**
     * An error occurred while attempting to initialize a SSL context for server to server communication: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_SSL_CONTEXT_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_SSL_CONTEXT_CANNOT_INITIALIZE_649", 649);

    /**
     * The ADS trust store backend %s is not enabled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_ADS_TRUST_STORE_BACKEND_NOT_ENABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_ADS_TRUST_STORE_BACKEND_NOT_ENABLED_650", 650);

    /**
     * The backend %s is not a trust store backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_ADS_TRUST_STORE_BACKEND_WRONG_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_ADS_TRUST_STORE_BACKEND_WRONG_CLASS_651", 651);

    /**
     * Attempt to start using the configuration that was in place at the last successful startup (if it is available) rather than using the current active configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_LASTKNOWNGOODCFG =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_LASTKNOWNGOODCFG_652", 652);

    /**
     * Error while searching base %s to synchronize the trust store: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TRUSTSTORESYNC_ADMIN_SUFFIX_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "INFO_TRUSTSTORESYNC_ADMIN_SUFFIX_SEARCH_FAILED_653", 653);

    /**
     * An error occurred in the trust store synchronization thread: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TRUSTSTORESYNC_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_TRUSTSTORESYNC_EXCEPTION_654", 654);

    /**
     * Error while trying to add entry %s to the trust store: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TRUSTSTORESYNC_ADD_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "INFO_TRUSTSTORESYNC_ADD_FAILED_655", 655);

    /**
     * Error while trying to delete entry %s from the trust store: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_TRUSTSTORESYNC_DELETE_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "INFO_TRUSTSTORESYNC_DELETE_FAILED_656", 656);

    /**
     * The password storage scheme defined in configuration entry %s does not support the auth password syntax, which is used by password attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_SCHEME_DOESNT_SUPPORT_AUTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_SCHEME_DOESNT_SUPPORT_AUTH_657", 657);

    /**
     * Password policy configuration entry %s references deprecated password storage scheme DN %s which does not support the auth password syntax
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICY_DEPRECATED_SCHEME_NOT_AUTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_DEPRECATED_SCHEME_NOT_AUTH_659", 659);

    /**
     * The search filter "%s" used by group implementation %s is not indexed in backend %s. Backend initialization for this group implementation might take a very long time to complete
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_GROUP_FILTER_NOT_INDEXED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_GROUP_FILTER_NOT_INDEXED_660", 660);

    /**
     * CryptoManager cannot get the requested digest %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_DIGEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_DIGEST_661", 661);

    /**
     * CryptoManager cannot get the requested MAC engine %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_MAC_ENGINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_MAC_ENGINE_662", 662);

    /**
     * CryptoManager cannot get the requested encryption cipher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_ENCRYPTION_CIPHER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_CANNOT_GET_REQUESTED_ENCRYPTION_CIPHER_663", 663);

    /**
     * CryptoManager cannot get the preferred key wrapping cipher: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_CANNOT_GET_PREFERRED_KEY_WRAPPING_CIPHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_CANNOT_GET_PREFERRED_KEY_WRAPPING_CIPHER_664", 664);

    /**
     * CryptoManager failed to add entry "%s" to initiate instance key generation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_TO_INITIATE_INSTANCE_KEY_GENERATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_INITIATE_INSTANCE_KEY_GENERATION_665", 665);

    /**
     * CryptoManager failed to retrieve entry "%s" (the instance-key-pair public-key-certificate): %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_FAILED_TO_RETRIEVE_INSTANCE_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_RETRIEVE_INSTANCE_CERTIFICATE_666", 666);

    /**
     * CryptoManager failed to compute an instance key identifier: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_TO_COMPUTE_INSTANCE_KEY_IDENTIFIER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_COMPUTE_INSTANCE_KEY_IDENTIFIER_667", 667);

    /**
     * Failed to add entry "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_TO_ADD_INSTANCE_KEY_ENTRY_TO_ADS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_ADD_INSTANCE_KEY_ENTRY_TO_ADS_668", 668);

    /**
     * CryptoManager failed to publish the instance-key-pair public-key-certificate entry in ADS: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_TO_PUBLISH_INSTANCE_KEY_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_PUBLISH_INSTANCE_KEY_ENTRY_669", 669);

    /**
     * CryptoManager failed to retrieve the collection of instance-key-pair public-key-certificates from ADS container "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_FAILED_TO_RETRIEVE_ADS_TRUSTSTORE_CERTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_RETRIEVE_ADS_TRUSTSTORE_CERTS_670", 670);

    /**
     * CryptoManager failed to encode symmetric key attribute value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_TO_ENCODE_SYMMETRIC_KEY_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_TO_ENCODE_SYMMETRIC_KEY_ATTRIBUTE_671", 671);

    /**
     * CryptoManager symmetric key attribute value "%s" syntax is invalid: incorrect number of fields
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_FIELD_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_FIELD_COUNT_672", 672);

    /**
     * CryptoManager symmetric key attribute value "%s" syntax is invalid. Parsing failed in field "%s" at offset %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_SYNTAX_673", 673);

    /**
     * CryptoManager failed to retrieve the instance-key-pair private-key: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_NO_PRIVATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_NO_PRIVATE_674", 674);

    /**
     * CryptoManager failed to decipher the wrapped secret-key value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_DECIPHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECODE_SYMMETRIC_KEY_ATTRIBUTE_DECIPHER_675", 675);

    /**
     * CryptoManager cannot find the public-key-certificate (identifier "%s") requested for symmetric key re-encoding
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_REWRAP_SYMMETRIC_KEY_ATTRIBUTE_NO_WRAPPER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_REWRAP_SYMMETRIC_KEY_ATTRIBUTE_NO_WRAPPER_676", 676);

    /**
     * CryptoManager failed to decode the key entry identifier "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_INVALID_KEY_IDENTIFIER_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_INVALID_KEY_IDENTIFIER_SYNTAX_677", 677);

    /**
     * CrytpoManager passed invalid MAC algorithm "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_GET_MAC_ENGINE_INVALID_MAC_ALGORITHM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_GET_MAC_ENGINE_INVALID_MAC_ALGORITHM_678", 678);

    /**
     * CryptoManager failed to initialize MAC engine: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_GET_MAC_ENGINE_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_GET_MAC_ENGINE_CANNOT_INITIALIZE_679", 679);

    /**
     * CryptoManager passed invalid Cipher transformation "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_GET_CIPHER_INVALID_CIPHER_TRANSFORMATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_GET_CIPHER_INVALID_CIPHER_TRANSFORMATION_680", 680);

    /**
     * CryptoManager cannot initialize Cipher: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_GET_CIPHER_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_GET_CIPHER_CANNOT_INITIALIZE_681", 681);

    /**
     * CryptoManager failed to write the stream prologue: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_GET_CIPHER_STREAM_PROLOGUE_WRITE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_GET_CIPHER_STREAM_PROLOGUE_WRITE_ERROR_682", 682);

    /**
     * CryptoManager failed to decrypt the supplied data because it could not read the symmetric key identifier in the data prologue: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_KEY_IDENTIFIER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_KEY_IDENTIFIER_683", 683);

    /**
     * CryptoManager failed to decrypt the supplied data because the symmetric key identifier in the data prologue does not match any known key entries
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CRYPTOMGR_DECRYPT_UNKNOWN_KEY_IDENTIFIER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_UNKNOWN_KEY_IDENTIFIER_684", 684);

    /**
     * CryptoManager failed to decrypt the supplied data because it could not read the cipher initialization vector in the data prologue
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_IV =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_IV_685", 685);

    /**
     * CryptoManager failed to decrypt the supplied data because there was an error reading from the input stream: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECRYPT_CIPHER_INPUT_STREAM_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_CIPHER_INPUT_STREAM_ERROR_686", 686);

    /**
     * CryptoManager failed to import the symmetric key entry "%s" because it could not obtain a symmetric key attribute value that can be decoded by this instance
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_TO_DECODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_TO_DECODE_687", 687);

    /**
     * CryptoManager detected a field mismatch between the key entry to be imported and an entry in the key cache that share the key identifier "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FIELD_MISMATCH =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FIELD_MISMATCH_688", 688);

    /**
     * CryptoManager failed to import the symmetric key entry "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_OTHER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_OTHER_689", 689);

    /**
     * CryptoManager failed to import the symmetric key entry "%s" because it could not add a symmetric key attribute value that can be decoded by this instance
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_TO_ADD_KEY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_IMPORT_KEY_ENTRY_FAILED_TO_ADD_KEY_690", 690);

    /**
     * CryptoManager failed to instantiate a KeyGenerator for algorithm "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_INVALID_SYMMETRIC_KEY_ALGORITHM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_INVALID_SYMMETRIC_KEY_ALGORITHM_691", 691);

    /**
     * CryptoManager failed to add locally produced symmetric key entry "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CRYPTOMGR_SYMMETRIC_KEY_ENTRY_ADD_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_SYMMETRIC_KEY_ENTRY_ADD_FAILED_692", 692);

    /**
     * CryptoManager cipher transformation specification "%s" is invalid: it must be of the form "algorithm/mode/padding"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FULL_CIPHER_TRANSFORMATION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FULL_CIPHER_TRANSFORMATION_REQUIRED_693", 693);

    /**
     * CryptoManager cipher transformation specification "%s" is invalid: it must be of the form "algorithm/mode/padding"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FULL_KEY_WRAPPING_TRANSFORMATION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FULL_KEY_WRAPPING_TRANSFORMATION_REQUIRED_694", 694);

    /**
     * CryptoManager failed to decrypt the supplied data because it could not read the version number in the data prologue: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_PROLOGUE_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_FAILED_TO_READ_PROLOGUE_VERSION_695", 695);

    /**
     * CryptoManager failed to decrypt the supplied data because the version "%d" in the data prologue is unknown
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CRYPTOMGR_DECRYPT_UNKNOWN_PROLOGUE_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_DECRYPT_UNKNOWN_PROLOGUE_VERSION_696", 696);

    /**
     * The provided entry %s cannot be added because its suffix is not defined as one of the suffixes within the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADD_ENTRY_UNKNOWN_SUFFIX =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ENTRY_UNKNOWN_SUFFIX_697", 697);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "NOTE_VERSION_698", 698);

    /**
     * Build ID:                 %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BUILD_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "NOTE_BUILD_ID_699", 699);

    /**
     * Start TLS extended operations cannot be canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CANCEL_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_CANCEL_START_TLS_700", 700);

    /**
     * Cancel extended operations can not be canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CANCEL_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_CANCEL_CANCEL_701", 701);

    /**
     * The modify DN operation for entry %s cannot be performed because the new superior entry %s is equal to or a subordinate of the entry to be moved
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODDN_NEW_SUPERIOR_IN_SUBTREE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODDN_NEW_SUPERIOR_IN_SUBTREE_702", 702);

    /**
     * Unable to register workflow element %s with the Directory Server because another workflow element with the same ID is already registered
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REGISTER_WORKFLOW_ELEMENT_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_REGISTER_WORKFLOW_ELEMENT_ALREADY_EXISTS_703", 703);

    /**
     * Unable to process operation because this search scope is not allowed in this network group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_SEARCH_SCOPE_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_ERROR_SEARCH_SCOPE_NOT_ALLOWED_712", 712);

    /**
     * Entry %s can not be added because BER encoding of %s attribute is not supported
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADD_ATTR_IS_INVALID_OPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ADD_ATTR_IS_INVALID_OPTION_715", 715);

    /**
     * No worker queue thread pool size specified: sizing automatically to use %d threads
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_ERGONOMIC_SIZING_OF_WORKER_THREAD_POOL =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "INFO_ERGONOMIC_SIZING_OF_WORKER_THREAD_POOL_720", 720);

    /**
     * The CryptoManager entry "%s" (the instance-key-pair public-key-certificate) does not contain a public-key certificate
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CRYPTOMGR_FAILED_INSTANCE_CERTIFICATE_NULL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_FAILED_INSTANCE_CERTIFICATE_NULL_721", 721);

    /**
     * Maximum time (in seconds) to wait before the command returns (the server continues the startup process, regardless). A value of '0' indicates an infinite timeout, which means that the command returns only when the server startup is completed. The default value is 60 seconds. This option cannot be used with the -N, --nodetach option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCORE_DESCRIPTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DSCORE_DESCRIPTION_TIMEOUT_722", 722);

    /**
     * In no-detach mode, the 'timeout' option cannot be used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DSCORE_ERROR_NODETACH_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_DSCORE_ERROR_NODETACH_TIMEOUT_723", 723);

    /**
     * The search filter "%s" used by subentry manager is not indexed in backend %s. Backend initialization for subentry manager processing might take a very long time to complete
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_SUBENTRY_FILTER_NOT_INDEXED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_SUBENTRY_FILTER_NOT_INDEXED_724", 724);

    /**
     * The entry %s does not contain the pwdPolicy objectclass, which is required for Directory Server password policy
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICY_NO_PWDPOLICY_OC =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_NO_PWDPOLICY_OC_726", 726);

    /**
     * Unable to decode the provided string "%s" as a relative distinguished name because it does not contain a value for attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RDN_MISSING_ATTRIBUTE_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_RDN_MISSING_ATTRIBUTE_VALUE_727", 727);

    /**
     * CryptoManager failed to initialize because the specified cipher key length "%d" is beyond the allowed cryptography strength "%d" in jurisdiction policy files
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_CRYPTOMGR_INVALID_SYMMETRIC_KEY_LENGTH =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(CoreMessages.class, RESOURCE, "ERR_CRYPTOMGR_INVALID_SYMMETRIC_KEY_LENGTH_728", 728);

    /**
     * Failed to update free disk space for directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DISK_SPACE_MONITOR_UPDATE_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DISK_SPACE_MONITOR_UPDATE_FAILED_729", 729);

    /**
     * The directory server is not accepting a new persistent search request because the server has already reached its limit
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MAX_PSEARCH_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MAX_PSEARCH_LIMIT_EXCEEDED_730", 730);

    /**
     * This operation involves LDAP subentries which you do not have sufficient privileges to administer
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBENTRY_WRITE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SUBENTRY_WRITE_INSUFFICIENT_PRIVILEGES_739", 739);

    /**
     * The request to process this operation has been rejected because request handler thread was interrupted while attempting to put the operation on the work queue
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_OP_REJECTED_BY_QUEUE_INTERRUPT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_OP_REJECTED_BY_QUEUE_INTERRUPT_740", 740);

    /**
     * Invalid Credentials
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISCONNECT_DUE_TO_INVALID_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_DISCONNECT_DUE_TO_INVALID_CREDENTIALS_741", 741);

    /**
     * Entry "%s" contains a value for attribute %s that is invalid according to the syntax for that attribute: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ADD_OP_INVALID_SYNTAX_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ADD_OP_INVALID_SYNTAX_NO_VALUE_742", 742);

    /**
     * When attempting to modify entry %s, one value for attribute %s was found to be invalid according to the associated syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_ADD_INVALID_SYNTAX_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_ADD_INVALID_SYNTAX_NO_VALUE_743", 743);

    /**
     * When attempting to modify entry %s to replace the set of values for attribute %s, one value was found to be invalid according to the associated syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_MODIFY_REPLACE_INVALID_SYNTAX_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_MODIFY_REPLACE_INVALID_SYNTAX_NO_VALUE_744", 744);

    /**
     * The password policy definition contained in configuration entry "%s" is invalid because the password validator "%s" specified in attribute "%s" cannot be found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PWPOLICY_UNKNOWN_VALIDATOR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_UNKNOWN_VALIDATOR_745", 745);

    /**
     * The password could not be validated because of misconfiguration. Please contact the administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPOLICY_REJECT_DUE_TO_UNKNOWN_VALIDATOR_REASON =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_REJECT_DUE_TO_UNKNOWN_VALIDATOR_REASON_746", 746);

    /**
     * The password for user %s could not be validated because the password policy subentry %s is referring to an unknown password validator (%s). Please make sure the password policy subentry only refers to validators that exist on all replicas
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PWPOLICY_REJECT_DUE_TO_UNKNOWN_VALIDATOR_LOG =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICY_REJECT_DUE_TO_UNKNOWN_VALIDATOR_LOG_747", 747);

    /**
     * Could not get filesystem for directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DISK_SPACE_GET_MOUNT_POINT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DISK_SPACE_GET_MOUNT_POINT_748", 748);

    /**
     * The disk containing directory %s used by %s is low on free space (%d bytes free). Write operations are only permitted by a user with the BYPASS_LOCKDOWN privilege until the free space rises above the threshold. Replication updates are still allowed
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_DISK_SPACE_LOW_THRESHOLD_REACHED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_DISK_SPACE_LOW_THRESHOLD_REACHED_749", 749);

    /**
     * The disk containing directory %s used by %s is full (%d bytes free). Write operations to the backend, replication updates included, will fail until the free space rises above the threshold
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_DISK_SPACE_FULL_THRESHOLD_REACHED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_DISK_SPACE_FULL_THRESHOLD_REACHED_750", 750);

    /**
     * The free space (%d bytes) on the disk containing directory %s is now above the threshold
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> NOTE_DISK_SPACE_RESTORED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "NOTE_DISK_SPACE_RESTORED_751", 751);

    /**
     * A StartTLS operation is currently in progress on the associated client connection. No other requests may be made on this client connection until the StartTLS processing has completed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENQUEUE_STARTTLS_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ENQUEUE_STARTTLS_IN_PROGRESS_752", 752);

    /**
     * A SASL bind operation is currently in progress on the associated client connection. No other requests may be made on this client connection until the SASL bind processing has completed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ENQUEUE_SASLBIND_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ENQUEUE_SASLBIND_IN_PROGRESS_753", 753);

    /**
     * Cannot properly use SHA-1 using the java provider. Verify java.security is properly configured
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_HASH_DATA =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CANNOT_HASH_DATA_754", 754);

    /**
     * Cannot complete initialization of server's backends because the root and administrative backends have not been initialized yet.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MISSING_ADMIN_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MISSING_ADMIN_BACKENDS_755", 755);

}
