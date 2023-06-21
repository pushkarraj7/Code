class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = 1; i < days.length; i++) {
            dp[i] = dp[i - 1] + costs[0];

            int j = i - 1;
            while (j >= 0 && days[i] - days[j] < 7) {
                j--;
            }
            dp[i] = Math.min(dp[i], (j >= 0 ? dp[j] : 0) + costs[1]);

            while (j >= 0 && days[i] - days[j] < 30) {
                j--;
            }
            dp[i] = Math.min(dp[i], (j >= 0 ? dp[j] : 0) + costs[2]);
        }

        return dp[days.length - 1];
    }
}