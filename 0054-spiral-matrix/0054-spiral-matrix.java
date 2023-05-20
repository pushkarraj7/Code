class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        
        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {     // Traverse top row
                result.add(matrix[top][col]);
            }
            top++;
            
            for (int row = top; row <= bottom; row++) {     // Traverse right column
                result.add(matrix[row][right]);
            }
            right--;
            
            // Check if there are remaining rows and columns
            if (top <= bottom && left <= right) {
                for (int col = right; col >= left; col--) {     // Traverse bottom row
                    result.add(matrix[bottom][col]);
                }
                bottom--;
                
                for (int row = bottom; row >= top; row--) {     // Traverse left column
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}