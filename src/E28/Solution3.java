package E28;

/**
 * @author JwZheng
 */
public class Solution3 {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length(), nLength = needle.length();
        if (nLength == 0) {
            return 0;
        }
        int ph = 0;
        while (ph < hLength - nLength + 1) {
            while (ph < hLength - nLength + 1 && haystack.charAt(ph) != needle.charAt(0)) {
                ++ph;
            }
            int curLen = 0, pn = 0;
            while (ph < hLength && pn < nLength && haystack.charAt(ph) == needle.charAt(pn)) {
                ++ph;
                ++pn;
                ++curLen;
            }

            if (curLen == nLength) {
                return ph - nLength;
            }
            ph = ph - curLen + 1;
        }
        return -1;
    }
}
