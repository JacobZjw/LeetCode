package Sort;

/**
 * 堆排序
 * 「最优时间复杂度」、「平均时间复杂度」和「最差时间复杂度」为: O(㏒n)。
 * 「空间复杂度」: O(1)
 * @author JwZheng
 * @since 2021/9/19 20:16
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //通过上浮操作，保证了每一个父节点都大于其子节点的值，即构造了大根堆
            siftUp(arr, i);
        }
        while (n > 1) {
            //相当于移除大根堆的头部，然后插入新的树
            swap(arr, 0, --n);
            //则需要把新插入的树下沉到合适位置
            siftDown(arr, 0, n);
            //(n ~ arr.length) 则为已排序的子数组
        }
        return arr;
    }

    private void siftUp(int[] arr, int index) {
        int value = arr[index];
        while (index > 0) {
            int daddy = (index - 1) >>> 1;
            if (arr[daddy] > value) {
                break;
            }
            arr[index] = arr[daddy];
            index = daddy;
        }
        arr[index] = value;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j)
            return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void siftDown(int[] arr, int index, int end) {
        int val = arr[index], half = end >>> 1;
        while (index < half) {
            int left = (index << 1) + 1, right = left + 1;
            int min = arr[left];
            if (right < end && arr[right] > min) {
                min = arr[left = right];
            }
            if (min <= val)
                break;
            arr[index] = min;
            index = left;
        }
        arr[index] = val;
    }
}
