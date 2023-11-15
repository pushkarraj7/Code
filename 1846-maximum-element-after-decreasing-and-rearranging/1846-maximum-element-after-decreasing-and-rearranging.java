import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int maxElement = 1; // Initialize the maximum element after rearranging

        for (int i = 1; i < arr.length; i++) {
            // Make sure that each element is at most one greater than the previous element
            if (arr[i] > maxElement) {
                arr[i] = maxElement + 1;
            }

            // Update the maximum element after rearranging
            maxElement = arr[i];
        }

        return maxElement;
    }
}