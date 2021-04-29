package M394;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JwZheng
 * @date 2021/3/21 12:28
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.offerLast(ch);
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty() && stack.peekLast() != '[') {
                temp.append(stack.pollLast());
            }
            stack.pollLast();
            int n = 0, m = 0;
            while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                n += Math.pow(10, m++) * (stack.pollLast() - '0');
            }
            temp.reverse();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < temp.length(); j++) {
                    stack.offerLast(temp.charAt(j));
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
