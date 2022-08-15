package M641;

import java.time.temporal.Temporal;
import java.util.TimerTask;

/**
 * @author JwZheng
 * @since 2022/8/15 20:43
 */
public class MyCircularDeque {

    private final int[] data;
    private int head = 0;
    private int tail = 0;
    private int len;

    public MyCircularDeque(int k) {
        data = new int[k + 1];
        len = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        head = (head - 1 + len) % len;
        data[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        data[tail] = value;
        tail = (tail + 1) % len;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head = (head + 1) % len;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail = (tail - 1 + len) % len;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return data[head];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return data[(tail - 1 + len) % len];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return head == (tail + 1) % len;
    }
}
