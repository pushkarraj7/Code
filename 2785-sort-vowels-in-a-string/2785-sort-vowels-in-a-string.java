class Solution {
    public String sortVowels(String s) {
        // Step 1: Extract vowels
        StringBuilder vowels = new StringBuilder();
        StringBuilder result = new StringBuilder(s);

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.append(c);
            }
        }

        // Step 2: Sort the extracted vowels
        char[] sortedVowels = vowels.toString().toCharArray();
        Arrays.sort(sortedVowels);

        // Step 3: Replace the original vowels with sorted vowels
        int vowelIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                result.setCharAt(i, sortedVowels[vowelIndex]);
                vowelIndex++;
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}