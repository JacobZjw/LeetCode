package M654;

import TreeNode.TreeNode;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2022/8/20 8:06
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        int mid = maxIndex(nums);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, mid));
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return node;
    }

    private int maxIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}
