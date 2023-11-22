class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        int maxKey = 0;
        int totalElements = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;

                if (!diagonalMap.containsKey(key)) {
                    diagonalMap.put(key, new ArrayList<>());
                }

                diagonalMap.get(key).add(nums.get(i).get(j));
                totalElements++;
                maxKey = Math.max(maxKey, key);
            }
        }

        int[] result = new int[totalElements];
        int index = 0;

        for (int key = 0; key <= maxKey; key++) {
            List<Integer> diagonalElements = diagonalMap.get(key);

            if (diagonalElements != null) {
                Collections.reverse(diagonalElements);

                for (int element : diagonalElements) {
                    result[index++] = element;
                }
            }
        }

        return result;
    }
}