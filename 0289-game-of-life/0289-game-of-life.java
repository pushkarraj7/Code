class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Define the eight possible neighbors of a cell
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        // Perform the game of life simulation
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                // Count the live neighbors of the current cell
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && Math.abs(board[newRow][newCol]) == 1) {
                        liveNeighbors++;
                    }
                }
                
                // Apply the game of life rules to update the cell's state
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // Cell dies due to underpopulation or overpopulation
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    // Cell becomes alive due to reproduction
                    board[i][j] = 2;
                }
            }
        }
        
        // Update the board with the new cell states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}