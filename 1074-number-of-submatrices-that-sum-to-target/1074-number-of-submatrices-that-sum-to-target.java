class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        // Calculate the prefix sum for each row
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // Iterate over all possible pairs of columns and use hashing to find submatrices
        for (int col1 = 0; col1 < cols; col1++) {
            for (int col2 = col1; col2 < cols; col2++) {
                Map<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1);
                int currentSum = 0;

                for (int row = 0; row < rows; row++) {
                    int colSum = matrix[row][col2] - (col1 > 0 ? matrix[row][col1 - 1] : 0);
                    currentSum += colSum;
                    count += counter.getOrDefault(currentSum - target, 0);
                    counter.put(currentSum, counter.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }
}