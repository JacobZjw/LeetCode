package WC136;

/**
 * @author JwZheng
 * @since 2021/9/19 13:02
 */
public class Main {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.maxLength(new int[]{2, 3, 4, 5}));
        System.out.println(s.maxLength(new int[]{2, 2, 3, 4, 3}));
        System.out.println(s.maxLength(new int[]{1, 2, 3, 1, 2, 3, 2, 2}));
        System.out.println(s.maxLength(new int[]{3,3,2,1,3,3,3,1}));
    }
}
