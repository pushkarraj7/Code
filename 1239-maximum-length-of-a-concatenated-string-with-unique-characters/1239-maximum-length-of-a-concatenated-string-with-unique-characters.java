class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }

    private int backtrack(List<String> arr, int index, String current) {
        if (!isUnique(current)) {
            return 0;
        }

        int maxLength = current.length();

        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }

    private boolean isUnique(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] > 0) {
                return false;
            }
            count[ch - 'a']++;
        }

        return true;
    }
}