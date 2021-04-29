package J16;

/**
 * @author JwZheng
 */
public class Solution {
    public double myPow(double x, int n) {
        long y = n;//使用long类型接收，防止n为负数时直接取负导致溢出
        if (n < 0) {
            y = -y;
            x = 1 / x;
        }
        double res = 1;
        while (y != 0) {
            if (y % 2 != 0) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }
        return res;
    }
}
