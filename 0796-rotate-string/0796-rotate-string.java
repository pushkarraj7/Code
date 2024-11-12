class Solution {
    // Method to check if the string 'goal' can be obtained by rotating 's'.
    public boolean rotateString(String s, String goal) {
        // Check if the two strings are of the same length.
        // If they aren't, they cannot be rotations of each other.
        if (s.length() != goal.length()) {
            return false;
        }
      
        // Concatenate 's' with itself. In such a string, any rotation of 's'
        // would appear as a substring.
        String doubledS = s + s;

        // Check if the concatenated string contains 'goal' as a substring.
        // If it does, 'goal' is a rotation of 's'.
        return doubledS.contains(goal);
    }
}