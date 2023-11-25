class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        int totalSum = 0;

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            prefixSum[i] = totalSum;
        }

        totalSum = 0;

        // Calculate suffix sums
        for (int i = n - 1; i >= 0; i--) {
            totalSum += nums[i];
            suffixSum[i] = totalSum;
        }

        int[] result = new int[n];

        // Calculate absolute differences
        for (int i = 0; i < n; i++) {
            result[i] = i * nums[i] - prefixSum[i] + suffixSum[i] - (n - 1 - i) * nums[i];
        }

        return result;
    }
}