package middlewareica;


import java.net.Socket;

/**SocketAgent is responsible for
 *
 * @author Anastasov
 */
public class SocketAgent extends MetaAgent  {

    MetaAgent metaAgent;
    
    Socket socket;
    
    Portal portal;
    
//        write and read methods    
    
    public void makeReadLoop()
    {
        new Thread()
        {
//            while (open(socket))
//            {
//                portal.enqueue(name (socket.read()))
//            }
            
        };
        
    }
    
    public void msgHangler(String msg)
    {

//        socket.write(msgToText(msg));
        
    }
    
    
    
}
