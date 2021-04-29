package M82;

import ListNode.ListNode;

/**
 * 递归解法
 *
 * @author JwZheng
 * @date 2021/3/25 10:28
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        boolean flag = false;
        if (head.next != null && head.val == head.next.val) {
            flag = true;
        }
        ListNode pre = head;

        for (ListNode ptr = head; ptr != null; ptr = ptr.next) {
            if (ptr.next != null && ptr.val == ptr.next.val) {
                pre.next = helper(ptr.next, ptr.val);
                ptr = pre;
            } else {
                ptr.next = helper(ptr.next, ptr.val);
                pre = ptr;
            }
        }
        return flag ? head.next : head;
    }

    public ListNode helper(ListNode head, int v) {
        if (head == null) {
            return null;
        }
        if (head.val == v) {
            return helper(head.next, v);
        }
        return head;
    }
}
