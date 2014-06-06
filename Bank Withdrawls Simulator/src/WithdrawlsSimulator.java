package Q1C;

import java.text.DecimalFormat;



public class WithdrawlsSimulator implements Runnable {
	
	BankAccount bankAccount; // Declare and create BankAccount object
	
	DecimalFormat df = new DecimalFormat("0.00"); // set decimal format
	
	// constructor
	public WithdrawlsSimulator(BankAccount myAccount){
		this.bankAccount = myAccount;
	}
	
	// implement run method to effectively implement runnable interface
        @Override
	public void run() {
		
    	// synchronize withdrawls to prevent race conditions
		synchronized(this){
		int i;
		for(i=0;i<15;i++){ // simulate 15 withdrawls using for loop
		bankAccount.withdraw(50); // call withdraw method on BankAccount object
		try {
			System.out.println(df.format(bankAccount.getBalance())); // print balance
		    Thread.sleep(50); // pause for 50 milliseconds between withdrawls
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		} // end for
		} 
		
	} // end run method

} // end class
