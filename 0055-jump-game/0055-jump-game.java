class Solution {
    public boolean canJump(int[] nums) {
    int n = nums.length;
    int dp[] = new int[n];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] != -1 && j + nums[j] >= i) {
                dp[i] = dp[j] + 1;
                break;
            }
        }
    }
    return dp[n - 1] != -1;
    }
}
