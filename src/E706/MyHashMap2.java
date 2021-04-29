package E706;

/**
 * @author JwZheng
 */
public class MyHashMap2 {
    private int m = 997;
    private Buckets[] buckets;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap2() {
        buckets = new Buckets[m];
        for (int i = 0; i < m; i++) {
            buckets[i] = new Buckets();
        }
    }

    private int hash(int key) {
        return (Integer.hashCode(key) & 0x7fffffff) % m;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        buckets[hash(key)].put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return buckets[hash(key)].get(key);

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        buckets[hash(key)].remove(key);
    }
}

class Buckets {

    private Node head;

    public Buckets() {

    }

    public void put(int key, int val) {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            if (key == ptr.key) {
                ptr.val = val;
                return;
            }
        }
        Node node = new Node(key, val, head);
        this.head = node;
    }

    public int get(int key) {
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            if (key == ptr.key) {
                return ptr.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        this.head = delete(head,key);
    }

    private Node delete(Node head, int key) {
        if (head == null) {
            return null;
        }
        if (head.key == key) {
            return head.next;
        }
        head.next = delete(head.next, key);
        return head;
    }

    private class Node {
        private int key;
        private int val;
        private Node next;

        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

}
