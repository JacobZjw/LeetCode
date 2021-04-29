package M1006;

/**
 * @author JwZheng
 * @date 2021/4/1 10:14
 */
public class Solution {
    public int clumsy(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = N - i;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && i < 4; i++) {
            ans = nums[i++];
            if (i < N) {
                ans *= nums[i++];
            }
            if (i < N) {
                ans /= nums[i++];
            }
            if (i < N) {
                ans += nums[i];
            }
        }
        for (int i = 4; i < nums.length; i++) {
            int temp = nums[i++];
            if (i < N) {
                temp *= nums[i++];
            }
            if (i < N) {
                temp /= nums[i++];
            }
            if (i < N) {
                temp -= nums[i];
            }
            ans -= temp;
        }
        return ans;
    }
}
