package com.gfg.setone;

import java.util.Arrays;

public class Fibonacci {

	int fibonacci(int number) {
		
		if(number == 0)
			return 0;
		else if(number == 1)
			return 1;
		else
			return fibonacci(number-1) + fibonacci(number-2);
	}

	int fibonacciDP(int number) {
		int fib[] = new int[number];
		fib[0] = fib[1] = 1;
		for(int i=2; i<number; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		System.out.println(Arrays.toString(fib));
		return fib[number-1];
		
	}
	
	public static void main(String[] args) {
		Fibonacci fno = new Fibonacci();
		System.out.println(fno.fibonacci(8));
		System.out.println(fno.fibonacciDP(8));
	}
}

