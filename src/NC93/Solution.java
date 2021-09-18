package NC93;

import java.util.*;

/**
 * Hash表+双向队列
 *
 * @author JwZheng
 * @since 2021/9/11 15:04
 */
public class Solution {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    private Map<Integer, Integer> map;
    private int K;
    private Deque<Integer> deque;

    public int[] LRU(int[][] operators, int k) {
        // write code here
        int m = operators.length;
        if (m == 0) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        map = new HashMap<>(k);
        K = k;
        deque = new ArrayDeque<>(k);
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                ans.add(get(operator[1]));
                continue;
            }
            set(operator[1], operator[2]);
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for (int num : ans) {
            res[index++] = num;
        }
        return res;
    }

    private int get(int key) {
        Integer ans = map.get(key);
        if (ans == null) {
            return -1;
        }
        flush(key);
        return ans;
    }

    private void set(int key, int value) {
        if (!map.containsKey(key)) {
            while (deque.size() >= K) {
                map.remove(deque.removeFirst());
            }
        }
        map.put(key, value);
        flush(key);
    }

    private void flush(int key) {
        deque.remove(key);
        deque.addLast(key);
    }
}
