package middlewareica;


import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>SocketAgent.java is responsible for the communication of the agents though the sockets <p>
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
public class SocketAgent extends MetaAgent  {

    String name;
    
    Portal portal;
    
    Map<String, Agent> routingTable = new HashMap<String, Agent>();
    
    /**
     * This is the constructor for the agent. it takes in a name for the agent.
     *
     * @param name name of the agent being created.
     */
    public SocketAgent(String name) {
        this.name = name;
    }
    /**
     * This is the constructor for the agent. it takes in a name for the agent.
     *
     * @param name name of the agent being created.
     * @param portal this is the portal that the agent is using.
     */
    public SocketAgent(String name, Portal portal) {
        this.name = name;
        this.portal = portal;
//        this.t1.start();
    }

    /**
     * This method is used to send a message from one agent to another via sockets
     * 
     *
     * @param m this is the message object to0 be sent.
     */
    public void sendMessage(Message m) {
        try {
//            t1.interrupt();
            b.enqueue(m);
            System.out.println("message sent in Socket Agent: ");
            portal.msgHandler(m);
        } catch (InterruptedException ex) {
            Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void messageRecieved(Message msg) {
        this.message = msg;
        System.out.println("message Recieved in Socket Agent: ");
        System.out.println(message.toString());
    }
    
    /**
     * This method is used to allow a message to be passed from one agent to another.
     * @param m this is the message being sent.
     * @throws InterruptedException 
     */
    public void msgHandler(Message m) throws InterruptedException {
               
        System.out.println("recieved at the Portal");
                    
        String agName = m.getTo();
        
        if (routingTable.containsKey(agName)) {
//            a = (Agent) routingTable.get(agName);
//            a.messageRecieved(m);
//            a.run();
                                    
        } else {
            System.out.println("unable to find user");
        }     
        
    }
    
}
