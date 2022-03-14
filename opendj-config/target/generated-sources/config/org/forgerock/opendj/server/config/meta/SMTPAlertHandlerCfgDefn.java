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
import org.forgerock.opendj.server.config.client.SMTPAlertHandlerCfgClient;
import org.forgerock.opendj.server.config.server.AlertHandlerCfg;
import org.forgerock.opendj.server.config.server.SMTPAlertHandlerCfg;



/**
 * An interface for querying the SMTP Alert Handler managed object
 * definition meta information.
 * <p>
 * The SMTP Alert Handler may be used to send e-mail messages to
 * notify administrators of significant events that occur within the
 * server.
 */
public final class SMTPAlertHandlerCfgDefn extends ManagedObjectDefinition<SMTPAlertHandlerCfgClient, SMTPAlertHandlerCfg> {

  /** The singleton configuration definition instance. */
  private static final SMTPAlertHandlerCfgDefn INSTANCE = new SMTPAlertHandlerCfgDefn();



  /** The "java-class" property definition. */
  private static final ClassPropertyDefinition PD_JAVA_CLASS;



  /** The "message-body" property definition. */
  private static final StringPropertyDefinition PD_MESSAGE_BODY;



  /** The "message-subject" property definition. */
  private static final StringPropertyDefinition PD_MESSAGE_SUBJECT;



  /** The "recipient-address" property definition. */
  private static final StringPropertyDefinition PD_RECIPIENT_ADDRESS;



  /** The "sender-address" property definition. */
  private static final StringPropertyDefinition PD_SENDER_ADDRESS;



