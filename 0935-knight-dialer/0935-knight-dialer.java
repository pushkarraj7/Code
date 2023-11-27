class Solution {
    public int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        int[][] moves = {
            {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9},
            {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}
        };

        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int next : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
                }
            }
        }

        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[n][j]) % MOD;
        }

        return result;
    }
}
