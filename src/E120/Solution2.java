package E120;

import java.util.List;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int y = triangle.size();
        int x = triangle.get(y-1).size();
        int[] dp = new int[x];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1;i < y;i++){
            List<Integer> row = triangle.get(i);
            int prev = dp[0];
            dp[0] += row.get(0);
            dp[row.size() - 1] = Integer.MAX_VALUE;
            int temp = prev;
            for(int j = 1;j < row.size();++j){
                temp = dp[j];
                dp[j] = Math.min(dp[j],prev) + row.get(j);
                prev = temp;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < x;i++){
            if(dp[i] < res){
                res = dp[i];
            }
        }
        return res;
    }
}
