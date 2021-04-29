package E278;

/**
 * @author JwZheng
 */
public class Solution {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid = 1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return mid;
    }

    public boolean isBadVersion(int n) {
        return n >= 1;
    }
}
