class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        count[j] = count[i];
                    } else if (dp[i] + 1 == dp[j]) {
                        count[j] += count[i];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[j]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                ans += count[i];
            }
        }
        return ans;
    }
}