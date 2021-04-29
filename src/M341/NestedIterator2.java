package M341;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * BFS
 *
 * @author JwZheng
 * @date 2021/3/23 13:44
 */
public class NestedIterator2 implements Iterator<Integer> {
    Deque<Integer> deque;
    Iterator<Integer> iterator;

    public NestedIterator2(List<NestedInteger> nestedList) {
        deque = new LinkedList<>();
        init(nestedList);
        iterator = deque.iterator();
    }

    private void init(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                deque.offer(nestedInteger.getInteger());
            }
            init(nestedInteger.getList());
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}