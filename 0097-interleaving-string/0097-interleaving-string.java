class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        
        // Create a 2D boolean array to store the intermediate results
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Initialize the first row and first column of the dp array
        dp[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
                dp[0][j] = true;
            }
        }
        // Compute the intermediate results for the remaining cells of the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                
                if ((s1.charAt(i - 1) == c && dp[i - 1][j]) || (s2.charAt(j - 1) == c && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        // The result will be stored in the bottom-right cell of the dp array
        return dp[m][n];
    }
}