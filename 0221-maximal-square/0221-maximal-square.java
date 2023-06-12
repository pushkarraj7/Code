class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int maxLength = 0;

        // Fill the first row of the dp matrix
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLength = Math.max(maxLength, dp[i][0]);
        }

        // Fill the first column of the dp matrix
        for (int j = 0; j < columns; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxLength = Math.max(maxLength, dp[0][j]);
        }

        // Calculate the remaining cells of the dp matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength * maxLength;
    }
}