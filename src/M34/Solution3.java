package M34;

/**
 * @author JwZheng
 * @since 2021/9/11 20:01
 */
public class Solution3 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        int left = 0, right = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                int tmpR = mid;
                while (left < tmpR) {
                    int tmp = (left + tmpR) / 2;
                    if (nums[tmp] < target) {
                        left = tmp + 1;
                    } else if (nums[tmp] == target) {
                        tmpR = tmp;
                    }
                }
                int tmpL = mid;
                while (tmpL <= right) {
                    int tmp = (tmpL + right) / 2;
                    if (nums[tmp] == target) {
                        tmpL = tmp + 1;
                    } else if (nums[tmp] > target) {
                        right = tmp - 1;
                    }
                }
                break;
            }

        }
        return new int[]{left, right};
    }
}
