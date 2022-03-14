package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.access_control}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/access_control.properties} and it should not be manually edited.
 */
public final class AccessControlMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.access_control";

    // Prevent instantiation.
    private AccessControlMessages() {
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
     * The provided string "%s" could not be parsed as a valid Access Control Instruction (ACI) because it failed general ACI syntax evaluation
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_GENERAL_PARSE_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_GENERAL_PARSE_FAILED_1", 1);

    /**
     * The provided Access Control Instruction (ACI) version value "%s" is invalid, only the version 3.0 is supported
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVAILD_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVAILD_VERSION_2", 2);

    /**
     * The provided Access Control Instruction access type value "%s" is invalid. A valid access type value is either allow or deny
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_ACCESS_TYPE_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_ACCESS_TYPE_VERSION_3", 3);

    /**
     * The provided Access Control Instruction (ACI) rights values "%s" are invalid. The rights must be a list of 1 to 6 comma-separated keywords enclosed in parentheses
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_RIGHTS_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_RIGHTS_SYNTAX_4", 4);

    /**
     * The provided Access Control Instruction (ACI) rights keyword values "%s" are invalid. The valid rights keyword values are one or more of the following: read, write, add, delete, search, compare or the single value all
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_RIGHTS_KEYWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_RIGHTS_KEYWORD_5", 5);

    /**
     * The provided Access Control Instruction (ACI) bind rule value "%s" is invalid because it is missing a close parenthesis that corresponded to the initial open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_BIND_RULE_MISSING_CLOSE_PAREN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_BIND_RULE_MISSING_CLOSE_PAREN_6", 6);

    /**
     * The provided Access Control Instruction (ACI) bind rule value "%s" is invalid. A valid bind rule value must be in the following form: keyword operator "expression"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_BIND_RULE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_BIND_RULE_SYNTAX_7", 7);

    /**
     * The provided Access Control Instruction (ACI) bind rule keyword value "%s" is invalid. A valid keyword value is one of the following: userdn, groupdn, roledn, userattr,ip, dns, dayofweek, timeofday or authmethod
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_BIND_RULE_KEYWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_BIND_RULE_KEYWORD_8", 8);

    /**
     * The provided Access Control Instruction (ACI) bind rule operator value "%s" is invalid. A valid bind rule operator value is either '=' or "!="
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_BIND_RULE_OPERATOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_BIND_RULE_OPERATOR_9", 9);

    /**
     * The provided Access Control Instruction (ACI) bind rule expression value corresponding to the keyword value "%s" is missing an expression. A valid bind rule value must be in the following form: keyword operator "expression"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_MISSING_BIND_RULE_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_MISSING_BIND_RULE_EXPRESSION_10", 10);

    /**
     * The provided Access Control Instruction (ACI) bind rule boolean operator value "%s" is invalid. A valid bind rule boolean operator value is either "OR" or "AND"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_BIND_RULE_BOOLEAN_OPERATOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_BIND_RULE_BOOLEAN_OPERATOR_11", 11);

    /**
     * The provided Access Control Instruction (ACI) bind rule keyword string "%s" is invalid for the bind rule operator string "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_BIND_RULE_KEYWORD_OPERATOR_COMBO =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_BIND_RULE_KEYWORD_OPERATOR_COMBO_12", 12);

    /**
     * The provided Access Control Instruction (ACI) bind rule userdn expression failed to URL decode for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERDN_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERDN_URL_13", 13);

    /**
     * The provided Access Control Instruction (ACI) bind rule groupdn expression value "%s" is invalid. A valid groupdn keyword expression value requires one or more LDAP URLs in the following format: ldap:///groupdn [|| ldap:///groupdn] ... [|| ldap:///groupdn]
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_GROUPDN_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_GROUPDN_EXPRESSION_16", 16);

    /**
     * The provided Access Control Instruction (ACI) bind rule groupdn expression value failed to URL decode for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_GROUPDN_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_GROUPDN_URL_17", 17);

    /**
     * The provided Access Control Instruction (ACI) bind rule ip expression value "%s" is invalid. A valid ip keyword expression requires one or more comma-separated elements of a valid IP address list expression
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_IP_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_IP_EXPRESSION_21", 21);

    /**
     * The provided Access Control Instruction (ACI) bind rule dns expression value "%s" is invalid. A valid dns keyword expression value requires a valid fully qualified DNS domain name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_DNS_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_DNS_EXPRESSION_22", 22);

    /**
     * The provided Access Control Instruction (ACI) bind rule dns expression value "%s" is invalid, because a wild-card pattern was found in the wrong position. A valid dns keyword wild-card expression value requires the '*' character only be in the leftmost position of the domain name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_DNS_WILDCARD =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_DNS_WILDCARD_23", 23);

    /**
     * The provided Access Control Instruction (ACI) bind rule dayofweek expression value "%s" is invalid, because of an invalid day of week value. A valid dayofweek value is one of the following English three-letter abbreviations for the days of the week: sun, mon, tue, wed, thu, fri, or sat
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_DAYOFWEEK =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_DAYOFWEEK_24", 24);

    /**
     * The provided Access Control Instruction (ACI) bind rule timeofday expression value "%s" is invalid. A valid timeofday value is expressed as four digits representing hours and minutes in the 24-hour clock (0 to 2359)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TIMEOFDAY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TIMEOFDAY_25", 25);

    /**
     * The provided Access Control Instruction (ACI) bind rule timeofday expression value "%s" is not in the valid range. A valid timeofday value is expressed as four digits representing hours and minutes in the 24-hour clock (0 to 2359)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TIMEOFDAY_RANGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TIMEOFDAY_RANGE_26", 26);

    /**
     * The provided Access Control Instruction (ACI) bind rule authmethod expression value "%s" is invalid. A valid authmethod value is one of the following: none, simple,SSL, or "sasl mechanism", where mechanism is one of the supported SASL mechanisms including CRAM-MD5, DIGEST-MD5, and GSSAPI
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_AUTHMETHOD_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_AUTHMETHOD_EXPRESSION_27", 27);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression value "%s" is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_EXPRESSION_28", 28);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression inheritance pattern value "%s" is invalid. A valid inheritance pattern value must have the following format: parent[inheritance_level].attribute#bindType
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_INHERITANCE_PATTERN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_INHERITANCE_PATTERN_30", 30);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression inheritance pattern value "%s" is invalid. The inheritance level value cannot exceed the max level limit of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_MAX_USERATTR_INHERITANCE_LEVEL_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_MAX_USERATTR_INHERITANCE_LEVEL_EXCEEDED_31", 31);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression inheritance pattern value "%s" is invalid because it is non-numeric
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_INHERITANCE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_INHERITANCE_VALUE_32", 32);

    /**
     * The provided Access Control Instruction (ACI) target rule value "%s" is invalid. A valid target rule value must be in the following form: keyword operator "expression"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGET_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGET_SYNTAX_33", 33);

    /**
     * The provided Access Control Instruction (ACI) target keyword value "%s" is invalid. A valid target keyword value is one of the following: target, targetscope, targetfilter, targetattr or targattrfilters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGET_KEYWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGET_KEYWORD_34", 34);

    /**
     * The provided Access Control Instruction (ACI) target operator value "%s" is invalid. The only valid target operator value for the "%s" keyword is '='
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_TARGET_NOT_OPERATOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGET_NOT_OPERATOR_35", 35);

    /**
     * The provided Access Control Instruction (ACI) target keyword value "%s" was seen multiple times in the ACI "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_TARGET_DUPLICATE_KEYWORDS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGET_DUPLICATE_KEYWORDS_37", 37);

    /**
     * The provided Access Control Instruction (ACI) target keyword operator value "%s" is invalid. A valid target keyword operator value is either '=' or "!="
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETS_OPERATOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETS_OPERATOR_38", 38);

    /**
     * The provided Access Control Instruction (ACI) targetscope expression operator value "%s" is invalid. A valid targetscope expression value is one of the following: one, onelevel, subtree or subordinate
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETSCOPE_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETSCOPE_EXPRESSION_39", 39);

    /**
     * The provided Access Control Instruction (ACI) target expression value "%s" is invalid. A valid target keyword expression value requires a LDAP URL in the following format: ldap:///distinguished_name_pattern
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETKEYWORD_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETKEYWORD_EXPRESSION_40", 40);

    /**
     * The provided Access Control Instruction (ACI) target expression DN value "%s" is invalid. The target expression DN value must be a descendant of the ACI entry DN "%s", if no wild-card is specified in the target expression DN
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_TARGET_DN_NOT_DESCENDENTOF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_TARGET_DN_NOT_DESCENDENTOF_41", 41);

    /**
     * The provided Access Control Instruction (ACI) targetattr expression value "%s" is invalid. A valid targetattr keyword expression value requires one or more valid attribute type names in the following format: attribute1 [|| attribute2] ... [|| attributeN]. Attribute options are not supported
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETATTRKEYWORD_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETATTRKEYWORD_EXPRESSION_42", 42);

    /**
     * The provided Access Control Instruction (ACI) targetfilter expression value "%s" is invalid because it is not a valid LDAP filter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETFILTERKEYWORD_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETFILTERKEYWORD_EXPRESSION_43", 43);

    /**
     * An attempt to add the entry "%s" containing an aci attribute type failed, because the authorization DN "%s" lacked modify-acl privileges
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ACI_ADD_FAILED_PRIVILEGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "INFO_ACI_ADD_FAILED_PRIVILEGE_44", 44);

    /**
     * An attempt to modify an aci attribute type in the entry "%s" failed, because the authorization DN "%s" lacked modify-acl privileges
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ACI_MODIFY_FAILED_PRIVILEGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "INFO_ACI_MODIFY_FAILED_PRIVILEGE_45", 45);

    /**
     * An attempt to add the entry "%s" containing an aci attribute type failed because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_ADD_FAILED_DECODE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_ADD_FAILED_DECODE_46", 46);

    /**
     * An attempt to modify an aci attribute type in the entry "%s" failed because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_MODIFY_FAILED_DECODE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_MODIFY_FAILED_DECODE_47", 47);

    /**
     * "%s", located in the entry "%s", because of the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ACI_ADD_LIST_FAILED_DECODE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_ADD_LIST_FAILED_DECODE_48", 48);

    /**
     * Added %s Access Control Instruction (ACI) attribute types found in context "%s" to the access control evaluation engine
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ACI_ADD_LIST_ACIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "INFO_ACI_ADD_LIST_ACIS_50", 50);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression inheritance pattern value "%s" is invalid for the roledn keyword because it starts with the string "parent["
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_ROLEDN_INHERITANCE_PATTERN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_ROLEDN_INHERITANCE_PATTERN_51", 51);

    /**
     * The provided Access Control Instruction (ACI) targattrfilter expression value %s is invalid because it is not in the correct format.A valid targattrsfilters expression value must be in the following format: "add=attr1: F1 && attr2: F2 ... && attrN: FN,del= attr1: F1 && attr2: F2 ... && attrN: FN"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_EXPRESSION_53", 53);

    /**
     * The provided Access Control Instruction (ACI) targattrfilter expression value %s is invalid because the both operation tokens match in the two filter lists
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_OPS_MATCH =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_OPS_MATCH_54", 54);

    /**
     * The provided Access Control Instruction (ACI) targattrfilters expression value %s is invalid because there are more than two filter list statements
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_MAX_FILTER_LISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_MAX_FILTER_LISTS_55", 55);

    /**
     * The provided Access Control Instruction (ACI) targattrfilters expression value %s is invalid because the provided filter list string is in the wrong format. A valid targattrfilters filter list must be in the following format: add=attr1: F1 && attr2: F2 ... && attrN: FN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LIST_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LIST_FORMAT_56", 56);

    /**
     * The provided Access Control Instruction (ACI) targattrfilters expression value %s is invalid because one or more of the specified filters are invalid for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LISTS_FILTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LISTS_FILTER_57", 57);

    /**
     * The provided Access Control Instruction (ACI) targattrfilters expression value %s is invalid because one or more of the specified filters are invalid because of non-matching attribute type names in the filter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LISTS_ATTR_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGATTRFILTERS_FILTER_LISTS_ATTR_FILTER_58", 58);

    /**
     * The provided Access Control Instruction (ACI) attribute name value %s is invalid. A valid attribute type name must begin with an ASCII letter and must contain only ASCII letters,digits or the "-" character
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_ATTRIBUTE_TYPE_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_ATTRIBUTE_TYPE_NAME_59", 59);

    /**
     * The SASL mechanism "%s" provided in the Access Control Instruction (ACI) bind rule authmethod expression is not one of the currently registered mechanisms in the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_ACI_SYNTAX_DUBIOUS_AUTHMETHOD_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "NOTE_ACI_SYNTAX_DUBIOUS_AUTHMETHOD_SASL_MECHANISM_60", 60);

    /**
     * The provided Access Control Instruction (ACI) bind rule dns expression value "%s" references hostname %s, but the canonical representation for that hostname is configured to be %s. The server will attempt to automatically interpret the correct localhost value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ACI_LOCALHOST_DOESNT_MATCH_CANONICAL_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_LOCALHOST_DOESNT_MATCH_CANONICAL_VALUE_61", 61);

    /**
     * The provided Access Control Instruction (ACI) bind rule dns expression value "%s" references hostname %s, which resolves to IP address %s, but the canonical hostname for that IP address is %s. This likely means that the provided hostname will never match any clients
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> WARN_ACI_HOSTNAME_DOESNT_MATCH_CANONICAL_VALUE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_HOSTNAME_DOESNT_MATCH_CANONICAL_VALUE_62", 62);

    /**
     * An error occurred while attempting to determine whether hostname %s referenced in dns expression bind rule "%s" used the correct canonical representation: %s. This likely means that the provided hostname will never match any clients
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> WARN_ACI_ERROR_CHECKING_CANONICAL_HOSTNAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_ERROR_CHECKING_CANONICAL_HOSTNAME_63", 63);

    /**
     * Added %s Global Access Control Instruction (ACI) attribute types to the access control evaluation engine
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ACI_ADD_LIST_GLOBAL_ACIS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "INFO_ACI_ADD_LIST_GLOBAL_ACIS_66", 66);

    /**
     * An unexpected error occurred while processing the ds-cfg-global-aci attribute in configuration entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ACI_HANDLER_FAIL_PROCESS_GLOBAL_ACI =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "INFO_ACI_HANDLER_FAIL_PROCESS_GLOBAL_ACI_67", 67);

    /**
     * An unexpected error occurred while processing the aci attributes in the configuration system
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ACI_HANDLER_FAIL_PROCESS_ACI =
                    new LocalizableMessageDescriptor.Arg0(AccessControlMessages.class, RESOURCE, "INFO_ACI_HANDLER_FAIL_PROCESS_ACI_68", 68);

    /**
     * The pattern DN %s is not valid because it contains two consecutive wildcards in an attribute value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_PATTERN_DN_CONSECUTIVE_WILDCARDS_IN_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_PATTERN_DN_CONSECUTIVE_WILDCARDS_IN_VALUE_69", 69);

    /**
     * The pattern DN %s is not valid because it uses wildcards for substring matching on an attribute type. A single wildcard is allowed in place of an attribute type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_PATTERN_DN_TYPE_CONTAINS_SUBSTRINGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_PATTERN_DN_TYPE_CONTAINS_SUBSTRINGS_70", 70);

    /**
     * The pattern DN %s is not valid because it contains a wildcard in an attribute type in a multi-valued RDN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_PATTERN_DN_TYPE_WILDCARD_IN_MULTIVALUED_RDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_PATTERN_DN_TYPE_WILDCARD_IN_MULTIVALUED_RDN_71", 71);

    /**
     * Selfwrite check skipped because an attribute "%s" with a distinguished name syntax was not a valid DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_NOT_VALID_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_NOT_VALID_DN_73", 73);

    /**
     * The provided Access Control Instruction (ACI) targetattr expression value "%s" is invalid because the expression contains invalid or duplicate tokens
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_TARGETATTR_INVALID_ATTR_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_TARGETATTR_INVALID_ATTR_TOKEN_74", 74);

    /**
     * The provided Access Control Instruction (ACI) expression value "%s" is invalid because it contains the roledn keyword, which is not supported, replace it with the groupdn keyword
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_ROLEDN_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_ROLEDN_NOT_SUPPORTED_75", 75);

    /**
     * Failed to decode the Access Control Instruction (ACI)%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SERVER_DECODE_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SERVER_DECODE_FAILED_76", 76);

    /**
     * The server is being put into lockdown mode because invalid ACIs rules were detected either when the server was started or during a backend initialization
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_ACI_ENTER_LOCKDOWN_MODE =
                    new LocalizableMessageDescriptor.Arg0(AccessControlMessages.class, RESOURCE, "WARN_ACI_ENTER_LOCKDOWN_MODE_77", 77);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression value failed to URL decode for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_URL_78", 78);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression value failed to parse because the ldap URL "%s" contains an empty base DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_BASEDN_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_BASEDN_URL_79", 79);

    /**
     * The provided Access Control Instruction (ACI) bind rule userattr expression value failed to parse because the attribute field of the ldap URL "%s" either contains more than one description or the field is empty
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_USERATTR_ATTR_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_USERATTR_ATTR_URL_80", 80);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the prefix part of the expression "%s" has an invalid format
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_PREFIX_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_PREFIX_FORMAT_81", 81);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the prefix value of the expression "%s" was an invalid value. All values must greater than or equal to 0 and either less than or equal 32 for IPV4 addresses or less than or equal to 128 for IPV6 addresses
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_PREFIX_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_PREFIX_VALUE_82", 82);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the prefix part of the expression "%s" has an non-numeric value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_PREFIX_NOT_NUMERIC =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_PREFIX_NOT_NUMERIC_83", 83);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the the IPv4 address expression "%s" format was invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_IPV4_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_IPV4_FORMAT_84", 84);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the IPv4 address expression "%s" contains an invalid value. All values of the address must be between 0 and 255
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_IPV4_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_IPV4_VALUE_85", 85);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the the IPv4 address expression "%s" contains a non-numeric value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_IPV4_NOT_NUMERIC =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_IPV4_NOT_NUMERIC_86", 86);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the the IPv6 address expression "%s" contains an illegal wildcard character. Wildcards are not supported when using IPv6 addresses in a IP bind rule expression
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_IPV6_WILDCARD_INVALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_IPV6_WILDCARD_INVALID_87", 87);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression "%s" failed to parse for the following reason: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_IPV6_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_IPV6_FORMAT_88", 88);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the netmask part of the expression "%s" has an invalid format
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_NETMASK_FORMAT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_NETMASK_FORMAT_89", 89);

    /**
     * The provided Access Control Instruction (ACI) bind rule IP address expression failed to parse because the netmask part of the expression "%s" has an invalid value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_NETMASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_NETMASK_90", 90);

    /**
     * The provided Access Control Instruction (ACI) targetcontrol expression value "%s" is invalid. A valid targetcontrol keyword expression value requires one or more valid control OID strings in the following format: oid [|| oid1] ... [|| oidN]
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGETCONTROL_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGETCONTROL_EXPRESSION_91", 91);

    /**
     * The provided Access Control Instruction (ACI) targetcontrol OID value "%s" could not be parsed because the value contained an illegal character %c at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Character, Number> WARN_ACI_SYNTAX_ILLEGAL_CHAR_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg3<Object, Character, Number>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_ILLEGAL_CHAR_IN_NUMERIC_OID_92", 92);

    /**
     * The provided Access Control Instruction (ACI) targetcontrol OID value "%s" could not be parsed because the numeric OID contained two consecutive periods at position %d
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> WARN_ACI_SYNTAX_DOUBLE_PERIOD_IN_NUMERIC_OID =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_DOUBLE_PERIOD_IN_NUMERIC_OID_93", 93);

    /**
     * The provided Access Control Instruction (ACI) extop expression value "%s" is invalid. A valid extop keyword expression value requires one or more valid extended operation request OID strings in the following format: oid [|| oid1] ... [|| oidN]
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_TARGEXTOP_EXPRESSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TARGEXTOP_EXPRESSION_95", 95);

    /**
     * Backend %s does not have a presence index defined for attribute type %s. Access control initialization may take a very long time to complete in this backend
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_ATTRIBUTE_NOT_INDEXED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_ATTRIBUTE_NOT_INDEXED_96", 96);

    /**
     * The provided Access Control Instruction (ACI) bind rule SSF expression "%s" failed to parse for the following reason: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_SSF_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_SSF_FORMAT_97", 97);

    /**
     * The provided Access Control Instruction (ACI) bind rule ssf expression value "%s" is not in the valid range. A valid ssf value is in the range of 1 to 1024
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ACI_SYNTAX_INVALID_SSF_RANGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_SSF_RANGE_98", 98);

    /**
     * The provided Access Control Instruction (ACI) bind rule timeofday expression "%s" failed to parse for the following reason: "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_ACI_SYNTAX_INVALID_TIMEOFDAY_FORMAT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AccessControlMessages.class, RESOURCE, "WARN_ACI_SYNTAX_INVALID_TIMEOFDAY_FORMAT_99", 99);

}
