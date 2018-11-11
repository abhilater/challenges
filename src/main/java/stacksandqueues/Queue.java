package stacksandqueues;

/**
 * Created by abhishek on 08/11/18.
 */
public class Queue<T> {
    private Node<T> front = null;
    private Node<T> back = null;

    public boolean isEmpty() {
        return null == front;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("stacksandqueues.Queue is empty!");
        return front.data;
    }

    public void enqueue(T data) {
        Node<T> n = new Node<>(data, null);
        if (isEmpty()) {
            back = n;
            front = n;
        } else {
            back.next = n;
            back = n;
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("stacksandqueues.Queue is empty!");
        T data = front.data;
        if (front == back) {
            back = null;
            front = null;
        } else {
            front = front.next;
        }
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node t = front;
        while (t != null) {
            sb.append(t.data).append("->");
            t = t.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args){
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        System.out.println("Dequed: "+ q.dequeue());
        System.out.println("Dequed: "+ q.dequeue());
        System.out.println("Dequed: "+ q.dequeue());
        System.out.println(q);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println("Dequed: "+ q.dequeue());
        q.enqueue(7);
        System.out.println(q);
        //System.out.println("Dequed: "+ q.dequeue());
    }
}
