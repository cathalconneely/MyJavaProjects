package mySortingAlgorithms;


public class BubbleSort {
	
	// constructor
	public BubbleSort(int [] myArray){
		
		bubbleSort(myArray); // call bubbleSort method on array

	}
	
	// bubbleSort method to be called in main method on array.
    public static void bubbleSort(int [] a) { 
	   
    	int outer, inner; // Declare variables.
       
    	for (outer = a.length - 1; outer > 0; outer--) { // counting down 
		   for (inner = 0; inner < outer; inner++) { // bubbling up 
			    if (a[inner] > a[inner + 1]) { // if out of order... 
			    int temp = a[inner]; // ...then swap 
			    a[inner] = a[inner + 1]; 
			    a[inner + 1] = temp; 
			    }
	       }
	   }

	} // End bubbleSort method.      


}
