/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// class Solution {
//     public Node connect(Node root) {
//         if (root == null)
//             return null;

//         Queue<Node> q = new LinkedList<>();
//         q.add(root);

//         while (!q.isEmpty()) {
//             int size = q.size();
//             Node dummy = new Node(0);
//             while (size-- > 0) {
//                 Node node = q.remove();
//                 dummy.next = node;
//                 dummy = dummy.next;

//                 if (node.left != null) {
//                     q.add(node.left);
//                 }
//                 if (node.right != null) {
//                     q.add(node.right);
//                 }
//             }
//         }
//         return root;
//     }
// }

// TC -> O(N)
// SC -> O(N)






class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node head = root;

        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;

            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }

        return root;
    }
}

// TC -> O(N)
// SC -> O(1)