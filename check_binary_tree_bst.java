class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

public class CheckBST {

    static boolean isBST(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean check(Node node, long min, long max) {

        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return check(node.left, min, node.data)
                && check(node.right, node.data, max);
    }
}
