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
 * Copyright 2008 Sun Microsystems, Inc.
 */
package org.forgerock.opendj.server.config.meta;



import java.util.Collection;
import java.util.SortedSet;
import org.forgerock.opendj.config.AdministratorAction;
import org.forgerock.opendj.config.AliasDefaultBehaviorProvider;
import org.forgerock.opendj.config.AttributeTypePropertyDefinition;
import org.forgerock.opendj.config.BooleanPropertyDefinition;
import org.forgerock.opendj.config.ClassPropertyDefinition;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.ManagedObject;
import org.forgerock.opendj.config.client.MissingMandatoryPropertiesException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefaultBehaviorProvider;
import org.forgerock.opendj.config.DefinedDefaultBehaviorProvider;
import org.forgerock.opendj.config.ManagedObjectAlreadyExistsException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.PropertyOption;
import org.forgerock.opendj.config.PropertyProvider;
import org.forgerock.opendj.config.server.ConfigurationChangeListener;
import org.forgerock.opendj.config.server.ServerManagedObject;
import org.forgerock.opendj.config.StringPropertyDefinition;
import org.forgerock.opendj.config.Tag;
import org.forgerock.opendj.config.UndefinedDefaultBehaviorProvider;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.ldap.schema.AttributeType;
import org.forgerock.opendj.server.config.client.SMTPAccountStatusNotificationHandlerCfgClient;
import org.forgerock.opendj.server.config.server.AccountStatusNotificationHandlerCfg;
import org.forgerock.opendj.server.config.server.SMTPAccountStatusNotificationHandlerCfg;



/**
 * An interface for querying the SMTP Account Status Notification
 * Handler managed object definition meta information.
 * <p>
 * The SMTP Account Status Notification Handler is a notification
 * handler that sends email messages to end users and/or administrators
 * whenever an account status notification is generated.
 */
