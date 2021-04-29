package M133;

import java.util.HashMap;
import java.util.Map;

/**
 * DFS
 *
 * @author JwZheng
 * @date 2021/3/23 12:47
 */
public class Solution {
    Map<Integer, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node cloneNode = nodeMap.get(node.val);
        if (cloneNode != null) {
            return cloneNode;
        }
        cloneNode = new Node(node.val);
        nodeMap.put(cloneNode.val, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
