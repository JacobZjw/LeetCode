package J21;

import java.util.Arrays;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[]{9,9,14,1,2,12,8,14,7,20})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{1, 3, 5, 7, 2, 4, 6, 8})));
        System.out.println(Arrays.toString(solution.exchange(new int[]{2, 4, 6, 8, 1, 3, 5, 7,})));
    }
}
