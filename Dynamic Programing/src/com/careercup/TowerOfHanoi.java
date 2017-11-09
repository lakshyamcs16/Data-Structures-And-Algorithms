package com.careercup;


public class TowerOfHanoi {
 
	public void buildTower(char tower[]) {
	
		int n = tower.length;

		char aux [] = new char[n];
		char target[] = new char[n];
		tower(tower, aux, target, n);
	}
	
	public void tower(char[] initial, char[] aux, char[] target, int n) {
		
		if( n <= 1 ) {
			System.out.println("Move disk 1 from rod "+initial.toString() +" to "+target.toString());
			return;
		}
		
		else {
			tower(initial, target, aux, n - 1);
			System.out.println("Move disk "+n+" from rod "+initial.toString() +" to "+target.toString());
			tower(aux, initial, target, n - 1);
		}
		
		
	}
	
	
	public static void main(String[] args) {
	
		TowerOfHanoi hanoi = new TowerOfHanoi();
		char[] tower = {'A', 'B', 'C'};

		hanoi.buildTower(tower);
	}
}
