package yang;

import yang.demo.TreeNode;

/**
 * @Description: 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/05/28/8:41
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
}
