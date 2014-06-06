package Part2;

import java.util.ArrayList;

public class NumList implements Num {
    
	// Declare ArrayList num of type Num
	ArrayList<Num> nums = new ArrayList<Num>();
    
	//Constructor taking Double argument
	public NumList(Double[] d) {
        
		for (Double myDouble : d) {
			// Create instance of NumDouble class with myDouble argument passed to constructor
            NumDouble nd = new NumDouble(myDouble);
            nums.add(nd); // add to ArrayList
        }
    }
	
	//Constructor taking Float argument that can be successfully passed to constructor
    public NumList(Float[] f) {
        for (Float myFloat : f) {
        	//Create NumFloat object
            NumFloat nf = new NumFloat(myFloat);
            nums.add(nf); // add to ArrayList
        }
    }
    @Override
    public void neg() {
        // for all elements of ArrayList nums
    	for (Num n : nums) {
            n.neg(); // Call neg() method applicable to object
        }
    }
    @Override
    public void sqrt() {
        // for all elements of ArrayList nums
    	for (Num n : nums) {
            n.sqrt();// Call sqrt() method applicable to object
        }
    }
    @Override
    public String asString() {
        String s = ""; // String s is initially empty
        for (Num n : nums) {
            s = s + " " + n.asString();// Create string s adding a white space between elements
        }                             
        return s; // method must have return value. Returns string value of s
    }
}
	

