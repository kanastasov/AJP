/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package middlewareica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l1115768
 */
public class MetaAgent extends BlockingQueue implements Runnable {

    /**
     * Blocking queue is used to make an instance of blocking queue.
     */
    BlockingQueue b = new BlockingQueue();
    /**
     * creates a message object that can be used later.
     */
    Message message;
    /**
     * Here a new thread is created for each agent.
     */
    Thread t1;
    /**
     * This value is used as an exit clause for the thread run method.
     */
    private volatile Boolean flag;

    /**
     * This is the constructor of the meta agent. This is used to call the super
     * constructor. It also starts the thread run method.
     */
    public MetaAgent() {
        super();
        t1 = new Thread(this);
        t1.start();


    }

    /**
     * This method is called once a message is recieved by the user. The message
     * is stored in msg and is then printed to the user.
     *
     * @param msg used to store the message object.
     */
    public void messageRecieved(Message msg) {
//        t1.isAlive();
        this.message = msg;
        System.out.println("message Recieved in meta agent");
         System.out.println(message.toString());
//         t1.interrupt();
//        return msg;
    }

    /**
     * The run method is set to run continuously until the exit clause is met...
     * Flag == False is the exit clause.
     */
    static int counter = 0;
    @Override
    public void run() {
//        Message msg4 = new Message();
        try{
             while(true)
             {
//                 System.out.println("While run before t1.sleep: " + ++counter);
                 t1.sleep(2000);
                 if(m != null) {
                     messageRecieved(m);
                 }
                    System.out.println("While run before t1.sleep: " + ++counter);
             }
            
        } catch(InterruptedException ie) {
            System.out.println("Exiting from the MetaAgent Catch");
//            System.exit(0);
            ie.printStackTrace();
            
            
        }
        System.out.println("run in Meta Agent");
        System.out.println("im here in Meta Agent while loop");

    }
}
