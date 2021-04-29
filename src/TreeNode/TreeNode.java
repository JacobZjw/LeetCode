package TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JwZheng
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(String data) {
        if (data == null) {
            return;
        }
        String[] tree = data.split(",");
        int n = tree.length;
        Queue<TreeNode> queue = new LinkedList<>();
        this.val = Integer.parseInt(tree[0]);
        queue.offer(this);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode ptr = queue.poll();
            if (!"null".equals(tree[i])) {
                ptr.left = new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(ptr.left);
            }
            ++i;
            if (i == n) {
                break;
            }
            if (!"null".equals(tree[i])) {
                ptr.right = new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(ptr.right);
            }
            ++i;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null,");
            }
        }
        int last = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                last = i;
            }
        }
        return sb.substring(0, last + 1);
    }
}
