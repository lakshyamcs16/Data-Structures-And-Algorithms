package com.gfg.setone;

import java.util.Arrays;

public class WaterCapacity {

	public int maxWater(int arr[]) {
	
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];
		int water = 0;
		
		left[0] = arr[0];
		
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}

		right[n-1] = arr[n-1];
		
		for (int i = n-2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		
		System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right)+"\n"+Arrays.toString(arr));

		for (int i = 0; i < n; i++) {
				water += Math.min(left[i], right[i]) - arr[i];
		}
		
		return water;
	
	}
	
	public static void main(String[] args) {
		WaterCapacity capacity = new WaterCapacity();
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		 System.out.println("Maximum water that can be accumulated is " + capacity.maxWater(arr) );
	}
}
