package E155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class MinStack2 {
    Deque<Integer> data;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        data = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        data.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
