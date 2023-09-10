class Solution {
    public int countOrders(int n) {
        final int MOD = 1000000007;
        
        // dp[i] represents the number of valid orders for i pairs of deliveries.
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            // Calculate the number of ways to insert a new pair of pickups and deliveries.
            int pairs = 2 * i;
            long ways = (long) pairs * (pairs - 1) / 2;
            
            // Multiply by the number of valid positions to insert the new pair.
            dp[i] = (dp[i - 1] * ways) % MOD;
        }
        
        return (int) dp[n];
    }
}