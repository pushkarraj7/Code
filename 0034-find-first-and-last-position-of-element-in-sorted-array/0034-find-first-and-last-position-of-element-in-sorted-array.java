class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findPosition(nums, target, true);
        result[1] = findPosition(nums, target, false);
        return result;
    }

    private int findPosition(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target || (isFirst && nums[mid] == target))
                right = mid - 1;
            else
                left = mid + 1;

            if (nums[mid] == target)
                position = mid;
        }
        return position;
    }
}