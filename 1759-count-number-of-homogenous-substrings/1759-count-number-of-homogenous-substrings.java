class Solution {
    private static final int MOD = 1000000007;

    public int countHomogenous(String s) {
        long total = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            total = (total + count) % MOD;
        }
        return (int) total;
    }
}