package M8;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int i = 0, sign = 1;
        if (chars[i] == '-') {
            sign = -1;
            ++i;
        } else if (chars[i] == '+') {
            ++i;
        }
        int ans = 0;
        while (i < chars.length && Character.isDigit(chars[i])) {
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && (chars[i] - '0') > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && -(chars[i] - '0') < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + sign * (chars[i++] - '0');
        }
        return ans;
    }
}
