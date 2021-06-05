package yang;

import yang.demo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * @Author: yangchao
 * @Date: 2021/05/28/8:27
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
    /**
     * 递归
     */
    public int maxDepthII(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthII(root.left),maxDepthII(root.right))+1;
    }
}
