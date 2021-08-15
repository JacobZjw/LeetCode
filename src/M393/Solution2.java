package M393;

/**
 * @author JwZheng
 * @since 2021/8/15 22:42
 */
public class Solution2 {
    public boolean validUtf8(int[] data) {
        int begin = 0;
        while (begin < data.length) {
            int num = 0;
            for (int i = 7; i >= 0; i--) {
                if (((1 << i) & data[begin]) == 0) {
                    break;
                }
                num++;
            }
            if (num == 1 || num > 4 || num > data.length - begin) {
                return false;
            }
            for (int i = 1; i < num; i++) {
                if ((data[begin + i] & (1 << 7)) == 0 || (data[begin + i] & (1 << 6)) > 0) {
                    return false;
                }
            }
            begin = num == 0 ? begin + 1 : begin + num;
        }
        return true;
    }
}
