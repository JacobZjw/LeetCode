package M209;

/**
 * @author JwZheng
 * @description 双指针
 */
public class Solution3 {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0,end = 0,sum = 0;
        while (end < length) {
            sum += nums[end++];
            while (sum >= s) {
                ans = Math.min(ans, end - start);
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
