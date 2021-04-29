package M133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * BFS
 *
 * @author JwZheng
 * @date 2021/3/23 12:47
 */
public class Solution2 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> nodeMap = new HashMap();

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        nodeMap.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                nodeMap.get(n).neighbors.add(nodeMap.get(neighbor));
            }
        }

        return nodeMap.get(node);
    }
}
