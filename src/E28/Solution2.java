package E28;

/**
 * @author JwZheng
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();
        if(nLength == 0){
            return 0;
        }else if(nLength > hLength){
            return -1;
        }
        for(int i = 0;i < hLength - nLength + 1;i++){
            if(needle.equals(haystack.substring(i,i + nLength))){
                return i;
            }
        }
        return -1;
    }
}
