package H239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 * @since 2021/8/15 20:08
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        for (int i = k - 1; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while (i - queue.peekFirst() > k) {
                queue.pollFirst();
            }
            ans[index++] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
