class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currVowels = 0;
        int n = s.length();
        // Count vowels in first k characters
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) currVowels++;
        }
        maxVowels = currVowels;
        // Slide window and count vowels in each substring
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i))) currVowels++;
            if (isVowel(s.charAt(i - k))) currVowels--;
            maxVowels = Math.max(maxVowels, currVowels);
        }
        return maxVowels;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}