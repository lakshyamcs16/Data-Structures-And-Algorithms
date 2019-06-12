package com.gfg.setone;

import java.util.ArrayList;

public class RodCuttingInterviewbit {

	int parent[][];
	int cuts[];
	ArrayList<Integer> answer;
	
	public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
		int n = B.size() + 2;
		cuts = new int[n];
		answer = new ArrayList<Integer>();
		cuts[0] = 0;
		for(int i=0; i<B.size(); i++) {
			cuts[i+1] = B.get(i);
		}
		cuts[n-1] = A;
		
		long dp[][] = new long[n][n];
		parent = new int[n][n];
		
		for(int len = 1; len <= n; len++) {
			for(int start = 0; start < n - len; start++) {
				int end = start + len;
				for(int k = start + 1; k < end; k++) {
					long sum = cuts[end] - cuts[start] + dp[start][k] + dp[k][end];
					if(dp[start][end] == 0 || sum < dp[start][end]) {
						dp[start][end] = sum;
						parent[start][end] = k;
					}
				}
			}
		}
		
		buildSolution(0, n-1);
		return answer;
    } 
	
	public void buildSolution(int start, int end) {
		if(start + 1 >= end) {
			return;
		}
		
		answer.add(cuts[parent[start][end]]);
		buildSolution(start, parent[start][end]);
		buildSolution(parent[start][end], end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 6;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(5);
		
		RodCuttingInterviewbit rod = new RodCuttingInterviewbit();
		System.out.println(rod.rodCut(A, list));

	}

}
