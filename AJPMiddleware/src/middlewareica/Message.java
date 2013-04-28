package middlewareica;

/**
 * This class is used to store all of the details of a message.
 *
 * @author l1115768
 */
public class Message {

    /**
     * from is used to show who the message is sent from.
     */
    String from;
    /**
     * to is used to store who the message is being sent to.
     */
    String to;
    /**
     * msg is used to store the content of the message.
     */
    String msg;
    /**
     * msgID is used to store the ID for the message.
     */
    int msgID;

    
//    public Message()
//    {
//        
//    }
    /**
     * This is the constructor for the message class.
     *
     * @param from who the message is from.
     * @param to who the message is sent to;
     * @param msg the content of the message.
     * @param id this is the ID of the message.
     */
    public Message(String from, String to, String msg, int id) {
        this.from = from;
        this.to = to;
        this.msg = msg;
        this.msgID = id;
    }

    /**
     * This method returns who the message is from.
     *
     * @return returns who the message is from.
     */
    public String getFrom() {

        return from;
    }

    /**
     * This method returns who the message is from.
     *
     * @param s this is a string object that is used to return who the item is
     * from.
     */
    public void setFrom(String s) {

        this.from = s;
    }

    /**
     * This method returns who the message is from.
     *
     * @return returns who the message is from.
     */
    public String getTo() {

        return to;
    }

    /**
     * This method returns the message that is being sent.
     *
     * @return returns the content of the message.
     */
    public String getMessage() {

        return msg;
    }

    /**
     * This method returns the messageID.
     *
     * @return returns the messageID.
     */
    public int getID() {

        return msgID;
    }

    @Override
    public String toString() {
        String message;
        final StringBuilder sb = new StringBuilder();
        sb.append("\nThe message is sent to: \n");
        sb.append(getTo());
        sb.append("\n the message is: \n");
        sb.append(getMessage());
        sb.append("\n message was sent by: \n");
        sb.append(getFrom());
        message = sb.toString();
        return message;
    }
}
