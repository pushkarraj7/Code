class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int maxCoins = 0;

        for (int i = n; i < 3 * n; i += 2) {
            maxCoins += piles[i];
        }

        return maxCoins;
    }
}