package M947;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集，官方题解
 *
 * @author JwZheng
 * @date 2021/3/20 0:11
 */
public class Solution2 {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            //x轴坐标取反为了跟Y轴分开
            uf.union(~stone[0], stone[1]);
        }
        return stones.length - uf.getCount();
    }
}

class UnionFind {
    private Map<Integer, Integer> parents;
    //记录不连通的石头数量
    private int count;

    public UnionFind() {
        parents = new HashMap<>();
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
        if (!parents.containsKey(x)) {
            //新增的石头，父节点是自己
            parents.put(x, x);
            count++;
        }
        if (x != parents.get(x)) {
            parents.put(x, find(parents.get(x)));
        }
        return parents.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        //联通两个石头
        parents.put(x, y);
        count--;
    }
}