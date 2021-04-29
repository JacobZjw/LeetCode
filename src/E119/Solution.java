package E119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int temp;
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(1);
            temp = ans.get(0);
            for (int j = 1; j < i; ++j) {
                int l = temp + ans.get(j);
                temp = ans.get(j);
                ans.set(j, l);
            }
        }
        return ans;
    }
}
