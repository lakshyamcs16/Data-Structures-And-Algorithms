package com.lakshya.strings;

import java.io.*;
import java.util.*;
 
public class OptimizedWordRankAmazon {
    static long read(StringTokenizer ts) {
        return Long.parseLong(ts.nextToken());
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ts = new StringTokenizer(in.readLine());
        long t = read(ts);
        long[] fact = new long[21];
        fact[0] = 1;
        fact[1] = 1;
        
		long timeBefore = System.nanoTime();

        for (int i=2;i<fact.length;i++) fact[i] = fact[i-1] * i;
        
        while (t-- > 0) {
            ts = new StringTokenizer(in.readLine());
            String s = ts.nextToken();
            long no = read(ts);
            int[] hash = new int[26];
            for (int i=0;i<s.length();i++) hash[s.charAt(i)-'a']++;
            int len = s.length(), curr = len;
            long fullFact = fact[len];
            for (int i=0;i<26;i++) fullFact /= fact[hash[i]];
            StringBuilder ans = new StringBuilder();
            while (curr > 0) {
                // System.out.println("Iteration: " + curr + ": " + fullFact);
                for (int i=0;i<26;i++) {
                    if (hash[i] != 0) {
                        long currFact = fullFact * hash[i] / curr;
                         //System.out.println((char)(i+'a') + ", " + currFact);
                        if (no > currFact) {
                            no -= currFact;
                        } else {
                            hash[i]--;
                            fullFact = currFact;
                            ans.append((char)('a'+i));
                            break;
                        }
                    }
                }
                curr--;
            }
            System.out.println(ans.toString());
        }
        
        long timeAfter = System.nanoTime();
		long display   = timeAfter - timeBefore;
		System.out.println("Time taken: "+(float)display/1000000000+" seconds");
    }
}