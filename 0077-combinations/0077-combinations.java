class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(result, combination, 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtrack(result, combination, i + 1, n, k - 1);
            combination.remove(combination.size() - 1);
        }
    }
}