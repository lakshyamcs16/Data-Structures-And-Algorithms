/*

Given a binary tree, we install cameras on the nodes of the tree. 
Each camera at a node can monitor its parent, itself, and its immediate children.
Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 
Example 1:
Example 2:

Note:


*/

/*

Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.



*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public int minCameraCover(TreeNode root) {
        // there are two cases
        // case1: place camera, for sure the current node is covered, state 1;
        // case2: no camera at the current node
        // case2A: but one of its child or parent has camera, so it is covered, state 2
        // case2B: none of its neighbor has camaera, it is not covered, state 0;
        ans = 0;
        if(dfs(root) == 0){
            ans++;
        }
        return ans;
    }
    
    private int dfs(TreeNode node){
        if(node == null) return 2;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 0 || right == 0){// if any of its child is not covered, a camera is a must here
            ans ++;
            return 1;
        }else if(left == 2 && right == 2){
            return 0;
        }else{
            return 2;
        }
    }
}
