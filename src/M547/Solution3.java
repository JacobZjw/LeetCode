package M547;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 广度优先搜索
 *
 * @author JwZheng
 * @date 2021/3/17 15:02
 */
public class Solution3 {
    int[][] isConnected;
    boolean[] isVisited;
    Deque<Integer> deque;
    int n;

    public int findCircleNum(int[][] isConnected) {
        deque = new ArrayDeque<>();
        n = isConnected.length;
        this.isConnected = isConnected;
        this.isVisited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i);
                ans++;
            }
        }
        return ans;
    }

    private void bfs(int x) {
        deque.offer(x);
        isVisited[x] = true;
        while (!deque.isEmpty()) {
            int row = deque.poll();
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && isConnected[row][j] == 1) {
                    isVisited[j] = true;
                    deque.offer(j);
                }
            }
        }
    }
}
