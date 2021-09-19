package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author JwZheng
 * @since 2021/9/19 16:43
 */
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        System.out.println(queue);
        Heap<Integer> heap = new Heap<>(11, comparator);
        heap.add(2);
        heap.add(1);
        heap.add(3);
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove(6));
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }
}
