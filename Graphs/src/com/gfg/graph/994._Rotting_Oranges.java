/*

    You are given an m x n grid where each cell can have one of three values:
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten
    orange becomes rotten.Return the minimum number of minutes that must elapse
    until no cell has a fresh orange. If this is impossible, return -1.

*/

/*
    Example 1:
        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4

    Example 2:
        Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
        Output: -1
        Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

    Example 3:
        Input: grid = [[0,2]]
        Output: 0
        Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int m = grid.length; int n = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        q.add(null);
        while(q.size() > 1) {
            if(q.peek() == null) {
                q.poll();
                count++;
                q.add(null);
                continue;
            }
            
            int[] dirs = q.poll();
            int x = dirs[0]; int y = dirs[1];
            
            int[] rows = {0, 0, -1, 1};
            int[] cols = {1, -1, 0, 0};
            
            for(int i=0; i<4; i++) {
                if(isValid(grid, x + rows[i], y + cols[i], m, n)) {
                    grid[x + rows[i]][y + cols[i]] = 2;
                    q.add(new int[]{x + rows[i], y + cols[i]});
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[][] grid, int x, int y, int m, int n) {
        return (
            x >= 0 && x<m && y>=0 && y<n && grid[x][y] == 1
        );
    }
}
​
