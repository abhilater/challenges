package stacksandqueues;

/**
 * Created by abhishek on 08/11/18.
 */
public class Stack<T> {
    private Node<T> top = null;

    public boolean isEmpty() {
        return (null == top);
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("stacksandqueues.Stack is empty");
        return top.data;
    }

    public void push(T data) {
        Node<T> n = new Node<>(data, null);
        if (!isEmpty()) {
            n.next = top;
        }
        top = n;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("stacksandqueues.Stack is empty");
        T data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node t = top;
        while (t != null) {
            sb.append(t.data).append("->");
            t = t.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
