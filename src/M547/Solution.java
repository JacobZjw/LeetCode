package M547;

/**
 * 并查集的傻逼版本
 *
 * @author JwZheng
 * @date 2021/3/17 13:14
 */
public class Solution {
    int[] parents;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
//        Set<Integer> set = new HashSet<>();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (/*i != j &&*/ isConnected[i][j] == 1) {
                    int i1 = find(i);
                    int j1 = find(j);
                    parents[j1] = parents[i1] = Math.min(i1, j1);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            int x = i;
//            while (x != parents[x]) {
//                parents[x] = parents[parents[x]];
//                x = parents[x];
//            }
//        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                count++;
            }
//            set.add(parents[i]);
        }
//        return set.size();
        return count;
    }


    private int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
            return parents[x];
        }
        return x;
    }
}
