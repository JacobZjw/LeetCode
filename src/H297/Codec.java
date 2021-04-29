package H297;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JwZheng
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] tree = data.split(",");
        int n = tree.length;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        queue.offer(root);
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
        return root;
    }
}
