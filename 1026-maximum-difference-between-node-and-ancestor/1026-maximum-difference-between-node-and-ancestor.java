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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int maxAncestor, int minAncestor) {
        if (node == null) {
            return maxAncestor - minAncestor;
        }

        // Update max and min ancestors for the current node
        maxAncestor = Math.max(maxAncestor, node.val);
        minAncestor = Math.min(minAncestor, node.val);

        // Recursively traverse left and right subtrees
        int leftDiff = dfs(node.left, maxAncestor, minAncestor);
        int rightDiff = dfs(node.right, maxAncestor, minAncestor);

        // Return the maximum difference among left, right, and current node
        return Math.max(Math.max(leftDiff, rightDiff), Math.max(node.val - minAncestor, maxAncestor - node.val));
    }
}