class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            int firstOccurrence = s.indexOf(c);
            int lastOccurrence = s.lastIndexOf(c);

            if (firstOccurrence != -1 && lastOccurrence != -1 && firstOccurrence < lastOccurrence) {
                Set<Character> middleChars = new HashSet<>();
                for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
                    middleChars.add(s.charAt(i));
                }
                count += middleChars.size();
            }
        }

        return count;
    }
}