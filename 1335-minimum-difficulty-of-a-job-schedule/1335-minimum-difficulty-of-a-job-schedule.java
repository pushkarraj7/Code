// class Solution {
//   public int minDifficulty(int[] jobDifficulty, int d) {
//     final int n = jobDifficulty.length;
//     if (n < d)
//       return -1;

//     // dp[i][k] := the minimum difficulty to schedule the first i jobs in k days
//     int[][] dp = new int[n + 1][d + 1];
//     Arrays.stream(dp).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE / 2));
//     dp[0][0] = 0;

//     for (int i = 1; i <= n; ++i)
//       for (int k = 1; k <= d; ++k) {
//         // max(job[j + 1..i])
//         int maxDifficulty = 0;
//         for (int j = i - 1; j >= k - 1; --j) {                       // 1-based
//           maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]); // 0-based
//           dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + maxDifficulty);
//         }
//       }

//     return dp[n][d];
//   }
// }


class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;

        int[][] dp = new int[d][n];

        // Initialize the first day's difficulty
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }

        // Fill the rest of the DP array
        for (int day = 1; day < d; day++) {
            for (int job = day; job < n; job++) {
                int maxDifficulty = jobDifficulty[job];
                dp[day][job] = Integer.MAX_VALUE;

                // Iterate backward to find the optimal difficulty
                for (int prevJob = job; prevJob >= day; prevJob--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[prevJob]);
                    dp[day][job] = Math.min(dp[day][job], dp[day - 1][prevJob - 1] + maxDifficulty);
                }
            }
        }

        return dp[d - 1][n - 1];
    }
}
