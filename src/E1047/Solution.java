package E1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.reverse().toString();
    }
}
