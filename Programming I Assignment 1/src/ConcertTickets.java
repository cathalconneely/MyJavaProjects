import java.util.Scanner; // import class Scanner
import java.text.DecimalFormat; //import class Decimal Format

public class ConcertTickets {

	public static void main(String[] args) {
		
		// use DecimalFormat to limit decimal places
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		
		// use Scanner to get input from console
		
		Scanner input = new Scanner(System.in);
		
		// declare variables
		
		int numberA, numberB, numberC;
		
		double priceA, priceB, priceC, sum; 
		
		System.out.print("Enter number of A seats sold: ");
		numberA = input.nextInt(); // reads number of A
		
		System.out.print("Enter price of A tickets: ");
		priceA = input.nextDouble(); // reads price of A
		
		System.out.print("Enter number of B seats sold: ");
		numberB = input.nextInt(); // Reads number of B
		
		System.out.print("Enter price of B tickets: ");
		priceB = input.nextDouble(); // reads price of B
		
		System.out.print("Enter number of C seats sold: "); 
		numberC = input.nextInt(); // reads number of C
		
		System.out.print("Enter price of C tickets: "); 
		priceC = input.nextDouble(); // reads price of C tickets
		
		
		System.out.println("\t\tTickets sold" + "\t\tPrice per Ticket"); // print line for number sold and price categories
		
		System.out.print("\t\t____________"
				+ "\t\t_______________"); // print column header
		
		System.out.print("\n" + "A Tickets: " + "\t\t" + numberA + "\t\t\t" + df.format(priceA));  // print results for A Tickets
		
		System.out.print("\n" + "B Tickets: " + "\t\t" + numberB + "\t\t\t" + df.format(priceB)); // print results for B Tickets
		
		System.out.print("\n"  + "C Tickets: " + "\t\t" + numberC + "\t\t\t" + df.format(priceC)); // print results for C Tickets
		
		/* multiply number of tickets sold in each section (A,B,C) by their respective prices to get the
		 *  sum of each section, and add totals of sections to get the sum.
		 */
		
		sum = (numberA*priceA) + (numberB*priceB) + (numberC*priceC); 
		
		//output sum to screen
		System.out.print("\n" + "\t\t    " + "Total Sales Û" + df.format(sum));
		
		
	} //end method

} // end class
