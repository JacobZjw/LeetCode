package M781;

/**
 * @author JwZheng
 * @date 2021/4/4 17:25
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRabbits(new int[]{0, 0, 1, 1, 1}));
        System.out.println(solution.numRabbits(new int[]{1, 1, 2}));
        System.out.println(solution.numRabbits(new int[]{10, 10, 10}));
        System.out.println(solution.numRabbits(new int[]{1, 1, 0, 0}));
        System.out.println(solution.numRabbits(new int[]{1, 0, 1, 0, 0}));
    }
}
