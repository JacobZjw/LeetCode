package M394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JwZheng
 * @date 2021/3/21 12:28
 */
public class Solution1 {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.offerLast(ch);
                continue;
            }
            char[] chars = new char[stack.size()];
            int index = -1;
            while (!stack.isEmpty()) {
                chars[++index] = stack.pollLast();
                if (chars[index] == '[') {
                    --index;
                    break;
                }
            }
            int n = 0, m = 0;
            while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                n += Math.pow(10, m++) * (stack.pollLast() - '0');
            }
            for (int i = 0; i < n; i++) {
                for (int j = index; j >= 0; j--) {
                    stack.offerLast(chars[j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
