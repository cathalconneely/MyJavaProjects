package mySortingAlgorithms;

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
	
	
}
