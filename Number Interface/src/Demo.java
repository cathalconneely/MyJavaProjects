package Part2;

public class Demo {

	public static void main(String[] args) {
		
		Double[] d = new Double[]{12.1, 24.2, 33.3, 44.4};//Declare and create array d of numbers of type double 
        
		NumList n1 = new NumList(d); // Create Numlist object with array d as an argument
		System.out.print("original list contents: \t\t");
		System.out.println(n1.asString()); //Call asString method to show contents of ArrayList
        
                /* Demonstrate method neg()*/
                System.out.print("output following neg() method call: ");
                n1.neg();// call neg() method on n1 object 
                System.out.println(n1.asString());// Display new contents of ArrayList
                System.out.println();//blank line
        
                /* Demonstrate method sqrt() */
                Float [] f = new Float[] {55.5f, 66.6f, 77.7f};
        
                NumList n2 = new NumList(f); // Create NumList object with array f as argument
                System.out.print("original list contents: \t     ");
                System.out.println(n2.asString()); //show original ArrayList contents
       
                System.out.print("output following sqrt() method call: ");
                n2.sqrt();// call sqrt() method on n2 object
                System.out.println(n2.asString()); // Display new contents
       
	}

}
