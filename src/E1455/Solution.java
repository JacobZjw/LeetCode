package E1455;

/**
 * @author JwZheng
 * @since 2022/8/21 11:42
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }
}
