package middlewareica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>Agent.java is this is the main agent that is created each time. an agent is an extension of
 * a meta agent.</p>
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
public class Agent extends MetaAgent  {

    /**
     * Name of the agent.
     */
    String name;
    /**
     * Portal object used in the send message function.
     */
    Portal portal;

    
    /**
     * This is the constructor for the agent. it takes in a name for the agent.
     *
     * @param name name of the agent being created.
     */
    public Agent(String name) {
        this.name = name;
    }
    /**
     * This is the constructor for the agent. it takes in a name for the agent.
     *
     * @param name name of the agent being created.
     * @param portal this is the portal that the agent is using.
     */
    public Agent(String name, Portal portal) {
        this.name = name;
        this.portal = portal;
//        this.t1.start();
    }

    /**
     * This method is used to send a message from one agent to another via a
     * portal.
     *
     * @param m this is the message object to0 be sent.
     */
    public void sendMessage(Message m) {
        try {
//            t1.interrupt();
            b.enqueue(m);
            System.out.println("message sent in Agent: ");
            portal.msgHandler(m);
        } catch (InterruptedException ex) {
            Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void messageRecieved(Message msg) {
        this.message = msg;
        System.out.println("message Recieved in Agent: ");
        System.out.println(message.toString());
    }

//    void addMessageListener(MessageListener messageListener) {
//        
////        throw new UnsupportedOperationException("Not yet implemented");
//    }

    void sendMessage(String roomManager, String join) {
        
        
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
