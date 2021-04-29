package M1584;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author JwZheng
 * @date 2021/3/19 13:02
 */
public class Solution {
    List<Integer> p;

    public int minCostConnectPoints(int[][] points) {
        p = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            p.add(i);
        }
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        Collections.sort(edges, Comparator.comparingInt(v -> v.val));
        int ans = 0;
        for (Edge edge : edges) {
            int a = find(edge.a), b = find(edge.b);
            if (a != b) {
                p.set(a, b);
                ans += edge.val;
            }
        }
        return ans;

    }

    public int find(int x) {
        if (p.get(x) != x) {
            p.set(x, find(p.get(x)));
        }

        return p.get(x);
    }


}

// 定义边
class Edge {
    // 分别表示一条边两个点的索引和边长
    int a, b, val;

    public Edge(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}