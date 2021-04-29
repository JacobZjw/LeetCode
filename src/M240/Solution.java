package M240;

/**
 * @author JwZheng
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int m = 0, n = cols - 1;
        while (m < rows && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] < target) {
                ++m;
            } else {
                --n;
            }
        }
        return false;

    }
}
