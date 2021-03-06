package E225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JwZheng
 * @date 2021/3/23 10:40
 */
public class MyStack2 {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}
