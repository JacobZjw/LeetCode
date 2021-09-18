package WC141;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 *
 * @author JwZheng
 * @since 2021/9/18 12:21
 */
public class Solution {
    private Map<Integer, Integer> indexInOrder;
    private int deep;

    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        indexInOrder = new HashMap<>();
        int n = xianxu.length;
        for (int i = 0; i < n; i++) {
            indexInOrder.put(zhongxu[i], i);
        }
        TreeNode node = recur(xianxu, 0, n - 1, 0, n - 1, 1);
        return printRightView(node);
    }

    private TreeNode recur(int[] xianxu, int lBegin, int lEnd, int rBegin, int rEnd, int deep) {
        if (lBegin > lEnd || rBegin > rEnd) {
            return null;
        }
        TreeNode root = new TreeNode(xianxu[lBegin]);
        Integer index = indexInOrder.get(xianxu[lBegin]);
        root.left = recur(xianxu, lBegin + 1, lBegin + index - rBegin, rBegin, index - 1, deep + 1);
        root.right = recur(xianxu, lBegin + index - rBegin + 1, lEnd, index + 1, rEnd, deep + 1);
        this.deep = Math.max(this.deep, deep);
        return root;
    }

    private int[] printRightView(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int[] ans = new int[this.deep];
        int index = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode node = deque.getFirst();
            while (size > 0) {
                node = deque.removeFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                size--;
            }
            ans[index++] = node.val;
        }
        return ans;
    }
}
