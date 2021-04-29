package M81;

/**
 * @author JwZheng
 * @date 2021/4/7 10:09
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[l] < nums[mid]) {
                //前半部分有序
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //后半部分有序
                if (nums[mid] <= target && nums[r] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return false;
    }
}
