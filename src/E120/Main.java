package E120;


import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {

        Solution2 s = new Solution2();
        List<List<Integer>> triangle= new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        temp.add(2);
        triangle.add(temp);
        temp =new ArrayList<>();

        temp.add(3);
        temp.add(4);
        triangle.add(temp);
        temp =new ArrayList<>();

        temp.add(6);
        temp.add(5);
        temp.add(7);
        triangle.add(temp);
        temp =new ArrayList<>();

        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        triangle.add(temp);

        System.out.println(s.minimumTotal(triangle));

    }
}
