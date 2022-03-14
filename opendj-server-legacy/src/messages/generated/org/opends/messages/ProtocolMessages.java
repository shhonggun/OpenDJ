package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.protocol}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/protocol.properties} and it should not be manually edited.
 */
public final class ProtocolMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.protocol";

    // Prevent instantiation.
    private ProtocolMessages() {
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
     * Cannot decode the provided ASN.1 sequence as an LDAP message because the sequence was null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_MESSAGE_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MESSAGE_DECODE_NULL_45", 45);

    /**
     * Cannot decode the provided ASN.1 sequence as an LDAP message because the first element of the sequence could not be decoded as an integer message ID: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MESSAGE_DECODE_MESSAGE_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MESSAGE_DECODE_MESSAGE_ID_47", 47);

    /**
     * Cannot decode the provided ASN.1 sequence as an LDAP message because the second element of the sequence could not be decoded as the protocol op: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MESSAGE_DECODE_PROTOCOL_OP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MESSAGE_DECODE_PROTOCOL_OP_48", 48);

    /**
     * Cannot decode the provided ASN.1 sequence as an LDAP message because the third element of the sequence could not be decoded as the set of controls: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MESSAGE_DECODE_CONTROLS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MESSAGE_DECODE_CONTROLS_49", 49);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP control because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONTROL_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONTROL_DECODE_SEQUENCE_51", 51);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP control because the OID could not be decoded as a string: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONTROL_DECODE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONTROL_DECODE_OID_53", 53);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP control because the criticality could not be decoded as Boolean value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONTROL_DECODE_CRITICALITY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONTROL_DECODE_CRITICALITY_54", 54);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP control because the value could not be decoded as an octet string: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONTROL_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONTROL_DECODE_VALUE_55", 55);

    /**
     * Cannot decode the provided ASN.1 element as a set of LDAP controls because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONTROL_DECODE_CONTROLS_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONTROL_DECODE_CONTROLS_SEQUENCE_58", 58);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP abandon request protocol op because a problem occurred while trying to obtain the message ID of the operation to abandon: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ABANDON_REQUEST_DECODE_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ABANDON_REQUEST_DECODE_ID_59", 59);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP result protocol op because a problem occurred while trying to parse the result sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_RESULT_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_RESULT_DECODE_SEQUENCE_60", 60);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP result protocol op because the first element in the result sequence could not be decoded as an integer result code: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_RESULT_DECODE_RESULT_CODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_RESULT_DECODE_RESULT_CODE_62", 62);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP result protocol op because the second element in the result sequence could not be decoded as the matched DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_RESULT_DECODE_MATCHED_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_RESULT_DECODE_MATCHED_DN_63", 63);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP result protocol op because the third element in the result sequence could not be decoded as the error message: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_RESULT_DECODE_ERROR_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_RESULT_DECODE_ERROR_MESSAGE_64", 64);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP result protocol op because the fourth element in the result sequence could not be decoded as a set of referral URLs: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_RESULT_DECODE_REFERRALS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_RESULT_DECODE_REFERRALS_65", 65);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind response protocol op because the final element in the result sequence could not be decoded as the server SASL credentials: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_RESULT_DECODE_SERVER_SASL_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_RESULT_DECODE_SERVER_SASL_CREDENTIALS_67", 67);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind response protocol op because the response OID could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_EXTENDED_RESULT_DECODE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_EXTENDED_RESULT_DECODE_OID_71", 71);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind response protocol op because the response value could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_EXTENDED_RESULT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_EXTENDED_RESULT_DECODE_VALUE_72", 72);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP unbind request protocol op: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_UNBIND_DECODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_UNBIND_DECODE_74", 74);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_SEQUENCE_75", 75);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the protocol version could not be decoded as an integer: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_VERSION_77", 77);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the bind DN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_DN_78", 78);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the password to use for simple authentication could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_PASSWORD_79", 79);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the SASL authentication information could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_SASL_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_SASL_INFO_80", 80);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because the authentication info element had an invalid BER type (expected 80 or A3, got %x)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_BIND_REQUEST_DECODE_INVALID_CRED_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_INVALID_CRED_TYPE_81", 81);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP bind request protocol op because an unexpected error occurred while trying to decode the authentication info element: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_BIND_REQUEST_DECODE_CREDENTIALS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_BIND_REQUEST_DECODE_CREDENTIALS_82", 82);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP compare request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_COMPARE_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_COMPARE_REQUEST_DECODE_SEQUENCE_83", 83);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP compare request protocol op because the target DN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_COMPARE_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_COMPARE_REQUEST_DECODE_DN_85", 85);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP compare request protocol op because the attribute value assertion could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_COMPARE_REQUEST_DECODE_AVA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_COMPARE_REQUEST_DECODE_AVA_86", 86);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP compare request protocol op because the attribute type could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_COMPARE_REQUEST_DECODE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_COMPARE_REQUEST_DECODE_TYPE_88", 88);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP compare request protocol op because the assertion value could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_COMPARE_REQUEST_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_COMPARE_REQUEST_DECODE_VALUE_89", 89);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP delete request protocol op because the target DN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_DELETE_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_DELETE_REQUEST_DECODE_DN_90", 90);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP extended request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_EXTENDED_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_EXTENDED_REQUEST_DECODE_SEQUENCE_91", 91);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP extended request protocol op because the OID could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_EXTENDED_REQUEST_DECODE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_EXTENDED_REQUEST_DECODE_OID_93", 93);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP extended request protocol op because the value could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_EXTENDED_REQUEST_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_EXTENDED_REQUEST_DECODE_VALUE_94", 94);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify DN request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_DN_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_DN_REQUEST_DECODE_SEQUENCE_95", 95);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify DN request protocol op because the entry DN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_DN_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_DN_REQUEST_DECODE_DN_97", 97);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify DN request protocol op because the new RDN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_DN_REQUEST_DECODE_NEW_RDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_DN_REQUEST_DECODE_NEW_RDN_98", 98);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify DN request protocol op because the deleteOldRDN flag could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_DN_REQUEST_DECODE_DELETE_OLD_RDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_DN_REQUEST_DECODE_DELETE_OLD_RDN_99", 99);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify DN request protocol op because the new superior DN could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_DN_REQUEST_DECODE_NEW_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_DN_REQUEST_DECODE_NEW_SUPERIOR_100", 100);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP attribute because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ATTRIBUTE_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ATTRIBUTE_DECODE_SEQUENCE_101", 101);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP attribute because the attribute type could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ATTRIBUTE_DECODE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ATTRIBUTE_DECODE_TYPE_103", 103);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP attribute because the set of values could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ATTRIBUTE_DECODE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ATTRIBUTE_DECODE_VALUES_104", 104);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP add request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ADD_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ADD_REQUEST_DECODE_SEQUENCE_105", 105);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP add request protocol op because the entry DN could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ADD_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ADD_REQUEST_DECODE_DN_107", 107);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP add request protocol op because the set of attributes could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ADD_REQUEST_DECODE_ATTRS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ADD_REQUEST_DECODE_ATTRS_108", 108);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modification because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFICATION_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFICATION_DECODE_SEQUENCE_109", 109);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modification because it contained an invalid modification type (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_MODIFICATION_DECODE_INVALID_MOD_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFICATION_DECODE_INVALID_MOD_TYPE_111", 111);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modification because the modification type could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFICATION_DECODE_MOD_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFICATION_DECODE_MOD_TYPE_112", 112);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modification because the attribute could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFICATION_DECODE_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFICATION_DECODE_ATTR_113", 113);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_REQUEST_DECODE_SEQUENCE_114", 114);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify request protocol op because the entry DN could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_REQUEST_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_REQUEST_DECODE_DN_116", 116);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP modify request protocol op because the set of modifications could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_REQUEST_DECODE_MODS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_MODIFY_REQUEST_DECODE_MODS_117", 117);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search result entry protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_ENTRY_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_ENTRY_DECODE_SEQUENCE_118", 118);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search result entry protocol op because the entry DN could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_ENTRY_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_ENTRY_DECODE_DN_120", 120);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search result entry protocol op because the set of attributes could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_ENTRY_DECODE_ATTRS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_ENTRY_DECODE_ATTRS_121", 121);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search result reference protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REFERENCE_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REFERENCE_DECODE_SEQUENCE_122", 122);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search result reference protocol op because a problem occurred while trying to decode the sequence elements as referral URLs: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REFERENCE_DECODE_URLS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REFERENCE_DECODE_URLS_123", 123);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_SEQUENCE_124", 124);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the base DN could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_BASE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_BASE_126", 126);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the provided scope value (%d) is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_SCOPE_127", 127);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the scope could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_SCOPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_SCOPE_128", 128);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the provided alias dereferencing policy value (%d) is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_DEREF =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_INVALID_DEREF_129", 129);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the alias dereferencing policy could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_DEREF =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_DEREF_130", 130);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the size limit could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_SIZE_LIMIT_131", 131);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the time limit could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_TIME_LIMIT_132", 132);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the typesOnly flag could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_TYPES_ONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_TYPES_ONLY_133", 133);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the filter could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_FILTER_134", 134);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search request protocol op because the requested attribute set could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SEARCH_REQUEST_DECODE_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_SEARCH_REQUEST_DECODE_ATTRIBUTES_135", 135);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP protocol op because the element was null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_PROTOCOL_OP_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PROTOCOL_OP_DECODE_NULL_136", 136);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP protocol op because the element had an invalid BER type (%x) for an LDAP protocol op
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_PROTOCOL_OP_DECODE_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PROTOCOL_OP_DECODE_INVALID_TYPE_137", 137);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element was null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_FILTER_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_NULL_138", 138);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element had an invalid BER type (%x) for a search filter
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_FILTER_DECODE_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_INVALID_TYPE_139", 139);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because an unexpected error occurred while trying to decode one of the compound filter components: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_COMPOUND_COMPONENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_COMPOUND_COMPONENTS_141", 141);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the NOT component element could not be decoded as an LDAP filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_NOT_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_NOT_COMPONENT_143", 143);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element could not be decoded as a type-and-value sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_TV_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_TV_SEQUENCE_144", 144);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the attribute type could not be decoded from the type-and-value sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_TV_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_TV_TYPE_146", 146);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the assertion value could not be decoded from the type-and-value sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_TV_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_TV_VALUE_147", 147);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element could not be decoded as a substring sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_SUBSTRING_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_SUBSTRING_SEQUENCE_148", 148);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the attribute type could not be decoded from the substring sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_SUBSTRING_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_SUBSTRING_TYPE_150", 150);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the substring value sequence could not be decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_SUBSTRING_ELEMENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_SUBSTRING_ELEMENTS_151", 151);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the substring value sequence did not contain any elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_FILTER_DECODE_SUBSTRING_NO_SUBELEMENTS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_SUBSTRING_NO_SUBELEMENTS_152", 152);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because a problem occurred while trying to parse the substring value elements: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_SUBSTRING_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_SUBSTRING_VALUES_154", 154);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element could not be decoded as the presence attribute type: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_PRESENCE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_PRESENCE_TYPE_155", 155);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because the element could not be decoded as an extensible matching sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_EXTENSIBLE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_EXTENSIBLE_SEQUENCE_156", 156);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP search filter because a problem occurred while trying to parse the extensible match sequence elements: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_DECODE_EXTENSIBLE_ELEMENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_DECODE_EXTENSIBLE_ELEMENTS_158", 158);

    /**
     * The server attempted to send a response to the %s operation (conn=%d, op=%d), but the operation did not have a result code. This could indicate that the operation did not complete properly or that it is one that is not allowed to have a response. Using a generic 'Operations Error' response
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_CLIENT_SEND_RESPONSE_NO_RESULT_CODE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CLIENT_SEND_RESPONSE_NO_RESULT_CODE_159", 159);

    /**
     * The server attempted to send a response to the %s operation (conn=%d, op=%d), but this type of operation is not allowed to have responses. Backtrace: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object> ERR_LDAP_CLIENT_SEND_RESPONSE_INVALID_OP =
                    new LocalizableMessageDescriptor.Arg4<Object, Number, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CLIENT_SEND_RESPONSE_INVALID_OP_160", 160);

    /**
     * The Directory Server is closing the connection to this client
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CLIENT_GENERIC_NOTICE_OF_DISCONNECTION =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CLIENT_GENERIC_NOTICE_OF_DISCONNECTION_165", 165);

    /**
     * The Directory Server is currently in the process of closing this client connection
     */
    public static final LocalizableMessageDescriptor.Arg0 WARN_CLIENT_DISCONNECT_IN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "WARN_CLIENT_DISCONNECT_IN_PROGRESS_166", 166);

    /**
     * The LDAP connection handler defined in configuration entry %s was unable to open a selector to allow it to multiplex the associated accept sockets: %s. This connection handler will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_CONNHANDLER_OPEN_SELECTOR_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONNHANDLER_OPEN_SELECTOR_FAILED_177", 177);

    /**
     * The LDAP connection handler defined in configuration entry %s was unable to create a server socket channel to accept connections on %s:%d: %s. The Directory Server will not listen for new connections on that address
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object> ERR_LDAP_CONNHANDLER_CREATE_CHANNEL_FAILED =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONNHANDLER_CREATE_CHANNEL_FAILED_178", 178);

    /**
     * The LDAP connection handler defined in configuration entry %s was unable to create any of the socket channels on any of the configured addresses. This connection handler will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONNHANDLER_NO_ACCEPTORS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONNHANDLER_NO_ACCEPTORS_179", 179);

    /**
     * The connection attempt from client %s to %s has been rejected because the client was included in one of the denied address ranges
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONNHANDLER_DENIED_CLIENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_DENIED_CLIENT_180", 180);

    /**
     * The connection attempt from client %s to %s has been rejected because the client was not included in one of the allowed address ranges
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONNHANDLER_DISALLOWED_CLIENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_DISALLOWED_CLIENT_181", 181);

    /**
     * An internal error prevented the Directory Server from properly registering the client connection from %s to %s with an appropriate request handler: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_CONNHANDLER_UNABLE_TO_REGISTER_CLIENT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ProtocolMessages.class, RESOURCE, "INFO_CONNHANDLER_UNABLE_TO_REGISTER_CLIENT_182", 182);

    /**
     * The %s defined in configuration entry %s was unable to accept a new client connection: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONNHANDLER_CANNOT_ACCEPT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_CANNOT_ACCEPT_CONNECTION_183", 183);

    /**
     * The %s defined in configuration entry %s has experienced consecutive failures while trying to accept client connections: %s. This connection handler will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CONNHANDLER_CONSECUTIVE_ACCEPT_FAILURES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_CONSECUTIVE_ACCEPT_FAILURES_184", 184);

    /**
     * The LDAP connection handler defined in configuration entry %s caught an unexpected error while trying to listen for new connections: %s. This connection handler will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_CONNHANDLER_UNCAUGHT_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CONNHANDLER_UNCAUGHT_ERROR_185", 185);

    /**
     * %s was unable to open a selector to multiplex reads from clients: %s. This request handler cannot continue processing
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_REQHANDLER_OPEN_SELECTOR_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_OPEN_SELECTOR_FAILED_186", 186);

    /**
     * %s was unable to register this client connection with the selector: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_REQHANDLER_CANNOT_REGISTER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_CANNOT_REGISTER_187", 187);

    /**
     * This connection could not be registered with a request handler because the Directory Server is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_REQHANDLER_REJECT_DUE_TO_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_REJECT_DUE_TO_SHUTDOWN_188", 188);

    /**
     * This client connection is being deregistered from the associated request handler because the Directory Server is shutting down
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_REQHANDLER_DEREGISTER_DUE_TO_SHUTDOWN =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_DEREGISTER_DUE_TO_SHUTDOWN_190", 190);

    /**
     * Cannot decode the provided string as an LDAP search filter because the string was null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_FILTER_STRING_NULL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_STRING_NULL_192", 192);

    /**
     * Cannot decode the provided string %s as an LDAP search filter because an unexpected exception was thrown during processing: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_FILTER_UNCAUGHT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_UNCAUGHT_EXCEPTION_193", 193);

    /**
     * The provided search filter "%s" had mismatched parentheses around the portion between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_MISMATCHED_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_MISMATCHED_PARENTHESES_194", 194);

    /**
     * The provided search filter "%s" was missing an equal sign in the suspected simple filter component between positions %d and %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_NO_EQUAL_SIGN =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_EQUAL_SIGN_195", 195);

    /**
     * The provided search filter "%s" had an invalid escaped byte value at position %d. A backslash in a value must be followed by two hexadecimal characters that define the byte that has been encoded
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_INVALID_ESCAPED_BYTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_INVALID_ESCAPED_BYTE_196", 196);

    /**
     * The provided search filter "%s" could not be decoded because the compound filter between positions %d and %d did not start with an open parenthesis and end with a close parenthesis (they might be parentheses for different filter components)
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_COMPOUND_MISSING_PARENTHESES =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_COMPOUND_MISSING_PARENTHESES_197", 197);

    /**
     * The provided search filter "%s" could not be decoded because the closing parenthesis at position %d did not have a corresponding open parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_CORRESPONDING_OPEN_PARENTHESIS_198", 198);

    /**
     * The provided search filter "%s" could not be decoded because the opening parenthesis at position %d did not have a corresponding close parenthesis
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_NO_CORRESPONDING_CLOSE_PARENTHESIS_199", 199);

    /**
     * The provided search filter "%s" could not be decoded because the assumed substring filter value between positions %d and %d did not have any asterisk wildcard characters
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_SUBSTRING_NO_ASTERISKS =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_SUBSTRING_NO_ASTERISKS_200", 200);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not have a colon to denote the end of the attribute type name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_COLON =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_COLON_201", 201);

    /**
     * Terminating this connection because the client sent an invalid message of type %s (LDAP message ID %d) that is not allowed for request messages
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_DISCONNECT_DUE_TO_INVALID_REQUEST_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_DISCONNECT_DUE_TO_INVALID_REQUEST_TYPE_202", 202);

    /**
     * An unexpected failure occurred while trying to process a request of type %s (LDAP message ID %d): %s. The client connection will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Object> ERR_LDAP_DISCONNECT_DUE_TO_PROCESSING_FAILURE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_DISCONNECT_DUE_TO_PROCESSING_FAILURE_203", 203);

    /**
     * The bind request message (LDAP message ID %d) included an invalid authentication type of %s. This is a protocol error, and this connection will be terminated as per RFC 2251 section 4.2.3
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_INVALID_BIND_AUTH_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_INVALID_BIND_AUTH_TYPE_204", 204);

    /**
     * This client connection is being terminated because a protocol error occurred while trying to process a bind request. The LDAP message ID was %d and the error message for the bind response was %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_DISCONNECT_DUE_TO_BIND_PROTOCOL_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_DISCONNECT_DUE_TO_BIND_PROTOCOL_ERROR_205", 205);

    /**
     * An extended response message would have been sent to an LDAPv2 client (connection ID=%d, operation ID=%d): %s. LDAPv2 does not allow extended operations, so this response will not be sent
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_LDAPV2_SKIPPING_EXTENDED_RESPONSE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_SKIPPING_EXTENDED_RESPONSE_206", 206);

    /**
     * A search performed by an LDAPv2 client (connection ID=%d, operation ID=%d) would have included a search result reference %s. Referrals are not allowed for LDAPv2 clients, so this search reference will not be sent
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_LDAPV2_SKIPPING_SEARCH_REFERENCE =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_SKIPPING_SEARCH_REFERENCE_207", 207);

    /**
     * The original result code for this message was 10 but this result is not allowed for LDAPv2 clients
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPV2_REFERRAL_RESULT_CHANGED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_REFERRAL_RESULT_CHANGED_208", 208);

    /**
     * The response included one or more referrals, which are not allowed for LDAPv2 clients. The referrals included were: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPV2_REFERRALS_OMITTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_REFERRALS_OMITTED_209", 209);

    /**
     * The Directory Server has been configured to deny access to LDAPv2 clients. This connection will be closed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPV2_CLIENTS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_CLIENTS_NOT_ALLOWED_210", 210);

    /**
     * The client with connection ID %d authenticated to the Directory Server using LDAPv2, but attempted to send an extended operation request (LDAP message ID %d), which is not allowed for LDAPv2 clients. The connection will be terminated
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_LDAPV2_EXTENDED_REQUEST_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_EXTENDED_REQUEST_NOT_ALLOWED_211", 211);

    /**
     * An attempt was made to initialize the LDAP statistics monitor provider as defined in configuration entry %s. This monitor provider should only be dynamically created within the Directory Server itself and not from within the configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_STATS_INVALID_MONITOR_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_STATS_INVALID_MONITOR_INITIALIZATION_212", 212);

    /**
     * The LDAP request handler thread "%s" encountered an unexpected error that would have caused the thread to die: %s. The error has been caught and the request handler should continue operating as normal
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAP_REQHANDLER_UNEXPECTED_SELECT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_UNEXPECTED_SELECT_EXCEPTION_213", 213);

    /**
     * The attempt to register this connection with the Directory Server was rejected. This might indicate that the server already has the maximum allowed number of concurrent connections established, or that it is in a restricted access mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONNHANDLER_REJECTED_BY_SERVER =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_REJECTED_BY_SERVER_214", 214);

    /**
     * TCP port on which this connection handler can accept client connections. Changes to this configuration attribute will not take effect until the connection handler is disabled and re-enabled, or until the Directory Server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONNHANDLER_DESCRIPTION_LISTEN_PORT =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CONNHANDLER_DESCRIPTION_LISTEN_PORT_216", 216);

    /**
     * Indicates whether this connection handler should allow clients to use the StartTLS extended operation to initiate secure communication over a non-SSL LDAP connection. This can not be used if SSL is enabled for the connection handler. Changes to this configuration attribute will take effect immediately for LDAP clients
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONNHANDLER_DESCRIPTION_ALLOW_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CONNHANDLER_DESCRIPTION_ALLOW_STARTTLS_227", 227);

    /**
     * Nickname of the certificate that the connection handler should use when accepting SSL-based connections or performing StartTLS negotiation. Changes to this configuration attribute will not take effect until the connection handler is disabled and re-enabled, or until the Directory Server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONNHANDLER_DESCRIPTION_SSL_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CONNHANDLER_DESCRIPTION_SSL_CERT_NICKNAME_229", 229);

    /**
     * An unexpected error occurred while trying to decode the DN %s used for internal operations as a root user: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INTERNAL_CANNOT_DECODE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_INTERNAL_CANNOT_DECODE_DN_264", 264);

    /**
     * The TLS connection security provider cannot be enabled on this client connection because it is already using the %s provider. StartTLS can only be used on clear-text connections
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_TLS_EXISTING_SECURITY_PROVIDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_TLS_EXISTING_SECURITY_PROVIDER_271", 271);

    /**
     * StartTLS cannot be enabled on this LDAP client connection because the corresponding LDAP connection handler is configured to reject StartTLS requests. The use of StartTLS can be enabled using the ds-cfg-allow-start-tls configuration attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_TLS_STARTTLS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_TLS_STARTTLS_NOT_ALLOWED_272", 272);

    /**
     * An error occurred while attempting to create a TLS connection security provider for this client connection for use with StartTLS: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_TLS_CANNOT_CREATE_TLS_PROVIDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_TLS_CANNOT_CREATE_TLS_PROVIDER_273", 273);

    /**
     * Started listening for new connections on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONNHANDLER_STARTED_LISTENING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "NOTE_CONNHANDLER_STARTED_LISTENING_276", 276);

    /**
     * Stopped listening for new connections on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CONNHANDLER_STOPPED_LISTENING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "NOTE_CONNHANDLER_STOPPED_LISTENING_277", 277);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the element is null
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_PAGED_RESULTS_DECODE_NULL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_NULL_278", 278);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_SEQUENCE_279", 279);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the size element could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_SIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_SIZE_281", 281);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP paged results control value because the cookie could not be properly decoded: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_PAGED_RESULTS_DECODE_COOKIE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_PAGED_RESULTS_DECODE_COOKIE_282", 282);

    /**
     * Cannot decode the provided LDAP assertion control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPASSERT_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAPASSERT_NO_CONTROL_VALUE_283", 283);

    /**
     * Cannot decode the provided LDAP pre-read request control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PREREADREQ_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PREREADREQ_NO_CONTROL_VALUE_285", 285);

    /**
     * Cannot decode the provided LDAP pre-read request control because an error occurred while trying to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PREREADREQ_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PREREADREQ_CANNOT_DECODE_VALUE_286", 286);

    /**
     * Cannot decode the provided LDAP post-read request control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_POSTREADREQ_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_POSTREADREQ_NO_CONTROL_VALUE_287", 287);

    /**
     * Cannot decode the provided LDAP post-read request control because an error occurred while trying to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_POSTREADREQ_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_POSTREADREQ_CANNOT_DECODE_VALUE_288", 288);

    /**
     * Cannot decode the provided LDAP pre-read response control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PREREADRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PREREADRESP_NO_CONTROL_VALUE_289", 289);

    /**
     * Cannot decode the provided LDAP pre-read response control because an error occurred while trying to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PREREADRESP_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PREREADRESP_CANNOT_DECODE_VALUE_290", 290);

    /**
     * Cannot decode the provided LDAP post-read response control because the control does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_POSTREADRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_POSTREADRESP_NO_CONTROL_VALUE_291", 291);

    /**
     * Cannot decode the provided LDAP post-read response control because an error occurred while trying to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_POSTREADRESP_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_POSTREADRESP_CANNOT_DECODE_VALUE_292", 292);

    /**
     * Cannot decode the provided proxied authorization V1 control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH1_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH1_NO_CONTROL_VALUE_293", 293);

    /**
     * Cannot decode the provided proxied authorization V1 control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH1_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH1_CANNOT_DECODE_VALUE_295", 295);

    /**
     * User %s specified in the proxied authorization V1 control does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH1_NO_SUCH_USER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH1_NO_SUCH_USER_296", 296);

    /**
     * Cannot decode the provided proxied authorization V2 control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH2_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_NO_CONTROL_VALUE_297", 297);

    /**
     * Unable to process proxied authorization V2 control because it contains an authorization ID based on a username and no proxied authorization identity mapper is configured in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH2_NO_IDENTITY_MAPPER =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_NO_IDENTITY_MAPPER_299", 299);

    /**
     * The authorization ID "%s" contained in the proxied authorization V2 control is invalid because it does not start with "dn:" to indicate a user DN or "u:" to indicate a username
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_INVALID_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_INVALID_AUTHZID_300", 300);

    /**
     * User %s specified in the proxied authorization V2 control does not exist in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_NO_SUCH_USER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_NO_SUCH_USER_301", 301);

    /**
     * The provided integer value %d does not correspond to any persistent search change type
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PSEARCH_CHANGETYPES_INVALID_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_PSEARCH_CHANGETYPES_INVALID_TYPE_302", 302);

    /**
     * The provided integer value indicated that there were no persistent search change types, which is not allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PSEARCH_CHANGETYPES_NO_TYPES =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PSEARCH_CHANGETYPES_NO_TYPES_303", 303);

    /**
     * The provided integer value %d was outside the range of acceptable values for an encoded change type set
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PSEARCH_CHANGETYPES_INVALID_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_PSEARCH_CHANGETYPES_INVALID_TYPES_304", 304);

    /**
     * Cannot decode the provided persistent search control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PSEARCH_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PSEARCH_NO_CONTROL_VALUE_305", 305);

    /**
     * Cannot decode the provided persistent search control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PSEARCH_CANNOT_DECODE_VALUE_307", 307);

    /**
     * Cannot decode the provided entry change notification control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ECN_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_ECN_NO_CONTROL_VALUE_308", 308);

    /**
     * Cannot decode the provided entry change notification control because it contains a previous DN element but had a change type of %s. The previous DN element can only be provided with the modify DN change type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECN_ILLEGAL_PREVIOUS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_ECN_ILLEGAL_PREVIOUS_DN_310", 310);

    /**
     * Cannot decode the provided entry change notification control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECN_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_ECN_CANNOT_DECODE_VALUE_312", 312);

    /**
     * Cannot decode the provided authorization identity response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHZIDRESP_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_AUTHZIDRESP_NO_CONTROL_VALUE_313", 313);

    /**
     * Cannot decode the provided ASN.1 element as an LDAP intermediate response protocol op because the element could not be decoded as a sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_INTERMEDIATE_RESPONSE_DECODE_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_INTERMEDIATE_RESPONSE_DECODE_SEQUENCE_314", 314);

    /**
     * An error occurred while attempting to decode the intermediate response OID: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_INTERMEDIATE_RESPONSE_CANNOT_DECODE_OID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_INTERMEDIATE_RESPONSE_CANNOT_DECODE_OID_316", 316);

    /**
     * An error occurred while attempting to decode the intermediate response value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_INTERMEDIATE_RESPONSE_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_INTERMEDIATE_RESPONSE_CANNOT_DECODE_VALUE_317", 317);

    /**
     * The provided LDAP filter "%s" cannot be used as a matched values filter because filters of type %s are not allowed for use in matched values filters
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MVFILTER_INVALID_LDAP_FILTER_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_INVALID_LDAP_FILTER_TYPE_321", 321);

    /**
     * The provided LDAP filter "%s" cannot be used as a matched values filter because it is an extensible match filter that contains the dnAttributes flag, which is not allowed for matched values filters
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_INVALID_DN_ATTRIBUTES_FLAG =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_INVALID_DN_ATTRIBUTES_FLAG_322", 322);

    /**
     * An error occurred while attempting to decode the attribute value assertion in the provided matched values filter: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_CANNOT_DECODE_AVA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_CANNOT_DECODE_AVA_324", 324);

    /**
     * The provided matched values filter could not be decoded because there were no subInitial, subAny, or subFinal components in the substring filter
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MVFILTER_NO_SUBSTRING_ELEMENTS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_NO_SUBSTRING_ELEMENTS_326", 326);

    /**
     * The provided matched values filter could not be decoded because an error occurred while decoding the substring filter component: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_CANNOT_DECODE_SUBSTRINGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_CANNOT_DECODE_SUBSTRINGS_330", 330);

    /**
     * The provided matched values filter could not be decoded because an error occurred while decoding the presence filter component: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_CANNOT_DECODE_PRESENT_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_CANNOT_DECODE_PRESENT_TYPE_331", 331);

    /**
     * The provided matched values filter could not be decoded because an error occurred while decoding the extensible match filter component: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_CANNOT_DECODE_EXTENSIBLE_MATCH =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_CANNOT_DECODE_EXTENSIBLE_MATCH_337", 337);

    /**
     * The provided matched values filter could not be decoded because it had an invalid BER type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVFILTER_INVALID_ELEMENT_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MVFILTER_INVALID_ELEMENT_TYPE_338", 338);

    /**
     * Cannot decode the provided matched values control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MATCHEDVALUES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_MATCHEDVALUES_NO_CONTROL_VALUE_339", 339);

    /**
     * Cannot decode the provided matched values control because an error occurred while attempting to decode the value as an ASN.1 sequence: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MATCHEDVALUES_CANNOT_DECODE_VALUE_AS_SEQUENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_MATCHEDVALUES_CANNOT_DECODE_VALUE_AS_SEQUENCE_340", 340);

    /**
     * Cannot decode the provided matched values control because the control value does not specify any filters for use in matching attribute values
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MATCHEDVALUES_NO_FILTERS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_MATCHEDVALUES_NO_FILTERS_341", 341);

    /**
     * Cannot decode the provided control as a password expired control because the provided control had a value that could not be parsed as an integer
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWEXPIRED_CONTROL_INVALID_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PWEXPIRED_CONTROL_INVALID_VALUE_342", 342);

    /**
     * Cannot decode the provided password expiring control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWEXPIRING_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PWEXPIRING_NO_CONTROL_VALUE_343", 343);

    /**
     * Cannot decode the provided control as a password expiring control because an error occurred while attempting to decode the number of seconds until expiration: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PWEXPIRING_CANNOT_DECODE_SECONDS_UNTIL_EXPIRATION_344", 344);

    /**
     * The Directory Server is already processing another request on the same client connection with the same message ID of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> WARN_LDAP_CLIENT_DUPLICATE_MESSAGE_ID =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "WARN_LDAP_CLIENT_DUPLICATE_MESSAGE_ID_345", 345);

    /**
     * The Directory Server encountered an unexpected error while attempting to add the client request to the work queue: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAP_CLIENT_CANNOT_ENQUEUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "WARN_LDAP_CLIENT_CANNOT_ENQUEUE_346", 346);

    /**
     * TCP port on which this connection handler may accept administrative connections. Changes to this configuration attribute will not take effect until the connection handler is disabled and re-enabled, or until the Directory Server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JMX_CONNHANDLER_DESCRIPTION_LISTEN_PORT =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_JMX_CONNHANDLER_DESCRIPTION_LISTEN_PORT_347", 347);

    /**
     * Nickname of the certificate that the connection handler should use when accepting SSL-based connections or performing StartTLS negotiation. Changes to this configuration attribute will not take effect until the connection handler is disabled and re-enabled, or until the Directory Server is restarted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JMX_CONNHANDLER_DESCRIPTION_SSL_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_JMX_CONNHANDLER_DESCRIPTION_SSL_CERT_NICKNAME_352", 352);

    /**
     * Cannot decode the provided control as a password policy request control because the provided control had a value but the password policy request control should not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPOLICYREQ_CONTROL_HAS_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PWPOLICYREQ_CONTROL_HAS_VALUE_354", 354);

    /**
     * Cannot decode the provided password policy response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PWPOLICYRES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PWPOLICYRES_NO_CONTROL_VALUE_355", 355);

    /**
     * Cannot decode the provided password policy response control because the warning element has an invalid type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICYRES_INVALID_WARNING_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PWPOLICYRES_INVALID_WARNING_TYPE_356", 356);

    /**
     * Cannot decode the provided password policy response control because the error element has an invalid type of %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_PWPOLICYRES_INVALID_ERROR_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_PWPOLICYRES_INVALID_ERROR_TYPE_357", 357);

    /**
     * Cannot decode the provided password policy response control: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PWPOLICYRES_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PWPOLICYRES_DECODE_ERROR_359", 359);

    /**
     * passwordExpired
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_EXPIRED_360", 360);

    /**
     * accountLocked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_ACCOUNT_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_ACCOUNT_LOCKED_361", 361);

    /**
     * changeAfterReset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_CHANGE_AFTER_RESET =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_CHANGE_AFTER_RESET_362", 362);

    /**
     * passwordModNotAllowed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_MOD_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_MOD_NOT_ALLOWED_363", 363);

    /**
     * mustSupplyOldPassword
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_MUST_SUPPLY_OLD_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_MUST_SUPPLY_OLD_PASSWORD_364", 364);

    /**
     * insufficientPasswordQuality
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_INSUFFICIENT_PASSWORD_QUALITY =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_INSUFFICIENT_PASSWORD_QUALITY_365", 365);

    /**
     * passwordTooShort
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_TOO_SHORT =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_TOO_SHORT_366", 366);

    /**
     * passwordTooYoung
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_TOO_YOUNG =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_TOO_YOUNG_367", 367);

    /**
     * passwordInHistory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_IN_HISTORY =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPERRTYPE_DESCRIPTION_PASSWORD_IN_HISTORY_368", 368);

    /**
     * timeBeforeExpiration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPWARNTYPE_DESCRIPTION_TIME_BEFORE_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPWARNTYPE_DESCRIPTION_TIME_BEFORE_EXPIRATION_369", 369);

    /**
     * graceAuthNsRemaining
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PWPWARNTYPE_DESCRIPTION_GRACE_LOGINS_REMAINING =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_PWPWARNTYPE_DESCRIPTION_GRACE_LOGINS_REMAINING_370", 370);

    /**
     * Use of the proxied authorization V1 control for user %s is not allowed by the password policy configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH1_UNUSABLE_ACCOUNT =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH1_UNUSABLE_ACCOUNT_372", 372);

    /**
     * Cannot decode the provided control as an account availability request control because the provided control had a value but the account availability request control should not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ACCTUSABLEREQ_CONTROL_HAS_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_ACCTUSABLEREQ_CONTROL_HAS_VALUE_375", 375);

    /**
     * Cannot decode the provided account availability response control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ACCTUSABLERES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_ACCTUSABLERES_NO_CONTROL_VALUE_376", 376);

    /**
     * The account availability response control had an unknown ACCOUNT_USABLE_RESPONSE element type of %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ACCTUSABLERES_UNKNOWN_VALUE_ELEMENT_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_ACCTUSABLERES_UNKNOWN_VALUE_ELEMENT_TYPE_378", 378);

    /**
     * Cannot decode the provided account availability response control: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ACCTUSABLERES_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_ACCTUSABLERES_DECODE_ERROR_379", 379);

    /**
     * The provided LDAP attribute %s contains duplicate values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ATTRIBUTE_DUPLICATE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_ATTRIBUTE_DUPLICATE_VALUES_384", 384);

    /**
     * The provided LDAP search filter references unknown matching rule %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_UNKNOWN_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_UNKNOWN_MATCHING_RULE_385", 385);

    /**
     * The provided LDAP search filter has an assertion value but does not include either an attribute type or a matching rule ID
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_FILTER_VALUE_WITH_NO_ATTR_OR_MR =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_VALUE_WITH_NO_ATTR_OR_MR_386", 386);

    /**
     * Unable to call select() in the LDAP connection handler: %s. It appears that your JVM may be susceptible to the issue described at http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6322825, and it is unable to handle LDAP requests in its current configuration. Please upgrade to a newer JVM that does not exhibit this behavior (Java 5.0 Update 8 or higher) or set the number of available file descriptors to a value greater than or equal to 8193 (e.g., by issuing the command 'ulimit -n 8193') before starting the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_REQHANDLER_DETECTED_JVM_ISSUE_CR6322825 =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_REQHANDLER_DETECTED_JVM_ISSUE_CR6322825_387", 387);

    /**
     * Unwilling to process the request because it contains a proxied authorization V1 control which is not marked critical. The proxied authorization control must always have a criticality of "true"
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH1_CONTROL_NOT_CRITICAL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH1_CONTROL_NOT_CRITICAL_388", 388);

    /**
     * Unwilling to process the request because it contains a proxied authorization V2 control which is not marked critical. The proxied authorization control must always have a criticality of "true"
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PROXYAUTH2_CONTROL_NOT_CRITICAL =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_CONTROL_NOT_CRITICAL_389", 389);

    /**
     * DN of the configuration entry for the key manager provider that should be used with this LDAP connection handler. Changes to this attribute will take effect immediately, but only for subsequent attempts to access the key manager provider for associated client connections
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONNHANDLER_DESCRIPTION_KEYMANAGER_DN =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CONNHANDLER_DESCRIPTION_KEYMANAGER_DN_390", 390);

    /**
     * DN of the configuration entry for the trust manager provider that should be used with this LDAP connection handler. Changes to this attribute will take effect immediately, but only for subsequent attempts to access the trust manager provider for associated client connections
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONNHANDLER_DESCRIPTION_TRUSTMANAGER_DN =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAP_CONNHANDLER_DESCRIPTION_TRUSTMANAGER_DN_393", 393);

    /**
     * Specifies whether to enable the LDAPS connection handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPS_CONNHANDLER_DESCRIPTION_ENABLE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_LDAPS_CONNHANDLER_DESCRIPTION_ENABLE_404", 404);

    /**
     * The provided search filter "%s" could not be decoded because the NOT filter between positions %d and %d did not contain exactly one filter component
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_LDAP_FILTER_NOT_EXACTLY_ONE =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_NOT_EXACTLY_ONE_405", 405);

    /**
     * Unable to decode the provided control as a server-side sort request control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTREQ_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_VALUE_406", 406);

    /**
     * Unable to process the provided server-side sort request control because it references undefined ordering matching rule %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_UNDEFINED_ORDERING_RULE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_UNDEFINED_ORDERING_RULE_408", 408);

    /**
     * Unable to process the provided server-side sort request control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_CANNOT_DECODE_VALUE_410", 410);

    /**
     * Unable to decode the provided control as a server-side sort response control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTRES_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_SORTRES_CONTROL_NO_VALUE_411", 411);

    /**
     * Unable to process the provided server-side sort response control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTRES_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTRES_CONTROL_CANNOT_DECODE_VALUE_412", 412);

    /**
     * Unable to process the provided server-side sort request control because the sort order string "%s" included a sort key with no attribute name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_NO_ATTR_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_ATTR_NAME_413", 413);

    /**
     * Unable to process the provided server-side sort request control because the sort order string "%s" included a sort key with a colon but no matching rule name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_NO_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_MATCHING_RULE_414", 414);

    /**
     * Unable to process the provided server-side sort request control because it did not contain any sort keys
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORTREQ_CONTROL_NO_SORT_KEYS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_SORT_KEYS_415", 415);

    /**
     * Unable to process the provided server-side sort request control because it included attribute %s which does not have a default ordering matching rule and no ordering rule was specified in the sort key
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SORTREQ_CONTROL_NO_ORDERING_RULE_FOR_ATTR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_SORTREQ_CONTROL_NO_ORDERING_RULE_FOR_ATTR_416", 416);

    /**
     * Unable to decode the provided control as a VLV request control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLVREQ_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_NO_VALUE_417", 417);

    /**
     * Unable to decode the provided control as a VLV request control because the target element type %s is invalid
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVREQ_CONTROL_INVALID_TARGET_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_INVALID_TARGET_TYPE_419", 419);

    /**
     * Unable to process the provided VLV request control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVREQ_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_VLVREQ_CONTROL_CANNOT_DECODE_VALUE_420", 420);

    /**
     * Unable to decode the provided control as a VLV response control because it does not include a control value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLVRES_CONTROL_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_VLVRES_CONTROL_NO_VALUE_421", 421);

    /**
     * Unable to process the provided VLV response control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_VLVRES_CONTROL_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_VLVRES_CONTROL_CANNOT_DECODE_VALUE_423", 423);

    /**
     * The authorization ID "%s" contained in the geteffectiverights control is invalid because it does not start with "dn:" to indicate a user DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GETEFFECTIVERIGHTS_INVALID_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_GETEFFECTIVERIGHTS_INVALID_AUTHZID_424", 424);

    /**
     * Cannot decode the provided geteffectiverights request control: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GETEFFECTIVERIGHTS_DECODE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_GETEFFECTIVERIGHTS_DECODE_ERROR_425", 425);

    /**
     * An LDAP filter enclosed in apostrophes is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_FILTER_ENCLOSED_IN_APOSTROPHES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_ENCLOSED_IN_APOSTROPHES_427", 427);

    /**
     * Specifies whether to enable the JMX connection handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JMX_CONNHANDLER_DESCRIPTION_ENABLE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "INFO_JMX_CONNHANDLER_DESCRIPTION_ENABLE_428", 428);

    /**
     * The provided search filter contains an invalid attribute type '%s' with invalid character '%s' at position %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_LDAP_FILTER_INVALID_CHAR_IN_ATTR_TYPE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_INVALID_CHAR_IN_ATTR_TYPE_429", 429);

    /**
     * The provided search filter "%s" could not be decoded because the extensible match component starting at position %d did not include either an attribute description or a matching rule ID. At least one of them must be provided
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_FILTER_EXTENSIBLE_MATCH_NO_AD_OR_MR_430", 430);

    /**
     * LDAPv2 clients are not allowed to use request controls
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPV2_CONTROLS_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAPV2_CONTROLS_NOT_ALLOWED_431", 431);

    /**
     * The %s connection handler defined in configuration entry %s was unable to bind to %s:%d: %s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Number, Object> ERR_CONNHANDLER_CANNOT_BIND =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Number, Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_CANNOT_BIND_432", 432);

    /**
     * You do not have sufficient privileges to perform search operations through JMX
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_JMX_SEARCH_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_JMX_SEARCH_INSUFFICIENT_PRIVILEGES_438", 438);

    /**
     * You do not have sufficient privileges to establish the connection through JMX. At least JMX_READ privilege is required
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_JMX_INSUFFICIENT_PRIVILEGES =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_JMX_INSUFFICIENT_PRIVILEGES_439", 439);

    /**
     * User %s does not exist in the directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INTERNALCONN_NO_SUCH_USER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_INTERNALCONN_NO_SUCH_USER_440", 440);

    /**
     * This output stream has been closed
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INTERNALOS_CLOSED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_INTERNALOS_CLOSED_441", 441);

    /**
     * The provided LDAP message had an invalid operation type (%s) for a request
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INTERNALOS_INVALID_REQUEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_INTERNALOS_INVALID_REQUEST_442", 442);

    /**
     * SASL bind operations are not supported over internal LDAP sockets
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INTERNALOS_SASL_BIND_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_INTERNALOS_SASL_BIND_NOT_SUPPORTED_443", 443);

    /**
     * StartTLS operations are not supported over internal LDAP sockets
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INTERNALOS_STARTTLS_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_INTERNALOS_STARTTLS_NOT_SUPPORTED_444", 444);

    /**
     * The value %s specified as the LDIF directory path for the LDIF connection handler defined in configuration entry %s exists but is not a directory. The specified path must be a directory. The LDIF connection handler will start, but will not be able to proces any changes until this path is changed to a directory
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LDIF_CONNHANDLER_LDIF_DIRECTORY_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "WARN_LDIF_CONNHANDLER_LDIF_DIRECTORY_NOT_DIRECTORY_445", 445);

    /**
     * The directory %s referenced by the LDIF connection handler defined in configuration entry %s does not exist. The LDIF connection handler will start, but will not be able to process any changes until this directory is created
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> WARN_LDIF_CONNHANDLER_LDIF_DIRECTORY_MISSING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "WARN_LDIF_CONNHANDLER_LDIF_DIRECTORY_MISSING_446", 446);

    /**
     * An error occurred while trying to read a change record from the LDIF file: %s. This change will be skipped but processing on the LDIF file will continue
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_CONNHANDLER_CANNOT_READ_CHANGE_RECORD_NONFATAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDIF_CONNHANDLER_CANNOT_READ_CHANGE_RECORD_NONFATAL_447", 447);

    /**
     * An error occurred while trying to read a change record from the LDIF file: %s. No further processing on this LDIF file can be performed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_CONNHANDLER_CANNOT_READ_CHANGE_RECORD_FATAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDIF_CONNHANDLER_CANNOT_READ_CHANGE_RECORD_FATAL_448", 448);

    /**
     * Unsupported change type %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIF_CONNHANDLER_UNKNOWN_CHANGETYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_LDIF_CONNHANDLER_UNKNOWN_CHANGETYPE_449", 449);

    /**
     * Result Code: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> INFO_LDIF_CONNHANDLER_RESULT_CODE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ProtocolMessages.class, RESOURCE, "INFO_LDIF_CONNHANDLER_RESULT_CODE_450", 450);

    /**
     * Additional Info: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIF_CONNHANDLER_ERROR_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_LDIF_CONNHANDLER_ERROR_MESSAGE_451", 451);

    /**
     * Matched DN: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIF_CONNHANDLER_MATCHED_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_LDIF_CONNHANDLER_MATCHED_DN_452", 452);

    /**
     * Referral URL: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIF_CONNHANDLER_REFERRAL_URL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_LDIF_CONNHANDLER_REFERRAL_URL_453", 453);

    /**
     * An I/O error occurred while the LDIF connection handler was processing LDIF file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_CONNHANDLER_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDIF_CONNHANDLER_IO_ERROR_454", 454);

    /**
     * An error occurred while the LDIF connection handler was attempting to rename partially-processed file from %s to %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_LDIF_CONNHANDLER_CANNOT_RENAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDIF_CONNHANDLER_CANNOT_RENAME_455", 455);

    /**
     * An error occurred while the LDIF connection handler was attempting to delete processed file %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_CONNHANDLER_CANNOT_DELETE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_LDIF_CONNHANDLER_CANNOT_DELETE_456", 456);

    /**
     * Address already in use
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONNHANDLER_ADDRESS_INUSE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_ADDRESS_INUSE_457", 457);

    /**
     * Cannot decode the provided subentries control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBENTRIES_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SUBENTRIES_NO_CONTROL_VALUE_458", 458);

    /**
     * Cannot decode the provided subentries control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBENTRIES_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_SUBENTRIES_CANNOT_DECODE_VALUE_459", 459);

    /**
     * No Configuration was defined for this connection handler. The configuration parameters ds-cfg-listen-port and ds-cfg-trap-port are required by the connection handler to start
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SNMP_CONNHANDLER_NO_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_NO_CONFIGURATION_1462", 1462);

    /**
     * Traps Destination %s is an unknown host. Traps will not be sent to this destination
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SNMP_CONNHANDLER_TRAPS_DESTINATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_TRAPS_DESTINATION_1463", 1463);

    /**
     * You do not have the appropriate OpenDMK jar files to enable the SNMP Connection Handler. Please go under http://opendmk.dev.java.net and set the opendmk-jarfile configuration parameter to set the full path of the required jdmkrt.jar file. The SNMP connection Handler didn't started
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SNMP_CONNHANDLER_NO_OPENDMK_JARFILES =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_NO_OPENDMK_JARFILES_1464", 1464);

    /**
     * Cannot initialize the SNMP Connection Handler. Please check the configuration attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SNMP_CONNHANDLER_BAD_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_BAD_CONFIGURATION_1465", 1465);

    /**
     * No valid trap destinations has been found. No trap will be sent
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SNMP_CONNHANDLER_NO_VALID_TRAP_DESTINATIONS =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_NO_VALID_TRAP_DESTINATIONS_1466", 1466);

    /**
     * Cannot decode the provided subtree delete control because it contains a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_SUBTREE_DELETE_INVALID_CONTROL_VALUE_1503", 1503);

    /**
     * An error occurred while attempting to initialize the SSL context for use in the LDAP Connection Handler: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONNHANDLER_SSL_CANNOT_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_SSL_CANNOT_INITIALIZE_1504", 1504);

    /**
     * The Directory Server does not support LDAP protocol version %d. This connection will be closed
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_LDAP_UNSUPPORTED_PROTOCOL_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Number>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_UNSUPPORTED_PROTOCOL_VERSION_1505", 1505);

    /**
     * The specified OpenDMK jar file '%s' could not be found. Verify that the value set in the opendmk-jarfile configuration parameter of the SNMP connection handler is the valid path to the jdmkrt.jar file and that the file is accessible
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SNMP_CONNHANDLER_OPENDMK_JARFILES_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_OPENDMK_JARFILES_DOES_NOT_EXIST_1506", 1506);

    /**
     * The required classes could not be loaded using jar file '%s'. Verify that the jar file is not corrupted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SNMP_CONNHANDLER_OPENDMK_JARFILES_NOT_OPERATIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_SNMP_CONNHANDLER_OPENDMK_JARFILES_NOT_OPERATIONAL_1507", 1507);

    /**
     * Cannot decode the provided control %s because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_DECODE_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_CANNOT_DECODE_CONTROL_VALUE_1508", 1508);

    /**
     * An error occurred while processing the request %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_HTTP_ERROR_WHILE_PROCESSING_REQUEST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_HTTP_ERROR_WHILE_PROCESSING_REQUEST_1508", 1508);

    /**
     * Cannot decode the provided entry changelog notification control because it does not have a value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ECLN_NO_CONTROL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_ECLN_NO_CONTROL_VALUE_1509", 1509);

    /**
     * Cannot decode the provided entry changelog notification control because an error occurred while attempting to decode the control value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ECLN_CANNOT_DECODE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_ECLN_CANNOT_DECODE_VALUE_1510", 1510);

    /**
     * The connection to the Directory Server was closed while waiting for a response
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNEXPECTED_CONNECTION_CLOSURE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_UNEXPECTED_CONNECTION_CLOSURE_1511", 1511);

    /**
     * Connection handler '%s' does not specify the number of request handler threads: defaulting to %d threads
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_ERGONOMIC_SIZING_OF_REQUEST_HANDLER_THREADS =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(ProtocolMessages.class, RESOURCE, "INFO_ERGONOMIC_SIZING_OF_REQUEST_HANDLER_THREADS_1512", 1512);

    /**
     * An IO error occurred while reading a request from the client: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CLIENT_IO_ERROR_DURING_READ =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CLIENT_IO_ERROR_DURING_READ_1513", 1513);

    /**
     * Connection reset by client
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAP_CLIENT_IO_ERROR_BEFORE_READ =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_LDAP_CLIENT_IO_ERROR_BEFORE_READ_1514", 1514);

    /**
     * The server received configuration changes that require a restart of the %s connection handler to take effect
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONNHANDLER_CONFIG_CHANGES_REQUIRE_RESTART =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_CONNHANDLER_CONFIG_CHANGES_REQUIRE_RESTART_1516", 1516);

    /**
     * The GSER value does not contain a String matching the pattern %s at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_GSER_PATTERN_NO_MATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_PATTERN_NO_MATCH_1517", 1517);

    /**
     * The GSER value does not contain a separator at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_NO_VALID_SEPARATOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_NO_VALID_SEPARATOR_1518", 1518);

    /**
     * The GSER value does not contain a valid String value at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_NO_VALID_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_NO_VALID_STRING_1519", 1519);

    /**
     * The GSER value does not contain a valid integer value at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_NO_VALID_INTEGER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_NO_VALID_INTEGER_1520", 1520);

    /**
     * The GSER value does not contain a valid identifier at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_NO_VALID_IDENTIFIER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_NO_VALID_IDENTIFIER_1521", 1521);

    /**
     * The GSER value does not contain a whitespace character at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_SPACE_CHAR_EXPECTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_SPACE_CHAR_EXPECTED_1522", 1522);

    /**
     * The GSER value does not contain a valid IdentifiedChoiceValue at the current position: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GSER_NO_VALID_IDENTIFIEDCHOICE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_GSER_NO_VALID_IDENTIFIEDCHOICE_1523", 1523);

    /**
     * The keystore %s seems to be missing, this may render the secure port inoperative for '%s'. Verify the keystore setting in the configuration.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_NULL_KEY_PROVIDER_MANAGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_NULL_KEY_PROVIDER_MANAGER_1524", 1524);

    /**
     * Authorization as '%s' specified in the proxied authorization control is not permitted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH_AUTHZ_NOT_PERMITTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH_AUTHZ_NOT_PERMITTED_1525", 1525);

    /**
     * The key with alias '%s' was not found for '%s'. Verify that the keystore is properly configured
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_KEYSTORE_DOES_NOT_CONTAIN_ALIAS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ProtocolMessages.class, RESOURCE, "ERR_KEYSTORE_DOES_NOT_CONTAIN_ALIAS_1526", 1526);

    /**
     * No usable key was found for '%s'. Verify the keystore content
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_INVALID_KEYSTORE_1527", 1527);

    /**
     * Disabling %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DISABLE_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "INFO_DISABLE_CONNECTION_1528", 1528);

    /**
     * Failed to initialize Http Connection Handler
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INITIALIZE_HTTP_CONNECTION_HANDLER =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_INITIALIZE_HTTP_CONNECTION_HANDLER_1529", 1529);

    /**
     * No value was provided for the transaction id control, whereas an UTF-8 encoded value is expected
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TRANSACTION_ID_CONTROL_HAS_NO_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ProtocolMessages.class, RESOURCE, "ERR_TRANSACTION_ID_CONTROL_HAS_NO_VALUE_1530", 1530);

    /**
     * Exception on the underlying client connection: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNEXPECTED_EXCEPTION_ON_CLIENT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_UNEXPECTED_EXCEPTION_ON_CLIENT_CONNECTION_1531", 1531);

    /**
     * The underlying client connection timed out or closed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_IO_ERROR_ON_CLIENT_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_IO_ERROR_ON_CLIENT_CONNECTION_1532", 1532);

    /**
     * Use of the proxied authorization V2 control for user %s is not allowed: the account is disabled
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_ACCOUNT_DISABLED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_ACCOUNT_DISABLED_1533", 1533);

    /**
     * Use of the proxied authorization V2 control for user %s is not allowed: the account is expired
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_ACCOUNT_EXPIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_ACCOUNT_EXPIRED_1534", 1534);

    /**
     * Use of the proxied authorization V2 control for user %s is not allowed: the account is locked
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_ACCOUNT_LOCKED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_ACCOUNT_LOCKED_1535", 1535);

    /**
     * Use of the proxied authorization V2 control for user %s is not allowed: the account's password is expired
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROXYAUTH2_PASSWORD_EXPIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ProtocolMessages.class, RESOURCE, "ERR_PROXYAUTH2_PASSWORD_EXPIRED_1536", 1536);

}
