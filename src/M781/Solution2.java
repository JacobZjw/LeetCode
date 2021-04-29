package M781;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 * @date 2021/4/4 18:02
 */
public class Solution2 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            ans += (k + v) / (k + 1) * (k + 1);
        }
        return ans;
    }
}
