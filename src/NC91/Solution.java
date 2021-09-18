package NC91;

/**
 * @author JwZheng
 * @since 2021/9/11 21:22
 */
public class Solution {
    public int[] LIS(int[] arr) {
        int n = arr.length;
        // tail[i]表示长度为i + 1的子序列的最大值
        int[] tail = new int[n];
        // index[i]表示arr[i]是属于哪个长度的子序列
        int[] index = new int[n];
        int len = 1;
        tail[0] = arr[0];
        index[0] = len;
        for (int k = 1; k < n; k++) {
            int i = 0, j = len - 1;
            if (arr[k] > tail[len - 1]) {
                tail[len++] = arr[k];
                index[k] = len;
            } else {
                while (i < j) {
                    //判断num是否应该插入tail数组，以及插入的合理位置
                    int mid = (i + j) / 2;
                    if (tail[mid] < arr[k]) {
                        //当前长度上已是最小
                        i = mid + 1;
                    } else if (tail[mid] >= arr[k]) {
                        j = mid;
                    }
                }
                tail[i] = arr[k];
                index[k] = i + 1;
            }
        }
        int[] ans = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == len) {
                ans[--len] = arr[i];
            }
        }
        return ans;
    }
}
