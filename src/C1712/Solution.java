package C1712;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/26 13:15
 */
public class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ptr = root.left;
        TreeNode left = convertBiNode(root.left);
        root.left = null;
        root.right = convertBiNode(root.right);

        if (left == null) {
            return root;
        }
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        ptr.right = root;

        return left;
    }
}
