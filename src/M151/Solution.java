package M151;

/**
 * @author JwZheng
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        char[] charArray = s.trim().toCharArray();
        int begin = charArray.length -1;
        int end = begin;

        while(begin >= 0){
            if(begin == 0 || charArray[begin] == ' '){
                if(begin == 0){
                    ans.append(charArray,begin,end - begin + 1);
                }else{
                    ans.append(charArray,begin + 1,end - begin);
                    ans.append(' ');
                }
                end = begin;
            }
            --begin;
            while(charArray[end] == ' '){
                end--;
                begin = end;
            }
        }
        return ans.toString();
    }
}