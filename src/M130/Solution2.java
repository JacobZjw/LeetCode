package M130;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 *
 * @author JwZheng
 * @date 2021/3/19 15:26
 */
public class Solution2 {
    boolean[][] visited;
    int m, n;
    Deque<int[]> queue;


    private void bfs(char[][] board, int i, int j) {
        if (board[i][j] == 'X') {
            visited[i][j] = true;
            return;
        }
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i1 = 0; i1 < size; i1++) {
                int[] pos = queue.poll();
                assert pos != null;
                visited[pos[0]][pos[1]] = true;
                if (legal(board, pos[0] - 1, pos[1])) {
                    queue.offer(new int[]{pos[0] - 1, pos[1]});
                }
                if (legal(board, pos[0] + 1, pos[1])) {
                    queue.offer(new int[]{pos[0] + 1, pos[1]});
                }
                if (legal(board, pos[0], pos[1] - 1)) {
                    queue.offer(new int[]{pos[0], pos[1] - 1});
                }
                if (legal(board, pos[0], pos[1] + 1)) {
                    queue.offer(new int[]{pos[0], pos[1] + 1});
                }
            }
        }
    }

    private boolean legal(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        return board[i][j] != 'X';
    }

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        queue = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }
}
