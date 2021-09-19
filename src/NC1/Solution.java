package NC1;

/**
 * 大数加法
 *
 * @author JwZheng
 * @since 2021/9/19 13:31
 */
public class Solution {
    //9999 + 9999
    public String solve(String s, String t) {
        StringBuilder sb = new StringBuilder();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int temp = 0, ptr1 = sChars.length - 1, ptr2 = tChars.length - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            int sum = temp + sChars[ptr1--] - '0' + tChars[ptr2--] - '0';
            temp = sum / 10;
            sb.insert(0, sum % 10);
        }
        while (ptr1 >= 0) {
            int sum = temp + sChars[ptr1--] - '0';
            temp = sum / 10;
            sb.insert(0, sum % 10);
        }
        while (ptr2 >= 0) {
            int sum = temp + tChars[ptr2--] - '0';
            temp = sum / 10;
            sb.insert(0, sum % 10);
        }
        if (temp != 0)
            sb.insert(0, temp);
        return sb.toString();
    }
}
