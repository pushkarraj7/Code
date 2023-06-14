// Top-down Approach
// TC : O(n^2)
// SC : O(1)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i < triangle.size(); i++){
            for(int j=0; j<triangle.get(i).size(); j++){
                int sum = 0;
                if(j ==0){
                    sum = triangle.get(i).get(j) + triangle.get(i-1).get(j);
                }
                else if(j == triangle.get(i).size()-1){
                    sum = triangle.get(i).get(j) + triangle.get(i-1).get(triangle.get(i-1).size()-1);

                }
                else {
                    int min = Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1));
                    
                    sum = min +triangle.get(i).get(j);
                }
                triangle.get(i).set(j,sum);
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}


// Bottom-up Approach
// TC : O(n^2)
// SC : O(1)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         for(int i = triangle.size()-2; i>=0; i--){
//             for(int j=0; j<triangle.get(i).size(); j++){
                
//                 int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                    
//                 int sum = min +triangle.get(i).get(j);
                
//                 triangle.get(i).set(j,sum);
//             }
//         }
//         return triangle.get(0).get(0);
//     }
// }


// Follow up
// TC : O(n^2)
// SC : O(n)

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
        
//         // Create an array to store the minimum path sums
//         int[] dp = new int[n];
        
//         // Initialize the last row of dp array with the values from the last row of the triangle
//         List<Integer> lastRow = triangle.get(n - 1);
//         for (int i = 0; i < n; i++) {
//             dp[i] = lastRow.get(i);
//         }
        
//         // Start from the second-to-last row and compute the minimum path sums
//         for (int i = n - 2; i >= 0; i--) {
//             List<Integer> currentRow = triangle.get(i);
            
//             // Update the dp array with the minimum path sums for the current row
//             for (int j = 0; j < currentRow.size(); j++) {
//                 dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
//             }
//         }
//         // The minimum path sum will be the value at the top of the dp array
//         return dp[0];
//     }
// }