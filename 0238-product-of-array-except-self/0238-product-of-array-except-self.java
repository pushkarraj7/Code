class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] output = new int[n];
    for (int i = 0; i < n; i++) {
      output[i] = 1;
    }
    int leftProduct = 1;
    for (int i = 0; i < n; i++) {
      output[i] *= leftProduct;
      leftProduct *= nums[i];
    }
    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
      output[i] *= rightProduct;
      rightProduct *= nums[i];
    }
    return output;
  }
}