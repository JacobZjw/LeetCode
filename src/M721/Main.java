package M721;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JwZheng
 * @date 2021/3/17 18:05
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(
                solution.accountsMerge(
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
                                new ArrayList<>(Arrays.asList("John", "john00@mail.com", "johnsmith@mail.com")),
                                new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")),
                                new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"))
                        ))
                )
        );
        System.out.println(
                solution.accountsMerge(
                        new ArrayList<>(Arrays.asList(
                                new ArrayList<>(Arrays.asList("David","David0@m.co","David1@m.co")),
                                new ArrayList<>(Arrays.asList("David","David3@m.co","David4@m.co")),
                                new ArrayList<>(Arrays.asList("David","David4@m.co","David5@m.co")),
                                new ArrayList<>(Arrays.asList("David","David2@m.co","David3@m.co")),
                                new ArrayList<>(Arrays.asList("David","David1@m.co","David2@m.co"))
                        ))
                )
        );
    }
}
