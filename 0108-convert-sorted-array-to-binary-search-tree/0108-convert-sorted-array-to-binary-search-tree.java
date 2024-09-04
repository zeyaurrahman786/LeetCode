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
    public TreeNode add(int nums[] , int start , int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = add(nums , start , mid - 1);
        n.right = add(nums , mid + 1 , end);
        return n;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        root.val = nums[nums.length / 2];
        root.left = add(nums , 0 , nums.length / 2 - 1);
        root.right = add(nums , nums.length / 2 + 1 , nums.length - 1);
        return root;
    }
}