class Solution {
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        String firstHalf = s.substring(0, length / 2);
        String secondHalf = s.substring(length / 2);

        return countVowels(firstHalf) == countVowels(secondHalf);
    }

    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}