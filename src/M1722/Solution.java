package M1722;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 并查集，复杂模板题
 *
 * @author JwZheng
 * @date 2021/3/18 13:04
 */
public class Solution {
    int[] parents;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] allowedSwap : allowedSwaps) {
            union(allowedSwap[0], allowedSwap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if (!map.containsKey(root)) {
                map.put(root, new HashMap<>());
            }
            map.get(root).put(source[i], map.get(root).getOrDefault(source[i], 0) + 1);
        }
        System.out.println(map);
        System.out.println(Arrays.toString(parents));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            if ((!map.get(root).containsKey(target[i])) || (map.get(root).get(target[i]) == 0)) {
                ans++;
            } else {
                //有这个数字，对应的次数-1
                map.get(root).put(target[i], map.get(root).get(target[i]) - 1);
            }
        }
        return ans;
    }

    private void union(int x, int y) {
        int x1 = find(x);
        int y1 = find(y);
        if (x1 != y1) {
            parents[x1] = y1;
        }
    }

    private int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

}
