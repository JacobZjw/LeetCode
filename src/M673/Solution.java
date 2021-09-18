package M673;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/13 12:56
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int ans = 0;
        int[] lengths = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lengths[i]);
        }
        for (int i = 0; i < counts.length; i++) {
            if (lengths[i] == maxLen) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
