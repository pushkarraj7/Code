class Solution {
    public boolean searchMatrix(int[][] matrix, int key) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    System.out.println("found at cell("+ i +", " + j +")");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }
}