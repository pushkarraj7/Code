class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Sort the points based on x-coordinates
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int maxWidth = 0;

        // Calculate the horizontal distance between consecutive points
        for (int i = 1; i < points.length; i++) {
            int distance = points[i][0] - points[i - 1][0];
            maxWidth = Math.max(maxWidth, distance);
        }

        return maxWidth;
    }
}