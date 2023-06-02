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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Flatten the left subtree
        flatten(root.left);
        
        // Flatten the right subtree
        flatten(root.right);
        
        // Store the right subtree in a temporary variable
        TreeNode rightSubtree = root.right;
        
        // Make the left subtree the right subtree of the root
        root.right = root.left;
        root.left = null;
        
        // Find the rightmost node of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Attach the original right subtree to the rightmost node
        current.right = rightSubtree;
    }
}