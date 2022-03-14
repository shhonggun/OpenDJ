package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.replication}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/replication.properties} and it should not be manually edited.
 */
public final class ReplicationMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.replication";

    // Prevent instantiation.
    private ReplicationMessages() {
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
     * The configured DN is already used by another domain
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SYNC_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_SYNC_INVALID_DN_1", 1);

    /**
     * Replication Server failed to start because the hostname is unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNKNOWN_HOSTNAME =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_UNKNOWN_HOSTNAME_5", 5);

    /**
     * Replication Server failed to start : could not bind to the listen port : %d. Error : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_COULD_NOT_BIND_CHANGELOG =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_BIND_CHANGELOG_6", 6);

    /**
     * Unknown operation type : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNKNOWN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_UNKNOWN_TYPE_7", 7);

    /**
     * Internal Error : Operation %s change number %s was not found in pending list
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OPERATION_NOT_FOUND_IN_PENDING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_OPERATION_NOT_FOUND_IN_PENDING_9", 9);

    /**
     * The replication server failed to start because the database %s could not be read : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COULD_NOT_READ_DB =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_READ_DB_11", 11);

    /**
     * An Exception was caught while replaying operation %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXCEPTION_REPLAYING_OPERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_REPLAYING_OPERATION_12", 12);

    /**
     * Error %s when updating server state %s : %s base dn : %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> DEBUG_ERROR_UPDATING_RUV =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "DEBUG_ERROR_UPDATING_RUV_14", 14);

    /**
     * Error %s when searching for server state %s : %s base dn : %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ERROR_SEARCHING_RUV =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_ERROR_SEARCHING_RUV_15", 15);

    /**
     * Directory server DS(%d) was unable to connect to replication server %s for domain "%s". Please check that there is a replication server listening at this address
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_NO_CHANGELOG_SERVER_LISTENING =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_NO_CHANGELOG_SERVER_LISTENING_17", 17);

    /**
     * Caught IOException while sending topology info (for update) on domain %s for %s server %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_EXCEPTION_SENDING_TOPO_INFO =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_SENDING_TOPO_INFO_20", 20);

    /**
     * Error when searching old changes from the database for base DN %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_RECOVER_CHANGES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CANNOT_RECOVER_CHANGES_21", 21);

    /**
     * Directory server DS(%d) was unable to connect to any of the following replication servers for domain "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_COULD_NOT_FIND_CHANGELOG =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_COULD_NOT_FIND_CHANGELOG_23", 23);

    /**
     * Error trying to replay %s, operation could not be decoded :
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXCEPTION_DECODING_OPERATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_DECODING_OPERATION_25", 25);

    /**
     * Error trying to use the underlying database. The Replication Server is going to shut down: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_SHUTDOWN_DATABASE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_SHUTDOWN_DATABASE_ERROR_26", 26);

    /**
     * Error during the Replication Server database trimming or flush process. The Changelog service is going to shutdown: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXCEPTION_CHANGELOG_TRIM_FLUSH =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_CHANGELOG_TRIM_FLUSH_29", 29);

    /**
     * An unexpected error happened handling connection with %s.  This connection is going to be closed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_WRITER_UNEXPECTED_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_WRITER_UNEXPECTED_EXCEPTION_32", 32);

    /**
     * In replication server %s: an unexpected error occurred while sending an ack to server id %s for change number %s in domain %s . This connection is going to be closed and reopened
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_RS_ERROR_SENDING_ACK =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_ERROR_SENDING_ACK_33", 33);

    /**
     * A loop was detected while replaying operation: %s error %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOOP_REPLAYING_OPERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_LOOP_REPLAYING_OPERATION_35", 35);

    /**
     * An Exception was caught while testing existence or trying to create the directory for the Replication Server database : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILE_CHECK_CREATE_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_FILE_CHECK_CREATE_FAILED_36", 36);

    /**
     * The current request is rejected due to an import or an export already in progress for the same data
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SIMULTANEOUS_IMPORT_EXPORT_REJECTED =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_SIMULTANEOUS_IMPORT_EXPORT_REJECTED_44", 44);

    /**
     * On domain %s, initialization of server with serverId:%s has been requested from a server with an invalid serverId:%s. %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_INVALID_IMPORT_SOURCE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INVALID_IMPORT_SOURCE_45", 45);

    /**
     * Invalid target for the export
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INVALID_EXPORT_TARGET =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_INVALID_EXPORT_TARGET_46", 46);

    /**
     * Domain %s: the server with serverId=%s is unreachable
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_NO_REACHABLE_PEER_IN_THE_DOMAIN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_NO_REACHABLE_PEER_IN_THE_DOMAIN_47", 47);

    /**
     * No domain matches the provided base DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_MATCHING_DOMAIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_NO_MATCHING_DOMAIN_48", 48);

    /**
     * Multiple domains match the base DN provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MULTIPLE_MATCHING_DOMAIN =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_MULTIPLE_MATCHING_DOMAIN_49", 49);

    /**
     * The provider class does not allow the operation requested
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INVALID_PROVIDER =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_INVALID_PROVIDER_50", 50);

    /**
     * The hostname %s could not be resolved as an IP address
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COULD_NOT_SOLVE_HOSTNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_SOLVE_HOSTNAME_51", 51);

    /**
     * Received a Null Msg from %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_READER_NULL_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_READER_NULL_MSG_52", 52);

    /**
     * Exception when reading messages from %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_READER_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_READER_EXCEPTION_53", 53);

    /**
     * In Replication server %s: servers %s and %s have the same ServerId : %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number> ERR_DUPLICATE_SERVER_ID =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_DUPLICATE_SERVER_ID_54", 54);

    /**
     * In Replication server %s: replication servers %s and %s have the same ServerId : %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number> ERR_DUPLICATE_REPLICATION_SERVER_ID =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_DUPLICATE_REPLICATION_SERVER_ID_55", 55);

    /**
     * Entry %s was containing some unknown historical information, This may cause some inconsistency for this entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BAD_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_BAD_HISTORICAL_56", 56);

    /**
     * A conflict was detected but the conflict information could not be added. Operation: %s, Result: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_ADD_CONFLICT_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CANNOT_ADD_CONFLICT_ATTRIBUTE_57", 57);

    /**
     * An error happened trying to rename a conflicting entry. DN: %s, Operation: %s, Result: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CANNOT_RENAME_CONFLICT_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CANNOT_RENAME_CONFLICT_ENTRY_58", 58);

    /**
     * The Replication is configured for suffix %s but was not able to connect to any Replication Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_COULD_NOT_CONNECT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_REPLICATION_COULD_NOT_CONNECT_61", 61);

    /**
     * Directory server DS(%d) has connected to replication server RS(%d) for domain "%s" at %s with generation ID %d
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Number> NOTE_NOW_FOUND_SAME_GENERATION_CHANGELOG =
                    new LocalizableMessageDescriptor.Arg5<Number, Number, Object, Object, Number>(ReplicationMessages.class, RESOURCE, "NOTE_NOW_FOUND_SAME_GENERATION_CHANGELOG_62", 62);

    /**
     * Replication server RS(%d) at %s has closed the connection to this directory server DS(%d). This directory server will now try to connect to another replication server in order to receive changes for the domain "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> WARN_REPLICATION_SERVER_PROPERLY_DISCONNECTED =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "WARN_REPLICATION_SERVER_PROPERLY_DISCONNECTED_63", 63);

    /**
     * An unexpected error occurred while sending an Error Message to %s. This connection is going to be closed and reopened
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_ERROR_SENDING_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_ERROR_SENDING_ERROR_65", 65);

    /**
     * An unexpected error occurred while sending a Message to %s. This connection is going to be closed and reopened
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_ERROR_SENDING_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_ERROR_SENDING_MSG_66", 66);

    /**
     * Could not replay operation %s with ChangeNumber %s error %s %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ERROR_REPLAYING_OPERATION =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_ERROR_REPLAYING_OPERATION_67", 67);

    /**
     * The entry %s has historical information for attribute %s which is not defined in the schema. This information will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNKNOWN_ATTRIBUTE_IN_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_UNKNOWN_ATTRIBUTE_IN_HISTORICAL_68", 68);

    /**
     * An unresolved conflict was detected for DN %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_UNRESOLVED_CONFLICT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_UNRESOLVED_CONFLICT_69", 69);

    /**
     * The Replication Server socket could not be closed : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COULD_NOT_CLOSE_THE_SOCKET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_CLOSE_THE_SOCKET_70", 70);

    /**
     * The thread listening on the replication server port could not be stopped : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COULD_NOT_STOP_LISTEN_THREAD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_STOP_LISTEN_THREAD_71", 71);

    /**
     * An unexpected error occurred when searching for generation id for domain "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SEARCHING_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_SEARCHING_GENERATION_ID_73", 73);

    /**
     * An unexpected error occurred when looking for the replicated backend : %s. It may be not configured or disabled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SEARCHING_DOMAIN_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_SEARCHING_DOMAIN_BACKEND_74", 74);

    /**
     * An unexpected error occurred when searching in %s for the generation ID : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOADING_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_LOADING_GENERATION_ID_75", 75);

    /**
     * An unexpected error occurred when updating generation ID for domain "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UPDATING_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_UPDATING_GENERATION_ID_76", 76);

    /**
     * Replication server RS(%d) at %s presented generation ID %d for domain "%s", but the generation ID of this replication server RS(%d) is %d. This usually indicates that one or more directory servers in the replication topology have not been initialized with the same data, and re-initialization is required
     */
    public static final LocalizableMessageDescriptor.Arg6<Number, Object, Number, Object, Number, Number> WARN_BAD_GENERATION_ID_FROM_RS =
                    new LocalizableMessageDescriptor.Arg6<Number, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_BAD_GENERATION_ID_FROM_RS_77", 77);

    /**
     * The generation ID for domain "%s" has been reset to %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> NOTE_RESET_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RESET_GENERATION_ID_78", 78);

    /**
     * The following error has been received : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_MSG_RECEIVED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_ERROR_MSG_RECEIVED_79", 79);

    /**
     * Replication server RS(%d) ignoring update %s for domain "%s" from replication server RS(%d) at %s because its generation ID %d is different to the local generation ID %d
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number> WARN_IGNORING_UPDATE_FROM_RS =
                    new LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_FROM_RS_80", 80);

    /**
     * Replication server RS(%d) not sending update %s for domain "%s" to replication server RS(%d) at %s because its generation ID %d is different to the local generation ID %d
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number> WARN_IGNORING_UPDATE_TO_RS =
                    new LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_TO_RS_81", 81);

    /**
     * Initialization cannot be done because import is not supported by the backend %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_IMPORT_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_IMPORT_NOT_SUPPORTED_82", 82);

    /**
     * Initialization cannot be done because export is not supported by the backend %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_EXPORT_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_EXPORT_NOT_SUPPORTED_83", 83);

    /**
     * Initialization cannot be done because the following error occurred while locking the backend %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INIT_CANNOT_LOCK_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_CANNOT_LOCK_BACKEND_84", 84);

    /**
     * Caught Exception during reinitialization of communication on domain %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_EXCEPTION_RESTARTING_SESSION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_EXCEPTION_RESTARTING_SESSION_85", 85);

    /**
     * Replication server caught exception while listening for client connections %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXCEPTION_LISTENING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_LISTENING_86", 86);

    /**
     * While clearing the database %s , the following error happened: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ERROR_CLEARING_DB =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_ERROR_CLEARING_DB_87", 87);

    /**
     * Protocol error : a replication server is not expected to be the destination of a message of type %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_ROUTING_TO_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_ROUTING_TO_SERVER_88", 88);

    /**
     * An unexpected error occurred when testing existence or creating the replication backend : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHECK_CREATE_REPL_BACKEND_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHECK_CREATE_REPL_BACKEND_FAILED_89", 89);

    /**
     * An error occurred when searching for %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKEND_SEARCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_BACKEND_SEARCH_ENTRY_93", 93);

    /**
     * The base DN %s is not stored by any of the Directory Server backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNKNOWN_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_UNKNOWN_DN_95", 95);

    /**
     * Directory server DS(%d) has connected to replication server RS(%d) for domain "%s" at %s, but the generation IDs do not match, indicating that a full re-initialization is required. The local (DS) generation ID is %d and the remote (RS) generation ID is %d
     */
    public static final LocalizableMessageDescriptor.Arg6<Number, Number, Object, Object, Number, Number> WARN_NOW_FOUND_BAD_GENERATION_CHANGELOG =
                    new LocalizableMessageDescriptor.Arg6<Number, Number, Object, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_NOW_FOUND_BAD_GENERATION_CHANGELOG_96", 96);

    /**
     * Directory server DS(%d) is closing its connection to replication server RS(%d) at %s for domain "%s" because it could not detect a heart beat
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> WARN_HEARTBEAT_FAILURE =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_HEARTBEAT_FAILURE_97", 97);

    /**
     * Replication server accepted a connection from %s to local address %s but the SSL handshake failed. This is probably benign, but may indicate a transient network outage or a misconfigured client application connecting to this replication server. The error was: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_SSL_SERVER_CON_ATTEMPT_ERROR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "INFO_SSL_SERVER_CON_ATTEMPT_ERROR_105", 105);

    /**
     * Timed out waiting for monitor data for the domain "%s" from replication server RS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_MISSING_REMOTE_MONITOR_DATA =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "WARN_MISSING_REMOTE_MONITOR_DATA_106", 106);

    /**
     * Monitor data of remote servers are missing due to a processing error : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROCESSING_REMOTE_MONITOR_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_PROCESSING_REMOTE_MONITOR_DATA_107", 107);

    /**
     * Unable to send monitor data request for domain "%s" to replication server RS(%d) due to the following error: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_SENDING_REMOTE_MONITOR_DATA_REQUEST =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ReplicationMessages.class, RESOURCE, "ERR_SENDING_REMOTE_MONITOR_DATA_REQUEST_108", 108);

    /**
     * An Exception was caught while replaying replication message : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXCEPTION_REPLAYING_REPLICATION_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_REPLAYING_REPLICATION_MESSAGE_109", 109);

    /**
     * The replication server is late regarding our changes: going to send missing ones
     */
    public static final LocalizableMessageDescriptor.Arg0 DEBUG_GOING_TO_SEARCH_FOR_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "DEBUG_GOING_TO_SEARCH_FOR_CHANGES_111", 111);

    /**
     * All missing changes sent to replication server
     */
    public static final LocalizableMessageDescriptor.Arg0 DEBUG_CHANGES_SENT =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "DEBUG_CHANGES_SENT_113", 113);

    /**
     * Caught exception publishing fake operations for domain %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PUBLISHING_FAKE_OPS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_PUBLISHING_FAKE_OPS_114", 114);

    /**
     * Caught exception computing fake operations for domain %s for replication server %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COMPUTING_FAKE_OPS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_COMPUTING_FAKE_OPS_115", 115);

    /**
     * Late monitor data received for domain "%s" from replication server RS(%d), and will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_IGNORING_REMOTE_MONITOR_DATA =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "INFO_IGNORING_REMOTE_MONITOR_DATA_116", 116);

    /**
     * ServerState recovery for domain %s, updated with changeNumber %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_SERVER_STATE_RECOVERY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_SERVER_STATE_RECOVERY_117", 117);

    /**
     * For replicated domain %s, in server with serverId=%s, the generation ID could not be set to value %s in the rest of the topology because this server is NOT connected to any replication server. You should check in the configuration that the domain is enabled and that there is one replication server up and running
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RESET_GENERATION_CONN_ERR_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RESET_GENERATION_CONN_ERR_ID_118", 118);

    /**
     * Directory server DS(%d) encountered an unexpected error while connecting to replication server %s for domain "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object> WARN_EXCEPTION_STARTING_SESSION_PHASE =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_EXCEPTION_STARTING_SESSION_PHASE_119", 119);

    /**
     * DN sent by remote replication server: %s does not match local replication server one: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RS_DN_DOES_NOT_MATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_DN_DOES_NOT_MATCH_121", 121);

    /**
     * DN sent by replication server: %s does not match local directory server one: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DS_DN_DOES_NOT_MATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_DN_DOES_NOT_MATCH_122", 122);

    /**
     * Caught IOException while forwarding ResetGenerationIdMsg to peer replication servers for domain %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXCEPTION_FORWARDING_RESET_GEN_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_FORWARDING_RESET_GEN_ID_123", 123);

    /**
     * Computed invalid initial status: %s in DS replication domain %s with server id %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DS_INVALID_INIT_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_INVALID_INIT_STATUS_124", 124);

    /**
     * Replication server received invalid initial status: %s for replication domain %s from server id %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RS_INVALID_INIT_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_INVALID_INIT_STATUS_125", 125);

    /**
     * Received invalid requested status %s in DS replication domain %s with server id %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DS_INVALID_REQUESTED_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_INVALID_REQUESTED_STATUS_126", 126);

    /**
     * Could not compute new status in RS replication domain %s for server id %s. Was in %s status and received %s event
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_RS_CANNOT_CHANGE_STATUS =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_CANNOT_CHANGE_STATUS_127", 127);

    /**
     * Could not compute new status in DS replication domain %s with server id %s. Was in %s status and received %s event
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_DS_CANNOT_CHANGE_STATUS =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_CANNOT_CHANGE_STATUS_128", 128);

    /**
     * Caught IOException while changing status for domain %s and serverId: %s after reset for generation id: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_EXCEPTION_CHANGING_STATUS_AFTER_RESET_GEN_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_CHANGING_STATUS_AFTER_RESET_GEN_ID_129", 129);

    /**
     * Received change status message does not come from a directory server (dn: %s, server id: %s, msg: %s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RECEIVED_CHANGE_STATUS_NOT_FROM_DS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RECEIVED_CHANGE_STATUS_NOT_FROM_DS_130", 130);

    /**
     * Directory server DS(%d) for domain "%s" has changed its status to %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> NOTE_DIRECTORY_SERVER_CHANGED_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_DIRECTORY_SERVER_CHANGED_STATUS_131", 131);

    /**
     * Received invalid new status %s in RS for replication domain %s and directory server id %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RS_INVALID_NEW_STATUS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_INVALID_NEW_STATUS_132", 132);

    /**
     * Connected to a replication server with wrong group id. We have group id %s and replication server id %s %s has group id %s. This is for domain %s in directory server %s
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object> WARN_CONNECTED_TO_SERVER_WITH_WRONG_GROUP_ID =
                    new LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_CONNECTED_TO_SERVER_WITH_WRONG_GROUP_ID_133", 133);

    /**
     * Replication broker with dn %s and server id %s failed to signal status change because of: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_EXCEPTION_SENDING_CS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_SENDING_CS_134", 134);

    /**
     * Replication server RS(%d) ignoring update %s for domain "%s" from directory server DS(%d) at %s because its generation ID %d is different to the local generation ID %d
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number> WARN_IGNORING_UPDATE_FROM_DS_BADGENID =
                    new LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_FROM_DS_BADGENID_135", 135);

    /**
     * Replication server RS(%d) not sending update %s for domain "%s" to directory server DS(%d) at %s because its generation ID %d is different to the local generation ID %d
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number> WARN_IGNORING_UPDATE_TO_DS_BADGENID =
                    new LocalizableMessageDescriptor.Arg7<Number, Object, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_TO_DS_BADGENID_136", 136);

    /**
     * Replication server RS(%d) ignoring update %s for domain "%s" from directory server DS(%d) at %s because it is currently performing a full update
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Object, Object, Number, Object> WARN_IGNORING_UPDATE_FROM_DS_FULLUP =
                    new LocalizableMessageDescriptor.Arg5<Number, Object, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_FROM_DS_FULLUP_137", 137);

    /**
     * Replication server RS(%d) not sending update %s for domain "%s" to directory server DS(%d) at %s because it is currently performing a full update
     */
    public static final LocalizableMessageDescriptor.Arg5<Number, Object, Object, Number, Object> WARN_IGNORING_UPDATE_TO_DS_FULLUP =
                    new LocalizableMessageDescriptor.Arg5<Number, Object, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "WARN_IGNORING_UPDATE_TO_DS_FULLUP_138", 138);

    /**
     * Caught IOException while changing status for domain %s and serverId: %s from status analyzer: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_EXCEPTION_CHANGING_STATUS_FROM_STATUS_ANALYZER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_EXCEPTION_CHANGING_STATUS_FROM_STATUS_ANALYZER_139", 139);

    /**
     * Replication server %s for dn %s: directory server %s must stay in full update although a generation id reset has been ordered (from %s to %s)
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> NOTE_BAD_GEN_ID_IN_FULL_UPDATE =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_BAD_GEN_ID_IN_FULL_UPDATE_140", 140);

    /**
     * Starting total update: importing domain "%s" from remote directory server DS(%d) to this directory server DS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> NOTE_FULL_UPDATE_ENGAGED_FROM_REMOTE_START =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FROM_REMOTE_START_141", 141);

    /**
     * Finished total update: imported domain "%s" from remote directory server DS(%d) to this directory server DS(%d). %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> NOTE_FULL_UPDATE_ENGAGED_FROM_REMOTE_END =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FROM_REMOTE_END_142", 142);

    /**
     * Starting total update: exporting %d entries in domain "%s" from this directory server DS(%d) to remote directory server DS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Number> NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_START =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_START_143", 143);

    /**
     * Finished total update: exported domain "%s" from this directory server DS(%d) to remote directory server DS(%d). %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_END =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_END_144", 144);

    /**
     * Timed out while trying to acquire the domain lock for domain "%s". The connection attempt from replication server RS(%d) at %s to this replication server RS(%d) will be aborted. This is probably benign and a result of a simultaneous cross connection attempt
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Number> WARN_TIMEOUT_WHEN_CROSS_CONNECTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Number>(ReplicationMessages.class, RESOURCE, "WARN_TIMEOUT_WHEN_CROSS_CONNECTION_145", 145);

    /**
     * Directory server DS(%d) at %s presented generation ID %d for domain "%s", but the generation ID of this replication server RS(%d) is %d. This usually indicates that one or more directory servers in the replication topology have not been initialized with the same data, and re-initialization is required
     */
    public static final LocalizableMessageDescriptor.Arg6<Number, Object, Number, Object, Number, Number> WARN_BAD_GENERATION_ID_FROM_DS =
                    new LocalizableMessageDescriptor.Arg6<Number, Object, Number, Object, Number, Number>(ReplicationMessages.class, RESOURCE, "WARN_BAD_GENERATION_ID_FROM_DS_146", 146);

    /**
     * In replication service %s and server id %s, the assured update message %s was acknowledged with the following errors: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> NOTE_DS_RECEIVED_ACK_ERROR =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_DS_RECEIVED_ACK_ERROR_147", 147);

    /**
     * In replication service %s, timeout after %s ms waiting for the acknowledgement of the assured update message: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_DS_ACK_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_DS_ACK_TIMEOUT_148", 148);

    /**
     * In directory server %s, received unknown assured update mode: %s, for domain %s. Message: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_DS_UNKNOWN_ASSURED_MODE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_UNKNOWN_ASSURED_MODE_149", 149);

    /**
     * In replication server %s, received unknown assured update mode: %s, for domain %s. Message: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_RS_UNKNOWN_ASSURED_MODE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_UNKNOWN_ASSURED_MODE_150", 150);

    /**
     * In replication server %s, received a safe data assured update message with incoherent level: %s, this is for domain %s. Message: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_UNKNOWN_ASSURED_SAFE_DATA_LEVEL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_UNKNOWN_ASSURED_SAFE_DATA_LEVEL_151", 151);

    /**
     * The generation ID could not be reset for domain %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RESET_GENERATION_ID_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_RESET_GENERATION_ID_FAILED_152", 152);

    /**
     * Cannot change the configuration while a total update is in progress
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_ERR_CANNOT_CHANGE_CONFIG_DURING_TOTAL_UPDATE =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "NOTE_ERR_CANNOT_CHANGE_CONFIG_DURING_TOTAL_UPDATE_153", 153);

    /**
     * The Replication was not started on base-dn %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COULD_NOT_START_REPLICATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_START_REPLICATION_154", 154);

    /**
     * Replication protocol error. Bad message type. %s received, %s required
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_PROTOCOL_MESSAGE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_REPLICATION_PROTOCOL_MESSAGE_TYPE_157", 157);

    /**
     * The Server Handler byte count is not correct Byte Count=%s (Fixed)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BYTE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_BYTE_COUNT_159", 159);

    /**
     * Wrong fractional replication configuration: could not find object class definition for %s in schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_FRACTIONAL_CONFIG_UNKNOWN_OBJECT_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_UNKNOWN_OBJECT_CLASS_160", 160);

    /**
     * Wrong fractional replication configuration : could not find attribute type definition for %s in schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_FRACTIONAL_CONFIG_UNKNOWN_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_UNKNOWN_ATTRIBUTE_TYPE_161", 161);

    /**
     * Wrong fractional replication configuration : attribute %s is not optional in class %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FRACTIONAL_CONFIG_NOT_OPTIONAL_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_NOT_OPTIONAL_ATTRIBUTE_162", 162);

    /**
     * Wrong fractional replication configuration : wrong format : %s (need at least [<className>|*],attributeName)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_FRACTIONAL_CONFIG_WRONG_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_WRONG_FORMAT_163", 163);

    /**
     * Wrong fractional replication configuration : cannot use both exclusive and inclusive modes
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_ERR_FRACTIONAL_CONFIG_BOTH_MODES =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_BOTH_MODES_164", 164);

    /**
     * Wrong fractional replication configuration : prohibited attribute %s usage
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_FRACTIONAL_CONFIG_PROHIBITED_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_CONFIG_PROHIBITED_ATTRIBUTE_165", 165);

    /**
     * Fractional replication : exception for domain : %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FRACTIONAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_166", 166);

    /**
     * Warning : domain %s fractional replication configuration is inconsistent with backend data set : need resynchronization or fractional configuration to be changed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_FRACTIONAL_BAD_DATA_SET_NEED_RESYNC =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_FRACTIONAL_BAD_DATA_SET_NEED_RESYNC_167", 167);

    /**
     * The fractional replication ldif import plugin is configured with invalid plugin type %s. Only the ldifImport plugin type is allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PLUGIN_FRACTIONAL_LDIF_IMPORT_INVALID_PLUGIN_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_PLUGIN_FRACTIONAL_LDIF_IMPORT_INVALID_PLUGIN_TYPE_168", 168);

    /**
     * The online full update for importing suffix %s data from remote directory server %s has been stopped due to fractional configuration inconsistency between destination and source server : imported data set has not the same fractional configuration
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FULL_UPDATE_IMPORT_FRACTIONAL_BAD_REMOTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FULL_UPDATE_IMPORT_FRACTIONAL_BAD_REMOTE_169", 169);

    /**
     * The online full update for importing suffix %s data from remote directory server %s has been stopped due to fractional configuration inconsistency between destination and source server : imported data set has some fractional configuration but not destination server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FULL_UPDATE_IMPORT_FRACTIONAL_REMOTE_IS_FRACTIONAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FULL_UPDATE_IMPORT_FRACTIONAL_REMOTE_IS_FRACTIONAL_170", 170);

    /**
     * The following operation has been forbidden in suffix %s due to inconsistency with the fractional replication configuration : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FRACTIONAL_FORBIDDEN_OPERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_FORBIDDEN_OPERATION_171", 171);

    /**
     * The export of domain %s from server %s to all other servers of the topology is forbidden as the source server has some fractional configuration : only fractional servers in a replicated topology does not make sense
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_FRACTIONAL_FORBIDDEN_FULL_UPDATE_FRACTIONAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_FRACTIONAL_FORBIDDEN_FULL_UPDATE_FRACTIONAL_172", 172);

    /**
     * An error occurred when accessing the change number database : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGENUMBER_DATABASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGENUMBER_DATABASE_173", 173);

    /**
     * The initialization failed because the domain %s is not connected to a replication server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INITIALIZATION_FAILED_NOCONN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INITIALIZATION_FAILED_NOCONN_174", 174);

    /**
     * Could not retrieve the configuration for a replication domain matching the entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FRACTIONAL_COULD_NOT_RETRIEVE_CONFIG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_FRACTIONAL_COULD_NOT_RETRIEVE_CONFIG_175", 175);

    /**
     * The LDIF import for importing suffix %s data has been stopped due to fractional configuration inconsistency : imported data set has not the same fractional configuration as local server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_LDIF_IMPORT_FRACTIONAL_BAD_DATA_SET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_LDIF_IMPORT_FRACTIONAL_BAD_DATA_SET_176", 176);

    /**
     * The LDIF import for importing suffix %s data has been stopped due to fractional configuration inconsistency : imported data set has some fractional configuration but not local server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ERR_LDIF_IMPORT_FRACTIONAL_DATA_SET_IS_FRACTIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_LDIF_IMPORT_FRACTIONAL_DATA_SET_IS_FRACTIONAL_177", 177);

    /**
     * Directory server %s was attempting to connect to replication server %s but has disconnected in handshake phase
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DS_DISCONNECTED_DURING_HANDSHAKE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_DISCONNECTED_DURING_HANDSHAKE_178", 178);

    /**
     * Replication server %s was attempting to connect to replication server %s but has disconnected in handshake phase
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RS_DISCONNECTED_DURING_HANDSHAKE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_DISCONNECTED_DURING_HANDSHAKE_179", 179);

    /**
     * Directory server DS(%d) encountered an error while receiving changes for domain "%s" from replication server RS(%d) at %s. The connection will be closed, and this directory server will now try to connect to another replication server
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> WARN_REPLICATION_SERVER_BADLY_DISCONNECTED =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "WARN_REPLICATION_SERVER_BADLY_DISCONNECTED_180", 180);

    /**
     * The connection from this replication server RS(%d) to replication server RS(%d) at %s for domain "%s" has failed
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> ERR_RS_BADLY_DISCONNECTED =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RS_BADLY_DISCONNECTED_181", 181);

    /**
     * Error when loading a virtual attribute for external change log: Attribute: %s , Error: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_UNABLE_TO_ENABLE_ECL_VIRTUAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_UNABLE_TO_ENABLE_ECL_VIRTUAL_ATTR_182", 182);

    /**
     * Error in %s when enabling the external change log: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_ERR_UNABLE_TO_ENABLE_ECL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_ERR_UNABLE_TO_ENABLE_ECL_183", 183);

    /**
     * Full resync required. Reason: The provided cookie contains unknown replicated domain %s. Current starting cookie <%s>
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESYNC_REQUIRED_UNKNOWN_DOMAIN_IN_PROVIDED_COOKIE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RESYNC_REQUIRED_UNKNOWN_DOMAIN_IN_PROVIDED_COOKIE_185", 185);

    /**
     * Full resync required. Reason: The provided cookie is older than the start of historical in the server for the replicated domain : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RESYNC_REQUIRED_TOO_OLD_DOMAIN_IN_PROVIDED_COOKIE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_RESYNC_REQUIRED_TOO_OLD_DOMAIN_IN_PROVIDED_COOKIE_186", 186);

    /**
     * Invalid syntax for the provided cookie '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_COOKIE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INVALID_COOKIE_SYNTAX_187", 187);

    /**
     * Directory Server DS(%d) is switching from replication server RS(%d) at %s to RS(%d) for domain "%s" because it is more suitable. The previous replication server evaluation was: "%s", and the new replication server evaluation was: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg7<Number, Number, Object, Number, Object, Object, Object> NOTE_NEW_BEST_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg7<Number, Number, Object, Number, Object, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_NEW_BEST_REPLICATION_SERVER_188", 188);

    /**
     * Domain %s (server id: %s) : remote exporter server disconnection (server id: %s ) detected during initialization
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_INIT_EXPORTER_DISCONNECTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_EXPORTER_DISCONNECTION_189", 189);

    /**
     * During initialization from a remote server, the following error occurred : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_IMPORT_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_IMPORT_FAILURE_190", 190);

    /**
     * Connection failure with Replication Server %s during import
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_RS_DISCONNECTION_DURING_IMPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_RS_DISCONNECTION_DURING_IMPORT_191", 191);

    /**
     * Bad msg id sequence during import. Expected:%s Actual:%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INIT_BAD_MSG_ID_SEQ_DURING_IMPORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_BAD_MSG_ID_SEQ_DURING_IMPORT_192", 192);

    /**
     * The following servers did not acknowledge initialization in the expected time for domain %s. They are potentially down or too slow. Servers list: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INIT_NO_SUCCESS_START_FROM_SERVERS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_NO_SUCCESS_START_FROM_SERVERS_193", 193);

    /**
     * The following servers did not end initialization being connected with the right generation (%s). They are potentially stopped or too slow. Servers list: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INIT_NO_SUCCESS_END_FROM_SERVERS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_NO_SUCCESS_END_FROM_SERVERS_194", 194);

    /**
     * When initializing remote server(s), connection to Replication Server with serverId=%s is lost
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_RS_DISCONNECTION_DURING_EXPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_RS_DISCONNECTION_DURING_EXPORT_195", 195);

    /**
     * When initializing remote server(s), the initialized server with serverId=%s is potentially stopped or too slow
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INIT_HEARTBEAT_LOST_DURING_EXPORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_INIT_HEARTBEAT_LOST_DURING_EXPORT_196", 196);

    /**
     * When sending a new initialization request for an initialization from a remote server, the following error occurred %s. The initial error was : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SENDING_NEW_ATTEMPT_INIT_REQUEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_SENDING_NEW_ATTEMPT_INIT_REQUEST_197", 197);

    /**
     * Resending a new initialization request for an initialization from a remote server due to the root error : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_RESENDING_INIT_FROM_REMOTE_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_RESENDING_INIT_FROM_REMOTE_REQUEST_198", 198);

    /**
     * Resending a new initialization start for an initialization of a remote server due to the root error : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_RESENDING_INIT_TARGET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "NOTE_RESENDING_INIT_TARGET_199", 199);

    /**
     * Processing two different changes with same CSN=%s. Previous msg=<%s>, New msg=<%s>
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_RSQUEUE_DIFFERENT_MSGS_WITH_SAME_CSN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_RSQUEUE_DIFFERENT_MSGS_WITH_SAME_CSN_201", 201);

    /**
     * Error while trying to solve conflict with DN : %s ERROR : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COULD_NOT_SOLVE_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_SOLVE_CONFLICT_202", 202);

    /**
     * Monitor data for the domain "%s" has been received from replication server RS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> NOTE_MONITOR_DATA_RECEIVED =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "NOTE_MONITOR_DATA_RECEIVED_203", 203);

    /**
     * Replication server RS(%d) started listening for new connections on address %s port %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Number> NOTE_REPLICATION_SERVER_LISTENING =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Number>(ReplicationMessages.class, RESOURCE, "NOTE_REPLICATION_SERVER_LISTENING_204", 204);

    /**
     * Replication server RS(%d) has connected to replication server RS(%d) for domain "%s" at %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> INFO_REPLICATION_SERVER_CONNECTION_TO_RS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "INFO_REPLICATION_SERVER_CONNECTION_TO_RS_205", 205);

    /**
     * Replication server RS(%d) has accepted a connection from replication server RS(%d) for domain "%s" at %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> INFO_REPLICATION_SERVER_CONNECTION_FROM_RS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "INFO_REPLICATION_SERVER_CONNECTION_FROM_RS_206", 206);

    /**
     * Replication server RS(%d) has accepted a connection from directory server DS(%d) for domain "%s" at %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> INFO_REPLICATION_SERVER_CONNECTION_FROM_DS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "INFO_REPLICATION_SERVER_CONNECTION_FROM_DS_207", 207);

    /**
     * Directory server DS(%d) was unable to connect to any replication servers for domain "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> WARN_NO_AVAILABLE_CHANGELOGS =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ReplicationMessages.class, RESOURCE, "WARN_NO_AVAILABLE_CHANGELOGS_208", 208);

    /**
     * Starting total update: exporting %d entries in domain "%s" from this directory server DS(%d) to all remote directory servers
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Number> NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_START_ALL =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Number>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_START_ALL_209", 209);

    /**
     * Finished total update: exported domain "%s" from this directory server DS(%d) to all remote directory servers. %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_END_ALL =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ReplicationMessages.class, RESOURCE, "NOTE_FULL_UPDATE_ENGAGED_FOR_REMOTE_END_ALL_210", 210);

    /**
     * The connection from this replication server RS(%d) to directory server DS(%d) at %s for domain "%s" has failed
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> ERR_DS_BADLY_DISCONNECTED =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_DS_BADLY_DISCONNECTED_211", 211);

    /**
     * Directory server DS(%d) timed out while connecting to replication server %s for domain "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_TIMEOUT_CONNECTING_TO_RS =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ReplicationMessages.class, RESOURCE, "WARN_TIMEOUT_CONNECTING_TO_RS_212", 212);

    /**
     * Directory Server DS(%d) is disconnecting from replication server RS(%d) at %s for domain "%s" in order to find another replication server in the topology and distribute load more equally
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object> NOTE_LOAD_BALANCE_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "NOTE_LOAD_BALANCE_REPLICATION_SERVER_213", 213);

    /**
     * The attribute value '%s' is not a valid synchronization history value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_INVALID_SYNC_HIST_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "WARN_INVALID_SYNC_HIST_VALUE_214", 214);

    /**
     * %s was interrupted in the startup phase
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SESSION_STARTUP_INTERRUPTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_SESSION_STARTUP_INTERRUPTED_216", 216);

    /**
     * Cannot open database %s because shutdown was requested from replication server RS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_CANNOT_OPEN_DATABASE_BECAUSE_SHUTDOWN_WAS_REQUESTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "WARN_CANNOT_OPEN_DATABASE_BECAUSE_SHUTDOWN_WAS_REQUESTED_218", 218);

    /**
     * RS(%d) was not configured locally on DS(%d), but at least one other RS was
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_RS_NOT_LOCALLY_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_NOT_LOCALLY_CONFIGURED_219", 219);

    /**
     * RS(%d) has no generation Id, but at least one other RS has the same generation Id %d as DS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> NOTE_RS_HAS_NO_GENERATION_ID =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_HAS_NO_GENERATION_ID_220", 220);

    /**
     * RS(%d) generation Id %d does not match DS(%d) generation Id %d, but at least another RS does
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_RS_HAS_DIFFERENT_GENERATION_ID_THAN_DS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_HAS_DIFFERENT_GENERATION_ID_THAN_DS_221", 221);

    /**
     * RS(%d) groupId %d does not match DS(%d) groupId %d, but at least another RS does
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> NOTE_RS_HAS_DIFFERENT_GROUP_ID_THAN_DS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_HAS_DIFFERENT_GROUP_ID_THAN_DS_222", 222);

    /**
     * RS(%d) newest change %s is behind DS(%d) newest change %s, but at least another RS is at the same point or ahead of the DS
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> NOTE_RS_LATER_THAN_LOCAL_DS =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "NOTE_RS_LATER_THAN_LOCAL_DS_223", 223);

    /**
     * RS(%d) newest change %s is behind another RS which is ahead of DS(%d) newest change %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object> NOTE_RS_LATER_THAN_ANOTHER_RS_MORE_UP_TO_DATE_THAN_LOCAL_DS =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Number, Object>(ReplicationMessages.class, RESOURCE, "NOTE_RS_LATER_THAN_ANOTHER_RS_MORE_UP_TO_DATE_THAN_LOCAL_DS_224", 224);

    /**
     * RS(%d) is on the same host, but a different virtual machine than DS(%d), but at least another RS is
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_RS_ON_DIFFERENT_VM_THAN_DS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_ON_DIFFERENT_VM_THAN_DS_225", 225);

    /**
     * RS(%d) is on a different host than DS(%d), but at least another RS is on the same host
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_RS_ON_DIFFERENT_HOST_THAN_DS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_RS_ON_DIFFERENT_HOST_THAN_DS_226", 226);

    /**
     * DS(%d) disconnected from overloaded RS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_DISCONNECT_DS_FROM_OVERLOADED_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_DISCONNECT_DS_FROM_OVERLOADED_RS_227", 227);

    /**
     * DS(%d) not disconnected from overloaded RS(%d), other DSs will disconnect
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_DO_NOT_DISCONNECT_DS_FROM_OVERLOADED_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_DO_NOT_DISCONNECT_DS_FROM_OVERLOADED_RS_228", 228);

    /**
     * DS(%d) not disconnected from current RS(%d), since there is no need to rebalance all directory servers to other replication servers in the topology
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_NO_NEED_TO_REBALANCE_DSS_BETWEEN_RSS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_NO_NEED_TO_REBALANCE_DSS_BETWEEN_RSS_229", 229);

    /**
     * DS(%d) not disconnected from current RS(%d), because RS is underloaded or its load goal is reached
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_DO_NOT_DISCONNECT_DS_FROM_ACCEPTABLE_LOAD_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_DO_NOT_DISCONNECT_DS_FROM_ACCEPTABLE_LOAD_RS_230", 230);

    /**
     * DS(%d) will connect to RS(%d) because it has the biggest weight among all the replication servers
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_BIGGEST_WEIGHT_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_BIGGEST_WEIGHT_RS_231", 231);

    /**
     * DS(%d) stayed connected to RS(%d) to avoid the yoyo effect
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_AVOID_YOYO_EFFECT =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_AVOID_YOYO_EFFECT_232", 232);

    /**
     * RS(%d) has been evaluated to be the best replication server for DS(%d) to connect to because it was the only one standing after all tests
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_BEST_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_BEST_RS_233", 233);

    /**
     * RS(%d) could not be contacted by DS(%d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> NOTE_UNKNOWN_RS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ReplicationMessages.class, RESOURCE, "NOTE_UNKNOWN_RS_234", 234);

    /**
     * Could not create replica database because the changelog database is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_CREATE_REPLICA_DB_BECAUSE_CHANGELOG_DB_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "ERR_CANNOT_CREATE_REPLICA_DB_BECAUSE_CHANGELOG_DB_SHUTDOWN_235", 235);

    /**
     * An unexpected error forced the %s thread to shutdown: %s. The changeNumber attribute will not move forward anymore. You can reenable this thread by first setting the "compute-change-number" property to false and then back to true
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGE_NUMBER_INDEXER_UNEXPECTED_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGE_NUMBER_INDEXER_UNEXPECTED_EXCEPTION_236", 236);

    /**
     * Could not add change %s to replicaDB %s %s because flushing thread is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COULD_NOT_ADD_CHANGE_TO_SHUTTING_DOWN_REPLICA_DB =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_COULD_NOT_ADD_CHANGE_TO_SHUTTING_DOWN_REPLICA_DB_240", 240);

    /**
     * Error when retrieving changelog state from root path '%s' : IO error on domain directory '%s' when retrieving list of server ids
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_READ_STATE_CANT_READ_DOMAIN_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_READ_STATE_CANT_READ_DOMAIN_DIRECTORY_243", 243);

    /**
     * Could not get or create replica DB for baseDN '%s', serverId '%d', generationId '%d': %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_CHANGELOG_UNABLE_TO_CREATE_REPLICA_DB =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_REPLICA_DB_244", 244);

    /**
     * Could not get or create change number index DB in root path '%s', using path '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_CREATE_CN_INDEX_DB =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_CN_INDEX_DB_245", 245);

    /**
     * Could not retrieve generation id file '%s' for DN '%s' to delete it
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_DELETE_GENERATION_ID_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DELETE_GENERATION_ID_FILE_246", 246);

    /**
     * Could not create directory '%s' for server id %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHANGELOG_UNABLE_TO_CREATE_SERVER_ID_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_SERVER_ID_DIRECTORY_247", 247);

    /**
     * Could not create generation id file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_CREATE_GENERATION_ID_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_GENERATION_ID_FILE_248", 248);

    /**
     * Could not read server id filename because it uses a wrong format, expecting '[id].server' where [id] is numeric but got '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_SERVER_ID_FILENAME_WRONG_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_SERVER_ID_FILENAME_WRONG_FORMAT_250", 250);

    /**
     * Could not read generation id because it uses a wrong format, expecting a number but got '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_GENERATION_ID_WRONG_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_GENERATION_ID_WRONG_FORMAT_251", 251);

    /**
     * Could not open log file '%s' for write
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_OPEN_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_OPEN_LOG_FILE_252", 252);

    /**
     * Could not open a reader on log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_OPEN_READER_ON_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_OPEN_READER_ON_LOG_FILE_253", 253);

    /**
     * Could not decode a record from data read in log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_DECODE_RECORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DECODE_RECORD_254", 254);

    /**
     * Could not delete log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_DELETE_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DELETE_LOG_FILE_255", 255);

    /**
     * Could not create log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_CREATE_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_LOG_FILE_256", 256);

    /**
     * The changelog '%s' has been opened in read-only mode, it is not enabled for write
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CHANGELOG_NOT_ENABLED_FOR_WRITE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "WARN_CHANGELOG_NOT_ENABLED_FOR_WRITE_257", 257);

    /**
     * Could not add record '%s' in log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_ADD_RECORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_ADD_RECORD_258", 258);

    /**
     * Could not synchronize written records to file system for log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_SYNC =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_SYNC_259", 259);

    /**
     * Could not seek to position %d for reader on log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_CHANGELOG_UNABLE_TO_SEEK =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_SEEK_260", 260);

    /**
     * Could not create root directory '%s' for log file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_CREATE_LOG_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_LOG_DIRECTORY_261", 261);

    /**
     * Could not decode DN from domain state file '%s', from line '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_DECODE_DN_FROM_DOMAIN_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DECODE_DN_FROM_DOMAIN_STATE_FILE_262", 262);

    /**
     * Could not read domain state file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_READ_DOMAIN_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_READ_DOMAIN_STATE_FILE_263", 263);

    /**
     * There is a mismatch between domain state file and actual domain directories found in file system. Expected domain ids : '%s'. Actual domain ids found in file system: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_INCOHERENT_DOMAIN_STATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_INCOHERENT_DOMAIN_STATE_264", 264);

    /**
     * Could not create a new domain id %s for domain DN %s and save it in domain state file '%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CHANGELOG_UNABLE_TO_UPDATE_DOMAIN_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_UPDATE_DOMAIN_STATE_FILE_265", 265);

    /**
     * Could not get reader position for cursor in log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_GET_CURSOR_READER_POSITION_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_GET_CURSOR_READER_POSITION_LOG_FILE_266", 266);

    /**
     * Could not decode the key from string [%s]
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_DECODE_KEY_FROM_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DECODE_KEY_FROM_STRING_267", 267);

    /**
     * When closing log '%s', found %d cursor(s) still opened on the log
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHANGELOG_CURSOR_OPENED_WHILE_CLOSING_LOG =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_CURSOR_OPENED_WHILE_CLOSING_LOG_269", 269);

    /**
     * Could not initialize the log '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_INITIALIZE_LOG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_INITIALIZE_LOG_270", 270);

    /**
     * Could not retrieve key bounds from log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_RETRIEVE_KEY_BOUNDS_FROM_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_RETRIEVE_KEY_BOUNDS_FROM_FILE_271", 271);

    /**
     * Could not retrieve read-only log files from log '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_RETRIEVE_READ_ONLY_LOG_FILES_LIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_RETRIEVE_READ_ONLY_LOG_FILES_LIST_272", 272);

    /**
     * While purging log, could not delete log file(s): '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_DELETE_LOG_FILE_WHILE_PURGING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DELETE_LOG_FILE_WHILE_PURGING_273", 273);

    /**
     * The following log '%s' must be released but it is not referenced."
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNREFERENCED_LOG_WHILE_RELEASING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNREFERENCED_LOG_WHILE_RELEASING_274", 274);

    /**
     * Could not rename head log file from '%s' to '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_RENAME_HEAD_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_RENAME_HEAD_LOG_FILE_275", 275);

    /**
     * Rotation needed for log file '%s', size of head log file is %d bytes
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_CHANGELOG_LOG_FILE_ROTATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "INFO_CHANGELOG_LOG_FILE_ROTATION_276", 276);

    /**
     * Could not write offline replica information for domain %s and server id %d, using path '%s' (offline CSN is %s)
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_CHANGELOG_UNABLE_TO_WRITE_REPLICA_OFFLINE_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_WRITE_REPLICA_OFFLINE_STATE_FILE_278", 278);

    /**
     * Could not read replica offline state file '%s' for domain %s, it should contain exactly one line corresponding to the offline CSN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_INVALID_REPLICA_OFFLINE_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_INVALID_REPLICA_OFFLINE_STATE_FILE_279", 279);

    /**
     * Could not read content of replica offline state file '%s' for domain %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_READ_REPLICA_OFFLINE_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_READ_REPLICA_OFFLINE_STATE_FILE_280", 280);

    /**
     * Could not delete replica offline state file '%s' for domain %s and server id %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_CHANGELOG_UNABLE_TO_DELETE_REPLICA_OFFLINE_STATE_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DELETE_REPLICA_OFFLINE_STATE_FILE_281", 281);

    /**
     * Could not retrieve file length of log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_RETRIEVE_FILE_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_RETRIEVE_FILE_LENGTH_282", 282);

    /**
     * An error occurred while recovering the replication change log file '%s'. The recovery has been aborted and this replication server will be removed from the replication topology. The change log file system may be read-only, full, or corrupt and must be fixed before this replication server can be used. The underlying error was: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CHANGELOG_UNABLE_TO_RECOVER_LOG_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_RECOVER_LOG_FILE_283", 283);

    /**
     * Log file '%s' was successfully recovered by removing a partially written record
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CHANGELOG_LOG_FILE_RECOVERED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "INFO_CHANGELOG_LOG_FILE_RECOVERED_284", 284);

    /**
     * You do not have sufficient privileges to perform a search request on cn=changelog
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_SEARCH_CHANGELOG_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ReplicationMessages.class, RESOURCE, "NOTE_SEARCH_CHANGELOG_INSUFFICIENT_PRIVILEGES_285", 285);

    /**
     * An error occurred when searching base DN '%s' with filter '%s' in changelog backend : %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CHANGELOG_BACKEND_SEARCH =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_BACKEND_SEARCH_286", 286);

    /**
     * An error occurred when retrieving attribute value for attribute '%s' for entry DN '%s' in changelog backend : %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CHANGELOG_BACKEND_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_BACKEND_ATTRIBUTE_287", 287);

    /**
     * Could not create file '%s' to store last log rotation time %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHANGELOG_UNABLE_TO_CREATE_LAST_LOG_ROTATION_TIME_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_CREATE_LAST_LOG_ROTATION_TIME_FILE_288", 288);

    /**
     * Could not delete file '%s' that stored the previous last log rotation time
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_UNABLE_TO_DELETE_LAST_LOG_ROTATION_TIME_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_UNABLE_TO_DELETE_LAST_LOG_ROTATION_TIME_FILE_289", 289);

    /**
     * Cursor on log '%s' has been aborted after a purge or a clear
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_CURSOR_ABORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_CURSOR_ABORTED_290", 290);

    /**
     * Could not position and read newest record from log file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHANGELOG_CANNOT_READ_NEWEST_RECORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_CANNOT_READ_NEWEST_RECORD_291", 291);

    /**
     * The change number index could not be reset to start with %d in base DN '%s' because starting CSN '%s' does not exist in the change log
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_CHANGELOG_RESET_CHANGE_NUMBER_CHANGE_NOT_PRESENT =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_RESET_CHANGE_NUMBER_CHANGE_NOT_PRESENT_293", 293);

    /**
     * The change number could not be reset to %d because the associated change with CSN '%s' has already been purged from the change log. Try resetting to a more recent change
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_CHANGELOG_RESET_CHANGE_NUMBER_CSN_TOO_OLD =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ReplicationMessages.class, RESOURCE, "ERR_CHANGELOG_RESET_CHANGE_NUMBER_CSN_TOO_OLD_294", 294);

    /**
     * Change number indexing is disabled for replication domain '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_CHANGE_NUMBER_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ReplicationMessages.class, RESOURCE, "ERR_REPLICATION_CHANGE_NUMBER_DISABLED_295", 295);

    /**
     * Filtering out from log file '%s' the record '%s' because it would break ordering. Last key appended is '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_CHANGELOG_FILTER_OUT_RECORD_BREAKING_ORDER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ReplicationMessages.class, RESOURCE, "INFO_CHANGELOG_FILTER_OUT_RECORD_BREAKING_ORDER_296", 296);

    /**
     * Cannot decode change-log record with version %x
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_UNRECOGNIZED_RECORD_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(ReplicationMessages.class, RESOURCE, "ERR_UNRECOGNIZED_RECORD_VERSION_297", 297);

    /**
     * Cannot start total update in domain "%s" from this directory server DS(%d): no remote directory servers exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_FULL_UPDATE_NO_REMOTES =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ReplicationMessages.class, RESOURCE, "ERR_FULL_UPDATE_NO_REMOTES_298", 298);

    /**
     * Cannot start total update in domain "%s" from this directory server DS(%d): the remote directory server DS(%d) is unknown
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_FULL_UPDATE_MISSING_REMOTE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ReplicationMessages.class, RESOURCE, "ERR_FULL_UPDATE_MISSING_REMOTE_299", 299);

    /**
     * New replication connection from %s started with unexpected message %s and is being closed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_UNEXPECTED_MESSAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ReplicationMessages.class, RESOURCE, "ERR_REPLICATION_UNEXPECTED_MESSAGE_300", 300);

}
