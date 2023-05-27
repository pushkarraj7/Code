class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, true);
        }
        for (int val : nums) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int maxLength = 0;
        int maxStart = 0;
        for (int val : nums) {
            if (map.get(val)) {
                int currentLength = 1;
                int currentStart = val;
                while (map.containsKey(currentStart + currentLength)) {
                    currentLength++;
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
            }
        }
        return maxLength;
    }
}
