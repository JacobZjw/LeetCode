package M91;

/**
 * @author JwZheng
 */
public class Solution2 {
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
            //1.10-26
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                if (s.charAt(i - 1) == '0') {
                    //1. 20 OR 10
                    dp[i] = dp[i - 2];
                } else {
                    //2. 11-19 and 21-26
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else if (s.charAt(i - 1) == '0') {
                return 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length];
    }
}
