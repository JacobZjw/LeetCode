package E703;


/**
 * @author JwZheng
 * @date 2021/3/25 12:58
 */
public class KthLargest {
    TreeNode root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            root = add(root, num);
        }
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = add(root.right, val);
        } else {
            root.left = add(root.left, val);
        }
        root.count++;
        return root;
    }

    private TreeNode find(TreeNode node, int k) {
        if (node == null) {
            return node;
        }
        int leftNodeCount = node.left != null ? node.left.count : 0;
        int rightNodeCount = node.right != null ? node.right.count : 0;
        int currNodeCount = node.count - leftNodeCount - rightNodeCount;
        if (k > currNodeCount + rightNodeCount) {
            // k > 当前结点数加右子树的结点数，则搜索左子树
            return find(node.left, k - currNodeCount - rightNodeCount);
        } else if (k <= rightNodeCount) {
            // k <= 右子树的结点数，则搜索右子树
            return find(node.right, k);
        } else {
            // k == 当前结点数加右子树的结点数，则找到第k大的结点
            return node;
        }

    }

    public int add(int val) {
        root = add(root, val);
        return find(root, k).val;
    }

    class TreeNode {
        public int count;
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int x) {
            val = x;
            count = 1;
        }
    }
}
