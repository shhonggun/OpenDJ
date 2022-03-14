/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2008-2010 Sun Microsystems, Inc.
 * Portions Copyright 2011-2016 ForgeRock AS.
 */
package org.forgerock.opendj.maven.doc;

import static org.apache.maven.plugins.annotations.LifecyclePhase.*;
import static org.forgerock.opendj.maven.doc.DocsMessages.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarFile;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.forgerock.i18n.LocalizableMessage;

/** Generates an XML file of log messages found in properties files. */
@Mojo(name = "generate-xml-messages-doc", defaultPhase = PRE_SITE)
public class GenerateMessageFileMojo extends AbstractMojo {
    /** The Maven Project. */
    @Parameter(property = "project", readonly = true, required = true)
    private MavenProject project;
    /** The tag of the locale for which to generate the documentation. */
    @Parameter(defaultValue = "en")
    private String locale;

    /**
     * The path to the directory where the XML file should be written.
     * This path must be relative to ${project.build.directory}.
     */
    @Parameter(required = true)
    private String outputDirectory;

    /** A list which contains all file names, the extension is not needed. */
    @Parameter(required = true)
    private List<String> messageFileNames;
    /** One-line descriptions for log reference categories. */
    private static final Map<String, LocalizableMessage> CATEGORY_DESCRIPTIONS = new HashMap<>();
    static {
        CATEGORY_DESCRIPTIONS.put("ACCESS_CONTROL", CATEGORY_ACCESS_CONTROL.get());
        CATEGORY_DESCRIPTIONS.put("ADMIN", CATEGORY_ADMIN.get());
        CATEGORY_DESCRIPTIONS.put("ADMIN_TOOL", CATEGORY_ADMIN_TOOL.get());
        CATEGORY_DESCRIPTIONS.put("AUDIT", CATEGORY_AUDIT.get());
        CATEGORY_DESCRIPTIONS.put("BACKEND", CATEGORY_BACKEND.get());
        CATEGORY_DESCRIPTIONS.put("CONFIG", CATEGORY_CONFIG.get());
        CATEGORY_DESCRIPTIONS.put("CORE", CATEGORY_CORE.get());
        CATEGORY_DESCRIPTIONS.put("DSCONFIG", CATEGORY_DSCONFIG.get());
        CATEGORY_DESCRIPTIONS.put("EXTENSIONS", CATEGORY_EXTENSIONS.get());
        CATEGORY_DESCRIPTIONS.put("JVM", CATEGORY_JVM.get());
        CATEGORY_DESCRIPTIONS.put("LOG", CATEGORY_LOG.get());
        CATEGORY_DESCRIPTIONS.put("PLUGIN", CATEGORY_PLUGIN.get());
        CATEGORY_DESCRIPTIONS.put("PROTOCOL", CATEGORY_PROTOCOL.get());
        CATEGORY_DESCRIPTIONS.put("QUICKSETUP", CATEGORY_QUICKSETUP.get());
        CATEGORY_DESCRIPTIONS.put("RUNTIME_INFORMATION", CATEGORY_RUNTIME_INFORMATION.get());
        CATEGORY_DESCRIPTIONS.put("SCHEMA", CATEGORY_SCHEMA.get());
        CATEGORY_DESCRIPTIONS.put("SDK", CATEGORY_SDK.get());
        CATEGORY_DESCRIPTIONS.put("SYNC", CATEGORY_SYNC.get());
        CATEGORY_DESCRIPTIONS.put("TASK", CATEGORY_TASK.get());
        CATEGORY_DESCRIPTIONS.put("THIRD_PARTY", CATEGORY_THIRD_PARTY.get());
        CATEGORY_DESCRIPTIONS.put("TOOLS", CATEGORY_TOOLS.get());
        CATEGORY_DESCRIPTIONS.put("USER_DEFINED", CATEGORY_USER_DEFINED.get());
        CATEGORY_DESCRIPTIONS.put("UTIL", CATEGORY_UTIL.get());
        CATEGORY_DESCRIPTIONS.put("VERSION", CATEGORY_VERSION.get());
    }

    /** Message giving formatting rules for string keys. */
    public static final String KEY_FORM_MSG = ".\n\nOpenDJ message property keys must be of the form\n\n"
            + "\t\'[CATEGORY]_[SEVERITY]_[DESCRIPTION]_[ORDINAL]\'\n\n";
    private static final String ERROR_SEVERITY_IDENTIFIER_STRING = "ERR_";

    /** FreeMarker template configuration. */
    private Configuration configuration;

