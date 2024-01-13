class Solution {
    public int minSteps(String s, String t) {
        int[] charCount = new int[26];

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            charCount[ch - 'a']--;
        }

        int steps = 0;

        for (int count : charCount) {
            if (count > 0) {
                steps += count;
            }
        }

        return steps;
    }
}