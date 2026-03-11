/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;

        if(node.right == null){
            int tempLeft = dfs(node.left);
            return 1 + tempLeft;
        }
        else if(node.left == null){
            int tempRight = dfs(node.right);
            return 1 + tempRight;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        
      
        return 1 + Math.min(left, right);
    }
}