public final class SMTPAccountStatusNotificationHandlerCfgDefn extends ManagedObjectDefinition<SMTPAccountStatusNotificationHandlerCfgClient, SMTPAccountStatusNotificationHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final SMTPAccountStatusNotificationHandlerCfgDefn INSTANCE = new SMTPAccountStatusNotificationHandlerCfgDefn();



  /** The "email-address-attribute-type" property definition. */
  private static final AttributeTypePropertyDefinition PD_EMAIL_ADDRESS_ATTRIBUTE_TYPE;



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "message-subject" property definition. */
  private static final StringPropertyDefinition PD_MESSAGE_SUBJECT;



  /** The "message-template-file" property definition. */
  private static final StringPropertyDefinition PD_MESSAGE_TEMPLATE_FILE;



  /** The "recipient-address" property definition. */
  private static final StringPropertyDefinition PD_RECIPIENT_ADDRESS;



  /** The "send-email-as-html" property definition. */
  private static final BooleanPropertyDefinition PD_SEND_EMAIL_AS_HTML;



  /** The "sender-address" property definition. */
  private static final StringPropertyDefinition PD_SENDER_ADDRESS;



  /** The "send-message-without-end-user-address" property definition. */
  private static final BooleanPropertyDefinition PD_SEND_MESSAGE_WITHOUT_END_USER_ADDRESS;



  /** Build the "email-address-attribute-type" property definition. */
  static {
      AttributeTypePropertyDefinition.Builder builder = AttributeTypePropertyDefinition.createBuilder(INSTANCE, "email-address-attribute-type");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "email-address-attribute-type"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<AttributeType>(INSTANCE, "email-address-attribute-type"));
      PD_EMAIL_ADDRESS_ATTRIBUTE_TYPE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_EMAIL_ADDRESS_ATTRIBUTE_TYPE);
  }



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SMTPAccountStatusNotificationHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AccountStatusNotificationHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "message-subject" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "message-subject");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "message-subject"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MESSAGE_SUBJECT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MESSAGE_SUBJECT);
  }



  /** Build the "message-template-file" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "message-template-file");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "message-template-file"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MESSAGE_TEMPLATE_FILE = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MESSAGE_TEMPLATE_FILE);
  }



  /** Build the "recipient-address" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "recipient-address");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "recipient-address"));
      builder.setDefaultBehaviorProvider(new AliasDefaultBehaviorProvider<String>(INSTANCE, "recipient-address"));
      PD_RECIPIENT_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RECIPIENT_ADDRESS);
  }



  /** Build the "send-email-as-html" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "send-email-as-html");
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "send-email-as-html"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("false");
      builder.setDefaultBehaviorProvider(provider);
      PD_SEND_EMAIL_AS_HTML = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SEND_EMAIL_AS_HTML);
  }



  /** Build the "sender-address" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "sender-address");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "sender-address"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_SENDER_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SENDER_ADDRESS);
  }



  /** Build the "send-message-without-end-user-address" property definition. */
  static {
      BooleanPropertyDefinition.Builder builder = BooleanPropertyDefinition.createBuilder(INSTANCE, "send-message-without-end-user-address");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "send-message-without-end-user-address"));
      DefaultBehaviorProvider<Boolean> provider = new DefinedDefaultBehaviorProvider<Boolean>("true");
      builder.setDefaultBehaviorProvider(provider);
      PD_SEND_MESSAGE_WITHOUT_END_USER_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_SEND_MESSAGE_WITHOUT_END_USER_ADDRESS);
  }



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("user-management"));
  }



  /**
   * Get the SMTP Account Status Notification Handler configuration
   * definition singleton.
   *
   * @return Returns the SMTP Account Status Notification Handler
   *         configuration definition singleton.
   */
  public static SMTPAccountStatusNotificationHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SMTPAccountStatusNotificationHandlerCfgDefn() {
    super("smtp-account-status-notification-handler", AccountStatusNotificationHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SMTPAccountStatusNotificationHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends SMTPAccountStatusNotificationHandlerCfgClient> impl) {
    return new SMTPAccountStatusNotificationHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SMTPAccountStatusNotificationHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends SMTPAccountStatusNotificationHandlerCfg> impl) {
    return new SMTPAccountStatusNotificationHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SMTPAccountStatusNotificationHandlerCfg> getServerConfigurationClass() {
    return SMTPAccountStatusNotificationHandlerCfg.class;
  }



  /**
   * Get the "email-address-attribute-type" property definition.
   * <p>
   * Specifies which attribute in the user's entries may be used to
   * obtain the email address when notifying the end user.
   * <p>
   * You can specify more than one email address as separate values.
   * In this case, the OpenDJ server sends a notification to all email
   * addresses identified.
   *
   * @return Returns the "email-address-attribute-type" property definition.
   */
  public AttributeTypePropertyDefinition getEmailAddressAttributeTypePropertyDefinition() {
    return PD_EMAIL_ADDRESS_ATTRIBUTE_TYPE;
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SMTP Account Status Notification Handler is
   * enabled. Only enabled handlers are invoked whenever a related
   * event occurs in the server.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AccountStatusNotificationHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SMTP Account Status Notification Handler
   * implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "message-subject" property definition.
   * <p>
   * Specifies the subject that should be used for email messages
   * generated by this account status notification handler.
   * <p>
   * The values for this property should begin with the name of an
   * account status notification type followed by a colon and the
   * subject that should be used for the associated notification
   * message. If an email message is generated for an account status
   * notification type for which no subject is defined, then that
   * message is given a generic subject.
   *
   * @return Returns the "message-subject" property definition.
   */
  public StringPropertyDefinition getMessageSubjectPropertyDefinition() {
    return PD_MESSAGE_SUBJECT;
  }



  /**
   * Get the "message-template-file" property definition.
   * <p>
   * Specifies the path to the file containing the message template to
   * generate the email notification messages.
   * <p>
   * The values for this property should begin with the name of an
   * account status notification type followed by a colon and the path
   * to the template file that should be used for that notification
   * type. If an account status notification has a notification type
   * that is not associated with a message template file, then no email
   * message is generated for that notification.
   *
   * @return Returns the "message-template-file" property definition.
   */
  public StringPropertyDefinition getMessageTemplateFilePropertyDefinition() {
    return PD_MESSAGE_TEMPLATE_FILE;
  }



  /**
   * Get the "recipient-address" property definition.
   * <p>
   * Specifies an email address to which notification messages are
   * sent, either instead of or in addition to the end user for whom
   * the notification has been generated.
   * <p>
   * This may be used to ensure that server administrators also
   * receive a copy of any notification messages that are generated.
   *
   * @return Returns the "recipient-address" property definition.
   */
  public StringPropertyDefinition getRecipientAddressPropertyDefinition() {
    return PD_RECIPIENT_ADDRESS;
  }



  /**
   * Get the "send-email-as-html" property definition.
   * <p>
   * Indicates whether an email notification message should be sent as
   * HTML.
   * <p>
   * If this value is true, email notification messages are marked as
   * text/html. Otherwise outgoing email messages are assumed to be
   * plaintext and marked as text/plain.
   *
   * @return Returns the "send-email-as-html" property definition.
   */
  public BooleanPropertyDefinition getSendEmailAsHtmlPropertyDefinition() {
    return PD_SEND_EMAIL_AS_HTML;
  }



  /**
   * Get the "sender-address" property definition.
   * <p>
   * Specifies the email address from which the message is sent. Note
   * that this does not necessarily have to be a legitimate email
   * address.
   *
   * @return Returns the "sender-address" property definition.
   */
  public StringPropertyDefinition getSenderAddressPropertyDefinition() {
    return PD_SENDER_ADDRESS;
  }



  /**
   * Get the "send-message-without-end-user-address" property definition.
   * <p>
   * Indicates whether an email notification message should be
   * generated and sent to the set of notification recipients even if
   * the user entry does not contain any values for any of the email
   * address attributes (that is, in cases when it is not be possible
   * to notify the end user).
   * <p>
   * This is only applicable if both one or more email address
   * attribute types and one or more additional recipient addresses are
   * specified.
   *
   * @return Returns the "send-message-without-end-user-address" property definition.
   */
  public BooleanPropertyDefinition getSendMessageWithoutEndUserAddressPropertyDefinition() {
    return PD_SEND_MESSAGE_WITHOUT_END_USER_ADDRESS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SMTPAccountStatusNotificationHandlerCfgClientImpl implements
    SMTPAccountStatusNotificationHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SMTPAccountStatusNotificationHandlerCfgClient> impl;



    /** Private constructor. */
    private SMTPAccountStatusNotificationHandlerCfgClientImpl(
        ManagedObject<? extends SMTPAccountStatusNotificationHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getEmailAddressAttributeType() {
      return impl.getPropertyValues(INSTANCE.getEmailAddressAttributeTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEmailAddressAttributeType(Collection<AttributeType> values) {
      impl.setPropertyValues(INSTANCE.getEmailAddressAttributeTypePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public Boolean isEnabled() {
      return impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabled(boolean value) {
      impl.setPropertyValue(INSTANCE.getEnabledPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setJavaClass(String value) {
      impl.setPropertyValue(INSTANCE.getJavaClassPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getMessageSubject() {
      return impl.getPropertyValues(INSTANCE.getMessageSubjectPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMessageSubject(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getMessageSubjectPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getMessageTemplateFile() {
      return impl.getPropertyValues(INSTANCE.getMessageTemplateFilePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMessageTemplateFile(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getMessageTemplateFilePropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRecipientAddress() {
      return impl.getPropertyValues(INSTANCE.getRecipientAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setRecipientAddress(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getRecipientAddressPropertyDefinition(), values);
    }



    /** {@inheritDoc} */
    public boolean isSendEmailAsHtml() {
      return impl.getPropertyValue(INSTANCE.getSendEmailAsHtmlPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSendEmailAsHtml(Boolean value) {
      impl.setPropertyValue(INSTANCE.getSendEmailAsHtmlPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getSenderAddress() {
      return impl.getPropertyValue(INSTANCE.getSenderAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSenderAddress(String value) {
      impl.setPropertyValue(INSTANCE.getSenderAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public boolean isSendMessageWithoutEndUserAddress() {
      return impl.getPropertyValue(INSTANCE.getSendMessageWithoutEndUserAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSendMessageWithoutEndUserAddress(boolean value) {
      impl.setPropertyValue(INSTANCE.getSendMessageWithoutEndUserAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SMTPAccountStatusNotificationHandlerCfgClient, ? extends SMTPAccountStatusNotificationHandlerCfg> definition() {
      return INSTANCE;
    }



    /** {@inheritDoc} */
    public PropertyProvider properties() {
      return impl;
    }



    /** {@inheritDoc} */
    public void commit() throws ManagedObjectAlreadyExistsException,
        MissingMandatoryPropertiesException, ConcurrentModificationException,
        OperationRejectedException, LdapException {
      impl.commit();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }



  /**
   * Managed object server implementation.
   */
  private static class SMTPAccountStatusNotificationHandlerCfgServerImpl implements
    SMTPAccountStatusNotificationHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SMTPAccountStatusNotificationHandlerCfg> impl;

    /** The value of the "email-address-attribute-type" property. */
    private final SortedSet<AttributeType> pEmailAddressAttributeType;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "message-subject" property. */
    private final SortedSet<String> pMessageSubject;

    /** The value of the "message-template-file" property. */
    private final SortedSet<String> pMessageTemplateFile;

    /** The value of the "recipient-address" property. */
    private final SortedSet<String> pRecipientAddress;

    /** The value of the "send-email-as-html" property. */
    private final boolean pSendEmailAsHtml;

    /** The value of the "sender-address" property. */
    private final String pSenderAddress;

    /** The value of the "send-message-without-end-user-address" property. */
    private final boolean pSendMessageWithoutEndUserAddress;



    /** Private constructor. */
    private SMTPAccountStatusNotificationHandlerCfgServerImpl(ServerManagedObject<? extends SMTPAccountStatusNotificationHandlerCfg> impl) {
      this.impl = impl;
      this.pEmailAddressAttributeType = impl.getPropertyValues(INSTANCE.getEmailAddressAttributeTypePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMessageSubject = impl.getPropertyValues(INSTANCE.getMessageSubjectPropertyDefinition());
      this.pMessageTemplateFile = impl.getPropertyValues(INSTANCE.getMessageTemplateFilePropertyDefinition());
      this.pRecipientAddress = impl.getPropertyValues(INSTANCE.getRecipientAddressPropertyDefinition());
      this.pSendEmailAsHtml = impl.getPropertyValue(INSTANCE.getSendEmailAsHtmlPropertyDefinition());
      this.pSenderAddress = impl.getPropertyValue(INSTANCE.getSenderAddressPropertyDefinition());
      this.pSendMessageWithoutEndUserAddress = impl.getPropertyValue(INSTANCE.getSendMessageWithoutEndUserAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSMTPChangeListener(
        ConfigurationChangeListener<SMTPAccountStatusNotificationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSMTPChangeListener(
        ConfigurationChangeListener<SMTPAccountStatusNotificationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AccountStatusNotificationHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AccountStatusNotificationHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<AttributeType> getEmailAddressAttributeType() {
      return pEmailAddressAttributeType;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getMessageSubject() {
      return pMessageSubject;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getMessageTemplateFile() {
      return pMessageTemplateFile;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRecipientAddress() {
      return pRecipientAddress;
    }



    /** {@inheritDoc} */
    public boolean isSendEmailAsHtml() {
      return pSendEmailAsHtml;
    }



    /** {@inheritDoc} */
    public String getSenderAddress() {
      return pSenderAddress;
    }



    /** {@inheritDoc} */
    public boolean isSendMessageWithoutEndUserAddress() {
      return pSendMessageWithoutEndUserAddress;
    }



    /** {@inheritDoc} */
    public Class<? extends SMTPAccountStatusNotificationHandlerCfg> configurationClass() {
      return SMTPAccountStatusNotificationHandlerCfg.class;
    }



    /** {@inheritDoc} */
    public DN dn() {
      return impl.getDN();
    }



    /** {@inheritDoc} */
    public String name() {
      return impl.getName();
    }



    /** {@inheritDoc} */
    public String toString() {
      return impl.toString();
    }
  }
}
