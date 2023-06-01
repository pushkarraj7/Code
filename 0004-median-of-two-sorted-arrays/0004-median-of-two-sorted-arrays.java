class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            int firstMedianIndex = totalLength / 2 - 1;
            int secondMedianIndex = totalLength / 2;
            double median1 = findKthElement(nums1, nums2, firstMedianIndex + 1);
            double median2 = findKthElement(nums1, nums2, secondMedianIndex + 1);
            return (median1 + median2) / 2.0;
        } else {
            int medianIndex = totalLength / 2;
            return findKthElement(nums1, nums2, medianIndex + 1);
        }
    }
    
    private double findKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k - 1];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, nums1.length) - 1;
            int newIndex2 = Math.min(index2 + half, nums2.length) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}