package Sort;

/**
 * @author JwZheng
 * @since 2021/9/13 16:58
 */
public class ShellSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i, tmp = arr[j];
                while (j - gap >= 0 && tmp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
