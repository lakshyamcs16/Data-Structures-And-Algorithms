package com.gfg.sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private void quickSort(int arr[], int low, int high) {
	
		if(low<high) {
			int partition = partition(arr, low, high);
			quickSort(arr, low, partition-1);
			quickSort(arr, partition+1, high);
		}
	}
	
	private int partition(int arr[], int low, int high) {
		int mid= (low+high)/2;
		int el = arr[mid];
		
		int t = arr[mid];
		arr[mid] = arr[high];
		arr[high] = t;

		int i = low - 1;
		
		for(int j = low; j < high; j++) {
			
			if(arr[j] <= el) {
				i++;
				
				int temp = arr[j];
				arr[j]   = arr[i];
				arr[i]   = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int arr[] = { 9, 5, 3, 0, 1, 6, 2};
		quickSort.quickSort(arr);
	}
}
