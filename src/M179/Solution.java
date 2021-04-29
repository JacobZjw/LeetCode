package M179;

import java.util.Arrays;

/**
 * @author JwZheng
 * @date 2021/4/12 8:36
 */
public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = nums[i];
        }

        Arrays.sort(array, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (array[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : array) {
            sb.append(num);
        }
        return sb.toString();
    }

}
