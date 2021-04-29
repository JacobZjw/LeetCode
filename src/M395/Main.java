package M395;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring("bbaaacbd", 3));
        System.out.println(solution.longestSubstring("ababbc", 2));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestSubstring("bbaaacbd", 3));
        System.out.println(solution2.longestSubstring("ababbc", 2));
    }
}
