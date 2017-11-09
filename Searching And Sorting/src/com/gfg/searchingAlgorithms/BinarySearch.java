package com.gfg.searchingAlgorithms;

public class BinarySearch {

	public void binarySearch(int arr[], int key) {
		int result = binarySearch(arr, 0, arr.length-1, key);
		
		if(result!=-1)
			System.out.println("Element found at index "+result);
		else
			System.out.println("Element "+key+" not found");
		
	}
	
	public int binarySearch(int arr[], int start, int last, int key) {
		int mid = -1;
		if(start<=last) {
			mid = (start+last)/2;
			
			if(arr[mid] == key)
				return mid;
			else if(arr[mid]<key)
				return binarySearch(arr, mid+1, last, key);
			else
				return binarySearch(arr, start, mid-1, key);
		}
		return mid;
	}
	
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int key   = 0;
		binarySearch.binarySearch(arr, key);
	}
}
