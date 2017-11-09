package com.lakshya.strings;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input. */
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

//import for Scanner and other utility classes
//import java.util.*;


class TestClass {
	
	HashSet<String> sets ;
	boolean done;
	String result = "";
	void permutation(String str, int n) {
		char arr[] = str.toCharArray();
		Arrays.sort(arr);
		sets = new HashSet<String>();
		done = false;
		stringPermutation(new String(arr),"", n);
		
		
		/*for (String string : sets) {
			System.out.println(string+" ");
		}*/
	}
	private void stringPermutation(String str, String prefix, int n) {
		if(str.length()==0) {
			sets.add(prefix);
			if(sets.size() == n && !done) {
				result += prefix+"\n";
				prefix = "";
		 	    done = true;
			}
				
		}else {
			for(int i=0; i<str.length(); i++){
				String rem = str.substring(0,i) + str.substring(i+1);
				stringPermutation(rem, prefix + str.charAt(i), n);
			}
		}
	}
	
    public static void main(String args[] ) throws Exception {
        
    	TestClass testClass = new TestClass();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

       long timeBefore = System.nanoTime();
       
       while(N>0) {
    	   String inputs[] = br.readLine().split(" ");
    	   String str = inputs[0];
    	   int n 	  = Integer.parseInt(inputs[1]);
    	   
    	   
    	   testClass.permutation(str, n);
    	   N--;
           

       }
       System.out.println(testClass.result);
       
       long timeAfter = System.nanoTime();
       long display   = timeAfter - timeBefore;
       System.out.println("Time taken: "+(float)display/1000000000+" seconds");
    }
    
}
