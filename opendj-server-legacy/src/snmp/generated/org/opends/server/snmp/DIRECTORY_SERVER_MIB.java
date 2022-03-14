package org.opends.server.snmp;

//
// Generated by mibgen version 5.1 (03/08/07) when compiling DIRECTORY-SERVER-MIB in standard metadata mode.
//

// java imports
//
import java.io.Serializable;
import java.util.Hashtable;

// jmx imports
//
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.InstanceAlreadyExistsException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;
import com.sun.management.snmp.agent.SnmpMibNode;
import com.sun.management.snmp.agent.SnmpMibTable;
import com.sun.management.snmp.agent.SnmpStandardObjectServer;

/**
 * The class is used for representing "DIRECTORY-SERVER-MIB".
 * You can edit the file if you want to modify the behavior of the MIB.
 */
public class DIRECTORY_SERVER_MIB extends SnmpMib implements Serializable {

    /**
     * Default constructor. Initialize the Mib tree.
     */
    public DIRECTORY_SERVER_MIB() {
        mibName = "DIRECTORY_SERVER_MIB";
    }

    /**
     * Initialization of the MIB with no registration in Java DMK.
     */
    public void init() throws IllegalAccessException {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            return ;
        }

        try  {
            populate(null, null);
        } catch(IllegalAccessException x)  {
            throw x;
        } catch(RuntimeException x)  {
            throw x;
        } catch(Exception x)  {
            throw new Error(x.getMessage());
        }

        isInitialized = true;
    }

    /**
     * Initialization of the MIB with AUTOMATIC REGISTRATION in Java DMK.
     */
    public ObjectName preRegister(MBeanServer server, ObjectName name)
            throws Exception {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            throw new InstanceAlreadyExistsException();
        }

        // Initialize MBeanServer information.
        //
        this.server = server;

        populate(server, name);

        isInitialized = true;
        return name;
    }

    /**
     * Initialization of the MIB with no registration in Java DMK.
     */
    public void populate(MBeanServer server, ObjectName name) 
        throws Exception {
        // Allow only one initialization of the MIB.
        //
        if (isInitialized == true) {
            return ;
        }

        if (objectserver == null) 
            objectserver = new SnmpStandardObjectServer();

        // Initialization of the "DsMIB" group.
        // To disable support of this group, redefine the 
        // "createDsMIBMetaNode()" factory method, and make it return "null"
        //
        initDsMIB(server);

        isInitialized = true;
    }


    // ------------------------------------------------------------
    // 
    // Initialization of the "DsMIB" group.
    // 
    // ------------------------------------------------------------


    /**
     * Initialization of the "DsMIB" group.
     * 
     * To disable support of this group, redefine the 
     * "createDsMIBMetaNode()" factory method, and make it return "null"
     * 
     * @param server    MBeanServer for this group (may be null)
     * 
     **/
    protected void initDsMIB(MBeanServer server) 
        throws Exception {
        final String oid = getGroupOid("DsMIB", "1.3.6.1.2.1.66");
        ObjectName objname = null;
        if (server != null) {
            objname = getGroupObjectName("DsMIB", oid, mibName + ":name=org.opends.server.snmp.DsMIB");
        }
        final DsMIBMeta meta = createDsMIBMetaNode("DsMIB", oid, objname, server);
        if (meta != null) {
            meta.registerTableNodes( this, server );

            // Note that when using standard metadata,
            // the returned object must implement the "DsMIBMBean"
            // interface.
            //
            final DsMIBMBean group = (DsMIBMBean) createDsMIBMBean("DsMIB", oid, objname, server);
            meta.setInstance( group );
            registerGroupNode("DsMIB", oid, objname, meta, group, server);
        }
    }


    /**
     * Factory method for "DsMIB" group metadata class.
     * 
     * You can redefine this method if you need to replace the default
     * generated metadata class with your own customized class.
     * 
     * @param groupName Name of the group ("DsMIB")
     * @param groupOid  OID of this group
     * @param groupObjname ObjectName for this group (may be null)
     * @param server    MBeanServer for this group (may be null)
     * 
     * @return An instance of the metadata class generated for the
     *         "DsMIB" group (DsMIBMeta)
     * 
     **/
    protected DsMIBMeta createDsMIBMetaNode(String groupName,
                String groupOid, ObjectName groupObjname, MBeanServer server)  {
        return new DsMIBMeta(this, objectserver);
    }


    /**
     * Factory method for "DsMIB" group MBean.
     * 
     * You can redefine this method if you need to replace the default
     * generated MBean class with your own customized class.
     * 
     * @param groupName Name of the group ("DsMIB")
     * @param groupOid  OID of this group
     * @param groupObjname ObjectName for this group (may be null)
     * @param server    MBeanServer for this group (may be null)
     * 
     * @return An instance of the MBean class generated for the
     *         "DsMIB" group (DsMIB)
     * 
     * Note that when using standard metadata,
     * the returned object must implement the "DsMIBMBean"
     * interface.
     **/
    protected Object createDsMIBMBean(String groupName,
                String groupOid,  ObjectName groupObjname, MBeanServer server)  {

        // Note that when using standard metadata,
        // the returned object must implement the "DsMIBMBean"
        // interface.
        //
        if (server != null) 
            return new DsMIB(this,server);
        else 
            return new DsMIB(this);
    }


    // ------------------------------------------------------------
    // 
    // Implements the "registerTableMeta" method defined in "SnmpMib".
    // See the "SnmpMib" Javadoc API for more details.
    // 
    // ------------------------------------------------------------

    public void registerTableMeta( String name, SnmpMibTable meta) {
        if (metadatas == null) return;
        if (name == null) return;
        metadatas.put(name,meta);
    }


    // ------------------------------------------------------------
    // 
    // Implements the "getRegisteredTableMeta" method defined in "SnmpMib".
    // See the "SnmpMib" Javadoc API for more details.
    // 
    // ------------------------------------------------------------

    public SnmpMibTable getRegisteredTableMeta( String name ) {
        if (metadatas == null) return null;
        if (name == null) return null;
        return (SnmpMibTable) metadatas.get(name);
    }

    public SnmpStandardObjectServer getStandardObjectServer() {
        if (objectserver == null) 
            objectserver = new SnmpStandardObjectServer();
        return objectserver;
    }

    private boolean isInitialized = false;

    protected SnmpStandardObjectServer objectserver;

    protected final Hashtable metadatas = new Hashtable();
}
