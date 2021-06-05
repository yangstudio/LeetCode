package yang;

import java.util.Stack;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int min = Integer.MAX_VALUE, preVal = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            min = Math.min(min,Math.abs(root.val - preVal));
            preVal = root.val;
            root = root.right;
        }
        return min;
    }
}
