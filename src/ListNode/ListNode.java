package ListNode;

/**
 * @author JwZheng
 * @date 2021/3/25 10:29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getList(String str) {
        String[] chars = str.split(",");
        int index = 0;
        ListNode head = new ListNode(Integer.parseInt(chars[index++]));
        ListNode ptr = head;
        while (index < chars.length) {
            ptr.next = new ListNode(Integer.parseInt(chars[index++]));
            ptr = ptr.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ListNode ptr = this;
        while (ptr != null) {
            ans.append(ptr.val).append(",");
            ptr = ptr.next;
        }
        ans.deleteCharAt(ans.length() -1);
        return ans.toString();
    }
}