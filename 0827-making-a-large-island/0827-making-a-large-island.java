class Solution {
    // Instance variables
    private int gridSize; // The length of the grid
    private int[] parent; // Parent array for the disjoint-set (Union-Find)
    private int[] clusterSize; // Size of each cluster in the disjoint-set
    private int maxIslandSize = 1; // Initialize the result to 1 as minimum island size
    private int[] directions = new int[] {-1, 0, 1, 0, -1}; // Directions for exploring neighbors

    // Method to calculate the largest island by flipping one zero to one, if possible.
    public int largestIsland(int[][] grid) {
        gridSize = grid.length;
        parent = new int[gridSize * gridSize];
        clusterSize = new int[gridSize * gridSize];

        // Initialize each point as its own parent and the initial size of 1
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
            clusterSize[i] = 1;
        }

        // Loop through each cell in the grid to perform Union-Find merge operations
        for (int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == 1) { // Process only the land cells
                    // Loop to check all 4 possible neighbors
                    for (int k = 0; k < 4; ++k) {
                        // Calculate neighboring coordinates based on current cell
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                      
                        // Check if the neighbor is within the grid and is land
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[x][y] == 1) {
                            int rootNeighbor = find(x * gridSize + y);
                            int rootCurrent = find(i * gridSize + j);
                            // If neighbors belong to different sets, perform union operation
                            if (rootNeighbor != rootCurrent) {
                                parent[rootNeighbor] = rootCurrent;
                                clusterSize[rootCurrent] += clusterSize[rootNeighbor];
                                // Update the max island size
                                maxIslandSize = Math.max(maxIslandSize, clusterSize[rootCurrent]);
                            }
                        }
                    }
                }
            }
        }

        // Consider flipping each zero to one and calculate the potential island size
        for (int i = 0; i < gridSize; ++i) {
            for (int j = 0; j < gridSize; ++j) {
                if (grid[i][j] == 0) { // Process only the water cells
                    int potentialSize = 1; // Initialize the potential size with the flipped cell
                    Set<Integer> visited = new HashSet<>(); // To avoid counting duplicate clusters
                    // Loop through all 4 directions
                    for (int k = 0; k < 4; ++k) {
                        int x = i + directions[k];
                        int y = j + directions[k + 1];
                        // Check for valid neighboring land cell
                        if (x >= 0 && x < gridSize && y >= 0 && y < gridSize && grid[x][y] == 1) {
                            int root = find(x * gridSize + y);
                            // Only count unique roots to prevent double counting
                            if (!visited.contains(root)) {
                                visited.add(root);
                                potentialSize += clusterSize[root];
                            }
                        }
                    }
                    // Update the maximum island size if current flip leads to a larger island
                    maxIslandSize = Math.max(maxIslandSize, potentialSize);
                }
            }
        }
        return maxIslandSize;
    }

    // Union-Find's find operation with path compression
    private int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]); // Path compression
        }
        return parent[index];
    }
}