/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.Given an integer n, return all distinct solutions to the n-queens puzzle.Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. Example 1:Example 2: Constraints:


*/

/*

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Input: n = 1
Output: [["Q"]]



*/

class Solution {
    public List<List<String>> solveNQueens(int n) {        
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
​
        nqueens(res, board, 0, 0, n, 1);
        
        
        return res;
    }
    
    private void nqueens(List<List<String>> res, int[][] board, int x, int y, int n, int index) {
        if(x<n && x>=0 && y<n && y>=0) {
            for(int i=0; i<n; i++) {
                if(isValid(board, i, y, n)) {
                    board[i][y] = 1;
                    
                    if(index == n) {
                        addBoardToResult(res, board);
                    }
                    
                    nqueens(res, board, i, y + 1, n, index + 1);
                }
​
                board[i][y] = 0;
            }
        }        
    }
    
    private boolean isValid(int[][] board, int x, int y, int n) {
        if(x < n && y < n) {
            //check row
            for(int i=0; i<n; i++) {
                if(y != i && board[x][i] == 1) {
                    return false;
                }
            }
            
            //check diag
            int i = x + 1, j = y + 1;
            while(i<n && j<n) {
                if(board[i][j] == 1) return false;
                i++; j++;
            }
            
            i = x - 1; j = y - 1;
            while(i>=0 && j>=0) {
                if(board[i][j] == 1) return false;
                i--; j--;
            }
            
            i = x + 1; j = y - 1;
            while(i<n && j>=0) {
                if(board[i][j] == 1) return false;
                i++; j--;
            }
            
​
