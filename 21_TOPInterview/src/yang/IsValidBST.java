package yang;

import yang.demo.TreeNode;

/**
 * @Description: 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Author: yangchao
 * @Date: 2021/03/18/9:14
 */

/**
 * 递归：中序遍历：判断当前节点是否大于中序遍历的前一个节点，如果不大于，直接返回false，否则继续遍历
 */
public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
          if (root == null) return true;
          //访问左子树
          if (!isValidBST(root.left)) return false;
          //访问根节点
          if (root.val <= pre) return false;
          pre = root.val;
          //访问右子树
        return isValidBST(root.right);
    }
}
