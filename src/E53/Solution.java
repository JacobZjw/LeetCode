package E53;

/**
 * @author JwZheng
 * @date 2021/4/5 11:53
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
