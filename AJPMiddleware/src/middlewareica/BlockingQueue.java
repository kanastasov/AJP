package middlewareica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>BlockingQueue.java is the blocking queue that is used to send the messages on a first
 * in first out basis(FIFO).</p>
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
public class BlockingQueue implements Serializable {

    /**
     * used to terminate the thread.
     */
    boolean flag = true;
    /**
     * This is the linked list where all of the messages are stored.
     */
    private Queue queue = new LinkedList();
    /**
     * The message object that is added to the blocking queue.
     */
    Message m;
    /**
     * This variable is used to limit the amount of messages allowed into the
     * linked list.
     */
    private int limit = 20;
    /**
     * count is used to increment each time the enqueue method waits. This stops
     * it from being an endless loop and allows for the exit clause to be met.
     */
    private int count = 0;

    /**
     * no args constructor for blocking queue.
     */
    public BlockingQueue() {
    }

    /**
     * This method is used to add a message into the blocking queue. If the
     * queue is at its limit of 20 then it will wait until there is space. and
     * if the queue is empty it notifies all agents.
     *
     * @param m m is a Message object which is to be added to the queue.
     * @throws InterruptedException
     */
    public synchronized void enqueue(Message m) throws InterruptedException {
        
        if (queue.offer(m)) {
            System.out.println("Message added to the Queue through offer: ");
           
           
        } else {
             System.out.println("Queue is full, waiting for space to enqueue.");
             wait(1000);
            
        }

    }

    public boolean getFlag() {
        return flag;
    }

    /**
     * This method is used to remove an object from the queue then return it.
     *
     * @return returns the message that is recieved.
     * @throListws InterruptedException
     */
    public synchronized String dequeue() throws InterruptedException {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty: ");
            wait(1000);
        } else {
            m = (Message) queue.poll();
        }
        return m.toString();
    }
    
    
    
    public void setMessage(Message msg)
    {
        this.m = msg;
    }
    
    public Message getMessage()
    {
        return m; 
    }

//     public E poll() {
//        E e;
//        if (l.isEmpty()) {
//            e = null;
//        } else {
//            e = l.getFirst();
//            l.removeFirst();
//        }
//       
//        return e;
//    }
    @Override
    public String toString() {
        final String test = queue.toString();
        String str = new String();
        for (int i = 0; i < queue.size(); i++) {

            str = (String) queue.peek();
        }

        return str;

    }
}
