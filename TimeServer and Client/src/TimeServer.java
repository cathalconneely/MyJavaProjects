import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class TimeServer {
	

		 
		private static Date currentDateAndTime() { 
		return new Date(); 
		// An object of class Date comprises time and date
		} 
		
		// main method
		public static void main(String[]args){ 
		
	        try { 
		     ServerSocket serverSocket = new ServerSocket(8999); // declare and create server socket
		     while (true) { 

		                   Socket socket = serverSocket.accept(); // create handshake between socket and serverSocket
		                   try { 
		                         ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream()); // declare and create ObjectOutputStream
		
		                         Date dt = currentDateAndTime(); // create date object
		                         Message m = new Message(dt); // create Message object which takes Date object as argument
		                         
		                         stream.writeObject(m); // send Message object to client
		                         stream.close(); // close ObjectOutput stream 
		                   } catch (IOException e) { 
		                     System.out.println(e.getMessage()); 
		                   } 
		                   try { 
		                   socket.close(); // close socket
		                   } catch (IOException e) { 
		                   System.out.println(e.getMessage()); // print exception if socket cannot be closed 
		                   } 
		     } 
		
		}catch (IOException e) { 
		System.out.println(e.getMessage()); 
		} 
		} 
		
} //end TimeServer class
		 
     // nested class
	 class Message implements Serializable { 
		//This helper class can be used both by server and client code 
		 
		    /**
		      * 
		      */
		    private static final long serialVersionUID = 1L;
		    Date timeAndDate; 
		    // Objects of class Message comprise time & date
		
		    // Message constructor
		    Message(Date timeAndDate) { 
		    this.timeAndDate = timeAndDate; 
		} 

} // end Message class
