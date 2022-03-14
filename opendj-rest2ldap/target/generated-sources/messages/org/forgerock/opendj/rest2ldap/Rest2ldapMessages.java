package org.forgerock.opendj.rest2ldap;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.forgerock.opendj.rest2ldap.rest2ldap}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/forgerock/opendj/rest2ldap/rest2ldap.properties} and it should not be manually edited.
 */
public final class Rest2ldapMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.forgerock.opendj.rest2ldap.rest2ldap";

    // Prevent instantiation.
    private Rest2ldapMessages() {
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
     * Unable to start Rest2Ldap Http Application due to the configuration error: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FAIL_PARSE_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_FAIL_PARSE_CONFIGURATION_1", 1);

    /**
     * '%s'is not a supported access token resolver. Must be one of '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_OAUTH2_UNSUPPORTED_ACCESS_TOKEN_RESOLVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_UNSUPPORTED_ACCESS_TOKEN_RESOLVER_2", 2);

    /**
     * The token introspection endpoint '%s' is not a valid URL: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_OAUTH2_INVALID_INTROSPECT_URL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_INVALID_INTROSPECT_URL_3", 3);

    /**
     * The cache expiration duration cannot be zero
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_OAUTH2_CACHE_ZERO_DURATION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_CACHE_ZERO_DURATION_4", 4);

    /**
     * The cache expiration duration cannot be unlimited
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_OAUTH2_CACHE_UNLIMITED_DURATION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_CACHE_UNLIMITED_DURATION_5", 5);

    /**
     * Malformed duration value '%s' for cache expiration. The duration syntax supports all human readable notations from day ('days'', 'day'', 'd'') to nanosecond ('nanoseconds', 'nanosecond', 'nanosec', 'nanos', 'nano', 'ns')
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_OAUTH2_CACHE_INVALID_DURATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_OAUTH2_CACHE_INVALID_DURATION_6", 6);

    /**
     * Unsupported bind strategy '%s'. Must be one of '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_UNSUPPORTED_BIND_STRATEGY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_UNSUPPORTED_BIND_STRATEGY_7", 7);

    /**
     * Invalid authorization ID template: '%s'.Templates must start with one of the following elements: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_INVALID_AUTHZID_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_INVALID_AUTHZID_TEMPLATE_8", 8);

    /**
     * Only simple authentication is supported
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_INVALID_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_INVALID_AUTHENTICATION_9", 9);

    /**
     * secondaryLDAPServers configuration must contain a json array
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_INVALID_SECONDARY_LDAP_SERVER =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_INVALID_SECONDARY_LDAP_SERVER_10", 10);

    /**
     * The LDAP server configuration '%s' could not be parsed because of potential circular inheritance dependencies
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_SERVER_CIRCULAR_DEPENDENCIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_SERVER_CIRCULAR_DEPENDENCIES_11", 11);

    /**
     * Naming strategy DN and ID must be different
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_NAMING_STRATEGY_DN_AND_ID_NOT_DIFFERENT =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_NAMING_STRATEGY_DN_AND_ID_NOT_DIFFERENT_12", 12);

    /**
     * No mappings provided in configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_NO_MAPPINGS_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_NO_MAPPINGS_PROVIDED_13", 13);

    /**
     * Unknown mapping. The configuration mapping must be one of '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONFIG_NO_MAPPING_IN_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_NO_MAPPING_IN_CONFIGURATION_14", 14);

    /**
     * Unknown writability '%s'. Must be one of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_UNKNOWN_WRITABILITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_UNKNOWN_WRITABILITY_15", 15);

    /**
     * Unknown naming strategy '%s'. Must be one of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_UNKNOWN_NAMING_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_UNKNOWN_NAMING_CONFIGURATION_16", 16);

    /**
     * The request could not be authorized because the required security principal '%s' could not be determined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_AUTHZID_DECODER_PRINCIPAL_CANNOT_BE_DETERMINED =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_AUTHZID_DECODER_PRINCIPAL_CANNOT_BE_DETERMINED_17", 17);

    /**
     * The request could not be authorized because the required security principal '%s' had an invalid data type
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_AUTHZID_DECODER_PRINCIPAL_INVALID_DATA_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_AUTHZID_DECODER_PRINCIPAL_INVALID_DATA_TYPE_18", 18);

    /**
     * Unable to resolve oauthzid template placeholders for access token '%s': '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RESOLVING_AUTHZID_TEMPLATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_RESOLVING_AUTHZID_TEMPLATE_20", 20);

    /**
     * The token '%s' must be an access token, but it is a '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OAUTH2_CTS_INVALID_TOKEN_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_CTS_INVALID_TOKEN_TYPE_21", 21);

    /**
     * Unable to find the token '%s' in the CTS because: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OAUTH2_CTS_TOKEN_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_CTS_TOKEN_NOT_FOUND_22", 22);

    /**
     * Unable to resolve access token '%s' due to the following reason: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OAUTH2_CTS_TOKEN_RESOLUTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_CTS_TOKEN_RESOLUTION_23", 23);

    /**
     * Json of token '%s' is malformed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OAUTH2_CTS_INVALID_JSON_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_CTS_INVALID_JSON_TOKEN_24", 24);

    /**
     * Unable to find token file '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OAUTH2_FILE_NO_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_FILE_NO_TOKEN_25", 25);

    /**
     * Malformed token file '%s'. Details: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_OAUTH2_FILE_INVALID_JSON_TOKEN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_FILE_INVALID_JSON_TOKEN_26", 26);

    /**
     * Authorization server returned an error: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OAUTH2_RFC7662_RETURNED_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_RFC7662_RETURNED_ERROR_27", 27);

    /**
     * Access token returned by authorization server is not currently active
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OAUTH2_RFC7662_TOKEN_NOT_ACTIVE =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_RFC7662_TOKEN_NOT_ACTIVE_28", 28);

    /**
     * Invalid or malformed access token: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OAUTH2_RFC7662_INVALID_JSON_TOKEN =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_RFC7662_INVALID_JSON_TOKEN_29", 29);

    /**
     * Cannot read response content as JSON
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OAUTH2_RFC7662_CANNOT_READ_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_OAUTH2_RFC7662_CANNOT_READ_RESPONSE_30", 30);

    /**
     * The create request cannot be processed because it attempts to create the read-only field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATION_READ_ONLY_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CREATION_READ_ONLY_FIELD_31", 31);

    /**
     * The %s request cannot be processed because it attempts to remove the required field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REMOVE_REQUIRED_FIELD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_REMOVE_REQUIRED_FIELD_32", 32);

    /**
     * The %s request cannot be processed because it attempts to modify the read-only field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MODIFY_READ_ONLY_FIELD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_MODIFY_READ_ONLY_FIELD_33", 33);

    /**
     * The patch request cannot be processed because it attempts to patch the read-only field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_READ_ONLY_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_READ_ONLY_FIELD_34", 34);

    /**
     * The request cannot be processed because an array of values was provided for the single valued field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARRAY_FOR_SINGLE_VALUED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ARRAY_FOR_SINGLE_VALUED_FIELD_35", 35);

    /**
     * The request cannot be processed because an array of values was not provided for the multi-valued field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_NO_ARRAY_FOR_MULTI_VALUED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_NO_ARRAY_FOR_MULTI_VALUED_FIELD_36", 36);

    /**
     * The patch request cannot be processed because it attempts to append a value to the single valued field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_APPEND_IN_SINGLE_VALUED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_APPEND_IN_SINGLE_VALUED_FIELD_37", 37);

    /**
     * The patch request cannot be processed because it attempts to perform an indexed append of an array of values to the multi-valued field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_INDEXED_APPEND_TO_MULTI_VALUED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_INDEXED_APPEND_TO_MULTI_VALUED_FIELD_38", 38);

    /**
     * The patch request cannot be processed because it included an indexed patch operation '%s' which is not supported by this resource provider
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_INDEXED_OPERATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_INDEXED_OPERATION_39", 39);

    /**
     * The request cannot be processed because it included an unrecognized field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNRECOGNIZED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_UNRECOGNIZED_FIELD_40", 40);

    /**
     * The request cannot be processed because it included the field '%s' whose value is the wrong type: an object is expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_FIELD_WRONG_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_FIELD_WRONG_TYPE_41", 41);

    /**
     * The patch request cannot be processed because it included an add patch operation but no value(s) for field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_ADD_NO_VALUE_FOR_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_ADD_NO_VALUE_FOR_FIELD_42", 42);

    /**
     * The patch request cannot be processed because it included an unsupported type of patch operation '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PATCH_UNSUPPORTED_OPERATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_UNSUPPORTED_OPERATION_43", 43);

    /**
     * Multi-version concurrency control is not supported by this resource
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MVCC_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_MVCC_NOT_SUPPORTED_44", 44);

    /**
     * The resource could not be accessed because it did not contain any version information, when the version '%s' was expected
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MVCC_NO_VERSION_INFORMATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_MVCC_NO_VERSION_INFORMATION_45", 45);

    /**
     * The resource could not be accessed because the expected version '%s' does not match the current version '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MVCC_VERSIONS_MISMATCH =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_MVCC_VERSIONS_MISMATCH_46", 46);

    /**
     * The request cannot be processed because the reference field '%s' contains a value which does not contain a primary key
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REFERENCE_FIELD_NO_PRIMARY_KEY =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_REFERENCE_FIELD_NO_PRIMARY_KEY_47", 47);

    /**
     * The request cannot be processed because the reference field '%s' contains a value which contains multiple primary keys
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REFERENCE_FIELD_MULTIPLE_PRIMARY_KEYS =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_REFERENCE_FIELD_MULTIPLE_PRIMARY_KEYS_48", 48);

    /**
     * The request cannot be processed because the resource '%s' referenced in field '%s' does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REFERENCE_FIELD_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_REFERENCE_FIELD_DOES_NOT_EXIST_49", 49);

    /**
     * The request cannot be processed because the resource '%s' referenced in field '%s' is ambiguous
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REFERENCE_FIELD_AMBIGUOUS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_REFERENCE_FIELD_AMBIGUOUS_50", 50);

    /**
     * The request cannot be processed because it contained an illegal filter assertion value '%s' for field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ILLEGAL_FILTER_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ILLEGAL_FILTER_ASSERTION_VALUE_51", 51);

    /**
     * The request cannot be processed because an error occurred while encoding the values for the field '%s': '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ENCODING_VALUES_FOR_FIELD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ENCODING_VALUES_FOR_FIELD_52", 52);

    /**
     * Unrecognized type of JSON value: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNRECOGNIZED_JSON_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_UNRECOGNIZED_JSON_VALUE_53", 53);

    /**
     * Resources cannot be created without a client provided resource ID
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CLIENT_PROVIDED_RESOURCE_ID_MISSING =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CLIENT_PROVIDED_RESOURCE_ID_MISSING_54", 54);

    /**
     * Not yet implemented
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NOT_YET_IMPLEMENTED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_NOT_YET_IMPLEMENTED_55", 55);

    /**
     * The action '%s' is not supported
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ACTION_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ACTION_NOT_SUPPORTED_56", 56);

    /**
     * Passwords can only be modified using a secure connection
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PASSWORD_MODIFY_SECURE_CONNECTION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_PASSWORD_MODIFY_SECURE_CONNECTION_57", 57);

    /**
     * Passwords can only be modified by authenticated users
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PASSWORD_MODIFY_USER_AUTHENTICATED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_PASSWORD_MODIFY_USER_AUTHENTICATED_58", 58);

    /**
     * Unable to decode ldap control: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DECODING_CONTROL =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_DECODING_CONTROL_59", 59);

    /**
     * An error occurred while processing the request '%s': '%s' (details: '%s')
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ERROR_RESPONSE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ERROR_RESPONSE_60", 60);

    /**
     * A runtime exception occurred wile processing the request '%s': '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_RUNTIME_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_RUNTIME_EXCEPTION_61", 61);

    /**
     * The modify password request has been rejected because it is invalid. A modify password request must contain two string valued fields 'oldPassword' and 'newPassword'
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PASSWORD_MODIFY_REQUEST_IS_INVALID =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_PASSWORD_MODIFY_REQUEST_IS_INVALID_62", 62);

    /**
     * The trust-manager defined in '%s' is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_INVALID_TRUST_MANAGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_INVALID_TRUST_MANAGER_63", 63);

    /**
     * The key-manager defined in '%s' is invalid: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONFIG_INVALID_KEY_MANAGER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_INVALID_KEY_MANAGER_64", 64);

    /**
     * The resource cannot be created because it does not contain the type property '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MISSING_TYPE_PROPERTY_IN_CREATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_MISSING_TYPE_PROPERTY_IN_CREATE_65", 65);

    /**
     * The resource cannot be created because it specified an unrecognized resource type '%s'. Please specify one of the following types: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNRECOGNIZED_TYPE_IN_CREATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_UNRECOGNIZED_TYPE_IN_CREATE_66", 66);

    /**
     * The resource cannot be created because it specified the abstract resource type '%s'. Please specify one of the following non-abstract types: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ABSTRACT_TYPE_IN_CREATE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_ABSTRACT_TYPE_IN_CREATE_67", 67);

    /**
     * Queries using _queryId or _queryExpression are not supported. Use _queryFilter instead
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_QUERY_BY_ID_OR_EXPRESSION_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_QUERY_BY_ID_OR_EXPRESSION_NOT_SUPPORTED_68", 68);

    /**
     * This endpoint is read-only and only supports read and query requests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_READ_ONLY_ENDPOINT =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_READ_ONLY_ENDPOINT_69", 69);

    /**
     * The targeted resource is a resource collection which only supports create and query requests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNSUPPORTED_REQUEST_AGAINST_COLLECTION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_UNSUPPORTED_REQUEST_AGAINST_COLLECTION_70", 70);

    /**
     * The targeted resource is a resource instance which only supports read, update, delete, patch, and action requests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNSUPPORTED_REQUEST_AGAINST_INSTANCE =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_UNSUPPORTED_REQUEST_AGAINST_INSTANCE_71", 71);

    /**
     * The targeted resource is a resource singleton which only supports read, update, patch, and action requests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNSUPPORTED_REQUEST_AGAINST_SINGLETON =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_UNSUPPORTED_REQUEST_AGAINST_SINGLETON_72", 72);

    /**
     * Resources cannot be created with a client provided resource ID. The server will automatically generate a resource ID
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SERVER_PROVIDED_RESOURCE_ID_UNEXPECTED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_SERVER_PROVIDED_RESOURCE_ID_UNEXPECTED_73", 73);

    /**
     * Collections only support create or query requests
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_COLLECTION_ACTIONS_NOT_SUPPORTED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_COLLECTION_ACTIONS_NOT_SUPPORTED_74", 74);

    /**
     * The resource '%s' has an unrecognized super-type '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNRECOGNIZED_RESOURCE_SUPER_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_UNRECOGNIZED_RESOURCE_SUPER_TYPE_75", 75);

    /**
     * The resource '%s' references an unrecognized sub-resource '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNRECOGNIZED_SUB_RESOURCE_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_UNRECOGNIZED_SUB_RESOURCE_TYPE_76", 76);

    /**
     * The create request cannot be processed because it does not include the required field '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MISSING_REQUIRED_FIELD =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_MISSING_REQUIRED_FIELD_77", 77);

    /**
     * The endpoints configuration directory '%s' either does not exist, is not a directory or cannot be read
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_ENDPOINTS_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_INVALID_ENDPOINTS_DIRECTORY_78", 78);

    /**
     * The endpoint configuration directory '%s' either does not exist, is not a directory or cannot be read
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_ENDPOINT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_INVALID_ENDPOINT_DIRECTORY_79", 79);

    /**
     * Rest2Ldap starting with configuration directory '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REST2LDAP_STARTING =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "INFO_REST2LDAP_STARTING_80", 80);

    /**
     * Rest2Ldap created endpoint '%s' version %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REST2LDAP_CREATING_ENDPOINT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "INFO_REST2LDAP_CREATING_ENDPOINT_81", 81);

    /**
     * Passwords can only be reset using a secure connection
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PASSWORD_RESET_SECURE_CONNECTION =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_PASSWORD_RESET_SECURE_CONNECTION_82", 82);

    /**
     * Passwords can only be reset by authenticated users
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PASSWORD_RESET_USER_AUTHENTICATED =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_PASSWORD_RESET_USER_AUTHENTICATED_83", 83);

    /**
     * The requested resource API version '%s' is unsupported. This endpoint only supports the following resource API version(s): %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_BAD_API_RESOURCE_VERSION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_BAD_API_RESOURCE_VERSION_84", 84);

    /**
     * The value could not be parsed as valid JSON because a syntax error was detected on line %d column %d: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Object> ERR_JSON_PARSE_ERROR =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_JSON_PARSE_ERROR_85", 85);

    /**
     * The value could not be parsed as valid JSON: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JSON_IO_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_JSON_IO_ERROR_86", 86);

    /**
     * The value could not be parsed as valid JSON because it contains trailing content after the JSON value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_JSON_TRAILING_CONTENT =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_JSON_TRAILING_CONTENT_87", 87);

    /**
     * The value could not be parsed as valid JSON because it is empty
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_JSON_EMPTY_CONTENT =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_JSON_EMPTY_CONTENT_88", 88);

    /**
     * The value '%s' could not be parsed as a valid JSON query filter
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_JSON_QUERY_PARSE_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(Rest2ldapMessages.class, RESOURCE, "ERR_JSON_QUERY_PARSE_ERROR_89", 89);

    /**
     * The patch request cannot be processed because it attempts to modify the internal field '%s' of object '%s'. This capability is not currently supported by Rest2Ldap. Applications should instead perform a patch which replaces the entire object '%s'
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_PATCH_JSON_INTERNAL_PROPERTY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(Rest2ldapMessages.class, RESOURCE, "ERR_PATCH_JSON_INTERNAL_PROPERTY_90", 90);

    /**
     * Sub-resources must be read-only to support sub-tree flattening.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONFIG_MUST_BE_READ_ONLY_TO_FLATTEN_SUBTREE =
                    new LocalizableMessageDescriptor.Arg0(Rest2ldapMessages.class, RESOURCE, "ERR_CONFIG_MUST_BE_READ_ONLY_TO_FLATTEN_SUBTREE_91", 91);

}
