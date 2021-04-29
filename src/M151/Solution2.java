package M151;

/**
 * @author JwZheng
 */
public class Solution2 {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        int length = sb.length();
        int left = 0;
        int right = length - 1;

        reverse(sb,left,right);
        right = left;
        while(right < length){
            if(right == length - 1 || sb.charAt(right) == ' '){
                if(right == length -1){
                    reverse(sb,left,right);
                }else{
                    reverse(sb,left,right - 1);
                }
                left = right + 1;
            }
            right++;
        }
        return sb.toString();
    }

    public void reverse(StringBuilder sb,int left,int right){
        char temp;
        while(left < right){
            temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }

    public StringBuilder trimSpaces(String s){
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' '){
            left++;
        }
        while (s.charAt(right) == ' '){
            right--;
        }

        while (left <= right){
            if(s.charAt(left) != ' '){
                sb.append(s.charAt(left));
            }else if(s.charAt(left-1) != ' '){
                sb.append(' ');
            }
            ++left;
        }
        return  sb;
    }
}
