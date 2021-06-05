package yang.MultiwayTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Preorder {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        preorder(list,root);
        return list;
    }
    private void preorder(List<Integer> list, Node root) {
        if (root == null) return;
        list.add(root.val);
        if (root.children == null) return;
        for (Node child : root.children) {
            preorder(list,child);
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        if (root.children.isEmpty()) {
            list.add(root.val);
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return list;
    }


}
