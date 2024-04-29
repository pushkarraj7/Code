// class Solution {
//     public int minOperations(int[] nums, int k) {
//         int xorAll = 0;
//         for (int num : nums) {
//             xorAll ^= num;
//         }

//         int xorK = xorAll ^ k;  // XOR of the target value

//         int minOps = Integer.MAX_VALUE;
//         int targetIndex = -1;  // Track the index of the element to modify

//         for (int i = 0; i < nums.length; i++) {
//             int diff = 0;
//             int temp = nums[i] ^ xorK;  // XOR to find different bits
//             while (temp != 0) {
//                 diff += temp & 1;  // Count different bits
//                 temp >>= 1;
//             }

//             // **Key Correction:** Consider operations within the same element
//             minOps = Math.min(minOps, diff + Integer.bitCount(nums[i]));
//         }

//         // If a direct match is found, return 1 operation
//         if (minOps == 0) {
//             return 0;
//         }

//         // Track the actual bits to flip (this part remains unchanged)
//         int targetNum = nums[targetIndex];
//         int flippedBits = 0;
//         while (targetNum != xorK) {
//             if ((targetNum & 1) != (xorK & 1)) {
//                 flippedBits++;
//             }
//             targetNum >>= 1;
//             xorK >>= 1;
//         }

//         return minOps + flippedBits;  // Account for both operations
//     }
// }


class Solution {
  public int minOperations(int[] nums, int k) {
    final int xors = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    return Integer.bitCount(k ^ xors);
  }
}
