package NC60;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * @author JwZheng
 * @since 2021/9/19 14:06
 */
public class Solution {
    public boolean[] judgeIt(TreeNode root) {
        if (root == null) {
            return new boolean[]{false, false};
        }
        return new boolean[]{isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE), isCBT(root)};
    }

    private boolean isBST(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        return isBST(root.left, lower, root.val) && isBST(root.right, root.val, upper);
    }

    private boolean isCBT(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
                continue;
            } else if (node.right != null) {
                return false;
            } else if (node.left != null) {
                queue.offer(node.left);
            }
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.left != null || node.right != null)
                    return false;
            }
        }
        return true;
    }
}
