package Sort;

/**
 * 选择排序，数组实现的「直接选择排序」是不稳定的
 * 「最优时间复杂度」、「平均时间复杂度」和「最差时间复杂度」为: O(n²)。
 * 「空间复杂度」: O(1)
 *
 * @author JwZheng
 * @since 2021/9/13 13:53
 */
public class SelectionSort implements Sort{
    public int[] sort(int[] arr) {
        int n = arr.length, tmp, minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }
}
