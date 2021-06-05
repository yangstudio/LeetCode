package yang;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * 方法1：递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

        /**方法2：迭代
     * @param root
     * @return list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return list;
    }


    /**
     * 方法2：迭代
     * @param root
     * @return
     */
/*    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(true) {
            if (node != null) {
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else if (stack.isEmpty()) {
                return list;
            } else {
                node = stack.pop();
            }
        }
    }*/
}

