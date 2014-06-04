import javax.swing.JOptionPane; // import class JOptionPane

public class IntegerAddition {
	
	public static int myNum; // global variable to add integers
	
	public static void promptNumber(String num){
		String inputInteger =
				JOptionPane.showInputDialog("Enter " + num +  " number: "); // input number as string
		
		  myNum += Integer.parseInt(inputInteger); // reads and parses input
	}
	
	public static void getSum(){
		JOptionPane.showMessageDialog(null,
				"The sum of the two numbers is: " + myNum ); // display sum of integers 
	}

	public static void main(String[] args) {
		
		String firstNum = "first"; // string to prompt for first num
		String secondNum = "second"; // string to prompt input of second num
		
		promptNumber(firstNum); // call promptNumber method 2 times to add 2 integers
		promptNumber(secondNum);
        getSum(); // display sum of two integers in pane
		System.exit(0); // end program
		
	} //end method

} // end class
