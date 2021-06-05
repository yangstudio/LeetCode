package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */

public class PostorderTraversal {
    /**
     * 方法1：递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       postorder(list,root);
       return list;
    }
    private void postorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        postorder(list,root.left);
        postorder(list,root.right);
        list.add(root.val);
    }

    /**
     * 方法2：迭代
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //这个思路好理解
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

/*    public List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }*/
}
