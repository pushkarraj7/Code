class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        int circularMaxSum = totalSum - minSum;
        return Math.max(circularMaxSum, maxSum);
    }
}