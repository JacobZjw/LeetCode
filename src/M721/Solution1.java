package M721;

import java.util.*;

/**
 * 并查集优化版，等待继续优化
 *
 * @author JwZheng
 * @date 2021/3/17 18:05
 */
public class Solution1 {
    Map<String, String> map;
    Map<String, String> nameMap;


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        map = new LinkedHashMap<>();
        nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            String email = account.get(1);
            if (map.putIfAbsent(email, email) == null) {
                nameMap.put(email, account.get(0));
            }
            for (int i = 2; i < account.size(); i++) {
                email = account.get(i);
                if (map.putIfAbsent(email, email) == null) {
                    nameMap.put(email, account.get(0));
                }
                union(email, account.get(i - 1));
            }
        }

        // 暂时存储答案中的邮箱列表，每个键值对的键就是每个并查集集合的根元素
        Map<String, List<String>> rowMap = new HashMap<>();
        for (String email : map.keySet()) {
            // 获取当前邮箱对应并查集的根元素
            String root = find(email);
            // 将当前邮箱放入根元素对应的列表中
            List<String> list = rowMap.getOrDefault(root, new ArrayList<>());
            list.add(email);
            rowMap.put(root, list);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : rowMap.entrySet()) {
            String key = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);

            emails.add(0, nameMap.get(key));
            ans.add(emails);
        }
        return ans;
    }

    private String find(String str) {
        if (!str.equals(map.get(str))) {
            map.put(str, find(map.get(str)));
        }
        return map.get(str);
    }

    private void union(String str1, String str2) {
        String k1 = find(str1);
        String k2 = find(str2);
        if (k1.equals(k2)) {
            return;
        }
        map.put(k2, k1);
    }
}

