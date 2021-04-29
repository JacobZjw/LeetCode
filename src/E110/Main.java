package E110;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/26 11:19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(new TreeNode("1,2,2,3,null,null,3,4,null,null,4")));
    }
}
