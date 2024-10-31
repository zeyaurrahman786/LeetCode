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
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> mp = new HashMap<>(); // old - new
        return cloneUtil(node, mp); // mp -> map
    }

    public Node cloneUtil(Node node, HashMap<Node, Node> mp) {
        Node newNode = new Node(node.val);
        mp.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            if (!mp.containsKey(neighbor)) {
                // cloned
                newNode.neighbors.add(cloneUtil(neighbor, mp));
            } else {
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;
    }
}