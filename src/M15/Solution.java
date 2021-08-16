package M15;

import java.util.*;

/**
 * @author JwZheng
 * @since 2021/8/16 13:15
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        /* num —— index */
        Map<Integer, Integer> numMap = new HashMap<>(len);
        Set<List<Integer>> ansSet = new HashSet<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] < 0) {
                    break;
                }
                int sum = nums[i] + nums[j];
                Integer k = numMap.get(-sum);
                if (k != null) {
                    ansSet.add(List.of(nums[k], nums[i], nums[j]));
                }
            }
            numMap.put(nums[i], i);
        }
        return new ArrayList<>(ansSet);
    }
}
