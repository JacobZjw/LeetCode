package M8;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.myAtoi("-6147483648"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("987"));
        System.out.println(solution.myAtoi("+987"));
        System.out.println(solution.myAtoi("    "));
        System.out.println(solution.myAtoi(""));
        System.out.println(solution.myAtoi("+++1"));
    }
}
