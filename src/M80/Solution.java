package M80;

import java.util.Arrays;

/**
 * @author JwZheng
 * @date 2021/3/27 12:16
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 1;
        for (int fast = 2; fast < n; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[++slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
