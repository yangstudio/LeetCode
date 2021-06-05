package yang;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.leftmostInorder(root);
    }

    private void leftmostInorder(TreeNode root) {
        while(root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode topmostNode = this.stack.pop();
        if (topmostNode.right != null) {
            this.leftmostInorder(topmostNode.right);
        }
        return topmostNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
