class Solution {

    // Array representing the parents of each node in the disjoint-set (union-find).
    private int[] parent;

    // Function to find the redundant connection, taking edges of a graph.
    public int[] findRedundantConnection(int[][] edges) {

        // Initialize the parent array for a maximum of 1010 nodes.
        parent = new int[1010];
        for (int i = 0; i < parent.length; i++) {
            // Initially, each node is its own parent (self loop).
            parent[i] = i;
        }

        // Iterate through all edges.
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            // If both nodes have the same parent, the edge is redundant.
            if (find(node1) == find(node2)) {
                return edge;
            }

            // Union the sets of two nodes by setting the parent of one as the other.
            parent[find(node1)] = find(node2);
        }
      
        // If no redundant connection is found, return null (should not happen according to the problem statement).
        return null;
    }

    // Recursive function to find the parent of a given node.
    private int find(int node) {

        // Path compression: if the node is not its own parent, recursively find its parent and update the reference.
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        // Return the parent of the node.
        return parent[node];
    }
}