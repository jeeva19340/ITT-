class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
public class MergeBinaryTrees {
    static Node merge(Node t1, Node t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Node root = new Node(t1.data + t2.data);

        root.left = merge(t1.left, t2.left);
        root.right = merge(t1.right, t2.right);

        return root;
    }
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(3);
        t1.right = new Node(2);
        Node t2 = new Node(2);
        t2.left = new Node(1);
        t2.right = new Node(3);
        Node merged = merge(t1, t2);
        inorder(merged);
    }
}
