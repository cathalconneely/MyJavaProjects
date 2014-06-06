package mySortingAlgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
  
    
    /*
	 * writeFile method is called in the main method on the sorted array to write the results to a .txt file.
	 * This method prompts the user to input their desired write destination.
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
    
    }

}
