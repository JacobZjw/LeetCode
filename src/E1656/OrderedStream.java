package E1656;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JwZheng
 * @since 2022/8/16 21:14
 */
public class OrderedStream {
    private final String[] data;
    private int ptr = 1;
    private final int n ;

    public OrderedStream(int n) {
        this.n = n + 1;
        this.data = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        data[idKey] = value;
        List<String> ans = new ArrayList<>();
        while (ptr < n && data[ptr] != null)
            ans.add((data[ptr++]));
        return ans;
    }
}
