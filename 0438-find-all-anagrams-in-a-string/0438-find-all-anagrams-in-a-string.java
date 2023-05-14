class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] sCount = new int[26];

        while (right < s.length()) {
            char c = s.charAt(right);
            sCount[c - 'a']++;

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(sCount, pCount)) {
                    result.add(left);
                }
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return result;
    }
}
