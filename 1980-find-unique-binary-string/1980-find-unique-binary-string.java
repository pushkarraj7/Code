class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();

        for (String num : nums) {
            set.add(num);
        }

        for (int i = 0; i < (1 << n); i++) {
            String binaryString = Integer.toBinaryString(i);
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }

            if (!set.contains(binaryString)) {
                return binaryString;
            }
        }

        return ""; // This should not happen if there is a unique binary string.
    }
}