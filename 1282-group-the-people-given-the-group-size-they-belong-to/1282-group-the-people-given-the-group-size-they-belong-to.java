class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            // If the group size doesn't exist in the map, create a new list for it.
            groupMap.putIfAbsent(size, new ArrayList<>());
            
            List<Integer> group = groupMap.get(size);
            group.add(i);
            
            // If the group size reaches its limit, add it to the result and create a new list.
            if (group.size() == size) {
                result.add(new ArrayList<>(group));
                group.clear();
            }
        }       
        return result;
    }
}