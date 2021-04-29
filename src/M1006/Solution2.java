package M1006;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 * @date 2021/4/1 10:36
 */
public class Solution2 {
    public int clumsy(int N) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(N--);
        int index = 0;
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        return stack.stream().mapToInt(k -> k).sum();
    }
}
