package mySortingAlgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
    
    /*
	 * writeFile method is called in the main method on the sorted array to write the results to a .txt file.
	 * This method prompts the user to input their desired write destination. Write method surrounded
	 * by try/catch.
	 */
    public void writeFile(int[] a){       
	   
    	try{  
	       Scanner myWriteScanner = new Scanner(System.in); // Declare and create instance of scanner.
	       System.out.println("Please Enter the file path to which you would like to write the sorted file:");
	        	 
	       String myOutputFile = myWriteScanner.nextLine(); // myOutputFile assigned to user input.
          
	       File myFileWriter = new File(myOutputFile);  // New File instance of myOutputFile.
           FileOutputStream outFileStream = new FileOutputStream(myFileWriter); // OutputStream created 
           PrintWriter output = new PrintWriter(outFileStream); // Creates print destination. 
	       
	       // for loop iterates through all of sorted array
	       for(int i=0; i<a.length; i++){  
	          if(a[i] != 0)                         
	          output.write(a[i] + "\n"); // If array size is greater than 0, write all elements of array.                               
	       }  
	       output.close(); // Close PrintWriter.           
	       System.out.println("File Written Successfully!");
	   } // End Try.               
	   
	   catch(IOException e){  
	         System.out.println(e); // Print IOException.    
	         } // End Catch.
	
    } // End writeFile method.

}
