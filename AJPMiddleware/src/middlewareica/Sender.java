package middlewareica;

/**Sender is responsible for
 *a simple agent with the capability to send messages to other agents 
 * @author Anastasov
 */

//import boris.kernel.*;
//import boris.utils.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Sender extends JFrame 
{
	private JTextField agentTF, msgTF;
	private Portal portal;
	private Agent agent;
	private String agentName;
//        Router r1;


	/*==============================================
			Constructor
	\*============================================*/

	public Sender( Portal consolePortal, String cmdLine )
	{	portal = consolePortal;
		agentName = cmdLine;
		setUp();
	}

	
	/*==============================================
			initialisation
	\*============================================*/
	
	/** sets up the agent and GUI */
	private void setUp()
	{  	agent = new Agent( agentName );
		portal.addAgent(agent, agentName);
		agentTF = new JTextField( 5 );
		msgTF   = new JTextField( 15 );
                
//                r1.advertiseConnection(1234);
		JButton submit = new JButton( "Send" );
 		
		submit.addActionListener( new ActionListener()
		{	public void actionPerformed( ActionEvent e )
			{	agent.sendMessage( agentTF.getText(), msgTF.getText() );
			}
		});

		setTitle( agentName );
		setLayout( new FlowLayout() );
		add( new Label("agent"));
		add( agentTF );
		add( new Label("message"));
		add( msgTF   );
		add( submit );

		pack();
		setBounds(0, 0, 500, 80);
		setVisible(true);
	}
        
        
        
//       public static void main(String[] args) {
//        System.out.println("Test");
//        
////        Portal p1 = new Portal("Portal1");
//      
//    }
	
}
