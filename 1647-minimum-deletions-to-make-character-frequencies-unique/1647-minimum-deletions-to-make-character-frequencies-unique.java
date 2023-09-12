class Solution {
    public int minDeletions(String s) {
        // Create a map to store character frequencies.
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each character in the string.
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Create a set to keep track of unique frequencies.
        Set<Integer> uniqueFrequencies = new HashSet<>();
        
        int deletions = 0;
        
        for (int frequency : frequencyMap.values()) {
            while (uniqueFrequencies.contains(frequency)) {
                // If the frequency is not unique, decrement it and increment deletions.
                frequency--;
                deletions++;
            }
            
            if (frequency > 0) {
                // Add the current frequency to the set of unique frequencies.
                uniqueFrequencies.add(frequency);
            }
        }
        return deletions;
    }
}