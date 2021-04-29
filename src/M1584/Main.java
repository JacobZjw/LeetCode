package M1584;

/**
 * @author JwZheng
 * @date 2021/3/19 14:10
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(solution.minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
    }
}
