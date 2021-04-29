package M739;

/**
 * 暴力解法
 *
 * @author JwZheng
 * @date 2021/3/20 11:00
 */
public class Solution {
    /**
     * @param T [73, 74, 75, 71, 69, 72, 76, 73]
     * @return [1, 1, 4, 2, 1, 1, 0, 0]
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = i + 1; j < n; j++) {
                if (T[j] > T[i]) {
                    T[i] = j - i;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                T[i] = 0;
            }
        }
        return T;
    }
}
