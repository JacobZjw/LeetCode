package M395;

/**
 * @author JwZheng
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int ret = 0, n = s.length();
        for (int i = 1; i < 26; i++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0, less = 0;
            while (r < n) {
                if (++cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;//窗口内字符种类数增加
                    less++;//不匹配的字符种类数增加
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;//不匹配的字符种类数减少
                }
                while (tot > i) {//窗口内字符种类数大于限定的数量
                    if (--cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;//不匹配数增加
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;//窗口内字符种类数减少，对应不匹配数减少
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
