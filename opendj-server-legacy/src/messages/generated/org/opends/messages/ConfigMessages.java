package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.config}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/config.properties} and it should not be manually edited.
 */
public final class ConfigMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.config";

    // Prevent instantiation.
    private ConfigMessages() {
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
     * Configuration attribute %s is required to have at least one value but the resulted operation would have removed all values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_IS_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_IS_REQUIRED_1", 1);

    /**
     * Provided value %s for configuration attribute %s was rejected. The reason provided was: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_REJECTED_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_REJECTED_VALUE_2", 2);

    /**
     * Configuration attribute %s is single-valued, but multiple values were provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_SET_VALUES_IS_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_SET_VALUES_IS_SINGLE_VALUED_3", 3);

    /**
     * Configuration attribute %s is single-valued, but adding the provided value(s) would have given it multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_ADD_VALUES_IS_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_ADD_VALUES_IS_SINGLE_VALUED_4", 4);

    /**
     * Configuration attribute %s already contains a value %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_ADD_VALUES_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_ADD_VALUES_ALREADY_EXISTS_5", 5);

    /**
     * Cannot remove value %s from configuration attribute %s because the specified value does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_NO_SUCH_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_NO_SUCH_VALUE_6", 6);

    /**
     * Unable to set the value for Boolean configuration attribute %s because the provided value %s was not either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_INVALID_BOOLEAN_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_BOOLEAN_VALUE_7", 7);

    /**
     * Unable to retrieve the value for configuration attribute %s as an integer because that attribute does not have any values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_NO_INT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_NO_INT_VALUE_8", 8);

    /**
     * Unable to retrieve the value for configuration attribute %s as an integer because that attribute has multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_MULTIPLE_INT_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_MULTIPLE_INT_VALUES_9", 9);

    /**
     * Unable to retrieve the value for configuration attribute %s as a Java int because the value is outside the allowable range for an int
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_VALUE_OUT_OF_INT_RANGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_VALUE_OUT_OF_INT_RANGE_10", 10);

    /**
     * Unable to set the value for integer configuration attribute %s because the provided value %s cannot be interpreted as an integer value: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INVALID_INT_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_INT_VALUE_11", 11);

    /**
     * Unable to set the value for configuration attribute %s because the provided value %d is less than the lowest allowed value of %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_CONFIG_ATTR_INT_BELOW_LOWER_BOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_BELOW_LOWER_BOUND_12", 12);

    /**
     * Unable to set the value for configuration attribute %s because the provided value %d is greater than the largest allowed value of %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_CONFIG_ATTR_INT_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_ABOVE_UPPER_BOUND_13", 13);

    /**
     * Unable to parse value %s for configuration attribute %s as an integer value: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INT_COULD_NOT_PARSE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_COULD_NOT_PARSE_14", 14);

    /**
     * Unable to retrieve the value for configuration attribute %s as a string because that attribute does not have any values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_NO_STRING_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_NO_STRING_VALUE_15", 15);

    /**
     * Unable to retrieve the value for configuration attribute %s as a string because that attribute has multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_MULTIPLE_STRING_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_MULTIPLE_STRING_VALUES_16", 16);

    /**
     * An empty value string was provided for configuration attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_EMPTY_STRING_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_EMPTY_STRING_VALUE_17", 17);

    /**
     * The value %s is not included in the list of acceptable values for configuration attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_VALUE_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_VALUE_NOT_ALLOWED_18", 18);

    /**
     * '%s' is not a valid unit for configuration attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_INVALID_UNIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_UNIT_19", 19);

    /**
     * Cannot decode %s as an integer value and a unit for configuration attribute %s because no value/unit delimiter could be found
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_NO_UNIT_DELIMITER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_NO_UNIT_DELIMITER_20", 20);

    /**
     * Could not decode the integer portion of value %s for configuration attribute %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_COULD_NOT_PARSE_INT_COMPONENT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_COULD_NOT_PARSE_INT_COMPONENT_21", 21);

    /**
     * The provided value %s for integer with unit attribute %s is not allowed: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INVALID_VALUE_WITH_UNIT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_VALUE_WITH_UNIT_22", 22);

    /**
     * Unable to add configuration entry %s as a child of configuration entry %s because a child entry was already found with that DN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ENTRY_CONFLICTING_CHILD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRY_CONFLICTING_CHILD_23", 23);

    /**
     * Unable to remove entry %s as a child of configuration entry %s because that entry did not have a child with the specified DN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ENTRY_NO_SUCH_CHILD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRY_NO_SUCH_CHILD_24", 24);

    /**
     * Unable to remove entry %s as a child of configuration entry %s because that entry had children of its own and non-leaf entries may not be removed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ENTRY_CANNOT_REMOVE_NONLEAF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRY_CANNOT_REMOVE_NONLEAF_25", 25);

    /**
     * The specified configuration file %s does not exist or is not readable
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DOES_NOT_EXIST_26", 26);

    /**
     * An unexpected error occurred while attempting to determine whether configuration file %s exists: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_CANNOT_VERIFY_EXISTENCE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CANNOT_VERIFY_EXISTENCE_27", 27);

    /**
     * An error occurred while attempting to open the configuration file %s for reading: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_CANNOT_OPEN_FOR_READ =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CANNOT_OPEN_FOR_READ_28", 28);

    /**
     * An error occurred while attempting to read the contents of configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_READ_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_READ_ERROR_29", 29);

    /**
     * Invalid configuration attribute %s detected: the only attribute option allowed in the Directory Server configuration is "pending" to indicate the set of pending values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_OPTIONS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_OPTIONS_NOT_ALLOWED_30", 30);

    /**
     * An error occurred at or near line %d while trying to parse the configuration from LDIF file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_CONFIG_FILE_INVALID_LDIF_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_INVALID_LDIF_ENTRY_31", 31);

    /**
     * The specified configuration file %s does not appear to contain any configuration entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_EMPTY_32", 32);

    /**
     * The first entry read from LDIF configuration file %s had a DN of "%s" rather than the expected "%s" which should be used as the Directory Server configuration root
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_INVALID_BASE_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_INVALID_BASE_DN_33", 33);

    /**
     * An unexpected error occurred while attempting to process the Directory Server configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_GENERIC_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_GENERIC_ERROR_34", 34);

    /**
     * Configuration entry %s starting at or near line %s in the LDIF configuration file %s has the same DN as another entry already read from that file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_DUPLICATE_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DUPLICATE_ENTRY_35", 35);

    /**
     * Configuration entry %s starting at or near line %d in the configuration LDIF file %s does not appear to have a parent entry (expected parent DN was %s)
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_CONFIG_FILE_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_NO_PARENT_36", 36);

    /**
     * The Directory Server was unable to determine the parent DN for configuration entry %s starting at or near line %d in the configuration LDIF file %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_CONFIG_FILE_UNKNOWN_PARENT =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_UNKNOWN_PARENT_37", 37);

    /**
     * Unable to determine the Directory Server instance root from either an environment variable or based on the location of the configuration file. Please set an environment variable named %s with a value containing the absolute path to the server installation root
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_CANNOT_DETERMINE_SERVER_ROOT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CANNOT_DETERMINE_SERVER_ROOT_38", 38);

    /**
     * An unexpected error occurred while trying to write configuration entry %s to LDIF: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_WRITE_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_WRITE_ERROR_39", 39);

    /**
     * An unexpected error occurred while trying to close the LDIF writer: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_CLOSE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CLOSE_ERROR_40", 40);

    /**
     * The Directory Server configuration may not be altered by importing a new configuration from LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_UNWILLING_TO_IMPORT =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_UNWILLING_TO_IMPORT_41", 41);

    /**
     * There are no active access loggers defined in the Directory Server configuration. No access logging will be performed
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CONFIG_LOGGER_NO_ACTIVE_ACCESS_LOGGERS =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "WARN_CONFIG_LOGGER_NO_ACTIVE_ACCESS_LOGGERS_44", 44);

    /**
     * There are no active error loggers defined in the Directory Server configuration. No error logging will be performed
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CONFIG_LOGGER_NO_ACTIVE_ERROR_LOGGERS =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "WARN_CONFIG_LOGGER_NO_ACTIVE_ERROR_LOGGERS_45", 45);

    /**
     * An error occurred while attempting to create a Directory Server logger from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGER_CANNOT_CREATE_LOGGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_CANNOT_CREATE_LOGGER_49", 49);

    /**
     * Configuration entry %s does not contain a valid objectclass for a Directory Server access, error, or debug logger definition
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_LOGGER_INVALID_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_INVALID_OBJECTCLASS_50", 50);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server access logger: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_LOGGER_INVALID_ACCESS_LOGGER_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_INVALID_ACCESS_LOGGER_CLASS_54", 54);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server error logger: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_LOGGER_INVALID_ERROR_LOGGER_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_INVALID_ERROR_LOGGER_CLASS_55", 55);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server debug logger: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_LOGGER_INVALID_DEBUG_LOGGER_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_INVALID_DEBUG_LOGGER_CLASS_56", 56);

    /**
     * Configuration attribute %s appears to contain multiple pending value sets
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_MULTIPLE_PENDING_VALUE_SETS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_MULTIPLE_PENDING_VALUE_SETS_64", 64);

    /**
     * Configuration attribute %s appears to contain multiple active value sets
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_MULTIPLE_ACTIVE_VALUE_SETS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_MULTIPLE_ACTIVE_VALUE_SETS_65", 65);

    /**
     * Configuration attribute %s does not contain an active value set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_NO_ACTIVE_VALUE_SET =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_NO_ACTIVE_VALUE_SET_66", 66);

    /**
     * Unable to parse value %s for configuration attribute %s as an integer value because the element was of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INT_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_INVALID_TYPE_67", 67);

    /**
     * Unable to parse value for configuration attribute %s as a set of integer values because the array contained elements of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_INT_INVALID_ARRAY_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_INVALID_ARRAY_TYPE_68", 68);

    /**
     * Unable to parse value %s for configuration attribute %s as a string value: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INVALID_STRING_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_STRING_VALUE_69", 69);

    /**
     * Unable to parse value %s for configuration attribute %s as a string value because the element was of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_STRING_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_STRING_INVALID_TYPE_70", 70);

    /**
     * Unable to parse value for configuration attribute %s as a set of string values because the array contained elements of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_STRING_INVALID_ARRAY_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_STRING_INVALID_ARRAY_TYPE_71", 71);

    /**
     * Unable to parse value %s for configuration attribute %s as an integer with unit value because the element was of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INT_WITH_UNIT_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INT_WITH_UNIT_INVALID_TYPE_72", 72);

    /**
     * Configuration entry %s does not contain attribute %s (or that attribute exists but is not accessible using JMX)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_JMX_ATTR_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JMX_ATTR_NO_ATTR_74", 74);

    /**
     * There is no method %s for any invokable component registered with configuration entry %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_JMX_NO_METHOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JMX_NO_METHOD_78", 78);

    /**
     * The Directory Server could not register a JMX MBean for the component associated with configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_JMX_CANNOT_REGISTER_MBEAN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JMX_CANNOT_REGISTER_MBEAN_83", 83);

    /**
     * An unexpected error occurred while trying to export the Directory Server configuration to LDIF: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_LDIF_WRITE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LDIF_WRITE_ERROR_84", 84);

    /**
     * Worker thread "%s" has experienced too many repeated failures while attempting to retrieve the next operation from the work queue (%d failures experienced, maximum of %d failures allowed). This worker thread will be destroyed
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_CONFIG_WORK_QUEUE_TOO_MANY_FAILURES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_WORK_QUEUE_TOO_MANY_FAILURES_94", 94);

    /**
     * A problem occurred while trying to create and start an instance of class %s to use as a monitor provider for the Directory Server work queue: %s. No monitor information will be available for the work queue
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_WORK_QUEUE_CANNOT_CREATE_MONITOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_WORK_QUEUE_CANNOT_CREATE_MONITOR_95", 95);

    /**
     * A null value was provided for DN configuration attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_DN_NULL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_DN_NULL_98", 98);

    /**
     * An error occurred while trying to parse value "%s" of attribute %s as a DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_DN_CANNOT_PARSE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_DN_CANNOT_PARSE_99", 99);

    /**
     * Unable to parse value %s for configuration attribute %s as a DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_INVALID_DN_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_INVALID_DN_VALUE_100", 100);

    /**
     * Unable to parse value %s for configuration attribute %s as a DN because the element was of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ATTR_DN_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_DN_INVALID_TYPE_101", 101);

    /**
     * Unable to parse value for configuration attribute %s as a set of DN values because the array contained elements of an invalid type (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ATTR_DN_INVALID_ARRAY_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_DN_INVALID_ARRAY_TYPE_102", 102);

    /**
     * An unexpected error occurred while trying to register the configuration handler base DN "%s" as a private suffix with the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_CANNOT_REGISTER_AS_PRIVATE_SUFFIX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CANNOT_REGISTER_AS_PRIVATE_SUFFIX_103", 103);

    /**
     * An error occurred while trying to retrieve configuration entry cn=Backends,cn=config in order to initialize the Directory Server backends: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_BACKEND_CANNOT_GET_CONFIG_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CANNOT_GET_CONFIG_BASE_104", 104);

    /**
     * The entry cn=Backends,cn=config does not appear to exist in the Directory Server configuration. This is a required entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_BACKEND_BASE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_BASE_DOES_NOT_EXIST_105", 105);

    /**
     * An unexpected error occurred while interacting with backend configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_BACKEND_ERROR_INTERACTING_WITH_BACKEND_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_ERROR_INTERACTING_WITH_BACKEND_ENTRY_107", 107);

    /**
     * Fully-qualified name of the Java class that should provide the core logic for this backend implementation. Changes to this configuration attribute will not take effect until the backend is disabled and re-enabled or the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_CLASS =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_CLASS_109", 109);

    /**
     * The backend defined in configuration entry %s is marked as disabled and therefore will not be used
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CONFIG_BACKEND_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "INFO_CONFIG_BACKEND_DISABLED_111", 111);

    /**
     * An unexpected error occurred while attempting to determine whether the backend associated with configuration entry %s should be enabled or disabled: %s. It will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_BACKEND_UNABLE_TO_DETERMINE_ENABLED_STATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_UNABLE_TO_DETERMINE_ENABLED_STATE_112", 112);

    /**
     * The Directory Server was unable to load class %s and use it to create a backend instance as defined in configuration entry %s. The error that occurred was: %s. This backend will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_BACKEND_CANNOT_INSTANTIATE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CANNOT_INSTANTIATE_115", 115);

    /**
     * An error occurred while trying to initialize a backend loaded from class %s with the information in configuration entry %s: %s. This backend will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_BACKEND_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CANNOT_INITIALIZE_116", 116);

    /**
     * The class %s specified in configuration entry %s does not contain a valid Directory Server backend implementation
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_BACKEND_CLASS_NOT_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CLASS_NOT_BACKEND_117", 117);

    /**
     * The requested change to configuration entry %s would cause the class for the associated backend to change from %s to %s. This change will not take effect until the backend is disabled and re-enabled, or until the Directory Server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> NOTE_CONFIG_BACKEND_ACTION_REQUIRED_TO_CHANGE_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "NOTE_CONFIG_BACKEND_ACTION_REQUIRED_TO_CHANGE_CLASS_118", 118);

    /**
     * The backend defined in configuration entry %s has one or more subordinate backends. A backend may not be removed if it has subordinate backends
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONFIG_BACKEND_CANNOT_REMOVE_BACKEND_WITH_SUBORDINATES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "NOTE_CONFIG_BACKEND_CANNOT_REMOVE_BACKEND_WITH_SUBORDINATES_119", 119);

    /**
     * An error occurred while trying to initialize an instance of class %s as a monitor provider as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_MONITOR_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_MONITOR_INITIALIZATION_FAILED_140", 140);

    /**
     * An error occurred while trying to initialize a connection handler loaded from class %s with the information in configuration entry %s: %s. This connection handler will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_CONNHANDLER_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CONNHANDLER_CANNOT_INITIALIZE_154", 154);

    /**
     * An error occurred while trying to initialize a matching rule loaded from class %s with the information in configuration entry %s: %s. This matching rule will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SCHEMA_MR_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_MR_CANNOT_INITIALIZE_172", 172);

    /**
     * The matching rule defined in configuration entry %s conflicts with another matching rule defined in the server configuration: %s. This matching rule will not be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_MR_CONFLICTING_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_MR_CONFLICTING_MR_173", 173);

    /**
     * One or several definitions read from schema configuration file %s conflict with other definitions already read into the schema: %s. The later definitions will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_CONFLICTING_DEFINITIONS_IN_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_CONFLICTING_DEFINITIONS_IN_SCHEMA_FILE_174", 174);

    /**
     * Unable to parse the definitions from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_DEFINITIONS_IN_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_DEFINITIONS_IN_SCHEMA_FILE_175", 175);

    /**
     * An error occurred while trying to initialize an attribute syntax loaded from class %s with the information in configuration entry %s: %s. This syntax will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SCHEMA_SYNTAX_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_SYNTAX_CANNOT_INITIALIZE_186", 186);

    /**
     * The attribute syntax defined in configuration entry %s conflicts with another syntax defined in the server configuration: %s. This attribute syntax will not be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_SYNTAX_CONFLICTING_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_SYNTAX_CONFLICTING_SYNTAX_187", 187);

    /**
     * Unable to read the Directory Server schema definitions because the schema directory %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_SCHEMA_NO_SCHEMA_DIR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_NO_SCHEMA_DIR_188", 188);

    /**
     * Unable to read the Directory Server schema definitions because the schema directory %s exists but is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_SCHEMA_DIR_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_DIR_NOT_DIRECTORY_189", 189);

    /**
     * Unable to read the Directory Server schema definitions from directory %s because an unexpected error occurred while trying to list the files in that directory: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SCHEMA_CANNOT_LIST_FILES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_CANNOT_LIST_FILES_190", 190);

    /**
     * Schema configuration file %s in directory %s cannot be parsed because an unexpected error occurred while trying to open the file for reading: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_CONFIG_SCHEMA_CANNOT_OPEN_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_OPEN_FILE_191", 191);

    /**
     * Schema configuration file %s in directory %s cannot be parsed because an unexpected error occurred while trying to read its contents as an LDIF entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_CONFIG_SCHEMA_CANNOT_READ_LDIF_ENTRY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_READ_LDIF_ENTRY_192", 192);

    /**
     * Unable to parse an attribute type definition from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_ATTR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_ATTR_TYPE_193", 193);

    /**
     * An attribute type read from schema configuration file %s conflicts with another attribute type already read into the schema: %s. The later attribute type definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_ATTR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_ATTR_TYPE_194", 194);

    /**
     * An objectclass read from schema configuration file %s conflicts with another objectclass already read into the schema: %s. The later objectclass definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_OC_195", 195);

    /**
     * An objectclass read from schema configuration file %s could not be parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_OC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_OC_196", 196);

    /**
     * An unexpected error occurred that prevented the server from installing its default entry cache framework: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ENTRYCACHE_CANNOT_INSTALL_DEFAULT_CACHE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRYCACHE_CANNOT_INSTALL_DEFAULT_CACHE_200", 200);

    /**
     * The entry cache configuration entry "cn=Entry Caches,cn=config" does not exist in the Directory Server configuration. No entry cache will be available until this entry is created with a valid entry cache configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CONFIG_ENTRYCACHE_NO_CONFIG_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "WARN_CONFIG_ENTRYCACHE_NO_CONFIG_ENTRY_201", 201);

    /**
     * An error occurred while attempting to initialize an instance of class %s for use as the Directory Server entry cache: %s. As a result, the entry cache will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ENTRYCACHE_CANNOT_INITIALIZE_CACHE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRYCACHE_CANNOT_INITIALIZE_CACHE_202", 202);

    /**
     * The configuration for the entry cache defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ENTRYCACHE_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRYCACHE_CONFIG_NOT_ACCEPTABLE_203", 203);

    /**
     * The configuration for the entry cache defined in configuration entry %s was not acceptable: the entry cache level %d is already in use
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CONFIG_ENTRYCACHE_CONFIG_LEVEL_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRYCACHE_CONFIG_LEVEL_NOT_ACCEPTABLE_204", 204);

    /**
     * The configuration for the entry cache %s monitor provider was not available. As a result this monitor provider %s will not be enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_WARN_CONFIG_ENTRYCACHE_NO_MONITOR_CONFIG_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "INFO_WARN_CONFIG_ENTRYCACHE_NO_MONITOR_CONFIG_ENTRY_205", 205);

    /**
     * The configuration for the entry cache %s monitor provider was disabled. As a result the monitor provider %s will not be enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_WARN_CONFIG_ENTRYCACHE_MONITOR_CONFIG_DISABLED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "INFO_WARN_CONFIG_ENTRYCACHE_MONITOR_CONFIG_DISABLED_206", 206);

    /**
     * An unexpected error occurred while attempting to remove entry %s as a child of configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ENTRY_CANNOT_REMOVE_CHILD =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ENTRY_CANNOT_REMOVE_CHILD_215", 215);

    /**
     * Unable to parse a name form definition from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_NAME_FORM_216", 216);

    /**
     * A name form read from schema configuration file %s conflicts with another name form already read into the schema: %s. The later name form definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_NAME_FORM_217", 217);

    /**
     * Unable to parse a DIT content rule definition from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_DCR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_DCR_218", 218);

    /**
     * A DIT content rule read from schema configuration file %s conflicts with another DIT content rule already read into the schema: %s. The later DIT content rule definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_DCR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_DCR_219", 219);

    /**
     * Unable to parse a DIT structure rule definition from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_DSR_220", 220);

    /**
     * A DIT structure rule read from schema configuration file %s conflicts with another DIT structure rule already read into the schema: %s. The later DIT structure rule definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_DSR_221", 221);

    /**
     * Unable to parse a matching rule use definition from schema configuration file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_MRU =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_MRU_222", 222);

    /**
     * A matching rule use read from schema configuration file %s conflicts with another matching rule use already read into the schema: %s. The later matching rule use definition will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_MRU =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_MRU_223", 223);

    /**
     * Configuration attribute %s is read-only and its values may not be altered
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ATTR_READ_ONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ATTR_READ_ONLY_228", 228);

    /**
     * An error occurred while attempting to initialize an instance of class %s as a Directory Server plugin using the information in configuration entry %s: %s. This plugin will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_PLUGIN_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PLUGIN_CANNOT_INITIALIZE_245", 245);

    /**
     * Class %s specified in configuration entry %s does not contain a valid extended operation handler implementation: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_EXTOP_INVALID_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_EXTOP_INVALID_CLASS_256", 256);

    /**
     * An error occurred while trying to initialize an instance of class %s as an extended operation handler as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_EXTOP_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_EXTOP_INITIALIZATION_FAILED_261", 261);

    /**
     * An error occurred while trying to initialize an instance of class %s as a SASL mechanism handler as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SASL_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SASL_INITIALIZATION_FAILED_277", 277);

    /**
     * Entry %s cannot be removed from the Directory Server configuration because that DN does not have a parent
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DELETE_NO_PARENT_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_NO_PARENT_DN_278", 278);

    /**
     * Entry %s cannot be added to the Directory Server configuration because another configuration entry already exists with that DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_ADD_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_ALREADY_EXISTS_280", 280);

    /**
     * Entry %s cannot be added to the Directory Server configuration because that DN does not have a parent
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_ADD_NO_PARENT_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_NO_PARENT_DN_281", 281);

    /**
     * Entry %s cannot be added to the Directory Server configuration because its parent entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_ADD_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_NO_PARENT_282", 282);

    /**
     * The Directory Server is unwilling to add configuration entry %s because one of the add listeners registered with the parent entry %s rejected this change with the message: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_ADD_REJECTED_BY_LISTENER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_REJECTED_BY_LISTENER_283", 283);

    /**
     * An unexpected error occurred while attempting to add configuration entry %s as a child of entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_ADD_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_FAILED_284", 284);

    /**
     * Entry %s cannot be removed from the Directory Server configuration because the specified entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DELETE_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_NO_SUCH_ENTRY_285", 285);

    /**
     * Entry %s cannot be removed from the Directory Server configuration because the specified entry has one or more subordinate entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DELETE_HAS_CHILDREN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_HAS_CHILDREN_286", 286);

    /**
     * Entry %s cannot be removed from the Directory Server configuration because the entry does not have a parent and removing the configuration root entry is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DELETE_NO_PARENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_NO_PARENT_287", 287);

    /**
     * Entry %s cannot be removed from the Directory Server configuration because one of the delete listeners registered with the parent entry %s rejected this change with the message: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_DELETE_REJECTED_BY_LISTENER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_REJECTED_BY_LISTENER_288", 288);

    /**
     * An unexpected error occurred while attempting to remove configuration entry %s as a child of entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_DELETE_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_FAILED_289", 289);

    /**
     * Entry %s cannot be modified because the specified entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_MODIFY_NO_SUCH_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_NO_SUCH_ENTRY_290", 290);

    /**
     * Entry %s cannot be modified because one of the configuration change listeners registered for that entry rejected the change: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_MODIFY_REJECTED_BY_CHANGE_LISTENER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_REJECTED_BY_CHANGE_LISTENER_291", 291);

    /**
     * An unexpected error occurred while attempting to modify configuration entry %s as a child of entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_MODIFY_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_FAILED_292", 292);

    /**
     * The search operation cannot be processed because base entry %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_SEARCH_NO_SUCH_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_SEARCH_NO_SUCH_BASE_293", 293);

    /**
     * The search operation cannot be processed because the specified search scope %s is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_SEARCH_INVALID_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_SEARCH_INVALID_SCOPE_294", 294);

    /**
     * An error occurred while attempting to export the new Directory Server configuration to file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_WRITE_CANNOT_EXPORT_NEW_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_WRITE_CANNOT_EXPORT_NEW_CONFIG_300", 300);

    /**
     * An error occurred while attempting to rename the new Directory Server configuration from file %s to %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_FILE_WRITE_CANNOT_RENAME_NEW_CONFIG =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_WRITE_CANNOT_RENAME_NEW_CONFIG_301", 301);

    /**
     * Modify DN operations are not allowed in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_MODDN_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODDN_NOT_ALLOWED_302", 302);

    /**
     * Set of base DNs that should be used for this backend. It is up to the backend implementation as to whether changes to this attribute will automatically take effect
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_BASE_DNS_305", 305);

    /**
     * Indicates whether the Directory Server key manager provider should be enabled. A key manager provider is required for operations that require access to a key manager (e.g., communication over SSL). Changes to this configuration attribute will take effect immediately, but will only impact future attempts to access the key manager
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_KEYMANAGER_DESCRIPTION_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_KEYMANAGER_DESCRIPTION_ENABLED_313", 313);

    /**
     * Indicates whether the Directory Server trust manager provider should be enabled. A trust manager provider is required for operations that require access to a trust manager (e.g., communication over SSL). Changes to this configuration attribute will take effect immediately, but will only impact future attempts to access the trust manager
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_TRUSTMANAGER_DESCRIPTION_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_TRUSTMANAGER_DESCRIPTION_ENABLED_328", 328);

    /**
     * An error occurred while trying to initialize an instance of class %s as a password storage scheme as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_PWSCHEME_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWSCHEME_INITIALIZATION_FAILED_376", 376);

    /**
     * Unable to add a new password storage scheme entry with DN %s because there is already a storage scheme registered with that DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_PWSCHEME_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWSCHEME_EXISTS_377", 377);

    /**
     * Unique identifier for this backend. Changes to this configuration attribute will not take effect until the backend is disabled and re-enabled or the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_BACKEND_ATTR_DESCRIPTION_BACKEND_ID_382", 382);

    /**
     * The backend defined in configuration entry %s has a backend ID of %s that conflicts with the backend ID for another backend in the server. The backend will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_BACKEND_DUPLICATE_BACKEND_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_BACKEND_DUPLICATE_BACKEND_ID_384", 384);

    /**
     * The Directory Server was unable to acquire a shared lock for backend %s: %s. This generally means that the backend is in use by a process that requires an exclusive lock (e.g., importing from LDIF or restoring a backup). This backend will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_BACKEND_CANNOT_ACQUIRE_SHARED_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CANNOT_ACQUIRE_SHARED_LOCK_422", 422);

    /**
     * An error occurred while attempting to release a shared lock for backend %s: %s. This may interfere with operations that require exclusive access, including LDIF import and restoring a backup
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_BACKEND_CANNOT_RELEASE_SHARED_LOCK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_BACKEND_CANNOT_RELEASE_SHARED_LOCK_423", 423);

    /**
     * This file contains the primary Directory Server configuration. It must not be directly edited while the server is online. The server configuration should only be managed using the administration utilities provided with the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_FILE_HEADER =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_FILE_HEADER_424", 424);

    /**
     * An error occurred while trying to initialize an instance of class %s as an identity mapper as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_IDMAPPER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_IDMAPPER_INITIALIZATION_FAILED_442", 442);

    /**
     * The Directory Server does not have any identity mapper configured for use in conjunction with proxied authorization V2 operations. The Directory Server will not be able to process requests containing the proxied authorization control with a username-based authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_IDMAPPER_NO_PROXY_MAPPER_DN =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_IDMAPPER_NO_PROXY_MAPPER_DN_448", 448);

    /**
     * The configured proxied authorization identity mapper DN %s does not refer to an active identity mapper. The Directory Server will not be able to process requests containing the proxied authorization control with a username-based authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_IDMAPPER_INVALID_PROXY_MAPPER_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_IDMAPPER_INVALID_PROXY_MAPPER_DN_449", 449);

    /**
     * An error occurred while attempting to load class %s referenced in synchronization provider configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SYNCH_UNABLE_TO_LOAD_PROVIDER_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SYNCH_UNABLE_TO_LOAD_PROVIDER_CLASS_463", 463);

    /**
     * An error occurred while attempting to instantiate class %s referenced in synchronization provider configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SYNCH_UNABLE_TO_INSTANTIATE_PROVIDER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SYNCH_UNABLE_TO_INSTANTIATE_PROVIDER_464", 464);

    /**
     * An error occurred while attempting to initialize the Directory Server synchronization provider referenced in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SYNCH_ERROR_INITIALIZING_PROVIDER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SYNCH_ERROR_INITIALIZING_PROVIDER_465", 465);

    /**
     * An error occurred while trying to initialize an instance of class %s as a password validator as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_PWVALIDATOR_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWVALIDATOR_INITIALIZATION_FAILED_489", 489);

    /**
     * An error occurred while trying to initialize an instance of class %s as a password generator as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_PWGENERATOR_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWGENERATOR_INITIALIZATION_FAILED_505", 505);

    /**
     * No password policies have been defined below the cn=Password Policies,cn=config entry in the Directory Server configuration. At least one password policy configuration must be defined
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_PWPOLICY_NO_POLICIES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_NO_POLICIES_514", 514);

    /**
     * The password policy defined in configuration entry %s is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_PWPOLICY_INVALID_POLICY_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_INVALID_POLICY_CONFIG_515", 515);

    /**
     * The Directory Server default password policy is defined as %s, but that entry does not exist or is not below the password policy configuration base cn=Password Policies,cn=config
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_PWPOLICY_MISSING_DEFAULT_POLICY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_MISSING_DEFAULT_POLICY_516", 516);

    /**
     * The specified entry %s is currently defined as the configuration entry for the default password policy. The default password policy configuration entry may not be removed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CONFIG_PWPOLICY_CANNOT_DELETE_DEFAULT_POLICY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_PWPOLICY_CANNOT_DELETE_DEFAULT_POLICY_517", 517);

    /**
     * Password policy entry %s has been removed from the Directory Server configuration. Any user entries that explicitly reference this password policy will no longer be allowed to authenticate
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CONFIG_PWPOLICY_REMOVED_POLICY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "INFO_CONFIG_PWPOLICY_REMOVED_POLICY_518", 518);

    /**
     * Access control has been disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CONFIG_AUTHZ_DISABLED =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "WARN_CONFIG_AUTHZ_DISABLED_525", 525);

    /**
     * Access control has been enabled and will use the %s implementation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONFIG_AUTHZ_ENABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "NOTE_CONFIG_AUTHZ_ENABLED_526", 526);

    /**
     * An error occurred while attempting to instantiate class %s referenced in the access control configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_AUTHZ_UNABLE_TO_INSTANTIATE_HANDLER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_AUTHZ_UNABLE_TO_INSTANTIATE_HANDLER_533", 533);

    /**
     * Specifies one or more alternate bind DNs that may be used to authenticate as the associated root DN, in addition to the actual DN of the root DN configuration entry. Alternate bind DNs must not conflict with the DNs of any other entries in the directory, nor can they conflict with other alternate bind DNs configured for other root DNs. Changes to this configuration attribute will take effect immediately
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIG_ROOTDN_DESCRIPTION_ALTERNATE_BIND_DN =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "INFO_CONFIG_ROOTDN_DESCRIPTION_ALTERNATE_BIND_DN_540", 540);

    /**
     * Unable to register "%s" as an alternate bind DN for user "%s" because it is already registered as an alternate bind DN for root user "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ROOTDN_CONFLICTING_MAPPING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ROOTDN_CONFLICTING_MAPPING_541", 541);

    /**
     * An error occurred while trying to initialize an instance of class %s as an account status notification handler as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ACCTNOTHANDLER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ACCTNOTHANDLER_INITIALIZATION_FAILED_558", 558);

    /**
     * Unable to add a new account status notification handler entry with DN %s because there is already a notification handler registered with that DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ACCTNOTHANDLER_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ACCTNOTHANDLER_EXISTS_559", 559);

    /**
     * An error occurred while attempting to apply the changes contained in file %s to the server configuration at startup: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_UNABLE_TO_APPLY_STARTUP_CHANGES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_UNABLE_TO_APPLY_STARTUP_CHANGES_563", 563);

    /**
     * Unable to apply a change at server startup: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_ERROR_APPLYING_STARTUP_CHANGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ERROR_APPLYING_STARTUP_CHANGE_564", 564);

    /**
     * One or more errors occurred while applying changes on server startup: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_UNABLE_TO_APPLY_CHANGES_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_UNABLE_TO_APPLY_CHANGES_FILE_565", 565);

    /**
     * Configuration entry %s does not contain a valid value for configuration attribute ds-cfg-db-directory-permissions (It should be an UNIX permission mode in three-digit octal notation.)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_BACKEND_MODE_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_MODE_INVALID_567", 567);

    /**
     * Invalid UNIX file permissions %s does not allow read and write access to the backend database directory by the backend
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_BACKEND_INSANE_MODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_INSANE_MODE_568", 568);

    /**
     * No default password policy is configured for the Directory Server. The default password policy must be specified by the ds-cfg-default-password-policy attribute in the cn=config entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_PWPOLICY_NO_DEFAULT_POLICY =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_NO_DEFAULT_POLICY_571", 571);

    /**
     * An error occurred while attempting to register backend %s with the Directory Server: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_BACKEND_CANNOT_REGISTER_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_BACKEND_CANNOT_REGISTER_BACKEND_572", 572);

    /**
     * An error occurred while trying to create the configuration archive directory %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_CANNOT_CREATE_ARCHIVE_DIR_NO_REASON =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CANNOT_CREATE_ARCHIVE_DIR_NO_REASON_573", 573);

    /**
     * An error occurred while trying to create the configuration archive directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_FILE_CANNOT_CREATE_ARCHIVE_DIR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CANNOT_CREATE_ARCHIVE_DIR_574", 574);

    /**
     * An error occurred while trying to write the current configuration to the configuration archive: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_CANNOT_WRITE_CONFIG_ARCHIVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_CANNOT_WRITE_CONFIG_ARCHIVE_575", 575);

    /**
     * An error occurred while trying to initialize an instance of class %s as a group implementation as in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_GROUP_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_GROUP_INITIALIZATION_FAILED_591", 591);

    /**
     * You do not have sufficient privileges to perform add operations in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_ADD_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_INSUFFICIENT_PRIVILEGES_598", 598);

    /**
     * You do not have sufficient privileges to perform delete operations in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_DELETE_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_INSUFFICIENT_PRIVILEGES_599", 599);

    /**
     * You do not have sufficient privileges to perform modify operations in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_MODIFY_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_INSUFFICIENT_PRIVILEGES_600", 600);

    /**
     * You do not have sufficient privileges to perform modify DN operations in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_MODDN_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODDN_INSUFFICIENT_PRIVILEGES_601", 601);

    /**
     * You do not have sufficient privileges to perform search operations in the Directory Server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_SEARCH_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_SEARCH_INSUFFICIENT_PRIVILEGES_602", 602);

    /**
     * You do not have sufficient privileges to change the set of default root privileges
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_FILE_MODIFY_PRIVS_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_PRIVS_INSUFFICIENT_PRIVILEGES_603", 603);

    /**
     * An error occurred while trying to initialize an instance of class %s as a certificate mapper as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_CERTMAPPER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CERTMAPPER_INITIALIZATION_FAILED_614", 614);

    /**
     * An error occurred while attempting to retrieve the key manager provider base entry cn=Key Manager Providers,cn=config from the Directory Server configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_KEYMANAGER_CANNOT_GET_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_KEYMANAGER_CANNOT_GET_BASE_617", 617);

    /**
     * An error occurred while trying to initialize an instance of class %s as a key manager provider as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_KEYMANAGER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_KEYMANAGER_INITIALIZATION_FAILED_627", 627);

    /**
     * An error occurred while attempting to retrieve the trust manager provider base entry cn=Trust Manager Providers,cn=config from the Directory Server configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_TRUSTMANAGER_CANNOT_GET_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_TRUSTMANAGER_CANNOT_GET_BASE_630", 630);

    /**
     * An error occurred while trying to initialize an instance of class %s as a trust manager provider as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_TRUSTMANAGER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_TRUSTMANAGER_INITIALIZATION_FAILED_640", 640);

    /**
     * Unable to retrieve JMX attribute %s associated with configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_JMX_CANNOT_GET_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JMX_CANNOT_GET_ATTRIBUTE_643", 643);

    /**
     * %s.%s returned a result of null for entry %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_CHANGE_NO_RESULT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CHANGE_NO_RESULT_645", 645);

    /**
     * %s.%s failed for entry %s: result code=%s, admin action required=%b, messages="%s"
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Boolean, Object> ERR_CONFIG_CHANGE_RESULT_ERROR =
                    new LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Boolean, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CHANGE_RESULT_ERROR_646", 646);

    /**
     * %s.%s indicated that administrative action is required for entry %s: messages="%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_CONFIG_CHANGE_RESULT_ACTION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_CHANGE_RESULT_ACTION_REQUIRED_647", 647);

    /**
     * %s.%s succeeded but generated the following messages for entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_CONFIG_CHANGE_RESULT_MESSAGES =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "INFO_CONFIG_CHANGE_RESULT_MESSAGES_648", 648);

    /**
     * Unable to parse value "%s" from config entry "%s" as a valid search filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_VATTR_INVALID_SEARCH_FILTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_VATTR_INVALID_SEARCH_FILTER_649", 649);

    /**
     * An error occurred while trying to load an instance of class %s referenced in configuration entry %s as a virtual attribute provider: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_VATTR_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_VATTR_INITIALIZATION_FAILED_650", 650);

    /**
     * The virtual attribute configuration in entry "%s" is not valid because attribute type %s is single-valued but provider %s may generate multiple values
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_VATTR_SV_TYPE_WITH_MV_PROVIDER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_VATTR_SV_TYPE_WITH_MV_PROVIDER_651", 651);

    /**
     * The virtual attribute configuration in entry "%s" is not valid because attribute type %s is single-valued but the conflict behavior is configured to merge real and virtual values
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_VATTR_SV_TYPE_WITH_MERGE_VALUES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_VATTR_SV_TYPE_WITH_MERGE_VALUES_652", 652);

    /**
     * Configuration entry %s cannot be modified because the change would alter its structural object class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_MODIFY_STRUCTURAL_CHANGE_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_STRUCTURAL_CHANGE_NOT_ALLOWED_653", 653);

    /**
     * An error occurred while attempting to calculate a SHA-1 digest of file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_CANNOT_CALCULATE_DIGEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CANNOT_CALCULATE_DIGEST_654", 654);

    /**
     * The Directory Server has detected that one or more external changes have been made to the configuration file %s while the server was online, but another change has caused the server configuration to be overwritten. The manual changes have not been applied, but they have been preserved in file %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_MANUAL_CHANGES_DETECTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_MANUAL_CHANGES_DETECTED_655", 655);

    /**
     * The Directory Server encountered an error while attempting to determine whether the configuration file %s has been externally edited with the server online, and/or trying to preserve such changes: %s. Any manual changes made to that file may have been lost
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_MANUAL_CHANGES_LOST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_MANUAL_CHANGES_LOST_656", 656);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server log rotation policy: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ROTATION_POLICY_INVALID_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ROTATION_POLICY_INVALID_CLASS_657", 657);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server log retention policy: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_RETENTION_POLICY_INVALID_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_RETENTION_POLICY_INVALID_CLASS_658", 658);

    /**
     * An error occurred while attempting to create a Directory Server log rotation policy from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ROTATION_POLICY_CANNOT_CREATE_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ROTATION_POLICY_CANNOT_CREATE_POLICY_659", 659);

    /**
     * An error occurred while attempting to create a Directory Server log retention policy from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_RETENTION_POLICY_CANNOT_CREATE_POLICY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_RETENTION_POLICY_CANNOT_CREATE_POLICY_660", 660);

    /**
     * An error occurred while attempting to create a text writer for a Directory Server logger from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGING_CANNOT_CREATE_WRITER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_CANNOT_CREATE_WRITER_661", 661);

    /**
     * Schema configuration file %s in directory %s contains more than one entry. Only the first entry will be examined, and the additional entries will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_MULTIPLE_ENTRIES_IN_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_MULTIPLE_ENTRIES_IN_FILE_662", 662);

    /**
     * Schema configuration file %s in directory %s contains additional data after the schema entry that cannot be parsed by the LDIF reader: %s. The first entry will be processed, but the remaining data will be ignored
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_CONFIG_SCHEMA_UNPARSEABLE_EXTRA_DATA_IN_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_UNPARSEABLE_EXTRA_DATA_IN_FILE_663", 663);

    /**
     * The plugin order definition for plugins of type %s contains an empty element. This may cause the plugin order to be evaluated incorrectly
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CONFIG_PLUGIN_EMPTY_ELEMENT_IN_ORDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_PLUGIN_EMPTY_ELEMENT_IN_ORDER_664", 664);

    /**
     * The plugin order definition for plugins of type %s contains multiple wildcard characters. All plugin definitions should contain exactly one wildcard element to indicate where unmatched plugins should be included in the order, and including multiple wildcards may cause the plugin order to be evaluated incorrectly
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CONFIG_PLUGIN_MULTIPLE_WILDCARDS_IN_ORDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_PLUGIN_MULTIPLE_WILDCARDS_IN_ORDER_665", 665);

    /**
     * The plugin order definition for plugins of type %s includes multiple references to the '%s' plugin. This may cause the plugin order to be evaluated incorrectly
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_PLUGIN_LISTED_MULTIPLE_TIMES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_PLUGIN_LISTED_MULTIPLE_TIMES_666", 666);

    /**
     * The plugin order definition for plugins of type %s does not include a wildcard element to indicate where unmatched plugins should be included in the order. The server will default to invoking all unnamed plugins after set of named plugins
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_CONFIG_PLUGIN_ORDER_NO_WILDCARD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_PLUGIN_ORDER_NO_WILDCARD_667", 667);

    /**
     * Attribute syntax %s cannot be deleted from the server because it is in use by attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DELETE_SYNTAX_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DELETE_SYNTAX_IN_USE_668", 668);

    /**
     * Attribute syntax %s cannot be disabled because it is in use by attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DISABLE_SYNTAX_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DISABLE_SYNTAX_IN_USE_669", 669);

    /**
     * Matching rule %s cannot be deleted from the server because it is in use by attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DELETE_MR_IN_USE_BY_AT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DELETE_MR_IN_USE_BY_AT_670", 670);

    /**
     * Matching rule %s cannot be deleted from the server because it is in use by matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DELETE_MR_IN_USE_BY_MRU =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DELETE_MR_IN_USE_BY_MRU_671", 671);

    /**
     * Matching rule %s cannot be disabled because it is in use by attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DISABLE_MR_IN_USE_BY_AT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DISABLE_MR_IN_USE_BY_AT_672", 672);

    /**
     * Matching rule %s cannot be disabled because it is in use by matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_DISABLE_MR_IN_USE_BY_MRU =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_DISABLE_MR_IN_USE_BY_MRU_673", 673);

    /**
     * Unable to initialize an instance of class %s as a work queue as specified in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_WORK_QUEUE_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_WORK_QUEUE_INITIALIZATION_FAILED_674", 674);

    /**
     * The class used to provide the Directory Server work queue implementation has been changed from %s to %s, but this change will not take effect until the server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CONFIG_WORK_QUEUE_CLASS_CHANGE_REQUIRES_RESTART =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "INFO_CONFIG_WORK_QUEUE_CLASS_CHANGE_REQUIRES_RESTART_675", 675);

    /**
     * The attempt to apply the configuration add failed. The preliminary checks were all successful and the entry was added to the server configuration, but at least one of the configuration add listeners reported an error when attempting to apply the change: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_ADD_APPLY_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_APPLY_FAILED_676", 676);

    /**
     * The attempt to apply the configuration delete failed. The preliminary checks were all successful and the entry was removed from the server configuration, but at least one of the configuration delete listeners reported an error when attempting to apply the change: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_DELETE_APPLY_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_APPLY_FAILED_677", 677);

    /**
     * The attempt to apply the configuration modification failed. The preliminary checks were all successful and the modified entry was written to the server configuration, but at least one of the configuration change listeners reported an error when attempting to apply the change: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_FILE_MODIFY_APPLY_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_APPLY_FAILED_678", 678);

    /**
     * The configuration for the key manager provider defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_KEYMANAGER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_KEYMANAGER_CONFIG_NOT_ACCEPTABLE_679", 679);

    /**
     * The configuration for the trust manager provider defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_TRUSTMANAGER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_TRUSTMANAGER_CONFIG_NOT_ACCEPTABLE_680", 680);

    /**
     * The configuration for the trust manager provider defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_AUTHZ_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_AUTHZ_CONFIG_NOT_ACCEPTABLE_681", 681);

    /**
     * The configuration for the account status notification handler defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ACCTNOTHANDLER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ACCTNOTHANDLER_CONFIG_NOT_ACCEPTABLE_682", 682);

    /**
     * The configuration for the attribute syntax defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SCHEMA_SYNTAX_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_SYNTAX_CONFIG_NOT_ACCEPTABLE_683", 683);

    /**
     * The configuration for the certificate mapper defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_CERTMAPPER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CERTMAPPER_CONFIG_NOT_ACCEPTABLE_684", 684);

    /**
     * The configuration for the group implementation defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_GROUP_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_GROUP_CONFIG_NOT_ACCEPTABLE_686", 686);

    /**
     * The configuration for the identity mapper defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_IDMAPPER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_IDMAPPER_CONFIG_NOT_ACCEPTABLE_687", 687);

    /**
     * The configuration for the matching rule defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SCHEMA_MR_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_MR_CONFIG_NOT_ACCEPTABLE_688", 688);

    /**
     * The configuration for the password generator defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_PWGENERATOR_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWGENERATOR_CONFIG_NOT_ACCEPTABLE_689", 689);

    /**
     * The configuration for the password storage scheme defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_PWSCHEME_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWSCHEME_CONFIG_NOT_ACCEPTABLE_690", 690);

    /**
     * The configuration for the password validator defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_PWVALIDATOR_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWVALIDATOR_CONFIG_NOT_ACCEPTABLE_691", 691);

    /**
     * The configuration for the plugin defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_PLUGIN_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PLUGIN_CONFIG_NOT_ACCEPTABLE_692", 692);

    /**
     * The configuration for the SASL mechanism handler defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SASL_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SASL_CONFIG_NOT_ACCEPTABLE_693", 693);

    /**
     * The configuration for the virtual attribute provider defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_VATTR_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_VATTR_CONFIG_NOT_ACCEPTABLE_694", 694);

    /**
     * The configuration for the alert handler defined in configuration entry %s was not acceptable: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_ALERTHANDLER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ALERTHANDLER_CONFIG_NOT_ACCEPTABLE_695", 695);

    /**
     * An error occurred while trying to initialize an instance of class %s as an alert handler as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_ALERTHANDLER_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_ALERTHANDLER_INITIALIZATION_FAILED_696", 696);

    /**
     * The provided SMTP server value '%s' is invalid. An SMTP server value must have an IP address or a resolvable name, and it may optionally be followed by a colon and an integer value between 1 and 65535 to specify the server port number
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_CORE_INVALID_SMTP_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CORE_INVALID_SMTP_SERVER_697", 697);

    /**
     * An error occurred while attempting to open the current configuration file %s for reading in order to copy it to the ".startok" file: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STARTOK_CANNOT_OPEN_FOR_READING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_STARTOK_CANNOT_OPEN_FOR_READING_698", 698);

    /**
     * An error occurred while attempting to open file %s in order to write the ".startok" configuration file: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_STARTOK_CANNOT_OPEN_FOR_WRITING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_STARTOK_CANNOT_OPEN_FOR_WRITING_699", 699);

    /**
     * An error occurred while attempting to copy the current configuration from file %s into temporary file %s for use as the ".startok" configuration file: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STARTOK_CANNOT_WRITE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_STARTOK_CANNOT_WRITE_700", 700);

    /**
     * An error occurred while attempting to rename file %s to %s for use as the ".startok" configuration file: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_STARTOK_CANNOT_RENAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_STARTOK_CANNOT_RENAME_701", 701);

    /**
     * The Directory Server is starting using the last known good configuration file %s rather than the active configuration file %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_CONFIG_FILE_USING_STARTOK_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "NOTE_CONFIG_FILE_USING_STARTOK_FILE_702", 702);

    /**
     * No last known good configuration file %s exists. The server will attempt to start using the active configuration file %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_FILE_NO_STARTOK_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_FILE_NO_STARTOK_FILE_703", 703);

    /**
     * An error occurred while trying to parse and validate Berkeley DB JE property %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_JE_PROPERTY_INVALID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JE_PROPERTY_INVALID_704", 704);

    /**
     * An error occurred while trying to parse and validate Berkeley DB JE property %s: the property does not follow a singular property=value form
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_JE_PROPERTY_INVALID_FORM =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JE_PROPERTY_INVALID_FORM_705", 705);

    /**
     * An error occurred while trying to parse and validate Berkeley DB JE property %s: the property shadows configuration attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_JE_PROPERTY_SHADOWS_CONFIG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JE_PROPERTY_SHADOWS_CONFIG_706", 706);

    /**
     * An error occurred while trying to parse and validate Berkeley DB JE property %s: the property is already defined for this component
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_JE_DUPLICATE_PROPERTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_JE_DUPLICATE_PROPERTY_707", 707);

    /**
     * An error occurred while attempting to open the configured log file %s for logger %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_LOGGING_CANNOT_OPEN_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_CANNOT_OPEN_FILE_709", 709);

    /**
     * Invalid UNIX file permissions %s does not allow write access to the log file by the log publisher
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_LOGGING_INSANE_MODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_INSANE_MODE_715", 715);

    /**
     * Invalid UNIX file permissions %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGING_MODE_INVALID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_MODE_INVALID_716", 716);

    /**
     * An ldapSyntaxes attribute read from schema configuration file %s could not be parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CANNOT_PARSE_LDAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CANNOT_PARSE_LDAP_SYNTAX_723", 723);

    /**
     * An ldap syntax read from schema configuration file %s conflicts with another ldap syntax already read into the schema: %s. The later ldap syntax description will be used
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_CONFLICTING_LDAP_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_CONFLICTING_LDAP_SYNTAX_724", 724);

    /**
     * The configuration entry '%s' is currently defined to be the default password policy, however it is not a password policy
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_PWPOLICY_DEFAULT_POLICY_IS_WRONG_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_DEFAULT_POLICY_IS_WRONG_TYPE_726", 726);

    /**
     * The default password policy value '%s' is invalid because it refers to an authentication policy which is not a password policy
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_PWPOLICY_CANNOT_CHANGE_DEFAULT_POLICY_WRONG_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_PWPOLICY_CANNOT_CHANGE_DEFAULT_POLICY_WRONG_TYPE_727", 727);

    /**
     * The timestamp format string "%s" is not a valid format string. The format string should conform to the syntax described in the documentation for the "java.text.SimpleDateFormat" class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_LOGGING_INVALID_TIME_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_INVALID_TIME_FORMAT_728", 728);

    /**
     * The access log filtering criteria defined in "%s" could not be parsed because it contains an invalid user DN pattern "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGING_INVALID_USER_DN_PATTERN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_INVALID_USER_DN_PATTERN_729", 729);

    /**
     * The access log filtering criteria defined in "%s" could not be parsed because it contains an invalid target DN pattern "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGING_INVALID_TARGET_DN_PATTERN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_INVALID_TARGET_DN_PATTERN_730", 730);

    /**
     * There are no active HTTP access loggers defined in the Directory Server configuration. No HTTP access logging will be performed
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CONFIG_LOGGER_NO_ACTIVE_HTTP_ACCESS_LOGGERS =
                    new LocalizableMessageDescriptor.Arg0(ConfigMessages.class, RESOURCE, "WARN_CONFIG_LOGGER_NO_ACTIVE_HTTP_ACCESS_LOGGERS_731", 731);

    /**
     * Class %s specified in attribute ds-cfg-java-class of configuration entry %s cannot be instantiated as a Directory Server HTTP access logger: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_LOGGER_INVALID_HTTP_ACCESS_LOGGER_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_INVALID_HTTP_ACCESS_LOGGER_CLASS_732", 732);

    /**
     * The log format for configuration entry %s is empty. No information will be logged even if logging is activated
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_LOGGING_EMPTY_LOG_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGING_EMPTY_LOG_FORMAT_733", 733);

    /**
     * The log format for %s contains the following unsupported fields: %s. Their output will be replaced with a dash ("-") character
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_LOGGING_UNSUPPORTED_FIELDS_IN_LOG_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_LOGGING_UNSUPPORTED_FIELDS_IN_LOG_FORMAT_734", 734);

    /**
     * An error occurred while attempting to update a Directory Server logger from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGER_CANNOT_UPDATE_LOGGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_CANNOT_UPDATE_LOGGER_735", 735);

    /**
     * An error occurred while attempting to delete a Directory Server logger from the information in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_LOGGER_CANNOT_DELETE_LOGGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_LOGGER_CANNOT_DELETE_LOGGER_736", 736);

    /**
     * Cannot configure java.util.logging root logger level: %s. java.util.logging support is now disabled.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_CANNOT_CONFIGURE_JUL_LOGGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CANNOT_CONFIGURE_JUL_LOGGER_737", 737);

    /**
     * An error occurred while trying to initialize an instance of class %s as an HTTP endpoint as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_HTTPENDPOINT_INITIALIZATION_FAILED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_HTTPENDPOINT_INITIALIZATION_FAILED_738", 738);

    /**
     * An error occurred while starting the HTTP endpoint as defined in configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_HTTPENDPOINT_UNABLE_TO_START =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_HTTPENDPOINT_UNABLE_TO_START_739", 739);

    /**
     * The HTTP endpoint configuration defined in %s is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_HTTPENDPOINT_INVALID_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_HTTPENDPOINT_INVALID_CONFIGURATION_741", 741);

    /**
     * Invalid configuration URL in the REST2LDAP endpoint configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_REST2LDAP_MALFORMED_URL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_REST2LDAP_MALFORMED_URL_742", 742);

    /**
     * Cannot initialize the configuration framework: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_CONFIGURATION_FRAMEWORK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_CONFIGURATION_FRAMEWORK_743", 743);

    /**
     * Unable to retrieve children of configuration entry with dn: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNABLE_TO_RETRIEVE_CHILDREN_OF_CONFIGURATION_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_UNABLE_TO_RETRIEVE_CHILDREN_OF_CONFIGURATION_ENTRY_744", 744);

    /**
     * Unable to load the configuration-enabled schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNABLE_TO_LOAD_CONFIGURATION_ENABLED_SCHEMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_UNABLE_TO_LOAD_CONFIGURATION_ENABLED_SCHEMA_745", 745);

    /**
     * Backend config error when trying to delete an entry: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_BACKEND_CANNOT_DELETE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_CANNOT_DELETE_ENTRY_746", 746);

    /**
     * The HTTP endpoint configuration defined in %s is referencing a non existing authorization DN %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_HTTPENDPOINT_INVALID_AUTHZ_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_HTTPENDPOINT_INVALID_AUTHZ_DN_747", 747);

    /**
     * The HTTP endpoint configuration defined in %s is referencing mutually exclusive authorization DNs %s and %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_HTTPENDPOINT_CONFLICTING_AUTHZ_DN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_HTTPENDPOINT_CONFLICTING_AUTHZ_DN_748", 748);

    /**
     * Unable to read the configuration from %s in the REST2LDAP endpoint configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_REST2LDAP_UNABLE_READ =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_REST2LDAP_UNABLE_READ_749", 749);

    /**
     * Invalid JSON element %s from %s in the REST2LDAP endpoint configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CONFIG_REST2LDAP_UNEXPECTED_JSON =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_REST2LDAP_UNEXPECTED_JSON_750", 750);

    /**
     * Invalid configuration element from %s in the REST2LDAP endpoint configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_REST2LDAP_INVALID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_REST2LDAP_INVALID_751", 751);

    /**
     * The OAuth2 authorization mechanism defined in %s contains an invalid JSON Pointer %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_OAUTH2_INVALID_JSON_POINTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_INVALID_JSON_POINTER_752", 752);

    /**
     * The authorization mechanism defined in %s is referencing a non-existing or non-readable directory: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_OAUTH2_NON_EXISTING_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_NON_EXISTING_DIRECTORY_753", 753);

    /**
     * The authorization mechanism defined in %s is referencing a non existing DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_AUTHZ_REFERENCED_DN_DOESNT_EXISTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_AUTHZ_REFERENCED_DN_DOESNT_EXISTS_754", 754);

    /**
     * The authorization mechanism defined in %s is referencing an invalid URL %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_OAUTH2_INVALID_URL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_INVALID_URL_755", 755);

    /**
     * Unable to configure the authorization mechanism defined in %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_OAUTH2_CONFIG_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_CONFIG_ERROR_756", 756);

    /**
     * The requested admin API version '%s' is unsupported. This endpoint only supports the following admin API version(s): %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BAD_ADMIN_API_RESOURCE_VERSION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_BAD_ADMIN_API_RESOURCE_VERSION_757", 757);

    /**
     * The configuration of schema provider '%s' is not acceptable for the following reasons: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_SCHEMA_PROVIDER_CONFIG_NOT_ACCEPTABLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_PROVIDER_CONFIG_NOT_ACCEPTABLE_758", 758);

    /**
     * The schema provider class '%s' could not be instantiated or initialized with the configuration '%s' : %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONFIG_SCHEMA_PROVIDER_CANT_BE_INITIALIZED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_SCHEMA_PROVIDER_CANT_BE_INITIALIZED_759", 759);

    /**
     * The core schema provider defined by '%s' has been disabled. The core schema must always be enabled.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_CORE_SCHEMA_PROVIDER_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_CORE_SCHEMA_PROVIDER_DISABLED_760", 760);

    /**
     * The config schema file '%s' generated warning when trying to update schema with its content: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_FILE_HAS_SCHEMA_WARNING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_FILE_HAS_SCHEMA_WARNING_761", 761);

    /**
     * The config schema file '%s' generated warning when trying to update schema with its content, despite allowing to overwrite definitions: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_CONFIG_SCHEMA_FILE_HAS_SCHEMA_WARNING_WITH_OVERWRITE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ConfigMessages.class, RESOURCE, "WARN_CONFIG_SCHEMA_FILE_HAS_SCHEMA_WARNING_WITH_OVERWRITE_762", 762);

    /**
     * Unable to configure the backend '%s' because one of its base DNs is the empty DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_BACKEND_BASE_IS_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_BACKEND_BASE_IS_EMPTY_763", 763);

    /**
     * Entry '%s' cannot be added because attribute '%s' contained an expression '%s' that could not be evaluated: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CONFIG_FILE_ADD_REJECTED_DUE_TO_EVALUATION_FAILURE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_ADD_REJECTED_DUE_TO_EVALUATION_FAILURE_764", 764);

    /**
     * Entry '%s' cannot be deleted because attribute '%s' contained an expression '%s' that could not be evaluated: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CONFIG_FILE_DELETE_REJECTED_DUE_TO_EVALUATION_FAILURE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_DELETE_REJECTED_DUE_TO_EVALUATION_FAILURE_765", 765);

    /**
     * Entry '%s' cannot be modified because attribute '%s' contained an expression '%s' that could not be evaluated: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CONFIG_FILE_MODIFY_REJECTED_DUE_TO_EVALUATION_FAILURE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_MODIFY_REJECTED_DUE_TO_EVALUATION_FAILURE_766", 766);

    /**
     * Entry '%s' cannot be read because attribute '%s' contained an expression '%s' that could not be evaluated: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CONFIG_FILE_READ_FAILED_DUE_TO_EVALUATION_FAILURE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ConfigMessages.class, RESOURCE, "ERR_CONFIG_FILE_READ_FAILED_DUE_TO_EVALUATION_FAILURE_767", 767);

}
