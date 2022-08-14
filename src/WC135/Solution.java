package WC135;

import ListNode.ListNode;

/**
 * 两个链表生成相加链表
 * 超时
 *
 * @author JwZheng
 * @since 2021/9/20 13:52
 */
public class Solution {
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);
        int tmp = 0;
        ListNode ans = head1;
        while (head2 != null) {
            int sum = head1.val + head2.val + tmp;
            head1.val = sum % 10;
            tmp = sum / 10;
            head2 = head2.next;
            while (head1.next == null && head2 != null) {
                sum = head2.val + tmp;
                head1.next = new ListNode(sum % 10);
                tmp = sum / 10;
                head1 = head1.next;
                head2 = head2.next;
            }
            head1 = head1.next;
        }
        while (head1 != null) {
            int sum = head1.val + tmp;
            head1.val = sum % 10;
            tmp = sum / 10;
            if (head1.next == null && tmp != 0) {
                head1.next = new ListNode(tmp);
                break;
            }
            head1 = head1.next;
        }
        return reverse(ans);
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
