package M1052;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, n = customers.length;
        for (int i = 0; i < n; i++) {
            sum += customers[i] * (1 - grumpy[i]);
        }
        int max = sum;
        for (int i = X; i < n; i++) {
            sum += customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
            max = Math.max(sum, max);
        }
        return max;
    }
}
