class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int remainingTarget, int start) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentList)); // Add a valid combination to the result
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Check if the current candidate is within the remaining target
            if (candidates[i] > remainingTarget) {
                break; // Since the array is sorted, further elements will also be greater than the target
            }

            currentList.add(candidates[i]); // Include the current candidate in the combination
            // Recursively call the function with the updated parameters
            backtrack(result, currentList, candidates, remainingTarget - candidates[i], i + 1);
            currentList.remove(currentList.size() - 1); // Backtrack by removing the last added element
        }
    }
}