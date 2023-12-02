class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        // Count characters in chars
        for (char c : chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if each word can be formed by characters from chars
        for (String word : words) {
            Map<Character, Integer> wordCount = new HashMap<>();

            // Count characters in the current word
            for (char c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
            }

            // Check if the word can be formed
            boolean canFormWord = true;
            for (char c : wordCount.keySet()) {
                if (!charCount.containsKey(c) || wordCount.get(c) > charCount.get(c)) {
                    canFormWord = false;
                    break;
                }
            }

            if (canFormWord) {
                result += word.length();
            }
        }

        return result;
    }
}