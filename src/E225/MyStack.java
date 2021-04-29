package E225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JwZheng
 * @date 2021/3/23 10:40
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int whoIsEmpty;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        whoIsEmpty = 1;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (whoIsEmpty == 2) {
            //queue2 is empty
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            whoIsEmpty = 1;
        } else if (whoIsEmpty == 1) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            whoIsEmpty = 2;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return whoIsEmpty != 1 ? queue1.poll() : queue2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return whoIsEmpty != 1 ? queue1.peek() : queue2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
