package M1423;

import java.util.*;

/**
 * @author JwZheng
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if (k == cardPoints.length) {
            return Arrays.stream(cardPoints).sum();
        }
        Deque<Integer> queue = new ArrayDeque<>(k);
        List<Integer> list = new ArrayList<>(k * 2);
        int n = cardPoints.length;
        for (int i = n - k; i < n; i++) {
            list.add(cardPoints[i]);
        }
        for (int i = 0; i < k; i++) {
            list.add(cardPoints[i]);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            queue.offer(list.get(i));
            sum += list.get(i);
        }
        int ans = sum;
        for (int i = k; i < list.size(); i++) {
            sum -= queue.poll();
            sum += list.get(i);
            queue.offer(list.get(i));
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
