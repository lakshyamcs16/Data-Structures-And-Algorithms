package com.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {

	public String alienOrder(String[] words) {
        Set[] adj = new Set[26];
        Boolean[] visited = new Boolean[26];
        Stack<Character> st = new Stack<Character>();
        StringBuilder strb = new StringBuilder();

        for(int i=0; i<words.length; i++) {
        	for(int j=0; j<words[i].length(); j++) {
        		adj[words[i].charAt(j) - 'a'] = new HashSet<>();
        	}
        }

        for(int i=0; i<words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int m = word1.length();
            int n = word2.length();

            int minLength = Math.min(m, n);

            if (m > n && word1.substring(0, minLength).equals(word2)) {
                return "";
            }

            for(int j=0; j<minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj[word2.charAt(j) - 'a'].add(word1.charAt(j));
                    break;
                }
            }
        }

        for(int i=0; i<26; i++) {
        	char curr = (char) (i + 'a');
        	
            if(adj[i] != null && dfs(visited, curr, adj, st)) {
                return "";
            }
        }

        while(!st.isEmpty()) {
            strb.append(st.pop());
        }

        return strb.reverse().toString();
    }

    private boolean dfs(Boolean[] visited, Character ch, Set[] adj, Stack<Character> st) {
        if (visited[ch - 'a'] != null) return visited[ch - 'a'];
        visited[ch - 'a'] = true;

        for(Character nei : (Set<Character>) adj[ch - 'a']) {
            if (dfs(visited, nei, adj, st)) {
                return true;
            }
        }

        visited[ch - 'a'] = false;
        st.push(ch);
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlienDictionary dictionary = new AlienDictionary();
		String[] words = new String[]{"wrt","wrf","er","ett","rftt"};
		
		System.out.println(dictionary.alienOrder(words));
	}

}
