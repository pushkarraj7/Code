class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        
        // Initialize a 2D array to store the count of arrays with k inverse pairs
        int[][] dp = new int[n + 1][k + 1];
        
        // Base case: there is one array with 0 inverse pairs (sorted array)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Dynamic programming to fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-i+1]
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
                }
            }
        }
        
        return dp[n][k];
    }
}