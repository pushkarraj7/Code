class Graph {
    private int n; // Number of nodes
    private List<int[]>[] adjList; // Adjacency list for the graph

    public Graph(int n, int[][] edges) {
        this.n = n;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            adjList[from].add(new int[]{to, cost});
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        adjList[from].add(new int[]{to, cost});
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{node1, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int cost = current[1];

            if (node == node2) {
                return cost;
            }

            if (cost > dist[node]) {
                continue;
            }

            for (int[] neighbor : adjList[node]) {
                int neighborNode = neighbor[0];
                int neighborCost = neighbor[1];

                if (cost + neighborCost < dist[neighborNode]) {
                    dist[neighborNode] = cost + neighborCost;
                    minHeap.offer(new int[]{neighborNode, dist[neighborNode]});
                }
            }
        }

        return -1; // No path exists
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */