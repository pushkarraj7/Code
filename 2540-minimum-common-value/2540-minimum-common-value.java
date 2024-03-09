class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the common value
            } else if (nums1[i] < nums2[j]) {
                i++; // Move pointer in nums1
            } else {
                j++; // Move pointer in nums2
            }
        }
        
        return -1; // No common value found
    }
}