package J49;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author JwZheng
 * @date 2021/4/8 10:23
 */
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        int index = 1;
        int[] ugly = new int[]{2, 3, 5};
        long ans = 1;
        while (index <= n) {
            ans = heap.poll();
            for (int j : ugly) {
                if (!heap.contains(ans * j)) {
                    heap.offer(ans * j);
                }
            }
            index++;
        }
        return (int) ans;
    }
}
