package J58;

/**
 * @author JwZheng
 * @date 2021/3/31 10:42
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int l = chars.length;

        for (int i = n; i < l; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
