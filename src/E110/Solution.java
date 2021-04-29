package E110;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/26 11:19
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dept(root.left) - dept(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    public int dept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dept(root.left), dept(root.right)) + 1;
    }
}
