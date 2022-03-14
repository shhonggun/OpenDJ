package org.opends.messages;

import org.forgerock.i18n.LocalizableMessageDescriptor;

/**
 * This file contains localizable message descriptors having the resource
 * name {@code org.opends.messages.external}. This file was generated
 * automatically by the {@code i18n-maven-plugin} from the property file
 * {@code org/opends/messages/external.properties} and it should not be manually edited.
 */
public final class ExternalMessages {
    // The name of the resource bundle.
    private static final String RESOURCE = "org.opends.messages.external";

    // Prevent instantiation.
    private ExternalMessages() {
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
     */
    public static final LocalizableMessageDescriptor.Arg1<Object> INFO_EXTERNAL_LIB_MESSAGE =
                    new LocalizableMessageDescriptor.Arg1<Object>(ExternalMessages.class, RESOURCE, "INFO_EXTERNAL_LIB_MESSAGE_1", 1);

}
