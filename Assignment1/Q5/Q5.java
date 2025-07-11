package coen352A1;
import java.util.*;

public class Q5 {
	//can't iterate through and compare since that would be a different O(n)
	//need O(3log N)
	//Find bitonic part (peak of array)
	//perform a binary search on both halves 
	//search right part in ascending order
	//left part in reverse order
	
	private static int findPeak(int[] arr, int lo, int hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid + 1]) {
                hi = mid; // Peak is on the left
            } else {
                lo = mid + 1; // Peak is on the right
            }
        }
        return lo; // Peak index
    }
	
	private static int binarySearchAsc(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1; // Not found
    }
	
	private static int binarySearchDesc(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1; // Not found
    }

	 public static int searchBitonic(int[] arr, int target) {
	        int peak = findPeak(arr, 0, arr.length - 1);

	        // Check if target is the peak element
	        if (arr[peak] == target) return peak;

	        // Search in the increasing half
	        int result = binarySearchAsc(arr, 0, peak - 1, target);
	        if (result != -1) return result;

	        // Search in the decreasing half
	        return binarySearchDesc(arr, peak + 1, arr.length - 1, target);
	    }
	
//	public int binarySearch(int[] arr, int target) {
//		int lo = 0;
//		int hi = arr.length -1;
//		
//
//		//now perform binary search
//		//perform until lo = hi
//		 while (lo <= hi) {
//			 int mid = (lo + hi)/2;
//	            if (arr[mid] == target) 
//	                return mid;  // Target found
//	            else if (arr[mid] < target) 
//	                lo = mid + 1;  // Search right half
//	            else 
//	                hi = mid - 1; // Search left half
//	        }
//	        return -1; // Element not found
//	}
	
	public static void main(String[] args) {
		int[] bitonicArray = {1, 3, 7,  8, 12, 9, 5, 2}; // Example bitonic array
        int target = 7;

        int index = searchBitonic(bitonicArray, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
		
	    }

		

