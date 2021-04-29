package M787;

/**
 * @author JwZheng
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < flights.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[flights[i][0]][flights[i][1]] = flights[i][2];
            }
        }

        for (int i = 0; i < n - K; i++) {
            for (int j = 1; j <= K; j++) {
//                dp[i][i + j] = Math.min(dp[i][i+j],)
            }
        }


        return dp[src][dst];
    }
}
