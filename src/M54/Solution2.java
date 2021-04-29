package M54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, columnStart = 0, rowEnd = m - 1, columnEnd = n - 1;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (int i = columnStart; i <= columnEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                ans.add(matrix[i][columnEnd]);
            }
            if (rowStart < rowEnd && columnStart < columnEnd) {
                for (int i = columnEnd - 1; i >= columnStart; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
                for (int i = rowEnd - 1; i > rowStart; i--) {
                    ans.add(matrix[i][columnStart]);
                }
            }
            rowStart++;
            columnStart++;
            rowEnd--;
            columnEnd--;
        }
        return ans;
    }

}
