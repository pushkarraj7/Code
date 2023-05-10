class Solution {
    private int numRows;
    private int numCols;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int numIslands = 0;
        numRows = grid.length;
        numCols = grid[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == '1') {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}