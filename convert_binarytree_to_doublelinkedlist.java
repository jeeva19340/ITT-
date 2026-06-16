class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

public class BinaryTreeToDLL {

    static Node head = null;
    static Node prev = null;

    static void convert(Node root) {

        if (root == null)
            return;

        convert(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convert(root.right);
    }
}
