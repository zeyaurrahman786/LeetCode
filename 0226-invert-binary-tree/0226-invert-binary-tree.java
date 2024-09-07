/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: end recursive call if current node is null
        if (root == null) {
            return null;
        }
        // We will do a post-order traversal of the binary tree.
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }

        // Let's swap the left and right nodes at current level.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}