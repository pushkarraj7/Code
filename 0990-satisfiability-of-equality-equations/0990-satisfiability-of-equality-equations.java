class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];

        // Initialize parent array
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union-Find: Connect variables in the same set
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                union(parent, x, y);
            }
        }

        // Check if variables in not-equal equations are in different sets
        for (String equation : equations) {
            if (equation.charAt(1) == '!' && find(parent, equation.charAt(0) - 'a') == find(parent, equation.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        parent[rootA] = rootB;
    }

    private int find(int[] parent, int a) {
        if (parent[a] != a) {
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];
    }
}