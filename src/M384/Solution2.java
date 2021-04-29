package M384;

import java.util.Random;

/**
 * @author JwZheng
 */
public class Solution2 {
    int[] raw;
    int[] shuffle;
    Random ran;

    public Solution2(int[] nums) {
        this.raw = nums;
        this.shuffle = nums.clone();
        this.ran = new Random();
    }

    public int[] reset() {
        this.shuffle = this.raw;
        this.raw = this.raw.clone();
        return this.raw;
    }

    public int[] shuffle() {
        for (int i = 0; i < shuffle.length; i++) {
            swap(i, randRange(i, shuffle.length));
        }
        return this.shuffle;
    }

    private int randRange(int min, int max) {
        return ran.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }
}
