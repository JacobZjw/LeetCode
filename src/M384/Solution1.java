package M384;

import java.util.Random;

/**
 * @author JwZheng
 */
public class Solution1 {
    int[] raw;
    int[] shuffle;

    public Solution1(int[] nums) {
        this.raw = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return raw;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        this.shuffle = raw;
        Random random = new Random();
        int n = random.nextInt(raw.length);
        dfs(n, 0);
        return this.shuffle;
    }

    public boolean dfs(int n, int level) {
        if (n <= 0 || level == shuffle.length - 1) {
            return true;
        }
        for (int i = level; i < shuffle.length; i++) {
            swap(i, level);
            if (!dfs(n--, level + 1)) {
                swap(i, level);
            }
        }
        return false;
    }

    private void swap(int i, int j) {
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }
}
