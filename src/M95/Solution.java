package M95;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 * @date 2021/3/26 14:09
 */
public class Solution {


    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);

            for (TreeNode node : left) {
                for (TreeNode treeNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node;
                    root.right = treeNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
