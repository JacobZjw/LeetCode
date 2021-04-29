package J59;

import java.util.PriorityQueue;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if ((len = nums.length) == 0 || k == 0) {
            return new int[]{};
        } else if (k == 1) {
            return nums;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(len, (o1, o2) -> o2[0] - o1[0]);
        int[] ans = new int[len - k + 1];
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        for (int i = k - 1; i < len; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[index++] = queue.peek()[0];
        }
        return ans;
    }
}