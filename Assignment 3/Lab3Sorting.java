package assignment3;

import java.util.Arrays;

public class Lab3Sorting {
    /** This is the skeleton code for the sorting algorithms
     * implementations for Assignment 1. The methods that
     * are currently not implemented throw the
     * UnsupportedOperationException. You may add more
     * methods to the class, but please do not change
     * the names or types of the existing methods. */

    // Insertion sort.

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {

	    int value = array[i];
	    int j = i - 1;

	    while (j >= 0 && array[j] > value) {

		array[j + 1] = array[j];
		j = j - 1;

	    }
	    array[j + 1] = value;
	}
    }

    // Quicksort.

    public static void quickSort(int[] array) {
        
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end) {
        // Base case.
	if (begin >= end)
	    return;

	// Partition the array.
	int pivot = partition(array, begin, end);

	// Now recursively quicksort the two partitions.
	quickSort(array, begin, pivot - 1);
	quickSort(array, pivot + 1, end);
	// throw new UnsupportedOperationException();
    }

    // Partition part of an array, and return the index where the pivot
    // ended up.
    private static int partition(int[] array, int begin, int end) {
       int i = begin-1;
	
	int pivot = array[end];
	

	for (int j = begin; j <= end-1; j++) {
	    if (array[j] <= pivot) {
		i++;
		int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
	    }
	}
	        int temp = array[i+1];
                array[i+1] = array[end];
                array[end] = temp;
                
	        return i+1;
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        
        return mergeSort(array, 0, array.length - 1);
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        // Base case: array of length 0 or 1.
	if (begin > end)
	    return new int[0];
	if (begin == end) {
	    int[] result = { array[begin] };
	    return result;
	}

	// Midpoint of the array
	int mid = (begin + end) / 2;
	
	// Recursively sort both halves of the array,
	int[] arrayLeft = new int[mid];
	int[] arrayRight = new int[array.length - mid];
	arrayLeft = mergeSort(array,begin,mid);
	arrayRight = mergeSort(array,mid+1,end);
	// then merge the results.

	return merge(arrayLeft,arrayRight);
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        // The result array
	int[] result = new int[left.length + right.length];
	// How far we have got in the result array
	int nextResult = 0;
	// How far we have got in the left array
	int nextLeft = 0;
	// How far we have got in the right array
	int nextRight = 0;

	// Idea: repeatedly copy one element from either the left or right array to the
	while(nextLeft < left.length && nextRight < right.length) {
		if(left[nextLeft] <= right[nextRight]) {
			result[nextResult] = left[nextLeft];
			nextLeft++;
		}else {
			result[nextResult] = right[nextRight];
			nextRight++;
		}
		nextResult++;
	}
	while(nextLeft < left.length) {
		result[nextResult] = left[nextLeft];
		nextLeft++;
		nextResult++;
	}
	while(nextRight < right.length) {
		result[nextResult] = right[nextRight];
		nextRight++;
		nextResult++;
	}
	// result array.
	return result;
    }

    public static void heapSort(int[] array) {
        
        int n = array.length;
        
        for (int i = n/2 -1; i>=0 ; i--){
            trickleDown(array, n, i);
        }
        
        for(int i= n-1; i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            trickleDown(array, i, 0);
        }
 
    }
    
    private static void trickleDown(int [] arr, int n, int i){
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;
        
        if(l < n && arr[l] > arr[largest] )
            largest = l;
        
        if( r < n && arr[r] > arr[largest])
            largest = r;
        
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            trickleDown(arr, n, largest);
        }
            
    }


    public static void main(String[] args) {
      // Put code here to try out your algorithms
      int[] example1 = new int[] {4, 5, 6, 3, 2, 1};


      // Insertion sort performs sorting in place, and it will
      // modify the original array;
      insertionSort(example1);
      System.out.println(Arrays.toString(example1));
    }
}
