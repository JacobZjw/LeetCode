package C1721;

/**
 * @author JwZheng
 * @date 2021/4/2 10:37
 */
public class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                continue;
            }
            int lHeight = height[i], rHeight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > lHeight) {
                    lHeight = height[j];
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (height[j] > rHeight) {
                    rHeight = height[j];
                }
            }
            ans += Math.max(0, Math.min(lHeight, rHeight) - height[i]);
        }
        return ans;
    }
}
