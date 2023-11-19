class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int reductions = 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                reductions += n - i;
            }
        }

        return reductions;
    }
}