package com.careercup;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BalancedParentheses {

	public void create(Set<String> paren, char par[], int left, int right, int index) {
	
		if(left<0 || right<left) return;
		
		if(left ==0 && right==0) {
			paren.add(String.valueOf(par));
		}
		else {
			par[index] = '(';
			create(paren, par, left-1, right, index+1);
		
			par[index] = ')';
			create(paren, par, left, right-1, index+1);
		}
	}
	
	public void generate(int count) {
		char par[] = new char[2*count];
		Set<String> set = new HashSet<String>();
		create(set, par, count, count, 0);
		
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next()+", ");
			
		}
	}
	public static void main(String[] args) {
		BalancedParentheses parentheses = new BalancedParentheses();
		parentheses.generate(3);
	}
}
