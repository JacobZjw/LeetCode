package WC136;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap + 双指针；通过
 *
 * @author JwZheng
 * @since 2021/9/19 13:09
 */
public class Solution2 {
    public int maxLength(int[] arr) {
        int n = arr.length, slow = 0, fast, max = 0;
        Map<Integer, Integer> map = new HashMap<>(n >>> 1);
        for (fast = 0; fast < n; fast++) {
            Integer index = map.get(arr[fast]);
            if (index != null && index >= slow) {
                max = Math.max(max, fast - slow);
                //清除在 slow 之前的元素
                slow = index + 1;
            }
            map.put(arr[fast], fast);
        }
        return max == 0 ? n : max;
    }
}
