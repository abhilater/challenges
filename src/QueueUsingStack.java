/**
 *  Uses a back stack with LIFO order and front stack with FIFO order
 *  i) When dequeue or peek is done on back stack, it transfers all to front
 *  ii) When enqueue needs to be done on front stack, it transfers all to back stack
 * Created by abhishek on 08/11/18.
 */
public class QueueUsingStack<T> {
    private Stack<T> back = new Stack<>();
    private Stack<T> front = new Stack<>();
    boolean isBack = true;

    public boolean isEmpty() {
        return back.isEmpty() && front.isEmpty();
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        if (isBack) {
            while (!back.isEmpty()) {
                front.push(back.pop());
            }
            isBack = false;
        }
        return front.peek();
    }

    public void enqueue(T data) {
        if (isBack) back.push(data);
        else {
            while (!front.isEmpty()) {
                back.push(front.pop());
            }
            back.push(data);
            isBack = true;
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        if (isBack) {
            while (!back.isEmpty()) {
                front.push(back.pop());
            }
            isBack = false;
        }
        return front.pop();
    }

}