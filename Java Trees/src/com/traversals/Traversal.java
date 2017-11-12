/*
 * Implementations:
 * 1.   BFS
 * 2.   Recursive in-order
 * 3.   Level by level
 * 4.   In-order without stack/recursion
 * 5.   size
 * 6.   [not done] Identical Trees
 * 7.   [not done] Threaded Trees
 * 8.   Height
 * 9.   Delete the tree
 * 10.  Mirror
 * 11.  Paths
 * 12.  Spiral
 * 13.  Max width
 * 14.  Diameter
 * 15.  Sum Tree
 * 16.  [do it next] Connect Nodes
 * 17.  SumOfPath
 * 18.  In-order Tree
 * 19.  Pre-Inorder to BST
 * 20.  Double Tree
 */

package com.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

class Res {
	int val;
}

public class Traversal {

	//----------------------------------------------------------------------------------------------

	static class Node{
		int data;
		Node left, right, nextRight;
		
		Node(){
			left = right = nextRight = null;
		}
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	//----------------------------------------------------------------------------------------------

	
	static Node root, root2;
	static int max = Integer.MIN_VALUE, preIndex, staticIndex;
	
	//----------------------------------------------------------------------------------------------

	void inorder(Node node){
		
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
		
	}
	
	//----------------------------------------------------------------------------------------------
	
	void BFS(Node node){
		
		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()){
			
			System.out.print(queue.peek().data+" ");
			Node n = queue.poll();
			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
			
		}
		
		
	}
	
	//-----------------------------------------------------------------------------------------------

