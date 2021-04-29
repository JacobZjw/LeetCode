package M779;

import java.util.Arrays;

/**
 * 动态规划，超出内存限制
 *
 * @author JwZheng
 * @date 2021/3/19 21:58
 */
public class Solution2 {

    /**
     * 第一行: 0
     * 第二行: 01
     * 第三行: 0110
     * 第四行: 0110 1001
     */
    public int kthGrammar(int N, int K) {
        if (K == 1) {
            return 0;
        }
        int[] dp = new int[K];
        dp[1] = 1;
        int l = 2;
        for (int i = 2; i < K; i++) {
            if (i + 1 > l * 2) {
                l *= 2;
            }
            dp[i] = ~dp[i % l] & 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[K - 1];
    }
}
