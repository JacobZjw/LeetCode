package Sort;

/**
 * 插入排序,稳定
 * 思想：把待排序的数组分成已排序和未排序两部分，从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * 「最优时间复杂度」: O(n)
 * 「平均时间复杂度」和「最差时间复杂度」为: O(n²)。
 * 「空间复杂度」: O(1)
 *
 * @author JwZheng
 * @since 2021/9/13 14:04
 */
public class InsertionSort implements Sort {
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i], pos = i;
            while (pos > 0 && arr[pos - 1] > value) {
                arr[pos] = arr[--pos];
            }
            arr[pos] = value;
        }
        return arr;
    }
}
