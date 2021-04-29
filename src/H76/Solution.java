package H76;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution {
    Map<Character, Integer> sMap;
    Map<Character, Integer> tMap;

    public String minWindow(String s, String t) {
        int start = 0, end = -1, length = s.length(), min = Integer.MAX_VALUE;

        char[] sArray = s.toCharArray();
        int[] range = new int[2];

        sMap = new HashMap<>(length);
        tMap = new HashMap<>(t.length());
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        while (end < length) {
            ++end;
            if (end < length && tMap.containsKey(sArray[end])) {
                sMap.put(sArray[end], sMap.getOrDefault(sArray[end], 0) + 1);
            }
            while (judge() && start <= end) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    range[0] = start;
                    range[1] = start + min;
                }
                if (tMap.containsKey(sArray[start])) {
                    sMap.put(sArray[start], sMap.getOrDefault(sArray[start], 0) - 1);
                }
                ++start;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(range[0], range[1]);
    }

    private boolean judge() {
        for (Character ch : tMap.keySet()) {
            Integer val = tMap.get(ch);
            if (sMap.getOrDefault(ch, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public boolean check() {
        Iterator iter = tMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (sMap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
