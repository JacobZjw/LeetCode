package H297;

import TreeNode.TreeNode;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        System.out.println(codec.serialize(codec.deserialize("1,null,2")));
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(root))));
    }
}
