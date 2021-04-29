package M5;

/**
 * @author JwZheng
 */
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i ; j < n; j++) {
                if ((j - i + 1 > maxLen) && isPalindrome(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
