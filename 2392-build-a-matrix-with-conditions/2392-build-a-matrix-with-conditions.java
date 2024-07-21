import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Perform topological sort to find the order for rows and columns
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        
        // If either rowOrder or colOrder is empty, return an empty matrix
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }
        
        // Create position maps for rows and columns
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        // Create the result matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }
    
    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        List<Integer>[] graph = new ArrayList[k + 1];
        
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return result.size() == k ? result : new ArrayList<>();
    }
}