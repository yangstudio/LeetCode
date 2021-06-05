package yang;

import yang.demo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @Author: yangchao
 * @Date: 2021/03/17/8:33
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            index++;
            if (index == k) return root.val;
            root = root.right;
        }
        return Integer.MIN_VALUE;
    }
}
