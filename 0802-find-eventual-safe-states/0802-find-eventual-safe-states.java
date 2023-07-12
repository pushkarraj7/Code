class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (isSafe(graph, colors, i)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private boolean isSafe(int[][] graph, int[] colors, int node) {
        if (colors[node] > 0) {
            return colors[node] == 2;
        }
        
        colors[node] = 1;
        
        for (int neighbor : graph[node]) {
            if (!isSafe(graph, colors, neighbor)) {
                return false;
            }
        }
        
        colors[node] = 2;
        return true;
    }
}