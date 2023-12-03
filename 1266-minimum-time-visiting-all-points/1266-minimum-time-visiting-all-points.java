class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int xDiff = Math.abs(points[i][0] - points[i - 1][0]);
            int yDiff = Math.abs(points[i][1] - points[i - 1][1]);

            // Calculate the diagonal moves (min of xDiff and yDiff)
            int diagonalMoves = Math.min(xDiff, yDiff);

            // Calculate the remaining vertical or horizontal moves
            int remainingMoves = Math.abs(xDiff - yDiff);

            // Total time for moving from points[i-1] to points[i]
            totalTime += diagonalMoves + remainingMoves;
        }

        return totalTime;
    }
}