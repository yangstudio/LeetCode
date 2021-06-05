package yang;

import yang.demo.TreeNode;

/**
 * @Description: 剑指 Offer 27. 二叉树的镜像
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Author: yangchao
 * @Date: 2021/04/30/8:55
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
