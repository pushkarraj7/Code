class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(result, queens, n, 0, columns, diag1, diag2);
        return result;
    }
    
    private void backtrack(List<List<String>> result, int[] queens, int n, int row, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            result.add(generateBoard(queens, n));
        } else {
            for (int col = 0; col < n; col++) {
                int d1 = row - col + n - 1;
                int d2 = row + col;
                if (!columns[col] && !diag1[d1] && !diag2[d2]) {
                    queens[row] = col;
                    columns[col] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;
                    backtrack(result, queens, n, row + 1, columns, diag1, diag2);
                    queens[row] = -1;
                    columns[col] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;
                }
            }
        }
    }
    
    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}