  /** Build the "java-class" property definition. */
  static {
      ClassPropertyDefinition.Builder builder = ClassPropertyDefinition.createBuilder(INSTANCE, "java-class");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setOption(PropertyOption.ADVANCED);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.COMPONENT_RESTART, INSTANCE, "java-class"));
      DefaultBehaviorProvider<String> provider = new DefinedDefaultBehaviorProvider<String>("org.opends.server.extensions.SMTPAlertHandler");
      builder.setDefaultBehaviorProvider(provider);
      builder.addInstanceOf("org.opends.server.api.AlertHandler");
      PD_JAVA_CLASS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_JAVA_CLASS);
  }



  /** Build the "message-body" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "message-body");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "message-body"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MESSAGE_BODY = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MESSAGE_BODY);
  }



  /** Build the "message-subject" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "message-subject");
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "message-subject"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_MESSAGE_SUBJECT = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_MESSAGE_SUBJECT);
  }



  /** Build the "recipient-address" property definition. */
  static {
      StringPropertyDefinition.Builder builder = StringPropertyDefinition.createBuilder(INSTANCE, "recipient-address");
      builder.setOption(PropertyOption.MULTI_VALUED);
      builder.setOption(PropertyOption.MANDATORY);
      builder.setAdministratorAction(new AdministratorAction(AdministratorAction.Type.NONE, INSTANCE, "recipient-address"));
      builder.setDefaultBehaviorProvider(new UndefinedDefaultBehaviorProvider<String>());
      PD_RECIPIENT_ADDRESS = builder.getInstance();
      INSTANCE.registerPropertyDefinition(PD_RECIPIENT_ADDRESS);
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



  // Register the tags associated with this managed object definition.
  static {
    INSTANCE.registerTag(Tag.valueOf("core-server"));
  }



  /**
   * Get the SMTP Alert Handler configuration definition singleton.
   *
   * @return Returns the SMTP Alert Handler configuration definition
   *         singleton.
   */
  public static SMTPAlertHandlerCfgDefn getInstance() {
    return INSTANCE;
  }



  /**
   * Private constructor.
   */
  private SMTPAlertHandlerCfgDefn() {
    super("smtp-alert-handler", AlertHandlerCfgDefn.getInstance());
  }



  /** {@inheritDoc} */
  public SMTPAlertHandlerCfgClient createClientConfiguration(
      ManagedObject<? extends SMTPAlertHandlerCfgClient> impl) {
    return new SMTPAlertHandlerCfgClientImpl(impl);
  }



  /** {@inheritDoc} */
  public SMTPAlertHandlerCfg createServerConfiguration(
      ServerManagedObject<? extends SMTPAlertHandlerCfg> impl) {
    return new SMTPAlertHandlerCfgServerImpl(impl);
  }



  /** {@inheritDoc} */
  public Class<SMTPAlertHandlerCfg> getServerConfigurationClass() {
    return SMTPAlertHandlerCfg.class;
  }



  /**
   * Get the "disabled-alert-type" property definition.
   * <p>
   * Specifies the names of the alert types that are disabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then no alerts with
   * any of the specified types are allowed. If there are no values for
   * this attribute, then only alerts with a type included in the set
   * of enabled alert types are allowed, or if there are no values for
   * the enabled alert types option, then all alert types are allowed.
   *
   * @return Returns the "disabled-alert-type" property definition.
   */
  public StringPropertyDefinition getDisabledAlertTypePropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getDisabledAlertTypePropertyDefinition();
  }



  /**
   * Get the "enabled" property definition.
   * <p>
   * Indicates whether the SMTP Alert Handler is enabled.
   *
   * @return Returns the "enabled" property definition.
   */
  public BooleanPropertyDefinition getEnabledPropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getEnabledPropertyDefinition();
  }



  /**
   * Get the "enabled-alert-type" property definition.
   * <p>
   * Specifies the names of the alert types that are enabled for this
   * alert handler.
   * <p>
   * If there are any values for this attribute, then only alerts with
   * one of the specified types are allowed (unless they are also
   * included in the disabled alert types). If there are no values for
   * this attribute, then any alert with a type not included in the
   * list of disabled alert types is allowed.
   *
   * @return Returns the "enabled-alert-type" property definition.
   */
  public StringPropertyDefinition getEnabledAlertTypePropertyDefinition() {
    return AlertHandlerCfgDefn.getInstance().getEnabledAlertTypePropertyDefinition();
  }



  /**
   * Get the "java-class" property definition.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the SMTP Alert Handler implementation.
   *
   * @return Returns the "java-class" property definition.
   */
  public ClassPropertyDefinition getJavaClassPropertyDefinition() {
    return PD_JAVA_CLASS;
  }



  /**
   * Get the "message-body" property definition.
   * <p>
   * Specifies the body that should be used for email messages
   * generated by this alert handler.
   * <p>
   * The token "%%%%alert-type%%%%" is dynamically replaced with the
   * alert type string. The token "%%%%alert-id%%%%" is dynamically
   * replaced with the alert ID value. The token
   * "%%%%alert-message%%%%" is dynamically replaced with the alert
   * message. The token "\\n" is replaced with an end-of-line marker.
   *
   * @return Returns the "message-body" property definition.
   */
  public StringPropertyDefinition getMessageBodyPropertyDefinition() {
    return PD_MESSAGE_BODY;
  }



  /**
   * Get the "message-subject" property definition.
   * <p>
   * Specifies the subject that should be used for email messages
   * generated by this alert handler.
   * <p>
   * The token "%%%%alert-type%%%%" is dynamically replaced with the
   * alert type string. The token "%%%%alert-id%%%%" is dynamically
   * replaced with the alert ID value. The token
   * "%%%%alert-message%%%%" is dynamically replaced with the alert
   * message. The token "\\n" is replaced with an end-of-line marker.
   *
   * @return Returns the "message-subject" property definition.
   */
  public StringPropertyDefinition getMessageSubjectPropertyDefinition() {
    return PD_MESSAGE_SUBJECT;
  }



  /**
   * Get the "recipient-address" property definition.
   * <p>
   * Specifies an email address to which the messages should be sent.
   * <p>
   * Multiple values may be provided if there should be more than one
   * recipient.
   *
   * @return Returns the "recipient-address" property definition.
   */
  public StringPropertyDefinition getRecipientAddressPropertyDefinition() {
    return PD_RECIPIENT_ADDRESS;
  }



  /**
   * Get the "sender-address" property definition.
   * <p>
   * Specifies the email address to use as the sender for messages
   * generated by this alert handler.
   *
   * @return Returns the "sender-address" property definition.
   */
  public StringPropertyDefinition getSenderAddressPropertyDefinition() {
    return PD_SENDER_ADDRESS;
  }



  /**
   * Managed object client implementation.
   */
  private static class SMTPAlertHandlerCfgClientImpl implements
    SMTPAlertHandlerCfgClient {

    /** Private implementation. */
    private ManagedObject<? extends SMTPAlertHandlerCfgClient> impl;



    /** Private constructor. */
    private SMTPAlertHandlerCfgClientImpl(
        ManagedObject<? extends SMTPAlertHandlerCfgClient> impl) {
      this.impl = impl;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledAlertType() {
      return impl.getPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setDisabledAlertType(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition(), values);
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
    public SortedSet<String> getEnabledAlertType() {
      return impl.getPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setEnabledAlertType(Collection<String> values) {
      impl.setPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition(), values);
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
    public String getMessageBody() {
      return impl.getPropertyValue(INSTANCE.getMessageBodyPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMessageBody(String value) {
      impl.setPropertyValue(INSTANCE.getMessageBodyPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public String getMessageSubject() {
      return impl.getPropertyValue(INSTANCE.getMessageSubjectPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setMessageSubject(String value) {
      impl.setPropertyValue(INSTANCE.getMessageSubjectPropertyDefinition(), value);
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
    public String getSenderAddress() {
      return impl.getPropertyValue(INSTANCE.getSenderAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void setSenderAddress(String value) {
      impl.setPropertyValue(INSTANCE.getSenderAddressPropertyDefinition(), value);
    }



    /** {@inheritDoc} */
    public ManagedObjectDefinition<? extends SMTPAlertHandlerCfgClient, ? extends SMTPAlertHandlerCfg> definition() {
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
  private static class SMTPAlertHandlerCfgServerImpl implements
    SMTPAlertHandlerCfg {

    /** Private implementation. */
    private ServerManagedObject<? extends SMTPAlertHandlerCfg> impl;

    /** The value of the "disabled-alert-type" property. */
    private final SortedSet<String> pDisabledAlertType;

    /** The value of the "enabled" property. */
    private final boolean pEnabled;

    /** The value of the "enabled-alert-type" property. */
    private final SortedSet<String> pEnabledAlertType;

    /** The value of the "java-class" property. */
    private final String pJavaClass;

    /** The value of the "message-body" property. */
    private final String pMessageBody;

    /** The value of the "message-subject" property. */
    private final String pMessageSubject;

    /** The value of the "recipient-address" property. */
    private final SortedSet<String> pRecipientAddress;

    /** The value of the "sender-address" property. */
    private final String pSenderAddress;



    /** Private constructor. */
    private SMTPAlertHandlerCfgServerImpl(ServerManagedObject<? extends SMTPAlertHandlerCfg> impl) {
      this.impl = impl;
      this.pDisabledAlertType = impl.getPropertyValues(INSTANCE.getDisabledAlertTypePropertyDefinition());
      this.pEnabled = impl.getPropertyValue(INSTANCE.getEnabledPropertyDefinition());
      this.pEnabledAlertType = impl.getPropertyValues(INSTANCE.getEnabledAlertTypePropertyDefinition());
      this.pJavaClass = impl.getPropertyValue(INSTANCE.getJavaClassPropertyDefinition());
      this.pMessageBody = impl.getPropertyValue(INSTANCE.getMessageBodyPropertyDefinition());
      this.pMessageSubject = impl.getPropertyValue(INSTANCE.getMessageSubjectPropertyDefinition());
      this.pRecipientAddress = impl.getPropertyValues(INSTANCE.getRecipientAddressPropertyDefinition());
      this.pSenderAddress = impl.getPropertyValue(INSTANCE.getSenderAddressPropertyDefinition());
    }



    /** {@inheritDoc} */
    public void addSMTPChangeListener(
        ConfigurationChangeListener<SMTPAlertHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeSMTPChangeListener(
        ConfigurationChangeListener<SMTPAlertHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }
    /** {@inheritDoc} */
    public void addChangeListener(
        ConfigurationChangeListener<AlertHandlerCfg> listener) {
      impl.registerChangeListener(listener);
    }



    /** {@inheritDoc} */
    public void removeChangeListener(
        ConfigurationChangeListener<AlertHandlerCfg> listener) {
      impl.deregisterChangeListener(listener);
    }



    /** {@inheritDoc} */
    public SortedSet<String> getDisabledAlertType() {
      return pDisabledAlertType;
    }



    /** {@inheritDoc} */
    public boolean isEnabled() {
      return pEnabled;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getEnabledAlertType() {
      return pEnabledAlertType;
    }



    /** {@inheritDoc} */
    public String getJavaClass() {
      return pJavaClass;
    }



    /** {@inheritDoc} */
    public String getMessageBody() {
      return pMessageBody;
    }



    /** {@inheritDoc} */
    public String getMessageSubject() {
      return pMessageSubject;
    }



    /** {@inheritDoc} */
    public SortedSet<String> getRecipientAddress() {
      return pRecipientAddress;
    }



    /** {@inheritDoc} */
    public String getSenderAddress() {
      return pSenderAddress;
    }



    /** {@inheritDoc} */
    public Class<? extends SMTPAlertHandlerCfg> configurationClass() {
      return SMTPAlertHandlerCfg.class;
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
