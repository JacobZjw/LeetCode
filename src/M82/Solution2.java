package M82;

import ListNode.ListNode;

/**
 * 迭代
 *
 * @author JwZheng
 * @date 2021/3/25 11:12
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode ptr = dummy;
        while (ptr.next != null && ptr.next.next != null) {
            if (ptr.next.val == ptr.next.next.val) {
                int x = ptr.next.val;
                while (ptr.next != null && ptr.next.val == x) {
                    ptr.next = ptr.next.next;
                }
            } else {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }

}
