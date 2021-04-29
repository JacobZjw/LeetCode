package J59;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author JwZheng
 * @date 2021/4/1 10:55
 */
public class MaxQueue {
    Queue<Integer> data;
    Deque<Integer> maxData;


    public MaxQueue() {
        data = new ArrayDeque<>();
        maxData = new ArrayDeque<>();
        maxData.offer(Integer.MIN_VALUE);
    }

    public int max_value() {
        if (data.isEmpty()) {
            return -1;
        }
        return maxData.peekFirst();
    }

    public void push_back(int value) {
        data.offer(value);
        while (!maxData.isEmpty() && maxData.peekLast() < value) {
            maxData.pollLast();
        }
        maxData.offerLast(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int ans = data.poll();
        if (ans == maxData.peekFirst()) {
            maxData.pollFirst();
        }
        return ans;
    }
}
