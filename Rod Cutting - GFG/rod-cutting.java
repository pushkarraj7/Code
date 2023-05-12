//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int cutRod(int price[], int n) {
        // Initialize the dp array with 0s
        int dp[] = new int[n+1];
        
        // Calculate the maximum value obtainable for each subproblem
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j-1] + dp[i-j]);
            }
        }
        
        // Return the maximum value obtainable for the original problem
        return dp[n];
    }
}