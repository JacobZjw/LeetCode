package M54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    List<Integer> ans;
    int[][] matrix;
    int m, n;

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dfs(0, m - 1, 0, n - 1);
        int more = ans.size() - m * n;
        for (int i = 0; i < more; i++) {
            ans.remove(ans.size() - 1);
        }
        return ans;
    }

    public void dfs(int rowStart, int rowEnd, int columnStart, int columnEnd) {
        if (rowStart > rowEnd || columnStart > columnEnd || rowEnd < 0 || columnEnd < 0 || ans.size() >= m * n) {
            return;
        }
        for (int i = columnStart; i <= columnEnd; i++) {
            ans.add(matrix[rowStart][i]);
        }
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            ans.add(matrix[i][columnEnd]);
        }
        for (int i = columnEnd - 1; i >= columnStart; i--) {
            ans.add(matrix[rowEnd][i]);
        }
        for (int i = rowEnd - 1; i > rowStart; i--) {
            ans.add(matrix[i][columnStart]);
        }
        dfs(rowStart + 1, rowEnd - 1, columnStart + 1, columnEnd - 1);
    }
}
