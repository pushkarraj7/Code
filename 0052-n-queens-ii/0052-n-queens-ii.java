class Solution {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        int[] queens = new int[n];
        solveNQueens(queens, 0, n);
        return count;
    }

    private void solveNQueens(int[] queens, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPosition(queens, row, col)) {
                queens[row] = col;
                solveNQueens(queens, row + 1, n);
            }
        }
    }

    private boolean isValidPosition(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(queens[i] - col);
            if (diff == 0 || diff == row - i)
                return false;
        }
        return true;
    }
}