package E1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix[0].length;
        int n = matrix.length;

        int[] row = new int[n];
        int[] column = new int[m];

        Arrays.fill(row,Integer.MAX_VALUE);

        for (int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(row[i] > matrix[i][j]){
                    row[i] = matrix[i][j];
                }
            }
        }

        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                if(column[i] < matrix[j][i]){
                    column[i] = matrix[j][i];
                }
            }
        }

        for (int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == column[j] && matrix[i][j] == row[i]){
                    res.add(matrix[i][j]);
                }
            }
        }

        return res;
    }
}
