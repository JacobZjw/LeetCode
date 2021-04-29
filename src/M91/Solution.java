package M91;

/**
 * @author JwZheng
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return 1;
        }
        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= length; i++) {
            int temp = (int) (s.charAt(i - 1) - '0') + (int) (s.charAt(i - 2) - '0') * 10;
            if (temp >= 10 && temp <= 26) {
                if (temp % 10 == 0) {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else if (temp % 10 == 0) {
                return 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length];
    }
}
