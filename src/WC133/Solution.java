package WC133;

/**
 * @author JwZheng
 * @since 2021/9/19 12:40
 */
public class Solution {
    public int maxsumofSubarray(int[] arr) {
        int n = arr.length, max = arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
