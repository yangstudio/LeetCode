package yang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    /**
     * 解法1：递归,经测试，递归的代码执行速度要优于迭代
     * @param root
     * @return list
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list,root);
        return list;
    }
    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return ;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }

    /**
     * 解法2：迭代
     * @param root
     * @return list
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


}
