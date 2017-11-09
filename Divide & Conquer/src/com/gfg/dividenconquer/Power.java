package com.gfg.dividenconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power {

	BufferedReader reader;
	Power(){
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	public float power(float x, int y) {
	
		if(y == 0)
			return 1;
		float temp = power(x, y/2);
		
		if(y%2 == 0)
			return temp*temp;
		else {
			
			if(y<0)
				return (temp*temp)/x;
			else
				return x*temp*temp;

		}
	}
	
	public static void main(String[] args) {
		Power power = new Power();
		float x = 0;
		int   y = 0;
		
		try {
			 System.out.print("Enter X:");
			 x = Float.parseFloat(power.reader.readLine());
			 System.out.print("Enter Y:");
			 y = Integer.parseInt(power.reader.readLine());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(x+"^"+y+" = "+power.power(x, y));
	}
}
