package yang;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/21/18:44
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (root.left == null || root.right == null) return minLeft+minRight+1;
        return Math.min(minLeft,minRight)+1;
    }
}
