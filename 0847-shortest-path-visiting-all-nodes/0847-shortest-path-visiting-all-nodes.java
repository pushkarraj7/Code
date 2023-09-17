class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int targetMask = (1 << N) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][1 << N];

        for (int i = 0; i < N; i++) {
            queue.offer(new int[] { i, 1 << i });
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];

                if (mask == targetMask) {
                    return steps;
                }

                for (int neighbor : graph[node]) {
                    int newMask = mask | (1 << neighbor);
                    if (!visited[neighbor][newMask]) {
                        queue.offer(new int[] { neighbor, newMask });
                        visited[neighbor][newMask] = true;
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}