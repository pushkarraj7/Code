class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] div = new int[word.length()];
        long rem =0;
        for (int i = 0; i < word.length(); i++) {
            rem = rem * 10 + (word.charAt(i) - '0');
            rem %=m;
            if (rem == 0){
                div[i] = 1;
            }
        }
        return div;
    }
}