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
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPseudoPalindromicPaths(root, 0);
    }

    private int countPseudoPalindromicPaths(TreeNode node, int pathCount) {
        if (node == null) {
            return 0;
        }

        // Update the frequency of the current digit in the path
        pathCount ^= 1 << (node.val - 1);

        if (node.left == null && node.right == null) {
            // Check if the path is pseudo-palindromic
            return (pathCount & (pathCount - 1)) == 0 ? 1 : 0;
        }

        // Recursively explore the left and right subtrees
        int leftCount = countPseudoPalindromicPaths(node.left, pathCount);
        int rightCount = countPseudoPalindromicPaths(node.right, pathCount);

        return leftCount + rightCount;
    }
}