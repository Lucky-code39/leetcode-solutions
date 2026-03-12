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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return symmetric(root.left, root.right);
        
    }
    private boolean symmetric(TreeNode node, TreeNode node1){
        if(node == null && node1 == null) return true;

        if(node == null || node1 == null) return false;

        if(node.val != node1.val) return false;

        return symmetric(node.left, node1.right) && symmetric(node.right, node1.left);
    }
}
