package com.career.cup;

import com.gfg.searchingAlgorithms.BinarySearch;

public class SearchRotatedArray {

	public void rotatedSearch(int arr[], int key) {
		int rotatedIndex = rotatedSearch(arr, 0, arr.length-1, key);
		BinarySearch search = new BinarySearch();
		
		int resultLeft  = search.binarySearch(arr,0,rotatedIndex+1,key);
		int resultRight = search.binarySearch(arr, rotatedIndex + 1, arr.length-1, key);
		
		if(resultLeft!=-1)
			System.out.println("Element "+key+" found at index "+resultLeft);
		else if(resultRight!=-1)
			System.out.println("Element "+key+" found at index "+resultRight);
		else
			System.out.println("Element "+key+" not found");
		
	
	}
	
	private int rotatedSearch(int arr[], int start, int last, int key) {
	
		int mid = -1;
		
		if(start<=last) {
			mid = (start+last)/2;
			
			if(arr[mid]>arr[mid+1])
				return mid;
			else if(arr[mid]<=arr[start])
				return rotatedSearch(arr, start, mid-1, key);
			else
				return rotatedSearch(arr, mid+1, last, key);
		}
		return mid;
	}
	
	public static void main(String[] args) {
		SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
		int arr[] = {19, 20, 21, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//Testing
		for (int i = 0; i < 22; i++) {
			searchRotatedArray.rotatedSearch(arr, i);			
		}
	}
}
