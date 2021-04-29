package M721;

import java.util.*;

/**
 * 并查集
 *
 * @author JwZheng
 * @date 2021/3/17 18:05
 */
public class Solution {
    Map<String, String> map;
    Map<String, String> nameMap;


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        map = new LinkedHashMap<>();
        nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            int i = 1;
            String key = account.get(i);
            for (; i < account.size(); i++) {
                key = account.get(i);
                if (map.putIfAbsent(account.get(i), key) == null) {
                    nameMap.put(key, account.get(0));
                    break;
                }
            }
            for (; i < account.size(); i++) {
                map.putIfAbsent(account.get(i), key);
            }
        }

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size() - 1; i++) {
                union(account.get(i), account.get(i + 1));
            }
        }
        for (String s : map.keySet()) {
            find(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            if (s.equals(map.get(s))) {
                List<String> row = new ArrayList<>();
                row.add(nameMap.get(s));
                map.forEach((k, v) -> {
                    if (v.equals(s)) {
                        row.add(k);
                    }
                });
                Collections.sort(row);
                ans.add(row);
            }
        }
        return ans;
    }

    private String find(String str) {
        if (!str.equals(map.get(str))) {
            map.put(str, find(map.get(str)));
            return map.get(str);
        }
        return str;
    }

    private void union(String str1, String str2) {
        String k1 = find(str1);
        String k2 = find(str2);
        if (k1.equals(k2)) {
            return;
        }
        if (k1.hashCode() < k2.hashCode()) {
            map.put(k2, k1);
        } else {
            map.put(k1, k2);
        }
    }
}
