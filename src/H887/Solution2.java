package H887;

/**
 * @author JwZheng
 * @date 2021/7/15 0:04
 */
public class Solution2 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                int min = N * N;
                for (int k = 1; k <= j; k++) {
                    min = Math.min(min, Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
                }
                dp[i][j] = min;
            }
        }
        return dp[K][N];
    }
}
