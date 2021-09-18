package WC129;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @since 2021/9/18 13:38
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("1,2,3,4,5,6,7,8,9,10,11");
        Solution s = new Solution();
        System.out.println(s.nodeNum(root));
    }
}
