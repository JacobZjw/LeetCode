package M15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JwZheng
 * @since 2021/8/16 15:13
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < len; second++) {
                if (second != first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    ans.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }
}
