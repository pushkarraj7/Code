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
    public int maxDepth(TreeNode root) {
         if (root == null)
            return 0;
        else {
            int ld = maxDepth(root.left);
            int rd = maxDepth(root.right);
 
            if (ld > rd)
                return (ld + 1);
            else
                return (rd + 1);
        }
    }
}