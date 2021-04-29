package E189;

/**
 * @author JwZheng
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        int toSwapIndex;
        int toSwapValue;

        int nextIndex;
        int nextValue;

        k %= len;

        int count = gcd(k, len);

        for (int i = 0; i < count; i++) {

            toSwapIndex = i;
            toSwapValue = nums[i];

            int start = nums[i];

            do {

                nextIndex = (toSwapIndex + k) % len;
                nextValue = nums[nextIndex];

                nums[nextIndex] = toSwapValue;

                toSwapIndex = nextIndex;
                toSwapValue = nextValue;

            } while (nextValue != start);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
