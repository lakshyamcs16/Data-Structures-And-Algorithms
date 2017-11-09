package com.gfg.sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

	public void bubbleSort(int arr[]) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i]   = arr[j];
					arr[j]   = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int arr[] = { 9, 5, 3, 0, 1, 6, 2};
		bubbleSort.bubbleSort(arr);
	}
}
