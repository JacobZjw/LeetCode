package M1052;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println(solution.maxSatisfied(new int[]{10, 1, 7}, new int[]{0, 0, 0}, 2));
    }
}
