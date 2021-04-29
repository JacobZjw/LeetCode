package J35;


/**
 * @author JwZheng
 * @date 2021/3/31 10:19
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Node ptr = head, clone, cloneHead;
        while (ptr != null) {
            clone = new Node(ptr.val);
            clone.next = ptr.next;
            ptr.next = clone;
            ptr = clone.next;
        }

        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }

        cloneHead = head.next;
        clone = cloneHead;
        ptr = head;

        while (clone.next != null) {
            ptr.next = ptr.next.next;
            clone.next = clone.next.next;
            ptr = ptr.next;
            clone = clone.next;
        }
        ptr.next = null;
        return cloneHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
