class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickselect(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (left < right) {
            if (nums[left] < pivot) {
                left++;
            } else {
                swap(nums, left, --right);
            }
        }
        swap(nums, left, end);
        if (left == k) {
            return nums[left];
        } else if (left < k) {
            return quickselect(nums, left + 1, end, k);
        } else {
            return quickselect(nums, start, left - 1, k);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}