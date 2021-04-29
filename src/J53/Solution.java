package J53;

/**
 * @author JwZheng
 * @date 2021/3/18 12:48
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int start = 0, n = nums.length, end = n - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
            return nums[start] == n - 1 ? n : start;
    }
}
