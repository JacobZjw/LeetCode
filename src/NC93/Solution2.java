package NC93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hash表+双向链表实现
 *
 * @author JwZheng
 * @since 2021/9/11 15:12
 */
public class Solution2 {
    Node head;
    Node tail;
    int K;
    Map<Integer, Node> map;

    public int[] LRU(int[][] operators, int k) {
        if (operators.length == 0) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        map = new HashMap<>();
        K = k;
        head = null;
        tail = null;

        for (int[] operator : operators) {
            if (operator[0] == 2) {
                ans.add(get(operator[1]));
                continue;
            }
            set(operator[1], operator[2]);
        }

        int[] res = new int[ans.size()];
        int index = 0;
        for (int num : ans) {
            res[index++] = num;
        }
        return res;
    }

    private int get(int key) {
        Node ans = map.get(key);
        if (ans == null) {
            return -1;
        }
        flush(key);
        return ans.value;
    }

    private void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            flush(key);
            return;
        }
        while (map.size() >= K) {
            map.remove(head.key);
            head.next.prev = null;
            head = head.next;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    private void flush(int key) {
        Node node = map.get(key);
        if (head == tail || tail == node) {
            return;
        }
        node.next.prev = node.prev;
        if (node != head) {
            node.prev.next = node.next;
        } else {
            head = node.next;
            head.prev = null;
        }
        node.next = null;
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
