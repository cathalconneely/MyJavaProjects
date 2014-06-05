package Q1C;


public class BankAccount {
	
    // declare variables
    double balance;
    int accountNum;
    
    // create BankAccount constructors
    public BankAccount(){
    	this.balance= 0.00;
    	this.accountNum = 0;
    }
    // constructor which takes an int and double as arguments
    public BankAccount(int accountNum, double balance){
    	this.accountNum = accountNum;
    	this.balance = balance;
    }
    
    // method returns balance of BankAccount object
    public double getBalance(){
    	return balance;
    }
    
    // method adds to balance of BankAccount object
    public void deposit(int myDeposit){
    	balance += myDeposit;
    }
    
    // method withdraws from BankAccount objects balance if balance is >= than requested withdrawl amount
    public void withdraw(int myWithdrawl){
    	
    	if(balance >= myWithdrawl){
    		
    		balance-= myWithdrawl;
    	}
    	
    }

} // end class
