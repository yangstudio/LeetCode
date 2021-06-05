package yang;

import yang.demo.TreeNode;

import java.util.Stack;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/14/13:26
 */
public class Main {

    public void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        System.out.println(node.val);
        dfs(node.right);
    }
}
