package C1707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JwZheng
 * @date 2021/3/19 10:25
 */
public class Solution1 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        UnionFind uf = new UnionFind();
        for (String str : names) {
            int index1 = str.indexOf('('), index2 = str.indexOf(')');
            String name = str.substring(0, index1);
            int count = Integer.parseInt(str.substring(index1 + 1, index2));
            //并查集初始化
            uf.parent.put(name, name);
            uf.size.put(name, count);
        }
        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1, index);
            String name2 = synonym.substring(index + 1, synonym.length() - 1);
            //避免漏网之鱼
            if (!uf.parent.containsKey(name1)) {
                uf.parent.put(name1, name1);
                //注意人数为0
                uf.size.put(name1, 0);
            }
            if (!uf.parent.containsKey(name2)) {
                uf.parent.put(name2, name2);
                uf.size.put(name2, 0);
            }
            uf.union(name1, name2);
        }
        List<String> res = new ArrayList<>();
        for (String str : names) {
            int index1 = str.indexOf('('), index2 = str.indexOf(')');
            String name = str.substring(0, index1);
            //根节点
            if (name.equals(uf.find(name)))
                res.add(name + "(" + uf.size.get(name) + ")");
        }
        return res.toArray(new String[res.size()]);
    }
}

//并查集
//路径压缩
class UnionFind {
    //当前节点的父亲节点
    Map<String, String> parent;
    //当前节点人数
    Map<String, Integer> size;

    public UnionFind() {
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
    }

    //找到x的根节点
    public String find(String x) {
        if (parent.get(x).equals(x)) {
            return x;
        }
        //路径压缩
        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    public void union(String x, String y) {
        String str1 = find(x), str2 = find(y);
        if (str1.equals(str2)) {
            return;
        }
        //字典序小的作为根
        if (str1.compareTo(str2) > 0) {
            parent.put(str1, str2);
            //人数累加到根节点
            size.put(str2, size.get(str1) + size.get(str2));
        } else {
            parent.put(str2, str1);
            size.put(str1, size.get(str2) + size.get(str1));
        }
    }

    //以x为根结点的子树包含的人数
    public int getSize(String x) {
        String str = find(x);
        return size.get(str);
    }

}