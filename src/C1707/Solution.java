package C1707;

import java.util.*;

/**
 * 并查集，复杂模板题
 *
 * @author JwZheng
 * @date 2021/3/19 12:34
 */
public class Solution {

    Map<String, String> parentsMap = new HashMap<>();
    Map<String, Integer> namesMap = new HashMap<>();

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        for (String str : names) {
            String name = str.substring(0, str.indexOf("("));
            String count = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
            namesMap.put(name, Integer.valueOf(count));
            parentsMap.put(name, name);
        }

        for (String synonym : synonyms) {
            String s = synonym.replace("(", "").replace(")", "");
            String[] group = s.split(",");
            if (!namesMap.containsKey(group[0])) {
                namesMap.put(group[0], 0);
                parentsMap.put(group[0], group[0]);
            }
            if (!namesMap.containsKey(group[1])) {
                namesMap.put(group[1], 0);
                parentsMap.put(group[1], group[1]);
            }
            union(group[0], group[1]);
        }
        List<String> res = new ArrayList<>();
        for (String str : names) {
            String name = str.substring(0, str.indexOf("("));
            if (name.equals(find(name))) {
                res.add(name + "(" + namesMap.get(name) + ")");
            }
        }
        return res.toArray(new String[0]);
    }

    private void union(String a, String b) {
        String a1 = find(a);
        String b1 = find(b);
        if (a1.equals(b1)) {
            return;
        } else if (a1.compareTo(b1) < 0) {
            parentsMap.put(b1, a1);
            namesMap.put(a1, namesMap.get(a1) + namesMap.get(b1));
        } else {
            parentsMap.put(a1, b1);
            namesMap.put(b1, namesMap.get(a1) + namesMap.get(b1));
        }
    }

    private String find(String x) {
        if (!x.equals(parentsMap.get(x))) {
            parentsMap.put(x, find(parentsMap.get(x)));
        }
        return parentsMap.get(x);
    }
}
