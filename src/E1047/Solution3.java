package E1047;

/**
 * @author JwZheng
 */
public class Solution3 {
    public String removeDuplicates(String S) {
        char[] ans = new char[S.length()];
        int j = -1;
        for (char ch : S.toCharArray()) {
            if (j >= 0 && ch == ans[j]) {
                --j;
            } else {
                ans[++j] = ch;
            }
        }

        return new String(ans, 0, j + 1);
    }
}
