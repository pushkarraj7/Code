class Solution {
  public int minInsertions(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for (int i = 1; i < n; i++) {
      for (int j = 0, k = i; k < n; j++, k++) {
        if (s.charAt(j) == s.charAt(k)) {
          dp[j][k] = dp[j + 1][k - 1];
        } else {
          dp[j][k] = Math.min(dp[j][k - 1], dp[j + 1][k]) + 1;
        }
      }
    }

    return dp[0][n - 1];
  }
}