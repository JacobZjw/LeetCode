package J53;

import J53.Solution;

/**
 * @author JwZheng
 * @date 2021/3/18 12:48
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(solution.missingNumber(new int[]{1,2}));
        System.out.println(solution.missingNumber(new int[]{0,1}));
    }
}
