package careercup.hard;
/*
 * GCD GAME CODE:
 * 
 * 
 * 
#include<bits/stdc++.h>
using namespace std;
int dp[1001][1001][2];
int solve(int a, int b, bool turn)
{
    if(a==1 && b==1)
        return 2;
    if(a==1)
        return 0;
    if(b==1)
        return 1;
    if(dp[a][b][turn]!=-1)
        return dp[a][b][turn];
    int gcd = __gcd(a, b);
    int temp;
    if(turn==0)
        temp = solve(a-1, b, !turn);
    else
        temp = solve(a, b-1, !turn);
    if(gcd==1)
        return dp[a][b][turn] = temp;
    else
    {
        int temp1;
        if(!turn)
            temp1 = solve(a/gcd , b, !turn);
        else
            temp1 = solve(a, b/gcd, !turn);
        if(temp1==temp)
            return dp[a][b][turn] = temp;
    
        if(turn==temp || turn==temp1)
            return dp[a][b][turn] = turn;
        else
            return dp[a][b][turn] = 2;
    }
}
 
int main()
{
    memset(dp, -1, sizeof(dp));
    int t;
    cin >> t;
    while(t--)
    {
        int a, b;
        cin >> a >> b;
        if(solve(a, b, 1)==1)
            cout<<"Arjit\n";
        else if(solve(a, b, 1)==0)
            cout<<"Chandu Don\n";
        else
            cout<<"Draw\n";
    }
}
 */

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        HashMap<Character, ArrayList<Integer>> swap = new HashMap<Character, ArrayList<Integer>>();
        char[] content = new char[1000000];
        char swaps[][] = new char[2*N][2];
        int i = 0;
        while(N-->0) {
        	String inputs[] = br.readLine().split(" ");
        	char a = inputs[0].charAt(0);
        	swaps[i][0] = a;
        	char b = inputs[1].charAt(0);
        	swaps[i][1] = b;
        	i++;
        	swaps[i][0] = b;
        	swaps[i][1] = a;
        	i++;
        }
        
       content = br.readLine().toCharArray();
       for(int j=0; j<content.length; j++) {
    	   if(swap.containsKey(content[j])) {
    		   swap.get(content[j]).add(j);
    	   }else {
    		   swap.put(content[j], new ArrayList<Integer>(j));
    	   }
       }
       
       for(int l=0; l<N; l++) {
    	   if(swap.containsKey(swaps[l][0])) {
    		   for (Integer m : swap.get(swaps[l][0])) {
    			   content[m] = swaps[l][1];
			}
    	  }
       }
        
        System.out.println(String.valueOf(content));
    }
}
