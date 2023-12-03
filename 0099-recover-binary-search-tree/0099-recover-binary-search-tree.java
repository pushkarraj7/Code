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
    TreeNode firstIncorrectNode = null;
    TreeNode secondIncorrectNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        // Traverse the BST to find the incorrect nodes
        inorderTraversal(root);

        // Swap the values of the two incorrect nodes to recover the tree
        int temp = firstIncorrectNode.val;
        firstIncorrectNode.val = secondIncorrectNode.val;
        secondIncorrectNode.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Recursively traverse the left subtree
        inorderTraversal(node.left);

        // Check if the current node is out of order
        if (node.val < prevNode.val) {
            if (firstIncorrectNode == null) {
                firstIncorrectNode = prevNode;
            }
            secondIncorrectNode = node;
        }

        // Update the previous node
        prevNode = node;

        // Recursively traverse the right subtree
        inorderTraversal(node.right);
    }
}
