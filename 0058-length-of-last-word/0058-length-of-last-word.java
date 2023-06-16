class Solution {
    public int lengthOfLastWord(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        int length = 0;
        int i = s.length() - 1;
        
        // Iterate backwards from the end of the trimmed string
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}