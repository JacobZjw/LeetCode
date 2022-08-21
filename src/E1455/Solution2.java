package E1455;

/**
 * @author JwZheng
 * @since 2022/8/21 11:46
 */
public class Solution2 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = 1, ptr = 0, len = sentence.length();
        char[] chars = sentence.toCharArray();
        char[] searchChars = searchWord.toCharArray();
        while (ptr < len) {
            while (ptr < len && chars[ptr] != searchChars[0]) {
                ++ans;
                while (ptr < len && chars[ptr] != ' ')
                    ptr++;
                ++ptr;
            }
            if (ptr >= len)
                return -1;
            int index = 0;
            while (index < searchWord.length() && searchChars[index] == chars[ptr]) {
                index++;
                ptr++;
            }
            if (index == searchWord.length())
                return ans;
        }
        return -1;
    }
}
