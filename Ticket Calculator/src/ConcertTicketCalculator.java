import java.text.DecimalFormat;
import java.util.Scanner;


public class ConcertTicketCalculator {
	
	public static DecimalFormat df = new DecimalFormat("0.00"); // set decimal format
	public static Scanner input  = new Scanner(System.in);; // use Scanner to get input from console	
	
	// declare variables	
	public static int numberA, numberB, numberC;	
	public static double priceA, priceB, priceC, sum;
	public static String A = "A", B = "B", C = "C";
	
	// method enables user to input number of seats wanted per section
	public static void enterNumSeats(String mySection){
		System.out.print("Enter number of " + mySection + " seats sold: ");
		
		if(mySection == A){
		numberA = input.nextInt(); // reads number of A
		}
		else if (mySection == B){
		numberB = input.nextInt(); // reads number of B
		}
		else{
		numberC = input.nextInt(); // reads number of C
		}
	}
 	
   // method enables user to enter price per ticket from each section
   public static void enterSeatPrice(String mySection){
	   
	   System.out.print("Enter price of " + mySection + " seats sold: ");
		
		if(mySection == "A"){
		priceA = input.nextDouble(); // reads price of A tickets
		}
		else if (mySection == "B"){
		priceB = input.nextDouble(); // reads price of B tickets
		}
		else{
		priceC = input.nextDouble(); // reads price of C tickets
		}
   }
   
   public static void getSum(){ 
	   /* multiply number of tickets sold in each section (A,B,C) by their respective prices to get the
		*  sum of each section, and add totals of sections to get the sum.
		*/   
	   sum = (numberA*priceA) + (numberB*priceB) + (numberC*priceC); 
	   
	    //output sum to screen
		System.out.print("\n\n" + "Total Sales Û" + df.format(sum));
	   
   }
   
   public static void displayNumbers(String myDisplaySection){
	  
	   // Print numbers to console in column format
	   if(myDisplaySection == A){
	   System.out.print("\n" + "A Tickets: " + "\t\t" + numberA + "\t\t\t" + df.format(priceA));
	   }
	   else if (myDisplaySection == B){
	   System.out.print("\n" + "C Tickets: " + "\t\t" + numberB + "\t\t\t" + df.format(priceB));
	   }
	   else{
		   System.out.print("\n" + "C Tickets: " + "\t\t" + numberC + "\t\t\t" + df.format(priceC));
	   }
   }

	public static void main(String[] args) {
		  
		  enterNumSeats(A);
		  enterSeatPrice(A);
		  enterNumSeats(B);
		  enterSeatPrice(B);
		  enterNumSeats(C);
		  enterSeatPrice(C);
			
		  System.out.println("\n" + "\t\tTickets sold" + "\t\tPrice per Ticket"); // print line for number sold and price categories
		  System.out.print("\t\t____________"+ "\t\t_______________"); // print column header
		 
		  displayNumbers(A);
		  displayNumbers(B);
		  displayNumbers(C);
		  
		  getSum();	// print sum total		
	}

}
