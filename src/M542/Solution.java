package M542;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 * @author JwZheng
 * @date 2021/3/21 13:20
 */
public class Solution {
    int m, n;

    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = bfs(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    private int bfs(int[][] matrix, int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        add(deque, x, y);
        int ans = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] pos = deque.poll();
                if (matrix[pos[0]][pos[1]] == 0) {
                    return ans;
                }
                add(deque, pos[0], pos[1]);
            }
            ans++;
        }
        return ans;
    }

    private void add(Deque<int[]> deque, int x, int y) {
        if (legal(x + 1, y)) {
            deque.offer(new int[]{x + 1, y});
        }
        if (legal(x - 1, y)) {
            deque.offer(new int[]{x - 1, y});
        }
        if (legal(x, y + 1)) {
            deque.offer(new int[]{x, y + 1});
        }
        if (legal(x, y - 1)) {
            deque.offer(new int[]{x, y - 1});
        }
    }

    private boolean legal(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
