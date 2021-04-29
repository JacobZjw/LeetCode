package E101;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JwZheng
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode l, TreeNode r) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(l);
        queue.offer(r);
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();

            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null) {
                return false;
            }
            if (u.val != v.val) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
