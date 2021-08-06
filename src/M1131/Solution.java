package M1131;

/**
 * @author JwZheng
 * @date 2021/8/6 13:32
 */
public class Solution {
    public int MaxAbsValExpr(int[] arr1, int[] arr2) {
        int aMin = Integer.MAX_VALUE, aMax = Integer.MIN_VALUE;
        int bMin = Integer.MAX_VALUE, bMax = Integer.MIN_VALUE;
        int cMin = Integer.MAX_VALUE, cMax = Integer.MIN_VALUE;
        int dMin = Integer.MAX_VALUE, dMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            aMin = Math.min(aMin, arr1[i] + arr2[i] + i);
            aMax = Math.max(aMax, arr1[i] + arr2[i] + i);

            bMin = Math.min(bMin, arr1[i] + arr2[i] - i);
            bMax = Math.max(bMax, arr1[i] + arr2[i] - i);

            cMin = Math.min(cMin, arr1[i] - arr2[i] + i);
            cMax = Math.max(cMax, arr1[i] - arr2[i] + i);

            dMin = Math.min(dMin, arr1[i] - arr2[i] - i);
            dMax = Math.max(dMax, arr1[i] - arr2[i] - i);
        }
        return Math.max(Math.max(aMax - aMin, bMax - bMin), Math.max(cMax - cMin, dMax - dMin));
    }
}
