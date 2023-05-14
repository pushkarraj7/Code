class Solution {
    public String reverseWords(String s) {
        s = s.trim();        // remove leading and trailing spaces
        String[] words = s.split("\\s+");       // split the string into words by one or more spaces
        StringBuilder sb = new StringBuilder();     // reverse the order of the words
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}