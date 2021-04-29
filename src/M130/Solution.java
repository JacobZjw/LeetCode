package M130;

import java.util.Arrays;

/**
 * DFS
 *
 * @author JwZheng
 * @date 2021/3/19 14:34
 */
public class Solution {
    boolean[][] visited;
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
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

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}
