package M542;

import java.util.Arrays;

/**
 * @author JwZheng
 * @date 2021/3/21 13:22
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.deepToString(
                solution.updateMatrix(
                        new int[][]{
                                {1,1,0,0,1,0,0,1,1,0},
                                {1,0,0,1,0,1,1,1,1,1},
                                {1,1,1,0,0,1,1,1,1,0},
                                {0,1,1,1,0,1,1,1,1,1},
                                {0,0,1,1,1,1,1,1,1,0},
                                {1,1,1,1,1,1,0,1,1,1},
                                {0,1,1,1,1,1,1,0,0,1},
                                {1,1,1,1,1,0,0,1,1,1},
                                {0,1,0,1,1,0,1,1,1,1},
                                {1,1,1,0,1,0,1,1,1,1}})));
        System.out.println(Arrays.deepToString(
                solution.updateMatrix(
                        new int[][]{
                                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}})));
        System.out.println(Arrays.deepToString(
                solution.updateMatrix(
                        new int[][]{
                                {0, 1, 0, 1, 1},
                                {1, 1, 0, 0, 1},
                                {0, 0, 0, 1, 0},
                                {1, 0, 1, 1, 1},
                                {1, 0, 0, 0, 1}})));
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
    }
