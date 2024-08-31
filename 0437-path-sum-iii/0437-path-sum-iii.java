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
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if (root == null) {
            return 0;
        }

        // Running Path Sum for Root
        count += pathSumHelper(root, targetSum, 0);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }

    public int pathSumHelper(TreeNode root, int targetSum, long currentSum) {
        int count = 0;
        if (root == null) {
            return 0;
        }

        currentSum += root.val;

        if (currentSum == targetSum) {
            count++;
        }

        count += pathSumHelper(root.left, targetSum, currentSum);
        count += pathSumHelper(root.right, targetSum, currentSum);

        return count;

    }

}