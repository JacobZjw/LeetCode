package E454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int res = 0;

        //值-次数
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                int sum = A[i] + B[j];
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
                sum = C[i] + D[j];
                map2.put(sum, map2.getOrDefault(sum, 0) + 1);
            }
        }

        Integer[] value1 = new Integer[map1.size()];
        map1.keySet().toArray(value1);

        Integer[] value2 = new Integer[map2.size()];
        map2.keySet().toArray(value2);

        for (int i = 0;i < value1.length;i++){
            for (int j = 0;j < value2.length;j++){
                if(value1[i] + value2[j] == 0){
                    res += map1.get(value1[i]) * map2.get(value2[j]);
                }
            }
        }

        return res;
    }
}
