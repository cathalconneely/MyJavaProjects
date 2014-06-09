package mySortingAlgorithms;
 
public class InsertionSort {

	// constructor 
    public InsertionSort(int [] myArray){
    	
    	insertionSort(myArray); // call insertionSort method on array  	
    }


    public static void insertionSort(int [] arr) {

       int outer, inner, newValue; // Decalare variables.
	   //Find position for insertion.
	   for (outer = 1; outer < arr.length; outer++) {
	       newValue = arr[outer];
	       inner = outer;
	       while (inner > 0 && arr[inner - 1] > newValue) {
	          arr[inner] = arr[inner - 1]; // Move sorted elements to the right.
	          inner--;
	       }
	       arr[inner] = newValue; // Insert current element.
	   }
    } // End insertionSortMethod


}