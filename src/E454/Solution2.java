package E454;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int res = 0;

        //值-次数
        Map<Integer,Integer> map = new HashMap<>(len*len);

        for (int a : A){
            for (int b : B){
                map.compute(a + b, (k,v) -> {
                    if(v == null) return 1;
                    else return v + 1;
                });
            }
        }

        for (int c : C){
            for (int d : D){
                Integer i = map.get(- c - d);
                if(i != null){
                    res += i;
                }
            }
        }

        return res;
    }
}
