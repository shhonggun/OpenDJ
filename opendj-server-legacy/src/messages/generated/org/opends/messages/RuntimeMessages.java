package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.runtime}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/runtime.properties} and it should not be manually edited.
 */
public final class RuntimeMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.runtime";

    // Prevent instantiation.
    private RuntimeMessages() {
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
     * JAVA Version:            %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JAVA_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JAVA_VERSION_1", 1);

    /**
     * JAVA Vendor:             %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JAVA_VENDOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JAVA_VENDOR_2", 2);

    /**
     * JVM Version:             %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JVM_VERSION =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_VERSION_3", 3);

    /**
     * JVM Vendor:              %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JVM_VENDOR =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_VENDOR_4", 4);

    /**
     * JAVA Home:               %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JAVA_HOME =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JAVA_HOME_5", 5);

    /**
     * Class Path:              %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JAVA_CLASSPATH =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JAVA_CLASSPATH_6", 6);

    /**
     * Current Directory:       %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_CURRENT_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_CURRENT_DIRECTORY_8", 8);

    /**
     * Operating System:        %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_OPERATING_SYSTEM =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_OPERATING_SYSTEM_9", 9);

    /**
     * JVM Architecture:        %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JVM_ARCH =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_ARCH_10", 10);

    /**
     * System Name:             %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_SYSTEM_NAME =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_SYSTEM_NAME_11", 11);

    /**
     * Available Processors:    %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_AVAILABLE_PROCESSORS =
                    new LocalizableMessageDescriptor.Arg1<Number>(RuntimeMessages.class, RESOURCE, "NOTE_AVAILABLE_PROCESSORS_12", 12);

    /**
     * Max Available Memory:    %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_MAX_MEMORY =
                    new LocalizableMessageDescriptor.Arg1<Number>(RuntimeMessages.class, RESOURCE, "NOTE_MAX_MEMORY_13", 13);

    /**
     * Currently Used Memory:   %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_TOTAL_MEMORY =
                    new LocalizableMessageDescriptor.Arg1<Number>(RuntimeMessages.class, RESOURCE, "NOTE_TOTAL_MEMORY_14", 14);

    /**
     * Currently Free Memory:   %d
     */
    public static final LocalizableMessageDescriptor.Arg1<Number> NOTE_FREE_MEMORY =
                    new LocalizableMessageDescriptor.Arg1<Number>(RuntimeMessages.class, RESOURCE, "NOTE_FREE_MEMORY_15", 15);

    /**
     * JVM Information: %s by %s, %s architecture, %d bytes heap size
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number> NOTE_JVM_INFO =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Object, Number>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_INFO_17", 17);

    /**
     * JVM Host: %s, running %s, %d bytes physical memory size, number of processors available %d
     */
    public static final LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number> NOTE_JVM_HOST =
                    new LocalizableMessageDescriptor.Arg4<Object, Object, Number, Number>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_HOST_18", 18);

    /**
     * JVM Arguments: %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_JVM_ARGS =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_ARGS_19", 19);

    /**
     * JVM Host: %s, running %s, unknown physical memory size, number of processors available %d
     */
    public static final LocalizableMessageDescriptor.Arg3<Object, Object, Number> NOTE_JVM_HOST_WITH_UNKNOWN_PHYSICAL_MEM =
                    new LocalizableMessageDescriptor.Arg3<Object, Object, Number>(RuntimeMessages.class, RESOURCE, "NOTE_JVM_HOST_WITH_UNKNOWN_PHYSICAL_MEM_20", 20);

    /**
     * Installation Directory:  %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_INSTALL_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_INSTALL_DIRECTORY_21", 21);

    /**
     * Installation Directory:  unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_UNKNOWN_INSTALL_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg0(RuntimeMessages.class, RESOURCE, "NOTE_UNKNOWN_INSTALL_DIRECTORY_22", 22);

    /**
     * Instance Directory:      %s
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_INSTANCE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg1<Object>(RuntimeMessages.class, RESOURCE, "NOTE_INSTANCE_DIRECTORY_23", 23);

    /**
     * Instance Directory:      unknown
     */
    public static final LocalizableMessageDescriptor.Arg0 NOTE_UNKNOWN_INSTANCE_DIRECTORY =
                    new LocalizableMessageDescriptor.Arg0(RuntimeMessages.class, RESOURCE, "NOTE_UNKNOWN_INSTANCE_DIRECTORY_24", 24);

}
