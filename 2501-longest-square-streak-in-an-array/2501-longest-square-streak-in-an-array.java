class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            uniques.add(num);
        }

        int res = 1;

        for (int num : uniques) {
            int sqrt = (int) Math.sqrt(num);
            int streak = 1;

            // Skip numbers that are perfect squares of a smaller number in the set
            if (sqrt * sqrt == num && uniques.contains(sqrt)) {
                continue;
            }

            // Check for square streaks
            while (num < 1000 && uniques.contains(num * num)) {
                num *= num;
                streak++;
            }

            res = Math.max(res, streak);
        }

        return res == 1 ? -1 : res;
    }
}
