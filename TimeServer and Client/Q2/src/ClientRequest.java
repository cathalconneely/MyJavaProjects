
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;




public class ClientRequest {
			
        private ObjectInputStream instream; // create ObjectInputStream
	    private Socket socket; // Create Socket
		     
	    public void createConnection() throws IOException {

		        // create connection and initialize in/out streams
		        socket = new Socket("localhost", 8999); // create socket connection by setting host and port
		        
		        instream = new ObjectInputStream(socket.getInputStream()); // create ObjectInputStream using socket
		    }
		    
		
		// method to print incoming Message object		
	    public void printRequest() throws IOException, ClassNotFoundException{
                     
	    	         Message m = (Message) instream.readObject(); // cast instream object to type Message
                     System.out.println(m.timeAndDate); // print message as date object
                     instream.close(); // close stream
            }

		     
		     
		public static void main(String[] args) throws ClassNotFoundException{    	 
		    	 	 
		    	 try {

		    		// Create client instance
			    	 ClientRequest myClientInstance = new ClientRequest();
			    	 System.out.println("Connected to server...");
			         
		    		 myClientInstance.createConnection(); // Creates necessary handshaking between client and server
		                     
		             myClientInstance.printRequest(); // parse input from string to Integer and call
		                	                         // sendInput method to send input to server        

		        
		    	 } catch (IOException ex) { 
		        	 ex.printStackTrace(); // print stacktrace to diagnose exception.
		         }
		     
	           
		     
		  
       }
		     
		       

}
