package M209;

/**
 * @author JwZheng
 * @description 暴力模拟
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 1;

        int sum = nums[0];
        if(sum >= s){
            return 1;
        }
        while (fast < length) {
            sum += nums[fast];
            if (sum < s) {
                ++fast;
            } else {
                ans = Math.min(ans, fast - slow + 1);
                sum = nums[++slow];
                fast = slow + 1;
                if (sum >= s) {
                    return 1;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
