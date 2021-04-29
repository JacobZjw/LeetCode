package M781;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 * @date 2021/4/4 17:24
 */
public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : answers) {
            int v = map.getOrDefault(i, 0);
            if (v == 0) {
                v = i + 1;
                ans += (i + 1);
            }
            map.put(i, v - 1);
        }
        return ans;
    }
}
