package com.gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	int weight;
	
	Node(int data) {
		this.data = data;
	}

	public Node(int dest, int weight2) {
		data = dest;
		weight = weight2;
	}
}

class Graph {
	int v;
	ArrayList<LinkedList<Node>> list;

	
	Graph(int v){
		this.v = v;
		list = new ArrayList<LinkedList<Node>>(v);
		
		for(int i=0; i<v; i++) {
			list.add(new LinkedList<Node>());
		}
	}
	
	public void insert(Node src, Node dest) {
		
		LinkedList<Node> adj = list.get(src.data);
		adj.add(dest);
	}
	
	public void insert(Node src, Node dest, int weight) {
		LinkedList<Node> adj = list.get(src.data);
		dest = new Node(dest.data, weight);
		adj.add(dest);
	}
	public void display() {
		
		Iterator<Node> itr;
		int i = 0;
		
		for(LinkedList<Node> l: list) {
			itr = l.iterator();
			System.out.print(i+++"|");
			
			while(itr.hasNext()) {
				Node temp = itr.next();
				System.out.print("->"+temp.data+"("+temp.weight+")");
			}
			
			System.out.println();
		}
	}
	
	public void BFSUtil(int startNode, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startNode);
		
		while(!queue.isEmpty()) {
			int visitNode = queue.peek();
			queue.poll();
			
			if(visited[visitNode] == false) {
				System.out.print(visitNode+", ");
				visited[visitNode] = true;
				
				for(Node neighbor:list.get(visitNode)) {
					if(visited[neighbor.data] == false)
						queue.add(neighbor.data);
				}
			}
				
		}
		
	}
	
	public void BFS() {
		boolean[] visited = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(visited[i] == false)
				BFSUtil(i, visited);
		}
	}
	
	public void DFS() {
		boolean visited[] = new boolean[v];
		
		for(int i=0; i<v; ++i) {
			if(visited[i] == false)
				DFSUtil(i, visited);
		}
	}

	private void DFSUtil(int startNode, boolean[] visited) {
		visited[startNode] = true;
		System.out.print(startNode+", ");
		
		for(Node neighbor:list.get(startNode)) {
			if(visited[neighbor.data] == false)
				DFSUtil(neighbor.data, visited);
		}
	}
	
	public void topologicalSort() {
		boolean visited[] = new boolean[v];
		Arrays.fill(visited, false);
		Stack<Integer> sort  = new Stack<Integer>();

		for(int i=0; i<v; ++i) {
			if(visited[i] == false)
				topologicalSortUtil(i, visited, sort);
		}
		
		while(!sort.isEmpty())
			System.out.print(sort.pop()+", ");
	}

	private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> sort) {
		
		visited[i] = true;
		
		for(Node neighbors:list.get(i)) {
			if(visited[neighbors.data]==false)
				topologicalSortUtil(neighbors.data, visited, sort);
		}
		
		sort.push(i);
	}
	
	public void longestPath(int src) {
		
		boolean visited[] = new boolean[v];
		Stack<Integer> sort = new Stack<Integer>();
		for(int i=0; i<v; ++i) {
			if(visited[i] == false)
				topologicalSortUtil(i, visited, sort);
		}
		
		
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[src] = 0;
		
		
		while(!sort.isEmpty()) {
			int key = sort.peek();
			sort.pop();
			if(dist[key]!=Integer.MIN_VALUE) {
				for(Node node:list.get(key)){
					if(dist[node.data]<node.weight + dist[key])
						dist[node.data] = node.weight + dist[key];
				}
			}
		}
		
		for(int i=0; i<v; i++) {
			if(dist[i] == Integer.MIN_VALUE)
				System.out.print("INF, "); 
			else
				System.out.print(dist[i]+", ");
		}
	}
	
	public void findMother() {
		boolean visited[] = new boolean[v];
		int lastVertex = 0;
		
		for(int i=0; i<v; ++i) {
			if(visited[i] == false) {
				DFSUtil(i, visited);
				lastVertex = i;
			}
				
		}

		Arrays.fill(visited, false);
		DFSUtil(lastVertex, visited);
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == false)
				System.out.println("\nNo Mother");
		}
		
		System.out.println("\nMother vertex is "+lastVertex);
	}
	
	public void DFSClosureUtil(int startNode, int neighbors, boolean visited[], int tc[][]) {
		
		visited[startNode] = true;
		tc[startNode][neighbors] = 1;
		
		for(Node neighbor:list.get(neighbors)) {
			if(visited[neighbor.data] == false)
				DFSClosureUtil(startNode, neighbor.data, visited, tc);
		}
	}
	public void DFSClosure() {
		int [][]tc = new int[v][v];
		boolean visited[] = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(visited[i] == false)
				DFSClosureUtil(i, i, visited, tc);
		}
		
		for(int outer[]: tc) {
			System.out.println();
			for(int key: outer) {
				System.out.print(key+" ");
			}
		}
	}
	
	public void IterativeDFS() {
		boolean visited[] = new boolean[v];
		Stack<Integer> dfs = new Stack<Integer>();
		for(int i=0; i<v; i++) {
			dfs.push(i);
			if(visited[i]==false) {
				while(!dfs.isEmpty()) {

				int n = dfs.peek();
				visited[n] = true;
				System.out.print(dfs.pop()+", ");
				
				for(Node neighbors:list.get(n))
					if(visited[neighbors.data] == false) {
						dfs.push(neighbors.data);
						visited[neighbors.data] = true;
					}
				}
			}
		}
	}
	
	public boolean detectCycleUtil(int startNode, boolean[] visited, boolean[] recStack) {
		
		if(visited[startNode] == false) {
			visited[startNode] = true;
			recStack[startNode] = true;
			
			for(Node neighbor:list.get(startNode)) {
				if(visited[neighbor.data] == false && detectCycleUtil(neighbor.data, visited, recStack) == false)
					return false;
				else if(recStack[neighbor.data] == true)
					return true;
							
			}
		}
		
		recStack[startNode] = false;
		return false;
	}
	public boolean detectCycle() {
		
		boolean visited[] = new boolean[v];
		Arrays.fill(visited, false);
		boolean[] recStack  = new boolean[v];

		for(int i=0; i<v; ++i) {
				if(detectCycleUtil(i, visited, recStack) == true)
					return true;
		}
		return false;
	}
}

