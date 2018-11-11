package linkedlist;

/**
 * Created by abhishek on 08/11/18.
 */
public class SortedInsertDLL {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode t = head;
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        // data is less than head
        if (data < head.data) {
            node.next = head;
            head.prev = node;
            head = node;
            return head;
        }
        while (data >= t.data && t.next != null) {
            t = t.next;
        }
        // last node and data is >= last
        if (t.next == null && data >= t.data) {
            t.next = node;
            node.prev = t;
            // either both last node and data is < or only data is less
        } else if (data < t.data) {
            t.prev.next = node;
            node.prev = t.prev;
            node.next = t;
            t.prev = node;
        }
        return head;
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }
}
