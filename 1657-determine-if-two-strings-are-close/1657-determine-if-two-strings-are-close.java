class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            freqMap1.put(ch, freqMap1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0) + 1);
        }

        if (!freqMap1.keySet().equals(freqMap2.keySet())) {
            return false;
        }

        int[] countFreq1 = freqMap1.values().stream().mapToInt(Integer::intValue).sorted().toArray();
        int[] countFreq2 = freqMap2.values().stream().mapToInt(Integer::intValue).sorted().toArray();

        for (int i = 0; i < countFreq1.length; i++) {
            if (countFreq1[i] != countFreq2[i]) {
                return false;
            }
        }

        return true;
    }
}