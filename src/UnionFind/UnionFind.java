package UnionFind;

/**
 * @author JwZheng
 * @date 2021/3/20 0:03
 */
public class UnionFind {
    public int[] parents;

    public UnionFind(int n) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[y] = x;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
