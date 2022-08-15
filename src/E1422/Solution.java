package E1422;

/**
 * @author JwZheng
 * @since 2022/8/14 19:41
 */
public class Solution {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int ret = 0, len = chars.length;
        for (int i = 1; i < len; i++) {
            int score = 0;

            for (int j = 0; j < i; j++) {
                if (chars[j] == '0')
                    score++;
            }

            for (int j = i; j < len; j++) {
                if (chars[j] == '1')
                    score++;
            }
            ret = Math.max(ret, score);
        }
        return ret;
    }
}
