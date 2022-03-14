package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.admin_tool}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/admin_tool.properties} and it should not be manually edited.
 */
public final class AdminToolMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.admin_tool";

    // Prevent instantiation.
    private AdminToolMessages() {
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
     * Impossible to create the new backend '%s'. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERROR_CTRL_PANEL_CREATE_NEW_BACKEND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERROR_CTRL_PANEL_CREATE_NEW_BACKEND", -1);

    /**
     * An error occured while loading the configuration framework: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERROR_CTRL_PANEL_INITIALIZE_CONFIG_OFFLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERROR_CTRL_PANEL_INITIALIZE_CONFIG_OFFLINE", -1);

    /**
     * An error occured while processing task reset change number: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERROR_RESET_CHANGE_NUMBER_EXCEPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERROR_RESET_CHANGE_NUMBER_EXCEPTION", -1);

    /**
     * Could not find the baseDN associated to change number %s. Found targetDN '%s' and replicationCSN %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERROR_RESET_CHANGE_NUMBER_NO_BASEDN =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERROR_RESET_CHANGE_NUMBER_NO_BASEDN", -1);

    /**
     * Could not find a replication CSN for change number %s on server '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERROR_RESET_CHANGE_NUMBER_NO_CSN_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERROR_RESET_CHANGE_NUMBER_NO_CSN_FOUND", -1);

    /**
     * Cannot reset change-log change number because replicated baseDNs on server %s and server %s differ. Since the change number is computed across all the replicated baseDNs, the change-log change number can only be reset between two replication servers replicating the exact same baseDNs.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERROR_RESET_CHANGE_NUMBER_SERVERS_BASEDNS_DIFFER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERROR_RESET_CHANGE_NUMBER_SERVERS_BASEDNS_DIFFER", -1);

    /**
     * Could not find change number %s on server '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERROR_RESET_CHANGE_NUMBER_UNKNOWN_NUMBER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERROR_RESET_CHANGE_NUMBER_UNKNOWN_NUMBER", -1);

    /**
     * There is already an existing backend with name: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BACKEND_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_BACKEND_ALREADY_EXISTS", -1);

    /**
     * The base DN '%s' is already defined.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE_DN_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_BASE_DN_ALREADY_EXISTS", -1);

    /**
     * The backend already contains another base DN that is within the same hierarchical path (%s is an ancestor of the provided base DN).
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE_DN_ANCESTOR_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_BASE_DN_ANCESTOR_EXISTS", -1);

    /**
     * The backend already contains another base DN that is within the same hierarchical path (%s is a descendant of the provided base DN).
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_BASE_DN_DN_IS_ANCESTOR_OF =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_BASE_DN_DN_IS_ANCESTOR_OF", -1);

    /**
     * Could not connect to the Directory Server with the provided credentials.  The possible causes for this are:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CANNOT_CONNECT_TO_LOGIN_WITH_CAUSE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CANNOT_CONNECT_TO_LOGIN_WITH_CAUSE", -1);

    /**
     * Cannot modify the objectclass and rename the entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CANNOT_MODIFY_OBJECTCLASS_AND_RENAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CANNOT_MODIFY_OBJECTCLASS_AND_RENAME", -1);

    /**
     * You must select something to be uninstalled.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CLI_UNINSTALL_NOTHING_TO_BE_UNINSTALLED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CLI_UNINSTALL_NOTHING_TO_BE_UNINSTALLED", -1);

    /**
     * You must select the elements to uninstall.  Use the options described in the usage to specify what must be uninstalled.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CLI_UNINSTALL_NOTHING_TO_BE_UNINSTALLED_NON_INTERACTIVE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CLI_UNINSTALL_NOTHING_TO_BE_UNINSTALLED_NON_INTERACTIVE", -1);

    /**
     * Could not launch Control Panel.  Check that you have access to the display.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CONTROL_PANEL_LAUNCHER_GUI_LAUNCH_FAILED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CONTROL_PANEL_LAUNCHER_GUI_LAUNCH_FAILED", -1);

    /**
     * Could not launch Control Panel.  Check that you have access to the display.   Check file %s for details.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CONTROL_PANEL_LAUNCHER_GUI_LAUNCH_FAILED_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CONTROL_PANEL_LAUNCHER_GUI_LAUNCH_FAILED_DETAILS", -1);

    /**
     * Error reading the configuration file.%nThis could be caused because there is not an enabled LDAP port for the specified connection parameters or because you do not have read rights on the configuration file.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_COULD_NOT_FIND_VALID_LDAPURL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_COULD_NOT_FIND_VALID_LDAPURL", -1);

    /**
     * An error occurred adding to groups.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ADDING_TO_GROUP_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ADDING_TO_GROUP_ERROR_DETAILS", -1);

    /**
     * Error adding to groups
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ADDING_TO_GROUP_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ADDING_TO_GROUP_ERROR_SUMMARY", -1);

    /**
     * The provided alias '%s' already exists in the schema (defined as %s).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_ALIAS_ALREADY_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ALIAS_ALREADY_IN_USE", -1);

    /**
     * An attribute cannot be its own superior.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ATTRIBUTE_CANNOT_BE_ITS_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ATTRIBUTE_CANNOT_BE_ITS_SUPERIOR", -1);

    /**
     * The attribute is superior (directly or indirectly) of '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ATTRIBUTE_IS_SUPERIOR_OF_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ATTRIBUTE_IS_SUPERIOR_OF_SUPERIOR", -1);

    /**
     * The provided name '%s' already exists in the schema (defined as %s).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_ATTRIBUTE_NAME_ALREADY_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ATTRIBUTE_NAME_ALREADY_IN_USE", -1);

    /**
     * You must provide a name for the attribute.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ATTRIBUTE_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ATTRIBUTE_NAME_REQUIRED", -1);

    /**
     * You must provide a value for attribute %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ATTRIBUTE_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ATTRIBUTE_REQUIRED", -1);

    /**
     * The backend '%s' could not be found.  Check main panel for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_BACKEND_NOT_FOUND_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKEND_NOT_FOUND_DETAILS", -1);

    /**
     * Could not find backend
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_BACKEND_NOT_FOUND_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKEND_NOT_FOUND_SUMMARY", -1);

    /**
     * A backup with ID '%s' is already defined under '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_BACKUP_ID_ALREADY_EXIST =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKUP_ID_ALREADY_EXIST", -1);

    /**
     * The backup path '%s' does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_BACKUP_PATH_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKUP_PATH_DOES_NOT_EXIST", -1);

    /**
     * The file '%s' exists.  You must provide a directory to do the new backup.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_BACKUP_PATH_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKUP_PATH_EXISTS", -1);

    /**
     * The backup path '%s" exists and is a file.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_BACKUP_PATH_IS_A_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_BACKUP_PATH_IS_A_FILE", -1);

    /**
     * An error occurred canceling the selected tasks.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CANCELING_TASK_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CANCELING_TASK_ERROR_DETAILS", -1);

    /**
     * Error canceling task
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CANCELING_TASK_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CANCELING_TASK_ERROR_SUMMARY", -1);

    /**
     * Cannot read file '%s'.  Check that you have read rights to it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_CANNOT_READ_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CANNOT_READ_FILE", -1);

    /**
     * Could not find entry specified in '%s'.  Check that the entry exists in server %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_COULD_NOT_FIND_PROVIDED_ENTRY_IN_REFERRAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_COULD_NOT_FIND_PROVIDED_ENTRY_IN_REFERRAL", -1);

    /**
     * Could not find entry specified in '%s'.  Check that the entry exists in server.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_COULD_NOT_FIND_PROVIDED_ENTRY_IN_REFERRAL_NO_HOST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_COULD_NOT_FIND_PROVIDED_ENTRY_IN_REFERRAL_NO_HOST", -1);

    /**
     * An error occurred creating attribute '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_CREATING_ATTRIBUTE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_ATTRIBUTE_ERROR_DETAILS", -1);

    /**
     * Error creating attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_ATTRIBUTE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_ATTRIBUTE_ERROR_SUMMARY", -1);

    /**
     * An error occurred during the creation of the base DN.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_CREATING_BASE_DN_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_BASE_DN_ERROR_DETAILS", -1);

    /**
     * Error during creation of base DN '%s'.    Check 'Details' text area for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_CREATING_BASE_DN_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_BASE_DN_ERROR_SUMMARY", -1);

    /**
     * An error occurred creating new entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_ENTRY_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_ENTRY_ERROR_DETAILS", -1);

    /**
     * Error creating new entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_ENTRY_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_ENTRY_ERROR_SUMMARY", -1);

    /**
     * An error occurred creating index.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_INDEX_ERROR_DETAILS", -1);

    /**
     * Error creating index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_INDEX_ERROR_SUMMARY", -1);

    /**
     * An error occurred creating VLV index.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_VLV_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_VLV_INDEX_ERROR_DETAILS", -1);

    /**
     * Error creating VLV index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_NEW_VLV_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_NEW_VLV_INDEX_ERROR_SUMMARY", -1);

    /**
     * An error occurred creating object class '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_CREATING_OBJECTCLASS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_OBJECTCLASS_ERROR_DETAILS", -1);

    /**
     * Error creating object class
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_CREATING_OBJECTCLASS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_CREATING_OBJECTCLASS_ERROR_SUMMARY", -1);

    /**
     * The provided date already passed.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DATE_ALREADY_PASSED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DATE_ALREADY_PASSED", -1);

    /**
     * An error occurred deleting attribute '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_ATTRIBUTE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ATTRIBUTE_ERROR_DETAILS", -1);

    /**
     * Error deleting attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_ATTRIBUTE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ATTRIBUTE_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting backends.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_BACKENDS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_BACKENDS_ERROR_DETAILS", -1);

    /**
     * Error deleting backends
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_BACKENDS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_BACKENDS_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting base DNs.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_BASE_DNS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_BASE_DNS_ERROR_DETAILS", -1);

    /**
     * Error deleting base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_BASE_DNS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_BASE_DNS_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting entries
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_ENTRIES_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ENTRIES_ERROR_DETAILS", -1);

    /**
     * Error deleting entries
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_ENTRIES_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ENTRIES_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting entry '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_ENTRY_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ENTRY_ERROR_DETAILS", -1);

    /**
     * Error deleting entry
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_ENTRY_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_ENTRY_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting indexes '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_INDEXES_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_INDEXES_ERROR_DETAILS", -1);

    /**
     * Error deleting indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_INDEXES_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_INDEXES_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting index '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_INDEX_ERROR_DETAILS", -1);

    /**
     * Error deleting index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_INDEX_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting object class '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_OBJECTCLASS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_OBJECTCLASS_ERROR_DETAILS", -1);

    /**
     * Error deleting object class
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_OBJECTCLASS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_OBJECTCLASS_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting schema elements.  Check details for more information
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_ERROR_DETAILS", -1);

    /**
     * Error deleting schema elements
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_ERROR_SUMMARY", -1);

    /**
     * An error occurred deleting subtree '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_SUBTREE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_SUBTREE_ERROR_DETAILS", -1);

    /**
     * Error deleting subtree
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_SUBTREE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_SUBTREE_ERROR_SUMMARY", -1);

    /**
     * An error occurred VLV deleting index '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DELETING_VLV_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_VLV_INDEX_ERROR_DETAILS", -1);

    /**
     * Error deleting VLV index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DELETING_VLV_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DELETING_VLV_INDEX_ERROR_SUMMARY", -1);

    /**
     * An error occurred during the disabling of the Windows service.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_ERROR_DETAILS", -1);

    /**
     * Error during Disabling of Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_ERROR_SUMMARY", -1);

    /**
     * The DN is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DN_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DN_NOT_VALID", -1);

    /**
     * Invalid dn value: '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_DN_NOT_VALID_WITH_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DN_NOT_VALID_WITH_VALUE", -1);

    /**
     * You must provide the name of the new entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DUPLICATE_ENTRY_NAME_EMPTY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DUPLICATE_ENTRY_NAME_EMPTY", -1);

    /**
     * You must provide a valid DN for the parent entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DN_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DN_NOT_VALID", -1);

    /**
     * The parent entry does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DOES_NOT_EXIST", -1);

    /**
     * You have provided an empty alias.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_EMPTY_ALIAS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_EMPTY_ALIAS", -1);

    /**
     * An error occurred during the enabling of the Windows service.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_ERROR_DETAILS", -1);

    /**
     * Error during Enabling of Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_ERROR_SUMMARY", -1);

    /**
     * Entry '%s' already exists.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ENTRY_ALREADY_EXISTS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ENTRY_ALREADY_EXISTS", -1);

    /**
     * Error checking entry.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_CHECKING_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_CHECKING_ENTRY", -1);

    /**
     * An unexpected error occurred checking the provided Java settings.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_CHECKING_JAVA_SETTINGS_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_CHECKING_JAVA_SETTINGS_DETAILS", -1);

    /**
     * Error checking Java settings
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ERROR_CHECKING_JAVA_SETTINGS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_CHECKING_JAVA_SETTINGS_SUMMARY", -1);

    /**
     * Could not created local LDIF to populate new base DN with automatically generated data. Error details: %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_CREATING_NEW_DATA_LDIF =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_CREATING_NEW_DATA_LDIF", -1);

    /**
     * An error occurred decoding the provided base 64 string.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_DECODING_BASE64 =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_DECODING_BASE64", -1);

    /**
     * Error Reading Configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ERROR_READING_CONFIGURATION_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_READING_CONFIGURATION_SUMMARY", -1);

    /**
     * An error occurred reading the contents of the file.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_READING_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_READING_FILE", -1);

    /**
     * An error occurred searching entry '%s'.  Details:<br>%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_ERROR_SEARCHING_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_SEARCHING_ENTRY", -1);

    /**
     * Error updating schema.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_ERROR_UPDATING_SCHEMA =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERROR_UPDATING_SCHEMA", -1);

    /**
     * Error reading Java settings
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_ERR_READING_JAVA_SETTINGS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_ERR_READING_JAVA_SETTINGS_SUMMARY", -1);

    /**
     * An error occurred during the export.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_EXPORTING_LDIF_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_EXPORTING_LDIF_ERROR_DETAILS", -1);

    /**
     * Error during Export
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_EXPORTING_LDIF_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_EXPORTING_LDIF_ERROR_SUMMARY", -1);

    /**
     * The provided path '%s' exists and it is a directory.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_EXPORT_DIRECTORY_PROVIDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_EXPORT_DIRECTORY_PROVIDED", -1);

    /**
     * The file '%s' does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_FILE_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_FILE_DOES_NOT_EXIST", -1);

    /**
     * You have to provide a value for the file.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_FILE_NOT_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_FILE_NOT_PROVIDED", -1);

    /**
     * The Java home value '%s' is not valid.  This value will be used as fall back when the OPENDJ_JAVA_HOME environment variable is not defined.  If you do not want to specify a fall back, leave the Java Home text field empty or specify a valid Java home.<br>Error details:<br>%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_GENERIC_ERROR_FALLBACK_JAVAHOME =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_GENERIC_ERROR_FALLBACK_JAVAHOME", -1);

    /**
     * The group '%s' could not be found.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_GROUP_COULD_NOT_BE_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_GROUP_COULD_NOT_BE_FOUND", -1);

    /**
     * The provided LDAP URL value is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_GROUP_FILTER_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_GROUP_FILTER_NOT_VALID", -1);

    /**
     * You must provide an LDAP URL with a filter for the group.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_GROUP_FILTER_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_GROUP_FILTER_REQUIRED", -1);

    /**
     * You must specify a group.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_GROUP_NOT_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_GROUP_NOT_PROVIDED", -1);

    /**
     * An error occurred during the import.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_DETAILS", -1);

    /**
     * Error during Import
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_IMPORTING_LDIF_ERROR_SUMMARY", -1);

    /**
     * You are editing an abstract object class.  The following object classes are structural or auxiliary: %s.%nOnly auxiliary object classes can be used as superior object classes of an abstract object class.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_ABSTRACT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_ABSTRACT", -1);

    /**
     * You are editing an auxiliary object class.  The following object classes are structural: %s.%nOnly auxiliary or abstract object classes can be used as superior object classes of an auxiliary object class.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_AUXILIARY", -1);

    /**
     * You are editing a structural object class.  The following object classes are auxiliary: %s.%nOnly structural or abstract object classes can be used as superior object classes of a structural object class.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_STRUCTURAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INCOMPATIBLE_SUPERIORS_WITH_STRUCTURAL", -1);

    /**
     * You must select an index.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INDEX_MUST_BE_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INDEX_MUST_BE_SELECTED", -1);

    /**
     * You must select at least one index to be verified.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INDEX_TO_BE_VERIFIED_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INDEX_TO_BE_VERIFIED_REQUIRED", -1);

    /**
     * The provided name is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_ATTRIBUTE_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_ATTRIBUTE_NAME", -1);

    /**
     * The provided base DN is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_BASE_DN_FOR_VLV_PROVIDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_BASE_DN_FOR_VLV_PROVIDED", -1);

    /**
     * The provided base DN is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_BASE_DN_PROVIDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_BASE_DN_PROVIDED", -1);

    /**
     * The provided day value is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INVALID_DAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_DAY", -1);

    /**
     * The day '%d' does not exist in %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Object> ERR_CTRL_PANEL_INVALID_DAY_IN_MONTH =
                    new LocalizableMessageDescriptor.Arg2<Number, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_DAY_IN_MONTH", -1);

    /**
     * The entry is not correct.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_ENTRY", -1);

    /**
     * The entry limit must be an integer between %d and %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_CTRL_PANEL_INVALID_ENTRY_LIMIT_LABEL =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_ENTRY_LIMIT_LABEL", -1);

    /**
     * The provided value '%s' is not a valid filter.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_INVALID_FILTER_DETAILS_WITH_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_FILTER_DETAILS_WITH_VALUE", -1);

    /**
     * The provided filter is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_FILTER_FOR_VLV_PROVIDED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_FILTER_FOR_VLV_PROVIDED", -1);

    /**
     * The provided hour value is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INVALID_HOUR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_HOUR", -1);

    /**
     * The provided minute value is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INVALID_MINUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_MINUTE", -1);

    /**
     * The provided name is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_INVALID_OBJECTCLASS_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_OBJECTCLASS_NAME", -1);

    /**
     * The provided time value is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_INVALID_TIME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_TIME", -1);

    /**
     * The value of the wrap column must be between %d and %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_CTRL_PANEL_INVALID_WRAP_COLUMN =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_INVALID_WRAP_COLUMN", -1);

    /**
     * Could not find binary '%s'.  You must specify the path to the Java installation to be used.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_JAVA_BINARY_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_JAVA_BINARY_NOT_FOUND", -1);

    /**
     * Path '%s' does not exist.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_JAVA_PATH_DOES_NOT_EXIST =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_JAVA_PATH_DOES_NOT_EXIST", -1);

    /**
     * Path '%s' is not a directory.  You must specify the path to the Java installation to be used.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_JAVA_PATH_NOT_A_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_JAVA_PATH_NOT_A_DIRECTORY", -1);

    /**
     * To be able to launch tasks on a future date, the server must be running.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_LAUNCH_LATER_REQUIRES_SERVER_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_LAUNCH_LATER_REQUIRES_SERVER_RUNNING", -1);

    /**
     * To be able to launch tasks periodically, the server must be running.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_LAUNCH_SCHEDULE_REQUIRES_SERVER_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_LAUNCH_SCHEDULE_REQUIRES_SERVER_RUNNING", -1);

    /**
     * The entry '%s' could not be found.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MEMBER_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MEMBER_NOT_FOUND", -1);

    /**
     * You must provide a member for the group.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MEMBER_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MEMBER_REQUIRED", -1);

    /**
     * The provided value as member '%s' is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_MEMBER_VALUE_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MEMBER_VALUE_NOT_VALID", -1);

    /**
     * An error occurred modifying attribute '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MODIFYING_ATTRIBUTE_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_ATTRIBUTE_ERROR_DETAILS", -1);

    /**
     * Error modifying attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MODIFYING_ATTRIBUTE_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_ATTRIBUTE_ERROR_SUMMARY", -1);

    /**
     * An error occurred saving changes to entry '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MODIFYING_ENTRY_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_ENTRY_ERROR_DETAILS", -1);

    /**
     * Error saving changes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MODIFYING_ENTRY_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_ENTRY_ERROR_SUMMARY", -1);

    /**
     * An error occurred modifying index '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MODIFYING_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_INDEX_ERROR_DETAILS", -1);

    /**
     * Error modifying index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MODIFYING_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_INDEX_ERROR_SUMMARY", -1);

    /**
     * An error occurred modifying object class '%s'.  Check details for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MODIFYING_OBJECTCLASS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_OBJECTCLASS_ERROR_DETAILS", -1);

    /**
     * Error modifying object class
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MODIFYING_OBJECTCLASS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_OBJECTCLASS_ERROR_SUMMARY", -1);

    /**
     * An error occurred modifying VLV index '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_MODIFYING_VLV_INDEX_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_VLV_INDEX_ERROR_DETAILS", -1);

    /**
     * Error modifying VLV index
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MODIFYING_VLV_INDEX_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MODIFYING_VLV_INDEX_ERROR_SUMMARY", -1);

    /**
     * You must select a base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MUST_SELECT_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MUST_SELECT_BASE_DN", -1);

    /**
     * You must select at least one index to be rebuilt.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_MUST_SELECT_INDEX_TO_REBUILD =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_MUST_SELECT_INDEX_TO_REBUILD", -1);

    /**
     * You must provide a value for the name of the domain.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NAME_OF_DOMAIN_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NAME_OF_DOMAIN_REQUIRED", -1);

    /**
     * You must provide a value for the name of the group.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NAME_OF_GROUP_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NAME_OF_GROUP_REQUIRED", -1);

    /**
     * You must provide a value for the name of the organization.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NAME_OF_ORGANIZATION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NAME_OF_ORGANIZATION_REQUIRED", -1);

    /**
     * You must provide a value for the Name of the Organizational Unit.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NAME_OF_OU_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NAME_OF_OU_REQUIRED", -1);

    /**
     * You must provide a value for the new password.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NEW_PASSWORD_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NEW_PASSWORD_REQUIRED", -1);

    /**
     * The base DN '%s' is not a descendant of any of the base DNs defined in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_NOT_A_DESCENDANT_OF_BASE_DN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_A_DESCENDANT_OF_BASE_DN", -1);

    /**
     * The entry '%s' exists but it is not an static group.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_NOT_A_STATIC_GROUP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_A_STATIC_GROUP", -1);

    /**
     * The attribute '%s' has not a valid name.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_NOT_VALID_ATTRIBUTE_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_ATTRIBUTE_NAME", -1);

    /**
     * The hour value provided is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NOT_VALID_CRON_HOUR_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_CRON_HOUR_PROVIDED", -1);

    /**
     * The minute value provided is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NOT_VALID_CRON_MINUTE_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_CRON_MINUTE_PROVIDED", -1);

    /**
     * The day of month value provided is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NOT_VALID_CRON_MONTH_DAY_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_CRON_MONTH_DAY_PROVIDED", -1);

    /**
     * The month value provided is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NOT_VALID_CRON_MONTH_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_CRON_MONTH_PROVIDED", -1);

    /**
     * The day of week value provided is not valid.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NOT_VALID_CRON_WEEK_DAY_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_VALID_CRON_WEEK_DAY_PROVIDED", -1);

    /**
     * The Java binary '%s' could not be used to launch the server scripts.  This value will be used as fall back when the OPENDJ_JAVA_HOME environment variable is not defined.  If you do not want to specify a fall back, leave the Java Home text field empty or specify a valid Java home.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_NOT_WORKING_FALLBACK_JVM_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_WORKING_FALLBACK_JVM_DETAILS", -1);

    /**
     * The Java binary '%s' could not be used to launch the server scripts.<br>The server cannot run using the provided Java Home.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_NOT_WORKING_JVM_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NOT_WORKING_JVM_DETAILS", -1);

    /**
     * You must select at least one attribute for the sort order.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_ATTRIBUTE_FOR_VLV_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_ATTRIBUTE_FOR_VLV_PROVIDED", -1);

    /**
     * No backends available.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKENDS_AVAILABLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKENDS_AVAILABLE", -1);

    /**
     * There are no backends defined.  To create and manage indexes, you must create a backend.  To create a new backend you can use the action "New Base DN".
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKENDS_FOUND_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKENDS_FOUND_DETAILS", -1);

    /**
     * No Backends Found
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKENDS_FOUND_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKENDS_FOUND_TITLE", -1);

    /**
     * No backends selected.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKENDS_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKENDS_SELECTED", -1);

    /**
     * No backend selected.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKEND_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKEND_SELECTED", -1);

    /**
     * No backup ID provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKUP_ID_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKUP_ID_PROVIDED", -1);

    /**
     * No backup path provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BACKUP_PATH_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BACKUP_PATH_PROVIDED", -1);

    /**
     * No base DNs defined.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BASE_DNS_DEFINED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BASE_DNS_DEFINED_LABEL", -1);

    /**
     * You must provide a base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BASE_DN_FOR_VLV_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BASE_DN_FOR_VLV_PROVIDED", -1);

    /**
     * You must provide a base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_BASE_DN_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_BASE_DN_PROVIDED", -1);

    /**
     * No hour provided.  Use '*' to indicate any value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_CRON_HOUR_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_CRON_HOUR_PROVIDED", -1);

    /**
     * No minute provided.  Use '*' to indicate any value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_CRON_MINUTE_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_CRON_MINUTE_PROVIDED", -1);

    /**
     * No day of month provided.  Use '*' to indicate any value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_CRON_MONTH_DAY_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_CRON_MONTH_DAY_PROVIDED", -1);

    /**
     * No month provided.  Use '*' to indicate any value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_CRON_MONTH_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_CRON_MONTH_PROVIDED", -1);

    /**
     * No day of week provided.  Use '*' to indicate any value.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_CRON_WEEK_DAY_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_CRON_WEEK_DAY_PROVIDED", -1);

    /**
     * You must provide a filter for the index.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_FILTER_FOR_VLV_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_FILTER_FOR_VLV_PROVIDED", -1);

    /**
     * No indexes defined for base DN '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_NO_INDEXES_FOR_BASEDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_INDEXES_FOR_BASEDN", -1);

    /**
     * No index selected on the tree.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_INDEX_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_INDEX_SELECTED", -1);

    /**
     * You must select at least one index type (approximate, equality, ordering, presence or substring).
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_INDEX_TYPE_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_INDEX_TYPE_SELECTED", -1);

    /**
     * You must select at least one day of the month.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_MONTH_DAY_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_MONTH_DAY_SELECTED", -1);

    /**
     * No parent backup ID provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_PARENT_BACKUP_ID_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_PARENT_BACKUP_ID_PROVIDED", -1);

    /**
     * You have chosen to run an incremental backup.  You must select the parent backup in the list of available parent backups.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_PARENT_BACKUP_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_PARENT_BACKUP_SELECTED", -1);

    /**
     * You must provide the parent directory containing the backup files.  Then click on 'Refresh' to update the list of available backups.<br>Finally select a backup from the list.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_PARENT_BACKUP_TO_VERIFY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_PARENT_BACKUP_TO_VERIFY", -1);

    /**
     * No VLV index name provided.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_VLV_INDEX_NAME_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_VLV_INDEX_NAME_PROVIDED", -1);

    /**
     * You must select at least one day of the week.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_NO_WEEK_DAY_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_NO_WEEK_DAY_SELECTED", -1);

    /**
     * An object class cannot be its own superior.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_OBJECTCLASS_CANNOT_BE_ITS_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OBJECTCLASS_CANNOT_BE_ITS_SUPERIOR", -1);

    /**
     * The object class is superior (directly or indirectly) of '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_OBJECTCLASS_IS_SUPERIOR_OF_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OBJECTCLASS_IS_SUPERIOR_OF_SUPERIOR", -1);

    /**
     * The provided name '%s' already exists in the schema (defined as %s).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_OBJECTCLASS_NAME_ALREADY_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OBJECTCLASS_NAME_ALREADY_IN_USE", -1);

    /**
     * You must provide a name for the object class.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_OBJECTCLASS_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OBJECTCLASS_NAME_REQUIRED", -1);

    /**
     * The provided OID '%s' already exists in the schema (defined as %s).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_OID_ALREADY_IN_USE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OID_ALREADY_IN_USE", -1);

    /**
     * The provided OID is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_OID_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_OID_NOT_VALID", -1);

    /**
     * The provided passwords do not match.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_PASSWORD_DO_NOT_MATCH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_PASSWORD_DO_NOT_MATCH", -1);

    /**
     * The path '%s' is a directory.  You must provide a file.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_PATH_IS_A_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_PATH_IS_A_DIRECTORY", -1);

    /**
     * An unexpected error occurred reading the Java settings.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_READING_JAVA_SETTINGS_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_READING_JAVA_SETTINGS_DETAILS", -1);

    /**
     * An error occurred rebuilding index.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_REBUILDING_INDEXES_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REBUILDING_INDEXES_ERROR_DETAILS", -1);

    /**
     * Error Rebuilding Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REBUILDING_INDEXES_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REBUILDING_INDEXES_ERROR_SUMMARY", -1);

    /**
     * The provided Reference Group exists but it is not a dynamic group.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_DYNAMIC =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_DYNAMIC", -1);

    /**
     * The provided Reference Group could not be found.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_FOUND", -1);

    /**
     * The provided Dynamic Group Reference DN is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REFERENCE_GROUP_NOT_VALID", -1);

    /**
     * The selected referral is defined in server %s and is referencing to an entry in the same server that is an ascentor of the entry.  This configuration generates a loop in the DIT structure that should be avoided.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_REFERRAL_LOOP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REFERRAL_LOOP", -1);

    /**
     * The rejects and skips file must have different values.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REJECTS_AND_SKIPS_MUST_BE_DIFFERENT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REJECTS_AND_SKIPS_MUST_BE_DIFFERENT", -1);

    /**
     * You must provide a value for the rejects file.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REJECTS_FILE_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REJECTS_FILE_REQUIRED", -1);

    /**
     * You must select a backup from the list of available backups.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_REQUIRED_BACKUP_TO_VERIFY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_REQUIRED_BACKUP_TO_VERIFY", -1);

    /**
     * An error occurred updating user password.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_RESETTING_USER_PASSWORD_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESETTING_USER_PASSWORD_ERROR_DETAILS", -1);

    /**
     * Error updating user password
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_RESETTING_USER_PASSWORD_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESETTING_USER_PASSWORD_ERROR_SUMMARY", -1);

    /**
     * The error occurred solving referral '%s'.<br>Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_RESOLVING_REFERRAL_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESOLVING_REFERRAL_DETAILS", -1);

    /**
     * An error occurred restarting the server.  Error code: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_RESTARTING_SERVER_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESTARTING_SERVER_ERROR_DETAILS", -1);

    /**
     * Error during server restart
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_RESTARTING_SERVER_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESTARTING_SERVER_ERROR_SUMMARY", -1);

    /**
     * An error occurred during the restore.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_RESTORING_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESTORING_ERROR_DETAILS", -1);

    /**
     * Error during Restore
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_RESTORING_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RESTORING_ERROR_SUMMARY", -1);

    /**
     * An error occurred during the backup.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_RUN_BACKUP_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RUN_BACKUP_ERROR_DETAILS", -1);

    /**
     * Error during Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_RUN_BACKUP_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_RUN_BACKUP_ERROR_SUMMARY", -1);

    /**
     * The schema could not be found.  Check main panel for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_SCHEMA_NOT_FOUND_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_SCHEMA_NOT_FOUND_DETAILS", -1);

    /**
     * Could not find schema
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_SCHEMA_NOT_FOUND_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_SCHEMA_NOT_FOUND_SUMMARY", -1);

    /**
     * Error setting environment: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_SETTING_ENVIRONMENT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_SETTING_ENVIRONMENT", -1);

    /**
     * You must provide a value for the skips file.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_SKIPS_FILE_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_SKIPS_FILE_REQUIRED", -1);

    /**
     * An error occurred starting the server.  Error code: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_STARTING_SERVER_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_STARTING_SERVER_ERROR_DETAILS", -1);

    /**
     * Error during server start
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_STARTING_SERVER_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_STARTING_SERVER_ERROR_SUMMARY", -1);

    /**
     * An error occurred stopping the server.  Error code: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_STOPPING_SERVER_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_STOPPING_SERVER_ERROR_DETAILS", -1);

    /**
     * Error during Server Stop
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_STOPPING_SERVER_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_STOPPING_SERVER_ERROR_SUMMARY", -1);

    /**
     * The command-line %s returned successfully but the server appears to be running.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_STOPPING_SERVER_POST_CMD_LINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_STOPPING_SERVER_POST_CMD_LINE", -1);

    /**
     * Unexpected error. Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_UNEXPECTED_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_UNEXPECTED_DETAILS", -1);

    /**
     * An error occurred updating Java settings.  Error code: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_CODE =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_CODE", -1);

    /**
     * An error occurred updating Java settings.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_DETAILS", -1);

    /**
     * Error updating Java properties
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_UPDATING_JAVA_SETTINGS_ERROR_SUMMARY", -1);

    /**
     * You must provide a value for 'Common Name'.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_USER_COMMON_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_USER_COMMON_NAME_REQUIRED", -1);

    /**
     * You must provide a value for 'Last Name'.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_USER_LAST_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_USER_LAST_NAME_REQUIRED", -1);

    /**
     * You must provide a value for the naming attribute '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_CTRL_PANEL_USER_NAMING_ATTRIBUTE_REQUIRED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_USER_NAMING_ATTRIBUTE_REQUIRED", -1);

    /**
     * You must provide a value in Base 64 format.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_VALUE_IN_BASE_64_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VALUE_IN_BASE_64_REQUIRED", -1);

    /**
     * An error occurred during the backup verification.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_VERIFYING_BACKUP_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VERIFYING_BACKUP_ERROR_DETAILS", -1);

    /**
     * Error during Backup Verification
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_VERIFYING_BACKUP_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VERIFYING_BACKUP_ERROR_SUMMARY", -1);

    /**
     * An error occurred during the index verification.  Error code: %d.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_CTRL_PANEL_VERIFYING_INDEXES_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VERIFYING_INDEXES_ERROR_DETAILS", -1);

    /**
     * Error during Index Verification
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_CTRL_PANEL_VERIFYING_INDEXES_ERROR_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VERIFYING_INDEXES_ERROR_SUMMARY", -1);

    /**
     * There is already a VLV index '%s' defined in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_CTRL_PANEL_VLV_INDEX_ALREADY_DEFINED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_CTRL_PANEL_VLV_INDEX_ALREADY_DEFINED", -1);

    /**
     * There is no task with ID '%s' in the server.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_DEPENDENCY_TASK_NOT_DEFINED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_DEPENDENCY_TASK_NOT_DEFINED", -1);

    /**
     * Could not connect to the Directory Server %s with the provided credentials.%nError details: %s%n%nProvide again the required information to connect to the server:
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_ERROR_CONNECTING_TO_SERVER_PROMPT_AGAIN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_ERROR_CONNECTING_TO_SERVER_PROMPT_AGAIN", -1);

    /**
     * Error searching backups
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_ERROR_SEARCHING_BACKUPS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_ERROR_SEARCHING_BACKUPS_SUMMARY", -1);

    /**
     * The thread number must be a positive integer.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_IMPORT_THREAD_NUMBER_INVALID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_IMPORT_THREAD_NUMBER_INVALID", -1);

    /**
     * The remote server in '%s' has not the same version as the control panel.  The remote server version is '%s.%s.%s' and the control panel version is '%d.%d.%d'.
     */
    public static final LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Number, Number, Number> ERR_INCOMPATIBLE_VERSION_IN_REMOTE_SERVER =
                    new LocalizableMessageDescriptor.Arg7<Object, Object, Object, Object, Number, Number, Number>(AdminToolMessages.class, RESOURCE, "ERR_INCOMPATIBLE_VERSION_IN_REMOTE_SERVER", -1);

    /**
     * No attribute name selected.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INFO_CTRL_ATTRIBUTE_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_INFO_CTRL_ATTRIBUTE_NAME_REQUIRED", -1);

    /**
     * The entry limit must be an integer between %d and %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_INFO_CTRL_PANEL_ENTRY_LIMIT_NOT_VALID =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "ERR_INFO_CTRL_PANEL_ENTRY_LIMIT_NOT_VALID", -1);

    /**
     * You must select at least one index type (approximate, equality, ordering, presence or substring).
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_INFO_ONE_INDEX_TYPE_MUST_BE_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_INFO_ONE_INDEX_TYPE_MUST_BE_SELECTED", -1);

    /**
     * Error initializing.  Could not find replication ID in the server %s for base DN %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_INITIALIZING_REPLICATIONID_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_INITIALIZING_REPLICATIONID_NOT_FOUND", -1);

    /**
     * The value '%s' is not a valid email address.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INVALID_EMAIL_ADDRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_INVALID_EMAIL_ADDRESS", -1);

    /**
     * Error launching the operation.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LAUNCHING_POST_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_LAUNCHING_POST_EXTERNAL_INITIALIZATION", -1);

    /**
     * Error launching the operation.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LAUNCHING_PRE_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_LAUNCHING_PRE_EXTERNAL_INITIALIZATION", -1);

    /**
     * Error launching the operation.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LAUNCHING_PURGE_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_LAUNCHING_PURGE_HISTORICAL", -1);

    /**
     * You must provide the LDIF representation of the entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LDIF_REPRESENTATION_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_LDIF_REPRESENTATION_REQUIRED", -1);

    /**
     * Error loading image
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_LOADING_IMAGE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_LOADING_IMAGE", -1);

    /**
     * You must provide a name for the new backend.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NEW_BACKEND_NAME_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NEW_BACKEND_NAME_REQUIRED", -1);

    /**
     * You must provide a value for the base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NEW_BASE_DN_VALUE_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NEW_BASE_DN_VALUE_REQUIRED", -1);

    /**
     * Non Modifiable attributes must have an operational usage.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NON_MODIFIABLE_CANNOT_BE_USER_APPLICATIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NON_MODIFIABLE_CANNOT_BE_USER_APPLICATIONS", -1);

    /**
     * You do not have access rights to the configuration of the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NOT_ADMINISTRATIVE_USER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NOT_ADMINISTRATIVE_USER", -1);

    /**
     * The remote server in '%s' cannot be managed by this control panel.  The remote server product name is '%s' and the control panel product name is '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_NOT_SAME_PRODUCT_IN_REMOTE_SERVER_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_NOT_SAME_PRODUCT_IN_REMOTE_SERVER_NOT_FOUND", -1);

    /**
     * There are no base DNs replicated in the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_DISABLE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_DISABLE_REPLICATION", -1);

    /**
     * There are no base DNs available to enable replication between the two servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_ENABLE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_ENABLE_REPLICATION", -1);

    /**
     * There are no base DNs available to enable replication between the two servers.  You must specify at least one server that will contain the replicated data, before configuring servers that will only contain the replication changelog (replication servers).
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_ENABLE_REPLICATION_NO_DOMAIN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_ENABLE_REPLICATION_NO_DOMAIN", -1);

    /**
     * There are no base DNs replicated in the server.  The base DNs must be replicated to be able to use their contents to initialize the base DNs on the other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_ALL_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_ALL_REPLICATION", -1);

    /**
     * There are no base DNs replicated in the server.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_LOCAL_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_LOCAL_REPLICATION", -1);

    /**
     * There are no Base DNs replicated between the two servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_INITIALIZE_REPLICATION", -1);

    /**
     * There are no base DNs available to purge historical.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_AVAILABLE_TO_PURGE_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_AVAILABLE_TO_PURGE_HISTORICAL", -1);

    /**
     * You must choose at least one base DN to be disabled.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_DISABLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_DISABLE", -1);

    /**
     * You must choose at least one base DN to be initialized.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_INITIALIZE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_INITIALIZE", -1);

    /**
     * You must choose at least one base DN to initialize.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_INITIALIZE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_INITIALIZE_ALL", -1);

    /**
     * You must specify the base DNs that have been initialized using the import-ldif command or the binary copy.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_POST_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_POST_EXTERNAL_INITIALIZATION", -1);

    /**
     * You must specify the base DNs that will be initialized using the import-ldif command or the binary copy.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_PRE_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_PRE_EXTERNAL_INITIALIZATION", -1);

    /**
     * You must choose at least one base DN to be purged from historical.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_PURGE_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_PURGE_HISTORICAL", -1);

    /**
     * You must choose at least one Base DN to be replicated.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_NO_SUFFIXES_SELECTED_TO_REPLICATE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_NO_SUFFIXES_SELECTED_TO_REPLICATE", -1);

    /**
     * The number of user entries to generate must be between %d and %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> ERR_NUMBER_OF_ENTRIES_INVALID =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "ERR_NUMBER_OF_ENTRIES_INVALID", -1);

    /**
     * You must provide the objectclass values of the entry.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_OBJECTCLASS_FOR_ENTRY_REQUIRED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_OBJECTCLASS_FOR_ENTRY_REQUIRED", -1);

    /**
     * Error reading data from server.  Verify the authentication information provided.%nDetails: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_READING_CONFIG_LDAP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_READING_CONFIG_LDAP", -1);

    /**
     * Error reading schema from the remote server.%nDetails: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_READING_SCHEMA_LDAP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_READING_SCHEMA_LDAP", -1);

    /**
     * Error reading the progress of the operation.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_READING_SERVER_TASK_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_READING_SERVER_TASK_PROGRESS", -1);

    /**
     * Referral limit (%d) reached.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_REFERRAL_LIMIT_EXCEEDED =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_REFERRAL_LIMIT_EXCEEDED", -1);

    /**
     * The errors reading the registry information on %s do not allow to do the merge between the replication topologies.  You will have to fix the following problems before merging the topologies:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_CANNOT_MERGE_WITH_ERRORS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_CANNOT_MERGE_WITH_ERRORS", -1);

    /**
     * Cannot write to file %s.  Verify that you have access rights to that file and that you provided the full path of the file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_CANNOT_WRITE_EQUIVALENT_COMMAND_LINE_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_CANNOT_WRITE_EQUIVALENT_COMMAND_LINE_FILE", -1);

    /**
     * Error updating replication configuration on base DN %s of server %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_CONFIGURING_BASEDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_CONFIGURING_BASEDN", -1);

    /**
     * Error configuring replication port on server %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_CONFIGURING_REPLICATIONSERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_CONFIGURING_REPLICATIONSERVER", -1);

    /**
     * The following base DNs could not be found in the server:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_DISABLE_SUFFIXES_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_DISABLE_SUFFIXES_NOT_FOUND", -1);

    /**
     * Error disabling replication port on server %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_DISABLING_REPLICATIONSERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_DISABLING_REPLICATIONSERVER", -1);

    /**
     * The following servers in the two topologies have the same domain ID%n%s%n%nThe replication topologies cannot be merged.  To fix this problem please refer to the documentation.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_ENABLE_COMMON_DOMAIN_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_COMMON_DOMAIN_ID", -1);

    /**
     * Server %s (base DN '%s') and server %s (base DN '%s') have the same domain ID: %d.
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number> ERR_REPLICATION_ENABLE_COMMON_DOMAIN_ID_ARG =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Number>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_COMMON_DOMAIN_ID_ARG", -1);

    /**
     * The following servers in the two topologies have the same replication server ID%n%s%n%nThe replication topologies cannot be merged.  To fix this problem please refer to the documentation.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_ENABLE_COMMON_REPLICATION_SERVER_ID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_COMMON_REPLICATION_SERVER_ID", -1);

    /**
     * Server %s and server %s have the same replication server ID: %d.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> ERR_REPLICATION_ENABLE_COMMON_REPLICATION_SERVER_ID_ARG =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_COMMON_REPLICATION_SERVER_ID_ARG", -1);

    /**
     * You have to provide two different servers to enable replication.  You have provided twice the server %s:%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_ENABLE_SAME_SERVER_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_SAME_SERVER_PORT", -1);

    /**
     * An unexpected error occurred seeding the truststore contents of server %s with truststore of server %s.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_REPLICATION_ENABLE_SEEDING_TRUSTSTORE =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_SEEDING_TRUSTSTORE", -1);

    /**
     * The following base DNs cannot be replicated between the two servers because they could not be found in at least one of the servers:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_ENABLE_SUFFIXES_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ENABLE_SUFFIXES_NOT_FOUND", -1);

    /**
     * The specified path %s to write the equivalent command is a directory.  You must specify a path to a file
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_EQUIVALENT_COMMAND_LINE_FILE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_EQUIVALENT_COMMAND_LINE_FILE_DIRECTORY", -1);

    /**
     * Error reading replication configuration of server %s.%nDetails: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_ERROR_READING_CONFIGURATION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ERROR_READING_CONFIGURATION", -1);

    /**
     * An error occurred while attempting to write equivalent non-interactive command line to file %s.  Error details:  %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_ERROR_WRITING_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_ERROR_WRITING_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * The following base DNs could not be found in the server:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_INITIALIZE_LOCAL_SUFFIXES_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_INITIALIZE_LOCAL_SUFFIXES_NOT_FOUND", -1);

    /**
     * Error initializing.  Could not find a peer to start the initialization after several tries.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_INITIALIZING_TRIES_COMPLETED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_INITIALIZING_TRIES_COMPLETED", -1);

    /**
     * The administrative base DN '%s' cannot be replicated. Please provide a base DN that contains user data.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_NOT_A_USER_SUFFIX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NOT_A_USER_SUFFIX", -1);

    /**
     * The provided value %s is not a valid base DN.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_NOT_A_VALID_BASEDN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NOT_A_VALID_BASEDN", -1);

    /**
     * You must provide the password of the global administrator in non interactive mode.  You can provide it using the %s or the %s options.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_NO_ADMINISTRATOR_PASSWORD_PROVIDED =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NO_ADMINISTRATOR_PASSWORD_PROVIDED", -1);

    /**
     * You must provide at least one Base DN in non interactive mode.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REPLICATION_NO_BASE_DN_PROVIDED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NO_BASE_DN_PROVIDED", -1);

    /**
     * 
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REPLICATION_NO_MESSAGE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NO_MESSAGE", -1);

    /**
     * No replication server is defined for the following base DNs:%n%s%nAt least one replication server (a changelog) is required in the replication topology.  It is recommended to have at least two replication servers (two changelogs) to avoid a single point of failure in the replication topology.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_NO_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_NO_REPLICATION_SERVER", -1);

    /**
     * The server administration port and the replication port have the same value in host %s.  You provided %s for both.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_PORT_AND_REPLICATION_PORT_EQUAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_PORT_AND_REPLICATION_PORT_EQUAL", -1);

    /**
     * An error occurred executing the purge historical.  Details: %s.%nYou can check the error logs of the local server for more information.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_PURGE_HISTORICAL_EXECUTING =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_PURGE_HISTORICAL_EXECUTING", -1);

    /**
     * The specified maximum time of %d seconds was elapsed before the purge historical completed.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> ERR_REPLICATION_PURGE_HISTORICAL_TIMEOUT =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_PURGE_HISTORICAL_TIMEOUT", -1);

    /**
     * The following base DNs could not be found in the server:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_PURGE_SUFFIXES_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_PURGE_SUFFIXES_NOT_FOUND", -1);

    /**
     * Error reading registration information.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_READING_ADS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_READING_ADS", -1);

    /**
     * The following errors were encountered reading the configuration of the existing servers:%n%s%n%nIf you continue the replication tool will to try to update the configuration of all the servers in a best-effort mode.  However it cannot guarantee that the servers that are generating errors will be updated.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_READING_REGISTERED_SERVERS_CONFIRM_UPDATE_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_READING_REGISTERED_SERVERS_CONFIRM_UPDATE_REMOTE", -1);

    /**
     * The following errors were encountered reading the configuration of the existing servers:
%s
The replication tool will to try to update the configuration of all the servers in a best-effort mode.  However it cannot guarantee that the servers that are generating errors will be updated.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_READING_REGISTERED_SERVERS_WARNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_READING_REGISTERED_SERVERS_WARNING", -1);

    /**
     * You have provided the same replication port (%s) for two servers located on the same machine (%s).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_SAME_REPLICATION_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_SAME_REPLICATION_PORT", -1);

    /**
     * The '%s' subcommand is not compatible with the %s option.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_REPLICATION_STATUS_QUIET =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_STATUS_QUIET", -1);

    /**
     * The displayed information might not be complete because the following errors were encountered reading the configuration of the existing servers:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_STATUS_READING_REGISTERED_SERVERS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_STATUS_READING_REGISTERED_SERVERS", -1);

    /**
     * Error updating registration information.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_UPDATING_ADS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_UPDATING_ADS", -1);

    /**
     * User cancelled the operation
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_REPLICATION_USER_CANCELLED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_USER_CANCELLED", -1);

    /**
     * Could not find a valid subcommand.  You must specify a subcommand when using the option %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_REPLICATION_VALID_SUBCOMMAND_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_REPLICATION_VALID_SUBCOMMAND_NOT_FOUND", -1);

    /**
     * You have to provide two different servers as source and destination of the initialization.  You have provided twice the server %s:%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_SOURCE_DESTINATION_INITIALIZE_SAME_SERVER_PORT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_SOURCE_DESTINATION_INITIALIZE_SAME_SERVER_PORT", -1);

    /**
     * The following base DNs cannot be initialized because they are not replicated or they are not configured on both servers:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_SUFFIXES_CANNOT_BE_INITIALIZED =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_SUFFIXES_CANNOT_BE_INITIALIZED", -1);

    /**
     * Unexpected error during the operation.  Task state: %s.  Check the error logs of %s for more information.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNEXPECTED_DURING_TASK_NO_LOG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_UNEXPECTED_DURING_TASK_NO_LOG", -1);

    /**
     * Unexpected error during the operation.  Last log details: %s.  Task state: %s.  Check the error logs of %s for more information.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> ERR_UNEXPECTED_DURING_TASK_WITH_LOG =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_UNEXPECTED_DURING_TASK_WITH_LOG", -1);

    /**
     * This server is configured to replicate some of its base DNs.  There was an error retrieving the references to it in the replicated servers.  Note that to be able to remove remote references you must provide Global Administrator credentials using the %s and %s (or %s) options.%nContinuing uninstall as we are on force on error mode.%n%nThe error found was:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> ERR_UNINSTALL_ERROR_UPDATING_REMOTE_FORCE =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_ERROR_UPDATING_REMOTE_FORCE", -1);

    /**
     * This server is configured to replicate some of its base DNs.  There was an error retrieving the references to it in the replicated servers.  Note that to be able to remove remote references you must provide Global Administrator credentials using the %s and %s (or %s) options.%nCheck that the connection parameters you provided are correct.%nIf you want to uninstall the server even when remote references cannot be removed, you can use the %s option.%n%nThe error found was:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object> ERR_UNINSTALL_ERROR_UPDATING_REMOTE_NO_FORCE =
                    new LocalizableMessageDescriptor.Arg5<Object, Object, Object, Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_ERROR_UPDATING_REMOTE_NO_FORCE", -1);

    /**
     * The %s option only can be used when %s has been specified
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> ERR_UNINSTALL_FORCE_REQUIRES_NO_PROMPT =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_FORCE_REQUIRES_NO_PROMPT", -1);

    /**
     * %n%nThe graphical Uninstall launch failed.%n%nLaunching command line uninstall...
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNINSTALL_LAUNCHER_GUI_LAUNCHED_FAILED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_LAUNCHER_GUI_LAUNCHED_FAILED", -1);

    /**
     * %n%nThe graphical Uninstall launch failed.  Check file %s for more details.%n%nLaunching command line uninstall...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNINSTALL_LAUNCHER_GUI_LAUNCHED_FAILED_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_LAUNCHER_GUI_LAUNCHED_FAILED_DETAILS", -1);

    /**
     * This server is configured to replicate some of its base DNs.  There was an error retrieving the references to it in the replicated servers.%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_UNINSTALL_NOT_UPDATE_REMOTE_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_NOT_UPDATE_REMOTE_PROMPT", -1);

    /**
     * The following errors were encountered reading the configuration of the existing servers:%n%s%nDo you want the uninstaller to try to remove the references to this server in a best-effort mode?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_UNINSTALL_READING_REGISTERED_SERVERS_CONFIRM_UPDATE_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "ERR_UNINSTALL_READING_REGISTERED_SERVERS_CONFIRM_UPDATE_REMOTE", -1);

    /**
     * Could not find version information in the remote server.  The remote LDAP server does not seem to be manageable remotely by the control panel.
     */
    public static final LocalizableMessageDescriptor.Arg0 ERR_VERSION_IN_REMOTE_SERVER_NOT_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "ERR_VERSION_IN_REMOTE_SERVER_NOT_FOUND", -1);

    /**
     * Address:Port
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADDRESS_PORT_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ADDRESS_PORT_COLUMN", -1);

    /**
     * Administrative Users:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ADMINISTRATIVE_USERS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ADMINISTRATIVE_USERS_LABEL", -1);

    /**
     * Age of Oldest Missing Change
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_AGE_OF_OLDEST_MISSING_CHANGE_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_AGE_OF_OLDEST_MISSING_CHANGE_COLUMN", -1);

    /**
     * The following base DNs are not replicated:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ALREADY_NOT_REPLICATED_SUFFIXES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_ALREADY_NOT_REPLICATED_SUFFIXES", -1);

    /**
     * The following base DNs are already replicated between the two servers:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ALREADY_REPLICATED_SUFFIXES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_ALREADY_REPLICATED_SUFFIXES", -1);

    /**
     * The selected attributes are superior of the following attributes: %s.  If you continue, these attributes will be updated with a new superior.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ATTRIBUTES_ARE_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_ATTRIBUTES_ARE_SUPERIOR", -1);

    /**
     * The selected attributes are optional or required by the following object classes: %s.  If you continue, the definition of the object classes will be modified.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ATTRIBUTES_WITH_DEPENDENCIES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_ATTRIBUTES_WITH_DEPENDENCIES", -1);

    /**
     * Attribute '%s' is superior of the following attributes: %s.  If you continue, these attributes will be updated with a new superior.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ATTRIBUTE_IS_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_ATTRIBUTE_IS_SUPERIOR", -1);

    /**
     * Attribute '%s' is optional or required by the following object classes: %s.  If you continue, the definition of the object classes will be modified.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ATTRIBUTE_WITH_DEPENDENCIES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_ATTRIBUTE_WITH_DEPENDENCIES", -1);

    /**
     * Authenticate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_AUTHENTICATE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_AUTHENTICATE_BUTTON_LABEL", -1);

    /**
     * The available defined tasks are:%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_AVAILABLE_DEFINED_TASKS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_AVAILABLE_DEFINED_TASKS", -1);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BACKENDID_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_BACKENDID_COLUMN", -1);

    /**
     * Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_BASEDN_COLUMN", -1);

    /**
     * Disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_DISABLED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_BASEDN_DISABLED_LABEL", -1);

    /**
     * 
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_NOT_REPLICATED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_BASEDN_NOT_REPLICATED_LABEL", -1);

    /**
     * Enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_BASEDN_REPLICATED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_BASEDN_REPLICATED_LABEL", -1);

    /**
     * Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_DO_YOU_WANT_TO_CONTINUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_DO_YOU_WANT_TO_CONTINUE", -1);

    /**
     * Remove Backup Files Contained in bak Directory?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_BACKUPS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_BACKUPS", -1);

    /**
     * Remove Configuration and Schema Files?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_CONFIGURATION_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_CONFIGURATION_SCHEMA", -1);

    /**
     * Remove Database Contents?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_DATABASES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_DATABASES", -1);

    /**
     * The files will be permanently deleted, are you sure you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_DELETE_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_DELETE_FILES", -1);

    /**
     * Remove LDIF Export Files Contained in ldif Directory?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_LDIFS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_LDIFS", -1);

    /**
     * Remove Server Libraries and Administrative Tools?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_LIBRARIES_BINARIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_LIBRARIES_BINARIES", -1);

    /**
     * Remove Log Files?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_LOGS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_LOGS", -1);

    /**
     * The Directory Server contains database files in the following locations outside the server path:%n%s%nRemove these files?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CLI_UNINSTALL_CONFIRM_OUTSIDEDBS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_OUTSIDEDBS", -1);

    /**
     * The Directory Server contains log files in the following locations outside the server path:%n%s%nRemove these files?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CLI_UNINSTALL_CONFIRM_OUTSIDELOGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_OUTSIDELOGS", -1);

    /**
     * The server is currently running and must be stopped before uninstallation can continue.%nStop the Server and permanently delete the files?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_STOP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_STOP", -1);

    /**
     * This server is configured to do replication.%nIf the server is actually replicating contents with other servers you must provide administrator authentication to remove references to this server in the replicating servers.%n%nType 'Yes' to provide authentication to remove the remote references.%nType 'No' to continue the uninstall without updating remote references.%nProvide authentication?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_UPDATE_REMOTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_UPDATE_REMOTE", -1);

    /**
     * This server is configured to do replication.%nIf the server is actually replicating contents with other servers it must be started and you must provide administrator authentication to remove references to this server in the replicating servers.%n%nType 'Yes' to start the server and then provide authentication to remove the remote references.%nType 'No' to continue the uninstall without updating remote references.%nStart the server and provide authentication?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_CONFIRM_UPDATE_REMOTE_AND_START =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_CONFIRM_UPDATE_REMOTE_AND_START", -1);

    /**
     * Remove all components
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_REMOVE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_REMOVE_ALL", -1);

    /**
     * Select the components to be removed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_SPECIFY_WHAT_REMOVE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_SPECIFY_WHAT_REMOVE", -1);

    /**
     * Do you want to remove all components of the server or select the components to remove?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_UNINSTALL_WHAT_TO_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_UNINSTALL_WHAT_TO_DELETE", -1);

    /**
     * View Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLI_VIEW_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLI_VIEW_DETAILS", -1);

    /**
     * Close Uninstall Window
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CLOSE_BUTTON_UNINSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CLOSE_BUTTON_UNINSTALL_TOOLTIP", -1);

    /**
     * Email addresses to send the completion notification to [continue]:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_COMPLETION_NOTIFICATION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_COMPLETION_NOTIFICATION_PROMPT", -1);

    /**
     * The Uninstall has not yet completed.%nAre you sure you want to close the Uninstall Window?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CLOSE_UNINSTALL_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_CLOSE_UNINSTALL_MSG", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_CLOSE_UNINSTALL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_CLOSE_UNINSTALL_TITLE", -1);

    /**
     * The Uninstall tool will remove all parts of the server you have selected below from your system. If all are selected, the server will be removed entirely.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_PANEL_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_PANEL_INSTRUCTIONS", -1);

    /**
     * Uninstall Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_PANEL_TITLE", -1);

    /**
     * This server is configured to do replication.%nIf the server is actually replicating contents with other servers it must be started and then you must provide administrator authentication to remove references to this server in the replicating servers.%n%nClick on 'Yes' to start the server and then provide authentication to remove the remote references.%nClick on 'No' to continue the uninstall without updating remote references.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_NOT_RUNNING_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_NOT_RUNNING_MSG", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_NOT_RUNNING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_NOT_RUNNING_TITLE", -1);

    /**
     * This server is configured to do replication.%nIf the server is actually replicating contents with other servers you must provide administrator authentication to remove references to this server in the replicating servers.%n%nClick on 'Yes' to provide authentication to remove the remote references.%nClick on 'No' to continue the uninstall without updating remote references.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_RUNNING_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_RUNNING_MSG", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_RUNNING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_REPLICATION_SERVER_RUNNING_TITLE", -1);

    /**
     * Confirm Uninstall%nAll selected files will be permanently deleted, are you sure you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_SERVER_NOT_RUNNING_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_SERVER_NOT_RUNNING_MSG", -1);

    /**
     * Confirm Uninstall
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_SERVER_NOT_RUNNING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_SERVER_NOT_RUNNING_TITLE", -1);

    /**
     * Server is Running%nThe server is currently running and must be stopped before uninstallation can continue. Do you want the uninstaller to stop the server for you and continue with the uninstall? If you click No, you will need to stop the server manually to continue.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_SERVER_RUNNING_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_SERVER_RUNNING_MSG", -1);

    /**
     * Server is Running
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONFIRM_UNINSTALL_SERVER_RUNNING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONFIRM_UNINSTALL_SERVER_RUNNING_TITLE", -1);

    /**
     * Open Connections:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONNECTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONNECTIONS_LABEL", -1);

    /**
     * This utility can be used to display the Control Panel window which displays basic server information and allows to do some basic administration tasks on the server.%n%nIf no host name or port is provided, the tool will try to connect to the local server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CONTROL_PANEL_LAUNCHER_USAGE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CONTROL_PANEL_LAUNCHER_USAGE_DESCRIPTION", -1);

    /**
     * %s Control Panel
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CONTROL_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CONTROL_PANEL_TITLE", -1);

    /**
     * Auxiliary objectclasses: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_AUXILIARY_OBJECTCLASS_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_AUXILIARY_OBJECTCLASS_DESCRIPTOR", -1);

    /**
     * Number of Entries: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_BROWSER_NUMBER_OF_ENTRIES =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_BROWSER_NUMBER_OF_ENTRIES", -1);

    /**
     * New Domain
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_NEW_DOMAIN_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_NEW_DOMAIN_PANEL_TITLE", -1);

    /**
     * New Organization
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_NEW_ORGANIZATION_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_NEW_ORGANIZATION_PANEL_TITLE", -1);

    /**
     * Objectclass: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_OBJECTCLASS_DESCRIPTOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_OBJECTCLASS_DESCRIPTOR", -1);

    /**
     * Backup...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_BACKUP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_BACKUP", -1);

    /**
     * Export LDIF...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_EXPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_EXPORT_LDIF", -1);

    /**
     * Import LDIF...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_IMPORT_LDIF =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_IMPORT_LDIF", -1);

    /**
     * Java Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_JAVA_SETTINGS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_JAVA_SETTINGS", -1);

    /**
     * Action:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_LABEL", -1);

    /**
     * Manage Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_MANAGE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_MANAGE_ENTRIES", -1);

    /**
     * Manage Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_MANAGE_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_MANAGE_INDEXES", -1);

    /**
     * Manage Schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_MANAGE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_MANAGE_SCHEMA", -1);

    /**
     * New Base DN...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_NEW_BASEDN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_NEW_BASEDN", -1);

    /**
     * Rebuild Indexes...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_REBUILD_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_REBUILD_INDEXES", -1);

    /**
     * Restore...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_RESTORE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_RESTORE", -1);

    /**
     * Verify Indexes...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_VERIFY_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_VERIFY_INDEXES", -1);

    /**
     * Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ACTION_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ACTION_WINDOWS_SERVICE", -1);

    /**
     * Updating group '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_ADDING_TO_GROUP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDING_TO_GROUP", -1);

    /**
     * The entries were successfully added.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDING_TO_GROUP_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDING_TO_GROUP_SUCCESSFUL_DETAILS", -1);

    /**
     * Entries added to groups
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDING_TO_GROUP_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDING_TO_GROUP_SUCCESSFUL_SUMMARY", -1);

    /**
     * Adding to Group...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDING_TO_GROUP_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDING_TO_GROUP_SUMMARY", -1);

    /**
     * Add All >
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_ADD_ALL_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_ADD_ALL_BUTTON", -1);

    /**
     * Add >
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_ADD_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_ADD_BUTTON", -1);

    /**
     * Available Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_AVAILABLE_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_AVAILABLE_ATTRIBUTES", -1);

    /**
     * Available Object Classes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_AVAILABLE_OBJECTCLASSES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_AVAILABLE_OBJECTCLASSES", -1);

    /**
     * Optional Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_OPTIONAL_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_OPTIONAL_ATTRIBUTES", -1);

    /**
     * < Remove All
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_REMOVE_ALL_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_REMOVE_ALL_BUTTON", -1);

    /**
     * < Remove
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_REMOVE_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_REMOVE_BUTTON", -1);

    /**
     * Required Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_REQUIRED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_REQUIRED_ATTRIBUTES", -1);

    /**
     * Selected Object Classes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADDREMOVE_SELECTED_OBJECTCLASSES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADDREMOVE_SELECTED_OBJECTCLASSES", -1);

    /**
     * Add Groups...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_GROUPS_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_GROUPS_BUTTON_LABEL", -1);

    /**
     * Add Members...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_MEMBERS_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_MEMBERS_BUTTON", -1);

    /**
     * Add Members
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_MEMBERS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_MEMBERS_LABEL", -1);

    /**
     * Add Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_REQUESTS_LABEL", -1);

    /**
     * Add Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_RESPONSES_LABEL", -1);

    /**
     * Entries to be added:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_TO_GROUP_ENTRIES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_TO_GROUP_ENTRIES_LABEL", -1);

    /**
     * Groups:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_TO_GROUP_GROUPS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_TO_GROUP_GROUPS_LABEL", -1);

    /**
     * Add to Group...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_TO_GROUP_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_TO_GROUP_MENU", -1);

    /**
     * Add entries to groups.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_TO_GROUP_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_TO_GROUP_TASK_DESCRIPTION", -1);

    /**
     * Add to Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADD_TO_GROUP_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADD_TO_GROUP_TITLE", -1);

    /**
     * %d - Administration Connector
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_ADMINISTRATION_CONNECTOR_NAME =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMINISTRATION_CONNECTOR_NAME", -1);

    /**
     * Administration Guide
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADMINISTRATION_GUIDE_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMINISTRATION_GUIDE_MENU", -1);

    /**
     * Administration Port:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADMINISTRATION_PORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMINISTRATION_PORT", -1);

    /**
     * Administrative Users:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADMINISTRATIVE_USERS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMINISTRATIVE_USERS_LABEL", -1);

    /**
     * Port %d (LDAPS)
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_ADMIN_CONNECTOR_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMIN_CONNECTOR_DESCRIPTION", -1);

    /**
     * Administration Connector:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ADMIN_CONNECTOR_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ADMIN_CONNECTOR_LABEL", -1);

    /**
     * Allowed By:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ALLOWED_BY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ALLOWED_BY_LABEL", -1);

    /**
     * All Base DNs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ALL_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ALL_BASE_DNS", -1);

    /**
     * All
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ALL_CONNECTION_HANDLERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ALL_CONNECTION_HANDLERS", -1);

    /**
     * Apply
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_APPLY_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_APPLY_BUTTON_LABEL", -1);

    /**
     * Approximate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_APPROXIMATE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_APPROXIMATE_LABEL", -1);

    /**
     * April
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_APRIL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_APRIL", -1);

    /**
     * Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTES_CATEGORY_NODE", -1);

    /**
     * Attributes to Exclude:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTES_TO_EXCLUDE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTES_TO_EXCLUDE", -1);

    /**
     * Attributes to Include:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTES_TO_INCLUDE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTES_TO_INCLUDE", -1);

    /**
     * Aliases:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_ALIASES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_ALIASES_LABEL", -1);

    /**
     * Approximate Matching Rule:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_APPROXIMATE_MATCHING_RULE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_APPROXIMATE_MATCHING_RULE_LABEL", -1);

    /**
     * Collective
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_COLLECTIVE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_COLLECTIVE_LABEL", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_DESCRIPTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_DESCRIPTION_LABEL", -1);

    /**
     * Attribute Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_DETAILS", -1);

    /**
     * Equality Matching Rule:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_EQUALITY_MATCHING_RULE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_EQUALITY_MATCHING_RULE_LABEL", -1);

    /**
     * File:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_FILE_LABEL", -1);

    /**
     * Attribute Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_INDEXES", -1);

    /**
     * Attribute:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_LABEL", -1);

    /**
     * Multivalued
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_MULTI_VALUED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_MULTI_VALUED_LABEL", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_NAME_LABEL", -1);

    /**
     * Non Modifiable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_NON_MODIFIABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_NON_MODIFIABLE_LABEL", -1);

    /**
     * Obsolete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_OBSOLETE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_OBSOLETE_LABEL", -1);

    /**
     * OID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_OID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_OID_LABEL", -1);

    /**
     * Operational
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_OPERATIONAL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_OPERATIONAL_LABEL", -1);

    /**
     * Ordering Matching Rule:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_ORDERING_MATCHING_RULE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_ORDERING_MATCHING_RULE_LABEL", -1);

    /**
     * Origin:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_ORIGIN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_ORIGIN_LABEL", -1);

    /**
     * Superior:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_PARENT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_PARENT_LABEL", -1);

    /**
     * Single Valued
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SINGLE_VALUED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SINGLE_VALUED_LABEL", -1);

    /**
     * Substring Matching Rule:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SUBSTRING_MATCHING_RULE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SUBSTRING_MATCHING_RULE_LABEL", -1);

    /**
     * Attribute Syntaxes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAXES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAXES_CATEGORY_NODE", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_DESCRIPTION", -1);

    /**
     * Attribute Syntax Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_DETAILS", -1);

    /**
     * Syntax:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_LABEL", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_NAME", -1);

    /**
     * OID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_OID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_OID", -1);

    /**
     * Attribute Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_SYNTAX_TITLE", -1);

    /**
     * Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_TYPE_LABEL", -1);

    /**
     * Attribute Type Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_TYPE_OPTIONS_EXPANDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_TYPE_OPTIONS_EXPANDER", -1);

    /**
     * Usage:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_USAGE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_USAGE_LABEL", -1);

    /**
     * %s (operational)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_ATTRIBUTE_USAGE_OPERATIONAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_USAGE_OPERATIONAL", -1);

    /**
     * Attribute View
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_VIEW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_VIEW_MENU", -1);

    /**
     * Attribute View Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ATTRIBUTE_VIEW_OPTIONS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ATTRIBUTE_VIEW_OPTIONS_TITLE", -1);

    /**
     * August
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUGUST =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUGUST", -1);

    /**
     * Authenticated as '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_AUTHENTICATED_AS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATED_AS", -1);

    /**
     * The server is running.  You must provide authentication to delete the attribute.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_ATTRIBUTE_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_ATTRIBUTE_DELETE", -1);

    /**
     * The server is running.  You must provide authentication to delete a backend.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BACKEND_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BACKEND_DELETE", -1);

    /**
     * The server is running.  You must provide authentication to perform the backup.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BACKUP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BACKUP", -1);

    /**
     * The server is running.  You must provide authentication to delete a base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BASE_DN_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_BASE_DN_DELETE", -1);

    /**
     * The server is running.  You must provide authentication to create a new base DN.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_CREATE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_CREATE_BASE_DN", -1);

    /**
     * The server is running.  You must provide authentication to disable the backend before rebuilding the indexes.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_DISABLE_BACKEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_DISABLE_BACKEND", -1);

    /**
     * The server is running.  You must provide authentication to perform the export.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_EXPORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_EXPORT", -1);

    /**
     * The server is running.  You must provide authentication to perform the import.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_IMPORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_IMPORT", -1);

    /**
     * The server is running.  You must provide authentication to edit the index.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_INDEX_EDITING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_INDEX_EDITING", -1);

    /**
     * The server is running.  You must provide authentication to create an index.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_NEW_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_NEW_INDEX", -1);

    /**
     * The server is running.  You must provide authentication to create a VLV index.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_NEW_VLV =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_NEW_VLV", -1);

    /**
     * The server is running.  You must provide authentication to edit the object class.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_OBJECTCLASS_EDIT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_OBJECTCLASS_EDIT", -1);

    /**
     * The server is running.  You must provide authentication to restore from backup.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_RESTORE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_RESTORE", -1);

    /**
     * The server is running.  You must provide authentication to edit the VLV index.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_VLV_INDEX_EDITING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_FOR_VLV_INDEX_EDITING", -1);

    /**
     * Authentication Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_SUMMARY", -1);

    /**
     * The server is running.  You must provide authentication to browse data.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_BROWSE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_BROWSE_SUMMARY", -1);

    /**
     * The server is running.  You must provide authentication to create an attribute in the schema.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_CREATE_ATTRIBUTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_CREATE_ATTRIBUTE_SUMMARY", -1);

    /**
     * The server is running.  You must provide authentication to create an attribute in the schema.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_CREATE_OBJECTCLASS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_REQUIRED_TO_CREATE_OBJECTCLASS_SUMMARY", -1);

    /**
     * To browse data the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHENTICATION_SERVER_MUST_RUN_TO_BROWSE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHENTICATION_SERVER_MUST_RUN_TO_BROWSE_SUMMARY", -1);

    /**
     * Auth Password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTHPASSWORD_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTHPASSWORD_FRIENDLY_NAME", -1);

    /**
     * The server is running.  You must provide authentication to see the monitoring data.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTH_REQUIRED_TO_BROWSE_MONITORING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTH_REQUIRED_TO_BROWSE_MONITORING_SUMMARY", -1);

    /**
     * The server is running.  You must provide authentication to see the monitoring data.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUTH_REQUIRED_TO_SEE_TRAFFIC_MONITORING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUTH_REQUIRED_TO_SEE_TRAFFIC_MONITORING_SUMMARY", -1);

    /**
     * Auxiliary Object Classes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AUXILIARY_OBJECTCLASS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AUXILIARY_OBJECTCLASS_LABEL", -1);

    /**
     * Available Backups:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVAILABLE_BACKUPS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVAILABLE_BACKUPS_LABEL", -1);

    /**
     * Available CPUs
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVAILABLE_CPUS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVAILABLE_CPUS", -1);

    /**
     * Available Indexes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVAILABLE_INDEXES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVAILABLE_INDEXES_LABEL", -1);

    /**
     * Available:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVAILABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVAILABLE_LABEL", -1);

    /**
     * Available Parent Backups:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVAILABLE_PARENT_BACKUPS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVAILABLE_PARENT_BACKUPS_LABEL", -1);

    /**
     * %s Avg per second
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_AVERAGE_HEADER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVERAGE_HEADER", -1);

    /**
     * Average Request Backlog
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_AVERAGE_REQUEST_BACKLOG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_AVERAGE_REQUEST_BACKLOG", -1);

    /**
     * Backend Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKEND_INDEXES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKEND_INDEXES_TITLE", -1);

    /**
     * Backend:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKEND_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKEND_LABEL", -1);

    /**
     * Backend VLV Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKEND_VLV_INDEXES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKEND_VLV_INDEXES_TITLE", -1);

    /**
     * All Backends
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_ALL_BACKENDS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_ALL_BACKENDS_LABEL", -1);

    /**
     * Backup ID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_ID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_ID_LABEL", -1);

    /**
     * Backup Options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_OPTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_OPTIONS_LABEL", -1);

    /**
     * Backup Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_PATH_LABEL", -1);

    /**
     * Backup contents of  '%s' to directory '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_BACKUP_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_TASK_DESCRIPTION", -1);

    /**
     * Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_TASK_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_TASK_NAME", -1);

    /**
     * Run Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_TITLE", -1);

    /**
     * Backup Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BACKUP_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BACKUP_TYPE_LABEL", -1);

    /**
     * For example: dc=example,dc=com
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BASE_DN_EXAMPLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BASE_DN_EXAMPLE", -1);

    /**
     * Base DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BASE_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BASE_DN_LABEL", -1);

    /**
     * Backend Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BASE_DN_NEW_BACKEND_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BASE_DN_NEW_BACKEND_TYPE_LABEL", -1);

    /**
     * - Binary Value -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BINARY_VALUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BINARY_VALUE", -1);

    /**
     * Bind DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BIND_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BIND_DN_LABEL", -1);

    /**
     * Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BIND_PASSWORD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BIND_PASSWORD_LABEL", -1);

    /**
     * Bind Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BIND_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BIND_REQUESTS_LABEL", -1);

    /**
     * Bind Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BIND_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BIND_RESPONSES_LABEL", -1);

    /**
     * Browse...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BROWSE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BROWSE_BUTTON_LABEL", -1);

    /**
     * General Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_BROWSE_GENERAL_MONITORING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_BROWSE_GENERAL_MONITORING", -1);

    /**
     * The tasks were successfully canceled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCELING_TASK_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCELING_TASK_COMPLETE", -1);

    /**
     * The tasks were successfully canceled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCELING_TASK_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCELING_TASK_SUCCESSFUL", -1);

    /**
     * Canceling Tasks...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCELING_TASK_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCELING_TASK_SUMMARY", -1);

    /**
     * Cancel
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCEL_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCEL_BUTTON_LABEL", -1);

    /**
     * Cancel Task
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCEL_TASK_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCEL_TASK_BUTTON_LABEL", -1);

    /**
     * Cancel Selected Tasks.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCEL_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCEL_TASK_DESCRIPTION", -1);

    /**
     * Are you sure you want to cancel the selected tasks?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCEL_TASK_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCEL_TASK_MSG", -1);

    /**
     * Cancel Tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANCEL_TASK_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANCEL_TASK_TITLE", -1);

    /**
     * The remote server '%s' might be down or the provided authentication is no longer valid.  To be able to manage a server remotely it must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CANNOT_CONNECT_TO_REMOTE_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANNOT_CONNECT_TO_REMOTE_DETAILS", -1);

    /**
     * Could not connect to remote server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CANNOT_CONNECT_TO_REMOTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CANNOT_CONNECT_TO_REMOTE_SUMMARY", -1);

    /**
     * Directory Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_DIRECTORY_DATA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_DIRECTORY_DATA", -1);

    /**
     * Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_INDEXES", -1);

    /**
     * Category Item Selected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_ITEM_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_ITEM_SELECTED", -1);

    /**
     * Monitoring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_MONITORING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_MONITORING", -1);

    /**
     * Runtime Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_RUNTIME_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_RUNTIME_OPTIONS", -1);

    /**
     * Schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CATEGORY_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CATEGORY_SCHEMA", -1);

    /**
     * Change...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHANGE_SCHEDULE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHANGE_SCHEDULE", -1);

    /**
     * Checking provided Java options...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHECKING_JAVA_OPTIONS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHECKING_JAVA_OPTIONS_SUMMARY", -1);

    /**
     * Checking...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHECKING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHECKING_SUMMARY", -1);

    /**
     * Check Syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHECK_SYNTAX_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHECK_SYNTAX_BUTTON", -1);

    /**
     * Child Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHILD_CLASS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHILD_CLASS", -1);

    /**
     * Choose Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHOOSE_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHOOSE_ENTRIES", -1);

    /**
     * Choose Groups
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHOOSE_GROUP_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHOOSE_GROUP_TITLE", -1);

    /**
     * Choose Parent DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHOOSE_PARENT_ENTRY_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHOOSE_PARENT_ENTRY_DN", -1);

    /**
     * Choose Reference Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CHOOSE_REFERENCE_GROUP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CHOOSE_REFERENCE_GROUP", -1);

    /**
     * Class Path
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CLASS_PATH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CLASS_PATH", -1);

    /**
     * Deselect All
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CLEAR_SELECTION_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CLEAR_SELECTION_BUTTON", -1);

    /**
     * Close
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CLOSE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CLOSE_BUTTON_LABEL", -1);

    /**
     * Close
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CLOSE_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CLOSE_MENU", -1);

    /**
     * Close window when operation completes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CLOSE_WINDOW_WHEN_OPERATION_COMPLETES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CLOSE_WINDOW_WHEN_OPERATION_COMPLETES_LABEL", -1);

    /**
     * Common Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CN_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CN_FRIENDLY_NAME", -1);

    /**
     * Command-Line Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_COMMAND_LINE_NAME_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_COMMAND_LINE_NAME_COLUMN", -1);

    /**
     * Compare Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_COMPARE_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_COMPARE_REQUESTS_LABEL", -1);

    /**
     * Compare Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_COMPARE_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_COMPARE_RESPONSES_LABEL", -1);

    /**
     * Compress Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_COMPRESS_DATA_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_COMPRESS_DATA_LABEL", -1);

    /**
     * Server Configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIGURATION_ATTRIBUTES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIGURATION_ATTRIBUTES_CATEGORY_NODE", -1);

    /**
     * Configuration Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIGURATION_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIGURATION_ATTRIBUTE_TITLE", -1);

    /**
     * Server Configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIGURATION_OBJECTCLASSES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIGURATION_OBJECTCLASSES_CATEGORY_NODE", -1);

    /**
     * Configuration Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIGURATION_OBJECTCLASS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIGURATION_OBJECTCLASS_TITLE", -1);

    /**
     * Are you sure you want to delete the attribute '%s' defined in the schema?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRMATION_DELETE_ATTRIBUTE_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_ATTRIBUTE_DETAILS", -1);

    /**
     * The following backends will be deleted.  All the entries defined on all the base DNs of the backend and all the index configuration will be deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRMATION_DELETE_BACKENDS_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_BACKENDS_DETAILS", -1);

    /**
     * The following base DNs will be deleted.  All the entries defined on the base DNs will be deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRMATION_DELETE_BASE_DNS_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_BASE_DNS_DETAILS", -1);

    /**
     * The following backends will be deleted and all the configuration lost:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRMATION_DELETE_BASE_DNS_INDIRECT_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_BASE_DNS_INDIRECT_DETAILS", -1);

    /**
     * Are you sure you want to delete the object class '%s' defined in the schema?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRMATION_DELETE_OBJECTCLASS_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_OBJECTCLASS_DETAILS", -1);

    /**
     * Are you sure you want to delete the elements '%s' defined in the schema?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRMATION_DELETE_SCHEMA_ELEMENTS_MSG =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_DELETE_SCHEMA_ELEMENTS_MSG", -1);

    /**
     * File '%s' exists and its contents will be overwritten.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRMATION_EXPORT_LDIF_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_EXPORT_LDIF_DETAILS", -1);

    /**
     * Are you sure you want to delete the indexes '%s' defined in backend '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CONFIRMATION_INDEXES_DELETE_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_INDEXES_DELETE_DETAILS", -1);

    /**
     * Are you sure you want to delete the index '%s' defined in backend '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CONFIRMATION_INDEX_DELETE_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_INDEX_DELETE_DETAILS", -1);

    /**
     * The following base DNs are replicated:<br>%s<br><br>In order for replication to work, these base DNs must be initialized once the import of the LDIF is finished.<br><br>Do you want to initialize the contents of the replicated base DNs automatically in the remote servers once the import LDIF has finished?  Note that if you click 'Yes' all the data in the remote server base DNs will be overwritten.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRMATION_INITIALIZE_ALL_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_INITIALIZE_ALL_DETAILS", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRMATION_REQUIRED_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_REQUIRED_SUMMARY", -1);

    /**
     * Are you sure you want to delete the VLV index '%s' defined in backend '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CONFIRMATION_VLV_INDEX_DELETE_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRMATION_VLV_INDEX_DELETE_DETAILS", -1);

    /**
     * Confirmation Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRM_INITIALIZE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_INITIALIZE_TITLE", -1);

    /**
     * The following Java arguments could not be used with binary '%s':<br>%s<br><br>The command-lines associated with those Java arguments may not work.<br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CONFIRM_NOT_WORKING_ARGUMENTS_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_NOT_WORKING_ARGUMENTS_DETAILS", -1);

    /**
     * The following Java arguments could not be used with binary '%s':<br>%s<br><br>These arguments will be used as fall back when OPENDJ_JAVA_ARGS is not defined.  If you do not want to specify a fall back, leave those arguments empty.<br><br>The command-lines associated with those Java arguments may not work.<br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CONFIRM_NOT_WORKING_FALLBACK_ARGUMENTS_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_NOT_WORKING_FALLBACK_ARGUMENTS_DETAILS", -1);

    /**
     * During the rebuilding of the indexes the backend '%s' will be disabled and none of its suffixes will be accessible.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONFIRM_REBUILD_INDEX_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_REBUILD_INDEX_DETAILS", -1);

    /**
     * During the restart process all the open connections to the server will be closed and the server will be not available.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRM_RESTART_SERVER_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_RESTART_SERVER_DETAILS", -1);

    /**
     * If you continue with the restore the contents on the server will be overwritten.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRM_RESTORE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_RESTORE_DETAILS", -1);

    /**
     * If the server is stopped all the open connections to the server will be closed and the server will be not available.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONFIRM_STOP_SERVER_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONFIRM_STOP_SERVER_DETAILS", -1);

    /**
     * Connection Handlers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLERS", -1);

    /**
     * Connection Handlers:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLERS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLERS_LABEL", -1);

    /**
     * Connection Handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLER_HEADER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLER_HEADER", -1);

    /**
     * Connection Handler
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLER_MONITORING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLER_MONITORING", -1);

    /**
     * Connection Handler Monitoring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLER_MONITORING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLER_MONITORING_TITLE", -1);

    /**
     * View
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLER_VIEW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLER_VIEW_MENU", -1);

    /**
     * View options for the Connection Handler Monitoring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECTION_HANDLER_VIEW_MENU_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECTION_HANDLER_VIEW_MENU_DESCRIPTION", -1);

    /**
     * Server to Administer...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONNECT_TO_SERVER_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONNECT_TO_SERVER_MENU", -1);

    /**
     * Administration Connector
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_ADMINISTRATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_ADMINISTRATION", -1);

    /**
     * HTTP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_HTTP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_HTTP", -1);

    /**
     * HTTPS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_HTTPS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_HTTPS", -1);

    /**
     * JMX
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_JMX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_JMX", -1);

    /**
     * JMX (secure)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_JMXS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_JMXS", -1);

    /**
     * LDAP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_LDAP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_LDAP", -1);

    /**
     * LDAPS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_LDAPS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_LDAPS", -1);

    /**
     * LDAP (allows StartTLS)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_LDAP_STARTTLS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_LDAP_STARTTLS", -1);

    /**
     * LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_LDIF =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_LDIF", -1);

    /**
     * Other
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_OTHER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_OTHER", -1);

    /**
     * Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_REPLICATION", -1);

    /**
     * Replication (secure)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_REPLICATION_SECURE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_REPLICATION_SECURE", -1);

    /**
     * SNMP
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CONN_HANDLER_SNMP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONN_HANDLER_SNMP", -1);

    /**
     * - Contents of file '%s' -
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CONTENTS_OF_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CONTENTS_OF_FILE", -1);

    /**
     * Copy DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_COPY_DN_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_COPY_DN_MENU", -1);

    /**
     * Creating default indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_ADDITIONAL_INDEXES_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ADDITIONAL_INDEXES_PROGRESS", -1);

    /**
     * Attribute created in schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_ATTRIBUTE_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ATTRIBUTE_COMPLETE", -1);

    /**
     * Creating attribute '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_ATTRIBUTE_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ATTRIBUTE_PROGRESS", -1);

    /**
     * The attribute '%s' was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_ATTRIBUTE_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ATTRIBUTE_SUCCESSFUL", -1);

    /**
     * Creating attribute '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_ATTRIBUTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ATTRIBUTE_SUMMARY", -1);

    /**
     * Creating backend '%s' containing base DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CREATING_BACKEND_PROGRESS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_BACKEND_PROGRESS", -1);

    /**
     * Base DN Created
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_BASE_DN_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_BASE_DN_COMPLETE", -1);

    /**
     * Creating base DN '%s' in backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_CREATING_BASE_DN_PROGRESS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_BASE_DN_PROGRESS", -1);

    /**
     * The base DN '%s' was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_BASE_DN_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_BASE_DN_SUCCESSFUL", -1);

    /**
     * Creating base DN  '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_BASE_DN_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_BASE_DN_SUMMARY", -1);

    /**
     * Creating entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_ENTRY", -1);

    /**
     * The entry was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUCCESSFUL_DETAILS", -1);

    /**
     * Entry created
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUCCESSFUL_SUMMARY", -1);

    /**
     * Creating new entry...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_ENTRY_SUMMARY", -1);

    /**
     * Creating index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_INDEX_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_INDEX_PROGRESS", -1);

    /**
     * The new index '%s' was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUCCESSFUL_DETAILS", -1);

    /**
     * Index created
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUCCESSFUL_SUMMARY", -1);

    /**
     * Creating new index '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_INDEX_SUMMARY", -1);

    /**
     * Creating VLV index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_PROGRESS", -1);

    /**
     * The new VLV index '%s' was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUCCESSFUL_DETAILS", -1);

    /**
     * VLV Index created
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUCCESSFUL_SUMMARY", -1);

    /**
     * Creating new VLV index '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_NEW_VLV_INDEX_SUMMARY", -1);

    /**
     * Object class created in schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CREATING_OBJECTCLASS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_OBJECTCLASS_COMPLETE", -1);

    /**
     * Creating object class '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_OBJECTCLASS_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_OBJECTCLASS_PROGRESS", -1);

    /**
     * The object class '%s' was successfully created.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_OBJECTCLASS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_OBJECTCLASS_SUCCESSFUL", -1);

    /**
     * Creating object class '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_CREATING_OBJECTCLASS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CREATING_OBJECTCLASS_SUMMARY", -1);

    /**
     * Use ',' to separate values and intervals. For example: '1-3,5'.<br>Use '-' to indicate intervals. Append '/' and a number to skip through the interval. For example '1-5/2'.<br>Use '*' to indicate any value. Append '/' and a number to skip through the values. For example '*&#x2f;2'.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_HELP", -1);

    /**
     * Valid values from 0 to 23
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_HOUR_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_HOUR_HELP", -1);

    /**
     * Valid values from 0 to 59
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_MINUTE_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_MINUTE_HELP", -1);

    /**
     * From 1 to 31
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_MONTH_DAY_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_MONTH_DAY_HELP", -1);

    /**
     * Valid values from 1 to 12 (1 is January, 2 is February...)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_MONTH_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_MONTH_HELP", -1);

    /**
     * Valid values from 0 to 6 (0 is Sunday, 1 is Monday...)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CRON_WEEK_DAY_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CRON_WEEK_DAY_HELP", -1);

    /**
     * Entry Cache Count
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CURRENT_ENTRY_CACHE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CURRENT_ENTRY_CACHE_COUNT", -1);

    /**
     * Entry Cache Size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CURRENT_ENTRY_CACHE_SIZE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CURRENT_ENTRY_CACHE_SIZE", -1);

    /**
     * Current Request Backlog
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CURRENT_REQUEST_BACKLOG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CURRENT_REQUEST_BACKLOG", -1);

    /**
     * Custom
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CUSTOM_ATTRIBUTES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CUSTOM_ATTRIBUTES_CATEGORY_NODE", -1);

    /**
     * Custom Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CUSTOM_ATTRIBUTES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CUSTOM_ATTRIBUTES_LABEL", -1);

    /**
     * Custom Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CUSTOM_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CUSTOM_ATTRIBUTE_TITLE", -1);

    /**
     * Custom
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CUSTOM_OBJECTCLASSES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CUSTOM_OBJECTCLASSES_CATEGORY_NODE", -1);

    /**
     * Custom Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_CUSTOM_OBJECTCLASS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_CUSTOM_OBJECTCLASS_TITLE", -1);

    /**
     * Country
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_C_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_C_FRIENDLY_NAME", -1);

    /**
     * Database Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DATABASE_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DATABASE_INDEXES", -1);

    /**
     * Data Exclusion Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DATA_EXCLUSION_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DATA_EXCLUSION_OPTIONS", -1);

    /**
     * Data Inclusion Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DATA_INCLUSION_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DATA_INCLUSION_OPTIONS", -1);

    /**
     * Data in File is Compressed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DATA_IN_FILE_COMPRESSED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DATA_IN_FILE_COMPRESSED", -1);

    /**
     * Data Sources
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DATA_SOURCES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DATA_SOURCES", -1);

    /**
     * Days:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DAYS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DAYS", -1);

    /**
     * ds-suffix.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DB_ENVIRONMENT_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DB_ENVIRONMENT_TREE_NODE", -1);

    /**
     * Backend ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DB_HEADER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DB_HEADER", -1);

    /**
     * December
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DECEMBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DECEMBER", -1);

    /**
     * - Default defined in syntax (%s) -
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DEFAULT_DEFINED_IN_SYNTAX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DEFAULT_DEFINED_IN_SYNTAX", -1);

    /**
     * Defined in file: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DEFINED_IN_SCHEMA_FILE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DEFINED_IN_SCHEMA_FILE", -1);

    /**
     * Delete Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ATTRIBUTES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ATTRIBUTES_TITLE", -1);

    /**
     * Delete Attribute...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ATTRIBUTE_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ATTRIBUTE_BUTTON", -1);

    /**
     * Delete Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ATTRIBUTE_TITLE", -1);

    /**
     * Delete backends '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_BACKENDS_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BACKENDS_DESCRIPTION", -1);

    /**
     * Delete backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_BACKEND_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BACKEND_DESCRIPTION", -1);

    /**
     * Delete Backend...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_BACKEND_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BACKEND_MENU", -1);

    /**
     * Delete Backend
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_BACKEND_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BACKEND_TITLE", -1);

    /**
     * Delete base DNs %s.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_BASE_DNS_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BASE_DNS_DESCRIPTION", -1);

    /**
     * Delete base DN '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_BASE_DN_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BASE_DN_DESCRIPTION", -1);

    /**
     * Delete Base DN...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_BASE_DN_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BASE_DN_MENU", -1);

    /**
     * Delete base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_BASE_DN_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BASE_DN_TITLE", -1);

    /**
     * Delete...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_BUTTON_LABEL", -1);

    /**
     * Do you want to delete the selected entries (including all the entries below them on the tree)?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ENTRIES_CONFIRMATION_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ENTRIES_CONFIRMATION_DETAILS", -1);

    /**
     * Delete Entry...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ENTRY_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ENTRY_BUTTON", -1);

    /**
     * Do you want to delete entry '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_ENTRY_CONFIRMATION_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ENTRY_CONFIRMATION_DETAILS", -1);

    /**
     * Delete Entry...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ENTRY_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ENTRY_MENU", -1);

    /**
     * Delete entries.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_ENTRY_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_ENTRY_TASK_DESCRIPTION", -1);

    /**
     * Delete Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_INDEXES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEXES_TITLE", -1);

    /**
     * Delete indexes in backends '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_INDEX_IN_BACKENDS_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEX_IN_BACKENDS_TASK_DESCRIPTION", -1);

    /**
     * Delete Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_INDEX_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEX_LABEL", -1);

    /**
     * Delete Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_INDEX_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEX_MENU", -1);

    /**
     * Delete indexes in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEX_TASK_DESCRIPTION", -1);

    /**
     * Delete Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_INDEX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_INDEX_TITLE", -1);

    /**
     * Delete Objectclasses and Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_OBJECTCLASSES_AND_ATTRIBUTES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_OBJECTCLASSES_AND_ATTRIBUTES_TITLE", -1);

    /**
     * Delete Objectclasses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_OBJECTCLASSES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_OBJECTCLASSES_TITLE", -1);

    /**
     * Delete Object Class...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_OBJECTCLASS_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_OBJECTCLASS_BUTTON", -1);

    /**
     * Delete Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_OBJECTCLASS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_OBJECTCLASS_TITLE", -1);

    /**
     * Delete Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_REQUESTS_LABEL", -1);

    /**
     * Delete Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_RESPONSES_LABEL", -1);

    /**
     * Delete...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_SCHEMA_ELEMENT_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_SCHEMA_ELEMENT_MENU", -1);

    /**
     * Delete schema elements.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_SCHEMA_ELEMENT_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_SCHEMA_ELEMENT_TASK_DESCRIPTION", -1);

    /**
     * Delete Selected Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_SELECTED_ENTRIES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_SELECTED_ENTRIES_TITLE", -1);

    /**
     * Do you want to delete subtree '%s' (including all the entries below it on the tree)?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETE_SUBTREE_CONFIRMATION_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_SUBTREE_CONFIRMATION_DETAILS", -1);

    /**
     * Delete VLV Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETE_VLV_INDEX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETE_VLV_INDEX_TITLE", -1);

    /**
     * Deleting attribute '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ATTRIBUTE", -1);

    /**
     * Attribute Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ATTRIBUTE_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ATTRIBUTE_COMPLETE", -1);

    /**
     * The attribute '%s' was successfully deleted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_ATTRIBUTE_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ATTRIBUTE_SUCCESSFUL", -1);

    /**
     * Deleting attribute '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_ATTRIBUTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ATTRIBUTE_SUMMARY", -1);

    /**
     * Deleting backend '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_BACKEND =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BACKEND", -1);

    /**
     * Backends Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BACKENDS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BACKENDS_COMPLETE", -1);

    /**
     * The backends were successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BACKENDS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BACKENDS_SUCCESSFUL", -1);

    /**
     * Deleting backends...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BACKENDS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BACKENDS_SUMMARY", -1);

    /**
     * Deleting base DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_BASE_DN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BASE_DN", -1);

    /**
     * Deleting base DNs %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_BASE_DNS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BASE_DNS", -1);

    /**
     * Base DNs Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BASE_DNS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BASE_DNS_COMPLETE", -1);

    /**
     * The base DNs were successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BASE_DNS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BASE_DNS_SUCCESSFUL", -1);

    /**
     * Deleting base DNs...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_BASE_DNS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_BASE_DNS_SUMMARY", -1);

    /**
     * Disabling replication of base DN '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_DOMAIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_DOMAIN", -1);

    /**
     * Entries Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ENTRIES_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRIES_COMPLETE", -1);

    /**
     * The entries were successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ENTRIES_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRIES_SUCCESSFUL", -1);

    /**
     * Deleting entries...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ENTRIES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRIES_SUMMARY", -1);

    /**
     * Entry Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ENTRY_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRY_COMPLETE", -1);

    /**
     * The entry '%s' was successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_ENTRY_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRY_SUCCESSFUL", -1);

    /**
     * Deleting '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_ENTRY_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRY_SUMMARY", -1);

    /**
     * Delete Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_ENTRY_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_ENTRY_TITLE", -1);

    /**
     * Deleting index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEX", -1);

    /**
     * Indexes Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_INDEXES_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEXES_COMPLETE", -1);

    /**
     * The indexes '%s' in backend '%s' were successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_DELETING_INDEXES_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEXES_SUCCESSFUL", -1);

    /**
     * Deleting indexes...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_INDEXES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEXES_SUMMARY", -1);

    /**
     * Index Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_INDEX_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEX_COMPLETE", -1);

    /**
     * The index '%s' in backend '%s' was successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_DELETING_INDEX_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEX_SUCCESSFUL", -1);

    /**
     * Deleting index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_INDEX_SUMMARY", -1);

    /**
     * Deleting objectclass '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_OBJECTCLASS", -1);

    /**
     * Object class Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_OBJECTCLASS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_OBJECTCLASS_COMPLETE", -1);

    /**
     * The object class '%s' was successfully deleted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_OBJECTCLASS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_OBJECTCLASS_SUCCESSFUL", -1);

    /**
     * Deleting object class '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_OBJECTCLASS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_OBJECTCLASS_SUMMARY", -1);

    /**
     * Schema Definitions Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_COMPLETE", -1);

    /**
     * The schema elements '%s' were successfully deleted
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_SUCCESSFUL", -1);

    /**
     * Deleting...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SCHEMA_ELEMENTS_SUMMARY", -1);

    /**
     * Subtree Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_SUBTREE_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SUBTREE_COMPLETE", -1);

    /**
     * The subtree '%s' was successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_SUBTREE_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SUBTREE_SUCCESSFUL", -1);

    /**
     * Deleting subtree '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_SUBTREE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SUBTREE_SUMMARY", -1);

    /**
     * Delete Subtree
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_SUBTREE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_SUBTREE_TITLE", -1);

    /**
     * Deleting VLV index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DELETING_VLV_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_VLV_INDEX", -1);

    /**
     * VLV Index Deleted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_VLV_INDEX_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_VLV_INDEX_COMPLETE", -1);

    /**
     * The VLV index '%s' in backend '%s' was successfully deleted.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_DELETING_VLV_INDEX_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_VLV_INDEX_SUCCESSFUL", -1);

    /**
     * Deleting VLV index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DELETING_VLV_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DELETING_VLV_INDEX_SUMMARY", -1);

    /**
     * Description
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DESCRIPTION_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DESCRIPTION_FRIENDLY_NAME", -1);

    /**
     * Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_DETAILS_THROWABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DETAILS_THROWABLE", -1);

    /**
     * Directory Data:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DIRECTORY_DATA_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DIRECTORY_DATA_LABEL", -1);

    /**
     * Disable...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISABLE_WINDOWS_SERVICE_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISABLE_WINDOWS_SERVICE_BUTTON", -1);

    /**
     * Disable Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISABLE_WINDOWS_SERVICE_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISABLE_WINDOWS_SERVICE_TASK_DESCRIPTION", -1);

    /**
     * The Windows service was successfully disabled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUCCESSFUL_DETAILS", -1);

    /**
     * Windows Service Disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUCCESSFUL_SUMMARY", -1);

    /**
     * Disabling Windows Service...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISABLING_WINDOWS_SERVICE_SUMMARY", -1);

    /**
     * Display All Command-lines
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DISPLAY_ALL_COMMAND_LINES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DISPLAY_ALL_COMMAND_LINES", -1);

    /**
     * DNs to Exclude:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DNS_TO_EXCLUDE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DNS_TO_EXCLUDE", -1);

    /**
     * DNs to Include:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DNS_TO_INCLUDE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DNS_TO_INCLUDE", -1);

    /**
     * Documentation Wiki
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DOCUMENTATION_WIKI_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DOCUMENTATION_WIKI_MENU", -1);

    /**
     * Do Not Save
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DO_NOT_SAVE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DO_NOT_SAVE_BUTTON_LABEL", -1);

    /**
     * Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DO_YOU_WANT_TO_CONTINUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DO_YOU_WANT_TO_CONTINUE", -1);

    /**
     * Dynamic Group Reference DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DS_TARGET_GROUP_DN_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DS_TARGET_GROUP_DN_FRIENDLY_NAME", -1);

    /**
     * Password (confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_CONFIRMNEWPASSWORD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_CONFIRMNEWPASSWORD_LABEL", -1);

    /**
     * Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_DN", -1);

    /**
     * Duplicate Entry...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_MENU", -1);

    /**
     * New Entry Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_NAME_LABEL", -1);

    /**
     * New Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_NEWPASSWORD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_NEWPASSWORD_LABEL", -1);

    /**
     * Parent Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_PARENT_DN_LABEL", -1);

    /**
     * Leave empty for no password.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_PASSWORD_INFO =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_PASSWORD_INFO", -1);

    /**
     * Duplicate Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DUPLICATE_ENTRY_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DUPLICATE_ENTRY_TITLE", -1);

    /**
     * Dynamic Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DYNAMIC_GROUP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DYNAMIC_GROUP_LABEL", -1);

    /**
     * Dynamic Group Reference DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_DYNAMIC_GROUP_REFERENCE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_DYNAMIC_GROUP_REFERENCE_LABEL", -1);

    /**
     * Edit binary attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EDIT_BINARY_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EDIT_BINARY_ATTRIBUTE_TITLE", -1);

    /**
     * Edit...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EDIT_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EDIT_BUTTON_LABEL", -1);

    /**
     * To edit default java home and JVM runtime arguments please edit content of the [INSTANCE_ROOT]/config/java.properties file
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EDIT_JAVA_PROPERTIES_FILE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EDIT_JAVA_PROPERTIES_FILE", -1);

    /**
     * Edit LDAP Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EDIT_LDAP_ENTRY_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EDIT_LDAP_ENTRY_TITLE", -1);

    /**
     * Edit Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EDIT_OBJECTCLASS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EDIT_OBJECTCLASS_TITLE", -1);

    /**
     * Employee Number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EMPLOYEENUMBER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EMPLOYEENUMBER_FRIENDLY_NAME", -1);

    /**
     * Enable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENABLE_WINDOWS_SERVICE_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENABLE_WINDOWS_SERVICE_BUTTON", -1);

    /**
     * Enable Windows Service
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENABLE_WINDOWS_SERVICE_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENABLE_WINDOWS_SERVICE_TASK_DESCRIPTION", -1);

    /**
     * The Windows service was successfully enabled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUCCESSFUL_DETAILS", -1);

    /**
     * Windows Service Enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUCCESSFUL_SUMMARY", -1);

    /**
     * Enabling Windows Service...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENABLING_WINDOWS_SERVICE_SUMMARY", -1);

    /**
     * Encrypt Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENCRYPT_DATA_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENCRYPT_DATA_LABEL", -1);

    /**
     * %d entries deleted.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_ENTRIES_DELETED =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRIES_DELETED", -1);

    /**
     * Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRIES_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRIES_MENU", -1);

    /**
     * The entries edition menu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRIES_MENU_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRIES_MENU_DESCRIPTION", -1);

    /**
     * Entry Cache
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_CACHES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_CACHES", -1);

    /**
     * ds-generic.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_CACHES_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_CACHES_TREE_NODE", -1);

    /**
     * Entry Cache Hits
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_CACHE_HITS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_CACHE_HITS", -1);

    /**
     * Entry Cache Hit Ratio
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_CACHE_HIT_RATIO =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_CACHE_HIT_RATIO", -1);

    /**
     * Entry Cache Tries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_CACHE_TRIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_CACHE_TRIES", -1);

    /**
     * Entry Limit:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ENTRY_LIMIT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ENTRY_LIMIT_LABEL", -1);

    /**
     * Equality
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUALITY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUALITY_LABEL", -1);

    /**
     * The equivalent procedure to update the Java settings from the command line is: <br> Edit the properties in file:<br><b>%s</b><br>Then run the following command-line:<br><b>%s</b><br><br>
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EQUIVALENT_ACTION_TO_UPDATE_JAVA_PROPERTIES =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_ACTION_TO_UPDATE_JAVA_PROPERTIES", -1);

    /**
     * Equivalent command line to add attribute '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_ATTRIBUTE_ONLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_ATTRIBUTE_ONLINE", -1);

    /**
     * Equivalent command line to add object class '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_OBJECTCLASS_ONLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_OBJECTCLASS_ONLINE", -1);

    /**
     * Adding the schema elements '%s' can also be done adding the following attributes to the schema definition entry (cn=schema) in file '%s':
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_SCHEMA_ELEMENT_OFFLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_SCHEMA_ELEMENT_OFFLINE", -1);

    /**
     * Adding the schema elements '%s' can also be done adding the following entry to the file '%s':
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_SCHEMA_ENTRY_OFFLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_ADD_SCHEMA_ENTRY_OFFLINE", -1);

    /**
     * Equivalent command-line to cancel task '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CANCEL_TASK =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CANCEL_TASK", -1);

    /**
     * Equivalent command lines to generate default indexes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_ADDITIONAL_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_ADDITIONAL_INDEXES", -1);

    /**
     * Equivalent command line to update the configuration:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_BASE_DN", -1);

    /**
     * Equivalent command line to create the entry:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_ENTRY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_ENTRY", -1);

    /**
     * Equivalent command line to create the index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_INDEX", -1);

    /**
     * Equivalent command line to create the VLV index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_VLV_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_CREATE_VLV_INDEX", -1);

    /**
     * Deleting attribute '%s' can also be done removing the following attribute from the schema definition entry (cn=schema) in file '%s':
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ATTRIBUTE_OFFLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ATTRIBUTE_OFFLINE", -1);

    /**
     * Equivalent command line to delete attribute '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ATTRIBUTE_ONLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ATTRIBUTE_ONLINE", -1);

    /**
     * Equivalent command line to delete the backend:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_BACKEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_BACKEND", -1);

    /**
     * Equivalent command line to delete the base DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_BASE_DN", -1);

    /**
     * Equivalent command line to disable replication on base DN '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_DOMAIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_DOMAIN", -1);

    /**
     * Equivalent command line to delete entry '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_ENTRY", -1);

    /**
     * Equivalent command line to delete the index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_INDEX", -1);

    /**
     * Deleting object class '%s' can also be done removing the following attribute from the schema definition entry (cn=schema) in file '%s':
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_OBJECTCLASS_OFFLINE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_OBJECTCLASS_OFFLINE", -1);

    /**
     * Equivalent command line to delete object class '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_OBJECTCLASS_ONLINE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_DELETE_OBJECTCLASS_ONLINE", -1);

    /**
     * Equivalent command to initialize remote servers:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_INITIALIZE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_INITIALIZE_ALL", -1);

    /**
     * Equivalent command line to modify the entry:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY", -1);

    /**
     * Equivalent command line to modify the index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY_INDEX", -1);

    /**
     * Equivalent command line to modify the VLV index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY_VLV_INDEX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_MODIFY_VLV_INDEX", -1);

    /**
     * Equivalent command line to rebuild indexes in '%s':
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_REBUILD_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_REBUILD_INDEX", -1);

    /**
     * Equivalent command line to rename the entry:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_RENAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_RENAME", -1);

    /**
     * Equivalent command line to start the server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_START_SERVER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_START_SERVER", -1);

    /**
     * Equivalent command line to stop the server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_STOP_SERVER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_CMD_TO_STOP_SERVER", -1);

    /**
     * Equivalent command line:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EQUIVALENT_COMMAND_LINE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EQUIVALENT_COMMAND_LINE", -1);

    /**
     * The following errors occurred connecting to the local server:<br>%s<br>If you continue without providing authentication no monitoring information will be displayed.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_ERROR_CONNECTING_TO_LOCAL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_CONNECTING_TO_LOCAL", -1);

    /**
     * Connection Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ERROR_CONNECT_BROWSE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_CONNECT_BROWSE_DETAILS", -1);

    /**
     * An error occurred trying to connect to the server to read data.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_ERROR_CONNECT_BROWSE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_CONNECT_BROWSE_SUMMARY", -1);

    /**
     * Error
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ERROR_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_DIALOG_TITLE", -1);

    /**
     * You must select at least one superior object class.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ERROR_NO_SUPERIOR_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_NO_SUPERIOR_SELECTED", -1);

    /**
     * Could not resolve the referrals defined in entry '%s'.<br><br>The referrals of the entry are:<br>%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_ERROR_RESOLVING_REFERRAL_MSG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_RESOLVING_REFERRAL_MSG", -1);

    /**
     * Error resolving referral
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ERROR_RESOLVING_REFERRAL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_RESOLVING_REFERRAL_TITLE", -1);

    /**
     * Error searching entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ERROR_SEARCHING_ENTRY_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ERROR_SEARCHING_ENTRY_TITLE", -1);

    /**
     * Exclude Operational Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXCLUDE_OPERATIONAL_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXCLUDE_OPERATIONAL_ATTRIBUTES", -1);

    /**
     * Exclusion Filter:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXCLUSION_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXCLUSION_FILTER", -1);

    /**
     * Exit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXIT_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXIT_MENU", -1);

    /**
     * To modify references to the deleted attributes and object classes the schema elements that refer to them must be deleted and then added again.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPLANATION_TO_DELETE_REFERENCED_ELEMENTS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPLANATION_TO_DELETE_REFERENCED_ELEMENTS", -1);

    /**
     * To modify attribute '%s' it will be deleted and then recreated.  The same applies to all the schema elements that have references to it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EXPLANATION_TO_MODIFY_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPLANATION_TO_MODIFY_ATTRIBUTE", -1);

    /**
     * To modify object class '%s' it will be deleted and then recreated.  The same applies to all the schema elements that have references to it.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EXPLANATION_TO_MODIFY_OBJECTCLASS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPLANATION_TO_MODIFY_OBJECTCLASS", -1);

    /**
     * The export finished successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORTING_LDIF_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORTING_LDIF_SUCCESSFUL_DETAILS", -1);

    /**
     * Export Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORTING_LDIF_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORTING_LDIF_SUCCESSFUL_SUMMARY", -1);

    /**
     * Exporting from backend '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_EXPORTING_LDIF_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORTING_LDIF_SUMMARY", -1);

    /**
     * Generate a Signed Hash
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_GENERATE_SIGNED_HASH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_GENERATE_SIGNED_HASH", -1);

    /**
     * Export LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_LDIF_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_LDIF_TITLE", -1);

    /**
     * Export Options:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_OPTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_OPTIONS", -1);

    /**
     * If file exists, overwrite contents of file instead of appending.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_OVERWRITE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_OVERWRITE_LABEL", -1);

    /**
     * Export of backend '%s' to file '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_EXPORT_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_TASK_DESCRIPTION", -1);

    /**
     * Export to File:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_TO_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_TO_FILE_LABEL", -1);

    /**
     * Wrap Text at Column
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXPORT_WRAP_TEXT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXPORT_WRAP_TEXT", -1);

    /**
     * Extended Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXTENDED_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXTENDED_REQUESTS_LABEL", -1);

    /**
     * Extended Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXTENDED_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXTENDED_RESPONSES_LABEL", -1);

    /**
     * Other Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXTRA_JAVA_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXTRA_JAVA_ATTRIBUTES", -1);

    /**
     * Extra Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_EXTRA_OPTIONS_EXPANDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_EXTRA_OPTIONS_EXPANDER", -1);

    /**
     * Fax Number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FACSIMILETELEPHONENUMBER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FACSIMILETELEPHONENUMBER_FRIENDLY_NAME", -1);

    /**
     * February
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FEBRUARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FEBRUARY", -1);

    /**
     * File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FILE_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FILE_MENU", -1);

    /**
     * The file menu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FILE_MENU_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FILE_MENU_DESCRIPTION", -1);

    /**
     * File to Import:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FILE_TO_IMPORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FILE_TO_IMPORT_LABEL", -1);

    /**
     * For example: (|(cn=*)(sn=*))
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FILTER_INLINE_HELP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FILTER_INLINE_HELP_LABEL", -1);

    /**
     * Filter:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FILTER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FILTER_LABEL", -1);

    /**
     * Follow Referrals
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FOLLOW_REFERRALS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FOLLOW_REFERRALS", -1);

    /**
     * Free Memory in JVM
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FREE_USED_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FREE_USED_MEMORY", -1);

    /**
     * Full Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_FULL_BACKUP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_FULL_BACKUP_LABEL", -1);

    /**
     * - No Item Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GENERAL_MONITORING_NO_ITEM_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERAL_MONITORING_NO_ITEM_SELECTED", -1);

    /**
     * Monitoring Root
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GENERAL_MONITORING_ROOT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERAL_MONITORING_ROOT", -1);

    /**
     * ds-directory.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GENERAL_MONITORING_ROOT_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERAL_MONITORING_ROOT_TREE_NODE", -1);

    /**
     * General Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GENERAL_MONITORING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERAL_MONITORING_TITLE", -1);

    /**
     * Generate Message Digest of Backup Contents to Use as Checksum
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GENERATE_MESSAGE_DIGEST_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERATE_MESSAGE_DIGEST_LABEL", -1);

    /**
     * %s Control Panel - %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_GENERIC_TITLE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GENERIC_TITLE", -1);

    /**
     * First Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GIVENNAME_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GIVENNAME_FRIENDLY_NAME", -1);

    /**
     * Groups
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GROUPS_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GROUPS_FILTER", -1);

    /**
     * LDAP URL:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GROUP_FILTER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GROUP_FILTER_LABEL", -1);

    /**
     * Member DNs:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_GROUP_MEMBER_DNS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_GROUP_MEMBER_DNS_LABEL", -1);

    /**
     * Help
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HELP_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HELP_MENU", -1);

    /**
     * The help menu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HELP_MENU_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HELP_MENU_DESCRIPTION", -1);

    /**
     * Global view options.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HELP_VIEW_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HELP_VIEW_DESCRIPTION", -1);

    /**
     * Home Telephone Number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HOMEPHONE_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HOMEPHONE_FRIENDLY_NAME", -1);

    /**
     * Host Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HOST_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HOST_NAME_LABEL", -1);

    /**
     * To edit the referral in the entry, deselect the 'Follow Referrals' option in the 'View' menu.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_HOW_TO_EDIT_REFERRALS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_HOW_TO_EDIT_REFERRALS", -1);

    /**
     * Image of Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMAGE_OF_ATTRIBUTE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMAGE_OF_ATTRIBUTE_LABEL", -1);

    /**
     * Image Preview:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMAGE_PREVIEW_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMAGE_PREVIEW_LABEL", -1);

    /**
     * The import finished successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_DETAILS", -1);

    /**
     * Import Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORTING_LDIF_SUCCESSFUL_SUMMARY", -1);

    /**
     * Importing to backend '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_IMPORTING_LDIF_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORTING_LDIF_SUMMARY", -1);

    /**
     * Import Automatically Generated Example Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_AUTOMATICALLY_GENERATED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_AUTOMATICALLY_GENERATED_LABEL", -1);

    /**
     * Import Data From LDIF File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_FROM_LDIF_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_FROM_LDIF_LABEL", -1);

    /**
     * Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_LDIF_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_LDIF_PATH_LABEL", -1);

    /**
     * Import LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_LDIF_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_LDIF_TITLE", -1);

    /**
     * Import Only
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_ONLY_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_ONLY_BUTTON_LABEL", -1);

    /**
     * Import the contents of file '%s' to backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_IMPORT_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_TASK_DESCRIPTION", -1);

    /**
     * If left empty the number of threads will be equal to 2 x Number of CPUs on server machine.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_THREADS_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_THREADS_HELP", -1);

    /**
     * Thread Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_THREADS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_THREADS_LABEL", -1);

    /**
     * Number of threads used to read LDIF file during import.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_IMPORT_THREADS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_IMPORT_THREADS_TOOLTIP", -1);

    /**
     * Inclusion Filter:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INCLUSION_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INCLUSION_FILTER", -1);

    /**
     * The following task is running: %s<br>It cannot run simultaneously with task %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_INCOMPATIBLE_TASKS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INCOMPATIBLE_TASKS", -1);

    /**
     * Incremental Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INCREMENTAL_BACKUP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INCREMENTAL_BACKUP_LABEL", -1);

    /**
     * Specify Parent Backup Below
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INCREMENTAL_PARENT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INCREMENTAL_PARENT_LABEL", -1);

    /**
     * Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_CATEGORY_NODE", -1);

    /**
     * Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_HEADER_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_HEADER_ATTRIBUTE", -1);

    /**
     * Entry Limit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_HEADER_ENTRY_LIMIT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_HEADER_ENTRY_LIMIT", -1);

    /**
     * Index Types
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_HEADER_INDEX_TYPES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_HEADER_INDEX_TYPES", -1);

    /**
     * Requires Rebuild
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_HEADER_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_HEADER_REQUIRES_REBUILD", -1);

    /**
     * Indexes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEXES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEXES_LABEL", -1);

    /**
     * Approximate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_APPROXIMATE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_APPROXIMATE", -1);

    /**
     * View Index Properties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_BROWSER_RIGHT_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_BROWSER_RIGHT_PANEL_TITLE", -1);

    /**
     * Index Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_DETAILS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_DETAILS_LABEL", -1);

    /**
     * Equality
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_EQUALITY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_EQUALITY", -1);

    /**
     * Index:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_LABEL", -1);

    /**
     * <html>The index has been modified.<br>Rebuild of the indexes required (using 'Rebuild Index' or 'Import').
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_MODIFIED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_MODIFIED_LABEL", -1);

    /**
     * <html>The index has been modified.<br>Rebuild of the indexes required (using 'Rebuild Index' or 'Import').
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_MODIFIED_MESSAGE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_MODIFIED_MESSAGE", -1);

    /**
     * Ordering
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_ORDERING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_ORDERING", -1);

    /**
     * Index Properties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_PANEL_TITLE", -1);

    /**
     * Presence
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_PRESENCE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_PRESENCE", -1);

    /**
     * The index configuration for '%s' was successfully modified.  For the configuration to be taken into account the database index files must be regenerated.  This can be done by using the 'Rebuild Indexes' tool or re-importing the contents of the backend '%s'.<br><br> Do you want to rebuild the index now?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_OFFLINE_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_OFFLINE_DETAILS", -1);

    /**
     * The index configuration for '%s' was successfully modified.  For the configuration to be taken into account the database index files must be regenerated.  This can be done by using the 'Rebuild Indexes' tool or re-importing the contents of the backend '%s'.<br>During the rebuilding of the indexes the backend '%s' will be disabled and none of its suffixes will be accessible.<br><br>Do you want to rebuild the index now?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_ONLINE_DETAILS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_ONLINE_DETAILS", -1);

    /**
     * The index configuration for '%s' was successfully modified.  For the configuration to be taken into account the database index files must be regenerated.  This can be done by using the 'rebuild-index' command-line on the remote server or re-importing the contents of the backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_REMOTE_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_REMOTE_DETAILS", -1);

    /**
     * Index Rebuild Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_REBUILD_REQUIRED_SUMMARY", -1);

    /**
     * Substring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_SUBSTRING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_SUBSTRING", -1);

    /**
     * Index Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDEX_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDEX_TYPE_LABEL", -1);

    /**
     * Indicates Required Field
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INDICATES_REQUIRED_FIELD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INDICATES_REQUIRED_FIELD_LABEL", -1);

    /**
     * (*) Inherited Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INHERITED_ATTRIBUTES_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INHERITED_ATTRIBUTES_HELP", -1);

    /**
     * Import and Initialize
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INITIALIZE_ALL_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INITIALIZE_ALL_BUTTON_LABEL", -1);

    /**
     * Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INSTALLATION_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INSTALLATION_PATH_LABEL", -1);

    /**
     * Instance Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_INSTANCE_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INSTANCE_PATH_LABEL", -1);

    /**
     * The value %s is not a valid DN.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_INVALID_DN_DETAILS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INVALID_DN_DETAILS", -1);

    /**
     * The provided filter is not valid.  Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_INVALID_FILTER_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INVALID_FILTER_DETAILS", -1);

    /**
     * The period time must be an integer positive value smaller than %d seconds.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_INVALID_PERIOD_VALUE =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_INVALID_PERIOD_VALUE", -1);

    /**
     * January
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JANUARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JANUARY", -1);

    /**
     * Java Arguments
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_ARGUMENTS_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_ARGUMENTS_COLUMN", -1);

    /**
     * Java Arguments:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_ARGUMENTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_ARGUMENTS_LABEL", -1);

    /**
     * Java Home:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_HOME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_HOME_LABEL", -1);

    /**
     * Java Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_INFORMATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_INFORMATION", -1);

    /**
     * Memory Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_MEMORY_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_MEMORY_ATTRIBUTES", -1);

    /**
     * Java Settings
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_PROPERTIES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_PROPERTIES_TITLE", -1);

    /**
     * Java Vendor
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_VENDOR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_VENDOR", -1);

    /**
     * Java Version
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_VERSION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_VERSION", -1);

    /**
     * Java Version:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JAVA_VERSION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JAVA_VERSION_LABEL", -1);

    /**
     * JE Databases Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JE_DB_INFO =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JE_DB_INFO", -1);

    /**
     * JPEG Photograph
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JPEGPHOTO_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JPEGPHOTO_FRIENDLY_NAME", -1);

    /**
     * July
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JULY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JULY", -1);

    /**
     * June
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JUNE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JUNE", -1);

    /**
     * JVM Architecture
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JVM_ARCHITECTURE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JVM_ARCHITECTURE", -1);

    /**
     * JVM Arguments
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JVM_ARGUMENTS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JVM_ARGUMENTS", -1);

    /**
     * ds-generic.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JVM_MEMORY_USAGE_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JVM_MEMORY_USAGE_TREE_NODE", -1);

    /**
     * JVM Vendor
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JVM_VENDOR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JVM_VENDOR", -1);

    /**
     * JVM Version
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_JVM_VERSION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_JVM_VERSION", -1);

    /**
     * Launch Later
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LAUNCH_LATER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LAUNCH_LATER", -1);

    /**
     * Launch on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_LAUNCH_LATER_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LAUNCH_LATER_SUMMARY", -1);

    /**
     * Launch Now
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LAUNCH_NOW =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LAUNCH_NOW", -1);

    /**
     * Launch now
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LAUNCH_NOW_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LAUNCH_NOW_SUMMARY", -1);

    /**
     * Launch periodically with CRON schedule '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_LAUNCH_PERIODICALLY_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LAUNCH_PERIODICALLY_SUMMARY", -1);

    /**
     * LDAP Filter:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LDAP_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LDAP_FILTER", -1);

    /**
     * Enter LDIF syntax for the new entry:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LDIF_SYNTAX_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LDIF_SYNTAX_LABEL", -1);

    /**
     * LDIF View
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LDIF_VIEW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LDIF_VIEW_MENU", -1);

    /**
     * Leave Database Empty
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LEAVE_DATABASE_EMPTY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LEAVE_DATABASE_EMPTY_LABEL", -1);

    /**
     * Loading panel...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOADING_PANEL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOADING_PANEL_SUMMARY", -1);

    /**
     * Select the server that you want to administer:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOCAL_OR_REMOTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOCAL_OR_REMOTE", -1);

    /**
     * Server to Administer
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOCAL_OR_REMOTE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOCAL_OR_REMOTE_PANEL_TITLE", -1);

    /**
     * Local Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOCAL_SERVER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOCAL_SERVER", -1);

    /**
     * Not Running
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOCAL_SERVER_NOT_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOCAL_SERVER_NOT_RUNNING", -1);

    /**
     * Authentication Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_LOGIN_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_LOGIN_PANEL_TITLE", -1);

    /**
     * City/Locality
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_L_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_L_FRIENDLY_NAME", -1);

    /**
     * E-Mail
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAIL_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAIL_FRIENDLY_NAME", -1);

    /**
     * Manage Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MANAGE_ENTRIES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MANAGE_ENTRIES_TITLE", -1);

    /**
     * Manage Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MANAGE_INDEXES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MANAGE_INDEXES_TITLE", -1);

    /**
     * Manage Schema
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MANAGE_SCHEMA_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MANAGE_SCHEMA_TITLE", -1);

    /**
     * Manage Tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MANAGE_TASKS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MANAGE_TASKS", -1);

    /**
     * March
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MARCH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MARCH", -1);

    /**
     * Matching Rules
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULES_CATEGORY_NODE", -1);

    /**
     * The matching rule to be used for approximate requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_APPROXIMATE_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_APPROXIMATE_HELP", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_DESCRIPTION", -1);

    /**
     * Matching Rule Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_DETAILS", -1);

    /**
     * The matching rule to be used for equality requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_EQUALITY_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_EQUALITY_HELP", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_NAME", -1);

    /**
     * OID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_OID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_OID", -1);

    /**
     * Matching Rule Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_OPTIONS_EXPANDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_OPTIONS_EXPANDER", -1);

    /**
     * The matching rule to be used for ordering requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_ORDERING_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_ORDERING_HELP", -1);

    /**
     * Matching Rule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_PANEL_TITLE", -1);

    /**
     * The matching rule to be used for substring requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_SUBSTRING_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_SUBSTRING_HELP", -1);

    /**
     * Syntax:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_SYNTAX", -1);

    /**
     * Used by Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MATCHING_RULE_USED_BY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MATCHING_RULE_USED_BY", -1);

    /**
     * Maximum %d Children Displayed.  Try Applying a Filter.
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_MAXIMUM_CHILDREN_DISPLAYED =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAXIMUM_CHILDREN_DISPLAYED", -1);

    /**
     * Max Connections:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAX_CONNECTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAX_CONNECTIONS_LABEL", -1);

    /**
     * Max Entry Cache Count
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAX_ENTRY_CACHE_COUNT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAX_ENTRY_CACHE_COUNT", -1);

    /**
     * Max Entry Cache Size
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAX_ENTRY_CACHE_SIZE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAX_ENTRY_CACHE_SIZE", -1);

    /**
     * Max Memory in JVM
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAX_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAX_MEMORY", -1);

    /**
     * Maximum Request Backlog
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAX_REQUEST_BACKLOG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAX_REQUEST_BACKLOG", -1);

    /**
     * May
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MAY", -1);

    /**
     * LDAP URL
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MEMBERURL_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MEMBERURL_FRIENDLY_NAME", -1);

    /**
     * Members of Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MEMBER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MEMBER_FRIENDLY_NAME", -1);

    /**
     * %d MB, %d KB
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_CTRL_PANEL_MEMORY_VALUE =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MEMORY_VALUE", -1);

    /**
     * Mobile Number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MOBILE_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MOBILE_FRIENDLY_NAME", -1);

    /**
     * Attribute Modified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_COMPLETE", -1);

    /**
     * The attribute '%s' was successfully modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_SUCCESSFUL", -1);

    /**
     * Modifying attribute '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ATTRIBUTE_SUMMARY", -1);

    /**
     * Modifying entry '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_ENTRY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ENTRY", -1);

    /**
     * Save Changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_ENTRY_CHANGES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ENTRY_CHANGES_TITLE", -1);

    /**
     * Entry Updated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_ENTRY_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ENTRY_COMPLETE", -1);

    /**
     * The entry '%s' was successfully updated.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_ENTRY_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ENTRY_SUCCESSFUL", -1);

    /**
     * Saving changes of entry '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_ENTRY_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_ENTRY_SUMMARY", -1);

    /**
     * Index Modified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_INDEX_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_INDEX_COMPLETE", -1);

    /**
     * Modifying index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_INDEX_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_INDEX_PROGRESS", -1);

    /**
     * The index '%s' in backend '%s' was successfully modified.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MODIFYING_INDEX_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_INDEX_SUCCESSFUL", -1);

    /**
     * Modifying index %s...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_INDEX_SUMMARY", -1);

    /**
     * Modifying Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_INDEX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_INDEX_TITLE", -1);

    /**
     * Object Class Modified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_COMPLETE", -1);

    /**
     * The object class '%s' was successfully modified
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_SUCCESSFUL", -1);

    /**
     * Modifying object class '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_OBJECTCLASS_SUMMARY", -1);

    /**
     * VLV Index Modified
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_COMPLETE", -1);

    /**
     * Modifying VLV index '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_PROGRESS", -1);

    /**
     * The VLV index '%s' in backend '%s' was successfully modified.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_SUCCESSFUL", -1);

    /**
     * Modifying VLV index %s...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFYING_VLV_INDEX_SUMMARY", -1);

    /**
     * Modify attribute '%s' in schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFY_ATTRIBUTE_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_ATTRIBUTE_TASK_DESCRIPTION", -1);

    /**
     * Modify Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MODIFY_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_ATTRIBUTE_TITLE", -1);

    /**
     * Modify entry '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFY_ENTRY_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_ENTRY_TASK_DESCRIPTION", -1);

    /**
     * Modify index '%s' in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MODIFY_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_INDEX_TASK_DESCRIPTION", -1);

    /**
     * Modify object class '%s' in schema
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MODIFY_OBJECTCLASS_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_OBJECTCLASS_TASK_DESCRIPTION", -1);

    /**
     * Modify VLV index '%s' in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MODIFY_VLV_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MODIFY_VLV_INDEX_TASK_DESCRIPTION", -1);

    /**
     * Mod DN Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MOD_DN_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MOD_DN_REQUESTS_LABEL", -1);

    /**
     * Mod DN Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MOD_DN_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MOD_DN_RESPONSES_LABEL", -1);

    /**
     * Modify Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MOD_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MOD_REQUESTS_LABEL", -1);

    /**
     * Modify Responses
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MOD_RESPONSES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MOD_RESPONSES_LABEL", -1);

    /**
     * - Multiple Entries Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MULTIPLE_ENTRIES_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MULTIPLE_ENTRIES_SELECTED_LABEL", -1);

    /**
     * - Multiple Items Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MULTIPLE_ITEMS_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MULTIPLE_ITEMS_SELECTED_LABEL", -1);

    /**
     * Multiple Schema Items Selected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MULTIPLE_SCHEMA_ITEMS_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MULTIPLE_SCHEMA_ITEMS_SELECTED", -1);

    /**
     * -Multiple Tasks Selected-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_MULTIPLE_TASKS_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MULTIPLE_TASKS_SELECTED", -1);

    /**
     * You must define the index '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_MUST_DEFINE_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MUST_DEFINE_INDEX", -1);

    /**
     * You must define the index '%s' to be of type %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MUST_DEFINE_INDEX_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MUST_DEFINE_INDEX_TYPE", -1);

    /**
     * You must update the definition of index '%s' to be of type %s.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_MUST_UPDATE_INDEX_DEFINITION_TYPE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_MUST_UPDATE_INDEX_DEFINITION_TYPE", -1);

    /**
     * Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NAME_LABEL", -1);

    /**
     * Naming Contexts
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NAMINGCONTEXTS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NAMINGCONTEXTS_FRIENDLY_NAME", -1);

    /**
     * Creating new attributes '%s' in schema.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NEW_ATTRIBUTES_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ATTRIBUTES_TASK_DESCRIPTION", -1);

    /**
     * New Attribute...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ATTRIBUTE_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ATTRIBUTE_BUTTON", -1);

    /**
     * New Attribute...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ATTRIBUTE_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ATTRIBUTE_MENU", -1);

    /**
     * New Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ATTRIBUTE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ATTRIBUTE_PANEL_TITLE", -1);

    /**
     * Create new attribute '%s' in schema.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NEW_ATTRIBUTE_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ATTRIBUTE_TASK_DESCRIPTION", -1);

    /**
     * New Backend:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_BACKEND_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_BACKEND_LABEL", -1);

    /**
     * Create new base DN '%s' in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_NEW_BASE_DN_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_BASE_DN_TASK_DESCRIPTION", -1);

    /**
     * New Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_BASE_DN_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_BASE_DN_TITLE", -1);

    /**
     * New Window
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_BROWSER_WINDOW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_BROWSER_WINDOW_MENU", -1);

    /**
     * New Domain...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_DOMAIN_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_DOMAIN_MENU", -1);

    /**
     * New Entry from LDIF
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ENTRY_FROM_LDIF_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ENTRY_FROM_LDIF_TITLE", -1);

    /**
     * To create an entry you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ENTRY_REQUIRES_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ENTRY_REQUIRES_AUTHENTICATION", -1);

    /**
     * To create an entry the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ENTRY_REQUIRES_SERVER_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ENTRY_REQUIRES_SERVER_RUNNING", -1);

    /**
     * New entry '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NEW_ENTRY_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ENTRY_TASK_DESCRIPTION", -1);

    /**
     * New from LDIF...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_FROM_LDIF_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_FROM_LDIF_MENU", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_DESCRIPTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_DESCRIPTION_LABEL", -1);

    /**
     * Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_ENTRY_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_ENTRY_DN_LABEL", -1);

    /**
     * Members:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_MEMBERS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_MEMBERS_LABEL", -1);

    /**
     * New Group...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_MENU", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_NAME_LABEL", -1);

    /**
     * New Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_GROUP_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_GROUP_PANEL_TITLE", -1);

    /**
     * New Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_INDEX_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_INDEX_BUTTON_LABEL", -1);

    /**
     * New Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_INDEX_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_INDEX_MENU", -1);

    /**
     * Create new index '%s' in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_NEW_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_INDEX_TASK_DESCRIPTION", -1);

    /**
     * New Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_INDEX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_INDEX_TITLE", -1);

    /**
     * Creating new object classes '%s' in schema.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NEW_OBJECTCLASSES_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OBJECTCLASSES_TASK_DESCRIPTION", -1);

    /**
     * New Object Class...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OBJECTCLASS_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OBJECTCLASS_BUTTON", -1);

    /**
     * New Object Class...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OBJECTCLASS_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OBJECTCLASS_MENU", -1);

    /**
     * New Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OBJECTCLASS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OBJECTCLASS_PANEL_TITLE", -1);

    /**
     * Create new object class '%s' in schema.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NEW_OBJECTCLASS_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OBJECTCLASS_TASK_DESCRIPTION", -1);

    /**
     * New Organizational Unit...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ORGANIZATIONAL_UNIT_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ORGANIZATIONAL_UNIT_MENU", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ORGANIZATION_DESCRIPTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ORGANIZATION_DESCRIPTION_LABEL", -1);

    /**
     * Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ORGANIZATION_ENTRY_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ORGANIZATION_ENTRY_DN_LABEL", -1);

    /**
     * New Organization...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ORGANIZATION_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ORGANIZATION_MENU", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_ORGANIZATION_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_ORGANIZATION_NAME_LABEL", -1);

    /**
     * Address:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_ADDRESS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_ADDRESS_LABEL", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_DESCRIPTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_DESCRIPTION_LABEL", -1);

    /**
     * Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_ENTRY_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_ENTRY_DN_LABEL", -1);

    /**
     * Fax Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_FAX_NUMBER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_FAX_NUMBER_LABEL", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_NAME_LABEL", -1);

    /**
     * New Organizational Unit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_PANEL_TITLE", -1);

    /**
     * Telephone Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_OU_TELEPHONE_NUMBER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_OU_TELEPHONE_NUMBER_LABEL", -1);

    /**
     * Creating attributes '%s' and object classes '%s' in schema.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_NEW_SCHEMA_ELEMENTS_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_SCHEMA_ELEMENTS_TASK_DESCRIPTION", -1);

    /**
     * Common Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_COMMON_NAMES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_COMMON_NAMES_LABEL", -1);

    /**
     * Password (Confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_CONFIRM_PASSWORD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_CONFIRM_PASSWORD_LABEL", -1);

    /**
     * E-mail:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_EMAIL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_EMAIL_LABEL", -1);

    /**
     * Entry DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_ENTRY_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_ENTRY_DN_LABEL", -1);

    /**
     * Fax Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_FAX_NUMBER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_FAX_NUMBER_LABEL", -1);

    /**
     * First Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_FIRST_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_FIRST_NAME_LABEL", -1);

    /**
     * Last Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_LAST_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_LAST_NAME_LABEL", -1);

    /**
     * New User...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_MENU", -1);

    /**
     * Naming Attribute:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_NAMING_ATTRIBUTE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_NAMING_ATTRIBUTE_LABEL", -1);

    /**
     * New User
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_PANEL_TITLE", -1);

    /**
     * Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_PASSWORD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_PASSWORD_LABEL", -1);

    /**
     * Telephone Number:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_TELEPHONE_NUMBER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_TELEPHONE_NUMBER_LABEL", -1);

    /**
     * User ID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_USER_UID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_USER_UID_LABEL", -1);

    /**
     * New VLV Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_VLV_INDEX_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_VLV_INDEX_BUTTON_LABEL", -1);

    /**
     * New VLV Index...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_VLV_INDEX_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_VLV_INDEX_MENU", -1);

    /**
     * Create new VLV index '%s' in backend '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_NEW_VLV_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_VLV_INDEX_TASK_DESCRIPTION", -1);

    /**
     * New VLV Index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NEW_VLV_INDEX_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NEW_VLV_INDEX_TITLE", -1);

    /**
     * This is a non-configurable internal index
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NON_CONFIGURABLE_INDEX_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NON_CONFIGURABLE_INDEX_LABEL", -1);

    /**
     * Non-editable Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NON_EDITABLE_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NON_EDITABLE_ATTRIBUTES", -1);

    /**
     * User Not Authenticated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NOT_AUTHENTICATED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOT_AUTHENTICATED", -1);

    /**
     * User not authenticated (server not running)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_NOT_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_NOT_RUNNING", -1);

    /**
     * User not authenticated (could not connect to server '%s')
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOT_AUTHENTICATED_SERVER_REMOTE", -1);

    /**
     * Not Available
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NOT_AVAILABLE_LONG_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOT_AVAILABLE_LONG_LABEL", -1);

    /**
     * Not Implemented
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NOT_IMPLEMENTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOT_IMPLEMENTED", -1);

    /**
     * November
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NOVEMBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NOVEMBER", -1);

    /**
     * - No Backends Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_BACKENDS_FOUND_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_BACKENDS_FOUND_LABEL", -1);

    /**
     * - No Backups Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_BACKUPS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_BACKUPS_FOUND", -1);

    /**
     * - No base DNs Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_BASE_DNS_FOUND_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_BASE_DNS_FOUND_LABEL", -1);

    /**
     * No base DN selected.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_BASE_DN_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_BASE_DN_SELECTED", -1);

    /**
     * - No Connection Handlers Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_CONNECTION_HANDLER_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_CONNECTION_HANDLER_FOUND", -1);

    /**
     * - No Data Sources Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_DATA_SOURCES_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_DATA_SOURCES_FOUND", -1);

    /**
     * -No Databases Found-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_DBS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_DBS_FOUND", -1);

    /**
     * -No Database Environment Data Found-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_DB_MONITORING_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_DB_MONITORING_FOUND", -1);

    /**
     * - No Entry Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_ENTRY_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_ENTRY_SELECTED_LABEL", -1);

    /**
     * - No Item Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_ITEM_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_ITEM_SELECTED_LABEL", -1);

    /**
     * No Matches Found
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_MATCHES_FOUND_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_MATCHES_FOUND_LABEL", -1);

    /**
     * - No matching rule -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_MATCHING_RULE_FOR_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_MATCHING_RULE_FOR_ATTRIBUTE", -1);

    /**
     * -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_MONITORING_VALUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_MONITORING_VALUE", -1);

    /**
     * You must select at least one operation.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_OPERATION_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_OPERATION_SELECTED", -1);

    /**
     * - No parent -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_PARENT_FOR_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_PARENT_FOR_ATTRIBUTE", -1);

    /**
     * No Schema Item Selected
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_SCHEMA_ITEM_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_SCHEMA_ITEM_SELECTED", -1);

    /**
     * - No Schema Item Selected -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_SCHEMA_ITEM_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_SCHEMA_ITEM_SELECTED_LABEL", -1);

    /**
     * - No Tasks Found -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_TASKS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_TASKS_FOUND", -1);

    /**
     * -No Task Selected-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_TASK_SELECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_TASK_SELECTED", -1);

    /**
     * -No Task Specific Details-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_TASK_SPECIFIC_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_TASK_SPECIFIC_DETAILS", -1);

    /**
     * - No Value Specified -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NO_VALUE_SPECIFIED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NO_VALUE_SPECIFIED", -1);

    /**
     * Number of User Entries:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_NUMBER_OF_USER_ENTRIES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_NUMBER_OF_USER_ENTRIES_LABEL", -1);

    /**
     * Object Classes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASSES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASSES_CATEGORY_NODE", -1);

    /**
     * Abstract
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_ABSTRACT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_ABSTRACT_LABEL", -1);

    /**
     * Aliases:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_ALIASES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_ALIASES_LABEL", -1);

    /**
     * Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_ATTRIBUTES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_ATTRIBUTES_LABEL", -1);

    /**
     * Auxiliary
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_AUXILIARY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_AUXILIARY_LABEL", -1);

    /**
     * Auxiliary: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_OBJECTCLASS_CELL_PANEL_AUXILIARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_CELL_PANEL_AUXILIARY", -1);

    /**
     * Description:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_DESCRIPTION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_DESCRIPTION_LABEL", -1);

    /**
     * Object Class Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_DETAILS", -1);

    /**
     * File:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_FILE_LABEL", -1);

    /**
     * Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_FRIENDLY_NAME", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_NAME_LABEL", -1);

    /**
     * Obsolete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_OBSOLETE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_OBSOLETE_LABEL", -1);

    /**
     * OID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_OID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_OID_LABEL", -1);

    /**
     * Origin:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_ORIGIN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_ORIGIN_LABEL", -1);

    /**
     * Superiors:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_PARENTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_PARENTS_LABEL", -1);

    /**
     * Superior:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_PARENT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_PARENT_LABEL", -1);

    /**
     * Structural
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_STRUCTURAL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_STRUCTURAL_LABEL", -1);

    /**
     * Type:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OBJECTCLASS_TYPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OBJECTCLASS_TYPE_LABEL", -1);

    /**
     * October
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OCTOBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OCTOBER", -1);

    /**
     * <html>(**)The operation is executed on its own process and could benefit from more memory allocation.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OFFLINE_COMMAND_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OFFLINE_COMMAND_HELP", -1);

    /**
     * %s (Offline) (**)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_OFFLINE_COMMAND_LINE_CELL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OFFLINE_COMMAND_LINE_CELL", -1);

    /**
     * OK
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OK_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OK_BUTTON_LABEL", -1);

    /**
     * <html>(*)The operation is executed on the server's process and the command-line does not require many resources.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ONLINE_COMMAND_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ONLINE_COMMAND_HELP", -1);

    /**
     * %s (Online) (*)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_ONLINE_COMMAND_LINE_CELL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ONLINE_COMMAND_LINE_CELL", -1);

    /**
     * Only Create Base Entry
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ONLY_CREATE_BASE_ENTRY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ONLY_CREATE_BASE_ENTRY_LABEL", -1);

    /**
     * Version:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPENDS_VERSION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPENDS_VERSION_LABEL", -1);

    /**
     * Open Connections:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPEN_CONNECTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPEN_CONNECTIONS_LABEL", -1);

    /**
     * Operating System
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPERATING_SYSTEM =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPERATING_SYSTEM", -1);

    /**
     * Show Operations...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPERATIONS_VIEW =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPERATIONS_VIEW", -1);

    /**
     * %s:
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_OPERATION_NAME_AS_LABEL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPERATION_NAME_AS_LABEL", -1);

    /**
     * Show Columns
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPERATION_VIEW_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPERATION_VIEW_LABEL", -1);

    /**
     * Optional Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPTIONAL_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPTIONAL_ATTRIBUTES", -1);

    /**
     * Optional Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OPTIONAL_ATTRIBUTES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OPTIONAL_ATTRIBUTES_LABEL", -1);

    /**
     * Ordering
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ORDERING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ORDERING_LABEL", -1);

    /**
     * Other...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OTHER_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OTHER_BASE_DN", -1);

    /**
     * Other base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OTHER_BASE_DN_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OTHER_BASE_DN_TITLE", -1);

    /**
     * If file exists, overwrite contents of file instead of appending
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OVERWRITE_REJECTS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OVERWRITE_REJECTS_FILE_LABEL", -1);

    /**
     * If file exists, overwrite contents of file instead of appending
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_OVERWRITE_SKIPS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_OVERWRITE_SKIPS_FILE_LABEL", -1);

    /**
     * Pager
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PAGER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PAGER_FRIENDLY_NAME", -1);

    /**
     * Parent Backup ID:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PARENT_BACKUP_ID_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PARENT_BACKUP_ID_LABEL", -1);

    /**
     * Parent Backup Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PARENT_BACKUP_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PARENT_BACKUP_PATH_LABEL", -1);

    /**
     * Superior Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PARENT_CLASS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PARENT_CLASS", -1);

    /**
     * Password (confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PASSWORD_CONFIRM_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PASSWORD_CONFIRM_LABEL", -1);

    /**
     * PDB Databases Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PDB_DB_INFO =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PDB_DB_INFO", -1);

    /**
     * Please wait...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PLEASE_WAIT_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PLEASE_WAIT_SUMMARY", -1);

    /**
     * Address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_POSTALADDRESS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_POSTALADDRESS_FRIENDLY_NAME", -1);

    /**
     * Postal Code
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_POSTALCODE_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_POSTALCODE_FRIENDLY_NAME", -1);

    /**
     * Presence
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PRESENCE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PRESENCE_LABEL", -1);

    /**
     * Preview not available.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PREVIEW_NOT_AVAILABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PREVIEW_NOT_AVAILABLE_LABEL", -1);

    /**
     * Private Naming Contexts
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PRIVATENAMINGCONTEXTS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PRIVATENAMINGCONTEXTS_FRIENDLY_NAME", -1);

    /**
     * Details:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PROGRESS_DIALOG_DETAILS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PROGRESS_DIALOG_DETAILS_LABEL", -1);

    /**
     * Done
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_PROGRESS_DONE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_PROGRESS_DONE", -1);

    /**
     * Reading Configuration...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_READING_CONFIGURATION_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_READING_CONFIGURATION_SUMMARY", -1);

    /**
     * Reading Java Settings...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_READING_JAVA_SETTINGS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_READING_JAVA_SETTINGS_SUMMARY", -1);

    /**
     * Reading...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_READING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_READING_SUMMARY", -1);

    /**
     * The indexes where successfully rebuilt.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REBUILDING_INDEXES_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REBUILDING_INDEXES_SUCCESSFUL_DETAILS", -1);

    /**
     * Index Rebuilding Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REBUILDING_INDEXES_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REBUILDING_INDEXES_SUCCESSFUL_SUMMARY", -1);

    /**
     * Rebuilding indexes in backend '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_REBUILDING_INDEXES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REBUILDING_INDEXES_SUMMARY", -1);

    /**
     * Rebuild Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REBUILD_INDEXES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REBUILD_INDEXES_TITLE", -1);

    /**
     * Rebuild indexes in '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_REBUILD_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REBUILD_INDEX_TASK_DESCRIPTION", -1);

    /**
     * Refreshing List...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESHING_LIST_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESHING_LIST_SUMMARY", -1);

    /**
     * Refresh
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_BUTTON_LABEL", -1);

    /**
     * Refresh Contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_DATA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_DATA", -1);

    /**
     * Refresh List
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_LIST_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_LIST_BUTTON_LABEL", -1);

    /**
     * Refresh options...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_MENU", -1);

    /**
     * Refresh Period (sec):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_OPTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_OPTIONS_LABEL", -1);

    /**
     * Select the period (in seconds) used to refresh the monitoring and configuration information displayed.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_OPTIONS_PANEL_TEXT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_OPTIONS_PANEL_TEXT", -1);

    /**
     * Refresh Options
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REFRESH_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REFRESH_PANEL_TITLE", -1);

    /**
     * Rejects File:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REJECTS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REJECTS_FILE_LABEL", -1);

    /**
     * Reject Entries That are Not Schema-Compliant
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REJECT_NOT_SCHEMA_COMPLIANT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REJECT_NOT_SCHEMA_COMPLIANT_LABEL", -1);

    /**
     * Remote Server:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REMOTE_SERVER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REMOTE_SERVER", -1);

    /**
     * The path must be accessible by the remote server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REMOTE_SERVER_PATH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REMOTE_SERVER_PATH", -1);

    /**
     * Fully qualified host name of the remote server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REMOTE_SERVER_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REMOTE_SERVER_TOOLTIP", -1);

    /**
     * Renaming entry '%s' to '%s'
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_RENAMING_ENTRY =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RENAMING_ENTRY", -1);

    /**
     * Requests Rejected Due To Full Queue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUESTS_REJECTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUESTS_REJECTED", -1);

    /**
     * Requests Submitted
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUESTS_SUBMITTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUESTS_SUBMITTED", -1);

    /**
     * Required Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUIRED_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUIRED_ATTRIBUTES", -1);

    /**
     * Required Attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUIRED_ATTRIBUTES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUIRED_ATTRIBUTES_LABEL", -1);

    /**
     * Required By:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUIRED_BY_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUIRED_BY_LABEL", -1);

    /**
     * (*) Requires Rebuild
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_REQUIRES_REBUILD_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_REQUIRES_REBUILD_LEGEND", -1);

    /**
     * The user password was successfully updated.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUCCESSFUL_DETAILS", -1);

    /**
     * User Password Updated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUCCESSFUL_SUMMARY", -1);

    /**
     * Resetting user password...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESETTING_USER_PASSWORD_SUMMARY", -1);

    /**
     * Password (confirm):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_CONFIRM_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_CONFIRM_LABEL", -1);

    /**
     * DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_DN_LABEL", -1);

    /**
     * Reset User Password...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_MENU", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_NAME_LABEL", -1);

    /**
     * New User Password:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_PWD_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_PWD_LABEL", -1);

    /**
     * Reset password for entry '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_RESET_USER_PASSWORD_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_TASK_DESCRIPTION", -1);

    /**
     * Reset User Password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESET_USER_PASSWORD_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESET_USER_PASSWORD_TITLE", -1);

    /**
     * The server restarted successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTARTING_SERVER_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTARTING_SERVER_SUCCESSFUL_DETAILS", -1);

    /**
     * Restart Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTARTING_SERVER_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTARTING_SERVER_SUCCESSFUL_SUMMARY", -1);

    /**
     * Restart Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTART_SERVER_PROGRESS_DLG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTART_SERVER_PROGRESS_DLG_TITLE", -1);

    /**
     * Restart Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTART_SERVER_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTART_SERVER_TASK_DESCRIPTION", -1);

    /**
     * Restore from Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTORE_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTORE_PANEL_TITLE", -1);

    /**
     * Restore the contents of backup '%s' located in directory '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_RESTORE_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTORE_TASK_DESCRIPTION", -1);

    /**
     * The restore finished successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTORING_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTORING_SUCCESSFUL_DETAILS", -1);

    /**
     * Restore Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RESTORING_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTORING_SUCCESSFUL_SUMMARY", -1);

    /**
     * Restoring contents of backup '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_RESTORING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RESTORING_SUMMARY", -1);

    /**
     * The following tasks are running:<br>%s<br><br>If you connect to another server the tasks will continue but you will have to check the log files to see if they complete successfully.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_RUNNING_TASKS_CHANGE_SERVER_CONFIRMATION_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUNNING_TASKS_CHANGE_SERVER_CONFIRMATION_DETAILS", -1);

    /**
     * The following tasks are running:<br>%s<br><br>If you exit the tasks will continue but you will have to check the log files to see if they complete successfully.<br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_RUNNING_TASKS_CONFIRMATION_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUNNING_TASKS_CONFIRMATION_DETAILS", -1);

    /**
     * Creating backup of all backends...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RUN_BACKUP_ALL_BACKENDS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUN_BACKUP_ALL_BACKENDS", -1);

    /**
     * The backup finished successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RUN_BACKUP_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUN_BACKUP_SUCCESSFUL_DETAILS", -1);

    /**
     * Backup Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_RUN_BACKUP_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUN_BACKUP_SUCCESSFUL_SUMMARY", -1);

    /**
     * Creating backup of backend '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_RUN_BACKUP_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_RUN_BACKUP_SUMMARY", -1);

    /**
     * Save
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SAVE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SAVE_BUTTON_LABEL", -1);

    /**
     * Save Changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SAVE_CHANGES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SAVE_CHANGES_LABEL", -1);

    /**
     * To see the list of scheduled tasks you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEDULED_TASK_LIST_AUTHENTICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEDULED_TASK_LIST_AUTHENTICATION", -1);

    /**
     * To see the list of scheduled tasks the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEDULED_TASK_LIST_REQUIRES_SERVER_RUNNING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEDULED_TASK_LIST_REQUIRES_SERVER_RUNNING", -1);

    /**
     * View Schema Element
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEMA_BROWSER_RIGHT_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_BROWSER_RIGHT_PANEL_TITLE", -1);

    /**
     * Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEMA_ELEMENT_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_ELEMENT_NAME", -1);

    /**
     * Number of Elements: %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_CTRL_PANEL_SCHEMA_ELEMENT_NUMBER =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_ELEMENT_NUMBER", -1);

    /**
     * Type
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEMA_ELEMENT_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_ELEMENT_TYPE", -1);

    /**
     * The file (under 'config%sschema') where the attribute definition will be stored.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_SCHEMA_FILE_ATTRIBUTE_HELP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_FILE_ATTRIBUTE_HELP", -1);

    /**
     * The file (under 'config%sschema') where the object class definition will be stored.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_SCHEMA_FILE_OBJECTCLASS_HELP =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_FILE_OBJECTCLASS_HELP", -1);

    /**
     * Schema Validation:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SCHEMA_VALIDATION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SCHEMA_VALIDATION_LABEL", -1);

    /**
     * Searches Done
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEARCH_DONE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEARCH_DONE_LABEL", -1);

    /**
     * Search Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEARCH_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEARCH_REQUESTS_LABEL", -1);

    /**
     * Selected Indexes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SELECTED_INDEXES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SELECTED_INDEXES_LABEL", -1);

    /**
     * Selected:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SELECTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SELECTED_LABEL", -1);

    /**
     * Select All
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SELECT_ALL_BUTTON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SELECT_ALL_BUTTON", -1);

    /**
     * Select the Backends to Delete:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SELECT_BACKENDS_TO_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SELECT_BACKENDS_TO_DELETE", -1);

    /**
     * Select the base DNs to Delete:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SELECT_BASE_DNS_TO_DELETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SELECT_BASE_DNS_TO_DELETE", -1);

    /**
     * Separated with commas
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEPARATED_WITH_COMMAS_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEPARATED_WITH_COMMAS_HELP", -1);

    /**
     * Separate multiple attributes with a comma (,)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEPARATE_ATTRIBUTES_COMMA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEPARATE_ATTRIBUTES_COMMA", -1);

    /**
     * Separate multiple DNs with a line break
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEPARATE_DNS_LINE_BREAK =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEPARATE_DNS_LINE_BREAK", -1);

    /**
     * September
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SEPTEMBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SEPTEMBER", -1);

    /**
     * Server Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_DETAILS_TITLE_BORDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_DETAILS_TITLE_BORDER", -1);

    /**
     * The Java Settings can only be updated when the managed server is the local server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_JAVA_PROPERTIES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_JAVA_PROPERTIES_SUMMARY", -1);

    /**
     * The indexes can only be rebuilt when the managed server is the local server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_REBUILD_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_REBUILD_INDEX_SUMMARY", -1);

    /**
     * The indexes can only be verified when the managed server is the local server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_VERIFY_INDEX_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_VERIFY_INDEX_SUMMARY", -1);

    /**
     * The Windows Service configuration can only be viewed and updated when the managed server is the local server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_WINDOWS_SERVICE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_BE_LOCAL_WINDOWS_SERVICE_SUMMARY", -1);

    /**
     * To see the monitoring data the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_RUN_TO_BROWSE_MONITORING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_RUN_TO_BROWSE_MONITORING_SUMMARY", -1);

    /**
     * To see the monitoring data the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_MUST_RUN_TO_SEE_TRAFFIC_MONITORING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_MUST_RUN_TO_SEE_TRAFFIC_MONITORING_SUMMARY", -1);

    /**
     * To browse data the server must be running and you must provide authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_NOT_RUNNING_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_NOT_RUNNING_DETAILS", -1);

    /**
     * Server Not Running
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_NOT_RUNNING_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_NOT_RUNNING_SUMMARY", -1);

    /**
     * Server is Remote
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_REMOTE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_REMOTE_SUMMARY", -1);

    /**
     * %s (Server Runtime)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_SERVER_RUNTIME_CELL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_RUNTIME_CELL", -1);

    /**
     * Server Status:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_STATUS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_STATUS_LABEL", -1);

    /**
     * Server Status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_STATUS_TITLE_BORDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_STATUS_TITLE_BORDER", -1);

    /**
     * Server Stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SERVER_STOPPED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SERVER_STOPPED", -1);

    /**
     * Only Show Attributes with Values
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SHOW_ATTRS_WITH_VALUES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SHOW_ATTRS_WITH_VALUES_LABEL", -1);

    /**
     * Show Averages since Server Startup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SHOW_AVERAGES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SHOW_AVERAGES", -1);

    /**
     * Sign Message Digest Hash
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SIGN_MESSAGE_DIGEST_HASH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SIGN_MESSAGE_DIGEST_HASH_LABEL", -1);

    /**
     * Simplified View
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SIMPLIFIED_VIEW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SIMPLIFIED_VIEW_MENU", -1);

    /**
     * Skips File:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SKIPS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SKIPS_FILE_LABEL", -1);

    /**
     * Last Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SN_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SN_FRIENDLY_NAME", -1);

    /**
     * Sort User Data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SORT_USER_DATA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SORT_USER_DATA", -1);

    /**
     * - Specify the value in Base 64 -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SPECIFY_CONTENTS_IN_BASE64 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SPECIFY_CONTENTS_IN_BASE64", -1);

    /**
     * Multiple Superiors...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SPECIFY_MULTIPLE_SUPERIORS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SPECIFY_MULTIPLE_SUPERIORS_LABEL", -1);

    /**
     * Click on this button to specify multiple superiors for this object class.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SPECIFY_MULTIPLE_SUPERIORS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SPECIFY_MULTIPLE_SUPERIORS_TOOLTIP", -1);

    /**
     * Standard
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STANDARD_ATTRIBUTES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STANDARD_ATTRIBUTES_CATEGORY_NODE", -1);

    /**
     * Standard Attributes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STANDARD_ATTRIBUTES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STANDARD_ATTRIBUTES_LABEL", -1);

    /**
     * Standard Attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STANDARD_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STANDARD_ATTRIBUTE_TITLE", -1);

    /**
     * Standard
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STANDARD_OBJECTCLASSES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STANDARD_OBJECTCLASSES_CATEGORY_NODE", -1);

    /**
     * Standard Object Class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STANDARD_OBJECTCLASS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STANDARD_OBJECTCLASS_TITLE", -1);

    /**
     * The server started successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STARTING_SERVER_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STARTING_SERVER_SUCCESSFUL_DETAILS", -1);

    /**
     * Start Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STARTING_SERVER_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STARTING_SERVER_SUCCESSFUL_SUMMARY", -1);

    /**
     * Starting Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STARTING_SERVER_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STARTING_SERVER_SUMMARY", -1);

    /**
     * Start Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_START_SERVER_PROGRESS_DLG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_START_SERVER_PROGRESS_DLG_TITLE", -1);

    /**
     * Start Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_START_SERVER_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_START_SERVER_TASK_DESCRIPTION", -1);

    /**
     * Start Time:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_START_TIME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_START_TIME_LABEL", -1);

    /**
     * Static Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STATIC_GROUP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STATIC_GROUP_LABEL", -1);

    /**
     * General Status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STATUS_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STATUS_PANEL_TITLE", -1);

    /**
     * The server stopped successfully
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STOPPING_SERVER_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STOPPING_SERVER_SUCCESSFUL_DETAILS", -1);

    /**
     * Stop Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STOPPING_SERVER_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STOPPING_SERVER_SUCCESSFUL_SUMMARY", -1);

    /**
     * Stopping Server...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STOPPING_SERVER_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STOPPING_SERVER_SUMMARY", -1);

    /**
     * Stop Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STOP_SERVER_PROGRESS_DLG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STOP_SERVER_PROGRESS_DLG_TITLE", -1);

    /**
     * Stop Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STOP_SERVER_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STOP_SERVER_TASK_DESCRIPTION", -1);

    /**
     * Street Address
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STREET_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STREET_FRIENDLY_NAME", -1);

    /**
     * Structural Object Class:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_STRUCTURAL_OBJECTCLASS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_STRUCTURAL_OBJECTCLASS_LABEL", -1);

    /**
     * State
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_ST_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_ST_FRIENDLY_NAME", -1);

    /**
     * Substring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUBSTRING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUBSTRING_LABEL", -1);

    /**
     * Use '*' for substring search.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUBSTRING_SEARCH_INLINE_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUBSTRING_SEARCH_INLINE_HELP", -1);

    /**
     * For example: dc=subtree,dc=example,dc=com
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUBTREE_INLINE_HELP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUBTREE_INLINE_HELP_LABEL", -1);

    /**
     * Specify the superior object classes.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPERIOR_OBJECTCLASSES_INSTRUCTIONS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPERIOR_OBJECTCLASSES_INSTRUCTIONS", -1);

    /**
     * Superior Object Classes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPERIOR_OBJECTCLASSES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPERIOR_OBJECTCLASSES_TITLE", -1);

    /**
     * Supported Controls
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPPORTEDCONTROLS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPPORTEDCONTROLS_FRIENDLY_NAME", -1);

    /**
     * Supported Extensions
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPPORTEDEXTENSIONS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPPORTEDEXTENSIONS_FRIENDLY_NAME", -1);

    /**
     * Supported Features
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPPORTEDFEATURES_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPPORTEDFEATURES_FRIENDLY_NAME", -1);

    /**
     * Supported LDAP Versions
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPPORTEDLDAPVERSIONS_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPPORTEDLDAPVERSIONS_FRIENDLY_NAME", -1);

    /**
     * Supported Password Schemes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SUPPORTEDPWDSCHEMES_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SUPPORTEDPWDSCHEMES_FRIENDLY_NAME", -1);

    /**
     * Entry syntax is correct
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SYNTAX_CORRECT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SYNTAX_CORRECT_LABEL", -1);

    /**
     * The syntax defines the type of value of the attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SYNTAX_INLINE_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SYNTAX_INLINE_HELP", -1);

    /**
     * System Information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SYSTEM_INFORMATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SYSTEM_INFORMATION", -1);

    /**
     * ds-generic.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SYSTEM_INFORMATION_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SYSTEM_INFORMATION_TREE_NODE", -1);

    /**
     * System Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_SYSTEM_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_SYSTEM_NAME", -1);

    /**
     * Show Task Attributes...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_ATTRIBUTES_VIEW =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_ATTRIBUTES_VIEW", -1);

    /**
     * Is Cancelable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_CANCELABLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_CANCELABLE", -1);

    /**
     * Cancelable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_IS_CANCELABLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_IS_CANCELABLE", -1);

    /**
     * Not Cancelable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_IS_NOT_CANCELABLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_IS_NOT_CANCELABLE", -1);

    /**
     * Task Log Message(s)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_LOG_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_LOG_LABEL", -1);

    /**
     * Task Specific Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_SPECIFIC_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_SPECIFIC_DETAILS", -1);

    /**
     * Launch Periodically using a CRON Schedule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON", -1);

    /**
     * Hour:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_HOUR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_HOUR", -1);

    /**
     * Minute:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MINUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MINUTE", -1);

    /**
     * Month:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MONTH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MONTH", -1);

    /**
     * Day of Month:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MONTH_DAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_MONTH_DAY", -1);

    /**
     * Day of Week:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_WEEK_DAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_CRON_WEEK_DAY", -1);

    /**
     * Launch Periodically using a Daily Schedule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_DAILY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_DAILY", -1);

    /**
     * Day:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_DAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_DAY", -1);

    /**
     * Fri
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_FRIDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_FRIDAY", -1);

    /**
     * Scheduled Tasks
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_LIST_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_LIST_TITLE", -1);

    /**
     * Mon
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONDAY", -1);

    /**
     * Month:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONTH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONTH", -1);

    /**
     * Launch Periodically using a Monthly Schedule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONTHLY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_MONTHLY", -1);

    /**
     * Sat
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SATURDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SATURDAY", -1);

    /**
     * Specify when the task '%s' will be launched.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SUMMARY", -1);

    /**
     * Sun
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SUNDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_SUNDAY", -1);

    /**
     * Thu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_THURSDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_THURSDAY", -1);

    /**
     * Time:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TIME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TIME", -1);

    /**
     * Hour (from 00:00 to 23:59) in the time zone of the server host.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TIME_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TIME_TOOLTIP", -1);

    /**
     * '%s' Task Schedule
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TITLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TITLE", -1);

    /**
     * Tue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TUESDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_TUESDAY", -1);

    /**
     * Wed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_WEDNESDAY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_WEDNESDAY", -1);

    /**
     * Launch Periodically using a Weekly Schedule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_WEEKLY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_WEEKLY", -1);

    /**
     * Year:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TASK_TO_SCHEDULE_YEAR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TASK_TO_SCHEDULE_YEAR", -1);

    /**
     * Telephone Number
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TELEPHONENUMBER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TELEPHONENUMBER_FRIENDLY_NAME", -1);

    /**
     * Thumbnail
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_THUMBNAIL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_THUMBNAIL_DESCRIPTION", -1);

    /**
     * Total Connections:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TOTAL_CONNECTIONS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TOTAL_CONNECTIONS_LABEL", -1);

    /**
     * TOTAL
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TOTAL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TOTAL_LABEL", -1);

    /**
     * attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TYPE_ATTRIBUTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TYPE_ATTRIBUTE", -1);

    /**
     * syntax
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TYPE_ATTRIBUTE_SYNTAX =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TYPE_ATTRIBUTE_SYNTAX", -1);

    /**
     * matching rule
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TYPE_MATCHING_RULE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TYPE_MATCHING_RULE", -1);

    /**
     * object class
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_TYPE_OBJECT_CLASS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_TYPE_OBJECT_CLASS", -1);

    /**
     * User ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UID_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UID_FRIENDLY_NAME", -1);

    /**
     * Unbind Requests
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UNBIND_REQUESTS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNBIND_REQUESTS_LABEL", -1);

    /**
     * Members of Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UNIQUEMEMBER_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNIQUEMEMBER_FRIENDLY_NAME", -1);

    /**
     * Save Changes to attribute: '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_UNSAVED_ATTRIBUTE_CHANGES_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_ATTRIBUTE_CHANGES_DETAILS", -1);

    /**
     * Unsaved Changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UNSAVED_CHANGES_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_CHANGES_DIALOG_TITLE", -1);

    /**
     * Unsaved Changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UNSAVED_CHANGES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_CHANGES_SUMMARY", -1);

    /**
     * Save Changes to entry: '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_UNSAVED_ENTRY_CHANGES_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_ENTRY_CHANGES_DETAILS", -1);

    /**
     * Save Changes to index: '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_UNSAVED_INDEX_CHANGES_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_INDEX_CHANGES_DETAILS", -1);

    /**
     * Save Changes to object class: '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_UNSAVED_OBJECTCLASS_CHANGES_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UNSAVED_OBJECTCLASS_CHANGES_DETAILS", -1);

    /**
     * Update Java Settings.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATE_JAVA_SETTINGS_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATE_JAVA_SETTINGS_TASK_DESCRIPTION", -1);

    /**
     * Change...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATE_MULTIPLE_SUPERIORS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATE_MULTIPLE_SUPERIORS_LABEL", -1);

    /**
     * Click on this button to specify the superiors of this object class.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATE_MULTIPLE_SUPERIORS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATE_MULTIPLE_SUPERIORS_TOOLTIP", -1);

    /**
     * Java Settings Updated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_COMPLETE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_COMPLETE", -1);

    /**
     * The Java settings were successfully updated.  When the command-lines are executed the new settings will be taken into account.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_SUCCESSFUL", -1);

    /**
     * Updating Java settings...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATING_JAVA_SETTINGS_SUMMARY", -1);

    /**
     * Adding schema elements to schema file '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_UPDATING_SCHEMA_FILE_PROGRESS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UPDATING_SCHEMA_FILE_PROGRESS", -1);

    /**
     * Up Time:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_UP_TIME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_UP_TIME_LABEL", -1);

    /**
     * Used by attributes:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USED_BY_ATTRIBUTES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USED_BY_ATTRIBUTES", -1);

    /**
     * Used Memory in JVM
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USED_MEMORY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USED_MEMORY", -1);

    /**
     * User Certificate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USERCERTIFICATE_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USERCERTIFICATE_FRIENDLY_NAME", -1);

    /**
     * User Password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USERPASSWORD_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USERPASSWORD_FRIENDLY_NAME", -1);

    /**
     * Users
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USERS_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USERS_FILTER", -1);

    /**
     * Specify binary contents in base 64 format:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_CONTENTS_IN_BASE64 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_CONTENTS_IN_BASE64", -1);

    /**
     * Use contents of file:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_CONTENTS_OF_FILE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_CONTENTS_OF_FILE", -1);

    /**
     * Use the value of the environment variable OPENDJ_JAVA_ARGS
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_OPENDS_JAVA_ARGS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_OPENDS_JAVA_ARGS", -1);

    /**
     * If OPENDJ_JAVA_ARGS is not defined the values specified below will be used as fallback.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_OPENDS_JAVA_ARGS_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_OPENDS_JAVA_ARGS_HELP", -1);

    /**
     * Use the value of the environment variable OPENDJ_JAVA_HOME
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_OPENDS_JAVA_HOME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_OPENDS_JAVA_HOME", -1);

    /**
     * If OPENDJ_JAVA_HOME is not defined the value below will be used as fallback.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_OPENDS_JAVA_HOME_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_OPENDS_JAVA_HOME_HELP", -1);

    /**
     * Use the values specified below
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_ARGS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_ARGS", -1);

    /**
     * If the value is not specified for a command-line the value of OPENDJ_JAVA_ARGS will be used as fallback.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_ARGS_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_ARGS_HELP", -1);

    /**
     * Use the following value:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_HOME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_HOME", -1);

    /**
     * If the value is not found launching the command-line the value of OPENDJ_JAVA_HOME will be used as fallback.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_HOME_HELP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_USE_SPECIFIED_OPENDS_JAVA_HOME_HELP", -1);

    /**
     * - Value in Base64 -
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VALUE_IN_BASE64 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VALUE_IN_BASE64", -1);

    /**
     * Value in base 64 format:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VALUE_IN_BASE_64_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VALUE_IN_BASE_64_LABEL", -1);

    /**
     * Vendor Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VENDORNAME_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VENDORNAME_FRIENDLY_NAME", -1);

    /**
     * Vendor Version
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VENDORVERSION_FRIENDLY_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VENDORVERSION_FRIENDLY_NAME", -1);

    /**
     * Verifying Authentication...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFYING_AUTHENTICATION_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_AUTHENTICATION_SUMMARY", -1);

    /**
     * The verification of the backup finished successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFYING_BACKUP_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_BACKUP_SUCCESSFUL_DETAILS", -1);

    /**
     * Verify Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFYING_BACKUP_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_BACKUP_SUCCESSFUL_SUMMARY", -1);

    /**
     * Verifying contents of backup '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VERIFYING_BACKUP_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_BACKUP_SUMMARY", -1);

    /**
     * The indexes where successfully verified.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFYING_INDEXES_SUCCESSFUL_DETAILS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_INDEXES_SUCCESSFUL_DETAILS", -1);

    /**
     * Index Verification Complete
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFYING_INDEXES_SUCCESSFUL_SUMMARY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_INDEXES_SUCCESSFUL_SUMMARY", -1);

    /**
     * Verifying contents of indexes in '%s'...
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VERIFYING_INDEXES_SUMMARY =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFYING_INDEXES_SUMMARY", -1);

    /**
     * Verify All Index Key Entry IDs are Clean and Refer to Existing Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFY_ALL_KEYS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_ALL_KEYS", -1);

    /**
     * Verify Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFY_BACKUP_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_BACKUP_BUTTON_LABEL", -1);

    /**
     * Verify Backup
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFY_BACKUP_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_BACKUP_TITLE", -1);

    /**
     * Verify Entry Contents are Properly Indexed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFY_ENTRY_CONTEXT_ARE_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_ENTRY_CONTEXT_ARE_INDEXES", -1);

    /**
     * Verify Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VERIFY_INDEXES_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_INDEXES_PANEL_TITLE", -1);

    /**
     * Verify indexes in '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VERIFY_INDEX_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_INDEX_TASK_DESCRIPTION", -1);

    /**
     * Verify the contents of  backup '%s' located in directory '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_VERIFY_TASK_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VERIFY_TASK_DESCRIPTION", -1);

    /**
     * View binary attribute
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VIEW_BINARY_ATTRIBUTE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VIEW_BINARY_ATTRIBUTE_TITLE", -1);

    /**
     * View...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VIEW_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VIEW_BUTTON_LABEL", -1);

    /**
     * View
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VIEW_MENU =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VIEW_MENU", -1);

    /**
     * The view menu
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VIEW_MENU_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VIEW_MENU_DESCRIPTION", -1);

    /**
     * Virtual Static Group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VIRTUAL_STATIC_GROUP_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VIRTUAL_STATIC_GROUP_LABEL", -1);

    /**
     * (ascending)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_ASCENDING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_ASCENDING_LABEL", -1);

    /**
     * %s (ascending)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VLV_ASCENDING_VLV_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_ASCENDING_VLV_INDEX", -1);

    /**
     * (descending)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_DESCENDING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_DESCENDING_LABEL", -1);

    /**
     * %s (descending)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VLV_DESCENDING_VLV_INDEX =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_DESCENDING_VLV_INDEX", -1);

    /**
     * VLV Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES", -1);

    /**
     * VLV Indexes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_CATEGORY_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_CATEGORY_NODE", -1);

    /**
     * Base DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_BASE_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_BASE_DN", -1);

    /**
     * Filter
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_FILTER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_FILTER", -1);

    /**
     * Name
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_NAME", -1);

    /**
     * Requires Rebuild
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_REQUIRES_REBUILD =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_REQUIRES_REBUILD", -1);

    /**
     * Scope
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_SCOPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_SCOPE", -1);

    /**
     * Sort Order
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_HEADER_SORT_ORDER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_HEADER_SORT_ORDER", -1);

    /**
     * In order this VLV index to be effective the following indexes must be configured in '%s':<br>%s <br><br>Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_CTRL_PANEL_VLV_INDEXES_NOT_DEFINED_CONFIRMATION_MSG =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_NOT_DEFINED_CONFIRMATION_MSG", -1);

    /**
     * Indexes Not Defined
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEXES_NOT_DEFINED_CONFIRMATION_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEXES_NOT_DEFINED_CONFIRMATION_TITLE", -1);

    /**
     * Add
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_ADD_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_ADD_BUTTON_LABEL", -1);

    /**
     * approximate
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_APPROXIMATE_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_APPROXIMATE_TYPE", -1);

    /**
     * Base DN:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_BASE_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_BASE_DN_LABEL", -1);

    /**
     * Base Object
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_BASE_OBJECT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_BASE_OBJECT_LABEL", -1);

    /**
     * %s - VLV Index
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_CTRL_PANEL_VLV_INDEX_CELL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_CELL", -1);

    /**
     * VLV Index Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_DETAILS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_DETAILS_LABEL", -1);

    /**
     * equality
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_EQUALITY_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_EQUALITY_TYPE", -1);

    /**
     * Filter:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_FILTER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_FILTER_LABEL", -1);

    /**
     * Max Block Size:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_MAX_BLOCK_SIZE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_MAX_BLOCK_SIZE_LABEL", -1);

    /**
     * Move Down
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_MOVE_DOWN_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_MOVE_DOWN_BUTTON_LABEL", -1);

    /**
     * Move Up
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_MOVE_UP_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_MOVE_UP_BUTTON_LABEL", -1);

    /**
     * Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_NAME_LABEL", -1);

    /**
     * ordering
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_ORDERING_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_ORDERING_TYPE", -1);

    /**
     * VLV Index Properties
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_PANEL_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_PANEL_TITLE", -1);

    /**
     * presence
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_PRESENCE_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_PRESENCE_TYPE", -1);

    /**
     * Remove
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_REMOVE_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_REMOVE_BUTTON_LABEL", -1);

    /**
     * Search Scope:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_SEARCH_SCOPE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_SEARCH_SCOPE_LABEL", -1);

    /**
     * Single Level
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_SINGLE_LEVEL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_SINGLE_LEVEL_LABEL", -1);

    /**
     * Sort Order:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_SORT_ORDER_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_SORT_ORDER_LABEL", -1);

    /**
     * Subordinate Subtree
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_SUBORDINATE_SUBTREE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_SUBORDINATE_SUBTREE_LABEL", -1);

    /**
     * substring
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_SUBSTRING_TYPE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_SUBSTRING_TYPE", -1);

    /**
     * Whole Subtree
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_INDEX_WHOLE_SUBTREE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_INDEX_WHOLE_SUBTREE_LABEL", -1);

    /**
     * Other:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_VLV_OTHER_BASE_DN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_VLV_OTHER_BASE_DN_LABEL", -1);

    /**
     * Windows Service Integration:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WINDOWS_SERVICE_INTEGRATION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WINDOWS_SERVICE_INTEGRATION_LABEL", -1);

    /**
     * This page indicates whether this server instance is configured to run as a Windows Service. To manage auto-start and other features, run the Windows Service Control Manager of the operating system.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WINDOWS_SERVICE_PANEL_TEXT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WINDOWS_SERVICE_PANEL_TEXT", -1);

    /**
     * Windows Service Configuration
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WINDOWS_SERVICE_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WINDOWS_SERVICE_TITLE", -1);

    /**
     * Work Queue
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WORK_QUEUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WORK_QUEUE", -1);

    /**
     * ds-generic.png
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WORK_QUEUE_TREE_NODE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WORK_QUEUE_TREE_NODE", -1);

    /**
     * Write Rejected Entries to a File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WRITE_REJECTS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WRITE_REJECTS_FILE_LABEL", -1);

    /**
     * Write Skipped Entries to a File
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_CTRL_PANEL_WRITE_SKIPS_FILE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_CTRL_PANEL_WRITE_SKIPS_FILE_LABEL", -1);

    /**
     * Data Sources
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DATABASES_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DATABASES_TITLE", -1);

    /**
     * Delete these Database Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_DBS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_DBS_LABEL", -1);

    /**
     * The Directory Server contains database files in the following locations outside the server path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_DBS_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_DBS_MSG", -1);

    /**
     * Check this box to Delete the Database Files located outside the install directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_DBS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_DBS_TOOLTIP", -1);

    /**
     * Delete these Log Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_LOGS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_LOGS_LABEL", -1);

    /**
     * The Directory Server contains log files in the following locations outside the server path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_LOGS_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_LOGS_MSG", -1);

    /**
     * Check this box to Delete the Log Files located outside the install directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DELETE_OUTSIDE_LOGS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DELETE_OUTSIDE_LOGS_TOOLTIP", -1);

    /**
     * User ID of the Global Administrator to use to bind to the server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ADMIN_UID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ADMIN_UID", -1);

    /**
     * Disable the replication configuration on the specified server.  The contents of the server are no longer replicated and the replication server (changelog and replication port) is disabled if it is configured
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DISABLE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_DISABLE_ALL", -1);

    /**
     * DN to use to bind to the server where we want to disable replication.  This option must be used when no Global Administrator has been defined on the server or if the user does not want to remove references in the other replicated servers.  The password provided for the Global Administrator will be used when specifying this option
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DISABLE_REPLICATION_BINDDN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_DISABLE_REPLICATION_BINDDN", -1);

    /**
     * Disable the replication server.  The replication port and change log are disabled on the specified server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_DISABLE_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_DISABLE_REPLICATION_SERVER", -1);

    /**
     * DN to use to bind to the first server whose contents will be replicated.  If not specified the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDDN1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDDN1", -1);

    /**
     * DN to use to bind to the second server whose contents will be replicated.  If not specified the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDDN2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDDN2", -1);

    /**
     * Password to use to bind to the first server whose contents will be replicated.  If no bind DN was specified for the first server the password of the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORD1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORD1", -1);

    /**
     * Password to use to bind to the second server whose contents will be replicated.  If no bind DN was specified for the second server the password of the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORD2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORD2", -1);

    /**
     * File containing the password to use to bind to the first server whose contents will be replicated.  If no bind DN was specified for the first server the password of the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORDFILE1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORDFILE1", -1);

    /**
     * File containing the password to use to bind to the second server whose contents will be replicated.  If no bind DN was specified for the second server the password of the global administrator will be used to bind
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORDFILE2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_BINDPASSWORDFILE2", -1);

    /**
     * Fully qualified host name or IP address of the first server whose contents will be replicated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_HOST1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_HOST1", -1);

    /**
     * Fully qualified host name or IP address of the second server whose contents will be replicated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_HOST2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_HOST2", -1);

    /**
     * Do not configure a replication port or change log on the first server. The first server will contain replicated data but will not contain a change log of modifications made to the replicated data. Note that each replicated topology must contain at least two servers with a change log to avoid a single point of failure
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_NO_REPLICATION_SERVER1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_NO_REPLICATION_SERVER1", -1);

    /**
     * Do not configure a replication port or change log on the second server. The second server will contain replicated data but will not contain a change log of modifications made to the replicated data. Note that each replicated topology must contain at least two servers with a change log to avoid a single point of failure
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_NO_REPLICATION_SERVER2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_NO_REPLICATION_SERVER2", -1);

    /**
     * Do not replicate the schema between the servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_NO_SCHEMA_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_NO_SCHEMA_REPLICATION", -1);

    /**
     * Configure only a change log and replication port on the first server.  The first server will not contain replicated data, but will contain a change log of the modifications made to the replicated data on other servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_ONLY_REPLICATION_SERVER1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_ONLY_REPLICATION_SERVER1", -1);

    /**
     * Configure only a change log and replication port on the second server.  The second server will not contain replicated data, but will contain a change log of the modifications made to the replicated data on other servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_ONLY_REPLICATION_SERVER2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_ONLY_REPLICATION_SERVER2", -1);

    /**
     * Port that will be used by the replication mechanism in the first server to communicate with the other servers.  You have to specify this option only if replication was not previously configured in the first server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_PORT1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_PORT1", -1);

    /**
     * Port that will be used by the replication mechanism in the second server to communicate with the other servers.  You have to specify this option only if replication was not previously configured in the second server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_PORT2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_PORT2", -1);

    /**
     * Directory server administration port number of the first server whose contents will be replicated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_SERVER_PORT1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_SERVER_PORT1", -1);

    /**
     * Directory server administration port number of the second server whose contents will be replicated
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_SERVER_PORT2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_SERVER_PORT2", -1);

    /**
     * Skip the check to determine whether the specified replication ports are usable
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_REPLICATION_SKIPPORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_SKIPPORT", -1);

    /**
     * Use the second server to initialize the schema of the first server.  If this option nor option %s are specified the schema of the first server will be used to initialize the schema of the second server
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_ENABLE_REPLICATION_USE_SECOND_AS_SCHEMA_SOURCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_REPLICATION_USE_SECOND_AS_SCHEMA_SOURCE", -1);

    /**
     * Specifies whether the communication through the replication port of the first server is encrypted or not.  This option will only be taken into account the first time replication is configured on the first server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_SECURE_REPLICATION1 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_SECURE_REPLICATION1", -1);

    /**
     * Specifies whether the communication through the replication port of the second server is encrypted or not.  This option will only be taken into account the first time replication is configured on the second server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_ENABLE_SECURE_REPLICATION2 =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_ENABLE_SECURE_REPLICATION2", -1);

    /**
     * Fully qualified host name or IP address of the destination server whose contents will be initialized
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_INITIALIZE_REPLICATION_HOST_DESTINATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_INITIALIZE_REPLICATION_HOST_DESTINATION", -1);

    /**
     * Fully qualified host name or IP address of the source server whose contents will be used to initialize the destination server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_INITIALIZE_REPLICATION_HOST_SOURCE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_INITIALIZE_REPLICATION_HOST_SOURCE", -1);

    /**
     * Directory server administration port number of the destination server whose contents will be initialized
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_INITIALIZE_REPLICATION_SERVER_PORT_DESTINATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_INITIALIZE_REPLICATION_SERVER_PORT_DESTINATION", -1);

    /**
     * Directory server administration port number of the source server whose contents will be used to initialize the destination server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_INITIALIZE_REPLICATION_SERVER_PORT_SOURCE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_INITIALIZE_REPLICATION_SERVER_PORT_SOURCE", -1);

    /**
     * The name of this host (or IP address) as it is referenced in remote servers for replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REFERENCED_HOST =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REFERENCED_HOST", -1);

    /**
     * The global administrator password
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REPLICATION_ADMIN_BINDPASSWORD =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REPLICATION_ADMIN_BINDPASSWORD", -1);

    /**
     * The file containing the password of the global administrator
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REPLICATION_ADMIN_BINDPASSWORDFILE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REPLICATION_ADMIN_BINDPASSWORDFILE", -1);

    /**
     * User ID of the Global Administrator to use to bind to the server.  For the '%s' subcommand if no Global Administrator was defined previously for none of the server the Global Administrator will be created using the provided data.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_REPLICATION_ADMIN_UID =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REPLICATION_ADMIN_UID", -1);

    /**
     * Base DN of the data to be replicated, initialized or for which we want to disable replication.  Multiple base DNs can be provided by using this option multiple times
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_REPLICATION_BASEDNS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_REPLICATION_BASEDNS", -1);

    /**
     * Re-synchronizes the change-log changenumber on one server with the change-log changenumber of another.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_RESET_CHANGE_NUMBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_RESET_CHANGE_NUMBER", -1);

    /**
     * The change number to use as the basis for re-synchronization
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_START_CHANGE_NUMBER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_START_CHANGE_NUMBER", -1);

    /**
     * Disables replication on the specified server for the provided base DN and removes references in the other servers with which it is replicating data
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBCMD_DISABLE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_DISABLE_REPLICATION", -1);

    /**
     * Updates the configuration of the servers to replicate the data under the specified base DN.  If one of the specified servers is already replicating the data under the base DN with other servers, executing this subcommand will update the configuration of all the servers (so it is sufficient to execute the command line once for each server we add to the replication topology)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBCMD_ENABLE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_ENABLE_REPLICATION", -1);

    /**
     * Initialize the contents of the data under the specified base DN on all the servers whose contents are being replicated with the contents on the specified server.  This operation is required after enabling replication for replication to work ('%s' applied to each server can also be used for this purpose)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_SUBCMD_INITIALIZE_ALL_REPLICATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_INITIALIZE_ALL_REPLICATION", -1);

    /**
     * Initialize the contents of the data under the specified base DN on the destination server with the contents on the source server.  This operation is required after enabling replication in order replication to work ('%s' can also be used for this purpose)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_SUBCMD_INITIALIZE_REPLICATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_INITIALIZE_REPLICATION", -1);

    /**
     * This subcommand must be called after initializing the contents of all the replicated servers using the tool import-ldif or the binary copy method.  You must specify the list of base DNs that have been initialized and you must provide the credentials of any of the servers that are being replicated.  See the usage of the subcommand '%s' for more information
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_SUBCMD_POST_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_POST_EXTERNAL_INITIALIZATION", -1);

    /**
     * This subcommand must be called before initializing the contents of all the replicated servers using the tool import-ldif or the binary copy method.  You must specify the list of base DNs that will be initialized and you must provide the credentials of any of the servers that are being replicated.  After calling this subcommand, initialize the contents of all the servers in the topology (use the same LDIF file/binary copy on each of the servers), then call the subcommand '%s'
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DESCRIPTION_SUBCMD_PRE_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_PRE_EXTERNAL_INITIALIZATION", -1);

    /**
     * Launches a purge processing of the historical informations stored in the user entries by replication. Since this processing may take a while, you must specify the maximum duration for this processing.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBCMD_PURGE_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_PURGE_HISTORICAL", -1);

    /**
     * Displays a list with the basic replication configuration of the base DNs of the servers defined in the registration information.  If no base DNs are specified as parameter the information for all base DNs is displayed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DESCRIPTION_SUBCMD_STATUS_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DESCRIPTION_SUBCMD_STATUS_REPLICATION", -1);

    /**
     * Disabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DISABLED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DISABLED_LABEL", -1);

    /**
     * You have decided to disable the replication server (replication changelog).  At least one replication server is required in a replication topology and this is the last replication server for the following suffixes:%n%s%nReplication will be disabled for these servers.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DISABLE_REPLICATION_DISABLE_IN_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DISABLE_REPLICATION_DISABLE_IN_REMOTE", -1);

    /**
     * You have decided to disable the replication server (replication changelog).  At least one replication server is required in a replication topology and this is the last replication server for the following suffixes:%n%s%nReplication will be disabled for these servers.%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DISABLE_REPLICATION_DISABLE_IN_REMOTE_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DISABLE_REPLICATION_DISABLE_IN_REMOTE_PROMPT", -1);

    /**
     * You have decided to disable the replication server (replication changelog).  After disabling the replication server only one replication server will be configured for the following suffixes:%n%s%nTo avoid a single point of failure at least two replication servers must be configured.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DISABLE_REPLICATION_ONE_POINT_OF_FAILURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DISABLE_REPLICATION_ONE_POINT_OF_FAILURE", -1);

    /**
     * You have decided to disable the replication server (replication changelog).  After disabling the replication server only one replication server will be configured for the following suffixes:%n%s%nTo avoid a single point of failure at least two replication servers must be configured.%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_DISABLE_REPLICATION_ONE_POINT_OF_FAILURE_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_DISABLE_REPLICATION_ONE_POINT_OF_FAILURE_PROMPT", -1);

    /**
     * Dynamic group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_DYNAMIC_GROUP_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_DYNAMIC_GROUP_ICON_DESCRIPTION", -1);

    /**
     * You must provide the name of the remote host name.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_EMPTY_REMOTE_HOST_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_EMPTY_REMOTE_HOST_NAME", -1);

    /**
     * Enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ENABLED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ENABLED_LABEL", -1);

    /**
     * Initializing registration information on server %s with the contents of server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ENABLE_REPLICATION_INITIALIZING_ADS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_ENABLE_REPLICATION_INITIALIZING_ADS", -1);

    /**
     * Initializing registration information with the contents of server %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_ENABLE_REPLICATION_INITIALIZING_ADS_ALL =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_ENABLE_REPLICATION_INITIALIZING_ADS_ALL", -1);

    /**
     * Initializing schema on server %s with the contents of server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_ENABLE_REPLICATION_INITIALIZING_SCHEMA =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_ENABLE_REPLICATION_INITIALIZING_SCHEMA", -1);

    /**
     * Email addresses to send the error notification to [continue]:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ERROR_NOTIFICATION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ERROR_NOTIFICATION_PROMPT", -1);

    /**
     * Uninstall
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISH_BUTTON_UNINSTALL_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_FINISH_BUTTON_UNINSTALL_LABEL", -1);

    /**
     * Finish Uninstall
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_FINISH_BUTTON_UNINSTALL_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_FINISH_BUTTON_UNINSTALL_TOOLTIP", -1);

    /**
     * %s Uninstall
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_FRAME_UNINSTALL_TITLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_FRAME_UNINSTALL_TITLE", -1);

    /**
     * Do you want to send an email notification when this task completes?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HAS_COMPLETION_NOTIFICATION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_HAS_COMPLETION_NOTIFICATION_PROMPT", -1);

    /**
     * Do you want to send an email notification if this task fails?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HAS_ERROR_NOTIFICATION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_HAS_ERROR_NOTIFICATION_PROMPT", -1);

    /**
     * Host Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_HOSTNAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_HOSTNAME_LABEL", -1);

    /**
     * Yes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INDEX_MUST_BE_REBUILT_CELL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_INDEX_MUST_BE_REBUILT_CELL_VALUE", -1);

    /**
     * No
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INDEX_MUST_NOT_BE_REBUILT_CELL_VALUE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_INDEX_MUST_NOT_BE_REBUILT_CELL_VALUE", -1);

    /**
     * >>>> Specify server administration connection parameters for the destination server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INITIALIZE_DESTINATION_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_INITIALIZE_DESTINATION_CONNECTION_PARAMETERS", -1);

    /**
     * >>>> Specify server administration connection parameters for the source server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INITIALIZE_SOURCE_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_INITIALIZE_SOURCE_CONNECTION_PARAMETERS", -1);

    /**
     * Installation Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_INSTALLATION_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_INSTALLATION_PATH_LABEL", -1);

    /**
     * The value of the remote server administrative port must be an integer value between %d and %d.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> INFO_INVALID_REMOTE_SERVER_PORT =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "INFO_INVALID_REMOTE_SERVER_PORT", -1);

    /**
     * Java Version:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_JAVA_VERSION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_JAVA_VERSION_LABEL", -1);

    /**
     * Connection Handlers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LISTENERS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_LISTENERS_TITLE", -1);

    /**
     * The Directory Server is not running. Click OK to continue.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LOGIN_DIALOG_SERVER_NOT_RUNNING_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_LOGIN_DIALOG_SERVER_NOT_RUNNING_MSG", -1);

    /**
     * Directory Server not Running
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LOGIN_DIALOG_SERVER_NOT_RUNNING_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_LOGIN_DIALOG_SERVER_NOT_RUNNING_TITLE", -1);

    /**
     * Authentication Required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_LOGIN_DIALOG_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_LOGIN_DIALOG_TITLE", -1);

    /**
     * Missing Changes
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_MISSING_CHANGES_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_MISSING_CHANGES_COLUMN", -1);

    /**
     * You must select something to be uninstalled.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOTHING_SELECTED_TO_UNINSTALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOTHING_SELECTED_TO_UNINSTALL", -1);

    /**
     * --
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_APPLICABLE_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_APPLICABLE_LABEL", -1);

    /**
     * <not available> (*)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LABEL", -1);

    /**
     * * Information only available if you provide valid authentication information when launching the status command.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_CLI_LEGEND", -1);

    /**
     * <html>Information is only available if you are authenticated<br>as an administrative user.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_AUTHENTICATION_REQUIRED_TOOLTIP", -1);

    /**
     * <not available> (*)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LABEL", -1);

    /**
     * * Information only available if server is running and you provide valid authentication information when launching the status command.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_SERVER_DOWN_CLI_LEGEND", -1);

    /**
     * <html>Information is only available if server is running and you are authenticated<br>as an administrative user.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_SERVER_DOWN_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_SERVER_DOWN_TOOLTIP", -1);

    /**
     * N/A
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NOT_AVAILABLE_SHORT_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NOT_AVAILABLE_SHORT_LABEL", -1);

    /**
     * -No LDAP Databases Found-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_DBS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NO_DBS_FOUND", -1);

    /**
     * -No Listener Ports Found-
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NO_LISTENERS_FOUND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NO_LISTENERS_FOUND", -1);

    /**
     * Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_NUMBER_ENTRIES_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_NUMBER_ENTRIES_COLUMN", -1);

    /**
     * The selected object classes are superior of the following object classes: %s.  If you continue, these object classes will be updated with a new superior.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_OBJECTCLASSES_ARE_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_OBJECTCLASSES_ARE_SUPERIOR", -1);

    /**
     * Object class '%s' is superior of the following object classes: %s.  If you continue, these object classes will be updated with a new superior.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_OBJECTCLASS_IS_SUPERIOR =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_OBJECTCLASS_IS_SUPERIOR", -1);

    /**
     * Version:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_OPENDS_VERSION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_OPENDS_VERSION_LABEL", -1);

    /**
     * Organizational unit
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ORGANIZATIONAL_UNIT_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ORGANIZATIONAL_UNIT_ICON_DESCRIPTION", -1);

    /**
     * Organization
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_ORGANIZATION_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_ORGANIZATION_ICON_DESCRIPTION", -1);

    /**
     * Password policy
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PASSWORD_POLICY_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PASSWORD_POLICY_ICON_DESCRIPTION", -1);

    /**
     * Person object
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PERSON_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PERSON_ICON_DESCRIPTION", -1);

    /**
     * Importing Automatically-Generated Data (%s Entries)
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED_REMOTE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_IMPORT_AUTOMATICALLY_GENERATED_REMOTE", -1);

    /**
     * Updating replication information on base DN %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_POST_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_POST_EXTERNAL_INITIALIZATION", -1);

    /**
     * Post initialization procedure completed successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_POST_INITIALIZATION_FINISHED_PROCEDURE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_POST_INITIALIZATION_FINISHED_PROCEDURE", -1);

    /**
     * Preparing base DN %s to be initialized externally
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_PRE_EXTERNAL_INITIALIZATION =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_PRE_EXTERNAL_INITIALIZATION", -1);

    /**
     * Now you can proceed to the initialization of the contents of the base DNs on all the replicated servers.  You can use the command import-ldif or the binary copy to do so.  You must use the same LDIF file or binary copy on each server.%n%nWhen the initialization is completed you must use the subcommand '%s' for replication to work with the new base DNs contents.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_PRE_INITIALIZATION_FINISHED_PROCEDURE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_PRE_INITIALIZATION_FINISHED_PROCEDURE", -1);

    /**
     * Purging historical on base DNs:%s%s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_PROGRESS_PURGE_HISTORICAL =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_PURGE_HISTORICAL", -1);

    /**
     * Purge of historical has been successfully completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROGRESS_PURGE_HISTORICAL_FINISHED_PROCEDURE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_PURGE_HISTORICAL_FINISHED_PROCEDURE", -1);

    /**
     * Removing references on %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_PROGRESS_REMOVING_REFERENCES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_PROGRESS_REMOVING_REFERENCES", -1);

    /**
     * Protocol
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PROTOCOL_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PROTOCOL_COLUMN", -1);

    /**
     * Purge historical
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_PURGE_HISTORICAL_TASK_NAME =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_PURGE_HISTORICAL_TASK_NAME", -1);

    /**
     * Backup Files Contained in bak Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_BACKUPS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_BACKUPS_LABEL", -1);

    /**
     * Remove Backup Files Contained in bak Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_BACKUPS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_BACKUPS_TOOLTIP", -1);

    /**
     * Database Contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_DATABASES_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_DATABASES_LABEL", -1);

    /**
     * Remove Database Contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_DATABASES_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_DATABASES_TOOLTIP", -1);

    /**
     * LDIF Export Files Contained in ldif Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LDIFS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LDIFS_LABEL", -1);

    /**
     * Remove LDIF Export Files Contained in ldif Directory
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LDIFS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LDIFS_TOOLTIP", -1);

    /**
     * Server Libraries and Administrative Tools
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LIBRARIES_AND_TOOLS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LIBRARIES_AND_TOOLS_LABEL", -1);

    /**
     * Remove Server Libraries and Administrative Tools
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LIBRARIES_AND_TOOLS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LIBRARIES_AND_TOOLS_TOOLTIP", -1);

    /**
     * Log Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LOGS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LOGS_LABEL", -1);

    /**
     * Remove Log Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_LOGS_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_LOGS_TOOLTIP", -1);

    /**
     * Configuration and Schema Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_SCHEMA_AND_CONFIGURATION_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_SCHEMA_AND_CONFIGURATION_LABEL", -1);

    /**
     * Remove Configuration and Schema Files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REMOVE_SCHEMA_AND_CONFIGURATION_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REMOVE_SCHEMA_AND_CONFIGURATION_TOOLTIP", -1);

    /**
     * Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATED_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATED_COLUMN", -1);

    /**
     * You chose to disable replication on base DN %s.  This base DN is used by the replication mechanism and by some administrative tools and it is not recommended to configure it directly.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_CONFIRM_DISABLE_ADS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_DISABLE_ADS", -1);

    /**
     * Disabling replication will make the data under the selected base DNs not to be synchronized with other servers any more.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_CONFIRM_DISABLE_GENERIC =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_DISABLE_GENERIC", -1);

    /**
     * You chose to disable replication of the schema.  Disabling schema replication is only recommended in specific scenarios.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_CONFIRM_DISABLE_SCHEMA =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_DISABLE_SCHEMA", -1);

    /**
     * You chose to initialize the contents of base DN %s on server %s with the contents in server %s.  This base DN is used by the replication mechanism and by some administrative tools and it is not recommended to configure it directly.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_REPLICATION_CONFIRM_INITIALIZE_ADS =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_INITIALIZE_ADS", -1);

    /**
     * You chose to initialize the contents of base DN %s with the contents in server %s.  This base DN is used by the replication mechanism and by some administrative tools and it is not recommended to configure it directly.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_CONFIRM_INITIALIZE_ALL_ADS =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_INITIALIZE_ALL_ADS", -1);

    /**
     * Initializing the contents of a base DN removes all the existing contents of that base DN.  Do you want to remove the contents of the selected base DNs on the replicated servers and replace them with the contents of server %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_CONFIRM_INITIALIZE_ALL_GENERIC =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_INITIALIZE_ALL_GENERIC", -1);

    /**
     * Initializing the contents of a base DN removes all the existing contents of that base DN.  Do you want to remove the contents of the selected base DNs on server %s and replace them with the contents of server %s?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_CONFIRM_INITIALIZE_GENERIC =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONFIRM_INITIALIZE_GENERIC", -1);

    /**
     * Establishing connections
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_CONNECTING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CONNECTING", -1);

    /**
     * Details: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_CRITICAL_ERROR_DETAILS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_CRITICAL_ERROR_DETAILS", -1);

    /**
     * The full path to the file where the equivalent non-interactive commands will be written when this command is run in interactive mode
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_DESCRIPTION_EQUIVALENT_COMMAND_FILE_PATH =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DESCRIPTION_EQUIVALENT_COMMAND_FILE_PATH", -1);

    /**
     * You have chosen to disable all the replicated base DNs in the server '%s'.  Do you want to disable also the replication port '%d'?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_REPLICATION_DISABLE_ALL_SUFFIXES_DISABLE_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLE_ALL_SUFFIXES_DISABLE_REPLICATION_SERVER", -1);

    /**
     * You have chosen to disable replication on all the replicated base DNs of '%s'.  If you want also the replication server (changelog and replication port) to be disabled you must also specify the '--%s' or '--%s' option.
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Object> INFO_REPLICATION_DISABLE_ALL_SUFFIXES_KEEP_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLE_ALL_SUFFIXES_KEEP_REPLICATION_SERVER", -1);

    /**
     * Disable Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_DISABLE_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLE_MENU_PROMPT", -1);

    /**
     * Disable replication on base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_DISABLE_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLE_SUFFIX_PROMPT", -1);

    /**
     * Disabling replication on base DN %s of server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_DISABLING_BASEDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLING_BASEDN", -1);

    /**
     * Disabling replication port %s of server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_DISABLING_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_DISABLING_REPLICATION_SERVER", -1);

    /**
     * Global Administrator account will be created.%nYou must provide the credentials of the Global Administrator that will be created to manage the server instances that are being replicated.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_ADMINISTRATOR_MUST_BE_CREATED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_ADMINISTRATOR_MUST_BE_CREATED", -1);

    /**
     * Updating registration configuration on server %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_CONFIGURING_ADS =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_CONFIGURING_ADS", -1);

    /**
     * Updating replication configuration for baseDN %s on server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_ENABLE_CONFIGURING_BASEDN =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_CONFIGURING_BASEDN", -1);

    /**
     * Configuring Replication port on server %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_CONFIGURING_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_CONFIGURING_REPLICATION_SERVER", -1);

    /**
     * >>>> Specify server administration connection parameters for the first server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_HOST1_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_HOST1_CONNECTION_PARAMETERS", -1);

    /**
     * >>>> Specify server administration connection parameters for the second server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_HOST2_CONNECTION_PARAMETERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_HOST2_CONNECTION_PARAMETERS", -1);

    /**
     * Enable Replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_MENU_PROMPT", -1);

    /**
     * Replication port for the first server (the port must be free)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATIONPORT1_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATIONPORT1_PROMPT", -1);

    /**
     * Replication port for the second server (the port must be free)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATIONPORT2_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATIONPORT2_PROMPT", -1);

    /**
     * Will this server contain the data that is going to be replicated?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATION_DOMAIN1_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATION_DOMAIN1_PROMPT", -1);

    /**
     * Will this server contain the data that is going to be replicated?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATION_DOMAIN2_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATION_DOMAIN2_PROMPT", -1);

    /**
     * A replication server contains a changelog with the replication changes and requires a replication port to be configured.%nDo you want the first server to contain a changelog?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATION_SERVER1_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATION_SERVER1_PROMPT", -1);

    /**
     * A replication server contains a changelog with the replication changes and requires a replication port to be configured.%nDo you want the second server to contain a changelog?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_REPLICATION_SERVER2_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_REPLICATION_SERVER2_PROMPT", -1);

    /**
     * Do you want replication to use encrypted communication when connecting to replication port %s on the first server?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_SECURE1_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_SECURE1_PROMPT", -1);

    /**
     * Do you want replication to use encrypted communication when connecting to replication port %s on the second server?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_SECURE2_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_SECURE2_PROMPT", -1);

    /**
     * Replicate base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_SUFFIX_PROMPT", -1);

    /**
     * Checking registration information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_ENABLE_UPDATING_ADS_CONTENTS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_UPDATING_ADS_CONTENTS", -1);

    /**
     * Updating remote references on server %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ENABLE_UPDATING_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ENABLE_UPDATING_REPLICATION_SERVER", -1);

    /**
     * Initialize All Servers
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_INITIALIZE_ALL_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_INITIALIZE_ALL_MENU_PROMPT", -1);

    /**
     * Initialize base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_INITIALIZE_ALL_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_INITIALIZE_ALL_SUFFIX_PROMPT", -1);

    /**
     * Initialize Replication on one Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_INITIALIZE_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_INITIALIZE_MENU_PROMPT", -1);

    /**
     * Initialize base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_INITIALIZE_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_INITIALIZE_SUFFIX_PROMPT", -1);

    /**
     * To be able to configure replication the registration information of servers %s and %s must be merged.  If any conflict is detected, the information of server %s will be kept and the information of server %s overridden.%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_REPLICATION_MERGING_REGISTRIES_CONFIRMATION =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_MERGING_REGISTRIES_CONFIRMATION", -1);

    /**
     * To be able to configure replication the registration information of servers %s and %s must be merged.  If any conflict is detected, the information of server %s will be kept and the information of server %s overridden.
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_REPLICATION_MERGING_REGISTRIES_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_MERGING_REGISTRIES_DESCRIPTION", -1);

    /**
     * Merging registration information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_MERGING_REGISTRIES_PROGRESS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_MERGING_REGISTRIES_PROGRESS", -1);

    /**
     * The equivalent non-interactive command-line is:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_NON_INTERACTIVE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_NON_INTERACTIVE", -1);

    /**
     * Only one replication server will be defined for the following base DNs:%n%s%nIt is recommended to have at least two replication servers (two changelogs) to avoid a single point of failure in the replication topology.%nDo you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ONLY_ONE_REPLICATION_SERVER_CONFIRM =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ONLY_ONE_REPLICATION_SERVER_CONFIRM", -1);

    /**
     * Only one replication server will be defined for the following base DNs:%n%s%nIt is recommended to have at least two replication servers (two changelogs) to avoid a single point of failure in the replication topology.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_ONLY_ONE_REPLICATION_SERVER_WARNING =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_ONLY_ONE_REPLICATION_SERVER_WARNING", -1);

    /**
     * Replication has been successfully enabled.  Note that for replication to work you must initialize the contents of the base DNs that are being replicated (use %s %s to do so).
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_POST_ENABLE_INFO =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_POST_ENABLE_INFO", -1);

    /**
     * Post External Initialization
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_POST_EXTERNAL_INITIALIZATION_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_POST_EXTERNAL_INITIALIZATION_MENU_PROMPT", -1);

    /**
     * Have you initialized with import-ldif or binary copy base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_POST_EXTERNAL_INITIALIZATION_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_POST_EXTERNAL_INITIALIZATION_SUFFIX_PROMPT", -1);

    /**
     * Pre External Initialization
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PRE_EXTERNAL_INITIALIZATION_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PRE_EXTERNAL_INITIALIZATION_MENU_PROMPT", -1);

    /**
     * Are you going to initialize with import-ldif or binary copy base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_PRE_EXTERNAL_INITIALIZATION_SUFFIX_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PRE_EXTERNAL_INITIALIZATION_SUFFIX_PROMPT", -1);

    /**
     * You can choose to disable all the replication on the server.  If you choose 'yes' the changelog and the replication port (if defined) will be disabled; if this server contains replicated data, the data will not be replicated with other servers any more; all the registration information will be deleted.%nDo you want to disable all the replication configuration?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PROMPT_DISABLE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PROMPT_DISABLE_ALL", -1);

    /**
     * Do you want to disable the replication server (changelog and replication port '%d') on the server?
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> INFO_REPLICATION_PROMPT_DISABLE_REPLICATION_SERVER =
                    new LocalizableMessageDescriptor.Arg1<Number>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PROMPT_DISABLE_REPLICATION_SERVER", -1);

    /**
     * There is no replication server configured in '%s'.  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_PROMPT_NO_REPLICATION_SERVER_TO_DISABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PROMPT_NO_REPLICATION_SERVER_TO_DISABLE", -1);

    /**
     * Initializing environment for purge historical
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_ENVIRONMENT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_ENVIRONMENT", -1);

    /**
     * Do you want to execute the purge on the local server (which is stopped)?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_PROMPT", -1);

    /**
     * Purging historical started.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_STARTING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_LOCAL_STARTING", -1);

    /**
     * Maximum duration for the historical purge in seconds?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PURGE_HISTORICAL_MAXIMUM_DURATION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_MAXIMUM_DURATION_PROMPT", -1);

    /**
     * Purge Historical
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_PURGE_HISTORICAL_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_MENU_PROMPT", -1);

    /**
     * Purge historical on base DN %s?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_PURGE_HISTORICAL_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_PURGE_HISTORICAL_PROMPT", -1);

    /**
     * Removing registration information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_REMOVE_ADS_CONTENTS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_REMOVE_ADS_CONTENTS", -1);

    /**
     * Removing references on base DN %s of server %s
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_REMOVING_REFERENCES_ON_REMOTE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_REMOVING_REFERENCES_ON_REMOTE", -1);

    /**
     * You asked not to configure a replication server in '%s' but the server already has a replication server configured (with replication port '%d').
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_REPLICATION_SERVER_CONFIGURED_WARNING =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_SERVER_CONFIGURED_WARNING", -1);

    /**
     * You asked not to configure a replication server in '%s' but the server already has a replication server configured (with replication port '%d').  Do you want to continue?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Number> INFO_REPLICATION_SERVER_CONFIGURED_WARNING_PROMPT =
                    new LocalizableMessageDescriptor.Arg2<Object, Number>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_SERVER_CONFIGURED_WARNING_PROMPT", -1);

    /**
     * A.O.M.C. (3)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_AGE_OF_OLDEST_MISSING_CHANGE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_AGE_OF_OLDEST_MISSING_CHANGE", -1);

    /**
     * DS ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_DS_ID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_DS_ID", -1);

    /**
     * M.C. (2)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_MISSING_CHANGES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_MISSING_CHANGES", -1);

    /**
     * Entries
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_NUMBER_ENTRIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_NUMBER_ENTRIES", -1);

    /**
     * Replication enabled
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_REPLICATION_ENABLED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_REPLICATION_ENABLED", -1);

    /**
     * RS Port (1)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_REPLICATION_PORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_REPLICATION_PORT", -1);

    /**
     * RS ID
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_RS_ID =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_RS_ID", -1);

    /**
     * Security (4)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_SECURE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_SECURE", -1);

    /**
     * Server
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_SERVERPORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_SERVERPORT", -1);

    /**
     * Suffix DN
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_HEADER_SUFFIX_DN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_HEADER_SUFFIX_DN", -1);

    /**
     * The following servers have a replication server (with changelog and a replication port) but are not linked to any server containing replicated data.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_INDEPENDENT_REPLICATION_SERVERS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_INDEPENDENT_REPLICATION_SERVERS", -1);

    /**
     * Display Replication Status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_MENU_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_MENU_PROMPT", -1);

    /**
     * [6] Server does not contain replicated data for the suffix.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NOT_A_REPLICATION_DOMAIN_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NOT_A_REPLICATION_DOMAIN_LEGEND", -1);

    /**
     * (6)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NOT_A_REPLICATION_DOMAIN_SHORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NOT_A_REPLICATION_DOMAIN_SHORT", -1);

    /**
     * [5] Server not configured as a replication server (no replication changelog).
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NOT_A_REPLICATION_SERVER_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NOT_A_REPLICATION_SERVER_LEGEND", -1);

    /**
     * (5)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NOT_A_REPLICATION_SERVER_SHORT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NOT_A_REPLICATION_SERVER_SHORT", -1);

    /**
     * No replication information for the base DNs found.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NO_BASEDNS =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NO_BASEDNS", -1);

    /**
     * No replication information found.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_NO_REPLICATION_INFORMATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_NO_REPLICATION_INFORMATION", -1);

    /**
     * [1] The port used to communicate between the servers whose contents are being replicated.%n[2] The number of changes that are still missing on this server (and that have been applied to at least one of the other servers).%n[3] Age of oldest missing change: the date on which the oldest change that has not arrived on this server was generated.%n[4] Whether the replication communication through the replication port is encrypted or not.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_STATUS_REPLICATED_LEGEND =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_STATUS_REPLICATED_LEGEND", -1);

    /**
     * What do you want to do?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_SUBCOMMAND_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_SUBCOMMAND_PROMPT", -1);

    /**
     * The operation has been successfully completed
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_SUCCESSFUL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_SUCCESSFUL", -1);

    /**
     * The operation has been successfully completed, but no action was required
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REPLICATION_SUCCESSFUL_NOP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_SUCCESSFUL_NOP", -1);

    /**
     * This utility can be used to configure replication between servers so that the data of the servers is synchronized.  For replication to work you must first enable replication using the '%s' subcommand and then initialize the contents of one of the servers with the contents of the other using the '%s' subcommand
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_REPLICATION_TOOL_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_TOOL_DESCRIPTION", -1);

    /**
     * There is no replication server configured in '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_REPLICATION_WARNING_NO_REPLICATION_SERVER_TO_DISABLE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_REPLICATION_WARNING_NO_REPLICATION_SERVER_TO_DISABLE", -1);

    /**
     * Required Icon.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_REQUIRED_ICON_ACCESSIBLE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_REQUIRED_ICON_ACCESSIBLE_DESCRIPTION", -1);

    /**
     * Are you sure that you want to reset the change number on server '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_RESET_CHANGE_NUMBER_CONFIRM_RESET =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_RESET_CHANGE_NUMBER_CONFIRM_RESET", -1);

    /**
     * Resetting change-log's change number of server '%s' to ChangeNumber: %s, CSN: %s, base DN: '%s'
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object> INFO_RESET_CHANGE_NUMBER_INFO =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_RESET_CHANGE_NUMBER_INFO", -1);

    /**
     * Change-log change number reset task has finished successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESET_CHANGE_NUMBER_TASK_FINISHED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_RESET_CHANGE_NUMBER_TASK_FINISHED", -1);

    /**
     * Which change number on server '%s' would you like to use as the starting point for the change-log's change number on server '%s'?
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> INFO_RESET_CHANGE_NUMBER_TO =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(AdminToolMessages.class, RESOURCE, "INFO_RESET_CHANGE_NUMBER_TO", -1);

    /**
     * Restart
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RESTART_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_RESTART_BUTTON_LABEL", -1);

    /**
     * Launch later
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RUN_TASK_LATER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_RUN_TASK_LATER", -1);

    /**
     * Launch now
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_RUN_TASK_NOW =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_RUN_TASK_NOW", -1);

    /**
     * Schedule to run the task periodically
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SCHEDULE_TASK =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SCHEDULE_TASK", -1);

    /**
     * Server Details
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_DETAILS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_DETAILS_TITLE", -1);

    /**
     * Not Connected to Remote
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_NOT_CONNECTED_TO_REMOTE_STATUS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_NOT_CONNECTED_TO_REMOTE_STATUS_LABEL", -1);

    /**
     * Server Path:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_PATH_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_PATH_LABEL", -1);

    /**
     * Started
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STARTED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STARTED_LABEL", -1);

    /**
     * Starting
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STARTING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STARTING_LABEL", -1);

    /**
     * Server Run Status:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STATUS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STATUS_LABEL", -1);

    /**
     * Server Status
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STATUS_TITLE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STATUS_TITLE", -1);

    /**
     * Stopped
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STOPPED_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STOPPED_LABEL", -1);

    /**
     * Stopping
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_STOPPING_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_STOPPING_LABEL", -1);

    /**
     * Unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SERVER_UNKNOWN_STATUS_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SERVER_UNKNOWN_STATUS_LABEL", -1);

    /**
     * Start
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_START_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_START_BUTTON_LABEL", -1);

    /**
     * State
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STATE_COLUMN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_STATE_COLUMN", -1);

    /**
     * Static group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STATIC_GROUP_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_STATIC_GROUP_ICON_DESCRIPTION", -1);

    /**
     * This utility can be used to display basic server information
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STATUS_CLI_USAGE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_STATUS_CLI_USAGE_DESCRIPTION", -1);

    /**
     * Stop
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_STOP_BUTTON_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_STOP_BUTTON_LABEL", -1);

    /**
     * Deleting Database Files outside the Installation Path...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_DELETING_EXTERNAL_DB_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_DELETING_EXTERNAL_DB_FILES", -1);

    /**
     * Deleting Log Files outside the Installation Path...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_DELETING_EXTERNAL_LOG_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_DELETING_EXTERNAL_LOG_FILES", -1);

    /**
     * Deleting External References...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_DELETING_EXTERNAL_REFERENCES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_DELETING_EXTERNAL_REFERENCES", -1);

    /**
     * Deleting Files under the Installation Path...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_DELETING_INSTALLATION_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_DELETING_INSTALLATION_FILES", -1);

    /**
     * Disabling Windows Service...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_DISABLING_WINDOWS_SERVICE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_DISABLING_WINDOWS_SERVICE", -1);

    /**
     * Removing references in remote servers...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNCONFIGURING_REPLICATION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNCONFIGURING_REPLICATION", -1);

    /**
     * <b>Uninstall Completed Successfully.</b>
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY", -1);

    /**
     * Uninstall Completed Successfully.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_CLI =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_CLI", -1);

    /**
     * <b>The Uninstall Completed Successfully.</b><br><br>To complete the uninstallation, you must delete manually the following files and directories:<br>%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_REMOVE_JARFILES =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_REMOVE_JARFILES", -1);

    /**
     * The Uninstall Completed Successfully.%nTo complete the uninstallation, you must delete manually the following files and directories:%n%s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_REMOVE_JARFILES_CLI =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_SUCCESSFULLY_REMOVE_JARFILES_CLI", -1);

    /**
     * An error occurred.  Check 'Details' text area for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR", -1);

    /**
     * <b>The Uninstall Succeeded With Warnings</b><br>The server was successfully uninstalled in the local machine but some error occurred deleting files.  Check 'Details' text area for more information about the files that caused the problem.<br><br>Verify that there is no other program using those files and delete them manually.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_DELETING =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_DELETING", -1);

    /**
     * The server was successfully uninstalled in the local machine but some error occurred deleting files.  Check 'Details' text area for more information about the files that caused the problem.%n%nVerify that there is no other program using those files and delete them manually.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_DELETING_CLI =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_DELETING_CLI", -1);

    /**
     * <b>The Uninstall Succeeded With Warnings</b><br>The server was successfully uninstalled in the local machine but some error occurred updating remote servers.  Check 'Details' text area for more information.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_ON_REMOTE =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_ON_REMOTE", -1);

    /**
     * The server was successfully uninstalled in the local machine but some error occurred updating remote servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_ON_REMOTE_CLI =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_FINISHED_WITH_ERROR_ON_REMOTE_CLI", -1);

    /**
     * Starting Uninstallation...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_SUMMARY_UNINSTALL_NOT_STARTED =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_SUMMARY_UNINSTALL_NOT_STARTED", -1);

    /**
     * ID of the tasks this task depends on [continue]:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_DEPENDENCIES_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_DEPENDENCIES_PROMPT", -1);

    /**
     * Which action must this task take if one if its dependent tasks fails?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_FAILED_DEPENDENCY_ACTION_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_FAILED_DEPENDENCY_ACTION_PROMPT", -1);

    /**
     * Has this task a dependency on another task?
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_HAS_DEPENDENCIES_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_HAS_DEPENDENCIES_PROMPT", -1);

    /**
     * Periodical schedule when the task must run (in crontab(5) format):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_RECURRING_SCHEDULE_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_RECURRING_SCHEDULE_PROMPT", -1);

    /**
     * Specify when the task '%s' will be launched.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_TASK_SCHEDULE_PROMPT =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_TASK_SCHEDULE_PROMPT", -1);

    /**
     * >>>> Specify task scheduling parameters
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_SCHEDULE_PROMPT_HEADER =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_SCHEDULE_PROMPT_HEADER", -1);

    /**
     * Launch date (in YYYYMMDDhhmmssZ or YYYYMMDDhhmmss format):
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_TASK_START_DATE_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_TASK_START_DATE_PROMPT", -1);

    /**
     * Specifies whether the uninstall should continue if there is an error updating references to this server in remote server instances or not.  This option can only be used with the %s no prompt option.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_UNINSTALLDS_DESCRIPTION_FORCE =
                    new LocalizableMessageDescriptor.Arg1<Object>(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_FORCE", -1);

    /**
     * Remove all components of the server (this option is not compatible with the rest of remove options)
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_ALL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_ALL", -1);

    /**
     * Remove backup files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_BACKUP_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_BACKUP_FILES", -1);

    /**
     * Remove configuration files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_CONFIGURATION_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_CONFIGURATION_FILES", -1);

    /**
     * Remove database contents
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_DATABASES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_DATABASES", -1);

    /**
     * Remove LDIF files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_LDIF_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_LDIF_FILES", -1);

    /**
     * Remove log files
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_LOG_FILES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_LOG_FILES", -1);

    /**
     * Remove Server Libraries and Administrative Tools
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALLDS_DESCRIPTION_REMOVE_SERVER_LIBRARIES =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALLDS_DESCRIPTION_REMOVE_SERVER_LIBRARIES", -1);

    /**
     * The name of this host (or IP address) as it is referenced in remote servers for replication
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_CLI_REFERENCED_HOSTNAME_PROMPT =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_CLI_REFERENCED_HOSTNAME_PROMPT", -1);

    /**
     * Do you want to provide authentication again?  (If you say no, the references to this server in other servers will not be removed).
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_CONFIRM_PROVIDE_AUTHENTICATION_AGAIN =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_CONFIRM_PROVIDE_AUTHENTICATION_AGAIN", -1);

    /**
     * Launching graphical uninstall...
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LAUNCHER_LAUNCHING_GUI =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LAUNCHER_LAUNCHING_GUI", -1);

    /**
     * This utility can be used to uninstall the Directory Server.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LAUNCHER_USAGE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LAUNCHER_USAGE_DESCRIPTION", -1);

    /**
     * Close this dialog and do not try to remove references of this server in other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_CANCEL_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_CANCEL_BUTTON_TOOLTIP", -1);

    /**
     * You must provide a Global Administrative User ID to be able to remove the references to this server in other servers.%nYou must also provide the name of this host (or IP address) as it is referenced in remote servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_DIALOG_MSG =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_DIALOG_MSG", -1);

    /**
     * Host Name:
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_HOST_NAME_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_HOST_NAME_LABEL", -1);

    /**
     * The name of this host (or IP address) as it is referenced in other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_HOST_NAME_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_HOST_NAME_TOOLTIP", -1);

    /**
     * Try to connect with the provided authentication.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_OK_BUTTON_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_OK_BUTTON_TOOLTIP", -1);

    /**
     * The password of the Global Administrator to be used to read and update configuration in other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_PWD_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_PWD_TOOLTIP", -1);

    /**
     * The Global Administrator User ID to be used to read and update configuration in other servers.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNINSTALL_LOGIN_UID_TOOLTIP =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNINSTALL_LOGIN_UID_TOOLTIP", -1);

    /**
     * --
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_UNKNOWN_LABEL =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_UNKNOWN_LABEL", -1);

    /**
     * Virtual static group
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_VIRTUAL_STATIC_GROUP_ICON_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_VIRTUAL_STATIC_GROUP_ICON_DESCRIPTION", -1);

    /**
     * Warning Icon.
     */
    public static final LocalizableMessageDescriptor.Arg0 INFO_WARNING_ICON_ACCESSIBLE_DESCRIPTION =
                    new LocalizableMessageDescriptor.Arg0(AdminToolMessages.class, RESOURCE, "INFO_WARNING_ICON_ACCESSIBLE_DESCRIPTION", -1);

    /**
     * The first server is already configured with replication port '%d'.  The provided replication server port '%d' has been ignored.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> WARN_FIRST_REPLICATION_SERVER_ALREADY_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "WARN_FIRST_REPLICATION_SERVER_ALREADY_CONFIGURED", -1);

    /**
     * The second server is already configured with replication port '%d'.  The provided replication server port '%d' has been ignored.
     */
    public static final LocalizableMessageDescriptor.Arg2<Number, Number> WARN_SECOND_REPLICATION_SERVER_ALREADY_CONFIGURED =
                    new LocalizableMessageDescriptor.Arg2<Number, Number>(AdminToolMessages.class, RESOURCE, "WARN_SECOND_REPLICATION_SERVER_ALREADY_CONFIGURED", -1);

}
