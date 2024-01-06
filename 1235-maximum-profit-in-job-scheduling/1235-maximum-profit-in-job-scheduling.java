import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Create an array of jobs using the three input arrays
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort jobs based on their end times
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.endTime, b.endTime));

        // dp[i]: maximum profit up to job i
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            // Find the latest job that doesn't overlap with the current job
            int prevJobIndex = binarySearch(jobs, i);

            // Calculate the maximum profit by considering or not considering the current job
            int includeProfit = (prevJobIndex >= 0) ? dp[prevJobIndex] + jobs[i].profit : jobs[i].profit;
            int excludeProfit = dp[i - 1];

            // Update dp[i] with the maximum profit
            dp[i] = Math.max(includeProfit, excludeProfit);
        }

        return dp[n - 1];
    }

    // Binary search to find the latest job that doesn't overlap with the current job
    private int binarySearch(Job[] jobs, int currentJobIndex) {
        int low = 0, high = currentJobIndex - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].endTime <= jobs[currentJobIndex].startTime) {
                if (jobs[mid + 1].endTime <= jobs[currentJobIndex].startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1; // No non-overlapping job found
    }

    // Job class to represent each job with start time, end time, and profit
    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}