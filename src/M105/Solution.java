package M105;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution {

//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int index = 0;
        for (Integer val : inorder) {
            map.put(val, index++);
        }

        return helper(0, index - 1, 0, index - 1);
    }

    public TreeNode helper(int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pLeft]);

        int num = map.get(preorder[pLeft]) - iLeft;

        int nextRootPos = pLeft + num + 1;
        root.left = helper(pLeft + 1, pLeft + num, iLeft, map.get(preorder[pLeft]) - 1);
        root.right = helper(nextRootPos, pRight, map.get(preorder[pLeft]) +1, iRight);

        return root;
    }
}
