package linkedList;

public class MyLinkedList {
    Node headNode = null;
    int size = 0;

    public MyLinkedList() {
        headNode = new Node();
    }

    public int get(int index) {
        Node currentNode = headNode;

        if (index >= 0) {
            while (index != 0) {
                index--;
                currentNode = currentNode.next;
            }
            return currentNode.val;

        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0){
            headNode.val = val;
        } else {
            node.next = headNode;
            headNode = node;
        }
        size++;
    }

    public void addAtTail(int val) {

        Node current = headNode;
        Node node = new Node(val);
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;

        if (index == size) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            Node node = new Node(val);
            Node current = headNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            System.out.println("Exception size in deleteAtIndex");;
        } else if (index == 0){
            headNode = headNode.next;
            size--;
        } else {
            Node current = headNode;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public static class Node {
        int val = 0;
        Node next = null;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}

