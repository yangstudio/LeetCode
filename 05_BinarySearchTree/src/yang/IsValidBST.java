package yang;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftValid = true, rightValid = true;

        if (root.left != null) {
            leftValid = isValidBST(root.left) && (root.left.val < root.val);
            TreeNode node  = root.left;
            //左子树最右的节点也要比根节点小
            while(node.right != null) {
                node = node.right;
            }
            leftValid = leftValid && (node.val < root.val);
        }
        if (root.right != null) {
            rightValid = isValidBST(root.right) &&(root.right.val > root.val);
            TreeNode node = root.right;
            while(node.left != null) {
                node = node.left;
            }
            leftValid = leftValid && (node.val > root.val);
        }

        return leftValid && rightValid;
    }
}
