package linkedlist;

/**
 * Created by abhishek on 08/11/18.
 */
public class DetectCycle {

    boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }


    static int findMergeNode(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        while(t1 != t2){
            t1 = (t1 == null)? head1 : t1.next;
            t2 = (t2 == null)? head2 : t2.next;
        }
        return t1.data;
    }

    class Node {
        int data;
        Node next;
    }
}