	private void LevelTraversal(Node node) {
		if(node == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		System.out.println();
		int size = queue.size();
		
		while(!queue.isEmpty()){
			Node n = queue.peek();
			if(size>0){
				System.out.print(n.data+" ");
			}else{
				System.out.println();
				System.out.print(n.data+" ");
			    size = queue.size();
			}
			queue.poll();
			size--;


			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
			
		}
	}
	
	//-------------------------------------------------------------------------------------------------

	private void inorderWithoutStackOrRecursion(Node root) {
		if(root==null)
			return;
		Node current, pre;
		current = root;
		
		
		while(current!=null){
			/*
			 *  if left doesn't exist print the data of current node and move to right
			 */
			if(current.left == null){
				System.out.print(current.data+" ");
				current = current.right;
			}
			else{
				/*
				 * it means left exists, so move to left but don't lose the pointer to current
				 */
				pre = current.left;
				
				/*
				 * go to extreme right or unless node points back to the parent which means the 
				 * parent has also been printed and now we can make the pointer back to null which
				 * was pointing to the parent.
				 * 
				 * We basically find the pre-order predecessor and make it point to the current node.
				 */
				while(pre.right!=null && pre.right!=current)
					pre = pre.right;
				
				/*
				 * set the pointer back to current so that we can return back 
				 */
				if(pre.right == null){
					pre.right = current;
					current = current.left;
				}
				/*
				 * work for back pointer is over, make it null again (print middle node here)
				 */
				else{
					pre.right = null;
					System.out.print(current.data+" ");
					current = current.right;
				}
			}
		}
	}
	
	//-------------------------------------------------------------------------------------------------

	private int size(Node root) {
		if(root == null)
			return 0;
		else
		return (size(root.left) + size(root.right) + 1);
	}
	
	//-------------------------------------------------------------------------------------------------

	private int height(Node root) {
		if(root == null)
			return 0;
		else
		return Math.max(height(root.left)+1,height(root.right)+1);
	}

	//--------------------------------------------------------------------------------------------------

	private void delete(Node node) {
		if(node == null){
			System.out.println("   Bhai kuch ni hai delete karne ko..");
			return;
		}
		
		if(node.left == null && node.right == null){
			System.out.println("   Deleting node: "+node.data);
			node = null;
			return;
		}
		
		if(node.left!=null)
			delete(node.left);
		
		if(node.right!=null)
			delete(node.right);
		
		System.out.println("   Deleting node: "+node.data);
		root = null;
		
	}
	
	//--------------------------------------------------------------------------------------------------
	
	private void mirrorTree(){
		root = mirror(root);
	}
	
	private void inOrderForMirror(){
		inorder(root);
	}
	
	
	private Node mirror(Node node) {
			if(node == null)
				return node;
			
			Node left = mirror(node.left);
	        Node right = mirror(node.right);
	        node.left = right;
	        node.right = left;
			
			return node;
	}
	
	//----------------------------------------------------------------------------------------------

	private void path(Node node, String soFar) {
		if(node == null)
			return;
		
		if(node.left == null && node.right == null){
			System.out.println("  "+soFar+"->"+String.valueOf(node.data)+" ");
			return;
		}

		soFar += "->"+String.valueOf(node.data);
		path(node.left,soFar);
		path(node.right,soFar);
			
	}
	
	//------------------------------------------------------------------------------------------------

	private void spiral(Node node) {
		if(node == null)
			return;
		
		int level = 1;
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.add(node);
		System.out.println();
		int size = queue.size();
		
		while(!queue.isEmpty() || !stack.isEmpty()){
			Node n = queue.peek();
			if(size>0){
				if(level%2 == 0)
					stack.push(n);
				else
					System.out.print(n.data+"->");
			}else{
		    	

			    if(level%2 == 0 && size == 0){
			    	System.out.print("\n");
			    	while(!stack.isEmpty()){
			    		System.out.print(stack.pop().data+"->");			
			    	}
		    		System.out.print("\n");

			    	level++;
				    size = queue.size();
				    continue;
			    }else{
			    	level++;
				    size = queue.size();
				    
			    	if(level%2 == 0)
						stack.push(n);
					else{
						
						System.out.println();
				    	System.out.print(n.data+" ");
					}
			    	
			    }

			}
			queue.poll();
			size--;


			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
			
		}
		
	}
	
	//---------------------------------------------------------------------------------------------

	private int maxWidth(Node node) {
		
		if(node == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		System.out.println();
		int size = queue.size();
		int max = size;
		while(!queue.isEmpty()){
			Node n = queue.peek();
			if(size<=0){
				size = queue.size();
			    max = Math.max(max, size);
			}
			queue.poll();
			size--;


			if(n.left!=null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
			
		}
		return max;
	
	}
	
	//-------------------------------------------------------------------------------------------

	private int diameter(Node node) {
		if(node == null)
			return 0;
		
		int ldiameter = diameter(node.left);
		int rdiameter = diameter(node.right);
		
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		return (Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter)));
	}

	//--------------------------------------------------------------------------------------------

	private int sumTree(Node node) {
		if(node == null || (node.left == null && node.right == null))
			return node.data;
		
		int left = 0, right = 0;
		
		if(node.left!=null)
			 left = sumTree(node.left);
		if(node.right!=null)
			 right = sumTree(node.right);
		
		if((left + right) == node.data)
			return (left + right + node.data);
		
		return -1;
	}	
	
	//-----------------------------------------------------------------------------------------

	private int sumOfPath(Node node, int soFar) {
		if(node == null)
			return 0;
		
		 if(node.left==null && node.right == null){
			 soFar += node.data;
			 if(soFar>max)
				 max = soFar;
			 return max;
		 }
		 
		 soFar += node.data;
		 sumOfPath(node.left,soFar);
		 sumOfPath(node.right,soFar);
		 
		 return max;
		
	}
	
	//--------------------------------------------------------------------------------------------

	
	/*
	 * Inorder sequence: D B E A F C
	 * Preorder sequence: A B D E C F
	 * 
	 */
	public Node preOrderToBST(int pre[],int in[], int start, int end) {
		
		if(start>end)
			return null;
		
		Node node       = new Node(pre[preIndex++]);
		
		if(start == end) {
			return node;
		}
		
		
		
		int index      = search(in,start,end,node);
		
		node.left  = preOrderToBST(pre, in, start, index-1);
		node.right = preOrderToBST(pre, in, index+1, end);
		
		return node;
	}
	
	public int search(int arr[], int start, int end, Node key) {
		int i = 0;
		for(i= start; i<end; i++) {
			if(arr[i]==key.data)
				return i;
		}
		return i;
	}
	
	//-----------------------------------------------------------------------------------------

	private int convertToSumTree(Node root) {
		if(root == null || root.left == null && root.right == null) {
			return root.data;
		}
		int left = 0, right = 0, diff;
		
		if(root.left!=null)
			left = convertToSumTree(root.left);
		
		if(root.right!=null)
			right = convertToSumTree(root.right);
		
		diff = (left + right) - root.data;
		if(diff>=0)
			root.data += diff;
		if(diff<0) {
			
			if(root.left!=null) {
				root.left.data += -diff;
		    	left = convertToSumTree(root.left);
			}
			
			else if(root.right!=null) {
				root.right.data += -diff;
				right = convertToSumTree(root.right);
			}
			
			else {
				return -1;
			}
		}
		
		
		return root.data;
	}
	
	//---------------------------------------------------------------------------------------------

	public boolean identical(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}if((root1 == null && root2!=null) || (root1 !=null && root2 == null)) {
			return false;
		}
		if(root1.data!=root2.data) {
			return false;
		}
		
		if(identical(root1.left,root2.left) && identical(root1.right, root2.right))
			return true;
		
		return false;
		
		
	}
	
