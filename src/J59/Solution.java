package J59;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if ((len = nums.length) == 0 || k == 0) {
            return new int[]{};
        } else if (k == 1) {
            return nums;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                //队列永远按照元素从大到小顺序存储
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for (int i = k - 1; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                //队列永远按照元素从大到小顺序存储
                queue.pollLast();
            }
            //队列里面要存索引，因为要计算什么时候过期该出队
            queue.offerLast(i);
            while (i - queue.peek() >= k) {
                queue.poll();
            }
            ans[index++] = nums[queue.peek()];
        }
        return ans;
    }
}
