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
package org.forgerock.opendj.server.config.client;



import java.util.Collection;
import org.forgerock.opendj.config.client.ConcurrentModificationException;
import org.forgerock.opendj.config.client.IllegalManagedObjectNameException;
import org.forgerock.opendj.config.client.ManagedObjectDecodingException;
import org.forgerock.opendj.config.client.OperationRejectedException;
import org.forgerock.opendj.config.DefinitionDecodingException;
import org.forgerock.opendj.config.ManagedObjectDefinition;
import org.forgerock.opendj.config.ManagedObjectNotFoundException;
import org.forgerock.opendj.config.PropertyException;
import org.forgerock.opendj.ldap.LdapException;
import org.forgerock.opendj.server.config.server.ReplicationDomainCfg;
import org.forgerock.opendj.server.config.server.ReplicationServerCfg;
import org.forgerock.opendj.server.config.server.ReplicationSynchronizationProviderCfg;



/**
 * A client-side interface for reading and modifying Replication
 * Synchronization Provider settings.
 * <p>
 * The Replication Synchronization Provider provides multi-master
 * replication of data across multiple directory server instances.
 */
public interface ReplicationSynchronizationProviderCfgClient extends SynchronizationProviderCfgClient {

  /**
   * Get the configuration definition associated with this Replication Synchronization Provider.
   *
   * @return Returns the configuration definition associated with this Replication Synchronization Provider.
   */
  ManagedObjectDefinition<? extends ReplicationSynchronizationProviderCfgClient, ? extends ReplicationSynchronizationProviderCfg> definition();



  /**
   * Gets the "connection-timeout" property.
   * <p>
   * Specifies the timeout used when connecting to peers and when
   * performing SSL negotiation.
   *
   * @return Returns the value of the "connection-timeout" property.
   */
  long getConnectionTimeout();



  /**
   * Sets the "connection-timeout" property.
   * <p>
   * Specifies the timeout used when connecting to peers and when
   * performing SSL negotiation.
   *
   * @param value The value of the "connection-timeout" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setConnectionTimeout(Long value) throws PropertyException;



  /**
   * Gets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Replication Synchronization Provider implementation.
   *
   * @return Returns the value of the "java-class" property.
   */
  String getJavaClass();



  /**
   * Sets the "java-class" property.
   * <p>
   * Specifies the fully-qualified name of the Java class that
   * provides the Replication Synchronization Provider implementation.
   *
   * @param value The value of the "java-class" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setJavaClass(String value) throws PropertyException;



  /**
   * Gets the "num-update-replay-threads" property.
   * <p>
   * Specifies the number of update replay threads.
   * <p>
   * This value is the number of threads created for replaying every
   * updates received for all the replication domains.
   *
   * @return Returns the value of the "num-update-replay-threads" property.
   */
  Integer getNumUpdateReplayThreads();



  /**
   * Sets the "num-update-replay-threads" property.
   * <p>
   * Specifies the number of update replay threads.
   * <p>
   * This value is the number of threads created for replaying every
   * updates received for all the replication domains.
   *
   * @param value The value of the "num-update-replay-threads" property.
   * @throws PropertyException
   *           If the new value is invalid.
   */
  void setNumUpdateReplayThreads(Integer value) throws PropertyException;



  /**
   * Lists the Replication Domains.
   *
   * @return Returns an array containing the names of the Replication
   *         Domains.
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  String[] listReplicationDomains() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the named Replication Domain.
   *
   * @param name
   *           The name of the Replication Domain to retrieve.
   * @return Returns the named Replication Domain.
   * @throws DefinitionDecodingException
   *           If the named Replication Domain was found but its type
   *           could not be determined.
   * @throws ManagedObjectDecodingException
   *           If the named Replication Domain was found but one or
   *           more of its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the named Replication Domain was not found on the
   *           server.
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ReplicationDomainCfgClient getReplicationDomain(String name)
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Replication Domain. The new Replication Domain will
   * initially not contain any property values (including mandatory
   * properties). Once the Replication Domain has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Replication Domain being created.
   * @param d
   *          The definition of the Replication Domain to be created.
   * @param name
   *          The name of the new Replication Domain.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Replication Domain.
   *          This argument can be <code>null<code>.
   * @return Returns a new Replication Domain configuration instance.
   * @throws IllegalManagedObjectNameException
   *          If the name of the new Replication Domain is invalid.
   */
  <C extends ReplicationDomainCfgClient> C createReplicationDomain(
      ManagedObjectDefinition<C, ? extends ReplicationDomainCfg> d, String name, Collection<PropertyException> exceptions) throws IllegalManagedObjectNameException;



  /**
   * Removes the named Replication Domain.
   *
   * @param name
   *          The name of the Replication Domain to remove.
   * @throws ManagedObjectNotFoundException
   *           If the Replication Domain does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Replication Domain
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeReplicationDomain(String name)
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;



  /**
   * Determines whether the Replication Server exists.
   *
   * @return Returns <true> if the Replication Server exists.
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  boolean hasReplicationServer() throws ConcurrentModificationException,
      LdapException;



  /**
   * Gets the Replication Server if it is present.
   *
   * @return Returns the Replication Server if it is present.
   * @throws DefinitionDecodingException
   *           If the Replication Server was found but its type could
   *           not be determined.
   * @throws ManagedObjectDecodingException
   *           If the Replication Server was found but one or more of
   *           its properties could not be decoded.
   * @throws ManagedObjectNotFoundException
   *           If the Replication Server is not present.
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  ReplicationServerCfgClient getReplicationServer()
      throws DefinitionDecodingException, ManagedObjectDecodingException,
      ManagedObjectNotFoundException, ConcurrentModificationException,
      LdapException;



  /**
   * Creates a new Replication Server. The new Replication Server will
   * initially not contain any property values (including mandatory
   * properties). Once the Replication Server has been configured it
   * can be added to the server using the {@link #commit()} method.
   *
   * @param <C>
   *          The type of the Replication Server being created.
   * @param d
   *          The definition of the Replication Server to be created.
   * @param exceptions
   *          An optional collection in which to place any {@link
   *          PropertyException}s that occurred whilst attempting to
   *          determine the default values of the Replication Server.
   *          This argument can be <code>null<code>.
   * @return Returns a new Replication Server configuration instance.
   */
  <C extends ReplicationServerCfgClient> C createReplicationServer(
      ManagedObjectDefinition<C, ? extends ReplicationServerCfg> d, Collection<PropertyException> exceptions);



  /**
   * Removes the Replication Server if it exists.
   *
   * @throws ManagedObjectNotFoundException
   *           If the Replication Server does not exist.
   * @throws OperationRejectedException
   *           If the server refuses to remove the Replication Server
   *           due to some server-side constraint which cannot be
   *           satisfied (for example, if it is referenced by another
   *           managed object).
   * @throws ConcurrentModificationException
   *           If this Replication Synchronization Provider has been
   *           removed from the server by another client.
   * @throws LdapException
   *           If any other error occurs.
   */
  void removeReplicationServer()
      throws ManagedObjectNotFoundException, OperationRejectedException,
      ConcurrentModificationException, LdapException;

}
