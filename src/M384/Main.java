package M384;

import java.util.Arrays;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