	//-------------------------------------------------------------------------------------------

	private Node inorderTree(int[] inorder, int start, int end) {
		
		if(start>end){
			return null;
		}
		
		int maxIndex = maxIndex(inorder, start, end);
		Node node = new Node(inorder[maxIndex]);
		
		if (start == end)
            return node;
		
		node.left = inorderTree(inorder, start, maxIndex-1);
		node.right = inorderTree(inorder, maxIndex+1, end);
		
		return node;
	}
	
	private int maxIndex(int[] inorder, int start, int end){
		int max = inorder[start], maxIndex = start;
		for(int i=(start+1); i<end; i++){
				if(inorder[i]>max){
					max = inorder[i];
					maxIndex = i;
				}
		}
		
		return maxIndex;
	}
	
	//--------------------------------------------------------------------------------------------

	public Node doubleTree(Node root) {
		
		Node nodeDouble = null;
		
		if(root == null)
			return null;
		
		nodeDouble 		= new Node(root.data);
		Node temp  		= root.left;
		root.left  		= nodeDouble;
		nodeDouble.left = temp;
		
		doubleTree(root.left.left);
		doubleTree(root.right);
		
		return root;
	}
	
	//-------------------------------------------------------------------------------------------

	/*
	 * It works only for COMPLETE BINARY TREES !
	 */
	public Node connectLevels(Node node) {
		
		if(node == null) {
			return null;
		}
		
		if(node.left!=null) {
			node.left.nextRight = node.right;
		}
		
		if(node.right!=null)
			node.right.nextRight = (node.nextRight!=null)? node.nextRight.left : null;
		
		connectLevels(node.left);
		connectLevels(node.right);
		return root;
	}
	
	//---------------------------------------------------------------------------------------------

	public void printWithNextRight(Node node) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			node = q.peek();
			
