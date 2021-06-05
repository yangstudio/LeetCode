package yang;

import java.util.Stack;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {
    /**
     * 迭代
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val >= L && root.val <= R) {
                sum += root.val;
            }
            root = root.right;
        }
        return sum;
    }

    /**
     * 递归
     * @param root
     * @param L
     * @param R
     * @return
     */
    //变量和对象是有区别的，如果像【94. 二叉树的中序遍历】那样用两个函数且定义在里面，会一直出错，输出恒定为0
    int sum = 0;
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0;
        rangeSumBST(root.left,L,R);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        rangeSumBST(root.right,L,R);
        return sum;
    }
}
