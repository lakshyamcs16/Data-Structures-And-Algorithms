package com.gfg.sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int arr[]) {
		mergeSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	private void mergeSort(int[] arr, int low, int high) {
		
		if(low<high){
			int mid = (low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
		
	}
	
	private void merge(int[] arr, int low, int mid, int high) {
		
		int sizeLeft = mid - low + 1;
		int sizeRight = high - mid;
		int left[] = new int[sizeLeft];
		int right[] = new int[sizeRight];
		
		int i = 0;
		int j = 0;
		
		for(int l = 0; l < sizeLeft ; l++)
			left[l] = arr[l + low];
		
		for(int m = 0; m < sizeRight; m++)
			right[m] = arr[m+mid+1];
		
		int k = low;
		
		while(i<sizeLeft && j<sizeRight) {
			
			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while(i<sizeLeft) {
			arr[k++] = left[i++];
		}
		
		while(j<sizeRight) {
			arr[k++] = right[j++];
		}
		
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int arr[] = { 9, 5, 3, 0, 1, 6, 2};
		mergeSort.mergeSort(arr);
	}
}
