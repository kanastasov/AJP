package middlewareica;

/**
 * <p>Message.java is used to store all of the details of a message.</p>
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
