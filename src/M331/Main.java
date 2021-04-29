package M331;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.isValidSerialization("9,#,93,#,9,9,#,#,#"));
        System.out.println(solution.isValidSerialization("9,#,#,1"));
        System.out.println(solution.isValidSerialization("9,#"));
        System.out.println(solution.isValidSerialization("#"));
        System.out.println(solution.isValidSerialization("1,#,#,1"));
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solution.isValidSerialization("91,13,14,#,#,10"));
    }
}
