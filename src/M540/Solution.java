package M540;

/**
 * @author JwZheng
 * @since 2021/9/11 19:34
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid + 1] != nums[mid]) {
                if ((mid & 1) == 1) {
                    //如果是奇数，且最后两个数相等，则在右边
                    l = mid + 1;
                } else if ((mid & 1) == 0) {
                    r = mid;
                }
            } else if (nums[mid + 1] == nums[mid]) {
                if ((mid & 1) == 1) {
                    r = mid;
                } else if ((mid & 1) == 0) {
                    //如果是偶数，且最后两个数不等，在右边
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }
}
