package H154;

/**
 * @author JwZheng
 * @date 2021/4/9 10:42
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 3, 1, 3}));
        System.out.println(solution.findMin(new int[]{3, 3, 3, 3, 1, 3,3,3,3}));
        System.out.println(solution.findMin(new int[]{10, 1, 10, 10, 10}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 4}));
        System.out.println(solution.findMin(new int[]{0, 1, 4, 4, 5, 6, 7}));
        System.out.println(solution.findMin(new int[]{2, 2, 2, 0, 1}));
    }
}
