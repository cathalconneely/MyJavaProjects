package SERVER;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBasic {
	 
	public static int  myTotal = 0; //Create and initialize static int variable which will be global variable containing sum
	private Socket socket; // create socket


	    
	   
	    public void startServer() {
	        try{
	            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream())); // create stream to read in from client
	            PrintWriter out = new PrintWriter(socket.getOutputStream()); // create stream to send out to client
	            
	            while (true) { // loop constantly
	                 String myServerInput = in.readLine(); // reads in user input and assigns it to serverInput string.
	                 if (myServerInput == null || myServerInput.equals("quit")) { // if user enters quit
	                     System.out.println("Connection to client ended"); // print 
	                	 break; // break constant while loop 
	                     
	                 }
	                 else{
	                         //if current sum of global variable and new input is less than the max value allowed for integers by java
	                         if(myTotal + Integer.parseInt(myServerInput) < Integer.MAX_VALUE){
	                         myTotal = myTotal+Integer.parseInt(myServerInput); // add number and assign sum to global variable
	                         System.out.println("Latest integer received from client: " + myServerInput);
	                         
	                         System.out.println("Server Total: " + myTotal + "\n"); // prints global variable
	                         out.println("OK"); // sends response to client to inform that integer was successfully added
	                        }
	                        else{
	                            out.println("ERROR"); // if sum is greater than max value allowed by java then print "ERROR"
	                        }
	                        out.flush(); // flush stream
	                       
	                     }
	                     
	                }
	            
	        }
	        catch(Exception ex){ // catch exception
	            
	        }
	    }
	    
	    public static void main(String[] args) throws Exception{
	       
	    	// create ServerSocket instance and declare port number as argument;
	    	ServerSocket server = new ServerSocket(8888); 
	        
	    	// Create instance of server class
	        ServerBasic myServerInstance = new ServerBasic(); 
	        
	        System.out.println("Server running. Waiting for client to connect...");
	        
	        try{     
	            while (true) { // constant loop
	                     myServerInstance.socket = server.accept(); // ServerSocket accepts myServerInstance socket
	                                                                // creates handshake between server and client
	                     myServerInstance.startServer(); // call startServer method on server instance.
	                                              
	            }
	            
	        }
	        finally {
	        	
	           server.close(); // close ServerSocket instance
	           
	        }
	        
	        
	    }
	}
	     