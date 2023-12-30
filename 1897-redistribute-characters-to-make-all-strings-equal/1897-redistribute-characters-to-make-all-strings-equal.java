class Solution {
    public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];

        // Count the occurrences of each character in all words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
        }

        // Check if the counts are divisible by the number of words
        int numWords = words.length;
        for (int count : charCount) {
            if (count % numWords != 0) {
                return false;
            }
        }

        return true;
    }
}