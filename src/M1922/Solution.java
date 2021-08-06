package M1922;

/**
 * @author JwZheng
 * @date 2021/8/6 13:08
 */
public class Solution {
    public int countGoodNumbers(long n) {
        long even = pow(4, n / 2) % 1000000007;
        long odd = pow(5, (n + 1) / 2) % 1000000007;
        return (int) ((even * odd) % 1000000007);
    }

    private long pow(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * x) % 1000000007;
            }
            n /= 2;
            x = (x * x) % 1000000007;
        }
        return ans;
    }
}
