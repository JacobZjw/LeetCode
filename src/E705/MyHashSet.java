package E705;

import java.util.LinkedList;

class MyHashSet {
    private Buckets[] buckets;
    private int keyRange;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.keyRange = 769;
        this.buckets = new Buckets[this.keyRange];
        for (int i = 0; i < keyRange; i++) {
            buckets[i] = new Buckets();
        }
    }

    private int hash(int key) {
        return (Integer.hashCode(key) & 0x7fffffff) % keyRange;
    }

    public void add(int key) {
        buckets[hash(key)].add(key);
    }

    public void remove(int key) {
        buckets[hash(key)].remove(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return buckets[hash(key)].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class Buckets {
    private LinkedList<Integer> list;

    public Buckets() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if (!contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = list.indexOf(key);
        if (index != -1) {
            list.remove(index);
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }

}