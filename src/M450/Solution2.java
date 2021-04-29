package M450;

import TreeNode.TreeNode;

/**
 * 迭代
 *
 * @author JwZheng
 * @date 2021/3/24 13:14
 */
class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode ptr = root;
        TreeNode pre = ptr;

        while (ptr != null) {
            if (ptr.val < key) {
                pre = ptr;
                ptr = ptr.right;
            } else if (ptr.val > key) {
                pre = ptr;
                ptr = ptr.left;
            } else {
                if (ptr.right != null && ptr.left != null) {
                    pre = ptr;
                    TreeNode node = ptr.right;
                    while (node.left != null) {
                        pre = node;
                        node = node.left;
                    }
                    ptr.val = node.val;
                    node.val = key;
                    ptr = node;
                } else {
                    TreeNode next = ptr.left == null ? ptr.right : ptr.left;
                    if (pre.left == ptr) {
                        pre.left = next;
                    } else if (pre.right == ptr) {
                        pre.right = next;
                    } else {
                        return next;
                    }
                    return root;
                }
            }
        }
        return root;
    }
}
