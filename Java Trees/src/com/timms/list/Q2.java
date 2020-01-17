package com.timms.list;

public class Q2 {

	
	public int trappingRainWater(int arr[]) {
		
		if(arr == null || arr.length < 1)
			return 0;
		
		int size = arr.length;
		int max = Integer.MIN_VALUE;
		int leftMax[] = new int[size];
		int rightMax[] = new int[size];
		int total = 0;
		
		leftMax[0] = arr[0];
		max = arr[0];
		for (int i = 1; i < leftMax.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
			leftMax[i] = max;
		}
		
		rightMax[rightMax.length-1] = arr[rightMax.length-1];
		max = arr[rightMax.length-1];
		for (int i = rightMax.length-2; i > -1; i--) {
			if(max < arr[i]) {
				max = arr[i];
			}
			rightMax[i] = max;
		}
		
		for (int i = 0; i < arr.length; i++) {
			total += Math.min(leftMax[i], rightMax[i]) - arr[i];
		}
		
		return total;
	}
	public static void main(String[] args) {
		int arr[] = new int[] {}; 
		Q2 ans = new Q2();
		System.out.println(ans.trappingRainWater(arr));

	}

}
