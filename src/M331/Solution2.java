package M331;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class Solution2 {
    //对Solution进行优化
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        char[] chars = preorder.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        if (chars[0] != '#') {
            stack.push(2);
        }
        int i = 1;
        while (i < n) {
            if (chars[i] == ',') {
                ++i;
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            int top = stack.pop();
            if (top > 1) {
                stack.push(--top);
            }
            if (chars[i] != '#') {
                while (i < n && chars[i] != ',') {
                    ++i;
                }
                stack.push(2);
            }
            ++i;
        }
        return stack.isEmpty();
    }
}
