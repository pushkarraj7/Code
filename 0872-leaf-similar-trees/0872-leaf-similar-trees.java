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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Traverse both trees and collect leaf values
        dfs(root1, leaves1);
        dfs(root2, leaves2);

        // Compare the leaf value sequences
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        // If the current node is a leaf, add its value to the list
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        // Recursively traverse the left and right subtrees
        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }
}