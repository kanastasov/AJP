package middlewareica;

import java.util.Map;

/**
 * <p>MiddlewareICA.java contains the main method and runs the project.</p>
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
public class MiddlewareICA {

    /**
     * This is the main method used to run the project.
     * @param args 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        
        
        
        
       final Portal portal = new Portal("test");
      
       final Agent agent1 = new Agent("agent1", portal);
       
       final Agent agent2 = new Agent("agent2", portal);
        
        portal.addAgent(agent1, "agent1");
      
        portal.addAgent(agent2, "agent2");
       
       
       final Message m1 = new Message("agent2", "agent1", "blahh", 1);
        
       final Message m2 = new Message("agent1", "agent2", "Hello agent2D", 2);
        
       final Message m3 = new Message("agent2", "agent1", "Hello m", 3);
        
         agent2.sendMessage(m1);
         agent1.sendMessage(m2);
         agent2.sendMessage(m3);
         System.out.println("Portal#s routing table to string in the test");
         System.out.println(portal.routingTable.toString());
         
         
         
         
         for (Map.Entry<String, Agent> entry: portal.routingTable.entrySet()) {
            final String key = entry.getKey();
            final Agent agent = entry.getValue();
             
             System.out.println("\nkey : " + key + " value: " + agent);
             
         }
         
          
    }
    
//    public Message createMessage
}
