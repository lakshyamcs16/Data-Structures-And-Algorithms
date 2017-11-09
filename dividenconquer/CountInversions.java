package com.gfg.dividenconquer;


public class CountInversions {

	public void countInversionsNaively(int arr[]) {
	
		int noOfInversions = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[i])
					noOfInversions++;
			}
		}
		
		System.out.println(noOfInversions);
	}
	
	public void countInversions(int arr[]) {
		int temp[] = new int[arr.length];
		int result = countInversionsWithMerge(arr, temp, 0, arr.length-1);
		
		System.out.println(result);
	}
	
	private int countInversionsWithMerge(int[] arr,int temp[], int start, int end) {
		
		int inversions = 0;
		if(start<end) {
			int mid = (start+end)/2;
			inversions  = countInversionsWithMerge(arr, temp, start, mid);
			inversions += countInversionsWithMerge(arr, temp, mid+1, end);
			inversions += merge(arr, temp, start, mid+1, end);
		}
		
		return inversions;
	}

	private int merge(int[] arr, int[] temp, int start, int mid, int end) {
		
		int i = start;
		int j = mid;
		int k = start;
		int inversions = 0;
		
		while(i <= mid - 1 && j <= end) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
				inversions += (mid - i); 
			}
			
			k++;
		}

		while (i <= mid - 1)
	        temp[k++] = arr[i++];
	  
	    while (j <= end)
	        temp[k++] = arr[j++];
	      
	    for (i=start; i <= end; i++)
	        arr[i] = temp[i];
	      
		return inversions;
	}

	public static void main(String[] args) {
		CountInversions inversions = new CountInversions();
		int arr[] = {1, 20, 6, 4, 5};
		
		long timeBefore = System.nanoTime();
		inversions.countInversionsNaively(arr);
		long timeAfter = System.nanoTime();
		long display   = timeAfter - timeBefore;
		System.out.println("Time taken: "+(float)display/1000+" microseconds");
		
		timeBefore     = System.nanoTime();
		inversions.countInversions(arr);
		timeAfter      = System.nanoTime();
		display		   = timeAfter - timeBefore;
		System.out.println("Time taken: "+(float)display/1000+"  microsceconds");
	}
}
