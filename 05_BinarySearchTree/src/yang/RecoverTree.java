package yang;

import java.util.Stack;

/**
 * 99. 恢复二叉搜索树:想出一个只使用常数空间的解决方案
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class RecoverTree {
    /**
     * 迭代
     * @param root
     */
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, pred = null;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
