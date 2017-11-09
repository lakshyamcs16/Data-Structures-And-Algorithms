package com.gfg.sortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

	public void selectionSort(int arr[]) {
		
		for(int i = arr.length-1; i >= 0; i--) {
			int max = arr[i];
			int j = 0, index = 0;
			while(j <= i) {
				
				if(arr[j] >= max) {
					max = arr[j];
					index = j;
				}
				
				j++;
			}
			
			arr[index]   = arr[i];
			arr[i] = max;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int arr[] = { 9, 5, 3, 0, 1, 6, 2};
		selectionSort.selectionSort(arr);
	}
}
