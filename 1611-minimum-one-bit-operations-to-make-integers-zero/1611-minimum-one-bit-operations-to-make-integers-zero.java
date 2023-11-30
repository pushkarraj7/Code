class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }
        int msb = 0;
        while ((1 << msb) <= n) {
            msb++;
        }
        return (1 << msb) - 1 - minimumOneBitOperations(n ^ (1 << (msb - 1)));
    }
}