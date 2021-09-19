package Sort;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/13 14:13
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 6, 2, 4};
        Sort sort = new HeapSort();
        System.out.println(Arrays.toString(sort.sort(new int[]{87, 45, 78, 32, 17, 65, 53, 9, 122, 133})));
        System.out.println(Arrays.toString(sort.sort(arr)));
    }
}
