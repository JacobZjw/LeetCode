package M450;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/24 12:32
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.deleteNode(new TreeNode("3,2,4,1"), 2));
        System.out.println(solution2.deleteNode(new TreeNode("1,null,2"), 1));
        System.out.println(solution2.deleteNode(new TreeNode("50,30,70,null,40,60,80"), 50));
        System.out.println(solution2.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 3));
        System.out.println(solution2.deleteNode(new TreeNode("5"), 5));
        System.out.println(solution2.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 5));
        System.out.println(solution2.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 6));

        System.out.println();
        Solution solution = new Solution();
        System.out.println(solution.deleteNode(new TreeNode("50,30,70,null,40,60,80"), 50));
        System.out.println(solution.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 3));
        System.out.println(solution.deleteNode(new TreeNode("5"), 5));
        System.out.println(solution.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 5));
        System.out.println(solution.deleteNode(new TreeNode("5,3,6,2,4,null,7"), 6));
    }
}
