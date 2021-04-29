package C1721;

/**
 * @author JwZheng
 * @date 2021/4/2 10:24
 */
public class Main {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.trap(new int[]{4, 9, 4, 5, 3, 2}));
        System.out.println(solution.trap(new int[]{2, 0, 2}));
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
