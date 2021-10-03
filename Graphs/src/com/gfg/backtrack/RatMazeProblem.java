package com.gfg.backtrack;

public class RatMazeProblem {

	static int N = 5;
	
	/* Check for valid moves */
	static boolean isValidMove(int x, int y, Integer maze[][]){
		return (x>=0 && x<5 && y>=0 && y<4 && maze[x][y]==1);
	}
	
	/* solve the maze and print the solution, if any */
	static boolean solveMaze() {
		Integer maze[][] = {{1, 1, 1, 1},
						    {0, 0, 0, 1},
						    {1, 1, 1, 1},
						    {1, 0, 0, 0},
						    {1, 1, 1, 1}};
		int xMove[] = {0, 1, 0};
		int yMove[] = {1, 0, -1};
		
		maze[0][0] = -1;
		if(!solveMaze(0, 0, maze, xMove, yMove)){
			System.out.println("No solution exists!");
			return false;
		}else{
			KnightProblem.printsol(maze);
		}
		
		return false;
		
		
	}
	/* A utility recursive function for solving the maze */
	private static boolean solveMaze(int x, int y, Integer[][] maze, int[] xMove, int[] yMove) {
		int next_x, next_y, i;
		
		if( x == 4 && y == 3)
			return true;
		
		for(i=0; i<3; i++){
			next_x = x + xMove[i];
			next_y = y + yMove[i];
			// Keep trying as long as the move is valid
			if(isValidMove(next_x, next_y, maze)){
				maze[next_x][next_y] = -1;
				//if solved successfully, return true
				if(solveMaze(next_x, next_y, maze, xMove, yMove))
					return true;
				else
					//mark back to 1, backtrack
					maze[next_x][next_y] = 1;
			}
		}
		//back track the entire step
		return false;
	}


	public static void main(String[] args) {
		//call the solve maze function
		solveMaze();
	}

}
