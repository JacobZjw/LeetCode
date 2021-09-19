package WC130;

/**
 * Top K 问题，选择排序
 *
 * @author JwZheng
 * @since 2021/9/18 15:12
 */
public class Solution {
    public int findKth(int[] a, int n, int K) {
        for (int i = 0; i < K; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (a[max] < a[j]) {
                    max = j;
                }
            }
            if (max != i) {
                int tmp = a[max];
                a[max] = a[i];
                a[i] = tmp;
            }
        }
        return a[K - 1];
    }
}
