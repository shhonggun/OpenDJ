package com.forgerock.opendj.dsconfig;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.forgerock.opendj.dsconfig.dsconfig}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/forgerock/opendj/dsconfig/dsconfig.properties} and it should not be manually edited.
 */
public final class DsconfigMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.forgerock.opendj.dsconfig.dsconfig";

    // Prevent instantiation.
    private DsconfigMessages() {
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
     * An unexpected error occurred while attempting to initialize the command-line arguments:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_INITIALIZE_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_CANNOT_INITIALIZE_ARGS", -1);

    /**
     * An error occurred while parsing the command-line arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ERROR_PARSING_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_ERROR_PARSING_ARGS", -1);

    /**
     * Unable to connect to the server at %s on port %s. In non-interactive mode, if the trustStore related parameters are not used, you must use the '--trustAll' option for remote connections
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_FAILED_TO_CONNECT_NOT_TRUSTED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_FAILED_TO_CONNECT_NOT_TRUSTED", -1);

    /**
     * {batchFilePath}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BATCH_FILE_PATH_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_BATCH_FILE_PATH_PLACEHOLDER", -1);

    /**
     * {category}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CATEGORY_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_CATEGORY_PLACEHOLDER", -1);

    /**
     * Reads from standard input a set of commands to be executed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BATCH =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DESCRIPTION_BATCH", -1);

    /**
     * Path to a batch file containing a set of commands to be executed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_BATCH_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DESCRIPTION_BATCH_FILE_PATH", -1);

    /**
     * {name}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NAME_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_NAME_PLACEHOLDER", -1);

    /**
     * {property}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROPERTY_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_PROPERTY_PLACEHOLDER", -1);

    /**
     * {type}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TYPE_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_TYPE_PLACEHOLDER", -1);

    /**
     * {unit}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNIT_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_UNIT_PLACEHOLDER", -1);

    /**
     * {PROP:VALUE}
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VALUE_SET_PLACEHOLDER =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_VALUE_SET_PLACEHOLDER", -1);

    /**
     * The connection parameters could not be read due to the following error: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CANNOT_READ_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CANNOT_READ_CONNECTION_PARAMETERS_1", 1);

    /**
     * Unable to connect to the server at "%s" on port %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_LDAP_FAILED_TO_CONNECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LDAP_FAILED_TO_CONNECT_3", 3);

    /**
     * Creates %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SUBCMD_CREATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_CREATE_5", 5);

    /**
     * Deletes %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SUBCMD_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_DELETE_6", 6);

    /**
     * Lists existing %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SUBCMD_LIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_LIST_7", 7);

    /**
     * Shows %s properties
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SUBCMD_GETPROP =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_GETPROP_8", 8);

    /**
     * Modifies %s properties
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SUBCMD_SETPROP =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_SETPROP_9", 9);

    /**
     * A sub-command must be specified
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DSCFG_ERROR_MISSING_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MISSING_SUBCOMMAND_10", 10);

    /**
     * The type of %s which should be created. The value for TYPE can be one of: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_DESCRIPTION_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_TYPE_11", 11);

    /**
     * No password was specified for administrator "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_PASSWORD =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_PASSWORD_12", 12);

    /**
     * The property "%s" is not a recognized property of %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_PROPERTY_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_PROPERTY_UNRECOGNIZED_13", 13);

    /**
     * Describes managed objects and their properties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_SUBCMD_HELPPROP =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SUBCMD_HELPPROP_18", 18);

    /**
     * Component
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_COMPONENT_NAME =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_COMPONENT_NAME_19", 19);

    /**
     * Property
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_PROPERTY_NAME =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_PROPERTY_NAME_20", 20);

    /**
     * Value(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_PROPERTY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_PROPERTY_VALUE_21", 21);

    /**
     * Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_PROPERTY_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_PROPERTY_SYNTAX_22", 22);

    /**
     * Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_PROPERTY_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_PROPERTY_OPTIONS_23", 23);

    /**
     * The parent %s could not be retrieved because its type could not be determined. This is probably due to the %s having an invalid LDAP entry. Check that the %s has the correct object classes
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_GET_PARENT_DDE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_PARENT_DDE_25", 25);

    /**
     * The parent %s could not be retrieved because of the reasons listed below:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_PARENT_MODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_PARENT_MODE_26", 26);

    /**
     * The parent %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_PARENT_MONFE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_PARENT_MONFE_27", 27);

    /**
     * The %s could not be created because there is already an existing one with the same name
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CREATE_MOAEE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_MOAEE_28", 28);

    /**
     * The %s could not be created because you do not have the correct authorization
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CREATE_AUTHZ =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_AUTHZ_29", 29);

    /**
     * The %s could not be created due to a communications problem: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_CREATE_CE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_CE_30", 30);

    /**
     * The %s could not be created because another client is currently making conflicting configuration changes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CREATE_CME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_CME_31", 31);

    /**
     * The %s could not be deleted because it does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_DELETE_MONFE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_MONFE_32", 32);

    /**
     * The %s could not be deleted because you do not have the correct authorization
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_DELETE_AUTHZ =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_AUTHZ_33", 33);

    /**
     * The %s could not be deleted due to a communications problem: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_DELETE_CE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_CE_34", 34);

    /**
     * The %s could not be deleted because another client is currently making conflicting configuration changes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_DELETE_CME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_CME_35", 35);

    /**
     * The %s could not be retrieved because its type could not be determined. This is probably due to the %s having an invalid LDAP entry. Check that the %s object classes are correct
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_GET_CHILD_DDE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_CHILD_DDE_36", 36);

    /**
     * The %s could not be retrieved because of the reasons listed below:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_CHILD_MODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_CHILD_MODE_37", 37);

    /**
     * The %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_CHILD_MONFE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_CHILD_MONFE_38", 38);

    /**
     * The %s could not be accessed because you do not have the correct authorization
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_CHILD_AUTHZ =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_CHILD_AUTHZ_39", 39);

    /**
     * The %s could not be accessed because another client is currently making conflicting configuration changes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_GET_CHILD_CME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_GET_CHILD_CME_41", 41);

    /**
     * The %s could not be modified because you do not have the correct authorization
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_MODIFY_AUTHZ =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MODIFY_AUTHZ_42", 42);

    /**
     * The %s could not be modified due to a communications problem: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_MODIFY_CE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MODIFY_CE_43", 43);

    /**
     * The %s could not be modified because another client is currently making conflicting configuration changes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_MODIFY_CME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MODIFY_CME_44", 44);

    /**
     * The %s could not be retrieved because its type could not be determined. This is probably due to the %s having an invalid LDAP entry. Check that the %s object classes are correct
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_LIST_DDE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_DDE_45", 45);

    /**
     * The %s could not be retrieved because of the reasons listed below:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_LIST_MODE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_MODE_46", 46);

    /**
     * The %s does not exist
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_LIST_MONFE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_MONFE_47", 47);

    /**
     * The %s could not be listed because you do not have the correct authorization
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_LIST_AUTHZ =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_AUTHZ_48", 48);

    /**
     * The %s could not be listed due to a communications problem: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_LIST_CE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_CE_49", 49);

    /**
     * The %s could not be listed because another client is currently making conflicting configuration changes
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_LIST_CME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_LIST_CME_50", 50);

    /**
     * The property argument "%s" does not contain a name/value separator. The argument should have the following syntax: property:value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_SEPARATOR_IN_PROPERTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_SEPARATOR_IN_PROPERTY_VALUE_53", 53);

    /**
     * The property argument "%s" does not contain a property name. The argument should have the following syntax: property:value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_NAME_IN_PROPERTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_NAME_IN_PROPERTY_VALUE_54", 54);

    /**
     * The property argument "%s" does not contain a property value. The argument should have the following syntax: property:value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_VALUE_IN_PROPERTY_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_VALUE_IN_PROPERTY_VALUE_55", 55);

    /**
     * The sub-type "%s" is not a recognized type of %s. It should be one of: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_SUB_TYPE_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_SUB_TYPE_UNRECOGNIZED_56", 56);

    /**
     * The property modification "%s" does not contain a name/value separator. The argument should have the following syntax: property[+|-]:value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_SEPARATOR_IN_PROPERTY_MOD =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_SEPARATOR_IN_PROPERTY_MOD_57", 57);

    /**
     * The property modification "%s" does not contain a property name. The argument should have the following syntax: property[+|-]:value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_NAME_IN_PROPERTY_MOD =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_NAME_IN_PROPERTY_MOD_58", 58);

    /**
     * The property modification "%s" is incompatible with another modification to the same property
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_INCOMPATIBLE_PROPERTY_MOD =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_INCOMPATIBLE_PROPERTY_MOD_59", 59);

    /**
     * The type of %s which should be created (Default: %s). The value for TYPE can be one of: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_DSCFG_DESCRIPTION_TYPE_DEFAULT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_TYPE_DEFAULT_60", 60);

    /**
     * Modifies the display output to show one property value per line
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_RECORD =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_RECORD_61", 61);

    /**
     * Display time data using the specified unit. The value for UNIT can be one of ms, s, m, h, d, or w (milliseconds, seconds, minutes, hours, days, or weeks)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_UNIT_TIME =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_UNIT_TIME_62", 62);

    /**
     * Display size data using the specified unit. The value for UNIT can be one of b, kb, mb, gb, or tb (bytes, kilobytes, megabytes, gigabytes, or terabytes)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_UNIT_SIZE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_UNIT_SIZE_63", 63);

    /**
     * The time unit "%s" is invalid. The valid time units are ms, s, m, h, d, or w (milliseconds, seconds, minutes, hours, days, or weeks)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_ERROR_TIME_UNIT_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_ERROR_TIME_UNIT_UNRECOGNIZED_64", 64);

    /**
     * The size unit "%s" is invalid. The valid size units are b, kb, mb, gb, or tb (bytes, kilobytes, megabytes, gigabytes, or terabytes)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_ERROR_SIZE_UNIT_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_ERROR_SIZE_UNIT_UNRECOGNIZED_65", 65);

    /**
     * Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_COMPONENT_TYPE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_COMPONENT_TYPE_66", 66);

    /**
     * Display subcommands relating to %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_SHOW_GROUP_USAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SHOW_GROUP_USAGE_67", 67);

    /**
     * Display all subcommands
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_SHOW_GROUP_USAGE_ALL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_SHOW_GROUP_USAGE_ALL_68", 68);

    /**
     * The name of the %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_NAME_70", 70);

    /**
     * The name of a property to be displayed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_PROP =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_PROP_71", 71);

    /**
     * Assigns a value to a property where PROP is the name of the property and VALUE is the single value to be assigned. Specify the same property multiple times in order to assign more than one value to it
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_PROP_VAL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_PROP_VAL_72", 72);

    /**
     * Adds a single value to a property where PROP is the name of the property and VALUE is the single value to be added
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_ADD_PROP_VAL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_ADD_PROP_VAL_73", 73);

    /**
     * Removes a single value from a property where PROP is the name of the property and VALUE is the single value to be removed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_REMOVE_PROP_VAL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_REMOVE_PROP_VAL_74", 74);

    /**
     * Resets a property back to its default values where PROP is the name of the property to be reset
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_RESET_PROP =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_RESET_PROP_75", 75);

    /**
     * The type of components whose properties should be described. The value for TYPE must be one of the component types associated with the CATEGORY specified using the "--category" option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_HELP_TYPE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_HELP_TYPE_76", 76);

    /**
     * The LDAP bind password was not specified and cannot be read interactively
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DSCFG_ERROR_BIND_PASSWORD_NONINTERACTIVE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_BIND_PASSWORD_NONINTERACTIVE_77", 77);

    /**
     * The %s property "%s" is mandatory cannot be reset. Use the "%s" option to specify a new value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_UNABLE_TO_RESET_MANDATORY_PROPERTY =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_UNABLE_TO_RESET_MANDATORY_PROPERTY_78", 78);

    /**
     * "--%s %s" : the argument "--%s" reset the property to the default value. It cannot be used to set a property to a given value
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_UNABLE_TO_RESET_PROPERTY_WITH_VALUE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_UNABLE_TO_RESET_PROPERTY_WITH_VALUE_79", 79);

    /**
     * The name "%s" is not a valid name for the %s which has the following syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_DSCFG_ERROR_ILLEGAL_NAME_SYNTAX =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_ILLEGAL_NAME_SYNTAX_80", 80);

    /**
     * Empty names are not permitted for %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_ILLEGAL_NAME_EMPTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_ILLEGAL_NAME_EMPTY_81", 81);

    /**
     * Blank names are not permitted for %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_ILLEGAL_NAME_BLANK =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_ILLEGAL_NAME_BLANK_82", 82);

    /**
     * The name "%s" is not a valid name for the %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_ILLEGAL_NAME_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_ILLEGAL_NAME_UNKNOWN_83", 83);

    /**
     * The name of the new %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_NAME_CREATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_NAME_CREATE_84", 84);

    /**
     * The name of the new %s which will also be used as the value of the "%s" property: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_DSCFG_DESCRIPTION_NAME_CREATE_EXT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_NAME_CREATE_EXT_85", 85);

    /**
     * The property "%s" cannot be set as it is defined implicitly by the name of the %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_UNABLE_TO_SET_NAMING_PROPERTY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_UNABLE_TO_SET_NAMING_PROPERTY_86", 86);

    /**
     * The argument "--%s" must be specified when this application is used non-interactively
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_MISSING_NON_INTERACTIVE_ARG =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MISSING_NON_INTERACTIVE_ARG_88", 88);

    /**
     * >>>> Select the type of %s that you want to create:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CREATE_TYPE_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CREATE_TYPE_PROMPT_89", 89);

    /**
     * >>>> Enter a name for the %s that you want to create:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CREATE_NAME_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CREATE_NAME_PROMPT_90", 90);

    /**
     * There is already another %s with the name "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_CREATE_NAME_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_NAME_ALREADY_EXISTS_91", 91);

    /**
     * Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_CREATE_HELP_HEADING_TYPE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_CREATE_HELP_HEADING_TYPE_92", 92);

    /**
     * Description
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_CREATE_HELP_HEADING_DESCR =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_CREATE_HELP_HEADING_DESCR_93", 93);

    /**
     * Unable to continue since there are no %s currently configured on the server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_FINDER_NO_CHILDREN =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_FINDER_NO_CHILDREN_94", 94);

    /**
     * >>>> There is only one %s: "%s". Are you sure that this is the correct one?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_FINDER_PROMPT_SINGLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_FINDER_PROMPT_SINGLE_95", 95);

    /**
     * >>>> Select the %s from the following list:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_FINDER_PROMPT_MANY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_FINDER_PROMPT_MANY_96", 96);

    /**
     * Unable to continue since there is no such an object currently configured on the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_DSCFG_ERROR_FINDER_NO_CHILDREN_NULL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_FINDER_NO_CHILDREN_NULL_97", 97);

    /**
     * one of the following values:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_FIELD_ENUM =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_ENUM_98", 98);

    /**
     * undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_FIELD_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_UNDEFINED_99", 99);

    /**
     * inherits from the property "%s" in the %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_HELP_FIELD_INHERITED_ABS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_INHERITED_ABS_100", 100);

    /**
     * inherits from the property "%s" in the parent %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_HELP_FIELD_INHERITED_PARENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_INHERITED_PARENT_101", 101);

    /**
     * inherits from the property "%s" in this %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_HELP_FIELD_INHERITED_THIS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_INHERITED_THIS_102", 102);

    /**
     * The server must be restarted in order for changes to this property to take effect
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_FIELD_SERVER_RESTART =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_SERVER_RESTART_103", 103);

    /**
     * The %s must be restarted in order for changes to this property to take effect
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_HELP_FIELD_COMPONENT_RESTART =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_COMPONENT_RESTART_104", 104);

    /**
     * read-only - this property can only be specified when the %s is created
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_HELP_FIELD_READ_ONLY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_READ_ONLY_105", 105);

    /**
     * monitoring - this property is automatically generated by the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_FIELD_MONITORING =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_FIELD_MONITORING_106", 106);

    /**
     * Property: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_HELP_HEADING_PROPERTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_PROPERTY_107", 107);

    /**
     * Component name: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_HELP_HEADING_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_COMPONENT_108", 108);

    /**
     * Default behavior
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_DEFAULT_109", 109);

    /**
     * Mandatory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_MANDATORY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_MANDATORY_110", 110);

    /**
     * Advanced
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_ADVANCED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_ADVANCED_111", 111);

    /**
     * Multi-valued
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_MULTI_VALUED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_MULTI_VALUED_112", 112);

    /**
     * Read-only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_READ_ONLY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_READ_ONLY_113", 113);

    /**
     * Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_HEADING_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_HEADING_SYNTAX_114", 114);

    /**
     * Option Types:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_OPTION =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_OPTION_115", 115);

    /**
     * Property value(s) are readable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_READ =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_READ_116", 116);

    /**
     * Property value(s) are writable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_WRITE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_WRITE_117", 117);

    /**
     * The property is mandatory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_MANDATORY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_MANDATORY_118", 118);

    /**
     * The property is single-valued
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_SINGLE_VALUED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_SINGLE_VALUED_119", 119);

    /**
     * Administrative action is required for changes to take effect
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HELP_DESCRIPTION_ADMIN_ACTION =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HELP_DESCRIPTION_ADMIN_ACTION_120", 120);

    /**
     * Are you sure that you want to delete the %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_DELETE_122", 122);

    /**
     * The %s was created successfully
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_CREATE_SUCCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_CREATE_SUCCESS_124", 124);

    /**
     * The %s was deleted successfully
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_DELETE_SUCCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_DELETE_SUCCESS_125", 125);

    /**
     * The %s was modified successfully
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_MODIFY_SUCCESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_MODIFY_SUCCESS_126", 126);

    /**
     * The %s was not created
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_CREATE_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_CREATE_FAIL_127", 127);

    /**
     * The %s was not deleted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_DELETE_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_DELETE_FAIL_128", 128);

    /**
     * The %s was not modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CONFIRM_MODIFY_FAIL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CONFIRM_MODIFY_FAIL_129", 129);

    /**
     * The category of components whose properties should be described
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_HELP_CATEGORY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_HELP_CATEGORY_130", 130);

    /**
     * "%s" is not a recognized component category
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CATEGORY_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CATEGORY_UNRECOGNIZED_131", 131);

    /**
     * "%s" is not a recognized component type in category "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_CATEGORY_TYPE_UNRECOGNIZED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CATEGORY_TYPE_UNRECOGNIZED_132", 132);

    /**
     * The property "%s" is not a recognized property
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_PROPERTY_UNRECOGNIZED_NO_DEFN =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_PROPERTY_UNRECOGNIZED_NO_DEFN_133", 133);

    /**
     * Modifies the display output to show the inherited properties of components
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_HELP_INHERITED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_HELP_INHERITED_134", 134);

    /**
     * true
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VALUE_TRUE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_VALUE_TRUE_135", 135);

    /**
     * false
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VALUE_FALSE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_VALUE_FALSE_136", 136);

    /**
     * unlimited
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VALUE_UNLIMITED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_VALUE_UNLIMITED_137", 137);

    /**
     * Select a value for the "%s" property:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_SELECT_VALUE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_VALUE_SINGLE_138", 138);

    /**
     * Select one or more values for the "%s" property:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_SELECT_VALUE_MULTI =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_VALUE_MULTI_139", 139);

    /**
     * Syntax:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_HEADING_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_SYNTAX_140", 140);

    /**
     * The "%s" property has the following values:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_VALUES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_VALUES_SUMMARY_141", 141);

    /**
     * Select the values you wish to add:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_PROMPT_SELECT_VALUES_ADD =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_VALUES_ADD_142", 142);

    /**
     * Select the values you wish to remove:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_PROMPT_SELECT_VALUES_REMOVE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_VALUES_REMOVE_143", 143);

    /**
     * Do you want to modify the "%s" property?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_MODIFY_MENU =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_MODIFY_MENU_144", 144);

    /**
     * Add all values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_ADD_ALL_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_ADD_ALL_VALUES_145", 145);

    /**
     * Add one or more values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_ADD_ONE_OR_MORE_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_ADD_ONE_OR_MORE_VALUES_146", 146);

    /**
     * Remove one or more values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_REMOVE_ONE_OR_MORE_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_REMOVE_ONE_OR_MORE_VALUES_147", 147);

    /**
     * Remove all values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_REMOVE_ALL_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_REMOVE_ALL_VALUES_148", 148);

    /**
     * Revert changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_REVERT_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_REVERT_CHANGES_149", 149);

    /**
     * Leave undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_LEAVE_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_LEAVE_UNDEFINED_150", 150);

    /**
     * Use the default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_USE_DEFAULT_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_DEFAULT_ALIAS_151", 151);

    /**
     * Use the inherited default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_USE_DEFAULT_INHERITED_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_DEFAULT_INHERITED_ALIAS_152", 152);

    /**
     * Use the inherited default behavior: undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_USE_DEFAULT_INHERITED_ALIAS_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_DEFAULT_INHERITED_ALIAS_UNDEFINED_153", 153);

    /**
     * Use the value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_USE_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_VALUE_154", 154);

    /**
     * Use the default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_USE_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_DEFAULT_VALUE_155", 155);

    /**
     * Use the inherited default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_USE_INHERITED_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_INHERITED_DEFAULT_VALUE_156", 156);

    /**
     * Use these values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_USE_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_VALUES_157", 157);

    /**
     * Use these default values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_USE_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_DEFAULT_VALUES_158", 158);

    /**
     * Use these inherited default values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_USE_INHERITED_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_USE_INHERITED_DEFAULT_VALUES_159", 159);

    /**
     * Keep the default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_KEEP_DEFAULT_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_DEFAULT_ALIAS_160", 160);

    /**
     * Keep the inherited default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_KEEP_DEFAULT_INHERITED_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_DEFAULT_INHERITED_ALIAS_161", 161);

    /**
     * Keep the inherited default behavior: undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_KEEP_DEFAULT_INHERITED_ALIAS_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_DEFAULT_INHERITED_ALIAS_UNDEFINED_162", 162);

    /**
     * Keep the value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_KEEP_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_VALUE_163", 163);

    /**
     * Keep the default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_KEEP_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_DEFAULT_VALUE_164", 164);

    /**
     * Keep the inherited default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_KEEP_INHERITED_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_INHERITED_DEFAULT_VALUE_165", 165);

    /**
     * Keep these values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_KEEP_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_VALUES_166", 166);

    /**
     * Keep these default values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_KEEP_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_DEFAULT_VALUES_167", 167);

    /**
     * Keep these inherited default values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_KEEP_INHERITED_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_KEEP_INHERITED_DEFAULT_VALUES_168", 168);

    /**
     * Reset to the default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_DEFAULT_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_DEFAULT_ALIAS_169", 169);

    /**
     * Reset to the inherited default behavior: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_DEFAULT_INHERITED_ALIAS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_DEFAULT_INHERITED_ALIAS_170", 170);

    /**
     * Reset to the inherited default behavior: undefined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_RESET_DEFAULT_INHERITED_ALIAS_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_DEFAULT_INHERITED_ALIAS_UNDEFINED_171", 171);

    /**
     * Reset to the default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_DEFAULT_VALUE_172", 172);

    /**
     * Reset to the inherited default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_INHERITED_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_INHERITED_DEFAULT_VALUE_173", 173);

    /**
     * Reset to the default values: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_DEFAULT_VALUES_174", 174);

    /**
     * Reset to the inherited default values: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_RESET_INHERITED_DEFAULT_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_RESET_INHERITED_DEFAULT_VALUES_175", 175);

    /**
     * The "%s" property is undefined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_READ_ONLY_ALIAS_UNDEFINED =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_READ_ONLY_ALIAS_UNDEFINED_176", 176);

    /**
     * The "%s" property is undefined: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_HEADING_READ_ONLY_ALIAS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_READ_ONLY_ALIAS_177", 177);

    /**
     * The "%s" property has the following value: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_HEADING_READ_ONLY_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_READ_ONLY_VALUE_178", 178);

    /**
     * The "%s" property has the following values:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_READ_ONLY_VALUES =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_READ_ONLY_VALUES_179", 179);

    /**
     * This property is read-only and cannot be modified. Would you like to view its help documentation?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_PROMPT_READ_ONLY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_READ_ONLY_180", 180);

    /**
     * Change it to the default value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_CHANGE_TO_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CHANGE_TO_DEFAULT_VALUE_181", 181);

    /**
     * Change it to the value: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_CHANGE_TO_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CHANGE_TO_VALUE_182", 182);

    /**
     * Change the value
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_CHANGE_VALUE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CHANGE_VALUE_183", 183);

    /**
     * >>>> Configuring the "%s" property
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_CONFIGURE_PROPERTY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_CONFIGURE_PROPERTY_184", 184);

    /**
     * Enter a value for the "%s" property:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_READ_FIRST_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_READ_FIRST_VALUE_185", 185);

    /**
     * Enter a value for the "%s" property [continue]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_READ_FIRST_VALUE_OPTIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_READ_FIRST_VALUE_OPTIONAL_186", 186);

    /**
     * Enter another value for the "%s" property [continue]:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_READ_NEXT_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_READ_NEXT_VALUE_187", 187);

    /**
     * This property already contains the value "%s". Please enter a different value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EDITOR_READ_FIRST_DUPLICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_EDITOR_READ_FIRST_DUPLICATE_188", 188);

    /**
     * This property already contains the value "%s". Please enter a different value, or press RETURN to continue
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_EDITOR_READ_NEXT_DUPLICATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_EDITOR_READ_NEXT_DUPLICATE_189", 189);

    /**
     * >>>> Configure the properties of the %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_CONFIGURE_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_CONFIGURE_COMPONENT_190", 190);

    /**
     * finish - create the new %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_FINISH_CREATE_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_FINISH_CREATE_COMPONENT_191", 191);

    /**
     * finish - apply any changes to the %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_FINISH_MODIFY_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_FINISH_MODIFY_COMPONENT_192", 192);

    /**
     * f
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EDITOR_OPTION_FINISH_KEY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_FINISH_KEY_193", 193);

    /**
     * >>>> Configuring the "%s" property (Continued)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_HEADING_CONFIGURE_PROPERTY_CONT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_CONFIGURE_PROPERTY_CONT_194", 194);

    /**
     * >>>> Specify a name for the %s. This name will be used as the value for the "%s" property which has the following description:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_CREATE_NAME_PROMPT_NAMING =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CREATE_NAME_PROMPT_NAMING_195", 195);

    /**
     * Enter a name for the %s that you want to create:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CREATE_NAME_PROMPT_NAMING_CONT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CREATE_NAME_PROMPT_NAMING_CONT_196", 196);

    /**
     * >>>> ChakanLDAP configuration console main menu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_MAIN_MENU_TITLE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_MAIN_MENU_TITLE_197", 197);

    /**
     * What do you want to configure?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_MAIN_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_MAIN_MENU_PROMPT_198", 198);

    /**
     * >>>> %s management menu
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_HEADING_COMPONENT_MENU_TITLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_COMPONENT_MENU_TITLE_199", 199);

    /**
     * What would you like to do?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_HEADING_COMPONENT_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_HEADING_COMPONENT_MENU_PROMPT_200", 200);

    /**
     * Create a new %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_CREATE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_CREATE_201", 201);

    /**
     * View and edit the %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_MODIFY_SINGULAR =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_MODIFY_SINGULAR_202", 202);

    /**
     * View and edit an existing %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_MODIFY_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_MODIFY_PLURAL_203", 203);

    /**
     * Delete an existing %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_DELETE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_DELETE_204", 204);

    /**
     * List existing %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_LIST_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_LIST_PLURAL_205", 205);

    /**
     * Show the %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_OPTION_COMPONENT_MENU_LIST_SINGULAR =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_OPTION_COMPONENT_MENU_LIST_SINGULAR_206", 206);

    /**
     * Generic %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_GENERIC_TYPE_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_GENERIC_TYPE_OPTION_207", 207);

    /**
     * The %s could not be created because of the following reason:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CREATE_ORE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_ORE_SINGLE_208", 208);

    /**
     * The %s could not be created because of the following reasons:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_CREATE_ORE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_CREATE_ORE_PLURAL_209", 209);

    /**
     * The %s could not be deleted because of the following reason:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_DELETE_ORE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_ORE_SINGLE_210", 210);

    /**
     * The %s could not be deleted because of the following reasons:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_DELETE_ORE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_DELETE_ORE_PLURAL_211", 211);

    /**
     * The %s could not be modified because of the following reason:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_MODIFY_ORE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MODIFY_ORE_SINGLE_212", 212);

    /**
     * The %s could not be modified because of the following reasons:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_MODIFY_ORE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_MODIFY_ORE_PLURAL_213", 213);

    /**
     * Would you like to edit the properties of the %s again in order to resolve this problem?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_PROMPT_EDIT_AGAIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_PROMPT_EDIT_AGAIN_214", 214);

    /**
     * "%s" component type cannot be used with subcommand {%s}
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_TYPE_UNRECOGNIZED_FOR_SUBCOMMAND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_TYPE_UNRECOGNIZED_FOR_SUBCOMMAND_215", 215);

    /**
     * Select one or more %s for the "%s" property:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_PROMPT_SELECT_COMPONENT_MULTI =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_COMPONENT_MULTI_216", 216);

    /**
     * Select a %s for the "%s" property:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_PROMPT_SELECT_COMPONENT_SINGLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_COMPONENT_SINGLE_217", 217);

    /**
     * The "%s" property references the following %s:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_HEADING_COMPONENT_SUMMARY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_HEADING_COMPONENT_SUMMARY_218", 218);

    /**
     * Select the %s you wish to add:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_SELECT_COMPONENTS_ADD =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_COMPONENTS_ADD_219", 219);

    /**
     * Add all %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_ADD_ALL_COMPONENTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_ADD_ALL_COMPONENTS_220", 220);

    /**
     * Select the %s you wish to remove:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_PROMPT_SELECT_COMPONENTS_REMOVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_SELECT_COMPONENTS_REMOVE_221", 221);

    /**
     * Change it to the default %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_OPTION_CHANGE_TO_DEFAULT_COMPONENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CHANGE_TO_DEFAULT_COMPONENT_222", 222);

    /**
     * Change it to the %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_EDITOR_OPTION_CHANGE_TO_COMPONENT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CHANGE_TO_COMPONENT_223", 223);

    /**
     * The referenced %s called "%s" must be enabled so that it can be used with this %s. Do you want to enable it?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_EDITOR_PROMPT_ENABLED_REFERENCED_COMPONENT =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_PROMPT_ENABLED_REFERENCED_COMPONENT_224", 224);

    /**
     * The modifications to the %s cannot be made because it contains a reference to a disabled %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SET_REFERENCED_COMPONENT_DISABLED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_SET_REFERENCED_COMPONENT_DISABLED_225", 225);

    /**
     * The %s could not be created because the following mandatory property was not defined:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATE_HEADING_MMPE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_CREATE_HEADING_MMPE_SINGLE_226", 226);

    /**
     * The %s could not be created because the following mandatory properties were not defined:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CREATE_HEADING_MMPE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_CREATE_HEADING_MMPE_PLURAL_227", 227);

    /**
     * The %s could not be modified because the following mandatory property was not defined:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_HEADING_MMPE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_MODIFY_HEADING_MMPE_SINGLE_228", 228);

    /**
     * The %s could not be modified because the following mandatory properties were not defined:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MODIFY_HEADING_MMPE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_MODIFY_HEADING_MMPE_PLURAL_229", 229);

    /**
     * Would you like to edit the properties of the %s in order to resolve this problem?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_PROMPT_EDIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_PROMPT_EDIT_230", 230);

    /**
     * The %s could not be decoded due to the following reason:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GET_HEADING_MODE_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_GET_HEADING_MODE_SINGLE_231", 231);

    /**
     * The %s could not be decoded due to the following reasons:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_GET_HEADING_MODE_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_GET_HEADING_MODE_PLURAL_232", 232);

    /**
     * Create a new %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EDITOR_OPTION_CREATE_A_NEW_COMPONENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_EDITOR_OPTION_CREATE_A_NEW_COMPONENT_233", 233);

    /**
     * The referenced %s called "%s" must be enabled so that it can be used with this %s. Do you want to edit its properties in order to enable it?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_DSCFG_PROMPT_EDIT_TO_ENABLE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_PROMPT_EDIT_TO_ENABLE_234", 234);

    /**
     * Custom %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CUSTOM_TYPE_OPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CUSTOM_TYPE_OPTION_235", 235);

    /**
     * A Custom %s with a user-defined implementation class
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CUSTOM_TYPE_SYNOPSIS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CUSTOM_TYPE_SYNOPSIS_236", 236);

    /**
     * A Generic %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_GENERIC_TYPE_SYNOPSIS =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_GENERIC_TYPE_SYNOPSIS_237", 237);

    /**
     * Help: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_CREATE_TYPE_HELP_HEADING =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_CREATE_TYPE_HELP_HEADING_238", 238);

    /**
     * The equivalent non-interactive command-line is:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_NON_INTERACTIVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_NON_INTERACTIVE_239", 239);

    /**
     * Display the equivalent non-interactive argument in the standard output when this command is run in interactive mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_DISPLAY_EQUIVALENT =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_DISPLAY_EQUIVALENT_240", 240);

    /**
     * The full path to the file where the equivalent non-interactive commands will be written when this command is run in interactive mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_EQUIVALENT_COMMAND_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_EQUIVALENT_COMMAND_FILE_PATH_241", 241);

    /**
     * An error occurred while attempting to write equivalent non-interactive command line to file %s.  Error details:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_WRITING_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_WRITING_EQUIVALENT_COMMAND_LINE_242", 242);

    /**
     * Cannot write to file %s.  Verify that you have access rights to that file and that you provided the full path of the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_CANNOT_WRITE_EQUIVALENT_COMMAND_LINE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_CANNOT_WRITE_EQUIVALENT_COMMAND_LINE_FILE_243", 243);

    /**
     * The specified path %s to write the equivalent command is a directory.  You must specify a path to a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_EQUIVALENT_COMMAND_LINE_FILE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_EQUIVALENT_COMMAND_LINE_FILE_DIRECTORY_244", 244);

    /**
     * The value %s for the %s property does not exist
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_VALUE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_VALUE_DOES_NOT_EXIST_247", 247);

    /**
     * Unable to continue since there are no available types of %s to choose from
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_NO_AVAILABLE_TYPES =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_NO_AVAILABLE_TYPES_248", 248);

    /**
     * >>>> There is only one type of %s available: "%s". Are you sure that this is the correct one?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_TYPE_PROMPT_SINGLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_TYPE_PROMPT_SINGLE_249", 249);

    /**
     * An error occurred while attempting to read the batch file : %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DSCFG_ERROR_READING_BATCH_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_READING_BATCH_FILE_250", 250);

    /**
     * %s session start date: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_DSCFG_SESSION_START_TIME_MESSAGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_SESSION_START_TIME_MESSAGE_251", 251);

    /**
     * Session operation number: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_DSCFG_EQUIVALENT_COMMAND_LINE_SESSION_OPERATION_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_EQUIVALENT_COMMAND_LINE_SESSION_OPERATION_NUMBER_252", 252);

    /**
     * Configuration Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_DESCRIPTION_OPTIONS_ARGS =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_OPTIONS_ARGS_253", 253);

    /**
     * If you specify the {%s} argument you must also specify {%s}
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_DSCFG_ERROR_QUIET_AND_INTERACTIVE_INCOMPATIBLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "ERR_DSCFG_ERROR_QUIET_AND_INTERACTIVE_INCOMPATIBLE_254", 254);

    /**
     * This utility can be used to define a base configuration for the Directory Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DSCFG_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_TOOL_DESCRIPTION_255", 255);

    /**
     * A value of "-1" or "unlimited" for no limit.
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_ALLOW_UNLIMITED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ALLOW_UNLIMITED_1000", 1000);

    /**
     * <olink targetdoc="admin-guide" targetptr="about-acis" />
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_ACI_SYNTAX_REL_URL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ACI_SYNTAX_REL_URL_1001", 1001);

    /**
     * <xinclude:include href="itemizedlist-duration.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_DURATION_SYNTAX_REL_URL =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DURATION_SYNTAX_REL_URL_1002", 1002);

    /**
     * %s properties depend on the %s type, which depends on the %s option.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> REF_DSCFG_ARG_ADDITIONAL_INFO =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ARG_ADDITIONAL_INFO_1003", 1003);

    /**
     * %s properties depend on the %s type, which depends on the %s you provide.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> REF_DSCFG_SUBTYPE_DEPENDENCIES =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_SUBTYPE_DEPENDENCIES_1004", 1004);

    /**
     * By default, ChakanLDAP directory server supports the following %s types:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_SUBTYPE_TYPES_INTRO =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_SUBTYPE_TYPES_INTRO_1005", 1005);

    /**
     * Default %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> REF_DSCFG_CHILD_DEFAULT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_CHILD_DEFAULT_1006", 1006);

    /**
     * Enabled by default: %b
     */
    public static final LocalizableMessageDescriptor.Arg1<Boolean> REF_DSCFG_CHILD_ENABLED_BY_DEFAULT =
                    new LocalizableMessageDescriptor.Arg1<Boolean>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_CHILD_ENABLED_BY_DEFAULT_1007", 1007);

    /**
     * See %s for the properties of this %s type.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> REF_DSCFG_CHILD_LINK =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_CHILD_LINK_1008", 1008);

    /**
     * %s of type %s have the following properties:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> REF_DSCFG_PROPS_INTRO =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_INTRO_1009", 1009);

    /**
     * Default Value
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_DEFAULT_VALUE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_DEFAULT_VALUE_1010", 1010);

    /**
     * Allowed Values
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_ALLOWED_VALUES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_ALLOWED_VALUES_1011", 1011);

    /**
     * Multi-valued
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_MULTI_VALUED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_MULTI_VALUED_1012", 1012);

    /**
     * Required
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_REQUIRED_1013", 1013);

    /**
     * Admin Action Required
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_ADMIN_ACTION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_ADMIN_ACTION_REQUIRED_1014", 1014);

    /**
     * Advanced Property
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_ADVANCED_PROPERTY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_ADVANCED_PROPERTY_1015", 1015);

    /**
     * Read-only
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROPS_LABEL_READ_ONLY =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROPS_LABEL_READ_ONLY_1016", 1016);

    /**
     * The %s must be disabled and re-enabled for changes to this setting to take effect
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_ADMIN_ACTION_COMPONENT_RESTART =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ADMIN_ACTION_COMPONENT_RESTART_1017", 1017);

    /**
     * Restart the server
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_ADMIN_ACTION_SERVER_RESTART =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ADMIN_ACTION_SERVER_RESTART_1018", 1018);

    /**
     * None
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_ADMIN_ACTION_NONE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ADMIN_ACTION_NONE_1019", 1019);

    /**
     * Yes
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROP_YES =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROP_YES_1020", 1020);

    /**
     * Yes (Use --advanced in interactive mode.)
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROP_YES_ADVANCED =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROP_YES_ADVANCED_1021", 1021);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_PROP_NO =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_PROP_NO_1022", 1022);

    /**
     * None
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_DEFAULT_BEHAVIOR_NONE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DEFAULT_BEHAVIOR_NONE_1023", 1023);

    /**
     * %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_DEFAULT_BEHAVIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DEFAULT_BEHAVIOR_1024", 1024);

    /**
     * The DN of any %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_AGGREGATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_AGGREGATION_1025", 1025);

    /**
     * The name of an attribute type defined in the server schema
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_ANY_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_ANY_ATTRIBUTE_1026", 1026);

    /**
     * A Java class that implements or extends the class(es):
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_JAVA_PLUGIN =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_JAVA_PLUGIN_1027", 1027);

    /**
     * A valid DN
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_VALID_DN =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_VALID_DN_1028", 1028);

    /**
     * Maximum unit is "%s"
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_DURATION_MAX_UNIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DURATION_MAX_UNIT_1029", 1029);

    /**
     * Lower limit is %d %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> REF_DSCFG_DURATION_LOWER_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DURATION_LOWER_LIMIT_1030", 1030);

    /**
     * Upper limit is %d %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> REF_DSCFG_DURATION_UPPER_LIMIT =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DURATION_UPPER_LIMIT_1031", 1031);

    /**
     * An integer value
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_INT =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_INT_1032", 1032);

    /**
     * Lower value is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> REF_DSCFG_INT_LOWER_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Number>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_INT_LOWER_LIMIT_1033", 1033);

    /**
     * Upper value is %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> REF_DSCFG_INT_UPPER_LIMIT =
                    new LocalizableMessageDescriptor.Arg1<Number>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_INT_UPPER_LIMIT_1034", 1034);

    /**
     * Unit is %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> REF_DSCFG_INT_UNIT =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "REF_DSCFG_INT_UNIT_1035", 1035);

    /**
     * An IP address
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_IP_ADDRESS =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_IP_ADDRESS_1036", 1036);

    /**
     * An IP address mask
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_IP_ADDRESS_MASK =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_IP_ADDRESS_MASK_1037", 1037);

    /**
     * A String
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_STRING =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_STRING_1038", 1038);

    /**
     * Unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_UNKNOWN =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_UNKNOWN_1039", 1039);

    /**
     * manage ChakanLDAP directory server configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_SHORT_DESC_DSCONFIG =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_SHORT_DESC_DSCONFIG_1040", 1040);

    /**
     * <xinclude:include href="description-dsconfig.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_DOC_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DOC_TOOL_DESCRIPTION_1041", 1041);

    /**
     * <xinclude:include href="description-dsconfig-subcommands.xml" />
     */
    public static final LocalizableMessageDescriptor.Arg0 REF_DSCFG_DOC_SUBCOMMANDS_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(DsconfigMessages.class, RESOURCE, "REF_DSCFG_DOC_SUBCOMMANDS_DESCRIPTION_1042", 1042);

    /**
     * Ignore non-existent %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DSCFG_DESCRIPTION_FORCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(DsconfigMessages.class, RESOURCE, "INFO_DSCFG_DESCRIPTION_FORCE_1196", 1196);

}
