package com.GFG.stockStack;

import java.util.Arrays;
import java.util.Stack;

public class Stocks {

	Stack<Integer> st = new Stack<Integer>();
	static Stocks span = new Stocks();

	public int[] calculateSpan(int arr[]) {
		int result[] = new int[arr.length];
		st.push(arr.length-1);

		for(int i=arr.length-2; i>=0; i--) {
			
			if(arr[i]<=arr[st.peek()]) {
				st.push(i);
				span.display();
			}else {
				while(!st.isEmpty() && arr[i]>arr[st.peek()]) {
					result[st.peek()] =  st.peek() - i;
					st.pop();
				}
				
				st.push(i);
				span.display();
			}
		}
		
		result[0] = 1;
		
		return result;
	}
	
	public void display() {
		Object print[] = st.toArray();
		System.out.println(Arrays.toString(print));
	}
	public static void main(String[] args) {

		int stocks[] = {100, 80, 60, 70, 60, 75, 85};
		int res[] = span.calculateSpan(stocks);
		System.out.println(Arrays.toString(res));
	}

}
