package M34;

/**
 * @author JwZheng
 * @since 2021/8/16 19:42
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, start = 0, r = nums.length - 1, end = r;
        int firstHit = -1;
        while (l <= r) {
            int mid = (r + l) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                firstHit = mid;
                break;
            }
        }
        if (firstHit == -1) {
            return new int[]{-1, -1};
        }
        r = firstHit;
        while (start < r) {
            int mid = (r + start) >> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                r = mid;
            }
        }
        l = firstHit;
        while (l <= end) {
            int mid = (end + l) >> 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{start, end};
    }
}
