package E155;

import java.util.ArrayList;

/**
 * @author JwZheng
 */
public class MinStack {
    ArrayList<Integer> data;
    ArrayList<Integer> minIndex;
    int minVal;
    int index = -1;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<>();
        minIndex = new ArrayList<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        data.add(x);
        ++index;
        if (x < minVal) {
            minIndex.add(index);
            minVal = x;
        }
    }

    public void pop() {
        data.remove(index);
        if (minIndex.get(minIndex.size() - 1) == index) {
            minIndex.remove(minIndex.size() - 1);
            if (minIndex.size() > 0) {
                minVal = data.get(minIndex.get(minIndex.size() - 1));
            } else {
                minVal = Integer.MAX_VALUE;
            }
        }
        index--;
    }

    public int top() {
        return data.get(index);
    }

    public int getMin() {
        return minVal;
    }
}
