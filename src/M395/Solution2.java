package M395;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (var entry : map.entrySet()) {
            Character K = entry.getKey();
            Integer V = entry.getValue();
            if (V < k) {
                int res = 0;
                for (String str : s.split(String.valueOf(K))) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
