package com.forgerock.opendj.cli;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.cli.cli}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/cli/cli.properties} and it should not be manually edited.
 */
public final class CliMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.cli.cli";

    // Prevent instantiation.
    private CliMessages() {
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
     * A value was provided for argument --%s but that argument does not take a value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_ARG_FOR_LONG_ID_DOESNT_TAKE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_ARG_FOR_LONG_ID_DOESNT_TAKE_VALUE", -1);

    /**
     * An error occurred while attempting to read the contents of the argument properties file %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARGPARSER_CANNOT_READ_PROPERTIES_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_CANNOT_READ_PROPERTIES_FILE", -1);

    /**
     * The provided argument block '-%s%s' is illegal because the '%s' argument requires a value but is in the same block as at least one other argument that does not require a value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ARGPARSER_CANT_MIX_ARGS_WITH_VALUES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_CANT_MIX_ARGS_WITH_VALUES", -1);

    /**
     * Argument "%s" does not start with one or two dashes and unnamed trailing arguments are not allowed
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_DISALLOWED_TRAILING_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_DISALLOWED_TRAILING_ARGUMENT", -1);

    /**
     * Cannot add argument %s to the argument list because there is already one defined with the same identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_DUPLICATE_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_DUPLICATE_LONG_ID", -1);

    /**
     * Cannot add argument %s to the argument list because its short identifier -%s conflicts with the %s argument that has already been defined
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ARGPARSER_DUPLICATE_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_DUPLICATE_SHORT_ID", -1);

    /**
     * The dash character by itself is invalid for use as an argument name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ARGPARSER_INVALID_DASH_AS_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_ARGPARSER_INVALID_DASH_AS_ARGUMENT", -1);

    /**
     * The provided argument "%s" is invalid because it does not include the argument name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_LONG_ARG_WITHOUT_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_LONG_ARG_WITHOUT_NAME", -1);

    /**
     * The argument --%s was included multiple times in the provided set of arguments but it does not allow multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NOT_MULTIVALUED_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NOT_MULTIVALUED_FOR_LONG_ID", -1);

    /**
     * The argument -%s was included multiple times in the provided set of arguments but it does not allow multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NOT_MULTIVALUED_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NOT_MULTIVALUED_FOR_SHORT_ID", -1);

    /**
     * Argument --%s is not allowed for use with this program
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NO_ARGUMENT_WITH_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NO_ARGUMENT_WITH_LONG_ID", -1);

    /**
     * Argument -%s is not allowed for use with this program
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NO_ARGUMENT_WITH_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NO_ARGUMENT_WITH_SHORT_ID", -1);

    /**
     * Argument --%s requires a value but none was provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NO_VALUE_FOR_ARGUMENT_WITH_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NO_VALUE_FOR_ARGUMENT_WITH_LONG_ID", -1);

    /**
     * Argument -%s requires a value but none was provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NO_VALUE_FOR_ARGUMENT_WITH_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NO_VALUE_FOR_ARGUMENT_WITH_SHORT_ID", -1);

    /**
     * The argument %s is required to have a value but none was provided in the argument list and no default value is available
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARGPARSER_NO_VALUE_FOR_REQUIRED_ARG =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_NO_VALUE_FOR_REQUIRED_ARG", -1);

    /**
     * At least %d unnamed trailing arguments are required in the argument list, but too few were provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ARGPARSER_TOO_FEW_TRAILING_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_TOO_FEW_TRAILING_ARGUMENTS", -1);

    /**
     * The provided set of command-line arguments contained too many unnamed trailing arguments.  The maximum number of allowed trailing arguments is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_ARGPARSER_TOO_MANY_TRAILING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_TOO_MANY_TRAILING_ARGS", -1);

    /**
     * The provided value "%s" for argument --%s is not acceptable:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ARGPARSER_VALUE_UNACCEPTABLE_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_VALUE_UNACCEPTABLE_FOR_LONG_ID", -1);

    /**
     * The provided value "%s" for argument -%s is not acceptable:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ARGPARSER_VALUE_UNACCEPTABLE_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARGPARSER_VALUE_UNACCEPTABLE_FOR_SHORT_ID", -1);

    /**
     * The provided value "%s" for the %s argument cannot be decoded as an integer
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARG_CANNOT_DECODE_AS_INT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_CANNOT_DECODE_AS_INT", -1);

    /**
     * The %s argument has multiple values and therefore cannot be decoded as a single integer value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARG_INT_MULTIPLE_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARG_INT_MULTIPLE_VALUES", -1);

    /**
     * The %s argument does not have any value that may be retrieved as an integer
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARG_NO_INT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARG_NO_INT_VALUE", -1);

    /**
     * The %s argument is configured to take a value but no value placeholder has been defined for it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARG_NO_VALUE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARG_NO_VALUE_PLACEHOLDER", -1);

    /**
     * Argument %s for subcommand %s conflicts with a global argument with the same name
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARG_SUBCOMMAND_ARGUMENT_GLOBAL_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_ARGUMENT_GLOBAL_CONFLICT", -1);

    /**
     * Failed to add Argument %s for subcommand %s because there is already a global argument defined with the same long identifier
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARG_SUBCOMMAND_ARGUMENT_LONG_ID_GLOBAL_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_ARGUMENT_LONG_ID_GLOBAL_CONFLICT", -1);

    /**
     * Argument %s for subcommand %s has a short ID -%s that conflicts with that of global argument %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ARG_SUBCOMMAND_ARGUMENT_SHORT_ID_GLOBAL_CONFLICT =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_ARGUMENT_SHORT_ID_GLOBAL_CONFLICT", -1);

    /**
     * There are multiple arguments for subcommand %s with name %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARG_SUBCOMMAND_DUPLICATE_ARGUMENT_NAME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_DUPLICATE_ARGUMENT_NAME", -1);

    /**
     * Failed to add Argument %s for subcommand %s because there is already an argument with the same identifier for this subcommand
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ARG_SUBCOMMAND_DUPLICATE_LONG_ID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_DUPLICATE_LONG_ID", -1);

    /**
     * Argument %s for subcommand %s has a short identifier -%s that conflicts with that of argument %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_ARG_SUBCOMMAND_DUPLICATE_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_DUPLICATE_SHORT_ID", -1);

    /**
     * The argument parser already has a %s subcommand
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ARG_SUBCOMMAND_DUPLICATE_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_DUPLICATE_SUBCOMMAND", -1);

    /**
     * Invalid subcommand
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ARG_SUBCOMMAND_INVALID =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_ARG_SUBCOMMAND_INVALID", -1);

    /**
     * Invalid port number "%s". Please enter a valid port number between 1 and 65535
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BAD_PORT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_BAD_PORT_NUMBER", -1);

    /**
     * The provided %s value is unacceptable because Boolean arguments are never allowed to have values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BOOLEANARG_NO_VALUE_ALLOWED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_BOOLEANARG_NO_VALUE_ALLOWED", -1);

    /**
     * Could not connect to %s. Check that the server is running and that it is accessible from the local machine.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CANNOT_CONNECT_TO_REMOTE_COMMUNICATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_REMOTE_COMMUNICATION", -1);

    /**
     * Cannot access key store '%s'.  Verify that the provided key store exists and that you have read access rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_READ_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_CANNOT_READ_KEYSTORE", -1);

    /**
     * Cannot access trust store '%s'.  Verify that the provided trust store exists and that you have read access rights to it
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_READ_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_CANNOT_READ_TRUSTSTORE", -1);

    /**
     * Confirmation tries limit reached (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CONFIRMATION_TRIES_LIMIT_REACHED =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "ERR_CONFIRMATION_TRIES_LIMIT_REACHED", -1);

    /**
     * Invalid response. Please enter "%s" or "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CONSOLE_APP_CONFIRM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_CONSOLE_APP_CONFIRM", -1);

    /**
     * The response could not be read from the console due to the following error: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONSOLE_INPUT_ERROR =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_CONSOLE_INPUT_ERROR", -1);

    /**
     * Unable to read bind name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_CANNOT_READ_BIND_NAME =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_ERROR_CANNOT_READ_BIND_NAME", -1);

    /**
     * Cannot read the host name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_CANNOT_READ_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_ERROR_CANNOT_READ_HOST_NAME", -1);

    /**
     * Unable to read password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_CANNOT_READ_PASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_ERROR_CANNOT_READ_PASSWORD", -1);

    /**
     * An error occurred while trying to open file %s specified for argument %s for reading:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILEARG_CANNOT_OPEN_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_FILEARG_CANNOT_OPEN_FILE", -1);

    /**
     * An error occurred while trying to read from file %s specified for argument %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILEARG_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_FILEARG_CANNOT_READ_FILE", -1);

    /**
     * An error occurred while trying to verify the existence of file %s specified for argument %s:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_FILEARG_CANNOT_VERIFY_FILE_EXISTENCE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_FILEARG_CANNOT_VERIFY_FILE_EXISTENCE", -1);

    /**
     * The file %s specified for argument %s exists but is empty
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILEARG_EMPTY_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_FILEARG_EMPTY_FILE", -1);

    /**
     * The file %s specified for argument %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FILEARG_NO_SUCH_FILE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_FILEARG_NO_SUCH_FILE", -1);

    /**
     * The minimum Java version required is %s.%n%nThe detected version is %s.%nThe binary detected is %s%n%nPlease set OPENDJ_JAVA_HOME to the root of a compatible Java installation or edit the java.properties file
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_INCOMPATIBLE_JAVA_VERSION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_INCOMPATIBLE_JAVA_VERSION", -1);

    /**
     * The %s argument configuration is invalid because the lower bound of %d is greater than the upper bound of %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_INTARG_LOWER_BOUND_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CliMessages.class, RESOURCE, "ERR_INTARG_LOWER_BOUND_ABOVE_UPPER_BOUND", -1);

    /**
     * The provided %s value %d is unacceptable because it is above the upper bound of %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_INTARG_VALUE_ABOVE_UPPER_BOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CliMessages.class, RESOURCE, "ERR_INTARG_VALUE_ABOVE_UPPER_BOUND", -1);

    /**
     * The provided %s value %d is unacceptable because it is below the lower bound of %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Number, Number> ERR_INTARG_VALUE_BELOW_LOWER_BOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Number, Number>(CliMessages.class, RESOURCE, "ERR_INTARG_VALUE_BELOW_LOWER_BOUND", -1);

    /**
     * The "authid" SASL property is required for use with the %s mechanism
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_SASL_AUTHID_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_LDAPAUTH_SASL_AUTHID_REQUIRED", -1);

    /**
     * The requested SASL mechanism "%s" is not supported by this client
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAPAUTH_UNSUPPORTED_SASL_MECHANISM =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_LDAPAUTH_UNSUPPORTED_SASL_MECHANISM", -1);

    /**
     * ERROR:  Unable to perform SSL initialization:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_CANNOT_INITIALIZE_SSL =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_LDAP_CONN_CANNOT_INITIALIZE_SSL", -1);

    /**
     * ERROR:  The provided SASL option string "%s" could not be parsed in the form "name=value"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_LDAP_CONN_CANNOT_PARSE_SASL_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_LDAP_CONN_CANNOT_PARSE_SASL_OPTION", -1);

    /**
     * The provided %s value %s is unacceptable because it is not included in the set of allowed values for that argument
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MCARG_VALUE_NOT_ALLOWED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_MCARG_VALUE_NOT_ALLOWED", -1);

    /**
     * Invalid response. Please enter one or more valid menu options
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MENU_BAD_CHOICE_MULTI =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_MENU_BAD_CHOICE_MULTI", -1);

    /**
     * The option "%s" was specified more than once. Please enter one or more valid menu options
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MENU_BAD_CHOICE_MULTI_DUPE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_MENU_BAD_CHOICE_MULTI_DUPE", -1);

    /**
     * Invalid response. Please enter a valid menu option
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MENU_BAD_CHOICE_SINGLE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_MENU_BAD_CHOICE_SINGLE", -1);

    /**
     * A value was provided for argument --%s but that argument does not take a value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_ARG_FOR_LONG_ID_DOESNT_TAKE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_ARG_FOR_LONG_ID_DOESNT_TAKE_VALUE", -1);

    /**
     * The provided argument block '-%s%s' is illegal because the '%s' argument requires a value but is in the same block as at least one other argument that does not require a value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SUBCMDPARSER_CANT_MIX_ARGS_WITH_VALUES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_CANT_MIX_ARGS_WITH_VALUES", -1);

    /**
     * Failed to add global argument %s because there is already one defined with the same long identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_LONG_ID", -1);

    /**
     * There is already another global argument named "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_NAME", -1);

    /**
     * Short ID -%s for global argument %s conflicts with the short ID of another global argument %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_DUPLICATE_GLOBAL_ARG_SHORT_ID", -1);

    /**
     * Failed to add argument %s to subcommand %s because there is already one argument with the same long identifier associated to this subcommand.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SUBCMDPARSER_GLOBAL_ARG_LONG_ID_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_GLOBAL_ARG_LONG_ID_CONFLICT", -1);

    /**
     * The argument name %s conflicts with the name of another argument associated with the %s subcommand
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SUBCMDPARSER_GLOBAL_ARG_NAME_SUBCMD_CONFLICT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_GLOBAL_ARG_NAME_SUBCMD_CONFLICT", -1);

    /**
     * Short ID -%s for global argument %s conflicts with the short ID for the %s argument associated with subcommand %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_SUBCMDPARSER_GLOBAL_ARG_SHORT_ID_CONFLICT =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_GLOBAL_ARG_SHORT_ID_CONFLICT", -1);

    /**
     * The provided argument "%s" is not recognized
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_INVALID_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_INVALID_ARGUMENT", -1);

    /**
     * The dash character by itself is invalid for use as an argument name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_SUBCMDPARSER_INVALID_DASH_AS_ARGUMENT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_INVALID_DASH_AS_ARGUMENT", -1);

    /**
     * The provided command-line argument %s does not contain an argument name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_LONG_ARG_WITHOUT_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_LONG_ARG_WITHOUT_NAME", -1);

    /**
     * The argument --%s was included multiple times in the provided set of arguments but it does not allow multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NOT_MULTIVALUED_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NOT_MULTIVALUED_FOR_LONG_ID", -1);

    /**
     * The argument -%s was included multiple times in the provided set of arguments but it does not allow multiple values
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NOT_MULTIVALUED_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NOT_MULTIVALUED_FOR_SHORT_ID", -1);

    /**
     * The provided argument --%s is not a valid global or subcommand argument identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_ARGUMENT_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_ARGUMENT_FOR_LONG_ID", -1);

    /**
     * The provided argument -%s is not a valid global or subcommand argument identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_ARGUMENT_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_ARGUMENT_FOR_SHORT_ID", -1);

    /**
     * The provided argument --%s is not a valid global argument identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_GLOBAL_ARGUMENT_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_GLOBAL_ARGUMENT_FOR_LONG_ID", -1);

    /**
     * The provided argument -%s is not a valid global argument identifier
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_GLOBAL_ARGUMENT_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_GLOBAL_ARGUMENT_FOR_SHORT_ID", -1);

    /**
     * Command-line argument --%s requires a value but none was given
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_VALUE_FOR_ARGUMENT_WITH_LONG_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_VALUE_FOR_ARGUMENT_WITH_LONG_ID", -1);

    /**
     * Argument -%s requires a value but none was provided
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUBCMDPARSER_NO_VALUE_FOR_ARGUMENT_WITH_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_NO_VALUE_FOR_ARGUMENT_WITH_SHORT_ID", -1);

    /**
     * The provided value "%s" for argument --%s is not acceptable:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SUBCMDPARSER_VALUE_UNACCEPTABLE_FOR_LONG_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_VALUE_UNACCEPTABLE_FOR_LONG_ID", -1);

    /**
     * The provided value "%s" for argument -%s is not acceptable:  %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_SUBCMDPARSER_VALUE_UNACCEPTABLE_FOR_SHORT_ID =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(CliMessages.class, RESOURCE, "ERR_SUBCMDPARSER_VALUE_UNACCEPTABLE_FOR_SHORT_ID", -1);

    /**
     * You may not provide both the --%s and the --%s arguments
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_TOOL_CONFLICTING_ARGS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "ERR_TOOL_CONFLICTING_ARGS", -1);

    /**
     * SASL EXTERNAL authentication may only be used if a client certificate key store is specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TOOL_SASLEXTERNAL_NEEDS_KEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_TOOL_SASLEXTERNAL_NEEDS_KEYSTORE", -1);

    /**
     * SASL EXTERNAL authentication may only be requested if SSL or StartTLS is used
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_TOOL_SASLEXTERNAL_NEEDS_SSL_OR_TLS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "ERR_TOOL_SASLEXTERNAL_NEEDS_SSL_OR_TLS", -1);

    /**
     * Input tries limit reached (%d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_TRIES_LIMIT_REACHED =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "ERR_TRIES_LIMIT_REACHED", -1);

    /**
     * {adminUID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINUID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ADMINUID_PLACEHOLDER", -1);

    /**
     * Usage:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGPARSER_USAGE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGPARSER_USAGE", -1);

    /**
     * Default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ARGPARSER_USAGE_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_ARGPARSER_USAGE_DEFAULT_VALUE", -1);

    /**
     * Usage:  java %s  {options}
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ARGPARSER_USAGE_JAVA_CLASSNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_ARGPARSER_USAGE_JAVA_CLASSNAME", -1);

    /**
     * Usage:  %s  {options}
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ARGPARSER_USAGE_JAVA_SCRIPTNAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_ARGPARSER_USAGE_JAVA_SCRIPTNAME", -1);

    /**
     * {trailing-arguments}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGPARSER_USAGE_TRAILINGARGS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGPARSER_USAGE_TRAILINGARGS", -1);

    /**
     * Indicates whether to create the base entry in the Directory Server database
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_ADDBASE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_ADDBASE", -1);

    /**
     * Port on which the Administration Connector should listen for communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_ADMINCONNECTORPORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_ADMINCONNECTORPORT", -1);

    /**
     * Base DN for user information in the Directory Server.  Multiple base DNs may be provided by using this option multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_BASEDN", -1);

    /**
     * Nickname of the certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_CERT_NICKNAME =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_CERT_NICKNAME", -1);

    /**
     * Use the command line install. If not specified the graphical interface will be launched.  The rest of the options (excluding help and version) will only be taken into account if this option is specified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_CLI =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_CLI", -1);

    /**
     * Enable the server to run as a Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_ENABLE_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_ENABLE_WINDOWS_SERVICE", -1);

    /**
     * The fully-qualified directory server host name that will be used when generating self-signed certificates for LDAP SSL/StartTLS, the administration connector, and replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_HOST_NAME", -1);

    /**
     * Certificate key store PIN.  A PIN is required when you specify to use an existing certificate as server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_KEYSTOREPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_KEYSTOREPASSWORD", -1);

    /**
     * Certificate key store PIN file.  A PIN is required when you specify to use an existing certificate as server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_KEYSTOREPASSWORD_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_KEYSTOREPASSWORD_FILE", -1);

    /**
     * Port on which the Directory Server should listen for LDAP communication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_LDAPPORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_LDAPPORT", -1);

    /**
     * Port on which the Directory Server should listen for LDAPS communication.  The LDAPS port will be configured and SSL will be enabled only if this argument is explicitly specified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_LDAPSPORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_LDAPSPORT", -1);

    /**
     * DN for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_ROOTDN =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_ROOTDN", -1);

    /**
     * Path to a file containing the password for the initial root user for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_ROOTPWFILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_ROOTPWFILE", -1);

    /**
     * Skip the check to determine whether the specified ports are usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_SKIPPORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_SKIPPORT", -1);

    /**
     * Path of a Java Key Store (JKS) containing a certificate to be used as the server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_USE_JAVAKEYSTORE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_USE_JAVAKEYSTORE", -1);

    /**
     * Path of a JCEKS containing a certificate to be used as the server certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_USE_JCEKS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_USE_JCEKS", -1);

    /**
     * Use a certificate in a PKCS#11 token that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_USE_PKCS11 =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_USE_PKCS11", -1);

    /**
     * Path of a PKCS#12 key store containing the certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_USE_PKCS12 =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_USE_PKCS12", -1);

    /**
     * Generate a self-signed certificate that the server should use when accepting SSL-based connections or performing StartTLS negotiation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ARGUMENT_DESCRIPTION_USE_SELF_SIGNED_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ARGUMENT_DESCRIPTION_USE_SELF_SIGNED_CERTIFICATE", -1);

    /**
     * {baseDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_BASEDN_PLACEHOLDER", -1);

    /**
     * {bindDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDDN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_BINDDN_PLACEHOLDER", -1);

    /**
     * {bindPasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDPWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_BINDPWD_FILE_PLACEHOLDER", -1);

    /**
     * {bindPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BINDPWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_BINDPWD_PLACEHOLDER", -1);

    /**
     * The provided credentials are not valid in server %s.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CANNOT_CONNECT_TO_REMOTE_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_CANNOT_CONNECT_TO_REMOTE_AUTHENTICATION", -1);

    /**
     * Could not connect to %s.  Check that the server is running and that the provided credentials are valid.%nError details:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CANNOT_CONNECT_TO_REMOTE_GENERIC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_CANNOT_CONNECT_TO_REMOTE_GENERIC", -1);

    /**
     * You do not have enough access rights to read the configuration in %s. %nProvide credentials with enough rights.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CANNOT_CONNECT_TO_REMOTE_PERMISSIONS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_CANNOT_CONNECT_TO_REMOTE_PERMISSIONS", -1);

    /**
     * {configClass}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGCLASS_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_CONFIGCLASS_PLACEHOLDER", -1);

    /**
     * {configFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIGFILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_CONFIGFILE_PLACEHOLDER", -1);

    /**
     * Administrator user bind DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ADMIN_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_ADMIN_BINDDN", -1);

    /**
     * Directory server administration port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ADMIN_PORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_ADMIN_PORT", -1);

    /**
     * Allows the configuration of advanced components and properties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ADVANCED =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_ADVANCED", -1);

    /**
     * DN to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDDN", -1);

    /**
     * Password to use to bind to the server. Use -w - to ensure that the command prompts for the password, rather than entering the password as a command argument
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDPASSWORD", -1);

    /**
     * Bind password file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BINDPASSWORDFILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_BINDPASSWORDFILE", -1);

    /**
     * The fully-qualified name of the Java class to use as the Directory Server configuration handler.  If this is not provided, then a default of org.opends.server.extensions.ConfigFileHandler will be used
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONFIG_CLASS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_CONFIG_CLASS", -1);

    /**
     * Path to the Directory Server configuration file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONFIG_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_CONFIG_FILE", -1);

    /**
     * Maximum length of time (in milliseconds) that can be taken to establish a connection.  Use '0' to specify no time out
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONNECTION_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_CONNECTION_TIMEOUT", -1);

    /**
     * Continue processing even if there are errors
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONTINUE_ON_ERROR =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_CONTINUE_ON_ERROR", -1);

    /**
     * Use a request control with the provided information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_CONTROLS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_CONTROLS", -1);

    /**
     * Legacy argument for ForgeRock OpenDJ compatibility.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DEFAULT_ADD =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_DEFAULT_ADD", -1);

    /**
     * Display the equivalent non-interactive argument in the standard output when this command is run in interactive mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DISPLAY_EQUIVALENT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_DISPLAY_EQUIVALENT", -1);

    /**
     * General options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_GENERAL_ARGS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_GENERAL_ARGS", -1);

    /**
     * Directory server hostname or IP address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_HOST =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_HOST", -1);

    /**
     * Utility input/output options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_IO_ARGS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_IO_ARGS", -1);

    /**
     * Certificate key store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_KEYSTOREPATH =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_KEYSTOREPATH", -1);

    /**
     * LDAP connection options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_LDAP_CONNECTION_ARGS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_LDAP_CONNECTION_ARGS", -1);

    /**
     * Show what would be done but do not perform any operation
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_NOOP =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_NOOP", -1);

    /**
     * Use non-interactive mode.  If data in the command is missing, the user is not prompted and the tool will fail
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_NO_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_NO_PROMPT", -1);

    /**
     * No properties file will be used to get default command line argument values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_NO_PROP_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_NO_PROP_FILE", -1);

    /**
     * Directory server port number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PORT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_PORT", -1);

    /**
     * Display Directory Server version information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PRODUCT_VERSION =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_PRODUCT_VERSION", -1);

    /**
     * Path to the file containing default property values used for command line arguments
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PROP_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_PROP_FILE_PATH", -1);

    /**
     * Use the proxied authorization control with the given authorization ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_PROXYAUTHZID =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_PROXYAUTHZID", -1);

    /**
     * Use quiet mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_QUIET =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_QUIET", -1);

    /**
     * Connect to a remote server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REMOTE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_REMOTE", -1);

    /**
     * Use the authorization identity control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REPORT_AUTHZID =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_REPORT_AUTHZID", -1);

    /**
     * Attempt to automatically restart the server once it has stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_RESTART =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_RESTART", -1);

    /**
     * Use script-friendly mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SCRIPT_FRIENDLY =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_SCRIPT_FRIENDLY", -1);

    /**
     * Display this usage information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SHOWUSAGE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_SHOWUSAGE", -1);

    /**
     * Use StartTLS to secure communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_START_TLS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_START_TLS", -1);

    /**
     * Trust all server SSL certificates
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTALL =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTALL", -1);

    /**
     * Certificate trust store PIN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPASSWORD", -1);

    /**
     * Certificate trust store PIN file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPASSWORD_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPASSWORD_FILE", -1);

    /**
     * Certificate trust store path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_TRUSTSTOREPATH =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_TRUSTSTOREPATH", -1);

    /**
     * Use the password policy request control
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_USE_PWP_CONTROL =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_USE_PWP_CONTROL", -1);

    /**
     * Use SSL for secure communication with the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_USE_SSL =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_USE_SSL", -1);

    /**
     * Use verbose mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_VERBOSE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_VERBOSE", -1);

    /**
     * Maximum length of an output line (0 for no wrapping)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_WRAP_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_DESCRIPTION_WRAP_COLUMN", -1);

    /**
     * ERROR: a response must be provided in order to continue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_EMPTY_RESPONSE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ERROR_EMPTY_RESPONSE", -1);

    /**
     * Error reading data from server %s.  There is an error with the certificate presented by the server.
Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE_SERVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_ERROR_READING_CONFIG_LDAP_CERTIFICATE_SERVER", -1);

    /**
     * Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EXCEPTION_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_EXCEPTION_DETAILS", -1);

    /**
     * Not enough memory to perform the operation.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EXCEPTION_OUT_OF_MEMORY_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_EXCEPTION_OUT_OF_MEMORY_DETAILS", -1);

    /**
     * {file}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_FILE_PLACEHOLDER", -1);

    /**
     * Write rejected entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_DESCRIPTION_REJECTED_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_GENERAL_DESCRIPTION_REJECTED_FILE", -1);

    /**
     * Write skipped entries to the specified file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_DESCRIPTION_SKIPPED_FILE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_GENERAL_DESCRIPTION_SKIPPED_FILE", -1);

    /**
     * no
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_NO =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_GENERAL_NO", -1);

    /**
     * yes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GENERAL_YES =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_GENERAL_YES", -1);

    /**
     * See "%s --help" to get more usage help
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GLOBAL_HELP_REFERENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_GLOBAL_HELP_REFERENCE", -1);

    /**
     * Global Options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_GLOBAL_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_GLOBAL_OPTIONS", -1);

    /**
     * See "%s --help"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_GLOBAL_OPTIONS_REFERENCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_GLOBAL_OPTIONS_REFERENCE", -1);

    /**
     * {host}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HOST_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_HOST_PLACEHOLDER", -1);

    /**
     * {jmxPort}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JMXPORT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_JMXPORT_PLACEHOLDER", -1);

    /**
     * {keyStorePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTOREPATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_KEYSTOREPATH_PLACEHOLDER", -1);

    /**
     * {keyStorePasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_FILE_PLACEHOLDER", -1);

    /**
     * {keyStorePassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_KEYSTORE_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_KEYSTORE_PWD_PLACEHOLDER", -1);

    /**
     * Password for user '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAPAUTH_PASSWORD_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_LDAPAUTH_PASSWORD_PROMPT", -1);

    /**
     * SASL bind options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_DESCRIPTION_SASLOPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_DESCRIPTION_SASLOPTIONS", -1);

    /**
     * >>>> Specify OpenDJ LDAP connection parameters
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_HEADING_CONNECTION_PARAMETERS", -1);

    /**
     * View certificate details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_CERTIFICATE_DETAILS", -1);

    /**
     * Server Certificate:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_SERVER_CERTIFICATE", -1);

    /**
     * Do you trust this server certificate?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION", -1);

    /**
     * Yes, also add it to a truststore
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_ALWAYS", -1);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_NO", -1);

    /**
     * Yes, for this session only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_PROMPT_SECURITY_TRUST_OPTION_SESSION", -1);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE", -1);

    /**
     * Issuer   : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_ISSUER", -1);

    /**
     * User DN  : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_USER_DN", -1);

    /**
     * Validity : From '%s'%n             To '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_LDAP_CONN_SECURITY_SERVER_CERTIFICATE_VALIDITY", -1);

    /**
     * {controloid[:criticality[:value|::b64value|:<filePath]]}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDAP_CONTROL_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDAP_CONTROL_PLACEHOLDER", -1);

    /**
     * {ldifFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LDIFFILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_LDIFFILE_PLACEHOLDER", -1);

    /**
     * %c)
     */
    public static final LocalizableMessageDescriptor.Arg1<Character> INFO_MENU_CHAR_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Character>(CliMessages.class, RESOURCE, "INFO_MENU_CHAR_OPTION", -1);

    /**
     * %d)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_MENU_NUMERIC_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "INFO_MENU_NUMERIC_OPTION", -1);

    /**
     * back
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_BACK =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_BACK", -1);

    /**
     * b
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_BACK_KEY =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_BACK_KEY", -1);

    /**
     * cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_CANCEL =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_CANCEL", -1);

    /**
     * c
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_CANCEL_KEY =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_CANCEL_KEY", -1);

    /**
     * help
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_HELP =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_HELP", -1);

    /**
     * ?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_HELP_KEY =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_HELP_KEY", -1);

    /**
     * quit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_QUIT =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_QUIT", -1);

    /**
     * q
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_OPTION_QUIT_KEY =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_OPTION_QUIT_KEY", -1);

    /**
     * %s (%s / %s) [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_MENU_PROMPT_CONFIRM =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_CONFIRM", -1);

    /**
     * Enter one or more choices separated by commas:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_PROMPT_MULTI =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_MULTI", -1);

    /**
     * Enter one or more choices separated by commas [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_MENU_PROMPT_MULTI_DEFAULT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_MULTI_DEFAULT", -1);

    /**
     * Press RETURN to continue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_PROMPT_RETURN_TO_CONTINUE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_RETURN_TO_CONTINUE", -1);

    /**
     * Enter choice:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MENU_PROMPT_SINGLE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_SINGLE", -1);

    /**
     * Enter choice [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_MENU_PROMPT_SINGLE_DEFAULT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_MENU_PROMPT_SINGLE_DEFAULT", -1);

    /**
     * {nickname}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NICKNAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_NICKNAME_PLACEHOLDER", -1);

    /**
     * {numEntries}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUM_ENTRIES_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_NUM_ENTRIES_PLACEHOLDER", -1);

    /**
     * Operation date: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_OPERATION_START_TIME_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "INFO_OPERATION_START_TIME_MESSAGE", -1);

    /**
     * Automatically accepts the product license (if present)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPTION_ACCEPT_LICENSE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_OPTION_ACCEPT_LICENSE", -1);

    /**
     * {path}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_PATH_PLACEHOLDER", -1);

    /**
     * {port}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PORT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_PORT_PLACEHOLDER", -1);

    /**
     * %s [%s]:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROMPT_SINGLE_DEFAULT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(CliMessages.class, RESOURCE, "INFO_PROMPT_SINGLE_DEFAULT", -1);

    /**
     * {propertiesFilePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROP_FILE_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_PROP_FILE_PATH_PLACEHOLDER", -1);

    /**
     * {authzID}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROXYAUTHID_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_PROXYAUTHID_PLACEHOLDER", -1);

    /**
     * {rejectFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REJECT_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_REJECT_FILE_PLACEHOLDER", -1);

    /**
     * {rootUserDN}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_DN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ROOT_USER_DN_PLACEHOLDER", -1);

    /**
     * {rootUserPasswordFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ROOT_USER_PWD_FILE_PLACEHOLDER", -1);

    /**
     * {rootUserPassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ROOT_USER_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_ROOT_USER_PWD_PLACEHOLDER", -1);

    /**
     * {name=value}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SASL_OPTION_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SASL_OPTION_PLACEHOLDER", -1);

    /**
     * Search scope ('base', 'one', 'sub', or 'subordinates'). Note: 'subordinates' is an LDAP extension that might not work with all LDAP servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_DESCRIPTION_SEARCH_SCOPE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SEARCH_DESCRIPTION_SEARCH_SCOPE", -1);

    /**
     * {searchScope}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SEARCH_SCOPE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SEARCH_SCOPE_PLACEHOLDER", -1);

    /**
     * Do not start the server when the configuration is completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SETUP_DESCRIPTION_DO_NOT_START =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SETUP_DESCRIPTION_DO_NOT_START", -1);

    /**
     * Enable StartTLS to allow secure communication with the server using the LDAP port
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SETUP_DESCRIPTION_ENABLE_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SETUP_DESCRIPTION_ENABLE_STARTTLS", -1);

    /**
     * Specifies that the database should be populated with the specified number of sample entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SETUP_DESCRIPTION_SAMPLE_DATA =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SETUP_DESCRIPTION_SAMPLE_DATA", -1);

    /**
     * {skipFile}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SKIP_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SKIP_FILE_PLACEHOLDER", -1);

    /**
     * The global options are:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_GLOBAL_HEADING =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_GLOBAL_HEADING", -1);

    /**
     * {options}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_OPTIONS", -1);

    /**
     * {subcommand} {options}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_SUBCMD_AND_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_SUBCMD_AND_OPTIONS", -1);

    /**
     * Available subcommands:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_SUBCMD_HEADING =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_SUBCMD_HEADING", -1);

    /**
     * To get the list of subcommands use:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_SUBCMD_HELP_HEADING =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_SUBCMD_HELP_HEADING", -1);

    /**
     * Command options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMDPARSER_WHERE_OPTIONS_INCLUDE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMDPARSER_WHERE_OPTIONS_INCLUDE", -1);

    /**
     * SubCommand Options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUBCMD_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_SUBCMD_OPTIONS", -1);

    /**
     * {timeout}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TIMEOUT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_TIMEOUT_PLACEHOLDER", -1);

    /**
     * %d days, %d hours, %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number> INFO_TIME_IN_DAYS_HOURS_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg4<Number, Number, Number, Number>(CliMessages.class, RESOURCE, "INFO_TIME_IN_DAYS_HOURS_MINUTES_SECONDS", -1);

    /**
     * %d hours, %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg3<Number, Number, Number> INFO_TIME_IN_HOURS_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg3<Number, Number, Number>(CliMessages.class, RESOURCE, "INFO_TIME_IN_HOURS_MINUTES_SECONDS", -1);

    /**
     * %d minutes, %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_TIME_IN_MINUTES_SECONDS =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(CliMessages.class, RESOURCE, "INFO_TIME_IN_MINUTES_SECONDS", -1);

    /**
     * %d seconds
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_TIME_IN_SECONDS =
                    new LocalizableMessageDescriptor.Arg1<Number>(CliMessages.class, RESOURCE, "INFO_TIME_IN_SECONDS", -1);

    /**
     * {trustStorePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTOREPATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_TRUSTSTOREPATH_PLACEHOLDER", -1);

    /**
     * {path}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTORE_PWD_FILE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_TRUSTSTORE_PWD_FILE_PLACEHOLDER", -1);

    /**
     * {trustStorePassword}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TRUSTSTORE_PWD_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_TRUSTSTORE_PWD_PLACEHOLDER", -1);

    /**
     * {wrapColumn}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WRAP_COLUMN_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "INFO_WRAP_COLUMN_PLACEHOLDER", -1);

    /**
     * Default: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DEFAULT =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "REF_DEFAULT", -1);

    /**
     * Default: <literal>je</literal> for standard edition, <literal>pdb</literal> for OEM edition.
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DEFAULT_BACKEND_TYPE =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "REF_DEFAULT_BACKEND_TYPE", -1);

    /**
     * The <command>%s</command> command takes the following options:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_INTRO_OPTIONS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "REF_INTRO_OPTIONS", -1);

    /**
     * The <command>%s</command> command supports the following subcommands:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_INTRO_SUBCOMMANDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "REF_INTRO_SUBCOMMANDS", -1);

    /**
     * This section covers <command>%s</command> subcommands.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_PART_INTRO_SUBCOMMANDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "REF_PART_INTRO_SUBCOMMANDS", -1);

    /**
     * %s Subcommands Reference
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_PART_TITLE_SUBCOMMANDS =
                    new LocalizableMessageDescriptor.Arg1<Object>(CliMessages.class, RESOURCE, "REF_PART_TITLE_SUBCOMMANDS", -1);

    /**
     * Description
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_TITLE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "REF_TITLE_DESCRIPTION", -1);

    /**
     * Options
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_TITLE_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "REF_TITLE_OPTIONS", -1);

    /**
     * Subcommands
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_TITLE_SUBCOMMANDS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "REF_TITLE_SUBCOMMANDS", -1);

    /**
     * <xinclude:include href="variablelist-ldap-controls.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 SUPPLEMENT_DESCRIPTION_CONTROLS =
                    new LocalizableMessageDescriptor.Arg0(CliMessages.class, RESOURCE, "SUPPLEMENT_DESCRIPTION_CONTROLS", -1);

}
