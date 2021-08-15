package M393;

/**
 * @author JwZheng
 * @since 2021/8/15 20:55
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        return validUtf8(data, 0);
    }

    public boolean validUtf8(int[] data, int begin) {
        if (begin == data.length) {
            return true;
        }
        int num = countOne(data[begin]);
        if (num == 1 || num > 4 || num > data.length - begin) {
            return false;
        }
        for (int i = 1; i < num; i++) {
            if ((data[begin + i] & (1 << 7)) == 0 || (data[begin + i] & (1 << 6)) > 0) {
                return false;
            }
        }
        return num == 0 ? validUtf8(data, begin + 1) : validUtf8(data, begin + num);
    }


    private int countOne(int num) {
        int count = 0;
        for (int i = 7; i >= 0; i--) {
            if (((1 << i) & num) == 0) {
                return count;
            }
            count++;
        }
        return count;
    }
}
