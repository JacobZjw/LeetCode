package E1422;

/**
 * @author JwZheng
 * @since 2022/8/14 20:08
 */
public class Solution2 {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int sum = 0, l = s.length();
        if (chars[0] == '0')
            sum++;
        for (int i = 1; i < l; i++) {
            if (chars[i] == '1')
                sum++;
        }
        int ret = sum;
        for (int i = 1; i < l - 1; i++) {
            if (chars[i] == '0') {
                sum++;
            } else {
                sum--;
            }
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}
