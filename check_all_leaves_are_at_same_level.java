class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
    }
}

public class SameLevelLeaves {

    static int leafLevel = -1;

    static boolean check(Node root, int level) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null) {

            if (leafLevel == -1)
                leafLevel = level;

            return leafLevel == level;
        }

        return check(root.left, level + 1)
                && check(root.right, level + 1);
    }
}
