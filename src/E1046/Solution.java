package E1046;

import java.util.PriorityQueue;

/**
 * @author JwZheng
 * @date 2021/3/28 10:50
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (o, k) -> k - o);
        for (int stone : stones) {
            heap.offer(stone);
        }
        int a, b;
        while (heap.size() >= 2) {
            a = heap.poll();
            assert !heap.isEmpty();
            b = heap.poll();
            heap.offer(Math.abs(a - b));
        }
        if (heap.isEmpty()) {
            return 0;
        }
        return heap.poll();
    }
}
