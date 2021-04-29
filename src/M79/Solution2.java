package M79;

/**
 * @author JwZheng
 */
public class Solution2 {
    public boolean exist(char[][] board, String word) {
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
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || words[index] != board[x][y]) {
            return false;
        }
        if (index == words.length - 1) {
            return true;
        }
        board[x][y] = '\0';

        boolean res = helper(board, x - 1, y, words, index + 1) ||
                helper(board, x + 1, y, words, index + 1) ||
                helper(board, x, y + 1, words, index + 1) ||
                helper(board, x, y - 1, words, index + 1);
        board[x][y] = words[index];
        return res;
    }
}
