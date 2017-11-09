package com.careercup;

public class StepCounter {

	public int ways(int n, int mem[]) {
	
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		if(n == 3)
			return 4;
		if(mem[n] == 0)
			mem[n] =  ways(n-1, mem) + ways(n-2, mem) + ways(n-3, mem);
		
			return mem[n];
	}
	
	public static void main(String[] args) {
		StepCounter counter = new StepCounter();
		int n = 4;
		int mem[] = new int[n+1];
		System.out.println(counter.ways(n, mem));
	}
}
