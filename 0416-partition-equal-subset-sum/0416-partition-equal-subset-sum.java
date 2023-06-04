class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, it cannot be divided into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];
        
        // Base case
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[nums.length][targetSum];
    }
}