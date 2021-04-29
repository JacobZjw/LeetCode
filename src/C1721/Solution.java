package C1721;

/**
 * @author JwZheng
 * @date 2021/4/2 10:15
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int volume = 0;
        for (int j : height) {
            volume -= j;
        }
        int l = 0, r = n - 1;
        int ptr = 1;
        while (l <= r) {
            while (l < n && height[l] < ptr) {
                l++;
            }
            while (r > 0 && height[r] < ptr) {
                r--;
            }
            if (r < l) {
                break;
            }
            volume += (r - l + 1);
            ptr++;
        }
        return Math.max(volume, 0);
    }
}
