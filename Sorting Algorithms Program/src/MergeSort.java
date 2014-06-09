package mySortingAlgorithms;


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
	

}
