package CLIENT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;




public class Client {
		
	private BufferedReader in; // Create BufferedReader
	private PrintWriter out; // Create PrintWriter
        private Socket socket; // Create Socket
	     
        public void createConnection() throws IOException {
 
	        // create connection and initialize in/out streams
	        socket = new Socket("localhost", 8888); // create socket connection by setting host and port
	        in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Creates incoming stream
	        out = new PrintWriter(socket.getOutputStream()); //Creates outgoing stream
	    }
	    
        public void sendInput(String myInput) throws IOException{
	         out.println(myInput); // sends integer to server 
	         out.flush(); // flushes server feed
	         System.out.println(in.readLine()); // prints incoming response from server e.g "OK"
	     }
	     
	public static void main(String[] args){    	 
	    	 	 
	    	 try {

	    		// Create client instance
		    	 Client myClientInstance = new Client();
		    	 System.out.println("Connected to server...\nEnter an integer to add to the server total or enter 'QUIT' to end client connection.");
		         
	    		 myClientInstance.createConnection(); // Creates necessary handshaking between client and server
	             
	             
	             String myRequest; // Create string to contain input request
	            
	             // do while 
	             do{
	                 // Create buffered reader with InputStreamReader to read user input as a string
	            	 BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in)); 
	                 
	                 System.out.print("Enter Request: ");
	                 
	                 myRequest = bufferRead.readLine(); // assigns user input to string myRequest
	                 
	                 if(!myRequest.equalsIgnoreCase("quit")){ // if true that input does not equal "quit" or "QUIT"
	                     
	                	 myClientInstance.sendInput(myRequest); // parse input from string to Integer and call
	                	                                                         // sendInput method to send input to server
	                 }
	             }while(!myRequest.equalsIgnoreCase("quit")); // while true that input != "quit" or "QUIT"
	             

	        
	    	 } catch (IOException ex) { 
	        	 ex.printStackTrace(); // print stacktrace to diagnose exception.
	         }
	     
           
	     }
	  
      }
	     
	       
	
