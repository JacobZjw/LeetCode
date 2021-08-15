package J20;

/**
 * @author JwZheng
 * @since 2021/8/15 15:28
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumber(".2"));
        System.out.println(s.isNumber("+100"));
        System.out.println(s.isNumber("5e2"));
        System.out.println(s.isNumber("+123"));
        System.out.println(s.isNumber("3.1416"));
        System.out.println(s.isNumber("-1E-16"));
        System.out.println(s.isNumber("-.3e6"));

        System.out.println("---------FALSE------------");
        System.out.println(s.isNumber("+."));
        System.out.println(s.isNumber(".2."));
        System.out.println(s.isNumber("1.2.3"));
        System.out.println(s.isNumber("12e"));
        System.out.println(s.isNumber("12e+5.4"));

    }
}
