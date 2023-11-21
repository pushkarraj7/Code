class Solution {
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            int rev = reverse(num);
            int diff = num - rev;
            frequencyMap.put(diff, frequencyMap.getOrDefault(diff, 0) + 1);
        }

        for (int freq : frequencyMap.values()) {
            // Count the number of pairs that can be formed with the same difference
            count = (int) ((count + (long) freq * (freq - 1) / 2) % MOD);
        }

        return count;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}