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
  public List < List < Integer >> zigzagLevelOrder(TreeNode root) {
    List < List < Integer >> result = new ArrayList < > ();
    if (root == null) return result;
    Queue < TreeNode > queue = new LinkedList < > ();
    queue.offer(root);
    boolean reverse = false;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List < Integer > levelNodes = new ArrayList < > ();
      for (int i = 0; i < levelSize; i++) {
        TreeNode curr = queue.poll();
        levelNodes.add(curr.val);
        if (curr.left != null)
          queue.offer(curr.left);
        if (curr.right != null)
          queue.offer(curr.right);
      }
      if (reverse)
        Collections.reverse(levelNodes);
      result.add(levelNodes);
      reverse = !reverse;
    }
    return result;
  }
}