package yang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTrees {
    /**
     * 递归
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }

    /**
     * 迭代
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            //如果node1和node2的左子树都不为null，就放到队列中
            //如果node1的左子树为null，就把node2的左子树放到node1的左子树上
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            } else if (node1.left == null) {
                node1.left = node2.left;
            }
            //对于右子树也是一样的
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            } else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return t1;
    }
}
