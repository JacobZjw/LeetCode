package M547;

/**
 * 并查集解法，Solution的优化版本
 *
 * @author JwZheng
 * @date 2021/3/17 13:14
 */
public class Solution1 {
    int[] parents;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                count++;
            }
        }
        return count;
    }


    private void union(int x, int y) {
        parents[find(y)] = find(x);
    }

    private int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
            return parents[x];
        }
        return x;
    }
}
