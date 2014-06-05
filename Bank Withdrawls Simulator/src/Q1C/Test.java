package Q1C;

public class Test {

	public static void main(String[] args) {
		
		// Declare and create BankAccount object with 1000.00 balance
		BankAccount myAccount = new BankAccount(12345, 1000.00);
	    
		// Create instance of WithdrawSimulator which takes BankAccount object as constructor argument
		WithdrawlsSimulator mySimulator = new WithdrawlsSimulator(myAccount);
		
		// create new thread using WithdrawlSimulator object
		Thread myThread = new Thread(mySimulator);
		
		myThread.start(); // start thread
		

	} // end main method

} // end class
