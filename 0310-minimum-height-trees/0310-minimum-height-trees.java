class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int leavesSize = leaves.size();
            remainingNodes -= leavesSize;

            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adjacencyList.get(leaf)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> minHeightTrees = new ArrayList<>();
        while (!leaves.isEmpty()) {
            minHeightTrees.add(leaves.poll());
        }

        return minHeightTrees;
    }
}