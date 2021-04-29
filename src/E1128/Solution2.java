package E1128;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] array = new int[100];
        int res = 0;
        for (int[] dominoe : dominoes){
            if(dominoe[0] > dominoe[1]){
                dominoe[0] ^= dominoe[1];
                dominoe[1] ^= dominoe[0];
                dominoe[0] ^= dominoe[1];
            }

            int key  = dominoe[0]*10 + dominoe[1];
            res += array[key];
            ++array[key];
        }
        return res;
    }
}
