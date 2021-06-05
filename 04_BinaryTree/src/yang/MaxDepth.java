package yang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
    /**
     * 方法1：使用层序遍历迭代
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> curr = new LinkedList<>();
        curr.offer(root);
        while(!curr.isEmpty()) {
            Deque<TreeNode> next = new LinkedList<>();
            while (!curr.isEmpty()) {
                TreeNode node = curr.poll();
                if (node.left != null) {
                    next.offer(node.left);
                }
                if (node.right != null) {
                    next.offer(node.right);
                }
            }
            depth++;
            curr = next;
        }
        return depth;
    }

    /**
     * 方法2：递归
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height1 = maxDepth(root.left);
        int height2 = maxDepth(root.right);
        return Math.max(height1, height2) + 1;
    }
}
