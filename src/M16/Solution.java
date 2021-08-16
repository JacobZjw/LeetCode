package M16;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/8/16 15:26
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int best = (int) (1e9 + 7);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int second = first + 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                if (sum > target) {
                    int tmp = third - 1;
                    while (second < third && nums[third] == nums[tmp]) {
                        --third;
                    }
                    third = tmp;
                } else {
                    int tmp = second + 1;
                    while (second < third && nums[second] == nums[tmp]) {
                        ++second;
                    }
                    second = tmp;
                }
            }
        }
        return best;
    }
}
