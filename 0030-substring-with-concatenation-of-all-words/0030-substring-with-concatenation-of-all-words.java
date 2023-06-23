class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int substringLength = wordLength * totalWords;

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words)
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= s.length() - substringLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            while (j < totalWords) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (wordCountMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    if (seenWords.get(word) > wordCountMap.getOrDefault(word, 0))
                        break;
                } else {
                    break;
                }
                j++;
            }
            if (j == totalWords)
                result.add(i);
        }

        return result;
    }
}