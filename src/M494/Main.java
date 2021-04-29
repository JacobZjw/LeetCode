package M494;

/**
 * @author JwZheng
 * @date 2021/3/20 12:18
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 0}, 1));
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 3, 4, 1}, 5));
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
