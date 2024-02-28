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
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
    TreeNode node = null;

    while (!q.isEmpty()) {
      node = q.poll();
      if (node.right != null)
        q.offer(node.right);
      if (node.left != null)
        q.offer(node.left);
    }

    return node.val;
  }
}