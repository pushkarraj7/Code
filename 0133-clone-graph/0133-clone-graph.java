/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // Create a mapping of original nodes to their clones
        Map<Node, Node> cloneMap = new HashMap<>();

        // Create the clone of the start node
        Node cloneNode = new Node(node.val);
        cloneMap.put(node, cloneNode);

        // Perform depth-first traversal to clone the graph
        cloneGraphDFS(node, cloneMap);

        return cloneNode;
    }

    private void cloneGraphDFS(Node node, Map<Node, Node> cloneMap) {
        // Iterate through the neighbors of the current node
        for (Node neighbor : node.neighbors) {
            if (!cloneMap.containsKey(neighbor)) {
                // Create the clone of the neighbor node
                Node cloneNeighbor = new Node(neighbor.val);
                cloneMap.put(neighbor, cloneNeighbor);

                // Recursively clone the neighbor's neighbors
                cloneGraphDFS(neighbor, cloneMap);
            }

            // Add the cloned neighbor to the cloned node's neighbors list
            cloneMap.get(node).neighbors.add(cloneMap.get(neighbor));
        }
    }
}