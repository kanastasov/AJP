package middlewareica;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Portal.java is responsible for the communication of the agents.</p>
 *
 * <p>This program is part of the solution for the second ICA for AJP in Teesside
 * University.</p>
 *
 * <p>AJP middleware 2013-SOLUTION is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.</p>
 *
 * <p>This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.</p>
 *
 * <p>You should have received a copy of the GNU General Public License along
 * with this program. If not, see http://www.gnu.org/licenses/.</p>
 *
 * <p>Copyright Kiril Anastasov L1087591@live.tees.ac.uk 10-April-2013 </p>
 * <p>Copyright Chris Wills L1115768@live.tees.ac.uk </p>
 * <p>Copyright Sean Temple L1065759@live.tees.ac.uk </p>
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
