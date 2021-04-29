package M1722;

/**
 * @author JwZheng
 * @date 2021/3/18 13:06
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //1
        System.out.println(solution.minimumHammingDistance(
                new int[]{2, 3, 1},
                new int[]{1, 2, 2},
                new int[][]{{0, 2}, {1, 2}}
        ));

        //1
        System.out.println(solution.minimumHammingDistance(
                new int[]{1, 2, 3, 4},
                new int[]{2, 1, 4, 5},
                new int[][]{{2, 3}, {0, 1}}
        ));


        //4
        System.out.println(solution.minimumHammingDistance(
                new int[]{71, 13, 6, 60, 22, 31},
                new int[]{66, 57, 2, 60, 22, 73},
                new int[][]{{4, 5}, {0, 4}}
        ));

        //0
        System.out.println(solution.minimumHammingDistance(
                new int[]{5, 1, 2, 4, 3},
                new int[]{1, 5, 4, 2, 3},
                new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}
        ));
        //14
        System.out.println(solution.minimumHammingDistance(
                new int[]{50, 46, 54, 35, 18, 42, 26, 72, 75, 47, 50, 4, 54, 21, 18, 18, 61, 64, 100, 14},
                new int[]{83, 34, 43, 73, 61, 94, 10, 68, 74, 31, 54, 46, 28, 60, 18, 18, 4, 44, 79, 92},
                new int[][]{{1, 8}, {14, 17}, {3, 1}, {17, 10}, {18, 2}, {7, 12}, {11, 3}, {1, 15}, {13, 17}, {18, 19}, {0, 10}, {15, 19}, {0, 15}, {6, 7}, {7, 15}, {19, 4}, {7, 16}, {14, 18}, {8, 10}, {17, 0}, {2, 13}, {14, 10}, {12, 17}, {2, 9}, {6, 15}, {16, 18}, {2, 16}, {2, 6}, {4, 5}, {17, 5}, {10, 13}, {7, 2}, {9, 16}, {15, 5}, {0, 5}, {8, 0}, {11, 12}, {9, 7}, {1, 0}, {11, 17}, {4, 6}, {5, 7}, {19, 12}, {3, 18}, {19, 1}, {13, 18}, {19, 6}, {13, 6}, {6, 1}, {4, 2}}
        ));

    }
}
