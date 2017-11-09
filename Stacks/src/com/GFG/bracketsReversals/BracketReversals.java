package com.GFG.bracketsReversals;

import java.util.Stack;

public class BracketReversals {

	
	int countReversals(char arr[]) {
		
		if(arr.length%2!=0)
			return -1;
		
		Stack<Character> openCount = new Stack<Character>();
		int closeCount = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == '{')
				openCount.push('{');
			if(arr[i] == '}' && openCount.isEmpty()){
				++closeCount;
			}
			if(arr[i] == '}' && !openCount.isEmpty()) {
				openCount.pop();
			} 
			
		}
		
		return (int)Math.ceil(((double)closeCount/2)) + (int)Math.ceil(((double)openCount.size()/2));
		
		
		
	}
	public static void main(String[] args) {

		String input = "}{{}}{{{";
		char arr[] = input.toCharArray();
		System.out.println(new BracketReversals().countReversals(arr));
	}

}
