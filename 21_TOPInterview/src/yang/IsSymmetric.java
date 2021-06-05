package yang;

import yang.demo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @Author: yangchao
 * @Date: 2021/03/17/9:15
 */
public class IsSymmetric {
    /*递归*/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点为空，或者两个节点中有一个为空，或者两个节点不相等
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
    /*迭代*/
    public boolean isSymmetric2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //用队列保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点的左右子节点放到队列中
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            //从队列中取出两个节点，在比较这两个节点
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //如果两个节点都3为空就继续循环，有一个为空的话就返回false
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //将左节点的左孩子、右节点的右孩子放入队列
            queue.offer(left.left);
            queue.offer(right.right);
            //将左节点的右孩子、右节点的左孩子放入队列
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
