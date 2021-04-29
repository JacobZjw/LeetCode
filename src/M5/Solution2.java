package M5;

/**
 * @author JwZheng
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int oddLen = centerPalindrome(chars, i, i);
            int evenLen = centerPalindrome(chars, i, i + 1);

            int curLen = Math.max(oddLen, evenLen);

            if (curLen > maxLen) {
                maxLen = curLen;
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public int centerPalindrome(char[] chars, int left, int right) {
        int len = chars.length;
        while (left >= 0 && right < len) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
