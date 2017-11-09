package com.lakshya.arrays;

/*
 * To do list: Find the two repeating elements in a given array
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GFGArrays {

	
	int majority(int arr[]) {
		int maj_el, count, length;
		maj_el = arr[0];
		count = 0;
		length = arr.length;
		for(int i=1; i<length; i++) {
			if(maj_el == arr[i])
				count++;
			else
				count--;
			if(count == 0) {
				maj_el = arr[i];
				count = 1;
			}
		}
		
		count = 0;
		for(int i=0; i<length; i++) {
			if(maj_el == arr[i]){
				count++;
			}
		}
		
		if(count>(length/2))
			return maj_el;
		else
			return -1;
	}
	
	int oddOccurrence(int arr[]){
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}
	
	//Dynamic programming approach: works for all negative numbers as well!
	int largestSubarraySum(int a[]) {
		
		   int max_so_far = a[0];
		   int curr_max = a[0];
		   int size = a.length;
		   for (int i = 1; i < size; i++)
		   {
			    //Current maximum: maximum so far Versus maximum including the next element
		        curr_max = Math.max(a[i], curr_max+a[i]);
		        //Keep track of maximum so far among new curr_max and the older max_so_far
		        max_so_far = Math.max(max_so_far, curr_max);
		   }
		   return max_so_far;
	}
	
	int findMissingNumber(int arr[]) {
		int n = arr.length;
		int sum = (n*(n+1))/2;
		int array_sum = 0;
		
		for(int i=0; i<n; i++) {
			array_sum += arr[i];
		}
		
		return sum - array_sum;
		
	}
	
	int binarySearch(int arr[], int low, int high, int key)
	{
	   if (high < low)
	       return -1;
	   int mid = (low + high)/2;  /*low + (high - low)/2;*/
	   if (key == arr[mid])
	       return mid;
	   if (key > arr[mid])
	       return binarySearch(arr, (mid + 1), high, key);
	   return binarySearch(arr, low, (mid -1), key);
	}
	
	int pivotedBinarySearch(int arr[], int n, int key)
	{
	   int pivot = searchRotated(arr, 0, n-1);
	 
	   // If we didn't find a pivot, then array is not rotated at all
	   if (pivot == -1)
	       return binarySearch(arr, 0, n-1, key);
	 
	   // If we found a pivot, then first compare with pivot and then
	   // search in two subarrays around pivot
	   if (arr[pivot] == key)
	       return pivot;
	   if (arr[0] <= key)
	       return binarySearch(arr, 0, pivot-1, key);
	   return binarySearch(arr, pivot+1, n-1, key);
	}
	
	int searchRotated(int arr[],int low, int high) {
		if (high < low)  return -1;
		   if (high == low) return low;
		 
		   int mid = (low + high)/2;   /*low + (high - low)/2;*/
		   if (mid < high && arr[mid] > arr[mid + 1])
		       return mid;
		   if (mid > low && arr[mid] < arr[mid - 1])
		       return (mid-1);
		   if (arr[low] >= arr[mid])
		       return searchRotated(arr, low, mid-1);
		   return searchRotated(arr, mid + 1, high);
	}
	
	void reverse(int arr[], int low, int high, int d) {
		for(int i=low, j=high-1; i < j ; i++, j-- ) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	void printArray(int arr[]) {
		System.out.println("Reversed array is "+Arrays.toString(arr));
	}
	
	void rotate(int arr[], int low, int high, int d) {
		reverse(arr,low,d,d);
		reverse(arr,d,high,d);
		reverse(arr,low,high,d);
		
		System.out.println("Rotated by "+d+", Array is "+Arrays.toString(arr));
	}
	
	void maximumAdjacentSum(int arr[], int size) {
		int excl = 0, incl = arr[0], excl_new = 0;
		
		for(int i=1; i< size; i++) {
			excl_new = (excl>incl)? excl : incl;
			
			incl = excl + arr[i];
			excl = excl_new;
			
		}
		int result = (excl>incl)? excl : incl;
		System.out.println("Maximum is "+result);
	}
	
	void leaders(int arr[]) {
		int max = arr[arr.length -1];
		System.out.print("Leaders are ");
		for(int i = arr.length - 1; i>=0; i--) {
		
			if(max <= arr[i]) {
				max = Math.max(max, arr[i]);
				System.out.print(max+" ");
			}
			
		}
	}
	
	
	void frequencySort(int arr[]) {
		int length = arr.length;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int val = 0;
		for(int i=0; i<length; i++) {
			map.put(arr[i], val);
		}
		
		for(int i=0; i<length; i++) {
			val = map.get(arr[i]);
			val++;
			map.put(arr[i], val);
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
        {
            public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        
        System.out.println();
		for(Entry<Integer, Integer> entry:list){
			for(int i=0; i<entry.getValue(); i++)
				System.out.print(entry.getKey()+" ");
        }
	}
	
	/*
	 * Maximum difference s.t. the bigger element of the array is at bigger index
	 */
	
	int maximumDifference(int arr[]) {
		int min_element = arr[0];
		int max_diff = arr[1] - arr[0];
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if(min_element > arr[i])
				min_element = arr[i];
		}
		
		return max_diff;
	}
	
	/*
	 * Union & Intersection
	 * int arr1[] = {1, 3, 4, 5, 7};
	 * int arr2[] = {2, 3, 5, 6};
	 */
	
	Object[] unionIntersection(int arr1[], int arr2[]) {
		
		int length1 = arr1.length;
		int length2 = arr2.length;
		int i = 0, j = 0, k = 0;
		// Union
		int totalSize = length1 + length2;
		int union[] = new int[totalSize];
		int intersection[] = new int[10];
		for(i=0, j=0, k=0; i<length1 && j<length2; ) {
			if(arr1[i]<arr2[j]){
				union[k] = arr1[i];
				k++; i++;
			}
			else if(arr2[j]<arr1[i]) {
				union[k] = arr2[j];
				k++; j++;
			}
			else if(arr1[i] == arr2[j]) {
				union[k] = arr1[i];
				k++; i++; j++;
			}
		}
		
		while(i<length1) {
			union[k++] = arr1[i++];
		}
		while(j<length2) {
			union[k++] = arr1[j++];
		}
		
		//Intersection
		for(int l=0, m=0, n=0; l<length1 && m<length2; ) {
			if(arr1[l] == arr2[m]) {
				intersection[n] = arr1[l];
				l++; m++; n++;
			}
			else if(arr1[l]<arr2[m]){
				 l++;
			}
			else if(arr2[m]<arr1[l]) {
				 m++;
			}
		}
		
		return new Object[]{union,intersection};
	}
	
	boolean consecutive(int arr[]) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int a:arr) {
		sum+=a;
		if(min>a)
		min = a;
		}

		int l = arr.length;
		min = min*l;
		l-=1;
		int nSum = (l*(l+1))/2;
		nSum+=min;
		if(sum==nSum)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int missing_array[] = {1, 2, 4, 0, 6, 3, 7, 8};
		int sorted_array[] = {3,4,5,1,0};
		int leaders[] = {16, 17, 4, 3, 5, 2};
		int frequency[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		int maxDiff[] = {7, 9, 1, 2, 8};
		int consec[] = {1, 0, -1, -2, 2};
		GFGArrays array = new GFGArrays();
		
		System.out.println("Majority Element is "+array.majority(arr));
		System.out.println("Odd Occerrence: "+array.oddOccurrence(arr));
		System.out.println("Largest Subarray sum is "+array.largestSubarraySum(arr));
		System.out.println("Missing number is "+array.findMissingNumber(missing_array));
		System.out.println("Search Rotated: "+array.pivotedBinarySearch(sorted_array, sorted_array.length, 4));
		array.rotate(sorted_array, 0, sorted_array.length, 3 );
		array.reverse(sorted_array, 0, sorted_array.length, 2);
		array.printArray(sorted_array);
		array.maximumAdjacentSum(sorted_array, sorted_array.length);
		array.leaders(leaders);
		array.frequencySort(frequency);
		System.out.println("\nMaximum difference: "+array.maximumDifference(maxDiff));
		
		int arr1[] = {1, 3, 4, 5, 7};
		int arr2[] = {2, 3, 5, 6};
		Object results[] = array.unionIntersection(arr1, arr2);
		System.out.println("Union:"+Arrays.toString((int[])results[0])+" Intersection: "+Arrays.toString((int[])results[1]));
		System.out.println("Check consec. :"+array.consecutive(consec));
	
	}

}
