package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.logger}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/logger.properties} and it should not be manually edited.
 */
public final class LoggerMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.logger";

    // Prevent instantiation.
    private LoggerMessages() {
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
     * Error occurred while writing log record for logger %s: %s. Any further write errors will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOGGER_ERROR_WRITING_RECORD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_WRITING_RECORD_1", 1);

    /**
     * Error occurred while opening log file %s for logger %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LOGGER_ERROR_OPENING_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_OPENING_FILE_2", 2);

    /**
     * Error occurred while closing log file for logger %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOGGER_ERROR_CLOSING_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_CLOSING_FILE_3", 3);

    /**
     * Error occurred while flushing writer buffer for logger %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOGGER_ERROR_FLUSHING_BUFFER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_FLUSHING_BUFFER_4", 4);

    /**
     * Invalid error log severity "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ERROR_LOGGER_INVALID_SEVERITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "WARN_ERROR_LOGGER_INVALID_SEVERITY_5", 5);

    /**
     * Invalid error log category "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ERROR_LOGGER_INVALID_CATEGORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "WARN_ERROR_LOGGER_INVALID_CATEGORY_6", 6);

    /**
     * Invalid override of severity level "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ERROR_LOGGER_INVALID_OVERRIDE_SEVERITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "WARN_ERROR_LOGGER_INVALID_OVERRIDE_SEVERITY_7", 7);

    /**
     * Error occurred while setting file permissions for the log file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LOGGER_SET_PERMISSION_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "WARN_LOGGER_SET_PERMISSION_FAILED_8", 8);

    /**
     * This platform does not support setting file permissions %s to the log file %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LOGGER_UNABLE_SET_PERMISSIONS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "WARN_LOGGER_UNABLE_SET_PERMISSIONS_9", 9);

    /**
     * Error occurred while listing log files named by policy with initial file name %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LOGGER_ERROR_LISTING_FILES =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_LISTING_FILES_10", 10);

    /**
     * Error occurred while obtaining free disk space in the partition containing log file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LOGGER_ERROR_OBTAINING_FREE_SPACE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_OBTAINING_FREE_SPACE_11", 11);

    /**
     * Error occurred while enforcing retention policy %s for logger %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LOGGER_ERROR_ENFORCING_RETENTION_POLICY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_LOGGER_ERROR_ENFORCING_RETENTION_POLICY_12", 12);

    /**
     * Error occurred while creating common audit facility: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMON_AUDIT_CREATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_CREATE_13", 13);

    /**
     * Error while creating or updating common audit log publisher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_ADD_OR_UPDATE_LOG_PUBLISHER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_ADD_OR_UPDATE_LOG_PUBLISHER_14", 14);

    /**
     * Error while removing common audit log publisher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_REMOVE_LOG_PUBLISHER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_REMOVE_LOG_PUBLISHER_15", 15);

    /**
     * Error while adding common audit log publisher %s, the publisher has an unsupported handler type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMON_AUDIT_UNSUPPORTED_HANDLER_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_UNSUPPORTED_HANDLER_TYPE_16", 16);

    /**
     * Error while reading JSON configuration file %s while creating common audit external log publisher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COMMON_AUDIT_EXTERNAL_HANDLER_JSON_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_EXTERNAL_HANDLER_JSON_FILE_17", 17);

    /**
     * Error while creating common audit external log publisher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_EXTERNAL_HANDLER_CREATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_EXTERNAL_HANDLER_CREATION_18", 18);

    /**
     * Error while creating common audit log publisher %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_FILE_BASED_HANDLER_CREATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_FILE_BASED_HANDLER_CREATION_19", 19);

    /**
     * Error while adding common audit log publisher %s, the publisher defines an unsupported log rotation policy %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_UNSUPPORTED_LOG_ROTATION_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_UNSUPPORTED_LOG_ROTATION_POLICY_20", 20);

    /**
     * Error while adding common audit log publisher %s, the publisher defines an unsupported log retention policy %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_UNSUPPORTED_LOG_RETENTION_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_UNSUPPORTED_LOG_RETENTION_POLICY_21", 21);

    /**
     * Error while processing common audit log publisher %s, this type of log publisher is unsupported
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMON_AUDIT_UNSUPPORTED_LOG_PUBLISHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_UNSUPPORTED_LOG_PUBLISHER_22", 22);

    /**
     * Error while processing common audit log publisher %s, delimiter char '%s' should not contains more than one character
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_CSV_HANDLER_DELIMITER_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_CSV_HANDLER_DELIMITER_CHAR_23", 23);

    /**
     * Error while processing common audit log publisher %s, quote char '%s' should not contains more than one character
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_CSV_HANDLER_QUOTE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_CSV_HANDLER_QUOTE_CHAR_24", 24);

    /**
     * Error while processing common audit log publisher %s, time of the day value '%s' for fixed time log rotation policy is not valid, it should use a 24-hour format "HHmm" : %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COMMON_AUDIT_INVALID_TIME_OF_DAY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_INVALID_TIME_OF_DAY_25", 25);

    /**
     * Error while decoding a transaction id control received from a request: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMON_AUDIT_INVALID_TRANSACTION_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_INVALID_TRANSACTION_ID_26", 26);

    /**
     * Error while processing a log event for common audit: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMON_AUDIT_UNABLE_TO_PROCESS_LOG_EVENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_UNABLE_TO_PROCESS_LOG_EVENT_27", 27);

    /**
     * Error while processing common audit log publisher %s, the keystore pin file %s is missing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_KEYSTORE_PIN_FILE_MISSING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_KEYSTORE_PIN_FILE_MISSING_28", 28);

    /**
     * Error while processing common audit log publisher %s, the keystore pin file %s could not be read: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COMMON_AUDIT_ERROR_READING_KEYSTORE_PIN_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_ERROR_READING_KEYSTORE_PIN_FILE_29", 29);

    /**
     * Error while processing common audit log publisher %s, the keystore pin file %s contains an empty pin
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_KEYSTORE_PIN_FILE_CONTAINS_EMPTY_PIN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_KEYSTORE_PIN_FILE_CONTAINS_EMPTY_PIN_30", 30);

    /**
     * Error while processing common audit log publisher %s, the keystore file %s is missing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_KEYSTORE_FILE_MISSING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_KEYSTORE_FILE_MISSING_31", 31);

    /**
     * Error while processing common audit log publisher %s, the keystore file %s could not be read: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_COMMON_AUDIT_ERROR_READING_KEYSTORE_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_ERROR_READING_KEYSTORE_FILE_32", 32);

    /**
     * Error while processing common audit log publisher %s, the keystore file %s is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_COMMON_AUDIT_KEYSTORE_FILE_IS_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(LoggerMessages.class, RESOURCE, "ERR_COMMON_AUDIT_KEYSTORE_FILE_IS_EMPTY_33", 33);

}
