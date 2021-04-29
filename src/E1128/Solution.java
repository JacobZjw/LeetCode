package E1128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int len = dominoes.length;
        Map<Pair, Integer> map = new HashMap<>(len);
        for (int[] array : dominoes) {
            Pair key = new Pair(array[0], array[1]);
            if (map.computeIfPresent(key, (k, v) -> v + 1) == null) {
                map.put(key, 0);
            }
        }
        int res = 0;
        for (Integer v : map.values()) {
            res += v;
        }
        return res;
    }

    class Pair {
        int v1;
        int v2;

        public Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return v1 == pair.v1 && v2 == pair.v2 || v1 == pair.v2 && v2 == pair.v1;
        }

        @Override
        public int hashCode() {
            if (v1 > v2) {
                return v2 * 10 + v1;
            }
            return v1 * 10 + v2;
        }

    }
}
