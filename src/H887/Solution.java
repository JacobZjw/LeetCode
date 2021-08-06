package H887;

/**
 * 暴力解法
 *
 * @author JwZheng
 * @date 2021/7/14 11:05
 */
public class Solution {
    public int superEggDrop(int K, int N) {
        if (K == 1 || N == 1 || N == 0) {
            return N;
        }
        int min = N;
        //循环求出F的各种可能下所需的最小操作次数
        for (int i = 1; i <= N; i++) {
            //当前层鸡蛋碎了和当前层鸡蛋没碎，则往上N-i层
            int t = Math.max(superEggDrop(K - 1, i - 1), superEggDrop(K, N - i));
            min = Math.min(min, t + 1);
        }
        return min;
    }
}
