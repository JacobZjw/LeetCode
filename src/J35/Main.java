package J35;

/**
 * @author JwZheng
 * @date 2021/3/31 10:20
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.Node node0 = new Solution.Node(7);
        Solution.Node node1 = new Solution.Node(13);
        Solution.Node node2 = new Solution.Node(11);
        Solution.Node node3 = new Solution.Node(10);
        Solution.Node node4 = new Solution.Node(1);
        node0.next = node1;
        node0.random = null;

        node1.next = node2;
        node1.random = node0;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.next = null;
        node4.random = node0;

        Solution.Node node = solution.copyRandomList(node0);
        for (Solution.Node ptr = node; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.val + " ");

        }
        System.out.println();
        for (Solution.Node ptr = node; ptr != null; ptr = ptr.random) {
            System.out.print(ptr.val + " ");
        }


    }
}
