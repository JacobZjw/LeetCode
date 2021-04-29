package M79;

/**
 * @author JwZheng
 */
public class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0] && helper(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int x, int y, char[] words, int index) {
        visited[x][y] = true;
        if (index >= words.length - 1 && words[index] == board[x][y]) {
            return true;
        }
        if (words[index] != board[x][y]) {
            visited[x][y] = false;
            return false;
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && helper(board, x - 1, y, words, index + 1)) {
            return true;
        }
        if (x + 1 < board.length && !visited[x + 1][y] && helper(board, x + 1, y, words, index + 1)) {
            return true;
        }
        if (y + 1 < board[0].length && !visited[x][y + 1] && helper(board, x, y + 1, words, index + 1)) {
            return true;
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && helper(board, x, y - 1, words, index + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }
}
