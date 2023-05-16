class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Create a priority queue with custom comparator to get the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> wordCount.get(a).equals(wordCount.get(b)) ? b.compareTo(a) : wordCount.get(a) - wordCount.get(b)
        );
        
        // Step 3: Process each word and maintain a heap of size k
        for (String word : wordCount.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // Step 4: Build the result list in reverse order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }
        
        return result;
    }
}