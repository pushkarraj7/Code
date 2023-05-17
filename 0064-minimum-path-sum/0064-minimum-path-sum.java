class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Calculate the minimum path sum for the first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // Calculate the minimum path sum for the first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // Calculate the minimum path sum for each cell in the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}