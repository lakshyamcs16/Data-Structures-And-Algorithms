package com.gfg.backtrack;



public class KnightProblem {

	static int N = 8;


	static boolean isSafeMove(int x, int y, Integer board[][]) {
		
		return (x>=0 && x<N && y>=0  && y<N && board[x][y]==-1);
	}
	
	static <T> void printsol(T board[][]){
		for(T row[]:board){
			System.out.println();
			for(T col: row)
				System.out.print((int)col+"\t");
		}
	}
	static boolean solveKT() {
		Integer board[][] = new Integer[8][8];

		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				board[i][j] = -1;
		
		int x_axis[] = {2, 1, -1, -2, -2, -1, 1, 2};
		int y_axis[] = {1, 2, 2, 1, -1, -2, -2, -1};
		
		board[0][0] = 0;
		if(!solveKT( 0, 0, 1, board, x_axis, y_axis)){
			System.out.println("No solution exists");
			return false;
		}else{
				printsol(board);
		}
		
		
		return true;
		
	}
	
	static boolean solveKT(int x, int y, int move, Integer board[][], int x_axis[], int y_axis[]){
		
		int i, next_x, next_y;
		if(move == N*N)
			return true;
		
		for(i=0; i<8; i++){
			next_x = x + x_axis[i];
			next_y = y + y_axis[i];
			
			if(isSafeMove(next_x, next_y, board)){
				board[next_x][next_y] = move;
				if(solveKT(next_x, next_y, move+1, board, x_axis, y_axis))
					return true;
				else
					board[next_x][next_y] = -1;
			}
				
		}
		
		return false;
	}
	public static void main(String[] args) {
		solveKT();
	}

}
