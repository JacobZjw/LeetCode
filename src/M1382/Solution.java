package M1382;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 * @date 2021/3/26 13:43
 */
public class Solution {
    List<Integer> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        traversal(root);
        return build(0, list.size() - 1);
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }

    private TreeNode build(int start, int end) {
        if (start == end) {
            return new TreeNode(list.get(start));
        } else if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(start, mid - 1);
        node.right = build(mid + 1, end);
        return node;
    }
}
