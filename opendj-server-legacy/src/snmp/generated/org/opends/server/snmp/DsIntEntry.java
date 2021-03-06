package org.opends.server.snmp;

//
// Generated by mibgen version 5.1 (03/08/07) when compiling DIRECTORY-SERVER-MIB.
//

// java imports
//
import java.io.Serializable;

// jmx imports
//
import com.sun.management.snmp.SnmpStatusException;

// jdmk imports
//
import com.sun.management.snmp.agent.SnmpMib;

/**
 * The class is used for implementing the "DsIntEntry" group.
 * The group is defined with the following oid: 1.3.6.1.2.1.66.3.1.
 */
public class DsIntEntry implements DsIntEntryMBean, Serializable {

    /**
     * Variable for storing the value of "DsIntEntURL".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.9".
     *
     * " URL of the peer Directory Server."
     *
     */
    protected String DsIntEntURL = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "DsIntEntSuccesses".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.8".
     *
     * " Cumulative successes in contacting the peer Directory Server
     * since the creation of this entry."
     *
     */
    protected Long DsIntEntSuccesses = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntFailures".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.7".
     *
     * " Cumulative failures in contacting the peer Directory Server
     * since the creation of this entry."
     *
     */
    protected Long DsIntEntFailures = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntFailuresSinceLastSuccess".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.6".
     *
     * " The number of failures since the last time an
     * attempt to contact the peer Directory Server was successful.
     * If there have been no successful attempts, this counter
     * will contain the number of failures since this entry
     * was created."
     *
     */
    protected Long DsIntEntFailuresSinceLastSuccess = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntTimeOfLastSuccess".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.5".
     *
     * " The value of sysUpTime when the last attempt made to
     * contact the peer Directory Server was successful. If there
     * have been no successful attempts this entry will have a value
     * 
     * of zero. If the last successful attempt was made before
     * the network management subsystem was initialized, this
     * object will contain a value of zero."
     *
     */
    protected Long DsIntEntTimeOfLastSuccess = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntTimeOfLastAttempt".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.4".
     *
     * " The value of sysUpTime when the last attempt was made
     * to contact the peer Directory Server. If the last attempt
     * was made before the network management subsystem was
     * initialized, this object will contain a value of zero."
     *
     */
    protected Long DsIntEntTimeOfLastAttempt = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntTimeOfCreation".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.3".
     *
     * " The value of sysUpTime when this row was created.
     * If the entry was created before the network management
     * subsystem was initialized, this object will contain
     * a value of zero."
     *
     */
    protected Long DsIntEntTimeOfCreation = new Long(1);

    /**
     * Variable for storing the value of "DsIntEntDirectoryName".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.2".
     *
     * " Distinguished Name of the peer Directory Server to
     * which this entry pertains."
     *
     */
    protected String DsIntEntDirectoryName = new String("JDMK 5.1");

    /**
     * Variable for storing the value of "DsIntEntIndex".
     * The variable is identified by: "1.3.6.1.2.1.66.3.1.1".
     *
     * " Together with applIndex and dsApplIfProtocolIndex, this
     * object forms the unique key to
     * identify the conceptual row which contains useful info
     * on the (attempted) interaction between the Directory
     * Server (referred to by applIndex) and a peer Directory
     * Server using a particular protocol."
     *
     */
    protected Integer DsIntEntIndex = new Integer(1);

    /**
     * Variable for storing the value of "ApplIndex".
     * The variable is identified by: "1.3.6.1.2.1.27.1.1.1".
     *
     * "An index to uniquely identify the network service
     * application. This attribute is the index used for
     * lexicographic ordering of the table."
     *
     */
    protected Integer ApplIndex = new Integer(1);

    /**
     * Variable for storing the value of "DsApplIfProtocolIndex".
     * The variable is identified by: "1.3.6.1.2.1.66.2.1.1".
     *
     * "An index to uniquely identify an entry corresponding to a
     * application-layer protocol interface. This index is used
     * for lexicographic ordering of the table."
     *
     */
    protected Integer DsApplIfProtocolIndex = new Integer(1);


    /**
     * Constructor for the "DsIntEntry" group.
     */
    public DsIntEntry(SnmpMib myMib) {
    }

    /**
     * Getter for the "DsIntEntURL" variable.
     */
    public String getDsIntEntURL() throws SnmpStatusException {
        return DsIntEntURL;
    }

    /**
     * Getter for the "DsIntEntSuccesses" variable.
     */
    public Long getDsIntEntSuccesses() throws SnmpStatusException {
        return DsIntEntSuccesses;
    }

    /**
     * Getter for the "DsIntEntFailures" variable.
     */
    public Long getDsIntEntFailures() throws SnmpStatusException {
        return DsIntEntFailures;
    }

    /**
     * Getter for the "DsIntEntFailuresSinceLastSuccess" variable.
     */
    public Long getDsIntEntFailuresSinceLastSuccess() throws SnmpStatusException {
        return DsIntEntFailuresSinceLastSuccess;
    }

    /**
     * Getter for the "DsIntEntTimeOfLastSuccess" variable.
     */
    public Long getDsIntEntTimeOfLastSuccess() throws SnmpStatusException {
        return DsIntEntTimeOfLastSuccess;
    }

    /**
     * Getter for the "DsIntEntTimeOfLastAttempt" variable.
     */
    public Long getDsIntEntTimeOfLastAttempt() throws SnmpStatusException {
        return DsIntEntTimeOfLastAttempt;
    }

    /**
     * Getter for the "DsIntEntTimeOfCreation" variable.
     */
    public Long getDsIntEntTimeOfCreation() throws SnmpStatusException {
        return DsIntEntTimeOfCreation;
    }

    /**
     * Getter for the "DsIntEntDirectoryName" variable.
     */
    public String getDsIntEntDirectoryName() throws SnmpStatusException {
        return DsIntEntDirectoryName;
    }

    /**
     * Getter for the "DsIntEntIndex" variable.
     */
    public Integer getDsIntEntIndex() throws SnmpStatusException {
        return DsIntEntIndex;
    }

    /**
     * Getter for the "ApplIndex" variable.
     */
    public Integer getApplIndex() throws SnmpStatusException {
        return ApplIndex;
    }

    /**
     * Getter for the "DsApplIfProtocolIndex" variable.
     */
    public Integer getDsApplIfProtocolIndex() throws SnmpStatusException {
        return DsApplIfProtocolIndex;
    }

}
