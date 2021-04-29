package M173;

import TreeNode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author JwZheng
 * @date 2021/3/24 10:16
 */
public class BSTIterator {

    Deque<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        stack.push(root);
        node = root;
    }

    public int next() {
        if (hasNext()) {
            node = stack.poll();
            assert node != null;
            int v = node.val;
            node = node.right;
            if (node != null) {
                stack.push(node);
            }
            return v;
        }
        return 0;
    }

    public boolean hasNext() {
        while (node != null && node.left != null) {
            stack.push(node.left);
            node = node.left;
        }
        return !stack.isEmpty();
    }
}
