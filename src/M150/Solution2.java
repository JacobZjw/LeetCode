package M150;

/**
 * 数组模拟栈
 *
 * @author JwZheng
 * @date 2021/3/20 10:40
 */
public class Solution2 {
    /**
     * tokens = ["4","13","5","/","+"]
     */
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[index - 1] += stack[index];
                    --index;
                    break;
                case "-":
                    stack[index - 1] -= stack[index];
                    --index;
                    break;
                case "*":
                    stack[index - 1] *= stack[index];
                    --index;
                    break;
                case "/":
                    stack[index - 1] /= stack[index];
                    --index;
                    break;
                default:
                    stack[++index] = Integer.parseInt(token);
                    break;
            }
        }

        return stack[index];
    }
}
