package WC129;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @since 2021/9/18 13:25
 */
public class Solution {
    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int l = height(head.left);
        int r = height(head.right);
        if (l > r) {
            //左子树高度大于右子树，则右子树必定为满二叉树
            return (int) (Math.pow(2, r) + nodeNum(head.left));
        }
        //左子树高度等于右子树高度，则至少左子树是满二叉树
        return (int) (Math.pow(2, l) + nodeNum(head.right));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return l > r ? l + 1 : r + 1;
    }
}
