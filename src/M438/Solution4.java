package M438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution4 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen, pLen;
        if (s == null || (sLen = s.length()) == 0 || (pLen = p.length()) > sLen) {
            return ans;
        }
        int[] match = new int[26];
        int[] patten = new int[26];

        for (int i = 0; i < pLen; i++) {
            ++patten[p.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            int curRight = s.charAt(right) - 'a';
            match[curRight]++;
            while (patten[curRight] < match[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                match[curLeft]--;
                left++;
            }
            if (right - left + 1 == pLen) {
                ans.add(left);
            }
        }
        return ans;
    }
}
