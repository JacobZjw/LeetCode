package M641;

/**
 * @author JwZheng
 * @since 2022/8/15 21:31
 */
public class Main {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertFront(4);
        deque.getRear();
    }
}
