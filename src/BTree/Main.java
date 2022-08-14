package BTree;

/**
 * @author JwZheng
 * @since 2021/9/20 22:50
 */
public class Main {
    public static void main(String[] args) {
        BTree<Integer, Object> bTree = new BTree<Integer, Object>(5, null);

        bTree.put(1, 1);
        bTree.put(2, 1);
        bTree.put(6, 1);
        bTree.put(7, 1);
        bTree.put(11, 1);
        bTree.put(4, 1);
        bTree.put(8, 1);
        bTree.put(13, 1);
        bTree.put(10, 1);
        bTree.put(5, 1);
        bTree.put(17, 1);
        bTree.put(9, 1);
        bTree.put(16, 1);
        bTree.put(20, 1);
        bTree.put(3, 1);
        bTree.put(12, 1);
        bTree.put(14, 1);
        bTree.put(18, 1);
        bTree.put(19, 1);
        bTree.put(15, 1);
        bTree.remove(10);
        return;
    }


}
