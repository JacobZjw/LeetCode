package M393;

/**
 * @author JwZheng
 * @since 2021/8/15 21:04
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.err.println(solution.validUtf8(new int[]{230, 136, 145}));
        System.err.println(solution.validUtf8(new int[]{192, 130, 1}));
        System.err.println(solution.validUtf8(new int[]{228, 189, 160, 229, 165, 189, 13, 10}));
        System.err.println(solution.validUtf8(new int[]{235, 140, 4}));
        System.err.println(solution.validUtf8(new int[]{255}));
        System.err.println(solution.validUtf8(new int[]{145}));
        System.err.println(solution.validUtf8(new int[]{240, 162, 138, 147, 145}));
        System.err.println(solution.validUtf8(new int[]{250, 145, 145, 145, 145}));
    }
}
