package Sort;

import java.util.Arrays;

/**
 * @author JwZheng
 * @since 2021/9/13 14:13
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 6, 2, 4};
        Sort sort = new ShellSort();
        System.out.println(Arrays.toString(sort.sort(arr)));
    }
}