public class Graphs {
	
	

	public static void main(String[] args) {

		Graph g = new Graph(6);
		int   i = 0;
		Node zero  = new Node(0);
		Node one   = new Node(1);
		Node two   = new Node(2);
		Node three = new Node(3);
		Node four  = new Node(4);
		Node five  = new Node(5);
		/*
		 *   0___1
		 *   |	/|\
		 *   | / | 2
		 *   |/  |/  
		 *   4___3
		 */
		
/*
 		Node four  = new Node(4);
		
		g.insert(zero, one);
		g.insert(zero, four);
		g.insert(one, zero);
		g.insert(one, four);
		g.insert(one, two);
		g.insert(one, three);
		g.insert(two, one);
		g.insert(two, three);
		g.insert(three, one);
		g.insert(three, four);
		g.insert(three, two);
		g.insert(four, three);
		g.insert(four, zero);
		g.insert(four, one);
		
*/
		g.insert(zero, one, 5);
		g.insert(zero, two, 3);
		g.insert(one, two, 2);
		g.insert(one, three, 6);
		g.insert(two, three, 7);
		g.insert(two, five, 2);
		g.insert(two, four, 4);
		g.insert(three, four, -1);
		g.insert(three, five, 1);
		g.insert(four, five, -2);
		
		
		System.out.println(++i+". Adjacency list");
		g.display();
		
		System.out.println("\n\n"+(++i)+". Finding Mother");
		g.findMother();
		
		System.out.println("\n\n"+(++i)+". DFS Closure");
		g.DFSClosure();
		
		System.out.println("\n\n"+(++i)+". BFS");
		g.BFS();
		
		System.out.println("\n\n"+(++i)+". DFS");
		g.DFS();
		
		System.out.println("\n\n"+(++i)+". DetectCycle");
		System.out.println(g.detectCycle());
		
		System.out.println("\n\n"+(++i)+". Iterative DFS");
		g.IterativeDFS();
		
		System.out.println("\n\n"+(++i)+". Topological Sort");
		g.topologicalSort();
		
		System.out.println("\n\n"+(++i)+". Longest Path");
		g.longestPath(1);
		
		
		
	}

}
