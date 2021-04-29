package J13;

/**
 * @author JwZheng
 */
public class Solution {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return test(0, 0);
    }

    public int test(int i, int j) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j] || sum(i) + sum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return test(i, j - 1) + test(i, j + 1) + test(i + 1, j) + test(i - 1, j) + 1;
    }

    public int sum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
