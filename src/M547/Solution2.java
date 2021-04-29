package M547;

/**
 * 深度优先搜索
 *
 * @author JwZheng
 * @date 2021/3/17 14:22
 */
public class Solution2 {

    int[][] isConnected;
    boolean[] isVisited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        this.isConnected = isConnected;
        this.isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int j) {
        for (int k = 0; k < isConnected.length; k++) {
            if (isConnected[j][k] == 1 && !isVisited[k]) {
                isVisited[j] = true;
                dfs(k);
            }
        }
    }

}
