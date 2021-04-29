package E125;

/**
 * @author JwZheng
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            if (!Character.isLetterOrDigit(charArray[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(charArray[r])) {
                r--;
                continue;
            }
            if ((Character.isDigit(charArray[l]) || Character.isDigit(charArray[r])) && charArray[l] != charArray[r]) {
                return false;
            } else if (charArray[l] != charArray[r] && (charArray[l] + 32 != charArray[r]) && (charArray[l] - 32 != charArray[r])) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
