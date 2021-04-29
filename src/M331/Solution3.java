package M331;

/**
 * @author JwZheng
 */
public class Solution3 {
    public boolean isValidSerialization(String preorder) {
        int i = 0, slots = 1, n = preorder.length();
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (',' == preorder.charAt(i)) {
                i++;
            } else if ('#' == preorder.charAt(i)) {
                i++;
                slots--;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    ++i;
                }
                slots++;
            }
        }
        return slots == 0;
    }
}
