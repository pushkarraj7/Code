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
    private int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Traverse the tree in reverse in-order (right -> node -> left)
        bstToGst(root.right);
        
        // Update the sum and node's value
        sum += root.val;
        root.val = sum;
        
        // Continue the traversal
        bstToGst(root.left);
        
        return root;
    }
}