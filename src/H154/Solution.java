package H154;

/**
 * @author JwZheng
 * @date 2021/4/9 10:42
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end - 1) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] > nums[start]) {
                end = mid - 1;
            } else {
                start++;
            }
        }
        return Math.min(nums[start], nums[mid]);
    }
}
