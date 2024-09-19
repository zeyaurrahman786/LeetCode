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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Solve(ans, root, 0); // 0 -> Level
        return ans;
    }

    public void Solve(List<List<Integer>> ans, TreeNode root, int level){
        if (root == null) return;
        if (level == ans.size()) ans.add(new ArrayList<>());
        ans.get(level).add(root.val); // N
        Solve(ans, root.left, level+1); // L
        Solve(ans, root.right, level+1); // R
    }
}