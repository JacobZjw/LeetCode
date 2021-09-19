package NC60;

import TreeNode.TreeNode;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/19 14:33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.judgeIt(new TreeNode("1,2,3,5,null,7,8"))));
    }
}
