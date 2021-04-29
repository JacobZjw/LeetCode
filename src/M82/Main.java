package M82;

import ListNode.ListNode;

/**
 * @author JwZheng
 * @date 2021/3/25 10:33
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNode.getList("1,2,3,3,4,4,4,5");
        System.out.println(head);
        System.out.println(solution.deleteDuplicates(head));


        Solution2 solution2 = new Solution2();

        System.out.println(solution2.deleteDuplicates(ListNode.getList("1,1,2,2")));
        System.out.println(solution2.deleteDuplicates(ListNode.getList("1,1,1,2,3,3,4,4,4,5,5,5,5")));
        System.out.println(solution2.deleteDuplicates(ListNode.getList("1,2,3,3,4,4,4,5")));
    }
}
