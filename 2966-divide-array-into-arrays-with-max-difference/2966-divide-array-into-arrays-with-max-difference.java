import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to make it easier to form valid arrays

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 < nums.length) {
                // Create an array of size 3 with consecutive elements satisfying the condition
                int[] subArray = {nums[i], nums[i + 1], nums[i + 2]};
                
                // Check if the difference between any two elements is less than or equal to k
                if (subArray[2] - subArray[0] <= k) {
                    result.add(subArray);
                } else {
                    return new int[][]{}; // Return empty array if conditions are not satisfied
                }
            } else {
                return new int[][]{}; // Return empty array for incomplete arrays
            }
        }

        return result.toArray(new int[0][0]);
    }
}