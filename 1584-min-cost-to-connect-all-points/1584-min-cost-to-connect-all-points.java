class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        // Create a list to store edges (distance, u, v).
        List<int[]> edges = new ArrayList<>();
        
        // Calculate the distance between all pairs of points and store them as edges.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{distance, i, j});
            }
        }
        
        // Sort the edges by distance in ascending order.
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create an array to represent the disjoint set (Union-Find).
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        int minCost = 0;
        int edgesIncluded = 0;
        
        // Kruskal's algorithm: Connect vertices in ascending order of distances.
        for (int[] edge : edges) {
            int distance = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if (union(parent, u, v)) {
                minCost += distance;
                edgesIncluded++;
                
                if (edgesIncluded == n - 1) {
                    break; // We have connected all vertices.
                }
            }
        }
        
        return minCost;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return find(parent, parent[x]);
    }
    
    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {
            parent[rootX] = rootY;
            return true;
        }
        
        return false;
    }
}