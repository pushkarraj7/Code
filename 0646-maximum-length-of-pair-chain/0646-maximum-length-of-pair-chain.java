class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 1;
        int currentEnd = pairs[0][1];
        
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > currentEnd) {
                count++;
                currentEnd = pairs[i][1];
            }
        }
        return count;
    }
}