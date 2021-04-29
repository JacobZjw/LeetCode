package J63;

/**
 * @author JwZheng
 * @date 2021/4/9 10:54
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int min = prices[0], ans = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > min) {
                ans = Math.max(ans, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return ans;
    }
}
