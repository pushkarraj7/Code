public class Solution {
    public int minOperations(String s) {
        int count1 = 0;
        int count2 = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for alternating pattern starting with '0'
            if (i % 2 == 0) {
                if (s.charAt(i) != '0') {
                    count1++;
                } else {
                    count2++;
                }
            } else {
                // Check for alternating pattern starting with '1'
                if (s.charAt(i) != '1') {
                    count1++;
                } else {
                    count2++;
                }
            }
        }
        
        // Return the minimum count of operations needed to make s alternating
        return Math.min(count1, count2);
    }
}