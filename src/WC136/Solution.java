package WC136;

import java.util.HashSet;
import java.util.Set;

/**
 * 暴力 hash ，超时
 *
 * @author JwZheng
 * @since 2021/9/19 12:51
 */
public class Solution {
    public int maxLength(int[] arr) {
        int n = arr.length, slow = 0, fast = 0, max = 0;
        Set<Integer> set = new HashSet<>(n);
        while (fast < n) {
            if (!set.add(arr[fast])) {
                max = Math.max(max, fast - slow);
                set.clear();
                ++slow;
                fast = slow - 1;
            }
            ++fast;
        }
        max = Math.max(max, fast - slow);
        return max;
    }
}
