class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return countAndMergeSort(prefixSum, 0, n + 1, lower, upper);
    }

    private int countAndMergeSort(long[] prefixSum, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = countAndMergeSort(prefixSum, left, mid, lower, upper) + 
                    countAndMergeSort(prefixSum, mid, right, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] merged = new long[right - left];
        for (int i = left, r = 0; i < mid; i++, r++) {
            while (j < right && prefixSum[j] - prefixSum[i] < lower) {
                j++;
            }
            while (k < right && prefixSum[k] - prefixSum[i] <= upper) {
                k++;
            }
            while (t < right && prefixSum[t] < prefixSum[i]) {
                merged[r++] = prefixSum[t++];
            }
            merged[r] = prefixSum[i];
            count += k - j;
        }

        System.arraycopy(merged, 0, prefixSum, left, t - left);

        return count;
    }
}