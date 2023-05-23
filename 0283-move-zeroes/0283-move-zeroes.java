class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[zeroCount] = nums[i];
                zeroCount++;
            }
        }
        while (zeroCount < n) {
            nums[zeroCount] = 0;
            zeroCount++;
        }
    }
}
