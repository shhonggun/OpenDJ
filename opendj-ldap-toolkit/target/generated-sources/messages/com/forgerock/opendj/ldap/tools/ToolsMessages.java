package com.forgerock.opendj.ldap.tools;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.ldap.tools.tools}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/ldap/tools/tools.properties} and it should not be manually edited.
 */
public final class ToolsMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.ldap.tools.tools";

    // Prevent instantiation.
    private ToolsMessages() {
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
     * %s
Stopping...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERROR_RATE_TOOLS_CANNOT_GET_CONNECTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERROR_RATE_TOOLS_CANNOT_GET_CONNECTION", -1);

    /**
     * A deletion threshold should not be specified when deletion is disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRATE_DELMODE_OFF_THRESHOLD_ON =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_ADDRATE_DELMODE_OFF_THRESHOLD_ON", -1);

    /**
     * A age based deletion threshold should not be used with a random deletion mode
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRATE_DELMODE_RAND_THRESHOLD_AGE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_ADDRATE_DELMODE_RAND_THRESHOLD_AGE", -1);

    /**
     * The size threshold must be lower than the maximum number of add operations
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRATE_SIZE_THRESHOLD_LOWER_THAN_ITERATIONS =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_ADDRATE_SIZE_THRESHOLD_LOWER_THAN_ITERATIONS", -1);

    /**
     * Size and age based deletion thresholds were both specified, but only only one at a time is supported
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ADDRATE_THRESHOLD_SIZE_AND_AGE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_ADDRATE_THRESHOLD_SIZE_AND_AGE", -1);

    /**
     * Authentication information must be provided to use this tool
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHRATE_NO_BIND_DN_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_AUTHRATE_NO_BIND_DN_PROVIDED", -1);

    /**
     * An error occurred while attempting to read the base64-encoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_READ_ENCODED_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_CANNOT_READ_ENCODED_DATA", -1);

    /**
     * An error occurred while attempting to read the raw data to encode: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_READ_RAW_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_CANNOT_READ_RAW_DATA", -1);

    /**
     * An error occurred while attempting to write the encoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_WRITE_ENCODED_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_CANNOT_WRITE_ENCODED_DATA", -1);

    /**
     * An error occurred while attempting to write the decoded data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_CANNOT_WRITE_RAW_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_CANNOT_WRITE_RAW_DATA", -1);

    /**
     * Unable to decode provided data: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_ERROR_DECODING_RAW_DATA =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_ERROR_DECODING_RAW_DATA", -1);

    /**
     * A subcommand must be specified with this tool.
Please use either 'base64 encode' or 'base64 decode'.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_BASE64_NO_SUBCOMMAND_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_BASE64_NO_SUBCOMMAND_SPECIFIED", -1);

    /**
     * Unknown subcommand %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE64_UNKNOWN_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_BASE64_UNKNOWN_SUBCOMMAND", -1);

    /**
     * An unexpected error occurred while attempting to initialize the command-line arguments:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_ARGS", -1);

    /**
     * Unable to parse a constant argument expecting name=value but got %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONSTANT_ARG_CANNOT_DECODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_CONSTANT_ARG_CANNOT_DECODE", -1);

    /**
     * Invalid format for criticality value '%s' in control '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DECODE_CONTROL_CRITICALITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_DECODE_CONTROL_CRITICALITY", -1);

    /**
     * # %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DECODE_CONTROL_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_DECODE_CONTROL_FAILURE", -1);

    /**
     * The authorization ID "%s" contained in the geteffectiverights control is invalid because it does not start with "dn:" to indicate a user DN
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EFFECTIVERIGHTS_INVALID_AUTHZID =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_EFFECTIVERIGHTS_INVALID_AUTHZID", -1);

    /**
     * An error occurred while parsing the command-line arguments:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_PARSING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_ERROR_PARSING_ARGS", -1);

    /**
     * Invalid attribute string '%s'. The attribute string must be in one of the following forms: 'attribute:value', 'attribute::base64value', or 'attribute:<valueFilePath'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPCOMPARE_INVALID_ATTR_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAPCOMPARE_INVALID_ATTR_STRING", -1);

    /**
     * An error occurred while reading DN(s) from standard input: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPDELETE_READING_STDIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAPDELETE_READING_STDIN", -1);

    /**
     * The LDAP password modify operation failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAPPWMOD_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAPPWMOD_FAILED", -1);

    /**
     * The LDAP bind request failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAPP_BIND_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAPP_BIND_FAILED", -1);

    /**
     * The provided virtual list view descriptor was invalid.  It must be a value in the form 'beforeCount:afterCount:offset:contentCount' (where offset specifies the index of the target entry and contentCount specifies the estimated total number of results or zero if it is not known), or 'beforeCount:afterCount:assertionValue' (where the entry should be the first entry whose primary sort value is greater than or equal to the provided assertionValue).  In either case, beforeCount is the number of entries to return before the target value and afterCount is the number of entries to return after the target value
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDAPSEARCH_VLV_INVALID_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_LDAPSEARCH_VLV_INVALID_DESCRIPTOR", -1);

    /**
     * If the --%s argument is provided, then the --%s argument must also be given
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDAPSEARCH_VLV_REQUIRES_SORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAPSEARCH_VLV_REQUIRES_SORT", -1);

    /**
     * The search filter provided for the LDAP assertion control was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_ASSERTION_INVALID_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_ASSERTION_INVALID_FILTER", -1);

    /**
     * The LDAP compare request failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_COMPARE_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_COMPARE_FAILED", -1);

    /**
     * The LDAP delete request failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_DELETE_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_DELETE_FAILED", -1);

    /**
     * The provided matched values filter was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MATCHEDVALUES_INVALID_FILTER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_MATCHEDVALUES_INVALID_FILTER", -1);

    /**
     * The LDAP modify request failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_MODIFY_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_MODIFY_FAILED", -1);

    /**
     * Unable to write entries on the output because '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_MODIFY_WRITTING_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_MODIFY_WRITTING_ENTRIES", -1);

    /**
     * The LDAP search request failed: %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_LDAP_SEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_SEARCH_FAILED", -1);

    /**
     * The provided sort order was invalid:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_SORTCONTROL_INVALID_ORDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDAP_SORTCONTROL_INVALID_ORDER", -1);

    /**
     * The differences could not be computed for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFDIFF_DIFF_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIFDIFF_DIFF_FAILED", -1);

    /**
     * Unable to use stdin for both the source LDIF and target LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIFDIFF_MULTIPLE_USES_OF_STDIN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_LDIFDIFF_MULTIPLE_USES_OF_STDIN", -1);

    /**
     * Unable to use stdin for both the source LDIF and changes LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIFMODIFY_MULTIPLE_USES_OF_STDIN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_LDIFMODIFY_MULTIPLE_USES_OF_STDIN", -1);

    /**
     * The changes could not be applied for the following reason: %s
Ensure that no modification operations are done on previously added or deleted entries.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFMODIFY_PATCH_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIFMODIFY_PATCH_FAILED", -1);

    /**
     * The search could not be performed for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIFSEARCH_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIFSEARCH_FAILED", -1);

    /**
     * An error occurred while attempting to open the LDIF file %s for reading:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_FILE_CANNOT_OPEN_FOR_READ =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_LDIF_FILE_CANNOT_OPEN_FOR_READ", -1);

    /**
     * An error occurred while attempting to open the LDIF file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_LDIF_FILE_CANNOT_OPEN_FOR_WRITE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_LDIF_FILE_CANNOT_OPEN_FOR_WRITE", -1);

    /**
     * An error occurred while attempting to read the contents of LDIF file(s):  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_FILE_READ_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIF_FILE_READ_ERROR", -1);

    /**
     * An error occurred while parsing template file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_GEN_TOOL_EXCEPTION_DURING_PARSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIF_GEN_TOOL_EXCEPTION_DURING_PARSE", -1);

    /**
     * The specified resource directory %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDIF_GEN_TOOL_NO_SUCH_RESOURCE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_LDIF_GEN_TOOL_NO_SUCH_RESOURCE_DIRECTORY", -1);

    /**
     * An error occurred while writing data to LDIF file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_ERROR_WRITING_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_MAKELDIF_ERROR_WRITING_LDIF", -1);

    /**
     * An error occurred while processing :  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MAKELDIF_EXCEPTION_DURING_PROCESSING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_MAKELDIF_EXCEPTION_DURING_PROCESSING", -1);

    /**
     * An error occurred while attempting to open LDIF file %s for writing:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MAKELDIF_UNABLE_TO_CREATE_LDIF =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "ERR_MAKELDIF_UNABLE_TO_CREATE_LDIF", -1);

    /**
     * The persistent search descriptor %s did not start with the required 'ps' string
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_DOESNT_START_WITH_PS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_PSEARCH_DOESNT_START_WITH_PS", -1);

    /**
     * The provided changesOnly value %s is invalid.  Allowed values are 1 to only return matching entries that have changed since the beginning of the search, or 0 to also include existing entries that match the search criteria
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_CHANGESONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_CHANGESONLY", -1);

    /**
     * The provided change type value %s is invalid.  The recognized change types are add, delete, modify, modifydn, and any
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_CHANGE_TYPE", -1);

    /**
     * The provided returnECs value %s is invalid.  Allowed values are 1 to request that the entry change notification control be included in updated entries, or 0 to exclude the control from matching entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PSEARCH_INVALID_RETURN_ECS =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_PSEARCH_INVALID_RETURN_ECS", -1);

    /**
     * The request to use the persistent search control did not include a descriptor that indicates the options to use with that control
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_PSEARCH_MISSING_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "ERR_PSEARCH_MISSING_DESCRIPTOR", -1);

    /**
     * %s must be used if %s is %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_TOOL_ARG_MUST_BE_USED_WHEN_ARG_CONDITION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_ARG_MUST_BE_USED_WHEN_ARG_CONDITION", -1);

    /**
     * Additional Information:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_ERROR_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_ERROR_MESSAGE", -1);

    /**
     * Invalid control specification '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_INVALID_CONTROL_STRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_INVALID_CONTROL_STRING", -1);

    /**
     * Matched DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_TOOL_MATCHED_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_MATCHED_DN", -1);

    /**
     * %s argument must be greater than or equal to %s (%s per %s)
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_TOOL_NOT_ENOUGH_ITERATIONS =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_NOT_ENOUGH_ITERATIONS", -1);

    /**
     * Result Code:  %d (%s)
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_TOOL_RESULT_CODE =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(ToolsMessages.class, RESOURCE, "ERR_TOOL_RESULT_CODE", -1);

    /**
     * A constant that overrides the value set in the template file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_CONSTANT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_CONSTANT", -1);

    /**
     * Specifies the age at which added entries will become candidates for deletion
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_DELETEAGETHRESHOLD =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_DELETEAGETHRESHOLD", -1);

    /**
     * The algorithm used for selecting entries to be deleted which must be one of "fifo", "random", or "off".
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_DELETEMODE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_DELETEMODE", -1);

    /**
     * Specifies the number of entries to be added before deletion begins
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_DELETESIZETHRESHOLD =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_DELETESIZETHRESHOLD", -1);

    /**
     * Disable the purge phase when the tool stops.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_NOPURGE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_NOPURGE", -1);

    /**
     * Path to look for template resources (e.g. data files)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_RESOURCE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_RESOURCE_PATH", -1);

    /**
     * The seed to use for initializing the random number generator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_DESCRIPTION_SEED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_DESCRIPTION_SEED", -1);

    /**
     * This utility can be used to measure add and optionally delete throughput and response time of a directory server using user-defined entries. The {template-file-path} argument identifies a template file that has the same form as a template file for the makeldif command.

Examples:
   This example adds entries and randomly deletes them while the number of entries added is greater than 10,000: 
 addrate -p 1389 -f -c 10 -C random -s 10000 addrate.template 
 This example adds entries and starts to delete them in the same order if their age is greater than a certain time: 
 addrate -p 1389 -f -c 10 -C fifo -a 2 addrate.template

For details about the template file, see makeldif.template
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRATE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ADDRATE_TOOL_DESCRIPTION", -1);

    /**
     * {filter}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ASSERTION_FILTER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ASSERTION_FILTER_PLACEHOLDER", -1);

    /**
     * {attrList}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ATTRIBUTE_LIST_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ATTRIBUTE_LIST_PLACEHOLDER", -1);

    /**
     * {attribute}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ATTRIBUTE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_ATTRIBUTE_PLACEHOLDER", -1);

    /**
     * This utility can be used to measure bind throughput and response time of a directory service using user-defined bind or search-then-bind operations.

Format strings may be used in the bind DN option as well as the authid and authzid SASL bind options. A search operation may be used to retrieve the bind DN by specifying the base DN and a filter. The retrieved entry DN will be appended as the last argument in the argument list when evaluating format strings.

Example (bind only):

  authrate -p 1389 -D "uid=user.%%d,ou=people,dc=example,dc=com" \
     -w password -f -c 10 -g "rand(0,2000)"

Example (search then bind):

  authrate -p 1389 -D '%%2$s' -w password -f -c 10 \
    -b "ou=people,dc=example,dc=com" -s one -g "rand(0,2000)" "(uid=user.%%d)"

Before trying the example, import 2000 randomly generated users
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_AUTHRATE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_AUTHRATE_TOOL_DESCRIPTION", -1);

    /**
     * Decode base64-encoded information into raw data. When no options are specified, this subcommand reads from standard input and writes to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_DECODE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_DECODE_DESCRIPTION", -1);

    /**
     * The base64-encoded data to be decoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODED_DATA_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_ENCODED_DATA_DESCRIPTION", -1);

    /**
     * The path to a file containing the base64-encoded data to be decoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODED_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_ENCODED_FILE_DESCRIPTION", -1);

    /**
     * Encode raw data using base64. When no options are specified, this subcommand reads from standard input and writes to standard output
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_ENCODE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_ENCODE_DESCRIPTION", -1);

    /**
     * The raw data to be base64 encoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_RAW_DATA_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_RAW_DATA_DESCRIPTION", -1);

    /**
     * The path to a file containing the raw data to be base64 encoded
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_RAW_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_RAW_FILE_DESCRIPTION", -1);

    /**
     * This utility can be used to encode and decode information using base64
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_TOOL_DESCRIPTION", -1);

    /**
     * The path to a file to which the base64-encoded data should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TO_ENCODED_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_TO_ENCODED_FILE_DESCRIPTION", -1);

    /**
     * The path to a file to which the raw base64-decoded data should be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASE64_TO_RAW_FILE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASE64_TO_RAW_FILE_DESCRIPTION", -1);

    /**
     * {baseDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BASEDN_PLACEHOLDER", -1);

    /**
     * # Your account has been locked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_ACCOUNT_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BIND_ACCOUNT_LOCKED", -1);

    /**
     * # Bound with authorization ID %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_BIND_AUTHZID_RETURNED =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_BIND_AUTHZID_RETURNED", -1);

    /**
     * # You have %d grace logins remaining
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_BIND_GRACE_LOGINS_REMAINING =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_BIND_GRACE_LOGINS_REMAINING", -1);

    /**
     * # You must change your password before any other operations will be allowed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_MUST_CHANGE_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BIND_MUST_CHANGE_PASSWORD", -1);

    /**
     * # Your password has expired
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BIND_PASSWORD_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_BIND_PASSWORD_EXPIRED", -1);

    /**
     * # Your password will expire in %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_BIND_PASSWORD_EXPIRING =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_BIND_PASSWORD_EXPIRING", -1);

    /**
     * The assertion value was indicated to be base64-encoded, but an error occurred while trying to decode the value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COMPARE_CANNOT_BASE64_DECODE_ASSERTION_VALUE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_COMPARE_CANNOT_BASE64_DECODE_ASSERTION_VALUE", -1);

    /**
     * Unable to read the assertion value from the specified file:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_CANNOT_READ_ASSERTION_VALUE_FROM_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_COMPARE_CANNOT_READ_ASSERTION_VALUE_FROM_FILE", -1);

    /**
     * Compare operation returned false for entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_OPERATION_RESULT_FALSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_COMPARE_OPERATION_RESULT_FALSE", -1);

    /**
     * Compare operation returned true for entry %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_COMPARE_OPERATION_RESULT_TRUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_COMPARE_OPERATION_RESULT_TRUE", -1);

    /**
     * {name=value}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONSTANT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_CONSTANT_PLACEHOLDER", -1);

    /**
     * {currentPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CURRENT_PASSWORD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_CURRENT_PASSWORD_PLACEHOLDER", -1);

    /**
     * {data}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATA_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DATA_PLACEHOLDER", -1);

    /**
     * {seconds}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETEAGETHRESHOLD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DELETEAGETHRESHOLD_PLACEHOLDER", -1);

    /**
     * {fifo | random | off}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETEMODE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DELETEMODE_PLACEHOLDER", -1);

    /**
     * {count}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETESIZETHRESHOLD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DELETESIZETHRESHOLD_PLACEHOLDER", -1);

    /**
     * Delete the specified entry and all entries below it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_DESCRIPTION_DELETE_SUBTREE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DELETE_DESCRIPTION_DELETE_SUBTREE", -1);

    /**
     * {dereferencePolicy}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DEREFERENCE_POLICE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DEREFERENCE_POLICE_PLACEHOLDER", -1);

    /**
     * Use the LDAP assertion control with the provided filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ASSERTION_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_ASSERTION_FILTER", -1);

    /**
     * Count the number of entries returned by the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_COUNT_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_COUNT_ENTRIES", -1);

    /**
     * Specifies geteffectiverights control specific attribute list
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_EFFECTIVERIGHTS_ATTR =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_EFFECTIVERIGHTS_ATTR", -1);

    /**
     * Use geteffectiverights control with the provided authzid
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_EFFECTIVERIGHTS_USER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_EFFECTIVERIGHTS_USER", -1);

    /**
     * Use the LDAP matched values control with the provided filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_MATCHED_VALUES_FILTER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_MATCHED_VALUES_FILTER", -1);

    /**
     * Use the LDAP ReadEntry post-read control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_POSTREAD_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_POSTREAD_ATTRS", -1);

    /**
     * Use the LDAP ReadEntry pre-read control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PREREAD_ATTRS =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_PREREAD_ATTRS", -1);

    /**
     * Use the proxied authorization control with the given authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PROXY_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_PROXY_AUTHZID", -1);

    /**
     * Use the persistent search control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PSEARCH_INFO =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_PSEARCH_INFO", -1);

    /**
     * Use the simple paged results control with the given page size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SIMPLE_PAGE_SIZE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_SIMPLE_PAGE_SIZE", -1);

    /**
     * Sort the results using the provided sort order
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SORT_ORDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_SORT_ORDER", -1);

    /**
     * Use subentries control to specify that subentries are visible and normal entries are not
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBENTRIES =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBENTRIES", -1);

    /**
     * Only retrieve attribute names but not their values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TYPES_ONLY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_TYPES_ONLY", -1);

    /**
     * Use the virtual list view control to retrieve the specified results page
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_VLV =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_DESCRIPTION_VLV", -1);

    /**
     * {file}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_FILE_PLACEHOLDER", -1);

    /**
     * {filter}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILTER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_FILTER_PLACEHOLDER", -1);

    /**
     * File containing the DNs of the entries to compare
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPCOMPARE_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPCOMPARE_DESCRIPTION_FILENAME", -1);

    /**
     * Use the LDAP compare result as an exit code for the LDAP compare operations
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPCOMPARE_DESCRIPTION_USE_COMPARE_RESULT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPCOMPARE_DESCRIPTION_USE_COMPARE_RESULT", -1);

    /**
     * This utility can be used to perform LDAP compare operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPCOMPARE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPCOMPARE_TOOL_DESCRIPTION", -1);

    /**
     * This utility can be used to perform LDAP delete operations in the Directory Server.
 If standard input is used to specify entries to remove, end your input with EOF (Ctrl+D on UNIX, Ctrl+Z on Windows)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPDELETE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPDELETE_TOOL_DESCRIPTION", -1);

    /**
     * LDIF file containing the changes to apply
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_DESCRIPTION_FILENAME =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPMODIFY_DESCRIPTION_FILENAME", -1);

    /**
     * Target entry after the operation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_POSTREAD_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPMODIFY_POSTREAD_ENTRY", -1);

    /**
     * Target entry before the operation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_PREREAD_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPMODIFY_PREREAD_ENTRY", -1);

    /**
     * This utility can be used to perform LDAP modify, add, delete, and modify DN operations in the Directory Server. When not using file(s) to specify modifications, end your input with EOF (Ctrl+D on UNIX, Ctrl+Z on Windows)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPMODIFY_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPMODIFY_TOOL_DESCRIPTION", -1);

    /**
     * Additional Info:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPPWMOD_ADDITIONAL_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_ADDITIONAL_INFO", -1);

    /**
     * Authorization ID for the user entry whose password should be changed. The authorization ID is a string having either the prefix "dn:" followed by the user's distinguished name, or the prefix "u:" followed by a user identifier that depends on the identity mapping used to match the user identifier to an entry in the directory. Examples include "dn:uid=bjensen,ou=People,dc=example,dc=com", and, if we assume that "bjensen" is mapped to Barbara Jensen's entry, "u:bjensen"
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_AUTHZID", -1);

    /**
     * Current password for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_CURRENTPW =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_CURRENTPW", -1);

    /**
     * Path to a file containing the current password for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_CURRENTPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_CURRENTPWFILE", -1);

    /**
     * New password to provide for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_NEWPW =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_NEWPW", -1);

    /**
     * Path to a file containing the new password to provide for the target user
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_DESCRIPTION_NEWPWFILE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_DESCRIPTION_NEWPWFILE", -1);

    /**
     * Generated Password:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPPWMOD_GENERATED_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_GENERATED_PASSWORD", -1);

    /**
     * The LDAP password modify operation was successful
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_SUCCESSFUL", -1);

    /**
     * This utility can be used to perform LDAP password modify operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPPWMOD_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPPWMOD_TOOL_DESCRIPTION", -1);

    /**
     * #   The account has been deactivated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_ACCT_INACTIVE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_ACCT_INACTIVE", -1);

    /**
     * # Account Usability Response Control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_HEADER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_HEADER", -1);

    /**
     * #   The account is usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_IS_USABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_IS_USABLE", -1);

    /**
     * #   The account is locked
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_LOCKED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_LOCKED", -1);

    /**
     * #   The account is not usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_NOT_USABLE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_NOT_USABLE", -1);

    /**
     * #   The password has expired
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_PW_EXPIRED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_PW_EXPIRED", -1);

    /**
     * #   The password has been reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_ACCTUSABLE_PW_RESET =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_PW_RESET", -1);

    /**
     * #   Number of grace logins remaining:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_ACCTUSABLE_REMAINING_GRACE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_REMAINING_GRACE", -1);

    /**
     * #   Time until password expiration:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_EXPIRATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_EXPIRATION", -1);

    /**
     * #   Time until the account is unlocked:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_UNLOCK =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_ACCTUSABLE_TIME_UNTIL_UNLOCK", -1);

    /**
     * # Total number of matching entries: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_MATCHING_ENTRY_COUNT", -1);

    /**
     * # Persistent search change type:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_PSEARCH_CHANGE_TYPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_PSEARCH_CHANGE_TYPE", -1);

    /**
     * # Persistent search previous entry DN:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPSEARCH_PSEARCH_PREVIOUS_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_PSEARCH_PREVIOUS_DN", -1);

    /**
     * This utility can be used to perform LDAP search operations in the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAPSEARCH_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_TOOL_DESCRIPTION", -1);

    /**
     * # VLV Content Count:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_VLV_CONTENT_COUNT =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_VLV_CONTENT_COUNT", -1);

    /**
     * # VLV Target Offset:  %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_LDAPSEARCH_VLV_TARGET_OFFSET =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_LDAPSEARCH_VLV_TARGET_OFFSET", -1);

    /**
     * Write differences to %s instead of stdout
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIFDIFF_DESCRIPTION_OUTPUT_FILENAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_OUTPUT_FILENAME", -1);

    /**
     * Use the LDAP compare result as an exit code for reporting differences between the two LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_DESCRIPTION_USE_COMPARE_RESULT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFDIFF_DESCRIPTION_USE_COMPARE_RESULT", -1);

    /**
     * No differences were detected between the source and target LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_NO_DIFFERENCES =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFDIFF_NO_DIFFERENCES", -1);

    /**
     * This utility can be used to compare two LDIF files and report the differences in LDIF format.
 If standard input is used to specify source or target, end your input with EOF (Ctrl+D on UNIX, Ctrl+Z on Windows)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFDIFF_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFDIFF_TOOL_DESCRIPTION", -1);

    /**
     * Write updated entries to %s instead of stdout
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIFMODIFY_DESCRIPTION_OUTPUT_FILENAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDIFMODIFY_DESCRIPTION_OUTPUT_FILENAME", -1);

    /**
     * This utility can be used to apply a set of modify, add, and delete operations to entries contained in an LDIF file.
 If standard input is used to specify source or changes, end your input with EOF (Ctrl+D on UNIX, Ctrl+Z on Windows)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFMODIFY_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFMODIFY_TOOL_DESCRIPTION", -1);

    /**
     * The base DN for the search. If no base DN is provided, then the root DSE will be used
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_BASEDN", -1);

    /**
     * Write search results to %s instead of stdout
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDIFSEARCH_DESCRIPTION_OUTPUT_FILENAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "INFO_LDIFSEARCH_DESCRIPTION_OUTPUT_FILENAME", -1);

    /**
     * This utility can be used to perform search operations against entries contained in an LDIF file.
 If standard input is used to specify source, end your input with EOF (Ctrl+D on UNIX, Ctrl+Z on Windows)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFSEARCH_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_LDIFSEARCH_TOOL_DESCRIPTION", -1);

    /**
     * A constant that overrides the value set in the template file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAKELDIF_DESCRIPTION_CONSTANT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_DESCRIPTION_CONSTANT", -1);

    /**
     * The path to the LDIF file to be written
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAKELDIF_DESCRIPTION_LDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_DESCRIPTION_LDIF", -1);

    /**
     * Path to look for MakeLDIF resources (e.g., data files)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAKELDIF_DESCRIPTION_RESOURCE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_DESCRIPTION_RESOURCE_PATH", -1);

    /**
     * The seed to use to initialize the random number generator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAKELDIF_DESCRIPTION_SEED =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_DESCRIPTION_SEED", -1);

    /**
     * Processed %d entries
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_MAKELDIF_PROCESSED_N_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_PROCESSED_N_ENTRIES", -1);

    /**
     * LDIF processing complete. %d entries written
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_MAKELDIF_PROCESSING_COMPLETE =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_PROCESSING_COMPLETE", -1);

    /**
     * This utility can be used to generate LDIF data based on a definition in a template file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MAKELDIF_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MAKELDIF_TOOL_DESCRIPTION", -1);

    /**
     * This utility can be used to measure modify throughput and response time of a directory service using user-defined modifications.

Example:

  modrate -p 1389 -D "cn=directory manager" -w password \
    -F -c 4 -t 4 -b "uid=user.%%d,ou=people,dc=example,dc=com" \
    -g "rand(0,2000)" -g "randstr(16)" 'description:%%2$s'

Before trying the example, import 2000 randomly generated users
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODRATE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MODRATE_TOOL_DESCRIPTION", -1);

    /**
     * Target entry DN format string
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MODRATE_TOOL_DESCRIPTION_TARGETDN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_MODRATE_TOOL_DESCRIPTION_TARGETDN", -1);

    /**
     * {newPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NEW_PASSWORD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_NEW_PASSWORD_PLACEHOLDER", -1);

    /**
     * {numEntries}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUM_ENTRIES_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_NUM_ENTRIES_PLACEHOLDER", -1);

    /**
     * %s operation successful for DN %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_OPERATION_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "INFO_OPERATION_SUCCESSFUL", -1);

    /**
     * {file}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OUTPUT_LDIF_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_OUTPUT_LDIF_FILE_PLACEHOLDER", -1);

    /**
     * {path}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_PATH_PLACEHOLDER", -1);

    /**
     * Comparing type %s with value %s in entry %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_PROCESSING_COMPARE_OPERATION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(ToolsMessages.class, RESOURCE, "INFO_PROCESSING_COMPARE_OPERATION", -1);

    /**
     * Processing %s request for %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROCESSING_OPERATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ToolsMessages.class, RESOURCE, "INFO_PROCESSING_OPERATION", -1);

    /**
     * {authzID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROXYAUTHID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_PROXYAUTHID_PLACEHOLDER", -1);

    /**
     * ps[:changetype[:changesonly[:entrychgcontrols]]]
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PSEARCH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_PSEARCH_PLACEHOLDER", -1);

    /**
     * This utility can be used to measure search throughput and response time of a directory service using user-defined searches.

Example:

  searchrate -p 1389 -D "cn=directory manager" -w password \
    -F -c 4 -t 4 -b "dc=example,dc=com" -g "rand(0,2000)" "(uid=user.%%d)"

Before trying the example, import 2000 randomly generated users
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCHRATE_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCHRATE_TOOL_DESCRIPTION", -1);

    /**
     * Base DN format string.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCHRATE_TOOL_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCHRATE_TOOL_DESCRIPTION_BASEDN", -1);

    /**
     * Search base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_BASEDN", -1);

    /**
     * Alias dereference policy ('never', 'always', 'search', or 'find')
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_DEREFERENCE_POLICY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_DEREFERENCE_POLICY", -1);

    /**
     * Maximum number of entries to return from the search
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_SIZE_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_SIZE_LIMIT", -1);

    /**
     * Maximum length of time in seconds to allow for the search
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_TIME_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_TIME_LIMIT", -1);

    /**
     * {seed}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEED_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SEED_PLACEHOLDER", -1);

    /**
     * {sizeLimit}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SIZE_LIMIT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SIZE_LIMIT_PLACEHOLDER", -1);

    /**
     * {sortOrder}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SORT_ORDER_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_SORT_ORDER_PLACEHOLDER", -1);

    /**
     * {targetDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TARGETDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_TARGETDN_PLACEHOLDER", -1);

    /**
     * {timeLimit}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TIME_LIMIT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_TIME_LIMIT_PLACEHOLDER", -1);

    /**
     * Warming up for %d seconds...
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_TOOL_WARMING_UP =
                    new LocalizableMessageDescriptor.Arg1<Number>(ToolsMessages.class, RESOURCE, "INFO_TOOL_WARMING_UP", -1);

    /**
     * {before:after:index:count | before:after:value}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VLV_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "INFO_VLV_PLACEHOLDER", -1);

    /**
     * measure add and delete throughput and response time
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_ADDRATE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_ADDRATE", -1);

    /**
     * measure bind throughput and response time
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_AUTHRATE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_AUTHRATE", -1);

    /**
     * encode and decode base64 strings
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_BASE64 =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_BASE64", -1);

    /**
     * perform LDAP compare operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPCOMPARE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPCOMPARE", -1);

    /**
     * perform LDAP delete operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPDELETE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPDELETE", -1);

    /**
     * perform LDAP modify, add, delete, mod DN operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPMODIFY", -1);

    /**
     * perform LDAP password modifications
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPPASSWORDMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPPASSWORDMODIFY", -1);

    /**
     * perform LDAP search operations
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDAPSEARCH =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDAPSEARCH", -1);

    /**
     * compare small LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFDIFF =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFDIFF", -1);

    /**
     * apply LDIF changes to LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFMODIFY =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFMODIFY", -1);

    /**
     * search LDIF with LDAP filters
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_LDIFSEARCH =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_LDIFSEARCH", -1);

    /**
     * generate test LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_MAKELDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_MAKELDIF", -1);

    /**
     * measure modification throughput and response time
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_MODRATE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_MODRATE", -1);

    /**
     * measure search throughput and response time
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_SEARCHRATE =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "REF_SHORT_DESC_SEARCHRATE", -1);

    /**
     * <xinclude:include href="description-makeldif.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_MAKELDIF =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_MAKELDIF", -1);

    /**
     * <xinclude:include href="description-psearch-info.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_PSEARCH_INFO =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_PSEARCH_INFO", -1);

    /**
     * <xinclude:include href="description-rate-tools.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_RATE_TOOLS =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_RATE_TOOLS", -1);

    /**
     * <xinclude:include href="description-resource-path.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_RESOURCE_PATH =
                    new LocalizableMessageDescriptor.Arg0(ToolsMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_RESOURCE_PATH", -1);

    /**
     * # Server-side sort failed:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_SORT_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "WARN_LDAPSEARCH_SORT_ERROR", -1);

    /**
     * # Virtual list view processing failed: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_LDAPSEARCH_VLV_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(ToolsMessages.class, RESOURCE, "WARN_LDAPSEARCH_VLV_ERROR", -1);

}
