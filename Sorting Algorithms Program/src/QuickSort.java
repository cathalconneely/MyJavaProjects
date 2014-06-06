package mySortingAlgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSort {
	
	
	//constructor
	public QuickSort(int [] myArray){
		
		quickSortOnArray(myArray);
	}
	
	
	
	// quickSortOnArray method to take int array parameter.
    public static void quickSortOnArray(int[]a){
	   quickSort(a, 0, a.length-1);
	} // End quickSortOnArray method.
    
    
    /*
	 * This method calls partition method. It has parmaeters int array,
	 *  left which refers to the left
	 */

	public static void quickSort(int arr[], int left, int right){       
	   
		int index = partition(arr, left, right); // int index is the pivot index.
	   
	   // sort the two parts of the array.
	   if(left< index-1){
	     quickSort(arr,left,index-1); // recursive call.
	   }
	   if( index < right){
	      quickSort(arr,index,right); // recursive call.
	   }
    } // End quickSort method.
	      
	/* 
	 * This method partitions list and returns index of pivot. Array is modified
	 * based on pivot. The parameter left is the lower section of the array and 
	 * the parameter right is the upper section. Elements to left of partition 
	 * index are less than it, and elements to the right are greater.
	 */
	public static int partition(int quickarray[], int left, int right){       
	   int i = left;
	   int j = right;
	   int tmp;
	   int pivot = quickarray[ (left+right)/2 ]; // Get pivot element 
	   while( i<= j ){
	        while (quickarray[i] < pivot){ // When left is less than or equal to right
	               i++;                    // increments i until it finds element more than pivot.
	        }          
	        while(quickarray[j] > pivot ){ 
	             j--; // decrements j until it finds element less than the pivot.
	        }
	        // swap values that are left from lower and upper section
	        if(i<= j){
	           tmp = quickarray[i];
	           quickarray[i] = quickarray[j];
	           quickarray[j] = tmp;
	           i++;
	           j--;
	        }
	    }     
	        return i; // Index of pivot.
    } // End partition method.
	
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
