class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        
        while (i < n && intervals[i][1] < newInterval[0]) {    // Add all intervals that come before the new interval
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        while (i < n && intervals[i][0] <= newInterval[1]) {    // Merge intervals that overlap with the new interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        mergedIntervals.add(newInterval);       // Add the merged interval

        while (i < n) {     // Add the remaining intervals
            mergedIntervals.add(intervals[i]);
            i++;
        }
        
        // Convert the list of intervals to a 2D array
        int[][] result = new int[mergedIntervals.size()][2];
        for (int j = 0; j < mergedIntervals.size(); j++) {
            result[j] = mergedIntervals.get(j);
        }
        return result;
    }
}