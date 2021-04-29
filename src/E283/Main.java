package E283;


/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1,0};
        s.moveZeroes(a);
        for(int i : a){
            System.out.print(i);
        }
    }
}
