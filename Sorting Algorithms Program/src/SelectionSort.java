package mySortingAlgorithms;

public class SelectionSort {
	
	// constructor
    public SelectionSort(int [] myArray){
    	
    	selectionSort(myArray);
    }
        
    // selectionSort method to be called in main method on array.
    public static void selectionSort(int [] a) { 
	   
    	int outer, inner, min; // Declare variables.
	   
    	for (outer = 0; outer < a.length - 1; outer++) { // outer counts down 
	        min = outer; 
	        for (inner = outer + 1; inner < a.length; inner++) { 
	        	 if (a[inner] < a[min]) { 
	        	 min = inner; 
	        	 } 
	        }      // Invariant: for all i, if outer <= i <= inner, then a[min] <= a[i]  
	        	   // a[min] is least among a[outer]..a[a.length - 1] 
	        	 int temp = a[outer]; 
	        	 a[outer] = a[min]; 
	        	 a[min] = temp; 
	        	 // Invariant: for all i <= outer, if i < j then a[i] <= a[j] 
	   } 
    } // End selectionSort method.

}
