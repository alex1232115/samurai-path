package sprint5;

public class Solution {
    static int prev = Integer.MIN_VALUE;

    public static boolean treeSolution(Node head) {
        if (head == null) {
            return true;
        }
        if (!treeSolution(head.left)) return false;
        if (head.value <= prev) return false;
        prev = head.value;
        if (!treeSolution(head.right)) return false;
        return true;
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
    // <template>


    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }

    public static void main(String[] args) {
        Node node5 = new Node(25, null, null);
        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node9 = new Node(9, null, null);
        Node node8 = new Node(8, node9, null);
        Node node4 = new Node(4, node7, node8);
        Node node3 = new Node(3, node5, node6);
        Node node1 = new Node(1, node3, null);
        Node node2 = new Node(24, null, node4);
        Node node0 = new Node(10, node1, node2);
        System.out.println(treeSolution(node0));
    }
}
