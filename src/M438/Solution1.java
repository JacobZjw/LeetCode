package M438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen, pLen;
        if (s == null || (sLen = s.length()) == 0 || (pLen = p.length()) > sLen) {
            return ans;
        }
        int[] match = new int[26];
        int[] patten = new int[26];

        for (int i = 0; i < pLen; i++) {
            match[s.charAt(i) - 'a']++;
            patten[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(match, patten)) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            //窗口滑动
            match[s.charAt(i - pLen) - 'a']--;
            match[s.charAt(i) - 'a']++;
            if (Arrays.equals(match, patten)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
