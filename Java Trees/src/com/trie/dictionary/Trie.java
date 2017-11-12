package com.trie.dictionary;

import java.util.LinkedList;
import java.util.Scanner;

class TrieNode {

	char element;
	int count;
	boolean isEnd;
	LinkedList<TrieNode> childlist;
	
	TrieNode(char ch) {
		element = ch;
		count   = 0;
		isEnd   = false;
	childlist   = new LinkedList<TrieNode>();
	}
	
	public TrieNode subNode(char ch) {
		
		for(TrieNode eachElement: childlist) {
			if(eachElement.element == ch) {
				return eachElement;
			}
		}
		
		return null;
	}
}

class TrieUtil {
	TrieNode root;
	
	TrieUtil() {
		root = new TrieNode(' ');
	}
	
	public void insert(String word) {
		
		if(search(word)) {
			return;
		}
		TrieNode current = root;
		for(char eachElement:word.toCharArray()) {
			
			TrieNode child = current.subNode(eachElement);
			if(child!= null) {
				current = child;
			}else {
				child = new TrieNode(eachElement);
				current.childlist.add(child);
				current = current.subNode(eachElement);
			}
			current.count++;

		}
		
		current.isEnd = true;
		
		
	}
	
	public boolean search(String word) {
		
		TrieNode current = root;
		for(char ch:word.toCharArray()) {
			if(current.subNode(ch) == null)
				return false;
			else
				current = current.subNode(ch);
		}
		
		if(current.isEnd)
			return true;
		
		return false;
	}
	
	public void remove(String word) {
		
		if(!search(word)) {
			System.out.println("Dude "+word+" doesn't even exist! What the hell are you doing?");
			return;
		}
		
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.subNode(ch);
			
			if(child.count == 1) {
				current.childlist.remove(child);
				return;
			}else {
				child.count--;
				current = child;
			}
		}
		
		current.isEnd = false;
	}
}

public class Trie {

	public static void main(String[] args) {
		 @SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);

	        /* Creating object of AATree */

	        TrieUtil t = new TrieUtil(); 

	        System.out.println("Trie Test\n");          

	        char ch;

	        /*  Perform tree operations  */

	        do    

	        {

	            System.out.println("\nTrie Operations\n");

	            System.out.println("1. insert ");

	            System.out.println("2. delete");

	            System.out.println("3. search");

	 

	            int choice = scan.nextInt();            

	            switch (choice)

	            {

	            case 1 : 

	                System.out.println("Enter string element to insert");

	                t.insert( scan.next() );                     

	                break;                          

	            case 2 : 

	                System.out.println("Enter string element to delete");

	                try

	                {

	                    t.remove( scan.next() ); 

	                }                    

	                catch (Exception e)

	                {

	                    System.out.println(e.getMessage()+" not found ");

	                }

	                break;                         

	            case 3 : 

	                System.out.println("Enter string element to search");

	                System.out.println("Search result : "+ t.search( scan.next() ));

	                break;                                          

	            default : 

	                System.out.println("Wrong Entry \n ");

	                break;   

	            }

	 

	            System.out.println("\nDo you want to continue (Type y or n) \n");

	            ch = scan.next().charAt(0);                        

	        } while (ch == 'Y'|| ch == 'y');               

	    }
}

