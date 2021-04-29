package J16;

/**
 * @author JwZheng
 */
public class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        } else if (n % 2 != 0) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }
}
