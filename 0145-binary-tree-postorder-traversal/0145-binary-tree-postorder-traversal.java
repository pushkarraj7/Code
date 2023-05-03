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
  public List < Integer > postorderTraversal(TreeNode root) {
    List < Integer > result = new ArrayList < > ();
    if (root == null) {
      return result;
    }
    Stack < TreeNode > stack = new Stack < > ();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(0, node.val); // add to the front of the list
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return result;
  }
}