package E705;

import java.util.Arrays;

/**
 * @author JwZheng
 */
public class MyHashSet2 {
    private int m;

    private int[] keys;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet2() {
        this.m = 20007;
        this.keys = new int[m];
        Arrays.fill(keys, -1);
    }

    public int find(int key) {
        int index = hash(key);
        while (keys[index] != key && keys[index] != -1) {
            index = (++index) % m;
        }
        return index;
    }

    public void add(int key) {
        int index = find(key);
        keys[index] = key;
    }

    public void remove(int key) {
        int index = find(key);
        keys[index] = -1;

        index = (++index) % m;
        while (keys[index] != -1) {
            key = keys[index];
            keys[index] = -1;
            add(key);
            index = (++index) % m;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = find(key);
        return keys[index] >= 0;
    }

    private int hash(int key) {
        return (Integer.hashCode(key) & 0x7fffffff) % m;
    }
}
