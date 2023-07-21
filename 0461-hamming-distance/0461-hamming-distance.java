class Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        int distance = 0;

        while (xorResult != 0) {
            distance++;
            xorResult &= (xorResult - 1);
        }
        return distance;
    }
}