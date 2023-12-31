class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstOccurrence = new int[26];
        int maxLength = -1;

        // Initialize first occurrence positions
        for (int i = 0; i < firstOccurrence.length; i++) {
            firstOccurrence[i] = -1;
        }

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstOccurrence[c - 'a'] == -1) {
                // First occurrence of the character
                firstOccurrence[c - 'a'] = i;
            } else {
                // Calculate the length between two occurrences
                maxLength = Math.max(maxLength, i - firstOccurrence[c - 'a'] - 1);
            }
        }

        return maxLength;
    }
}