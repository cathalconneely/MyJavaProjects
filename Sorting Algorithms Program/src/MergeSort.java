package mySortingAlgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeSort {
	
	// constructor
	public MergeSort(int[] myArray){
		
		mergeSort(myArray);
	}
	
    // mergeSort method to take int array parameter.
    public static void mergeSort(int[] c) {
	   
    	int[] temp = new int[ c.length ]; 
	   sort(c, temp, 0, c.length - 1); // Calls sort method on these parameters.
	} 	                  
	
    
    /*
     *  sort method called recursively. Parameter temp refers to merged array.
     *  Parameter low refers to lowest index of array and parameter
     *  high refers to highest index.
     */
    private static void sort(int[] list, int[] temp, int low, int high) {
	   
    	if( low < high){  
	     int center = (low + high) / 2; 
	     sort(list, temp, low, center); // recursion.
	     sort(list, temp, center + 1, high); // recursion.
	     merge(list, temp, low, center + 1, high); 
	   } 
	}
	    
    /*
     * This method merges two sorted halves of sub array.
     * The parameter temp is an array of the merged result.
     * The parameter leftPos is the left-most index of the sub array.
     * The parameter rightPos is the index of the start of the second half.
     * The parameterrightEnd the right-most index of the sub array.
     */
	private static void merge( int[] list, int[] temp, int leftPos, int rightPos, int rightEnd){ 
	   
	   int leftEnd = rightPos - 1; 
	   int tempPos = leftPos; 
	   int numElements = rightEnd - leftPos + 1; 
	  
	   //main loop 
	   while( leftPos <= leftEnd && rightPos <= rightEnd){ 
	     if( list[ leftPos ] < list[rightPos]){ 
	     temp[ tempPos ] = list[ leftPos ]; 
	     leftPos++; 
	     } 
	     else{ 
	     temp[ tempPos ] = list[ rightPos ]; 
	     rightPos++; 
	         } 
	     tempPos++; 
	     } 	      
	      //copy rest of left half 
	      while( leftPos <= leftEnd){ 
	            temp[ tempPos ] = list[ leftPos ]; 
	            tempPos++; 
	            leftPos++; 
	      } 
	        //copy rest of right half 
	        while( rightPos <= rightEnd){ 
	              temp[ tempPos ] = list[ rightPos ]; 
	              tempPos++; 
	        	  rightPos++; 
	        	  } 
	        	  //Copy temp back into list 
	        	  for(int i = 0; i < numElements; i++, rightEnd--) 
	        	  list[ rightEnd ] = temp[ rightEnd ]; 
    } // End merge method.
	
	
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
