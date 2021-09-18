package NC91;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/13 12:13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.LIS(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7})));
        System.out.println(Arrays.toString(solution.LIS(new int[]{1, 2, 8, 6, 4})));
    }
}
