package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.schema}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/schema.properties} and it should not be manually edited.
 */
public final class SchemaMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.schema";

    // Prevent instantiation.
    private SchemaMessages() {
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
     * The provided value "%s" is too short to be a valid generalized time value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_TOO_SHORT_13", 13);

    /**
     * The provided value "%s" is not a valid generalized time value because the '%s' character is not allowed in the century or year specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_YEAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_YEAR_14", 14);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid month specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MONTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MONTH_15", 15);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid day specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_DAY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_DAY_16", 16);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid hour specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_HOUR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_HOUR_17", 17);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid minute specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MINUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MINUTE_18", 18);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid second specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_SECOND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_SECOND_19", 19);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid GMT offset
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_OFFSET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_OFFSET_22", 22);

    /**
     * The provided value "%s" is not a valid generalized time value because it contains an invalid character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_CHAR_23", 23);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the last non-space character was a comma or semicolon
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_END_WITH_COMMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_END_WITH_COMMA_26", 26);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because character '%c' at position %d is not allowed in an attribute name
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_CHAR_28", 28);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the underscore character is not allowed in an attribute name unless the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_UNDERSCORE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_UNDERSCORE_CHAR_29", 29);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the hyphen character is not allowed as the first character of an attribute name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_DASH =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_DASH_30", 30);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the underscore character is not allowed as the first character of an attribute name even if the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_UNDERSCORE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_UNDERSCORE_31", 31);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the digit '%c' is not allowed as the first character of an attribute name unless the name is specified as an OID or the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Object> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_DIGIT =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_INITIAL_DIGIT_32", 32);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because it contained an RDN containing an empty attribute name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_ATTR_NO_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_NO_NAME_33", 33);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the parsed attribute name %s included a period but that name did not appear to be a valid OID
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_PERIOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_PERIOD_34", 34);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the last non-space character was part of the attribute name '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_END_WITH_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_END_WITH_ATTR_NAME_35", 35);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the next non-space character after attribute name "%s" should have been an equal sign but instead was '%c'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Character> ERR_ATTR_SYNTAX_DN_NO_EQUAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Character>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_NO_EQUAL_36", 36);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because character '%c' at position %d is not valid
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_DN_INVALID_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_INVALID_CHAR_37", 37);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with an octothorpe (#) but was not followed by a positive multiple of two hexadecimal digits
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_HEX_VALUE_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_HEX_VALUE_TOO_SHORT_38", 38);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with an octothorpe (#) but contained a character %c that was not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_ATTR_SYNTAX_DN_INVALID_HEX_DIGIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_INVALID_HEX_DIGIT_39", 39);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an unexpected failure occurred while attempting to parse an attribute value from one of the RDN components: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_ATTR_VALUE_DECODE_FAILURE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_VALUE_DECODE_FAILURE_40", 40);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because one of the RDN components included a quoted value that did not have a corresponding closing quotation mark
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_UNMATCHED_QUOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_UNMATCHED_QUOTE_41", 41);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because one of the RDN components included a value with an escaped hexadecimal digit that was not followed by a second hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_ESCAPED_HEX_VALUE_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ESCAPED_HEX_VALUE_INVALID_42", 42);

    /**
     * The provided value could not be parsed as a valid attribute type description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_ATTRTYPE_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRTYPE_EMPTY_VALUE_52", 52);

    /**
     * The provided value could not be parsed as a valid objectclass description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_OBJECTCLASS_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_EMPTY_VALUE_69", 69);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_OPEN_PARENTHESIS_70", 70);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_OBJECTCLASS_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_TRUNCATED_VALUE_71", 71);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_OBJECTCLASS_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_DOUBLE_PERIOD_IN_NUMERIC_OID_72", 72);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because the numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR_IN_NUMERIC_OID_73", 73);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because the non-numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR_IN_STRING_OID_74", 74);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because it contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_CHAR_75", 75);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_OBJECTCLASS_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_UNEXPECTED_CLOSE_PARENTHESIS_76", 76);

    /**
     * The definition for the objectclass with OID %s declared a superior objectclass with an OID of %s. No objectclass with this OID exists in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_SUPERIOR_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_SUPERIOR_CLASS_78", 78);

    /**
     * The provided value "%s" could not be parsed as an objectclass description because a single quote was expected at position %d but the character %s was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_QUOTE_AT_POS_79", 79);

    /**
     * The definition for the objectclass with OID %s declared that it should include required attribute "%s". No attribute type matching this name or OID exists in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_REQUIRED_ATTR_80", 80);

    /**
     * The definition for the objectclass with OID %s declared that it should include optional attribute "%s". No attribute type matching this name or OID exists in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_OPTIONAL_ATTR_81", 81);

    /**
     * The provided value could not be parsed as a valid DIT content rule description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_DCR_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_EMPTY_VALUE_119", 119);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DCR_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_EXPECTED_OPEN_PARENTHESIS_120", 120);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DCR_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_TRUNCATED_VALUE_121", 121);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DCR_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_DOUBLE_PERIOD_IN_NUMERIC_OID_122", 122);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because the numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR_IN_NUMERIC_OID_123", 123);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because the non-numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR_IN_STRING_OID_124", 124);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DCR_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNEXPECTED_CLOSE_PARENTHESIS_125", 125);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because it contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_ILLEGAL_CHAR_126", 126);

    /**
     * The DIT content rule "%s" is associated with a structural objectclass %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_STRUCTURAL_CLASS_127", 127);

    /**
     * The DIT content rule "%s" is associated with the objectclass with OID %s (%s). This objectclass exists in the server schema but is defined as %s rather than structural
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ATTR_SYNTAX_DCR_STRUCTURAL_CLASS_NOT_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_STRUCTURAL_CLASS_NOT_STRUCTURAL_128", 128);

    /**
     * The DIT content rule "%s" is associated with an auxiliary objectclass %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_AUXILIARY_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_AUXILIARY_CLASS_129", 129);

    /**
     * The DIT content rule "%s" is associated with an auxiliary objectclass %s. This objectclass exists in the server schema but is defined as %s rather than auxiliary
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_AUXILIARY_CLASS_NOT_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_AUXILIARY_CLASS_NOT_AUXILIARY_130", 130);

    /**
     * The DIT content rule "%s" is associated with a required attribute type %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_REQUIRED_ATTR_131", 131);

    /**
     * The DIT content rule "%s" is associated with an optional attribute type %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_OPTIONAL_ATTR_132", 132);

    /**
     * The DIT content rule "%s" is associated with a prohibited attribute type %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_PROHIBITED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_PROHIBITED_ATTR_133", 133);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because a single quote was expected at position %d but the %s character was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DCR_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_EXPECTED_QUOTE_AT_POS_134", 134);

    /**
     * The provided value could not be parsed as a valid name form description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_NAME_FORM_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_EMPTY_VALUE_135", 135);

    /**
     * The provided value "%s" could not be parsed as a name form description because an open parenthesis was expected at position %d but instead a '%c' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Character> ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Character>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_OPEN_PARENTHESIS_136", 136);

    /**
     * The provided value "%s" could not be parsed as a name form description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_NAME_FORM_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_TRUNCATED_VALUE_137", 137);

    /**
     * The provided value "%s" could not be parsed as a name form description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_NAME_FORM_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_DOUBLE_PERIOD_IN_NUMERIC_OID_138", 138);

    /**
     * The provided value "%s" could not be parsed as a name form description because the numeric OID contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR_IN_NUMERIC_OID_139", 139);

    /**
     * The provided value "%s" could not be parsed as a name form description because the non-numeric OID contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR_IN_STRING_OID_140", 140);

    /**
     * The provided value "%s" could not be parsed as a name form description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_NAME_FORM_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNEXPECTED_CLOSE_PARENTHESIS_141", 141);

    /**
     * The provided value "%s" could not be parsed as a name form description because it contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_CHAR_142", 142);

    /**
     * The name form description "%s" is associated with a structural objectclass %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_STRUCTURAL_CLASS_143", 143);

    /**
     * The name form description "%s" is associated with the objectclass with OID %s (%s). This objectclass exists in the server schema but is defined as %s rather than structural
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_STRUCTURAL_CLASS_NOT_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_STRUCTURAL_CLASS_NOT_STRUCTURAL_144", 144);

    /**
     * The definition for the name form with OID %s declared that it should include required attribute "%s". No attribute type matching this name or OID exists in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_REQUIRED_ATTR_145", 145);

    /**
     * The definition for the name form with OID %s declared that it should include optional attribute "%s". No attribute type matching this name or OID exists in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_OPTIONAL_ATTR_146", 146);

    /**
     * The provided value "%s" could not be parsed as a name form description because it does not specify the structural objectclass with which it is associated
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_NAME_FORM_NO_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_NO_STRUCTURAL_CLASS_147", 147);

    /**
     * The provided value "%s" could not be parsed as a name form description because a single quote was expected at position %d but the %c character was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Character> ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Character>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_QUOTE_AT_POS_148", 148);

    /**
     * The provided value could not be parsed as a valid matching rule use description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_MRUSE_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_EMPTY_VALUE_160", 160);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_MRUSE_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_EXPECTED_OPEN_PARENTHESIS_161", 161);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MRUSE_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_TRUNCATED_VALUE_162", 162);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_MRUSE_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_DOUBLE_PERIOD_IN_NUMERIC_OID_163", 163);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because the numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR_IN_NUMERIC_OID_164", 164);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because the non-numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR_IN_STRING_OID_165", 165);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because the specified matching rule %s is unknown
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_MATCHING_RULE_166", 166);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_MRUSE_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_UNEXPECTED_CLOSE_PARENTHESIS_167", 167);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because it contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_CHAR_168", 168);

    /**
     * The matching rule use description "%s" is associated with attribute type %s that is not defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_ATTR_169", 169);

    /**
     * The provided value "%s" could not be parsed as a matching rule description because it does not specify the set of attribute types that may be used with the associated OID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MRUSE_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_NO_ATTR_170", 170);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because a single quote was expected at position %d but the %s character was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_MRUSE_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_EXPECTED_QUOTE_AT_POS_171", 171);

    /**
     * The provided value could not be parsed as a valid DIT structure rule description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_DSR_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_EMPTY_VALUE_172", 172);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DSR_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_EXPECTED_OPEN_PARENTHESIS_173", 173);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DSR_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_TRUNCATED_VALUE_174", 174);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because the rule ID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_RULE_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_RULE_ID_175", 175);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DSR_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_UNEXPECTED_CLOSE_PARENTHESIS_176", 176);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_177", 177);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it referenced an unknown name form %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DSR_UNKNOWN_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_UNKNOWN_NAME_FORM_178", 178);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it referenced an unknown rule ID %d for a superior DIT structure rule
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DSR_UNKNOWN_RULE_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_UNKNOWN_RULE_ID_179", 179);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it did not specify the name form for the rule
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DSR_NO_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_NO_NAME_FORM_180", 180);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because a single quote was expected at position %d but the %s character was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DSR_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_EXPECTED_QUOTE_AT_POS_181", 181);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DSR_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_DOUBLE_PERIOD_IN_NUMERIC_OID_182", 182);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because the numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_NUMERIC_OID_183", 183);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because the non-numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_ILLEGAL_CHAR_IN_STRING_OID_184", 184);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Character, Number> ERR_ATTR_SYNTAX_GUIDE_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_ILLEGAL_CHAR_206", 206);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not contain a close parenthesis that corresponded to the initial open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_MISSING_CLOSE_PAREN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_MISSING_CLOSE_PAREN_207", 207);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s started with a question mark but was not followed by the string "true" or "false"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_INVALID_QUESTION_MARK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_INVALID_QUESTION_MARK_208", 208);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not contain a dollar sign to separate the attribute type from the match type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_DOLLAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_DOLLAR_209", 209);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not specify an attribute type before the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_ATTR_210", 210);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not specify a match type after the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_MATCH_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_MATCH_TYPE_211", 211);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s had an invalid match type starting at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_GUIDE_INVALID_MATCH_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_INVALID_MATCH_TYPE_212", 212);

    /**
     * The provided authPassword value had an invalid scheme character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_SCHEME_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_SCHEME_CHAR_243", 243);

    /**
     * The provided authPassword value had a zero-length scheme element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME_244", 244);

    /**
     * The provided authPassword value was missing the separator character or had an illegal character between the scheme and authInfo elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME_SEPARATOR_245", 245);

    /**
     * The provided authPassword value had an invalid authInfo character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_INFO_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_INFO_CHAR_246", 246);

    /**
     * The provided authPassword value had a zero-length authInfo element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO_247", 247);

    /**
     * The provided authPassword value was missing the separator character or had an illegal character between the authInfo and authValue elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO_SEPARATOR_248", 248);

    /**
     * No value was given to decode by the user password attribute syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_VALUE_253", 253);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not start with the opening curly brace ("{") character
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_OPENING_BRACE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_OPENING_BRACE_254", 254);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not contain a closing curly brace ("}") character
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_CLOSING_BRACE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_CLOSING_BRACE_255", 255);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not contain a storage scheme name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_SCHEME_256", 256);

    /**
     * The provided value "%s" could not be parsed as a valid RFC 3672 subtree specification
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_RFC3672_SUBTREE_SPECIFICATION_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_RFC3672_SUBTREE_SPECIFICATION_INVALID_257", 257);

    /**
     * The provided authPassword value had an invalid authValue character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_VALUE_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_VALUE_CHAR_261", 261);

    /**
     * The provided authPassword value had a zero-length authValue element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_VALUE_262", 262);

    /**
     * The provided authPassword value had an invalid trailing character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_TRAILING_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_TRAILING_CHAR_263", 263);

    /**
     * The definition for objectclass %s is invalid because it has an objectclass type of %s but this is incompatible with the objectclass type %s for the superior class %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_TYPE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_TYPE_266", 266);

    /**
     * The definition for objectclass %s is invalid because it is defined as a structural class but its superior chain does not include the "top" objectclass
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_OBJECTCLASS_STRUCTURAL_SUPERIOR_NOT_TOP =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_STRUCTURAL_SUPERIOR_NOT_TOP_267", 267);

    /**
     * The provided value "%s" could not be parsed as a valid subtree specification
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_SUBTREE_SPECIFICATION_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_SUBTREE_SPECIFICATION_INVALID_269", 269);

    /**
     * The DIT content rule "%s" is not valid because it prohibits the use of attribute type %s which is required by the associated structural object class %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_STRUCTURAL_271", 271);

    /**
     * The DIT content rule "%s" is not valid because it prohibits the use of attribute type %s which is required by the associated auxiliary object class %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_AUXILIARY_272", 272);

    /**
     * The provided value %s is not a valid generalized time value because it contains illegal character %s in the fraction component
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_FRACTION_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_FRACTION_CHAR_275", 275);

    /**
     * The provided value %s is not a valid generalized time value because it does not contain at least one digit after the period to use as the fractional component
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_EMPTY_FRACTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_EMPTY_FRACTION_276", 276);

    /**
     * The provided value %s is not a valid generalized time value because it does not end with 'Z' or a time zone offset
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_NO_TIME_ZONE_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_NO_TIME_ZONE_INFO_277", 277);

    /**
     * The provided value %s is not a valid generalized time value because it represents an invalid time (e.g., a date that does not exist): %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_TIME_278", 278);

    /**
     * A schema element could not be imported: %s, %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_SCHEMA_IMPORT_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "NOTE_SCHEMA_IMPORT_FAILED_279", 279);

    /**
     * The collation rule %s under matching rule entry %s is invalid as the locale %s is not supported by JVM
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ATTR_INVALID_COLLATION_MATCHING_RULE_LOCALE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_INVALID_COLLATION_MATCHING_RULE_LOCALE_280", 280);

    /**
     * The provided collation rule %s does not contain a valid format of OID:LOCALE
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_INVALID_COLLATION_MATCHING_RULE_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_INVALID_COLLATION_MATCHING_RULE_FORMAT_281", 281);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with a character at position %d that needs to be escaped
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DN_INVALID_REQUIRES_ESCAPE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_INVALID_REQUIRES_ESCAPE_CHAR_282", 282);

    /**
     * The provided value "%s" could not be parsed as a valid object class definition because character '%c' at position %d is not allowed in an object class name
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_OC_SYNTAX_ATTR_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(SchemaMessages.class, RESOURCE, "ERR_OC_SYNTAX_ATTR_ILLEGAL_CHAR_288", 288);

    /**
     * The provided value "%s" could not be parsed as a valid object class definition because the underscore character is not allowed in an object class name unless the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OC_SYNTAX_ATTR_ILLEGAL_UNDERSCORE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_OC_SYNTAX_ATTR_ILLEGAL_UNDERSCORE_CHAR_289", 289);

    /**
     * The provided value "%s" could not be parsed as a valid object class definition because the hyphen character is not allowed as the first character of an object class name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_DASH =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_DASH_290", 290);

    /**
     * The provided value "%s" could not be parsed as a valid object class definition because the underscore character is not allowed as the first character of an object class name even if the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_UNDERSCORE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_UNDERSCORE_291", 291);

    /**
     * The provided value "%s" could not be parsed as a valid object class definition because the digit '%c' is not allowed as the first character of an object class name unless the name is specified as an OID or the %s configuration option is enabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Object> ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_DIGIT =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Object>(SchemaMessages.class, RESOURCE, "ERR_OC_SYNTAX_ATTR_ILLEGAL_INITIAL_DIGIT_292", 292);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax because it contains an unrecognized extension %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_UNKNOWN_EXT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_UNKNOWN_EXT_306", 306);

    /**
     * The provided value "%s" could not be parsed as a regex syntax because it does not contain a regex pattern
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_NO_PATTERN =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_NO_PATTERN_308", 308);

    /**
     * The provided value "%s" could not be parsed as a regex syntax because the provided regex pattern "%s" is invalid
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_PATTERN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_PATTERN_309", 309);

    /**
     * The provided value "%s" cannot be parsed as an enumeration syntax because it contains a duplicate value "%s" at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_DUPLICATE_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_DUPLICATE_VALUE_311", 311);

    /**
     * The provided value could not be parsed as a valid ldap syntax description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_LDAPSYNTAX_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_EMPTY_VALUE_317", 317);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_EXPECTED_OPEN_PARENTHESIS_318", 318);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because the end of the value was encountered while the Directory Server expected more data to be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_TRUNCATED_VALUE_319", 319);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_DOUBLE_PERIOD_IN_NUMERIC_OID_320", 320);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because the numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_ILLEGAL_CHAR_IN_NUMERIC_OID_321", 321);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because the non-numeric OID contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_ILLEGAL_CHAR_IN_STRING_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_ILLEGAL_CHAR_IN_STRING_OID_322", 322);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because it contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_UNEXPECTED_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_UNEXPECTED_CLOSE_PARENTHESIS_323", 323);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because it contains more than one form of constructor
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_TOO_MANY_EXTENSIONS =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_TOO_MANY_EXTENSIONS_324", 324);

    /**
     * The definition for the ldap syntax with OID %s declared that it's a substitute for a syntax with OID %s. No such syntax is configured for use in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_UNKNOWN_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_UNKNOWN_SYNTAX_325", 325);

    /**
     * The provided value "%s" could not be parsed as an enumeration syntax, because there is no value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_ENUM_NO_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_ENUM_NO_VALUES_326", 326);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax extension because an invalid character was found at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_LDAPSYNTAX_EXTENSION_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_EXTENSION_INVALID_CHARACTER_327", 327);

    /**
     * The provided value "%s" could not be parsed as an ldap syntax description because a single quote was expected at position %d but the character %s was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_LDAPSYNTAX_EXPECTED_QUOTE_AT_POS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_LDAPSYNTAX_EXPECTED_QUOTE_AT_POS_329", 329);

    /**
     * The provided value "%s" is not safe for X-SCHEMA-FILE
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ILLEGAL_X_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ILLEGAL_X_SCHEMA_FILE_334", 334);

    /**
     * Attribute type could not be registered from definition: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_TYPE_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_ATTR_TYPE_CANNOT_REGISTER_340", 340);

    /**
     * There should be no warnings on the schema, but instead got %d warnings: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_SCHEMA_HAS_WARNINGS =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(SchemaMessages.class, RESOURCE, "ERR_SCHEMA_HAS_WARNINGS_341", 341);

    /**
     * Matching rule use could not be registered from definition: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MATCHING_RULE_USE_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_MATCHING_RULE_USE_CANNOT_REGISTER_342", 342);

    /**
     * Object class could not be registered from definition: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OBJECT_CLASS_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_OBJECT_CLASS_CANNOT_REGISTER_343", 343);

    /**
     * Unable to parse the OID from the provided definition of objectclass: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_OBJECTCLASS_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_OBJECTCLASS_OID_344", 344);

    /**
     * Unable to parse the OID from the provided definition of attribute type: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_ATTRIBUTE_TYPE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_ATTRIBUTE_TYPE_OID_345", 345);

    /**
     * Unable to parse the OID from the provided definition of ldap syntax: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_LDAP_SYNTAX_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_LDAP_SYNTAX_OID_346", 346);

    /**
     * Unable to parse the OID from the provided definition of matching rule use: '%s' 
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_MATCHING_RULE_USE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_MATCHING_RULE_USE_OID_347", 347);

    /**
     * DIT content rule could not be registered from definition: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DIT_CONTENT_RULE_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_DIT_CONTENT_RULE_CANNOT_REGISTER_348", 348);

    /**
     * Name form could not be registered from definition: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NAME_FORM_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_NAME_FORM_CANNOT_REGISTER_349", 349);

    /**
     * Unable to parse the OID from the provided definition of name form: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_NAME_FORM_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_NAME_FORM_OID_350", 350);

    /**
     * Unable to parse the OID from the provided definition of DIT content rule: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_DIT_CONTENT_RULE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_DIT_CONTENT_RULE_OID_351", 351);

    /**
     * Unable to parse the rule ID from the provided definition of DIT structure rule: '%s' 
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PARSING_DIT_STRUCTURE_RULE_RULEID =
                    new LocalizableMessageDescriptor.Arg1<Object>(SchemaMessages.class, RESOURCE, "ERR_PARSING_DIT_STRUCTURE_RULE_RULEID_352", 352);

}
