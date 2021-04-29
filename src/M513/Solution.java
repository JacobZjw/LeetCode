package M513;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author JwZheng
 * @date 2021/3/28 10:28
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int ans = root.val;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans = deque.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return ans;
    }
}
