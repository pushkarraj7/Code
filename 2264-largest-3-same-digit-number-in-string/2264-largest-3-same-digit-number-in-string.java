class Solution {
    public String largestGoodInteger(String num) {
        String result = "";

        for (int i = 0; i <= num.length() - 3; i++) {
            char digit = num.charAt(i);
            if (digit == num.charAt(i + 1) && digit == num.charAt(i + 2)) {
                // Update result only if the current substring is greater than the current result
                result = result.compareTo(String.valueOf(digit) + digit + digit) < 0 ?
                        String.valueOf(digit) + digit + digit : result;
            }
        }

        return result;
    }
}
