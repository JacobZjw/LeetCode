package M1052;

/**
 * @author JwZheng
 */
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int all = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                all += customers[i];
            }
        }
        int sum = all;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int max = sum;
        for (int i = X; i < n; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[i - X] == 1) {
                sum -= customers[i - X];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
