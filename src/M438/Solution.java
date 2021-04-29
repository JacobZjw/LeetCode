package M438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen, pLen;
        if (s == null || (sLen = s.length()) == 0 || (pLen = p.length()) > sLen) {
            return ans;
        }
        int l = 0, r = pLen - 1;

        int[] match = new int[128];
        int[] patten = new int[128];

        for (char ch : p.toCharArray()) {
            ++patten[ch];
        }
        char[] sArray = s.toCharArray();

        for (int i = l; i < r; i++) {
            ++match[sArray[i]];
        }

        while (r < sLen) {
            ++match[sArray[r]];
            int valid = 0;
            for (int i = l; i <= r; i++) {
                if (patten[sArray[i]] == match[sArray[i]]) {
                    valid++;
                }
            }
            if (valid == pLen) {
                ans.add(l);
            }
            ++r;
            --match[sArray[l++]];
        }
        return ans;
    }
}
