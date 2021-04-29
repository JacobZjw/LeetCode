package M150;


/**
 * @author JwZheng
 * @date 2021/3/20 10:19
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
