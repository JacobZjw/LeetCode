package H857;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author JwZheng
 * @date 2021/3/29 11:08
 */
public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(n, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(calculate(o1), calculate(o2));
            }

            private double calculate(int i) {
                return (double) wage[i] / (double) quality[i];
            }
        });
        IntStream.range(0, n).forEach(heap::offer);
        double ans = 0;

        return 1;
    }
}
