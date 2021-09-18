package M34;

/**
 * @author JwZheng
 * @since 2021/8/16 19:19
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        int l = 0, r = nums.length - 1;
        boolean hitL = false, hitR = false;
        while (l <= r && (!hitL || !hitR)) {
            if (!hitL && nums[l] == target) {
                start = l;
                hitL = true;
            } else if (!hitL){
                l++;
            }

            if (!hitR && nums[r] == target) {
                end = r;
                hitR = true;
            } else if (!hitR){
                r--;
            }
        }
        return new int[]{start, end};
    }
}
