package Sort;

/**
 * 冒泡排序,稳定
 * 数据完全有序的时候展现出 「最优时间复杂度」: O(n)
 * 「平均时间复杂度」和「最差时间复杂度」为: O(n²)。
 * 「空间复杂度」: O(1)
 *
 * @author JwZheng
 * @since 2021/9/13 13:43
 */
public class BubbleSort implements Sort{
    public int[] sort(int[] arr) {
        int n = arr.length, tmp;
        boolean swap = false;
        for (int i = n - 1; i > 0; i--) {
            //每经过一轮扫描，最末尾元素即为最大的元素，因此每次忽略最后的元素
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            //当前一轮没有进行数据交换，则说明数组有序
            if (!swap)
                break;
        }
        return arr;
    }
}
