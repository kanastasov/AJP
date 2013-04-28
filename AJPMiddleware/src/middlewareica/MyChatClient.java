package middlewareica;

/**
 * MyChatClient is responsible for clients
 *
 * @author Anastasov
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class MyChatClient extends JFrame
        implements Runnable {

    /**
     * @param jtfSendText is responsible for text field of the text to be send
     * to the server
     */
    private JTextField jtfSendText;
    /**
     * @param jtfName is responsible for the name of the Client.
     */
    private JTextField jtfName;
    /**
     * @param jta is responsible for displaying the text from the Server.
     */
    private JTextArea jta;
    /**
     * @param socket is responsible for the communication with the sockets.
     */
    private Socket socket;
    /**
     * @param dout is responsible for writing primitive types in a portable way
     */
    private DataOutputStream dout;
    /**
     * @param din is responsible for reading primitive types in a portable way
     */
    private DataInputStream din;

    /**
     * ButtonListener is responsible for the action of the buttons and the
     * keyboards
     *
     */
    private class ButtonListener implements ActionListener {

        /**
         * @param myClient object of type MyChatClient
         */
        private final MyChatClient myClient;

        /**
         * ButtonListener default constructor
         *
         */
        public ButtonListener() {
            super();
            myClient = MyChatClient.this;

        }

        /**
         * ButtonListener paramaterized constructor.
         *
         * @param buttonlistener object of type ButtonListener
         */
        public ButtonListener(ButtonListener buttonlistener) {
            this();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String string = (new StringBuilder(String.valueOf(jtfName.getText().trim()))).append(": ").append(jtfSendText.getText().trim()).toString();
                dout.writeUTF(string);
                jtfSendText.setText("");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    /**
     * main method to created a client
     *
     * @param args
     */
    public static void main(String args[]) {

        new MyChatClient();
    }

    /**
     * MyChatClient is a default constructor, sets the GUI for the Client.
     *
     * panels are declared inside the constructor for better encapsulation.
     */
    public MyChatClient() {
        jtfSendText = new JTextField();
        jtfName = new JTextField("Enter a name");
        jta = new JTextArea();
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(new JLabel("Enter text"), "West");
        p1.add(jtfSendText, "Center");
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(new JLabel("Name"), "West");
        p2.add(jtfName, "Center");
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p1, "South");
        p.add(p2, "North");
        setLayout(new BorderLayout());
        add(p, "North");
        add(new JScrollPane(jta), "Center");
        jtfSendText.addActionListener(new ButtonListener(null));
        jta.setEditable(false);
        setTitle("ChatClient");
        setSize(500, 300);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);


        try {
//            opens a socket that the client can communicate with the server.
//            server name is the server's host name of IP.
            socket = new Socket("localhost", 8000);

//            with IP
//            socket = new Socket("130.254.204.36", 8000);
//             || with domain name
//             socket = new Socket("http://www.scm.tees.ac.uk/isg/website/", 8000);


            //after the server accepts the connection, the communication between the server and the client is the same as I/O stream.
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            
            //create a new Thread for each Client to make it concurrent in order to allow multiple clients.
            (new Thread(this)).start();
        } catch (IOException ex) {
            //catch the exception and print it to the text area.
            jta.append((new StringBuilder(String.valueOf(ex.toString()))).append('\n').toString());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
//                read the value from the input stream and append it to the text area.
                String text = din.readUTF();
                jta.append((new StringBuilder(String.valueOf(text))).append('\n').toString());
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
