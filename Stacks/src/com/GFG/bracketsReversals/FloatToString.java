package com.GFG.bracketsReversals;

public class FloatToString {

	public String toString(double x, int prec) {
		
		String result = "";
		int temp1 = (int)x;
		x = x - temp1;
		x = x*10;
		
		while(temp1>0) {
			int d = temp1%10;
			result += (char) (d + '0');
			temp1 = (int)temp1/10;
		}
		
		if(prec!=0)
		result += ".";
		
		int i =0;
		
		while(x>0 && i<prec ) {
			
		int temp = (int)x;
		x = x - temp;
		
		while(temp>0) {
			int d = temp%10;
			result += (char) (d + '0');
			temp = (int)temp/10;
		}
		
			x = x*10; i++;
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		System.out.println(new FloatToString().toString(77.645636559987545669,8));
	}

}
