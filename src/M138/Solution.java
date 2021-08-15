package M138;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 * @since 2021/8/15 19:38
 */
public class Solution {

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node tmp = head;
        /*旧节点——新节点*/
        while (head != null) {
            Node node = fork(head);
            node.next = fork(head.next);
            node.random = fork(head.random);
            head = head.next;
        }
        return map.get(tmp);
    }

    private Node fork(Node node) {
        if (node == null) {
            return null;
        }
        Node res = map.get(node);
        if (res == null) {
            res = new Node(node.val);
            map.put(node, res);
        }
        return res;
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
