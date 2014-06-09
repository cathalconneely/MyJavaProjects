package mySortingAlgorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SortingAlgorithmsDriver {
	
    public static void main(String[] args) { 
    	
        // Print program introduction string.
    	System.out.println("This program will sort a random list of numbers \nread in from a text file, with which ever of the "
    			          + "\nsorting methods you choose to use and write the \nsorted file to a file destination of your choice.");  	    
    	    
    	// Scanner used to take user input for unsorted numbers file path.
        Scanner pathScanner = new Scanner(System.in);
        System.out.println("\nPlease enter the full path of the file: ");
        String filePath = pathScanner.nextLine(); // Assigns String filePath to user input.
            
        /* 
         * Try/Catch statement implemented on scanner file read operation. File is read into an
         * array list.
         */
       
        try {
            	
               // Declare and create RandomIntegers ArrayList of type Integer.
               List<Integer> RandomIntegers = new ArrayList<Integer>();    
             
               readFile(filePath, RandomIntegers); // call readFile method and read contents into arrayList
                
              /* Declare and create int array RandomNumbers.
               * Call convertIntegersToArray method on RandomIntegers
               * to convert from arraylist to an array fill RandomNumbers array.
               */
             
               // convert arraylist to array to enable passing of array as argument into sorting methods
               int[] RandomNumbers = convertIntegersToArray(RandomIntegers);
             
               System.out.println("\nPlease Select Sorting Method\n----------------------------\n1.Bubble Sort\n2.Selection Sort\n3.Insertion Sort\n4.Merge Sort \n5.Quick Sort \n6.Exit Program");
    		   System.out.println(); //Print sorting options followed by blank line.
             
    		   /*
    		    *  Scanner reads user input for sorting selection. sortMethod is assigned
    		    *  to the int entered by the user.
    		    */
              
    		   Scanner sortScanner = new Scanner(System.in); // declare and create scanner for reading users sorting method selection
    		   int sortMethod; // declare sortMethod variable
                
               // do while loop iterates option of sorting unless sortMethod is < 1 or > 5.
               do{
            	     System.out.print("\nEnter the sort method you wish to use (6 to exit): \n");            
                     sortMethod = sortScanner.nextInt(); // reads in users selected sort method.
               
                        if (sortMethod == 1) {
                                System.out.println("Bubble sort selected.");
		                BubbleSort bubbleSort = new BubbleSort(RandomNumbers); // Create BubbleSort object using RandomNumbers as arg            	
                                WriteFile myWriteFile = new WriteFile(bubbleSort); // Create WriteFile object with BubbleSort object as arg
                                myWriteFile.writeFile(RandomNumbers); // implement writeFile method on WriteFile object
                        }
                        else if (sortMethod == 2){
                       
                	        System.out.println("Selection sort selected.");
			        SelectionSort selectionSort = new SelectionSort(RandomNumbers); // Create SelectionSort object using RandomNumbers as arg 
			 	WriteFile myWriteFile = new WriteFile(selectionSort); // Create WriteFile object with SelectionSort object as arg
                                myWriteFile.writeFile(RandomNumbers); // implement writeFile method on WriteFile object 	             	
                        }
                        else if (sortMethod == 3){
                       
                	        System.out.println("Insertion sort selected.");
			        InsertionSort insertionSort = new InsertionSort(RandomNumbers); // Create InsertionSort object using RandomNumbers as arg 
		                WriteFile myWriteFile = new WriteFile(insertionSort); // Create WriteFile object with InsertionSort object as arg
                                myWriteFile.writeFile(RandomNumbers); // implement writeFile method on WriteFile object
                        }
                        else if (sortMethod == 4){                          
                       
                	        System.out.println("Merge sort selected.");
			        MergeSort mergeSort = new MergeSort(RandomNumbers); // Create MergeSort object using RandomNumbers as arg 
			        WriteFile myWriteFile = new WriteFile(mergeSort); // Create WriteFile object with MergeSort object as arg
                                myWriteFile.writeFile(RandomNumbers); // implement writeFile method on WriteFile object
                        }
                        else if (sortMethod == 5){              	
                       
                	        System.out.println("Quick sort selected.");
			        QuickSort quickSort = new QuickSort(RandomNumbers); // Create QuickSort object using RandomNumbers as arg 
		                WriteFile myWriteFile = new WriteFile(quickSort); // Create WriteFile object with QuickSort object as arg
                                myWriteFile.writeFile(RandomNumbers); // implement writeFile method on WriteFile object	
                        }
                   
              }while(sortMethod >0 && sortMethod < 6); // end do while
                   
               if(sortMethod < 1 || sortMethod >= 6){ // if user selection is less than 1 or greater than 5
                	   System.out.print("\nProgram Terminated!");
                	   System.exit(0); // terminates program
               } 
                   
                 
        } // End Try.                		                                  
         
        catch(IOException e){
                System.out.println("Could not find file"); // Print string if file is not read in successfully.
               } // End catch
    
    } // end main method

   
    // method takes list as parameter and converts it to an array
    public static int[] convertIntegersToArray(List<Integer> integers){
        
    	int[] newArray = new int[integers.size()];       
    	Iterator<Integer> iterator = integers.iterator(); // Declare and create iterator on integers arraylist.
        
        for (int i = 0; i < newArray.length; i++){
             newArray[i] = iterator.next().intValue(); // add elements to newArray 
        }
        
        return newArray;
    } // End convertIntegersToArray method
    
    
    // method reads in contents of txt file to arraylist.
    public static void readFile(String myFile, List <Integer> myList) throws FileNotFoundException{
    	     
        Scanner fileScanner = new Scanner(new File(myFile)); // Reads in from filePath.
       
        while (fileScanner.hasNextInt()){ // Loops while there is still a next integer in the list.
       	      myList.add(fileScanner.nextInt()); // Adds all integers to RandomIntegers arraylist.
        }
        
        System.out.println("\nFile read in successfully."); 
    } // end method readFile
    
    
} // end class SortingAlgorithmsDriver
