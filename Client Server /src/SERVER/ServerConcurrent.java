package SERVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;




public class ServerConcurrent { 
	    

	    // declare a server socket and a client socket for the server;
	    // declare the number of connections

	    ServerSocket myServerSocket;
	    Socket clientSocket; 
	    int numConnections = 0; // starts at zero. Will be incremented with every new connection.
	    int port; // create port variable for ServerConcurrent constructor
		
	    
	    // Constructor
	    public ServerConcurrent( int port ) {
		this.port = port; 
	    }

        // method to run server
	    public void startServer() {
		// Try to open a server socket on the given port		
	        try {
	        	//Declare and create server socketServerSocket
		    myServerSocket = new ServerSocket(port); // takes port as argument. Port is defined in when ServerConcurrent 
	        }                                        // instance is constructed
	        catch (IOException e) {
		    System.out.println(e);
	        }   
		
		System.out.println( "Server Running. Waiting for client(s) to connect." );
		System.out.println( "Client(s) can send 'QUIT' to end connection" );

		// Whenever a connection is received, start a new thread to process the connection
		// and wait for the next connection.
		
		while (true) {
		    try {
		    	
			clientSocket = myServerSocket.accept(); // creates handshake between server and client.
			numConnections ++; // increments each time a new connection is made
			
			// create instance of nested class ServerConnector... 
			ServerConnector myConnection = new ServerConnector(clientSocket, numConnections, this);
			new Thread(myConnection).start(); // create and start new thread for each connection. 
		    }                                 // Threads take ServerConnector instance as argument.
		    catch (IOException e) {
			System.out.println(e);
		    }
		}
	    }
	    // Class ServerConcurrent main method
	    public static void main(String args[]) {
			
		    // Create server instance
		    ServerConcurrent server = new ServerConcurrent(8888);// takes port number as argument
			server.startServer(); // call startServer() method 
		    }
	}

/* nested inner class. Instance will exist within ServerConcurrent class. 
 * This class will allow the server to handle multiple connections (multiple ServerConnector instances)
 * thus allowing for multiple clients.
 */
class ServerConnector implements Runnable { // implements Runnable interface to enable multi-threading
    
    BufferedReader in; // declare BufferedReader
    PrintStream out; // declare PrintStream
    Socket clientSocket; // declare client Socket
    int id; // declare int id which will be used in ServerConnector constructor to identify each server connection instance
    ServerConcurrent server; // declare server
    private static int myTotal = 0; // Declare and initialize static global variable. Start at zero.
    
    // Constructor for ServerConnector
    public ServerConnector(Socket clientSocket, int id, ServerConcurrent server) {
	this.clientSocket = clientSocket; // ServerConnector clientSocket parameter defined
	this.id = id; // ServerConnector id parameter defined
	this.server = server; // ServerConnector server parameter defined
	
	System.out.println( "Connection " + id + " established." ); // informs user of connection & connnection id
	
	try {
		// Create ServerConnector in and out streams
	    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    out = new PrintStream(clientSocket.getOutputStream());
	    } catch (IOException e) {
	      System.out.println(e);
	      }
    }


    public void run() { // Invoke run() method to implement Runnable correctly
    	String myServerInput; // String to contain input from client
	try {

            while (true) { // constant loop until specific condition invokes break
            	
            	synchronized(this){ // synchronize actions within this block
         
            
             myServerInput = in.readLine(); // reads in user input and assigns it to serverInput string.
             if (myServerInput == null || myServerInput.equals("quit")) { // if user enters quit or enters null string
                System.out.println("Connection to client " + id + " ended"); // print 
                break; // break while loop and end ServerConnector instance
                
            }
            else{
                    //if current sum of global variable and new input is less than the max value allowed for integers by java
                    if(myTotal + Integer.parseInt(myServerInput) <= Integer.MAX_VALUE){
                    myTotal = myTotal+Integer.parseInt(myServerInput); // add number and assign sum to global variable
                    System.out.println("Latest integer received from client: " + myServerInput);
                    
                    System.out.println("Server Total: " + myTotal + "\n"); // prints global variable
                    out.println("OK"); // sends response to client to inform that integer was successfully added
                   }
                   else{
                       out.println("ERROR"); // if sum is greater than max value allowed by java then print "ERROR"
                   }	    
	          }
            }
            }
	    }
            catch (IOException e) { // catch exception
	    System.out.println(e); // print exception
	   }
   }
}
	


	
