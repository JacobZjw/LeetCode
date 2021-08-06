package J73;

/**
 * @author JwZheng
 * @date 2021/8/6 14:14
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        while (min < max) {
            int mid = (max + min) >> 1;
            int hour = 0;
            for (int pile : piles) {
                if (pile % mid != 0)//抵消向下取整少算的次数
                    hour++;
                hour += (pile / mid);
            }
            if (hour > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
