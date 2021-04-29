package M153;

/**
 * @author JwZheng
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left + 1 <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                ans = Math.min(nums[left], nums[right]);
            } else {
                right = mid - 1;
                ans = Math.min(nums[mid], ans);
            }
        }
        ans = Math.min(ans, nums[left]);
        return ans;
    }
}
