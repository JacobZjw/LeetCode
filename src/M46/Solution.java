package M46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    List<List<Integer>> ans;
    List<Integer> row;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        row = new ArrayList<>();
        for (int i : nums) {
            row.add(i);
        }
        helper(0);
        return ans;
    }

    public void helper(int level) {
        if (level == row.size() - 1) {
            ans.add(new ArrayList<>(row));
            return;
        }
        for (int i = level; i < row.size(); i++) {
            Collections.swap(row, level, i);
            helper(level + 1);
            Collections.swap(row, level, i);
        }
    }
}
