package M438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution3 {
    Map<Character, Integer> sMap;
    Map<Character, Integer> pMap;

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen, pLen;
        if (s == null || (sLen = s.length()) == 0 || (pLen = p.length()) > sLen) {
            return ans;
        }
        pMap = new HashMap<>(pLen);
        sMap = new HashMap<>(pLen);
        for (Character key : p.toCharArray()) {
            pMap.put(key, pMap.getOrDefault(key, 0) + 1);
        }

        int start = 0, end = 0, valid = 0;
        while (end < sLen) {
            char ch = s.charAt(end);
            if (pMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (sMap.get(ch).equals(pMap.get(ch))) {
                    ++valid;
                }
                if (valid == pMap.size()) {
                    ans.add(start);
                }
            }
            ch = s.charAt(start);
            while (!pMap.containsKey(ch) && start < end) {
                ++start;
                ch = s.charAt(start);
            }
            if (end - start + 1 == pLen) {
                if (sMap.containsKey(ch) && sMap.get(ch).equals(pMap.get(ch))) {
                    --valid;
                }
                sMap.put(ch, sMap.getOrDefault(ch, 0) - 1);
                ++start;
            }
            ++end;
        }
        return ans;
    }
}
