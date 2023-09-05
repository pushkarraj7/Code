class Solution {
    public int kthFactor(int n, int k) {
        int count = 0; // Counter for the kth factor
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    return i; // Return the kth factor
                }
            }
        }
        return -1; // If k is greater than the number of factors, return -1
    }
}