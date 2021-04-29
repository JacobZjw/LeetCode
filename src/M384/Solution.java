package M384;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author JwZheng
 */
public class Solution {
    int[] raw;
    int[] shuffle;
    Random random;

    public Solution(int[] nums) {
        this.raw = nums;
        this.shuffle = nums.clone();
        this.random = new Random();
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
        List<Integer> arrayCopy = getArrayCopy();
        for (int i = 0; i < shuffle.length; i++) {
            int randomIndex = random.nextInt(arrayCopy.size());
            shuffle[i] = arrayCopy.get(randomIndex);
            arrayCopy.remove(randomIndex);
        }
        return shuffle;
    }

    private List<Integer> getArrayCopy() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < raw.length; i++) {
            res.add(raw[i]);
        }
        return res;
    }

}
