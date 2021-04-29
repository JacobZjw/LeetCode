package M947;

import UnionFind.UnionFind;

import java.util.Arrays;

/**
 * 并查集
 * @author JwZheng
 * @date 2021/3/19 23:43
 */
public class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        System.out.println(Arrays.toString(uf.parents));
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i) {
                ans--;
            }
        }
        System.out.println(Arrays.toString(uf.parents));
        return ans;
    }
}
