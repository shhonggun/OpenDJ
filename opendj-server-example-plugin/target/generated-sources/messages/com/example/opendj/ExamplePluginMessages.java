package com.example.opendj;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code com.example.opendj.example_plugin}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code com/example/opendj/example_plugin.properties} and it should not be manually edited.
 */
public final class ExamplePluginMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "com.example.opendj.example_plugin";

    // Prevent instantiation.
    private ExamplePluginMessages() {
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
     * "Invalid plugin type %s for the example plugin.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> ERR_INITIALIZE_PLUGIN =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExamplePluginMessages.class, RESOURCE, "ERR_INITIALIZE_PLUGIN_1", 1);

    /**
     * Example plugin message '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> NOTE_DO_STARTUP =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExamplePluginMessages.class, RESOURCE, "NOTE_DO_STARTUP_2", 2);

    /**
     * "Example plugin message has been changed from '%s' to '%s'.
     */
    public static final LocalizableMessageDescriptor.Arg2<Object, Object> NOTE_APPLY_CONFIGURATION_CHANGE =
                    new LocalizableMessageDescriptor.Arg2<Object, Object>(ExamplePluginMessages.class, RESOURCE, "NOTE_APPLY_CONFIGURATION_CHANGE_3", 3);

}
