package LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Task141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        if (head == null) return false;

        if (head.next == head) {
            return true;
        }

        while (head.next != null) {
            if (set.contains(head)) return true;

            set.add(head);

            head = head.next;
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
