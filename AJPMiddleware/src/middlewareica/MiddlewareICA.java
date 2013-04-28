package middlewareica;

import java.util.Map;

/**
 *
 * @author l1115768
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
