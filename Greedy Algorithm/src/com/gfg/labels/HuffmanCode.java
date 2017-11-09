package com.gfg.labels;

import java.util.PriorityQueue;

class Code implements Comparable<Code>{
	char key;
	int frequency;
	Code left;
	Code right;
	
	Code(char c, int f){
		key = c;
		frequency = f;
		left = null;
		right = null;
	}
	
	@Override
	public int compareTo(Code o) {
		return Integer.compare(this.frequency, o.frequency);
	};
}

public class HuffmanCode {
	
	
	
	
	
	public void printCode(Code code, String c, String result) {
		
		if(code.left == null && code.right == null && code.key!='$') {
			System.out.println(code.key+" - "+result+c);
			return;
		}
		result += c;
		printCode(code.left, "0", result);
		printCode(code.right, "1", result);
	}
	
	public void huffmancode(char arr[], int freq[]) {
		
		PriorityQueue<Code> codes = new PriorityQueue<Code>();
		
		for(int i = 0; i < arr.length; i++) {
			codes.add(new Code(arr[i],freq[i]));
		}
		
		while(codes.size() != 1) {
			Code firstMin = codes.poll();
			Code secondMin  = codes.poll();
			
			Code resultant = new Code('$', firstMin.frequency + secondMin.frequency);
			
			resultant.left = firstMin;
			resultant.right = secondMin;
			
			codes.add(resultant);
		}
		
		printCode(codes.poll(),"","");
	}
	
	public static void main(String[] args) {
	
		char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
	    int freq[] = {5, 9, 12, 13, 16, 45};
	    
	    HuffmanCode code = new HuffmanCode();
	    code.huffmancode(arr, freq);
		
	}

}
