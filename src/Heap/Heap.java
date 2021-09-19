package Heap;

import java.util.*;

/**
 * 手写优先队列，默认小根堆实现
 *
 * @author JwZheng
 * @since 2021/9/18 17:41
 */
public final class Heap<T extends Comparable<? super T>> implements Collection<T> {
    public static final int DEFAULT_CAPACITY = 11;
    private final Comparator<? super T> comparator;
    private transient T[] heap;
    private int size;

    @SuppressWarnings("unchecked")
    public Heap(int capacity, Comparator<? super T> comparator) {
        if (capacity < 1)
            throw new IllegalArgumentException();
        this.heap = (T[]) new Comparable[capacity + 1];
        this.comparator = comparator;
    }

    public Heap() {
        this(DEFAULT_CAPACITY, null);
    }

    public Heap(Comparator<? super T> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new NullPointerException();
        T t = (T) o;
        for (int i = 1; i <= size; i++) {
            if (heap[i].equals(t))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean add(T t) {
        if (t == null)
            throw new NullPointerException();
        if (size == heap.length - 1)
            grow();
        heap[++size] = t;
        siftUp(size);
        return true;
    }

    private void grow(int newLength) {
        this.heap = Arrays.copyOf(this.heap, newLength);
    }

    private void grow() {
        grow((int) (heap.length * 1.5));
    }


    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();
        T key = (T) o;
        for (int i = 1; i <= size; i++) {
            if (key.equals(heap[i])) {
                heap[i] = heap[size--];
                siftDown(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(this::remove);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= size; i++) {
            heap[i] = null;
        }
        size = 0;
        System.gc();
    }


    public T remove() {
        if (isEmpty())
            return null;
        T val = heap[1];
        heap[1] = heap[size];
        siftDown(1);
        heap[size--] = null;
        return val;
    }

    private void siftUp(int index) {
        if (comparator != null) {
            siftUpUsingComparator(index);
            return;
        }
        T t = heap[index];
        for (heap[0] = t; t.compareTo(heap[index >>> 1]) < 0; index >>>= 1) {
            heap[index] = heap[index >>> 1];
        }
        heap[index] = t;
    }

    private void siftUpUsingComparator(int index) {
        T t = heap[index];
        for (heap[0] = t; comparator.compare(t, heap[index >>> 1]) < 0; index >>>= 1) {
            heap[index] = heap[index >>> 1];
        }
        heap[index] = t;
    }


    private void siftDown(int index) {
        if (comparator != null) {
            siftDownUsingComparator(index);
            return;
        }
        T val = heap[index];
        int half = size >>> 1;//到最后一棵树的父节点即可
        while (index < half) {
            int left = index << 1, right = left + 1;
            T c = heap[left];//假设左节点是最小的
            if (right < size && c.compareTo(heap[right]) > 0)
                c = heap[left = right];
            if (val.compareTo(c) <= 0)//即heap[left] > val and heap[right] > val,则 index 即为 val 合适的位置。
                break;
            heap[index] = c;
            index = left;
        }
        heap[index] = val;
    }

    private void siftDownUsingComparator(int index) {
        T val = heap[index];
        int half = size >>> 1;//到最后一棵树的父节点即可
        while (index < half) {
            int left = index << 1, right = left + 1;
            T c = heap[left];//假设左节点是最小的
            if (right < size && comparator.compare(c, heap[right]) > 0)
                c = heap[left = right];
            if (comparator.compare(val, c) <= 0)//即heap[left] > val and heap[right] > val,则 index 即为 val 合适的位置。
                break;
            heap[index] = c;
            index = left;
        }
        heap[index] = val;
    }


    public T peek() {
        return isEmpty() ? null : heap[1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        for (int i = 1; i < size; i++) {
            sb.append(heap[i]).append(',').append(' ');
        }
        return sb.append(heap[size]).append(']').toString();
    }
}
