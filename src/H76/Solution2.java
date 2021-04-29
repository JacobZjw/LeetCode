package H76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution2 {
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int start = 0, end = 0, sLen = s.length();
        int valid = 0, minLen = Integer.MAX_VALUE, lRange = -1, rRange = -1;
        for (Character ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        while (end < sLen) {
            //不满足，窗口右增
            char ch = s.charAt(end);
            if (start <= end && tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (sMap.get(ch).equals(tMap.get(ch))) {
                    ++valid;
                }
            }
            ++end;
            //已经满足，窗口缩小
            while (valid == tMap.size()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    lRange = start;
                    rRange = start + minLen;
                }

                ch = s.charAt(start++);

                if (tMap.containsKey(ch)) {
                    if (sMap.get(ch).equals(tMap.get(ch))) {
                        --valid;
                    }
                    sMap.put(ch, sMap.getOrDefault(ch, 1) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(lRange, rRange);
    }
}
