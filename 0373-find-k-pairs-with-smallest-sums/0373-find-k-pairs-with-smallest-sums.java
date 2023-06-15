class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int num1 = pair[0];
            int num2 = pair[1];
            int index = pair[2];
            
            result.add(Arrays.asList(num1, num2));
            
            if (index + 1 < nums2.length) {
                pq.offer(new int[]{num1, nums2[index + 1], index + 1});
            }
            
            k--;
        }
        
        return result;
    }
}