package yang.MultiwayTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepth {
    /**
     * 迭代
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while (size-- > 0) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
        }
        return depth;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if (null == root) {
            return 0;
        }
        int result = 1;
        for (Node child : root.children) {
            result = Math.max(result, 1 + maxDepth(child));
        }
        return result;
    }
}
