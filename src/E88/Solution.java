package E88;

/**
 * @author JwZheng
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, index = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[index--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
