package com.forgerock.opendj.ldap;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.ldap.core}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/ldap/core.properties} and it should not be manually edited.
 */
public final class CoreMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.ldap.core";

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
     * The delete request spans multiple partitions
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_DELETE_SPANS_MULTIPLE_PARTITIONS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_DELETE_SPANS_MULTIPLE_PARTITIONS", -1);

    /**
     * The modify DN request spans multiple partitions
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_MODDN_SPANS_MULTIPLE_PARTITIONS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_MODDN_SPANS_MULTIPLE_PARTITIONS", -1);

    /**
     * The Persistent Search request control is not supported across multiple partitions, except if it requests changes only
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_PSEARCH_CONTROL_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_PSEARCH_CONTROL_NOT_SUPPORTED", -1);

    /**
     * The Simple Paged Results request control is not supported across multiple partitions
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_SPR_CONTROL_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_SPR_CONTROL_NOT_SUPPORTED", -1);

    /**
     * The Server Side Sort request control is not supported across multiple partitions
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_SSS_CONTROL_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_SSS_CONTROL_NOT_SUPPORTED", -1);

    /**
     * Unable to determine the partition ID from bind request
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_UNRESOLVABLE_PARTITION_ID_FOR_BIND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_UNRESOLVABLE_PARTITION_ID_FOR_BIND", -1);

    /**
     * Unable to determine the partition ID from extended request
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_UNRESOLVABLE_PARTITION_ID_FOR_EXT_OP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_UNRESOLVABLE_PARTITION_ID_FOR_EXT_OP", -1);

    /**
     * The search scope %d is not supported by the distribution layer
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> DISTRIBUTION_UNSUPPORTED_SEARCH_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "DISTRIBUTION_UNSUPPORTED_SEARCH_SCOPE", -1);

    /**
     * The VLV request control is not supported across multiple partitions
     */
    public static final LocalizableMessageDescriptor.Arg0 DISTRIBUTION_VLV_CONTROL_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DISTRIBUTION_VLV_CONTROL_NOT_SUPPORTED", -1);

    /**
     * Serbo-Croatian
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_LANGUAGE_SH =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_LANGUAGE_SH", -1);

    /**
     * Collation order object identifier: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> DOC_LOCALE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "DOC_LOCALE_OID", -1);

    /**
     * OpenDJ software supports the following locales with their associated language and country codes and their collation order object identifiers. Locale support depends on the Java Virtual Machine used at run time. The following list reflects all supported locales.
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_LOCALE_SECTION_INFO =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_LOCALE_SECTION_INFO", -1);

    /**
     * Directory Support For Locales and Language Subtypes
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_LOCALE_SECTION_TITLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_LOCALE_SECTION_TITLE", -1);

    /**
     * Code tag: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> DOC_LOCALE_TAG =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "DOC_LOCALE_TAG", -1);

    /**
     * Locales
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_SUPPORTED_LOCALES_INDEXTERM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_SUPPORTED_LOCALES_INDEXTERM", -1);

    /**
     * Supported Locales
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_SUPPORTED_LOCALES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_SUPPORTED_LOCALES_TITLE", -1);

    /**
     * Language subtypes
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_SUPPORTED_SUBTYPES_INDEXTERM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_SUPPORTED_SUBTYPES_INDEXTERM", -1);

    /**
     * Supported Language Subtypes
     */
    public static final LocalizableMessageDescriptor.Arg0 DOC_SUPPORTED_SUBTYPES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "DOC_SUPPORTED_SUBTYPES_TITLE", -1);

    /**
     * Cannot decode the provided control as an account availability request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ACCTUSABLEREQ_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLEREQ_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as an account availability request control because the provided control had a value but the account availability request control should not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ACCTUSABLEREQ_CONTROL_HAS_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLEREQ_CONTROL_HAS_VALUE", -1);

    /**
     * Cannot decode the provided control as an account availability response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ACCTUSABLERES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLERES_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided account availability response control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ACCTUSABLERES_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLERES_DECODE_ERROR", -1);

    /**
     * Cannot decode the provided account availability response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ACCTUSABLERES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLERES_NO_CONTROL_VALUE", -1);

    /**
     * The account availability response control had an unknown ACCOUNT_USABLE_RESPONSE element type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ACCTUSABLERES_UNKNOWN_VALUE_ELEMENT_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ACCTUSABLERES_UNKNOWN_VALUE_ELEMENT_TYPE", -1);

    /**
     * Cannot decode the provided address mask because the it has an invalid format
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRESSMASK_FORMAT_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ADDRESSMASK_FORMAT_DECODE_ERROR", -1);

    /**
     * Cannot decode the provided address mask prefix because an invalid value was specified. The permitted values for IPv4are 0 to32 and for IPv6 0 to128
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRESSMASK_PREFIX_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ADDRESSMASK_PREFIX_DECODE_ERROR", -1);

    /**
     * Cannot decode the provided address mask because an prefix mask was specified with an wild card "*" match character
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRESSMASK_WILDCARD_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ADDRESSMASK_WILDCARD_DECODE_ERROR", -1);

    /**
     * Cannot decode the ASN.1 boolean element because the decoded value length was not exactly one byte (decoded length was %d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_BOOLEAN_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_BOOLEAN_INVALID_LENGTH", -1);

    /**
     * Cannot decode the ASN.1 boolean element of because an unexpected end of file was reached while reading value bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_BOOLEAN_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_BOOLEAN_TRUNCATED_VALUE", -1);

    /**
     * Cannot decode the provided ASN.1 integer element because the length of the element value was not between one and four bytes (actual length was %d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_INTEGER_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_INTEGER_INVALID_LENGTH", -1);

    /**
     * Cannot decode the ASN.1 integer element of because an unexpected end of file was reached while reading value bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_INTEGER_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_INTEGER_TRUNCATED_VALUE", -1);

    /**
     * Cannot decode the ASN.1 element because it contained a multi-byte length with an invalid number of bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_INVALID_NUM_LENGTH_BYTES =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_INVALID_NUM_LENGTH_BYTES", -1);

    /**
     * Cannot decode the ASN.1 null element because the decoded value length was not exactly zero bytes (decoded length was %d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_NULL_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_NULL_INVALID_LENGTH", -1);

    /**
     * Cannot decode the ASN.1 octet string element of because an unexpected end of file was reached while reading value bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_OCTET_STRING_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_OCTET_STRING_TRUNCATED_VALUE", -1);

    /**
     * Cannot decode the end of the ASN.1 sequence or set because the start of the sequence was not read
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ASN1_SEQUENCE_READ_NOT_STARTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ASN1_SEQUENCE_READ_NOT_STARTED", -1);

    /**
     * Cannot decode the ASN.1 sequence or set element of because an unexpected end of file was reached while reading value bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_SEQUENCE_SET_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_SEQUENCE_SET_TRUNCATED_VALUE", -1);

    /**
     * Cannot encode the end of the ASN.1 sequence or set because the start of the sequence was not written
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ASN1_SEQUENCE_WRITE_NOT_STARTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ASN1_SEQUENCE_WRITE_NOT_STARTED", -1);

    /**
     * Cannot skip the ASN.1 element of because an unexpected end of file was reached while reading value bytes (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_SKIP_TRUNCATED_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_SKIP_TRUNCATED_VALUE", -1);

    /**
     * Cannot decode the ASN.1 element because an unexpected end of file was reached while reading the type byte
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ASN1_TRUCATED_TYPE_BYTE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ASN1_TRUCATED_TYPE_BYTE", -1);

    /**
     * Cannot decode the ASN.1 element because an unexpected end of file was reached while reading the first length byte
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ASN1_TRUNCATED_LENGTH_BYTE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ASN1_TRUNCATED_LENGTH_BYTE", -1);

    /**
     * Cannot decode the ASN.1 element because an unexpected end of file was reached while reading a multi-byte length of %d bytes
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ASN1_TRUNCATED_LENGTH_BYTES =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_TRUNCATED_LENGTH_BYTES", -1);

    /**
     * Encountered unexpected tag while reading ASN.1 element (expected=0x%02x, got=0x%02x)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_ASN1_UNEXPECTED_TAG =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(CoreMessages.class, RESOURCE, "ERR_ASN1_UNEXPECTED_TAG", -1);

    /**
     * The attribute description "%s" could not be parsed because it was empty
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_DESCRIPTION_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_DESCRIPTION_EMPTY", -1);

    /**
     * The attribute description "%s" could not be parsed because it contains a zero length option
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_DESCRIPTION_EMPTY_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_DESCRIPTION_EMPTY_OPTION", -1);

    /**
     * The attribute description "%s" could not be parsed because it contains an invalid character "%c" at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTRIBUTE_DESCRIPTION_ILLEGAL_CHARACTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_DESCRIPTION_ILLEGAL_CHARACTER", -1);

    /**
     * The attribute description "%s" could not be parsed because it contains internal white space
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_DESCRIPTION_INTERNAL_WHITESPACE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_DESCRIPTION_INTERNAL_WHITESPACE", -1);

    /**
     * The attribute description "%s" could not be parsed because it does not contain an attribute type name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_DESCRIPTION_NO_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_DESCRIPTION_NO_TYPE", -1);

    /**
     * The entry could not be parsed because the '%s' is missing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTRIBUTE_PARSER_MISSING_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTRIBUTE_PARSER_MISSING_ATTRIBUTE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute syntax description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ATTRSYNTAX_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRSYNTAX_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as an attribute syntax description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_ATTRSYNTAX_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRSYNTAX_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid attribute syntax description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_ATTRSYNTAX_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRSYNTAX_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute syntax description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_ATTRSYNTAX_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRSYNTAX_INVALID1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute type description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ATTRTYPE_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRTYPE_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as an attribute type description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_ATTRTYPE_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRTYPE_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid attribute type description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_ATTRTYPE_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRTYPE_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute type description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_ATTRTYPE_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ATTRTYPE_INVALID1", -1);

    /**
     * The provided authPassword value had an invalid authInfo character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_INFO_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_INFO_CHAR", -1);

    /**
     * The provided authPassword value had an invalid authValue character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_VALUE_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_AUTH_VALUE_CHAR", -1);

    /**
     * The provided authPassword value had an invalid scheme character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_SCHEME_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_SCHEME_CHAR", -1);

    /**
     * The provided authPassword value had an invalid trailing character at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_AUTHPW_INVALID_TRAILING_CHAR =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_INVALID_TRAILING_CHAR", -1);

    /**
     * The provided authPassword value had a zero-length authInfo element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO", -1);

    /**
     * The provided authPassword value was missing the separator character or had an illegal character between the authInfo and authValue elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_INFO_SEPARATOR", -1);

    /**
     * The provided authPassword value had a zero-length authValue element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_AUTH_VALUE", -1);

    /**
     * The provided authPassword value had a zero-length scheme element
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME", -1);

    /**
     * The provided authPassword value was missing the separator character or had an illegal character between the scheme and authInfo elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_AUTHPW_NO_SCHEME_SEPARATOR", -1);

    /**
     * The provided value "%s" is not a valid country string because the length is not exactly two characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_COUNTRY_STRING_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_COUNTRY_STRING_INVALID_LENGTH", -1);

    /**
     * The provided value "%s" is not a valid ISO 3166 country code
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_COUNTRY_STRING_NO_VALID_ISO_CODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_COUNTRY_STRING_NO_VALID_ISO_CODE", -1);

    /**
     * The definition for the syntax with OID %s declared a cyclic substitution.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_CYCLIC_SUB_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_CYCLIC_SUB_SYNTAX", -1);

    /**
     * The DIT content rule "%s" is associated with an auxiliary object class "%s".  This object class exists in the schema but is defined as %s rather than auxiliary
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_AUXILIARY_CLASS_NOT_AUXILIARY1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_AUXILIARY_CLASS_NOT_AUXILIARY1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid DIT content rule description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DCR_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as a DIT content rule description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DCR_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid DIT content rule description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid DIT content rule description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_INVALID1", -1);

    /**
     * The DIT content rule "%s" is not valid because it prohibits the use of attribute type %s which is required by the associated auxiliary object class %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_AUXILIARY", -1);

    /**
     * The DIT content rule "%s" is not valid because it prohibits the use of attribute type %s which is required by the associated structural object class %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_PROHIBITED_REQUIRED_BY_STRUCTURAL", -1);

    /**
     * The DIT content rule "%s" is associated with the "%s" object class.  This object class exists in the schema but is defined as %s rather than structural
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_DCR_STRUCTURAL_CLASS_NOT_STRUCTURAL1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_STRUCTURAL_CLASS_NOT_STRUCTURAL1", -1);

    /**
     * The DIT content rule "%s" is associated with an auxiliary object class "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_AUXILIARY_CLASS1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_AUXILIARY_CLASS1", -1);

    /**
     * The DIT content rule "%s" is associated with an optional attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_OPTIONAL_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_OPTIONAL_ATTR1", -1);

    /**
     * The DIT content rule "%s" is associated with a prohibited attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_PROHIBITED_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_PROHIBITED_ATTR1", -1);

    /**
     * The DIT content rule "%s" is associated with a required attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_REQUIRED_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_REQUIRED_ATTR1", -1);

    /**
     * The DIT content rule "%s" is associated with a structural object class %s which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DCR_UNKNOWN_STRUCTURAL_CLASS1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DCR_UNKNOWN_STRUCTURAL_CLASS1", -1);

    /**
     * The provided value "%s" is not a valid delivery method value because "%s" is not a valid method
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DELIVERY_METHOD_INVALID_ELEMENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DELIVERY_METHOD_INVALID_ELEMENT", -1);

    /**
     * The provided value "%s" is not a valid delivery method value because it does not contain any elements
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DELIVERY_METHOD_NO_ELEMENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DELIVERY_METHOD_NO_ELEMENTS", -1);

    /**
     * The operation attempted to assign a zero-length value to an attribute with the directory string syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_DIRECTORYSTRING_INVALID_ZEROLENGTH_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DIRECTORYSTRING_INVALID_ZEROLENGTH_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because character '%c' at position %d is not allowed in an attribute name
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_ILLEGAL_CHAR", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because it contained an RDN containing an empty attribute name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_ATTR_NO_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_NO_NAME", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an unexpected failure occurred while attempting to parse an attribute value from one of the RDN components:  "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_ATTR_VALUE_DECODE_FAILURE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ATTR_VALUE_DECODE_FAILURE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the last non-space character was part of the attribute name '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DN_END_WITH_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_END_WITH_ATTR_NAME", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because one of the RDN components included a value with an escaped hexadecimal digit that was not followed by a second hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_ESCAPED_HEX_VALUE_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_ESCAPED_HEX_VALUE_INVALID", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with an octothorpe (#) but was not followed by a positive multiple of two hexadecimal digits
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_HEX_VALUE_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_HEX_VALUE_TOO_SHORT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with an octothorpe (#) but contained a character %c that was not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_ATTR_SYNTAX_DN_INVALID_HEX_DIGIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_INVALID_HEX_DIGIT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an attribute value started with a character at position %d that needs to be escaped
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DN_INVALID_REQUIRES_ESCAPE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_INVALID_REQUIRES_ESCAPE_CHAR", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because the next non-space character after attribute name "%s" should have been an equal sign but instead was '%c'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Character> ERR_ATTR_SYNTAX_DN_NO_EQUAL =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Character>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_NO_EQUAL", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because one of the RDN components included a quoted value that did not have a corresponding closing quotation mark
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DN_UNMATCHED_QUOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DN_UNMATCHED_QUOTE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid DIT structure rule description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DSR_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_DSR_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid DIT structure rule description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DSR_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid DIT structure rule description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DSR_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_INVALID1", -1);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it did not specify the name form for the rule
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_DSR_NO_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_NO_NAME_FORM", -1);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it referenced an unknown name form %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_DSR_UNKNOWN_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_UNKNOWN_NAME_FORM", -1);

    /**
     * The provided value "%s" could not be parsed as a DIT structure rule description because it referenced an unknown rule ID %d for a superior DIT structure rule
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_DSR_UNKNOWN_RULE_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_DSR_UNKNOWN_RULE_ID", -1);

    /**
     * The provided value could not be parsed because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_EMPTY_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because the specified scope %s was invalid
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_INVALID_SCOPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_INVALID_SCOPE", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because it did not specify any criteria between the octothorpe (#) characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_CRITERIA =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_CRITERIA", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because it did not have an octothorpe (#) character to separate the criteria from the scope
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_FINAL_SHARP =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_FINAL_SHARP", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because it did not contain an object class name or OID before the octothorpe (#) character
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_OC1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_OC1", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because no scope was provided after the final octothorpe (#) character
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_SCOPE", -1);

    /**
     * The provided value "%s" could not be parsed as an enhanced guide value because it did not contain an octothorpe (#) character to separate the object class from the criteria
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_SHARP1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ENHANCEDGUIDE_NO_SHARP1", -1);

    /**
     * The provided value "%s" could not be parsed because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * the value should have contained a single quote at position %d but the character '%s' was found instead
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_ATTR_SYNTAX_EXPECTED_QUOTE_AT_POS1 =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_EXPECTED_QUOTE_AT_POS1", -1);

    /**
     * The provided value could not be parsed as a valid facsimile telephone number because it was empty
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_FAXNUMBER_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_FAXNUMBER_EMPTY", -1);

    /**
     * The provided value "%s" could not be parsed as a valid facsimile telephone number because it ends with a dollar sign, but that dollar sign should have been followed by a fax parameter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_FAXNUMBER_END_WITH_DOLLAR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_FAXNUMBER_END_WITH_DOLLAR", -1);

    /**
     * The provided value "%s" could not be parsed as a valid facsimile telephone number because the string "%s" between positions %d and %d was not a valid fax parameter
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> ERR_ATTR_SYNTAX_FAXNUMBER_ILLEGAL_PARAMETER =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_FAXNUMBER_ILLEGAL_PARAMETER", -1);

    /**
     * The provided value "%s" could not be parsed as a valid facsimile telephone number because character %s at position %d was not a valid printable string character
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_FAXNUMBER_NOT_PRINTABLE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_FAXNUMBER_NOT_PRINTABLE", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Character, Number> ERR_ATTR_SYNTAX_GUIDE_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Character, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_ILLEGAL_CHAR", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s had an invalid match type starting at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_GUIDE_INVALID_MATCH_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_INVALID_MATCH_TYPE", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s started with a question mark but was not followed by the string "true" or "false"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_INVALID_QUESTION_MARK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_INVALID_QUESTION_MARK", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not contain a close parenthesis that corresponded to the initial open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_MISSING_CLOSE_PAREN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_MISSING_CLOSE_PAREN", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not specify an attribute type before the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_ATTR", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not contain a dollar sign to separate the attribute type from the match type
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_DOLLAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_DOLLAR", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because the criteria portion %s did not specify a match type after the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_GUIDE_NO_MATCH_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_MATCH_TYPE", -1);

    /**
     * The provided value "%s" could not be parsed as a guide value because it did not contain an object class name or OID before the octothorpe (#) character
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_GUIDE_NO_OC1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_GUIDE_NO_OC1", -1);

    /**
     * the value contains a non-numeric OID which could not be parsed because it contains an illegal character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_ILLEGAL_CHAR_IN_STRING_OID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_ILLEGAL_CHAR_IN_STRING_OID1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid matching rule use description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MRUSE_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as a matching rule use description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_MRUSE_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid matching rule use description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid matching rule use description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_INVALID1", -1);

    /**
     * The provided value "%s" could not be parsed as a matching rule description because it does not specify the set of attribute types that may be used with the associated OID
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MRUSE_NO_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_NO_ATTR", -1);

    /**
     * The matching rule use "%s" specifies the attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_ATTR1", -1);

    /**
     * The matching rule use "%s" specifies the matching rule "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_MATCHING_RULE1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MRUSE_UNKNOWN_MATCHING_RULE1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid matching rule description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MR_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as a matching rule description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_MR_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid matching rule description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MR_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid matching rule description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MR_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_INVALID1", -1);

    /**
     * The provided value "%s" could not be parsed as a matching rule description because it does not specify the attribute syntax with which it is associated
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_MR_NO_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_NO_SYNTAX", -1);

    /**
     * The matching rule "%s" is associated with attribute syntax "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_MR_UNKNOWN_SYNTAX1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_MR_UNKNOWN_SYNTAX1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid name and optional UID value because the UID portion contained an illegal binary digit %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_NAMEANDUID_ILLEGAL_BINARY_DIGIT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAMEANDUID_ILLEGAL_BINARY_DIGIT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid name and optional UID value because an error occurred while trying to parse the DN portion:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAMEANDUID_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAMEANDUID_INVALID_DN", -1);

    /**
     * The provided value "%s" could not be parsed as a valid name form description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_NAME_FORM_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as a name form description because an open parenthesis was expected at position %d but instead a '%c' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Character> ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Character>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_EXPECTED_OPEN_PARENTHESIS", -1);

    /**
     * The provided value "%s"could not be parsed as a valid name form description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid name form description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_INVALID1", -1);

    /**
     * The provided value "%s" could not be parsed as a name form description because it does not specify a required naming attribute
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_NAME_FORM_NO_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_NO_REQUIRED_ATTR", -1);

    /**
     * The provided value "%s" could not be parsed as a name form description because it does not specify the structural object class with which it is associated
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_NAME_FORM_NO_STRUCTURAL_CLASS1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_NO_STRUCTURAL_CLASS1", -1);

    /**
     * The name form description "%s" is associated with the "%s" object class. This object class exists in the schema but is defined as %s rather than structural
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_STRUCTURAL_CLASS_NOT_STRUCTURAL1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_STRUCTURAL_CLASS_NOT_STRUCTURAL1", -1);

    /**
     * The name form "%s" specifies the optional attribute "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_OPTIONAL_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_OPTIONAL_ATTR1", -1);

    /**
     * The name form "%s" specifies the required attribute "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_REQUIRED_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_REQUIRED_ATTR1", -1);

    /**
     * The name form description "%s" is associated with a structural object class "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_STRUCTURAL_CLASS1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NAME_FORM_UNKNOWN_STRUCTURAL_CLASS1", -1);

    /**
     * The provided value is not a valid numeric string because it did not contain any characters.  A numeric string value must contain at least one numeric digit or space
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_NUMERIC_STRING_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_NUMERIC_STRING_EMPTY_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid object class description because it was empty or contained only whitespace
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_OBJECTCLASS_EMPTY_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_EMPTY_VALUE1", -1);

    /**
     * The provided value "%s" could not be parsed as an object class description because an open parenthesis was expected at position %d but instead a '%s' character was found
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_OPEN_PARENTHESIS1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_EXPECTED_OPEN_PARENTHESIS1", -1);

    /**
     * The provided value "%s"could not be parsed as a valid object class description because it contains an illegal token "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_TOKEN1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_ILLEGAL_TOKEN1", -1);

    /**
     * The provided value "%s" could not be parsed as a valid object class description for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_OBJECTCLASS_INVALID1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OBJECTCLASS_INVALID1", -1);

    /**
     * the value contains a numeric OID which could not be parsed because it contains two consecutive periods at or near position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_OID_CONSECUTIVE_PERIODS1 =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OID_CONSECUTIVE_PERIODS1", -1);

    /**
     * the value contains a numeric OID which could not be parsed because it ends with a period at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_OID_ENDS_WITH_PERIOD1 =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OID_ENDS_WITH_PERIOD1", -1);

    /**
     * the value contains a numeric OID which could not be parsed because it contains an illegal character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ATTR_SYNTAX_OID_ILLEGAL_CHARACTER1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OID_ILLEGAL_CHARACTER1", -1);

    /**
     * the value did not contain an OID at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_OID_NO_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OID_NO_VALUE1", -1);

    /**
     * The provided value could not be parsed as an other mailbox value because it was empty
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_OTHER_MAILBOX_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OTHER_MAILBOX_EMPTY_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as an other mailbox value because the mailbox type contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_OTHER_MAILBOX_ILLEGAL_MBTYPE_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OTHER_MAILBOX_ILLEGAL_MBTYPE_CHAR", -1);

    /**
     * The provided value "%s" could not be parsed as an other mailbox value because the mailbox contained an illegal character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_OTHER_MAILBOX_ILLEGAL_MB_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OTHER_MAILBOX_ILLEGAL_MB_CHAR", -1);

    /**
     * The provided value "%s" could not be parsed as an other mailbox value because there was no mailbox after the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_OTHER_MAILBOX_NO_MAILBOX =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OTHER_MAILBOX_NO_MAILBOX", -1);

    /**
     * The provided value "%s" could not be parsed as an other mailbox value because there was no mailbox type before the dollar sign
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_OTHER_MAILBOX_NO_MBTYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_OTHER_MAILBOX_NO_MBTYPE", -1);

    /**
     * the value contained an invalid rule ID "%s" which could not be parsed as a number
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_RULE_ID_INVALID1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_RULE_ID_INVALID1", -1);

    /**
     * the value did not contain a rule ID at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_RULE_ID_NO_VALUE1 =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_RULE_ID_NO_VALUE1", -1);

    /**
     * The provided value is not a valid telephone number because it is empty or null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_TELEPHONE_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEPHONE_EMPTY", -1);

    /**
     * The provided value "%s" is not a valid telephone number because strict telephone number checking is enabled and the character %s at position %d is not allowed by the ITU-T E.123 specification
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_TELEPHONE_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEPHONE_ILLEGAL_CHAR", -1);

    /**
     * The provided value "%s" is not a valid telephone number because it does not contain any numeric digits
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELEPHONE_NO_DIGITS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEPHONE_NO_DIGITS", -1);

    /**
     * The provided value "%s" is not a valid telephone number because strict telephone number checking is enabled and the value does not start with a plus sign in compliance with the ITU-T E.123 specification
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELEPHONE_NO_PLUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEPHONE_NO_PLUS", -1);

    /**
     * The provided value could not be parsed as a valid teletex terminal identifier because it was empty
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_TELETEXID_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELETEXID_EMPTY", -1);

    /**
     * The provided value "%s" could not be parsed as a valid teletex terminal identifier because it ends with a dollar sign, but that dollar sign should have been followed by a TTX parameter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELETEXID_END_WITH_DOLLAR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELETEXID_END_WITH_DOLLAR", -1);

    /**
     * The provided value "%s" could not be parsed as a valid teletex terminal identifier because the string "%s" is not a valid TTX parameter name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_TELETEXID_ILLEGAL_PARAMETER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELETEXID_ILLEGAL_PARAMETER", -1);

    /**
     * The provided value "%s" could not be parsed as a valid teletex terminal identifier because character %s at position %d was not a valid printable string character
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_TELETEXID_NOT_PRINTABLE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELETEXID_NOT_PRINTABLE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid teletex terminal identifier because the parameter string does not contain a colon to separate the name from the value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELETEXID_PARAM_NO_COLON =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELETEXID_PARAM_NO_COLON", -1);

    /**
     * The provided value "%s" does not hold a valid telex number because character %s at position %d was neither a valid printable string character nor a dollar sign to separate the telex number components
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_TELEX_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEX_ILLEGAL_CHAR", -1);

    /**
     * The provided value "%s" does not hold a valid telex number because a character %s at position %d was not a valid printable string character
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_TELEX_NOT_PRINTABLE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEX_NOT_PRINTABLE", -1);

    /**
     * The provided value "%s" is too short to be a valid telex number value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELEX_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEX_TOO_SHORT", -1);

    /**
     * The provided value "%s" does not hold a valid telex number because the end of the value was found before three dollar-delimited printable strings could be read
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_TELEX_TRUNCATED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TELEX_TRUNCATED", -1);

    /**
     * the value appears to be truncated
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_TRUNCATED_VALUE1 =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_TRUNCATED_VALUE1", -1);

    /**
     * the value contained an unexpected closing parenthesis at position %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ATTR_SYNTAX_UNEXPECTED_CLOSE_PARENTHESIS1 =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNEXPECTED_CLOSE_PARENTHESIS1", -1);

    /**
     * Unable to retrieve approximate matching rule %s used as the default for the %s attribute syntax. Approximate matching will not be allowed by default for attributes with this syntax
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UNKNOWN_APPROXIMATE_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNKNOWN_APPROXIMATE_MATCHING_RULE", -1);

    /**
     * Unable to retrieve equality matching rule %s used as the default for the %s attribute syntax. Equality matching will not be allowed by default for attributes with this syntax
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UNKNOWN_EQUALITY_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNKNOWN_EQUALITY_MATCHING_RULE", -1);

    /**
     * Unable to retrieve ordering matching rule %s used as the default for the %s attribute syntax. Ordering matches will not be allowed by default for attributes with this syntax
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UNKNOWN_ORDERING_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNKNOWN_ORDERING_MATCHING_RULE", -1);

    /**
     * Unable to retrieve substring matching rule %s used as the default for the %s attribute syntax. Substring matching will not be allowed by default for attributes with this syntax
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UNKNOWN_SUBSTRING_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNKNOWN_SUBSTRING_MATCHING_RULE", -1);

    /**
     * The definition for the syntax with OID %s declared that it should have a substitution syntax with OID %s. No such syntax is defined
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UNKNOWN_SUB_SYNTAX =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UNKNOWN_SUB_SYNTAX", -1);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not contain a closing curly brace ("}") character
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_CLOSING_BRACE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_CLOSING_BRACE", -1);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not start with the opening curly brace ("{") character
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_OPENING_BRACE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_OPENING_BRACE", -1);

    /**
     * Unable to decode the provided value according to the user password syntax because the value does not contain a storage scheme name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_SCHEME", -1);

    /**
     * No value was given to decode by the user password attribute syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ATTR_SYNTAX_USERPW_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_USERPW_NO_VALUE", -1);

    /**
     * The provided value %s could not be parsed as a valid UTC time:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_CANNOT_PARSE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_CANNOT_PARSE", -1);

    /**
     * The provided value %s is not a valid UTC time value because it contains an invalid character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_CHAR", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid day specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_DAY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_DAY", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid hour specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_HOUR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_HOUR", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid minute specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_MINUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_MINUTE", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid month specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_MONTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_MONTH", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid GMT offset
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_OFFSET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_OFFSET", -1);

    /**
     * The provided value %s is not a valid UTC time value because %s is not a valid second specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_SECOND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_SECOND", -1);

    /**
     * The provided value %s is not a valid UTC time value because the %s character is not allowed in the century or year specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_SYNTAX_UTC_TIME_INVALID_YEAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_INVALID_YEAR", -1);

    /**
     * The provided value %s is too short to be a valid UTC time value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ATTR_SYNTAX_UTC_TIME_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_SYNTAX_UTC_TIME_TOO_SHORT", -1);

    /**
     * Validation of attribute type definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ATTR_TYPE_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ATTR_TYPE_VALIDATION_FAIL", -1);

    /**
     * Cannot decode the provided control as an authorization identity request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_AUTHZIDREQ_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_AUTHZIDREQ_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as an authorization identity request control because the provided control had a value but the authorization identity request control should not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHZIDREQ_CONTROL_HAS_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_AUTHZIDREQ_CONTROL_HAS_VALUE", -1);

    /**
     * Cannot decode the provided control as an authorization identity response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_AUTHZIDRESP_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_AUTHZIDRESP_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided authorization identity response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHZIDRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_AUTHZIDRESP_NO_CONTROL_VALUE", -1);

    /**
     * The value %s cannot be base64-decoded because it contains an illegal character %c that is not allowed in base64-encoded values
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_BASE64_DECODE_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "ERR_BASE64_DECODE_INVALID_CHARACTER", -1);

    /**
     * The value %s cannot be base64-decoded because it does not have a length that is a multiple of four bytes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_DECODE_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_BASE64_DECODE_INVALID_LENGTH", -1);

    /**
     * None of the remaining names in the critical subject alt name extension for '%s' can be matched against '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERT_NO_MATCH_ALLOTHERS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CERT_NO_MATCH_ALLOTHERS", -1);

    /**
     * The DNS names in the critical subject alt name extension for '%s' do not match the host name '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERT_NO_MATCH_DNS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CERT_NO_MATCH_DNS", -1);

    /**
     * The IP addresses in the critical subject alt name extension for '%s' do not match the address '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERT_NO_MATCH_IP =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CERT_NO_MATCH_IP", -1);

    /**
     * The host name contained in the subject DN '%s' does not match the host name '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CERT_NO_MATCH_SUBJECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CERT_NO_MATCH_SUBJECT", -1);

    /**
     * Cannot decode the provided control as a connection affinity control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONNECTION_AFFINITY_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_CONNECTION_AFFINITY_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided ASN.1 element as a connection affinity control because it did not have a value, when a value must always be provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONNECTION_AFFINITY_CONTROL_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_CONNECTION_AFFINITY_CONTROL_DECODE_NULL", -1);

    /**
     * No connection could be obtained from connection pool "%s" because it is closing
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONNECTION_POOL_CLOSING =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CONNECTION_POOL_CLOSING", -1);

    /**
     * An error occurred during establishment of a connection: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONNECTION_UNEXPECTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_CONNECTION_UNEXPECTED", -1);

    /**
     * Validation of DIT content rule definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DCR_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DCR_VALIDATION_FAIL", -1);

    /**
     * The DN "%s" could not be parsed due to the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DN_TYPE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DN_TYPE_NOT_FOUND", -1);

    /**
     * Validation of DIT structure rule definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSR_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_DSR_VALIDATION_FAIL", -1);

    /**
     * Cannot decode the provided control as a entry change notification control because it an invalid changeTypes field '%d', when a value of 1, 2, 4, or 8 was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ECN_BAD_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ECN_BAD_CHANGE_TYPE", -1);

    /**
     * Cannot decode the provided entry change notification control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECN_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ECN_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided control as an entry change notification response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ECN_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ECN_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided entry change notification control because it contains a previous DN element but had a change type of %s.  The previous DN element can only be provided with the modify DN change type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECN_ILLEGAL_PREVIOUS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ECN_ILLEGAL_PREVIOUS_DN", -1);

    /**
     * Cannot decode the provided entry change notification control because it contains an invalid previous DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECN_INVALID_PREVIOUS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ECN_INVALID_PREVIOUS_DN", -1);

    /**
     * Cannot decode the provided entry change notification control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ECN_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_ECN_NO_CONTROL_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed by the integer first component matching rule because the first component does not appear to be an integer value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EMR_INTFIRSTCOMP_FIRST_COMPONENT_NOT_INT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_EMR_INTFIRSTCOMP_FIRST_COMPONENT_NOT_INT", -1);

    /**
     * Unable to add one or more values to attribute '%s' because at least one of the values already exists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_DUPLICATE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_DUPLICATE_VALUES", -1);

    /**
     * Unable to decode branch DN "%s" on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_CANNOT_DECODE_BRANCH_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CANNOT_DECODE_BRANCH_DN", -1);

    /**
     * An unexpected error occurred while trying to create a new instance of tag %s referenced on line %d of the template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ENTRY_GENERATOR_CANNOT_INSTANTIATE_NEW_TAG =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CANNOT_INSTANTIATE_NEW_TAG", -1);

    /**
     * Cannot instantiate class %s as a MakeLDIF tag
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_GENERATOR_CANNOT_INSTANTIATE_TAG =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CANNOT_INSTANTIATE_TAG", -1);

    /**
     * Unable to load class %s for use as a MakeLDIF tag
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_GENERATOR_CANNOT_LOAD_TAG_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CANNOT_LOAD_TAG_CLASS", -1);

    /**
     * The branch definition '%s' starting on line %d conflicts with an earlier branch definition contained in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_CONFLICTING_BRANCH_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CONFLICTING_BRANCH_DN", -1);

    /**
     * Cannot register the tag defined in class %s because the tag name %s conflicts with the name of another tag that has already been registered
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_GENERATOR_CONFLICTING_TAG_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CONFLICTING_TAG_NAME", -1);

    /**
     * The template definition %s starting on line %d conflicts with an earlier template definition contained in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_CONFLICTING_TEMPLATE_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_CONFLICTING_TEMPLATE_NAME", -1);

    /**
     * Could not find names resource file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_GENERATOR_COULD_NOT_FIND_NAME_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_COULD_NOT_FIND_NAME_FILE", -1);

    /**
     * Could not find template file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_GENERATOR_COULD_NOT_FIND_TEMPLATE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_COULD_NOT_FIND_TEMPLATE_FILE", -1);

    /**
     * The constant definition on line %d is missing an equal sign to delimit the constant name from the value
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ENTRY_GENERATOR_DEFINE_MISSING_EQUALS =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_DEFINE_MISSING_EQUALS", -1);

    /**
     * The constant definition on line %d does not include a name for the constant
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ENTRY_GENERATOR_DEFINE_NAME_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_DEFINE_NAME_EMPTY", -1);

    /**
     * An error occurred while attempting to parse the template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_GENERATOR_EXCEPTION_DURING_PARSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_EXCEPTION_DURING_PARSE", -1);

    /**
     * Line %d of the template file contains an incomplete tag that starts with either '<' or '{' but does get closed
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ENTRY_GENERATOR_INCOMPLETE_TAG =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_INCOMPLETE_TAG", -1);

    /**
     * There is no attribute name before the colon on line %d of the template file in the definition for template %s %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_ENTRY_GENERATOR_NO_ATTR_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_NO_ATTR_IN_TEMPLATE_LINE", -1);

    /**
     * There is no colon to separate the attribute name from the value pattern on line %d of the template file in the definition for %s %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_ENTRY_GENERATOR_NO_COLON_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_NO_COLON_IN_TEMPLATE_LINE", -1);

    /**
     * An undefined tag %s is referenced on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_NO_SUCH_TAG =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_NO_SUCH_TAG", -1);

    /**
     * Unable to parse the number of entries for template %s as an integer for the subordinate template definition on line %d for %s %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_ENTRY_GENERATOR_SUBORDINATE_CANT_PARSE_NUMENTRIES =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_SUBORDINATE_CANT_PARSE_NUMENTRIES", -1);

    /**
     * Cannot find file %s referenced by tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ENTRY_GENERATOR_TAG_CANNOT_FIND_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_CANNOT_FIND_FILE", -1);

    /**
     * Cannot parse value "%s" as a Boolean value for tag %s on line %d of the template file.  The value must be either 'true' or 'false'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ENTRY_GENERATOR_TAG_CANNOT_PARSE_AS_BOOLEAN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_CANNOT_PARSE_AS_BOOLEAN", -1);

    /**
     * Cannot parse value "%s" as an integer for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ENTRY_GENERATOR_TAG_CANNOT_PARSE_AS_INTEGER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_CANNOT_PARSE_AS_INTEGER", -1);

    /**
     * An error occurred while trying to read file %s referenced by tag %s on line %d of the template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object> ERR_ENTRY_GENERATOR_TAG_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_CANNOT_READ_FILE", -1);

    /**
     * Value %d is above the largest allowed value of %d for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number> ERR_ENTRY_GENERATOR_TAG_INTEGER_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INTEGER_ABOVE_UPPER_BOUND", -1);

    /**
     * Value %d is below the lowest allowed value of %d for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number> ERR_ENTRY_GENERATOR_TAG_INTEGER_BELOW_LOWER_BOUND =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INTEGER_BELOW_LOWER_BOUND", -1);

    /**
     * Invalid number of arguments provided for tag %s on line number %d of the template file:  expected %d, got %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number> ERR_ENTRY_GENERATOR_TAG_INVALID_ARGUMENT_COUNT =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INVALID_ARGUMENT_COUNT", -1);

    /**
     * Invalid number of arguments provided for tag %s on line number %d of the template file: expected between %d and %d, got %d
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number> ERR_ENTRY_GENERATOR_TAG_INVALID_ARGUMENT_RANGE_COUNT =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Number, Number, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INVALID_ARGUMENT_RANGE_COUNT", -1);

    /**
     * Invalid file access mode %s for tag %s on line %d of the template file.  It must be either "sequential" or "random"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ENTRY_GENERATOR_TAG_INVALID_FILE_ACCESS_MODE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INVALID_FILE_ACCESS_MODE", -1);

    /**
     * Cannot parse value "%s" as an valid format string for tag %s on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_ENTRY_GENERATOR_TAG_INVALID_FORMAT_STRING =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_INVALID_FORMAT_STRING", -1);

    /**
     * The list tag on line %d of the template file does not contain any arguments to specify the list values.  At least one list value must be provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ENTRY_GENERATOR_TAG_LIST_NO_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_LIST_NO_ARGUMENTS", -1);

    /**
     * Tag %s referenced on line %d of the template file is not allowed for use in branch definitions
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_TAG_NOT_ALLOWED_IN_BRANCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_NOT_ALLOWED_IN_BRANCH", -1);

    /**
     * The random tag on line %d of the template file does not include an argument to specify the type of random value that should be generated
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ENTRY_GENERATOR_TAG_NO_RANDOM_TYPE_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_NO_RANDOM_TYPE_ARGUMENT", -1);

    /**
     * Undefined attribute %s referenced on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_TAG_UNDEFINED_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_UNDEFINED_ATTRIBUTE", -1);

    /**
     * The random tag on line %d of the template file references an unknown random type of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_ENTRY_GENERATOR_TAG_UNKNOWN_RANDOM_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TAG_UNKNOWN_RANDOM_TYPE", -1);

    /**
     * The parent template %s referenced on line %d for template %s is invalid because the referenced parent template is not defined before the template that extends it
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_ENTRY_GENERATOR_TEMPLATE_INVALID_PARENT_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TEMPLATE_INVALID_PARENT_TEMPLATE", -1);

    /**
     * The template named %s includes RDN attribute %s that is not assigned a value in that template
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_GENERATOR_TEMPLATE_MISSING_RDN_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_TEMPLATE_MISSING_RDN_ATTR", -1);

    /**
     * The branch with entry DN '%s' references a subordinate template named '%s' which is not defined in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_GENERATOR_UNDEFINED_BRANCH_SUBORDINATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_UNDEFINED_BRANCH_SUBORDINATE", -1);

    /**
     * The template named %s references a subordinate template named %s which is not defined in the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_GENERATOR_UNDEFINED_TEMPLATE_SUBORDINATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_UNDEFINED_TEMPLATE_SUBORDINATE", -1);

    /**
     * Unexpected template line "%s" encountered on line %d of the template file
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_UNEXPECTED_TEMPLATE_FILE_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_UNEXPECTED_TEMPLATE_FILE_LINE", -1);

    /**
     * Constant '%s' defined on line %d has not been assigned a value
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_ENTRY_GENERATOR_WARNING_DEFINE_VALUE_EMPTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_ENTRY_GENERATOR_WARNING_DEFINE_VALUE_EMPTY", -1);

    /**
     * Unable to increment the value of attribute '%s' because either the current value or the increment could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_CANNOT_PARSE_AS_INT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_CANNOT_PARSE_AS_INT", -1);

    /**
     * Unable to increment the value of attribute '%s' because the provided modification did not have exactly one value to use as the increment
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_INVALID_VALUE_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_INVALID_VALUE_COUNT", -1);

    /**
     * Unable to increment the value of attribute '%s' because that attribute does not exist in the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_INCREMENT_NO_SUCH_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_INCREMENT_NO_SUCH_ATTRIBUTE", -1);

    /**
     * Unable to remove one or more values from attribute '%s' because at least one of the attributes does not exist in the entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_NO_SUCH_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_NO_SUCH_VALUE", -1);

    /**
     * Entry "%s" violates the schema because it contains an empty attribute "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_AT_EMPTY_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_AT_EMPTY_ATTRIBUTE", -1);

    /**
     * Entry "%s" violates the schema because it contains multiple values for the single-valued attribute "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_AT_SINGLE_VALUED_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_AT_SINGLE_VALUED_ATTRIBUTE", -1);

    /**
     * Entry "%s" violates the schema because it contains attribute "%s" which is not allowed by any of the object classes in the entry nor its DIT content rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_DCR_DISALLOWED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DCR_DISALLOWED_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it does not contain attribute "%s" which is required by DIT content rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_DCR_MISSING_MUST_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DCR_MISSING_MUST_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it contains attribute "%s" which is prohibited by DIT content rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_DCR_PROHIBITED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DCR_PROHIBITED_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it contains auxiliary object class "%s" which is not allowed by DIT content rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_DCR_PROHIBITED_AUXILIARY_OC =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DCR_PROHIBITED_AUXILIARY_OC", -1);

    /**
     * Entry "%s" violates the schema because DIT structure rule "%s" does not allow entries of type "%s" to be placed immediately below entries of type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ENTRY_SCHEMA_DSR_ILLEGAL_OC =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_ILLEGAL_OC", -1);

    /**
     * Entry "%s" violates the schema because there is no DIT structure rule that applies to the entry, but there is a DIT structure rule "%s" which applies to the parent entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_DSR_MISSING_DSR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_MISSING_DSR", -1);

    /**
     * Entry "%s" could not be validated against any DIT structure rules because its parent entry does not appear to contain a valid structural object class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_SCHEMA_DSR_NO_PARENT_OC =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_NO_PARENT_OC", -1);

    /**
     * Entry "%s" could not be validated against any DIT structure rules because its parent entry could not be retrieved for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_DSR_PARENT_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_DSR_PARENT_NOT_FOUND", -1);

    /**
     * Entry "%s" violates the schema because it contains multiple conflicting structural object classes "%s" and "%s". Only a single structural object class is allowed in an entry
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_MULTIPLE_STRUCTURAL_CLASSES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_MULTIPLE_STRUCTURAL_CLASSES", -1);

    /**
     * Entry "%s" violates the schema because its RDN contains attribute "%s" which is not allowed by any the name form "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_NF_DISALLOWED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_NF_DISALLOWED_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because its RDN does not contain the attribute "%s" which is required by name form "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_NF_MISSING_MUST_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_NF_MISSING_MUST_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it does not include a structural object class. All entries must contain a structural object class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_SCHEMA_NO_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_NO_STRUCTURAL_CLASS", -1);

    /**
     * Entry "%s" violates the schema because it contains attribute "%s" which is not allowed by any of the object classes in the entry
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_OC_DISALLOWED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_OC_DISALLOWED_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it does not contain attribute "%s" which is required by object class "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ENTRY_SCHEMA_OC_MISSING_MUST_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_OC_MISSING_MUST_ATTRIBUTES", -1);

    /**
     * Entry "%s" violates the schema because it contains an unrecognized object class "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENTRY_SCHEMA_UNKNOWN_OBJECT_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_SCHEMA_UNKNOWN_OBJECT_CLASS", -1);

    /**
     * Unsupported modification type '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ENTRY_UNKNOWN_MODIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_ENTRY_UNKNOWN_MODIFICATION_TYPE", -1);

    /**
     * An error occurred while attempting to decode the value of the cancel extended request:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_CANCEL_CANNOT_DECODE_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_EXTOP_CANCEL_CANNOT_DECODE_REQUEST_VALUE", -1);

    /**
     * Unable to process the cancel request because the extended operation did not include a request value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_EXTOP_CANCEL_NO_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_EXTOP_CANCEL_NO_REQUEST_VALUE", -1);

    /**
     * An unexpected error occurred while attempting to decode the password modify extended request sequence:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EXTOP_PASSMOD_CANNOT_DECODE_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_EXTOP_PASSMOD_CANNOT_DECODE_REQUEST", -1);

    /**
     * Cannot decode the provided control as a get effective rights request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_GETEFFECTIVERIGHTS_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_GETEFFECTIVERIGHTS_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided get effective rights request control because it contains an invalid authorization ID distinguished name: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GETEFFECTIVERIGHTS_INVALID_AUTHZIDDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_GETEFFECTIVERIGHTS_INVALID_AUTHZIDDN", -1);

    /**
     * Cannot decode the provided get effective rights request control because it contained an unrecognized attribute type: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GETEFFECTIVERIGHTS_UNKNOWN_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_GETEFFECTIVERIGHTS_UNKNOWN_ATTRIBUTE", -1);

    /**
     * Cannot decode the provided symmetric key extended request: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GET_SYMMETRIC_KEY_ASN1_DECODE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_GET_SYMMETRIC_KEY_ASN1_DECODE_EXCEPTION", -1);

    /**
     * Cannot decode the provided symmetric key extended operation because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_GET_SYMMETRIC_KEY_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_GET_SYMMETRIC_KEY_NO_VALUE", -1);

    /**
     * The value %s cannot be decoded as a hexadecimal string because it contains an illegal character %c that is not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_HEX_DECODE_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "ERR_HEX_DECODE_INVALID_CHARACTER", -1);

    /**
     * The value %s cannot be decoded as a hexadecimal string because it does not have a length that is a multiple of two bytes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_HEX_DECODE_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_HEX_DECODE_INVALID_LENGTH", -1);

    /**
     * Expected a compacted unsigned int (value less than %d), but got a compacted unsigned long: %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_INVALID_COMPACTED_UNSIGNED_INT =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(CoreMessages.class, RESOURCE, "ERR_INVALID_COMPACTED_UNSIGNED_INT", -1);

    /**
     * The value %s cannot be decoded because %c is not a valid escape character
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> ERR_INVALID_ESCAPE_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "ERR_INVALID_ESCAPE_CHAR", -1);

    /**
     * The entry %s includes a subschemaSubentry attribute but it contains an invalid distinguished name "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_INVALID_SUBSCHEMA_SUBENTRY_ATTR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_INVALID_SUBSCHEMA_SUBENTRY_ATTR", -1);

    /**
     * Cannot decode the provided control as an assertion control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPASSERT_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAPASSERT_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided LDAP assertion control because the control value cannot be decoded as an ASN.1 element:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPASSERT_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAPASSERT_INVALID_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided LDAP assertion control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPASSERT_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_LDAPASSERT_NO_CONTROL_VALUE", -1);

    /**
     * An error occurred while attempting to perform local authentication to the Kerberos realm:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_GSSAPI_LOCAL_AUTHENTICATION_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAPAUTH_GSSAPI_LOCAL_AUTHENTICATION_FAILED", -1);

    /**
     * The provided port number %d is not within the valid range between 1 and 65535
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAPURL_BAD_PORT =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_BAD_PORT", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the protocol scheme "%s" is invalid. It should be either "ldap" or "ldaps"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_BAD_SCHEME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_BAD_SCHEME", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the port number portion %s cannot be decoded as an integer
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_CANNOT_DECODE_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_CANNOT_DECODE_PORT", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the provided distinguished name could not be parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_DN", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the provided filter could not be parsed: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPURL_INVALID_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_FILTER", -1);

    /**
     * The provided URL component "%s" could not be decoded because the character at byte %d was not a valid hexadecimal digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPURL_INVALID_HEX_BYTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_HEX_BYTE", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because the provided port number %d is not within the valid range between 1 and 65535
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAPURL_INVALID_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_INVALID_PORT", -1);

    /**
     * The provided string "%s" cannot be decoded as an LDAP URL because it does not contain a protocol scheme
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPURL_NO_SCHEME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAPURL_NO_SCHEME", -1);

    /**
     * The client sent a request to the Directory Server with an ASN.1 element value length of %d bytes.  This exceeds the maximum allowed request size of %d bytes, so processing cannot continue on this connection
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_LDAP_CLIENT_DECODE_MAX_REQUEST_SIZE_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_CLIENT_DECODE_MAX_REQUEST_SIZE_EXCEEDED", -1);

    /**
     * The provided search filter "%s" could not be decoded because the compound filter between positions %d and %d did not start with an open parenthesis and end with a close parenthesis (they might be parentheses for different filter components)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_COMPOUND_MISSING_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_COMPOUND_MISSING_PARENTHESES", -1);

    /**
     * An LDAP filter enclosed in apostrophes is invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_ENCLOSED_IN_APOSTROPHES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_ENCLOSED_IN_APOSTROPHES", -1);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not include either an attribute description or a matching rule ID.  At least one of them must be provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR", -1);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not have a colon to denote the end of the attribute type name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_COLON", -1);

    /**
     * The provided search filter contains an invalid attribute type '%s' with invalid character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_LDAP_FILTER_INVALID_CHAR_IN_ATTR_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_INVALID_CHAR_IN_ATTR_TYPE", -1);

    /**
     * The provided search filter "%s" had an invalid escaped byte value at position %d.  A backslash in a value must be followed by two hexadecimal characters that define the byte that has been encoded
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_INVALID_ESCAPED_BYTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_INVALID_ESCAPED_BYTE", -1);

    /**
     * The provided search filter "%s" had mismatched parentheses around the portion between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_MISMATCHED_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_MISMATCHED_PARENTHESES", -1);

    /**
     * The provided search filter "%s" could not be decoded because the NOT filter between positions %d and %d did not contain exactly one filter component
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_NOT_EXACTLY_ONE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_NOT_EXACTLY_ONE", -1);

    /**
     * The provided search filter "%s" could not be decoded because the opening parenthesis at position %d did not have a corresponding close parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS", -1);

    /**
     * The provided search filter "%s" could not be decoded because the closing parenthesis at position %d did not have a corresponding open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS", -1);

    /**
     * The provided search filter "%s" was missing an equal sign in the suspected simple filter component between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_NO_EQUAL_SIGN =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_EQUAL_SIGN", -1);

    /**
     * Cannot decode the provided string as an LDAP search filter because the string was null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_FILTER_STRING_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_STRING_NULL", -1);

    /**
     * The provided search filter "%s" could not be decoded because the assumed substring filter value between positions %d and %d did not have any asterisk wildcard characters
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_SUBSTRING_NO_ASTERISKS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_SUBSTRING_NO_ASTERISKS", -1);

    /**
     * Cannot decode the provided string %s as an LDAP search filter because an unexpected exception was thrown during processing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_FILTER_UNCAUGHT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_FILTER_UNCAUGHT_EXCEPTION", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modification because it contained an invalid modification type (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_MODIFICATION_DECODE_INVALID_MOD_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_MODIFICATION_DECODE_INVALID_MOD_TYPE", -1);

    /**
     * Cannot decode the provided control as a simple paged results control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_PAGED_RESULTS_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the cookie could not be properly decoded:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_COOKIE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_COOKIE", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the element is null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_PAGED_RESULTS_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_NULL", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the element could not be decoded as a sequence:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_SEQUENCE", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the size element could not be properly decoded:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_SIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_SIZE", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the provided alias dereferencing policy value (%d) is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_DEREF =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_DEREF", -1);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the provided scope value (%d) is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_SCOPE", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it contained a an unexpected attribute "%s" when "%s" was expected
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object> ERR_LDIF_ATTRIBUTE_NAME_MISMATCH =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_ATTRIBUTE_NAME_MISMATCH", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it contained an unrecognized changetype "%s". The changetype must be one of add, delete, modify, modrdn, or moddn
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_BAD_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_BAD_CHANGE_TYPE", -1);

    /**
     * Unable to parse LDIF modify record starting at line %d with distinguished name "%s" because it contained an unrecognized modification type "%s". The modification type must be one of add, delete, replace, or increment
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_BAD_MODIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_BAD_MODIFICATION_TYPE", -1);

    /**
     * Skipping LDIF change record starting at line %d with distinguished name "%s" because it is within an excluded branch
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_CHANGE_EXCLUDED_BY_DN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_CHANGE_EXCLUDED_BY_DN", -1);

    /**
     * Unable to parse LDIF entry %s starting at line %d because it was not possible to base64-decode the value on line "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDIF_COULD_NOT_BASE64_DECODE_ATTR =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_BASE64_DECODE_ATTR", -1);

    /**
     * Unable to parse LDIF entry starting at line %d because it was not possible to base64-decode the DN on line "%s":  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_COULD_NOT_BASE64_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_COULD_NOT_BASE64_DECODE_DN", -1);

    /**
     * Skipping LDIF entry starting at line %d with distinguished name "%s" because it is within an excluded branch
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_ENTRY_EXCLUDED_BY_DN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_ENTRY_EXCLUDED_BY_DN", -1);

    /**
     * Skipping LDIF entry starting at line %d with distinguished name "%s" because it does not meet the filter criteria
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_ENTRY_EXCLUDED_BY_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_ENTRY_EXCLUDED_BY_FILTER", -1);

    /**
     * Unable to parse LDIF entry starting at line %d because an error occurred while trying to parse the value of line "%s" as a distinguished name:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_INVALID_DN", -1);

    /**
     * Unable to parse line %d ("%s") from the LDIF source because the line started with a space but there were no previous lines in the entry to which this line could be appended
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_INVALID_LEADING_SPACE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_INVALID_LEADING_SPACE", -1);

    /**
     * Unable to parse LDIF entry %s starting at line %d because the value %s was to be read from a URL but the URL was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object> ERR_LDIF_INVALID_URL =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_INVALID_URL", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it contained a malformed attribute description "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_ATTRIBUTE_NAME =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_ATTRIBUTE_NAME", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it contained a malformed changetype "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_CHANGE_TYPE", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it contained a malformed control "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_CONTROL =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_CONTROL", -1);

    /**
     * Unable to parse LDIF delete record starting at line %d with distinguished name "%s" because it contained additional lines after the changetype when none were expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_MALFORMED_DELETE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_DELETE", -1);

    /**
     * Unable to parse LDIF modify DN record starting at line %d with distinguished name "%s" because it contained a malformed deleteoldrdn "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_DELETE_OLD_RDN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_DELETE_OLD_RDN", -1);

    /**
     * Unable to parse LDIF modify record starting at line %d with distinguished name "%s" because it contained a malformed modification type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_MODIFICATION_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_MODIFICATION_TYPE", -1);

    /**
     * Unable to parse LDIF modify DN record starting at line %d with distinguished name "%s" because it contained a malformed new RDN "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_NEW_RDN =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_NEW_RDN", -1);

    /**
     * Unable to parse LDIF modify DN record starting at line %d with distinguished name "%s" because it contained a malformed newsuperior "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MALFORMED_NEW_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MALFORMED_NEW_SUPERIOR", -1);

    /**
     * Rejecting the LDIF change record starting at line %d with distinguished name "%s" because it includes multiple values for single-valued attribute "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_MULTI_VALUED_SINGLE_VALUED_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_MULTI_VALUED_SINGLE_VALUED_ATTRIBUTE", -1);

    /**
     * Unable to parse LDIF entry starting at line %d because the line "%s" does not include an attribute name
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_NO_ATTR_NAME", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because there was no change type
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_NO_CHANGE_TYPE", -1);

    /**
     * Unable to parse LDIF modify DN record starting at line %d with distinguished name "%s" because there was no deleteoldrdn field
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_DELETE_OLD_RDN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_NO_DELETE_OLD_RDN", -1);

    /**
     * Unable to parse LDIF entry starting at line %d because the first line does not contain a DN (the first line was "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_DN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_NO_DN", -1);

    /**
     * Unable to parse LDIF modify DN record starting at line %d with distinguished name "%s" because there was no new RDN
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDIF_NO_NEW_RDN =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_NO_NEW_RDN", -1);

    /**
     * Unable to parse LDIF change record starting at line %d with distinguished name "%s" because it has an unexpected binary option for attribute %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_UNEXPECTED_BINARY_OPTION =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_UNEXPECTED_BINARY_OPTION", -1);

    /**
     * Rejecting the LDIF change record starting at line %d with distinguished name "%s" because it contains an unrecognized attribute type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> ERR_LDIF_UNKNOWN_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_UNKNOWN_ATTRIBUTE_TYPE", -1);

    /**
     * Unable to parse LDIF entry %s starting at line %d because the value %s was to be read from URL %s but an error occurred while trying to read that content:  %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object> ERR_LDIF_URL_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg5<Object, Number, Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_LDIF_URL_IO_ERROR", -1);

    /**
     * Cannot decode the provided control as a ManageDsaIT request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MANAGEDSAIT_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MANAGEDSAIT_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided ManageDsaIT control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MANAGEDSAIT_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MANAGEDSAIT_INVALID_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided matched values control because an error occurred while attempting to decode the value as an ASN.1 sequence:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MATCHEDVALUES_CANNOT_DECODE_VALUE_AS_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MATCHEDVALUES_CANNOT_DECODE_VALUE_AS_SEQUENCE", -1);

    /**
     * Cannot decode the provided control as a matched values request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MATCHEDVALUES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MATCHEDVALUES_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided matched values control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MATCHEDVALUES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MATCHEDVALUES_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided matched values control because the control value does not specify any filters for use in matching attribute values
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MATCHEDVALUES_NO_FILTERS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MATCHEDVALUES_NO_FILTERS", -1);

    /**
     * Validation of matching rule use definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MRU_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MRU_VALIDATION_FAIL", -1);

    /**
     * The GSER value contains additional characters at the end of the assertion
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MR_CERTIFICATE_MATCH_EXPECTED_END =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_MR_CERTIFICATE_MATCH_EXPECTED_END", -1);

    /**
     * An error occurred while parsing the GSER String: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MR_CERTIFICATE_MATCH_GSER_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MR_CERTIFICATE_MATCH_GSER_INVALID", -1);

    /**
     * The identifier "%s" could not be found at the correct position
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MR_CERTIFICATE_MATCH_IDENTIFIER_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MR_CERTIFICATE_MATCH_IDENTIFIER_NOT_FOUND", -1);

    /**
     * The provided value "%s" could not be parsed as a valid distinguished name because an error occurred while trying to parse the DN portion:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MR_CERTIFICATE_MATCH_INVALID_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MR_CERTIFICATE_MATCH_INVALID_DN", -1);

    /**
     * The value could not be parsed as an X.509 certificate: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MR_CERTIFICATE_MATCH_PARSE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MR_CERTIFICATE_MATCH_PARSE_ERROR", -1);

    /**
     * Validation of matching rule definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MR_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_MR_VALIDATION_FAIL", -1);

    /**
     * The provided filter "%s" cannot be used as a matched values filter because "and" filters are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_BAD_FILTER_AND =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MVFILTER_BAD_FILTER_AND", -1);

    /**
     * The provided filter "%s" cannot be used as a matched values filter because extensible match filters requesting DN attributes are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_BAD_FILTER_EXT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MVFILTER_BAD_FILTER_EXT", -1);

    /**
     * The provided filter "%s" cannot be used as a matched values filter because "not" filters are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_BAD_FILTER_NOT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MVFILTER_BAD_FILTER_NOT", -1);

    /**
     * The provided filter "%s" cannot be used as a matched values filter because "or" filters are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_BAD_FILTER_OR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_MVFILTER_BAD_FILTER_OR", -1);

    /**
     * The provided filter "%s" cannot be used as a matched values filter because filters of type %d are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_MVFILTER_BAD_FILTER_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "ERR_MVFILTER_BAD_FILTER_UNRECOGNIZED", -1);

    /**
     * Validation of name form definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_NAMEFORM_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_NAMEFORM_VALIDATION_FAIL", -1);

    /**
     * The search request succeeded but did not return any search result entries when one was expected
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SEARCH_RESULT_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_NO_SEARCH_RESULT_ENTRIES", -1);

    /**
     * The entry %s does not include a subschemaSubentry attribute
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_SUBSCHEMA_SUBENTRY_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_NO_SUBSCHEMA_SUBENTRY_ATTR", -1);

    /**
     * Validation of object class definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OC_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_OC_VALIDATION_FAIL", -1);

    /**
     * Cannot decode the provided control as a permissive modify request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PERMISSIVE_MODIFY_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PERMISSIVE_MODIFY_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided permissive modify control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PERMISSIVE_MODIFY_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PERMISSIVE_MODIFY_INVALID_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided LDAP post-read request control because an error occurred while trying to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_POSTREADREQ_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_POSTREADREQ_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided LDAP post-read request control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_POSTREADREQ_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_POSTREADREQ_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided LDAP post-read response control because an error occurred while trying to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_POSTREADRESP_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_POSTREADRESP_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided LDAP post-read response control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_POSTREADRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_POSTREADRESP_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a post-read control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_POSTREAD_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_POSTREAD_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided LDAP pre-read request control because an error occurred while trying to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PREREADREQ_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PREREADREQ_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided LDAP pre-read request control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PREREADREQ_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PREREADREQ_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided LDAP pre-read response control because an error occurred while trying to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PREREADRESP_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PREREADRESP_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided LDAP pre-read response control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PREREADRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PREREADRESP_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a pre-read control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PREREAD_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PREREAD_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided proxied authorization V1 control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH1_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH1_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided control as a proxy authorization v1 control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PROXYAUTH1_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH1_CONTROL_BAD_OID", -1);

    /**
     * Unwilling to process the request because it contains a proxied authorization V1 control which is not marked critical.  The proxied authorization control must always have a criticality of "true"
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH1_CONTROL_NOT_CRITICAL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH1_CONTROL_NOT_CRITICAL", -1);

    /**
     * Cannot decode the provided proxy authorization v1 control because it contains an invalid authorization distinguished name: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH1_INVALID_AUTHZIDDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH1_INVALID_AUTHZIDDN", -1);

    /**
     * Cannot decode the provided proxied authorization V1 control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH1_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH1_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided proxied authorization V2 control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH2_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided control as a proxy authorization v2 control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PROXYAUTH2_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH2_CONTROL_BAD_OID", -1);

    /**
     * Unwilling to process the request because it contains a proxied authorization V2 control which is not marked critical.  The proxied authorization control must always have a criticality of "true"
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH2_CONTROL_NOT_CRITICAL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH2_CONTROL_NOT_CRITICAL", -1);

    /**
     * Cannot decode the provided proxy authorization v2 control because the control value '%s' does not begin with a valid authorization ID type 'dn:' or 'u:'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_INVALID_AUTHZID_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH2_INVALID_AUTHZID_TYPE", -1);

    /**
     * Cannot decode the provided proxied authorization V2 control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH2_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PROXYAUTH2_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a persistent search request control because it an invalid changeTypes field '%d', when a value between 0 and 15 was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PSEARCH_BAD_CHANGE_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_PSEARCH_BAD_CHANGE_TYPES", -1);

    /**
     * Cannot decode the provided persistent search control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PSEARCH_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided control as a persistent search request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PSEARCH_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PSEARCH_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided persistent search control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PSEARCH_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PSEARCH_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a Netscape password expired response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWEXPIRED_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWEXPIRED_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as a password expired control because the provided control had a value that could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWEXPIRED_CONTROL_INVALID_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWEXPIRED_CONTROL_INVALID_VALUE", -1);

    /**
     * Cannot decode the provided control as a password expiring control because an error occurred while attempting to decode the number of seconds until expiration: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION", -1);

    /**
     * Cannot decode the provided control as a Netscape password expiring response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWEXPIRING_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWEXPIRING_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided password expiring control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWEXPIRING_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWEXPIRING_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a password policy request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICYREQ_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICYREQ_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as a password policy request control because the provided control had a value but the password policy request control should not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPOLICYREQ_CONTROL_HAS_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWPOLICYREQ_CONTROL_HAS_VALUE", -1);

    /**
     * Cannot decode the provided control as a password policy response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_PWPOLICYRES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICYRES_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided password policy response control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICYRES_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICYRES_DECODE_ERROR", -1);

    /**
     * Cannot decode the provided password policy response control because the error element has an invalid type of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PWPOLICYRES_INVALID_ERROR_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_PWPOLICYRES_INVALID_ERROR_TYPE", -1);

    /**
     * Cannot decode the provided password policy response control because the warning element has an invalid type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICYRES_INVALID_WARNING_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPOLICYRES_INVALID_WARNING_TYPE", -1);

    /**
     * Cannot decode the provided password policy response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPOLICYRES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWPOLICYRES_NO_CONTROL_VALUE", -1);

    /**
     * An unexpected error occurred while attempting to decode password policy state extended request value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_DECODE_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_DECODE_FAILURE", -1);

    /**
     * The provided password policy state extended request did not include a request value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPSTATE_EXTOP_NO_REQUEST_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_NO_REQUEST_VALUE", -1);

    /**
     * The password policy state extended request included an operation with an invalid or unsupported operation type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPSTATE_EXTOP_UNKNOWN_OP_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_PWPSTATE_EXTOP_UNKNOWN_OP_TYPE", -1);

    /**
     * An RDN contained multiple components having the same attribute type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_RDN_DUPLICATE_AVA_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_RDN_DUPLICATE_AVA_TYPES", -1);

    /**
     * An RDN must contain at least one attribute type and value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_RDN_NO_AVAS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_RDN_NO_AVAS", -1);

    /**
     * The RDN "%s" could not be parsed because it contained trailing content after the RDN: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RDN_TRAILING_GARBAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_RDN_TRAILING_GARBAGE", -1);

    /**
     * The RDN "%s" could not be parsed due to the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RDN_TYPE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_RDN_TYPE_NOT_FOUND", -1);

    /**
     * Cannot decode the provided control as a real attributes only request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REAL_ATTRS_ONLY_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_REAL_ATTRS_ONLY_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided real attributes only control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REAL_ATTRS_ONLY_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_REAL_ATTRS_ONLY_INVALID_CONTROL_VALUE", -1);

    /**
     * An error occurred during multi-stage authentication: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SASL_BIND_MULTI_STAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SASL_BIND_MULTI_STAGE", -1);

    /**
     * An unexpected error occurred while trying to create an %s context: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_CONTEXT_CREATE_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SASL_CONTEXT_CREATE_ERROR", -1);

    /**
     * SASL %s protocol error: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SASL_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SASL_PROTOCOL_ERROR", -1);

    /**
     * Unable to register attribute type %s with the server schema because its OID %s conflicts with the OID of an existing attribute type %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_ATTRIBUTE_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_ATTRIBUTE_OID", -1);

    /**
     * Unable to register DIT content rule %s with the server schema because its structural object class %s conflicts with the structural object class for an existing DIT content rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_DIT_CONTENT_RULE1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_DIT_CONTENT_RULE1", -1);

    /**
     * Unable to register DIT structure rule %s with the server schema because its rule ID %d conflicts with the rule ID for an existing DIT structure rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_DIT_STRUCTURE_RULE_ID", -1);

    /**
     * Unable to register matching rule use %s with the server schema because its matching rule %s conflicts with the matching rule for an existing matching rule use %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_MATCHING_RULE_USE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_MATCHING_RULE_USE", -1);

    /**
     * Unable to register matching rule %s with the server schema because its OID %s conflicts with the OID of an existing matching rule %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_MR_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_MR_OID", -1);

    /**
     * Unable to register name form %s with the server schema because its OID %s conflicts with the OID for an existing name form %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_NAME_FORM_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_NAME_FORM_OID", -1);

    /**
     * Unable to register object class %s with the server schema because its OID %s conflicts with the OID of an existing object class %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_OBJECTCLASS_OID1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_OBJECTCLASS_OID1", -1);

    /**
     * Unable to register attribute syntax %s with the server schema because its OID %s conflicts with the OID of an existing syntax %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SCHEMA_CONFLICTING_SYNTAX_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "ERR_SCHEMA_CONFLICTING_SYNTAX_OID", -1);

    /**
     * Cannot decode the provided control as a server side sort request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SORTREQ_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SORTREQ_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as a server side sort response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SORTRES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SORTRES_CONTROL_BAD_OID", -1);

    /**
     * The sort key '%s' could not be decoded because the attribute description '%s' does not have a default ordering matching rule
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SORT_KEY_DEFAULT_MRULE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SORT_KEY_DEFAULT_MRULE_NOT_FOUND", -1);

    /**
     * The sort key '%s' could not be decoded because the ordering matching rule '%s' was not found in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SORT_KEY_MRULE_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SORT_KEY_MRULE_NOT_FOUND", -1);

    /**
     * The sort key '%s' could not be decoded because it did not contain an attribute description
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SORT_KEY_NO_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SORT_KEY_NO_ATTR_NAME", -1);

    /**
     * The sort key '%s' could not be decoded because it contained a colon but no ordering matching rule name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SORT_KEY_NO_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SORT_KEY_NO_MATCHING_RULE", -1);

    /**
     * The list of sort keys '%s' could not be decoded because it did not contain any sort keys
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SORT_KEY_NO_SORT_KEYS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SORT_KEY_NO_SORT_KEYS", -1);

    /**
     * Cannot decode the provided sub-entries control because an error occurred while attempting to decode the value as an ASN.1 boolean:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBENTRIES_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SUBENTRIES_CANNOT_DECODE_VALUE", -1);

    /**
     * Cannot decode the provided control as a sub-entries request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SUBENTRIES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SUBENTRIES_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided sub-entries control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBENTRIES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SUBENTRIES_NO_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a tree delete request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SUBTREE_DELETE_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SUBTREE_DELETE_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided subtree delete control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE", -1);

    /**
     * The provided value is not a valid X.509 Certificate because it contains invalid DER encodings
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SYNTAX_CERTIFICATE_INVALID_DER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_INVALID_DER", -1);

    /**
     * The provided value is not a valid X.509 Certificate because it contains an invalid version number (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_SYNTAX_CERTIFICATE_INVALID_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_INVALID_VERSION", -1);

    /**
     * The provided value is not a valid X.509 Certificate: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SYNTAX_CERTIFICATE_NOTVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_NOTVALID", -1);

    /**
     * The provided value is not a valid X.509 Certificate because it contains additional ASN.1 elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SYNTAX_CERTIFICATE_NO_ELEMENT_EXPECTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_NO_ELEMENT_EXPECTED", -1);

    /**
     * The provided value is not a valid X.509 Certificate because "%s" is only valid in X.509 v2/v3
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SYNTAX_CERTIFICATE_ONLY_VALID_V23 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_ONLY_VALID_V23", -1);

    /**
     * The provided value is not a valid X.509 Certificate because "%s" is only valid in X.509 v3
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SYNTAX_CERTIFICATE_ONLY_VALID_V3 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_SYNTAX_CERTIFICATE_ONLY_VALID_V3", -1);

    /**
     * Validation of syntax definition %s failed and will be removed from the schema: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SYNTAX_VALIDATION_FAIL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_SYNTAX_VALIDATION_FAIL", -1);

    /**
     * Unable to parse line %d ("%s") from the template file because the line started with a space but there were no previous lines in the entry to which this line could be appended
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_TEMPLATE_FILE_INVALID_LEADING_SPACE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "ERR_TEMPLATE_FILE_INVALID_LEADING_SPACE", -1);

    /**
     * Cannot decode the provided control as a transaction id control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TRANSACTION_ID_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_TRANSACTION_ID_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided ASN.1 element as a transaction id control because it did not have a value, when a value must always be provided
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TRANSACTION_ID_CONTROL_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_TRANSACTION_ID_CONTROL_DECODE_NULL", -1);

    /**
     * The search request succeeded but returned %d search result entry when only one was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_UNEXPECTED_SEARCH_RESULT_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "ERR_UNEXPECTED_SEARCH_RESULT_ENTRIES", -1);

    /**
     * The search request succeeded but returned more than one search result entry when only one was expected
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNEXPECTED_SEARCH_RESULT_ENTRIES_NO_COUNT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_UNEXPECTED_SEARCH_RESULT_ENTRIES_NO_COUNT", -1);

    /**
     * The search request succeeded but returned a search result reference containing the following URI: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNEXPECTED_SEARCH_RESULT_REFERENCES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_UNEXPECTED_SEARCH_RESULT_REFERENCES", -1);

    /**
     * The following request has a unknown request type: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNKNOWN_REQUEST_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_UNKNOWN_REQUEST_TYPE", -1);

    /**
     * Cannot decode the provided control as a virtual attributes only request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VIRTUAL_ATTRS_ONLY_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_VIRTUAL_ATTRS_ONLY_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided virtual attributes only control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_VIRTUAL_ATTRS_ONLY_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "ERR_VIRTUAL_ATTRS_ONLY_INVALID_CONTROL_VALUE", -1);

    /**
     * Cannot decode the provided control as a virtual list view request control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VLVREQ_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_VLVREQ_CONTROL_BAD_OID", -1);

    /**
     * Cannot decode the provided control as a virtual list view response control because it contained the OID '%s', when '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_VLVRES_CONTROL_BAD_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "ERR_VLVRES_CONTROL_BAD_OID", -1);

    /**
     * The provided authorization ID '%s' does not begin with a valid authorization ID type 'dn:' or 'u:'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_WHOAMI_INVALID_AUTHZID_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "ERR_WHOAMI_INVALID_AUTHZID_TYPE", -1);

    /**
     * The provided value starting with the bytes "%s" could not be parsed as an X509 certificate
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> FUNCTIONS_TO_CERT_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "FUNCTIONS_TO_CERT_FAIL", -1);

    /**
     * The provided value "%s" could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> FUNCTIONS_TO_INTEGER_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "FUNCTIONS_TO_INTEGER_FAIL", -1);

    /**
     * The provided value "%s" could not be parsed as an long
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> FUNCTIONS_TO_LONG_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "FUNCTIONS_TO_LONG_FAIL", -1);

    /**
     * Connection closed by client
     */
    public static final LocalizableMessageDescriptor.Arg0 HBCF_CONNECTION_CLOSED_BY_CLIENT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "HBCF_CONNECTION_CLOSED_BY_CLIENT", -1);

    /**
     * Heartbeat failed
     */
    public static final LocalizableMessageDescriptor.Arg0 HBCF_HEARTBEAT_FAILED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "HBCF_HEARTBEAT_FAILED", -1);

    /**
     * Heartbeat timed out after %d ms
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> HBCF_HEARTBEAT_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "HBCF_HEARTBEAT_TIMEOUT", -1);

    /**
     * The operation was canceled because the client issued an abandon request (message ID %d) for this operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CANCELED_BY_ABANDON_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_ABANDON_REQUEST", -1);

    /**
     * The operation was canceled because the client issued a cancel request (message ID %d) for this operation
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CANCELED_BY_CANCEL_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_CANCEL_REQUEST", -1);

    /**
     * The operation was canceled because the client has disconnected from the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCELED_BY_CLIENT_DISCONNECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_CLIENT_DISCONNECT", -1);

    /**
     * The operation was canceled because the client connection failed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCELED_BY_CLIENT_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_CLIENT_ERROR", -1);

    /**
     * The operation was canceled because the server has disconnected from the client
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CANCELED_BY_SERVER_DISCONNECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CANCELED_BY_SERVER_DISCONNECT", -1);

    /**
     * The operation was rejected because the client connection is closing
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLIENT_CONNECTION_CLOSING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_CLIENT_CONNECTION_CLOSING", -1);

    /**
     * Cannot decode the provided geteffectiverights request control:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GETEFFECTIVERIGHTS_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_GETEFFECTIVERIGHTS_DECODE_ERROR", -1);

    /**
     * The authorization ID "%s" contained in the geteffectiverights control is invalid because it does not start with "dn:" to indicate a user DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GETEFFECTIVERIGHTS_INVALID_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_GETEFFECTIVERIGHTS_INVALID_AUTHZID", -1);

    /**
     * Administrative Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ADMIN_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ADMIN_LIMIT_EXCEEDED", -1);

    /**
     * Affects Multiple DSAs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AFFECTS_MULTIPLE_DSAS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AFFECTS_MULTIPLE_DSAS", -1);

    /**
     * Alias Dereferencing Problem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ALIAS_DEREFERENCING_PROBLEM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ALIAS_DEREFERENCING_PROBLEM", -1);

    /**
     * Alias Problem
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ALIAS_PROBLEM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ALIAS_PROBLEM", -1);

    /**
     * Assertion Failed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ASSERTION_FAILED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ASSERTION_FAILED", -1);

    /**
     * Attribute or Value Exists
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ATTRIBUTE_OR_VALUE_EXISTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ATTRIBUTE_OR_VALUE_EXISTS", -1);

    /**
     * Authorization Denied
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AUTHORIZATION_DENIED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AUTHORIZATION_DENIED", -1);

    /**
     * Authentication Method Not Supported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_AUTH_METHOD_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_AUTH_METHOD_NOT_SUPPORTED", -1);

    /**
     * Busy
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_BUSY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_BUSY", -1);

    /**
     * Canceled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CANCELED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CANCELED", -1);

    /**
     * Cannot Cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CANNOT_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CANNOT_CANCEL", -1);

    /**
     * Unknown Authentication Mechanism
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_AUTH_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_AUTH_UNKNOWN", -1);

    /**
     * Referral Loop Detected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CLIENT_LOOP =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CLIENT_LOOP", -1);

    /**
     * Connect Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CONNECT_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CONNECT_ERROR", -1);

    /**
     * Control Not Found
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_CONTROL_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_CONTROL_NOT_FOUND", -1);

    /**
     * Decoding Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_DECODING_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_DECODING_ERROR", -1);

    /**
     * Encoding Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_ENCODING_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_ENCODING_ERROR", -1);

    /**
     * Filter Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_FILTER_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_FILTER_ERROR", -1);

    /**
     * Local Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_LOCAL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_LOCAL_ERROR", -1);

    /**
     * Operation Not Supported
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NOT_SUPPORTED", -1);

    /**
     * Out of Memory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NO_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NO_MEMORY", -1);

    /**
     * No Results Returned
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_NO_RESULTS_RETURNED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_NO_RESULTS_RETURNED", -1);

    /**
     * Parameter Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_PARAM_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_PARAM_ERROR", -1);

    /**
     * Referral Hop Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_REFERRAL_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_REFERRAL_LIMIT_EXCEEDED", -1);

    /**
     * Server Connection Closed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_SERVER_DOWN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_SERVER_DOWN", -1);

    /**
     * Client-Side Timeout
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_TIMEOUT", -1);

    /**
     * Unexpected Results Returned
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_UNEXPECTED_RESULTS_RETURNED", -1);

    /**
     * Cancelled by User
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CLIENT_SIDE_USER_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CLIENT_SIDE_USER_CANCELLED", -1);

    /**
     * Compare False
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_COMPARE_FALSE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_COMPARE_FALSE", -1);

    /**
     * Compare True
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_COMPARE_TRUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_COMPARE_TRUE", -1);

    /**
     * Confidentiality Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CONFIDENTIALITY_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CONFIDENTIALITY_REQUIRED", -1);

    /**
     * Constraint Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_CONSTRAINT_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_CONSTRAINT_VIOLATION", -1);

    /**
     * Entry Already Exists
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_ENTRY_ALREADY_EXISTS", -1);

    /**
     * Inappropriate Authentication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INAPPROPRIATE_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INAPPROPRIATE_AUTHENTICATION", -1);

    /**
     * Inappropriate Matching
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INAPPROPRIATE_MATCHING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INAPPROPRIATE_MATCHING", -1);

    /**
     * Insufficient Access Rights
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INSUFFICIENT_ACCESS_RIGHTS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INSUFFICIENT_ACCESS_RIGHTS", -1);

    /**
     * Invalid Attribute Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_ATTRIBUTE_SYNTAX", -1);

    /**
     * Invalid Credentials
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_CREDENTIALS", -1);

    /**
     * Invalid DN Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_INVALID_DN_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_INVALID_DN_SYNTAX", -1);

    /**
     * Loop Detected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_LOOP_DETECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_LOOP_DETECT", -1);

    /**
     * Naming Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NAMING_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NAMING_VIOLATION", -1);

    /**
     * Not Allowed on Non-Leaf
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NOT_ALLOWED_ON_NONLEAF =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NOT_ALLOWED_ON_NONLEAF", -1);

    /**
     * Not Allowed on RDN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NOT_ALLOWED_ON_RDN =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NOT_ALLOWED_ON_RDN", -1);

    /**
     * No Operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_OPERATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_OPERATION", -1);

    /**
     * No Such Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_ATTRIBUTE", -1);

    /**
     * No Such Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_OBJECT =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_OBJECT", -1);

    /**
     * No Such Operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_NO_SUCH_OPERATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_NO_SUCH_OPERATION", -1);

    /**
     * Object Class Modifications Prohibited
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OBJECTCLASS_MODS_PROHIBITED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OBJECTCLASS_MODS_PROHIBITED", -1);

    /**
     * Object Class Violation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OBJECTCLASS_VIOLATION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OBJECTCLASS_VIOLATION", -1);

    /**
     * Offset Range Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OFFSET_RANGE_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OFFSET_RANGE_ERROR", -1);

    /**
     * Operations Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OPERATIONS_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OPERATIONS_ERROR", -1);

    /**
     * Other
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_OTHER =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_OTHER", -1);

    /**
     * Protocol Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_PROTOCOL_ERROR", -1);

    /**
     * Referral
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_REFERRAL =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_REFERRAL", -1);

    /**
     * SASL Bind in Progress
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SASL_BIND_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SASL_BIND_IN_PROGRESS", -1);

    /**
     * Size Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SIZE_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SIZE_LIMIT_EXCEEDED", -1);

    /**
     * Sort Control Missing
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SORT_CONTROL_MISSING =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SORT_CONTROL_MISSING", -1);

    /**
     * Strong Authentication Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_STRONG_AUTH_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_STRONG_AUTH_REQUIRED", -1);

    /**
     * Success
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_SUCCESS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_SUCCESS", -1);

    /**
     * Time Limit Exceeded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_TIME_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_TIME_LIMIT_EXCEEDED", -1);

    /**
     * Too Late
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_TOO_LATE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_TOO_LATE", -1);

    /**
     * Unavailable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNAVAILABLE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNAVAILABLE", -1);

    /**
     * Unavailable Critical Extension
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNAVAILABLE_CRITICAL_EXTENSION =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNAVAILABLE_CRITICAL_EXTENSION", -1);

    /**
     * Undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNDEFINED", -1);

    /**
     * Undefined Attribute Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNDEFINED_ATTRIBUTE_TYPE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNDEFINED_ATTRIBUTE_TYPE", -1);

    /**
     * Unwilling to Perform
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_UNWILLING_TO_PERFORM =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_UNWILLING_TO_PERFORM", -1);

    /**
     * Virtual List View Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESULT_VIRTUAL_LIST_VIEW_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_RESULT_VIRTUAL_LIST_VIEW_ERROR", -1);

    /**
     * An unsupported or unexpected callback was provided to the SASL server for use during %s authentication:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_SASL_UNSUPPORTED_CALLBACK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "INFO_SASL_UNSUPPORTED_CALLBACK", -1);

    /**
     * Unable to process the provided server-side sort request control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_CANNOT_DECODE_VALUE", -1);

    /**
     * Unable to process the provided server-side sort request control because it did not contain any sort keys
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTREQ_CONTROL_NO_SORT_KEYS =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_SORT_KEYS", -1);

    /**
     * Unable to decode the provided control as a server-side sort request control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTREQ_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_VALUE", -1);

    /**
     * Unable to process the provided server-side sort response control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTRES_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_SORTRES_CONTROL_CANNOT_DECODE_VALUE", -1);

    /**
     * Unable to decode the provided control as a server-side sort response control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTRES_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_SORTRES_CONTROL_NO_VALUE", -1);

    /**
     * Unable to process the provided VLV request control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVREQ_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_CANNOT_DECODE_VALUE", -1);

    /**
     * Unable to decode the provided control as a VLV request control because the target element type %s is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVREQ_CONTROL_INVALID_TARGET_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_INVALID_TARGET_TYPE", -1);

    /**
     * Unable to decode the provided control as a VLV request control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLVREQ_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_NO_VALUE", -1);

    /**
     * Unable to process the provided VLV response control because an error occurred while attempting to decode the control value:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVRES_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "INFO_VLVRES_CONTROL_CANNOT_DECODE_VALUE", -1);

    /**
     * Unable to decode the provided control as a VLV response control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLVRES_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "INFO_VLVRES_CONTROL_NO_VALUE", -1);

    /**
     * The connection attempt to server %s has failed because the connection timeout period of %d ms was exceeded
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> LDAP_CONNECTION_CONNECT_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "LDAP_CONNECTION_CONNECT_TIMEOUT", -1);

    /**
     * Connection factory '%s' is no longer operational: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> LOAD_BALANCER_EVENT_LISTENER_LOG_OFFLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "LOAD_BALANCER_EVENT_LISTENER_LOG_OFFLINE", -1);

    /**
     * Connection factory '%s' is now operational
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> LOAD_BALANCER_EVENT_LISTENER_LOG_ONLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "LOAD_BALANCER_EVENT_LISTENER_LOG_ONLINE", -1);

    /**
     * The entry "%s" could not be added because there is already an entry with the same name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REJECTED_CHANGE_FAIL_ADD_DUPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "REJECTED_CHANGE_FAIL_ADD_DUPE", -1);

    /**
     * The entry "%s" could not be deleted because the entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REJECTED_CHANGE_FAIL_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "REJECTED_CHANGE_FAIL_DELETE", -1);

    /**
     * The entry "%s" could not be modified because the entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REJECTED_CHANGE_FAIL_MODIFY =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "REJECTED_CHANGE_FAIL_MODIFY", -1);

    /**
     * The entry "%s" could not be renamed because the entry does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REJECTED_CHANGE_FAIL_MODIFYDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "REJECTED_CHANGE_FAIL_MODIFYDN", -1);

    /**
     * The entry "%s" could not be renamed because there is already an entry with the same name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REJECTED_CHANGE_FAIL_MODIFYDN_DUPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "REJECTED_CHANGE_FAIL_MODIFYDN_DUPE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because more than one time units are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_CONFLICTING_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_CONFLICTING_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for DD (day of month) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_DAY_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_DAY_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for h (hour) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_HOUR_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_HOUR_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for m (minute) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_MINUTE_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_MINUTE_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for MM (month) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_MONTH_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_MONTH_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for s (second) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_SECOND_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_SECOND_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because there is conflicting value "%d" for YYYY (year) specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_DUPLICATE_YEAR_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_DUPLICATE_YEAR_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid day specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_DAY_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_DAY_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid hour specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_HOUR_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_HOUR_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid minute specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_MINUTE_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_MINUTE_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid month specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_MONTH_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_MONTH_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because the character '%c' is not allowed. The acceptable values are s (second), m (minute), h (hour), D (date), M (month) and Y (year)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> WARN_ATTR_INVALID_PARTIAL_TIME_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_PARTIAL_TIME_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because the character '%c' is not allowed. The acceptable values are s (second), m (minute), h (hour), d (day) and w (week)
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Character> WARN_ATTR_INVALID_RELATIVE_TIME_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Character>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_RELATIVE_TIME_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid second specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_SECOND_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_SECOND_ASSERTION_FORMAT", -1);

    /**
     * The provided value "%s" could not be parsed as a valid assertion value because "%d" is not a valid year specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_INVALID_YEAR_ASSERTION_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_INVALID_YEAR_ASSERTION_FORMAT", -1);

    /**
     * The definition for attribute type %s is invalid because it is declared COLLECTIVE but does not have a usage of userApplications
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_ATTRTYPE_COLLECTIVE_IS_OPERATIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_COLLECTIVE_IS_OPERATIONAL", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute type description because it declared that it should have an attribute usage of %s. This is an invalid usage
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_ATTRIBUTE_USAGE1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_ATTRIBUTE_USAGE1", -1);

    /**
     * The definition for the attribute type "%s" declared a superior type "%s" which has been removed from the schema because it is invalid
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_SUPERIOR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_SUPERIOR_TYPE", -1);

    /**
     * The definition for attribute type %s is invalid because its attribute usage %s is not the same as the usage for its superior type %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_SUPERIOR_USAGE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_INVALID_SUPERIOR_USAGE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid attribute type description because it does not declare a syntax nor a superior type. Attribute type descriptions must declare a superior type or a syntax
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_ATTRTYPE_MISSING_SYNTAX_AND_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_MISSING_SYNTAX_AND_SUPERIOR", -1);

    /**
     * The definition for attribute type %s is invalid because it is not defined as a collective type but the superior type %s is collective
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_NONCOLLECTIVE_FROM_COLLECTIVE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_NONCOLLECTIVE_FROM_COLLECTIVE", -1);

    /**
     * The definition for attribute type %s is invalid because it is declared NO-USER-MODIFICATION but does not have an operational usage
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_ATTRTYPE_NO_USER_MOD_NOT_OPERATIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_NO_USER_MOD_NOT_OPERATIONAL", -1);

    /**
     * The definition for the attribute type "%s" declared that approximate matching should be performed using the matching rule "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_APPROXIMATE_MR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_APPROXIMATE_MR1", -1);

    /**
     * The definition for the attribute type "%s" declared that equality matching should be performed using the matching rule "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_EQUALITY_MR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_EQUALITY_MR1", -1);

    /**
     * The definition for the attribute type "%s" declared that ordering matching should be performed using the matching rule "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_ORDERING_MR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_ORDERING_MR1", -1);

    /**
     * The definition for the attribute type "%s" declared that substring matching should be performed using the matching rule "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_SUBSTRING_MR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_SUBSTRING_MR1", -1);

    /**
     * The definition for the attribute type "%s" declared a superior type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_SUPERIOR_TYPE1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ATTRTYPE_UNKNOWN_SUPERIOR_TYPE1", -1);

    /**
     * The provided value "%s" is not a valid bit string because '%s' is not a valid binary digit
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_BIT_STRING_INVALID_BIT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_BIT_STRING_INVALID_BIT", -1);

    /**
     * The provided value "%s" is not a valid bit string because it is not surrounded by single quotes and followed by a capital letter B
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_BIT_STRING_NOT_QUOTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_BIT_STRING_NOT_QUOTED", -1);

    /**
     * The provided value "%s" is too short to be a valid bit string.  A bit string must be a series of binary digits surrounded by single quotes and followed by a capital letter B
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_BIT_STRING_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_BIT_STRING_TOO_SHORT", -1);

    /**
     * The provided value %s is not a valid generalized time value because it does not contain at least one digit after the period to use as the fractional component
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_EMPTY_FRACTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_EMPTY_FRACTION", -1);

    /**
     * The provided value %s is not a valid generalized time value because it contains illegal character %s in the fraction component
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_FRACTION_CHAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_FRACTION_CHAR", -1);

    /**
     * The provided value %s is not a valid generalized time value because it represents an invalid time (e.g., a date that does not exist):  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_TIME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_ILLEGAL_TIME", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because it contains an invalid character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_CHAR", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid day specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_DAY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_DAY", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid hour specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_HOUR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_HOUR", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid minute specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MINUTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MINUTE", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid month specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MONTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_MONTH", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid GMT offset
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_OFFSET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_OFFSET", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because "%s" is not a valid second specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_SECOND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_SECOND", -1);

    /**
     * The provided value "%s" is not a valid generalized time value because the '%s' character is not allowed in the century or year specification
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_YEAR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_INVALID_YEAR", -1);

    /**
     * The provided value %s is not a valid generalized time value because it does not end with 'Z' or a time zone offset
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_NO_TIME_ZONE_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_NO_TIME_ZONE_INFO", -1);

    /**
     * The provided value "%s" is too short to be a valid generalized time value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_GENERALIZED_TIME_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_GENERALIZED_TIME_TOO_SHORT", -1);

    /**
     * The provided value "%s" cannot be parsed as a valid IA5 string because it contains an illegal character "%s" that is not allowed in the IA5 (ASCII) character set
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_IA5_ILLEGAL_CHARACTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_IA5_ILLEGAL_CHARACTER", -1);

    /**
     * The provided value "%s" is not allowed for attributes with a Boolean syntax.  The only allowed values are 'TRUE' and 'FALSE'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_ILLEGAL_BOOLEAN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ILLEGAL_BOOLEAN", -1);

    /**
     * The provided value %s is not allowed for attributes with a Integer syntax
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_ILLEGAL_INTEGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_ILLEGAL_INTEGER", -1);

    /**
     * The provided value "%s" could not be parsed as a valid integer because it contained only a dash not followed by an integer value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_INTEGER_DASH_NEEDS_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_INTEGER_DASH_NEEDS_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid integer because it did not contain any digits
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_INTEGER_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_INTEGER_EMPTY_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as a valid integer because the first digit may not be zero unless it is the only digit
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_INTEGER_INITIAL_ZERO =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_INTEGER_INITIAL_ZERO", -1);

    /**
     * The provided value "%s" could not be parsed as a valid integer because character '%c' at position %d is not allowed in an integer value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> WARN_ATTR_SYNTAX_INTEGER_INVALID_CHARACTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_INTEGER_INVALID_CHARACTER", -1);

    /**
     * The provided value "%s" cannot be parsed as an enumeration syntax  because it contains a duplicate value "%s" at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_DUPLICATE_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_DUPLICATE_VALUE", -1);

    /**
     * The provided value "%s" cannot be parsed because it is not allowed by enumeration syntax with OID "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_INVALID_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_ENUM_INVALID_VALUE", -1);

    /**
     * The definition for the syntax with OID "%s" could not be parsed as a regex syntax because the provided regex pattern "%s" is invalid
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_PATTERN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_PATTERN", -1);

    /**
     * The provided value "%s" cannot be parsed as a valid regex syntax because it does not match  the pattern "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_LDAPSYNTAX_REGEX_INVALID_VALUE", -1);

    /**
     * The "%s" syntax with OID %s is not implemented. It will be substituted by the default syntax with OID %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ATTR_SYNTAX_NOT_IMPLEMENTED1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_NOT_IMPLEMENTED1", -1);

    /**
     * The provided value "%s" is not a valid numeric string because it contained character %s at position %d that was neither a digit nor a space
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_NUMERIC_STRING_ILLEGAL_CHAR =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_NUMERIC_STRING_ILLEGAL_CHAR", -1);

    /**
     * The definition for the object class "%s" declared a superior object class "%s" which has been removed from the schema because it is invalid
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_CLASS", -1);

    /**
     * The object class "%s" is invalid because it has an object class type of %s which is incompatible with the object class type %s specified by the superior object class "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_TYPE1 =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_INVALID_SUPERIOR_TYPE1", -1);

    /**
     * The object class "%s" is invalid because it is defined as a structural class but its superior chain does not include the "top" object class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_OBJECTCLASS_STRUCTURAL_SUPERIOR_NOT_TOP1 =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_STRUCTURAL_SUPERIOR_NOT_TOP1", -1);

    /**
     * The object class "%s" specifies the optional attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_OPTIONAL_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_OPTIONAL_ATTR1", -1);

    /**
     * The object class "%s" specifies the required attribute type "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_REQUIRED_ATTR1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_REQUIRED_ATTR1", -1);

    /**
     * The object class "%s" specifies the superior object class "%s" which is not defined in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_SUPERIOR_CLASS1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_OBJECTCLASS_UNKNOWN_SUPERIOR_CLASS1", -1);

    /**
     * The provided value could not be parsed as a printable string because it was null or empty.  A printable string must contain at least one character
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_ATTR_SYNTAX_PRINTABLE_STRING_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_PRINTABLE_STRING_EMPTY_VALUE", -1);

    /**
     * The provided value "%s" could not be parsed as a printable string because it contained an invalid character %s at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> WARN_ATTR_SYNTAX_PRINTABLE_STRING_ILLEGAL_CHARACTER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_PRINTABLE_STRING_ILLEGAL_CHARACTER", -1);

    /**
     * The provided value "%s" could not be parsed as a substring assertion because it contains consecutive wildcard characters at position %d and zero-length substrings are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_SYNTAX_SUBSTRING_CONSECUTIVE_WILDCARDS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_SUBSTRING_CONSECUTIVE_WILDCARDS", -1);

    /**
     * The provided value could not be parsed as a substring assertion because it is zero-length
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_ATTR_SYNTAX_SUBSTRING_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_SUBSTRING_EMPTY", -1);

    /**
     * The provided value "%s" could not be parsed as a substring assertion because it does not contain any wildcard characters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_SYNTAX_SUBSTRING_NO_WILDCARDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_SUBSTRING_NO_WILDCARDS", -1);

    /**
     * The provided value "*" could not be parsed as a substring assertion because it consists only of a wildcard character and zero-length substrings are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_ATTR_SYNTAX_SUBSTRING_ONLY_WILDCARD =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_SUBSTRING_ONLY_WILDCARD", -1);

    /**
     * The provided value "%s" should have had a dash at position %d, but the character '%s' was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> WARN_ATTR_SYNTAX_UUID_EXPECTED_DASH =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_UUID_EXPECTED_DASH", -1);

    /**
     * The provided value "%s" should have had a hexadecimal digit at position %d, but the character '%s' was found instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> WARN_ATTR_SYNTAX_UUID_EXPECTED_HEX =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_UUID_EXPECTED_HEX", -1);

    /**
     * The provided value "%s" has an invalid length for a UUID.  All UUID values must have a length of exactly 36 bytes, but the provided value had a length of %d bytes
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ATTR_SYNTAX_UUID_INVALID_LENGTH =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ATTR_SYNTAX_UUID_INVALID_LENGTH", -1);

    /**
     * The following attribute types share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with attribute type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_ATTR_TYPES_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPES_DUPLICATED_NAME", -1);

    /**
     * Multiple attribute types with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_TYPE_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPE_AMBIGUOUS", -1);

    /**
     * The attribute type "%s" specifies the matching rule "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_TYPE_HAS_OBSOLETE_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPE_HAS_OBSOLETE_MR", -1);

    /**
     * The attribute type "%s" specifies the superior type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ATTR_TYPE_HAS_OBSOLETE_SUPERIOR_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPE_HAS_OBSOLETE_SUPERIOR_TYPE", -1);

    /**
     * The definition for the attribute type "%s" declared that it should use the syntax "%s" which is not defined in the schema. The default syntax "%s" will be used instead
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ATTR_TYPE_NOT_DEFINED1 =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPE_NOT_DEFINED1", -1);

    /**
     * No attribute type with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ATTR_TYPE_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_ATTR_TYPE_UNKNOWN", -1);

    /**
     * The following object classes share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with object class "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_CLASSES_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_CLASSES_DUPLICATED_NAME", -1);

    /**
     * The operation was rejected because there is already another request on the same client connection with the same message ID of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_CLIENT_DUPLICATE_MESSAGE_ID =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "WARN_CLIENT_DUPLICATE_MESSAGE_ID", -1);

    /**
     * Multiple DIT content rules with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_DCR_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_DCR_AMBIGUOUS", -1);

    /**
     * No DIT content rule with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_DCR_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_DCR_UNKNOWN", -1);

    /**
     * An error occurred while decoding an affinity control: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_DECODING_AFFINITY_CONTROL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_DECODING_AFFINITY_CONTROL", -1);

    /**
     * The following DIT content rules share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with DIT content rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_DIT_CR_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_DUPLICATED_NAME", -1);

    /**
     * The DIT content rule "%s" specifies the auxiliary object class "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_CR_HAS_OBSOLETE_AUXILIARY_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_HAS_OBSOLETE_AUXILIARY_CLASS", -1);

    /**
     * The DIT content rule "%s" specifies the optional attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_CR_HAS_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_HAS_OBSOLETE_OPTIONAL_ATTR", -1);

    /**
     * The DIT content rule "%s" specifies the prohibited attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_CR_HAS_OBSOLETE_PROHIBITED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_HAS_OBSOLETE_PROHIBITED_ATTR", -1);

    /**
     * The DIT content rule "%s" specifies the required attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_CR_HAS_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_HAS_OBSOLETE_REQUIRED_ATTR", -1);

    /**
     * The DIT content rule "%s" specifies the structural object class "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_CR_HAS_OBSOLETE_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_CR_HAS_OBSOLETE_STRUCTURAL_CLASS", -1);

    /**
     * The following DIT structure rules share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with DIT structure rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_DIT_SR_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_SR_DUPLICATED_NAME", -1);

    /**
     * The DIT structure rule "%s" specifies the name form "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_SR_HAS_OBSOLETE_NAME_FORM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_SR_HAS_OBSOLETE_NAME_FORM", -1);

    /**
     * The DIT structure rule "%s" specifies the superior rule "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_DIT_SR_HAS_OBSOLETE_SUPERIOR_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_DIT_SR_HAS_OBSOLETE_SUPERIOR_RULE", -1);

    /**
     * No DIT structure rule with name "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_DIT_SR_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_DIT_SR_UNKNOWN", -1);

    /**
     * No DIT structure rule with ID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_DSR_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_DSR_UNKNOWN", -1);

    /**
     * The value pattern for line %d of the template file in the definition for %s %s is empty
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Object, Object> WARN_ENTRY_GENERATOR_NO_VALUE_IN_TEMPLATE_LINE =
                    new LocalizableMessageDescriptor.Arg3<Number, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ENTRY_GENERATOR_NO_VALUE_IN_TEMPLATE_LINE", -1);

    /**
     * Subordinate template definition on line %d for %s %s specifies that zero entries of type %s should be generated
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object> WARN_ENTRY_GENERATOR_SUBORDINATE_ZERO_ENTRIES =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_ENTRY_GENERATOR_SUBORDINATE_ZERO_ENTRIES", -1);

    /**
     * The list tag on line %d of the template file contains item '%s' that includes a semicolon but that semicolon is not followed by an integer.  The semicolon will be assumed to be part of the value and not a delimiter to separate the value from its relative weight
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> WARN_ENTRY_GENERATOR_TAG_LIST_INVALID_WEIGHT =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(CoreMessages.class, RESOURCE, "WARN_ENTRY_GENERATOR_TAG_LIST_INVALID_WEIGHT", -1);

    /**
     * The value generated from the random tag on line %d of the template file will always be an empty string
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_ENTRY_GENERATOR_TAG_WARNING_EMPTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "WARN_ENTRY_GENERATOR_TAG_WARNING_EMPTY_VALUE", -1);

    /**
     * Possible reference to an undefined constant '%s' on line %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ENTRY_GENERATOR_WARNING_UNDEFINED_CONSTANT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(CoreMessages.class, RESOURCE, "WARN_ENTRY_GENERATOR_WARNING_UNDEFINED_CONSTANT", -1);

    /**
     * The GSER value does not contain a valid IdentifiedChoiceValue at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_NO_VALID_IDENTIFIEDCHOICE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_NO_VALID_IDENTIFIEDCHOICE", -1);

    /**
     * The GSER value does not contain a valid identifier at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_NO_VALID_IDENTIFIER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_NO_VALID_IDENTIFIER", -1);

    /**
     * The GSER value does not contain a valid integer value at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_NO_VALID_INTEGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_NO_VALID_INTEGER", -1);

    /**
     * The GSER value does not contain a separator at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_NO_VALID_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_NO_VALID_SEPARATOR", -1);

    /**
     * The GSER value does not contain a valid String value at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_NO_VALID_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_NO_VALID_STRING", -1);

    /**
     * The GSER value does not contain a String matching the pattern %s at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_GSER_PATTERN_NO_MATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_GSER_PATTERN_NO_MATCH", -1);

    /**
     * The GSER value does not contain a whitespace character at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_GSER_SPACE_CHAR_EXPECTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_GSER_SPACE_CHAR_EXPECTED", -1);

    /**
     * Rejecting the LDIF change record starting at line %d with distinguished name "%s" because it includes a duplicate attribute "%s" with value "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object> WARN_LDIF_DUPLICATE_ATTRIBUTE_VALUE =
                    new LocalizableMessageDescriptor.Arg4<Number, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_LDIF_DUPLICATE_ATTRIBUTE_VALUE", -1);

    /**
     * The following matching rules share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with matching rule "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_MATCHING_RULES_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_MATCHING_RULES_DUPLICATED_NAME", -1);

    /**
     * No implementation found for the matching rule "%s". The default matching rule "%s" will be used instead
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_MATCHING_RULE_NOT_IMPLEMENTED1 =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_MATCHING_RULE_NOT_IMPLEMENTED1", -1);

    /**
     * The following matching rule uses share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with matching rule use "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_MATCHING_RULE_USES_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_MATCHING_RULE_USES_DUPLICATED_NAME", -1);

    /**
     * The matching rule use "%s" specifies the attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_MATCHING_RULE_USE_HAS_OBSOLETE_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_MATCHING_RULE_USE_HAS_OBSOLETE_ATTR", -1);

    /**
     * The matching rule use "%s" specifies the matching rule "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_MATCHING_RULE_USE_HAS_OBSOLETE_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_MATCHING_RULE_USE_HAS_OBSOLETE_MATCHING_RULE", -1);

    /**
     * Multiple matching rule uses with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_MRU_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_MRU_AMBIGUOUS", -1);

    /**
     * No matching rule use with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_MRU_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_MRU_UNKNOWN", -1);

    /**
     * Multiple matching rules with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_MR_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_MR_AMBIGUOUS", -1);

    /**
     * No matching rule with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_MR_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_MR_UNKNOWN", -1);

    /**
     * Multiple name forms with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_NAMEFORM_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_NAMEFORM_AMBIGUOUS", -1);

    /**
     * No name form with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_NAMEFORM_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_NAMEFORM_UNKNOWN", -1);

    /**
     * Multiple OID with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_NAME_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_NAME_AMBIGUOUS", -1);

    /**
     * The following name forms share the name "%s": %s. To avoid ambiguity the name "%s" will only be associated with name form "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_NAME_FORMS_DUPLICATED_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CoreMessages.class, RESOURCE, "WARN_NAME_FORMS_DUPLICATED_NAME", -1);

    /**
     * The name form "%s" specifies the optional attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_NAME_FORM_HAS_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_NAME_FORM_HAS_OBSOLETE_OPTIONAL_ATTR", -1);

    /**
     * The name form "%s" specifies the required attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_NAME_FORM_HAS_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_NAME_FORM_HAS_OBSOLETE_REQUIRED_ATTR", -1);

    /**
     * The name form "%s" specifies the structural object class "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_NAME_FORM_HAS_OBSOLETE_STRUCTURAL_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_NAME_FORM_HAS_OBSOLETE_STRUCTURAL_CLASS", -1);

    /**
     * Multiple object classes with name %s exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_OBJECTCLASS_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_OBJECTCLASS_AMBIGUOUS", -1);

    /**
     * The object class "%s" specifies the optional attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_OBJECTCLASS_HAS_OBSOLETE_OPTIONAL_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_OBJECTCLASS_HAS_OBSOLETE_OPTIONAL_ATTR", -1);

    /**
     * The object class "%s" specifies the required attribute type "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_OBJECTCLASS_HAS_OBSOLETE_REQUIRED_ATTR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_OBJECTCLASS_HAS_OBSOLETE_REQUIRED_ATTR", -1);

    /**
     * The object class "%s" specifies the superior object class "%s" which is marked as OBSOLETE in the schema
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_OBJECTCLASS_HAS_OBSOLETE_SUPERIOR_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CoreMessages.class, RESOURCE, "WARN_OBJECTCLASS_HAS_OBSOLETE_SUPERIOR_CLASS", -1);

    /**
     * No object class with name or OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_OBJECTCLASS_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_OBJECTCLASS_UNKNOWN", -1);

    /**
     * The provided LDIF content contained %d entries, when only one was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_READ_LDIF_ENTRY_MULTIPLE_ENTRIES_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Number>(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_ENTRY_MULTIPLE_ENTRIES_FOUND", -1);

    /**
     * The provided LDIF content did not contain any entry
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_READ_LDIF_ENTRY_NO_ENTRY_FOUND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_ENTRY_NO_ENTRY_FOUND", -1);

    /**
     * The provided LDIF content did not contain an "%s" change record
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_READ_LDIF_RECORD_CHANGE_RECORD_WRONG_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_RECORD_CHANGE_RECORD_WRONG_TYPE", -1);

    /**
     * The provided LDIF content contained multiple LDIF change records, when only one was expected
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_READ_LDIF_RECORD_MULTIPLE_CHANGE_RECORDS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_RECORD_MULTIPLE_CHANGE_RECORDS_FOUND", -1);

    /**
     * The provided LDIF content did not contain any LDIF change records
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_READ_LDIF_RECORD_NO_CHANGE_RECORD_FOUND =
                    new LocalizableMessageDescriptor.Arg0(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_RECORD_NO_CHANGE_RECORD_FOUND", -1);

    /**
     * An unexpected IO error occurred while reading the provided LDIF content: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_READ_LDIF_RECORD_UNEXPECTED_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_READ_LDIF_RECORD_UNEXPECTED_IO_ERROR", -1);

    /**
     * No syntax with OID "%s" exists in the schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_SYNTAX_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CoreMessages.class, RESOURCE, "WARN_SYNTAX_UNKNOWN", -1);

}
