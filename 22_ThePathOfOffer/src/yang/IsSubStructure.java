package yang;

import yang.demo.TreeNode;

/**
 * @Description: 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @Author: yangchao
 * @Date: 2021/04/29/8:27
 */
public class IsSubStructure {
    //怎么递归实现?
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //1. 先序遍历树 A 中的每个节点 nA 对应函数 isSubStructure(A, B)）
        //判断树 AA 中 以 nA为根节点的子树 是否包含树 BB 。（对应函数 recur(A, B)）
        if (B == null || A == null) return false;
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
