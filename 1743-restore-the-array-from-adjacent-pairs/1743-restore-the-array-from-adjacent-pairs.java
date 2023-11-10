class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        int n = adjacentPairs.length + 1;
        Set<Integer> visited = new HashSet<>();
        int[] result = new int[n];

        int startNode = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                startNode = entry.getKey();
                break;
            }
        }

        dfs(graph, visited, result, startNode, 0);

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int[] result, int node, int index) {
        visited.add(node);
        result[index] = node;

        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, result, neighbor, index + 1);
            }
        }
    }
}