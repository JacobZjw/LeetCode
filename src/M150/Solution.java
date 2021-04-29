package M150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值，栈
 *
 * @author JwZheng
 * @date 2021/3/20 10:18
 */
public class Solution {
    /**
     * tokens = ["4","13","5","/","+"]
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int ans, left, right;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    ans = stack.pop() + stack.pop();
                    stack.push(ans);
                    break;
                case "-":
                    ans = stack.pop() - stack.pop();
                    stack.push(-ans);
                    break;
                case "*":
                    ans = stack.pop() * stack.pop();
                    stack.push(ans);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    ans = left / right;
                    stack.push(ans);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

}
