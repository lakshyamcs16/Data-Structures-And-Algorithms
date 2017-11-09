package com.gfg.labels;

import java.util.Arrays;

public class NumberOfPlatforms {
	
	private int numberOfLabels(String arr[], String dep[]) {
	
		int arrival[] = new int[arr.length];
		int departure[] = new int[dep.length];
		
		for(int i = 0; i<arr.length; i++) {
			arrival[i] = Integer.parseInt(arr[i].replaceAll(":", ""));
			departure[i] = Integer.parseInt(dep[i].replace(":", ""));
		}
		
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int i = 0, j = 0, labels = 0, result = 0;
		
		while(i<arr.length && j<dep.length) {
			
			if(arrival[i]<departure[j]) {
				i++;
				labels++;
			}else {
				j++;
				labels--;
			}
			
			if(labels>result) {
				result = labels;
			}
		}
		
		
		return result;
		
	}
	
	public static void main(String[] args) {
		String arr[]  = {"9:00",  "9:40", "9:50", "11:00", "15:00", "18:00"};
        String dep[]  = {"9:10", "10:00", "11:20", "11:30", "19:00", "20:00"};
        
        NumberOfPlatforms d = new NumberOfPlatforms();
        System.out.println("Number of platforms required are "+d.numberOfLabels(arr, dep));
	}
}
