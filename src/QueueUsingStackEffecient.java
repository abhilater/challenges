/**
 * Uses a push stack for enqueing and pop stack for peeking and dequeing.
 * 1. Enqueue: i) Push to push stack
 *             ii) If pop stack is empty, transfer all from push stack to pop stack
 * 2. Dequeue: i) Pop from pop stack
 *             ii) If pop stack is empty, transfer all from push stack to pop stack
 * 3. Empty: i) Both stacks are empty
 *
 * Created by abhishek on 08/11/18.
 */
public class QueueUsingStackEffecient<T> {
    private Stack<T> pushStack = new Stack<>();
    private Stack<T> popStack = new Stack<>();

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        return popStack.peek();
    }

    public void enqueue(T data) {
        pushStack.push(data);
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        T data = popStack.pop();
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return data;
    }

}
