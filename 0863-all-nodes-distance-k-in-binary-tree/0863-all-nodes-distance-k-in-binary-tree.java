/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(parentMap, root);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                visited.add(curr);
                
                if (k == 0) {
                    res.add(curr.val);
                }
                
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                }
                
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                }
                
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                }
            }
            
            k--;
            if (k < 0) break;
        }
        
        return res;
    }
    
    private void findParent(HashMap<TreeNode, TreeNode> parentMap, TreeNode root) {
        if (root == null) return;
        
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
        
        findParent(parentMap, root.left);
        findParent(parentMap, root.right);
    }
}