package indi.yuantongchn.LC116;

//116. 填充每个节点的下一个右侧节点指针

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node level = root;
        while(level != null){
            Node cur = level;
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
}
