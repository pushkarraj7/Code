class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("Divisor cannot be zero");
        
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        int result = 0;
        while (dividendLong >= divisorLong) {
            int shift = 0;
            while (dividendLong >= (divisorLong << shift))
                shift++;
            
            dividendLong -= divisorLong << (shift - 1);
            result += 1 << (shift - 1);
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            result = -result;
        
        return result;
    }
}