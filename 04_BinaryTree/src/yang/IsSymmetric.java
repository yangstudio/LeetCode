package yang;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetric {
    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> elements = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            int currSize = list.size();
            while(currSize-- > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                elements.add(node.left);
                elements.add(node.right);
            }
            if (elements.size() % 2 != 0) return false;

            while(!elements.isEmpty()) {
                if (elements.getFirst() == null && elements.getLast() == null)
                {
                    elements.removeFirst();
                    elements.removeLast();
                } else {
                    if (!elements.isEmpty()) {
                        if (elements.getFirst() != null && elements.getLast() != null) {
                            if (elements.removeFirst().val != elements.removeLast().val){
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
