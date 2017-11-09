package careercup.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//RECTIFY IT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//USE GRAPH !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Circle {
	

    
	    public int circle(String[] str) {
	        
	        int count[] = new int[26];
	        for(int i=0; i<str.length; i++){
	            
	            count[Character.toLowerCase(str[i].charAt(0))-'a']++;
	        }
	        
	        for(int i=0; i<str.length; i++){
	            count[Character.toLowerCase(str[i].charAt(str[i].length()-1))-'a']--;
	        }
	        
	        int i = 0;
	        
	        for(;i<26;i++){
	           // System.out.print(i+" "+count[i]+" ");
	            if(count[i]==-1)
	                return 0;
	        }
	        
	        return 1;
	    }
	    
		public static void main (String[] args) throws IOException, NumberFormatException{
		    Circle c = new Circle();
		    
		    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    int N = Integer.parseInt(in.readLine());
		    
		    while(N-->0){
		        Integer.parseInt(in.readLine());
		        String inputs[] = in.readLine().split(" ");
		        System.out.println(c.circle(inputs));
		    }
			//code
		}
	
}
