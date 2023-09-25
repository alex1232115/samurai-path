package sprint5;

import java.util.LinkedList;
import java.util.Queue;

public class C {
    // # 1 decision
    public static boolean treeSolution1(Node head) {
        if (head == null) return true;

        return isMirror(head.left, head.right);
    }

    private static boolean isMirror(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.value == right.value && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
    // # 2 decision
    public static boolean treeSolution2(Node head) {
        if (head == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head.left);
        queue.add(head.right);

        while(!queue.isEmpty()) {
            Node root1 = queue.poll();
            Node root2 = queue.poll();

            if (root1 == null && root2 == null) {
                continue;
            } else if (root1 == null || root2 == null) {
                return false;
            } else if (root1.value != root2.value){
                return false;
            }
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
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
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(4, null, null);
        Node node4 = new Node(3, null, null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution1(node7);
        assert treeSolution2(node7);
    }

    public static void main(String[] args) {
        Node node7 = new Node(1, new Node(5, null, null), new Node(5, null, null));
        System.out.println(treeSolution1(node7));
        System.out.println(treeSolution2(node7));
    }
}
