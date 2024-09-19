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
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) 
            return null;
 
        //Swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree (root.left); // Left recursive call
        invertTree (root.right); // Right recursive call
        return root;
    }
}