//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String longestCommonPrefix(String arr[], int n) {
        if (n == 0) {
            return "";
        }

        // Take the first string as a reference
        String reference = arr[0];

        // Iterate through each character of the reference string
        for (int i = 0; i < reference.length(); i++) {
            char currentChar = reference.charAt(i);

            // Check if the current character is common to all strings
            for (int j = 1; j < n; j++) {
                // If we reach the end of any string or find a mismatch, return the prefix
                if (i >= arr[j].length() || arr[j].charAt(i) != currentChar) {
                    return (i == 0) ? "-1" : reference.substring(0, i);
                }
            }
        }

        // If no mismatch is found, the entire reference string is the common prefix
        return reference;
    }
}