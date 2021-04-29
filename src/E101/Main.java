package E101;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        right.right = new TreeNode(3);

        root.left = left;
        root.right = right;

        System.out.println(new Solution().check(root,root));

    }
}
