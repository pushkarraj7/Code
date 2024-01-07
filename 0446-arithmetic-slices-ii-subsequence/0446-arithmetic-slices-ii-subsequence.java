class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;
        Map<Long, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                // Count the number of subsequences with the same difference
                int prevCount = dp[j].getOrDefault(diff, 0);
                int currentCount = dp[i].getOrDefault(diff, 0);
                totalCount += prevCount;

                // Update the number of subsequences ending at index i with the same difference
                dp[i].put(diff, currentCount + prevCount + 1);
            }
        }

        return totalCount;
    }
}