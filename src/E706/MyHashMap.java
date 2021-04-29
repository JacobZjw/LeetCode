package E706;

import java.util.Arrays;
import java.util.Random;

/**
 * 开放定址法
 *
 * @author JwZheng
 */
class MyHashMap {

    private final int m = 20007;
    private int[] vals;
    private int[] keys;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.keys = new int[m];
        this.vals = new int[m];
        Arrays.fill(keys, -1);
        Arrays.fill(vals, -1);

    }

    private int hash(int key) {
        return (Integer.hashCode(key) & 0x7fffffff) % m;
    }

    private int find(int key) {
        int index = hash(key);
        while (keys[index] != key && keys[index] != -1) {
            index = (++index) % m;
        }
        return index;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = find(key);
        keys[index] = key;
        vals[index] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = find(key);
        if (keys[index] == key) {
            return vals[index];
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = find(key);
        if (keys[index] == key) {
            vals[index] = -1;
            keys[index] = -1;
        }
        index = (++index) % m;
        while (keys[index] != -1) {
            key = keys[index];
            int val = vals[index];

            keys[index] = -1;
            vals[index] = -1;

            put(key, val);
            index = (++index) % m;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */