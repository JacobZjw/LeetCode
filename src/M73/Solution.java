package M73;

/**
 * @author JwZheng
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHaveZero = false;
        boolean firstColumnHaveZero = false;

        for (int i = 0;i < n;i++){
            if(matrix[0][i] == 0){
                firstRowHaveZero = true;
            }
        }
        for (int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                firstColumnHaveZero = true;
            }
        }

        //将第一行、第一列作为标记位；
        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //遍历第一列，将第一列为0的行全部置0
        for (int i = 1;i < m;i++){
            if(matrix[i][0] == 0){
                for (int j = 1;j < n;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //遍历第一行，将第一行为0的列全部置0
        for (int i = 1;i < n;i++){
            if(matrix[0][i] == 0){
                for (int j = 1;j < m;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(firstColumnHaveZero){
            for (int i = 0;i < m;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRowHaveZero){
            for (int i = 0;i < n;i++){
                matrix[0][i] = 0;
            }
        }
    }

}
