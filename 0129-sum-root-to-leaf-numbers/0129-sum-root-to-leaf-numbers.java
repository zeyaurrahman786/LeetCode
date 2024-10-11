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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        num = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            return num;
        }

        return dfs(node.left, num) + dfs(node.right, num);
    }
}