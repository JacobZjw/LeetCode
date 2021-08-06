package M1726;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 * @date 2021/8/6 15:11
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> resMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int res = nums[i] * nums[j];
                resMap.put(res, resMap.getOrDefault(res, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer size : resMap.values()) {
            if (size <= 2) {
                continue;
            }
            ans += c(size / 2, 2) * 8;
        }

        return ans;
    }


    public int c(int down, int top) {
        int m = 1, n = 1;
        for (int i = down; i > (down - top); i--) {
            m *= i;
        }
        for (int i = top; i > 0; i--) {
            n *= i;
        }
        return m / n;
    }
}
