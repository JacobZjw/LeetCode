package M739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 *
 * @author JwZheng
 * @date 2021/3/20 12:04
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
