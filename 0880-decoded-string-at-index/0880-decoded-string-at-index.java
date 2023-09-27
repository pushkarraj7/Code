class Solution {
    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            char c = S.charAt(i);

            if (Character.isDigit(c)) {
                size /= c - '0';
                K %= size;
            } else {
                if (K == 0 || K == size) {
                    return String.valueOf(c);
                }
                size--;
            }
        }

        return null;
    }
}