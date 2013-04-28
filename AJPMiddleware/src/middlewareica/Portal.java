package middlewareica;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *This is the portal.
 * @author l1115768
 */
public class Portal extends MetaAgent {
    
    /**
     * This creates the map which stores the agents.
     */
    Map<String, Agent> routingTable = new HashMap<String, Agent>();
    
    /**
     * 
     */
    Portal p;
    
    /**
     * The two string variables are used to define the agent and the name of the
     * portal.
     */
    String name, agName;
    
    /**
     * This is a message object.
     */
    Message m;
    
    /**
     * this is an agent.
     */
   public  Agent a;
    
    /**
     * This is the constructor for the portal it takes in a name for the portal.
     * @param portalName name of the portal being created.
     */
    public Portal(String portalName) {
        this.name = portalName;
        
    }
    
    
    
   /**
    * This method adds an agent into the routing table.
    * @param a this is the agent object that is added to the routing table.
    * @param aName used to designate the name of the agent.
    */
    public void addAgent(Agent a, String aName) {
        if (routingTable.containsKey(aName)) {
            System.out.println("User already exists");
        } else {
            routingTable.put(aName, a);
            System.out.println("User added under the name of: " + aName);
        }
        
    }
    
    /**
    * This method adds an agent into the routing table.
    * @param a this is the agent object that is added to the routing table.
    * @param aName used to designate the name of the agent.
    */
    public void addAgent(Agent a) {
        routingTable.put(agName, a);
//        p.addAgent(a, agName);
    }

    /**
     * this method removes an agent from the routing table.
     * @param aName used to designate the name of the agent to be removed.
     */
    public void removeAgent(String aName) {
        if (routingTable.containsKey(aName)) {
            routingTable.remove(aName);
            System.out.println("User removed");
        } else {
            System.out.println("User does not exist");
        }
    }
    
    /**
     * This method is used to get the portal.
     * @return returns the portal.
     */
    public Portal getPortal() {
        return p;
    }
    
    /**
     * This method is used to set the portal.
     * @param p the portal.
     */
    public void setPortal(Portal p) {
        this.p = p;
    }
    
    /**
     * This method is used to allow a message to be passed from one agent to another.
     * @param m this is the message being sent.
     * @throws InterruptedException 
     */
    public void msgHandler(Message m) throws InterruptedException {
               
        System.out.println("recieved at the Portal");
                    
        agName = m.getTo();
        
        if (routingTable.containsKey(agName)) {
            a = (Agent) routingTable.get(agName);
            a.messageRecieved(m);
//            a.run();
                                    
        } else {
            System.out.println("unable to find user");
        }     
        
    }
    
    
    
    
    
    
}
