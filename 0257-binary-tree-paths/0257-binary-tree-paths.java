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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        path += node.val;

        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }

        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }
}