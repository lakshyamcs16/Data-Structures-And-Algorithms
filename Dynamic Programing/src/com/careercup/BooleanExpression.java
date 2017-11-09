package com.careercup;

public class BooleanExpression {

	public int countExpressions(String s, boolean result) {
	
		if(s.length() == 0) return 0;
		
		if(s.length() == 1) return (toBoolean(s)==result)? 1:0;
		
		int ways = 0;

		for(int i=1; i<s.length(); i+=2) {
			
			char c = s.charAt(i);
			String left  = s.substring(0, i);
			String right = s.substring(i+1, s.length()); 
			
			int totalleftTrue = countExpressions(left, true);
			int totalleftFalse = countExpressions(left, false);
			int totalrightTrue = countExpressions(right, true);
			int totalrightFalse = countExpressions(right, false);
			
			int total = (totalleftTrue+totalleftFalse)*(totalrightFalse+totalrightTrue);
			int totalTrue = 0;
			if(c == '^') {
				totalTrue = (totalleftTrue*totalrightFalse) + (totalleftFalse*totalrightTrue);
			}else if(c == '&') {
				totalTrue = (totalleftTrue*totalrightTrue);
			}else if(c == '|') {
				totalTrue = (totalleftTrue*totalrightTrue)  + (totalleftFalse*totalrightTrue) + 
							(totalleftTrue*totalrightFalse);
			}
			
			int subWays = result? totalTrue : total - totalTrue;
			ways += subWays;
		}
		
		return ways;
	}
	
	public boolean toBoolean(String s) {
		return s.equals("1")? true : false;
	}
	
	public static void main(String[] args) {
		BooleanExpression expression = new BooleanExpression();
		System.out.println(expression.countExpressions("0&0&0&1^1|0", true));
	}
}
