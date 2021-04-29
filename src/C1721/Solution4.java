package C1721;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 * @date 2021/4/2 11:03
 */
public class Solution4 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        int ans = 0;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    //左右最小高度减去底部凹槽
                    int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    int w = i - stack.peek() - 1;
                    ans += h * w;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
