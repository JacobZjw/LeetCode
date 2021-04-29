package E120;

import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int y = triangle.size();
        int x = triangle.get(y-1).size();
        int[][] dp = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < y;i++){
            List<Integer> row = triangle.get(i);
            dp[i][0] = dp[i-1][0] + row.get(0);
            dp[i-1][row.size() - 1] = Integer.MAX_VALUE;
            for(int j = 1;j < row.size();++j){
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + row.get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < x;i++){
            if(dp[y-1][i] < res){
                res = dp[y-1][i];
            }
        }
        return res;
    }
}
