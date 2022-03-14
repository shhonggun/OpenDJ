package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.utility}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/utility.properties} and it should not be manually edited.
 */
public final class UtilityMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.utility";

    // Prevent instantiation.
    private UtilityMessages() {
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
     * The value %s cannot be base64-decoded because it does not have a length that is a multiple of four bytes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_DECODE_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_DECODE_INVALID_LENGTH_1", 1);

    /**
     * The value %s cannot be base64-decoded because it contains an illegal character %c that is not allowed in base64-encoded values
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_BASE64_DECODE_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(UtilityMessages.class, RESOURCE, "ERR_BASE64_DECODE_INVALID_CHARACTER_2", 2);

    /**
     * The value %s cannot be decoded as a hexadecimal string because it does not have a length that is a multiple of two bytes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_HEX_DECODE_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_HEX_DECODE_INVALID_LENGTH_3", 3);

    /**
     * The value %s cannot be decoded as a hexadecimal string because it contains an illegal character %c that is not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_HEX_DECODE_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(UtilityMessages.class, RESOURCE, "ERR_HEX_DECODE_INVALID_CHARACTER_4", 4);

    /**
     * Unable to parse line %d ("%s") from the LDIF source because the line started with a space but there were no previous lines in the entry to which this line could be appended
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_INVALID_LEADING_SPACE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_LEADING_SPACE_5", 5);

    /**
     * Unable to parse LDIF entry starting at line %d because the line "%s" does not include an attribute name
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_NO_ATTR_NAME_6", 6);

    /**
     * Unable to parse LDIF entry starting at line %d because the first line does not contain a DN (the first line was "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_DN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_NO_DN_7", 7);

    /**
     * Unable to parse LDIF entry starting at line %d because an error occurred while trying to parse the value of line "%s" as a distinguished name: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_DN_9", 9);

    /**
     * Unable to parse LDIF entry starting at line %d because it was not possible to base64-decode the DN on line "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_COULD_NOT_BASE64_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_BASE64_DECODE_DN_11", 11);

    /**
     * Unable to parse LDIF entry %s starting at line %d because it was not possible to base64-decode the attribute on line "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDIF_COULD_NOT_BASE64_DECODE_ATTR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_BASE64_DECODE_ATTR_12", 12);

    /**
     * Entry %s read from LDIF starting at line %d includes a duplicate objectclass value %s. The second occurrence of that objectclass has been skipped
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> WARN_LDIF_DUPLICATE_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(UtilityMessages.class, RESOURCE, "WARN_LDIF_DUPLICATE_OBJECTCLASS_13", 13);

    /**
     * Entry %s read from LDIF starting at line %d includes a duplicate attribute %s with value %s. The second occurrence of that attribute value has been skipped
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> WARN_LDIF_DUPLICATE_ATTR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(UtilityMessages.class, RESOURCE, "WARN_LDIF_DUPLICATE_ATTR_14", 14);

    /**
     * Entry %s starting at line %d includes multiple values for single-valued attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDIF_MULTIPLE_VALUES_FOR_SINGLE_VALUED_ATTR =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_MULTIPLE_VALUES_FOR_SINGLE_VALUED_ATTR_15", 15);

    /**
     * Entry %s read from LDIF starting at line %d is not valid because it violates the server's schema configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDIF_SCHEMA_VIOLATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SCHEMA_VIOLATION_17", 17);

    /**
     * The specified LDIF file %s already exists and the export configuration indicates that no attempt should be made to append to or replace the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_FILE_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_FILE_EXISTS_18", 18);

    /**
     * Unable to parse LDIF entry %s starting at line %d because the value of attribute %s was to be read from a URL but the URL was invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDIF_INVALID_URL =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_URL_19", 19);

    /**
     * Unable to parse LDIF entry %s starting at line %d because the value of attribute %s was to be read from URL %s but an error occurred while trying to read that content: %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object> ERR_LDIF_URL_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_URL_IO_ERROR_20", 20);

    /**
     * The specified reject file %s already exists and the import configuration indicates that no attempt should be made to append to or replace the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REJECT_FILE_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_REJECT_FILE_EXISTS_21", 21);

    /**
     * An error occurred while attempting to determine whether LDIF entry "%s" starting at line %d should be imported as a result of the include and exclude filter configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDIF_COULD_NOT_EVALUATE_FILTERS_FOR_IMPORT =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_EVALUATE_FILTERS_FOR_IMPORT_22", 22);

    /**
     * An error occurred while attempting to determine whether LDIF entry "%s" should be exported as a result of the include and exclude filter configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_COULD_NOT_EVALUATE_FILTERS_FOR_EXPORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_EVALUATE_FILTERS_FOR_EXPORT_23", 23);

    /**
     * Error in the LDIF change record entry. Invalid attributes specified for the delete operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIF_INVALID_DELETE_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_DELETE_ATTRIBUTES_24", 24);

    /**
     * Error in the LDIF change record entry. No attributes specified for the mod DN operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIF_NO_MOD_DN_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_LDIF_NO_MOD_DN_ATTRIBUTES_25", 25);

    /**
     * Error in the LDIF change record entry. No delete old RDN attribute specified for the mod DN operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIF_NO_DELETE_OLDRDN_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_LDIF_NO_DELETE_OLDRDN_ATTRIBUTE_26", 26);

    /**
     * Error in the LDIF change record entry. Invalid value "%s" for the delete old RDN attribute specified for the mod DN operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_INVALID_DELETE_OLDRDN_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_DELETE_OLDRDN_ATTRIBUTE_27", 27);

    /**
     * Error in the LDIF change record entry. Invalid attribute "%s" specified. Expecting attribute "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_INVALID_CHANGERECORD_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_CHANGERECORD_ATTRIBUTE_28", 28);

    /**
     * Error in the LDIF change record entry. Invalid attribute "%s" specified. Expecting one of the following attributes "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_INVALID_MODIFY_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_MODIFY_ATTRIBUTE_29", 29);

    /**
     * Error in the LDIF change record entry. Invalid value "%s" for the changetype specified. Expecting one of the following values "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_INVALID_CHANGETYPE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_CHANGETYPE_ATTRIBUTE_30", 30);

    /**
     * The provided value could not be parsed to determine whether it contained a valid schema element name or OID because it was null or empty
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SCHEMANAME_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_SCHEMANAME_EMPTY_VALUE_32", 32);

    /**
     * The provided value "%s" does not contain a valid schema element name or OID because it contains an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_SCHEMANAME_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(UtilityMessages.class, RESOURCE, "ERR_SCHEMANAME_ILLEGAL_CHAR_33", 33);

    /**
     * The provided value "%s" does not contain a valid schema element name or OID because the numeric OID contains two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_SCHEMANAME_CONSECUTIVE_PERIODS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_SCHEMANAME_CONSECUTIVE_PERIODS_34", 34);

    /**
     * The file to move %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MOVEFILE_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_MOVEFILE_NO_SUCH_FILE_72", 72);

    /**
     * The file to move %s exists but is not a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MOVEFILE_NOT_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_MOVEFILE_NOT_FILE_73", 73);

    /**
     * The target directory %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MOVEFILE_NO_SUCH_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_MOVEFILE_NO_SUCH_DIRECTORY_74", 74);

    /**
     * The target directory %s exists but is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MOVEFILE_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_MOVEFILE_NOT_DIRECTORY_75", 75);

    /**
     * The provided sender address %s is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMAILMSG_INVALID_SENDER_ADDRESS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMAILMSG_INVALID_SENDER_ADDRESS_76", 76);

    /**
     * The provided recipient address %s is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMAILMSG_INVALID_RECIPIENT_ADDRESS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMAILMSG_INVALID_RECIPIENT_ADDRESS_77", 77);

    /**
     * The specified e-mail message could not be sent using any of the configured mail servers
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EMAILMSG_CANNOT_SEND =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_EMAILMSG_CANNOT_SEND_78", 78);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because it does not contain the necessary :// component to separate the scheme from the rest of the URL
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_NO_COLON_SLASH_SLASH =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_NO_COLON_SLASH_SLASH_110", 110);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because it does not contain a protocol scheme
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_NO_SCHEME_111", 111);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because it does not contain a host before the colon to specify the port number
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_NO_HOST =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_NO_HOST_112", 112);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because it does not contain a port number after the colon following the host
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_NO_PORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_NO_PORT_113", 113);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the port number portion %s cannot be decoded as an integer
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_CANNOT_DECODE_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_CANNOT_DECODE_PORT_114", 114);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the provided port number %d is not within the valid range between 1 and 65535
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPURL_INVALID_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_PORT_115", 115);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the scope string %s was not one of the allowed values of base, one, sub, or subordinate
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_INVALID_SCOPE_STRING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_SCOPE_STRING_116", 116);

    /**
     * The provided URL component "%s" could not be decoded because the percent character at byte %d was not followed by two hexadecimal digits
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPURL_PERCENT_TOO_CLOSE_TO_END =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_PERCENT_TOO_CLOSE_TO_END_117", 117);

    /**
     * The provided URL component "%s" could not be decoded because the character at byte %d was not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPURL_INVALID_HEX_BYTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_HEX_BYTE_118", 118);

    /**
     * An error occurred while attempting to represent a byte array as a UTF-8 string during the course of decoding a portion of an LDAP URL: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_CANNOT_CREATE_UTF8_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAPURL_CANNOT_CREATE_UTF8_STRING_119", 119);

    /**
     * Cannot decode value "%s" as a named character set because it does not contain a colon to separate the name from the set of characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_NO_COLON =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CHARSET_NO_COLON_120", 120);

    /**
     * The named character set is invalid because it does not contain a name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CHARSET_CONSTRUCTOR_NO_NAME =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_CHARSET_CONSTRUCTOR_NO_NAME_121", 121);

    /**
     * The named character set is invalid because the provide name "%s" has an invalid character at position %d. Only ASCII alphabetic characters are allowed in the name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_CHARSET_CONSTRUCTOR_INVALID_NAME_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_CHARSET_CONSTRUCTOR_INVALID_NAME_CHAR_122", 122);

    /**
     * Cannot decode value "%s" as a named character set because it does not contain a name to use for the character set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_NO_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CHARSET_NO_NAME_123", 123);

    /**
     * Cannot decode value "%s" as a named character set because there are no characters to include in the set
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CHARSET_NO_CHARS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CHARSET_NO_CHARS_124", 124);

    /**
     * %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_TIME_IN_SECONDS =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "INFO_TIME_IN_SECONDS_125", 125);

    /**
     * %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_TIME_IN_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(UtilityMessages.class, RESOURCE, "INFO_TIME_IN_MINUTES_SECONDS_126", 126);

    /**
     * %d hours, %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> INFO_TIME_IN_HOURS_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(UtilityMessages.class, RESOURCE, "INFO_TIME_IN_HOURS_MINUTES_SECONDS_127", 127);

    /**
     * %d days, %d hours, %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> INFO_TIME_IN_DAYS_HOURS_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(UtilityMessages.class, RESOURCE, "INFO_TIME_IN_DAYS_HOURS_MINUTES_SECONDS_128", 128);

    /**
     * Unable to set permissions for file %s because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILEPERM_SET_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_FILEPERM_SET_NO_SUCH_FILE_141", 141);

    /**
     * One or more exceptions were thrown in the process of updating the file permissions for %s. Some of the permissions for the file may have been altered
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILEPERM_SET_JAVA_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_FILEPERM_SET_JAVA_EXCEPTION_143", 143);

    /**
     * The provided string %s does not represent a valid UNIX file mode. UNIX file modes must be a three-character string in which each character is a numeric digit between zero and seven
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FILEPERM_INVALID_UNIX_MODE_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_FILEPERM_INVALID_UNIX_MODE_STRING_146", 146);

    /**
     * The %s command will not be allowed because the Directory Server has been configured to refuse the use of the exec method
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXEC_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EXEC_DISABLED_147", 147);

    /**
     * Failed to rename file %s to %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RENAMEFILE_CANNOT_RENAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_RENAMEFILE_CANNOT_RENAME_157", 157);

    /**
     * Failed to delete target file %s. Make sure the file is not currently in use by this or another application
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RENAMEFILE_CANNOT_DELETE_TARGET =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_RENAMEFILE_CANNOT_DELETE_TARGET_158", 158);

    /**
     * Refusing to trust client or issuer certificate '%s' because it expired on %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXPCHECK_TRUSTMGR_CLIENT_CERT_EXPIRED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EXPCHECK_TRUSTMGR_CLIENT_CERT_EXPIRED_159", 159);

    /**
     * Refusing to trust client or issuer certificate '%s' because it is not valid until %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXPCHECK_TRUSTMGR_CLIENT_CERT_NOT_YET_VALID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EXPCHECK_TRUSTMGR_CLIENT_CERT_NOT_YET_VALID_160", 160);

    /**
     * Refusing to trust server or issuer certificate '%s' because it expired on %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXPCHECK_TRUSTMGR_SERVER_CERT_EXPIRED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EXPCHECK_TRUSTMGR_SERVER_CERT_EXPIRED_161", 161);

    /**
     * Refusing to trust server or issuer certificate '%s' because it is not valid until %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EXPCHECK_TRUSTMGR_SERVER_CERT_NOT_YET_VALID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EXPCHECK_TRUSTMGR_SERVER_CERT_NOT_YET_VALID_162", 162);

    /**
     * Entry %s read from LDIF starting at line %d includes value "%s" for attribute %s that is invalid according to the associated syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object> WARN_LDIF_VALUE_VIOLATES_SYNTAX =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object>(UtilityMessages.class, RESOURCE, "WARN_LDIF_VALUE_VIOLATES_SYNTAX_163", 163);

    /**
     * The specified skip file %s already exists and the import configuration indicates that no attempt should be made to append to or replace the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SKIP_FILE_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_SKIP_FILE_EXISTS_164", 164);

    /**
     * Skipping entry %s because the DN is not one that should be included based on the include and exclude branches/filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_SKIP =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SKIP_165", 165);

    /**
     * The embedded server with server root '%s' cannot be started because it is already running.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMBEDUTILS_SERVER_ALREADY_RUNNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDUTILS_SERVER_ALREADY_RUNNING_167", 167);

    /**
     * Send an e-mail message via SMTP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_TOOL_DESCRIPTION_171", 171);

    /**
     * The address of the SMTP server to use to send the message
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_HOST_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_HOST_DESCRIPTION_172", 172);

    /**
     * The address to use for the message sender
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_FROM_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_FROM_DESCRIPTION_173", 173);

    /**
     * The address to use for the message recipient
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_TO_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_TO_DESCRIPTION_174", 174);

    /**
     * The subject to use for the e-mail message
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_SUBJECT_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_SUBJECT_DESCRIPTION_175", 175);

    /**
     * The path to the file containing the text for the message body
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_BODY_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_BODY_DESCRIPTION_176", 176);

    /**
     * The path to a file to attach to the e-mail message
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMAIL_ATTACH_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_EMAIL_ATTACH_DESCRIPTION_177", 177);

    /**
     * The file %s specified as the body file for the e-mail message does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMAIL_NO_SUCH_BODY_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMAIL_NO_SUCH_BODY_FILE_181", 181);

    /**
     * An error occurred while attempting to process message body file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMAIL_CANNOT_PROCESS_BODY_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMAIL_CANNOT_PROCESS_BODY_FILE_182", 182);

    /**
     * The attachment file %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMAIL_NO_SUCH_ATTACHMENT_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMAIL_NO_SUCH_ATTACHMENT_FILE_183", 183);

    /**
     * An error occurred while trying to attach file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMAIL_CANNOT_ATTACH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMAIL_CANNOT_ATTACH_FILE_184", 184);

    /**
     * An error occurred while trying to send the e-mail message: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMAIL_CANNOT_SEND_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMAIL_CANNOT_SEND_MESSAGE_185", 185);

    /**
     * This utility can be used to encode and decode information using base64
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_TOOL_DESCRIPTION_186", 186);

    /**
     * Decode base64-encoded information into raw data. When no options are specified, this subcommand reads from standard input and writes to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_DECODE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_DECODE_DESCRIPTION_188", 188);

    /**
     * Encode raw data using base64. When no options are specified, this subcommand reads from standard input and writes to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_ENCODE_DESCRIPTION_189", 189);

    /**
     * The base64-encoded data to be decoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODED_DATA_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_ENCODED_DATA_DESCRIPTION_190", 190);

    /**
     * The path to a file containing the base64-encoded data to be decoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODED_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_ENCODED_FILE_DESCRIPTION_191", 191);

    /**
     * The raw data to be base64 encoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_RAW_DATA_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_RAW_DATA_DESCRIPTION_192", 192);

    /**
     * The path to a file containing the raw data to be base64 encoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_RAW_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_RAW_FILE_DESCRIPTION_193", 193);

    /**
     * The path to a file to which the base64-encoded data should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TO_ENCODED_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_TO_ENCODED_FILE_DESCRIPTION_194", 194);

    /**
     * The path to a file to which the raw base64-decoded data should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TO_RAW_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_BASE64_TO_RAW_FILE_DESCRIPTION_195", 195);

    /**
     * An error occurred while attempting to read the raw data to encode: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_READ_RAW_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_CANNOT_READ_RAW_DATA_196", 196);

    /**
     * An error occurred while attempting to write the encoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_WRITE_ENCODED_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_CANNOT_WRITE_ENCODED_DATA_197", 197);

    /**
     * An error occurred while attempting to read the base64-encoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_READ_ENCODED_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_CANNOT_READ_ENCODED_DATA_198", 198);

    /**
     * An error occurred while attempting to write the decoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_WRITE_RAW_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_CANNOT_WRITE_RAW_DATA_199", 199);

    /**
     * Unknown subcommand %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_UNKNOWN_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BASE64_UNKNOWN_SUBCOMMAND_200", 200);

    /**
     * Skipping entry %s because the DN is excluded by the exclude branch "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_SKIP_EXCLUDE_BRANCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SKIP_EXCLUDE_BRANCH_201", 201);

    /**
     * Skipping entry %s because the DN is excluded by the exclude filter "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_SKIP_EXCLUDE_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SKIP_EXCLUDE_FILTER_202", 202);

    /**
     * Skipping entry %s because the DN is not included by any include branches
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_SKIP_NOT_IN_INCLUDED_BRANCHES =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SKIP_NOT_IN_INCLUDED_BRANCHES_203", 203);

    /**
     * Skipping entry %s because the DN is not included by any include filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_SKIP_NOT_IN_INCLUDED_FILTERS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_SKIP_NOT_IN_INCLUDED_FILTERS_204", 204);

    /**
     * Rejecting entry %s because it was rejected by a plugin
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_REJECTED_BY_PLUGIN_NOMESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_REJECTED_BY_PLUGIN_NOMESSAGE_224", 224);

    /**
     * Rejecting entry %s because it was rejected by a plugin: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_REJECTED_BY_PLUGIN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_REJECTED_BY_PLUGIN_225", 225);

    /**
     * LDAP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_LDAP =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_LDAP_226", 226);

    /**
     * LDAP with SSL
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_SSL =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_SSL_227", 227);

    /**
     * LDAP with StartTLS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_START_TLS_228", 228);

    /**
     * Automatically trust
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_TRUST_ALL =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_TRUST_ALL_229", 229);

    /**
     * Truststore path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PATH =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PATH_230", 230);

    /**
     * Password for truststore '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_PASSWORD_231", 231);

    /**
     * Keystore path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PATH =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PATH_233", 233);

    /**
     * Password for keystore '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_KEYSTORE_PASSWORD_234", 234);

    /**
     * >>>> Specify OpenDJ LDAP connection parameters
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS_236", 236);

    /**
     * The hostname "%s" could not be resolved. Please check you have provided the correct address
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_BAD_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAP_CONN_BAD_HOST_NAME_237", 237);

    /**
     * Invalid port number "%s". Please enter a valid port number between 1 and 65535
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_BAD_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_LDAP_CONN_BAD_PORT_NUMBER_238", 238);

    /**
     * Directory server hostname or IP address [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_HOST_NAME_239", 239);

    /**
     * Directory server port number [%d]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAP_CONN_PROMPT_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_PORT_NUMBER_240", 240);

    /**
     * Administrator user bind DN [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_BIND_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_BIND_DN_241", 241);

    /**
     * How do you want to connect?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_USE_SECURE_CTX =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_USE_SECURE_CTX_242", 242);

    /**
     * %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAP_CONN_PROMPT_SECURITY_PROTOCOL_DEFAULT_CHOICE =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_PROTOCOL_DEFAULT_CHOICE_243", 243);

    /**
     * The provided path is not valid
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_CONN_PROMPT_SECURITY_INVALID_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_LDAP_CONN_PROMPT_SECURITY_INVALID_FILE_PATH_244", 244);

    /**
     * How do you want to trust the server certificate?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_METHOD =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_METHOD_245", 245);

    /**
     * Use a truststore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUSTSTORE_246", 246);

    /**
     * Manually validate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_MANUAL_CHECK =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_MANUAL_CHECK_247", 247);

    /**
     * Server Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE_248", 248);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_249", 249);

    /**
     * Do you trust this server certificate?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_250", 250);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO_251", 251);

    /**
     * Yes, for this session only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION_252", 252);

    /**
     * Yes, also add it to a truststore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS_253", 253);

    /**
     * View certificate details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS_254", 254);

    /**
     * User DN  : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN_255", 255);

    /**
     * Validity : From '%s'%n             To '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY_256", 256);

    /**
     * Issuer   : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER_257", 257);

    /**
     * Which certificate do you want to use?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIASES =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIASES_258", 258);

    /**
     * %s (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIAS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_ALIAS_259", 259);

    /**
     * %s [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROMPT_SINGLE_DEFAULT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "INFO_PROMPT_SINGLE_DEFAULT_261", 261);

    /**
     * Global Administrator User ID [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_PROMPT_ADMINISTRATOR_UID =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_ADMINISTRATOR_UID_262", 262);

    /**
     * Global Administrator User ID, or bind DN if no Global Administrator is defined [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_GLOBAL_ADMINISTRATOR_OR_BINDDN_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "INFO_LDAP_CONN_GLOBAL_ADMINISTRATOR_OR_BINDDN_PROMPT_263", 263);

    /**
     * Confirmation tries limit reached (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CONFIRMATION_TRIES_LIMIT_REACHED =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "ERR_CONFIRMATION_TRIES_LIMIT_REACHED_267", 267);

    /**
     * Unexpected error. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNEXPECTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_UNEXPECTED_268", 268);

    /**
     * Input tries limit reached (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_TRIES_LIMIT_REACHED =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "ERR_TRIES_LIMIT_REACHED_269", 269);

    /**
     * Directory server administration port number [%d]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_ADMIN_CONN_PROMPT_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "INFO_ADMIN_CONN_PROMPT_PORT_NUMBER_270", 270);

    /**
     * Unable to parse LDIF entry %s starting at line %d because it has an invalid binary option for attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDIF_INVALID_ATTR_OPTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_INVALID_ATTR_OPTION_271", 271);

    /**
     * Invalid key store path for PKCS11 keystore, it must be %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_INVALID_PKCS11_PATH =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_INVALID_PKCS11_PATH_272", 272);

    /**
     * Key store path %s exists but is not a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_INVALID_KEYSTORE_PATH =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_INVALID_KEYSTORE_PATH_273", 273);

    /**
     * Parent directory for key store path %s does not exist or is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_INVALID_PARENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_INVALID_PARENT_274", 274);

    /**
     * Invalid key store type, it must be one of the following: %s, %s, %s or %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CERTMGR_INVALID_STORETYPE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_INVALID_STORETYPE_275", 275);

    /**
     * Keystore does not exist, it must exist to retrieve an alias, delete an alias or generate a certificate request
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CERTMGR_KEYSTORE_NONEXISTANT =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_KEYSTORE_NONEXISTANT_276", 276);

    /**
     * Validity value %d is invalid, it must be a positive integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CERTMGR_VALIDITY =
                    new LocalizableMessageDescriptor.Arg1<Number>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_VALIDITY_277", 277);

    /**
     * A certificate with the alias %s already exists in the key store
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_ALIAS_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_ALIAS_ALREADY_EXISTS_278", 278);

    /**
     * The following error occurred when adding a certificate with alias %s to the keystore: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERTMGR_ADD_CERT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_ADD_CERT_279", 279);

    /**
     * The alias %s cannot be added to the keystore for one of the following reasons: it already exists in the keystore, or, it is not an instance of a trusted certificate class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_ALIAS_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_ALIAS_INVALID_280", 280);

    /**
     * The alias %s is an instance of a private key entry, which is not supported being added to the keystore at this time
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_CERT_REPLIES_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_CERT_REPLIES_INVALID_281", 281);

    /**
     * The following error occurred when deleting a certificate with alias %s from the keystore: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERTMGR_DELETE_ALIAS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_DELETE_ALIAS_282", 282);

    /**
     * The following error occurred when generating a self-signed certificate using the alias %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERTMGR_GEN_SELF_SIGNED_CERT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_GEN_SELF_SIGNED_CERT_284", 284);

    /**
     * The certificate file %s is invalid because it does not exists, or exists, but is not a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_INVALID_CERT_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_INVALID_CERT_FILE_285", 285);

    /**
     * The alias %s cannot be deleted from the keystore because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_ALIAS_CAN_NOT_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_ALIAS_CAN_NOT_DELETE_286", 286);

    /**
     * The trusted certificate associated with alias %s could not be added to keystore because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERTMGR_TRUSTED_CERT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_TRUSTED_CERT_292", 292);

    /**
     * The %s is invalid because it is null
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_FILE_NAME_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_FILE_NAME_INVALID_293", 293);

    /**
     * The argument %s is invalid because it is either null, or has zero length
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_VALUE_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_VALUE_INVALID_294", 294);

    /**
     * A security class cannot be found in this JVM because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_CLASS_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_CLASS_NOT_FOUND_295", 295);

    /**
     * The security classes could not be initialized because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_SECURITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_SECURITY_296", 296);

    /**
     * A method needed in the security classes could not be located because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_NO_METHOD =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_NO_METHOD_297", 297);

    /**
     * The CertAndKeyGen security class cannot be found, consider setting -D%s=
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CERTMGR_CERTGEN_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_CERTMGR_CERTGEN_NOT_FOUND_298", 298);

    /**
     * An error occurred while setting file permissions for the LDIF file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_EXPORT_LDIF_SET_PERMISSION_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "WARN_EXPORT_LDIF_SET_PERMISSION_FAILED_300", 300);

    /**
     * Skipping entry %s because the following error was received when reading its attributes: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_READ_ATTR_SKIP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_LDIF_READ_ATTR_SKIP_301", 301);

    /**
     * An error occurred while attempting to obtain the %s MAC provider to create the signed hash for the backup: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_GET_MAC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_GET_MAC_305", 305);

    /**
     * An error occurred while attempting to obtain the %s message digest to create the hash for the backup: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_GET_DIGEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_GET_DIGEST_306", 306);

    /**
     * An error occurred while trying to create the archive file %s in directory %s for the backup %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_BACKUP_CANNOT_CREATE_ARCHIVE_FILE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_CREATE_ARCHIVE_FILE_307", 307);

    /**
     * An error occurred while attempting to obtain the cipher to use to encrypt the backup: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_CANNOT_GET_CIPHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_GET_CIPHER_308", 308);

    /**
     * %s backup %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_ZIP_COMMENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_ZIP_COMMENT_309", 309);

    /**
     * An error occurred while attempting to obtain a list of the files in directory %s to include in the backup: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_LIST_LOG_FILES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_LIST_LOG_FILES_310", 310);

    /**
     * An error occurred while attempting to back up file %s of backup %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUP_CANNOT_WRITE_ARCHIVE_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_WRITE_ARCHIVE_FILE_311", 311);

    /**
     * An error occurred while trying to close the archive file %s in directory %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUP_CANNOT_CLOSE_ZIP_STREAM =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_CLOSE_ZIP_STREAM_312", 312);

    /**
     * The computed hash of backup %s is different to the value computed at time of backup
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_UNSIGNED_HASH_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_UNSIGNED_HASH_ERROR_313", 313);

    /**
     * The computed signed hash of backup %s is different to the value computed at time of backup
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKUP_SIGNED_HASH_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_SIGNED_HASH_ERROR_314", 314);

    /**
     * The directory %s, containing the files restored from backup, could not be renamed to the directory %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_RENAME_RESTORE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_CANNOT_RENAME_RESTORE_DIRECTORY_315", 315);

    /**
     * An error occurred while attempting to update the backup descriptor file %s with information about the backup: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_UPDATE_BACKUP_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_UPDATE_BACKUP_DESCRIPTOR_316", 316);

    /**
     * An error occurred while attempting to restore the files from backup %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_RESTORE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_RESTORE_317", 317);

    /**
     * Backup file has not changed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BACKUP_FILE_UNCHANGED =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "NOTE_BACKUP_FILE_UNCHANGED_318", 318);

    /**
     * Verifying backup file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BACKUP_VERIFY_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "NOTE_BACKUP_VERIFY_FILE_319", 319);

    /**
     * Restored backup file: %s (size %d)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> NOTE_BACKUP_RESTORED_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "NOTE_BACKUP_RESTORED_FILE_320", 320);

    /**
     * Archived backup file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_BACKUP_ARCHIVED_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "NOTE_BACKUP_ARCHIVED_FILE_321", 321);

    /**
     * An error occurred while attempting to obtain the MAC key ID to create the signed hash for the backup %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_GET_MAC_KEY_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_GET_MAC_KEY_ID_323", 323);

    /**
     * An error occurred while attempting to create a directory to restore the file %s for backup of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BACKUP_CANNOT_CREATE_DIRECTORY_TO_RESTORE_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_CREATE_DIRECTORY_TO_RESTORE_FILE_324", 324);

    /**
     * An error occurred while attempting to save files from root directory %s to target directory %s, for backup of %s : %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_BACKUP_CANNOT_SAVE_FILES_BEFORE_RESTORE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_SAVE_FILES_BEFORE_RESTORE_325", 325);

    /**
     * An error occurred while attempting to create a save directory with base path %s before restore of backup of %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_BACKUP_CANNOT_CREATE_SAVE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_BACKUP_CANNOT_CREATE_SAVE_DIRECTORY_326", 326);

    /**
     * An error occurred while attempting to configure replication between embedded server with server root '%s' and source replication port '%s' and destination server with hostname '%s' and destination replication port '%s'. Error code is: %d
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number> ERR_EMBEDDED_SERVER_CONFIGURE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_CONFIGURE_REPLICATION_328", 328);

    /**
     * An error occurred while attempting to import LDIF file '%s' into embedded server with server root '%s'. Error code is: %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_EMBEDDED_SERVER_IMPORT_DATA =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_IMPORT_DATA_329", 329);

    /**
     * An error occurred while attempting to initialize replication between embedded server with server root '%s' and admin source port '%s' and destination server with hostname '%s' and destination admin port '%s'. Error code is: %d
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number> ERR_EMBEDDED_SERVER_INITIALIZE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_INITIALIZE_REPLICATION_330", 330);

    /**
     * An error occurred while attempting to setup the embedded server with server root '%s', base DN '%s' and backend type '%s'. Error code is: %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number> ERR_EMBEDDED_SERVER_SETUP =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_SETUP_332", 332);

    /**
     * An error occurred while attempting to extract server archive '%s' before setup of embedded server with server root '%s': %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_EMBEDDED_SERVER_SETUP_EXTRACT_ARCHIVE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_SETUP_EXTRACT_ARCHIVE_333", 333);

    /**
     * An error occurred while attempting to rebuild index of embedded server with server root '%s'. Error code is: %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_EMBEDDED_SERVER_REBUILD_INDEX =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_REBUILD_INDEX_334", 334);

    /**
     * An error occurred while attempting to start the embedded server with server root '%s' : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMBEDDED_SERVER_START =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_START_336", 336);

    /**
     * An error occurred while attempting to upgrade the embedded server with server root '%s' : %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMBEDDED_SERVER_UPGRADE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_UPGRADE_337", 337);

    /**
     * An error occurred while attempting to retrieve an internal connection to the server with the user DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMBEDDED_SERVER_INTERNAL_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_INTERNAL_CONNECTION_338", 338);

    /**
     * The setup from an archive can only be done with a server root directory named after the root directory contained in the archive: '%s'. The provided server root was: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_EMBEDDED_SERVER_ARCHIVE_SETUP_WRONG_ROOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_ARCHIVE_SETUP_WRONG_ROOT_DIRECTORY_339", 339);

    /**
     * The import data operation could not be performed on the embedded server because it is not running
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EMBEDDED_SERVER_IMPORT_DATA_SERVER_IS_NOT_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_IMPORT_DATA_SERVER_IS_NOT_RUNNING_340", 340);

    /**
     * The rebuild index operation could not be performed on the embedded server because it is running
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EMBEDDED_SERVER_REBUILD_INDEX_SERVER_IS_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_REBUILD_INDEX_SERVER_IS_RUNNING_341", 341);

    /**
     * An error occurred while attempting to read the configuration file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMBEDDED_SERVER_LDIF_MANAGEMENT_CONTEXT =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_LDIF_MANAGEMENT_CONTEXT_342", 342);

    /**
     * An error occurred while attempting to retrieve the build version of the directory server: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMBEDDED_SERVER_BUILD_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(UtilityMessages.class, RESOURCE, "ERR_EMBEDDED_SERVER_BUILD_VERSION_343", 343);

}
