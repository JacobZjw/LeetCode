package BTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @author JwZheng
 * @since 2021/9/20 15:24
 */
public class BTree<K extends Comparable<K>, V> {
    private static final int DEFAULT_ORDER = 5;
    private final int order;
    private final Comparator<K> comparator;
    private Node<K, V> root;


    public BTree() {
        this(DEFAULT_ORDER, null);
    }

    public BTree(int order) {
        this(order, null);
    }

    public BTree(int order, Comparator<K> comparator) {
        this.order = order;
        this.comparator = comparator;
        this.root = new Node<>();
        this.root.isLeaf = true;
    }

    /**
     * 从 B-Tree 查找指定键对应的值
     *
     * @param key 键
     * @return 值
     */
    private V get(K key) {
        return search(root, key);
    }

    /**
     * 从指定节点递归搜索指定键对应的值
     *
     * @param node 节点
     * @param key  键
     * @return 值
     */
    private V search(Node<K, V> node, K key) {
        SearchResult<V> result = node.search(key);
        if (!result.exist && !node.isLeaf) {
            return search(node.childAt(result.index), key);
        }
        return result.value;
    }

    /**
     * 插入或替换
     *
     * @param key   键
     * @param value 值
     * @return 如果指定键存在值，则返回该键之前对应的值
     */
    public V put(K key, V value) {
        if (key == null)
            throw new NullPointerException();
        return put(root, new Entry<>(key, value));
    }

    private V put(Node<K, V> node, Entry<K, V> entry) {
        if (node.isLeaf) {
            //是叶子节点则直接插入
            V v = node.putEntry(entry);//应该插入后面的一个
            checkEntrySize(node);
            return v;
        }
        SearchResult<V> result = node.search(entry.key);
        if (result.exist) {
            //如果存在，则更新
            node.entryAt(result.index).value = entry.value;
            return result.value;
        }
        //不存在，则向子节点查找
        Node<K, V> child = node.childAt(result.index);
        return put(child, entry);
    }


    public V remove(K key) {
        return remove(root, new Entry<K, V>(key, null));
    }

    public V remove(Node<K, V> node, Entry<K, V> entry) {
        SearchResult<V> result = node.search(entry.key);
        if (!result.exist) {
            return remove(node.childAt(result.index), entry);
        }
        Entry<K, V> removeEntry = node.removeEntry(result.index);
        //如果是叶子结点，直接删除
        if (node.isLeaf) {
            reform(node);
            return removeEntry.value;
        }

        Node<K, V> leftChild = node.childAt(result.index);
        if (leftChild.size() > minEntrySize()) {
            node.addEntry(leftChild.entryAt(leftChild.size() - 1), result.index);
            remove(leftChild, leftChild.entryAt(leftChild.size() - 1));
            return removeEntry.value;
        }

        Node<K, V> rightChild = node.childAt(result.index + 1);
        if (rightChild.size() > minEntrySize()) {
            node.addEntry(rightChild.entryAt(0), result.index);
            remove(rightChild, rightChild.entryAt(0));
            return removeEntry.value;
        }
        leftChild.putEntry(removeEntry);
        node.removeChild(result.index);

        leftChild.entries.addAll(rightChild.entries);
        if (!rightChild.isLeaf)
            leftChild.addAllChild(rightChild.children);
        if (root == node) {
            this.root = leftChild;
            leftChild.parent = null;
        }
        remove(leftChild, entry);
        checkEntrySize(leftChild);
        return removeEntry.value;
    }

    private void reform(Node<K, V> node) {
        if (node.size() >= minEntrySize() || !node.isLeaf || node == root)
            return;
        int index = node.parent.children.indexOf(node);
        Node<K, V> brother = null;
        Node<K, V> siblingNode = null;
        int siblingIndex = -1;
        if (index < node.parent.children.size() - 1) {
            //存在右兄弟
            brother = node.parent.childAt(index + 1);
            if (brother.size() > minEntrySize()) {
                //右兄弟关键字数目足够
                siblingNode = brother;
                siblingIndex = index + 1;
            }
        }
        if (siblingNode == null && index > 0) {
            brother = node.parent.childAt(index - 1);
            if (brother.size() > minEntrySize()) {
                //左兄弟关键字数目足够
                siblingNode = brother;
                siblingIndex = index - 1;
            }
        }
        if (siblingNode != null) {
            Entry<K, V> removeEntry = node.parent.removeEntry(index);
            node.parent.putEntry(siblingNode.removeEntry(siblingIndex));
            node.putEntry(removeEntry);
            return;
        }

        if (index < node.parent.children.size() - 1) {
            //右兄弟
            node.addEntry(node.parent.removeEntry(index));
            assert brother != null;
            node.addAllEntry(brother.entries);
            node.parent.removeChild(index + 1);
        } else {
            assert brother != null;
            brother.addEntry(node.parent.removeEntry(index));
            brother.addAllEntry(node.entries);
            node.parent.removeChild(index);
        }
    }

    private int minEntrySize() {
        return order / 2;
    }

    private int maxEntrySize() {
        return order - 1;
    }

    private int maxChildSize() {
        return order;
    }


