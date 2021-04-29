package E283;

/**
 * @author JwZheng
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while (l < nums.length && nums[l] != 0) {
            ++l;
        }
        while (l < nums.length && r < nums.length) {
            while (r < nums.length && nums[r] == 0) {
                ++r;
            }
            if (r >= nums.length) {
                break;
            }
            if(r > l){
                nums[l++] = nums[r];
            }
            r++;
        }
        for (int i = l; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
