package E300;

/**
 * @author JwZheng
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
