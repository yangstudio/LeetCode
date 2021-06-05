package yang;

import yang.demo.TreeNode;

import javax.lang.model.util.Elements;

/**
 * @Description: 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/04/30/8:59
 */

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left,root.right);
    }
    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left,R.right) && recur(L.right, R.right);
    }
}
