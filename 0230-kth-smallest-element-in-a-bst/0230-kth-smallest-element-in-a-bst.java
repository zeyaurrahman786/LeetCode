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
    int pos = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = inorder(root, k);
        if(node == null){
            return -1;
        }
        return node.val;
    }

    public TreeNode inorder(TreeNode root, int k){
        if (root == null){
            return root;
        }

        TreeNode left = inorder(root.left, k);
        if(left != null){
            return left;
        }

        // Print the root
        pos++;

        // current node is the target(kth smallest)
        if(pos == k){
            return root;
        }

        // TreeNode right = inorder(root.right, k);
        // if(right != null){
        //     return right;
        // }
        // retun null;

        return inorder(root.right, k);
    }
}