class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Initialize each child with 1 candy.
        Arrays.fill(candies, 1);
        
        // First pass: Check left neighbors and update candies.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Second pass: Check right neighbors and update candies while ensuring that each child gets the maximum.
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Calculate the total number of candies needed.
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
}