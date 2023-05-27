class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                } else {
                    int len = i - j;
                    if (len > ans) {
                        ans = len;
                    }
                }
            }

            // Release
            while (j < i) {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
            }
            
            if (!f1 && !f2) {
                break;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLength = 0;
//         int start = 0;
//         Map<Character, Integer> map = new HashMap<>();

//         for (int end = 0; end < s.length(); end++) {
//             char c = s.charAt(end);
//             if (map.containsKey(c)) {
//                 // Update the start pointer to the next position after the last occurrence of the character
//                 start = Math.max(start, map.get(c) + 1);
//             }
//             map.put(c, end); // Update the latest occurrence of the character

//             // Update the maximum length if necessary
//             maxLength = Math.max(maxLength, end - start + 1);
//         }

//         return maxLength;
//     }
// }