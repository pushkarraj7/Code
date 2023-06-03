class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }

    private void backtrack(List<String> combinations, StringBuilder current, int open, int close, int n) {
        if (current.length() == n * 2) {
            combinations.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(combinations, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(combinations, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
