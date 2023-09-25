package sprint5;

public class B {

    public static boolean treeSolution(Node head) {

        int leftDepth = 0;
        int rightDepth = 0;
        if (head.left != null) {
            leftDepth = findHeight(head.left);
        }
        if (head.right != null) {
            rightDepth = findHeight(head.right);
        }
        if (leftDepth == Integer.MIN_VALUE || rightDepth == Integer.MIN_VALUE) return false;
        return (Math.abs(rightDepth - leftDepth) <= 1);
    }

    private static int findHeight(Node root) {
        if (root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(rightHeight - leftHeight) >= 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // <template>

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}
