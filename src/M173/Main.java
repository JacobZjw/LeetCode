package M173;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 * @date 2021/3/24 10:27
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("7,3,15,null,null,9,20");
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}
