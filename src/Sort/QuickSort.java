package Sort;

/**
 * 快速排序，不稳定
 * 「最优时间复杂度」、「平均时间复杂度」: O(n㏒n)
 * 「最差时间复杂度」为: O(n²)。
 * 「空间复杂度」: O(㏒n)
 *
 * @author JwZheng
 * @since 2021/9/13 15:31
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //分区
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high) {
        //基准
        int pivot = arr[low];
        while (low < high) {
            //从后往前找，找到第一个小于基准的数，放到基准的前面
            while (low < high && arr[high] >= pivot) --high;
            //省去交换过程
            arr[low] = arr[high];
            //从前往后找，找到第一个大于基准的数，放到基准后面
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        //找到基准在排序数组中的位置。
        arr[low] = pivot;
        return low;
    }
}
