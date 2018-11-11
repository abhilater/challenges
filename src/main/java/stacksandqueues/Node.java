package stacksandqueues;

/**
 * Created by abhishek on 08/11/18.
 */
public class Node<T> {
    public T data;
    public Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "stacksandqueues.Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}