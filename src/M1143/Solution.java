package M1143;

import java.util.Arrays;

/**
 * @author JwZheng
 * @date 2021/4/3 12:26
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int l1 = chars1.length, l2 = chars2.length;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (chars2[j - 1] == chars1[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[l1][l2];
    }
}
