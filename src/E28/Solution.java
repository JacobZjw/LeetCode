package E28;

/**
 * @author JwZheng
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if (nLength == 0) {
            return 0;
        } else if (nLength > hLength) {
            return -1;
        }
        int res = -1;
        int h = 0;
        int n = 0;
        while (h < hLength) {
            while (h < hLength && n < nLength && haystack.charAt(h) == needle.charAt(n)) {
                if (res == -1) {
                    res = h;
                }
                ++h;
                ++n;
            }
            if (n == nLength) {
                break;
            } else if (n != 0) {
                n = 0;
                h = res;
                res = -1;
            }
            ++h;
        }
        return res;
    }
}