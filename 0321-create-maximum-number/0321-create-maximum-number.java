class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[k];

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] result = new int[k];
        int n = nums.length;
        int index = 0;

        for (int i = 0; i < n; i++) {
            while (index > 0 && n - i + index > k && nums[i] > result[index - 1]) {
                index--;
            }
            if (index < k) {
                result[index++] = nums[i];
            }
        }

        return result;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0, j = 0, index = 0;

        while (index < k) {
            if (greater(nums1, i, nums2, j)) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }

        return result;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }

        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}