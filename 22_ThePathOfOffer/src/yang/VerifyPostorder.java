package yang;

/**
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/05/10/8:23
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        // 1. 递归
        return recur(postorder,0,postorder.length-1);

    }
    private boolean recur(int[] postorder, int i, int j) {
        // 递归方法的终止条件为什么是 i >= j 而不是 i==j呢？什么情况下会触发 i > j？
        //例如当 i = m = j - 1 时，向下递归 recur(i, m - 1) 时 i > j ，本质上就是左子树为空的情况
        if (i >= j) return true;
        int p = i;
        //求出左子树区间
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        //判断右子树区间是否符合要求
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }
}
