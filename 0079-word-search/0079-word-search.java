class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true; // Base case: All characters of the word have been found
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false; // Base case: Out of bounds, already visited, or current character doesn't match
        }

        visited[row][col] = true; // Mark current cell as visited

        // Recursively search in all four directions
        if (searchWord(board, word, row - 1, col, index + 1, visited) ||
            searchWord(board, word, row + 1, col, index + 1, visited) ||
            searchWord(board, word, row, col - 1, index + 1, visited) ||
            searchWord(board, word, row, col + 1, index + 1, visited)) {
            return true;
        }

        visited[row][col] = false; // Mark current cell as unvisited (backtracking)
        return false;
    }
}