package M438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution2 {
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

        int start = 0, end = pLen - 1, valid = 0;
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        while (end < sLen) {
            valid = 0;
            sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
            for (int i = start; i <= end; i++) {
                char ch = s.charAt(i);
                if (sMap.get(ch).equals(pMap.get(ch))) {
                    ++valid;
                }
            }

            if (valid == pLen) {
                ans.add(start);
            }
            sMap.put(s.charAt(start), sMap.getOrDefault(s.charAt(start), 0) - 1);
            ++start;
            ++end;
        }
        return ans;

    }
}
