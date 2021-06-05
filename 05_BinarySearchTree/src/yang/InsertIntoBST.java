package yang;

public class InsertIntoBST {
    /**
     * 迭代
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        TreeNode parent = null;
        while(node != null) {
            parent = node;
            if (node.val > val) {
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                node.val = val;
                return root;
            }
        }
        if (parent.val < val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val == val) return root;
        if (root.val < val) {
            root.right = insertIntoBST1(root.right,val);
        } else {
            root.left = insertIntoBST1(root.left,val);
        }
        return root;
    }
}