    private void split(Node<K, V> node) {
        Node<K, V> parent = node.parent;
        //分裂产生新结点
        Node<K, V> newNode = new Node<>(comparator);
        //如果原结点为叶子结点，那么新结点也是
        newNode.isLeaf = node.isLeaf;

        int mid = (order - 1) / 2;
        Entry<K, V> entry = node.entryAt(mid);

        //此时，子节点是满的，需要拆分，则拆分为[0 , (m - 1) / 2 - 1] 、(m - 1) / 2、[ (m - 1) / 2 + 1 , m - 1];
        for (int i = mid + 1; i <= maxEntrySize(); ++i)
            newNode.addEntry(node.entryAt(i));
        node.entries.subList(mid, maxEntrySize() + 1).clear();
        if (!newNode.isLeaf) {
            //如果分裂的不是叶子结点，那么存在子结点，需要将子结点也分裂
            for (int i = mid + 1; i <= maxChildSize(); i++) {
                newNode.addChild(node.childAt(i));
            }
            node.children.subList(mid + 1, maxChildSize() + 1).clear();
        }
        if (parent == null) {
            parent = new Node<>(comparator);
            this.root = parent;
            parent.addChild(node);
        }
        parent.insertEntryAndChild(entry, newNode);
        checkEntrySize(parent);
    }

    private void checkEntrySize(Node<K, V> node) {
        if (node.size() > maxEntrySize())
            split(node);
    }


    private static class Node<K extends Comparable<K>, V> implements Comparator<K> {
        /**
         * 孩子结点，最多有 m 个，除根节点外至少有 m / 2 个
         */
        private final List<Node<K, V>> children;
        /**
         * 关键字，最多有 m - 1 个，除根结点外至少有 (m / 2 - 1)  个
         */
        private final List<Entry<K, V>> entries;
        private final Comparator<K> comparator;
        private boolean isLeaf;
        private Node<K, V> parent;

        public Node() {
            this(null);
        }

        public Node(Comparator<K> comparator) {
            this.comparator = comparator;
            this.children = new ArrayList<>();
            this.entries = new ArrayList<>();
        }

        public int size() {
            return entries.size();
        }

        SearchResult<V> search(K key) {
            int low = 0, high = entries.size() - 1, mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                Entry<K, V> entry = entries.get(mid);
                K k = entry.key;
                if (compare(k, key) == 0)
                    return new SearchResult<>(true, mid, entry.value);
                else if (compare(k, key) > 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return new SearchResult<>(false, low);
        }

        /**
         * 将关键字插入到指定位置
         *
         * @param entry 关键字
         * @param index 位置索引
         */
        void addEntry(Entry<K, V> entry, int index) {
            entries.add(index, entry);
        }

        void addEntry(Entry<K, V> entry) {
            entries.add(entry);
        }


        void addAllEntry(Collection<? extends Entry<K, V>> c) {
            entries.addAll(c);
        }

        /**
         * 将结点插入到指定位置
         *
         * @param child 结点
         * @param index 位置索引
         */
        void addChild(Node<K, V> child, int index) {
            child.parent = this;
            children.add(index, child);
        }

        void addChild(Node<K, V> child) {
            child.parent = this;
            children.add(child);
        }

        void addAllChild(Collection<? extends Node<K, V>> c) {
            c.forEach(this::addChild);
        }


        Node<K, V> childAt(int index) {
            return children.get(index);
        }

        Entry<K, V> entryAt(int index) {
            return entries.get(index);
        }

        Entry<K, V> removeEntry(int index) {
            return entries.remove(index);
        }

        Node<K, V> removeChild(int index) {
            return children.remove(index);
        }

        V putEntry(Entry<K, V> entry) {
            SearchResult<V> result = search(entry.key);
            int index = result.index;
            if (!result.exist) {
                addEntry(entry, index);
                return null;
            }
            entries.get(index).value = entry.value;
            return result.value;
        }

        void insertEntryAndChild(Entry<K, V> entry, Node<K, V> child) {
            SearchResult<V> result = search(entry.key);
            if (result.exist)
                throw new NullPointerException("error");
            entries.add(result.index, entry);
            addChild(child, result.index + 1);
        }


        @Override
        public int compare(K o1, K o2) {
            return comparator == null ? o1.compareTo(o2) : comparator.compare(o1, o2);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "entries=" + entries +
                    ", children=" + children +
                    '}';
        }
    }

    /**
     * 在给定的B树节点中搜索
     * 如果查找成功，index 表示给定键值在B树节点对于的位置
     * 如果查找失败，index 表示给定键值应该插入的位置
     *
     * @param <V>
     */
    private static class SearchResult<V> {
        private final boolean exist;
        private final int index;
        private V value;

        public SearchResult(boolean exist, int index) {
            this.exist = exist;
            this.index = index;
        }

        public SearchResult(boolean exist, int index, V value) {
            this(exist, index);
            this.value = value;
        }
    }

    private static class Entry<K extends Comparable<K>, V> implements Comparable<K> {
        private final K key;
        private V value;

        public Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public int compareTo(K o) {
            return key.compareTo(o);
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }
}
