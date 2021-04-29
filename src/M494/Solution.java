package M494;

/**
 * 递归，DFS
 *
 * @author JwZheng
 * @date 2021/3/20 12:18
 */
public class Solution {
    int count;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        dfs(nums, S, 0, nums.length - 1);
        return count;
    }

    private void dfs(int[] nums, int S, int start, int end) {
        if (start >= end) {
            if (S == nums[end]) {
                count++;
            }
            if (S == -nums[end]) {
                count++;
            }
            return;
        }
        dfs(nums, S - nums[start], start + 1, end);
        dfs(nums, S + nums[start], start + 1, end);
    }
}
