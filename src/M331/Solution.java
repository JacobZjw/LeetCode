package M331;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author JwZheng
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        if ("#".equals(preorder)) {
            return true;
        }
        if (preorder.length() < 5) {
            return false;
        }
        String[] strs = preorder.split(",");
        Deque<int[]> stack = new ArrayDeque<>();

        String str = strs[0];
        if (!"#".equals(str)) {
            stack.push(new int[]{Integer.parseInt(str), 0});
        }

        for (int i = 1; i < strs.length; i++) {
            str = strs[i];
            if (stack.isEmpty()) {
                return false;
            }
            int[] poll = stack.pop();
            if (poll[1] < 1) {
                poll[1]++;
                stack.push(poll);
            }
            if (!"#".equals(str)) {
                stack.push(new int[]{Integer.parseInt(str), 0});
            }
        }
        return stack.isEmpty();
    }


}
