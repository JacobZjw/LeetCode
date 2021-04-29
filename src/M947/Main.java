package M947;

/**
 * @author JwZheng
 * @date 2021/3/19 23:43
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.removeStones(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}}));
        System.out.println(solution.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(solution.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
    }
}
