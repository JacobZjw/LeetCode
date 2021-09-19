package WC130;

/**
 * 快排解决 TopK 问题
 * @author JwZheng
 * @since 2021/9/18 15:20
 */
public class Solution2 {
    public int findKth(int[] a, int n, int K) {
        return findK(a, 0, n - 1, K);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] >= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    private int findK(int[] arr, int low, int high, int k) {
        if (low > high) {
            return -1;
        }
        int pivot = partition(arr, low, high);
        if (pivot == k - 1) {
            return arr[pivot];
        } else if (pivot < k - 1) {
            return findK(arr, pivot + 1, high, k);
        } else if (pivot > k - 1) {
            return findK(arr, low, pivot - 1, k);
        }
        return -1;
    }
}
