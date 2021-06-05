package yang.MultiwayTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Postorder {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        postorder(list,root);
        return list;
    }
    private void postorder(List<Integer> list, Node root) {
        if (root == null ) return;
        for (Node child : root.children) {
            postorder(list,child);
        }
        list.add(root.val);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }
        return list;
    }
}