			while(node!=null) {
				
				Node key = q.poll();
				System.out.print(key.data+"->");
				
				if(key.left!=null) {
					q.add(key.left);
				}
				
				if(key.right!=null)
					q.add(key.right);
				
				node = key.nextRight;
			}
			System.out.println();
		}
	}

	//----------------------------------------------------------------------------------------------

	/*
	 * int preOrder[] = {10, 30, 20, 5, 15};
	 * char preLN[]   = {'N','N','L','L','L'};
	 * This is my own implementation. Please confirm it with the GFG
	 */
	public Node preLN(int pre[], char preLN[], int index, int length) {
		
		Node node = null;
		if(index<length) {
		index = staticIndex++;

		node = new Node(pre[index]);
		if(preLN[index] == 'N') {
			node.left = preLN(pre, preLN, index+1, length);
			node.right = preLN(pre, preLN, index+2, length);
		}
		
		if(preLN[index] == 'L') {
			node.left = null;
			node.right = null;
		}
		}
		
		return node;
	}
	
	//----------------------------------------------------------------------------------------------

	public void printBoundary(Node node) {
		System.out.println();
		printExtremeLeft(node);
		printBottom(node);
		
		if(node.right!=null)
			printRight(node.right);
		else if(node.left!=null)
			printRight(node.left);
	}
	private void printRight(Node node) {
		
		if(node.right!=null) {
		    printRight(node.right);
		    System.out.print(node.data+" ");
		}
		
		else if(node.left!=null) {
			printRight(node.left);	
			System.out.print(node.data+" ");
	    }

	}

	private void printBottom(Node node) {
		if(node == null)
			return;
		if(node.left == null && node.right == null)
			System.out.print(node.data+" ");
		
		printBottom(node.left);
		printBottom(node.right);
	}

	private void printExtremeLeft(Node node) {
		while(node!=null) {
			if(node.left == null && node.right == null)
				return;
			
			System.out.print(node.data+" ");

			if(node.left!=null) {
				node = node.left;
			}
			else if(node.right!=null) {
				node = node.right;
			}
		}
	}


	//---------------------------------------------------------------------------------------------------
	
	public Node leftSubtreeSum(Node node) {
		
		if(node == null)
			return null;
		
		if(node.left == null && node.right == null)
			return node;
		
		if(node.left!=null) {
			node.data += leftTreeSum(node.left);
			leftSubtreeSum(node.left);
		}
		
		if(node.right!=null) {
			leftSubtreeSum(node.right);

		}
		
		
		return node;
	}
	
	private int leftTreeSum(Node node) {

		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			return node.data;
		
		
		return node.data+leftTreeSum(node.left)+leftTreeSum(node.right);
	}
	
	public int maximumPathSum(Node node, Res res) {
		
		if(node == null)
			return 0;
		
		int l = maximumPathSum(node.left, res);
		int r = maximumPathSum(node.right, res);
		
		int single_val = Math.max(Math.max(l, r) + node.data, node.data);
		
		int including_root = Math.max(single_val, l + r + node.data);
		
		res.val = Math.max(including_root, res.val);
		
		return single_val;
	}
	
	public int maximumPathSum(Node node) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		
		maximumPathSum(node, res);
		return res.val;
	}

	//------------------------------------------MY IMPLEMENTATION-------------------------------------------
	public Node createTreeFromParentArray(int parent[]) {
		
		ArrayList<Node> nodes = new ArrayList<Node>(parent.length);
		int ind = 0;
		for(int i=0; i<parent.length; i++) {
				nodes.add(new Node(i));
			
			if(parent[i] == -1)
				ind = i;
		}

		for(int i=0; i<parent.length; i++) {
			
			if(parent[i] == -1)
				continue;
			
			Node chi  = nodes.get(i);
			
			Node par  = nodes.get(parent[i]);
			
			if(par.left==null)
				par.left = chi;
			
			else if(par.right==null)
				par.right = chi;
			
				
			nodes.set(parent[i], par);
		}
		
		return nodes.get(ind);
	}
	
	private Node commonAncestor(Node root, Node p, Node q) {
		
		if(!isCover(root, p) || !isCover(root, q))
			return null;
		
		return findCommonAncestor(root, p, q);
		
	}
	
	private Node findCommonAncestor(Node root, Node p, Node q) {
		if(root == null || root == p || root == q) {
			return root;	
		}
		
		boolean isOnLeft = isCover(root.left, p);
		boolean isOnRight = isCover(root.left, q);
		
		if(isOnLeft!=isOnRight) {
			return root;
		}
		
		root = isOnLeft ? root.left : root.left;
		return findCommonAncestor(root, p, q);
	}

	private boolean isCover(Node p, Node q) {
		if(p == null)
			return false;
		if(p == q)
			return true;
		else
			return isCover(p.left, q) || isCover(p.right, q);
	}

	HashMap<Integer, Integer> top = new HashMap<Integer, Integer>();
	public void topView(Node node, int level) {
	
		if(node == null)
			return;
		
		if(!top.containsKey(level))
			top.put(level, node.data);
		
		topView(node.left, level-1);
		topView(node.right, level+1);
		
	}
	
	public void showView() {
	
		Iterator<Entry<Integer, Integer>> itr = top.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getValue());
		}
	}
	
	public static void main(String[] args) {

		Traversal travel = new Traversal();
		/*
		 * 			10
		 * 		  /    \
		 * 		 5		15
		 * 		/ \    /  \
		 *     1   3  12  30
		 *     	     /  \
		 *     		11   7
		 *            \   \
		 *            45  42
		 * 
		 * 			26
		 * 		   /  \
		 * 		  10   6
		 * 		 /  \   \
		 *      4    6	21
		 *          / \
		 *         11 15
		 *         
		 * 		     	26
		 *      	   /  \
		 *     	      26   6
		 *           /    /
		 *          10   6
		 *         /  \
		 *        10  6 
		 *       /   / 
		 *      4   6
		 *     / 
		 *    4   
		 */
		
	    /*root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.right = new Node(30);
		root.left.left = new Node(1);
		root.right.left = new Node(12);
		root.left.right = new Node(3);
		root.right.left.left = new Node(11);
		root.right.left.right = new Node(7);
		root.right.left.left.right = new Node(45);
		root.right.left.right.right = new Node(42);*/
		
		root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(21);
		root.left.right.left = new Node(11);
		root.left.right.right = new Node(15);
		
		root2 = new Node(26);
		root2.left = new Node(10);
		root2.right = new Node(6);
		root2.left.left = new Node(4);
		root2.left.right = new Node(6);
		
		int in[]  	   = {4, 2, 5, 1, 6, 3};
		int pre[]      = {1, 2, 4, 5, 3, 6};
		
		int preOrder[] = {10, 30, 20, 5, 15, 1, 2};
		char preLN[]   = {'N','N','L','L','N','L','L'};

		int parent[]   = {-1, 0, 0, 1, 1, 3, 5};
		int i = 0;
		

		System.out.println(++i+". Inorder");
		travel.inorder(root);
		
		System.out.println("\n\n"+(++i)+". Top View");
		travel.topView(root, 0);
		travel.showView();
		
		System.out.println("\n\n"+(++i)+". Tree from Parent Array");
		travel.inorder(travel.createTreeFromParentArray(parent));
		
		System.out.println("\n\n"+(++i)+". Maximum Path Sum: \n"+travel.maximumPathSum(root));
		
		System.out.println("\n\n"+(++i)+". Common Ancestor: \n"+ 
		travel.commonAncestor(root, root.left.left, root.left.right.left).data);

		System.out.println("\n\n"+(++i)+". Convert to BST");
		travel.inorder(travel.preOrderToBST(pre, in, 0, pre.length-1));
		
		//confirm with GFG (seems right but not sure)
		System.out.println("\n\n"+(++i)+". PreLN to Tree");
		travel.inorder(travel.preLN(preOrder, preLN, 0, preLN.length));

		System.out.println("\n\n"+(++i)+". Left Sub tree sum");
		travel.leftSubtreeSum(root);
		travel.inorder(root);
				
		System.out.println("\n\n"+(++i)+". Print Boundary");
		travel.printBoundary(root);
		
		System.out.println("\n\n"+(++i)+". Connect Nodes");
		travel.printWithNextRight(travel.connectLevels(root));		
				
		System.out.println("\n\n"+(++i)+". Double Tree");
		travel.inorder(travel.doubleTree(root));
		
		System.out.println("\n\n"+(++i)+". Identical?\n"+travel.identical(root, root2));

		System.out.println("\n\n"+(++i)+". BFS");
		travel.BFS(root);
		
		System.out.print("\n\n"+(++i)+". Level by level");
		travel.LevelTraversal(root);
		
		System.out.println("\n\n"+(++i)+". Inorder without stack or recursion!");
		travel.inorderWithoutStackOrRecursion(root);
		
		System.out.println("\n\n"+(++i)+". Size of the tree is "+travel.size(root));
		
		System.out.println("\n\n"+(++i)+". Height of a tree is "+travel.height(root));
		
		System.out.println("\n\n"+(++i)+". Spiral");
		travel.spiral(root);
		
		System.out.println("\n\n"+(++i)+". Max Width "+travel.maxWidth(root));
				
		System.out.println("\n\n"+(++i)+". Diameter "+travel.diameter(root));

		System.out.print("\n\n"+(++i)+". IsSumTree: ");
		if(travel.sumTree(root)!=-1){
			System.out.println("True");
		}else{
			System.out.println("False");
		}

		
		System.out.print("\n\n"+(++i)+". ConvertToSumTree: ");
		if(travel.convertToSumTree(root)!=-1){
			 travel.inorder(root);
		}else{
			System.out.println("False");
		}
		
		System.out.println("\n\n"+(++i)+". Sum of max. Path: "+ travel.sumOfPath(root,0));

		System.out.println("\n\n"+(++i)+". Mirror");
		travel.mirrorTree();
		travel.inOrderForMirror();
		
		System.out.println("\n\n"+(++i)+". Paths");
		travel.path(root,"");
		
		
		
		System.out.println("\n\n"+(++i)+".Deleting the tree...");
		travel.delete(root);
		System.out.println("   Tree has been deleted!");
		
		int inorder[] = {5, 10, 40, 30, 28};
		System.out.println("\n\n"+(++i)+".Inorder Special Tree");
		Node node = travel.inorderTree(inorder,0,inorder.length-1);
		travel.inorder(node);

		
		
	}

	
}
