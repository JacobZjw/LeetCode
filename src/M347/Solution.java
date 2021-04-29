package M347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author JwZheng
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //1: 次数 0:值
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(new Integer[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.add(new Integer[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        int i = 0;
        for (var o : queue) {
            res[i++] = o[0];
        }
        return res;
    }
}
