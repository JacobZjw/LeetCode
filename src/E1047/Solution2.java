package E1047;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class Solution2 {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().equals(ch)) {
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
