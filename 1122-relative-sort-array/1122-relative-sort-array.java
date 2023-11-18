class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] arr1Integer = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1Integer[i] = arr1[i];
        }

        // Map to store the index of each element in arr2
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }

        // Custom comparator to sort elements in arr1 based on their relative ordering in arr2
        Arrays.sort(arr1Integer, (a, b) -> {
            int indexA = indexMap.getOrDefault(a, Integer.MAX_VALUE);
            int indexB = indexMap.getOrDefault(b, Integer.MAX_VALUE);

            if (indexA != Integer.MAX_VALUE || indexB != Integer.MAX_VALUE) {
                return Integer.compare(indexA, indexB);
            } else {
                return Integer.compare(a, b);
            }
        });

        // Convert Integer[] back to int[]
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Integer[i];
        }

        return arr1;
    }
}