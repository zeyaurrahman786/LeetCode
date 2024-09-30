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
// Algo Used: BFS Traversal
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> ans = new LinkedList<>();

        while (!q.isEmpty()) { // BFS
            double avg = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) { // taking the avg level by level
                TreeNode node = q.poll();
                avg += node.val;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(avg / size);
        }
        return ans;
    }
}