package M8;

import java.util.ArrayList;

/**
 * @author JwZheng
 */
public class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        ArrayList<Integer> numList = new ArrayList<>();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != ' ') {
                break;
            }
        }
        if (i == chars.length) {
            return 0;
        }
        int isNegative = 1;
        if (chars[i] == '-') {
            isNegative = -1;
            ++i;
        } else if (chars[i] == '+') {
            ++i;
        }
        for (; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                numList.add(chars[i] - '0');
            } else {
                break;
            }
        }
        int ans = 0;
        for (int num : numList) {
            //重点在这里的溢出判断
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + isNegative * num;
        }
        return ans;
    }
}