    private Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            configuration.setClassForTemplateLoading(GenerateSchemaDocMojo.class, "/templates");
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
        }
        return configuration;
    }

    /**
     * Writes the result of applying the FreeMarker template to the data.
     * @param file                  The file to write to.
     * @param template              The name of a file in {@code resources/templates/}.
     * @param map                   The data to use in the template.
     * @throws IOException          Failed to write to the file.
     * @throws TemplateException    Failed to load the template.
     */
    private void writeLogRef(final File file, final String template, final Map<String, Object> map)
            throws IOException, TemplateException {
        // FreeMarker requires a configuration to find the template.
        configuration = getConfiguration();

        // FreeMarker takes the data and a Writer to process the template.
        try (Writer writer = new PrintWriter(file)) {
            configuration.getTemplate(template).process(map, writer);
        }
    }

    /** Represents a log reference entry for an individual message. */
    private static class MessageRefEntry implements Comparable<MessageRefEntry> {
        private Integer ordinal;
        private String xmlId;
        private String formatString;

        /** Build log reference entry for an log message. */
        public MessageRefEntry(final String msgPropKey, final Integer ordinal, final String formatString) {
            this.formatString = formatString;
            this.ordinal = ordinal;
            xmlId = getXmlId(msgPropKey);
        }

        private String getXmlId(final String messagePropertyKey) {
            // XML IDs must be unique, must begin with a letter ([A-Za-z]),
            // and may be followed by any number of letters, digits ([0-9]),
            // hyphens ("-"), underscores ("_"), colons (":"), and periods (".").

            final String invalidChars = "[^A-Za-z0-9\\-_:\\.]";
            return messagePropertyKey.replaceAll(invalidChars, "-");
        }

        /**
         * Returns a map of this log reference entry, suitable for use with FreeMarker.
         * This implementation copies the message string verbatim.
         * @return A map of this log reference entry, suitable for use with FreeMarker.
         */
        public Map<String, Object> toMap() {
            Map<String, Object> map = new HashMap<>();
            String id = (ordinal != null) ? ordinal.toString() : MESSAGE_NO_ORDINAL.get().toString();
            map.put("xmlId", "log-ref-" + xmlId);
            map.put("id", MESSAGE_ORDINAL_ID.get(id));
            map.put("severity", MESSAGE_SEVERITY.get(ERROR_SEVERITY_PRINTABLE.get()));
            map.put("message", MESSAGE_MESSAGE.get(formatString));
            return map;
        }

        /**
         * Compare message entries by unique identifier.
         *
         * @return See {@link java.lang.Comparable#compareTo(Object)}.
         */
        @Override
        public int compareTo(MessageRefEntry mre) {
            if (this.ordinal != null && mre.ordinal != null) {
                return this.ordinal.compareTo(mre.ordinal);
            }
            return 0;
        }
    }

    /** Represents a log reference list of messages for a category. */
    private static class MessageRefCategory {
        private String category;
        private TreeSet<MessageRefEntry> messages;

        MessageRefCategory(final String category, final TreeSet<MessageRefEntry> messages) {
            this.category = category;
            this.messages = messages;
        }

        /**
         * Returns a map of this log reference category, suitable for use with FreeMarker.
         * @return A map of this log reference category, suitable for use with FreeMarker.
         */
        public Map<String, Object> toMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("id", category);
            map.put("category", MESSAGE_CATEGORY.get(category));
            List<Map<String, Object>> messageEntries = new LinkedList<>();
            for (MessageRefEntry entry : messages) {
                messageEntries.add(entry.toMap());
            }
            map.put("entries", messageEntries);
            return map;
        }
    }

    private static class MessagePropertyKey implements Comparable<MessagePropertyKey> {
        private String description;
        private Integer ordinal;

        /**
         * Creates a message property key from a string value.
         *
         * @param key
         *            from properties file
         * @return MessagePropertyKey created from string
         */
        public static MessagePropertyKey parseString(String key) {
            int li = key.lastIndexOf("_");
            if (li == -1) {
                throw new IllegalArgumentException("Incorrectly formatted key " + key);
            }

            final String description = key.substring(0, li).toUpperCase();
            Integer ordinal = null;
            try {
                String ordString = key.substring(li + 1);
                ordinal = Integer.parseInt(ordString);
            } catch (Exception nfe) {
                // Ignore exception, the message has no ordinal.
            }
            return new MessagePropertyKey(description, ordinal);
        }

        /**
         * Creates a parameterized instance.
         *
         * @param description
         *            of this key
         * @param ordinal
         *            of this key
         */
        public MessagePropertyKey(String description, Integer ordinal) {
            this.description = description;
            this.ordinal = ordinal;
        }

        /**
         * Gets the ordinal of this key.
         *
         * @return ordinal of this key
         */
        public Integer getOrdinal() {
            return this.ordinal;
        }

        @Override
        public String toString() {
            if (ordinal != null) {
                return description + "_" + ordinal;
            }
            return description;
        }

        @Override
        public int compareTo(MessagePropertyKey k) {
            if (ordinal == k.ordinal) {
                return description.compareTo(k.description);
            } else if (ordinal != null && k.ordinal != null) {
                return ordinal.compareTo(k.ordinal);
            } else {
                return 0;
            }
        }
    }

    /**
     * For maven exec plugin execution. Generates for all included message files
     * (sample.properties), a xml log ref file (log-ref-sample.xml)
     *
     * @throws MojoExecutionException
     *          if a problem occurs
     * @throws MojoFailureException
     *          if a problem occurs
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String projectBuildDir = project.getBuild().getDirectory();

        if (!outputDirectory.contains(projectBuildDir)) {
            String errorMsg = String.format("outputDirectory parameter (%s) must be included "
                    + "in ${project.build.directory} (%s)", outputDirectory, projectBuildDir);
            getLog().error(errorMsg);
            throw new MojoExecutionException(errorMsg);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("year", new SimpleDateFormat("yyyy").format(new Date()));
        map.put("lang", locale);
        map.put("title", LOG_REF_TITLE.get());
        map.put("indexterm", LOG_REF_INDEXTERM.get());
        map.put("intro", LOG_REF_INTRO.get());
        List<Map<String, Object>> categories = new LinkedList<>();
        for (String category : messageFileNames) {
            Map<String, Object> categoryMap = getCategoryMap(category);
            if (!categoryMap.isEmpty()) {   // Empty: no messages to document
                categories.add(getCategoryMap(category));
            }
        }
        map.put("categories", categories);
        File file = new File(outputDirectory, "log-message-reference.xml");
        try {
            createOutputDirectory();
            writeLogRef(file, "log-message-reference.ftl", map);
        } catch (Exception e) {
            throw new MojoFailureException(e.getMessage(), e);
        }
    }

    private void createOutputDirectory() throws IOException {
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            throw new IOException("Failed to create output directory.");
        }
    }

    private Map<String, Object> getCategoryMap(final String category) throws MojoExecutionException {
        Properties properties = new Properties();
        try {
            properties.load(loadPropertiesFromJar(category));
            Map<MessagePropertyKey, String> errorMessages = loadErrorProperties(properties);
            TreeSet<MessageRefEntry> messageRefEntries = new TreeSet<>();
            Set<Integer> usedOrdinals = new HashSet<>();

            for (MessagePropertyKey msgKey : errorMessages.keySet()) {
                String formatString = errorMessages.get(msgKey).replaceAll("<", "&lt;");
                Integer ordinal = msgKey.getOrdinal();
                if (ordinal != null && usedOrdinals.contains(ordinal)) {
                    throw new Exception("The ordinal value \'" + ordinal + "\' in key " + msgKey
                            + " has been previously defined in " + category + KEY_FORM_MSG);
                }
                usedOrdinals.add(ordinal);
                messageRefEntries.add(new MessageRefEntry(msgKey.toString(), ordinal, formatString));
            }

            return messageRefEntries.isEmpty()
                    ? new HashMap<String, Object>()
                    : new MessageRefCategory(category.toUpperCase(), messageRefEntries).toMap();
        } catch (Exception e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    private InputStream loadPropertiesFromJar(final String category) throws IOException {
        getLog().debug("category: " + category);
        final JarFile jarFile = new JarFile(
                Paths.get(project.getBuild().getDirectory(), "opendj", "lib", "opendj.jar").toString());
        return jarFile.getInputStream(jarFile.getJarEntry(
                Paths.get("org", "opends", "messages", category + ".properties").toString()));
    }

    private Map<MessagePropertyKey, String> loadErrorProperties(Properties properties) throws Exception {
        Map<MessagePropertyKey, String> errorMessage = new TreeMap<>();
        for (Object propO : properties.keySet()) {
            String propKey = propO.toString();
            try {
                // Document only ERROR messages.
                if (propKey.startsWith(ERROR_SEVERITY_IDENTIFIER_STRING)) {
                    MessagePropertyKey key = MessagePropertyKey.parseString(propKey);
                    String formatString = properties.getProperty(propKey);
                    errorMessage.put(key, formatString);
                }
            } catch (IllegalArgumentException iae) {
                throw new Exception("invalid property key " + propKey + ": " + iae.getMessage() + KEY_FORM_MSG, iae);
            }
        }

        return errorMessage;
    }
}
