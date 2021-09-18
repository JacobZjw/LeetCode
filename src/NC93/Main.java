package NC93;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/11 15:04
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}}, 3)));
        System.out.println(Arrays.toString(solution.LRU(new int[][]{{1, 1, 1}, {1, 1, 2}, {2, 1}}, 2)));

        System.out.println(Arrays.toString(solution.LRU(new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 1, 3}, {2, 1}, {2, 1}}, 3)));
    }
}
