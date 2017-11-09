package com.gfg.setone;

import java.util.Arrays;

public class RodCutting {

	int maxPrice(int price[]) {
		
		int len = price.length;
		int cuts[]  = new int[len+1];
		
		cuts[0] = 0;
		
		for (int i = 1; i <= len; i++) {
			int max_val = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++) {
				
				max_val = Math.max(max_val,price[j] + cuts[i-j-1]);
				cuts[i] = max_val;
			}
		}
		
		System.out.println(Arrays.toString(cuts));
		return cuts[len];
	}
	public static void main(String[] args) {
		RodCutting cost = new RodCutting();
		
		int price[] = {1, 5, 8, 9};
		System.out.println(cost.maxPrice(price));
	}
}
