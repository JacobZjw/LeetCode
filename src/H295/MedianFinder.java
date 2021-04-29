package H295;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 维护一个大顶堆和一个小顶堆，记录中间两个数
 *
 * @author JwZheng
 * @date 2021/3/29 10:16
 */
public class MedianFinder {
    Queue<Integer> smallHeap;
    Queue<Integer> bigHeap;
    int size;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>();
        bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        size = 0;
    }

    public void addNum(int num) {
        size++;
        if (!smallHeap.isEmpty() && smallHeap.peek() < num) {
            smallHeap.offer(num);
        } else {
            bigHeap.offer(num);
        }
        while (smallHeap.size() > bigHeap.size()) {
            bigHeap.offer(smallHeap.poll());
        }
        while (bigHeap.size() - smallHeap.size() > 1) {
            smallHeap.offer(bigHeap.poll());
        }
    }

    public double findMedian() {
        if ((size & 1) == 1) {
            return bigHeap.peek();
        }
        double a = bigHeap.peek();
        double b = smallHeap.peek();
        return (a + b) / 2;
    }
}
