package M841;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JwZheng
 * @date 2021/3/23 12:22
 */
public class Solution {
    boolean[] visited;
    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i : rooms.get(index)) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count + 1 == n;
    }
}
