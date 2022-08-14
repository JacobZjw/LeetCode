package WC137;

import ListNode.ListNode;

/**
 * 单链表归并排序
 *
 * @author JwZheng
 * @since 2021/9/20 13:22
 */
public class Solution {
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = new ListNode(), fast = head;
        slow.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortInList(head), sortInList(fast));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ans = new ListNode();
        ListNode node = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        ListNode ptr = list1 == null ? list2 : list1;
        while (ptr != null) {
            node.next = ptr;
            ptr = ptr.next;
            node = node.next;
        }
        return ans.next;
    }
}
