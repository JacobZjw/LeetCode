package M54;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.spiralOrder(new int[][]{{1}, {2}, {3}, {4}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}}));
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
