package com.gfg.setone;

import java.util.Arrays;

public class UglyNumbers {

	int ugly(int n) {
		
		int two   = 2, counter_two = 0;
		int three = 3, counter_three = 0;
		int five  = 5, counter_five = 0;
		int uglynos[] = new int[n];
		uglynos[0] = 1;
		
		for(int i=1; i<n; i++) {
			
			uglynos[i] = Math.min(two, Math.min(three, five));
			
			if(uglynos[i] == two) {
				counter_two++;
				two = 2*uglynos[counter_two];
			}
			
			if(uglynos[i] == three) {
				counter_three++;
				three = 3*uglynos[counter_three];
			}			
			if(uglynos[i] == five) {
				counter_five++;
				five = 5*uglynos[counter_five];
			}
			
		}
		
		System.out.println(Arrays.toString(uglynos));
		return uglynos[n-1];
	}
	public static void main(String[] args) {
		UglyNumbers n = new UglyNumbers();
		System.out.println(n.ugly(15));
	}
}
