class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int count = t.length();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (target.containsKey(c)) {
                if (target.get(c) > 0) {
                    count--;
                }
                target.put(c, target.get(c) - 1);
            }
            right++;
            
            while (count == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                if (target.containsKey(leftChar)) {
                    target.put(leftChar, target.get(leftChar) + 1);
                    if (target.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLength);
    }
}