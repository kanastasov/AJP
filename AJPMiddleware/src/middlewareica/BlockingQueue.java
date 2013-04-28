package middlewareica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class is the blocking queue that is used to send the messages on a first
 * in first out basis.
 *
 * @author l1115768
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
