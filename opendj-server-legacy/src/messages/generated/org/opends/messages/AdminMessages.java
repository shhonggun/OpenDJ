package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.admin}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/admin.properties} and it should not be manually edited.
 */
public final class AdminMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.admin";

    // Prevent instantiation.
    private AdminMessages() {
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
     * An error occurred while trying to retrieve relation configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADMIN_CANNOT_GET_LISTENER_BASE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_GET_LISTENER_BASE_1", 1);

    /**
     * An error occurred while trying to retrieve the managed object configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADMIN_CANNOT_GET_MANAGED_OBJECT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_GET_MANAGED_OBJECT_3", 3);

    /**
     * The managed object configuration entry %s does not appear to exist in the Directory Server configuration. This is a required entry
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_MANAGED_OBJECT_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_MANAGED_OBJECT_DOES_NOT_EXIST_4", 4);

    /**
     * An error occurred while trying to decode the managed object configuration entry %s: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADMIN_MANAGED_OBJECT_DECODING_PROBLEM =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_MANAGED_OBJECT_DECODING_PROBLEM_5", 5);

    /**
     * The Directory Server was unable to load class %s and use it to create a component instance as defined in configuration entry %s. The error that occurred was: %s. This component will be disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ADMIN_CANNOT_INSTANTIATE_CLASS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_INSTANTIATE_CLASS_6", 6);

    /**
     * The Directory Server jar file %s in directory %s cannot be loaded because an unexpected error occurred while trying to open the file for reading: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ADMIN_CANNOT_OPEN_JAR_FILE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_OPEN_JAR_FILE_9", 9);

    /**
     * The extensions directory %s does not exist, therefore no extensions will be loaded
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ADMIN_NO_EXTENSIONS_DIR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "WARN_ADMIN_NO_EXTENSIONS_DIR_12", 12);

    /**
     * Unable to read the Directory Server extensions because the extensions directory %s exists but is not a directory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_EXTENSIONS_DIR_NOT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_EXTENSIONS_DIR_NOT_DIRECTORY_13", 13);

    /**
     * Unable to read the Directory Server extensions from directory %s because an unexpected error occurred while trying to list the files in that directory: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ADMIN_EXTENSIONS_CANNOT_LIST_FILES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_EXTENSIONS_CANNOT_LIST_FILES_14", 14);

    /**
     * The core administration manifest file %s cannot be located
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_CANNOT_FIND_CORE_MANIFEST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_FIND_CORE_MANIFEST_15", 15);

    /**
     * The administration manifest file %s associated with the extension %s cannot be loaded because an unexpected error occurred while trying to read it: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ADMIN_CANNOT_READ_EXTENSION_MANIFEST =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CANNOT_READ_EXTENSION_MANIFEST_17", 17);

    /**
     * Unable to register an add/delete listener against the entry "%s" because it does not exist in the configuration
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_UNABLE_TO_REGISTER_LISTENER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_UNABLE_TO_REGISTER_LISTENER_57", 57);

    /**
     * Reason unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OPERATION_REJECTED_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_OPERATION_REJECTED_DEFAULT_74", 74);

    /**
     * A configuration exception occurred while evaluating a constraint: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SERVER_CONSTRAINT_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_SERVER_CONSTRAINT_EXCEPTION_75", 75);

    /**
     * The %s could be found but did not contain any type information (e.g. missing object classes in LDAP)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DECODING_EXCEPTION_NO_TYPE_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_DECODING_EXCEPTION_NO_TYPE_INFO_82", 82);

    /**
     * The %s could be found but did not contain the expected type information (e.g. incorrect object classes in LDAP)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DECODING_EXCEPTION_WRONG_TYPE_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_DECODING_EXCEPTION_WRONG_TYPE_INFO_83", 83);

    /**
     * The %s could be found but its type resolved to an abstract managed object definition
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DECODING_EXCEPTION_ABSTRACT_TYPE_INFO =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_DECODING_EXCEPTION_ABSTRACT_TYPE_INFO_84", 84);

    /**
     * The default values for the "%s" property could not be determined
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DEFAULT_BEHAVIOR_PROPERTY_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_DEFAULT_BEHAVIOR_PROPERTY_EXCEPTION_86", 86);

    /**
     * The value "%s" is not a valid value for the "%s" property, which must have the following syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ILLEGAL_PROPERTY_VALUE_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_ILLEGAL_PROPERTY_VALUE_EXCEPTION_87", 87);

    /**
     * The "%s" property must be specified as it is mandatory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROPERTY_IS_MANDATORY_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_PROPERTY_IS_MANDATORY_EXCEPTION_89", 89);

    /**
     * The "%s" property must not be modified as it is read-only
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROPERTY_IS_READ_ONLY_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_PROPERTY_IS_READ_ONLY_EXCEPTION_90", 90);

    /**
     * The "%s" property must not contain more than one value
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROPERTY_IS_SINGLE_VALUED_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_PROPERTY_IS_SINGLE_VALUED_EXCEPTION_91", 91);

    /**
     * An internal error occurred while processing property "%s": unknown property type "%s"
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNKNOWN_PROPERTY_DEFINITION_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_UNKNOWN_PROPERTY_DEFINITION_EXCEPTION_92", 92);

    /**
     * Authentication failure
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHENTICATION_EXCEPTION_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_AUTHENTICATION_EXCEPTION_DEFAULT_93", 93);

    /**
     * The requested authentication mechanism is not supported by the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHENTICATION_NOT_SUPPORTED_EXCEPTION_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_AUTHENTICATION_NOT_SUPPORTED_EXCEPTION_DEFAULT_94", 94);

    /**
     * Authorization failure
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_AUTHORIZATION_EXCEPTION_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_AUTHORIZATION_EXCEPTION_DEFAULT_95", 95);

    /**
     * A communication problem occurred while contacting the server
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_COMMUNICATION_EXCEPTION_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_COMMUNICATION_EXCEPTION_DEFAULT_96", 96);

    /**
     * The operation was rejected for the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPERATION_REJECTED_EXCEPTION_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_OPERATION_REJECTED_EXCEPTION_SINGLE_97", 97);

    /**
     * The operation was rejected for the following reasons: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_OPERATION_REJECTED_EXCEPTION_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_OPERATION_REJECTED_EXCEPTION_PLURAL_98", 98);

    /**
     * The operation could not be performed because a conflicting change has already occurred. There may be another client administration tool in use
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONCURRENT_MODIFICATION_EXCEPTION_DEFAULT =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_CONCURRENT_MODIFICATION_EXCEPTION_DEFAULT_99", 99);

    /**
     * The %s could not be decoded due to the following reason: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MANAGED_OBJECT_DECODING_EXCEPTION_SINGLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_MANAGED_OBJECT_DECODING_EXCEPTION_SINGLE_100", 100);

    /**
     * The %s could not be decoded due to the following reasons: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_MANAGED_OBJECT_DECODING_EXCEPTION_PLURAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_MANAGED_OBJECT_DECODING_EXCEPTION_PLURAL_101", 101);

    /**
     * Empty managed object names are not permitted
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_EMPTY_102", 102);

    /**
     * Blank managed object names are not permitted
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_BLANK =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_BLANK_103", 103);

    /**
     * The managed object name "%s" is not a valid value for the naming property "%s", which must have the following syntax: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_SYNTAX =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_SYNTAX_104", 104);

    /**
     * The managed object name "%s" is not permitted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_OTHER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ILLEGAL_MANAGED_OBJECT_NAME_EXCEPTION_OTHER_105", 105);

    /**
     * The managed object could not be created because there is an existing managed object with the same name
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MANAGED_OBJECT_ALREADY_EXISTS_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_MANAGED_OBJECT_ALREADY_EXISTS_EXCEPTION_106", 106);

    /**
     * The requested managed object could not be found
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_MANAGED_OBJECT_NOT_FOUND_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminMessages.class, RESOURCE, "ERR_MANAGED_OBJECT_NOT_FOUND_EXCEPTION_107", 107);

    /**
     * The "%s" property is mandatory
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MISSING_MANDATORY_PROPERTIES_EXCEPTION_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_MISSING_MANDATORY_PROPERTIES_EXCEPTION_SINGLE_108", 108);

    /**
     * The following properties are mandatory: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_MISSING_MANDATORY_PROPERTIES_EXCEPTION_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_MISSING_MANDATORY_PROPERTIES_EXCEPTION_PLURAL_109", 109);

    /**
     * The property "%s" was not recognized
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_PROPERTY_NOT_FOUND_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_PROPERTY_NOT_FOUND_EXCEPTION_110", 110);

    /**
     * A communication problem occurred while contacting the server: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_COMMUNICATION_EXCEPTION_DEFAULT_CAUSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_COMMUNICATION_EXCEPTION_DEFAULT_CAUSE_111", 111);

    /**
     * The following constraint violation occurred: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONSTRAINT_VIOLATION_EXCEPTION_SINGLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_CONSTRAINT_VIOLATION_EXCEPTION_SINGLE_112", 112);

    /**
     * The following constraint violations occurred: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONSTRAINT_VIOLATION_EXCEPTION_PLURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_CONSTRAINT_VIOLATION_EXCEPTION_PLURAL_113", 113);

    /**
     * The value "%s" in property "%s" in the %s in entry "%s" refers to a non-existent %s in entry "%s"
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object> ERR_SERVER_REFINT_DANGLING_REFERENCE =
                    new LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_SERVER_REFINT_DANGLING_REFERENCE_114", 114);

    /**
     * The value "%s" in property "%s" in the %s in entry "%s" refers to a disabled %s in entry "%s"
     */
    public static final LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object> ERR_SERVER_REFINT_TARGET_DISABLED =
                    new LocalizableMessageDescriptor.Arg6<Object, Object, Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_SERVER_REFINT_TARGET_DISABLED_116", 116);

    /**
     * The %s in entry "%s" cannot be deleted because it is referenced by the "%s" property of the %s in entry "%s"
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> ERR_SERVER_REFINT_CANNOT_DELETE =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_SERVER_REFINT_CANNOT_DELETE_117", 117);

    /**
     * The %s in entry "%s" cannot be disabled because it is referenced by the "%s" property of the %s in entry "%s"
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> ERR_SERVER_REFINT_CANNOT_DISABLE =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_SERVER_REFINT_CANNOT_DISABLE_118", 118);

    /**
     * An unexpected error occurred while reading the manifest file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CLASS_LOADER_CANNOT_READ_MANIFEST_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_READ_MANIFEST_FILE_120", 120);

    /**
     * An error occurred while attempting to load class "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CLASS_LOADER_CANNOT_LOAD_CLASS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_LOAD_CLASS_121", 121);

    /**
     * Unable to to find the getInstance() method in the managed object definition class "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CLASS_LOADER_CANNOT_FIND_GET_INSTANCE_METHOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_FIND_GET_INSTANCE_METHOD_122", 122);

    /**
     * Unable to to invoke the getInstance() method in the managed object definition class "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CLASS_LOADER_CANNOT_INVOKE_GET_INSTANCE_METHOD =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_INVOKE_GET_INSTANCE_METHOD_123", 123);

    /**
     * Unable initialize the "%s" managed object definition in class "%s": %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLASS_LOADER_CANNOT_INITIALIZE_DEFN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_INITIALIZE_DEFN_124", 124);

    /**
     * The extension "%s" with manifest file %s cannot be loaded because an unexpected error occurred while trying to initialize it: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLASS_LOADER_CANNOT_LOAD_EXTENSION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_LOAD_EXTENSION_125", 125);

    /**
     * The core administration classes could not be loaded from manifest file %s because an unexpected error occurred: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CLASS_LOADER_CANNOT_LOAD_CORE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLASS_LOADER_CANNOT_LOAD_CORE_126", 126);

    /**
     * The %s "%s" referenced in property "%s" does not exist
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLIENT_REFINT_TARGET_DANGLING_REFERENCE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_TARGET_DANGLING_REFERENCE_127", 127);

    /**
     * The %s "%s" referenced in property "%s" exists but has an invalid configuration: %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CLIENT_REFINT_TARGET_INVALID =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_TARGET_INVALID_128", 128);

    /**
     * The %s "%s" referenced in property "%s" is disabled
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLIENT_REFINT_TARGET_DISABLED =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_TARGET_DISABLED_129", 129);

    /**
     * The "%s" property in the %s called "%s" references this %s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CLIENT_REFINT_CANNOT_DELETE_WITH_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_CANNOT_DELETE_WITH_NAME_130", 130);

    /**
     * The "%s" property in the %s references this %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLIENT_REFINT_CANNOT_DELETE_WITHOUT_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_CANNOT_DELETE_WITHOUT_NAME_131", 131);

    /**
     * This %s cannot be disabled because it is referenced by the "%s" property in the %s called "%s"
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_CLIENT_REFINT_CANNOT_DISABLE_WITH_NAME =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_CANNOT_DISABLE_WITH_NAME_132", 132);

    /**
     * This %s cannot be disabled because it is referenced by the "%s" property in the %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_CLIENT_REFINT_CANNOT_DISABLE_WITHOUT_NAME =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_CLIENT_REFINT_CANNOT_DISABLE_WITHOUT_NAME_133", 133);

    /**
     * An error occurred while attempting to determine if the %s in entry %s is enabled: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REFINT_UNABLE_TO_EVALUATE_TARGET_CONDITION =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminMessages.class, RESOURCE, "ERR_REFINT_UNABLE_TO_EVALUATE_TARGET_CONDITION_134", 134);

    /**
     * The administration connector self-signed certificate cannot be generated because the following error occurred: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_CERTIFICATE_GENERATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CERTIFICATE_GENERATION_135", 135);

    /**
     * The administration connector self-signed certificate cannot be generated because the following files are missing: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_ADMIN_CERTIFICATE_GENERATION_MISSING_FILES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "ERR_ADMIN_CERTIFICATE_GENERATION_MISSING_FILES_136", 136);

    /**
     * Failed to set permissions on file %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> WARN_ADMIN_SET_PERMISSIONS_FAILED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminMessages.class, RESOURCE, "WARN_ADMIN_SET_PERMISSIONS_FAILED_137", 137);

}
