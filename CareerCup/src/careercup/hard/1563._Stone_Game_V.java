/*

There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.The game ends when there is only one stone remaining. Alice's is initially zero.Return the maximum score that Alice can obtain. Example 1:Example 2:Example 3: Constraints:


*/

/*

Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28
Input: stoneValue = [4]
Output: 0



*/

class Solution {
    public int stoneGameV(int[] s) {
        int n = s.length;
        //prefix array so that difference between left and right can be calculated in O(1)
        int[] prefix = new int[n];
        //2D DP array for each cut (length) vs. elements containing the actual sum
        int[][] dp = new int[n][n];
        prefix[0] = s[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + s[i];
        }
        
        return minimax5(s, prefix, 0, n-1, dp);
    }
​
    private int minimax5(int[] stones, int[] pre, int s, int e, int[][] dp) {
        //base case: no profit as game ends when there's only one stone left
        if(s==e) {
            return 0;
        }
        //return the memoized solution
        if(dp[s][e]!=0) return dp[s][e];
        int sum = 0, ans = Integer.MIN_VALUE;
        //make a cut at each length and find the one with maximum profit
        for(int i=s; i<e; i++) {
            int left = s == 0? 0 : pre[s-1];
            //calculate left and right sum at the cut using prefix array built earlier
            int pl = pre[i] - left; int pr = pre[e] - pre[i];
            sum = Math.min(pl, pr);
            
            //pick the one with lower value as the larger one will be thrown
            //in case of equal partition, we need to look both ways and find the one that returns maximum value
            if(pl>pr) {
                sum += minimax5(stones, pre, i+1, e, dp);
            }else if(pl<pr) {
                sum += minimax5(stones, pre, s, i, dp);
            }else{
                sum += 
                    Math.max(minimax5(stones, pre, i+1, e, dp), minimax5(stones, pre, s, i, dp));
            }
            //save the overall maximum
            ans = Math.max(ans, sum);
        }
        //memoize the answer and return
        return dp[s][e]=ans;
    }
}
​
