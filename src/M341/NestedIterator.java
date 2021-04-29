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
public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        deque = new LinkedList<>();
        init(nestedList);
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
        return deque.poll();
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }
}