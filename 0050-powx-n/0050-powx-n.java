class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                x = x * x;
                n = -(n / 2);
            } else {
                n = -n;
            }
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (n > 0) {
            if (n % 2 == 1) {
                result *= currentProduct;
            }
            
            currentProduct *= currentProduct;
            n /= 2;
        }        
        return result;
    }
}