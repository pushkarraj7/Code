class Interval {
    int start;
    int end;
    int index;
    
    Interval(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Interval[] sortedIntervals = new Interval[n];
        
        // Create Interval objects and store the start, end, and index
        for (int i = 0; i < n; i++) {
            sortedIntervals[i] = new Interval(intervals[i][0], intervals[i][1], i);
        }
        
        // Sort the Interval objects based on their start value
        Arrays.sort(sortedIntervals, (a, b) -> a.start - b.start);
        
        // Create a map to store the start values and their corresponding indices
        Map<Integer, Integer> startIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            startIndices.put(sortedIntervals[i].start, i);
        }
        
        // Find the right interval for each interval
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            
            // Binary search to find the right interval
            int left = 0;
            int right = n - 1;
            int index = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (sortedIntervals[mid].start >= end) {
                    index = sortedIntervals[mid].index;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            result[i] = index;
        }
        
        return result;
    }
}