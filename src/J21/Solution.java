package J21;

import java.util.ArrayList;

/**
 * @author JwZheng
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int start = 0, end = 1;
        while (end < nums.length && start < nums.length) {
            while (end < nums.length && nums[end] % 2 == 0) {
                end++;
            }
            while (start < nums.length && nums[start] % 2 == 1) {
                start++;
            }
            if (start >= nums.length || end >= nums.length) {
                break;
            }
            if (start < end) {
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start++] ^= nums[end++];
            } else {
                end++;
            }
        }
        return nums;
    }
}
