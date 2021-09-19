package NC119;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的 K 个数
 *
 * @author JwZheng
 * @since 2021/9/19 14:54
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>(k);
        PriorityQueue<Integer> queue = new PriorityQueue<>(input.length);
        for (int i : input) {
            queue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll());
        }
        return ans;
    }
}
