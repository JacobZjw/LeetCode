package C1721;

/**
 * @author JwZheng
 * @date 2021/4/2 10:45
 */
public class Solution3 {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);
        }


        return ans;
    }
}
