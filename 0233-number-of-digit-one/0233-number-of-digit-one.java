class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long factor = 1;

        while (n / factor > 0) {
            long currentDigit = (n / factor) % 10;
            long before = n / (factor * 10);
            long after = n % factor;

            if (currentDigit == 0) {
                count += before * factor;
            } else if (currentDigit == 1) {
                count += before * factor + after + 1;
            } else {
                count += (before + 1) * factor;
            }

            factor *= 10;
        }

        return count;
    }
}