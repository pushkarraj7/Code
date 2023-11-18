class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFrequency = 1;
        int left = 0;
        long sum = nums[0];

        for (int right = 1; right < nums.length; right++) {
            sum += nums[right];

            while ((long) nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}