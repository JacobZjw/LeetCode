package Sort;

import java.util.Arrays;

/**
 * 归并排序，稳定 <br/>
 *「最优时间复杂度」、「平均时间复杂度」和「最差时间复杂度」为: O(n㏒n)。
 *「空间复杂度」: O(n)
 *
 * @author JwZheng
 * @since 2021/9/13 14:27
 */
public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return arr;
        }
        int middle = (int) Math.floor((double) n / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, n);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0;
        int i = 0;
        while (l < left.length && r < right.length) {
            result[i++] = left[l] < right[r] ? left[l++] : right[r++];
        }
        while (l < left.length) {
            result[i++] = left[l++];
        }
        while (r < right.length) {
            result[i++] = right[r++];
        }
        return result;
    }
}
