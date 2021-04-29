package E167;

/**
 * @author JwZheng
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (target - numbers[right] == numbers[left]) {
                return new int[]{++left, ++right};
            } else if (target - numbers[right] < numbers[left]) {
                --right;
            } else {
                ++left;
            }
        }
        return new int[]{-1,-1};
    }
}
