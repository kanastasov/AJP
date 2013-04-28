/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package middlewareica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>MetaAgent.java is used as a parent class for Agent and SocketAgent.</p>
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
