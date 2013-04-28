package middlewareica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main agent that is created each time. an agent is an extension of
 * a meta agent.
 *
 * @author l1115768
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

//    @Override
//    public void run() {
//
//        boolean flag1 = true;
//
//        Message myMessage = new Message("From", "to", "kur", 0);
////        Message myMessage = b.m;
//        System.out.println("run in Agent");
//        while (flag1 = true) {
//
//            messageRecieved(myMessage);
//
////             flag = false;
//            System.out.println(myMessage.toString());
//            System.out.println("im here in Agent while loop");
//        }
        //            try {
//                System.out.println("dequeue");
//                
////                m1 = this.dequeue();
//                
//                
//            } catch (InterruptedException ex) {
//               
//              Logger.getLogger(MetaAgent.class.getName()).log(Level.SEVERE, null, ex);
//            }


//    }

    void addMessageListener(MessageListener messageListener) {
        
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    void sendMessage(String roomManager, String join) {
        
        
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
