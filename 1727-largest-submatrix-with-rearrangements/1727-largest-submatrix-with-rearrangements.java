class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Calculate the heights of consecutive 1s for each column
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int maxArea = 0;

        // Sort each row and calculate the area of the largest submatrix
        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, matrix[i][j] * (n - j));
            }
        }

        return maxArea;
    }
}