package E108;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/18 12:10
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return new TreeNode();
        }
        return sortedArrayToBST(nums,0,nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if (start == end){
            return new TreeNode(nums[start]);
        }else if(start > end){
            return null;
        }
        int mid = end - (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid - 1);
        root.right = sortedArrayToBST(nums,mid + 1,end);
        return root;
    }
}
