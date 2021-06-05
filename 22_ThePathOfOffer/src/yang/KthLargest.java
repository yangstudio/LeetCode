package yang;

import yang.demo.TreeNode;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @Author: yangchao
 * @Date: 2021/05/27/8:16
 */
public class KthLargest {
    int count = 0, res = 0;
    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node) {
        if (node == null || count == 0) return;
        dfs(node.right);
        if (--count == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}
